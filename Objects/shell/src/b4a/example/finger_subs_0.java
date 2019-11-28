package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class finger_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (finger) ","finger",8,finger.mostCurrent.activityBA,finger.mostCurrent,20);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.finger.remoteMe.runUserSub(false, "finger","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 20;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 23;BA.debugLine="Activity.Background= C.Gradient(0xFFFFFFFF,0xFFFF";
Debug.ShouldStop(4194304);
finger.mostCurrent._activity.runMethod(false,"setBackground",(finger.mostCurrent._c.runMethod(false,"_gradient" /*RemoteObject*/ ,finger.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 0xffffffff)),(Object)(BA.numberCast(int.class, 0xffffffff)),(Object)(BA.numberCast(int.class, 0)),(Object)(finger.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 25;BA.debugLine="fingerprint.Initialize (Me, \"auth\")";
Debug.ShouldStop(16777216);
finger.mostCurrent._fingerprint.runClassMethod (b4a.example.fingerprintmanager.class, "_initialize" /*RemoteObject*/ ,finger.processBA,(Object)(finger.getObject()),(Object)(RemoteObject.createImmutable("auth")));
 BA.debugLineNum = 30;BA.debugLine="lav.Initialize(\"LAV\")";
Debug.ShouldStop(536870912);
finger.mostCurrent._lav.runVoidMethod ("Initialize",finger.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("LAV")));
 BA.debugLineNum = 31;BA.debugLine="Activity.AddView(lav,10%x,50%y-60%x,80%x,70%x)";
Debug.ShouldStop(1073741824);
finger.mostCurrent._activity.runVoidMethod ("AddView",(Object)((finger.mostCurrent._lav.getObject())),(Object)(finger.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),finger.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {finger.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),finger.mostCurrent.activityBA),finger.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),finger.mostCurrent.activityBA)}, "-",1, 1)),(Object)(finger.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 80)),finger.mostCurrent.activityBA)),(Object)(finger.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 70)),finger.mostCurrent.activityBA)));
 BA.debugLineNum = 32;BA.debugLine="lav.SetAnimation(File.DirAssets,\"gray.json\")";
Debug.ShouldStop(-2147483648);
finger.mostCurrent._lav.runVoidMethod ("SetAnimation",(Object)(finger.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("gray.json")));
 BA.debugLineNum = 33;BA.debugLine="lav.SetLoop(True) 'repeat";
Debug.ShouldStop(1);
finger.mostCurrent._lav.runVoidMethod ("SetLoop",(Object)(finger.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 34;BA.debugLine="lav.PlayAnimation";
Debug.ShouldStop(2);
finger.mostCurrent._lav.runVoidMethod ("PlayAnimation");
 BA.debugLineNum = 35;BA.debugLine="lav.Speed=.7";
Debug.ShouldStop(4);
finger.mostCurrent._lav.runVoidMethod ("setSpeed",BA.numberCast(float.class, .7));
 BA.debugLineNum = 38;BA.debugLine="fingerprint.Authenticate";
Debug.ShouldStop(32);
finger.mostCurrent._fingerprint.runClassMethod (b4a.example.fingerprintmanager.class, "_authenticate" /*RemoteObject*/ );
 BA.debugLineNum = 41;BA.debugLine="C.setlblset(lbl,\"\",Activity,0,50%y+20%x,100%x,13%";
Debug.ShouldStop(256);
finger.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,finger.mostCurrent.activityBA,(Object)(finger.mostCurrent._lbl),(Object)(BA.ObjectToString("")),(Object)(finger.mostCurrent._activity),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {finger.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),finger.mostCurrent.activityBA),finger.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 20)),finger.mostCurrent.activityBA)}, "+",1, 1)),(Object)(finger.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),finger.mostCurrent.activityBA)),(Object)(finger.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 13)),finger.mostCurrent.activityBA)),(Object)(BA.ObjectToString("لطفا اثر انگشت خود را تایید کنید")),(Object)(finger.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),(Object)(finger.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 15)),(Object)(BA.numberCast(int.class, 0xff898989)));
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (finger) ","finger",8,finger.mostCurrent.activityBA,finger.mostCurrent,77);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.finger.remoteMe.runUserSub(false, "finger","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 77;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("Activity_Resume (finger) ","finger",8,finger.mostCurrent.activityBA,finger.mostCurrent,73);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.finger.remoteMe.runUserSub(false, "finger","activity_resume");}
 BA.debugLineNum = 73;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(256);
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _auth_complete(RemoteObject _success,RemoteObject _errormessage) throws Exception{
try {
		Debug.PushSubsStack("Auth_Complete (finger) ","finger",8,finger.mostCurrent.activityBA,finger.mostCurrent,58);
if (RapidSub.canDelegate("auth_complete")) { b4a.example.finger.remoteMe.runUserSub(false, "finger","auth_complete", _success, _errormessage); return;}
ResumableSub_Auth_Complete rsub = new ResumableSub_Auth_Complete(null,_success,_errormessage);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Auth_Complete extends BA.ResumableSub {
public ResumableSub_Auth_Complete(b4a.example.finger parent,RemoteObject _success,RemoteObject _errormessage) {
this.parent = parent;
this._success = _success;
this._errormessage = _errormessage;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.finger parent;
RemoteObject _success;
RemoteObject _errormessage;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Auth_Complete (finger) ","finger",8,finger.mostCurrent.activityBA,finger.mostCurrent,58);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("Success", _success);
Debug.locals.put("ErrorMessage", _errormessage);
 BA.debugLineNum = 59;BA.debugLine="If Success Then";
Debug.ShouldStop(67108864);
if (true) break;

case 1:
//if
this.state = 6;
if (_success.<Boolean>get().booleanValue()) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 BA.debugLineNum = 60;BA.debugLine="lav.RemoveView";
Debug.ShouldStop(134217728);
parent.mostCurrent._lav.runVoidMethod ("RemoveView");
 BA.debugLineNum = 61;BA.debugLine="lav.Initialize(\"LAV\")";
Debug.ShouldStop(268435456);
parent.mostCurrent._lav.runVoidMethod ("Initialize",finger.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("LAV")));
 BA.debugLineNum = 62;BA.debugLine="Activity.AddView(lav,10%x,50%y-60%x,80%x,70%x)";
Debug.ShouldStop(536870912);
parent.mostCurrent._activity.runVoidMethod ("AddView",(Object)((parent.mostCurrent._lav.getObject())),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),finger.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),finger.mostCurrent.activityBA),parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),finger.mostCurrent.activityBA)}, "-",1, 1)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 80)),finger.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 70)),finger.mostCurrent.activityBA)));
 BA.debugLineNum = 63;BA.debugLine="lav.SetAnimation(File.DirAssets,\"green.json\")";
Debug.ShouldStop(1073741824);
parent.mostCurrent._lav.runVoidMethod ("SetAnimation",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("green.json")));
 BA.debugLineNum = 64;BA.debugLine="lav.PlayAnimation";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._lav.runVoidMethod ("PlayAnimation");
 BA.debugLineNum = 65;BA.debugLine="lav.Speed=.7";
Debug.ShouldStop(1);
parent.mostCurrent._lav.runVoidMethod ("setSpeed",BA.numberCast(float.class, .7));
 BA.debugLineNum = 66;BA.debugLine="lbl.Text=\"اثر انگشت تایید شد\"";
Debug.ShouldStop(2);
parent.mostCurrent._lbl.runMethod(true,"setText",BA.ObjectToCharSequence("اثر انگشت تایید شد"));
 BA.debugLineNum = 67;BA.debugLine="Sleep(2000 )";
Debug.ShouldStop(4);
parent.mostCurrent.__c.runVoidMethod ("Sleep",finger.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "finger", "auth_complete"),BA.numberCast(int.class, 2000));
this.state = 7;
return;
case 7:
//C
this.state = 6;
;
 BA.debugLineNum = 68;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8);
parent.mostCurrent._activity.runVoidMethod ("Finish");
 if (true) break;

case 5:
//C
this.state = 6;
 if (true) break;

case 6:
//C
this.state = -1;
;
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
public static void  _auth_fail() throws Exception{
try {
		Debug.PushSubsStack("Auth_fail (finger) ","finger",8,finger.mostCurrent.activityBA,finger.mostCurrent,44);
if (RapidSub.canDelegate("auth_fail")) { b4a.example.finger.remoteMe.runUserSub(false, "finger","auth_fail"); return;}
ResumableSub_Auth_fail rsub = new ResumableSub_Auth_fail(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Auth_fail extends BA.ResumableSub {
public ResumableSub_Auth_fail(b4a.example.finger parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.finger parent;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Auth_fail (finger) ","finger",8,finger.mostCurrent.activityBA,finger.mostCurrent,44);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 BA.debugLineNum = 45;BA.debugLine="lav.RemoveView";
Debug.ShouldStop(4096);
parent.mostCurrent._lav.runVoidMethod ("RemoveView");
 BA.debugLineNum = 46;BA.debugLine="lav.Initialize(\"LAV\")";
Debug.ShouldStop(8192);
parent.mostCurrent._lav.runVoidMethod ("Initialize",finger.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("LAV")));
 BA.debugLineNum = 47;BA.debugLine="Activity.AddView(lav,10%x,50%y-60%x,80%x,70%x)";
Debug.ShouldStop(16384);
parent.mostCurrent._activity.runVoidMethod ("AddView",(Object)((parent.mostCurrent._lav.getObject())),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),finger.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),finger.mostCurrent.activityBA),parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),finger.mostCurrent.activityBA)}, "-",1, 1)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 80)),finger.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 70)),finger.mostCurrent.activityBA)));
 BA.debugLineNum = 48;BA.debugLine="lav.SetAnimation(File.DirAssets,\"red.json\")";
Debug.ShouldStop(32768);
parent.mostCurrent._lav.runVoidMethod ("SetAnimation",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("red.json")));
 BA.debugLineNum = 49;BA.debugLine="lav.PlayAnimation";
Debug.ShouldStop(65536);
parent.mostCurrent._lav.runVoidMethod ("PlayAnimation");
 BA.debugLineNum = 50;BA.debugLine="lav.Speed=.7";
Debug.ShouldStop(131072);
parent.mostCurrent._lav.runVoidMethod ("setSpeed",BA.numberCast(float.class, .7));
 BA.debugLineNum = 51;BA.debugLine="lbl.Text=\"اثر انگشت مطابق نیست\"";
Debug.ShouldStop(262144);
parent.mostCurrent._lbl.runMethod(true,"setText",BA.ObjectToCharSequence("اثر انگشت مطابق نیست"));
 BA.debugLineNum = 53;BA.debugLine="Sleep(2000 )";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("Sleep",finger.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "finger", "auth_fail"),BA.numberCast(int.class, 2000));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 BA.debugLineNum = 54;BA.debugLine="Activity.Finish";
Debug.ShouldStop(2097152);
parent.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private fingerprint As FingerprintManager";
finger.mostCurrent._fingerprint = RemoteObject.createNew ("b4a.example.fingerprintmanager");
 //BA.debugLineNum = 16;BA.debugLine="Dim lav As Hitex_LottieAnimationView";
finger.mostCurrent._lav = RemoteObject.createNew ("ir.hitexroid.lottie.Hitex_LottieAnimationView");
 //BA.debugLineNum = 17;BA.debugLine="Dim lbl As Label";
finger.mostCurrent._lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}