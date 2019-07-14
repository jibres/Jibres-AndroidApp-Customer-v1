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

public class login extends Activity implements B4AActivity{
	public static login mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.login");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (login).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.login");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.login", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (login) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (login) Resume **");
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
		return login.class;
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
        BA.LogInfo("** Activity (login) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            login mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (login) Resume **");
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
public anywheresoftware.b4a.objects.LabelWrapper _lblbtn = null;
public b4a.example.main _main = null;
public b4a.example.act_tip _act_tip = null;
public b4a.example.verify _verify = null;
public b4a.example.home _home = null;
public b4a.example.c _c = null;
public b4a.example.starter _starter = null;
public b4a.example.page _page = null;
public b4a.example.finger _finger = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.objects.ImageViewWrapper _img = null;
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
de.amberhome.objects.appcompat.ACEditTextWrapper _ac = null;
ir.cafematerial.librariessupport.LibrariesSupport _cm = null;
 //BA.debugLineNum = 18;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 21;BA.debugLine="Activity.Background= C.Gradient(0xff54A3EC,0xff54";
mostCurrent._activity.setBackground((android.graphics.drawable.Drawable)(mostCurrent._c._gradient(mostCurrent.activityBA,(int) (0xff54a3ec),(int) (0xff5433b0),(int) (0),anywheresoftware.b4a.keywords.Common.True).getObject()));
 //BA.debugLineNum = 23;BA.debugLine="Dim img As ImageView";
_img = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 24;BA.debugLine="C.imgCreate(img,\"\",Activity,40%x,50%y-50%x,20%x,2";
mostCurrent._c._imgcreate(mostCurrent.activityBA,_img,"",mostCurrent._activity,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (40),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 25;BA.debugLine="img.Bitmap=Application.Icon";
_img.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Application.getIcon().getObject()));
 //BA.debugLineNum = 28;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="pnl.Initialize(\"\")";
_pnl.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 30;BA.debugLine="Activity.AddView(pnl,12%x,50%y-67%x+74%x,76%x,13%";
mostCurrent._activity.AddView((android.view.View)(_pnl.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (12),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (67),mostCurrent.activityBA)+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (74),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 33;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 34;BA.debugLine="C.setlblset(lbl,\"\",Activity,0,50%y-20%x,100%x,13%";
mostCurrent._c._setlblset(mostCurrent.activityBA,_lbl,"",mostCurrent._activity,(int) (0),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (13),mostCurrent.activityBA),"ثبت نام با شماره همراه",anywheresoftware.b4a.keywords.Common.Gravity.CENTER,mostCurrent._c._irs,(int) (20),(int) (0xffffffff));
 //BA.debugLineNum = 36;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 37;BA.debugLine="cd.Initialize2(0x5AC4C4C4, 10dip,1.5dip,0x5AFFFFF";
_cd.Initialize2((int) (0x5ac4c4c4),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1.5)),(int) (0x5affffff));
 //BA.debugLineNum = 38;BA.debugLine="pnl.Background = cd";
_pnl.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 40;BA.debugLine="Dim ac As ACEditText";
_ac = new de.amberhome.objects.appcompat.ACEditTextWrapper();
 //BA.debugLineNum = 41;BA.debugLine="ac.Initialize(\"ed\")";
_ac.Initialize(mostCurrent.activityBA,"ed");
 //BA.debugLineNum = 42;BA.debugLine="Activity.AddView(ac,29%x,50%y-67%x+74%x,57%x,14%x";
mostCurrent._activity.AddView((android.view.View)(_ac.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (29),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (67),mostCurrent.activityBA)+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (74),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (57),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 43;BA.debugLine="ac.Typeface=c.irs";
_ac.setTypeface((android.graphics.Typeface)(mostCurrent._c._irs.getObject()));
 //BA.debugLineNum = 44;BA.debugLine="ac.Hint=\"شماره موبایل\"";
_ac.setHint("شماره موبایل");
 //BA.debugLineNum = 45;BA.debugLine="ac.HintColor=0x5AFFFFFF";
_ac.setHintColor((int) (0x5affffff));
 //BA.debugLineNum = 46;BA.debugLine="Dim cm As cmLibrariesSupport";
_cm = new ir.cafematerial.librariessupport.LibrariesSupport();
 //BA.debugLineNum = 47;BA.debugLine="cm.SetEditTextTintColor(ac,Colors.Transparent,Col";
_cm.SetEditTextTintColor((android.widget.TextView)(_ac.getObject()),anywheresoftware.b4a.keywords.Common.Colors.Transparent,anywheresoftware.b4a.keywords.Common.Colors.Transparent);
 //BA.debugLineNum = 48;BA.debugLine="c.Force_RtlSupported4View(ac)";
mostCurrent._c._force_rtlsupported4view(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ac.getObject())));
 //BA.debugLineNum = 49;BA.debugLine="ac.TextColor=Colors.White";
_ac.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 50;BA.debugLine="ac.InputType=ac.INPUT_TYPE_PHONE";
_ac.setInputType(_ac.INPUT_TYPE_PHONE);
 //BA.debugLineNum = 51;BA.debugLine="ac.ForceDoneButton=True";
_ac.setForceDoneButton(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 53;BA.debugLine="Dim img As ImageView";
_img = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 54;BA.debugLine="C.imgCreate(img,\"\",Activity,15%x,50%y-67%x+77.5%x";
mostCurrent._c._imgcreate(mostCurrent.activityBA,_img,"",mostCurrent._activity,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (67),mostCurrent.activityBA)+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (77.5),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (6),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (6),mostCurrent.activityBA));
 //BA.debugLineNum = 55;BA.debugLine="C.btm(\"iran.png\",img)";
mostCurrent._c._btm(mostCurrent.activityBA,"iran.png",_img);
 //BA.debugLineNum = 57;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 58;BA.debugLine="C.setlblset(lbl,\"\",Activity,22%x,50%y-67%x+77.5%x";
mostCurrent._c._setlblset(mostCurrent.activityBA,_lbl,"",mostCurrent._activity,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (22),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (67),mostCurrent.activityBA)+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (77.5),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (6),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (6),mostCurrent.activityBA),BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe313))),anywheresoftware.b4a.keywords.Common.Gravity.CENTER,(anywheresoftware.b4a.keywords.constants.TypefaceWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.constants.TypefaceWrapper(), (android.graphics.Typeface)(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS())),(int) (20),(int) (0xffffffff));
 //BA.debugLineNum = 61;BA.debugLine="c.setlblset(lblbtn,\"lbl\",Activity,12%x,50%y-67%x+";
mostCurrent._c._setlblset(mostCurrent.activityBA,mostCurrent._lblbtn,"lbl",mostCurrent._activity,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (12),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (67),mostCurrent.activityBA)+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (94),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (13),mostCurrent.activityBA),"ادامه",anywheresoftware.b4a.keywords.Common.Gravity.CENTER,mostCurrent._c._irs,(int) (15),(int) (0xffffffff));
 //BA.debugLineNum = 62;BA.debugLine="lblbtn.Background=c.Gradient(0xff54A3EC,0xff54A3E";
mostCurrent._lblbtn.setBackground((android.graphics.drawable.Drawable)(mostCurrent._c._gradient(mostCurrent.activityBA,(int) (0xff54a3ec),(int) (0xff54a3ec),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.False).getObject()));
 //BA.debugLineNum = 63;BA.debugLine="lblbtn.Visible=False";
mostCurrent._lblbtn.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 80;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 76;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
public static String  _ed_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 69;BA.debugLine="Sub ed_TextChanged (Old As String, New As String)";
 //BA.debugLineNum = 70;BA.debugLine="If New.Length=10 Then";
if (_new.length()==10) { 
 //BA.debugLineNum = 71;BA.debugLine="c.SomUpDownFade(lblbtn,500, True)";
mostCurrent._c._somupdownfade(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lblbtn.getObject())),(int) (500),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 73;BA.debugLine="c.SomUpDownFade(lblbtn,500, False)";
mostCurrent._c._somupdownfade(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lblbtn.getObject())),(int) (500),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim lblbtn As Label";
mostCurrent._lblbtn = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_click() throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Sub lbl_Click";
 //BA.debugLineNum = 67;BA.debugLine="StartActivity(verify)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._verify.getObject()));
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
