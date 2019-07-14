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
	Dim picurl As String
	Dim videolink As String
	Dim isdowned As Boolean
	Dim postimg As String
	
	
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Dim soundurl As String
	Private ScrollView1 As ScrollView
	Dim nazarat_lbl As Label
	Private Paneldark As Panel
	Private ACToolBarLight1 As ACToolBarLight
	Private Img As ImageView
	Private toolbartemp As Panel
	Private Glide As Hitex_Glide
	Dim lbltoolbar As Label
	Private pnlmatlab As Panel
	Dim toptemp As Int = 80%x
	Dim titelhaghttemp As Int = 0
	
	'Dim imgtoploadtemp As Boolean = False
	Dim titletemp As Boolean = False
'	Dim doritemp As Bitmap = LoadBitmap(File.DirAssets,"dori.png")

	Dim name As String =""' Main.matlablink313
	Dim map As List
	Dim firstimg As String
	
	Private Pnlprb As Panel
	Private ProgressBar1 As ProgressBar
	Dim fsize As Int
	Dim foldername As String =""' Main.link313
	Dim canshare As Boolean = False
	Dim firstpicshow As Boolean = False
	Dim imglisnks As Map
	Dim comment As String

	Dim downtost As Boolean=False
	Private Label1 As Label
	Private Label2 As Label
	Dim flot As Panel
	Dim flot2 As Label
	Dim flot3 As Panel
	Dim flot4 As Label
	Dim mpo As MediaPlayer
	Dim lbldown As Label
	Dim lblplay As Label
	Dim lbldur As Label
	Dim lblpos As Label
	Dim seekbar As ACSeekBar
	Dim ispus As Boolean = False

	Dim downmap As Map
	Dim favmap As Map

	Dim alltext As String
	Dim hlbl As HeightLabel
	Dim retrofit As ARRetrofit
	Dim call As ARCall
	Dim downloader As ARFileClient
End Sub
Sub ACToolBarLight1_NavigationItemClick
	StartActivity(finger)
	'Activity.Finish
End Sub
#Extends: android.support.v7.app.AppCompatActivity
Sub Activity_Create(FirstTime As Boolean)
	If File.Exists(File.DirInternal,"fsize") = False Then
		File.WriteString(File.DirInternal,"fsize","14")
		fsize=14
	Else
		fsize=File.ReadString(File.DirInternal,"fsize")
	End If
	
	isdowned=False
	videolink=""

	Activity.LoadLayout("matlab1")
	
		
	ScrollView1.Panel.LoadLayout("matlab2")
	'ScrollView1.Panel.Color=Colors.White
	Dim sdk As Phone

	If sdk.SdkVersion >=19 Then
		Dim a As AppCompat
		ACToolBarLight1.Top=a.GetStatusBarHeight
		toolbartemp.Height=a.GetStatusBarHeight
		toolbartemp.Top=0
		toolbartemp.Color=Colors.ARGB(100,0,39,0)
	End If


	Dim Gradient1 As GradientDrawable
	Dim Clrs(2) As Int
	Clrs(0) =Colors.ARGB(100,0,39,0)
	Clrs(1) = Colors.Transparent
	Gradient1.Initialize("TOP_BOTTOM", Clrs)
	'Force_RtlSupported4View(ACToolBarLight1)
	ACToolBarLight1.Background=Gradient1
	ACToolBarLight1.Elevation=5dip
	Dim xml As XmlLayoutBuilder
	ACToolBarLight1.NavigationIconDrawable=xml.GetDrawable("baseline_arrow_forward_white_24")
	ACToolBarLight1.InitMenuListener
	ACToolBarLight1.TitleTextColor=Colors.Transparent
	ACToolBarLight1.Title=Main.txtnewstitle


	add2toolbar_sub
	
	Img.Tag=Null
	Img.Height=Img.Height+1%x
	firstimg=""'Main.matlabimg313
	'ScrollView1.Color=Colors.ARGB(255,242,206,220)
	Img.Color=Colors.Transparent
	
	''Log(Main.matlabimg313)
	Glide.Load("http",Main.picnew).CenterCrop.Into(Img)

	
	Dim imgtemp As ImageView
	imgtemp.Initialize("img")
	ScrollView1.Panel.AddView(imgtemp,0,0,100%x,Img.Height-10%x)
	
	
	imglisnks.Initialize
	

	addtitle_sub(Main.txtnewstitle,"")
	retrofit.InitializeProgress("http://google.com/","retrofit")
	downloader.Initialize(retrofit)

	call = downloader.getFile("http://havadari.iquizland.ir/api/api.php?request=GetSingleNews&news_id="&Main.newsid)
	retrofit.enqueueCall(call,downloader.getFileCallback("retrofits","getnews"))
	

	
	Disable_ScroolbarH(ScrollView1)
	Force_LtrSupported4View(ProgressBar1)

	
	set_Ripple(flot2)
	set_Ripple(flot4)
	flot4.Visible=False
	flot3.Visible=False
	Dim ri As RichString
	ri.Initialize(Label2.Text)
	Label2.Text=ri.Color(0xFFBE1043,39,45)
	
	
	bring_Up(flot3)

	
	
	

	flot.Visible=False
	flot2.Visible=False
	flot3.Visible=False
	flot4.Visible=False
	
	c.Force_RtlSupported4View(ACToolBarLight1)
End Sub

Sub set_Ripple(label As Label)
	Dim phone1 As Phone
	If phone1.SdkVersion<21 Then
	Else
		Dim ImageViewJo As JavaObject = label
		Dim ColorState As JavaObject
		ColorState.InitializeStatic("android.content.res.ColorStateList")
		Dim RippleDrawable As JavaObject
		RippleDrawable.InitializeNewInstance("android.graphics.drawable.RippleDrawable",Array(ColorState.RunMethod("valueOf",Array(0x78000000)),Null,Null))
		ImageViewJo.RunMethod("setBackground",Array(RippleDrawable))
	End If
End Sub
Sub bring_Up(v As View)
	Dim phone1 As Phone
	If phone1.SdkVersion>20 Then
		Dim jo As JavaObject = v
		Dim elevation As Float = 8dip
		jo.RunMethod("setElevation",Array(elevation))
	Else
		v.BringToFront
	End If
End Sub
Sub showbigpik
	'ToastMessageShow(menu_Change2("برای بزرگنمایی و ذخیره کردن عکس ها روی آنها کلیک کنید.",Colors.White,C.irs),True)
End Sub
Sub Label2_Click
	Pnlprb.Visible=True
	
	Label2.Visible=False
	Label1.Visible=False
	
End Sub
Sub Disable_ScroolbarH(sv1 As ScrollView)
	Dim r As Reflector
	r.Target = sv1
	r.RunMethod2("setVerticalScrollBarEnabled", False, "java.lang.boolean")
End Sub
Sub Activity_Resume

End Sub
Sub retrofits_onFileResponse(response As ARResponse)
	Dim parser As JSONParser
	If response.isSuccessful Then
		Dim body As ARResponseBody = response.body
		Dim a As String = body.string
		
		Dim parser As JSONParser
		parser.Initialize(a)
		Dim root As Map = parser.NextObject
		Dim result As String = root.Get("result")
		Dim news As Map = root.Get("news")
		Dim thumbnail As String = news.Get("thumbnail")
		Dim images As List = news.Get("images")
		For Each colimages As String In images
		Next
		Dim has_audio As String = news.Get("has_audio")
		Dim videos As List = news.Get("videos")
		Dim title As String = news.Get("title")
		Dim content As String = news.Get("content")
		Dim has_video As String = news.Get("has_video")
		Dim manba As String = news.Get("manba")
		Dim has_image As String = news.Get("has_image")
		Dim audios As List = news.Get("audios")
		Dim rutitr As String = news.Get("rutitr")
		Dim excerpt As String = news.Get("excerpt")
		Dim views As Int = news.Get("views")
		Dim likes As Int = news.Get("likes")
		
		
		Dim lable As Label
		lable.Initialize("")
		lable.Text=Convert_FA2EN(content)

		alltext=alltext&CRLF&Convert_FA2EN(content)
		lable.Typeface=C.irs
		Dim h As Hitex_Utils
		lable.TextColor=Colors.Black
		lable.Padding=Array As Int (20dip,5dip,20dip,0)
		lable.TextSize=14
		lable.Gravity= Gravity.RIGHT
		lable.Typeface=C.irs

		ScrollView1.Panel.AddView(lable,2%x,toptemp,96%x,60%x)
		lable.Height=h.GetTextHeight(lable)+5%x
		toptemp=toptemp+lable.Height+5%x

'	imglisnks.Put(imgtemp,Starter.postimg)
	
'	If File.Exists(File.DirInternal&"/Banoo/"&foldername,name) Then
'		map = File.ReadList(File.DirInternal&"/Banoo/"&foldername,name)
		'addviewtosv_sub
		toolbar
'	Else
'		'Log(name)
'		Try
'			map = File.ReadList(File.DirAssets,"wed/"&name)
'			addviewtosv_sub
'			toolbar
'		Catch
		Pnlprb.Visible=False
		'
	
		CallSubDelayed2( Me, "Justify_Text", lable )
	End If
End Sub

Sub saato_ina(h13 As String) As String
	Dim lbl2 As String
	Dim date As String = h13.SubString2(9,19)
	Dim month As Int = h13.SubString2(12,14)
	Dim day As Int = h13.SubString2(9,11)
	Dim year As Int = h13.SubString2(15,19)
	Dim saat As Int = h13.SubString2(0,2)
	Dim minu As String = h13.SubString2(3,5)
	Dim minu2 As Int = h13.SubString2(3,5)
	Log(saat)
	Log(minu)
	
	lbl2=date.Replace("-","/") & " در "& saat&":"&minu
	Dim manam As ManamPerianDateUltimate
	If year=manam.PersianYear Then
		If month=manam.PersianMonth Then
			If day=(manam.PersianDay)-1 Then
				lbl2="دیروز در "& saat&":"&minu
			End If
			If day<(manam.PersianDay)-1 Then
				lbl2=((manam.PersianDay)-day)&" روز پیش در "& saat&":"&minu
			End If
			If day=(manam.PersianDay) Then
				If saat<(DateTime.GetHour(DateTime.Now)) Then
					lbl2=((DateTime.GetHour(DateTime.Now))-saat) & " ساعت پیش"
				Else
						
					If minu2<(DateTime.GetMinute(DateTime.Now)) Then
						lbl2=((DateTime.GetMinute(DateTime.Now))-minu2) & " دقیقه پیش"
					Else
						lbl2="همین حالا"
					End If
				End If
			End If
		End If
	End If
	Dim utils As Hitex_Utils
	Return utils.EnToFa(lbl2)
End Sub
Sub pagerlist_OnError (Error As String)
	'Log("ss"&Error)
	Pnlprb.Visible=False
	Label1.Visible=True
	Label2.Visible=True
End Sub
Sub JsonToMap(strJSON As String) As Map

	' convert a json string to a map
	Dim jMap As Map
	jMap.Initialize
	Dim JSON As JSONParser
	JSON.Initialize(strJSON)
	jMap = JSON.NextObject
	Return jMap
End Sub

Sub addtitle_sub(title As String , matn As String)
	If titletemp=False Then
		Dim lable As Label
		lable.Initialize("")
		lable.Text=title
		lable.Typeface=Typeface.CreateNew(C.irs, Typeface.STYLE_BOLD)
		lable.Color=Colors.White'.ARGB(255,245,229,231)
		lable.TextColor=Colors.ARGB(255,4,0,153)
		lable.Padding=Array As Int (20dip,0,20dip,0)
		
		lable.TextSize=23
		lable.Gravity= Gravity.RIGHT
		'lable.Color=Colors.Red
		ScrollView1.Panel.AddView(lable,2%x,toptemp,96%x,60%x)
		Dim h As Hitex_Utils
		lable.Height=h.GetTextHeight(lable)'hlbl.LabelHeight(title,lable,C.irs ,23,Gravity.RIGHT,1.2)
		lable.Height=lable.Height
		toptemp=toptemp+lable.Height
		titletemp=True
		titelhaghttemp=lable.Height
		
		Dim lable As Label
		lable.Initialize("")
		lable.Text=Chr(0xE916)
		lable.Typeface=Typeface.MATERIALICONS
		lable.TextColor=0x8B000690
		lable.Padding=Array As Int (20dip,0,20dip,0)
		ScrollView1.Panel.AddView(lable,2%x,toptemp,96%x,10%x)
		lable.Gravity= Bit.Or(Gravity.RIGHT,Gravity.CENTER)

		
		Dim lable As Label
		lable.Initialize("")
		lable.Text=saato_ina(Main.newsdate)
		lable.Typeface=C.irs
		lable.TextColor=0x8B000690
		lable.Padding=Array As Int (20dip,0,40dip,0)
		ScrollView1.Panel.AddView(lable,2%x,toptemp,96%x,10%x)
		lable.Gravity= Bit.Or(Gravity.RIGHT,Gravity.CENTER)
		toptemp=toptemp+10%x
	End If
End Sub
Sub Justify_Text(lable As Label)
	
	Private JJustify As TeamEightJustify
	
	JJustify.Initialize
	lable.text = JJustify.JustifyByExtendWords(lable, lable.Text, False, .5 , False )
	DoEvents

	'Show The Label If It Was UnVisible, + Animation
	If lable.TextColor = Colors.Transparent Then
		lable.SetTextColorAnimated(250, Colors.Black)
	End If


End Sub
Sub Activity_Pause (UserClosed As Boolean)
	
	Try
		
		ispus=False
	Catch
		'Log(LastException)
	End Try
	Try
		mpo.Release
	Catch
		'Log(LastException)
	End Try
End Sub

Sub ScrollView1_ScrollChanged(Position As Int)
	Try
		Dim x As Int
		If Position>0 And Position<500 Then
			x=Position
			Paneldark.Color=Colors.ARGB(x/2,0,0,0)
		Else if Position<3 Then
			Paneldark.Color=Colors.ARGB(0,0,0,0)
		else if  Position>500 Then
			Paneldark.Color=Colors.ARGB(255,0,0,0)
		End If
	
		If Position>0 And Position<256 Then
			x=Position
		
			Dim Gradient1 As GradientDrawable
			Dim Clrs(2) As Int
			If Position<156 Then
				Clrs(0) =Colors.ARGB(100+x,0,87,0)
				toolbartemp.Color=Colors.ARGB(100+x,0,87,0)
			Else
				Clrs(0) =0xFF005700
				toolbartemp.Color=0xFF005700
			End If
			
			Clrs(1) = Colors.ARGB(x,0,87,0)
			Gradient1.Initialize("TOP_BOTTOM", Clrs)
			ACToolBarLight1.Background=Gradient1
		
		
			'ACToolBarLight1.Color=Colors.ARGB(x,0,87,0)
			
			ACToolBarLight1.TitleTextColor=Colors.ARGB(x,255,255,255)
		Else if Position<3 Then
			Dim Gradient1 As GradientDrawable
			Dim Clrs(2) As Int
			Clrs(0) =Colors.ARGB(100,0,39,0)
			Clrs(1) = Colors.Transparent
			Gradient1.Initialize("TOP_BOTTOM", Clrs)
			ACToolBarLight1.Background=Gradient1
			toolbartemp.Color=Colors.ARGB(100,0,39,0)
			ACToolBarLight1.TitleTextColor=Colors.ARGB(0,255,255,255)
		else if  Position>500 Then
			
			Dim Gradient1 As GradientDrawable
			Dim Clrs(2) As Int
			Clrs(0) =0xFF005700
			Clrs(1) = 0xFF005700
			Gradient1.Initialize("TOP_BOTTOM", Clrs)
			ACToolBarLight1.Background=Gradient1
			toolbartemp.Color=0xFF005700
			
			ACToolBarLight1.TitleTextColor=Colors.ARGB(255,255,255,255)
			lbltoolbar.Padding = Array As Int (0, 10dip, 0, 0)
		End If
		Try
			If 56dip+((Position/3)*-1)>=10dip Then
				lbltoolbar.Padding = Array As Int (0, 56dip+((Position/3)*-1), 0, 0)
			End If
		Catch
			'Log(LastException)
		End Try
	
	
		Img.Top=(Position/2)*-1
		
		
		
	Catch
		'Log(LastException)
	End Try
End Sub
Sub menu_Change2(onvan As String,color As Int,font As Typeface) As CSBuilder
	Dim cs As CSBuilder
	cs.Initialize.Color(color).Typeface(font).Alignment("ALIGN_CENTER").Append(onvan).PopAll
	Return cs
End Sub

Sub menu_Change(onvan As String,color As Int,font As Typeface) As CSBuilder
	Dim cs As CSBuilder
	cs.Initialize.Color(color).Typeface(font).Append(onvan).PopAll
	Return cs
End Sub
Sub add2toolbar_sub
	Dim xml As XmlLayoutBuilder
'	'دکمه جستجو و علاقه مندی های تولبار

	Dim bh = xml.GetDrawable("baseline_share_white_24")  As BitmapDrawable
	Activity.AddMenuItem3(menu_Change("اشتراک گذاری",Colors.Black,C.irs), "share",bh.Bitmap, True)
	'
'	Dim bh = xml.GetDrawable("ic_zoom_in_white_24dp")  As BitmapDrawable
'	Activity.AddMenuItem3(menu_Change("بزرگ کردن متن",Colors.Black,C.irs), "zoom_in",bh.Bitmap, True)
'	
'	Dim bh = xml.GetDrawable("ic_zoom_out_white_24dp")  As BitmapDrawable
'	Activity.AddMenuItem3(menu_Change("کوچک کردن متن",Colors.Black,C.irs), "zoom_out",bh.Bitmap, True)
'	
End Sub
Sub zoom_in_Click
	fsize=fsize+2
	File.WriteString(File.DirInternal,"fsize",fsize)
	Sleep(0)

	Activity.Finish
End Sub
Sub zoom_out_Click
	fsize=fsize-2
	File.WriteString(File.DirInternal,"fsize",fsize)
	Sleep(0)

	Activity.Finish
End Sub
Sub share_Click
	Dim Aria As AriaLib
	#if fotballbartar
	StartActivity( Aria.ShareText(Main.txtnewstitle&CRLF&CRLF&alltext&CRLF&CRLF&"برگرفته از اپلیکیشن فوتبال برتر ؛"&CRLF&"https://cafebazaar.ir/app/"&Application.PackageName&"/?l=fa","اشتراک گذاری با ؛"))
	
	#else
	StartActivity( Aria.ShareText(Main.txtnewstitle&CRLF&CRLF&alltext&CRLF&CRLF&"برگرفته از اپلیکیشن هواداری ؛"&CRLF&"https://cafebazaar.ir/app/"&Application.PackageName&"/?l=fa","اشتراک گذاری با ؛"))
	
	#End If

End Sub



Sub Force_RtlSupported4View(View As View)
	Dim jA,jos As JavaObject
	jos.InitializeStatic  ("android.view.View")
	If jA.InitializeStatic  ("android.os.Build$VERSION").GetField ("SDK_INT") > 16 Then
		jA = View
		jA.RunMethod ("setLayoutDirection",Array(jos.GetField ("LAYOUT_DIRECTION_RTL")))
	End If
End Sub

Sub Convert_FA2EN(contente As String) As String
	
	Dim Res As String = contente
	Res = Res.Replace("0", "۰")
	Res = Res.Replace("1", "۱")
	Res = Res.Replace("2", "۲")
	Res = Res.Replace("3", "۳")
	Res = Res.Replace("4", "۴")
	Res = Res.Replace("5", "۵")
	Res = Res.Replace("6", "۶")
	Res = Res.Replace("7", "۷")
	Res = Res.Replace("8", "۸")
	Res = Res.Replace("9", "۹")
	Return Res

End Sub
Sub addviewtosv_sub
	canshare=True
	'Dim Title As String=CatView.itemname
	'Log(map)
	For o = 0 To map.Size-1
		
		Dim h13() As String=Regex.Split("#",map.Get(o))
		Try
			Dim Typee As String = h13(1)
		Catch
			Dim Typee As String ="TEXT"
		End Try
		
		Select Typee
			Case "IMG"
				Dim url As String =  h13(0)
				If h13(0)="http://www.beytoote.com" Or h13(0)="" Or h13(0)=Null Or h13(0)="Null" Then
					
				Else
					If firstpicshow=False Then
						firstpicshow=True
					Else
						Dim img1 As ImageView
						img1.Initialize("img")
						img1.Color=Colors.LightGray
						ScrollView1.Panel.AddView(img1,0,toptemp,100%x,60%x)
						'Glide.Load("http",url).AsBitmap.Placeholder(Main.place).Error(Main.eror).Animate.FadeIn.CenterCrop.Into(img1)
	
						imglisnks.Put(img1,url)
						
						Dim imgdori As ImageView
						imgdori.Initialize("")
						imgdori.Gravity=Gravity.FILL
'						imgdori.Bitmap=doritemp
	
						ScrollView1.Panel.AddView(imgdori,0,toptemp,100%x,60%x)
						toptemp=toptemp+60%x
					End If
				End If
			Case "CAPTION"
				
				If h13(0).Length>2 Then
					Dim txt As String =  h13(0)
					'addtitle_sub(Title)
					Dim lable As Label
					lable.Initialize("")
					lable.Text=Convert_FA2EN(txt)
					alltext=alltext&CRLF&Convert_FA2EN(txt)
					lable.Typeface=C.irs
					lable.Color=Colors.RGB(234,209,212)
					lable.TextColor=Colors.ARGB(255,22,13,108)
					lable.Padding=Array As Int (10dip,5dip,10dip,5dip)
					lable.TextSize=15
					lable.Gravity= Gravity.CENTER',Gravity.RIGHT)
	
					ScrollView1.Panel.AddView(lable,0,toptemp,100%x,60%x)
					lable.Height=hlbl.LabelHeight(Convert_FA2EN(txt),lable,C.irs,15,Gravity.CENTER,1.2)
					lable.Height=lable.Height+5dip
					toptemp=toptemp+lable.Height+5%x
				End If
			Case "TEXT"
				
				
				If h13(0).Length>2 Then
					Dim txt As String =  h13(0)
					'addtitle_sub(Title)
					Dim lable As Label
					lable.Initialize("")
					lable.Text=Convert_FA2EN(txt)
					alltext=alltext&CRLF&Convert_FA2EN(txt)
					lable.Typeface=C.irs

					lable.TextColor=Colors.Black
					lable.Padding=Array As Int (1dip,5dip,10dip,0)
					lable.TextSize=14
					lable.Gravity= Gravity.RIGHT
					ScrollView1.Panel.AddView(lable,2%x,toptemp,96%x,60%x)
					lable.Height=hlbl.LabelHeight(Convert_FA2EN(txt),lable,C.irs,14,Gravity.RIGHT,1.2)
					toptemp=toptemp+lable.Height+5%x
				End If
			Case "SUB_TITLE"
				'Log(h13(0))
				If h13(0).Length>2 Then
					Dim txt As String =  h13(0)
					'addtitle_sub(Title)
					titletemp=True
					Dim lable As Label
					lable.Initialize("")
					lable.Text=Convert_FA2EN(txt)
					alltext=alltext&CRLF&Convert_FA2EN(txt)
					lable.Typeface=C.irs

					lable.TextColor=Colors.ARGB(255,146,6,47)
					lable.Padding=Array As Int (1dip,5dip,10dip,0)
					lable.TextSize=17
					lable.Gravity= Gravity.RIGHT
					ScrollView1.Panel.AddView(lable,2%x,toptemp,96%x,60%x)
					lable.Height=hlbl.LabelHeight(Convert_FA2EN(txt),lable,C.irs,17,Gravity.RIGHT,1.2)
					toptemp=toptemp+lable.Height
				End If
			Case "TABLE"
				If h13(0).Length>2 Then
					'addtitle_sub(Title)
					titletemp=True
					Try
		
						Dim h14() As String=Regex.Split("@",h13(0))

						Dim colo As Int
						If map.IndexOf(map.Get(o)) Mod 2 = 0 Then
							colo=0xFFF7F7F7
						Else
							colo=0xFFEBEBEB
						End If
	
						Dim lable1 As Label
						lable1.Initialize("")
						lable1.Text=Convert_FA2EN(h14(0))
						lable1.Typeface=C.irs
						lable1.Color=colo
						lable1.TextColor=Colors.ARGB(255,146,6,47)
						lable1.Padding=Array As Int (1dip,5dip,10dip,0)
						lable1.TextSize=17
						lable1.Gravity= Gravity.RIGHT
						ScrollView1.Panel.AddView(lable1,0,toptemp,49.5%x,60%x)
						lable1.Height=hlbl.LabelHeight(Convert_FA2EN(h14(1)),lable1,C.irs,14,Bit.Or(Gravity.RIGHT,Gravity.CENTER),1.2)
						
	
						Dim lable As Label
						lable.Initialize("")
						lable.Text=Convert_FA2EN(h14(0))
						lable.Typeface=C.irs
						lable.Color=colo
						lable.TextColor=Colors.ARGB(255,146,6,47)
						lable.Padding=Array As Int (1dip,5dip,10dip,0)
						lable.TextSize=17
						lable.Gravity= Gravity.RIGHT
						ScrollView1.Panel.AddView(lable,50%x,toptemp,50%x,60%x)
						lable.Height=hlbl.LabelHeight(Convert_FA2EN(h14(0)),lable,C.irs,14,Bit.Or(Gravity.RIGHT,Gravity.CENTER),1.2)
						lable1.Height=lable.Height
						toptemp=toptemp+lable.Height+.5%x
	
						alltext=alltext&CRLF&h14(0)&" : "&h14(1)
					Catch
						'Log(LastException)
					End Try
				End If
		End Select
			
		
	Next

	'n.CallSubDelayedPlus(Me,"SetAllLabel",200)
End Sub
Sub toolbar
	ScrollView1.Panel.Height=toptemp+10%x
	pnlmatlab.Height=toptemp
	ACToolBarLight1.Title=Main.txtnewstitle
	
	Dim Pntool As Panel = ACToolBarLight1
	For Each v As View In Pntool
		If v Is Label Then
			lbltoolbar = v
			Select lbltoolbar.text
				Case ACToolBarLight1.title
					lbltoolbar.Typeface = C.irs
					lbltoolbar.TextSize=15
					lbltoolbar.Padding = Array As Int (0, 4dip, 0, 0)
					lbltoolbar.Color=Colors.Transparent
					lbltoolbar.Height=56dip
			End Select
		End If
	Next
	
End Sub


Sub SetAllLabel
	Try
		For Each v As View In Activity.GetAllViewsRecursive
			If GetType(v) = "android.widget.TextView" Then
				Dim lbl As Label = v
				Dim h13() As String=Regex.Split(CRLF,lbl.Text)
				Dim hhh As String
				For m = 0 To h13.Length-1
					If h13(m).Contains("بیتوته") Or h13(m).Contains("منبع") Or h13(m)="" Or h13(m)=" " Then
					Else
						hhh=hhh+h13(m)
					End If
				Next
				lbl.Text=hhh
			End If
		Next
	
	Catch
		'Log(LastException)
	End Try

End Sub
Sub Force_LtrSupported4View(View As View)
	Dim jA,jos As JavaObject
	jos.InitializeStatic  ("android.view.View")
	If jA.InitializeStatic  ("android.os.Build$VERSION").GetField ("SDK_INT") > 16 Then
		jA = View
		jA.RunMethod ("setLayoutDirection",Array(jos.GetField ("LAYOUT_DIRECTION_LTR")))
	End If
End Sub

Sub img_Click
	If canshare Then
		Dim s As ImageView = Sender
		postimg=imglisnks.Get(s)

	Else
		ToastMessageShow("باز کردن عکس قبل از بارگزاری صفحه امکان پذیر نمیباشد.",False)
	End If
	
End Sub
Sub file_onFailure(msg As String)
	'Log("ss"&msg)
	Pnlprb.Visible=False
	Label1.Visible=True
	Label2.Visible=True
End Sub

Sub from_cacht(a As String , size As Int)
	Dim parser As JSONParser
	parser.Initialize(a)
	Dim root As Map = parser.NextObject
	Dim thumbnail As String = root.Get("thumbnail")
	Dim images As List = root.Get("images")
	For Each colimages As String In images
		''Log(colimages)
	Next
	Dim title As String = root.Get("title")
	Dim contentd As String = root.Get("content")
		
	Dim cd As String

	Dim h14() As String=Regex.Split(CRLF,contentd)
	For i = 0 To h14.Length-1
			
		If h14(i).Length>1 Then
			cd=cd&CRLF&h14(i)
			'Log(h14(i))
		End If
	Next
	DoEvents

	addtitle_sub(title,"")
	Dim h13() As String=Regex.Split("<span>",c)
	For i = 0 To h13.Length-1
			
		''Log(GetImage_Path(h13(i))&"dddddddddddddddddddddddddddd")
		''Log(Getmp3_Path(h13(i))&"dddddddddddddddddddddddddddd")
		''Log(Getmp4_Path(h13(i))&"dddddddddddddddddddddddddddd")
			
		'''
			
			
			
		'''
		If h13(i).Contains(".mp3") Or h13(i).Contains(".mp4") Or h13(i).Contains("img") Or h13(i).Contains("caption") Then
			If h13(i).Contains("img") Then
				Dim url As String =  GetImage_Path(h13(i))
				If h13(i)<>""  Then
					Dim img1 As ImageView
					img1.Initialize("")
					img1.Color=Colors.Transparent
					ScrollView1.Panel.AddView(img1,0,toptemp,100%x,60%x)
						
					Dim pnl As Panel
					pnl.Initialize("")
					pnl.Color=0xC8FFFFFF
					ScrollView1.Panel.AddView(pnl,0,toptemp,100%x,60%x)
						
					Dim img12 As ImageView
					img12.Initialize("img")
					img12.Color=Colors.Transparent
					ScrollView1.Panel.AddView(img12,0,toptemp,100%x,60%x)
					
'						Dim pnklick As Panel
'						pnklick.Initialize("img")
'						pnklick.Color=Colors.Transparent
'						ScrollView1.Panel.AddView(pnklick,0,toptemp,100%x,60%x)
'						
					imglisnks.Put(img12,url)
					toptemp=toptemp+62%x
				End If
			End If
			If h13(i).Contains(".mp4") Then
'					If File.Exists(File.DirRootExternal&"/NayeNey/"&Starter.maddahname,Starter.title&".mp4") Then
'					VideoPlayer1.LoadVideo(File.DirRootExternal&"/NayeNey/"&Starter.maddahname,Starter.title&".mp4","")
'				Else
				'Log("dddd      "&Getmp4_Path(h13(i)))
				'VideoPlayer1.LoadVideo("http",Getmp4_Path(h13(i)),"")
				videolink=Getmp4_Path(h13(i))
				'StartActivity(videoplayer)
				'End If
			End If
				
				
			If h13(i).Contains(".mp3") Then
				soundurl =  Getmp3_Path(h13(i))
					
				If h13(i)<>""  Then
						
					Dim pnl As Panel
					pnl.Initialize("")
					pnl.Color=Colors.LightGray
					ScrollView1.Panel.AddView(pnl,0,toptemp,100%x,15%x)
						
					Dim ac As AppCompat
						
					Dim lblplaya As Label
					lblplaya.Initialize("")
					lblplaya.Color=0xFFBCBCBC
					ScrollView1.Panel.AddView(lblplaya,85%x,toptemp,15%x,15%x)

					Dim lbldownd As Label
					lbldownd.Initialize("")
					lbldownd.Color=0xFFBCBCBC
					ScrollView1.Panel.AddView(lbldownd,0,toptemp,15%x,15%x)
						
						
					lblplay.Initialize("lblplay")
					lblplay.Text=Chr(0xE037)
					lblplay.Typeface=Typeface.MATERIALICONS
					lblplay.Gravity=Gravity.CENTER
					lblplay.TextColor=Colors.DarkGray
					lblplay.TextSize=20
					ScrollView1.Panel.AddView(lblplay,0,toptemp,15%x,15%x)
					ac.SetClickEffect(lblplay,False)
						
					lbldown.Initialize("lbldown")
					lbldown.Text=Chr(0xE2C4)
					lbldown.Typeface=Typeface.MATERIALICONS
					lbldown.Gravity=Gravity.CENTER
					lbldown.TextColor=Colors.DarkGray
					lbldown.TextSize=20
					ac.SetClickEffect(lbldown,False)
					ScrollView1.Panel.AddView(lbldown,85%x,toptemp,15%x,15%x)
						
					lbldur.Initialize("")
					lbldur.Text="00:00"
					lbldur.Typeface=C.irs
					lbldur.Gravity=Bit.Or(Gravity.LEFT,Gravity.BOTTOM)
					lbldur.TextColor=Colors.DarkGray
					lbldur.TextSize=10
					ScrollView1.Panel.AddView(lbldur,17.5%x,toptemp,30%x,15%x)
						
					lblpos.Initialize("")
					lblpos.Text="00:00"
					lblpos.Typeface=C.irs
					lblpos.Gravity=Bit.Or(Gravity.RIGHT,Gravity.BOTTOM)
					lblpos.TextColor=Colors.DarkGray
					lblpos.TextSize=10
					ScrollView1.Panel.AddView(lblpos,52.5%x,toptemp,30%x,15%x)
						
					seekbar.Initialize("seekbar")
					ScrollView1.Panel.AddView(seekbar,15%x,toptemp,70%x,15%x)
					Force_LtrSupported4View(seekbar)
					'imglisnks.Put(img1,url)
					toptemp=toptemp+18%x
				End If
			End If
				
		Else
			If h13(i).Length>2 Then

				Dim txt As String =  h13(i)
				Dim lable As Label
				lable.Initialize("")
				lable.Text=Convert_FA2EN(txt)
				alltext=alltext&CRLF&Convert_FA2EN(txt)
				lable.Typeface=C.irs
				lable.TextColor= Colors.Transparent
				lable.Padding=Array As Int (25dip,0,25dip,0)
				lable.TextSize=size
				lable.Gravity= Gravity.RIGHT
				ScrollView1.Panel.AddView(lable,2%x,toptemp,96%x,60%x)
				lable.Height=hlbl.LabelHeight(Convert_FA2EN(lable.Text),lable,C.irs,size,Gravity.RIGHT,1.2)
				toptemp=toptemp+lable.Height
				CallSubDelayed2( Me, "Justify_Text", lable )
			End If
		End If
	Next
		
	toolbar
		
	Pnlprb.Visible=False
	canshare=True
End Sub

Sub flot2_Click

	
End Sub

Sub flot3_Click
	Dim Aria As AriaLib
	StartActivity( Aria.ShareText(Main.txtnewstitle&CRLF&CRLF&"Main.txtnews"&CRLF&CRLF&"برگرفته از اپلیکیشن هواشناسی پیشرفته ؛"&CRLF&"https://cafebazaar.ir/app/"&Application.PackageName&"/?l=fa","اشتراک گذاری با ؛"))
End Sub


#If Java
import java.util.Locale;
    public static boolean isRTL() {
        return isRTL(Locale.getDefault());
    }
    public static boolean isRTL(Locale locale) {
        final int directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
        return directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT ||
                directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC;
    }
#End If

Public Sub GetImage_Path(val As String) As String
  
	Dim l As Matcher
	l = Regex.Matcher("src\s*=\s*(.+?)""",val)
  
	Try
		Dim find As Boolean
		find = l.find
		If find = False Then Return ""
		Dim res As String
    
		res = l.Group(1)
		res = res.SubString(1)
		Return res
	Catch
		Return ""
	End Try
  
End Sub
Public Sub Getmp3_Path(val As String) As String
  
	Dim l As Matcher
	l = Regex.Matcher("mp3\s*=\s*(.+?)""",val)
  
	Try
		Dim find As Boolean
		find = l.find
		If find = False Then Return ""
		Dim res As String
    
		res = l.Group(1)
		res = res.SubString(1)
		Return res
	Catch
		Return ""
	End Try
  
End Sub
Public Sub Getmp4_Path(val As String) As String
  
	Dim l As Matcher
	l = Regex.Matcher("mp4\s*=\s*(.+?)""",val)
  
	Try
		Dim find As Boolean
		find = l.find
		If find = False Then Return ""
		Dim res As String
    
		res = l.Group(1)
		res = res.SubString(1)
		Return res
	Catch
		Return ""
	End Try
   
End Sub


Sub ConvertTicksToTimeString_sub(ta As Long) As String
	Dim  hours, minutes, seconds As Int
	hours = ta / DateTime.TicksPerHour
	minutes = (ta Mod DateTime.TicksPerHour) / DateTime.TicksPerMinute
	seconds = (ta Mod DateTime.TicksPerMinute) / DateTime.TicksPerSecond
	Return NumberFormat(minutes, 2, 0) & ":" & NumberFormat(seconds, 2, 0)
End Sub


Sub SetTextShadow(pView As View, pRadius As Float, pDx As Float, pDy As Float, pColor As Int)
	Dim ref As Reflector

	ref.Target = pView
	ref.RunMethod4("setShadowLayer", Array As Object(pRadius, pDx, pDy, pColor), Array As String("java.lang.float", "java.lang.float", "java.lang.float", "java.lang.int"))
End Sub