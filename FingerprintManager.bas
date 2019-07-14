B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9
@EndOfDesignText@
#Event: Complete (Success As Boolean, ErrorMessage As String)
Sub Class_Globals
	Private sensor As JavaObject
	Private cancelObject As JavaObject
	Private mTarget As Object
	Private mEventName As String
End Sub

Public Sub Initialize (Target As Object, EventName As String)
	mTarget = Target
	mEventName = EventName
	Dim ctxt As JavaObject
	sensor = ctxt.InitializeContext.RunMethod("getSystemService", Array("fingerprint"))
End Sub

Public Sub getHardwareDetected As Boolean
	Return sensor.RunMethod("isHardwareDetected", Null)
End Sub

Public Sub getHasEnrolledFingerprints As Boolean
	Return sensor.RunMethod("hasEnrolledFingerprints", Null)
End Sub

Public Sub Authenticate
	Cancel
	cancelObject.InitializeNewInstance("android.os.CancellationSignal", Null)
	Dim Ev As JavaObject
	Ev.InitializeNewInstance(Application.PackageName & ".fingerprintmanager.FingerprintAuthentication", Array(Me))
	sensor.RunMethod("authenticate", Array(Null, Null, 0, Ev, Null))
End Sub

Public Sub Cancel
	If cancelObject.IsInitialized And cancelObject.RunMethod("isCanceled", Null) = False Then
		cancelObject.RunMethod("cancel", Null)
	End If
End Sub


#if java
import android.hardware.fingerprint.*;
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
#end if
Private Sub Auth_fail
	CallSub(mTarget, mEventName & "_fail")
End Sub
Private Sub Auth_Complete (Success As Boolean, ErrorCode As Int, ErrorMessage As String)
	If ErrorCode = 5 Then Return 'cancel
	CallSub3(mTarget, mEventName & "_complete", Success, ErrorMessage)
End Sub