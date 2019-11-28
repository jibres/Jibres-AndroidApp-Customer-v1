package b4a.example;

import java.util.Locale;

import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class page extends androidx.appcompat.app.AppCompatActivity implements B4AActivity{
	public static page mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.page");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (page).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.page");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.page", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (page) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (page) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return page.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (page) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            page mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (page) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static String _picurl = "";
public static String _videolink = "";
public static boolean _isdowned = false;
public static String _postimg = "";
public static String _soundurl = "";
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _nazarat_lbl = null;
public anywheresoftware.b4a.objects.PanelWrapper _paneldark = null;
public de.amberhome.objects.appcompat.ACToolbarLightWrapper _actoolbarlight1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _img = null;
public anywheresoftware.b4a.objects.PanelWrapper _toolbartemp = null;
public com.hitex_glide.Hitex_Glide _glide = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbltoolbar = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlmatlab = null;
public static int _toptemp = 0;
public static int _titelhaghttemp = 0;
public static boolean _titletemp = false;
public static String _name = "";
public anywheresoftware.b4a.objects.collections.List _map = null;
public static String _firstimg = "";
public anywheresoftware.b4a.objects.PanelWrapper _pnlprb = null;
public anywheresoftware.b4a.objects.ProgressBarWrapper _progressbar1 = null;
public static int _fsize = 0;
public static String _foldername = "";
public static boolean _canshare = false;
public static boolean _firstpicshow = false;
public anywheresoftware.b4a.objects.collections.Map _imglisnks = null;
public static String _comment = "";
public static boolean _downtost = false;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _flot = null;
public anywheresoftware.b4a.objects.LabelWrapper _flot2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _flot3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _flot4 = null;
public anywheresoftware.b4a.objects.MediaPlayerWrapper _mpo = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldown = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblplay = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldur = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblpos = null;
public de.amberhome.objects.appcompat.ACSeekBarWrapper _seekbar = null;
public static boolean _ispus = false;
public anywheresoftware.b4a.objects.collections.Map _downmap = null;
public anywheresoftware.b4a.objects.collections.Map _favmap = null;
public static String _alltext = "";
public b4a.example.heightlabel _hlbl = null;
public b4a.example.main _main = null;
public b4a.example.act_tip _act_tip = null;
public b4a.example.login _login = null;
public b4a.example.verify _verify = null;
public b4a.example.home _home = null;
public b4a.example.c _c = null;
public b4a.example.starter _starter = null;
public b4a.example.finger _finger = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.phone.Phone _sdk = null;
de.amberhome.objects.appcompat.AppCompatBase _a = null;
anywheresoftware.b4a.objects.drawable.GradientDrawable _gradient1 = null;
int[] _clrs = null;
anywheresoftware.b4a.object.XmlLayoutBuilder _xml = null;
anywheresoftware.b4a.objects.ImageViewWrapper _imgtemp = null;
anywheresoftware.b4a.agraham.richstring.RichStringBuilder.RichString _ri = null;
RDebugUtils.currentLine=4849664;
 //BA.debugLineNum = 4849664;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=4849665;
 //BA.debugLineNum = 4849665;BA.debugLine="If File.Exists(File.DirInternal,\"fsize\") = False";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"fsize")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=4849666;
 //BA.debugLineNum = 4849666;BA.debugLine="File.WriteString(File.DirInternal,\"fsize\",\"14\")";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"fsize","14");
RDebugUtils.currentLine=4849667;
 //BA.debugLineNum = 4849667;BA.debugLine="fsize=14";
_fsize = (int) (14);
 }else {
RDebugUtils.currentLine=4849669;
 //BA.debugLineNum = 4849669;BA.debugLine="fsize=File.ReadString(File.DirInternal,\"fsize\")";
_fsize = (int)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"fsize")));
 };
RDebugUtils.currentLine=4849672;
 //BA.debugLineNum = 4849672;BA.debugLine="isdowned=False";
_isdowned = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=4849673;
 //BA.debugLineNum = 4849673;BA.debugLine="videolink=\"\"";
_videolink = "";
RDebugUtils.currentLine=4849675;
 //BA.debugLineNum = 4849675;BA.debugLine="Activity.LoadLayout(\"matlab1\")";
mostCurrent._activity.LoadLayout("matlab1",mostCurrent.activityBA);
RDebugUtils.currentLine=4849678;
 //BA.debugLineNum = 4849678;BA.debugLine="ScrollView1.Panel.LoadLayout(\"matlab2\")";
mostCurrent._scrollview1.getPanel().LoadLayout("matlab2",mostCurrent.activityBA);
RDebugUtils.currentLine=4849680;
 //BA.debugLineNum = 4849680;BA.debugLine="Dim sdk As Phone";
_sdk = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=4849682;
 //BA.debugLineNum = 4849682;BA.debugLine="If sdk.SdkVersion >=19 Then";
if (_sdk.getSdkVersion()>=19) { 
RDebugUtils.currentLine=4849683;
 //BA.debugLineNum = 4849683;BA.debugLine="Dim a As AppCompat";
_a = new de.amberhome.objects.appcompat.AppCompatBase();
RDebugUtils.currentLine=4849684;
 //BA.debugLineNum = 4849684;BA.debugLine="ACToolBarLight1.Top=a.GetStatusBarHeight";
mostCurrent._actoolbarlight1.setTop(_a.GetStatusBarHeight(mostCurrent.activityBA));
RDebugUtils.currentLine=4849685;
 //BA.debugLineNum = 4849685;BA.debugLine="toolbartemp.Height=a.GetStatusBarHeight";
mostCurrent._toolbartemp.setHeight(_a.GetStatusBarHeight(mostCurrent.activityBA));
RDebugUtils.currentLine=4849686;
 //BA.debugLineNum = 4849686;BA.debugLine="toolbartemp.Top=0";
mostCurrent._toolbartemp.setTop((int) (0));
RDebugUtils.currentLine=4849687;
 //BA.debugLineNum = 4849687;BA.debugLine="toolbartemp.Color=Colors.ARGB(100,0,39,0)";
mostCurrent._toolbartemp.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (100),(int) (0),(int) (39),(int) (0)));
 };
RDebugUtils.currentLine=4849691;
 //BA.debugLineNum = 4849691;BA.debugLine="Dim Gradient1 As GradientDrawable";
_gradient1 = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=4849692;
 //BA.debugLineNum = 4849692;BA.debugLine="Dim Clrs(2) As Int";
_clrs = new int[(int) (2)];
;
RDebugUtils.currentLine=4849693;
 //BA.debugLineNum = 4849693;BA.debugLine="Clrs(0) =Colors.ARGB(100,0,39,0)";
_clrs[(int) (0)] = anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (100),(int) (0),(int) (39),(int) (0));
RDebugUtils.currentLine=4849694;
 //BA.debugLineNum = 4849694;BA.debugLine="Clrs(1) = Colors.Transparent";
_clrs[(int) (1)] = anywheresoftware.b4a.keywords.Common.Colors.Transparent;
RDebugUtils.currentLine=4849695;
 //BA.debugLineNum = 4849695;BA.debugLine="Gradient1.Initialize(\"TOP_BOTTOM\", Clrs)";
_gradient1.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clrs);
RDebugUtils.currentLine=4849697;
 //BA.debugLineNum = 4849697;BA.debugLine="ACToolBarLight1.Background=Gradient1";
mostCurrent._actoolbarlight1.setBackground((android.graphics.drawable.Drawable)(_gradient1.getObject()));
RDebugUtils.currentLine=4849698;
 //BA.debugLineNum = 4849698;BA.debugLine="ACToolBarLight1.Elevation=5dip";
mostCurrent._actoolbarlight1.setElevation((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))));
RDebugUtils.currentLine=4849699;
 //BA.debugLineNum = 4849699;BA.debugLine="Dim xml As XmlLayoutBuilder";
_xml = new anywheresoftware.b4a.object.XmlLayoutBuilder();
RDebugUtils.currentLine=4849700;
 //BA.debugLineNum = 4849700;BA.debugLine="ACToolBarLight1.NavigationIconDrawable=xml.GetDra";
mostCurrent._actoolbarlight1.setNavigationIconDrawable(_xml.GetDrawable("baseline_arrow_forward_white_24"));
RDebugUtils.currentLine=4849701;
 //BA.debugLineNum = 4849701;BA.debugLine="ACToolBarLight1.InitMenuListener";
mostCurrent._actoolbarlight1.InitMenuListener();
RDebugUtils.currentLine=4849702;
 //BA.debugLineNum = 4849702;BA.debugLine="ACToolBarLight1.TitleTextColor=Colors.Transparent";
mostCurrent._actoolbarlight1.setTitleTextColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=4849703;
 //BA.debugLineNum = 4849703;BA.debugLine="ACToolBarLight1.Title=Main.txtnewstitle";
mostCurrent._actoolbarlight1.setTitle(BA.ObjectToCharSequence(mostCurrent._main._txtnewstitle /*String*/ ));
RDebugUtils.currentLine=4849706;
 //BA.debugLineNum = 4849706;BA.debugLine="add2toolbar_sub";
_add2toolbar_sub();
RDebugUtils.currentLine=4849708;
 //BA.debugLineNum = 4849708;BA.debugLine="Img.Tag=Null";
mostCurrent._img.setTag(anywheresoftware.b4a.keywords.Common.Null);
RDebugUtils.currentLine=4849709;
 //BA.debugLineNum = 4849709;BA.debugLine="Img.Height=Img.Height+1%x";
mostCurrent._img.setHeight((int) (mostCurrent._img.getHeight()+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA)));
RDebugUtils.currentLine=4849710;
 //BA.debugLineNum = 4849710;BA.debugLine="firstimg=\"\"'Main.matlabimg313";
mostCurrent._firstimg = "";
RDebugUtils.currentLine=4849712;
 //BA.debugLineNum = 4849712;BA.debugLine="Img.Color=Colors.Transparent";
mostCurrent._img.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=4849715;
 //BA.debugLineNum = 4849715;BA.debugLine="Glide.Load(\"http\",Main.picnew).CenterCrop.Into(Im";
mostCurrent._glide.Load(mostCurrent.activityBA,"http",mostCurrent._main._picnew /*String*/ ).CenterCrop().Into(mostCurrent._img);
RDebugUtils.currentLine=4849718;
 //BA.debugLineNum = 4849718;BA.debugLine="Dim imgtemp As ImageView";
_imgtemp = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=4849719;
 //BA.debugLineNum = 4849719;BA.debugLine="imgtemp.Initialize(\"img\")";
_imgtemp.Initialize(mostCurrent.activityBA,"img");
RDebugUtils.currentLine=4849720;
 //BA.debugLineNum = 4849720;BA.debugLine="ScrollView1.Panel.AddView(imgtemp,0,0,100%x,Img.H";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_imgtemp.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),(int) (mostCurrent._img.getHeight()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA)));
RDebugUtils.currentLine=4849723;
 //BA.debugLineNum = 4849723;BA.debugLine="imglisnks.Initialize";
mostCurrent._imglisnks.Initialize();
RDebugUtils.currentLine=4849726;
 //BA.debugLineNum = 4849726;BA.debugLine="addtitle_sub(Main.txtnewstitle,\"\")";
_addtitle_sub(mostCurrent._main._txtnewstitle /*String*/ ,"");
RDebugUtils.currentLine=4849735;
 //BA.debugLineNum = 4849735;BA.debugLine="Disable_ScroolbarH(ScrollView1)";
_disable_scroolbarh(mostCurrent._scrollview1);
RDebugUtils.currentLine=4849736;
 //BA.debugLineNum = 4849736;BA.debugLine="Force_LtrSupported4View(ProgressBar1)";
_force_ltrsupported4view((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._progressbar1.getObject())));
RDebugUtils.currentLine=4849739;
 //BA.debugLineNum = 4849739;BA.debugLine="set_Ripple(flot2)";
_set_ripple(mostCurrent._flot2);
RDebugUtils.currentLine=4849740;
 //BA.debugLineNum = 4849740;BA.debugLine="set_Ripple(flot4)";
_set_ripple(mostCurrent._flot4);
RDebugUtils.currentLine=4849741;
 //BA.debugLineNum = 4849741;BA.debugLine="flot4.Visible=False";
mostCurrent._flot4.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4849742;
 //BA.debugLineNum = 4849742;BA.debugLine="flot3.Visible=False";
mostCurrent._flot3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4849743;
 //BA.debugLineNum = 4849743;BA.debugLine="Dim ri As RichString";
_ri = new anywheresoftware.b4a.agraham.richstring.RichStringBuilder.RichString();
RDebugUtils.currentLine=4849744;
 //BA.debugLineNum = 4849744;BA.debugLine="ri.Initialize(Label2.Text)";
_ri.Initialize(BA.ObjectToCharSequence(mostCurrent._label2.getText()));
RDebugUtils.currentLine=4849745;
 //BA.debugLineNum = 4849745;BA.debugLine="Label2.Text=ri.Color(0xFFBE1043,39,45)";
mostCurrent._label2.setText(BA.ObjectToCharSequence(_ri.Color((int) (0xffbe1043),(int) (39),(int) (45)).getObject()));
RDebugUtils.currentLine=4849748;
 //BA.debugLineNum = 4849748;BA.debugLine="bring_Up(flot3)";
_bring_up((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._flot3.getObject())));
RDebugUtils.currentLine=4849754;
 //BA.debugLineNum = 4849754;BA.debugLine="flot.Visible=False";
mostCurrent._flot.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4849755;
 //BA.debugLineNum = 4849755;BA.debugLine="flot2.Visible=False";
mostCurrent._flot2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4849756;
 //BA.debugLineNum = 4849756;BA.debugLine="flot3.Visible=False";
mostCurrent._flot3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4849757;
 //BA.debugLineNum = 4849757;BA.debugLine="flot4.Visible=False";
mostCurrent._flot4.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4849759;
 //BA.debugLineNum = 4849759;BA.debugLine="c.Force_RtlSupported4View(ACToolBarLight1)";
mostCurrent._c._force_rtlsupported4view /*String*/ (mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._actoolbarlight1.getObject())));
RDebugUtils.currentLine=4849760;
 //BA.debugLineNum = 4849760;BA.debugLine="End Sub";
return "";
}
public static String  _add2toolbar_sub() throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add2toolbar_sub", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add2toolbar_sub", null));}
anywheresoftware.b4a.object.XmlLayoutBuilder _xml = null;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _bh = null;
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Sub add2toolbar_sub";
RDebugUtils.currentLine=5963777;
 //BA.debugLineNum = 5963777;BA.debugLine="Dim xml As XmlLayoutBuilder";
_xml = new anywheresoftware.b4a.object.XmlLayoutBuilder();
RDebugUtils.currentLine=5963780;
 //BA.debugLineNum = 5963780;BA.debugLine="Dim bh = xml.GetDrawable(\"baseline_share_white_24";
_bh = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
_bh.setObject((android.graphics.drawable.BitmapDrawable)(_xml.GetDrawable("baseline_share_white_24")));
RDebugUtils.currentLine=5963781;
 //BA.debugLineNum = 5963781;BA.debugLine="Activity.AddMenuItem3(menu_Change(\"اشتراک گذاری\",";
mostCurrent._activity.AddMenuItem3(BA.ObjectToCharSequence(_menu_change("اشتراک گذاری",anywheresoftware.b4a.keywords.Common.Colors.Black,mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ ).getObject()),"share",_bh.getBitmap(),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5963789;
 //BA.debugLineNum = 5963789;BA.debugLine="End Sub";
return "";
}
public static String  _addtitle_sub(String _title,String _matn) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addtitle_sub", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addtitle_sub", new Object[] {_title,_matn}));}
anywheresoftware.b4a.objects.LabelWrapper _lable = null;
wir.hitex.recycler.Hitex_Utils _h = null;
RDebugUtils.currentLine=5570560;
 //BA.debugLineNum = 5570560;BA.debugLine="Sub addtitle_sub(title As String , matn As String)";
RDebugUtils.currentLine=5570561;
 //BA.debugLineNum = 5570561;BA.debugLine="If titletemp=False Then";
if (_titletemp==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=5570562;
 //BA.debugLineNum = 5570562;BA.debugLine="Dim lable As Label";
_lable = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5570563;
 //BA.debugLineNum = 5570563;BA.debugLine="lable.Initialize(\"\")";
_lable.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5570564;
 //BA.debugLineNum = 5570564;BA.debugLine="lable.Text=title";
_lable.setText(BA.ObjectToCharSequence(_title));
RDebugUtils.currentLine=5570565;
 //BA.debugLineNum = 5570565;BA.debugLine="lable.Typeface=Typeface.CreateNew(C.irs, Typefac";
_lable.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.CreateNew((android.graphics.Typeface)(mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ .getObject()),anywheresoftware.b4a.keywords.Common.Typeface.STYLE_BOLD));
RDebugUtils.currentLine=5570566;
 //BA.debugLineNum = 5570566;BA.debugLine="lable.Color=Colors.White'.ARGB(255,245,229,231)";
_lable.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=5570567;
 //BA.debugLineNum = 5570567;BA.debugLine="lable.TextColor=Colors.ARGB(255,4,0,153)";
_lable.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (4),(int) (0),(int) (153)));
RDebugUtils.currentLine=5570568;
 //BA.debugLineNum = 5570568;BA.debugLine="lable.Padding=Array As Int (20dip,0,20dip,0)";
_lable.setPadding(new int[]{anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),(int) (0)});
RDebugUtils.currentLine=5570570;
 //BA.debugLineNum = 5570570;BA.debugLine="lable.TextSize=23";
_lable.setTextSize((float) (23));
RDebugUtils.currentLine=5570571;
 //BA.debugLineNum = 5570571;BA.debugLine="lable.Gravity= Gravity.RIGHT";
_lable.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT);
RDebugUtils.currentLine=5570573;
 //BA.debugLineNum = 5570573;BA.debugLine="ScrollView1.Panel.AddView(lable,2%x,toptemp,96%x";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lable.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
RDebugUtils.currentLine=5570574;
 //BA.debugLineNum = 5570574;BA.debugLine="Dim h As Hitex_Utils";
_h = new wir.hitex.recycler.Hitex_Utils();
RDebugUtils.currentLine=5570575;
 //BA.debugLineNum = 5570575;BA.debugLine="lable.Height=h.GetTextHeight(lable)'hlbl.LabelHe";
_lable.setHeight((int) (_h.GetTextHeight(_lable)));
RDebugUtils.currentLine=5570576;
 //BA.debugLineNum = 5570576;BA.debugLine="lable.Height=lable.Height";
_lable.setHeight(_lable.getHeight());
RDebugUtils.currentLine=5570577;
 //BA.debugLineNum = 5570577;BA.debugLine="toptemp=toptemp+lable.Height";
_toptemp = (int) (_toptemp+_lable.getHeight());
RDebugUtils.currentLine=5570578;
 //BA.debugLineNum = 5570578;BA.debugLine="titletemp=True";
_titletemp = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=5570579;
 //BA.debugLineNum = 5570579;BA.debugLine="titelhaghttemp=lable.Height";
_titelhaghttemp = _lable.getHeight();
RDebugUtils.currentLine=5570581;
 //BA.debugLineNum = 5570581;BA.debugLine="Dim lable As Label";
_lable = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5570582;
 //BA.debugLineNum = 5570582;BA.debugLine="lable.Initialize(\"\")";
_lable.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5570583;
 //BA.debugLineNum = 5570583;BA.debugLine="lable.Text=Chr(0xE916)";
_lable.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe916))));
RDebugUtils.currentLine=5570584;
 //BA.debugLineNum = 5570584;BA.debugLine="lable.Typeface=Typeface.MATERIALICONS";
_lable.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
RDebugUtils.currentLine=5570585;
 //BA.debugLineNum = 5570585;BA.debugLine="lable.TextColor=0x8B000690";
_lable.setTextColor((int) (0x8b000690));
RDebugUtils.currentLine=5570586;
 //BA.debugLineNum = 5570586;BA.debugLine="lable.Padding=Array As Int (20dip,0,20dip,0)";
_lable.setPadding(new int[]{anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),(int) (0)});
RDebugUtils.currentLine=5570587;
 //BA.debugLineNum = 5570587;BA.debugLine="ScrollView1.Panel.AddView(lable,2%x,toptemp,96%x";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lable.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=5570588;
 //BA.debugLineNum = 5570588;BA.debugLine="lable.Gravity= Bit.Or(Gravity.RIGHT,Gravity.CENT";
_lable.setGravity(anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT,anywheresoftware.b4a.keywords.Common.Gravity.CENTER));
RDebugUtils.currentLine=5570591;
 //BA.debugLineNum = 5570591;BA.debugLine="Dim lable As Label";
_lable = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5570592;
 //BA.debugLineNum = 5570592;BA.debugLine="lable.Initialize(\"\")";
_lable.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5570593;
 //BA.debugLineNum = 5570593;BA.debugLine="lable.Text=saato_ina(Main.newsdate)";
_lable.setText(BA.ObjectToCharSequence(_saato_ina(mostCurrent._main._newsdate /*String*/ )));
RDebugUtils.currentLine=5570594;
 //BA.debugLineNum = 5570594;BA.debugLine="lable.Typeface=C.irs";
_lable.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ .getObject()));
RDebugUtils.currentLine=5570595;
 //BA.debugLineNum = 5570595;BA.debugLine="lable.TextColor=0x8B000690";
_lable.setTextColor((int) (0x8b000690));
RDebugUtils.currentLine=5570596;
 //BA.debugLineNum = 5570596;BA.debugLine="lable.Padding=Array As Int (20dip,0,40dip,0)";
_lable.setPadding(new int[]{anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),(int) (0)});
RDebugUtils.currentLine=5570597;
 //BA.debugLineNum = 5570597;BA.debugLine="ScrollView1.Panel.AddView(lable,2%x,toptemp,96%x";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lable.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=5570598;
 //BA.debugLineNum = 5570598;BA.debugLine="lable.Gravity= Bit.Or(Gravity.RIGHT,Gravity.CENT";
_lable.setGravity(anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT,anywheresoftware.b4a.keywords.Common.Gravity.CENTER));
RDebugUtils.currentLine=5570599;
 //BA.debugLineNum = 5570599;BA.debugLine="toptemp=toptemp+10%x";
_toptemp = (int) (_toptemp+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA));
 };
RDebugUtils.currentLine=5570601;
 //BA.debugLineNum = 5570601;BA.debugLine="End Sub";
return "";
}
public static String  _disable_scroolbarh(anywheresoftware.b4a.objects.ScrollViewWrapper _sv1) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "disable_scroolbarh", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "disable_scroolbarh", new Object[] {_sv1}));}
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
RDebugUtils.currentLine=5177344;
 //BA.debugLineNum = 5177344;BA.debugLine="Sub Disable_ScroolbarH(sv1 As ScrollView)";
RDebugUtils.currentLine=5177345;
 //BA.debugLineNum = 5177345;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=5177346;
 //BA.debugLineNum = 5177346;BA.debugLine="r.Target = sv1";
_r.Target = (Object)(_sv1.getObject());
RDebugUtils.currentLine=5177347;
 //BA.debugLineNum = 5177347;BA.debugLine="r.RunMethod2(\"setVerticalScrollBarEnabled\", False";
_r.RunMethod2("setVerticalScrollBarEnabled",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.False),"java.lang.boolean");
RDebugUtils.currentLine=5177348;
 //BA.debugLineNum = 5177348;BA.debugLine="End Sub";
return "";
}
public static String  _force_ltrsupported4view(anywheresoftware.b4a.objects.ConcreteViewWrapper _view) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "force_ltrsupported4view", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "force_ltrsupported4view", new Object[] {_view}));}
anywheresoftware.b4j.object.JavaObject _ja = null;
anywheresoftware.b4j.object.JavaObject _jos = null;
RDebugUtils.currentLine=6553600;
 //BA.debugLineNum = 6553600;BA.debugLine="Sub Force_LtrSupported4View(View As View)";
RDebugUtils.currentLine=6553601;
 //BA.debugLineNum = 6553601;BA.debugLine="Dim jA,jos As JavaObject";
_ja = new anywheresoftware.b4j.object.JavaObject();
_jos = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=6553602;
 //BA.debugLineNum = 6553602;BA.debugLine="jos.InitializeStatic  (\"android.view.View\")";
_jos.InitializeStatic("android.view.View");
RDebugUtils.currentLine=6553603;
 //BA.debugLineNum = 6553603;BA.debugLine="If jA.InitializeStatic  (\"android.os.Build$VERSIO";
if ((double)(BA.ObjectToNumber(_ja.InitializeStatic("android.os.Build$VERSION").GetField("SDK_INT")))>16) { 
RDebugUtils.currentLine=6553604;
 //BA.debugLineNum = 6553604;BA.debugLine="jA = View";
_ja.setObject((java.lang.Object)(_view.getObject()));
RDebugUtils.currentLine=6553605;
 //BA.debugLineNum = 6553605;BA.debugLine="jA.RunMethod (\"setLayoutDirection\",Array(jos.Get";
_ja.RunMethod("setLayoutDirection",new Object[]{_jos.GetField("LAYOUT_DIRECTION_LTR")});
 };
RDebugUtils.currentLine=6553607;
 //BA.debugLineNum = 6553607;BA.debugLine="End Sub";
return "";
}
public static String  _set_ripple(anywheresoftware.b4a.objects.LabelWrapper _label) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "set_ripple", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "set_ripple", new Object[] {_label}));}
anywheresoftware.b4a.phone.Phone _phone1 = null;
anywheresoftware.b4j.object.JavaObject _imageviewjo = null;
anywheresoftware.b4j.object.JavaObject _colorstate = null;
anywheresoftware.b4j.object.JavaObject _rippledrawable = null;
RDebugUtils.currentLine=4915200;
 //BA.debugLineNum = 4915200;BA.debugLine="Sub set_Ripple(label As Label)";
RDebugUtils.currentLine=4915201;
 //BA.debugLineNum = 4915201;BA.debugLine="Dim phone1 As Phone";
_phone1 = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=4915202;
 //BA.debugLineNum = 4915202;BA.debugLine="If phone1.SdkVersion<21 Then";
if (_phone1.getSdkVersion()<21) { 
 }else {
RDebugUtils.currentLine=4915204;
 //BA.debugLineNum = 4915204;BA.debugLine="Dim ImageViewJo As JavaObject = label";
_imageviewjo = new anywheresoftware.b4j.object.JavaObject();
_imageviewjo.setObject((java.lang.Object)(_label.getObject()));
RDebugUtils.currentLine=4915205;
 //BA.debugLineNum = 4915205;BA.debugLine="Dim ColorState As JavaObject";
_colorstate = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=4915206;
 //BA.debugLineNum = 4915206;BA.debugLine="ColorState.InitializeStatic(\"android.content.res";
_colorstate.InitializeStatic("android.content.res.ColorStateList");
RDebugUtils.currentLine=4915207;
 //BA.debugLineNum = 4915207;BA.debugLine="Dim RippleDrawable As JavaObject";
_rippledrawable = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=4915208;
 //BA.debugLineNum = 4915208;BA.debugLine="RippleDrawable.InitializeNewInstance(\"android.gr";
_rippledrawable.InitializeNewInstance("android.graphics.drawable.RippleDrawable",new Object[]{_colorstate.RunMethod("valueOf",new Object[]{(Object)(0x78000000)}),anywheresoftware.b4a.keywords.Common.Null,anywheresoftware.b4a.keywords.Common.Null});
RDebugUtils.currentLine=4915209;
 //BA.debugLineNum = 4915209;BA.debugLine="ImageViewJo.RunMethod(\"setBackground\",Array(Ripp";
_imageviewjo.RunMethod("setBackground",new Object[]{(Object)(_rippledrawable.getObject())});
 };
RDebugUtils.currentLine=4915211;
 //BA.debugLineNum = 4915211;BA.debugLine="End Sub";
return "";
}
public static String  _bring_up(anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "bring_up", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "bring_up", new Object[] {_v}));}
anywheresoftware.b4a.phone.Phone _phone1 = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
float _elevation = 0f;
RDebugUtils.currentLine=4980736;
 //BA.debugLineNum = 4980736;BA.debugLine="Sub bring_Up(v As View)";
RDebugUtils.currentLine=4980737;
 //BA.debugLineNum = 4980737;BA.debugLine="Dim phone1 As Phone";
_phone1 = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=4980738;
 //BA.debugLineNum = 4980738;BA.debugLine="If phone1.SdkVersion>20 Then";
if (_phone1.getSdkVersion()>20) { 
RDebugUtils.currentLine=4980739;
 //BA.debugLineNum = 4980739;BA.debugLine="Dim jo As JavaObject = v";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_v.getObject()));
RDebugUtils.currentLine=4980740;
 //BA.debugLineNum = 4980740;BA.debugLine="Dim elevation As Float = 8dip";
_elevation = (float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (8)));
RDebugUtils.currentLine=4980741;
 //BA.debugLineNum = 4980741;BA.debugLine="jo.RunMethod(\"setElevation\",Array(elevation))";
_jo.RunMethod("setElevation",new Object[]{(Object)(_elevation)});
 }else {
RDebugUtils.currentLine=4980743;
 //BA.debugLineNum = 4980743;BA.debugLine="v.BringToFront";
_v.BringToFront();
 };
RDebugUtils.currentLine=4980745;
 //BA.debugLineNum = 4980745;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="page";
RDebugUtils.currentLine=5701632;
 //BA.debugLineNum = 5701632;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=5701634;
 //BA.debugLineNum = 5701634;BA.debugLine="Try";
try {RDebugUtils.currentLine=5701636;
 //BA.debugLineNum = 5701636;BA.debugLine="ispus=False";
_ispus = anywheresoftware.b4a.keywords.Common.False;
 } 
       catch (Exception e4) {
			processBA.setLastException(e4); };
RDebugUtils.currentLine=5701640;
 //BA.debugLineNum = 5701640;BA.debugLine="Try";
try {RDebugUtils.currentLine=5701641;
 //BA.debugLineNum = 5701641;BA.debugLine="mpo.Release";
mostCurrent._mpo.Release();
 } 
       catch (Exception e8) {
			processBA.setLastException(e8); };
RDebugUtils.currentLine=5701645;
 //BA.debugLineNum = 5701645;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=5242880;
 //BA.debugLineNum = 5242880;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=5242882;
 //BA.debugLineNum = 5242882;BA.debugLine="End Sub";
return "";
}
public static String  _actoolbarlight1_navigationitemclick() throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "actoolbarlight1_navigationitemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "actoolbarlight1_navigationitemclick", null));}
RDebugUtils.currentLine=4784128;
 //BA.debugLineNum = 4784128;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
RDebugUtils.currentLine=4784129;
 //BA.debugLineNum = 4784129;BA.debugLine="StartActivity(finger)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._finger.getObject()));
RDebugUtils.currentLine=4784131;
 //BA.debugLineNum = 4784131;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.CSBuilder  _menu_change(String _onvan,int _color,anywheresoftware.b4a.keywords.constants.TypefaceWrapper _font) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "menu_change", false))
	 {return ((anywheresoftware.b4a.objects.CSBuilder) Debug.delegate(mostCurrent.activityBA, "menu_change", new Object[] {_onvan,_color,_font}));}
anywheresoftware.b4a.objects.CSBuilder _cs = null;
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Sub menu_Change(onvan As String,color As Int,font";
RDebugUtils.currentLine=5898241;
 //BA.debugLineNum = 5898241;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
RDebugUtils.currentLine=5898242;
 //BA.debugLineNum = 5898242;BA.debugLine="cs.Initialize.Color(color).Typeface(font).Append(";
_cs.Initialize().Color(_color).Typeface((android.graphics.Typeface)(_font.getObject())).Append(BA.ObjectToCharSequence(_onvan)).PopAll();
RDebugUtils.currentLine=5898243;
 //BA.debugLineNum = 5898243;BA.debugLine="Return cs";
if (true) return _cs;
RDebugUtils.currentLine=5898244;
 //BA.debugLineNum = 5898244;BA.debugLine="End Sub";
return null;
}
public static String  _saato_ina(String _h13) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "saato_ina", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "saato_ina", new Object[] {_h13}));}
String _lbl2 = "";
String _date = "";
int _month = 0;
int _day = 0;
int _year = 0;
int _saat = 0;
String _minu = "";
int _minu2 = 0;
ir.anamsoftware.persiandateultimate.ManamPDUltimate _manam = null;
wir.hitex.recycler.Hitex_Utils _utils = null;
RDebugUtils.currentLine=5373952;
 //BA.debugLineNum = 5373952;BA.debugLine="Sub saato_ina(h13 As String) As String";
RDebugUtils.currentLine=5373953;
 //BA.debugLineNum = 5373953;BA.debugLine="Dim lbl2 As String";
_lbl2 = "";
RDebugUtils.currentLine=5373954;
 //BA.debugLineNum = 5373954;BA.debugLine="Dim date As String = h13.SubString2(9,19)";
_date = _h13.substring((int) (9),(int) (19));
RDebugUtils.currentLine=5373955;
 //BA.debugLineNum = 5373955;BA.debugLine="Dim month As Int = h13.SubString2(12,14)";
_month = (int)(Double.parseDouble(_h13.substring((int) (12),(int) (14))));
RDebugUtils.currentLine=5373956;
 //BA.debugLineNum = 5373956;BA.debugLine="Dim day As Int = h13.SubString2(9,11)";
_day = (int)(Double.parseDouble(_h13.substring((int) (9),(int) (11))));
RDebugUtils.currentLine=5373957;
 //BA.debugLineNum = 5373957;BA.debugLine="Dim year As Int = h13.SubString2(15,19)";
_year = (int)(Double.parseDouble(_h13.substring((int) (15),(int) (19))));
RDebugUtils.currentLine=5373958;
 //BA.debugLineNum = 5373958;BA.debugLine="Dim saat As Int = h13.SubString2(0,2)";
_saat = (int)(Double.parseDouble(_h13.substring((int) (0),(int) (2))));
RDebugUtils.currentLine=5373959;
 //BA.debugLineNum = 5373959;BA.debugLine="Dim minu As String = h13.SubString2(3,5)";
_minu = _h13.substring((int) (3),(int) (5));
RDebugUtils.currentLine=5373960;
 //BA.debugLineNum = 5373960;BA.debugLine="Dim minu2 As Int = h13.SubString2(3,5)";
_minu2 = (int)(Double.parseDouble(_h13.substring((int) (3),(int) (5))));
RDebugUtils.currentLine=5373961;
 //BA.debugLineNum = 5373961;BA.debugLine="Log(saat)";
anywheresoftware.b4a.keywords.Common.LogImpl("35373961",BA.NumberToString(_saat),0);
RDebugUtils.currentLine=5373962;
 //BA.debugLineNum = 5373962;BA.debugLine="Log(minu)";
anywheresoftware.b4a.keywords.Common.LogImpl("35373962",_minu,0);
RDebugUtils.currentLine=5373964;
 //BA.debugLineNum = 5373964;BA.debugLine="lbl2=date.Replace(\"-\",\"/\") & \" در \"& saat&\":\"&min";
_lbl2 = _date.replace("-","/")+" در "+BA.NumberToString(_saat)+":"+_minu;
RDebugUtils.currentLine=5373965;
 //BA.debugLineNum = 5373965;BA.debugLine="Dim manam As ManamPerianDateUltimate";
_manam = new ir.anamsoftware.persiandateultimate.ManamPDUltimate();
RDebugUtils.currentLine=5373966;
 //BA.debugLineNum = 5373966;BA.debugLine="If year=manam.PersianYear Then";
if (_year==_manam.getPersianYear()) { 
RDebugUtils.currentLine=5373967;
 //BA.debugLineNum = 5373967;BA.debugLine="If month=manam.PersianMonth Then";
if (_month==_manam.getPersianMonth()) { 
RDebugUtils.currentLine=5373968;
 //BA.debugLineNum = 5373968;BA.debugLine="If day=(manam.PersianDay)-1 Then";
if (_day==(_manam.getPersianDay())-1) { 
RDebugUtils.currentLine=5373969;
 //BA.debugLineNum = 5373969;BA.debugLine="lbl2=\"دیروز در \"& saat&\":\"&minu";
_lbl2 = "دیروز در "+BA.NumberToString(_saat)+":"+_minu;
 };
RDebugUtils.currentLine=5373971;
 //BA.debugLineNum = 5373971;BA.debugLine="If day<(manam.PersianDay)-1 Then";
if (_day<(_manam.getPersianDay())-1) { 
RDebugUtils.currentLine=5373972;
 //BA.debugLineNum = 5373972;BA.debugLine="lbl2=((manam.PersianDay)-day)&\" روز پیش در \"&";
_lbl2 = BA.NumberToString(((_manam.getPersianDay())-_day))+" روز پیش در "+BA.NumberToString(_saat)+":"+_minu;
 };
RDebugUtils.currentLine=5373974;
 //BA.debugLineNum = 5373974;BA.debugLine="If day=(manam.PersianDay) Then";
if (_day==(_manam.getPersianDay())) { 
RDebugUtils.currentLine=5373975;
 //BA.debugLineNum = 5373975;BA.debugLine="If saat<(DateTime.GetHour(DateTime.Now)) Then";
if (_saat<(anywheresoftware.b4a.keywords.Common.DateTime.GetHour(anywheresoftware.b4a.keywords.Common.DateTime.getNow()))) { 
RDebugUtils.currentLine=5373976;
 //BA.debugLineNum = 5373976;BA.debugLine="lbl2=((DateTime.GetHour(DateTime.Now))-saat)";
_lbl2 = BA.NumberToString(((anywheresoftware.b4a.keywords.Common.DateTime.GetHour(anywheresoftware.b4a.keywords.Common.DateTime.getNow()))-_saat))+" ساعت پیش";
 }else {
RDebugUtils.currentLine=5373979;
 //BA.debugLineNum = 5373979;BA.debugLine="If minu2<(DateTime.GetMinute(DateTime.Now)) T";
if (_minu2<(anywheresoftware.b4a.keywords.Common.DateTime.GetMinute(anywheresoftware.b4a.keywords.Common.DateTime.getNow()))) { 
RDebugUtils.currentLine=5373980;
 //BA.debugLineNum = 5373980;BA.debugLine="lbl2=((DateTime.GetMinute(DateTime.Now))-min";
_lbl2 = BA.NumberToString(((anywheresoftware.b4a.keywords.Common.DateTime.GetMinute(anywheresoftware.b4a.keywords.Common.DateTime.getNow()))-_minu2))+" دقیقه پیش";
 }else {
RDebugUtils.currentLine=5373982;
 //BA.debugLineNum = 5373982;BA.debugLine="lbl2=\"همین حالا\"";
_lbl2 = "همین حالا";
 };
 };
 };
 };
 };
RDebugUtils.currentLine=5373988;
 //BA.debugLineNum = 5373988;BA.debugLine="Dim utils As Hitex_Utils";
_utils = new wir.hitex.recycler.Hitex_Utils();
RDebugUtils.currentLine=5373989;
 //BA.debugLineNum = 5373989;BA.debugLine="Return utils.EnToFa(lbl2)";
if (true) return _utils.EnToFa(_lbl2);
RDebugUtils.currentLine=5373990;
 //BA.debugLineNum = 5373990;BA.debugLine="End Sub";
return "";
}
public static String  _addviewtosv_sub() throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addviewtosv_sub", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addviewtosv_sub", null));}
int _o = 0;
String[] _h13 = null;
String _typee = "";
String _url = "";
anywheresoftware.b4a.objects.ImageViewWrapper _img1 = null;
anywheresoftware.b4a.objects.ImageViewWrapper _imgdori = null;
String _txt = "";
anywheresoftware.b4a.objects.LabelWrapper _lable = null;
String[] _h14 = null;
int _colo = 0;
anywheresoftware.b4a.objects.LabelWrapper _lable1 = null;
RDebugUtils.currentLine=6356992;
 //BA.debugLineNum = 6356992;BA.debugLine="Sub addviewtosv_sub";
RDebugUtils.currentLine=6356993;
 //BA.debugLineNum = 6356993;BA.debugLine="canshare=True";
_canshare = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=6356996;
 //BA.debugLineNum = 6356996;BA.debugLine="For o = 0 To map.Size-1";
{
final int step2 = 1;
final int limit2 = (int) (mostCurrent._map.getSize()-1);
_o = (int) (0) ;
for (;_o <= limit2 ;_o = _o + step2 ) {
RDebugUtils.currentLine=6356998;
 //BA.debugLineNum = 6356998;BA.debugLine="Dim h13() As String=Regex.Split(\"#\",map.Get(o))";
_h13 = anywheresoftware.b4a.keywords.Common.Regex.Split("#",BA.ObjectToString(mostCurrent._map.Get(_o)));
RDebugUtils.currentLine=6356999;
 //BA.debugLineNum = 6356999;BA.debugLine="Try";
try {RDebugUtils.currentLine=6357000;
 //BA.debugLineNum = 6357000;BA.debugLine="Dim Typee As String = h13(1)";
_typee = _h13[(int) (1)];
 } 
       catch (Exception e7) {
			processBA.setLastException(e7);RDebugUtils.currentLine=6357002;
 //BA.debugLineNum = 6357002;BA.debugLine="Dim Typee As String =\"TEXT\"";
_typee = "TEXT";
 };
RDebugUtils.currentLine=6357005;
 //BA.debugLineNum = 6357005;BA.debugLine="Select Typee";
switch (BA.switchObjectToInt(_typee,"IMG","CAPTION","TEXT","SUB_TITLE","TABLE")) {
case 0: {
RDebugUtils.currentLine=6357007;
 //BA.debugLineNum = 6357007;BA.debugLine="Dim url As String =  h13(0)";
_url = _h13[(int) (0)];
RDebugUtils.currentLine=6357008;
 //BA.debugLineNum = 6357008;BA.debugLine="If h13(0)=\"http://www.beytoote.com\" Or h13(0)=";
if ((_h13[(int) (0)]).equals("http://www.beytoote.com") || (_h13[(int) (0)]).equals("") || _h13[(int) (0)]== null || (_h13[(int) (0)]).equals("Null")) { 
 }else {
RDebugUtils.currentLine=6357011;
 //BA.debugLineNum = 6357011;BA.debugLine="If firstpicshow=False Then";
if (_firstpicshow==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=6357012;
 //BA.debugLineNum = 6357012;BA.debugLine="firstpicshow=True";
_firstpicshow = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=6357014;
 //BA.debugLineNum = 6357014;BA.debugLine="Dim img1 As ImageView";
_img1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=6357015;
 //BA.debugLineNum = 6357015;BA.debugLine="img1.Initialize(\"img\")";
_img1.Initialize(mostCurrent.activityBA,"img");
RDebugUtils.currentLine=6357016;
 //BA.debugLineNum = 6357016;BA.debugLine="img1.Color=Colors.LightGray";
_img1.setColor(anywheresoftware.b4a.keywords.Common.Colors.LightGray);
RDebugUtils.currentLine=6357017;
 //BA.debugLineNum = 6357017;BA.debugLine="ScrollView1.Panel.AddView(img1,0,toptemp,100";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_img1.getObject()),(int) (0),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
RDebugUtils.currentLine=6357020;
 //BA.debugLineNum = 6357020;BA.debugLine="imglisnks.Put(img1,url)";
mostCurrent._imglisnks.Put((Object)(_img1.getObject()),(Object)(_url));
RDebugUtils.currentLine=6357022;
 //BA.debugLineNum = 6357022;BA.debugLine="Dim imgdori As ImageView";
_imgdori = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=6357023;
 //BA.debugLineNum = 6357023;BA.debugLine="imgdori.Initialize(\"\")";
_imgdori.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=6357024;
 //BA.debugLineNum = 6357024;BA.debugLine="imgdori.Gravity=Gravity.FILL";
_imgdori.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=6357027;
 //BA.debugLineNum = 6357027;BA.debugLine="ScrollView1.Panel.AddView(imgdori,0,toptemp,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_imgdori.getObject()),(int) (0),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
RDebugUtils.currentLine=6357028;
 //BA.debugLineNum = 6357028;BA.debugLine="toptemp=toptemp+60%x";
_toptemp = (int) (_toptemp+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
 };
 };
 break; }
case 1: {
RDebugUtils.currentLine=6357033;
 //BA.debugLineNum = 6357033;BA.debugLine="If h13(0).Length>2 Then";
if (_h13[(int) (0)].length()>2) { 
RDebugUtils.currentLine=6357034;
 //BA.debugLineNum = 6357034;BA.debugLine="Dim txt As String =  h13(0)";
_txt = _h13[(int) (0)];
RDebugUtils.currentLine=6357036;
 //BA.debugLineNum = 6357036;BA.debugLine="Dim lable As Label";
_lable = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=6357037;
 //BA.debugLineNum = 6357037;BA.debugLine="lable.Initialize(\"\")";
_lable.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=6357038;
 //BA.debugLineNum = 6357038;BA.debugLine="lable.Text=Convert_FA2EN(txt)";
_lable.setText(BA.ObjectToCharSequence(_convert_fa2en(_txt)));
RDebugUtils.currentLine=6357039;
 //BA.debugLineNum = 6357039;BA.debugLine="alltext=alltext&CRLF&Convert_FA2EN(txt)";
mostCurrent._alltext = mostCurrent._alltext+anywheresoftware.b4a.keywords.Common.CRLF+_convert_fa2en(_txt);
RDebugUtils.currentLine=6357040;
 //BA.debugLineNum = 6357040;BA.debugLine="lable.Typeface=C.irs";
_lable.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ .getObject()));
RDebugUtils.currentLine=6357041;
 //BA.debugLineNum = 6357041;BA.debugLine="lable.Color=Colors.RGB(234,209,212)";
_lable.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (234),(int) (209),(int) (212)));
RDebugUtils.currentLine=6357042;
 //BA.debugLineNum = 6357042;BA.debugLine="lable.TextColor=Colors.ARGB(255,22,13,108)";
_lable.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (22),(int) (13),(int) (108)));
RDebugUtils.currentLine=6357043;
 //BA.debugLineNum = 6357043;BA.debugLine="lable.Padding=Array As Int (10dip,5dip,10dip,";
_lable.setPadding(new int[]{anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))});
RDebugUtils.currentLine=6357044;
 //BA.debugLineNum = 6357044;BA.debugLine="lable.TextSize=15";
_lable.setTextSize((float) (15));
RDebugUtils.currentLine=6357045;
 //BA.debugLineNum = 6357045;BA.debugLine="lable.Gravity= Gravity.CENTER',Gravity.RIGHT)";
_lable.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=6357047;
 //BA.debugLineNum = 6357047;BA.debugLine="ScrollView1.Panel.AddView(lable,0,toptemp,100";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lable.getObject()),(int) (0),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
RDebugUtils.currentLine=6357048;
 //BA.debugLineNum = 6357048;BA.debugLine="lable.Height=hlbl.LabelHeight(Convert_FA2EN(t";
_lable.setHeight((int) (mostCurrent._hlbl._labelheight(_convert_fa2en(_txt),_lable,mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ ,(int) (15),anywheresoftware.b4a.keywords.Common.Gravity.CENTER,(float) (1.2))));
RDebugUtils.currentLine=6357049;
 //BA.debugLineNum = 6357049;BA.debugLine="lable.Height=lable.Height+5dip";
_lable.setHeight((int) (_lable.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))));
RDebugUtils.currentLine=6357050;
 //BA.debugLineNum = 6357050;BA.debugLine="toptemp=toptemp+lable.Height+5%x";
_toptemp = (int) (_toptemp+_lable.getHeight()+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA));
 };
 break; }
case 2: {
RDebugUtils.currentLine=6357055;
 //BA.debugLineNum = 6357055;BA.debugLine="If h13(0).Length>2 Then";
if (_h13[(int) (0)].length()>2) { 
RDebugUtils.currentLine=6357056;
 //BA.debugLineNum = 6357056;BA.debugLine="Dim txt As String =  h13(0)";
_txt = _h13[(int) (0)];
RDebugUtils.currentLine=6357058;
 //BA.debugLineNum = 6357058;BA.debugLine="Dim lable As Label";
_lable = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=6357059;
 //BA.debugLineNum = 6357059;BA.debugLine="lable.Initialize(\"\")";
_lable.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=6357060;
 //BA.debugLineNum = 6357060;BA.debugLine="lable.Text=Convert_FA2EN(txt)";
_lable.setText(BA.ObjectToCharSequence(_convert_fa2en(_txt)));
RDebugUtils.currentLine=6357061;
 //BA.debugLineNum = 6357061;BA.debugLine="alltext=alltext&CRLF&Convert_FA2EN(txt)";
mostCurrent._alltext = mostCurrent._alltext+anywheresoftware.b4a.keywords.Common.CRLF+_convert_fa2en(_txt);
RDebugUtils.currentLine=6357062;
 //BA.debugLineNum = 6357062;BA.debugLine="lable.Typeface=C.irs";
_lable.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ .getObject()));
RDebugUtils.currentLine=6357064;
 //BA.debugLineNum = 6357064;BA.debugLine="lable.TextColor=Colors.Black";
_lable.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=6357065;
 //BA.debugLineNum = 6357065;BA.debugLine="lable.Padding=Array As Int (1dip,5dip,10dip,0";
_lable.setPadding(new int[]{anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (0)});
RDebugUtils.currentLine=6357066;
 //BA.debugLineNum = 6357066;BA.debugLine="lable.TextSize=14";
_lable.setTextSize((float) (14));
RDebugUtils.currentLine=6357067;
 //BA.debugLineNum = 6357067;BA.debugLine="lable.Gravity= Gravity.RIGHT";
_lable.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT);
RDebugUtils.currentLine=6357068;
 //BA.debugLineNum = 6357068;BA.debugLine="ScrollView1.Panel.AddView(lable,2%x,toptemp,9";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lable.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
RDebugUtils.currentLine=6357069;
 //BA.debugLineNum = 6357069;BA.debugLine="lable.Height=hlbl.LabelHeight(Convert_FA2EN(t";
_lable.setHeight((int) (mostCurrent._hlbl._labelheight(_convert_fa2en(_txt),_lable,mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ ,(int) (14),anywheresoftware.b4a.keywords.Common.Gravity.RIGHT,(float) (1.2))));
RDebugUtils.currentLine=6357070;
 //BA.debugLineNum = 6357070;BA.debugLine="toptemp=toptemp+lable.Height+5%x";
_toptemp = (int) (_toptemp+_lable.getHeight()+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA));
 };
 break; }
case 3: {
RDebugUtils.currentLine=6357074;
 //BA.debugLineNum = 6357074;BA.debugLine="If h13(0).Length>2 Then";
if (_h13[(int) (0)].length()>2) { 
RDebugUtils.currentLine=6357075;
 //BA.debugLineNum = 6357075;BA.debugLine="Dim txt As String =  h13(0)";
_txt = _h13[(int) (0)];
RDebugUtils.currentLine=6357077;
 //BA.debugLineNum = 6357077;BA.debugLine="titletemp=True";
_titletemp = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=6357078;
 //BA.debugLineNum = 6357078;BA.debugLine="Dim lable As Label";
_lable = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=6357079;
 //BA.debugLineNum = 6357079;BA.debugLine="lable.Initialize(\"\")";
_lable.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=6357080;
 //BA.debugLineNum = 6357080;BA.debugLine="lable.Text=Convert_FA2EN(txt)";
_lable.setText(BA.ObjectToCharSequence(_convert_fa2en(_txt)));
RDebugUtils.currentLine=6357081;
 //BA.debugLineNum = 6357081;BA.debugLine="alltext=alltext&CRLF&Convert_FA2EN(txt)";
mostCurrent._alltext = mostCurrent._alltext+anywheresoftware.b4a.keywords.Common.CRLF+_convert_fa2en(_txt);
RDebugUtils.currentLine=6357082;
 //BA.debugLineNum = 6357082;BA.debugLine="lable.Typeface=C.irs";
_lable.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ .getObject()));
RDebugUtils.currentLine=6357084;
 //BA.debugLineNum = 6357084;BA.debugLine="lable.TextColor=Colors.ARGB(255,146,6,47)";
_lable.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (146),(int) (6),(int) (47)));
RDebugUtils.currentLine=6357085;
 //BA.debugLineNum = 6357085;BA.debugLine="lable.Padding=Array As Int (1dip,5dip,10dip,0";
_lable.setPadding(new int[]{anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (0)});
RDebugUtils.currentLine=6357086;
 //BA.debugLineNum = 6357086;BA.debugLine="lable.TextSize=17";
_lable.setTextSize((float) (17));
RDebugUtils.currentLine=6357087;
 //BA.debugLineNum = 6357087;BA.debugLine="lable.Gravity= Gravity.RIGHT";
_lable.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT);
RDebugUtils.currentLine=6357088;
 //BA.debugLineNum = 6357088;BA.debugLine="ScrollView1.Panel.AddView(lable,2%x,toptemp,9";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lable.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
RDebugUtils.currentLine=6357089;
 //BA.debugLineNum = 6357089;BA.debugLine="lable.Height=hlbl.LabelHeight(Convert_FA2EN(t";
_lable.setHeight((int) (mostCurrent._hlbl._labelheight(_convert_fa2en(_txt),_lable,mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ ,(int) (17),anywheresoftware.b4a.keywords.Common.Gravity.RIGHT,(float) (1.2))));
RDebugUtils.currentLine=6357090;
 //BA.debugLineNum = 6357090;BA.debugLine="toptemp=toptemp+lable.Height";
_toptemp = (int) (_toptemp+_lable.getHeight());
 };
 break; }
case 4: {
RDebugUtils.currentLine=6357093;
 //BA.debugLineNum = 6357093;BA.debugLine="If h13(0).Length>2 Then";
if (_h13[(int) (0)].length()>2) { 
RDebugUtils.currentLine=6357095;
 //BA.debugLineNum = 6357095;BA.debugLine="titletemp=True";
_titletemp = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=6357096;
 //BA.debugLineNum = 6357096;BA.debugLine="Try";
try {RDebugUtils.currentLine=6357098;
 //BA.debugLineNum = 6357098;BA.debugLine="Dim h14() As String=Regex.Split(\"@\",h13(0))";
_h14 = anywheresoftware.b4a.keywords.Common.Regex.Split("@",_h13[(int) (0)]);
RDebugUtils.currentLine=6357100;
 //BA.debugLineNum = 6357100;BA.debugLine="Dim colo As Int";
_colo = 0;
RDebugUtils.currentLine=6357101;
 //BA.debugLineNum = 6357101;BA.debugLine="If map.IndexOf(map.Get(o)) Mod 2 = 0 Then";
if (mostCurrent._map.IndexOf(mostCurrent._map.Get(_o))%2==0) { 
RDebugUtils.currentLine=6357102;
 //BA.debugLineNum = 6357102;BA.debugLine="colo=0xFFF7F7F7";
_colo = (int) (0xfff7f7f7);
 }else {
RDebugUtils.currentLine=6357104;
 //BA.debugLineNum = 6357104;BA.debugLine="colo=0xFFEBEBEB";
_colo = (int) (0xffebebeb);
 };
RDebugUtils.currentLine=6357107;
 //BA.debugLineNum = 6357107;BA.debugLine="Dim lable1 As Label";
_lable1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=6357108;
 //BA.debugLineNum = 6357108;BA.debugLine="lable1.Initialize(\"\")";
_lable1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=6357109;
 //BA.debugLineNum = 6357109;BA.debugLine="lable1.Text=Convert_FA2EN(h14(0))";
_lable1.setText(BA.ObjectToCharSequence(_convert_fa2en(_h14[(int) (0)])));
RDebugUtils.currentLine=6357110;
 //BA.debugLineNum = 6357110;BA.debugLine="lable1.Typeface=C.irs";
_lable1.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ .getObject()));
RDebugUtils.currentLine=6357111;
 //BA.debugLineNum = 6357111;BA.debugLine="lable1.Color=colo";
_lable1.setColor(_colo);
RDebugUtils.currentLine=6357112;
 //BA.debugLineNum = 6357112;BA.debugLine="lable1.TextColor=Colors.ARGB(255,146,6,47)";
_lable1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (146),(int) (6),(int) (47)));
RDebugUtils.currentLine=6357113;
 //BA.debugLineNum = 6357113;BA.debugLine="lable1.Padding=Array As Int (1dip,5dip,10dip";
_lable1.setPadding(new int[]{anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (0)});
RDebugUtils.currentLine=6357114;
 //BA.debugLineNum = 6357114;BA.debugLine="lable1.TextSize=17";
_lable1.setTextSize((float) (17));
RDebugUtils.currentLine=6357115;
 //BA.debugLineNum = 6357115;BA.debugLine="lable1.Gravity= Gravity.RIGHT";
_lable1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT);
RDebugUtils.currentLine=6357116;
 //BA.debugLineNum = 6357116;BA.debugLine="ScrollView1.Panel.AddView(lable1,0,toptemp,4";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lable1.getObject()),(int) (0),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (49.5),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
RDebugUtils.currentLine=6357117;
 //BA.debugLineNum = 6357117;BA.debugLine="lable1.Height=hlbl.LabelHeight(Convert_FA2EN";
_lable1.setHeight((int) (mostCurrent._hlbl._labelheight(_convert_fa2en(_h14[(int) (1)]),_lable1,mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ ,(int) (14),anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT,anywheresoftware.b4a.keywords.Common.Gravity.CENTER),(float) (1.2))));
RDebugUtils.currentLine=6357120;
 //BA.debugLineNum = 6357120;BA.debugLine="Dim lable As Label";
_lable = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=6357121;
 //BA.debugLineNum = 6357121;BA.debugLine="lable.Initialize(\"\")";
_lable.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=6357122;
 //BA.debugLineNum = 6357122;BA.debugLine="lable.Text=Convert_FA2EN(h14(0))";
_lable.setText(BA.ObjectToCharSequence(_convert_fa2en(_h14[(int) (0)])));
RDebugUtils.currentLine=6357123;
 //BA.debugLineNum = 6357123;BA.debugLine="lable.Typeface=C.irs";
_lable.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ .getObject()));
RDebugUtils.currentLine=6357124;
 //BA.debugLineNum = 6357124;BA.debugLine="lable.Color=colo";
_lable.setColor(_colo);
RDebugUtils.currentLine=6357125;
 //BA.debugLineNum = 6357125;BA.debugLine="lable.TextColor=Colors.ARGB(255,146,6,47)";
_lable.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (146),(int) (6),(int) (47)));
RDebugUtils.currentLine=6357126;
 //BA.debugLineNum = 6357126;BA.debugLine="lable.Padding=Array As Int (1dip,5dip,10dip,";
_lable.setPadding(new int[]{anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (0)});
RDebugUtils.currentLine=6357127;
 //BA.debugLineNum = 6357127;BA.debugLine="lable.TextSize=17";
_lable.setTextSize((float) (17));
RDebugUtils.currentLine=6357128;
 //BA.debugLineNum = 6357128;BA.debugLine="lable.Gravity= Gravity.RIGHT";
_lable.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT);
RDebugUtils.currentLine=6357129;
 //BA.debugLineNum = 6357129;BA.debugLine="ScrollView1.Panel.AddView(lable,50%x,toptemp";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lable.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
RDebugUtils.currentLine=6357130;
 //BA.debugLineNum = 6357130;BA.debugLine="lable.Height=hlbl.LabelHeight(Convert_FA2EN(";
_lable.setHeight((int) (mostCurrent._hlbl._labelheight(_convert_fa2en(_h14[(int) (0)]),_lable,mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ ,(int) (14),anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT,anywheresoftware.b4a.keywords.Common.Gravity.CENTER),(float) (1.2))));
RDebugUtils.currentLine=6357131;
 //BA.debugLineNum = 6357131;BA.debugLine="lable1.Height=lable.Height";
_lable1.setHeight(_lable.getHeight());
RDebugUtils.currentLine=6357132;
 //BA.debugLineNum = 6357132;BA.debugLine="toptemp=toptemp+lable.Height+.5%x";
_toptemp = (int) (_toptemp+_lable.getHeight()+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (.5),mostCurrent.activityBA));
RDebugUtils.currentLine=6357134;
 //BA.debugLineNum = 6357134;BA.debugLine="alltext=alltext&CRLF&h14(0)&\" : \"&h14(1)";
mostCurrent._alltext = mostCurrent._alltext+anywheresoftware.b4a.keywords.Common.CRLF+_h14[(int) (0)]+" : "+_h14[(int) (1)];
 } 
       catch (Exception e117) {
			processBA.setLastException(e117); };
 };
 break; }
}
;
 }
};
RDebugUtils.currentLine=6357145;
 //BA.debugLineNum = 6357145;BA.debugLine="End Sub";
return "";
}
public static String  _convert_fa2en(String _contente) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "convert_fa2en", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "convert_fa2en", new Object[] {_contente}));}
String _res = "";
RDebugUtils.currentLine=6291456;
 //BA.debugLineNum = 6291456;BA.debugLine="Sub Convert_FA2EN(contente As String) As String";
RDebugUtils.currentLine=6291458;
 //BA.debugLineNum = 6291458;BA.debugLine="Dim Res As String = contente";
_res = _contente;
RDebugUtils.currentLine=6291459;
 //BA.debugLineNum = 6291459;BA.debugLine="Res = Res.Replace(\"0\", \"۰\")";
_res = _res.replace("0","۰");
RDebugUtils.currentLine=6291460;
 //BA.debugLineNum = 6291460;BA.debugLine="Res = Res.Replace(\"1\", \"۱\")";
_res = _res.replace("1","۱");
RDebugUtils.currentLine=6291461;
 //BA.debugLineNum = 6291461;BA.debugLine="Res = Res.Replace(\"2\", \"۲\")";
_res = _res.replace("2","۲");
RDebugUtils.currentLine=6291462;
 //BA.debugLineNum = 6291462;BA.debugLine="Res = Res.Replace(\"3\", \"۳\")";
_res = _res.replace("3","۳");
RDebugUtils.currentLine=6291463;
 //BA.debugLineNum = 6291463;BA.debugLine="Res = Res.Replace(\"4\", \"۴\")";
_res = _res.replace("4","۴");
RDebugUtils.currentLine=6291464;
 //BA.debugLineNum = 6291464;BA.debugLine="Res = Res.Replace(\"5\", \"۵\")";
_res = _res.replace("5","۵");
RDebugUtils.currentLine=6291465;
 //BA.debugLineNum = 6291465;BA.debugLine="Res = Res.Replace(\"6\", \"۶\")";
_res = _res.replace("6","۶");
RDebugUtils.currentLine=6291466;
 //BA.debugLineNum = 6291466;BA.debugLine="Res = Res.Replace(\"7\", \"۷\")";
_res = _res.replace("7","۷");
RDebugUtils.currentLine=6291467;
 //BA.debugLineNum = 6291467;BA.debugLine="Res = Res.Replace(\"8\", \"۸\")";
_res = _res.replace("8","۸");
RDebugUtils.currentLine=6291468;
 //BA.debugLineNum = 6291468;BA.debugLine="Res = Res.Replace(\"9\", \"۹\")";
_res = _res.replace("9","۹");
RDebugUtils.currentLine=6291469;
 //BA.debugLineNum = 6291469;BA.debugLine="Return Res";
if (true) return _res;
RDebugUtils.currentLine=6291471;
 //BA.debugLineNum = 6291471;BA.debugLine="End Sub";
return "";
}
public static String  _converttickstotimestring_sub(long _ta) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "converttickstotimestring_sub", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "converttickstotimestring_sub", new Object[] {_ta}));}
int _hours = 0;
int _minutes = 0;
int _seconds = 0;
RDebugUtils.currentLine=7143424;
 //BA.debugLineNum = 7143424;BA.debugLine="Sub ConvertTicksToTimeString_sub(ta As Long) As St";
RDebugUtils.currentLine=7143425;
 //BA.debugLineNum = 7143425;BA.debugLine="Dim  hours, minutes, seconds As Int";
_hours = 0;
_minutes = 0;
_seconds = 0;
RDebugUtils.currentLine=7143426;
 //BA.debugLineNum = 7143426;BA.debugLine="hours = ta / DateTime.TicksPerHour";
_hours = (int) (_ta/(double)anywheresoftware.b4a.keywords.Common.DateTime.TicksPerHour);
RDebugUtils.currentLine=7143427;
 //BA.debugLineNum = 7143427;BA.debugLine="minutes = (ta Mod DateTime.TicksPerHour) / DateTi";
_minutes = (int) ((_ta%anywheresoftware.b4a.keywords.Common.DateTime.TicksPerHour)/(double)anywheresoftware.b4a.keywords.Common.DateTime.TicksPerMinute);
RDebugUtils.currentLine=7143428;
 //BA.debugLineNum = 7143428;BA.debugLine="seconds = (ta Mod DateTime.TicksPerMinute) / Date";
_seconds = (int) ((_ta%anywheresoftware.b4a.keywords.Common.DateTime.TicksPerMinute)/(double)anywheresoftware.b4a.keywords.Common.DateTime.TicksPerSecond);
RDebugUtils.currentLine=7143429;
 //BA.debugLineNum = 7143429;BA.debugLine="Return NumberFormat(minutes, 2, 0) & \":\" & Number";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_minutes,(int) (2),(int) (0))+":"+anywheresoftware.b4a.keywords.Common.NumberFormat(_seconds,(int) (2),(int) (0));
RDebugUtils.currentLine=7143430;
 //BA.debugLineNum = 7143430;BA.debugLine="End Sub";
return "";
}
public static String  _file_onfailure(String _msg) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "file_onfailure", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "file_onfailure", new Object[] {_msg}));}
RDebugUtils.currentLine=6684672;
 //BA.debugLineNum = 6684672;BA.debugLine="Sub file_onFailure(msg As String)";
RDebugUtils.currentLine=6684674;
 //BA.debugLineNum = 6684674;BA.debugLine="Pnlprb.Visible=False";
mostCurrent._pnlprb.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6684675;
 //BA.debugLineNum = 6684675;BA.debugLine="Label1.Visible=True";
mostCurrent._label1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6684676;
 //BA.debugLineNum = 6684676;BA.debugLine="Label2.Visible=True";
mostCurrent._label2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6684677;
 //BA.debugLineNum = 6684677;BA.debugLine="End Sub";
return "";
}
public static String  _flot2_click() throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "flot2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "flot2_click", null));}
RDebugUtils.currentLine=6815744;
 //BA.debugLineNum = 6815744;BA.debugLine="Sub flot2_Click";
RDebugUtils.currentLine=6815747;
 //BA.debugLineNum = 6815747;BA.debugLine="End Sub";
return "";
}
public static String  _flot3_click() throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "flot3_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "flot3_click", null));}
anywheresoftware.b4a.ariagplib.ARIAlib _aria = null;
RDebugUtils.currentLine=6881280;
 //BA.debugLineNum = 6881280;BA.debugLine="Sub flot3_Click";
RDebugUtils.currentLine=6881281;
 //BA.debugLineNum = 6881281;BA.debugLine="Dim Aria As AriaLib";
_aria = new anywheresoftware.b4a.ariagplib.ARIAlib();
RDebugUtils.currentLine=6881282;
 //BA.debugLineNum = 6881282;BA.debugLine="StartActivity( Aria.ShareText(Main.txtnewstitle&C";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_aria.ShareText(mostCurrent._main._txtnewstitle /*String*/ +anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Main.txtnews"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"برگرفته از اپلیکیشن هواشناسی پیشرفته ؛"+anywheresoftware.b4a.keywords.Common.CRLF+"https://cafebazaar.ir/app/"+anywheresoftware.b4a.keywords.Common.Application.getPackageName()+"/?l=fa","اشتراک گذاری با ؛")));
RDebugUtils.currentLine=6881283;
 //BA.debugLineNum = 6881283;BA.debugLine="End Sub";
return "";
}
public static String  _force_rtlsupported4view(anywheresoftware.b4a.objects.ConcreteViewWrapper _view) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "force_rtlsupported4view", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "force_rtlsupported4view", new Object[] {_view}));}
anywheresoftware.b4j.object.JavaObject _ja = null;
anywheresoftware.b4j.object.JavaObject _jos = null;
RDebugUtils.currentLine=6225920;
 //BA.debugLineNum = 6225920;BA.debugLine="Sub Force_RtlSupported4View(View As View)";
RDebugUtils.currentLine=6225921;
 //BA.debugLineNum = 6225921;BA.debugLine="Dim jA,jos As JavaObject";
_ja = new anywheresoftware.b4j.object.JavaObject();
_jos = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=6225922;
 //BA.debugLineNum = 6225922;BA.debugLine="jos.InitializeStatic  (\"android.view.View\")";
_jos.InitializeStatic("android.view.View");
RDebugUtils.currentLine=6225923;
 //BA.debugLineNum = 6225923;BA.debugLine="If jA.InitializeStatic  (\"android.os.Build$VERSIO";
if ((double)(BA.ObjectToNumber(_ja.InitializeStatic("android.os.Build$VERSION").GetField("SDK_INT")))>16) { 
RDebugUtils.currentLine=6225924;
 //BA.debugLineNum = 6225924;BA.debugLine="jA = View";
_ja.setObject((java.lang.Object)(_view.getObject()));
RDebugUtils.currentLine=6225925;
 //BA.debugLineNum = 6225925;BA.debugLine="jA.RunMethod (\"setLayoutDirection\",Array(jos.Get";
_ja.RunMethod("setLayoutDirection",new Object[]{_jos.GetField("LAYOUT_DIRECTION_RTL")});
 };
RDebugUtils.currentLine=6225927;
 //BA.debugLineNum = 6225927;BA.debugLine="End Sub";
return "";
}
public static String  _from_cacht(String _a,int _size) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "from_cacht", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "from_cacht", new Object[] {_a,_size}));}
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
String _thumbnail = "";
anywheresoftware.b4a.objects.collections.List _images = null;
String _colimages = "";
String _title = "";
String _contentd = "";
String _cd = "";
String[] _h14 = null;
int _i = 0;
String[] _h13 = null;
String _url = "";
anywheresoftware.b4a.objects.ImageViewWrapper _img1 = null;
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.ImageViewWrapper _img12 = null;
de.amberhome.objects.appcompat.AppCompatBase _ac = null;
anywheresoftware.b4a.objects.LabelWrapper _lblplaya = null;
anywheresoftware.b4a.objects.LabelWrapper _lbldownd = null;
String _txt = "";
anywheresoftware.b4a.objects.LabelWrapper _lable = null;
RDebugUtils.currentLine=6750208;
 //BA.debugLineNum = 6750208;BA.debugLine="Sub from_cacht(a As String , size As Int)";
RDebugUtils.currentLine=6750209;
 //BA.debugLineNum = 6750209;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=6750210;
 //BA.debugLineNum = 6750210;BA.debugLine="parser.Initialize(a)";
_parser.Initialize(_a);
RDebugUtils.currentLine=6750211;
 //BA.debugLineNum = 6750211;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=6750212;
 //BA.debugLineNum = 6750212;BA.debugLine="Dim thumbnail As String = root.Get(\"thumbnail\")";
_thumbnail = BA.ObjectToString(_root.Get((Object)("thumbnail")));
RDebugUtils.currentLine=6750213;
 //BA.debugLineNum = 6750213;BA.debugLine="Dim images As List = root.Get(\"images\")";
_images = new anywheresoftware.b4a.objects.collections.List();
_images.setObject((java.util.List)(_root.Get((Object)("images"))));
RDebugUtils.currentLine=6750214;
 //BA.debugLineNum = 6750214;BA.debugLine="For Each colimages As String In images";
{
final anywheresoftware.b4a.BA.IterableList group6 = _images;
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_colimages = BA.ObjectToString(group6.Get(index6));
 }
};
RDebugUtils.currentLine=6750217;
 //BA.debugLineNum = 6750217;BA.debugLine="Dim title As String = root.Get(\"title\")";
_title = BA.ObjectToString(_root.Get((Object)("title")));
RDebugUtils.currentLine=6750218;
 //BA.debugLineNum = 6750218;BA.debugLine="Dim contentd As String = root.Get(\"content\")";
_contentd = BA.ObjectToString(_root.Get((Object)("content")));
RDebugUtils.currentLine=6750220;
 //BA.debugLineNum = 6750220;BA.debugLine="Dim cd As String";
_cd = "";
RDebugUtils.currentLine=6750222;
 //BA.debugLineNum = 6750222;BA.debugLine="Dim h14() As String=Regex.Split(CRLF,contentd)";
_h14 = anywheresoftware.b4a.keywords.Common.Regex.Split(anywheresoftware.b4a.keywords.Common.CRLF,_contentd);
RDebugUtils.currentLine=6750223;
 //BA.debugLineNum = 6750223;BA.debugLine="For i = 0 To h14.Length-1";
{
final int step12 = 1;
final int limit12 = (int) (_h14.length-1);
_i = (int) (0) ;
for (;_i <= limit12 ;_i = _i + step12 ) {
RDebugUtils.currentLine=6750225;
 //BA.debugLineNum = 6750225;BA.debugLine="If h14(i).Length>1 Then";
if (_h14[_i].length()>1) { 
RDebugUtils.currentLine=6750226;
 //BA.debugLineNum = 6750226;BA.debugLine="cd=cd&CRLF&h14(i)";
_cd = _cd+anywheresoftware.b4a.keywords.Common.CRLF+_h14[_i];
 };
 }
};
RDebugUtils.currentLine=6750230;
 //BA.debugLineNum = 6750230;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
RDebugUtils.currentLine=6750232;
 //BA.debugLineNum = 6750232;BA.debugLine="addtitle_sub(title,\"\")";
_addtitle_sub(_title,"");
RDebugUtils.currentLine=6750233;
 //BA.debugLineNum = 6750233;BA.debugLine="Dim h13() As String=Regex.Split(\"<span>\",c)";
_h13 = anywheresoftware.b4a.keywords.Common.Regex.Split("<span>",BA.ObjectToString(mostCurrent._c));
RDebugUtils.currentLine=6750234;
 //BA.debugLineNum = 6750234;BA.debugLine="For i = 0 To h13.Length-1";
{
final int step20 = 1;
final int limit20 = (int) (_h13.length-1);
_i = (int) (0) ;
for (;_i <= limit20 ;_i = _i + step20 ) {
RDebugUtils.currentLine=6750245;
 //BA.debugLineNum = 6750245;BA.debugLine="If h13(i).Contains(\".mp3\") Or h13(i).Contains(\".";
if (_h13[_i].contains(".mp3") || _h13[_i].contains(".mp4") || _h13[_i].contains("img") || _h13[_i].contains("caption")) { 
RDebugUtils.currentLine=6750246;
 //BA.debugLineNum = 6750246;BA.debugLine="If h13(i).Contains(\"img\") Then";
if (_h13[_i].contains("img")) { 
RDebugUtils.currentLine=6750247;
 //BA.debugLineNum = 6750247;BA.debugLine="Dim url As String =  GetImage_Path(h13(i))";
_url = _getimage_path(_h13[_i]);
RDebugUtils.currentLine=6750248;
 //BA.debugLineNum = 6750248;BA.debugLine="If h13(i)<>\"\"  Then";
if ((_h13[_i]).equals("") == false) { 
RDebugUtils.currentLine=6750249;
 //BA.debugLineNum = 6750249;BA.debugLine="Dim img1 As ImageView";
_img1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=6750250;
 //BA.debugLineNum = 6750250;BA.debugLine="img1.Initialize(\"\")";
_img1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=6750251;
 //BA.debugLineNum = 6750251;BA.debugLine="img1.Color=Colors.Transparent";
_img1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=6750252;
 //BA.debugLineNum = 6750252;BA.debugLine="ScrollView1.Panel.AddView(img1,0,toptemp,100%";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_img1.getObject()),(int) (0),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
RDebugUtils.currentLine=6750254;
 //BA.debugLineNum = 6750254;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=6750255;
 //BA.debugLineNum = 6750255;BA.debugLine="pnl.Initialize(\"\")";
_pnl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=6750256;
 //BA.debugLineNum = 6750256;BA.debugLine="pnl.Color=0xC8FFFFFF";
_pnl.setColor((int) (0xc8ffffff));
RDebugUtils.currentLine=6750257;
 //BA.debugLineNum = 6750257;BA.debugLine="ScrollView1.Panel.AddView(pnl,0,toptemp,100%x";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_pnl.getObject()),(int) (0),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
RDebugUtils.currentLine=6750259;
 //BA.debugLineNum = 6750259;BA.debugLine="Dim img12 As ImageView";
_img12 = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=6750260;
 //BA.debugLineNum = 6750260;BA.debugLine="img12.Initialize(\"img\")";
_img12.Initialize(mostCurrent.activityBA,"img");
RDebugUtils.currentLine=6750261;
 //BA.debugLineNum = 6750261;BA.debugLine="img12.Color=Colors.Transparent";
_img12.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=6750262;
 //BA.debugLineNum = 6750262;BA.debugLine="ScrollView1.Panel.AddView(img12,0,toptemp,100";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_img12.getObject()),(int) (0),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
RDebugUtils.currentLine=6750269;
 //BA.debugLineNum = 6750269;BA.debugLine="imglisnks.Put(img12,url)";
mostCurrent._imglisnks.Put((Object)(_img12.getObject()),(Object)(_url));
RDebugUtils.currentLine=6750270;
 //BA.debugLineNum = 6750270;BA.debugLine="toptemp=toptemp+62%x";
_toptemp = (int) (_toptemp+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (62),mostCurrent.activityBA));
 };
 };
RDebugUtils.currentLine=6750273;
 //BA.debugLineNum = 6750273;BA.debugLine="If h13(i).Contains(\".mp4\") Then";
if (_h13[_i].contains(".mp4")) { 
RDebugUtils.currentLine=6750279;
 //BA.debugLineNum = 6750279;BA.debugLine="videolink=Getmp4_Path(h13(i))";
_videolink = _getmp4_path(_h13[_i]);
 };
RDebugUtils.currentLine=6750285;
 //BA.debugLineNum = 6750285;BA.debugLine="If h13(i).Contains(\".mp3\") Then";
if (_h13[_i].contains(".mp3")) { 
RDebugUtils.currentLine=6750286;
 //BA.debugLineNum = 6750286;BA.debugLine="soundurl =  Getmp3_Path(h13(i))";
mostCurrent._soundurl = _getmp3_path(_h13[_i]);
RDebugUtils.currentLine=6750288;
 //BA.debugLineNum = 6750288;BA.debugLine="If h13(i)<>\"\"  Then";
if ((_h13[_i]).equals("") == false) { 
RDebugUtils.currentLine=6750290;
 //BA.debugLineNum = 6750290;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=6750291;
 //BA.debugLineNum = 6750291;BA.debugLine="pnl.Initialize(\"\")";
_pnl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=6750292;
 //BA.debugLineNum = 6750292;BA.debugLine="pnl.Color=Colors.LightGray";
_pnl.setColor(anywheresoftware.b4a.keywords.Common.Colors.LightGray);
RDebugUtils.currentLine=6750293;
 //BA.debugLineNum = 6750293;BA.debugLine="ScrollView1.Panel.AddView(pnl,0,toptemp,100%x";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_pnl.getObject()),(int) (0),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA));
RDebugUtils.currentLine=6750295;
 //BA.debugLineNum = 6750295;BA.debugLine="Dim ac As AppCompat";
_ac = new de.amberhome.objects.appcompat.AppCompatBase();
RDebugUtils.currentLine=6750297;
 //BA.debugLineNum = 6750297;BA.debugLine="Dim lblplaya As Label";
_lblplaya = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=6750298;
 //BA.debugLineNum = 6750298;BA.debugLine="lblplaya.Initialize(\"\")";
_lblplaya.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=6750299;
 //BA.debugLineNum = 6750299;BA.debugLine="lblplaya.Color=0xFFBCBCBC";
_lblplaya.setColor((int) (0xffbcbcbc));
RDebugUtils.currentLine=6750300;
 //BA.debugLineNum = 6750300;BA.debugLine="ScrollView1.Panel.AddView(lblplaya,85%x,topte";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lblplaya.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (85),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA));
RDebugUtils.currentLine=6750302;
 //BA.debugLineNum = 6750302;BA.debugLine="Dim lbldownd As Label";
_lbldownd = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=6750303;
 //BA.debugLineNum = 6750303;BA.debugLine="lbldownd.Initialize(\"\")";
_lbldownd.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=6750304;
 //BA.debugLineNum = 6750304;BA.debugLine="lbldownd.Color=0xFFBCBCBC";
_lbldownd.setColor((int) (0xffbcbcbc));
RDebugUtils.currentLine=6750305;
 //BA.debugLineNum = 6750305;BA.debugLine="ScrollView1.Panel.AddView(lbldownd,0,toptemp,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lbldownd.getObject()),(int) (0),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA));
RDebugUtils.currentLine=6750308;
 //BA.debugLineNum = 6750308;BA.debugLine="lblplay.Initialize(\"lblplay\")";
mostCurrent._lblplay.Initialize(mostCurrent.activityBA,"lblplay");
RDebugUtils.currentLine=6750309;
 //BA.debugLineNum = 6750309;BA.debugLine="lblplay.Text=Chr(0xE037)";
mostCurrent._lblplay.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe037))));
RDebugUtils.currentLine=6750310;
 //BA.debugLineNum = 6750310;BA.debugLine="lblplay.Typeface=Typeface.MATERIALICONS";
mostCurrent._lblplay.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
RDebugUtils.currentLine=6750311;
 //BA.debugLineNum = 6750311;BA.debugLine="lblplay.Gravity=Gravity.CENTER";
mostCurrent._lblplay.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=6750312;
 //BA.debugLineNum = 6750312;BA.debugLine="lblplay.TextColor=Colors.DarkGray";
mostCurrent._lblplay.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.DarkGray);
RDebugUtils.currentLine=6750313;
 //BA.debugLineNum = 6750313;BA.debugLine="lblplay.TextSize=20";
mostCurrent._lblplay.setTextSize((float) (20));
RDebugUtils.currentLine=6750314;
 //BA.debugLineNum = 6750314;BA.debugLine="ScrollView1.Panel.AddView(lblplay,0,toptemp,1";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._lblplay.getObject()),(int) (0),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA));
RDebugUtils.currentLine=6750315;
 //BA.debugLineNum = 6750315;BA.debugLine="ac.SetClickEffect(lblplay,False)";
_ac.SetClickEffect(mostCurrent.activityBA,(android.view.View)(mostCurrent._lblplay.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6750317;
 //BA.debugLineNum = 6750317;BA.debugLine="lbldown.Initialize(\"lbldown\")";
mostCurrent._lbldown.Initialize(mostCurrent.activityBA,"lbldown");
RDebugUtils.currentLine=6750318;
 //BA.debugLineNum = 6750318;BA.debugLine="lbldown.Text=Chr(0xE2C4)";
mostCurrent._lbldown.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe2c4))));
RDebugUtils.currentLine=6750319;
 //BA.debugLineNum = 6750319;BA.debugLine="lbldown.Typeface=Typeface.MATERIALICONS";
mostCurrent._lbldown.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
RDebugUtils.currentLine=6750320;
 //BA.debugLineNum = 6750320;BA.debugLine="lbldown.Gravity=Gravity.CENTER";
mostCurrent._lbldown.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=6750321;
 //BA.debugLineNum = 6750321;BA.debugLine="lbldown.TextColor=Colors.DarkGray";
mostCurrent._lbldown.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.DarkGray);
RDebugUtils.currentLine=6750322;
 //BA.debugLineNum = 6750322;BA.debugLine="lbldown.TextSize=20";
mostCurrent._lbldown.setTextSize((float) (20));
RDebugUtils.currentLine=6750323;
 //BA.debugLineNum = 6750323;BA.debugLine="ac.SetClickEffect(lbldown,False)";
_ac.SetClickEffect(mostCurrent.activityBA,(android.view.View)(mostCurrent._lbldown.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6750324;
 //BA.debugLineNum = 6750324;BA.debugLine="ScrollView1.Panel.AddView(lbldown,85%x,toptem";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._lbldown.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (85),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA));
RDebugUtils.currentLine=6750326;
 //BA.debugLineNum = 6750326;BA.debugLine="lbldur.Initialize(\"\")";
mostCurrent._lbldur.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=6750327;
 //BA.debugLineNum = 6750327;BA.debugLine="lbldur.Text=\"00:00\"";
mostCurrent._lbldur.setText(BA.ObjectToCharSequence("00:00"));
RDebugUtils.currentLine=6750328;
 //BA.debugLineNum = 6750328;BA.debugLine="lbldur.Typeface=C.irs";
mostCurrent._lbldur.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ .getObject()));
RDebugUtils.currentLine=6750329;
 //BA.debugLineNum = 6750329;BA.debugLine="lbldur.Gravity=Bit.Or(Gravity.LEFT,Gravity.BO";
mostCurrent._lbldur.setGravity(anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.LEFT,anywheresoftware.b4a.keywords.Common.Gravity.BOTTOM));
RDebugUtils.currentLine=6750330;
 //BA.debugLineNum = 6750330;BA.debugLine="lbldur.TextColor=Colors.DarkGray";
mostCurrent._lbldur.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.DarkGray);
RDebugUtils.currentLine=6750331;
 //BA.debugLineNum = 6750331;BA.debugLine="lbldur.TextSize=10";
mostCurrent._lbldur.setTextSize((float) (10));
RDebugUtils.currentLine=6750332;
 //BA.debugLineNum = 6750332;BA.debugLine="ScrollView1.Panel.AddView(lbldur,17.5%x,topte";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._lbldur.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (17.5),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (30),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA));
RDebugUtils.currentLine=6750334;
 //BA.debugLineNum = 6750334;BA.debugLine="lblpos.Initialize(\"\")";
mostCurrent._lblpos.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=6750335;
 //BA.debugLineNum = 6750335;BA.debugLine="lblpos.Text=\"00:00\"";
mostCurrent._lblpos.setText(BA.ObjectToCharSequence("00:00"));
RDebugUtils.currentLine=6750336;
 //BA.debugLineNum = 6750336;BA.debugLine="lblpos.Typeface=C.irs";
mostCurrent._lblpos.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ .getObject()));
RDebugUtils.currentLine=6750337;
 //BA.debugLineNum = 6750337;BA.debugLine="lblpos.Gravity=Bit.Or(Gravity.RIGHT,Gravity.B";
mostCurrent._lblpos.setGravity(anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT,anywheresoftware.b4a.keywords.Common.Gravity.BOTTOM));
RDebugUtils.currentLine=6750338;
 //BA.debugLineNum = 6750338;BA.debugLine="lblpos.TextColor=Colors.DarkGray";
mostCurrent._lblpos.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.DarkGray);
RDebugUtils.currentLine=6750339;
 //BA.debugLineNum = 6750339;BA.debugLine="lblpos.TextSize=10";
mostCurrent._lblpos.setTextSize((float) (10));
RDebugUtils.currentLine=6750340;
 //BA.debugLineNum = 6750340;BA.debugLine="ScrollView1.Panel.AddView(lblpos,52.5%x,topte";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._lblpos.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (52.5),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (30),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA));
RDebugUtils.currentLine=6750342;
 //BA.debugLineNum = 6750342;BA.debugLine="seekbar.Initialize(\"seekbar\")";
mostCurrent._seekbar.Initialize(mostCurrent.activityBA,"seekbar");
RDebugUtils.currentLine=6750343;
 //BA.debugLineNum = 6750343;BA.debugLine="ScrollView1.Panel.AddView(seekbar,15%x,toptem";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._seekbar.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA));
RDebugUtils.currentLine=6750344;
 //BA.debugLineNum = 6750344;BA.debugLine="Force_LtrSupported4View(seekbar)";
_force_ltrsupported4view((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._seekbar.getObject())));
RDebugUtils.currentLine=6750346;
 //BA.debugLineNum = 6750346;BA.debugLine="toptemp=toptemp+18%x";
_toptemp = (int) (_toptemp+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (18),mostCurrent.activityBA));
 };
 };
 }else {
RDebugUtils.currentLine=6750351;
 //BA.debugLineNum = 6750351;BA.debugLine="If h13(i).Length>2 Then";
if (_h13[_i].length()>2) { 
RDebugUtils.currentLine=6750353;
 //BA.debugLineNum = 6750353;BA.debugLine="Dim txt As String =  h13(i)";
_txt = _h13[_i];
RDebugUtils.currentLine=6750354;
 //BA.debugLineNum = 6750354;BA.debugLine="Dim lable As Label";
_lable = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=6750355;
 //BA.debugLineNum = 6750355;BA.debugLine="lable.Initialize(\"\")";
_lable.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=6750356;
 //BA.debugLineNum = 6750356;BA.debugLine="lable.Text=Convert_FA2EN(txt)";
_lable.setText(BA.ObjectToCharSequence(_convert_fa2en(_txt)));
RDebugUtils.currentLine=6750357;
 //BA.debugLineNum = 6750357;BA.debugLine="alltext=alltext&CRLF&Convert_FA2EN(txt)";
mostCurrent._alltext = mostCurrent._alltext+anywheresoftware.b4a.keywords.Common.CRLF+_convert_fa2en(_txt);
RDebugUtils.currentLine=6750358;
 //BA.debugLineNum = 6750358;BA.debugLine="lable.Typeface=C.irs";
_lable.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ .getObject()));
RDebugUtils.currentLine=6750359;
 //BA.debugLineNum = 6750359;BA.debugLine="lable.TextColor= Colors.Transparent";
_lable.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=6750360;
 //BA.debugLineNum = 6750360;BA.debugLine="lable.Padding=Array As Int (25dip,0,25dip,0)";
_lable.setPadding(new int[]{anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),(int) (0)});
RDebugUtils.currentLine=6750361;
 //BA.debugLineNum = 6750361;BA.debugLine="lable.TextSize=size";
_lable.setTextSize((float) (_size));
RDebugUtils.currentLine=6750362;
 //BA.debugLineNum = 6750362;BA.debugLine="lable.Gravity= Gravity.RIGHT";
_lable.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT);
RDebugUtils.currentLine=6750363;
 //BA.debugLineNum = 6750363;BA.debugLine="ScrollView1.Panel.AddView(lable,2%x,toptemp,96";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lable.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
RDebugUtils.currentLine=6750364;
 //BA.debugLineNum = 6750364;BA.debugLine="lable.Height=hlbl.LabelHeight(Convert_FA2EN(la";
_lable.setHeight((int) (mostCurrent._hlbl._labelheight(_convert_fa2en(_lable.getText()),_lable,mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ ,_size,anywheresoftware.b4a.keywords.Common.Gravity.RIGHT,(float) (1.2))));
RDebugUtils.currentLine=6750365;
 //BA.debugLineNum = 6750365;BA.debugLine="toptemp=toptemp+lable.Height";
_toptemp = (int) (_toptemp+_lable.getHeight());
RDebugUtils.currentLine=6750366;
 //BA.debugLineNum = 6750366;BA.debugLine="CallSubDelayed2( Me, \"Justify_Text\", lable )";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,page.getObject(),"Justify_Text",(Object)(_lable));
 };
 };
 }
};
RDebugUtils.currentLine=6750371;
 //BA.debugLineNum = 6750371;BA.debugLine="toolbar";
_toolbar();
RDebugUtils.currentLine=6750373;
 //BA.debugLineNum = 6750373;BA.debugLine="Pnlprb.Visible=False";
mostCurrent._pnlprb.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6750374;
 //BA.debugLineNum = 6750374;BA.debugLine="canshare=True";
_canshare = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=6750375;
 //BA.debugLineNum = 6750375;BA.debugLine="End Sub";
return "";
}
public static String  _getimage_path(String _val) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getimage_path", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "getimage_path", new Object[] {_val}));}
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _l = null;
boolean _find = false;
String _res = "";
RDebugUtils.currentLine=6946816;
 //BA.debugLineNum = 6946816;BA.debugLine="Public Sub GetImage_Path(val As String) As String";
RDebugUtils.currentLine=6946818;
 //BA.debugLineNum = 6946818;BA.debugLine="Dim l As Matcher";
_l = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
RDebugUtils.currentLine=6946819;
 //BA.debugLineNum = 6946819;BA.debugLine="l = Regex.Matcher(\"src\\s*=\\s*(.+?)\"\"\",val)";
_l = anywheresoftware.b4a.keywords.Common.Regex.Matcher("src\\s*=\\s*(.+?)\"",_val);
RDebugUtils.currentLine=6946821;
 //BA.debugLineNum = 6946821;BA.debugLine="Try";
try {RDebugUtils.currentLine=6946822;
 //BA.debugLineNum = 6946822;BA.debugLine="Dim find As Boolean";
_find = false;
RDebugUtils.currentLine=6946823;
 //BA.debugLineNum = 6946823;BA.debugLine="find = l.find";
_find = _l.Find();
RDebugUtils.currentLine=6946824;
 //BA.debugLineNum = 6946824;BA.debugLine="If find = False Then Return \"\"";
if (_find==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
RDebugUtils.currentLine=6946825;
 //BA.debugLineNum = 6946825;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=6946827;
 //BA.debugLineNum = 6946827;BA.debugLine="res = l.Group(1)";
_res = _l.Group((int) (1));
RDebugUtils.currentLine=6946828;
 //BA.debugLineNum = 6946828;BA.debugLine="res = res.SubString(1)";
_res = _res.substring((int) (1));
RDebugUtils.currentLine=6946829;
 //BA.debugLineNum = 6946829;BA.debugLine="Return res";
if (true) return _res;
 } 
       catch (Exception e12) {
			processBA.setLastException(e12);RDebugUtils.currentLine=6946831;
 //BA.debugLineNum = 6946831;BA.debugLine="Return \"\"";
if (true) return "";
 };
RDebugUtils.currentLine=6946834;
 //BA.debugLineNum = 6946834;BA.debugLine="End Sub";
return "";
}
public static String  _getmp4_path(String _val) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getmp4_path", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "getmp4_path", new Object[] {_val}));}
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _l = null;
boolean _find = false;
String _res = "";
RDebugUtils.currentLine=7077888;
 //BA.debugLineNum = 7077888;BA.debugLine="Public Sub Getmp4_Path(val As String) As String";
RDebugUtils.currentLine=7077890;
 //BA.debugLineNum = 7077890;BA.debugLine="Dim l As Matcher";
_l = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
RDebugUtils.currentLine=7077891;
 //BA.debugLineNum = 7077891;BA.debugLine="l = Regex.Matcher(\"mp4\\s*=\\s*(.+?)\"\"\",val)";
_l = anywheresoftware.b4a.keywords.Common.Regex.Matcher("mp4\\s*=\\s*(.+?)\"",_val);
RDebugUtils.currentLine=7077893;
 //BA.debugLineNum = 7077893;BA.debugLine="Try";
try {RDebugUtils.currentLine=7077894;
 //BA.debugLineNum = 7077894;BA.debugLine="Dim find As Boolean";
_find = false;
RDebugUtils.currentLine=7077895;
 //BA.debugLineNum = 7077895;BA.debugLine="find = l.find";
_find = _l.Find();
RDebugUtils.currentLine=7077896;
 //BA.debugLineNum = 7077896;BA.debugLine="If find = False Then Return \"\"";
if (_find==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
RDebugUtils.currentLine=7077897;
 //BA.debugLineNum = 7077897;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=7077899;
 //BA.debugLineNum = 7077899;BA.debugLine="res = l.Group(1)";
_res = _l.Group((int) (1));
RDebugUtils.currentLine=7077900;
 //BA.debugLineNum = 7077900;BA.debugLine="res = res.SubString(1)";
_res = _res.substring((int) (1));
RDebugUtils.currentLine=7077901;
 //BA.debugLineNum = 7077901;BA.debugLine="Return res";
if (true) return _res;
 } 
       catch (Exception e12) {
			processBA.setLastException(e12);RDebugUtils.currentLine=7077903;
 //BA.debugLineNum = 7077903;BA.debugLine="Return \"\"";
if (true) return "";
 };
RDebugUtils.currentLine=7077906;
 //BA.debugLineNum = 7077906;BA.debugLine="End Sub";
return "";
}
public static String  _getmp3_path(String _val) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getmp3_path", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "getmp3_path", new Object[] {_val}));}
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _l = null;
boolean _find = false;
String _res = "";
RDebugUtils.currentLine=7012352;
 //BA.debugLineNum = 7012352;BA.debugLine="Public Sub Getmp3_Path(val As String) As String";
RDebugUtils.currentLine=7012354;
 //BA.debugLineNum = 7012354;BA.debugLine="Dim l As Matcher";
_l = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
RDebugUtils.currentLine=7012355;
 //BA.debugLineNum = 7012355;BA.debugLine="l = Regex.Matcher(\"mp3\\s*=\\s*(.+?)\"\"\",val)";
_l = anywheresoftware.b4a.keywords.Common.Regex.Matcher("mp3\\s*=\\s*(.+?)\"",_val);
RDebugUtils.currentLine=7012357;
 //BA.debugLineNum = 7012357;BA.debugLine="Try";
try {RDebugUtils.currentLine=7012358;
 //BA.debugLineNum = 7012358;BA.debugLine="Dim find As Boolean";
_find = false;
RDebugUtils.currentLine=7012359;
 //BA.debugLineNum = 7012359;BA.debugLine="find = l.find";
_find = _l.Find();
RDebugUtils.currentLine=7012360;
 //BA.debugLineNum = 7012360;BA.debugLine="If find = False Then Return \"\"";
if (_find==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
RDebugUtils.currentLine=7012361;
 //BA.debugLineNum = 7012361;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=7012363;
 //BA.debugLineNum = 7012363;BA.debugLine="res = l.Group(1)";
_res = _l.Group((int) (1));
RDebugUtils.currentLine=7012364;
 //BA.debugLineNum = 7012364;BA.debugLine="res = res.SubString(1)";
_res = _res.substring((int) (1));
RDebugUtils.currentLine=7012365;
 //BA.debugLineNum = 7012365;BA.debugLine="Return res";
if (true) return _res;
 } 
       catch (Exception e12) {
			processBA.setLastException(e12);RDebugUtils.currentLine=7012367;
 //BA.debugLineNum = 7012367;BA.debugLine="Return \"\"";
if (true) return "";
 };
RDebugUtils.currentLine=7012370;
 //BA.debugLineNum = 7012370;BA.debugLine="End Sub";
return "";
}
public static String  _toolbar() throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "toolbar", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "toolbar", null));}
anywheresoftware.b4a.objects.PanelWrapper _pntool = null;
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
RDebugUtils.currentLine=6422528;
 //BA.debugLineNum = 6422528;BA.debugLine="Sub toolbar";
RDebugUtils.currentLine=6422529;
 //BA.debugLineNum = 6422529;BA.debugLine="ScrollView1.Panel.Height=toptemp+10%x";
mostCurrent._scrollview1.getPanel().setHeight((int) (_toptemp+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA)));
RDebugUtils.currentLine=6422530;
 //BA.debugLineNum = 6422530;BA.debugLine="pnlmatlab.Height=toptemp";
mostCurrent._pnlmatlab.setHeight(_toptemp);
RDebugUtils.currentLine=6422531;
 //BA.debugLineNum = 6422531;BA.debugLine="ACToolBarLight1.Title=Main.txtnewstitle";
mostCurrent._actoolbarlight1.setTitle(BA.ObjectToCharSequence(mostCurrent._main._txtnewstitle /*String*/ ));
RDebugUtils.currentLine=6422533;
 //BA.debugLineNum = 6422533;BA.debugLine="Dim Pntool As Panel = ACToolBarLight1";
_pntool = new anywheresoftware.b4a.objects.PanelWrapper();
_pntool.setObject((android.view.ViewGroup)(mostCurrent._actoolbarlight1.getObject()));
RDebugUtils.currentLine=6422534;
 //BA.debugLineNum = 6422534;BA.debugLine="For Each v As View In Pntool";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group5 = _pntool;
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_v.setObject((android.view.View)(group5.Get(index5)));
RDebugUtils.currentLine=6422535;
 //BA.debugLineNum = 6422535;BA.debugLine="If v Is Label Then";
if (_v.getObjectOrNull() instanceof android.widget.TextView) { 
RDebugUtils.currentLine=6422536;
 //BA.debugLineNum = 6422536;BA.debugLine="lbltoolbar = v";
mostCurrent._lbltoolbar.setObject((android.widget.TextView)(_v.getObject()));
RDebugUtils.currentLine=6422537;
 //BA.debugLineNum = 6422537;BA.debugLine="Select lbltoolbar.text";
switch (BA.switchObjectToInt(mostCurrent._lbltoolbar.getText(),mostCurrent._actoolbarlight1.getTitle())) {
case 0: {
RDebugUtils.currentLine=6422539;
 //BA.debugLineNum = 6422539;BA.debugLine="lbltoolbar.Typeface = C.irs";
mostCurrent._lbltoolbar.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ .getObject()));
RDebugUtils.currentLine=6422540;
 //BA.debugLineNum = 6422540;BA.debugLine="lbltoolbar.TextSize=15";
mostCurrent._lbltoolbar.setTextSize((float) (15));
RDebugUtils.currentLine=6422541;
 //BA.debugLineNum = 6422541;BA.debugLine="lbltoolbar.Padding = Array As Int (0, 4dip, 0";
mostCurrent._lbltoolbar.setPadding(new int[]{(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4)),(int) (0),(int) (0)});
RDebugUtils.currentLine=6422542;
 //BA.debugLineNum = 6422542;BA.debugLine="lbltoolbar.Color=Colors.Transparent";
mostCurrent._lbltoolbar.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=6422543;
 //BA.debugLineNum = 6422543;BA.debugLine="lbltoolbar.Height=56dip";
mostCurrent._lbltoolbar.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (56)));
 break; }
}
;
 };
 }
};
RDebugUtils.currentLine=6422548;
 //BA.debugLineNum = 6422548;BA.debugLine="End Sub";
return "";
}
public static String  _img_click() throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "img_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "img_click", null));}
anywheresoftware.b4a.objects.ImageViewWrapper _s = null;
RDebugUtils.currentLine=6619136;
 //BA.debugLineNum = 6619136;BA.debugLine="Sub img_Click";
RDebugUtils.currentLine=6619137;
 //BA.debugLineNum = 6619137;BA.debugLine="If canshare Then";
if (_canshare) { 
RDebugUtils.currentLine=6619138;
 //BA.debugLineNum = 6619138;BA.debugLine="Dim s As ImageView = Sender";
_s = new anywheresoftware.b4a.objects.ImageViewWrapper();
_s.setObject((android.widget.ImageView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=6619139;
 //BA.debugLineNum = 6619139;BA.debugLine="postimg=imglisnks.Get(s)";
_postimg = BA.ObjectToString(mostCurrent._imglisnks.Get((Object)(_s.getObject())));
 }else {
RDebugUtils.currentLine=6619142;
 //BA.debugLineNum = 6619142;BA.debugLine="ToastMessageShow(\"باز کردن عکس قبل از بارگزاری ص";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("باز کردن عکس قبل از بارگزاری صفحه امکان پذیر نمیباشد."),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=6619145;
 //BA.debugLineNum = 6619145;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.Map  _jsontomap(String _strjson) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jsontomap", false))
	 {return ((anywheresoftware.b4a.objects.collections.Map) Debug.delegate(mostCurrent.activityBA, "jsontomap", new Object[] {_strjson}));}
anywheresoftware.b4a.objects.collections.Map _jmap = null;
anywheresoftware.b4a.objects.collections.JSONParser _json = null;
RDebugUtils.currentLine=5505024;
 //BA.debugLineNum = 5505024;BA.debugLine="Sub JsonToMap(strJSON As String) As Map";
RDebugUtils.currentLine=5505027;
 //BA.debugLineNum = 5505027;BA.debugLine="Dim jMap As Map";
_jmap = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=5505028;
 //BA.debugLineNum = 5505028;BA.debugLine="jMap.Initialize";
_jmap.Initialize();
RDebugUtils.currentLine=5505029;
 //BA.debugLineNum = 5505029;BA.debugLine="Dim JSON As JSONParser";
_json = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=5505030;
 //BA.debugLineNum = 5505030;BA.debugLine="JSON.Initialize(strJSON)";
_json.Initialize(_strjson);
RDebugUtils.currentLine=5505031;
 //BA.debugLineNum = 5505031;BA.debugLine="jMap = JSON.NextObject";
_jmap = _json.NextObject();
RDebugUtils.currentLine=5505032;
 //BA.debugLineNum = 5505032;BA.debugLine="Return jMap";
if (true) return _jmap;
RDebugUtils.currentLine=5505033;
 //BA.debugLineNum = 5505033;BA.debugLine="End Sub";
return null;
}
public static String  _justify_text(anywheresoftware.b4a.objects.LabelWrapper _lable) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "justify_text", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "justify_text", new Object[] {_lable}));}
ir.TeamEight.Justify.teameightjustify _jjustify = null;
RDebugUtils.currentLine=5636096;
 //BA.debugLineNum = 5636096;BA.debugLine="Sub Justify_Text(lable As Label)";
RDebugUtils.currentLine=5636098;
 //BA.debugLineNum = 5636098;BA.debugLine="Private JJustify As TeamEightJustify";
_jjustify = new ir.TeamEight.Justify.teameightjustify();
RDebugUtils.currentLine=5636100;
 //BA.debugLineNum = 5636100;BA.debugLine="JJustify.Initialize";
_jjustify._initialize(processBA);
RDebugUtils.currentLine=5636101;
 //BA.debugLineNum = 5636101;BA.debugLine="lable.text = JJustify.JustifyByExtendWords(lable,";
_lable.setText(BA.ObjectToCharSequence(_jjustify._vv3((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_lable.getObject())),_lable.getText(),anywheresoftware.b4a.keywords.Common.False,(float) (.5),anywheresoftware.b4a.keywords.Common.False)));
RDebugUtils.currentLine=5636102;
 //BA.debugLineNum = 5636102;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
RDebugUtils.currentLine=5636105;
 //BA.debugLineNum = 5636105;BA.debugLine="If lable.TextColor = Colors.Transparent Then";
if (_lable.getTextColor()==anywheresoftware.b4a.keywords.Common.Colors.Transparent) { 
RDebugUtils.currentLine=5636106;
 //BA.debugLineNum = 5636106;BA.debugLine="lable.SetTextColorAnimated(250, Colors.Black)";
_lable.SetTextColorAnimated((int) (250),anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
RDebugUtils.currentLine=5636110;
 //BA.debugLineNum = 5636110;BA.debugLine="End Sub";
return "";
}
public static String  _label2_click() throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "label2_click", null));}
RDebugUtils.currentLine=5111808;
 //BA.debugLineNum = 5111808;BA.debugLine="Sub Label2_Click";
RDebugUtils.currentLine=5111809;
 //BA.debugLineNum = 5111809;BA.debugLine="Pnlprb.Visible=True";
mostCurrent._pnlprb.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5111811;
 //BA.debugLineNum = 5111811;BA.debugLine="Label2.Visible=False";
mostCurrent._label2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5111812;
 //BA.debugLineNum = 5111812;BA.debugLine="Label1.Visible=False";
mostCurrent._label1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5111814;
 //BA.debugLineNum = 5111814;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.CSBuilder  _menu_change2(String _onvan,int _color,anywheresoftware.b4a.keywords.constants.TypefaceWrapper _font) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "menu_change2", false))
	 {return ((anywheresoftware.b4a.objects.CSBuilder) Debug.delegate(mostCurrent.activityBA, "menu_change2", new Object[] {_onvan,_color,_font}));}
anywheresoftware.b4a.objects.CSBuilder _cs = null;
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Sub menu_Change2(onvan As String,color As Int,font";
RDebugUtils.currentLine=5832705;
 //BA.debugLineNum = 5832705;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
RDebugUtils.currentLine=5832706;
 //BA.debugLineNum = 5832706;BA.debugLine="cs.Initialize.Color(color).Typeface(font).Alignme";
_cs.Initialize().Color(_color).Typeface((android.graphics.Typeface)(_font.getObject())).Alignment(BA.getEnumFromString(android.text.Layout.Alignment.class,"ALIGN_CENTER")).Append(BA.ObjectToCharSequence(_onvan)).PopAll();
RDebugUtils.currentLine=5832707;
 //BA.debugLineNum = 5832707;BA.debugLine="Return cs";
if (true) return _cs;
RDebugUtils.currentLine=5832708;
 //BA.debugLineNum = 5832708;BA.debugLine="End Sub";
return null;
}
public static String  _pagerlist_onerror(String _error) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pagerlist_onerror", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pagerlist_onerror", new Object[] {_error}));}
RDebugUtils.currentLine=5439488;
 //BA.debugLineNum = 5439488;BA.debugLine="Sub pagerlist_OnError (Error As String)";
RDebugUtils.currentLine=5439490;
 //BA.debugLineNum = 5439490;BA.debugLine="Pnlprb.Visible=False";
mostCurrent._pnlprb.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5439491;
 //BA.debugLineNum = 5439491;BA.debugLine="Label1.Visible=True";
mostCurrent._label1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5439492;
 //BA.debugLineNum = 5439492;BA.debugLine="Label2.Visible=True";
mostCurrent._label2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5439493;
 //BA.debugLineNum = 5439493;BA.debugLine="End Sub";
return "";
}
public static String  _scrollview1_scrollchanged(int _position) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "scrollview1_scrollchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "scrollview1_scrollchanged", new Object[] {_position}));}
int _x = 0;
anywheresoftware.b4a.objects.drawable.GradientDrawable _gradient1 = null;
int[] _clrs = null;
RDebugUtils.currentLine=5767168;
 //BA.debugLineNum = 5767168;BA.debugLine="Sub ScrollView1_ScrollChanged(Position As Int)";
RDebugUtils.currentLine=5767169;
 //BA.debugLineNum = 5767169;BA.debugLine="Try";
try {RDebugUtils.currentLine=5767170;
 //BA.debugLineNum = 5767170;BA.debugLine="Dim x As Int";
_x = 0;
RDebugUtils.currentLine=5767171;
 //BA.debugLineNum = 5767171;BA.debugLine="If Position>0 And Position<500 Then";
if (_position>0 && _position<500) { 
RDebugUtils.currentLine=5767172;
 //BA.debugLineNum = 5767172;BA.debugLine="x=Position";
_x = _position;
RDebugUtils.currentLine=5767173;
 //BA.debugLineNum = 5767173;BA.debugLine="Paneldark.Color=Colors.ARGB(x/2,0,0,0)";
mostCurrent._paneldark.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (_x/(double)2),(int) (0),(int) (0),(int) (0)));
 }else 
{RDebugUtils.currentLine=5767174;
 //BA.debugLineNum = 5767174;BA.debugLine="Else if Position<3 Then";
if (_position<3) { 
RDebugUtils.currentLine=5767175;
 //BA.debugLineNum = 5767175;BA.debugLine="Paneldark.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._paneldark.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
 }else 
{RDebugUtils.currentLine=5767176;
 //BA.debugLineNum = 5767176;BA.debugLine="else if  Position>500 Then";
if (_position>500) { 
RDebugUtils.currentLine=5767177;
 //BA.debugLineNum = 5767177;BA.debugLine="Paneldark.Color=Colors.ARGB(255,0,0,0)";
mostCurrent._paneldark.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (0),(int) (0),(int) (0)));
 }}}
;
RDebugUtils.currentLine=5767180;
 //BA.debugLineNum = 5767180;BA.debugLine="If Position>0 And Position<256 Then";
if (_position>0 && _position<256) { 
RDebugUtils.currentLine=5767181;
 //BA.debugLineNum = 5767181;BA.debugLine="x=Position";
_x = _position;
RDebugUtils.currentLine=5767183;
 //BA.debugLineNum = 5767183;BA.debugLine="Dim Gradient1 As GradientDrawable";
_gradient1 = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=5767184;
 //BA.debugLineNum = 5767184;BA.debugLine="Dim Clrs(2) As Int";
_clrs = new int[(int) (2)];
;
RDebugUtils.currentLine=5767185;
 //BA.debugLineNum = 5767185;BA.debugLine="If Position<156 Then";
if (_position<156) { 
RDebugUtils.currentLine=5767186;
 //BA.debugLineNum = 5767186;BA.debugLine="Clrs(0) =Colors.ARGB(100+x,0,87,0)";
_clrs[(int) (0)] = anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (100+_x),(int) (0),(int) (87),(int) (0));
RDebugUtils.currentLine=5767187;
 //BA.debugLineNum = 5767187;BA.debugLine="toolbartemp.Color=Colors.ARGB(100+x,0,87,0)";
mostCurrent._toolbartemp.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (100+_x),(int) (0),(int) (87),(int) (0)));
 }else {
RDebugUtils.currentLine=5767189;
 //BA.debugLineNum = 5767189;BA.debugLine="Clrs(0) =0xFF005700";
_clrs[(int) (0)] = (int) (0xff005700);
RDebugUtils.currentLine=5767190;
 //BA.debugLineNum = 5767190;BA.debugLine="toolbartemp.Color=0xFF005700";
mostCurrent._toolbartemp.setColor((int) (0xff005700));
 };
RDebugUtils.currentLine=5767193;
 //BA.debugLineNum = 5767193;BA.debugLine="Clrs(1) = Colors.ARGB(x,0,87,0)";
_clrs[(int) (1)] = anywheresoftware.b4a.keywords.Common.Colors.ARGB(_x,(int) (0),(int) (87),(int) (0));
RDebugUtils.currentLine=5767194;
 //BA.debugLineNum = 5767194;BA.debugLine="Gradient1.Initialize(\"TOP_BOTTOM\", Clrs)";
_gradient1.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clrs);
RDebugUtils.currentLine=5767195;
 //BA.debugLineNum = 5767195;BA.debugLine="ACToolBarLight1.Background=Gradient1";
mostCurrent._actoolbarlight1.setBackground((android.graphics.drawable.Drawable)(_gradient1.getObject()));
RDebugUtils.currentLine=5767200;
 //BA.debugLineNum = 5767200;BA.debugLine="ACToolBarLight1.TitleTextColor=Colors.ARGB(x,25";
mostCurrent._actoolbarlight1.setTitleTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB(_x,(int) (255),(int) (255),(int) (255)));
 }else 
{RDebugUtils.currentLine=5767201;
 //BA.debugLineNum = 5767201;BA.debugLine="Else if Position<3 Then";
if (_position<3) { 
RDebugUtils.currentLine=5767202;
 //BA.debugLineNum = 5767202;BA.debugLine="Dim Gradient1 As GradientDrawable";
_gradient1 = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=5767203;
 //BA.debugLineNum = 5767203;BA.debugLine="Dim Clrs(2) As Int";
_clrs = new int[(int) (2)];
;
RDebugUtils.currentLine=5767204;
 //BA.debugLineNum = 5767204;BA.debugLine="Clrs(0) =Colors.ARGB(100,0,39,0)";
_clrs[(int) (0)] = anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (100),(int) (0),(int) (39),(int) (0));
RDebugUtils.currentLine=5767205;
 //BA.debugLineNum = 5767205;BA.debugLine="Clrs(1) = Colors.Transparent";
_clrs[(int) (1)] = anywheresoftware.b4a.keywords.Common.Colors.Transparent;
RDebugUtils.currentLine=5767206;
 //BA.debugLineNum = 5767206;BA.debugLine="Gradient1.Initialize(\"TOP_BOTTOM\", Clrs)";
_gradient1.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clrs);
RDebugUtils.currentLine=5767207;
 //BA.debugLineNum = 5767207;BA.debugLine="ACToolBarLight1.Background=Gradient1";
mostCurrent._actoolbarlight1.setBackground((android.graphics.drawable.Drawable)(_gradient1.getObject()));
RDebugUtils.currentLine=5767208;
 //BA.debugLineNum = 5767208;BA.debugLine="toolbartemp.Color=Colors.ARGB(100,0,39,0)";
mostCurrent._toolbartemp.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (100),(int) (0),(int) (39),(int) (0)));
RDebugUtils.currentLine=5767209;
 //BA.debugLineNum = 5767209;BA.debugLine="ACToolBarLight1.TitleTextColor=Colors.ARGB(0,25";
mostCurrent._actoolbarlight1.setTitleTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (255),(int) (255),(int) (255)));
 }else 
{RDebugUtils.currentLine=5767210;
 //BA.debugLineNum = 5767210;BA.debugLine="else if  Position>500 Then";
if (_position>500) { 
RDebugUtils.currentLine=5767212;
 //BA.debugLineNum = 5767212;BA.debugLine="Dim Gradient1 As GradientDrawable";
_gradient1 = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=5767213;
 //BA.debugLineNum = 5767213;BA.debugLine="Dim Clrs(2) As Int";
_clrs = new int[(int) (2)];
;
RDebugUtils.currentLine=5767214;
 //BA.debugLineNum = 5767214;BA.debugLine="Clrs(0) =0xFF005700";
_clrs[(int) (0)] = (int) (0xff005700);
RDebugUtils.currentLine=5767215;
 //BA.debugLineNum = 5767215;BA.debugLine="Clrs(1) = 0xFF005700";
_clrs[(int) (1)] = (int) (0xff005700);
RDebugUtils.currentLine=5767216;
 //BA.debugLineNum = 5767216;BA.debugLine="Gradient1.Initialize(\"TOP_BOTTOM\", Clrs)";
_gradient1.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clrs);
RDebugUtils.currentLine=5767217;
 //BA.debugLineNum = 5767217;BA.debugLine="ACToolBarLight1.Background=Gradient1";
mostCurrent._actoolbarlight1.setBackground((android.graphics.drawable.Drawable)(_gradient1.getObject()));
RDebugUtils.currentLine=5767218;
 //BA.debugLineNum = 5767218;BA.debugLine="toolbartemp.Color=0xFF005700";
mostCurrent._toolbartemp.setColor((int) (0xff005700));
RDebugUtils.currentLine=5767220;
 //BA.debugLineNum = 5767220;BA.debugLine="ACToolBarLight1.TitleTextColor=Colors.ARGB(255,";
mostCurrent._actoolbarlight1.setTitleTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (255),(int) (255),(int) (255)));
RDebugUtils.currentLine=5767221;
 //BA.debugLineNum = 5767221;BA.debugLine="lbltoolbar.Padding = Array As Int (0, 10dip, 0,";
mostCurrent._lbltoolbar.setPadding(new int[]{(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (0),(int) (0)});
 }}}
;
RDebugUtils.currentLine=5767223;
 //BA.debugLineNum = 5767223;BA.debugLine="Try";
try {RDebugUtils.currentLine=5767224;
 //BA.debugLineNum = 5767224;BA.debugLine="If 56dip+((Position/3)*-1)>=10dip Then";
if (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (56))+((_position/(double)3)*-1)>=anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))) { 
RDebugUtils.currentLine=5767225;
 //BA.debugLineNum = 5767225;BA.debugLine="lbltoolbar.Padding = Array As Int (0, 56dip+((";
mostCurrent._lbltoolbar.setPadding(new int[]{(int) (0),(int) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (56))+((_position/(double)3)*-1)),(int) (0),(int) (0)});
 };
 } 
       catch (Exception e51) {
			processBA.setLastException(e51); };
RDebugUtils.currentLine=5767232;
 //BA.debugLineNum = 5767232;BA.debugLine="Img.Top=(Position/2)*-1";
mostCurrent._img.setTop((int) ((_position/(double)2)*-1));
 } 
       catch (Exception e54) {
			processBA.setLastException(e54); };
RDebugUtils.currentLine=5767239;
 //BA.debugLineNum = 5767239;BA.debugLine="End Sub";
return "";
}
public static String  _setalllabel() throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "setalllabel", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "setalllabel", null));}
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
String[] _h13 = null;
String _hhh = "";
int _m = 0;
RDebugUtils.currentLine=6488064;
 //BA.debugLineNum = 6488064;BA.debugLine="Sub SetAllLabel";
RDebugUtils.currentLine=6488065;
 //BA.debugLineNum = 6488065;BA.debugLine="Try";
try {RDebugUtils.currentLine=6488066;
 //BA.debugLineNum = 6488066;BA.debugLine="For Each v As View In Activity.GetAllViewsRecurs";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group2 = mostCurrent._activity.GetAllViewsRecursive();
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_v.setObject((android.view.View)(group2.Get(index2)));
RDebugUtils.currentLine=6488067;
 //BA.debugLineNum = 6488067;BA.debugLine="If GetType(v) = \"android.widget.TextView\" Then";
if ((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("android.widget.TextView")) { 
RDebugUtils.currentLine=6488068;
 //BA.debugLineNum = 6488068;BA.debugLine="Dim lbl As Label = v";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl.setObject((android.widget.TextView)(_v.getObject()));
RDebugUtils.currentLine=6488069;
 //BA.debugLineNum = 6488069;BA.debugLine="Dim h13() As String=Regex.Split(CRLF,lbl.Text)";
_h13 = anywheresoftware.b4a.keywords.Common.Regex.Split(anywheresoftware.b4a.keywords.Common.CRLF,_lbl.getText());
RDebugUtils.currentLine=6488070;
 //BA.debugLineNum = 6488070;BA.debugLine="Dim hhh As String";
_hhh = "";
RDebugUtils.currentLine=6488071;
 //BA.debugLineNum = 6488071;BA.debugLine="For m = 0 To h13.Length-1";
{
final int step7 = 1;
final int limit7 = (int) (_h13.length-1);
_m = (int) (0) ;
for (;_m <= limit7 ;_m = _m + step7 ) {
RDebugUtils.currentLine=6488072;
 //BA.debugLineNum = 6488072;BA.debugLine="If h13(m).Contains(\"بیتوته\") Or h13(m).Contai";
if (_h13[_m].contains("بیتوته") || _h13[_m].contains("منبع") || (_h13[_m]).equals("") || (_h13[_m]).equals(" ")) { 
 }else {
RDebugUtils.currentLine=6488074;
 //BA.debugLineNum = 6488074;BA.debugLine="hhh=hhh+h13(m)";
_hhh = BA.NumberToString((double)(Double.parseDouble(_hhh))+(double)(Double.parseDouble(_h13[_m])));
 };
 }
};
RDebugUtils.currentLine=6488077;
 //BA.debugLineNum = 6488077;BA.debugLine="lbl.Text=hhh";
_lbl.setText(BA.ObjectToCharSequence(_hhh));
 };
 }
};
 } 
       catch (Exception e17) {
			processBA.setLastException(e17); };
RDebugUtils.currentLine=6488085;
 //BA.debugLineNum = 6488085;BA.debugLine="End Sub";
return "";
}
public static String  _settextshadow(anywheresoftware.b4a.objects.ConcreteViewWrapper _pview,float _pradius,float _pdx,float _pdy,int _pcolor) throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "settextshadow", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "settextshadow", new Object[] {_pview,_pradius,_pdx,_pdy,_pcolor}));}
anywheresoftware.b4a.agraham.reflection.Reflection _ref = null;
RDebugUtils.currentLine=7208960;
 //BA.debugLineNum = 7208960;BA.debugLine="Sub SetTextShadow(pView As View, pRadius As Float,";
RDebugUtils.currentLine=7208961;
 //BA.debugLineNum = 7208961;BA.debugLine="Dim ref As Reflector";
_ref = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=7208963;
 //BA.debugLineNum = 7208963;BA.debugLine="ref.Target = pView";
_ref.Target = (Object)(_pview.getObject());
RDebugUtils.currentLine=7208964;
 //BA.debugLineNum = 7208964;BA.debugLine="ref.RunMethod4(\"setShadowLayer\", Array As Object(";
_ref.RunMethod4("setShadowLayer",new Object[]{(Object)(_pradius),(Object)(_pdx),(Object)(_pdy),(Object)(_pcolor)},new String[]{"java.lang.float","java.lang.float","java.lang.float","java.lang.int"});
RDebugUtils.currentLine=7208965;
 //BA.debugLineNum = 7208965;BA.debugLine="End Sub";
return "";
}
public static String  _share_click() throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "share_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "share_click", null));}
anywheresoftware.b4a.ariagplib.ARIAlib _aria = null;
RDebugUtils.currentLine=6160384;
 //BA.debugLineNum = 6160384;BA.debugLine="Sub share_Click";
RDebugUtils.currentLine=6160385;
 //BA.debugLineNum = 6160385;BA.debugLine="Dim Aria As AriaLib";
_aria = new anywheresoftware.b4a.ariagplib.ARIAlib();
RDebugUtils.currentLine=6160390;
 //BA.debugLineNum = 6160390;BA.debugLine="StartActivity( Aria.ShareText(Main.txtnewstitle&C";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_aria.ShareText(mostCurrent._main._txtnewstitle /*String*/ +anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._alltext+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"برگرفته از اپلیکیشن هواداری ؛"+anywheresoftware.b4a.keywords.Common.CRLF+"https://cafebazaar.ir/app/"+anywheresoftware.b4a.keywords.Common.Application.getPackageName()+"/?l=fa","اشتراک گذاری با ؛")));
RDebugUtils.currentLine=6160394;
 //BA.debugLineNum = 6160394;BA.debugLine="End Sub";
return "";
}
public static String  _showbigpik() throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "showbigpik", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "showbigpik", null));}
RDebugUtils.currentLine=5046272;
 //BA.debugLineNum = 5046272;BA.debugLine="Sub showbigpik";
RDebugUtils.currentLine=5046274;
 //BA.debugLineNum = 5046274;BA.debugLine="End Sub";
return "";
}
public static void  _zoom_in_click() throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "zoom_in_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "zoom_in_click", null); return;}
ResumableSub_zoom_in_Click rsub = new ResumableSub_zoom_in_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_zoom_in_Click extends BA.ResumableSub {
public ResumableSub_zoom_in_Click(b4a.example.page parent) {
this.parent = parent;
}
b4a.example.page parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="page";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
RDebugUtils.currentLine=6029313;
 //BA.debugLineNum = 6029313;BA.debugLine="fsize=fsize+2";
parent._fsize = (int) (parent._fsize+2);
RDebugUtils.currentLine=6029314;
 //BA.debugLineNum = 6029314;BA.debugLine="File.WriteString(File.DirInternal,\"fsize\",fsize)";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"fsize",BA.NumberToString(parent._fsize));
RDebugUtils.currentLine=6029315;
 //BA.debugLineNum = 6029315;BA.debugLine="Sleep(0)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "page", "zoom_in_click"),(int) (0));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
RDebugUtils.currentLine=6029317;
 //BA.debugLineNum = 6029317;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
RDebugUtils.currentLine=6029318;
 //BA.debugLineNum = 6029318;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _zoom_out_click() throws Exception{
RDebugUtils.currentModule="page";
if (Debug.shouldDelegate(mostCurrent.activityBA, "zoom_out_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "zoom_out_click", null); return;}
ResumableSub_zoom_out_Click rsub = new ResumableSub_zoom_out_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_zoom_out_Click extends BA.ResumableSub {
public ResumableSub_zoom_out_Click(b4a.example.page parent) {
this.parent = parent;
}
b4a.example.page parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="page";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
RDebugUtils.currentLine=6094849;
 //BA.debugLineNum = 6094849;BA.debugLine="fsize=fsize-2";
parent._fsize = (int) (parent._fsize-2);
RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="File.WriteString(File.DirInternal,\"fsize\",fsize)";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"fsize",BA.NumberToString(parent._fsize));
RDebugUtils.currentLine=6094851;
 //BA.debugLineNum = 6094851;BA.debugLine="Sleep(0)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "page", "zoom_out_click"),(int) (0));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
RDebugUtils.currentLine=6094853;
 //BA.debugLineNum = 6094853;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
RDebugUtils.currentLine=6094854;
 //BA.debugLineNum = 6094854;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
    public static boolean isRTL() {
        return isRTL(Locale.getDefault());
    }
    public static boolean isRTL(Locale locale) {
        final int directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
        return directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT ||
                directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC;
    }
}