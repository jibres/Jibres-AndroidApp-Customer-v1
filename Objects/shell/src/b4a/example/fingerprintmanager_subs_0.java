package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class fingerprintmanager_subs_0 {


public static RemoteObject  _auth_complete(RemoteObject __ref,RemoteObject _success,RemoteObject _errorcode,RemoteObject _errormessage) throws Exception{
try {
		Debug.PushSubsStack("Auth_Complete (fingerprintmanager) ","fingerprintmanager",9,__ref.getField(false, "ba"),__ref,74);
if (RapidSub.canDelegate("auth_complete")) { return __ref.runUserSub(false, "fingerprintmanager","auth_complete", __ref, _success, _errorcode, _errormessage);}
Debug.locals.put("Success", _success);
Debug.locals.put("ErrorCode", _errorcode);
Debug.locals.put("ErrorMessage", _errormessage);
 BA.debugLineNum = 74;BA.debugLine="Private Sub Auth_Complete (Success As Boolean, Err";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="If ErrorCode = 5 Then Return 'cancel";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",_errorcode,BA.numberCast(double.class, 5))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 76;BA.debugLine="CallSub3(mTarget, mEventName & \"_complete\", Succe";
Debug.ShouldStop(2048);
fingerprintmanager.__c.runMethodAndSync(false,"CallSubNew3",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_mtarget" /*RemoteObject*/ )),(Object)(RemoteObject.concat(__ref.getField(true,"_meventname" /*RemoteObject*/ ),RemoteObject.createImmutable("_complete"))),(Object)((_success)),(Object)((_errormessage)));
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
public static RemoteObject  _auth_fail(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Auth_fail (fingerprintmanager) ","fingerprintmanager",9,__ref.getField(false, "ba"),__ref,71);
if (RapidSub.canDelegate("auth_fail")) { return __ref.runUserSub(false, "fingerprintmanager","auth_fail", __ref);}
 BA.debugLineNum = 71;BA.debugLine="Private Sub Auth_fail";
Debug.ShouldStop(64);
 BA.debugLineNum = 72;BA.debugLine="CallSub(mTarget, mEventName & \"_fail\")";
Debug.ShouldStop(128);
fingerprintmanager.__c.runMethodAndSync(false,"CallSubNew",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_mtarget" /*RemoteObject*/ )),(Object)(RemoteObject.concat(__ref.getField(true,"_meventname" /*RemoteObject*/ ),RemoteObject.createImmutable("_fail"))));
 BA.debugLineNum = 73;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _authenticate(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Authenticate (fingerprintmanager) ","fingerprintmanager",9,__ref.getField(false, "ba"),__ref,24);
if (RapidSub.canDelegate("authenticate")) { return __ref.runUserSub(false, "fingerprintmanager","authenticate", __ref);}
RemoteObject _ev = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
 BA.debugLineNum = 24;BA.debugLine="Public Sub Authenticate";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 25;BA.debugLine="Cancel";
Debug.ShouldStop(16777216);
__ref.runClassMethod (b4a.example.fingerprintmanager.class, "_cancel" /*RemoteObject*/ );
 BA.debugLineNum = 26;BA.debugLine="cancelObject.InitializeNewInstance(\"android.os.Ca";
Debug.ShouldStop(33554432);
__ref.getField(false,"_cancelobject" /*RemoteObject*/ ).runVoidMethod ("InitializeNewInstance",(Object)(BA.ObjectToString("android.os.CancellationSignal")),(Object)((fingerprintmanager.__c.getField(false,"Null"))));
 BA.debugLineNum = 27;BA.debugLine="Dim Ev As JavaObject";
Debug.ShouldStop(67108864);
_ev = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("Ev", _ev);
 BA.debugLineNum = 28;BA.debugLine="Ev.InitializeNewInstance(Application.PackageName";
Debug.ShouldStop(134217728);
_ev.runVoidMethod ("InitializeNewInstance",(Object)(RemoteObject.concat(fingerprintmanager.__c.getField(false,"Application").runMethod(true,"getPackageName"),RemoteObject.createImmutable(".fingerprintmanager.FingerprintAuthentication"))),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {__ref})));
 BA.debugLineNum = 29;BA.debugLine="sensor.RunMethod(\"authenticate\", Array(Null, Null";
Debug.ShouldStop(268435456);
__ref.getField(false,"_sensor" /*RemoteObject*/ ).runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("authenticate")),(Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {fingerprintmanager.__c.getField(false,"Null"),fingerprintmanager.__c.getField(false,"Null"),RemoteObject.createImmutable((0)),(_ev.getObject()),fingerprintmanager.__c.getField(false,"Null")})));
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cancel(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Cancel (fingerprintmanager) ","fingerprintmanager",9,__ref.getField(false, "ba"),__ref,32);
if (RapidSub.canDelegate("cancel")) { return __ref.runUserSub(false, "fingerprintmanager","cancel", __ref);}
 BA.debugLineNum = 32;BA.debugLine="Public Sub Cancel";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 33;BA.debugLine="If cancelObject.IsInitialized And cancelObject.Ru";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean(".",__ref.getField(false,"_cancelobject" /*RemoteObject*/ ).runMethod(true,"IsInitialized")) && RemoteObject.solveBoolean("=",__ref.getField(false,"_cancelobject" /*RemoteObject*/ ).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("isCanceled")),(Object)((fingerprintmanager.__c.getField(false,"Null")))),(fingerprintmanager.__c.getField(true,"False")))) { 
 BA.debugLineNum = 34;BA.debugLine="cancelObject.RunMethod(\"cancel\", Null)";
Debug.ShouldStop(2);
__ref.getField(false,"_cancelobject" /*RemoteObject*/ ).runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("cancel")),(Object)((fingerprintmanager.__c.getField(false,"Null"))));
 };
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private sensor As JavaObject";
fingerprintmanager._sensor = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");__ref.setField("_sensor",fingerprintmanager._sensor);
 //BA.debugLineNum = 4;BA.debugLine="Private cancelObject As JavaObject";
fingerprintmanager._cancelobject = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");__ref.setField("_cancelobject",fingerprintmanager._cancelobject);
 //BA.debugLineNum = 5;BA.debugLine="Private mTarget As Object";
fingerprintmanager._mtarget = RemoteObject.createNew ("Object");__ref.setField("_mtarget",fingerprintmanager._mtarget);
 //BA.debugLineNum = 6;BA.debugLine="Private mEventName As String";
fingerprintmanager._meventname = RemoteObject.createImmutable("");__ref.setField("_meventname",fingerprintmanager._meventname);
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _gethardwaredetected(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("getHardwareDetected (fingerprintmanager) ","fingerprintmanager",9,__ref.getField(false, "ba"),__ref,16);
if (RapidSub.canDelegate("gethardwaredetected")) { return __ref.runUserSub(false, "fingerprintmanager","gethardwaredetected", __ref);}
 BA.debugLineNum = 16;BA.debugLine="Public Sub getHardwareDetected As Boolean";
Debug.ShouldStop(32768);
 BA.debugLineNum = 17;BA.debugLine="Return sensor.RunMethod(\"isHardwareDetected\", Nul";
Debug.ShouldStop(65536);
if (true) return BA.ObjectToBoolean(__ref.getField(false,"_sensor" /*RemoteObject*/ ).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("isHardwareDetected")),(Object)((fingerprintmanager.__c.getField(false,"Null")))));
 BA.debugLineNum = 18;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _gethasenrolledfingerprints(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("getHasEnrolledFingerprints (fingerprintmanager) ","fingerprintmanager",9,__ref.getField(false, "ba"),__ref,20);
if (RapidSub.canDelegate("gethasenrolledfingerprints")) { return __ref.runUserSub(false, "fingerprintmanager","gethasenrolledfingerprints", __ref);}
 BA.debugLineNum = 20;BA.debugLine="Public Sub getHasEnrolledFingerprints As Boolean";
Debug.ShouldStop(524288);
 BA.debugLineNum = 21;BA.debugLine="Return sensor.RunMethod(\"hasEnrolledFingerprints\"";
Debug.ShouldStop(1048576);
if (true) return BA.ObjectToBoolean(__ref.getField(false,"_sensor" /*RemoteObject*/ ).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("hasEnrolledFingerprints")),(Object)((fingerprintmanager.__c.getField(false,"Null")))));
 BA.debugLineNum = 22;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _target,RemoteObject _eventname) throws Exception{
try {
		Debug.PushSubsStack("Initialize (fingerprintmanager) ","fingerprintmanager",9,__ref.getField(false, "ba"),__ref,9);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "fingerprintmanager","initialize", __ref, _ba, _target, _eventname);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
RemoteObject _ctxt = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("ba", _ba);
Debug.locals.put("Target", _target);
Debug.locals.put("EventName", _eventname);
 BA.debugLineNum = 9;BA.debugLine="Public Sub Initialize (Target As Object, EventName";
Debug.ShouldStop(256);
 BA.debugLineNum = 10;BA.debugLine="mTarget = Target";
Debug.ShouldStop(512);
__ref.setField ("_mtarget" /*RemoteObject*/ ,_target);
 BA.debugLineNum = 11;BA.debugLine="mEventName = EventName";
Debug.ShouldStop(1024);
__ref.setField ("_meventname" /*RemoteObject*/ ,_eventname);
 BA.debugLineNum = 12;BA.debugLine="Dim ctxt As JavaObject";
Debug.ShouldStop(2048);
_ctxt = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("ctxt", _ctxt);
 BA.debugLineNum = 13;BA.debugLine="sensor = ctxt.InitializeContext.RunMethod(\"getSys";
Debug.ShouldStop(4096);
__ref.getField(false,"_sensor" /*RemoteObject*/ ).setObject (_ctxt.runMethod(false,"InitializeContext",__ref.getField(false, "ba")).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getSystemService")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(RemoteObject.createImmutable("fingerprint"))}))));
 BA.debugLineNum = 14;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}