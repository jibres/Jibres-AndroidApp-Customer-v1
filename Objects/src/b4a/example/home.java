package b4a.example;


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

public class home extends Activity implements B4AActivity{
	public static home mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.home");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (home).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.home");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.home", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (home) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (home) Resume **");
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
		return home.class;
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
        BA.LogInfo("** Activity (home) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            home mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (home) Resume **");
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
public static anywheresoftware.b4a.objects.Timer _t_shegeft = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblbsk = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _sv = null;
public com.porya.pagerbullet.PagerBulletWrapper _pb = null;
public com.porya.pagerbullet.PagerBulletAdapter _pa = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblho = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblmin = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblsecend = null;
public static long _time313 = 0L;
public anywheresoftware.b4a.objects.LabelWrapper _lbltitletop = null;
public wir.hitex.recycler.Hitex_LayoutView[] _lv_prod = null;
public b4a.example.main _main = null;
public b4a.example.act_tip _act_tip = null;
public b4a.example.login _login = null;
public b4a.example.verify _verify = null;
public b4a.example.c _c = null;
public b4a.example.starter _starter = null;
public b4a.example.page _page = null;
public b4a.example.finger _finger = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="home";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
de.amberhome.objects.appcompat.AppCompatBase _ac = null;
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _oo = null;
anywheresoftware.b4a.objects.collections.List _lst = null;
aghajari.retrofit.Retrofit _retrofit = null;
aghajari.retrofit.Builder _builder = null;
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="Dim ac As AppCompat";
_ac = new de.amberhome.objects.appcompat.AppCompatBase();
RDebugUtils.currentLine=2097156;
 //BA.debugLineNum = 2097156;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="C.PnlCreate(pnl,\"\",Activity,0,0,-1,56dip+ac.GetSt";
mostCurrent._c._pnlcreate /*String*/ (mostCurrent.activityBA,_pnl,"",mostCurrent._activity,(int) (0),(int) (0),(int) (-1),(int) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (56))+_ac.GetStatusBarHeight(mostCurrent.activityBA)));
RDebugUtils.currentLine=2097158;
 //BA.debugLineNum = 2097158;BA.debugLine="pnl.Color=0xFF920000";
_pnl.setColor((int) (0xff920000));
RDebugUtils.currentLine=2097159;
 //BA.debugLineNum = 2097159;BA.debugLine="pnl.Elevation=4dip";
_pnl.setElevation((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))));
RDebugUtils.currentLine=2097162;
 //BA.debugLineNum = 2097162;BA.debugLine="C.setlblset(lbltitletop,\"\",pnl,0,ac.GetStatusBarH";
mostCurrent._c._setlblset /*String*/ (mostCurrent.activityBA,mostCurrent._lbltitletop,"",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_pnl.getObject())),(int) (0),_ac.GetStatusBarHeight(mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (56))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (56)),"دی جی کالا",mostCurrent._c._rcenter /*int*/ ,mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ ,(int) (20),anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2097164;
 //BA.debugLineNum = 2097164;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2097165;
 //BA.debugLineNum = 2097165;BA.debugLine="C.setlblset(lbl,\"menue\",pnl,100%x-56dip,ac.GetSta";
mostCurrent._c._setlblset /*String*/ (mostCurrent.activityBA,_lbl,"menue",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_pnl.getObject())),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (56))),_ac.GetStatusBarHeight(mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (56)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (56)),BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe5d2))),anywheresoftware.b4a.keywords.Common.Gravity.CENTER,(anywheresoftware.b4a.keywords.constants.TypefaceWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.constants.TypefaceWrapper(), (android.graphics.Typeface)(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS())),(int) (25),anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2097166;
 //BA.debugLineNum = 2097166;BA.debugLine="ac.SetClickEffect(lbl,True)";
_ac.SetClickEffect(mostCurrent.activityBA,(android.view.View)(_lbl.getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2097168;
 //BA.debugLineNum = 2097168;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2097169;
 //BA.debugLineNum = 2097169;BA.debugLine="C.setlblset(lbl,\"bask\",pnl,0,ac.GetStatusBarHeigh";
mostCurrent._c._setlblset /*String*/ (mostCurrent.activityBA,_lbl,"bask",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_pnl.getObject())),(int) (0),_ac.GetStatusBarHeight(mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (56)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (56)),BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe8cc))),anywheresoftware.b4a.keywords.Common.Gravity.CENTER,(anywheresoftware.b4a.keywords.constants.TypefaceWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.constants.TypefaceWrapper(), (android.graphics.Typeface)(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS())),(int) (25),anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2097170;
 //BA.debugLineNum = 2097170;BA.debugLine="ac.SetClickEffect(lbl,True)";
_ac.SetClickEffect(mostCurrent.activityBA,(android.view.View)(_lbl.getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2097173;
 //BA.debugLineNum = 2097173;BA.debugLine="C.setlblset(lblbsk,\"bask\",pnl,30dip,ac.GetStatusB";
mostCurrent._c._setlblset /*String*/ (mostCurrent.activityBA,mostCurrent._lblbsk,"bask",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_pnl.getObject())),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),(int) (_ac.GetStatusBarHeight(mostCurrent.activityBA)+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (6))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),"1",anywheresoftware.b4a.keywords.Common.Gravity.CENTER,mostCurrent._c._irsb /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ ,(int) (10),(int) (0xff920000));
RDebugUtils.currentLine=2097174;
 //BA.debugLineNum = 2097174;BA.debugLine="Dim oo As ColorDrawable";
_oo = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=2097175;
 //BA.debugLineNum = 2097175;BA.debugLine="oo.Initialize2(-1,5555,2dip,0xFF920000)";
_oo.Initialize2((int) (-1),(int) (5555),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),(int) (0xff920000));
RDebugUtils.currentLine=2097176;
 //BA.debugLineNum = 2097176;BA.debugLine="lblbsk.Background=oo";
mostCurrent._lblbsk.setBackground((android.graphics.drawable.Drawable)(_oo.getObject()));
RDebugUtils.currentLine=2097177;
 //BA.debugLineNum = 2097177;BA.debugLine="lblbsk.Padding = Array As Int (0, 2dip, 0, 0)";
mostCurrent._lblbsk.setPadding(new int[]{(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),(int) (0),(int) (0)});
RDebugUtils.currentLine=2097179;
 //BA.debugLineNum = 2097179;BA.debugLine="sv.Initialize(420%x)";
mostCurrent._sv.Initialize(mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (420),mostCurrent.activityBA));
RDebugUtils.currentLine=2097180;
 //BA.debugLineNum = 2097180;BA.debugLine="Activity.AddView(sv,0,56dip+ac.GetStatusBarHeight";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._sv.getObject()),(int) (0),(int) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (56))+_ac.GetStatusBarHeight(mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (56))+_ac.GetStatusBarHeight(mostCurrent.activityBA))));
RDebugUtils.currentLine=2097184;
 //BA.debugLineNum = 2097184;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2097185;
 //BA.debugLineNum = 2097185;BA.debugLine="lst.Initialize";
_lst.Initialize();
RDebugUtils.currentLine=2097186;
 //BA.debugLineNum = 2097186;BA.debugLine="lst.Add(\"سلام#سلام\")";
_lst.Add((Object)("سلام#سلام"));
RDebugUtils.currentLine=2097187;
 //BA.debugLineNum = 2097187;BA.debugLine="lst.Add(\"سلایلبلم#سلامسلام\")";
_lst.Add((Object)("سلایلبلم#سلامسلام"));
RDebugUtils.currentLine=2097188;
 //BA.debugLineNum = 2097188;BA.debugLine="lst.Add(\"سلازذفاتم#سلام\")";
_lst.Add((Object)("سلازذفاتم#سلام"));
RDebugUtils.currentLine=2097189;
 //BA.debugLineNum = 2097189;BA.debugLine="lst.Add(\"سهعهعهلام#سلامسلامسلام\")";
_lst.Add((Object)("سهعهعهلام#سلامسلامسلام"));
RDebugUtils.currentLine=2097190;
 //BA.debugLineNum = 2097190;BA.debugLine="lst.Add(\"سلایلبلم#سلامسلام\")";
_lst.Add((Object)("سلایلبلم#سلامسلام"));
RDebugUtils.currentLine=2097191;
 //BA.debugLineNum = 2097191;BA.debugLine="lst.Add(\"سلایلبلم#سلامسلام\")";
_lst.Add((Object)("سلایلبلم#سلامسلام"));
RDebugUtils.currentLine=2097192;
 //BA.debugLineNum = 2097192;BA.debugLine="lst.Add(\"سلازذفاتم#سلام\")";
_lst.Add((Object)("سلازذفاتم#سلام"));
RDebugUtils.currentLine=2097193;
 //BA.debugLineNum = 2097193;BA.debugLine="lst.Add(\"سهعهعهلام#سلامسلامسلام\")";
_lst.Add((Object)("سهعهعهلام#سلامسلامسلام"));
RDebugUtils.currentLine=2097194;
 //BA.debugLineNum = 2097194;BA.debugLine="lst.Add(\"سلازذفاتم#سلام\")";
_lst.Add((Object)("سلازذفاتم#سلام"));
RDebugUtils.currentLine=2097195;
 //BA.debugLineNum = 2097195;BA.debugLine="lst.Add(\"سهعهعهلام#سلامسلامdfسلام\")";
_lst.Add((Object)("سهعهعهلام#سلامسلامdfسلام"));
RDebugUtils.currentLine=2097197;
 //BA.debugLineNum = 2097197;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2097198;
 //BA.debugLineNum = 2097198;BA.debugLine="lst.Initialize";
_lst.Initialize();
RDebugUtils.currentLine=2097199;
 //BA.debugLineNum = 2097199;BA.debugLine="lst.Add(\"http://bamalearn.ir/wp-content/uploads/2";
_lst.Add((Object)("http://bamalearn.ir/wp-content/uploads/2019/04/rtl-toolbar-b4a-348x215.jpg"));
RDebugUtils.currentLine=2097200;
 //BA.debugLineNum = 2097200;BA.debugLine="lst.Add(\"http://bamalearn.ir/wp-content/uploads/2";
_lst.Add((Object)("http://bamalearn.ir/wp-content/uploads/2019/04/rtl-toolbar-b4a-348x215.jpg"));
RDebugUtils.currentLine=2097210;
 //BA.debugLineNum = 2097210;BA.debugLine="Dim retrofit As Amir_Retrofit";
_retrofit = new aghajari.retrofit.Retrofit();
RDebugUtils.currentLine=2097211;
 //BA.debugLineNum = 2097211;BA.debugLine="Dim Builder As Amir_RetrofitBuilder";
_builder = new aghajari.retrofit.Builder();
RDebugUtils.currentLine=2097214;
 //BA.debugLineNum = 2097214;BA.debugLine="Builder.Initialize.baseUrl(\"https://jeebres.ir/ap";
_builder.Initialize(processBA).baseUrl("https://jeebres.ir/api/v1/y88d/");
RDebugUtils.currentLine=2097216;
 //BA.debugLineNum = 2097216;BA.debugLine="Builder.addHeader(CreateMap(\"appkey\":\"78e0b233fd4";
_builder.addHeader((java.util.Map)(anywheresoftware.b4a.keywords.Common.createMap(new Object[] {(Object)("appkey"),(Object)("78e0b233fd4ffc5ffd1eb839158c4a2d")}).getObject()));
RDebugUtils.currentLine=2097217;
 //BA.debugLineNum = 2097217;BA.debugLine="retrofit.Initialize(Builder)";
_retrofit.Initialize(processBA,_builder);
RDebugUtils.currentLine=2097218;
 //BA.debugLineNum = 2097218;BA.debugLine="retrofit.Get(\"maindata\",\"app\",Null)";
_retrofit.Get("maindata","app",(java.util.Map)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=2097219;
 //BA.debugLineNum = 2097219;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="home";
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="t_shegeft.Enabled=False";
_t_shegeft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="home";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="End Sub";
return "";
}
public static String  _banner1taee_card_creat(int _top,int _heat,String _link,String _action) throws Exception{
RDebugUtils.currentModule="home";
if (Debug.shouldDelegate(mostCurrent.activityBA, "banner1taee_card_creat", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "banner1taee_card_creat", new Object[] {_top,_heat,_link,_action}));}
de.amberhome.objects.CardViewWrapper _card = null;
anywheresoftware.b4a.objects.ImageViewWrapper _img = null;
com.hitex_glide.Hitex_Glide _glide = null;
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub banner1taee_card_creat(top As Int,heat As Int,";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="Dim card As CardView";
_card = new de.amberhome.objects.CardViewWrapper();
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="card.Initialize(\"\")";
_card.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="card.Elevation=2dip";
_card.setElevation((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=2555908;
 //BA.debugLineNum = 2555908;BA.debugLine="sv.Panel.AddView(card,2%x,top,96%x,heat*1%x)";
mostCurrent._sv.getPanel().AddView((android.view.View)(_card.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2),mostCurrent.activityBA),_top,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),(int) (_heat*anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA)));
RDebugUtils.currentLine=2555909;
 //BA.debugLineNum = 2555909;BA.debugLine="Dim img As ImageView";
_img = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=2555910;
 //BA.debugLineNum = 2555910;BA.debugLine="img.Initialize(\"\")";
_img.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2555911;
 //BA.debugLineNum = 2555911;BA.debugLine="card.AddView(img,0,0,-1,-1)";
_card.AddView((android.view.View)(_img.getObject()),(int) (0),(int) (0),(int) (-1),(int) (-1));
RDebugUtils.currentLine=2555912;
 //BA.debugLineNum = 2555912;BA.debugLine="img.Gravity=Gravity.FILL";
_img.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=2555913;
 //BA.debugLineNum = 2555913;BA.debugLine="Dim Glide As Hitex_Glide";
_glide = new com.hitex_glide.Hitex_Glide();
RDebugUtils.currentLine=2555914;
 //BA.debugLineNum = 2555914;BA.debugLine="Glide.Load2(link).CenterCrop.Into(img)";
_glide.Load2(mostCurrent.activityBA,_link).CenterCrop().Into(_img);
RDebugUtils.currentLine=2555915;
 //BA.debugLineNum = 2555915;BA.debugLine="End Sub";
return "";
}
public static String  _banner1taee_creat(int _top,int _heat,String _link,String _action) throws Exception{
RDebugUtils.currentModule="home";
if (Debug.shouldDelegate(mostCurrent.activityBA, "banner1taee_creat", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "banner1taee_creat", new Object[] {_top,_heat,_link,_action}));}
anywheresoftware.b4a.objects.ImageViewWrapper _img = null;
com.hitex_glide.Hitex_Glide _glide = null;
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub banner1taee_creat(top As Int,heat As Int,link";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="Dim img As ImageView";
_img = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="C.imgCreate(img,\"\",sv.Panel,0,top,100%x,heat*1%x)";
mostCurrent._c._imgcreate /*String*/ (mostCurrent.activityBA,_img,"",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(mostCurrent._sv.getPanel().getObject())),(int) (0),_top,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),(int) (_heat*anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA)));
RDebugUtils.currentLine=2424835;
 //BA.debugLineNum = 2424835;BA.debugLine="Dim Glide As Hitex_Glide";
_glide = new com.hitex_glide.Hitex_Glide();
RDebugUtils.currentLine=2424836;
 //BA.debugLineNum = 2424836;BA.debugLine="Glide.Load2(link).FitCenter.Into(img)";
_glide.Load2(mostCurrent.activityBA,_link).FitCenter().Into(_img);
RDebugUtils.currentLine=2424837;
 //BA.debugLineNum = 2424837;BA.debugLine="End Sub";
return "";
}
public static String  _banner2taee_card_creat(int _top,int _heat,anywheresoftware.b4a.objects.collections.List _listbannerpager) throws Exception{
RDebugUtils.currentModule="home";
if (Debug.shouldDelegate(mostCurrent.activityBA, "banner2taee_card_creat", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "banner2taee_card_creat", new Object[] {_top,_heat,_listbannerpager}));}
String[] _h13 = null;
de.amberhome.objects.CardViewWrapper _card = null;
anywheresoftware.b4a.objects.ImageViewWrapper _img = null;
com.hitex_glide.Hitex_Glide _glide = null;
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub banner2taee_card_creat(top As Int,heat As Int,";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="Dim h13() As String=Regex.Split(\"#\",ListbannerPag";
_h13 = anywheresoftware.b4a.keywords.Common.Regex.Split("#",BA.ObjectToString(_listbannerpager.Get((int) (0))));
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="Dim card As CardView";
_card = new de.amberhome.objects.CardViewWrapper();
RDebugUtils.currentLine=2621444;
 //BA.debugLineNum = 2621444;BA.debugLine="card.Initialize(\"\")";
_card.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2621445;
 //BA.debugLineNum = 2621445;BA.debugLine="card.Elevation=2dip";
_card.setElevation((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=2621446;
 //BA.debugLineNum = 2621446;BA.debugLine="sv.Panel.AddView(card,2%x,top,47%x,heat*1%x)";
mostCurrent._sv.getPanel().AddView((android.view.View)(_card.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2),mostCurrent.activityBA),_top,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (47),mostCurrent.activityBA),(int) (_heat*anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA)));
RDebugUtils.currentLine=2621447;
 //BA.debugLineNum = 2621447;BA.debugLine="Dim img As ImageView";
_img = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=2621448;
 //BA.debugLineNum = 2621448;BA.debugLine="img.Initialize(\"\")";
_img.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2621449;
 //BA.debugLineNum = 2621449;BA.debugLine="card.AddView(img,0,0,-1,-1)";
_card.AddView((android.view.View)(_img.getObject()),(int) (0),(int) (0),(int) (-1),(int) (-1));
RDebugUtils.currentLine=2621450;
 //BA.debugLineNum = 2621450;BA.debugLine="img.Gravity=Gravity.FILL";
_img.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=2621451;
 //BA.debugLineNum = 2621451;BA.debugLine="Dim Glide As Hitex_Glide";
_glide = new com.hitex_glide.Hitex_Glide();
RDebugUtils.currentLine=2621452;
 //BA.debugLineNum = 2621452;BA.debugLine="Glide.Load2(h13(0)).CenterCrop.Into(img)";
_glide.Load2(mostCurrent.activityBA,_h13[(int) (0)]).CenterCrop().Into(_img);
RDebugUtils.currentLine=2621454;
 //BA.debugLineNum = 2621454;BA.debugLine="Dim h13() As String=Regex.Split(\"#\",ListbannerPag";
_h13 = anywheresoftware.b4a.keywords.Common.Regex.Split("#",BA.ObjectToString(_listbannerpager.Get((int) (1))));
RDebugUtils.currentLine=2621455;
 //BA.debugLineNum = 2621455;BA.debugLine="Dim card As CardView";
_card = new de.amberhome.objects.CardViewWrapper();
RDebugUtils.currentLine=2621456;
 //BA.debugLineNum = 2621456;BA.debugLine="card.Initialize(\"\")";
_card.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2621457;
 //BA.debugLineNum = 2621457;BA.debugLine="card.Elevation=2dip";
_card.setElevation((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=2621458;
 //BA.debugLineNum = 2621458;BA.debugLine="sv.Panel.AddView(card,51%x,top,47%x,heat*1%x)";
mostCurrent._sv.getPanel().AddView((android.view.View)(_card.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51),mostCurrent.activityBA),_top,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (47),mostCurrent.activityBA),(int) (_heat*anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA)));
RDebugUtils.currentLine=2621459;
 //BA.debugLineNum = 2621459;BA.debugLine="Dim img As ImageView";
_img = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=2621460;
 //BA.debugLineNum = 2621460;BA.debugLine="img.Initialize(\"\")";
_img.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2621461;
 //BA.debugLineNum = 2621461;BA.debugLine="card.AddView(img,0,0,-1,-1)";
_card.AddView((android.view.View)(_img.getObject()),(int) (0),(int) (0),(int) (-1),(int) (-1));
RDebugUtils.currentLine=2621462;
 //BA.debugLineNum = 2621462;BA.debugLine="img.Gravity=Gravity.FILL";
_img.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=2621463;
 //BA.debugLineNum = 2621463;BA.debugLine="Dim Glide As Hitex_Glide";
_glide = new com.hitex_glide.Hitex_Glide();
RDebugUtils.currentLine=2621464;
 //BA.debugLineNum = 2621464;BA.debugLine="Glide.Load2(h13(0)).CenterCrop.Into(img)";
_glide.Load2(mostCurrent.activityBA,_h13[(int) (0)]).CenterCrop().Into(_img);
RDebugUtils.currentLine=2621465;
 //BA.debugLineNum = 2621465;BA.debugLine="End Sub";
return "";
}
public static String  _banner2taee_creat(int _top,int _heat,anywheresoftware.b4a.objects.collections.List _listbannerpager) throws Exception{
RDebugUtils.currentModule="home";
if (Debug.shouldDelegate(mostCurrent.activityBA, "banner2taee_creat", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "banner2taee_creat", new Object[] {_top,_heat,_listbannerpager}));}
String[] _h13 = null;
anywheresoftware.b4a.objects.ImageViewWrapper _img = null;
com.hitex_glide.Hitex_Glide _glide = null;
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub banner2taee_creat(top As Int,heat As Int,Listb";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="Dim h13() As String=Regex.Split(\"#\",ListbannerPag";
_h13 = anywheresoftware.b4a.keywords.Common.Regex.Split("#",BA.ObjectToString(_listbannerpager.Get((int) (0))));
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="Dim img As ImageView";
_img = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=2490371;
 //BA.debugLineNum = 2490371;BA.debugLine="C.imgCreate(img,\"\",sv.Panel,0,top,50%x,heat*1%x)";
mostCurrent._c._imgcreate /*String*/ (mostCurrent.activityBA,_img,"",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(mostCurrent._sv.getPanel().getObject())),(int) (0),_top,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA),(int) (_heat*anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA)));
RDebugUtils.currentLine=2490372;
 //BA.debugLineNum = 2490372;BA.debugLine="Dim Glide As Hitex_Glide";
_glide = new com.hitex_glide.Hitex_Glide();
RDebugUtils.currentLine=2490373;
 //BA.debugLineNum = 2490373;BA.debugLine="Glide.Load2(h13(0)).FitCenter.Into(img)";
_glide.Load2(mostCurrent.activityBA,_h13[(int) (0)]).FitCenter().Into(_img);
RDebugUtils.currentLine=2490375;
 //BA.debugLineNum = 2490375;BA.debugLine="Dim h13() As String=Regex.Split(\"#\",ListbannerPag";
_h13 = anywheresoftware.b4a.keywords.Common.Regex.Split("#",BA.ObjectToString(_listbannerpager.Get((int) (1))));
RDebugUtils.currentLine=2490376;
 //BA.debugLineNum = 2490376;BA.debugLine="Dim img As ImageView";
_img = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=2490377;
 //BA.debugLineNum = 2490377;BA.debugLine="C.imgCreate(img,\"\",sv.Panel,50%x,top,50%x,heat*1%";
mostCurrent._c._imgcreate /*String*/ (mostCurrent.activityBA,_img,"",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(mostCurrent._sv.getPanel().getObject())),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA),_top,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA),(int) (_heat*anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA)));
RDebugUtils.currentLine=2490378;
 //BA.debugLineNum = 2490378;BA.debugLine="Dim Glide As Hitex_Glide";
_glide = new com.hitex_glide.Hitex_Glide();
RDebugUtils.currentLine=2490379;
 //BA.debugLineNum = 2490379;BA.debugLine="Glide.Load2(h13(0)).FitCenter.Into(img)";
_glide.Load2(mostCurrent.activityBA,_h13[(int) (0)]).FitCenter().Into(_img);
RDebugUtils.currentLine=2490380;
 //BA.debugLineNum = 2490380;BA.debugLine="End Sub";
return "";
}
public static String  _banners_create(int _top,int _heat,anywheresoftware.b4a.objects.collections.List _listbannerpager) throws Exception{
RDebugUtils.currentModule="home";
if (Debug.shouldDelegate(mostCurrent.activityBA, "banners_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "banners_create", new Object[] {_top,_heat,_listbannerpager}));}
int _i = 0;
String[] _h13 = null;
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.ImageViewWrapper _img = null;
com.hitex_glide.Hitex_Glide _glide = null;
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub banners_create(top As Int,heat As Int,Listbann";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="pa.Initialize";
mostCurrent._pa.Initialize(mostCurrent.activityBA);
RDebugUtils.currentLine=2686979;
 //BA.debugLineNum = 2686979;BA.debugLine="For i = 0 To ListbannerPager.Size-1";
{
final int step2 = 1;
final int limit2 = (int) (_listbannerpager.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=2686980;
 //BA.debugLineNum = 2686980;BA.debugLine="Dim h13() As String=Regex.Split(\"#\",ListbannerPa";
_h13 = anywheresoftware.b4a.keywords.Common.Regex.Split("#",BA.ObjectToString(_listbannerpager.Get(_i)));
RDebugUtils.currentLine=2686981;
 //BA.debugLineNum = 2686981;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2686982;
 //BA.debugLineNum = 2686982;BA.debugLine="p.Initialize(\"banners\")";
_p.Initialize(mostCurrent.activityBA,"banners");
RDebugUtils.currentLine=2686983;
 //BA.debugLineNum = 2686983;BA.debugLine="Dim img As ImageView";
_img = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=2686984;
 //BA.debugLineNum = 2686984;BA.debugLine="img.Initialize(\"\")";
_img.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2686985;
 //BA.debugLineNum = 2686985;BA.debugLine="p.AddView(img,0,0,-1,-1)";
_p.AddView((android.view.View)(_img.getObject()),(int) (0),(int) (0),(int) (-1),(int) (-1));
RDebugUtils.currentLine=2686986;
 //BA.debugLineNum = 2686986;BA.debugLine="Dim Glide As Hitex_Glide";
_glide = new com.hitex_glide.Hitex_Glide();
RDebugUtils.currentLine=2686987;
 //BA.debugLineNum = 2686987;BA.debugLine="Glide.Load2(h13(0)).FitCenter.Into(img)";
_glide.Load2(mostCurrent.activityBA,_h13[(int) (0)]).FitCenter().Into(_img);
RDebugUtils.currentLine=2686988;
 //BA.debugLineNum = 2686988;BA.debugLine="pa.AddPage(p)";
mostCurrent._pa.AddPage((android.view.View)(_p.getObject()));
RDebugUtils.currentLine=2686989;
 //BA.debugLineNum = 2686989;BA.debugLine="p.Tag=ListbannerPager.Get(i)";
_p.setTag(_listbannerpager.Get(_i));
 }
};
RDebugUtils.currentLine=2686992;
 //BA.debugLineNum = 2686992;BA.debugLine="pb.Initialize(pa,\"pb\")";
mostCurrent._pb.Initialize(mostCurrent.activityBA,mostCurrent._pa,"pb");
RDebugUtils.currentLine=2686993;
 //BA.debugLineNum = 2686993;BA.debugLine="pb.setDotsColor(0xFF008C79,0x7E008C79)";
mostCurrent._pb.setDotsColor((int) (0xff008c79),(int) (0x7e008c79));
RDebugUtils.currentLine=2686994;
 //BA.debugLineNum = 2686994;BA.debugLine="pb.Transition = pb.PARALLAX_PAGE";
mostCurrent._pb.setTransition(mostCurrent._pb.PARALLAX_PAGE);
RDebugUtils.currentLine=2686995;
 //BA.debugLineNum = 2686995;BA.debugLine="sv.Panel.AddView(pb,0,top,100%x,heat*1%x)";
mostCurrent._sv.getPanel().AddView((android.view.View)(mostCurrent._pb.getObject()),(int) (0),_top,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),(int) (_heat*anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA)));
RDebugUtils.currentLine=2686996;
 //BA.debugLineNum = 2686996;BA.debugLine="End Sub";
return "";
}
public static void  _cat_create(int _top,anywheresoftware.b4a.objects.collections.List _lst) throws Exception{
RDebugUtils.currentModule="home";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cat_create", false))
	 {Debug.delegate(mostCurrent.activityBA, "cat_create", new Object[] {_top,_lst}); return;}
ResumableSub_cat_create rsub = new ResumableSub_cat_create(null,_top,_lst);
rsub.resume(processBA, null);
}
public static class ResumableSub_cat_create extends BA.ResumableSub {
public ResumableSub_cat_create(b4a.example.home parent,int _top,anywheresoftware.b4a.objects.collections.List _lst) {
this.parent = parent;
this._top = _top;
this._lst = _lst;
}
b4a.example.home parent;
int _top;
anywheresoftware.b4a.objects.collections.List _lst;
anywheresoftware.b4a.objects.HorizontalScrollViewWrapper _sv1 = null;
int _withs = 0;
int _i = 0;
de.amberhome.objects.CardViewWrapper _card = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlk = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
String[] _h13 = null;
int step5;
int limit5;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="home";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="Dim sv1 As HorizontalScrollView";
_sv1 = new anywheresoftware.b4a.objects.HorizontalScrollViewWrapper();
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="sv1.Initialize(550dip,\"\")";
_sv1.Initialize(mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (550)),"");
RDebugUtils.currentLine=2752515;
 //BA.debugLineNum = 2752515;BA.debugLine="sv.Panel.AddView(sv1,0,top+1%x,100%x,12%x)";
parent.mostCurrent._sv.getPanel().AddView((android.view.View)(_sv1.getObject()),(int) (0),(int) (_top+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (12),mostCurrent.activityBA));
RDebugUtils.currentLine=2752516;
 //BA.debugLineNum = 2752516;BA.debugLine="Dim withs As Int = 1%x";
_withs = anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA);
RDebugUtils.currentLine=2752517;
 //BA.debugLineNum = 2752517;BA.debugLine="For i = 0 To lst.Size-1";
if (true) break;

case 1:
//for
this.state = 4;
step5 = 1;
limit5 = (int) (_lst.getSize()-1);
_i = (int) (0) ;
this.state = 5;
if (true) break;

case 5:
//C
this.state = 4;
if ((step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5)) this.state = 3;
if (true) break;

case 6:
//C
this.state = 5;
_i = ((int)(0 + _i + step5)) ;
if (true) break;

case 3:
//C
this.state = 6;
RDebugUtils.currentLine=2752519;
 //BA.debugLineNum = 2752519;BA.debugLine="Dim card As CardView";
_card = new de.amberhome.objects.CardViewWrapper();
RDebugUtils.currentLine=2752520;
 //BA.debugLineNum = 2752520;BA.debugLine="card.Initialize(\"\")";
_card.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2752521;
 //BA.debugLineNum = 2752521;BA.debugLine="card.Elevation=0";
_card.setElevation((float) (0));
RDebugUtils.currentLine=2752522;
 //BA.debugLineNum = 2752522;BA.debugLine="sv1.Panel.AddView(card,withs,1%x,-1,10%x)";
_sv1.getPanel().AddView((android.view.View)(_card.getObject()),_withs,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA),(int) (-1),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=2752523;
 //BA.debugLineNum = 2752523;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=2752524;
 //BA.debugLineNum = 2752524;BA.debugLine="cd.Initialize(0xFF00C6C6, 500dip)";
_cd.Initialize((int) (0xff00c6c6),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500)));
RDebugUtils.currentLine=2752527;
 //BA.debugLineNum = 2752527;BA.debugLine="Dim pnlk As Panel";
_pnlk = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2752528;
 //BA.debugLineNum = 2752528;BA.debugLine="pnlk.Initialize(\"\")";
_pnlk.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2752529;
 //BA.debugLineNum = 2752529;BA.debugLine="card.AddView(pnlk,0,0,-1,-1)";
_card.AddView((android.view.View)(_pnlk.getObject()),(int) (0),(int) (0),(int) (-1),(int) (-1));
RDebugUtils.currentLine=2752530;
 //BA.debugLineNum = 2752530;BA.debugLine="pnlk.Background = cd";
_pnlk.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=2752532;
 //BA.debugLineNum = 2752532;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2752533;
 //BA.debugLineNum = 2752533;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2752534;
 //BA.debugLineNum = 2752534;BA.debugLine="lbl.TextColor=Colors.White";
_lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2752535;
 //BA.debugLineNum = 2752535;BA.debugLine="lbl.Gravity=Gravity.CENTER";
_lbl.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2752536;
 //BA.debugLineNum = 2752536;BA.debugLine="lbl.Typeface=C.irs";
_lbl.setTypeface((android.graphics.Typeface)(parent.mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ .getObject()));
RDebugUtils.currentLine=2752537;
 //BA.debugLineNum = 2752537;BA.debugLine="lbl.TextSize=15";
_lbl.setTextSize((float) (15));
RDebugUtils.currentLine=2752538;
 //BA.debugLineNum = 2752538;BA.debugLine="pnlk.AddView(lbl,0,0%x,-1,9%x)";
_pnlk.AddView((android.view.View)(_lbl.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA),(int) (-1),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (9),mostCurrent.activityBA));
RDebugUtils.currentLine=2752540;
 //BA.debugLineNum = 2752540;BA.debugLine="Dim h13() As String=Regex.Split(\"#\",lst.Get(i))";
_h13 = anywheresoftware.b4a.keywords.Common.Regex.Split("#",BA.ObjectToString(_lst.Get(_i)));
RDebugUtils.currentLine=2752542;
 //BA.debugLineNum = 2752542;BA.debugLine="lbl.Text=h13(1)";
_lbl.setText(BA.ObjectToCharSequence(_h13[(int) (1)]));
RDebugUtils.currentLine=2752544;
 //BA.debugLineNum = 2752544;BA.debugLine="card.Width=C.GetTextWidth(lbl)+10%x";
_card.setWidth((int) (parent.mostCurrent._c._gettextwidth /*float*/ (mostCurrent.activityBA,_lbl)+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA)));
RDebugUtils.currentLine=2752545;
 //BA.debugLineNum = 2752545;BA.debugLine="withs=withs+C.GetTextWidth(lbl)+12%x";
_withs = (int) (_withs+parent.mostCurrent._c._gettextwidth /*float*/ (mostCurrent.activityBA,_lbl)+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (12),mostCurrent.activityBA));
RDebugUtils.currentLine=2752546;
 //BA.debugLineNum = 2752546;BA.debugLine="sv1.Panel.Width=withs";
_sv1.getPanel().setWidth(_withs);
 if (true) break;
if (true) break;

case 4:
//C
this.state = -1;
;
RDebugUtils.currentLine=2752549;
 //BA.debugLineNum = 2752549;BA.debugLine="Sleep(0)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "home", "cat_create"),(int) (0));
this.state = 7;
return;
case 7:
//C
this.state = -1;
;
RDebugUtils.currentLine=2752550;
 //BA.debugLineNum = 2752550;BA.debugLine="sv1.ScrollPosition=withs+9%x";
_sv1.setScrollPosition((int) (_withs+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (9),mostCurrent.activityBA)));
RDebugUtils.currentLine=2752551;
 //BA.debugLineNum = 2752551;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _maindata_oncompleted() throws Exception{
RDebugUtils.currentModule="home";
if (Debug.shouldDelegate(mostCurrent.activityBA, "maindata_oncompleted", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "maindata_oncompleted", null));}
RDebugUtils.currentLine=9109504;
 //BA.debugLineNum = 9109504;BA.debugLine="Sub maindata_onCompleted      '💎💎💎           Po";
RDebugUtils.currentLine=9109508;
 //BA.debugLineNum = 9109508;BA.debugLine="End Sub";
return "";
}
public static String  _maindata_onerror(String _error,int _code) throws Exception{
RDebugUtils.currentModule="home";
if (Debug.shouldDelegate(mostCurrent.activityBA, "maindata_onerror", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "maindata_onerror", new Object[] {_error,_code}));}
RDebugUtils.currentLine=9175040;
 //BA.debugLineNum = 9175040;BA.debugLine="Sub maindata_onError (Error As String,Code As Int)";
RDebugUtils.currentLine=9175041;
 //BA.debugLineNum = 9175041;BA.debugLine="Log(Error)";
anywheresoftware.b4a.keywords.Common.LogImpl("39175041",_error,0);
RDebugUtils.currentLine=9175042;
 //BA.debugLineNum = 9175042;BA.debugLine="End Sub";
return "";
}
public static String  _maindata_onnext(aghajari.retrofit.Amir_ResponseBody _responsebody) throws Exception{
RDebugUtils.currentModule="home";
if (Debug.shouldDelegate(mostCurrent.activityBA, "maindata_onnext", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "maindata_onnext", new Object[] {_responsebody}));}
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
anywheresoftware.b4a.objects.collections.Map _result = null;
anywheresoftware.b4a.objects.collections.Map _lang_list = null;
anywheresoftware.b4a.objects.collections.Map _en = null;
String _localname = "";
String _iso = "";
String _api_url = "";
String _name = "";
String _direction = "";
anywheresoftware.b4a.objects.collections.Map _fa = null;
anywheresoftware.b4a.objects.collections.Map _site = null;
String _logo = "";
String _slogan = "";
String _desc = "";
anywheresoftware.b4a.objects.collections.List _navigation = null;
anywheresoftware.b4a.objects.collections.Map _colnavigation = null;
String _icon = "";
String _link = "";
String _typegb = "";
String _title = "";
anywheresoftware.b4a.objects.collections.Map _ad = null;
anywheresoftware.b4a.objects.collections.Map _top = null;
String _content = "";
anywheresoftware.b4a.objects.collections.List _bottom = null;
anywheresoftware.b4a.objects.collections.List _intro = null;
anywheresoftware.b4a.objects.collections.Map _colintro = null;
String _bg_to = "";
String _image = "";
String _bg_from = "";
String _title_color = "";
String _desc_color = "";
anywheresoftware.b4a.objects.collections.List _btn = null;
anywheresoftware.b4a.objects.collections.Map _colbtn = null;
String _action = "";
anywheresoftware.b4a.objects.collections.Map _transalate = null;
String _changelang = "";
String _go = "";
String _back = "";
String _enter = "";
String _version = "";
String _close = "";
anywheresoftware.b4a.objects.collections.Map _theme = null;
anywheresoftware.b4a.objects.collections.Map _default = null;
anywheresoftware.b4a.objects.collections.Map _intror = null;
String _header_from = "";
String _footer_color = "";
String _color = "";
String _header_to = "";
String _header_color = "";
String _footer_from = "";
String _footer_to = "";
anywheresoftware.b4a.objects.collections.Map _global = null;
String _btn_from = "";
String _btn_color = "";
String _btn_to = "";
anywheresoftware.b4a.objects.collections.Map _share = null;
anywheresoftware.b4a.objects.collections.Map _splash = null;
anywheresoftware.b4a.objects.collections.Map _btng = null;
anywheresoftware.b4a.objects.collections.Map _warn = null;
anywheresoftware.b4a.objects.collections.Map _success = null;
anywheresoftware.b4a.objects.collections.Map _danger = null;
anywheresoftware.b4a.objects.collections.Map _info = null;
anywheresoftware.b4a.objects.collections.Map _night = null;
anywheresoftware.b4a.objects.collections.Map _introf = null;
anywheresoftware.b4a.objects.collections.Map _btnf = null;
anywheresoftware.b4a.objects.collections.List _menu = null;
anywheresoftware.b4a.objects.collections.Map _colmenu = null;
String _typefg = "";
anywheresoftware.b4a.objects.collections.Map _versiond = null;
String _deprecated_descd = "";
int _lastd = 0;
int _deprecatedd = 0;
String _update_titled = "";
String _deprecated_titled = "";
String _update_descd = "";
anywheresoftware.b4a.objects.collections.Map _url = null;
String _sited = "";
String _domain = "";
String _rootd = "";
String _update = "";
String _kingdom = "";
anywheresoftware.b4a.objects.collections.List _homepage = null;
anywheresoftware.b4a.objects.collections.Map _colhomepage = null;
String _typert = "";
anywheresoftware.b4a.objects.collections.Map _expire = null;
anywheresoftware.b4a.objects.collections.List _data = null;
anywheresoftware.b4a.objects.collections.List _lst = null;
anywheresoftware.b4a.objects.collections.Map _coldata = null;
String _mode = "";
String _activitya = "";
String _urla = "";
String _ok = "";
RDebugUtils.currentLine=9240576;
 //BA.debugLineNum = 9240576;BA.debugLine="Sub maindata_onNext (ResponseBody As Amir_Response";
RDebugUtils.currentLine=9240577;
 //BA.debugLineNum = 9240577;BA.debugLine="Log(ResponseBody.String)";
anywheresoftware.b4a.keywords.Common.LogImpl("39240577",_responsebody.getString(),0);
RDebugUtils.currentLine=9240578;
 //BA.debugLineNum = 9240578;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=9240579;
 //BA.debugLineNum = 9240579;BA.debugLine="parser.Initialize(ResponseBody.String)";
_parser.Initialize(_responsebody.getString());
RDebugUtils.currentLine=9240580;
 //BA.debugLineNum = 9240580;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=9240581;
 //BA.debugLineNum = 9240581;BA.debugLine="Dim result As Map = root.Get(\"result\")";
_result = new anywheresoftware.b4a.objects.collections.Map();
_result.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_root.Get((Object)("result"))));
RDebugUtils.currentLine=9240582;
 //BA.debugLineNum = 9240582;BA.debugLine="Dim lang_list As Map = result.Get(\"lang_list\")";
_lang_list = new anywheresoftware.b4a.objects.collections.Map();
_lang_list.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_result.Get((Object)("lang_list"))));
RDebugUtils.currentLine=9240583;
 //BA.debugLineNum = 9240583;BA.debugLine="Dim en As Map = lang_list.Get(\"en\")";
_en = new anywheresoftware.b4a.objects.collections.Map();
_en.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_lang_list.Get((Object)("en"))));
RDebugUtils.currentLine=9240584;
 //BA.debugLineNum = 9240584;BA.debugLine="Dim localname As String = en.Get(\"localname\")";
_localname = BA.ObjectToString(_en.Get((Object)("localname")));
RDebugUtils.currentLine=9240585;
 //BA.debugLineNum = 9240585;BA.debugLine="Dim iso As String = en.Get(\"iso\")";
_iso = BA.ObjectToString(_en.Get((Object)("iso")));
RDebugUtils.currentLine=9240586;
 //BA.debugLineNum = 9240586;BA.debugLine="Dim api_url As String = en.Get(\"api_url\")";
_api_url = BA.ObjectToString(_en.Get((Object)("api_url")));
RDebugUtils.currentLine=9240587;
 //BA.debugLineNum = 9240587;BA.debugLine="Dim name As String = en.Get(\"name\")";
_name = BA.ObjectToString(_en.Get((Object)("name")));
RDebugUtils.currentLine=9240588;
 //BA.debugLineNum = 9240588;BA.debugLine="Dim direction As String = en.Get(\"direction\")";
_direction = BA.ObjectToString(_en.Get((Object)("direction")));
RDebugUtils.currentLine=9240589;
 //BA.debugLineNum = 9240589;BA.debugLine="Dim fa As Map = lang_list.Get(\"fa\")";
_fa = new anywheresoftware.b4a.objects.collections.Map();
_fa.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_lang_list.Get((Object)("fa"))));
RDebugUtils.currentLine=9240590;
 //BA.debugLineNum = 9240590;BA.debugLine="Dim localname As String = fa.Get(\"localname\")";
_localname = BA.ObjectToString(_fa.Get((Object)("localname")));
RDebugUtils.currentLine=9240591;
 //BA.debugLineNum = 9240591;BA.debugLine="Dim iso As String = fa.Get(\"iso\")";
_iso = BA.ObjectToString(_fa.Get((Object)("iso")));
RDebugUtils.currentLine=9240592;
 //BA.debugLineNum = 9240592;BA.debugLine="Dim api_url As String = fa.Get(\"api_url\")";
_api_url = BA.ObjectToString(_fa.Get((Object)("api_url")));
RDebugUtils.currentLine=9240593;
 //BA.debugLineNum = 9240593;BA.debugLine="Dim name As String = fa.Get(\"name\")";
_name = BA.ObjectToString(_fa.Get((Object)("name")));
RDebugUtils.currentLine=9240594;
 //BA.debugLineNum = 9240594;BA.debugLine="Dim direction As String = fa.Get(\"direction\")";
_direction = BA.ObjectToString(_fa.Get((Object)("direction")));
RDebugUtils.currentLine=9240595;
 //BA.debugLineNum = 9240595;BA.debugLine="Dim site As Map = result.Get(\"site\")";
_site = new anywheresoftware.b4a.objects.collections.Map();
_site.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_result.Get((Object)("site"))));
RDebugUtils.currentLine=9240596;
 //BA.debugLineNum = 9240596;BA.debugLine="Dim name As String = site.Get(\"name\")";
_name = BA.ObjectToString(_site.Get((Object)("name")));
RDebugUtils.currentLine=9240597;
 //BA.debugLineNum = 9240597;BA.debugLine="Dim logo As String = site.Get(\"logo\")";
_logo = BA.ObjectToString(_site.Get((Object)("logo")));
RDebugUtils.currentLine=9240598;
 //BA.debugLineNum = 9240598;BA.debugLine="Dim slogan As String = site.Get(\"slogan\")";
_slogan = BA.ObjectToString(_site.Get((Object)("slogan")));
RDebugUtils.currentLine=9240599;
 //BA.debugLineNum = 9240599;BA.debugLine="Dim desc As String = site.Get(\"desc\")";
_desc = BA.ObjectToString(_site.Get((Object)("desc")));
RDebugUtils.currentLine=9240600;
 //BA.debugLineNum = 9240600;BA.debugLine="Dim navigation As List = result.Get(\"navigation\")";
_navigation = new anywheresoftware.b4a.objects.collections.List();
_navigation.setObject((java.util.List)(_result.Get((Object)("navigation"))));
RDebugUtils.currentLine=9240601;
 //BA.debugLineNum = 9240601;BA.debugLine="For Each colnavigation As Map In navigation";
_colnavigation = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group25 = _navigation;
final int groupLen25 = group25.getSize()
;int index25 = 0;
;
for (; index25 < groupLen25;index25++){
_colnavigation.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group25.Get(index25)));
RDebugUtils.currentLine=9240602;
 //BA.debugLineNum = 9240602;BA.debugLine="Dim icon As String = colnavigation.Get(\"icon\")";
_icon = BA.ObjectToString(_colnavigation.Get((Object)("icon")));
RDebugUtils.currentLine=9240603;
 //BA.debugLineNum = 9240603;BA.debugLine="Dim link As String = colnavigation.Get(\"link\")";
_link = BA.ObjectToString(_colnavigation.Get((Object)("link")));
RDebugUtils.currentLine=9240604;
 //BA.debugLineNum = 9240604;BA.debugLine="Dim Typegb As String = colnavigation.Get(\"type\")";
_typegb = BA.ObjectToString(_colnavigation.Get((Object)("type")));
RDebugUtils.currentLine=9240605;
 //BA.debugLineNum = 9240605;BA.debugLine="Dim title As String = colnavigation.Get(\"title\")";
_title = BA.ObjectToString(_colnavigation.Get((Object)("title")));
 }
};
RDebugUtils.currentLine=9240607;
 //BA.debugLineNum = 9240607;BA.debugLine="Dim ad As Map = result.Get(\"ad\")";
_ad = new anywheresoftware.b4a.objects.collections.Map();
_ad.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_result.Get((Object)("ad"))));
RDebugUtils.currentLine=9240608;
 //BA.debugLineNum = 9240608;BA.debugLine="Dim top As Map = ad.Get(\"top\")";
_top = new anywheresoftware.b4a.objects.collections.Map();
_top.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_ad.Get((Object)("top"))));
RDebugUtils.currentLine=9240609;
 //BA.debugLineNum = 9240609;BA.debugLine="Dim link As String = top.Get(\"link\")";
_link = BA.ObjectToString(_top.Get((Object)("link")));
RDebugUtils.currentLine=9240610;
 //BA.debugLineNum = 9240610;BA.debugLine="Dim content As String = top.Get(\"content\")";
_content = BA.ObjectToString(_top.Get((Object)("content")));
RDebugUtils.currentLine=9240611;
 //BA.debugLineNum = 9240611;BA.debugLine="Dim bottom As List = ad.Get(\"bottom\")";
_bottom = new anywheresoftware.b4a.objects.collections.List();
_bottom.setObject((java.util.List)(_ad.Get((Object)("bottom"))));
RDebugUtils.currentLine=9240612;
 //BA.debugLineNum = 9240612;BA.debugLine="Dim intro As List = result.Get(\"intro\")";
_intro = new anywheresoftware.b4a.objects.collections.List();
_intro.setObject((java.util.List)(_result.Get((Object)("intro"))));
RDebugUtils.currentLine=9240613;
 //BA.debugLineNum = 9240613;BA.debugLine="For Each colintro As Map In intro";
_colintro = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group37 = _intro;
final int groupLen37 = group37.getSize()
;int index37 = 0;
;
for (; index37 < groupLen37;index37++){
_colintro.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group37.Get(index37)));
RDebugUtils.currentLine=9240614;
 //BA.debugLineNum = 9240614;BA.debugLine="Dim bg_to As String = colintro.Get(\"bg_to\")";
_bg_to = BA.ObjectToString(_colintro.Get((Object)("bg_to")));
RDebugUtils.currentLine=9240615;
 //BA.debugLineNum = 9240615;BA.debugLine="Dim image As String = colintro.Get(\"image\")";
_image = BA.ObjectToString(_colintro.Get((Object)("image")));
RDebugUtils.currentLine=9240616;
 //BA.debugLineNum = 9240616;BA.debugLine="Dim bg_from As String = colintro.Get(\"bg_from\")";
_bg_from = BA.ObjectToString(_colintro.Get((Object)("bg_from")));
RDebugUtils.currentLine=9240617;
 //BA.debugLineNum = 9240617;BA.debugLine="Dim title_color As String = colintro.Get(\"title_";
_title_color = BA.ObjectToString(_colintro.Get((Object)("title_color")));
RDebugUtils.currentLine=9240618;
 //BA.debugLineNum = 9240618;BA.debugLine="Dim desc_color As String = colintro.Get(\"desc_co";
_desc_color = BA.ObjectToString(_colintro.Get((Object)("desc_color")));
RDebugUtils.currentLine=9240619;
 //BA.debugLineNum = 9240619;BA.debugLine="Dim title As String = colintro.Get(\"title\")";
_title = BA.ObjectToString(_colintro.Get((Object)("title")));
RDebugUtils.currentLine=9240620;
 //BA.debugLineNum = 9240620;BA.debugLine="Dim btn As List = colintro.Get(\"btn\")";
_btn = new anywheresoftware.b4a.objects.collections.List();
_btn.setObject((java.util.List)(_colintro.Get((Object)("btn"))));
RDebugUtils.currentLine=9240621;
 //BA.debugLineNum = 9240621;BA.debugLine="For Each colbtn As Map In btn";
_colbtn = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group45 = _btn;
final int groupLen45 = group45.getSize()
;int index45 = 0;
;
for (; index45 < groupLen45;index45++){
_colbtn.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group45.Get(index45)));
RDebugUtils.currentLine=9240622;
 //BA.debugLineNum = 9240622;BA.debugLine="Dim action As String = colbtn.Get(\"action\")";
_action = BA.ObjectToString(_colbtn.Get((Object)("action")));
RDebugUtils.currentLine=9240623;
 //BA.debugLineNum = 9240623;BA.debugLine="Dim title As String = colbtn.Get(\"title\")";
_title = BA.ObjectToString(_colbtn.Get((Object)("title")));
 }
};
RDebugUtils.currentLine=9240625;
 //BA.debugLineNum = 9240625;BA.debugLine="Dim desc As String = colintro.Get(\"desc\")";
_desc = BA.ObjectToString(_colintro.Get((Object)("desc")));
 }
};
RDebugUtils.currentLine=9240627;
 //BA.debugLineNum = 9240627;BA.debugLine="Dim transalate As Map = result.Get(\"transalate\")";
_transalate = new anywheresoftware.b4a.objects.collections.Map();
_transalate.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_result.Get((Object)("transalate"))));
RDebugUtils.currentLine=9240628;
 //BA.debugLineNum = 9240628;BA.debugLine="Dim changelang As String = transalate.Get(\"change";
_changelang = BA.ObjectToString(_transalate.Get((Object)("changelang")));
RDebugUtils.currentLine=9240629;
 //BA.debugLineNum = 9240629;BA.debugLine="Dim go As String = transalate.Get(\"go\")";
_go = BA.ObjectToString(_transalate.Get((Object)("go")));
RDebugUtils.currentLine=9240630;
 //BA.debugLineNum = 9240630;BA.debugLine="Dim back As String = transalate.Get(\"back\")";
_back = BA.ObjectToString(_transalate.Get((Object)("back")));
RDebugUtils.currentLine=9240631;
 //BA.debugLineNum = 9240631;BA.debugLine="Dim enter As String = transalate.Get(\"enter\")";
_enter = BA.ObjectToString(_transalate.Get((Object)("enter")));
RDebugUtils.currentLine=9240632;
 //BA.debugLineNum = 9240632;BA.debugLine="Dim version As String = transalate.Get(\"version\")";
_version = BA.ObjectToString(_transalate.Get((Object)("version")));
RDebugUtils.currentLine=9240633;
 //BA.debugLineNum = 9240633;BA.debugLine="Dim close As String = transalate.Get(\"close\")";
_close = BA.ObjectToString(_transalate.Get((Object)("close")));
RDebugUtils.currentLine=9240634;
 //BA.debugLineNum = 9240634;BA.debugLine="Dim theme As Map = result.Get(\"theme\")";
_theme = new anywheresoftware.b4a.objects.collections.Map();
_theme.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_result.Get((Object)("theme"))));
RDebugUtils.currentLine=9240635;
 //BA.debugLineNum = 9240635;BA.debugLine="Dim default As Map = theme.Get(\"default\")";
_default = new anywheresoftware.b4a.objects.collections.Map();
_default.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_theme.Get((Object)("default"))));
RDebugUtils.currentLine=9240636;
 //BA.debugLineNum = 9240636;BA.debugLine="Dim intror As Map = default.Get(\"intro\")";
_intror = new anywheresoftware.b4a.objects.collections.Map();
_intror.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_default.Get((Object)("intro"))));
RDebugUtils.currentLine=9240637;
 //BA.debugLineNum = 9240637;BA.debugLine="Dim bg_to As String = intror.Get(\"bg_to\")";
_bg_to = BA.ObjectToString(_intror.Get((Object)("bg_to")));
RDebugUtils.currentLine=9240638;
 //BA.debugLineNum = 9240638;BA.debugLine="Dim header_from As String = intror.Get(\"header_fr";
_header_from = BA.ObjectToString(_intror.Get((Object)("header_from")));
RDebugUtils.currentLine=9240639;
 //BA.debugLineNum = 9240639;BA.debugLine="Dim footer_color As String = intror.Get(\"footer_c";
_footer_color = BA.ObjectToString(_intror.Get((Object)("footer_color")));
RDebugUtils.currentLine=9240640;
 //BA.debugLineNum = 9240640;BA.debugLine="Dim bg_from As String = intror.Get(\"bg_from\")";
_bg_from = BA.ObjectToString(_intror.Get((Object)("bg_from")));
RDebugUtils.currentLine=9240641;
 //BA.debugLineNum = 9240641;BA.debugLine="Dim color As String = intror.Get(\"color\")";
_color = BA.ObjectToString(_intror.Get((Object)("color")));
RDebugUtils.currentLine=9240642;
 //BA.debugLineNum = 9240642;BA.debugLine="Dim header_to As String = intror.Get(\"header_to\")";
_header_to = BA.ObjectToString(_intror.Get((Object)("header_to")));
RDebugUtils.currentLine=9240643;
 //BA.debugLineNum = 9240643;BA.debugLine="Dim header_color As String = intror.Get(\"header_c";
_header_color = BA.ObjectToString(_intror.Get((Object)("header_color")));
RDebugUtils.currentLine=9240644;
 //BA.debugLineNum = 9240644;BA.debugLine="Dim footer_from As String = intror.Get(\"footer_fr";
_footer_from = BA.ObjectToString(_intror.Get((Object)("footer_from")));
RDebugUtils.currentLine=9240645;
 //BA.debugLineNum = 9240645;BA.debugLine="Dim footer_to As String = intror.Get(\"footer_to\")";
_footer_to = BA.ObjectToString(_intror.Get((Object)("footer_to")));
RDebugUtils.currentLine=9240646;
 //BA.debugLineNum = 9240646;BA.debugLine="Dim global As Map = default.Get(\"global\")";
_global = new anywheresoftware.b4a.objects.collections.Map();
_global.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_default.Get((Object)("global"))));
RDebugUtils.currentLine=9240647;
 //BA.debugLineNum = 9240647;BA.debugLine="Dim bg_to As String = global.Get(\"bg_to\")";
_bg_to = BA.ObjectToString(_global.Get((Object)("bg_to")));
RDebugUtils.currentLine=9240648;
 //BA.debugLineNum = 9240648;BA.debugLine="Dim bg_from As String = global.Get(\"bg_from\")";
_bg_from = BA.ObjectToString(_global.Get((Object)("bg_from")));
RDebugUtils.currentLine=9240649;
 //BA.debugLineNum = 9240649;BA.debugLine="Dim color As String = global.Get(\"color\")";
_color = BA.ObjectToString(_global.Get((Object)("color")));
RDebugUtils.currentLine=9240650;
 //BA.debugLineNum = 9240650;BA.debugLine="Dim btn_from As String = global.Get(\"btn_from\")";
_btn_from = BA.ObjectToString(_global.Get((Object)("btn_from")));
RDebugUtils.currentLine=9240651;
 //BA.debugLineNum = 9240651;BA.debugLine="Dim btn_color As String = global.Get(\"btn_color\")";
_btn_color = BA.ObjectToString(_global.Get((Object)("btn_color")));
RDebugUtils.currentLine=9240652;
 //BA.debugLineNum = 9240652;BA.debugLine="Dim btn_to As String = global.Get(\"btn_to\")";
_btn_to = BA.ObjectToString(_global.Get((Object)("btn_to")));
RDebugUtils.currentLine=9240653;
 //BA.debugLineNum = 9240653;BA.debugLine="Dim share As Map = default.Get(\"share\")";
_share = new anywheresoftware.b4a.objects.collections.Map();
_share.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_default.Get((Object)("share"))));
RDebugUtils.currentLine=9240654;
 //BA.debugLineNum = 9240654;BA.debugLine="Dim bg_to As String = share.Get(\"bg_to\")";
_bg_to = BA.ObjectToString(_share.Get((Object)("bg_to")));
RDebugUtils.currentLine=9240655;
 //BA.debugLineNum = 9240655;BA.debugLine="Dim header_from As String = share.Get(\"header_fro";
_header_from = BA.ObjectToString(_share.Get((Object)("header_from")));
RDebugUtils.currentLine=9240656;
 //BA.debugLineNum = 9240656;BA.debugLine="Dim footer_color As String = share.Get(\"footer_co";
_footer_color = BA.ObjectToString(_share.Get((Object)("footer_color")));
RDebugUtils.currentLine=9240657;
 //BA.debugLineNum = 9240657;BA.debugLine="Dim bg_from As String = share.Get(\"bg_from\")";
_bg_from = BA.ObjectToString(_share.Get((Object)("bg_from")));
RDebugUtils.currentLine=9240658;
 //BA.debugLineNum = 9240658;BA.debugLine="Dim color As String = share.Get(\"color\")";
_color = BA.ObjectToString(_share.Get((Object)("color")));
RDebugUtils.currentLine=9240659;
 //BA.debugLineNum = 9240659;BA.debugLine="Dim header_to As String = share.Get(\"header_to\")";
_header_to = BA.ObjectToString(_share.Get((Object)("header_to")));
RDebugUtils.currentLine=9240660;
 //BA.debugLineNum = 9240660;BA.debugLine="Dim header_color As String = share.Get(\"header_co";
_header_color = BA.ObjectToString(_share.Get((Object)("header_color")));
RDebugUtils.currentLine=9240661;
 //BA.debugLineNum = 9240661;BA.debugLine="Dim footer_from As String = share.Get(\"footer_fro";
_footer_from = BA.ObjectToString(_share.Get((Object)("footer_from")));
RDebugUtils.currentLine=9240662;
 //BA.debugLineNum = 9240662;BA.debugLine="Dim footer_to As String = share.Get(\"footer_to\")";
_footer_to = BA.ObjectToString(_share.Get((Object)("footer_to")));
RDebugUtils.currentLine=9240663;
 //BA.debugLineNum = 9240663;BA.debugLine="Dim splash As Map = default.Get(\"splash\")";
_splash = new anywheresoftware.b4a.objects.collections.Map();
_splash.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_default.Get((Object)("splash"))));
RDebugUtils.currentLine=9240664;
 //BA.debugLineNum = 9240664;BA.debugLine="Dim bg_to As String = splash.Get(\"bg_to\")";
_bg_to = BA.ObjectToString(_splash.Get((Object)("bg_to")));
RDebugUtils.currentLine=9240665;
 //BA.debugLineNum = 9240665;BA.debugLine="Dim bg_from As String = splash.Get(\"bg_from\")";
_bg_from = BA.ObjectToString(_splash.Get((Object)("bg_from")));
RDebugUtils.currentLine=9240666;
 //BA.debugLineNum = 9240666;BA.debugLine="Dim color As String = splash.Get(\"color\")";
_color = BA.ObjectToString(_splash.Get((Object)("color")));
RDebugUtils.currentLine=9240667;
 //BA.debugLineNum = 9240667;BA.debugLine="Dim btng As Map = default.Get(\"btn\")";
_btng = new anywheresoftware.b4a.objects.collections.Map();
_btng.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_default.Get((Object)("btn"))));
RDebugUtils.currentLine=9240668;
 //BA.debugLineNum = 9240668;BA.debugLine="Dim warn As Map = btng.Get(\"warn\")";
_warn = new anywheresoftware.b4a.objects.collections.Map();
_warn.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_btng.Get((Object)("warn"))));
RDebugUtils.currentLine=9240669;
 //BA.debugLineNum = 9240669;BA.debugLine="Dim bg_to As String = warn.Get(\"bg_to\")";
_bg_to = BA.ObjectToString(_warn.Get((Object)("bg_to")));
RDebugUtils.currentLine=9240670;
 //BA.debugLineNum = 9240670;BA.debugLine="Dim bg_from As String = warn.Get(\"bg_from\")";
_bg_from = BA.ObjectToString(_warn.Get((Object)("bg_from")));
RDebugUtils.currentLine=9240671;
 //BA.debugLineNum = 9240671;BA.debugLine="Dim color As String = warn.Get(\"color\")";
_color = BA.ObjectToString(_warn.Get((Object)("color")));
RDebugUtils.currentLine=9240672;
 //BA.debugLineNum = 9240672;BA.debugLine="Dim success As Map = btng.Get(\"success\")";
_success = new anywheresoftware.b4a.objects.collections.Map();
_success.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_btng.Get((Object)("success"))));
RDebugUtils.currentLine=9240673;
 //BA.debugLineNum = 9240673;BA.debugLine="Dim bg_to As String = success.Get(\"bg_to\")";
_bg_to = BA.ObjectToString(_success.Get((Object)("bg_to")));
RDebugUtils.currentLine=9240674;
 //BA.debugLineNum = 9240674;BA.debugLine="Dim bg_from As String = success.Get(\"bg_from\")";
_bg_from = BA.ObjectToString(_success.Get((Object)("bg_from")));
RDebugUtils.currentLine=9240675;
 //BA.debugLineNum = 9240675;BA.debugLine="Dim color As String = success.Get(\"color\")";
_color = BA.ObjectToString(_success.Get((Object)("color")));
RDebugUtils.currentLine=9240676;
 //BA.debugLineNum = 9240676;BA.debugLine="Dim danger As Map = btng.Get(\"danger\")";
_danger = new anywheresoftware.b4a.objects.collections.Map();
_danger.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_btng.Get((Object)("danger"))));
RDebugUtils.currentLine=9240677;
 //BA.debugLineNum = 9240677;BA.debugLine="Dim bg_to As String = danger.Get(\"bg_to\")";
_bg_to = BA.ObjectToString(_danger.Get((Object)("bg_to")));
RDebugUtils.currentLine=9240678;
 //BA.debugLineNum = 9240678;BA.debugLine="Dim bg_from As String = danger.Get(\"bg_from\")";
_bg_from = BA.ObjectToString(_danger.Get((Object)("bg_from")));
RDebugUtils.currentLine=9240679;
 //BA.debugLineNum = 9240679;BA.debugLine="Dim color As String = danger.Get(\"color\")";
_color = BA.ObjectToString(_danger.Get((Object)("color")));
RDebugUtils.currentLine=9240680;
 //BA.debugLineNum = 9240680;BA.debugLine="Dim info As Map = btng.Get(\"info\")";
_info = new anywheresoftware.b4a.objects.collections.Map();
_info.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_btng.Get((Object)("info"))));
RDebugUtils.currentLine=9240681;
 //BA.debugLineNum = 9240681;BA.debugLine="Dim bg_to As String = info.Get(\"bg_to\")";
_bg_to = BA.ObjectToString(_info.Get((Object)("bg_to")));
RDebugUtils.currentLine=9240682;
 //BA.debugLineNum = 9240682;BA.debugLine="Dim bg_from As String = info.Get(\"bg_from\")";
_bg_from = BA.ObjectToString(_info.Get((Object)("bg_from")));
RDebugUtils.currentLine=9240683;
 //BA.debugLineNum = 9240683;BA.debugLine="Dim color As String = info.Get(\"color\")";
_color = BA.ObjectToString(_info.Get((Object)("color")));
RDebugUtils.currentLine=9240684;
 //BA.debugLineNum = 9240684;BA.debugLine="Dim night As Map = theme.Get(\"night\")";
_night = new anywheresoftware.b4a.objects.collections.Map();
_night.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_theme.Get((Object)("night"))));
RDebugUtils.currentLine=9240685;
 //BA.debugLineNum = 9240685;BA.debugLine="Dim introf As Map = night.Get(\"intro\")";
_introf = new anywheresoftware.b4a.objects.collections.Map();
_introf.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_night.Get((Object)("intro"))));
RDebugUtils.currentLine=9240686;
 //BA.debugLineNum = 9240686;BA.debugLine="Dim bg_to As String = introf.Get(\"bg_to\")";
_bg_to = BA.ObjectToString(_introf.Get((Object)("bg_to")));
RDebugUtils.currentLine=9240687;
 //BA.debugLineNum = 9240687;BA.debugLine="Dim header_from As String = introf.Get(\"header_fr";
_header_from = BA.ObjectToString(_introf.Get((Object)("header_from")));
RDebugUtils.currentLine=9240688;
 //BA.debugLineNum = 9240688;BA.debugLine="Dim footer_color As String = introf.Get(\"footer_c";
_footer_color = BA.ObjectToString(_introf.Get((Object)("footer_color")));
RDebugUtils.currentLine=9240689;
 //BA.debugLineNum = 9240689;BA.debugLine="Dim bg_from As String = introf.Get(\"bg_from\")";
_bg_from = BA.ObjectToString(_introf.Get((Object)("bg_from")));
RDebugUtils.currentLine=9240690;
 //BA.debugLineNum = 9240690;BA.debugLine="Dim color As String = introf.Get(\"color\")";
_color = BA.ObjectToString(_introf.Get((Object)("color")));
RDebugUtils.currentLine=9240691;
 //BA.debugLineNum = 9240691;BA.debugLine="Dim header_to As String = introf.Get(\"header_to\")";
_header_to = BA.ObjectToString(_introf.Get((Object)("header_to")));
RDebugUtils.currentLine=9240692;
 //BA.debugLineNum = 9240692;BA.debugLine="Dim header_color As String = introf.Get(\"header_c";
_header_color = BA.ObjectToString(_introf.Get((Object)("header_color")));
RDebugUtils.currentLine=9240693;
 //BA.debugLineNum = 9240693;BA.debugLine="Dim footer_from As String = introf.Get(\"footer_fr";
_footer_from = BA.ObjectToString(_introf.Get((Object)("footer_from")));
RDebugUtils.currentLine=9240694;
 //BA.debugLineNum = 9240694;BA.debugLine="Dim footer_to As String = introf.Get(\"footer_to\")";
_footer_to = BA.ObjectToString(_introf.Get((Object)("footer_to")));
RDebugUtils.currentLine=9240695;
 //BA.debugLineNum = 9240695;BA.debugLine="Dim global As Map = night.Get(\"global\")";
_global = new anywheresoftware.b4a.objects.collections.Map();
_global.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_night.Get((Object)("global"))));
RDebugUtils.currentLine=9240696;
 //BA.debugLineNum = 9240696;BA.debugLine="Dim bg_to As String = global.Get(\"bg_to\")";
_bg_to = BA.ObjectToString(_global.Get((Object)("bg_to")));
RDebugUtils.currentLine=9240697;
 //BA.debugLineNum = 9240697;BA.debugLine="Dim bg_from As String = global.Get(\"bg_from\")";
_bg_from = BA.ObjectToString(_global.Get((Object)("bg_from")));
RDebugUtils.currentLine=9240698;
 //BA.debugLineNum = 9240698;BA.debugLine="Dim color As String = global.Get(\"color\")";
_color = BA.ObjectToString(_global.Get((Object)("color")));
RDebugUtils.currentLine=9240699;
 //BA.debugLineNum = 9240699;BA.debugLine="Dim btn_from As String = global.Get(\"btn_from\")";
_btn_from = BA.ObjectToString(_global.Get((Object)("btn_from")));
RDebugUtils.currentLine=9240700;
 //BA.debugLineNum = 9240700;BA.debugLine="Dim btn_color As String = global.Get(\"btn_color\")";
_btn_color = BA.ObjectToString(_global.Get((Object)("btn_color")));
RDebugUtils.currentLine=9240701;
 //BA.debugLineNum = 9240701;BA.debugLine="Dim btn_to As String = global.Get(\"btn_to\")";
_btn_to = BA.ObjectToString(_global.Get((Object)("btn_to")));
RDebugUtils.currentLine=9240702;
 //BA.debugLineNum = 9240702;BA.debugLine="Dim share As Map = night.Get(\"share\")";
_share = new anywheresoftware.b4a.objects.collections.Map();
_share.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_night.Get((Object)("share"))));
RDebugUtils.currentLine=9240703;
 //BA.debugLineNum = 9240703;BA.debugLine="Dim bg_to As String = share.Get(\"bg_to\")";
_bg_to = BA.ObjectToString(_share.Get((Object)("bg_to")));
RDebugUtils.currentLine=9240704;
 //BA.debugLineNum = 9240704;BA.debugLine="Dim header_from As String = share.Get(\"header_fro";
_header_from = BA.ObjectToString(_share.Get((Object)("header_from")));
RDebugUtils.currentLine=9240705;
 //BA.debugLineNum = 9240705;BA.debugLine="Dim footer_color As String = share.Get(\"footer_co";
_footer_color = BA.ObjectToString(_share.Get((Object)("footer_color")));
RDebugUtils.currentLine=9240706;
 //BA.debugLineNum = 9240706;BA.debugLine="Dim bg_from As String = share.Get(\"bg_from\")";
_bg_from = BA.ObjectToString(_share.Get((Object)("bg_from")));
RDebugUtils.currentLine=9240707;
 //BA.debugLineNum = 9240707;BA.debugLine="Dim color As String = share.Get(\"color\")";
_color = BA.ObjectToString(_share.Get((Object)("color")));
RDebugUtils.currentLine=9240708;
 //BA.debugLineNum = 9240708;BA.debugLine="Dim header_to As String = share.Get(\"header_to\")";
_header_to = BA.ObjectToString(_share.Get((Object)("header_to")));
RDebugUtils.currentLine=9240709;
 //BA.debugLineNum = 9240709;BA.debugLine="Dim header_color As String = share.Get(\"header_co";
_header_color = BA.ObjectToString(_share.Get((Object)("header_color")));
RDebugUtils.currentLine=9240710;
 //BA.debugLineNum = 9240710;BA.debugLine="Dim footer_from As String = share.Get(\"footer_fro";
_footer_from = BA.ObjectToString(_share.Get((Object)("footer_from")));
RDebugUtils.currentLine=9240711;
 //BA.debugLineNum = 9240711;BA.debugLine="Dim footer_to As String = share.Get(\"footer_to\")";
_footer_to = BA.ObjectToString(_share.Get((Object)("footer_to")));
RDebugUtils.currentLine=9240712;
 //BA.debugLineNum = 9240712;BA.debugLine="Dim splash As Map = night.Get(\"splash\")";
_splash = new anywheresoftware.b4a.objects.collections.Map();
_splash.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_night.Get((Object)("splash"))));
RDebugUtils.currentLine=9240713;
 //BA.debugLineNum = 9240713;BA.debugLine="Dim bg_to As String = splash.Get(\"bg_to\")";
_bg_to = BA.ObjectToString(_splash.Get((Object)("bg_to")));
RDebugUtils.currentLine=9240714;
 //BA.debugLineNum = 9240714;BA.debugLine="Dim bg_from As String = splash.Get(\"bg_from\")";
_bg_from = BA.ObjectToString(_splash.Get((Object)("bg_from")));
RDebugUtils.currentLine=9240715;
 //BA.debugLineNum = 9240715;BA.debugLine="Dim color As String = splash.Get(\"color\")";
_color = BA.ObjectToString(_splash.Get((Object)("color")));
RDebugUtils.currentLine=9240716;
 //BA.debugLineNum = 9240716;BA.debugLine="Dim btnf As Map = night.Get(\"btn\")";
_btnf = new anywheresoftware.b4a.objects.collections.Map();
_btnf.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_night.Get((Object)("btn"))));
RDebugUtils.currentLine=9240717;
 //BA.debugLineNum = 9240717;BA.debugLine="Dim warn As Map = btnf.Get(\"warn\")";
_warn = new anywheresoftware.b4a.objects.collections.Map();
_warn.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_btnf.Get((Object)("warn"))));
RDebugUtils.currentLine=9240718;
 //BA.debugLineNum = 9240718;BA.debugLine="Dim bg_to As String = warn.Get(\"bg_to\")";
_bg_to = BA.ObjectToString(_warn.Get((Object)("bg_to")));
RDebugUtils.currentLine=9240719;
 //BA.debugLineNum = 9240719;BA.debugLine="Dim bg_from As String = warn.Get(\"bg_from\")";
_bg_from = BA.ObjectToString(_warn.Get((Object)("bg_from")));
RDebugUtils.currentLine=9240720;
 //BA.debugLineNum = 9240720;BA.debugLine="Dim color As String = warn.Get(\"color\")";
_color = BA.ObjectToString(_warn.Get((Object)("color")));
RDebugUtils.currentLine=9240721;
 //BA.debugLineNum = 9240721;BA.debugLine="Dim success As Map = btnf.Get(\"success\")";
_success = new anywheresoftware.b4a.objects.collections.Map();
_success.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_btnf.Get((Object)("success"))));
RDebugUtils.currentLine=9240722;
 //BA.debugLineNum = 9240722;BA.debugLine="Dim bg_to As String = success.Get(\"bg_to\")";
_bg_to = BA.ObjectToString(_success.Get((Object)("bg_to")));
RDebugUtils.currentLine=9240723;
 //BA.debugLineNum = 9240723;BA.debugLine="Dim bg_from As String = success.Get(\"bg_from\")";
_bg_from = BA.ObjectToString(_success.Get((Object)("bg_from")));
RDebugUtils.currentLine=9240724;
 //BA.debugLineNum = 9240724;BA.debugLine="Dim color As String = success.Get(\"color\")";
_color = BA.ObjectToString(_success.Get((Object)("color")));
RDebugUtils.currentLine=9240725;
 //BA.debugLineNum = 9240725;BA.debugLine="Dim danger As Map = btnf.Get(\"danger\")";
_danger = new anywheresoftware.b4a.objects.collections.Map();
_danger.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_btnf.Get((Object)("danger"))));
RDebugUtils.currentLine=9240726;
 //BA.debugLineNum = 9240726;BA.debugLine="Dim bg_to As String = danger.Get(\"bg_to\")";
_bg_to = BA.ObjectToString(_danger.Get((Object)("bg_to")));
RDebugUtils.currentLine=9240727;
 //BA.debugLineNum = 9240727;BA.debugLine="Dim bg_from As String = danger.Get(\"bg_from\")";
_bg_from = BA.ObjectToString(_danger.Get((Object)("bg_from")));
RDebugUtils.currentLine=9240728;
 //BA.debugLineNum = 9240728;BA.debugLine="Dim color As String = danger.Get(\"color\")";
_color = BA.ObjectToString(_danger.Get((Object)("color")));
RDebugUtils.currentLine=9240729;
 //BA.debugLineNum = 9240729;BA.debugLine="Dim info As Map = btnf.Get(\"info\")";
_info = new anywheresoftware.b4a.objects.collections.Map();
_info.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_btnf.Get((Object)("info"))));
RDebugUtils.currentLine=9240730;
 //BA.debugLineNum = 9240730;BA.debugLine="Dim bg_to As String = info.Get(\"bg_to\")";
_bg_to = BA.ObjectToString(_info.Get((Object)("bg_to")));
RDebugUtils.currentLine=9240731;
 //BA.debugLineNum = 9240731;BA.debugLine="Dim bg_from As String = info.Get(\"bg_from\")";
_bg_from = BA.ObjectToString(_info.Get((Object)("bg_from")));
RDebugUtils.currentLine=9240732;
 //BA.debugLineNum = 9240732;BA.debugLine="Dim color As String = info.Get(\"color\")";
_color = BA.ObjectToString(_info.Get((Object)("color")));
RDebugUtils.currentLine=9240733;
 //BA.debugLineNum = 9240733;BA.debugLine="Dim menu As List = result.Get(\"menu\")";
_menu = new anywheresoftware.b4a.objects.collections.List();
_menu.setObject((java.util.List)(_result.Get((Object)("menu"))));
RDebugUtils.currentLine=9240734;
 //BA.debugLineNum = 9240734;BA.debugLine="For Each colmenu As Map In menu";
_colmenu = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group158 = _menu;
final int groupLen158 = group158.getSize()
;int index158 = 0;
;
for (; index158 < groupLen158;index158++){
_colmenu.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group158.Get(index158)));
RDebugUtils.currentLine=9240735;
 //BA.debugLineNum = 9240735;BA.debugLine="Dim icon As String = colmenu.Get(\"icon\")";
_icon = BA.ObjectToString(_colmenu.Get((Object)("icon")));
RDebugUtils.currentLine=9240736;
 //BA.debugLineNum = 9240736;BA.debugLine="Dim link As String = colmenu.Get(\"link\")";
_link = BA.ObjectToString(_colmenu.Get((Object)("link")));
RDebugUtils.currentLine=9240737;
 //BA.debugLineNum = 9240737;BA.debugLine="Dim Typefg As String = colmenu.Get(\"type\")";
_typefg = BA.ObjectToString(_colmenu.Get((Object)("type")));
RDebugUtils.currentLine=9240738;
 //BA.debugLineNum = 9240738;BA.debugLine="Dim title As String = colmenu.Get(\"title\")";
_title = BA.ObjectToString(_colmenu.Get((Object)("title")));
 }
};
RDebugUtils.currentLine=9240741;
 //BA.debugLineNum = 9240741;BA.debugLine="Dim versiond As Map = result.Get(\"version\")";
_versiond = new anywheresoftware.b4a.objects.collections.Map();
_versiond.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_result.Get((Object)("version"))));
RDebugUtils.currentLine=9240742;
 //BA.debugLineNum = 9240742;BA.debugLine="Dim deprecated_descd As String = versiond.Get(\"de";
_deprecated_descd = BA.ObjectToString(_versiond.Get((Object)("deprecated_desc")));
RDebugUtils.currentLine=9240743;
 //BA.debugLineNum = 9240743;BA.debugLine="Dim lastd As Int = versiond.Get(\"last\")";
_lastd = (int)(BA.ObjectToNumber(_versiond.Get((Object)("last"))));
RDebugUtils.currentLine=9240744;
 //BA.debugLineNum = 9240744;BA.debugLine="Dim deprecatedd As Int = versiond.Get(\"deprecated";
_deprecatedd = (int)(BA.ObjectToNumber(_versiond.Get((Object)("deprecated"))));
RDebugUtils.currentLine=9240745;
 //BA.debugLineNum = 9240745;BA.debugLine="Dim update_titled As String = versiond.Get(\"updat";
_update_titled = BA.ObjectToString(_versiond.Get((Object)("update_title")));
RDebugUtils.currentLine=9240746;
 //BA.debugLineNum = 9240746;BA.debugLine="Dim deprecated_titled As String = versiond.Get(\"d";
_deprecated_titled = BA.ObjectToString(_versiond.Get((Object)("deprecated_title")));
RDebugUtils.currentLine=9240747;
 //BA.debugLineNum = 9240747;BA.debugLine="Dim update_descd As String = versiond.Get(\"update";
_update_descd = BA.ObjectToString(_versiond.Get((Object)("update_desc")));
RDebugUtils.currentLine=9240748;
 //BA.debugLineNum = 9240748;BA.debugLine="Dim url As Map = result.Get(\"url\")";
_url = new anywheresoftware.b4a.objects.collections.Map();
_url.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_result.Get((Object)("url"))));
RDebugUtils.currentLine=9240749;
 //BA.debugLineNum = 9240749;BA.debugLine="Dim sited As String = url.Get(\"site\")";
_sited = BA.ObjectToString(_url.Get((Object)("site")));
RDebugUtils.currentLine=9240750;
 //BA.debugLineNum = 9240750;BA.debugLine="Dim domain As String = url.Get(\"domain\")";
_domain = BA.ObjectToString(_url.Get((Object)("domain")));
RDebugUtils.currentLine=9240751;
 //BA.debugLineNum = 9240751;BA.debugLine="Dim rootd As String = url.Get(\"root\")";
_rootd = BA.ObjectToString(_url.Get((Object)("root")));
RDebugUtils.currentLine=9240752;
 //BA.debugLineNum = 9240752;BA.debugLine="Dim update As String = url.Get(\"update\")";
_update = BA.ObjectToString(_url.Get((Object)("update")));
RDebugUtils.currentLine=9240753;
 //BA.debugLineNum = 9240753;BA.debugLine="Dim enter As String = url.Get(\"enter\")";
_enter = BA.ObjectToString(_url.Get((Object)("enter")));
RDebugUtils.currentLine=9240754;
 //BA.debugLineNum = 9240754;BA.debugLine="Dim kingdom As String = url.Get(\"kingdom\")";
_kingdom = BA.ObjectToString(_url.Get((Object)("kingdom")));
RDebugUtils.currentLine=9240755;
 //BA.debugLineNum = 9240755;BA.debugLine="Dim homepage As List = result.Get(\"homepage\")";
_homepage = new anywheresoftware.b4a.objects.collections.List();
_homepage.setObject((java.util.List)(_result.Get((Object)("homepage"))));
RDebugUtils.currentLine=9240756;
 //BA.debugLineNum = 9240756;BA.debugLine="For Each colhomepage As Map In homepage";
_colhomepage = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group179 = _homepage;
final int groupLen179 = group179.getSize()
;int index179 = 0;
;
for (; index179 < groupLen179;index179++){
_colhomepage.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group179.Get(index179)));
RDebugUtils.currentLine=9240758;
 //BA.debugLineNum = 9240758;BA.debugLine="Dim Typert As String = colhomepage.Get(\"type\")";
_typert = BA.ObjectToString(_colhomepage.Get((Object)("type")));
RDebugUtils.currentLine=9240761;
 //BA.debugLineNum = 9240761;BA.debugLine="Select Typert";
switch (BA.switchObjectToInt(_typert,"promotion")) {
case 0: {
RDebugUtils.currentLine=9240763;
 //BA.debugLineNum = 9240763;BA.debugLine="Dim expire As Map = colhomepage.Get(\"expire\")";
_expire = new anywheresoftware.b4a.objects.collections.Map();
_expire.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_colhomepage.Get((Object)("expire"))));
RDebugUtils.currentLine=9240764;
 //BA.debugLineNum = 9240764;BA.debugLine="If colhomepage.ContainsKey(\"data\") Then";
if (_colhomepage.ContainsKey((Object)("data"))) { 
RDebugUtils.currentLine=9240766;
 //BA.debugLineNum = 9240766;BA.debugLine="Dim data As List = colhomepage.Get(\"data\")";
_data = new anywheresoftware.b4a.objects.collections.List();
_data.setObject((java.util.List)(_colhomepage.Get((Object)("data"))));
RDebugUtils.currentLine=9240767;
 //BA.debugLineNum = 9240767;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9240768;
 //BA.debugLineNum = 9240768;BA.debugLine="lst.Initialize";
_lst.Initialize();
RDebugUtils.currentLine=9240769;
 //BA.debugLineNum = 9240769;BA.debugLine="For Each coldata As Map In data";
_coldata = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group188 = _data;
final int groupLen188 = group188.getSize()
;int index188 = 0;
;
for (; index188 < groupLen188;index188++){
_coldata.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group188.Get(index188)));
RDebugUtils.currentLine=9240770;
 //BA.debugLineNum = 9240770;BA.debugLine="Dim mode As String = coldata.Get(\"mode\")";
_mode = BA.ObjectToString(_coldata.Get((Object)("mode")));
RDebugUtils.currentLine=9240771;
 //BA.debugLineNum = 9240771;BA.debugLine="Dim title As String = coldata.Get(\"title\")";
_title = BA.ObjectToString(_coldata.Get((Object)("title")));
RDebugUtils.currentLine=9240773;
 //BA.debugLineNum = 9240773;BA.debugLine="Dim image As String = coldata.Get(\"image\")";
_image = BA.ObjectToString(_coldata.Get((Object)("image")));
RDebugUtils.currentLine=9240774;
 //BA.debugLineNum = 9240774;BA.debugLine="Dim Activitya As String = coldata.Get(\"activ";
_activitya = BA.ObjectToString(_coldata.Get((Object)("activity")));
RDebugUtils.currentLine=9240775;
 //BA.debugLineNum = 9240775;BA.debugLine="Dim urla As String = coldata.Get(\"url\")";
_urla = BA.ObjectToString(_coldata.Get((Object)("url")));
RDebugUtils.currentLine=9240777;
 //BA.debugLineNum = 9240777;BA.debugLine="lst.Add(image&\"#\"&\"123123\"&\"#\"&title&\"#\"&\"10";
_lst.Add((Object)(_image+"#"+"123123"+"#"+_title+"#"+"1000"+"#"+"455"+"#"+"132"+"#"+"123"+"#"+"123"+"#"+"132"));
 }
};
RDebugUtils.currentLine=9240780;
 //BA.debugLineNum = 9240780;BA.debugLine="Log(expire.Get(\"serverttime\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("39240780",BA.ObjectToString(_expire.Get((Object)("serverttime"))),0);
RDebugUtils.currentLine=9240781;
 //BA.debugLineNum = 9240781;BA.debugLine="Log(expire.Get(\"expiretime\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("39240781",BA.ObjectToString(_expire.Get((Object)("expiretime"))),0);
RDebugUtils.currentLine=9240782;
 //BA.debugLineNum = 9240782;BA.debugLine="shegeft_creat(4%x,lst,expire.Get(\"serverttime";
_shegeft_creat(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (4),mostCurrent.activityBA),_lst,BA.ObjectToLongNumber(_expire.Get((Object)("serverttime"))),BA.ObjectToLongNumber(_expire.Get((Object)("expiretime"))));
RDebugUtils.currentLine=9240783;
 //BA.debugLineNum = 9240783;BA.debugLine="Log(title)";
anywheresoftware.b4a.keywords.Common.LogImpl("39240783",_title,0);
 };
 break; }
}
;
 }
};
RDebugUtils.currentLine=9240792;
 //BA.debugLineNum = 9240792;BA.debugLine="Dim ok As String = root.Get(\"ok\")";
_ok = BA.ObjectToString(_root.Get((Object)("ok")));
RDebugUtils.currentLine=9240793;
 //BA.debugLineNum = 9240793;BA.debugLine="End Sub";
return "";
}
public static String  _shegeft_creat(int _top,anywheresoftware.b4a.objects.collections.List _lstnews1,long _start,long _endd) throws Exception{
RDebugUtils.currentModule="home";
if (Debug.shouldDelegate(mostCurrent.activityBA, "shegeft_creat", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "shegeft_creat", new Object[] {_top,_lstnews1,_start,_endd}));}
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
anywheresoftware.b4a.objects.LabelWrapper _shegeft = null;
b4a.example.creatlv _fc = null;
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub shegeft_creat(top As Int,lstnews1 As List,star";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="pnl.Initialize(\"\")";
_pnl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162691;
 //BA.debugLineNum = 2162691;BA.debugLine="sv.Panel.AddView(pnl,0,top,100%x,50%x)";
mostCurrent._sv.getPanel().AddView((android.view.View)(_pnl.getObject()),(int) (0),_top,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA));
RDebugUtils.currentLine=2162693;
 //BA.debugLineNum = 2162693;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=2162694;
 //BA.debugLineNum = 2162694;BA.debugLine="cd.Initialize(0xFF727272,2dip)";
_cd.Initialize((int) (0xff727272),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=2162697;
 //BA.debugLineNum = 2162697;BA.debugLine="lblho.Initialize(\"\")";
mostCurrent._lblho.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162698;
 //BA.debugLineNum = 2162698;BA.debugLine="pnl.AddView(lblho,4%x,1%x,8%x,8%x)";
_pnl.AddView((android.view.View)(mostCurrent._lblho.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (4),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (8),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (8),mostCurrent.activityBA));
RDebugUtils.currentLine=2162699;
 //BA.debugLineNum = 2162699;BA.debugLine="lblho.Background=cd";
mostCurrent._lblho.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=2162700;
 //BA.debugLineNum = 2162700;BA.debugLine="lblho.Text=\"02\"";
mostCurrent._lblho.setText(BA.ObjectToCharSequence("02"));
RDebugUtils.currentLine=2162701;
 //BA.debugLineNum = 2162701;BA.debugLine="lblho.Gravity=Gravity.CENTER";
mostCurrent._lblho.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162702;
 //BA.debugLineNum = 2162702;BA.debugLine="lblho.TextColor=Colors.White";
mostCurrent._lblho.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2162703;
 //BA.debugLineNum = 2162703;BA.debugLine="lblho.TextSize=16";
mostCurrent._lblho.setTextSize((float) (16));
RDebugUtils.currentLine=2162705;
 //BA.debugLineNum = 2162705;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2162706;
 //BA.debugLineNum = 2162706;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162707;
 //BA.debugLineNum = 2162707;BA.debugLine="pnl.AddView(lbl,12%x,1%x,3%x,8%x)";
_pnl.AddView((android.view.View)(_lbl.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (12),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (8),mostCurrent.activityBA));
RDebugUtils.currentLine=2162708;
 //BA.debugLineNum = 2162708;BA.debugLine="lbl.Text=\":\"";
_lbl.setText(BA.ObjectToCharSequence(":"));
RDebugUtils.currentLine=2162709;
 //BA.debugLineNum = 2162709;BA.debugLine="lbl.Gravity=Gravity.CENTER";
_lbl.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162710;
 //BA.debugLineNum = 2162710;BA.debugLine="lbl.TextColor=0xFF727272";
_lbl.setTextColor((int) (0xff727272));
RDebugUtils.currentLine=2162711;
 //BA.debugLineNum = 2162711;BA.debugLine="lbl.TextSize=16";
_lbl.setTextSize((float) (16));
RDebugUtils.currentLine=2162713;
 //BA.debugLineNum = 2162713;BA.debugLine="lblmin.Initialize(\"\")";
mostCurrent._lblmin.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162714;
 //BA.debugLineNum = 2162714;BA.debugLine="pnl.AddView(lblmin,15%x,1%x,8%x,8%x)";
_pnl.AddView((android.view.View)(mostCurrent._lblmin.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (8),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (8),mostCurrent.activityBA));
RDebugUtils.currentLine=2162715;
 //BA.debugLineNum = 2162715;BA.debugLine="lblmin.Background=cd";
mostCurrent._lblmin.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=2162716;
 //BA.debugLineNum = 2162716;BA.debugLine="lblmin.Text=\"02\"";
mostCurrent._lblmin.setText(BA.ObjectToCharSequence("02"));
RDebugUtils.currentLine=2162717;
 //BA.debugLineNum = 2162717;BA.debugLine="lblmin.Gravity=Gravity.CENTER";
mostCurrent._lblmin.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162718;
 //BA.debugLineNum = 2162718;BA.debugLine="lblmin.TextColor=Colors.White";
mostCurrent._lblmin.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2162719;
 //BA.debugLineNum = 2162719;BA.debugLine="lblmin.TextSize=16";
mostCurrent._lblmin.setTextSize((float) (16));
RDebugUtils.currentLine=2162721;
 //BA.debugLineNum = 2162721;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2162722;
 //BA.debugLineNum = 2162722;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162723;
 //BA.debugLineNum = 2162723;BA.debugLine="pnl.AddView(lbl,23%x,1%x,3%x,8%x)";
_pnl.AddView((android.view.View)(_lbl.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (23),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (8),mostCurrent.activityBA));
RDebugUtils.currentLine=2162724;
 //BA.debugLineNum = 2162724;BA.debugLine="lbl.Text=\":\"";
_lbl.setText(BA.ObjectToCharSequence(":"));
RDebugUtils.currentLine=2162725;
 //BA.debugLineNum = 2162725;BA.debugLine="lbl.Gravity=Gravity.CENTER";
_lbl.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162726;
 //BA.debugLineNum = 2162726;BA.debugLine="lbl.TextColor=0xFF727272";
_lbl.setTextColor((int) (0xff727272));
RDebugUtils.currentLine=2162727;
 //BA.debugLineNum = 2162727;BA.debugLine="lbl.TextSize=16";
_lbl.setTextSize((float) (16));
RDebugUtils.currentLine=2162729;
 //BA.debugLineNum = 2162729;BA.debugLine="lblsecend.Initialize(\"\")";
mostCurrent._lblsecend.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162730;
 //BA.debugLineNum = 2162730;BA.debugLine="pnl.AddView(lblsecend,26%x,1%x,8%x,8%x)";
_pnl.AddView((android.view.View)(mostCurrent._lblsecend.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (26),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (8),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (8),mostCurrent.activityBA));
RDebugUtils.currentLine=2162731;
 //BA.debugLineNum = 2162731;BA.debugLine="lblsecend.Background=cd";
mostCurrent._lblsecend.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=2162732;
 //BA.debugLineNum = 2162732;BA.debugLine="lblsecend.Text=\"02\"";
mostCurrent._lblsecend.setText(BA.ObjectToCharSequence("02"));
RDebugUtils.currentLine=2162733;
 //BA.debugLineNum = 2162733;BA.debugLine="lblsecend.Gravity=Gravity.CENTER";
mostCurrent._lblsecend.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162734;
 //BA.debugLineNum = 2162734;BA.debugLine="lblsecend.TextColor=Colors.White";
mostCurrent._lblsecend.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2162735;
 //BA.debugLineNum = 2162735;BA.debugLine="lblsecend.TextSize=16";
mostCurrent._lblsecend.setTextSize((float) (16));
RDebugUtils.currentLine=2162737;
 //BA.debugLineNum = 2162737;BA.debugLine="time313 =endd-start";
_time313 = (long) (_endd-_start);
RDebugUtils.currentLine=2162739;
 //BA.debugLineNum = 2162739;BA.debugLine="t_shegeft.Initialize(\"t_shegeft\", 1000)";
_t_shegeft.Initialize(processBA,"t_shegeft",(long) (1000));
RDebugUtils.currentLine=2162740;
 //BA.debugLineNum = 2162740;BA.debugLine="t_shegeft.Enabled = True";
_t_shegeft.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2162742;
 //BA.debugLineNum = 2162742;BA.debugLine="Dim shegeft As Label";
_shegeft = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2162743;
 //BA.debugLineNum = 2162743;BA.debugLine="shegeft.Initialize(\"\")";
_shegeft.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162744;
 //BA.debugLineNum = 2162744;BA.debugLine="shegeft.Text=\"محصولات شگفت انگیز\"";
_shegeft.setText(BA.ObjectToCharSequence("محصولات شگفت انگیز"));
RDebugUtils.currentLine=2162745;
 //BA.debugLineNum = 2162745;BA.debugLine="shegeft.Gravity=Gravity.RIGHT+Gravity.CENTER";
_shegeft.setGravity((int) (anywheresoftware.b4a.keywords.Common.Gravity.RIGHT+anywheresoftware.b4a.keywords.Common.Gravity.CENTER));
RDebugUtils.currentLine=2162746;
 //BA.debugLineNum = 2162746;BA.debugLine="shegeft.Typeface=C.irs";
_shegeft.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ .getObject()));
RDebugUtils.currentLine=2162747;
 //BA.debugLineNum = 2162747;BA.debugLine="shegeft.TextSize=18";
_shegeft.setTextSize((float) (18));
RDebugUtils.currentLine=2162748;
 //BA.debugLineNum = 2162748;BA.debugLine="sv.Panel.AddView(shegeft,50%x,top,45%x,10%x)";
mostCurrent._sv.getPanel().AddView((android.view.View)(_shegeft.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA),_top,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=2162750;
 //BA.debugLineNum = 2162750;BA.debugLine="Dim fc As creatLV";
_fc = new b4a.example.creatlv();
RDebugUtils.currentLine=2162751;
 //BA.debugLineNum = 2162751;BA.debugLine="fc.Initialize(sv.Panel,top+12%x,lstnews1)";
_fc._initialize /*String*/ (null,mostCurrent.activityBA,mostCurrent._sv.getPanel(),(int) (_top+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (12),mostCurrent.activityBA)),_lstnews1);
RDebugUtils.currentLine=2162753;
 //BA.debugLineNum = 2162753;BA.debugLine="End Sub";
return "";
}
public static String  _t_shegeft_tick() throws Exception{
RDebugUtils.currentModule="home";
if (Debug.shouldDelegate(mostCurrent.activityBA, "t_shegeft_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "t_shegeft_tick", null));}
int _sec = 0;
int _hours = 0;
int _minutes = 0;
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub t_shegeft_Tick";
RDebugUtils.currentLine=2228227;
 //BA.debugLineNum = 2228227;BA.debugLine="time313=time313-1000";
_time313 = (long) (_time313-1000);
RDebugUtils.currentLine=2228229;
 //BA.debugLineNum = 2228229;BA.debugLine="Dim sec, hours, minutes As Int";
_sec = 0;
_hours = 0;
_minutes = 0;
RDebugUtils.currentLine=2228235;
 //BA.debugLineNum = 2228235;BA.debugLine="hours = DateTime.GetHour(time313)";
_hours = anywheresoftware.b4a.keywords.Common.DateTime.GetHour(_time313);
RDebugUtils.currentLine=2228236;
 //BA.debugLineNum = 2228236;BA.debugLine="minutes = DateTime.GetMinute(time313)";
_minutes = anywheresoftware.b4a.keywords.Common.DateTime.GetMinute(_time313);
RDebugUtils.currentLine=2228237;
 //BA.debugLineNum = 2228237;BA.debugLine="sec = DateTime.GetSecond(time313)";
_sec = anywheresoftware.b4a.keywords.Common.DateTime.GetSecond(_time313);
RDebugUtils.currentLine=2228240;
 //BA.debugLineNum = 2228240;BA.debugLine="lblsecend.Text=sec";
mostCurrent._lblsecend.setText(BA.ObjectToCharSequence(_sec));
RDebugUtils.currentLine=2228241;
 //BA.debugLineNum = 2228241;BA.debugLine="lblmin.Text=minutes";
mostCurrent._lblmin.setText(BA.ObjectToCharSequence(_minutes));
RDebugUtils.currentLine=2228242;
 //BA.debugLineNum = 2228242;BA.debugLine="lblho.Text=hours";
mostCurrent._lblho.setText(BA.ObjectToCharSequence(_hours));
RDebugUtils.currentLine=2228246;
 //BA.debugLineNum = 2228246;BA.debugLine="If lblsecend.Text<10 Then  lblsecend.Text=\"0\"&lbl";
if ((double)(Double.parseDouble(mostCurrent._lblsecend.getText()))<10) { 
mostCurrent._lblsecend.setText(BA.ObjectToCharSequence("0"+mostCurrent._lblsecend.getText()));};
RDebugUtils.currentLine=2228247;
 //BA.debugLineNum = 2228247;BA.debugLine="If lblmin.Text<10 Then  lblmin.Text=\"0\"& lblmin.T";
if ((double)(Double.parseDouble(mostCurrent._lblmin.getText()))<10) { 
mostCurrent._lblmin.setText(BA.ObjectToCharSequence("0"+mostCurrent._lblmin.getText()));};
RDebugUtils.currentLine=2228248;
 //BA.debugLineNum = 2228248;BA.debugLine="If lblho.Text<9 Then  lblho.Text=\"0\"& lblho.Text";
if ((double)(Double.parseDouble(mostCurrent._lblho.getText()))<9) { 
mostCurrent._lblho.setText(BA.ObjectToCharSequence("0"+mostCurrent._lblho.getText()));};
RDebugUtils.currentLine=2228250;
 //BA.debugLineNum = 2228250;BA.debugLine="If lblsecend.Text=0 Then  lblsecend.Text=\"00\"";
if ((mostCurrent._lblsecend.getText()).equals(BA.NumberToString(0))) { 
mostCurrent._lblsecend.setText(BA.ObjectToCharSequence("00"));};
RDebugUtils.currentLine=2228251;
 //BA.debugLineNum = 2228251;BA.debugLine="If lblmin.Text=0 Then  lblmin.Text=\"00\"";
if ((mostCurrent._lblmin.getText()).equals(BA.NumberToString(0))) { 
mostCurrent._lblmin.setText(BA.ObjectToCharSequence("00"));};
RDebugUtils.currentLine=2228252;
 //BA.debugLineNum = 2228252;BA.debugLine="If lblho.Text=0 Then  lblho.Text=\"00\"";
if ((mostCurrent._lblho.getText()).equals(BA.NumberToString(0))) { 
mostCurrent._lblho.setText(BA.ObjectToCharSequence("00"));};
RDebugUtils.currentLine=2228253;
 //BA.debugLineNum = 2228253;BA.debugLine="End Sub";
return "";
}
}