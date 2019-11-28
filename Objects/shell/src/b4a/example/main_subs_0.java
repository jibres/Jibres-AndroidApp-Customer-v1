package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static void  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,31);
if (RapidSub.canDelegate("activity_create")) { b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime); return;}
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(b4a.example.main parent,RemoteObject _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _firsttime;
RemoteObject _img = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _lav = RemoteObject.declareNull("ir.hitexroid.lottie.Hitex_LottieAnimationView");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,31);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 34;BA.debugLine="Activity.Background= C.Gradient(0xff54A3EC,0xff54";
Debug.ShouldStop(2);
parent.mostCurrent._activity.runMethod(false,"setBackground",(parent.mostCurrent._c.runMethod(false,"_gradient" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 0xff54a3ec)),(Object)(BA.numberCast(int.class, 0xff5433b0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 36;BA.debugLine="If C.getDeviceLanguage=\"fa\" Then";
Debug.ShouldStop(8);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._c.runMethod(true,"_getdevicelanguage" /*RemoteObject*/ ,main.mostCurrent.activityBA),BA.ObjectToString("fa"))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 39;BA.debugLine="Dim img As ImageView";
Debug.ShouldStop(64);
_img = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("img", _img);
 BA.debugLineNum = 40;BA.debugLine="img.Initialize(\"\")";
Debug.ShouldStop(128);
_img.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 41;BA.debugLine="Activity.AddView(img,40%x,50%y-30%x,20%x,20%x)";
Debug.ShouldStop(256);
parent.mostCurrent._activity.runVoidMethod ("AddView",(Object)((_img.getObject())),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 40)),main.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),main.mostCurrent.activityBA),parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 30)),main.mostCurrent.activityBA)}, "-",1, 1)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 20)),main.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 20)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 42;BA.debugLine="img.Gravity=Gravity.FILL";
Debug.ShouldStop(512);
_img.runMethod(true,"setGravity",parent.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 43;BA.debugLine="img.Bitmap=Application.Icon";
Debug.ShouldStop(1024);
_img.runMethod(false,"setBitmap",(parent.mostCurrent.__c.getField(false,"Application").runMethod(false,"getIcon").getObject()));
 BA.debugLineNum = 44;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(2048);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 45;BA.debugLine="C.setlblset(lbl,\"\",Activity,0,50%y-5%x,-1,10%x,\"ا";
Debug.ShouldStop(4096);
parent.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_lbl),(Object)(BA.ObjectToString("")),(Object)(parent.mostCurrent._activity),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),main.mostCurrent.activityBA),parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),main.mostCurrent.activityBA)}, "-",1, 1)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)),(Object)(BA.ObjectToString("اپلیکیشن جامع جیبرس")),(Object)(parent.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),(Object)(parent.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 20)),(Object)(parent.mostCurrent.__c.getField(false,"Colors").getField(true,"White")));
 BA.debugLineNum = 47;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(16384);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 48;BA.debugLine="C.setlblset(lbl,\"\",Activity,0,50%y+5%x,-1,10%x,\"م";
Debug.ShouldStop(32768);
parent.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_lbl),(Object)(BA.ObjectToString("")),(Object)(parent.mostCurrent._activity),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),main.mostCurrent.activityBA),parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),main.mostCurrent.activityBA)}, "+",1, 1)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)),(Object)(BA.ObjectToString("مراقب همراه جیب شما")),(Object)(parent.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),(Object)(parent.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 15)),(Object)(BA.numberCast(int.class, 0xacffffff)));
 BA.debugLineNum = 50;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(131072);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 51;BA.debugLine="c.PnlCreate(pnl,\"\",Activity,0,0,-1,-1)";
Debug.ShouldStop(262144);
parent.mostCurrent._c.runVoidMethod ("_pnlcreate" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_pnl),(Object)(BA.ObjectToString("")),(Object)(parent.mostCurrent._activity),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.numberCast(int.class, -(double) (0 + 1))));
 BA.debugLineNum = 52;BA.debugLine="Dim lav As Hitex_LottieAnimationView";
Debug.ShouldStop(524288);
_lav = RemoteObject.createNew ("ir.hitexroid.lottie.Hitex_LottieAnimationView");Debug.locals.put("lav", _lav);
 BA.debugLineNum = 53;BA.debugLine="lav.Initialize(\"LAV\")";
Debug.ShouldStop(1048576);
_lav.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("LAV")));
 BA.debugLineNum = 54;BA.debugLine="pnl.AddView(lav,0,70%y,-1,30%x)";
Debug.ShouldStop(2097152);
_pnl.runVoidMethod ("AddView",(Object)((_lav.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 70)),main.mostCurrent.activityBA)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 30)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 55;BA.debugLine="lav.SetAnimation(File.DirAssets,\"netcheck.json\")";
Debug.ShouldStop(4194304);
_lav.runVoidMethod ("SetAnimation",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("netcheck.json")));
 BA.debugLineNum = 56;BA.debugLine="lav.SetLoop(True) 'repeat";
Debug.ShouldStop(8388608);
_lav.runVoidMethod ("SetLoop",(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 57;BA.debugLine="lav.PlayAnimation";
Debug.ShouldStop(16777216);
_lav.runVoidMethod ("PlayAnimation");
 BA.debugLineNum = 58;BA.debugLine="lav.Speed=.7";
Debug.ShouldStop(33554432);
_lav.runVoidMethod ("setSpeed",BA.numberCast(float.class, .7));
 BA.debugLineNum = 60;BA.debugLine="Sleep(1000)";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "activity_create"),BA.numberCast(int.class, 1000));
this.state = 5;
return;
case 5:
//C
this.state = -1;
;
 BA.debugLineNum = 64;BA.debugLine="pnl.SetVisibleAnimated(500,False)";
Debug.ShouldStop(-2147483648);
_pnl.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 500)),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 65;BA.debugLine="Sleep(500)";
Debug.ShouldStop(1);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "activity_create"),BA.numberCast(int.class, 500));
this.state = 6;
return;
case 6:
//C
this.state = -1;
;
 BA.debugLineNum = 70;BA.debugLine="StartActivity(act_tip)";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((parent.mostCurrent._act_tip.getObject())));
 BA.debugLineNum = 71;BA.debugLine="End Sub";
Debug.ShouldStop(64);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,84);
if (RapidSub.canDelegate("activity_keypress")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 84;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="If C.IsNoNetShow And c.IsNoNetPrimery=False Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean(".",main.mostCurrent._c._isnonetshow /*RemoteObject*/ ) && RemoteObject.solveBoolean("=",main.mostCurrent._c._isnonetprimery /*RemoteObject*/ ,main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 86;BA.debugLine="C.NoNetClose(pnlnonet)";
Debug.ShouldStop(2097152);
main.mostCurrent._c.runVoidMethod ("_nonetclose" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pnlnonet));
 BA.debugLineNum = 87;BA.debugLine="Return True";
Debug.ShouldStop(4194304);
if (true) return main.mostCurrent.__c.getField(true,"True");
 }else 
{ BA.debugLineNum = 88;BA.debugLine="Else if C.IsNoNetShow And c.IsNoNetPrimery=True T";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean(".",main.mostCurrent._c._isnonetshow /*RemoteObject*/ ) && RemoteObject.solveBoolean("=",main.mostCurrent._c._isnonetprimery /*RemoteObject*/ ,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 89;BA.debugLine="Return True";
Debug.ShouldStop(16777216);
if (true) return main.mostCurrent.__c.getField(true,"True");
 }}
;
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,79);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 79;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,75);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 75;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1024);
 BA.debugLineNum = 76;BA.debugLine="StartActivity(Home)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._home.getObject())));
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 25;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 28;BA.debugLine="Dim pnlnonet As Panel";
main.mostCurrent._pnlnonet = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
act_tip_subs_0._process_globals();
login_subs_0._process_globals();
verify_subs_0._process_globals();
home_subs_0._process_globals();
c_subs_0._process_globals();
starter_subs_0._process_globals();
page_subs_0._process_globals();
finger_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
act_tip.myClass = BA.getDeviceClass ("b4a.example.act_tip");
login.myClass = BA.getDeviceClass ("b4a.example.login");
verify.myClass = BA.getDeviceClass ("b4a.example.verify");
home.myClass = BA.getDeviceClass ("b4a.example.home");
c.myClass = BA.getDeviceClass ("b4a.example.c");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
page.myClass = BA.getDeviceClass ("b4a.example.page");
finger.myClass = BA.getDeviceClass ("b4a.example.finger");
fingerprintmanager.myClass = BA.getDeviceClass ("b4a.example.fingerprintmanager");
creatlv.myClass = BA.getDeviceClass ("b4a.example.creatlv");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="Dim txtnewstitle As String =\"تایتل تستی برای مطال";
main._txtnewstitle = BA.ObjectToString("تایتل تستی برای مطالب");
 //BA.debugLineNum = 20;BA.debugLine="Dim picnew As String=\"http://havadari.iquizland.i";
main._picnew = BA.ObjectToString("http://havadari.iquizland.ir/wp-content/uploads/2019/07/01419125.jpg");
 //BA.debugLineNum = 21;BA.debugLine="Dim newsid As String=\"6591\"";
main._newsid = BA.ObjectToString("6591");
 //BA.debugLineNum = 22;BA.debugLine="Dim newsdate As String=\"19:03:33 22-04-1398\"";
main._newsdate = BA.ObjectToString("19:03:33 22-04-1398");
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _retry_click() throws Exception{
try {
		Debug.PushSubsStack("retry_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,72);
if (RapidSub.canDelegate("retry_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","retry_click");}
 BA.debugLineNum = 72;BA.debugLine="Sub retry_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="Log(\"dd\")";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("LogImpl","37733249",RemoteObject.createImmutable("dd"),0);
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}