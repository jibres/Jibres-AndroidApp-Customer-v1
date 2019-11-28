B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.3
@EndOfDesignText@
Sub Class_Globals
	Dim lv As Hitex_LayoutView
	Dim lstnews1 As List
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize(parent As Panel,top As Int,lst As List)
	lv.Initializer("LV_news").ListView.Horizontal.RTL.Build

	lstnews1=lst
	parent.AddView(lv,0,top,100%x,73%x)

	lv.Show
End Sub

Sub LV_news_onCreateViewHolder (Parent As Panel, ViewType As Int)      '💎 onCreate 💎'
	
	Dim card As CardView
	card.Initialize("")
	card.Elevation=2dip
	card.CornerRadius=2dip
	Parent.AddView(card,1%x,1%x,44%x,71%x)
	
	Dim pnlk As Panel
	pnlk.Initialize("")
	card.AddView(pnlk,0,0,-1,-1)
	
	Dim img As ImageView
	img.Initialize("")
	pnlk.AddView(img,0,0,-1,36%x)
	
	Dim lbl As Label
	lbl.Initialize("")
	lbl.Color=Colors.White
	lbl.Gravity=Gravity.RIGHT
	lbl.Typeface=C.irs
	
	lbl.TextSize=14

	lbl.Padding = Array As Int (10dip, 0, 10dip, 0)
	pnlk.AddView(lbl,0,40%x,44%x,14%x)
	
	Dim lbl As Label
	lbl.Initialize("")
	lbl.Color=Colors.White
	lbl.Gravity=Gravity.LEFT
	lbl.Typeface=C.irs
	lbl.SingleLine=True
	lbl.Padding = Array As Int (10dip, 0, 10dip, 0)
	lbl.Ellipsize="END"
	lbl.TextSize=14
	pnlk.AddView(lbl,0,63%x,44%x,10%x)
	lbl.Text="2000 تومان"
	lbl.TextColor=0xFF006400
	
	Dim lbl2 As Label
	lbl2.Initialize("")
	lbl2.Color=Colors.Transparent
	lbl2.Gravity=Gravity.LEFT
	lbl2.Typeface=C.irs
	lbl2.SingleLine=True
	lbl2.Padding = Array As Int (10dip, 0, 10dip, 0)
	lbl2.Ellipsize="END"
	lbl2.TextSize=12
	
	pnlk.AddView(lbl2,0,58%x,44%x,10%x)
	lbl2.Text="قیمت:"
	lbl2.TextColor=0xFF9A0000

	Dim pnl As Label
	pnl.Initialize("")
	pnlk.AddView(pnl,0,55%x,100%x,1dip)
	pnl.Color=0xFFE5E5E5
End Sub
'Sub afzoodan_Click
'	Log("dd")
'	Dim lbl As Label=Sender
'	Dim Position As Int = lbl.Tag
'	Dim h13() As String=Regex.Split("#",lstnews1.Get(Position))
'	Dim id As String = h13(1)
'	
'	If Starter.sabadmap.ContainsKey(id) Then
'		Dim tedad As Int = Starter.sabadmap.Get(id)
'		Starter.sabadmap.Put(id,tedad+1)
'	Else
'		File.WriteString(File.DirInternal,id,lstnews1.Get(Position))
'		Starter.sabadmap.Put(id,1)
'	End If
'	LV_news1.notifyDataSetChanged
'	ub_sub
'End Sub
'Sub kam_Click
'	Dim lbl As Label=Sender
'	Dim Position As Int = lbl.Tag
'	Dim h13() As String=Regex.Split("#",lstnews1.Get(Position))
'	Dim id As String = h13(1)
'	If Starter.sabadmap.ContainsKey(id) Then
'		Dim tedad As Int = Starter.sabadmap.Get(id)
'		If tedad=1 Then
'			Starter.sabadmap.Remove(id)
'			File.Delete(File.DirInternal,id)
'		Else
'			Starter.sabadmap.Put(id,tedad-1)
'		End If
'	End If
'	LV_news1.notifyDataSetChanged
'	ub_sub
'End Sub

Sub LV_news_onBindViewHolder (Parent As Panel, Position As Int)         '💠 onBind 💠'
	Dim p1 As Panel = Parent.GetView(0)
	Dim p As Panel = p1.GetView(0)
	Dim img As ImageView = p.GetView(0)
	Dim Glide As Hitex_Glide
	Dim h13() As String=Regex.Split("#",lstnews1.Get(Position))
	Glide.Load2(h13(0)).CenterCrop.Into(img)
	
	Dim lbl As Label = p.GetView(1)
	lbl.Text=h13(2)
	
	Dim lbl As Label = p.GetView(2)
	lbl.Text=h13(4)&" تومان "
	
	Dim lbl As Label = p.GetView(3)
	If h13(3)<>h13(4) Then
		lbl.Text=whoops_text(h13(3)&" تومان ")
	Else
		lbl.Text=""
	End If

	

	
	
	If Position=0 Then
		Parent.Width=48%x
	Else
		Parent.Width=47%x
	End If
	
	Parent.Height=75%x
End Sub
Sub LV_news_GetItemCount As Int 								        '💯 ItemCount 💯'
	Return lstnews1.Size '/ItemList.Size
	
End Sub
Sub LV_news_ItemClick (ClickedItem As Panel, Position As Int)		'👆 ItemClick 👆'
'	Dim h13() As String=Regex.Split("#",lstnews1.Get(Position))
'		
'	Main.newsid=h13(1)
'	Main.txtnewstitle=h13(2)
'	Main.newsdate=h13(3)
'	Main.picnew=h13(0)

End Sub
Sub whoops_text(text As String) As Object
	Dim cs As CSBuilder
	cs.Initialize
	cs.Strikethrough.Append(text).Pop.PopAll
	Return  cs
End Sub