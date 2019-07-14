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
	
	Dim ac As ACEditText
	Dim lbl1 As Label
	Dim lbl2 As Label
	Dim lbl3 As Label
	Dim lbl4 As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.Background= C.Gradient(0xff54A3EC,0xff5433B0,0,True)

	Dim img As ImageView
	C.imgCreate(img,"",Activity,40%x,50%y-50%x,20%x,20%x)
	img.Bitmap=Application.Icon
	
	
	Dim lbl As Label
	C.setlblset(lbl,"",Activity,0,50%y-20%x,100%x,13%x,"تایید شماره همراه",Gravity.CENTER,C.irs,20,0xFFFFFFFF)
	
	Dim lbl As Label
	C.setlblset(lbl,"",Activity,0,50%y-10%x,100%x,13%x,"لطفا کد پیامک شده را وارد کنید",Gravity.CENTER,C.irs,15,0xFFFFFFFF)
	
	Dim pnl As Panel
	C.PnlCreate(pnl,"",Activity,19%x,50%y+15%x,14%x,14%x)
	pnl.Background= C.Gradient(-1,-1,5000,True)
	
	
	C.setlblset(lbl1,"lblc",pnl,0,0,-1,-1,"",Gravity.CENTER,C.irs,20,-1)
	
	Dim pnl As Panel
	C.PnlCreate(pnl,"",Activity,19%x+16%x,50%y+15%x,14%x,14%x)
	pnl.Background= C.Gradient(-1,-1,5000,True)
	
	C.setlblset(lbl2,"lblc",pnl,0,0,-1,-1,"",Gravity.CENTER,C.irs,20,-1)
	
	Dim pnl As Panel
	C.PnlCreate(pnl,"",Activity,19%x+(16%x*2),50%y+15%x,14%x,14%x)
	pnl.Background= C.Gradient(-1,-1,5000,True)
	
	C.setlblset(lbl3,"lblc",pnl,0,0,-1,-1,"",Gravity.CENTER,C.irs,20,-1)
	
	Dim pnl As Panel
	C.PnlCreate(pnl,"",Activity,19%x+(16%x*3),50%y+15%x,14%x,14%x)
	pnl.Background= C.Gradient(-1,-1,5000,True)
	
	C.setlblset(lbl4,"lblc",pnl,0,0,-1,-1,"",Gravity.CENTER,C.irs,20,-1)
	

	ac.Initialize("ed")
	Activity.AddView(ac,129%x,50%y+15%x,57%x,14%x)
	ac.Typeface=c.irs
	ac.Hint="شماره موبایل"
	ac.HintColor=0x5AFFFFFF
	Dim cm As cmLibrariesSupport
	cm.SetEditTextTintColor(ac,Colors.Transparent,Colors.Transparent)
	c.Force_RtlSupported4View(ac)
	ac.TextColor=Colors.White
	ac.InputType=ac.INPUT_TYPE_NUMBERS
	ac.ForceDoneButton=True
	ac.RequestFocus
	
	C.show_key(ac,"")
End Sub
Sub lblc_Click
	C.show_key(ac,"")
End Sub
Sub pnlcolor(a As Int,b As Int,cd As Int,d As Int)
	Dim pnl1 As Panel = lbl1.Parent
	Dim pnl2 As Panel = lbl2.Parent
	Dim pnl3 As Panel = lbl3.Parent
	Dim pnl4 As Panel = lbl4.Parent
	pnl1.Color=a
	pnl2.Color=b
	pnl3.Color=cd
	pnl4.Color=d
End Sub
Sub ed_TextChanged (Old As String, New As String)

	Select New.Length

		Case 0
			lbl1.Text=""
			lbl2.Text=""
			lbl3.Text=""
			lbl4.Text=""
			pnlcolor(-1,-1,-1,-1)
		Case 1
			lbl1.Text=New.SubString2(0,1)
			lbl2.Text=""
			lbl3.Text=""
			lbl4.Text=""
			pnlcolor(0xFF004383,-1,-1,-1)
		Case 2
			lbl1.Text=New.SubString2(0,1)
			lbl2.Text=New.SubString2(1,2)
			lbl3.Text=""
			lbl4.Text=""
			pnlcolor(0xFF004383,0xFF004383,-1,-1)
		Case 3
			lbl1.Text=New.SubString2(0,1)
			lbl2.Text=New.SubString2(1,2)
			lbl3.Text=New.SubString2(2,3)
			lbl4.Text=""
			pnlcolor(0xFF004383,0xFF004383,0xFF004383,-1)
			
		Case 4
			lbl1.Text=New.SubString2(0,1)
			lbl2.Text=New.SubString2(1,2)
			lbl3.Text=New.SubString2(2,3)
			lbl4.Text=New.SubString2(3,4)
			pnlcolor(0xFF004383,0xFF004383,0xFF004383,0xFF004383)
		Case 5
			ac.Text=Old
			ac.SetSelection(4,0)
	End Select

End Sub
Sub Activity_Click
	StartActivity(page)
End Sub
Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
