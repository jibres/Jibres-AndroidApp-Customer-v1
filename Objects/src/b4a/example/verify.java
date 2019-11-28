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

public class verify extends Activity implements B4AActivity{
	public static verify mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.verify");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (verify).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.verify");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.verify", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (verify) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (verify) Resume **");
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
		return verify.class;
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
        BA.LogInfo("** Activity (verify) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            verify mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (verify) Resume **");
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
public de.amberhome.objects.appcompat.ACEditTextWrapper _ac = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl4 = null;
public b4a.example.main _main = null;
public b4a.example.act_tip _act_tip = null;
public b4a.example.login _login = null;
public b4a.example.home _home = null;
public b4a.example.c _c = null;
public b4a.example.starter _starter = null;
public b4a.example.page _page = null;
public b4a.example.finger _finger = null;
public static String  _activity_click() throws Exception{
RDebugUtils.currentModule="verify";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_click", null));}
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub Activity_Click";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="StartActivity(page)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._page.getObject()));
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="End Sub";
return "";
}
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="verify";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.ImageViewWrapper _img = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
ir.cafematerial.librariessupport.LibrariesSupport _cm = null;
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="Activity.Background= C.Gradient(0xff54A3EC,0xff54";
mostCurrent._activity.setBackground((android.graphics.drawable.Drawable)(mostCurrent._c._gradient /*anywheresoftware.b4a.objects.drawable.GradientDrawable*/ (mostCurrent.activityBA,(int) (0xff54a3ec),(int) (0xff5433b0),(int) (0),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=1507333;
 //BA.debugLineNum = 1507333;BA.debugLine="Dim img As ImageView";
_img = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=1507334;
 //BA.debugLineNum = 1507334;BA.debugLine="C.imgCreate(img,\"\",Activity,40%x,50%y-50%x,20%x,2";
mostCurrent._c._imgcreate /*String*/ (mostCurrent.activityBA,_img,"",mostCurrent._activity,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (40),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
RDebugUtils.currentLine=1507335;
 //BA.debugLineNum = 1507335;BA.debugLine="img.Bitmap=Application.Icon";
_img.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Application.getIcon().getObject()));
RDebugUtils.currentLine=1507338;
 //BA.debugLineNum = 1507338;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1507339;
 //BA.debugLineNum = 1507339;BA.debugLine="C.setlblset(lbl,\"\",Activity,0,50%y-20%x,100%x,13%";
mostCurrent._c._setlblset /*String*/ (mostCurrent.activityBA,_lbl,"",mostCurrent._activity,(int) (0),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (13),mostCurrent.activityBA),"تایید شماره همراه",anywheresoftware.b4a.keywords.Common.Gravity.CENTER,mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ ,(int) (20),(int) (0xffffffff));
RDebugUtils.currentLine=1507341;
 //BA.debugLineNum = 1507341;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1507342;
 //BA.debugLineNum = 1507342;BA.debugLine="C.setlblset(lbl,\"\",Activity,0,50%y-10%x,100%x,13%";
mostCurrent._c._setlblset /*String*/ (mostCurrent.activityBA,_lbl,"",mostCurrent._activity,(int) (0),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (13),mostCurrent.activityBA),"لطفا کد پیامک شده را وارد کنید",anywheresoftware.b4a.keywords.Common.Gravity.CENTER,mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ ,(int) (15),(int) (0xffffffff));
RDebugUtils.currentLine=1507344;
 //BA.debugLineNum = 1507344;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1507345;
 //BA.debugLineNum = 1507345;BA.debugLine="C.PnlCreate(pnl,\"\",Activity,19%x,50%y+15%x,14%x,1";
mostCurrent._c._pnlcreate /*String*/ (mostCurrent.activityBA,_pnl,"",mostCurrent._activity,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (19),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA)+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (14),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (14),mostCurrent.activityBA));
RDebugUtils.currentLine=1507346;
 //BA.debugLineNum = 1507346;BA.debugLine="pnl.Background= C.Gradient(-1,-1,5000,True)";
_pnl.setBackground((android.graphics.drawable.Drawable)(mostCurrent._c._gradient /*anywheresoftware.b4a.objects.drawable.GradientDrawable*/ (mostCurrent.activityBA,(int) (-1),(int) (-1),(int) (5000),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=1507349;
 //BA.debugLineNum = 1507349;BA.debugLine="C.setlblset(lbl1,\"lblc\",pnl,0,0,-1,-1,\"\",Gravity.";
mostCurrent._c._setlblset /*String*/ (mostCurrent.activityBA,mostCurrent._lbl1,"lblc",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_pnl.getObject())),(int) (0),(int) (0),(int) (-1),(int) (-1),"",anywheresoftware.b4a.keywords.Common.Gravity.CENTER,mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ ,(int) (20),(int) (-1));
RDebugUtils.currentLine=1507351;
 //BA.debugLineNum = 1507351;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1507352;
 //BA.debugLineNum = 1507352;BA.debugLine="C.PnlCreate(pnl,\"\",Activity,19%x+16%x,50%y+15%x,1";
mostCurrent._c._pnlcreate /*String*/ (mostCurrent.activityBA,_pnl,"",mostCurrent._activity,(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (19),mostCurrent.activityBA)+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (16),mostCurrent.activityBA)),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA)+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (14),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (14),mostCurrent.activityBA));
RDebugUtils.currentLine=1507353;
 //BA.debugLineNum = 1507353;BA.debugLine="pnl.Background= C.Gradient(-1,-1,5000,True)";
_pnl.setBackground((android.graphics.drawable.Drawable)(mostCurrent._c._gradient /*anywheresoftware.b4a.objects.drawable.GradientDrawable*/ (mostCurrent.activityBA,(int) (-1),(int) (-1),(int) (5000),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=1507355;
 //BA.debugLineNum = 1507355;BA.debugLine="C.setlblset(lbl2,\"lblc\",pnl,0,0,-1,-1,\"\",Gravity.";
mostCurrent._c._setlblset /*String*/ (mostCurrent.activityBA,mostCurrent._lbl2,"lblc",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_pnl.getObject())),(int) (0),(int) (0),(int) (-1),(int) (-1),"",anywheresoftware.b4a.keywords.Common.Gravity.CENTER,mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ ,(int) (20),(int) (-1));
RDebugUtils.currentLine=1507357;
 //BA.debugLineNum = 1507357;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1507358;
 //BA.debugLineNum = 1507358;BA.debugLine="C.PnlCreate(pnl,\"\",Activity,19%x+(16%x*2),50%y+15";
mostCurrent._c._pnlcreate /*String*/ (mostCurrent.activityBA,_pnl,"",mostCurrent._activity,(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (19),mostCurrent.activityBA)+(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (16),mostCurrent.activityBA)*2)),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA)+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (14),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (14),mostCurrent.activityBA));
RDebugUtils.currentLine=1507359;
 //BA.debugLineNum = 1507359;BA.debugLine="pnl.Background= C.Gradient(-1,-1,5000,True)";
_pnl.setBackground((android.graphics.drawable.Drawable)(mostCurrent._c._gradient /*anywheresoftware.b4a.objects.drawable.GradientDrawable*/ (mostCurrent.activityBA,(int) (-1),(int) (-1),(int) (5000),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=1507361;
 //BA.debugLineNum = 1507361;BA.debugLine="C.setlblset(lbl3,\"lblc\",pnl,0,0,-1,-1,\"\",Gravity.";
mostCurrent._c._setlblset /*String*/ (mostCurrent.activityBA,mostCurrent._lbl3,"lblc",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_pnl.getObject())),(int) (0),(int) (0),(int) (-1),(int) (-1),"",anywheresoftware.b4a.keywords.Common.Gravity.CENTER,mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ ,(int) (20),(int) (-1));
RDebugUtils.currentLine=1507363;
 //BA.debugLineNum = 1507363;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1507364;
 //BA.debugLineNum = 1507364;BA.debugLine="C.PnlCreate(pnl,\"\",Activity,19%x+(16%x*3),50%y+15";
mostCurrent._c._pnlcreate /*String*/ (mostCurrent.activityBA,_pnl,"",mostCurrent._activity,(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (19),mostCurrent.activityBA)+(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (16),mostCurrent.activityBA)*3)),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA)+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (14),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (14),mostCurrent.activityBA));
RDebugUtils.currentLine=1507365;
 //BA.debugLineNum = 1507365;BA.debugLine="pnl.Background= C.Gradient(-1,-1,5000,True)";
_pnl.setBackground((android.graphics.drawable.Drawable)(mostCurrent._c._gradient /*anywheresoftware.b4a.objects.drawable.GradientDrawable*/ (mostCurrent.activityBA,(int) (-1),(int) (-1),(int) (5000),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=1507367;
 //BA.debugLineNum = 1507367;BA.debugLine="C.setlblset(lbl4,\"lblc\",pnl,0,0,-1,-1,\"\",Gravity.";
mostCurrent._c._setlblset /*String*/ (mostCurrent.activityBA,mostCurrent._lbl4,"lblc",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_pnl.getObject())),(int) (0),(int) (0),(int) (-1),(int) (-1),"",anywheresoftware.b4a.keywords.Common.Gravity.CENTER,mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ ,(int) (20),(int) (-1));
RDebugUtils.currentLine=1507370;
 //BA.debugLineNum = 1507370;BA.debugLine="ac.Initialize(\"ed\")";
mostCurrent._ac.Initialize(mostCurrent.activityBA,"ed");
RDebugUtils.currentLine=1507371;
 //BA.debugLineNum = 1507371;BA.debugLine="Activity.AddView(ac,129%x,50%y+15%x,57%x,14%x)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._ac.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (129),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA)+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (57),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (14),mostCurrent.activityBA));
RDebugUtils.currentLine=1507372;
 //BA.debugLineNum = 1507372;BA.debugLine="ac.Typeface=c.irs";
mostCurrent._ac.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ .getObject()));
RDebugUtils.currentLine=1507373;
 //BA.debugLineNum = 1507373;BA.debugLine="ac.Hint=\"شماره موبایل\"";
mostCurrent._ac.setHint("شماره موبایل");
RDebugUtils.currentLine=1507374;
 //BA.debugLineNum = 1507374;BA.debugLine="ac.HintColor=0x5AFFFFFF";
mostCurrent._ac.setHintColor((int) (0x5affffff));
RDebugUtils.currentLine=1507375;
 //BA.debugLineNum = 1507375;BA.debugLine="Dim cm As cmLibrariesSupport";
_cm = new ir.cafematerial.librariessupport.LibrariesSupport();
RDebugUtils.currentLine=1507376;
 //BA.debugLineNum = 1507376;BA.debugLine="cm.SetEditTextTintColor(ac,Colors.Transparent,Col";
_cm.SetEditTextTintColor((android.widget.TextView)(mostCurrent._ac.getObject()),anywheresoftware.b4a.keywords.Common.Colors.Transparent,anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=1507377;
 //BA.debugLineNum = 1507377;BA.debugLine="c.Force_RtlSupported4View(ac)";
mostCurrent._c._force_rtlsupported4view /*String*/ (mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._ac.getObject())));
RDebugUtils.currentLine=1507378;
 //BA.debugLineNum = 1507378;BA.debugLine="ac.TextColor=Colors.White";
mostCurrent._ac.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1507379;
 //BA.debugLineNum = 1507379;BA.debugLine="ac.InputType=ac.INPUT_TYPE_NUMBERS";
mostCurrent._ac.setInputType(mostCurrent._ac.INPUT_TYPE_NUMBERS);
RDebugUtils.currentLine=1507380;
 //BA.debugLineNum = 1507380;BA.debugLine="ac.ForceDoneButton=True";
mostCurrent._ac.setForceDoneButton(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1507381;
 //BA.debugLineNum = 1507381;BA.debugLine="ac.RequestFocus";
mostCurrent._ac.RequestFocus();
RDebugUtils.currentLine=1507383;
 //BA.debugLineNum = 1507383;BA.debugLine="C.show_key(ac,\"\")";
mostCurrent._c._show_key /*void*/ (mostCurrent.activityBA,(anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(mostCurrent._ac.getObject())),"");
RDebugUtils.currentLine=1507384;
 //BA.debugLineNum = 1507384;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="verify";
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="verify";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="End Sub";
return "";
}
public static String  _ed_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="verify";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ed_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ed_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Sub ed_TextChanged (Old As String, New As String)";
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="Select New.Length";
switch (BA.switchObjectToInt(_new.length(),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4),(int) (5))) {
case 0: {
RDebugUtils.currentLine=1703941;
 //BA.debugLineNum = 1703941;BA.debugLine="lbl1.Text=\"\"";
mostCurrent._lbl1.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1703942;
 //BA.debugLineNum = 1703942;BA.debugLine="lbl2.Text=\"\"";
mostCurrent._lbl2.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1703943;
 //BA.debugLineNum = 1703943;BA.debugLine="lbl3.Text=\"\"";
mostCurrent._lbl3.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1703944;
 //BA.debugLineNum = 1703944;BA.debugLine="lbl4.Text=\"\"";
mostCurrent._lbl4.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1703945;
 //BA.debugLineNum = 1703945;BA.debugLine="pnlcolor(-1,-1,-1,-1)";
_pnlcolor((int) (-1),(int) (-1),(int) (-1),(int) (-1));
 break; }
case 1: {
RDebugUtils.currentLine=1703947;
 //BA.debugLineNum = 1703947;BA.debugLine="lbl1.Text=New.SubString2(0,1)";
mostCurrent._lbl1.setText(BA.ObjectToCharSequence(_new.substring((int) (0),(int) (1))));
RDebugUtils.currentLine=1703948;
 //BA.debugLineNum = 1703948;BA.debugLine="lbl2.Text=\"\"";
mostCurrent._lbl2.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1703949;
 //BA.debugLineNum = 1703949;BA.debugLine="lbl3.Text=\"\"";
mostCurrent._lbl3.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1703950;
 //BA.debugLineNum = 1703950;BA.debugLine="lbl4.Text=\"\"";
mostCurrent._lbl4.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1703951;
 //BA.debugLineNum = 1703951;BA.debugLine="pnlcolor(0xFF004383,-1,-1,-1)";
_pnlcolor((int) (0xff004383),(int) (-1),(int) (-1),(int) (-1));
 break; }
case 2: {
RDebugUtils.currentLine=1703953;
 //BA.debugLineNum = 1703953;BA.debugLine="lbl1.Text=New.SubString2(0,1)";
mostCurrent._lbl1.setText(BA.ObjectToCharSequence(_new.substring((int) (0),(int) (1))));
RDebugUtils.currentLine=1703954;
 //BA.debugLineNum = 1703954;BA.debugLine="lbl2.Text=New.SubString2(1,2)";
mostCurrent._lbl2.setText(BA.ObjectToCharSequence(_new.substring((int) (1),(int) (2))));
RDebugUtils.currentLine=1703955;
 //BA.debugLineNum = 1703955;BA.debugLine="lbl3.Text=\"\"";
mostCurrent._lbl3.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1703956;
 //BA.debugLineNum = 1703956;BA.debugLine="lbl4.Text=\"\"";
mostCurrent._lbl4.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1703957;
 //BA.debugLineNum = 1703957;BA.debugLine="pnlcolor(0xFF004383,0xFF004383,-1,-1)";
_pnlcolor((int) (0xff004383),(int) (0xff004383),(int) (-1),(int) (-1));
 break; }
case 3: {
RDebugUtils.currentLine=1703959;
 //BA.debugLineNum = 1703959;BA.debugLine="lbl1.Text=New.SubString2(0,1)";
mostCurrent._lbl1.setText(BA.ObjectToCharSequence(_new.substring((int) (0),(int) (1))));
RDebugUtils.currentLine=1703960;
 //BA.debugLineNum = 1703960;BA.debugLine="lbl2.Text=New.SubString2(1,2)";
mostCurrent._lbl2.setText(BA.ObjectToCharSequence(_new.substring((int) (1),(int) (2))));
RDebugUtils.currentLine=1703961;
 //BA.debugLineNum = 1703961;BA.debugLine="lbl3.Text=New.SubString2(2,3)";
mostCurrent._lbl3.setText(BA.ObjectToCharSequence(_new.substring((int) (2),(int) (3))));
RDebugUtils.currentLine=1703962;
 //BA.debugLineNum = 1703962;BA.debugLine="lbl4.Text=\"\"";
mostCurrent._lbl4.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1703963;
 //BA.debugLineNum = 1703963;BA.debugLine="pnlcolor(0xFF004383,0xFF004383,0xFF004383,-1)";
_pnlcolor((int) (0xff004383),(int) (0xff004383),(int) (0xff004383),(int) (-1));
 break; }
case 4: {
RDebugUtils.currentLine=1703966;
 //BA.debugLineNum = 1703966;BA.debugLine="lbl1.Text=New.SubString2(0,1)";
mostCurrent._lbl1.setText(BA.ObjectToCharSequence(_new.substring((int) (0),(int) (1))));
RDebugUtils.currentLine=1703967;
 //BA.debugLineNum = 1703967;BA.debugLine="lbl2.Text=New.SubString2(1,2)";
mostCurrent._lbl2.setText(BA.ObjectToCharSequence(_new.substring((int) (1),(int) (2))));
RDebugUtils.currentLine=1703968;
 //BA.debugLineNum = 1703968;BA.debugLine="lbl3.Text=New.SubString2(2,3)";
mostCurrent._lbl3.setText(BA.ObjectToCharSequence(_new.substring((int) (2),(int) (3))));
RDebugUtils.currentLine=1703969;
 //BA.debugLineNum = 1703969;BA.debugLine="lbl4.Text=New.SubString2(3,4)";
mostCurrent._lbl4.setText(BA.ObjectToCharSequence(_new.substring((int) (3),(int) (4))));
RDebugUtils.currentLine=1703970;
 //BA.debugLineNum = 1703970;BA.debugLine="pnlcolor(0xFF004383,0xFF004383,0xFF004383,0xFF0";
_pnlcolor((int) (0xff004383),(int) (0xff004383),(int) (0xff004383),(int) (0xff004383));
 break; }
case 5: {
RDebugUtils.currentLine=1703972;
 //BA.debugLineNum = 1703972;BA.debugLine="ac.Text=Old";
mostCurrent._ac.setText(BA.ObjectToCharSequence(_old));
RDebugUtils.currentLine=1703973;
 //BA.debugLineNum = 1703973;BA.debugLine="ac.SetSelection(4,0)";
mostCurrent._ac.SetSelection((int) (4),(int) (0));
 break; }
}
;
RDebugUtils.currentLine=1703976;
 //BA.debugLineNum = 1703976;BA.debugLine="End Sub";
return "";
}
public static String  _pnlcolor(int _a,int _b,int _cd,int _d) throws Exception{
RDebugUtils.currentModule="verify";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pnlcolor", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pnlcolor", new Object[] {_a,_b,_cd,_d}));}
anywheresoftware.b4a.objects.PanelWrapper _pnl1 = null;
anywheresoftware.b4a.objects.PanelWrapper _pnl2 = null;
anywheresoftware.b4a.objects.PanelWrapper _pnl3 = null;
anywheresoftware.b4a.objects.PanelWrapper _pnl4 = null;
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub pnlcolor(a As Int,b As Int,cd As Int,d As Int)";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="Dim pnl1 As Panel = lbl1.Parent";
_pnl1 = new anywheresoftware.b4a.objects.PanelWrapper();
_pnl1.setObject((android.view.ViewGroup)(mostCurrent._lbl1.getParent()));
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="Dim pnl2 As Panel = lbl2.Parent";
_pnl2 = new anywheresoftware.b4a.objects.PanelWrapper();
_pnl2.setObject((android.view.ViewGroup)(mostCurrent._lbl2.getParent()));
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="Dim pnl3 As Panel = lbl3.Parent";
_pnl3 = new anywheresoftware.b4a.objects.PanelWrapper();
_pnl3.setObject((android.view.ViewGroup)(mostCurrent._lbl3.getParent()));
RDebugUtils.currentLine=1638404;
 //BA.debugLineNum = 1638404;BA.debugLine="Dim pnl4 As Panel = lbl4.Parent";
_pnl4 = new anywheresoftware.b4a.objects.PanelWrapper();
_pnl4.setObject((android.view.ViewGroup)(mostCurrent._lbl4.getParent()));
RDebugUtils.currentLine=1638405;
 //BA.debugLineNum = 1638405;BA.debugLine="pnl1.Color=a";
_pnl1.setColor(_a);
RDebugUtils.currentLine=1638406;
 //BA.debugLineNum = 1638406;BA.debugLine="pnl2.Color=b";
_pnl2.setColor(_b);
RDebugUtils.currentLine=1638407;
 //BA.debugLineNum = 1638407;BA.debugLine="pnl3.Color=cd";
_pnl3.setColor(_cd);
RDebugUtils.currentLine=1638408;
 //BA.debugLineNum = 1638408;BA.debugLine="pnl4.Color=d";
_pnl4.setColor(_d);
RDebugUtils.currentLine=1638409;
 //BA.debugLineNum = 1638409;BA.debugLine="End Sub";
return "";
}
public static String  _lblc_click() throws Exception{
RDebugUtils.currentModule="verify";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblc_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblc_click", null));}
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub lblc_Click";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="C.show_key(ac,\"\")";
mostCurrent._c._show_key /*void*/ (mostCurrent.activityBA,(anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(mostCurrent._ac.getObject())),"");
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="End Sub";
return "";
}
}