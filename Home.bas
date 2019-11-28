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
	Dim t_shegeft As Timer
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Dim lblbsk As Label
	Dim sv As ScrollView
	
	Dim pb As PagerBullet
	Dim pa As PagerBulletAdapter
	
	Dim lblho As Label
	Dim lblmin As Label
	Dim lblsecend As Label
	Dim time313 As Long
	Dim lbltitletop As Label
	Dim LV_prod(10) As Hitex_LayoutView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Dim ac As AppCompat
	Dim pnl As Panel
	C.PnlCreate(pnl,"",Activity,0,0,-1,56dip+ac.GetStatusBarHeight)
	pnl.Color=0xFF920000
	pnl.Elevation=4dip

	
	C.setlblset(lbltitletop,"",pnl,0,ac.GetStatusBarHeight,100%x-56dip,56dip,"دی جی کالا",C.rcenter,C.irs,20,Colors.White)
	
	Dim lbl As Label
	C.setlblset(lbl,"menue",pnl,100%x-56dip,ac.GetStatusBarHeight,56dip,56dip,Chr(0xE5D2),Gravity.CENTER,Typeface.MATERIALICONS,25,Colors.White)
	ac.SetClickEffect(lbl,True)
	
	Dim lbl As Label
	C.setlblset(lbl,"bask",pnl,0,ac.GetStatusBarHeight,56dip,56dip,Chr(0xE8CC),Gravity.CENTER,Typeface.MATERIALICONS,25,Colors.White)
	ac.SetClickEffect(lbl,True)
	
	
	C.setlblset(lblbsk,"bask",pnl,30dip,ac.GetStatusBarHeight+6dip,20dip,20dip,"1",Gravity.CENTER,C.irsb,10,0xFF920000)
	Dim oo As ColorDrawable
	oo.Initialize2(-1,5555,2dip,0xFF920000)
	lblbsk.Background=oo
	lblbsk.Padding = Array As Int (0, 2dip, 0, 0)
	
	sv.Initialize(420%x)
	Activity.AddView(sv,0,56dip+ac.GetStatusBarHeight,100%x,100%y-(56dip+ac.GetStatusBarHeight))

	
	
	Dim lst As List
	lst.Initialize
	lst.Add("سلام#سلام")
	lst.Add("سلایلبلم#سلامسلام")
	lst.Add("سلازذفاتم#سلام")
	lst.Add("سهعهعهلام#سلامسلامسلام")
	lst.Add("سلایلبلم#سلامسلام")
	lst.Add("سلایلبلم#سلامسلام")
	lst.Add("سلازذفاتم#سلام")
	lst.Add("سهعهعهلام#سلامسلامسلام")
	lst.Add("سلازذفاتم#سلام")
	lst.Add("سهعهعهلام#سلامسلامdfسلام")
	'cat_create(0,lst)
	Dim lst As List
	lst.Initialize
	lst.Add("http://bamalearn.ir/wp-content/uploads/2019/04/rtl-toolbar-b4a-348x215.jpg")
	lst.Add("http://bamalearn.ir/wp-content/uploads/2019/04/rtl-toolbar-b4a-348x215.jpg")
	
	'banners_create(11%x,lst)
	'banner2taee_creat(11%x,40,lst)
'	banner1taee_creat(11%x,64,"http://bamalearn.ir/wp-content/uploads/2019/04/rtl-toolbar-b4a-348x215.jpg","")
	
'	banner1taee_card_creat(11%x,64,"http://bamalearn.ir/wp-content/uploads/2019/04/rtl-toolbar-b4a-348x215.jpg","")
'	banner2taee_card_creat(11%x,32,lst)
	
	
	Dim retrofit As Amir_Retrofit
	Dim Builder As Amir_RetrofitBuilder

	
	Builder.Initialize.baseUrl("https://jeebres.ir/api/v1/y88d/")
	'Builder.UnsafeMode(True)
	Dim appkey As String = File.ReadString(File.DirAssets,"appkey.me.txt")
	Builder.addHeader(CreateMap("appkey":appkey))
	retrofit.Initialize(Builder)
	retrofit.Get("maindata","app",Null)
End Sub
Sub maindata_onCompleted      '💎💎💎           Post-Get-Put-Delete-Patch         💎💎💎



End Sub
Sub maindata_onError (Error As String,Code As Int)
Log(Error)
End Sub
Sub maindata_onNext (ResponseBody As Amir_ResponseBody)
	Log(ResponseBody.String)
	Dim parser As JSONParser
	parser.Initialize(ResponseBody.String)
	Dim root As Map = parser.NextObject
	Dim result As Map = root.Get("result")
	Dim lang_list As Map = result.Get("lang_list")
	Dim en As Map = lang_list.Get("en")
	Dim localname As String = en.Get("localname")
	Dim iso As String = en.Get("iso")
	Dim api_url As String = en.Get("api_url")
	Dim name As String = en.Get("name")
	Dim direction As String = en.Get("direction")
	Dim fa As Map = lang_list.Get("fa")
	Dim localname As String = fa.Get("localname")
	Dim iso As String = fa.Get("iso")
	Dim api_url As String = fa.Get("api_url")
	Dim name As String = fa.Get("name")
	Dim direction As String = fa.Get("direction")
	Dim site As Map = result.Get("site")
	Dim name As String = site.Get("name")
	Dim logo As String = site.Get("logo")
	Dim slogan As String = site.Get("slogan")
	Dim desc As String = site.Get("desc")
	Dim navigation As List = result.Get("navigation")
	For Each colnavigation As Map In navigation
		Dim icon As String = colnavigation.Get("icon")
		Dim link As String = colnavigation.Get("link")
		Dim Typegb As String = colnavigation.Get("type")
		Dim title As String = colnavigation.Get("title")
	Next
	Dim ad As Map = result.Get("ad")
	Dim top As Map = ad.Get("top")
	Dim link As String = top.Get("link")
	Dim content As String = top.Get("content")
	Dim bottom As List = ad.Get("bottom")
	Dim intro As List = result.Get("intro")
	For Each colintro As Map In intro
		Dim bg_to As String = colintro.Get("bg_to")
		Dim image As String = colintro.Get("image")
		Dim bg_from As String = colintro.Get("bg_from")
		Dim title_color As String = colintro.Get("title_color")
		Dim desc_color As String = colintro.Get("desc_color")
		Dim title As String = colintro.Get("title")
		Dim btn As List = colintro.Get("btn")
		For Each colbtn As Map In btn
			Dim action As String = colbtn.Get("action")
			Dim title As String = colbtn.Get("title")
		Next
		Dim desc As String = colintro.Get("desc")
	Next
	Dim transalate As Map = result.Get("transalate")
	Dim changelang As String = transalate.Get("changelang")
	Dim go As String = transalate.Get("go")
	Dim back As String = transalate.Get("back")
	Dim enter As String = transalate.Get("enter")
	Dim version As String = transalate.Get("version")
	Dim close As String = transalate.Get("close")
	Dim theme As Map = result.Get("theme")
	Dim default As Map = theme.Get("default")
	Dim intror As Map = default.Get("intro")
	Dim bg_to As String = intror.Get("bg_to")
	Dim header_from As String = intror.Get("header_from")
	Dim footer_color As String = intror.Get("footer_color")
	Dim bg_from As String = intror.Get("bg_from")
	Dim color As String = intror.Get("color")
	Dim header_to As String = intror.Get("header_to")
	Dim header_color As String = intror.Get("header_color")
	Dim footer_from As String = intror.Get("footer_from")
	Dim footer_to As String = intror.Get("footer_to")
	Dim global As Map = default.Get("global")
	Dim bg_to As String = global.Get("bg_to")
	Dim bg_from As String = global.Get("bg_from")
	Dim color As String = global.Get("color")
	Dim btn_from As String = global.Get("btn_from")
	Dim btn_color As String = global.Get("btn_color")
	Dim btn_to As String = global.Get("btn_to")
	Dim share As Map = default.Get("share")
	Dim bg_to As String = share.Get("bg_to")
	Dim header_from As String = share.Get("header_from")
	Dim footer_color As String = share.Get("footer_color")
	Dim bg_from As String = share.Get("bg_from")
	Dim color As String = share.Get("color")
	Dim header_to As String = share.Get("header_to")
	Dim header_color As String = share.Get("header_color")
	Dim footer_from As String = share.Get("footer_from")
	Dim footer_to As String = share.Get("footer_to")
	Dim splash As Map = default.Get("splash")
	Dim bg_to As String = splash.Get("bg_to")
	Dim bg_from As String = splash.Get("bg_from")
	Dim color As String = splash.Get("color")
	Dim btng As Map = default.Get("btn")
	Dim warn As Map = btng.Get("warn")
	Dim bg_to As String = warn.Get("bg_to")
	Dim bg_from As String = warn.Get("bg_from")
	Dim color As String = warn.Get("color")
	Dim success As Map = btng.Get("success")
	Dim bg_to As String = success.Get("bg_to")
	Dim bg_from As String = success.Get("bg_from")
	Dim color As String = success.Get("color")
	Dim danger As Map = btng.Get("danger")
	Dim bg_to As String = danger.Get("bg_to")
	Dim bg_from As String = danger.Get("bg_from")
	Dim color As String = danger.Get("color")
	Dim info As Map = btng.Get("info")
	Dim bg_to As String = info.Get("bg_to")
	Dim bg_from As String = info.Get("bg_from")
	Dim color As String = info.Get("color")
	Dim night As Map = theme.Get("night")
	Dim introf As Map = night.Get("intro")
	Dim bg_to As String = introf.Get("bg_to")
	Dim header_from As String = introf.Get("header_from")
	Dim footer_color As String = introf.Get("footer_color")
	Dim bg_from As String = introf.Get("bg_from")
	Dim color As String = introf.Get("color")
	Dim header_to As String = introf.Get("header_to")
	Dim header_color As String = introf.Get("header_color")
	Dim footer_from As String = introf.Get("footer_from")
	Dim footer_to As String = introf.Get("footer_to")
	Dim global As Map = night.Get("global")
	Dim bg_to As String = global.Get("bg_to")
	Dim bg_from As String = global.Get("bg_from")
	Dim color As String = global.Get("color")
	Dim btn_from As String = global.Get("btn_from")
	Dim btn_color As String = global.Get("btn_color")
	Dim btn_to As String = global.Get("btn_to")
	Dim share As Map = night.Get("share")
	Dim bg_to As String = share.Get("bg_to")
	Dim header_from As String = share.Get("header_from")
	Dim footer_color As String = share.Get("footer_color")
	Dim bg_from As String = share.Get("bg_from")
	Dim color As String = share.Get("color")
	Dim header_to As String = share.Get("header_to")
	Dim header_color As String = share.Get("header_color")
	Dim footer_from As String = share.Get("footer_from")
	Dim footer_to As String = share.Get("footer_to")
	Dim splash As Map = night.Get("splash")
	Dim bg_to As String = splash.Get("bg_to")
	Dim bg_from As String = splash.Get("bg_from")
	Dim color As String = splash.Get("color")
	Dim btnf As Map = night.Get("btn")
	Dim warn As Map = btnf.Get("warn")
	Dim bg_to As String = warn.Get("bg_to")
	Dim bg_from As String = warn.Get("bg_from")
	Dim color As String = warn.Get("color")
	Dim success As Map = btnf.Get("success")
	Dim bg_to As String = success.Get("bg_to")
	Dim bg_from As String = success.Get("bg_from")
	Dim color As String = success.Get("color")
	Dim danger As Map = btnf.Get("danger")
	Dim bg_to As String = danger.Get("bg_to")
	Dim bg_from As String = danger.Get("bg_from")
	Dim color As String = danger.Get("color")
	Dim info As Map = btnf.Get("info")
	Dim bg_to As String = info.Get("bg_to")
	Dim bg_from As String = info.Get("bg_from")
	Dim color As String = info.Get("color")
	Dim menu As List = result.Get("menu")
	For Each colmenu As Map In menu
		Dim icon As String = colmenu.Get("icon")
		Dim link As String = colmenu.Get("link")
		Dim Typefg As String = colmenu.Get("type")
		Dim title As String = colmenu.Get("title")

	Next
	Dim versiond As Map = result.Get("version")
	Dim deprecated_descd As String = versiond.Get("deprecated_desc")
	Dim lastd As Int = versiond.Get("last")
	Dim deprecatedd As Int = versiond.Get("deprecated")
	Dim update_titled As String = versiond.Get("update_title")
	Dim deprecated_titled As String = versiond.Get("deprecated_title")
	Dim update_descd As String = versiond.Get("update_desc")
	Dim url As Map = result.Get("url")
	Dim sited As String = url.Get("site")
	Dim domain As String = url.Get("domain")
	Dim rootd As String = url.Get("root")
	Dim update As String = url.Get("update")
	Dim enter As String = url.Get("enter")
	Dim kingdom As String = url.Get("kingdom")
	Dim homepage As List = result.Get("homepage")
	For Each colhomepage As Map In homepage
		
		Dim Typert As String = colhomepage.Get("type")
		

		Select Typert
			Case "promotion"
				Dim expire As Map = colhomepage.Get("expire")
				If colhomepage.ContainsKey("data") Then

					Dim data As List = colhomepage.Get("data")
					Dim lst As List
					lst.Initialize
					For Each coldata As Map In data
						Dim mode As String = coldata.Get("mode")
						Dim title As String = coldata.Get("title")
						
						Dim image As String = coldata.Get("image")
						Dim Activitya As String = coldata.Get("activity")
						Dim urla As String = coldata.Get("url")
						
						lst.Add(image&"#"&"123123"&"#"&title&"#"&"1000"&"#"&"455"&"#"&"132"&"#"&"123"&"#"&"123"&"#"&"132")
						
					Next
					Log(expire.Get("serverttime"))
					Log(expire.Get("expiretime"))
					shegeft_creat(4%x,lst,expire.Get("serverttime"),expire.Get("expiretime"))
					Log(title)
				End If
		End Select

		
		
		

	Next
	Dim ok As String = root.Get("ok")
End Sub
Sub shegeft_creat(top As Int,lstnews1 As List,start As Long,endd As Long)
	Dim pnl As Panel
	pnl.Initialize("")
	sv.Panel.AddView(pnl,0,top,100%x,50%x)
	
	Dim cd As ColorDrawable
	cd.Initialize(0xFF727272,2dip)
	
	
	lblho.Initialize("")
	pnl.AddView(lblho,4%x,1%x,8%x,8%x)
	lblho.Background=cd
	lblho.Text="02"
	lblho.Gravity=Gravity.CENTER
	lblho.TextColor=Colors.White
	lblho.TextSize=16
	
	Dim lbl As Label
	lbl.Initialize("")
	pnl.AddView(lbl,12%x,1%x,3%x,8%x)
	lbl.Text=":"
	lbl.Gravity=Gravity.CENTER
	lbl.TextColor=0xFF727272
	lbl.TextSize=16

	lblmin.Initialize("")
	pnl.AddView(lblmin,15%x,1%x,8%x,8%x)
	lblmin.Background=cd
	lblmin.Text="02"
	lblmin.Gravity=Gravity.CENTER
	lblmin.TextColor=Colors.White
	lblmin.TextSize=16
	
	Dim lbl As Label
	lbl.Initialize("")
	pnl.AddView(lbl,23%x,1%x,3%x,8%x)
	lbl.Text=":"
	lbl.Gravity=Gravity.CENTER
	lbl.TextColor=0xFF727272
	lbl.TextSize=16

	lblsecend.Initialize("")
	pnl.AddView(lblsecend,26%x,1%x,8%x,8%x)
	lblsecend.Background=cd
	lblsecend.Text="02"
	lblsecend.Gravity=Gravity.CENTER
	lblsecend.TextColor=Colors.White
	lblsecend.TextSize=16
	
	time313 =endd-start

	t_shegeft.Initialize("t_shegeft", 1000)
	t_shegeft.Enabled = True
 
	Dim shegeft As Label
	shegeft.Initialize("")
	shegeft.Text="محصولات شگفت انگیز"
	shegeft.Gravity=Gravity.RIGHT+Gravity.CENTER
	shegeft.Typeface=C.irs
	shegeft.TextSize=18
	sv.Panel.AddView(shegeft,50%x,top,45%x,10%x)
	
	Dim fc As creatLV
	fc.Initialize(sv.Panel,top+12%x,lstnews1)
	
End Sub

Sub t_shegeft_Tick

'	Log(DateTime.Time(1574915285197))
	time313=time313-1000
	
	Dim sec, hours, minutes As Int
	
'	hours = Floor((time313 Mod DateTime.TicksPerDay) / DateTime.TicksPerHour)
'	minutes = Floor((time313 Mod DateTime.TicksPerHour) / DateTime.TicksPerMinute)
'	sec = Floor((time313 Mod DateTime.TicksPerMinute) / DateTime.TicksPerSecond)

	hours = DateTime.GetHour(time313)
	minutes = DateTime.GetMinute(time313)
	sec = DateTime.GetSecond(time313)


	lblsecend.Text=sec
	lblmin.Text=minutes
	lblho.Text=hours


	
	If lblsecend.Text<10 Then  lblsecend.Text="0"&lblsecend.Text
	If lblmin.Text<10 Then  lblmin.Text="0"& lblmin.Text
	If lblho.Text<9 Then  lblho.Text="0"& lblho.Text
	
	If lblsecend.Text=0 Then  lblsecend.Text="00"
	If lblmin.Text=0 Then  lblmin.Text="00"
	If lblho.Text=0 Then  lblho.Text="00"
End Sub
Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
t_shegeft.Enabled=False
End Sub

Sub banner1taee_creat(top As Int,heat As Int,link As String,action As String)
	Dim img As ImageView
	C.imgCreate(img,"",sv.Panel,0,top,100%x,heat*1%x)
	Dim Glide As Hitex_Glide
	Glide.Load2(link).FitCenter.Into(img)
End Sub
Sub banner2taee_creat(top As Int,heat As Int,ListbannerPager As List)
	Dim h13() As String=Regex.Split("#",ListbannerPager.Get(0))
	Dim img As ImageView
	C.imgCreate(img,"",sv.Panel,0,top,50%x,heat*1%x)
	Dim Glide As Hitex_Glide
	Glide.Load2(h13(0)).FitCenter.Into(img)
	
	Dim h13() As String=Regex.Split("#",ListbannerPager.Get(1))
	Dim img As ImageView
	C.imgCreate(img,"",sv.Panel,50%x,top,50%x,heat*1%x)
	Dim Glide As Hitex_Glide
	Glide.Load2(h13(0)).FitCenter.Into(img)
End Sub

Sub banner1taee_card_creat(top As Int,heat As Int,link As String,action As String)
	Dim card As CardView
	card.Initialize("")
	card.Elevation=2dip
	sv.Panel.AddView(card,2%x,top,96%x,heat*1%x)
	Dim img As ImageView
	img.Initialize("")
	card.AddView(img,0,0,-1,-1)
	img.Gravity=Gravity.FILL
	Dim Glide As Hitex_Glide
	Glide.Load2(link).CenterCrop.Into(img)
End Sub
Sub banner2taee_card_creat(top As Int,heat As Int,ListbannerPager As List)
	Dim h13() As String=Regex.Split("#",ListbannerPager.Get(0))

	Dim card As CardView
	card.Initialize("")
	card.Elevation=2dip
	sv.Panel.AddView(card,2%x,top,47%x,heat*1%x)
	Dim img As ImageView
	img.Initialize("")
	card.AddView(img,0,0,-1,-1)
	img.Gravity=Gravity.FILL
	Dim Glide As Hitex_Glide
	Glide.Load2(h13(0)).CenterCrop.Into(img)
	
	Dim h13() As String=Regex.Split("#",ListbannerPager.Get(1))
	Dim card As CardView
	card.Initialize("")
	card.Elevation=2dip
	sv.Panel.AddView(card,51%x,top,47%x,heat*1%x)
	Dim img As ImageView
	img.Initialize("")
	card.AddView(img,0,0,-1,-1)
	img.Gravity=Gravity.FILL
	Dim Glide As Hitex_Glide
	Glide.Load2(h13(0)).CenterCrop.Into(img)
End Sub
Sub banners_create(top As Int,heat As Int,ListbannerPager As List)
	pa.Initialize

	For i = 0 To ListbannerPager.Size-1
		Dim h13() As String=Regex.Split("#",ListbannerPager.Get(i))
		Dim p As Panel
		p.Initialize("banners")
		Dim img As ImageView
		img.Initialize("")
		p.AddView(img,0,0,-1,-1)
		Dim Glide As Hitex_Glide
		Glide.Load2(h13(0)).FitCenter.Into(img)
		pa.AddPage(p)
		p.Tag=ListbannerPager.Get(i)
	Next
		
	pb.Initialize(pa,"pb")
	pb.setDotsColor(0xFF008C79,0x7E008C79)
	pb.Transition = pb.PARALLAX_PAGE
	sv.Panel.AddView(pb,0,top,100%x,heat*1%x)
End Sub
Sub cat_create(top As Int , lst As List)
	Dim sv1 As HorizontalScrollView
	sv1.Initialize(550dip,"")
	sv.Panel.AddView(sv1,0,top+1%x,100%x,12%x)
	Dim withs As Int = 1%x
	For i = 0 To lst.Size-1
	
		Dim card As CardView
		card.Initialize("")
		card.Elevation=0
		sv1.Panel.AddView(card,withs,1%x,-1,10%x)
		Dim cd As ColorDrawable
		cd.Initialize(0xFF00C6C6, 500dip)
	
	
		Dim pnlk As Panel
		pnlk.Initialize("")
		card.AddView(pnlk,0,0,-1,-1)
		pnlk.Background = cd
	
		Dim lbl As Label
		lbl.Initialize("")
		lbl.TextColor=Colors.White
		lbl.Gravity=Gravity.CENTER
		lbl.Typeface=C.irs
		lbl.TextSize=15
		pnlk.AddView(lbl,0,0%x,-1,9%x)
		
		Dim h13() As String=Regex.Split("#",lst.Get(i))

		lbl.Text=h13(1)
	
		card.Width=C.GetTextWidth(lbl)+10%x
		withs=withs+C.GetTextWidth(lbl)+12%x
		sv1.Panel.Width=withs
	Next

	Sleep(0)
	sv1.ScrollPosition=withs+9%x
End Sub



