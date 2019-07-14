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
	Dim rcenter As Int = Bit.Or(Gravity.CENTER,Gravity.RIGHT)
	Dim lcenter As Int = Bit.Or(Gravity.CENTER,Gravity.LEFT)
	Dim tcenter As Int = Bit.Or(Gravity.CENTER,Gravity.TOP)
	Dim IsNoNetShow As Boolean = False
	Dim IsNoNetPrimery As Boolean = False
	
End Sub
Sub setripple(view As View,bor As Boolean)
	Dim apc As AppCompat
	apc.SetClickEffect(view,bor)
End Sub
Sub btm(name As String,img As ImageView)
	img.Bitmap=LoadBitmapSample(File.DirAssets,name,100%x,100%y)
	
End Sub
Sub show_key(ac As EditText,ev As String)
	Sleep(0)
	Dim ime As IME
	ime.Initialize(ev)
	ime.ShowKeyboard(ac)
End Sub
Sub setBacckGD As GradientDrawable
	Dim Gradient1 As GradientDrawable
	Dim Clrs(2) As Int
	Clrs(0) = 0xff54A3EC
	Clrs(1) = 0xff5433B0
	Gradient1.Initialize("TOP_BOTTOM", Clrs)
	Return Gradient1
End Sub
Sub SomUpDownFade(view As View,dur As Int,inorout As Boolean)
	If inorout=True Then
	Dim t As Int=view.Top
	view.Visible=False
	view.Top=view.Top+5%x
	view.SetLayoutAnimated(dur,view.Left,t,view.Width,view.Height)
	view.SetVisibleAnimated(dur,True)
	Else
		view.SetLayoutAnimated(dur,view.Left,view.Top+5%x,view.Width,view.Height)
		view.SetVisibleAnimated(dur,False)
		Sleep(dur)
		view.Top=view.Top-5%x
	End If
End Sub
Sub NoNetClose(pnl As Panel)
	pnl.SetVisibleAnimated(500,False)
	SomUpDownFade(pnl.GetView(0),500,False)
	IsNoNetShow=False
	IsNoNetPrimery=False
End Sub
Sub NoNet(activity As Activity , prim As Boolean) As Panel
	IsNoNetShow=True
	IsNoNetPrimery=prim
	Dim pnlnonet As Panel
	PnlCreate(pnlnonet,"",activity,0,0,-1,-1)
	pnlnonet.Color=0x78000000
	pnlnonet.Visible=False
	Dim pnla As Panel
	PnlCreate(pnla,"",pnlnonet,5%x,100%y-90%x,90%x,85%x)
	pnla.Background=Gradient(0xFFFCFCFC,0xFFFCFCFC,10dip,True)
	pnla.Elevation=4dip
	pnla.Visible=False

	Dim lav As Hitex_LottieAnimationView
	lav.Initialize("LAV")
	pnla.AddView(lav,0,-5%x,-1,50%x)
	lav.SetAnimation(File.DirAssets,"no net.json")
	lav.SetLoop(True) 'repeat
	lav.PlayAnimation
	lav.Speed=.7
	SetViewAlpha(lav,.000001)
	
	Dim lbl As Label
	setlblset(lbl,"",pnla,0,36%x,-1,10%x,"اشکال در برقراری ارتباط",Gravity.CENTER,irs,20,0xFF646464)
	
	
	Dim lbl As Label
	setlblset(lbl,"",pnla,0,48%x,-1,7%x,"از ارتباط دستگاه با اینترنت مطمئن شوید",tcenter,irs,15,0xFF646464)
	
	
	Dim lbl As Label
	setlblset(lbl,"retry",pnla,10%x,65%x,70%x,13%x,"تلاش مجدد",Gravity.CENTER,irs,15,0xFFFFFFFF)
	lbl.Background=Gradient(0xff54A3EC,0xff5433B0,10dip,False)
	pnlnonet.SetVisibleAnimated(500,True)
	SomUpDownFade(pnla,500,True)
	Return  pnlnonet 
End Sub

Sub PnlCreate(pnl As Panel,ev As String,Activity As Activity,left As Int ,top As Int,withs As Int,height As Int)
	pnl.Initialize(ev)
	Activity.AddView(pnl,left,top,withs,height)
End Sub
Sub imgCreate(img As ImageView,ev As String,Activity As Activity,left As Int ,top As Int,withs As Int,height As Int)
	img.Initialize(ev)
	img.Gravity=Gravity.FILL
	Activity.AddView(img,left,top,withs,height)
End Sub
Sub setlblset(lbl As Label,ev As String,Activity As Activity,left As Int ,top As Int,withs As Int,height As Int,text As String,grav As Int,typef As Typeface,fsize As Int,tcolor As Int)
	lbl.Initialize(ev)
	Activity.AddView(lbl,left,top,withs,height)
	lbl.Text=text
	lbl.Gravity=grav
	lbl.Typeface=typef
	lbl.TextSize=fsize
	If tcolor<> -10 Then lbl.TextColor=tcolor

End Sub
Sub setBacckGD2 As GradientDrawable
	Dim Gradient1 As GradientDrawable
	Dim Clrs(2) As Int
	Clrs(0) = 0xff54A3EC
	Clrs(1) = 0xff5433B0
	Gradient1.Initialize("TOP_BOTTOM", Clrs)
	Return Gradient1
End Sub
Sub Gradient(clr1 As Int,clr2 As Int,rad As Int,tb As Boolean) As GradientDrawable
	Dim Gradient1 As GradientDrawable
	Dim Clrs(2) As Int
	Clrs(0) = clr1
	Clrs(1) = clr2
	If tb Then Gradient1.Initialize("TOP_BOTTOM", Clrs) Else Gradient1.Initialize("LEFT_RIGHT", Clrs)
	
	Gradient1.CornerRadius=rad
	Return Gradient1
End Sub
Sub SetViewAlpha(view As View,f As Float)
	Dim f As Float = 0.5
	Dim jo As JavaObject = view
	jo.RunMethod("setAlpha",Array(f))
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

Public Sub getDeviceLanguage As String
	Dim jo As JavaObject
	jo.InitializeStatic("android.content.res.Resources")
	Return jo.RunMethodJO("getSystem",Null).RunMethodJO("getConfiguration",Null).GetFieldJO("locale").RunMethod("getLanguage",Null)
End Sub

Public Sub Dialogs_RTL (Dialog As MaterialDialogBuilder)
	Dim JO As JavaObject : JO.InitializeStatic("android.content.res.Resources")
	If JO.runmethod( "isRTL", Null ) = True Then Dialog.Show Else _
	Dialog.ContentGravity(Dialog.GRAVITY_END).ButtonsGravity(Dialog.GRAVITY_END).TitleGravity(Dialog.GRAVITY_END).ItemsGravity(Dialog.GRAVITY_END).ButtonStackedGravity(Dialog.GRAVITY_END).Show
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