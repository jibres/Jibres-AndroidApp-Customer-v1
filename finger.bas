B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=9
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private fingerprint As FingerprintManager
	Dim lav As Hitex_LottieAnimationView
	Dim lbl As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.Background= C.Gradient(0xFFFFFFFF,0xFFFFFFFF,0,True)

		fingerprint.Initialize (Me, "auth")


	

	lav.Initialize("LAV")
	Activity.AddView(lav,10%x,50%y-60%x,80%x,70%x)
	lav.SetAnimation(File.DirAssets,"gray.json")
	lav.SetLoop(True) 'repeat
	lav.PlayAnimation
	lav.Speed=.7

	
	fingerprint.Authenticate
	

	C.setlblset(lbl,"",Activity,0,50%y+20%x,100%x,13%x,"لطفا اثر انگشت خود را تایید کنید",Gravity.CENTER,C.irs,15,0xFF898989)
End Sub

Sub Auth_fail
	lav.RemoveView
	lav.Initialize("LAV")
	Activity.AddView(lav,10%x,50%y-60%x,80%x,70%x)
	lav.SetAnimation(File.DirAssets,"red.json")
	lav.PlayAnimation
	lav.Speed=.7
	lbl.Text="اثر انگشت مطابق نیست"
		
	Sleep(2000 )
	Activity.Finish

	
End Sub
Sub Auth_Complete (Success As Boolean, ErrorMessage As String)
	If Success Then
		lav.RemoveView
		lav.Initialize("LAV")
		Activity.AddView(lav,10%x,50%y-60%x,80%x,70%x)
		lav.SetAnimation(File.DirAssets,"green.json")
		lav.PlayAnimation
		lav.Speed=.7
		lbl.Text="اثر انگشت تایید شد"
		Sleep(2000 )
		Activity.Finish
	Else

	End If
End Sub
Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
