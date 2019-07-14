package b4a.example;

import android.hardware.fingerprint.*;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class fingerprintmanager extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.fingerprintmanager");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.fingerprintmanager.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4j.object.JavaObject _sensor = null;
public anywheresoftware.b4j.object.JavaObject _cancelobject = null;
public Object _mtarget = null;
public String _meventname = "";
public b4a.example.main _main = null;
public b4a.example.act_tip _act_tip = null;
public b4a.example.login _login = null;
public b4a.example.verify _verify = null;
public b4a.example.home _home = null;
public b4a.example.c _c = null;
public b4a.example.starter _starter = null;
public b4a.example.page _page = null;
public b4a.example.finger _finger = null;
public String  _auth_complete(boolean _success,int _errorcode,String _errormessage) throws Exception{
 //BA.debugLineNum = 74;BA.debugLine="Private Sub Auth_Complete (Success As Boolean, Err";
 //BA.debugLineNum = 75;BA.debugLine="If ErrorCode = 5 Then Return 'cancel";
if (_errorcode==5) { 
if (true) return "";};
 //BA.debugLineNum = 76;BA.debugLine="CallSub3(mTarget, mEventName & \"_complete\", Succe";
__c.CallSubNew3(ba,_mtarget,_meventname+"_complete",(Object)(_success),(Object)(_errormessage));
 //BA.debugLineNum = 77;BA.debugLine="End Sub";
return "";
}
public String  _auth_fail() throws Exception{
 //BA.debugLineNum = 71;BA.debugLine="Private Sub Auth_fail";
 //BA.debugLineNum = 72;BA.debugLine="CallSub(mTarget, mEventName & \"_fail\")";
__c.CallSubNew(ba,_mtarget,_meventname+"_fail");
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public String  _authenticate() throws Exception{
anywheresoftware.b4j.object.JavaObject _ev = null;
 //BA.debugLineNum = 24;BA.debugLine="Public Sub Authenticate";
 //BA.debugLineNum = 25;BA.debugLine="Cancel";
_cancel();
 //BA.debugLineNum = 26;BA.debugLine="cancelObject.InitializeNewInstance(\"android.os.Ca";
_cancelobject.InitializeNewInstance("android.os.CancellationSignal",(Object[])(__c.Null));
 //BA.debugLineNum = 27;BA.debugLine="Dim Ev As JavaObject";
_ev = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 28;BA.debugLine="Ev.InitializeNewInstance(Application.PackageName";
_ev.InitializeNewInstance(__c.Application.getPackageName()+".fingerprintmanager.FingerprintAuthentication",new Object[]{this});
 //BA.debugLineNum = 29;BA.debugLine="sensor.RunMethod(\"authenticate\", Array(Null, Null";
_sensor.RunMethod("authenticate",new Object[]{__c.Null,__c.Null,(Object)(0),(Object)(_ev.getObject()),__c.Null});
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
public String  _cancel() throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Public Sub Cancel";
 //BA.debugLineNum = 33;BA.debugLine="If cancelObject.IsInitialized And cancelObject.Ru";
if (_cancelobject.IsInitialized() && (_cancelobject.RunMethod("isCanceled",(Object[])(__c.Null))).equals((Object)(__c.False))) { 
 //BA.debugLineNum = 34;BA.debugLine="cancelObject.RunMethod(\"cancel\", Null)";
_cancelobject.RunMethod("cancel",(Object[])(__c.Null));
 };
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private sensor As JavaObject";
_sensor = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 4;BA.debugLine="Private cancelObject As JavaObject";
_cancelobject = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 5;BA.debugLine="Private mTarget As Object";
_mtarget = new Object();
 //BA.debugLineNum = 6;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return "";
}
public boolean  _gethardwaredetected() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Public Sub getHardwareDetected As Boolean";
 //BA.debugLineNum = 17;BA.debugLine="Return sensor.RunMethod(\"isHardwareDetected\", Nul";
if (true) return BA.ObjectToBoolean(_sensor.RunMethod("isHardwareDetected",(Object[])(__c.Null)));
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return false;
}
public boolean  _gethasenrolledfingerprints() throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Public Sub getHasEnrolledFingerprints As Boolean";
 //BA.debugLineNum = 21;BA.debugLine="Return sensor.RunMethod(\"hasEnrolledFingerprints\"";
if (true) return BA.ObjectToBoolean(_sensor.RunMethod("hasEnrolledFingerprints",(Object[])(__c.Null)));
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return false;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _target,String _eventname) throws Exception{
innerInitialize(_ba);
anywheresoftware.b4j.object.JavaObject _ctxt = null;
 //BA.debugLineNum = 9;BA.debugLine="Public Sub Initialize (Target As Object, EventName";
 //BA.debugLineNum = 10;BA.debugLine="mTarget = Target";
_mtarget = _target;
 //BA.debugLineNum = 11;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 12;BA.debugLine="Dim ctxt As JavaObject";
_ctxt = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 13;BA.debugLine="sensor = ctxt.InitializeContext.RunMethod(\"getSys";
_sensor.setObject((java.lang.Object)(_ctxt.InitializeContext(ba).RunMethod("getSystemService",new Object[]{(Object)("fingerprint")})));
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
public static class FingerprintAuthentication extends FingerprintManager.AuthenticationCallback {
	private BA ba;
	public FingerprintAuthentication(B4AClass parent) {
		ba = parent.getBA();
	}
	@Override
	public void onAuthenticationError(int errorCode, CharSequence errString) {
		super.onAuthenticationError(errorCode, errString);
		 ba.raiseEvent(this, "auth_complete", false, errorCode, errString);
	}

	@Override
	public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
		super.onAuthenticationHelp(helpCode, helpString);
	}

	@Override
	public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
		super.onAuthenticationSucceeded(result);
		 ba.raiseEvent(this, "auth_complete", true, 0, "");
	}

	@Override
	public void onAuthenticationFailed() {
		super.onAuthenticationFailed();
		BA.Log("fail");
		ba.raiseEvent(this, "auth_fail");
	}
}
}
