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

public class page extends android.support.v7.app.AppCompatActivity implements B4AActivity{
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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.page");
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
public ir.aminrezaei.arretrofit.ARRetrofit _retrofit = null;
public ir.aminrezaei.arretrofit.ARCall _call = null;
public ir.aminrezaei.arretrofit.ARFileClient _downloader = null;
public b4a.example.main _main = null;
public b4a.example.act_tip _act_tip = null;
public b4a.example.login _login = null;
public b4a.example.verify _verify = null;
public b4a.example.home _home = null;
public b4a.example.c _c = null;
public b4a.example.starter _starter = null;
public b4a.example.finger _finger = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.phone.Phone _sdk = null;
de.amberhome.objects.appcompat.AppCompatBase _a = null;
anywheresoftware.b4a.objects.drawable.GradientDrawable _gradient1 = null;
int[] _clrs = null;
anywheresoftware.b4a.object.XmlLayoutBuilder _xml = null;
anywheresoftware.b4a.objects.ImageViewWrapper _imgtemp = null;
anywheresoftware.b4a.agraham.richstring.RichStringBuilder.RichString _ri = null;
 //BA.debugLineNum = 79;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 80;BA.debugLine="If File.Exists(File.DirInternal,\"fsize\") = False";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"fsize")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 81;BA.debugLine="File.WriteString(File.DirInternal,\"fsize\",\"14\")";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"fsize","14");
 //BA.debugLineNum = 82;BA.debugLine="fsize=14";
_fsize = (int) (14);
 }else {
 //BA.debugLineNum = 84;BA.debugLine="fsize=File.ReadString(File.DirInternal,\"fsize\")";
_fsize = (int)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"fsize")));
 };
 //BA.debugLineNum = 87;BA.debugLine="isdowned=False";
_isdowned = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 88;BA.debugLine="videolink=\"\"";
_videolink = "";
 //BA.debugLineNum = 90;BA.debugLine="Activity.LoadLayout(\"matlab1\")";
mostCurrent._activity.LoadLayout("matlab1",mostCurrent.activityBA);
 //BA.debugLineNum = 93;BA.debugLine="ScrollView1.Panel.LoadLayout(\"matlab2\")";
mostCurrent._scrollview1.getPanel().LoadLayout("matlab2",mostCurrent.activityBA);
 //BA.debugLineNum = 95;BA.debugLine="Dim sdk As Phone";
_sdk = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 97;BA.debugLine="If sdk.SdkVersion >=19 Then";
if (_sdk.getSdkVersion()>=19) { 
 //BA.debugLineNum = 98;BA.debugLine="Dim a As AppCompat";
_a = new de.amberhome.objects.appcompat.AppCompatBase();
 //BA.debugLineNum = 99;BA.debugLine="ACToolBarLight1.Top=a.GetStatusBarHeight";
mostCurrent._actoolbarlight1.setTop(_a.GetStatusBarHeight(mostCurrent.activityBA));
 //BA.debugLineNum = 100;BA.debugLine="toolbartemp.Height=a.GetStatusBarHeight";
mostCurrent._toolbartemp.setHeight(_a.GetStatusBarHeight(mostCurrent.activityBA));
 //BA.debugLineNum = 101;BA.debugLine="toolbartemp.Top=0";
mostCurrent._toolbartemp.setTop((int) (0));
 //BA.debugLineNum = 102;BA.debugLine="toolbartemp.Color=Colors.ARGB(100,0,39,0)";
mostCurrent._toolbartemp.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (100),(int) (0),(int) (39),(int) (0)));
 };
 //BA.debugLineNum = 106;BA.debugLine="Dim Gradient1 As GradientDrawable";
_gradient1 = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
 //BA.debugLineNum = 107;BA.debugLine="Dim Clrs(2) As Int";
_clrs = new int[(int) (2)];
;
 //BA.debugLineNum = 108;BA.debugLine="Clrs(0) =Colors.ARGB(100,0,39,0)";
_clrs[(int) (0)] = anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (100),(int) (0),(int) (39),(int) (0));
 //BA.debugLineNum = 109;BA.debugLine="Clrs(1) = Colors.Transparent";
_clrs[(int) (1)] = anywheresoftware.b4a.keywords.Common.Colors.Transparent;
 //BA.debugLineNum = 110;BA.debugLine="Gradient1.Initialize(\"TOP_BOTTOM\", Clrs)";
_gradient1.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clrs);
 //BA.debugLineNum = 112;BA.debugLine="ACToolBarLight1.Background=Gradient1";
mostCurrent._actoolbarlight1.setBackground((android.graphics.drawable.Drawable)(_gradient1.getObject()));
 //BA.debugLineNum = 113;BA.debugLine="ACToolBarLight1.Elevation=5dip";
mostCurrent._actoolbarlight1.setElevation((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))));
 //BA.debugLineNum = 114;BA.debugLine="Dim xml As XmlLayoutBuilder";
_xml = new anywheresoftware.b4a.object.XmlLayoutBuilder();
 //BA.debugLineNum = 115;BA.debugLine="ACToolBarLight1.NavigationIconDrawable=xml.GetDra";
mostCurrent._actoolbarlight1.setNavigationIconDrawable(_xml.GetDrawable("baseline_arrow_forward_white_24"));
 //BA.debugLineNum = 116;BA.debugLine="ACToolBarLight1.InitMenuListener";
mostCurrent._actoolbarlight1.InitMenuListener();
 //BA.debugLineNum = 117;BA.debugLine="ACToolBarLight1.TitleTextColor=Colors.Transparent";
mostCurrent._actoolbarlight1.setTitleTextColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
 //BA.debugLineNum = 118;BA.debugLine="ACToolBarLight1.Title=Main.txtnewstitle";
mostCurrent._actoolbarlight1.setTitle(BA.ObjectToCharSequence(mostCurrent._main._txtnewstitle));
 //BA.debugLineNum = 121;BA.debugLine="add2toolbar_sub";
_add2toolbar_sub();
 //BA.debugLineNum = 123;BA.debugLine="Img.Tag=Null";
mostCurrent._img.setTag(anywheresoftware.b4a.keywords.Common.Null);
 //BA.debugLineNum = 124;BA.debugLine="Img.Height=Img.Height+1%x";
mostCurrent._img.setHeight((int) (mostCurrent._img.getHeight()+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA)));
 //BA.debugLineNum = 125;BA.debugLine="firstimg=\"\"'Main.matlabimg313";
mostCurrent._firstimg = "";
 //BA.debugLineNum = 127;BA.debugLine="Img.Color=Colors.Transparent";
mostCurrent._img.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
 //BA.debugLineNum = 130;BA.debugLine="Glide.Load(\"http\",Main.picnew).CenterCrop.Into(Im";
mostCurrent._glide.Load(mostCurrent.activityBA,"http",mostCurrent._main._picnew).CenterCrop().Into(mostCurrent._img);
 //BA.debugLineNum = 133;BA.debugLine="Dim imgtemp As ImageView";
_imgtemp = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 134;BA.debugLine="imgtemp.Initialize(\"img\")";
_imgtemp.Initialize(mostCurrent.activityBA,"img");
 //BA.debugLineNum = 135;BA.debugLine="ScrollView1.Panel.AddView(imgtemp,0,0,100%x,Img.H";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_imgtemp.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),(int) (mostCurrent._img.getHeight()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA)));
 //BA.debugLineNum = 138;BA.debugLine="imglisnks.Initialize";
mostCurrent._imglisnks.Initialize();
 //BA.debugLineNum = 141;BA.debugLine="addtitle_sub(Main.txtnewstitle,\"\")";
_addtitle_sub(mostCurrent._main._txtnewstitle,"");
 //BA.debugLineNum = 142;BA.debugLine="retrofit.InitializeProgress(\"http://google.com/\",";
mostCurrent._retrofit.InitializeProgress(processBA,"http://google.com/","retrofit");
 //BA.debugLineNum = 143;BA.debugLine="downloader.Initialize(retrofit)";
mostCurrent._downloader.Initialize((retrofit2.Retrofit)(mostCurrent._retrofit.getObject()));
 //BA.debugLineNum = 145;BA.debugLine="call = downloader.getFile(\"http://havadari.iquizl";
mostCurrent._call.setObject((retrofit2.Call)(mostCurrent._downloader.getFile("http://havadari.iquizland.ir/api/api.php?request=GetSingleNews&news_id="+mostCurrent._main._newsid)));
 //BA.debugLineNum = 146;BA.debugLine="retrofit.enqueueCall(call,downloader.getFileCallb";
mostCurrent._retrofit.enqueueCall((retrofit2.Call)(mostCurrent._call.getObject()),mostCurrent._downloader.getFileCallback(processBA,"retrofits",(Object)("getnews")));
 //BA.debugLineNum = 150;BA.debugLine="Disable_ScroolbarH(ScrollView1)";
_disable_scroolbarh(mostCurrent._scrollview1);
 //BA.debugLineNum = 151;BA.debugLine="Force_LtrSupported4View(ProgressBar1)";
_force_ltrsupported4view((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._progressbar1.getObject())));
 //BA.debugLineNum = 154;BA.debugLine="set_Ripple(flot2)";
_set_ripple(mostCurrent._flot2);
 //BA.debugLineNum = 155;BA.debugLine="set_Ripple(flot4)";
_set_ripple(mostCurrent._flot4);
 //BA.debugLineNum = 156;BA.debugLine="flot4.Visible=False";
mostCurrent._flot4.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 157;BA.debugLine="flot3.Visible=False";
mostCurrent._flot3.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 158;BA.debugLine="Dim ri As RichString";
_ri = new anywheresoftware.b4a.agraham.richstring.RichStringBuilder.RichString();
 //BA.debugLineNum = 159;BA.debugLine="ri.Initialize(Label2.Text)";
_ri.Initialize(BA.ObjectToCharSequence(mostCurrent._label2.getText()));
 //BA.debugLineNum = 160;BA.debugLine="Label2.Text=ri.Color(0xFFBE1043,39,45)";
mostCurrent._label2.setText(BA.ObjectToCharSequence(_ri.Color((int) (0xffbe1043),(int) (39),(int) (45)).getObject()));
 //BA.debugLineNum = 163;BA.debugLine="bring_Up(flot3)";
_bring_up((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._flot3.getObject())));
 //BA.debugLineNum = 169;BA.debugLine="flot.Visible=False";
mostCurrent._flot.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 170;BA.debugLine="flot2.Visible=False";
mostCurrent._flot2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 171;BA.debugLine="flot3.Visible=False";
mostCurrent._flot3.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 172;BA.debugLine="flot4.Visible=False";
mostCurrent._flot4.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 174;BA.debugLine="c.Force_RtlSupported4View(ACToolBarLight1)";
mostCurrent._c._force_rtlsupported4view(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._actoolbarlight1.getObject())));
 //BA.debugLineNum = 175;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 396;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 398;BA.debugLine="Try";
try { //BA.debugLineNum = 400;BA.debugLine="ispus=False";
_ispus = anywheresoftware.b4a.keywords.Common.False;
 } 
       catch (Exception e4) {
			processBA.setLastException(e4); };
 //BA.debugLineNum = 404;BA.debugLine="Try";
try { //BA.debugLineNum = 405;BA.debugLine="mpo.Release";
mostCurrent._mpo.Release();
 } 
       catch (Exception e8) {
			processBA.setLastException(e8); };
 //BA.debugLineNum = 409;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 214;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
return "";
}
public static String  _actoolbarlight1_navigationitemclick() throws Exception{
 //BA.debugLineNum = 74;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
 //BA.debugLineNum = 75;BA.debugLine="StartActivity(finger)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._finger.getObject()));
 //BA.debugLineNum = 77;BA.debugLine="End Sub";
return "";
}
public static String  _add2toolbar_sub() throws Exception{
anywheresoftware.b4a.object.XmlLayoutBuilder _xml = null;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _bh = null;
 //BA.debugLineNum = 494;BA.debugLine="Sub add2toolbar_sub";
 //BA.debugLineNum = 495;BA.debugLine="Dim xml As XmlLayoutBuilder";
_xml = new anywheresoftware.b4a.object.XmlLayoutBuilder();
 //BA.debugLineNum = 498;BA.debugLine="Dim bh = xml.GetDrawable(\"baseline_share_white_24";
_bh = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
_bh.setObject((android.graphics.drawable.BitmapDrawable)(_xml.GetDrawable("baseline_share_white_24")));
 //BA.debugLineNum = 499;BA.debugLine="Activity.AddMenuItem3(menu_Change(\"اشتراک گذاری\",";
mostCurrent._activity.AddMenuItem3(BA.ObjectToCharSequence(_menu_change("اشتراک گذاری",anywheresoftware.b4a.keywords.Common.Colors.Black,mostCurrent._c._irs).getObject()),"share",_bh.getBitmap(),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 507;BA.debugLine="End Sub";
return "";
}
public static String  _addtitle_sub(String _title,String _matn) throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lable = null;
wir.hitex.recycler.Hitex_Utils _h = null;
 //BA.debugLineNum = 339;BA.debugLine="Sub addtitle_sub(title As String , matn As String)";
 //BA.debugLineNum = 340;BA.debugLine="If titletemp=False Then";
if (_titletemp==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 341;BA.debugLine="Dim lable As Label";
_lable = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 342;BA.debugLine="lable.Initialize(\"\")";
_lable.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 343;BA.debugLine="lable.Text=title";
_lable.setText(BA.ObjectToCharSequence(_title));
 //BA.debugLineNum = 344;BA.debugLine="lable.Typeface=Typeface.CreateNew(C.irs, Typefac";
_lable.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.CreateNew((android.graphics.Typeface)(mostCurrent._c._irs.getObject()),anywheresoftware.b4a.keywords.Common.Typeface.STYLE_BOLD));
 //BA.debugLineNum = 345;BA.debugLine="lable.Color=Colors.White'.ARGB(255,245,229,231)";
_lable.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 346;BA.debugLine="lable.TextColor=Colors.ARGB(255,4,0,153)";
_lable.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (4),(int) (0),(int) (153)));
 //BA.debugLineNum = 347;BA.debugLine="lable.Padding=Array As Int (20dip,0,20dip,0)";
_lable.setPadding(new int[]{anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),(int) (0)});
 //BA.debugLineNum = 349;BA.debugLine="lable.TextSize=23";
_lable.setTextSize((float) (23));
 //BA.debugLineNum = 350;BA.debugLine="lable.Gravity= Gravity.RIGHT";
_lable.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT);
 //BA.debugLineNum = 352;BA.debugLine="ScrollView1.Panel.AddView(lable,2%x,toptemp,96%x";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lable.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
 //BA.debugLineNum = 353;BA.debugLine="Dim h As Hitex_Utils";
_h = new wir.hitex.recycler.Hitex_Utils();
 //BA.debugLineNum = 354;BA.debugLine="lable.Height=h.GetTextHeight(lable)'hlbl.LabelHe";
_lable.setHeight((int) (_h.GetTextHeight(_lable)));
 //BA.debugLineNum = 355;BA.debugLine="lable.Height=lable.Height";
_lable.setHeight(_lable.getHeight());
 //BA.debugLineNum = 356;BA.debugLine="toptemp=toptemp+lable.Height";
_toptemp = (int) (_toptemp+_lable.getHeight());
 //BA.debugLineNum = 357;BA.debugLine="titletemp=True";
_titletemp = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 358;BA.debugLine="titelhaghttemp=lable.Height";
_titelhaghttemp = _lable.getHeight();
 //BA.debugLineNum = 360;BA.debugLine="Dim lable As Label";
_lable = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 361;BA.debugLine="lable.Initialize(\"\")";
_lable.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 362;BA.debugLine="lable.Text=Chr(0xE916)";
_lable.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe916))));
 //BA.debugLineNum = 363;BA.debugLine="lable.Typeface=Typeface.MATERIALICONS";
_lable.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
 //BA.debugLineNum = 364;BA.debugLine="lable.TextColor=0x8B000690";
_lable.setTextColor((int) (0x8b000690));
 //BA.debugLineNum = 365;BA.debugLine="lable.Padding=Array As Int (20dip,0,20dip,0)";
_lable.setPadding(new int[]{anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),(int) (0)});
 //BA.debugLineNum = 366;BA.debugLine="ScrollView1.Panel.AddView(lable,2%x,toptemp,96%x";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lable.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 367;BA.debugLine="lable.Gravity= Bit.Or(Gravity.RIGHT,Gravity.CENT";
_lable.setGravity(anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT,anywheresoftware.b4a.keywords.Common.Gravity.CENTER));
 //BA.debugLineNum = 370;BA.debugLine="Dim lable As Label";
_lable = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 371;BA.debugLine="lable.Initialize(\"\")";
_lable.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 372;BA.debugLine="lable.Text=saato_ina(Main.newsdate)";
_lable.setText(BA.ObjectToCharSequence(_saato_ina(mostCurrent._main._newsdate)));
 //BA.debugLineNum = 373;BA.debugLine="lable.Typeface=C.irs";
_lable.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs.getObject()));
 //BA.debugLineNum = 374;BA.debugLine="lable.TextColor=0x8B000690";
_lable.setTextColor((int) (0x8b000690));
 //BA.debugLineNum = 375;BA.debugLine="lable.Padding=Array As Int (20dip,0,40dip,0)";
_lable.setPadding(new int[]{anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),(int) (0)});
 //BA.debugLineNum = 376;BA.debugLine="ScrollView1.Panel.AddView(lable,2%x,toptemp,96%x";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lable.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 377;BA.debugLine="lable.Gravity= Bit.Or(Gravity.RIGHT,Gravity.CENT";
_lable.setGravity(anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT,anywheresoftware.b4a.keywords.Common.Gravity.CENTER));
 //BA.debugLineNum = 378;BA.debugLine="toptemp=toptemp+10%x";
_toptemp = (int) (_toptemp+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA));
 };
 //BA.debugLineNum = 380;BA.debugLine="End Sub";
return "";
}
public static String  _addviewtosv_sub() throws Exception{
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
 //BA.debugLineNum = 561;BA.debugLine="Sub addviewtosv_sub";
 //BA.debugLineNum = 562;BA.debugLine="canshare=True";
_canshare = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 565;BA.debugLine="For o = 0 To map.Size-1";
{
final int step2 = 1;
final int limit2 = (int) (mostCurrent._map.getSize()-1);
_o = (int) (0) ;
for (;_o <= limit2 ;_o = _o + step2 ) {
 //BA.debugLineNum = 567;BA.debugLine="Dim h13() As String=Regex.Split(\"#\",map.Get(o))";
_h13 = anywheresoftware.b4a.keywords.Common.Regex.Split("#",BA.ObjectToString(mostCurrent._map.Get(_o)));
 //BA.debugLineNum = 568;BA.debugLine="Try";
try { //BA.debugLineNum = 569;BA.debugLine="Dim Typee As String = h13(1)";
_typee = _h13[(int) (1)];
 } 
       catch (Exception e7) {
			processBA.setLastException(e7); //BA.debugLineNum = 571;BA.debugLine="Dim Typee As String =\"TEXT\"";
_typee = "TEXT";
 };
 //BA.debugLineNum = 574;BA.debugLine="Select Typee";
switch (BA.switchObjectToInt(_typee,"IMG","CAPTION","TEXT","SUB_TITLE","TABLE")) {
case 0: {
 //BA.debugLineNum = 576;BA.debugLine="Dim url As String =  h13(0)";
_url = _h13[(int) (0)];
 //BA.debugLineNum = 577;BA.debugLine="If h13(0)=\"http://www.beytoote.com\" Or h13(0)=";
if ((_h13[(int) (0)]).equals("http://www.beytoote.com") || (_h13[(int) (0)]).equals("") || _h13[(int) (0)]== null || (_h13[(int) (0)]).equals("Null")) { 
 }else {
 //BA.debugLineNum = 580;BA.debugLine="If firstpicshow=False Then";
if (_firstpicshow==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 581;BA.debugLine="firstpicshow=True";
_firstpicshow = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 583;BA.debugLine="Dim img1 As ImageView";
_img1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 584;BA.debugLine="img1.Initialize(\"img\")";
_img1.Initialize(mostCurrent.activityBA,"img");
 //BA.debugLineNum = 585;BA.debugLine="img1.Color=Colors.LightGray";
_img1.setColor(anywheresoftware.b4a.keywords.Common.Colors.LightGray);
 //BA.debugLineNum = 586;BA.debugLine="ScrollView1.Panel.AddView(img1,0,toptemp,100";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_img1.getObject()),(int) (0),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
 //BA.debugLineNum = 589;BA.debugLine="imglisnks.Put(img1,url)";
mostCurrent._imglisnks.Put((Object)(_img1.getObject()),(Object)(_url));
 //BA.debugLineNum = 591;BA.debugLine="Dim imgdori As ImageView";
_imgdori = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 592;BA.debugLine="imgdori.Initialize(\"\")";
_imgdori.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 593;BA.debugLine="imgdori.Gravity=Gravity.FILL";
_imgdori.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 596;BA.debugLine="ScrollView1.Panel.AddView(imgdori,0,toptemp,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_imgdori.getObject()),(int) (0),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
 //BA.debugLineNum = 597;BA.debugLine="toptemp=toptemp+60%x";
_toptemp = (int) (_toptemp+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
 };
 };
 break; }
case 1: {
 //BA.debugLineNum = 602;BA.debugLine="If h13(0).Length>2 Then";
if (_h13[(int) (0)].length()>2) { 
 //BA.debugLineNum = 603;BA.debugLine="Dim txt As String =  h13(0)";
_txt = _h13[(int) (0)];
 //BA.debugLineNum = 605;BA.debugLine="Dim lable As Label";
_lable = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 606;BA.debugLine="lable.Initialize(\"\")";
_lable.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 607;BA.debugLine="lable.Text=Convert_FA2EN(txt)";
_lable.setText(BA.ObjectToCharSequence(_convert_fa2en(_txt)));
 //BA.debugLineNum = 608;BA.debugLine="alltext=alltext&CRLF&Convert_FA2EN(txt)";
mostCurrent._alltext = mostCurrent._alltext+anywheresoftware.b4a.keywords.Common.CRLF+_convert_fa2en(_txt);
 //BA.debugLineNum = 609;BA.debugLine="lable.Typeface=C.irs";
_lable.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs.getObject()));
 //BA.debugLineNum = 610;BA.debugLine="lable.Color=Colors.RGB(234,209,212)";
_lable.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (234),(int) (209),(int) (212)));
 //BA.debugLineNum = 611;BA.debugLine="lable.TextColor=Colors.ARGB(255,22,13,108)";
_lable.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (22),(int) (13),(int) (108)));
 //BA.debugLineNum = 612;BA.debugLine="lable.Padding=Array As Int (10dip,5dip,10dip,";
_lable.setPadding(new int[]{anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))});
 //BA.debugLineNum = 613;BA.debugLine="lable.TextSize=15";
_lable.setTextSize((float) (15));
 //BA.debugLineNum = 614;BA.debugLine="lable.Gravity= Gravity.CENTER',Gravity.RIGHT)";
_lable.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 616;BA.debugLine="ScrollView1.Panel.AddView(lable,0,toptemp,100";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lable.getObject()),(int) (0),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
 //BA.debugLineNum = 617;BA.debugLine="lable.Height=hlbl.LabelHeight(Convert_FA2EN(t";
_lable.setHeight((int) (mostCurrent._hlbl._labelheight(_convert_fa2en(_txt),_lable,mostCurrent._c._irs,(int) (15),anywheresoftware.b4a.keywords.Common.Gravity.CENTER,(float) (1.2))));
 //BA.debugLineNum = 618;BA.debugLine="lable.Height=lable.Height+5dip";
_lable.setHeight((int) (_lable.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))));
 //BA.debugLineNum = 619;BA.debugLine="toptemp=toptemp+lable.Height+5%x";
_toptemp = (int) (_toptemp+_lable.getHeight()+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA));
 };
 break; }
case 2: {
 //BA.debugLineNum = 624;BA.debugLine="If h13(0).Length>2 Then";
if (_h13[(int) (0)].length()>2) { 
 //BA.debugLineNum = 625;BA.debugLine="Dim txt As String =  h13(0)";
_txt = _h13[(int) (0)];
 //BA.debugLineNum = 627;BA.debugLine="Dim lable As Label";
_lable = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 628;BA.debugLine="lable.Initialize(\"\")";
_lable.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 629;BA.debugLine="lable.Text=Convert_FA2EN(txt)";
_lable.setText(BA.ObjectToCharSequence(_convert_fa2en(_txt)));
 //BA.debugLineNum = 630;BA.debugLine="alltext=alltext&CRLF&Convert_FA2EN(txt)";
mostCurrent._alltext = mostCurrent._alltext+anywheresoftware.b4a.keywords.Common.CRLF+_convert_fa2en(_txt);
 //BA.debugLineNum = 631;BA.debugLine="lable.Typeface=C.irs";
_lable.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs.getObject()));
 //BA.debugLineNum = 633;BA.debugLine="lable.TextColor=Colors.Black";
_lable.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 634;BA.debugLine="lable.Padding=Array As Int (1dip,5dip,10dip,0";
_lable.setPadding(new int[]{anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (0)});
 //BA.debugLineNum = 635;BA.debugLine="lable.TextSize=14";
_lable.setTextSize((float) (14));
 //BA.debugLineNum = 636;BA.debugLine="lable.Gravity= Gravity.RIGHT";
_lable.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT);
 //BA.debugLineNum = 637;BA.debugLine="ScrollView1.Panel.AddView(lable,2%x,toptemp,9";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lable.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
 //BA.debugLineNum = 638;BA.debugLine="lable.Height=hlbl.LabelHeight(Convert_FA2EN(t";
_lable.setHeight((int) (mostCurrent._hlbl._labelheight(_convert_fa2en(_txt),_lable,mostCurrent._c._irs,(int) (14),anywheresoftware.b4a.keywords.Common.Gravity.RIGHT,(float) (1.2))));
 //BA.debugLineNum = 639;BA.debugLine="toptemp=toptemp+lable.Height+5%x";
_toptemp = (int) (_toptemp+_lable.getHeight()+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA));
 };
 break; }
case 3: {
 //BA.debugLineNum = 643;BA.debugLine="If h13(0).Length>2 Then";
if (_h13[(int) (0)].length()>2) { 
 //BA.debugLineNum = 644;BA.debugLine="Dim txt As String =  h13(0)";
_txt = _h13[(int) (0)];
 //BA.debugLineNum = 646;BA.debugLine="titletemp=True";
_titletemp = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 647;BA.debugLine="Dim lable As Label";
_lable = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 648;BA.debugLine="lable.Initialize(\"\")";
_lable.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 649;BA.debugLine="lable.Text=Convert_FA2EN(txt)";
_lable.setText(BA.ObjectToCharSequence(_convert_fa2en(_txt)));
 //BA.debugLineNum = 650;BA.debugLine="alltext=alltext&CRLF&Convert_FA2EN(txt)";
mostCurrent._alltext = mostCurrent._alltext+anywheresoftware.b4a.keywords.Common.CRLF+_convert_fa2en(_txt);
 //BA.debugLineNum = 651;BA.debugLine="lable.Typeface=C.irs";
_lable.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs.getObject()));
 //BA.debugLineNum = 653;BA.debugLine="lable.TextColor=Colors.ARGB(255,146,6,47)";
_lable.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (146),(int) (6),(int) (47)));
 //BA.debugLineNum = 654;BA.debugLine="lable.Padding=Array As Int (1dip,5dip,10dip,0";
_lable.setPadding(new int[]{anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (0)});
 //BA.debugLineNum = 655;BA.debugLine="lable.TextSize=17";
_lable.setTextSize((float) (17));
 //BA.debugLineNum = 656;BA.debugLine="lable.Gravity= Gravity.RIGHT";
_lable.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT);
 //BA.debugLineNum = 657;BA.debugLine="ScrollView1.Panel.AddView(lable,2%x,toptemp,9";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lable.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
 //BA.debugLineNum = 658;BA.debugLine="lable.Height=hlbl.LabelHeight(Convert_FA2EN(t";
_lable.setHeight((int) (mostCurrent._hlbl._labelheight(_convert_fa2en(_txt),_lable,mostCurrent._c._irs,(int) (17),anywheresoftware.b4a.keywords.Common.Gravity.RIGHT,(float) (1.2))));
 //BA.debugLineNum = 659;BA.debugLine="toptemp=toptemp+lable.Height";
_toptemp = (int) (_toptemp+_lable.getHeight());
 };
 break; }
case 4: {
 //BA.debugLineNum = 662;BA.debugLine="If h13(0).Length>2 Then";
if (_h13[(int) (0)].length()>2) { 
 //BA.debugLineNum = 664;BA.debugLine="titletemp=True";
_titletemp = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 665;BA.debugLine="Try";
try { //BA.debugLineNum = 667;BA.debugLine="Dim h14() As String=Regex.Split(\"@\",h13(0))";
_h14 = anywheresoftware.b4a.keywords.Common.Regex.Split("@",_h13[(int) (0)]);
 //BA.debugLineNum = 669;BA.debugLine="Dim colo As Int";
_colo = 0;
 //BA.debugLineNum = 670;BA.debugLine="If map.IndexOf(map.Get(o)) Mod 2 = 0 Then";
if (mostCurrent._map.IndexOf(mostCurrent._map.Get(_o))%2==0) { 
 //BA.debugLineNum = 671;BA.debugLine="colo=0xFFF7F7F7";
_colo = (int) (0xfff7f7f7);
 }else {
 //BA.debugLineNum = 673;BA.debugLine="colo=0xFFEBEBEB";
_colo = (int) (0xffebebeb);
 };
 //BA.debugLineNum = 676;BA.debugLine="Dim lable1 As Label";
_lable1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 677;BA.debugLine="lable1.Initialize(\"\")";
_lable1.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 678;BA.debugLine="lable1.Text=Convert_FA2EN(h14(0))";
_lable1.setText(BA.ObjectToCharSequence(_convert_fa2en(_h14[(int) (0)])));
 //BA.debugLineNum = 679;BA.debugLine="lable1.Typeface=C.irs";
_lable1.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs.getObject()));
 //BA.debugLineNum = 680;BA.debugLine="lable1.Color=colo";
_lable1.setColor(_colo);
 //BA.debugLineNum = 681;BA.debugLine="lable1.TextColor=Colors.ARGB(255,146,6,47)";
_lable1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (146),(int) (6),(int) (47)));
 //BA.debugLineNum = 682;BA.debugLine="lable1.Padding=Array As Int (1dip,5dip,10dip";
_lable1.setPadding(new int[]{anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (0)});
 //BA.debugLineNum = 683;BA.debugLine="lable1.TextSize=17";
_lable1.setTextSize((float) (17));
 //BA.debugLineNum = 684;BA.debugLine="lable1.Gravity= Gravity.RIGHT";
_lable1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT);
 //BA.debugLineNum = 685;BA.debugLine="ScrollView1.Panel.AddView(lable1,0,toptemp,4";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lable1.getObject()),(int) (0),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (49.5),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
 //BA.debugLineNum = 686;BA.debugLine="lable1.Height=hlbl.LabelHeight(Convert_FA2EN";
_lable1.setHeight((int) (mostCurrent._hlbl._labelheight(_convert_fa2en(_h14[(int) (1)]),_lable1,mostCurrent._c._irs,(int) (14),anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT,anywheresoftware.b4a.keywords.Common.Gravity.CENTER),(float) (1.2))));
 //BA.debugLineNum = 689;BA.debugLine="Dim lable As Label";
_lable = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 690;BA.debugLine="lable.Initialize(\"\")";
_lable.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 691;BA.debugLine="lable.Text=Convert_FA2EN(h14(0))";
_lable.setText(BA.ObjectToCharSequence(_convert_fa2en(_h14[(int) (0)])));
 //BA.debugLineNum = 692;BA.debugLine="lable.Typeface=C.irs";
_lable.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs.getObject()));
 //BA.debugLineNum = 693;BA.debugLine="lable.Color=colo";
_lable.setColor(_colo);
 //BA.debugLineNum = 694;BA.debugLine="lable.TextColor=Colors.ARGB(255,146,6,47)";
_lable.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (146),(int) (6),(int) (47)));
 //BA.debugLineNum = 695;BA.debugLine="lable.Padding=Array As Int (1dip,5dip,10dip,";
_lable.setPadding(new int[]{anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (0)});
 //BA.debugLineNum = 696;BA.debugLine="lable.TextSize=17";
_lable.setTextSize((float) (17));
 //BA.debugLineNum = 697;BA.debugLine="lable.Gravity= Gravity.RIGHT";
_lable.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT);
 //BA.debugLineNum = 698;BA.debugLine="ScrollView1.Panel.AddView(lable,50%x,toptemp";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lable.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
 //BA.debugLineNum = 699;BA.debugLine="lable.Height=hlbl.LabelHeight(Convert_FA2EN(";
_lable.setHeight((int) (mostCurrent._hlbl._labelheight(_convert_fa2en(_h14[(int) (0)]),_lable,mostCurrent._c._irs,(int) (14),anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT,anywheresoftware.b4a.keywords.Common.Gravity.CENTER),(float) (1.2))));
 //BA.debugLineNum = 700;BA.debugLine="lable1.Height=lable.Height";
_lable1.setHeight(_lable.getHeight());
 //BA.debugLineNum = 701;BA.debugLine="toptemp=toptemp+lable.Height+.5%x";
_toptemp = (int) (_toptemp+_lable.getHeight()+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (.5),mostCurrent.activityBA));
 //BA.debugLineNum = 703;BA.debugLine="alltext=alltext&CRLF&h14(0)&\" : \"&h14(1)";
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
 //BA.debugLineNum = 714;BA.debugLine="End Sub";
return "";
}
public static String  _bring_up(anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
anywheresoftware.b4a.phone.Phone _phone1 = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
float _elevation = 0f;
 //BA.debugLineNum = 189;BA.debugLine="Sub bring_Up(v As View)";
 //BA.debugLineNum = 190;BA.debugLine="Dim phone1 As Phone";
_phone1 = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 191;BA.debugLine="If phone1.SdkVersion>20 Then";
if (_phone1.getSdkVersion()>20) { 
 //BA.debugLineNum = 192;BA.debugLine="Dim jo As JavaObject = v";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_v.getObject()));
 //BA.debugLineNum = 193;BA.debugLine="Dim elevation As Float = 8dip";
_elevation = (float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (8)));
 //BA.debugLineNum = 194;BA.debugLine="jo.RunMethod(\"setElevation\",Array(elevation))";
_jo.RunMethod("setElevation",new Object[]{(Object)(_elevation)});
 }else {
 //BA.debugLineNum = 196;BA.debugLine="v.BringToFront";
_v.BringToFront();
 };
 //BA.debugLineNum = 198;BA.debugLine="End Sub";
return "";
}
public static String  _convert_fa2en(String _contente) throws Exception{
String _res = "";
 //BA.debugLineNum = 545;BA.debugLine="Sub Convert_FA2EN(contente As String) As String";
 //BA.debugLineNum = 547;BA.debugLine="Dim Res As String = contente";
_res = _contente;
 //BA.debugLineNum = 548;BA.debugLine="Res = Res.Replace(\"0\", \"۰\")";
_res = _res.replace("0","۰");
 //BA.debugLineNum = 549;BA.debugLine="Res = Res.Replace(\"1\", \"۱\")";
_res = _res.replace("1","۱");
 //BA.debugLineNum = 550;BA.debugLine="Res = Res.Replace(\"2\", \"۲\")";
_res = _res.replace("2","۲");
 //BA.debugLineNum = 551;BA.debugLine="Res = Res.Replace(\"3\", \"۳\")";
_res = _res.replace("3","۳");
 //BA.debugLineNum = 552;BA.debugLine="Res = Res.Replace(\"4\", \"۴\")";
_res = _res.replace("4","۴");
 //BA.debugLineNum = 553;BA.debugLine="Res = Res.Replace(\"5\", \"۵\")";
_res = _res.replace("5","۵");
 //BA.debugLineNum = 554;BA.debugLine="Res = Res.Replace(\"6\", \"۶\")";
_res = _res.replace("6","۶");
 //BA.debugLineNum = 555;BA.debugLine="Res = Res.Replace(\"7\", \"۷\")";
_res = _res.replace("7","۷");
 //BA.debugLineNum = 556;BA.debugLine="Res = Res.Replace(\"8\", \"۸\")";
_res = _res.replace("8","۸");
 //BA.debugLineNum = 557;BA.debugLine="Res = Res.Replace(\"9\", \"۹\")";
_res = _res.replace("9","۹");
 //BA.debugLineNum = 558;BA.debugLine="Return Res";
if (true) return _res;
 //BA.debugLineNum = 560;BA.debugLine="End Sub";
return "";
}
public static String  _converttickstotimestring_sub(long _ta) throws Exception{
int _hours = 0;
int _minutes = 0;
int _seconds = 0;
 //BA.debugLineNum = 1037;BA.debugLine="Sub ConvertTicksToTimeString_sub(ta As Long) As St";
 //BA.debugLineNum = 1038;BA.debugLine="Dim  hours, minutes, seconds As Int";
_hours = 0;
_minutes = 0;
_seconds = 0;
 //BA.debugLineNum = 1039;BA.debugLine="hours = ta / DateTime.TicksPerHour";
_hours = (int) (_ta/(double)anywheresoftware.b4a.keywords.Common.DateTime.TicksPerHour);
 //BA.debugLineNum = 1040;BA.debugLine="minutes = (ta Mod DateTime.TicksPerHour) / DateTi";
_minutes = (int) ((_ta%anywheresoftware.b4a.keywords.Common.DateTime.TicksPerHour)/(double)anywheresoftware.b4a.keywords.Common.DateTime.TicksPerMinute);
 //BA.debugLineNum = 1041;BA.debugLine="seconds = (ta Mod DateTime.TicksPerMinute) / Date";
_seconds = (int) ((_ta%anywheresoftware.b4a.keywords.Common.DateTime.TicksPerMinute)/(double)anywheresoftware.b4a.keywords.Common.DateTime.TicksPerSecond);
 //BA.debugLineNum = 1042;BA.debugLine="Return NumberFormat(minutes, 2, 0) & \":\" & Number";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_minutes,(int) (2),(int) (0))+":"+anywheresoftware.b4a.keywords.Common.NumberFormat(_seconds,(int) (2),(int) (0));
 //BA.debugLineNum = 1043;BA.debugLine="End Sub";
return "";
}
public static String  _disable_scroolbarh(anywheresoftware.b4a.objects.ScrollViewWrapper _sv1) throws Exception{
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
 //BA.debugLineNum = 209;BA.debugLine="Sub Disable_ScroolbarH(sv1 As ScrollView)";
 //BA.debugLineNum = 210;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
 //BA.debugLineNum = 211;BA.debugLine="r.Target = sv1";
_r.Target = (Object)(_sv1.getObject());
 //BA.debugLineNum = 212;BA.debugLine="r.RunMethod2(\"setVerticalScrollBarEnabled\", False";
_r.RunMethod2("setVerticalScrollBarEnabled",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.False),"java.lang.boolean");
 //BA.debugLineNum = 213;BA.debugLine="End Sub";
return "";
}
public static String  _file_onfailure(String _msg) throws Exception{
 //BA.debugLineNum = 779;BA.debugLine="Sub file_onFailure(msg As String)";
 //BA.debugLineNum = 781;BA.debugLine="Pnlprb.Visible=False";
mostCurrent._pnlprb.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 782;BA.debugLine="Label1.Visible=True";
mostCurrent._label1.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 783;BA.debugLine="Label2.Visible=True";
mostCurrent._label2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 784;BA.debugLine="End Sub";
return "";
}
public static String  _flot2_click() throws Exception{
 //BA.debugLineNum = 955;BA.debugLine="Sub flot2_Click";
 //BA.debugLineNum = 958;BA.debugLine="End Sub";
return "";
}
public static String  _flot3_click() throws Exception{
anywheresoftware.b4a.ariagplib.ARIAlib _aria = null;
 //BA.debugLineNum = 960;BA.debugLine="Sub flot3_Click";
 //BA.debugLineNum = 961;BA.debugLine="Dim Aria As AriaLib";
_aria = new anywheresoftware.b4a.ariagplib.ARIAlib();
 //BA.debugLineNum = 962;BA.debugLine="StartActivity( Aria.ShareText(Main.txtnewstitle&C";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_aria.ShareText(mostCurrent._main._txtnewstitle+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Main.txtnews"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"برگرفته از اپلیکیشن هواشناسی پیشرفته ؛"+anywheresoftware.b4a.keywords.Common.CRLF+"https://cafebazaar.ir/app/"+anywheresoftware.b4a.keywords.Common.Application.getPackageName()+"/?l=fa","اشتراک گذاری با ؛")));
 //BA.debugLineNum = 963;BA.debugLine="End Sub";
return "";
}
public static String  _force_ltrsupported4view(anywheresoftware.b4a.objects.ConcreteViewWrapper _view) throws Exception{
anywheresoftware.b4j.object.JavaObject _ja = null;
anywheresoftware.b4j.object.JavaObject _jos = null;
 //BA.debugLineNum = 760;BA.debugLine="Sub Force_LtrSupported4View(View As View)";
 //BA.debugLineNum = 761;BA.debugLine="Dim jA,jos As JavaObject";
_ja = new anywheresoftware.b4j.object.JavaObject();
_jos = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 762;BA.debugLine="jos.InitializeStatic  (\"android.view.View\")";
_jos.InitializeStatic("android.view.View");
 //BA.debugLineNum = 763;BA.debugLine="If jA.InitializeStatic  (\"android.os.Build$VERSIO";
if ((double)(BA.ObjectToNumber(_ja.InitializeStatic("android.os.Build$VERSION").GetField("SDK_INT")))>16) { 
 //BA.debugLineNum = 764;BA.debugLine="jA = View";
_ja.setObject((java.lang.Object)(_view.getObject()));
 //BA.debugLineNum = 765;BA.debugLine="jA.RunMethod (\"setLayoutDirection\",Array(jos.Get";
_ja.RunMethod("setLayoutDirection",new Object[]{_jos.GetField("LAYOUT_DIRECTION_LTR")});
 };
 //BA.debugLineNum = 767;BA.debugLine="End Sub";
return "";
}
public static String  _force_rtlsupported4view(anywheresoftware.b4a.objects.ConcreteViewWrapper _view) throws Exception{
anywheresoftware.b4j.object.JavaObject _ja = null;
anywheresoftware.b4j.object.JavaObject _jos = null;
 //BA.debugLineNum = 536;BA.debugLine="Sub Force_RtlSupported4View(View As View)";
 //BA.debugLineNum = 537;BA.debugLine="Dim jA,jos As JavaObject";
_ja = new anywheresoftware.b4j.object.JavaObject();
_jos = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 538;BA.debugLine="jos.InitializeStatic  (\"android.view.View\")";
_jos.InitializeStatic("android.view.View");
 //BA.debugLineNum = 539;BA.debugLine="If jA.InitializeStatic  (\"android.os.Build$VERSIO";
if ((double)(BA.ObjectToNumber(_ja.InitializeStatic("android.os.Build$VERSION").GetField("SDK_INT")))>16) { 
 //BA.debugLineNum = 540;BA.debugLine="jA = View";
_ja.setObject((java.lang.Object)(_view.getObject()));
 //BA.debugLineNum = 541;BA.debugLine="jA.RunMethod (\"setLayoutDirection\",Array(jos.Get";
_ja.RunMethod("setLayoutDirection",new Object[]{_jos.GetField("LAYOUT_DIRECTION_RTL")});
 };
 //BA.debugLineNum = 543;BA.debugLine="End Sub";
return "";
}
public static String  _from_cacht(String _a,int _size) throws Exception{
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
 //BA.debugLineNum = 786;BA.debugLine="Sub from_cacht(a As String , size As Int)";
 //BA.debugLineNum = 787;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 788;BA.debugLine="parser.Initialize(a)";
_parser.Initialize(_a);
 //BA.debugLineNum = 789;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
 //BA.debugLineNum = 790;BA.debugLine="Dim thumbnail As String = root.Get(\"thumbnail\")";
_thumbnail = BA.ObjectToString(_root.Get((Object)("thumbnail")));
 //BA.debugLineNum = 791;BA.debugLine="Dim images As List = root.Get(\"images\")";
_images = new anywheresoftware.b4a.objects.collections.List();
_images.setObject((java.util.List)(_root.Get((Object)("images"))));
 //BA.debugLineNum = 792;BA.debugLine="For Each colimages As String In images";
{
final anywheresoftware.b4a.BA.IterableList group6 = _images;
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_colimages = BA.ObjectToString(group6.Get(index6));
 }
};
 //BA.debugLineNum = 795;BA.debugLine="Dim title As String = root.Get(\"title\")";
_title = BA.ObjectToString(_root.Get((Object)("title")));
 //BA.debugLineNum = 796;BA.debugLine="Dim contentd As String = root.Get(\"content\")";
_contentd = BA.ObjectToString(_root.Get((Object)("content")));
 //BA.debugLineNum = 798;BA.debugLine="Dim cd As String";
_cd = "";
 //BA.debugLineNum = 800;BA.debugLine="Dim h14() As String=Regex.Split(CRLF,contentd)";
_h14 = anywheresoftware.b4a.keywords.Common.Regex.Split(anywheresoftware.b4a.keywords.Common.CRLF,_contentd);
 //BA.debugLineNum = 801;BA.debugLine="For i = 0 To h14.Length-1";
{
final int step12 = 1;
final int limit12 = (int) (_h14.length-1);
_i = (int) (0) ;
for (;_i <= limit12 ;_i = _i + step12 ) {
 //BA.debugLineNum = 803;BA.debugLine="If h14(i).Length>1 Then";
if (_h14[_i].length()>1) { 
 //BA.debugLineNum = 804;BA.debugLine="cd=cd&CRLF&h14(i)";
_cd = _cd+anywheresoftware.b4a.keywords.Common.CRLF+_h14[_i];
 };
 }
};
 //BA.debugLineNum = 808;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
 //BA.debugLineNum = 810;BA.debugLine="addtitle_sub(title,\"\")";
_addtitle_sub(_title,"");
 //BA.debugLineNum = 811;BA.debugLine="Dim h13() As String=Regex.Split(\"<span>\",c)";
_h13 = anywheresoftware.b4a.keywords.Common.Regex.Split("<span>",BA.ObjectToString(mostCurrent._c));
 //BA.debugLineNum = 812;BA.debugLine="For i = 0 To h13.Length-1";
{
final int step20 = 1;
final int limit20 = (int) (_h13.length-1);
_i = (int) (0) ;
for (;_i <= limit20 ;_i = _i + step20 ) {
 //BA.debugLineNum = 823;BA.debugLine="If h13(i).Contains(\".mp3\") Or h13(i).Contains(\".";
if (_h13[_i].contains(".mp3") || _h13[_i].contains(".mp4") || _h13[_i].contains("img") || _h13[_i].contains("caption")) { 
 //BA.debugLineNum = 824;BA.debugLine="If h13(i).Contains(\"img\") Then";
if (_h13[_i].contains("img")) { 
 //BA.debugLineNum = 825;BA.debugLine="Dim url As String =  GetImage_Path(h13(i))";
_url = _getimage_path(_h13[_i]);
 //BA.debugLineNum = 826;BA.debugLine="If h13(i)<>\"\"  Then";
if ((_h13[_i]).equals("") == false) { 
 //BA.debugLineNum = 827;BA.debugLine="Dim img1 As ImageView";
_img1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 828;BA.debugLine="img1.Initialize(\"\")";
_img1.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 829;BA.debugLine="img1.Color=Colors.Transparent";
_img1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
 //BA.debugLineNum = 830;BA.debugLine="ScrollView1.Panel.AddView(img1,0,toptemp,100%";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_img1.getObject()),(int) (0),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
 //BA.debugLineNum = 832;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 833;BA.debugLine="pnl.Initialize(\"\")";
_pnl.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 834;BA.debugLine="pnl.Color=0xC8FFFFFF";
_pnl.setColor((int) (0xc8ffffff));
 //BA.debugLineNum = 835;BA.debugLine="ScrollView1.Panel.AddView(pnl,0,toptemp,100%x";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_pnl.getObject()),(int) (0),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
 //BA.debugLineNum = 837;BA.debugLine="Dim img12 As ImageView";
_img12 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 838;BA.debugLine="img12.Initialize(\"img\")";
_img12.Initialize(mostCurrent.activityBA,"img");
 //BA.debugLineNum = 839;BA.debugLine="img12.Color=Colors.Transparent";
_img12.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
 //BA.debugLineNum = 840;BA.debugLine="ScrollView1.Panel.AddView(img12,0,toptemp,100";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_img12.getObject()),(int) (0),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
 //BA.debugLineNum = 847;BA.debugLine="imglisnks.Put(img12,url)";
mostCurrent._imglisnks.Put((Object)(_img12.getObject()),(Object)(_url));
 //BA.debugLineNum = 848;BA.debugLine="toptemp=toptemp+62%x";
_toptemp = (int) (_toptemp+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (62),mostCurrent.activityBA));
 };
 };
 //BA.debugLineNum = 851;BA.debugLine="If h13(i).Contains(\".mp4\") Then";
if (_h13[_i].contains(".mp4")) { 
 //BA.debugLineNum = 857;BA.debugLine="videolink=Getmp4_Path(h13(i))";
_videolink = _getmp4_path(_h13[_i]);
 };
 //BA.debugLineNum = 863;BA.debugLine="If h13(i).Contains(\".mp3\") Then";
if (_h13[_i].contains(".mp3")) { 
 //BA.debugLineNum = 864;BA.debugLine="soundurl =  Getmp3_Path(h13(i))";
mostCurrent._soundurl = _getmp3_path(_h13[_i]);
 //BA.debugLineNum = 866;BA.debugLine="If h13(i)<>\"\"  Then";
if ((_h13[_i]).equals("") == false) { 
 //BA.debugLineNum = 868;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 869;BA.debugLine="pnl.Initialize(\"\")";
_pnl.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 870;BA.debugLine="pnl.Color=Colors.LightGray";
_pnl.setColor(anywheresoftware.b4a.keywords.Common.Colors.LightGray);
 //BA.debugLineNum = 871;BA.debugLine="ScrollView1.Panel.AddView(pnl,0,toptemp,100%x";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_pnl.getObject()),(int) (0),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA));
 //BA.debugLineNum = 873;BA.debugLine="Dim ac As AppCompat";
_ac = new de.amberhome.objects.appcompat.AppCompatBase();
 //BA.debugLineNum = 875;BA.debugLine="Dim lblplaya As Label";
_lblplaya = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 876;BA.debugLine="lblplaya.Initialize(\"\")";
_lblplaya.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 877;BA.debugLine="lblplaya.Color=0xFFBCBCBC";
_lblplaya.setColor((int) (0xffbcbcbc));
 //BA.debugLineNum = 878;BA.debugLine="ScrollView1.Panel.AddView(lblplaya,85%x,topte";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lblplaya.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (85),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA));
 //BA.debugLineNum = 880;BA.debugLine="Dim lbldownd As Label";
_lbldownd = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 881;BA.debugLine="lbldownd.Initialize(\"\")";
_lbldownd.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 882;BA.debugLine="lbldownd.Color=0xFFBCBCBC";
_lbldownd.setColor((int) (0xffbcbcbc));
 //BA.debugLineNum = 883;BA.debugLine="ScrollView1.Panel.AddView(lbldownd,0,toptemp,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lbldownd.getObject()),(int) (0),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA));
 //BA.debugLineNum = 886;BA.debugLine="lblplay.Initialize(\"lblplay\")";
mostCurrent._lblplay.Initialize(mostCurrent.activityBA,"lblplay");
 //BA.debugLineNum = 887;BA.debugLine="lblplay.Text=Chr(0xE037)";
mostCurrent._lblplay.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe037))));
 //BA.debugLineNum = 888;BA.debugLine="lblplay.Typeface=Typeface.MATERIALICONS";
mostCurrent._lblplay.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
 //BA.debugLineNum = 889;BA.debugLine="lblplay.Gravity=Gravity.CENTER";
mostCurrent._lblplay.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 890;BA.debugLine="lblplay.TextColor=Colors.DarkGray";
mostCurrent._lblplay.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.DarkGray);
 //BA.debugLineNum = 891;BA.debugLine="lblplay.TextSize=20";
mostCurrent._lblplay.setTextSize((float) (20));
 //BA.debugLineNum = 892;BA.debugLine="ScrollView1.Panel.AddView(lblplay,0,toptemp,1";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._lblplay.getObject()),(int) (0),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA));
 //BA.debugLineNum = 893;BA.debugLine="ac.SetClickEffect(lblplay,False)";
_ac.SetClickEffect(mostCurrent.activityBA,(android.view.View)(mostCurrent._lblplay.getObject()),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 895;BA.debugLine="lbldown.Initialize(\"lbldown\")";
mostCurrent._lbldown.Initialize(mostCurrent.activityBA,"lbldown");
 //BA.debugLineNum = 896;BA.debugLine="lbldown.Text=Chr(0xE2C4)";
mostCurrent._lbldown.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe2c4))));
 //BA.debugLineNum = 897;BA.debugLine="lbldown.Typeface=Typeface.MATERIALICONS";
mostCurrent._lbldown.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
 //BA.debugLineNum = 898;BA.debugLine="lbldown.Gravity=Gravity.CENTER";
mostCurrent._lbldown.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 899;BA.debugLine="lbldown.TextColor=Colors.DarkGray";
mostCurrent._lbldown.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.DarkGray);
 //BA.debugLineNum = 900;BA.debugLine="lbldown.TextSize=20";
mostCurrent._lbldown.setTextSize((float) (20));
 //BA.debugLineNum = 901;BA.debugLine="ac.SetClickEffect(lbldown,False)";
_ac.SetClickEffect(mostCurrent.activityBA,(android.view.View)(mostCurrent._lbldown.getObject()),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 902;BA.debugLine="ScrollView1.Panel.AddView(lbldown,85%x,toptem";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._lbldown.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (85),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA));
 //BA.debugLineNum = 904;BA.debugLine="lbldur.Initialize(\"\")";
mostCurrent._lbldur.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 905;BA.debugLine="lbldur.Text=\"00:00\"";
mostCurrent._lbldur.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 906;BA.debugLine="lbldur.Typeface=C.irs";
mostCurrent._lbldur.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs.getObject()));
 //BA.debugLineNum = 907;BA.debugLine="lbldur.Gravity=Bit.Or(Gravity.LEFT,Gravity.BO";
mostCurrent._lbldur.setGravity(anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.LEFT,anywheresoftware.b4a.keywords.Common.Gravity.BOTTOM));
 //BA.debugLineNum = 908;BA.debugLine="lbldur.TextColor=Colors.DarkGray";
mostCurrent._lbldur.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.DarkGray);
 //BA.debugLineNum = 909;BA.debugLine="lbldur.TextSize=10";
mostCurrent._lbldur.setTextSize((float) (10));
 //BA.debugLineNum = 910;BA.debugLine="ScrollView1.Panel.AddView(lbldur,17.5%x,topte";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._lbldur.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (17.5),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (30),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA));
 //BA.debugLineNum = 912;BA.debugLine="lblpos.Initialize(\"\")";
mostCurrent._lblpos.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 913;BA.debugLine="lblpos.Text=\"00:00\"";
mostCurrent._lblpos.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 914;BA.debugLine="lblpos.Typeface=C.irs";
mostCurrent._lblpos.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs.getObject()));
 //BA.debugLineNum = 915;BA.debugLine="lblpos.Gravity=Bit.Or(Gravity.RIGHT,Gravity.B";
mostCurrent._lblpos.setGravity(anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT,anywheresoftware.b4a.keywords.Common.Gravity.BOTTOM));
 //BA.debugLineNum = 916;BA.debugLine="lblpos.TextColor=Colors.DarkGray";
mostCurrent._lblpos.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.DarkGray);
 //BA.debugLineNum = 917;BA.debugLine="lblpos.TextSize=10";
mostCurrent._lblpos.setTextSize((float) (10));
 //BA.debugLineNum = 918;BA.debugLine="ScrollView1.Panel.AddView(lblpos,52.5%x,topte";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._lblpos.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (52.5),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (30),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA));
 //BA.debugLineNum = 920;BA.debugLine="seekbar.Initialize(\"seekbar\")";
mostCurrent._seekbar.Initialize(mostCurrent.activityBA,"seekbar");
 //BA.debugLineNum = 921;BA.debugLine="ScrollView1.Panel.AddView(seekbar,15%x,toptem";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._seekbar.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA));
 //BA.debugLineNum = 922;BA.debugLine="Force_LtrSupported4View(seekbar)";
_force_ltrsupported4view((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._seekbar.getObject())));
 //BA.debugLineNum = 924;BA.debugLine="toptemp=toptemp+18%x";
_toptemp = (int) (_toptemp+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (18),mostCurrent.activityBA));
 };
 };
 }else {
 //BA.debugLineNum = 929;BA.debugLine="If h13(i).Length>2 Then";
if (_h13[_i].length()>2) { 
 //BA.debugLineNum = 931;BA.debugLine="Dim txt As String =  h13(i)";
_txt = _h13[_i];
 //BA.debugLineNum = 932;BA.debugLine="Dim lable As Label";
_lable = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 933;BA.debugLine="lable.Initialize(\"\")";
_lable.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 934;BA.debugLine="lable.Text=Convert_FA2EN(txt)";
_lable.setText(BA.ObjectToCharSequence(_convert_fa2en(_txt)));
 //BA.debugLineNum = 935;BA.debugLine="alltext=alltext&CRLF&Convert_FA2EN(txt)";
mostCurrent._alltext = mostCurrent._alltext+anywheresoftware.b4a.keywords.Common.CRLF+_convert_fa2en(_txt);
 //BA.debugLineNum = 936;BA.debugLine="lable.Typeface=C.irs";
_lable.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs.getObject()));
 //BA.debugLineNum = 937;BA.debugLine="lable.TextColor= Colors.Transparent";
_lable.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
 //BA.debugLineNum = 938;BA.debugLine="lable.Padding=Array As Int (25dip,0,25dip,0)";
_lable.setPadding(new int[]{anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),(int) (0)});
 //BA.debugLineNum = 939;BA.debugLine="lable.TextSize=size";
_lable.setTextSize((float) (_size));
 //BA.debugLineNum = 940;BA.debugLine="lable.Gravity= Gravity.RIGHT";
_lable.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT);
 //BA.debugLineNum = 941;BA.debugLine="ScrollView1.Panel.AddView(lable,2%x,toptemp,96";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lable.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
 //BA.debugLineNum = 942;BA.debugLine="lable.Height=hlbl.LabelHeight(Convert_FA2EN(la";
_lable.setHeight((int) (mostCurrent._hlbl._labelheight(_convert_fa2en(_lable.getText()),_lable,mostCurrent._c._irs,_size,anywheresoftware.b4a.keywords.Common.Gravity.RIGHT,(float) (1.2))));
 //BA.debugLineNum = 943;BA.debugLine="toptemp=toptemp+lable.Height";
_toptemp = (int) (_toptemp+_lable.getHeight());
 //BA.debugLineNum = 944;BA.debugLine="CallSubDelayed2( Me, \"Justify_Text\", lable )";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,page.getObject(),"Justify_Text",(Object)(_lable));
 };
 };
 }
};
 //BA.debugLineNum = 949;BA.debugLine="toolbar";
_toolbar();
 //BA.debugLineNum = 951;BA.debugLine="Pnlprb.Visible=False";
mostCurrent._pnlprb.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 952;BA.debugLine="canshare=True";
_canshare = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 953;BA.debugLine="End Sub";
return "";
}
public static String  _getimage_path(String _val) throws Exception{
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _l = null;
boolean _find = false;
String _res = "";
 //BA.debugLineNum = 978;BA.debugLine="Public Sub GetImage_Path(val As String) As String";
 //BA.debugLineNum = 980;BA.debugLine="Dim l As Matcher";
_l = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
 //BA.debugLineNum = 981;BA.debugLine="l = Regex.Matcher(\"src\\s*=\\s*(.+?)\"\"\",val)";
_l = anywheresoftware.b4a.keywords.Common.Regex.Matcher("src\\s*=\\s*(.+?)\"",_val);
 //BA.debugLineNum = 983;BA.debugLine="Try";
try { //BA.debugLineNum = 984;BA.debugLine="Dim find As Boolean";
_find = false;
 //BA.debugLineNum = 985;BA.debugLine="find = l.find";
_find = _l.Find();
 //BA.debugLineNum = 986;BA.debugLine="If find = False Then Return \"\"";
if (_find==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 987;BA.debugLine="Dim res As String";
_res = "";
 //BA.debugLineNum = 989;BA.debugLine="res = l.Group(1)";
_res = _l.Group((int) (1));
 //BA.debugLineNum = 990;BA.debugLine="res = res.SubString(1)";
_res = _res.substring((int) (1));
 //BA.debugLineNum = 991;BA.debugLine="Return res";
if (true) return _res;
 } 
       catch (Exception e12) {
			processBA.setLastException(e12); //BA.debugLineNum = 993;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 996;BA.debugLine="End Sub";
return "";
}
public static String  _getmp3_path(String _val) throws Exception{
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _l = null;
boolean _find = false;
String _res = "";
 //BA.debugLineNum = 997;BA.debugLine="Public Sub Getmp3_Path(val As String) As String";
 //BA.debugLineNum = 999;BA.debugLine="Dim l As Matcher";
_l = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
 //BA.debugLineNum = 1000;BA.debugLine="l = Regex.Matcher(\"mp3\\s*=\\s*(.+?)\"\"\",val)";
_l = anywheresoftware.b4a.keywords.Common.Regex.Matcher("mp3\\s*=\\s*(.+?)\"",_val);
 //BA.debugLineNum = 1002;BA.debugLine="Try";
try { //BA.debugLineNum = 1003;BA.debugLine="Dim find As Boolean";
_find = false;
 //BA.debugLineNum = 1004;BA.debugLine="find = l.find";
_find = _l.Find();
 //BA.debugLineNum = 1005;BA.debugLine="If find = False Then Return \"\"";
if (_find==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 1006;BA.debugLine="Dim res As String";
_res = "";
 //BA.debugLineNum = 1008;BA.debugLine="res = l.Group(1)";
_res = _l.Group((int) (1));
 //BA.debugLineNum = 1009;BA.debugLine="res = res.SubString(1)";
_res = _res.substring((int) (1));
 //BA.debugLineNum = 1010;BA.debugLine="Return res";
if (true) return _res;
 } 
       catch (Exception e12) {
			processBA.setLastException(e12); //BA.debugLineNum = 1012;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 1015;BA.debugLine="End Sub";
return "";
}
public static String  _getmp4_path(String _val) throws Exception{
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _l = null;
boolean _find = false;
String _res = "";
 //BA.debugLineNum = 1016;BA.debugLine="Public Sub Getmp4_Path(val As String) As String";
 //BA.debugLineNum = 1018;BA.debugLine="Dim l As Matcher";
_l = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
 //BA.debugLineNum = 1019;BA.debugLine="l = Regex.Matcher(\"mp4\\s*=\\s*(.+?)\"\"\",val)";
_l = anywheresoftware.b4a.keywords.Common.Regex.Matcher("mp4\\s*=\\s*(.+?)\"",_val);
 //BA.debugLineNum = 1021;BA.debugLine="Try";
try { //BA.debugLineNum = 1022;BA.debugLine="Dim find As Boolean";
_find = false;
 //BA.debugLineNum = 1023;BA.debugLine="find = l.find";
_find = _l.Find();
 //BA.debugLineNum = 1024;BA.debugLine="If find = False Then Return \"\"";
if (_find==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 1025;BA.debugLine="Dim res As String";
_res = "";
 //BA.debugLineNum = 1027;BA.debugLine="res = l.Group(1)";
_res = _l.Group((int) (1));
 //BA.debugLineNum = 1028;BA.debugLine="res = res.SubString(1)";
_res = _res.substring((int) (1));
 //BA.debugLineNum = 1029;BA.debugLine="Return res";
if (true) return _res;
 } 
       catch (Exception e12) {
			processBA.setLastException(e12); //BA.debugLineNum = 1031;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 1034;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 20;BA.debugLine="Dim soundurl As String";
mostCurrent._soundurl = "";
 //BA.debugLineNum = 21;BA.debugLine="Private ScrollView1 As ScrollView";
mostCurrent._scrollview1 = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Dim nazarat_lbl As Label";
mostCurrent._nazarat_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private Paneldark As Panel";
mostCurrent._paneldark = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private ACToolBarLight1 As ACToolBarLight";
mostCurrent._actoolbarlight1 = new de.amberhome.objects.appcompat.ACToolbarLightWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private Img As ImageView";
mostCurrent._img = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private toolbartemp As Panel";
mostCurrent._toolbartemp = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private Glide As Hitex_Glide";
mostCurrent._glide = new com.hitex_glide.Hitex_Glide();
 //BA.debugLineNum = 28;BA.debugLine="Dim lbltoolbar As Label";
mostCurrent._lbltoolbar = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private pnlmatlab As Panel";
mostCurrent._pnlmatlab = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Dim toptemp As Int = 80%x";
_toptemp = anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA);
 //BA.debugLineNum = 31;BA.debugLine="Dim titelhaghttemp As Int = 0";
_titelhaghttemp = (int) (0);
 //BA.debugLineNum = 34;BA.debugLine="Dim titletemp As Boolean = False";
_titletemp = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 37;BA.debugLine="Dim name As String =\"\"' Main.matlablink313";
mostCurrent._name = "";
 //BA.debugLineNum = 38;BA.debugLine="Dim map As List";
mostCurrent._map = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 39;BA.debugLine="Dim firstimg As String";
mostCurrent._firstimg = "";
 //BA.debugLineNum = 41;BA.debugLine="Private Pnlprb As Panel";
mostCurrent._pnlprb = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private ProgressBar1 As ProgressBar";
mostCurrent._progressbar1 = new anywheresoftware.b4a.objects.ProgressBarWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Dim fsize As Int";
_fsize = 0;
 //BA.debugLineNum = 44;BA.debugLine="Dim foldername As String =\"\"' Main.link313";
mostCurrent._foldername = "";
 //BA.debugLineNum = 45;BA.debugLine="Dim canshare As Boolean = False";
_canshare = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 46;BA.debugLine="Dim firstpicshow As Boolean = False";
_firstpicshow = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 47;BA.debugLine="Dim imglisnks As Map";
mostCurrent._imglisnks = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 48;BA.debugLine="Dim comment As String";
mostCurrent._comment = "";
 //BA.debugLineNum = 50;BA.debugLine="Dim downtost As Boolean=False";
_downtost = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 51;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private Label2 As Label";
mostCurrent._label2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Dim flot As Panel";
mostCurrent._flot = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Dim flot2 As Label";
mostCurrent._flot2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 55;BA.debugLine="Dim flot3 As Panel";
mostCurrent._flot3 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Dim flot4 As Label";
mostCurrent._flot4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Dim mpo As MediaPlayer";
mostCurrent._mpo = new anywheresoftware.b4a.objects.MediaPlayerWrapper();
 //BA.debugLineNum = 58;BA.debugLine="Dim lbldown As Label";
mostCurrent._lbldown = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 59;BA.debugLine="Dim lblplay As Label";
mostCurrent._lblplay = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Dim lbldur As Label";
mostCurrent._lbldur = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Dim lblpos As Label";
mostCurrent._lblpos = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 62;BA.debugLine="Dim seekbar As ACSeekBar";
mostCurrent._seekbar = new de.amberhome.objects.appcompat.ACSeekBarWrapper();
 //BA.debugLineNum = 63;BA.debugLine="Dim ispus As Boolean = False";
_ispus = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 65;BA.debugLine="Dim downmap As Map";
mostCurrent._downmap = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 66;BA.debugLine="Dim favmap As Map";
mostCurrent._favmap = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 68;BA.debugLine="Dim alltext As String";
mostCurrent._alltext = "";
 //BA.debugLineNum = 69;BA.debugLine="Dim hlbl As HeightLabel";
mostCurrent._hlbl = new b4a.example.heightlabel();
 //BA.debugLineNum = 70;BA.debugLine="Dim retrofit As ARRetrofit";
mostCurrent._retrofit = new ir.aminrezaei.arretrofit.ARRetrofit();
 //BA.debugLineNum = 71;BA.debugLine="Dim call As ARCall";
mostCurrent._call = new ir.aminrezaei.arretrofit.ARCall();
 //BA.debugLineNum = 72;BA.debugLine="Dim downloader As ARFileClient";
mostCurrent._downloader = new ir.aminrezaei.arretrofit.ARFileClient();
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public static String  _img_click() throws Exception{
anywheresoftware.b4a.objects.ImageViewWrapper _s = null;
 //BA.debugLineNum = 769;BA.debugLine="Sub img_Click";
 //BA.debugLineNum = 770;BA.debugLine="If canshare Then";
if (_canshare) { 
 //BA.debugLineNum = 771;BA.debugLine="Dim s As ImageView = Sender";
_s = new anywheresoftware.b4a.objects.ImageViewWrapper();
_s.setObject((android.widget.ImageView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 772;BA.debugLine="postimg=imglisnks.Get(s)";
_postimg = BA.ObjectToString(mostCurrent._imglisnks.Get((Object)(_s.getObject())));
 }else {
 //BA.debugLineNum = 775;BA.debugLine="ToastMessageShow(\"باز کردن عکس قبل از بارگزاری ص";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("باز کردن عکس قبل از بارگزاری صفحه امکان پذیر نمیباشد."),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 778;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.Map  _jsontomap(String _strjson) throws Exception{
anywheresoftware.b4a.objects.collections.Map _jmap = null;
anywheresoftware.b4a.objects.collections.JSONParser _json = null;
 //BA.debugLineNum = 328;BA.debugLine="Sub JsonToMap(strJSON As String) As Map";
 //BA.debugLineNum = 331;BA.debugLine="Dim jMap As Map";
_jmap = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 332;BA.debugLine="jMap.Initialize";
_jmap.Initialize();
 //BA.debugLineNum = 333;BA.debugLine="Dim JSON As JSONParser";
_json = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 334;BA.debugLine="JSON.Initialize(strJSON)";
_json.Initialize(_strjson);
 //BA.debugLineNum = 335;BA.debugLine="jMap = JSON.NextObject";
_jmap = _json.NextObject();
 //BA.debugLineNum = 336;BA.debugLine="Return jMap";
if (true) return _jmap;
 //BA.debugLineNum = 337;BA.debugLine="End Sub";
return null;
}
public static String  _justify_text(anywheresoftware.b4a.objects.LabelWrapper _lable) throws Exception{
ir.TeamEight.Justify.teameightjustify _jjustify = null;
 //BA.debugLineNum = 381;BA.debugLine="Sub Justify_Text(lable As Label)";
 //BA.debugLineNum = 383;BA.debugLine="Private JJustify As TeamEightJustify";
_jjustify = new ir.TeamEight.Justify.teameightjustify();
 //BA.debugLineNum = 385;BA.debugLine="JJustify.Initialize";
_jjustify._initialize(processBA);
 //BA.debugLineNum = 386;BA.debugLine="lable.text = JJustify.JustifyByExtendWords(lable,";
_lable.setText(BA.ObjectToCharSequence(_jjustify._vv3((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_lable.getObject())),_lable.getText(),anywheresoftware.b4a.keywords.Common.False,(float) (.5),anywheresoftware.b4a.keywords.Common.False)));
 //BA.debugLineNum = 387;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
 //BA.debugLineNum = 390;BA.debugLine="If lable.TextColor = Colors.Transparent Then";
if (_lable.getTextColor()==anywheresoftware.b4a.keywords.Common.Colors.Transparent) { 
 //BA.debugLineNum = 391;BA.debugLine="lable.SetTextColorAnimated(250, Colors.Black)";
_lable.SetTextColorAnimated((int) (250),anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
 //BA.debugLineNum = 395;BA.debugLine="End Sub";
return "";
}
public static String  _label2_click() throws Exception{
 //BA.debugLineNum = 202;BA.debugLine="Sub Label2_Click";
 //BA.debugLineNum = 203;BA.debugLine="Pnlprb.Visible=True";
mostCurrent._pnlprb.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 205;BA.debugLine="Label2.Visible=False";
mostCurrent._label2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 206;BA.debugLine="Label1.Visible=False";
mostCurrent._label1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 208;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.CSBuilder  _menu_change(String _onvan,int _color,anywheresoftware.b4a.keywords.constants.TypefaceWrapper _font) throws Exception{
anywheresoftware.b4a.objects.CSBuilder _cs = null;
 //BA.debugLineNum = 489;BA.debugLine="Sub menu_Change(onvan As String,color As Int,font";
 //BA.debugLineNum = 490;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
 //BA.debugLineNum = 491;BA.debugLine="cs.Initialize.Color(color).Typeface(font).Append(";
_cs.Initialize().Color(_color).Typeface((android.graphics.Typeface)(_font.getObject())).Append(BA.ObjectToCharSequence(_onvan)).PopAll();
 //BA.debugLineNum = 492;BA.debugLine="Return cs";
if (true) return _cs;
 //BA.debugLineNum = 493;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.CSBuilder  _menu_change2(String _onvan,int _color,anywheresoftware.b4a.keywords.constants.TypefaceWrapper _font) throws Exception{
anywheresoftware.b4a.objects.CSBuilder _cs = null;
 //BA.debugLineNum = 483;BA.debugLine="Sub menu_Change2(onvan As String,color As Int,font";
 //BA.debugLineNum = 484;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
 //BA.debugLineNum = 485;BA.debugLine="cs.Initialize.Color(color).Typeface(font).Alignme";
_cs.Initialize().Color(_color).Typeface((android.graphics.Typeface)(_font.getObject())).Alignment(BA.getEnumFromString(android.text.Layout.Alignment.class,"ALIGN_CENTER")).Append(BA.ObjectToCharSequence(_onvan)).PopAll();
 //BA.debugLineNum = 486;BA.debugLine="Return cs";
if (true) return _cs;
 //BA.debugLineNum = 487;BA.debugLine="End Sub";
return null;
}
public static String  _pagerlist_onerror(String _error) throws Exception{
 //BA.debugLineNum = 322;BA.debugLine="Sub pagerlist_OnError (Error As String)";
 //BA.debugLineNum = 324;BA.debugLine="Pnlprb.Visible=False";
mostCurrent._pnlprb.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 325;BA.debugLine="Label1.Visible=True";
mostCurrent._label1.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 326;BA.debugLine="Label2.Visible=True";
mostCurrent._label2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 327;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim picurl As String";
_picurl = "";
 //BA.debugLineNum = 10;BA.debugLine="Dim videolink As String";
_videolink = "";
 //BA.debugLineNum = 11;BA.debugLine="Dim isdowned As Boolean";
_isdowned = false;
 //BA.debugLineNum = 12;BA.debugLine="Dim postimg As String";
_postimg = "";
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return "";
}
public static String  _retrofits_onfileresponse(ir.aminrezaei.arretrofit.ARResponse _response) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
ir.aminrezaei.arretrofit.ARResponseBody _body = null;
String _a = "";
anywheresoftware.b4a.objects.collections.Map _root = null;
String _result = "";
anywheresoftware.b4a.objects.collections.Map _news = null;
String _thumbnail = "";
anywheresoftware.b4a.objects.collections.List _images = null;
String _colimages = "";
String _has_audio = "";
anywheresoftware.b4a.objects.collections.List _videos = null;
String _title = "";
String _content = "";
String _has_video = "";
String _manba = "";
String _has_image = "";
anywheresoftware.b4a.objects.collections.List _audios = null;
String _rutitr = "";
String _excerpt = "";
int _views = 0;
int _likes = 0;
anywheresoftware.b4a.objects.LabelWrapper _lable = null;
wir.hitex.recycler.Hitex_Utils _h = null;
 //BA.debugLineNum = 217;BA.debugLine="Sub retrofits_onFileResponse(response As ARRespons";
 //BA.debugLineNum = 218;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 219;BA.debugLine="If response.isSuccessful Then";
if (_response.isSuccessful()) { 
 //BA.debugLineNum = 220;BA.debugLine="Dim body As ARResponseBody = response.body";
_body = new ir.aminrezaei.arretrofit.ARResponseBody();
_body.setObject((okhttp3.ResponseBody)(_response.body()));
 //BA.debugLineNum = 221;BA.debugLine="Dim a As String = body.string";
_a = _body.string();
 //BA.debugLineNum = 223;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 224;BA.debugLine="parser.Initialize(a)";
_parser.Initialize(_a);
 //BA.debugLineNum = 225;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
 //BA.debugLineNum = 226;BA.debugLine="Dim result As String = root.Get(\"result\")";
_result = BA.ObjectToString(_root.Get((Object)("result")));
 //BA.debugLineNum = 227;BA.debugLine="Dim news As Map = root.Get(\"news\")";
_news = new anywheresoftware.b4a.objects.collections.Map();
_news.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_root.Get((Object)("news"))));
 //BA.debugLineNum = 228;BA.debugLine="Dim thumbnail As String = news.Get(\"thumbnail\")";
_thumbnail = BA.ObjectToString(_news.Get((Object)("thumbnail")));
 //BA.debugLineNum = 229;BA.debugLine="Dim images As List = news.Get(\"images\")";
_images = new anywheresoftware.b4a.objects.collections.List();
_images.setObject((java.util.List)(_news.Get((Object)("images"))));
 //BA.debugLineNum = 230;BA.debugLine="For Each colimages As String In images";
{
final anywheresoftware.b4a.BA.IterableList group12 = _images;
final int groupLen12 = group12.getSize()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_colimages = BA.ObjectToString(group12.Get(index12));
 }
};
 //BA.debugLineNum = 232;BA.debugLine="Dim has_audio As String = news.Get(\"has_audio\")";
_has_audio = BA.ObjectToString(_news.Get((Object)("has_audio")));
 //BA.debugLineNum = 233;BA.debugLine="Dim videos As List = news.Get(\"videos\")";
_videos = new anywheresoftware.b4a.objects.collections.List();
_videos.setObject((java.util.List)(_news.Get((Object)("videos"))));
 //BA.debugLineNum = 234;BA.debugLine="Dim title As String = news.Get(\"title\")";
_title = BA.ObjectToString(_news.Get((Object)("title")));
 //BA.debugLineNum = 235;BA.debugLine="Dim content As String = news.Get(\"content\")";
_content = BA.ObjectToString(_news.Get((Object)("content")));
 //BA.debugLineNum = 236;BA.debugLine="Dim has_video As String = news.Get(\"has_video\")";
_has_video = BA.ObjectToString(_news.Get((Object)("has_video")));
 //BA.debugLineNum = 237;BA.debugLine="Dim manba As String = news.Get(\"manba\")";
_manba = BA.ObjectToString(_news.Get((Object)("manba")));
 //BA.debugLineNum = 238;BA.debugLine="Dim has_image As String = news.Get(\"has_image\")";
_has_image = BA.ObjectToString(_news.Get((Object)("has_image")));
 //BA.debugLineNum = 239;BA.debugLine="Dim audios As List = news.Get(\"audios\")";
_audios = new anywheresoftware.b4a.objects.collections.List();
_audios.setObject((java.util.List)(_news.Get((Object)("audios"))));
 //BA.debugLineNum = 240;BA.debugLine="Dim rutitr As String = news.Get(\"rutitr\")";
_rutitr = BA.ObjectToString(_news.Get((Object)("rutitr")));
 //BA.debugLineNum = 241;BA.debugLine="Dim excerpt As String = news.Get(\"excerpt\")";
_excerpt = BA.ObjectToString(_news.Get((Object)("excerpt")));
 //BA.debugLineNum = 242;BA.debugLine="Dim views As Int = news.Get(\"views\")";
_views = (int)(BA.ObjectToNumber(_news.Get((Object)("views"))));
 //BA.debugLineNum = 243;BA.debugLine="Dim likes As Int = news.Get(\"likes\")";
_likes = (int)(BA.ObjectToNumber(_news.Get((Object)("likes"))));
 //BA.debugLineNum = 246;BA.debugLine="Dim lable As Label";
_lable = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 247;BA.debugLine="lable.Initialize(\"\")";
_lable.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 248;BA.debugLine="lable.Text=Convert_FA2EN(content)";
_lable.setText(BA.ObjectToCharSequence(_convert_fa2en(_content)));
 //BA.debugLineNum = 250;BA.debugLine="alltext=alltext&CRLF&Convert_FA2EN(content)";
mostCurrent._alltext = mostCurrent._alltext+anywheresoftware.b4a.keywords.Common.CRLF+_convert_fa2en(_content);
 //BA.debugLineNum = 251;BA.debugLine="lable.Typeface=C.irs";
_lable.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs.getObject()));
 //BA.debugLineNum = 252;BA.debugLine="Dim h As Hitex_Utils";
_h = new wir.hitex.recycler.Hitex_Utils();
 //BA.debugLineNum = 253;BA.debugLine="lable.TextColor=Colors.Black";
_lable.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 254;BA.debugLine="lable.Padding=Array As Int (20dip,5dip,20dip,0)";
_lable.setPadding(new int[]{anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),(int) (0)});
 //BA.debugLineNum = 255;BA.debugLine="lable.TextSize=14";
_lable.setTextSize((float) (14));
 //BA.debugLineNum = 256;BA.debugLine="lable.Gravity= Gravity.RIGHT";
_lable.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT);
 //BA.debugLineNum = 257;BA.debugLine="lable.Typeface=C.irs";
_lable.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs.getObject()));
 //BA.debugLineNum = 259;BA.debugLine="ScrollView1.Panel.AddView(lable,2%x,toptemp,96%x";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_lable.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2),mostCurrent.activityBA),_toptemp,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA));
 //BA.debugLineNum = 260;BA.debugLine="lable.Height=h.GetTextHeight(lable)+5%x";
_lable.setHeight((int) (_h.GetTextHeight(_lable)+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA)));
 //BA.debugLineNum = 261;BA.debugLine="toptemp=toptemp+lable.Height+5%x";
_toptemp = (int) (_toptemp+_lable.getHeight()+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA));
 //BA.debugLineNum = 268;BA.debugLine="toolbar";
_toolbar();
 //BA.debugLineNum = 276;BA.debugLine="Pnlprb.Visible=False";
mostCurrent._pnlprb.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 279;BA.debugLine="CallSubDelayed2( Me, \"Justify_Text\", lable )";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,page.getObject(),"Justify_Text",(Object)(_lable));
 };
 //BA.debugLineNum = 281;BA.debugLine="End Sub";
return "";
}
public static String  _saato_ina(String _h13) throws Exception{
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
 //BA.debugLineNum = 283;BA.debugLine="Sub saato_ina(h13 As String) As String";
 //BA.debugLineNum = 284;BA.debugLine="Dim lbl2 As String";
_lbl2 = "";
 //BA.debugLineNum = 285;BA.debugLine="Dim date As String = h13.SubString2(9,19)";
_date = _h13.substring((int) (9),(int) (19));
 //BA.debugLineNum = 286;BA.debugLine="Dim month As Int = h13.SubString2(12,14)";
_month = (int)(Double.parseDouble(_h13.substring((int) (12),(int) (14))));
 //BA.debugLineNum = 287;BA.debugLine="Dim day As Int = h13.SubString2(9,11)";
_day = (int)(Double.parseDouble(_h13.substring((int) (9),(int) (11))));
 //BA.debugLineNum = 288;BA.debugLine="Dim year As Int = h13.SubString2(15,19)";
_year = (int)(Double.parseDouble(_h13.substring((int) (15),(int) (19))));
 //BA.debugLineNum = 289;BA.debugLine="Dim saat As Int = h13.SubString2(0,2)";
_saat = (int)(Double.parseDouble(_h13.substring((int) (0),(int) (2))));
 //BA.debugLineNum = 290;BA.debugLine="Dim minu As String = h13.SubString2(3,5)";
_minu = _h13.substring((int) (3),(int) (5));
 //BA.debugLineNum = 291;BA.debugLine="Dim minu2 As Int = h13.SubString2(3,5)";
_minu2 = (int)(Double.parseDouble(_h13.substring((int) (3),(int) (5))));
 //BA.debugLineNum = 292;BA.debugLine="Log(saat)";
anywheresoftware.b4a.keywords.Common.LogImpl("24587529",BA.NumberToString(_saat),0);
 //BA.debugLineNum = 293;BA.debugLine="Log(minu)";
anywheresoftware.b4a.keywords.Common.LogImpl("24587530",_minu,0);
 //BA.debugLineNum = 295;BA.debugLine="lbl2=date.Replace(\"-\",\"/\") & \" در \"& saat&\":\"&min";
_lbl2 = _date.replace("-","/")+" در "+BA.NumberToString(_saat)+":"+_minu;
 //BA.debugLineNum = 296;BA.debugLine="Dim manam As ManamPerianDateUltimate";
_manam = new ir.anamsoftware.persiandateultimate.ManamPDUltimate();
 //BA.debugLineNum = 297;BA.debugLine="If year=manam.PersianYear Then";
if (_year==_manam.getPersianYear()) { 
 //BA.debugLineNum = 298;BA.debugLine="If month=manam.PersianMonth Then";
if (_month==_manam.getPersianMonth()) { 
 //BA.debugLineNum = 299;BA.debugLine="If day=(manam.PersianDay)-1 Then";
if (_day==(_manam.getPersianDay())-1) { 
 //BA.debugLineNum = 300;BA.debugLine="lbl2=\"دیروز در \"& saat&\":\"&minu";
_lbl2 = "دیروز در "+BA.NumberToString(_saat)+":"+_minu;
 };
 //BA.debugLineNum = 302;BA.debugLine="If day<(manam.PersianDay)-1 Then";
if (_day<(_manam.getPersianDay())-1) { 
 //BA.debugLineNum = 303;BA.debugLine="lbl2=((manam.PersianDay)-day)&\" روز پیش در \"&";
_lbl2 = BA.NumberToString(((_manam.getPersianDay())-_day))+" روز پیش در "+BA.NumberToString(_saat)+":"+_minu;
 };
 //BA.debugLineNum = 305;BA.debugLine="If day=(manam.PersianDay) Then";
if (_day==(_manam.getPersianDay())) { 
 //BA.debugLineNum = 306;BA.debugLine="If saat<(DateTime.GetHour(DateTime.Now)) Then";
if (_saat<(anywheresoftware.b4a.keywords.Common.DateTime.GetHour(anywheresoftware.b4a.keywords.Common.DateTime.getNow()))) { 
 //BA.debugLineNum = 307;BA.debugLine="lbl2=((DateTime.GetHour(DateTime.Now))-saat)";
_lbl2 = BA.NumberToString(((anywheresoftware.b4a.keywords.Common.DateTime.GetHour(anywheresoftware.b4a.keywords.Common.DateTime.getNow()))-_saat))+" ساعت پیش";
 }else {
 //BA.debugLineNum = 310;BA.debugLine="If minu2<(DateTime.GetMinute(DateTime.Now)) T";
if (_minu2<(anywheresoftware.b4a.keywords.Common.DateTime.GetMinute(anywheresoftware.b4a.keywords.Common.DateTime.getNow()))) { 
 //BA.debugLineNum = 311;BA.debugLine="lbl2=((DateTime.GetMinute(DateTime.Now))-min";
_lbl2 = BA.NumberToString(((anywheresoftware.b4a.keywords.Common.DateTime.GetMinute(anywheresoftware.b4a.keywords.Common.DateTime.getNow()))-_minu2))+" دقیقه پیش";
 }else {
 //BA.debugLineNum = 313;BA.debugLine="lbl2=\"همین حالا\"";
_lbl2 = "همین حالا";
 };
 };
 };
 };
 };
 //BA.debugLineNum = 319;BA.debugLine="Dim utils As Hitex_Utils";
_utils = new wir.hitex.recycler.Hitex_Utils();
 //BA.debugLineNum = 320;BA.debugLine="Return utils.EnToFa(lbl2)";
if (true) return _utils.EnToFa(_lbl2);
 //BA.debugLineNum = 321;BA.debugLine="End Sub";
return "";
}
public static String  _scrollview1_scrollchanged(int _position) throws Exception{
int _x = 0;
anywheresoftware.b4a.objects.drawable.GradientDrawable _gradient1 = null;
int[] _clrs = null;
 //BA.debugLineNum = 411;BA.debugLine="Sub ScrollView1_ScrollChanged(Position As Int)";
 //BA.debugLineNum = 412;BA.debugLine="Try";
try { //BA.debugLineNum = 413;BA.debugLine="Dim x As Int";
_x = 0;
 //BA.debugLineNum = 414;BA.debugLine="If Position>0 And Position<500 Then";
if (_position>0 && _position<500) { 
 //BA.debugLineNum = 415;BA.debugLine="x=Position";
_x = _position;
 //BA.debugLineNum = 416;BA.debugLine="Paneldark.Color=Colors.ARGB(x/2,0,0,0)";
mostCurrent._paneldark.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (_x/(double)2),(int) (0),(int) (0),(int) (0)));
 }else if(_position<3) { 
 //BA.debugLineNum = 418;BA.debugLine="Paneldark.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._paneldark.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
 }else if(_position>500) { 
 //BA.debugLineNum = 420;BA.debugLine="Paneldark.Color=Colors.ARGB(255,0,0,0)";
mostCurrent._paneldark.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (0),(int) (0),(int) (0)));
 };
 //BA.debugLineNum = 423;BA.debugLine="If Position>0 And Position<256 Then";
if (_position>0 && _position<256) { 
 //BA.debugLineNum = 424;BA.debugLine="x=Position";
_x = _position;
 //BA.debugLineNum = 426;BA.debugLine="Dim Gradient1 As GradientDrawable";
_gradient1 = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
 //BA.debugLineNum = 427;BA.debugLine="Dim Clrs(2) As Int";
_clrs = new int[(int) (2)];
;
 //BA.debugLineNum = 428;BA.debugLine="If Position<156 Then";
if (_position<156) { 
 //BA.debugLineNum = 429;BA.debugLine="Clrs(0) =Colors.ARGB(100+x,0,87,0)";
_clrs[(int) (0)] = anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (100+_x),(int) (0),(int) (87),(int) (0));
 //BA.debugLineNum = 430;BA.debugLine="toolbartemp.Color=Colors.ARGB(100+x,0,87,0)";
mostCurrent._toolbartemp.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (100+_x),(int) (0),(int) (87),(int) (0)));
 }else {
 //BA.debugLineNum = 432;BA.debugLine="Clrs(0) =0xFF005700";
_clrs[(int) (0)] = (int) (0xff005700);
 //BA.debugLineNum = 433;BA.debugLine="toolbartemp.Color=0xFF005700";
mostCurrent._toolbartemp.setColor((int) (0xff005700));
 };
 //BA.debugLineNum = 436;BA.debugLine="Clrs(1) = Colors.ARGB(x,0,87,0)";
_clrs[(int) (1)] = anywheresoftware.b4a.keywords.Common.Colors.ARGB(_x,(int) (0),(int) (87),(int) (0));
 //BA.debugLineNum = 437;BA.debugLine="Gradient1.Initialize(\"TOP_BOTTOM\", Clrs)";
_gradient1.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clrs);
 //BA.debugLineNum = 438;BA.debugLine="ACToolBarLight1.Background=Gradient1";
mostCurrent._actoolbarlight1.setBackground((android.graphics.drawable.Drawable)(_gradient1.getObject()));
 //BA.debugLineNum = 443;BA.debugLine="ACToolBarLight1.TitleTextColor=Colors.ARGB(x,25";
mostCurrent._actoolbarlight1.setTitleTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB(_x,(int) (255),(int) (255),(int) (255)));
 }else if(_position<3) { 
 //BA.debugLineNum = 445;BA.debugLine="Dim Gradient1 As GradientDrawable";
_gradient1 = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
 //BA.debugLineNum = 446;BA.debugLine="Dim Clrs(2) As Int";
_clrs = new int[(int) (2)];
;
 //BA.debugLineNum = 447;BA.debugLine="Clrs(0) =Colors.ARGB(100,0,39,0)";
_clrs[(int) (0)] = anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (100),(int) (0),(int) (39),(int) (0));
 //BA.debugLineNum = 448;BA.debugLine="Clrs(1) = Colors.Transparent";
_clrs[(int) (1)] = anywheresoftware.b4a.keywords.Common.Colors.Transparent;
 //BA.debugLineNum = 449;BA.debugLine="Gradient1.Initialize(\"TOP_BOTTOM\", Clrs)";
_gradient1.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clrs);
 //BA.debugLineNum = 450;BA.debugLine="ACToolBarLight1.Background=Gradient1";
mostCurrent._actoolbarlight1.setBackground((android.graphics.drawable.Drawable)(_gradient1.getObject()));
 //BA.debugLineNum = 451;BA.debugLine="toolbartemp.Color=Colors.ARGB(100,0,39,0)";
mostCurrent._toolbartemp.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (100),(int) (0),(int) (39),(int) (0)));
 //BA.debugLineNum = 452;BA.debugLine="ACToolBarLight1.TitleTextColor=Colors.ARGB(0,25";
mostCurrent._actoolbarlight1.setTitleTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (255),(int) (255),(int) (255)));
 }else if(_position>500) { 
 //BA.debugLineNum = 455;BA.debugLine="Dim Gradient1 As GradientDrawable";
_gradient1 = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
 //BA.debugLineNum = 456;BA.debugLine="Dim Clrs(2) As Int";
_clrs = new int[(int) (2)];
;
 //BA.debugLineNum = 457;BA.debugLine="Clrs(0) =0xFF005700";
_clrs[(int) (0)] = (int) (0xff005700);
 //BA.debugLineNum = 458;BA.debugLine="Clrs(1) = 0xFF005700";
_clrs[(int) (1)] = (int) (0xff005700);
 //BA.debugLineNum = 459;BA.debugLine="Gradient1.Initialize(\"TOP_BOTTOM\", Clrs)";
_gradient1.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clrs);
 //BA.debugLineNum = 460;BA.debugLine="ACToolBarLight1.Background=Gradient1";
mostCurrent._actoolbarlight1.setBackground((android.graphics.drawable.Drawable)(_gradient1.getObject()));
 //BA.debugLineNum = 461;BA.debugLine="toolbartemp.Color=0xFF005700";
mostCurrent._toolbartemp.setColor((int) (0xff005700));
 //BA.debugLineNum = 463;BA.debugLine="ACToolBarLight1.TitleTextColor=Colors.ARGB(255,";
mostCurrent._actoolbarlight1.setTitleTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 464;BA.debugLine="lbltoolbar.Padding = Array As Int (0, 10dip, 0,";
mostCurrent._lbltoolbar.setPadding(new int[]{(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (0),(int) (0)});
 };
 //BA.debugLineNum = 466;BA.debugLine="Try";
try { //BA.debugLineNum = 467;BA.debugLine="If 56dip+((Position/3)*-1)>=10dip Then";
if (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (56))+((_position/(double)3)*-1)>=anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))) { 
 //BA.debugLineNum = 468;BA.debugLine="lbltoolbar.Padding = Array As Int (0, 56dip+((";
mostCurrent._lbltoolbar.setPadding(new int[]{(int) (0),(int) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (56))+((_position/(double)3)*-1)),(int) (0),(int) (0)});
 };
 } 
       catch (Exception e51) {
			processBA.setLastException(e51); };
 //BA.debugLineNum = 475;BA.debugLine="Img.Top=(Position/2)*-1";
mostCurrent._img.setTop((int) ((_position/(double)2)*-1));
 } 
       catch (Exception e54) {
			processBA.setLastException(e54); };
 //BA.debugLineNum = 482;BA.debugLine="End Sub";
return "";
}
public static String  _set_ripple(anywheresoftware.b4a.objects.LabelWrapper _label) throws Exception{
anywheresoftware.b4a.phone.Phone _phone1 = null;
anywheresoftware.b4j.object.JavaObject _imageviewjo = null;
anywheresoftware.b4j.object.JavaObject _colorstate = null;
anywheresoftware.b4j.object.JavaObject _rippledrawable = null;
 //BA.debugLineNum = 177;BA.debugLine="Sub set_Ripple(label As Label)";
 //BA.debugLineNum = 178;BA.debugLine="Dim phone1 As Phone";
_phone1 = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 179;BA.debugLine="If phone1.SdkVersion<21 Then";
if (_phone1.getSdkVersion()<21) { 
 }else {
 //BA.debugLineNum = 181;BA.debugLine="Dim ImageViewJo As JavaObject = label";
_imageviewjo = new anywheresoftware.b4j.object.JavaObject();
_imageviewjo.setObject((java.lang.Object)(_label.getObject()));
 //BA.debugLineNum = 182;BA.debugLine="Dim ColorState As JavaObject";
_colorstate = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 183;BA.debugLine="ColorState.InitializeStatic(\"android.content.res";
_colorstate.InitializeStatic("android.content.res.ColorStateList");
 //BA.debugLineNum = 184;BA.debugLine="Dim RippleDrawable As JavaObject";
_rippledrawable = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 185;BA.debugLine="RippleDrawable.InitializeNewInstance(\"android.gr";
_rippledrawable.InitializeNewInstance("android.graphics.drawable.RippleDrawable",new Object[]{_colorstate.RunMethod("valueOf",new Object[]{(Object)(0x78000000)}),anywheresoftware.b4a.keywords.Common.Null,anywheresoftware.b4a.keywords.Common.Null});
 //BA.debugLineNum = 186;BA.debugLine="ImageViewJo.RunMethod(\"setBackground\",Array(Ripp";
_imageviewjo.RunMethod("setBackground",new Object[]{(Object)(_rippledrawable.getObject())});
 };
 //BA.debugLineNum = 188;BA.debugLine="End Sub";
return "";
}
public static String  _setalllabel() throws Exception{
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
String[] _h13 = null;
String _hhh = "";
int _m = 0;
 //BA.debugLineNum = 738;BA.debugLine="Sub SetAllLabel";
 //BA.debugLineNum = 739;BA.debugLine="Try";
try { //BA.debugLineNum = 740;BA.debugLine="For Each v As View In Activity.GetAllViewsRecurs";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group2 = mostCurrent._activity.GetAllViewsRecursive();
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_v.setObject((android.view.View)(group2.Get(index2)));
 //BA.debugLineNum = 741;BA.debugLine="If GetType(v) = \"android.widget.TextView\" Then";
if ((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("android.widget.TextView")) { 
 //BA.debugLineNum = 742;BA.debugLine="Dim lbl As Label = v";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl.setObject((android.widget.TextView)(_v.getObject()));
 //BA.debugLineNum = 743;BA.debugLine="Dim h13() As String=Regex.Split(CRLF,lbl.Text)";
_h13 = anywheresoftware.b4a.keywords.Common.Regex.Split(anywheresoftware.b4a.keywords.Common.CRLF,_lbl.getText());
 //BA.debugLineNum = 744;BA.debugLine="Dim hhh As String";
_hhh = "";
 //BA.debugLineNum = 745;BA.debugLine="For m = 0 To h13.Length-1";
{
final int step7 = 1;
final int limit7 = (int) (_h13.length-1);
_m = (int) (0) ;
for (;_m <= limit7 ;_m = _m + step7 ) {
 //BA.debugLineNum = 746;BA.debugLine="If h13(m).Contains(\"بیتوته\") Or h13(m).Contai";
if (_h13[_m].contains("بیتوته") || _h13[_m].contains("منبع") || (_h13[_m]).equals("") || (_h13[_m]).equals(" ")) { 
 }else {
 //BA.debugLineNum = 748;BA.debugLine="hhh=hhh+h13(m)";
_hhh = BA.NumberToString((double)(Double.parseDouble(_hhh))+(double)(Double.parseDouble(_h13[_m])));
 };
 }
};
 //BA.debugLineNum = 751;BA.debugLine="lbl.Text=hhh";
_lbl.setText(BA.ObjectToCharSequence(_hhh));
 };
 }
};
 } 
       catch (Exception e17) {
			processBA.setLastException(e17); };
 //BA.debugLineNum = 759;BA.debugLine="End Sub";
return "";
}
public static String  _settextshadow(anywheresoftware.b4a.objects.ConcreteViewWrapper _pview,float _pradius,float _pdx,float _pdy,int _pcolor) throws Exception{
anywheresoftware.b4a.agraham.reflection.Reflection _ref = null;
 //BA.debugLineNum = 1046;BA.debugLine="Sub SetTextShadow(pView As View, pRadius As Float,";
 //BA.debugLineNum = 1047;BA.debugLine="Dim ref As Reflector";
_ref = new anywheresoftware.b4a.agraham.reflection.Reflection();
 //BA.debugLineNum = 1049;BA.debugLine="ref.Target = pView";
_ref.Target = (Object)(_pview.getObject());
 //BA.debugLineNum = 1050;BA.debugLine="ref.RunMethod4(\"setShadowLayer\", Array As Object(";
_ref.RunMethod4("setShadowLayer",new Object[]{(Object)(_pradius),(Object)(_pdx),(Object)(_pdy),(Object)(_pcolor)},new String[]{"java.lang.float","java.lang.float","java.lang.float","java.lang.int"});
 //BA.debugLineNum = 1051;BA.debugLine="End Sub";
return "";
}
public static String  _share_click() throws Exception{
anywheresoftware.b4a.ariagplib.ARIAlib _aria = null;
 //BA.debugLineNum = 522;BA.debugLine="Sub share_Click";
 //BA.debugLineNum = 523;BA.debugLine="Dim Aria As AriaLib";
_aria = new anywheresoftware.b4a.ariagplib.ARIAlib();
 //BA.debugLineNum = 528;BA.debugLine="StartActivity( Aria.ShareText(Main.txtnewstitle&C";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_aria.ShareText(mostCurrent._main._txtnewstitle+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._alltext+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"برگرفته از اپلیکیشن هواداری ؛"+anywheresoftware.b4a.keywords.Common.CRLF+"https://cafebazaar.ir/app/"+anywheresoftware.b4a.keywords.Common.Application.getPackageName()+"/?l=fa","اشتراک گذاری با ؛")));
 //BA.debugLineNum = 532;BA.debugLine="End Sub";
return "";
}
public static String  _showbigpik() throws Exception{
 //BA.debugLineNum = 199;BA.debugLine="Sub showbigpik";
 //BA.debugLineNum = 201;BA.debugLine="End Sub";
return "";
}
public static String  _toolbar() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pntool = null;
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
 //BA.debugLineNum = 715;BA.debugLine="Sub toolbar";
 //BA.debugLineNum = 716;BA.debugLine="ScrollView1.Panel.Height=toptemp+10%x";
mostCurrent._scrollview1.getPanel().setHeight((int) (_toptemp+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA)));
 //BA.debugLineNum = 717;BA.debugLine="pnlmatlab.Height=toptemp";
mostCurrent._pnlmatlab.setHeight(_toptemp);
 //BA.debugLineNum = 718;BA.debugLine="ACToolBarLight1.Title=Main.txtnewstitle";
mostCurrent._actoolbarlight1.setTitle(BA.ObjectToCharSequence(mostCurrent._main._txtnewstitle));
 //BA.debugLineNum = 720;BA.debugLine="Dim Pntool As Panel = ACToolBarLight1";
_pntool = new anywheresoftware.b4a.objects.PanelWrapper();
_pntool.setObject((android.view.ViewGroup)(mostCurrent._actoolbarlight1.getObject()));
 //BA.debugLineNum = 721;BA.debugLine="For Each v As View In Pntool";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group5 = _pntool;
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_v.setObject((android.view.View)(group5.Get(index5)));
 //BA.debugLineNum = 722;BA.debugLine="If v Is Label Then";
if (_v.getObjectOrNull() instanceof android.widget.TextView) { 
 //BA.debugLineNum = 723;BA.debugLine="lbltoolbar = v";
mostCurrent._lbltoolbar.setObject((android.widget.TextView)(_v.getObject()));
 //BA.debugLineNum = 724;BA.debugLine="Select lbltoolbar.text";
switch (BA.switchObjectToInt(mostCurrent._lbltoolbar.getText(),mostCurrent._actoolbarlight1.getTitle())) {
case 0: {
 //BA.debugLineNum = 726;BA.debugLine="lbltoolbar.Typeface = C.irs";
mostCurrent._lbltoolbar.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs.getObject()));
 //BA.debugLineNum = 727;BA.debugLine="lbltoolbar.TextSize=15";
mostCurrent._lbltoolbar.setTextSize((float) (15));
 //BA.debugLineNum = 728;BA.debugLine="lbltoolbar.Padding = Array As Int (0, 4dip, 0";
mostCurrent._lbltoolbar.setPadding(new int[]{(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4)),(int) (0),(int) (0)});
 //BA.debugLineNum = 729;BA.debugLine="lbltoolbar.Color=Colors.Transparent";
mostCurrent._lbltoolbar.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
 //BA.debugLineNum = 730;BA.debugLine="lbltoolbar.Height=56dip";
mostCurrent._lbltoolbar.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (56)));
 break; }
}
;
 };
 }
};
 //BA.debugLineNum = 735;BA.debugLine="End Sub";
return "";
}
public static void  _zoom_in_click() throws Exception{
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

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 509;BA.debugLine="fsize=fsize+2";
parent._fsize = (int) (parent._fsize+2);
 //BA.debugLineNum = 510;BA.debugLine="File.WriteString(File.DirInternal,\"fsize\",fsize)";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"fsize",BA.NumberToString(parent._fsize));
 //BA.debugLineNum = 511;BA.debugLine="Sleep(0)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (0));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 513;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 //BA.debugLineNum = 514;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _zoom_out_click() throws Exception{
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

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 516;BA.debugLine="fsize=fsize-2";
parent._fsize = (int) (parent._fsize-2);
 //BA.debugLineNum = 517;BA.debugLine="File.WriteString(File.DirInternal,\"fsize\",fsize)";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"fsize",BA.NumberToString(parent._fsize));
 //BA.debugLineNum = 518;BA.debugLine="Sleep(0)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (0));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 520;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 //BA.debugLineNum = 521;BA.debugLine="End Sub";
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
