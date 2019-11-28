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
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.example.fingerprintmanager");
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

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
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
public String  _initialize(b4a.example.fingerprintmanager __ref,anywheresoftware.b4a.BA _ba,Object _target,String _eventname) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="fingerprintmanager";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_target,_eventname}));}
anywheresoftware.b4j.object.JavaObject _ctxt = null;
RDebugUtils.currentLine=7929856;
 //BA.debugLineNum = 7929856;BA.debugLine="Public Sub Initialize (Target As Object, EventName";
RDebugUtils.currentLine=7929857;
 //BA.debugLineNum = 7929857;BA.debugLine="mTarget = Target";
__ref._mtarget /*Object*/  = _target;
RDebugUtils.currentLine=7929858;
 //BA.debugLineNum = 7929858;BA.debugLine="mEventName = EventName";
__ref._meventname /*String*/  = _eventname;
RDebugUtils.currentLine=7929859;
 //BA.debugLineNum = 7929859;BA.debugLine="Dim ctxt As JavaObject";
_ctxt = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=7929860;
 //BA.debugLineNum = 7929860;BA.debugLine="sensor = ctxt.InitializeContext.RunMethod(\"getSys";
__ref._sensor /*anywheresoftware.b4j.object.JavaObject*/ .setObject((java.lang.Object)(_ctxt.InitializeContext(ba).RunMethod("getSystemService",new Object[]{(Object)("fingerprint")})));
RDebugUtils.currentLine=7929861;
 //BA.debugLineNum = 7929861;BA.debugLine="End Sub";
return "";
}
public String  _authenticate(b4a.example.fingerprintmanager __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="fingerprintmanager";
if (Debug.shouldDelegate(ba, "authenticate", false))
	 {return ((String) Debug.delegate(ba, "authenticate", null));}
anywheresoftware.b4j.object.JavaObject _ev = null;
RDebugUtils.currentLine=8126464;
 //BA.debugLineNum = 8126464;BA.debugLine="Public Sub Authenticate";
RDebugUtils.currentLine=8126465;
 //BA.debugLineNum = 8126465;BA.debugLine="Cancel";
__ref._cancel /*String*/ (null);
RDebugUtils.currentLine=8126466;
 //BA.debugLineNum = 8126466;BA.debugLine="cancelObject.InitializeNewInstance(\"android.os.Ca";
__ref._cancelobject /*anywheresoftware.b4j.object.JavaObject*/ .InitializeNewInstance("android.os.CancellationSignal",(Object[])(__c.Null));
RDebugUtils.currentLine=8126467;
 //BA.debugLineNum = 8126467;BA.debugLine="Dim Ev As JavaObject";
_ev = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=8126468;
 //BA.debugLineNum = 8126468;BA.debugLine="Ev.InitializeNewInstance(Application.PackageName";
_ev.InitializeNewInstance(__c.Application.getPackageName()+".fingerprintmanager.FingerprintAuthentication",new Object[]{this});
RDebugUtils.currentLine=8126469;
 //BA.debugLineNum = 8126469;BA.debugLine="sensor.RunMethod(\"authenticate\", Array(Null, Null";
__ref._sensor /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("authenticate",new Object[]{__c.Null,__c.Null,(Object)(0),(Object)(_ev.getObject()),__c.Null});
RDebugUtils.currentLine=8126470;
 //BA.debugLineNum = 8126470;BA.debugLine="End Sub";
return "";
}
public String  _auth_complete(b4a.example.fingerprintmanager __ref,boolean _success,int _errorcode,String _errormessage) throws Exception{
__ref = this;
RDebugUtils.currentModule="fingerprintmanager";
if (Debug.shouldDelegate(ba, "auth_complete", false))
	 {return ((String) Debug.delegate(ba, "auth_complete", new Object[] {_success,_errorcode,_errormessage}));}
RDebugUtils.currentLine=8323072;
 //BA.debugLineNum = 8323072;BA.debugLine="Private Sub Auth_Complete (Success As Boolean, Err";
RDebugUtils.currentLine=8323073;
 //BA.debugLineNum = 8323073;BA.debugLine="If ErrorCode = 5 Then Return 'cancel";
if (_errorcode==5) { 
if (true) return "";};
RDebugUtils.currentLine=8323074;
 //BA.debugLineNum = 8323074;BA.debugLine="CallSub3(mTarget, mEventName & \"_complete\", Succe";
__c.CallSubNew3(ba,__ref._mtarget /*Object*/ ,__ref._meventname /*String*/ +"_complete",(Object)(_success),(Object)(_errormessage));
RDebugUtils.currentLine=8323075;
 //BA.debugLineNum = 8323075;BA.debugLine="End Sub";
return "";
}
public String  _auth_fail(b4a.example.fingerprintmanager __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="fingerprintmanager";
if (Debug.shouldDelegate(ba, "auth_fail", false))
	 {return ((String) Debug.delegate(ba, "auth_fail", null));}
RDebugUtils.currentLine=8257536;
 //BA.debugLineNum = 8257536;BA.debugLine="Private Sub Auth_fail";
RDebugUtils.currentLine=8257537;
 //BA.debugLineNum = 8257537;BA.debugLine="CallSub(mTarget, mEventName & \"_fail\")";
__c.CallSubNew(ba,__ref._mtarget /*Object*/ ,__ref._meventname /*String*/ +"_fail");
RDebugUtils.currentLine=8257538;
 //BA.debugLineNum = 8257538;BA.debugLine="End Sub";
return "";
}
public String  _cancel(b4a.example.fingerprintmanager __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="fingerprintmanager";
if (Debug.shouldDelegate(ba, "cancel", false))
	 {return ((String) Debug.delegate(ba, "cancel", null));}
RDebugUtils.currentLine=8192000;
 //BA.debugLineNum = 8192000;BA.debugLine="Public Sub Cancel";
RDebugUtils.currentLine=8192001;
 //BA.debugLineNum = 8192001;BA.debugLine="If cancelObject.IsInitialized And cancelObject.Ru";
if (__ref._cancelobject /*anywheresoftware.b4j.object.JavaObject*/ .IsInitialized() && (__ref._cancelobject /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("isCanceled",(Object[])(__c.Null))).equals((Object)(__c.False))) { 
RDebugUtils.currentLine=8192002;
 //BA.debugLineNum = 8192002;BA.debugLine="cancelObject.RunMethod(\"cancel\", Null)";
__ref._cancelobject /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("cancel",(Object[])(__c.Null));
 };
RDebugUtils.currentLine=8192004;
 //BA.debugLineNum = 8192004;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.example.fingerprintmanager __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="fingerprintmanager";
RDebugUtils.currentLine=7864320;
 //BA.debugLineNum = 7864320;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=7864321;
 //BA.debugLineNum = 7864321;BA.debugLine="Private sensor As JavaObject";
_sensor = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=7864322;
 //BA.debugLineNum = 7864322;BA.debugLine="Private cancelObject As JavaObject";
_cancelobject = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=7864323;
 //BA.debugLineNum = 7864323;BA.debugLine="Private mTarget As Object";
_mtarget = new Object();
RDebugUtils.currentLine=7864324;
 //BA.debugLineNum = 7864324;BA.debugLine="Private mEventName As String";
_meventname = "";
RDebugUtils.currentLine=7864325;
 //BA.debugLineNum = 7864325;BA.debugLine="End Sub";
return "";
}
public boolean  _gethardwaredetected(b4a.example.fingerprintmanager __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="fingerprintmanager";
if (Debug.shouldDelegate(ba, "gethardwaredetected", false))
	 {return ((Boolean) Debug.delegate(ba, "gethardwaredetected", null));}
RDebugUtils.currentLine=7995392;
 //BA.debugLineNum = 7995392;BA.debugLine="Public Sub getHardwareDetected As Boolean";
RDebugUtils.currentLine=7995393;
 //BA.debugLineNum = 7995393;BA.debugLine="Return sensor.RunMethod(\"isHardwareDetected\", Nul";
if (true) return BA.ObjectToBoolean(__ref._sensor /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("isHardwareDetected",(Object[])(__c.Null)));
RDebugUtils.currentLine=7995394;
 //BA.debugLineNum = 7995394;BA.debugLine="End Sub";
return false;
}
public boolean  _gethasenrolledfingerprints(b4a.example.fingerprintmanager __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="fingerprintmanager";
if (Debug.shouldDelegate(ba, "gethasenrolledfingerprints", false))
	 {return ((Boolean) Debug.delegate(ba, "gethasenrolledfingerprints", null));}
RDebugUtils.currentLine=8060928;
 //BA.debugLineNum = 8060928;BA.debugLine="Public Sub getHasEnrolledFingerprints As Boolean";
RDebugUtils.currentLine=8060929;
 //BA.debugLineNum = 8060929;BA.debugLine="Return sensor.RunMethod(\"hasEnrolledFingerprints\"";
if (true) return BA.ObjectToBoolean(__ref._sensor /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("hasEnrolledFingerprints",(Object[])(__c.Null)));
RDebugUtils.currentLine=8060930;
 //BA.debugLineNum = 8060930;BA.debugLine="End Sub";
return false;
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