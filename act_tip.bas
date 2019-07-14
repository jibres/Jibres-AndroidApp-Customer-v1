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
	Private VP As AHViewPager
	Private PC As AHPageContainer
	Private Panel(4) As Panel
	Dim pnlnonet As Panel
	Dim lblnext As Label
	Dim lblprew As Label
	Dim lblbol As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.Background= C.Gradient(0xff54A3EC,0xff5433B0,0,True)
	
	Dim pnl As Panel
	C.PnlCreate(pnl,"",Activity,-100%x,100%y-75%x,300%x,300%x)
	Dim cd As ColorDrawable
	cd.Initialize(Colors.White, 5000dip)
	pnl.Background = cd
	
	PC.Initialize
	For i = 0 To 3
		Panel(i).Initialize("Panel")
		PC.AddPage(Panel(i),"")
		Panel(i).Color=Colors.Transparent
		Dim pnl As Panel
		C.PnlCreate(pnl,"",Panel(i),10%x,15%x,80%x,100%y-70%x)
		pnl.Background=C.Gradient(0xFFFFFFFF,0xFFFFFFFF,10dip,True)
		pnl.Elevation=10dip
		pnl.Color=Colors.White
		
		Dim lbl As Label
		C.setlblset(lbl,"",Panel(i),0,100%y-50%x,-1,10%x,"تیتر راهنمای اپلیکیش",Gravity.CENTER,C.irs,20,Colors.Black)
		
		Dim lbl As Label
		C.setlblset(lbl,"",Panel(i),0,100%y-40%x,-1,20%x,"متن راهنمای اپلیکیشن جیبرس ، در هزینه های خود صرفه جویی کنید.",C.tcenter,C.irs,15,0xFF727272)
		lbl.Padding = Array As Int (30dip, 0, 30dip, 0)
	Next
	
	VP.Initialize2(PC,"VP")
	Activity.AddView(VP,0,0,-1,100%y)
	VP.Color=Colors.Transparent
	VP.PageMargin=-50dip
	VP.OffscreenPageLimit=4
	
	
	C.setlblset(lblprew,"prew",Activity,0,100%y-15%x,35%x,10%x,"قبلی",Gravity.CENTER,C.irs,15,0xFF727272)
	lblprew.Visible=False

	C.setlblset(lblnext,"next",Activity,100%x-35%x,100%y-15%x,35%x,10%x,"بعدی",Gravity.CENTER,C.irs,15,0xFF727272)

	Dim cs As CSBuilder
	cs.Initialize.Color(0xFF727272).Append(Chr(0xF111)).Pop.Append("   ").Color(0xFFCECECE).Append(Chr(0xF111)).Pop.Append("   ").Color(0xFFCECECE).Append(Chr(0xF111)).Append("   ").Color(0xFFCECECE).Append(Chr(0xF111)).PopAll

	
	C.setlblset(lblbol,"",Activity,0,100%y-19.5%x,100%x,20%x,"",Gravity.CENTER,Typeface.FONTAWESOME,12,-1)
	lblbol.Text=cs
	

End Sub
Sub vp_PageChanged (Position As Int)
	Select Position
		Case 0
			Dim cs As CSBuilder
			cs.Initialize.Color(0xFF727272).Append(Chr(0xF111)).Pop.Append("   ").Color(0xFFCECECE).Append(Chr(0xF111)).Pop.Append("   ").Color(0xFFCECECE).Append(Chr(0xF111)).Append("   ").Color(0xFFCECECE).Append(Chr(0xF111)).PopAll
			lblbol.Text=cs
			lblprew.SetVisibleAnimated(500,False)
			lblnext.Text="بعدی"
		Case 1
			Dim cs As CSBuilder
			cs.Initialize.Color(0xFFCECECE).Append(Chr(0xF111)).Pop.Append("   ").Color(0xFF727272).Append(Chr(0xF111)).Pop.Append("   ").Color(0xFFCECECE).Append(Chr(0xF111)).Append("   ").Color(0xFFCECECE).Append(Chr(0xF111)).PopAll
			lblbol.Text=cs
			lblprew.SetVisibleAnimated(500,True)
			lblnext.Text="بعدی"
		Case 2
			Dim cs As CSBuilder
			cs.Initialize.Color(0xFFCECECE).Append(Chr(0xF111)).Pop.Append("   ").Color(0xFFCECECE).Append(Chr(0xF111)).Pop.Append("   ").Color(0xFF727272).Append(Chr(0xF111)).Append("   ").Color(0xFFCECECE).Append(Chr(0xF111)).PopAll
			lblbol.Text=cs
			
			If lblnext.Text<>"بعدی" Then
				lblnext.SetVisibleAnimated(200,False)
				Sleep(200)
				lblnext.Text="بعدی"
				lblnext.SetVisibleAnimated(200,True)
			End If
			lblprew.SetVisibleAnimated(200,True)
		Case 3
			Dim cs As CSBuilder
			cs.Initialize.Color(0xFFCECECE).Append(Chr(0xF111)).Pop.Append("   ").Color(0xFFCECECE).Append(Chr(0xF111)).Pop.Append("   ").Color(0xFFCECECE).Append(Chr(0xF111)).Append("   ").Color(0xFF727272).Append(Chr(0xF111)).PopAll
			lblbol.Text=cs
			lblprew.SetVisibleAnimated(500,True)
			lblnext.SetVisibleAnimated(200,False)
			Sleep(200)
			lblnext.Text="ورود به برنامه"
			lblnext.SetVisibleAnimated(200,True)
			
	End Select
End Sub
Sub next_Click
	Dim l As Label = Sender
	Select l.Text
		Case "بعدی"
			VP.GotoPage(VP.CurrentPage+1,True)
		Case Else
			StartActivity(login)
	End Select

	
End Sub
Sub prew_Click
	VP.GotoPage(VP.CurrentPage-1,True)
End Sub
Sub Activity_Resume
VP.GotoPage(0,False)
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean 'Return True to consume the event
	If C.IsNoNetShow And c.IsNoNetPrimery=False Then
		C.NoNetClose(pnlnonet)
		Return True
	Else if C.IsNoNetShow And c.IsNoNetPrimery=True Then
		Return True
	End If
'	Activity.Finish
'	StartActivity(Me)
'	Return True
End Sub