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

public class act_tip extends Activity implements B4AActivity{
	public static act_tip mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.act_tip");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (act_tip).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.act_tip");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.act_tip", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (act_tip) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (act_tip) Resume **");
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
		return act_tip.class;
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
        BA.LogInfo("** Activity (act_tip) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            act_tip mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (act_tip) Resume **");
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
public de.amberhome.viewpager.AHViewPager _vp = null;
public de.amberhome.viewpager.AHPageContainer _pc = null;
public anywheresoftware.b4a.objects.PanelWrapper[] _panel = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlnonet = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblnext = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblprew = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblbol = null;
public b4a.example.main _main = null;
public b4a.example.login _login = null;
public b4a.example.verify _verify = null;
public b4a.example.home _home = null;
public b4a.example.c _c = null;
public b4a.example.starter _starter = null;
public b4a.example.page _page = null;
public b4a.example.finger _finger = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="act_tip";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
anywheresoftware.b4a.objects.CSBuilder _cs = null;
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="Activity.Background= C.Gradient(0xff54A3EC,0xff54";
mostCurrent._activity.setBackground((android.graphics.drawable.Drawable)(mostCurrent._c._gradient /*anywheresoftware.b4a.objects.drawable.GradientDrawable*/ (mostCurrent.activityBA,(int) (0xff54a3ec),(int) (0xff5433b0),(int) (0),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="C.PnlCreate(pnl,\"\",Activity,-100%x,100%y-75%x,300";
mostCurrent._c._pnlcreate /*String*/ (mostCurrent.activityBA,_pnl,"",mostCurrent._activity,(int) (-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (300),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (300),mostCurrent.activityBA));
RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="cd.Initialize(Colors.White, 5000dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5000)));
RDebugUtils.currentLine=458761;
 //BA.debugLineNum = 458761;BA.debugLine="pnl.Background = cd";
_pnl.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=458763;
 //BA.debugLineNum = 458763;BA.debugLine="PC.Initialize";
mostCurrent._pc.Initialize(mostCurrent.activityBA);
RDebugUtils.currentLine=458764;
 //BA.debugLineNum = 458764;BA.debugLine="For i = 0 To 3";
{
final int step8 = 1;
final int limit8 = (int) (3);
_i = (int) (0) ;
for (;_i <= limit8 ;_i = _i + step8 ) {
RDebugUtils.currentLine=458765;
 //BA.debugLineNum = 458765;BA.debugLine="Panel(i).Initialize(\"Panel\")";
mostCurrent._panel[_i].Initialize(mostCurrent.activityBA,"Panel");
RDebugUtils.currentLine=458766;
 //BA.debugLineNum = 458766;BA.debugLine="PC.AddPage(Panel(i),\"\")";
mostCurrent._pc.AddPage((android.view.View)(mostCurrent._panel[_i].getObject()),"");
RDebugUtils.currentLine=458767;
 //BA.debugLineNum = 458767;BA.debugLine="Panel(i).Color=Colors.Transparent";
mostCurrent._panel[_i].setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=458768;
 //BA.debugLineNum = 458768;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=458769;
 //BA.debugLineNum = 458769;BA.debugLine="C.PnlCreate(pnl,\"\",Panel(i),10%x,15%x,80%x,100%y";
mostCurrent._c._pnlcreate /*String*/ (mostCurrent.activityBA,_pnl,"",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(mostCurrent._panel[_i].getObject())),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA)));
RDebugUtils.currentLine=458770;
 //BA.debugLineNum = 458770;BA.debugLine="pnl.Background=C.Gradient(0xFFFFFFFF,0xFFFFFFFF,";
_pnl.setBackground((android.graphics.drawable.Drawable)(mostCurrent._c._gradient /*anywheresoftware.b4a.objects.drawable.GradientDrawable*/ (mostCurrent.activityBA,(int) (0xffffffff),(int) (0xffffffff),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=458771;
 //BA.debugLineNum = 458771;BA.debugLine="pnl.Elevation=10dip";
_pnl.setElevation((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=458772;
 //BA.debugLineNum = 458772;BA.debugLine="pnl.Color=Colors.White";
_pnl.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=458774;
 //BA.debugLineNum = 458774;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=458775;
 //BA.debugLineNum = 458775;BA.debugLine="C.setlblset(lbl,\"\",Panel(i),0,100%y-50%x,-1,10%x";
mostCurrent._c._setlblset /*String*/ (mostCurrent.activityBA,_lbl,"",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(mostCurrent._panel[_i].getObject())),(int) (0),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA)),(int) (-1),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),"تیتر راهنمای اپلیکیش",anywheresoftware.b4a.keywords.Common.Gravity.CENTER,mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ ,(int) (20),anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=458777;
 //BA.debugLineNum = 458777;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=458778;
 //BA.debugLineNum = 458778;BA.debugLine="C.setlblset(lbl,\"\",Panel(i),0,100%y-40%x,-1,20%x";
mostCurrent._c._setlblset /*String*/ (mostCurrent.activityBA,_lbl,"",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(mostCurrent._panel[_i].getObject())),(int) (0),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (40),mostCurrent.activityBA)),(int) (-1),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA),"متن راهنمای اپلیکیشن جیبرس ، در هزینه های خود صرفه جویی کنید.",mostCurrent._c._tcenter /*int*/ ,mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ ,(int) (15),(int) (0xff727272));
RDebugUtils.currentLine=458779;
 //BA.debugLineNum = 458779;BA.debugLine="lbl.Padding = Array As Int (30dip, 0, 30dip, 0)";
_lbl.setPadding(new int[]{anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),(int) (0)});
 }
};
RDebugUtils.currentLine=458782;
 //BA.debugLineNum = 458782;BA.debugLine="VP.Initialize2(PC,\"VP\")";
mostCurrent._vp.Initialize2(mostCurrent.activityBA,mostCurrent._pc,"VP");
RDebugUtils.currentLine=458783;
 //BA.debugLineNum = 458783;BA.debugLine="Activity.AddView(VP,0,0,-1,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._vp.getObject()),(int) (0),(int) (0),(int) (-1),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=458784;
 //BA.debugLineNum = 458784;BA.debugLine="VP.Color=Colors.Transparent";
mostCurrent._vp.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=458785;
 //BA.debugLineNum = 458785;BA.debugLine="VP.PageMargin=-50dip";
mostCurrent._vp.setPageMargin((int) (-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))));
RDebugUtils.currentLine=458786;
 //BA.debugLineNum = 458786;BA.debugLine="VP.OffscreenPageLimit=4";
mostCurrent._vp.setOffscreenPageLimit((int) (4));
RDebugUtils.currentLine=458789;
 //BA.debugLineNum = 458789;BA.debugLine="C.setlblset(lblprew,\"prew\",Activity,0,100%y-15%x,";
mostCurrent._c._setlblset /*String*/ (mostCurrent.activityBA,mostCurrent._lblprew,"prew",mostCurrent._activity,(int) (0),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (35),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),"قبلی",anywheresoftware.b4a.keywords.Common.Gravity.CENTER,mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ ,(int) (15),(int) (0xff727272));
RDebugUtils.currentLine=458790;
 //BA.debugLineNum = 458790;BA.debugLine="lblprew.Visible=False";
mostCurrent._lblprew.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458792;
 //BA.debugLineNum = 458792;BA.debugLine="C.setlblset(lblnext,\"next\",Activity,100%x-35%x,10";
mostCurrent._c._setlblset /*String*/ (mostCurrent.activityBA,mostCurrent._lblnext,"next",mostCurrent._activity,(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (35),mostCurrent.activityBA)),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (35),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),"بعدی",anywheresoftware.b4a.keywords.Common.Gravity.CENTER,mostCurrent._c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ ,(int) (15),(int) (0xff727272));
RDebugUtils.currentLine=458794;
 //BA.debugLineNum = 458794;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
RDebugUtils.currentLine=458795;
 //BA.debugLineNum = 458795;BA.debugLine="cs.Initialize.Color(0xFF727272).Append(Chr(0xF111";
_cs.Initialize().Color((int) (0xff727272)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf111)))).Pop().Append(BA.ObjectToCharSequence("   ")).Color((int) (0xffcecece)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf111)))).Pop().Append(BA.ObjectToCharSequence("   ")).Color((int) (0xffcecece)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf111)))).Append(BA.ObjectToCharSequence("   ")).Color((int) (0xffcecece)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf111)))).PopAll();
RDebugUtils.currentLine=458798;
 //BA.debugLineNum = 458798;BA.debugLine="C.setlblset(lblbol,\"\",Activity,0,100%y-19.5%x,100";
mostCurrent._c._setlblset /*String*/ (mostCurrent.activityBA,mostCurrent._lblbol,"",mostCurrent._activity,(int) (0),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (19.5),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA),"",anywheresoftware.b4a.keywords.Common.Gravity.CENTER,(anywheresoftware.b4a.keywords.constants.TypefaceWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.constants.TypefaceWrapper(), (android.graphics.Typeface)(anywheresoftware.b4a.keywords.Common.Typeface.getFONTAWESOME())),(int) (12),(int) (-1));
RDebugUtils.currentLine=458799;
 //BA.debugLineNum = 458799;BA.debugLine="lblbol.Text=cs";
mostCurrent._lblbol.setText(BA.ObjectToCharSequence(_cs.getObject()));
RDebugUtils.currentLine=458802;
 //BA.debugLineNum = 458802;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="act_tip";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="If C.IsNoNetShow And c.IsNoNetPrimery=False Then";
if (mostCurrent._c._isnonetshow /*boolean*/  && mostCurrent._c._isnonetprimery /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="C.NoNetClose(pnlnonet)";
mostCurrent._c._nonetclose /*String*/ (mostCurrent.activityBA,mostCurrent._pnlnonet);
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else 
{RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="Else if C.IsNoNetShow And c.IsNoNetPrimery=True T";
if (mostCurrent._c._isnonetshow /*boolean*/  && mostCurrent._c._isnonetprimery /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }}
;
RDebugUtils.currentLine=851978;
 //BA.debugLineNum = 851978;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="act_tip";
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="act_tip";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="VP.GotoPage(0,False)";
mostCurrent._vp.GotoPage((int) (0),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="End Sub";
return "";
}
public static String  _next_click() throws Exception{
RDebugUtils.currentModule="act_tip";
if (Debug.shouldDelegate(mostCurrent.activityBA, "next_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "next_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _l = null;
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub next_Click";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Dim l As Label = Sender";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
_l.setObject((android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="Select l.Text";
switch (BA.switchObjectToInt(_l.getText(),"بعدی")) {
case 0: {
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="VP.GotoPage(VP.CurrentPage+1,True)";
mostCurrent._vp.GotoPage((int) (mostCurrent._vp.getCurrentPage()+1),anywheresoftware.b4a.keywords.Common.True);
 break; }
default: {
RDebugUtils.currentLine=589830;
 //BA.debugLineNum = 589830;BA.debugLine="StartActivity(login)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._login.getObject()));
 break; }
}
;
RDebugUtils.currentLine=589834;
 //BA.debugLineNum = 589834;BA.debugLine="End Sub";
return "";
}
public static String  _prew_click() throws Exception{
RDebugUtils.currentModule="act_tip";
if (Debug.shouldDelegate(mostCurrent.activityBA, "prew_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "prew_click", null));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub prew_Click";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="VP.GotoPage(VP.CurrentPage-1,True)";
mostCurrent._vp.GotoPage((int) (mostCurrent._vp.getCurrentPage()-1),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="End Sub";
return "";
}
public static void  _vp_pagechanged(int _position) throws Exception{
RDebugUtils.currentModule="act_tip";
if (Debug.shouldDelegate(mostCurrent.activityBA, "vp_pagechanged", false))
	 {Debug.delegate(mostCurrent.activityBA, "vp_pagechanged", new Object[] {_position}); return;}
ResumableSub_vp_PageChanged rsub = new ResumableSub_vp_PageChanged(null,_position);
rsub.resume(processBA, null);
}
public static class ResumableSub_vp_PageChanged extends BA.ResumableSub {
public ResumableSub_vp_PageChanged(b4a.example.act_tip parent,int _position) {
this.parent = parent;
this._position = _position;
}
b4a.example.act_tip parent;
int _position;
anywheresoftware.b4a.objects.CSBuilder _cs = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="act_tip";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="Select Position";
if (true) break;

case 1:
//select
this.state = 14;
switch (_position) {
case 0: {
this.state = 3;
if (true) break;
}
case 1: {
this.state = 5;
if (true) break;
}
case 2: {
this.state = 7;
if (true) break;
}
case 3: {
this.state = 13;
if (true) break;
}
}
if (true) break;

case 3:
//C
this.state = 14;
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="cs.Initialize.Color(0xFF727272).Append(Chr(0xF1";
_cs.Initialize().Color((int) (0xff727272)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf111)))).Pop().Append(BA.ObjectToCharSequence("   ")).Color((int) (0xffcecece)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf111)))).Pop().Append(BA.ObjectToCharSequence("   ")).Color((int) (0xffcecece)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf111)))).Append(BA.ObjectToCharSequence("   ")).Color((int) (0xffcecece)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf111)))).PopAll();
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="lblbol.Text=cs";
parent.mostCurrent._lblbol.setText(BA.ObjectToCharSequence(_cs.getObject()));
RDebugUtils.currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="lblprew.SetVisibleAnimated(500,False)";
parent.mostCurrent._lblprew.SetVisibleAnimated((int) (500),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=524295;
 //BA.debugLineNum = 524295;BA.debugLine="lblnext.Text=\"بعدی\"";
parent.mostCurrent._lblnext.setText(BA.ObjectToCharSequence("بعدی"));
 if (true) break;

case 5:
//C
this.state = 14;
RDebugUtils.currentLine=524297;
 //BA.debugLineNum = 524297;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
RDebugUtils.currentLine=524298;
 //BA.debugLineNum = 524298;BA.debugLine="cs.Initialize.Color(0xFFCECECE).Append(Chr(0xF1";
_cs.Initialize().Color((int) (0xffcecece)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf111)))).Pop().Append(BA.ObjectToCharSequence("   ")).Color((int) (0xff727272)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf111)))).Pop().Append(BA.ObjectToCharSequence("   ")).Color((int) (0xffcecece)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf111)))).Append(BA.ObjectToCharSequence("   ")).Color((int) (0xffcecece)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf111)))).PopAll();
RDebugUtils.currentLine=524299;
 //BA.debugLineNum = 524299;BA.debugLine="lblbol.Text=cs";
parent.mostCurrent._lblbol.setText(BA.ObjectToCharSequence(_cs.getObject()));
RDebugUtils.currentLine=524300;
 //BA.debugLineNum = 524300;BA.debugLine="lblprew.SetVisibleAnimated(500,True)";
parent.mostCurrent._lblprew.SetVisibleAnimated((int) (500),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=524301;
 //BA.debugLineNum = 524301;BA.debugLine="lblnext.Text=\"بعدی\"";
parent.mostCurrent._lblnext.setText(BA.ObjectToCharSequence("بعدی"));
 if (true) break;

case 7:
//C
this.state = 8;
RDebugUtils.currentLine=524303;
 //BA.debugLineNum = 524303;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
RDebugUtils.currentLine=524304;
 //BA.debugLineNum = 524304;BA.debugLine="cs.Initialize.Color(0xFFCECECE).Append(Chr(0xF1";
_cs.Initialize().Color((int) (0xffcecece)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf111)))).Pop().Append(BA.ObjectToCharSequence("   ")).Color((int) (0xffcecece)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf111)))).Pop().Append(BA.ObjectToCharSequence("   ")).Color((int) (0xff727272)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf111)))).Append(BA.ObjectToCharSequence("   ")).Color((int) (0xffcecece)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf111)))).PopAll();
RDebugUtils.currentLine=524305;
 //BA.debugLineNum = 524305;BA.debugLine="lblbol.Text=cs";
parent.mostCurrent._lblbol.setText(BA.ObjectToCharSequence(_cs.getObject()));
RDebugUtils.currentLine=524307;
 //BA.debugLineNum = 524307;BA.debugLine="If lblnext.Text<>\"بعدی\" Then";
if (true) break;

case 8:
//if
this.state = 11;
if ((parent.mostCurrent._lblnext.getText()).equals("بعدی") == false) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
RDebugUtils.currentLine=524308;
 //BA.debugLineNum = 524308;BA.debugLine="lblnext.SetVisibleAnimated(200,False)";
parent.mostCurrent._lblnext.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=524309;
 //BA.debugLineNum = 524309;BA.debugLine="Sleep(200)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "act_tip", "vp_pagechanged"),(int) (200));
this.state = 15;
return;
case 15:
//C
this.state = 11;
;
RDebugUtils.currentLine=524310;
 //BA.debugLineNum = 524310;BA.debugLine="lblnext.Text=\"بعدی\"";
parent.mostCurrent._lblnext.setText(BA.ObjectToCharSequence("بعدی"));
RDebugUtils.currentLine=524311;
 //BA.debugLineNum = 524311;BA.debugLine="lblnext.SetVisibleAnimated(200,True)";
parent.mostCurrent._lblnext.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 11:
//C
this.state = 14;
;
RDebugUtils.currentLine=524313;
 //BA.debugLineNum = 524313;BA.debugLine="lblprew.SetVisibleAnimated(200,True)";
parent.mostCurrent._lblprew.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 13:
//C
this.state = 14;
RDebugUtils.currentLine=524315;
 //BA.debugLineNum = 524315;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
RDebugUtils.currentLine=524316;
 //BA.debugLineNum = 524316;BA.debugLine="cs.Initialize.Color(0xFFCECECE).Append(Chr(0xF1";
_cs.Initialize().Color((int) (0xffcecece)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf111)))).Pop().Append(BA.ObjectToCharSequence("   ")).Color((int) (0xffcecece)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf111)))).Pop().Append(BA.ObjectToCharSequence("   ")).Color((int) (0xffcecece)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf111)))).Append(BA.ObjectToCharSequence("   ")).Color((int) (0xff727272)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf111)))).PopAll();
RDebugUtils.currentLine=524317;
 //BA.debugLineNum = 524317;BA.debugLine="lblbol.Text=cs";
parent.mostCurrent._lblbol.setText(BA.ObjectToCharSequence(_cs.getObject()));
RDebugUtils.currentLine=524318;
 //BA.debugLineNum = 524318;BA.debugLine="lblprew.SetVisibleAnimated(500,True)";
parent.mostCurrent._lblprew.SetVisibleAnimated((int) (500),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=524319;
 //BA.debugLineNum = 524319;BA.debugLine="lblnext.SetVisibleAnimated(200,False)";
parent.mostCurrent._lblnext.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=524320;
 //BA.debugLineNum = 524320;BA.debugLine="Sleep(200)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "act_tip", "vp_pagechanged"),(int) (200));
this.state = 16;
return;
case 16:
//C
this.state = 14;
;
RDebugUtils.currentLine=524321;
 //BA.debugLineNum = 524321;BA.debugLine="lblnext.Text=\"ورود به برنامه\"";
parent.mostCurrent._lblnext.setText(BA.ObjectToCharSequence("ورود به برنامه"));
RDebugUtils.currentLine=524322;
 //BA.debugLineNum = 524322;BA.debugLine="lblnext.SetVisibleAnimated(200,True)";
parent.mostCurrent._lblnext.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 14:
//C
this.state = -1;
;
RDebugUtils.currentLine=524325;
 //BA.debugLineNum = 524325;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
}