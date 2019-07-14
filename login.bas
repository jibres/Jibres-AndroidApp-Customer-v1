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
	Dim lblbtn As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.Background= C.Gradient(0xff54A3EC,0xff5433B0,0,True)

	Dim img As ImageView
	C.imgCreate(img,"",Activity,40%x,50%y-50%x,20%x,20%x)
	img.Bitmap=Application.Icon
	
	
	Dim pnl As Panel
	pnl.Initialize("")
	Activity.AddView(pnl,12%x,50%y-67%x+74%x,76%x,13%x)
	
	
	Dim lbl As Label
	C.setlblset(lbl,"",Activity,0,50%y-20%x,100%x,13%x,"ثبت نام با شماره همراه",Gravity.CENTER,C.irs,20,0xFFFFFFFF)
	
	Dim cd As ColorDrawable
	cd.Initialize2(0x5AC4C4C4, 10dip,1.5dip,0x5AFFFFFF)
	pnl.Background = cd
	
	Dim ac As ACEditText
	ac.Initialize("ed")
	Activity.AddView(ac,29%x,50%y-67%x+74%x,57%x,14%x)
	ac.Typeface=c.irs
	ac.Hint="شماره موبایل"
	ac.HintColor=0x5AFFFFFF
	Dim cm As cmLibrariesSupport
	cm.SetEditTextTintColor(ac,Colors.Transparent,Colors.Transparent)
	c.Force_RtlSupported4View(ac)
	ac.TextColor=Colors.White
	ac.InputType=ac.INPUT_TYPE_PHONE
	ac.ForceDoneButton=True
	
	Dim img As ImageView
	C.imgCreate(img,"",Activity,15%x,50%y-67%x+77.5%x,6%x,6%x)
	C.btm("iran.png",img)
	
	Dim lbl As Label
	C.setlblset(lbl,"",Activity,22%x,50%y-67%x+77.5%x,6%x,6%x,Chr(0xE313),Gravity.CENTER,Typeface.MATERIALICONS,20,0xFFFFFFFF)
	
	
	c.setlblset(lblbtn,"lbl",Activity,12%x,50%y-67%x+94%x,76%x,13%x,"ادامه",Gravity.CENTER,c.irs,15,0xFFFFFFFF)
	lblbtn.Background=c.Gradient(0xff54A3EC,0xff54A3EC,10dip,False)
	lblbtn.Visible=False
	
End Sub
Sub lbl_Click
	StartActivity(verify)
End Sub
Sub ed_TextChanged (Old As String, New As String)
	If New.Length=10 Then
		c.SomUpDownFade(lblbtn,500, True)
		Else
		c.SomUpDownFade(lblbtn,500, False)
	End If
End Sub
Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
