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

public class finger extends Activity implements B4AActivity{
	public static finger mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.finger");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (finger).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.finger");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.finger", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (finger) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (finger) Resume **");
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
		return finger.class;
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
        BA.LogInfo("** Activity (finger) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            finger mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (finger) Resume **");
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
public b4a.example.fingerprintmanager _fingerprint = null;
public ir.hitexroid.lottie.Hitex_LottieAnimationView _lav = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
public b4a.example.main _main = null;
public b4a.example.act_tip _act_tip = null;
public b4a.example.login _login = null;
public b4a.example.verify _verify = null;
public b4a.example.home _home = null;
public b4a.example.c _c = null;
public b4a.example.starter _starter = null;
public b4a.example.page _page = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 23;BA.debugLine="Activity.Background= C.Gradient(0xFFFFFFFF,0xFFFF";
mostCurrent._activity.setBackground((android.graphics.drawable.Drawable)(mostCurrent._c._gradient(mostCurrent.activityBA,(int) (0xffffffff),(int) (0xffffffff),(int) (0),anywheresoftware.b4a.keywords.Common.True).getObject()));
 //BA.debugLineNum = 25;BA.debugLine="fingerprint.Initialize (Me, \"auth\")";
mostCurrent._fingerprint._initialize(processBA,finger.getObject(),"auth");
 //BA.debugLineNum = 30;BA.debugLine="lav.Initialize(\"LAV\")";
mostCurrent._lav.Initialize(mostCurrent.activityBA,"LAV");
 //BA.debugLineNum = 31;BA.debugLine="Activity.AddView(lav,10%x,50%y-60%x,80%x,70%x)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._lav.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 32;BA.debugLine="lav.SetAnimation(File.DirAssets,\"gray.json\")";
mostCurrent._lav.SetAnimation(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"gray.json");
 //BA.debugLineNum = 33;BA.debugLine="lav.SetLoop(True) 'repeat";
mostCurrent._lav.SetLoop(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 34;BA.debugLine="lav.PlayAnimation";
mostCurrent._lav.PlayAnimation();
 //BA.debugLineNum = 35;BA.debugLine="lav.Speed=.7";
mostCurrent._lav.setSpeed((float) (.7));
 //BA.debugLineNum = 38;BA.debugLine="fingerprint.Authenticate";
mostCurrent._fingerprint._authenticate();
 //BA.debugLineNum = 41;BA.debugLine="C.setlblset(lbl,\"\",Activity,0,50%y+20%x,100%x,13%";
mostCurrent._c._setlblset(mostCurrent.activityBA,mostCurrent._lbl,"",mostCurrent._activity,(int) (0),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA)+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (13),mostCurrent.activityBA),"لطفا اثر انگشت خود را تایید کنید",anywheresoftware.b4a.keywords.Common.Gravity.CENTER,mostCurrent._c._irs,(int) (15),(int) (0xff898989));
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 77;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 73;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public static void  _auth_complete(boolean _success,String _errormessage) throws Exception{
ResumableSub_Auth_Complete rsub = new ResumableSub_Auth_Complete(null,_success,_errormessage);
rsub.resume(processBA, null);
}
public static class ResumableSub_Auth_Complete extends BA.ResumableSub {
public ResumableSub_Auth_Complete(b4a.example.finger parent,boolean _success,String _errormessage) {
this.parent = parent;
this._success = _success;
this._errormessage = _errormessage;
}
b4a.example.finger parent;
boolean _success;
String _errormessage;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 59;BA.debugLine="If Success Then";
if (true) break;

case 1:
//if
this.state = 6;
if (_success) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 //BA.debugLineNum = 60;BA.debugLine="lav.RemoveView";
parent.mostCurrent._lav.RemoveView();
 //BA.debugLineNum = 61;BA.debugLine="lav.Initialize(\"LAV\")";
parent.mostCurrent._lav.Initialize(mostCurrent.activityBA,"LAV");
 //BA.debugLineNum = 62;BA.debugLine="Activity.AddView(lav,10%x,50%y-60%x,80%x,70%x)";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._lav.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 63;BA.debugLine="lav.SetAnimation(File.DirAssets,\"green.json\")";
parent.mostCurrent._lav.SetAnimation(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"green.json");
 //BA.debugLineNum = 64;BA.debugLine="lav.PlayAnimation";
parent.mostCurrent._lav.PlayAnimation();
 //BA.debugLineNum = 65;BA.debugLine="lav.Speed=.7";
parent.mostCurrent._lav.setSpeed((float) (.7));
 //BA.debugLineNum = 66;BA.debugLine="lbl.Text=\"اثر انگشت تایید شد\"";
parent.mostCurrent._lbl.setText(BA.ObjectToCharSequence("اثر انگشت تایید شد"));
 //BA.debugLineNum = 67;BA.debugLine="Sleep(2000 )";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (2000));
this.state = 7;
return;
case 7:
//C
this.state = 6;
;
 //BA.debugLineNum = 68;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 if (true) break;

case 5:
//C
this.state = 6;
 if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _auth_fail() throws Exception{
ResumableSub_Auth_fail rsub = new ResumableSub_Auth_fail(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_Auth_fail extends BA.ResumableSub {
public ResumableSub_Auth_fail(b4a.example.finger parent) {
this.parent = parent;
}
b4a.example.finger parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 45;BA.debugLine="lav.RemoveView";
parent.mostCurrent._lav.RemoveView();
 //BA.debugLineNum = 46;BA.debugLine="lav.Initialize(\"LAV\")";
parent.mostCurrent._lav.Initialize(mostCurrent.activityBA,"LAV");
 //BA.debugLineNum = 47;BA.debugLine="Activity.AddView(lav,10%x,50%y-60%x,80%x,70%x)";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._lav.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 48;BA.debugLine="lav.SetAnimation(File.DirAssets,\"red.json\")";
parent.mostCurrent._lav.SetAnimation(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"red.json");
 //BA.debugLineNum = 49;BA.debugLine="lav.PlayAnimation";
parent.mostCurrent._lav.PlayAnimation();
 //BA.debugLineNum = 50;BA.debugLine="lav.Speed=.7";
parent.mostCurrent._lav.setSpeed((float) (.7));
 //BA.debugLineNum = 51;BA.debugLine="lbl.Text=\"اثر انگشت مطابق نیست\"";
parent.mostCurrent._lbl.setText(BA.ObjectToCharSequence("اثر انگشت مطابق نیست"));
 //BA.debugLineNum = 53;BA.debugLine="Sleep(2000 )";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (2000));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 54;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private fingerprint As FingerprintManager";
mostCurrent._fingerprint = new b4a.example.fingerprintmanager();
 //BA.debugLineNum = 16;BA.debugLine="Dim lav As Hitex_LottieAnimationView";
mostCurrent._lav = new ir.hitexroid.lottie.Hitex_LottieAnimationView();
 //BA.debugLineNum = 17;BA.debugLine="Dim lbl As Label";
mostCurrent._lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
