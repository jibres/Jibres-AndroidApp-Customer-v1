B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=9
@EndOfDesignText@
'Code module
'Subs in this code module will be accessible from all modules.
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
Dim irs As Typeface = Typeface.LoadFromAssets("iransansmobile.ttf")
	Dim irsb As Typeface = Typeface.CreateNew(irs, Typeface.STYLE_BOLD)
	
End Sub
Sub setBacckGD As GradientDrawable
	Dim Gradient1 As GradientDrawable
	Dim Clrs(2) As Int
	Clrs(0) = 0xff54A3EC
	Clrs(1) = 0xff5433B0
	Gradient1.Initialize("TOP_BOTTOM", Clrs)
	Return Gradient1
End Sub
Sub setBacckGD2 As GradientDrawable
	Dim Gradient1 As GradientDrawable
	Dim Clrs(2) As Int
	Clrs(0) = 0xff54A3EC
	Clrs(1) = 0xff5433B0
	Gradient1.Initialize("TOP_BOTTOM", Clrs)
	Return Gradient1
End Sub
Sub Gradient(clr1 As Int,clr2 As Int,rad As Int) As GradientDrawable
	Dim Gradient1 As GradientDrawable
	Dim Clrs(2) As Int
	Clrs(0) = clr1
	Clrs(1) = clr2
	Gradient1.Initialize("LEFT_RIGHT", Clrs)
	Gradient1.CornerRadius=rad
	Return Gradient1
End Sub
Sub SetStatusBarColor(clr As Int)
	Dim p As Phone
	If p.SdkVersion >= 21 Then
		Dim jo As JavaObject
		jo.InitializeContext
		Dim window As JavaObject = jo.RunMethodJO("getWindow", Null)
		window.RunMethod("addFlags", Array (0x80000000))
		window.RunMethod("clearFlags", Array (0x04000000))
		window.RunMethod("setNavigationBarColor", Array(clr))
	End If
	

'	
End Sub
Sub Force_RtlSupported4View(View As View)
	Dim jA,jos As JavaObject
	jos.InitializeStatic  ("android.view.View")
	If jA.InitializeStatic  ("android.os.Build$VERSION").GetField ("SDK_INT") > 16 Then
		jA = View
		jA.RunMethod ("setLayoutDirection",Array(jos.GetField ("LAYOUT_DIRECTION_RTL")))
	End If
End Sub
Public Sub ForceLTRSupported(View As View)
	Dim jA,jos As JavaObject
	jos.InitializeStatic  ("android.view.View")
	If jA.InitializeStatic  ("android.os.Build$VERSION").GetField ("SDK_INT") > 16 Then
		jA = View
		jA.RunMethod ("setLayoutDirection",Array(jos.GetField ("LAYOUT_DIRECTION_LTR")))
	End If
End Sub

Sub generatekey As String
	Dim s As String = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@%#0123456789"
	Dim h As String
For i = 0 To 5
	Dim j As String
	j=s.CharAt(Rnd(0,s.Length-1))
		h=h&j
Next
Return h
End Sub