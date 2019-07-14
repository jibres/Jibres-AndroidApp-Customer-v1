package b4a.example;

import java.util.Locale;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class c {
private static c mostCurrent = new c();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.keywords.constants.TypefaceWrapper _irs = null;
public static anywheresoftware.b4a.keywords.constants.TypefaceWrapper _irsb = null;
public static int _rcenter = 0;
public static int _lcenter = 0;
public static int _tcenter = 0;
public static boolean _isnonetshow = false;
public static boolean _isnonetprimery = false;
public b4a.example.main _main = null;
public b4a.example.act_tip _act_tip = null;
public b4a.example.login _login = null;
public b4a.example.verify _verify = null;
public b4a.example.home _home = null;
public b4a.example.starter _starter = null;
public b4a.example.page _page = null;
public b4a.example.finger _finger = null;
public static String  _btm(anywheresoftware.b4a.BA _ba,String _name,anywheresoftware.b4a.objects.ImageViewWrapper _img) throws Exception{
 //BA.debugLineNum = 19;BA.debugLine="Sub btm(name As String,img As ImageView)";
 //BA.debugLineNum = 20;BA.debugLine="img.Bitmap=LoadBitmapSample(File.DirAssets,name,1";
_img.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_name,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)).getObject()));
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public static String  _dialogs_rtl(anywheresoftware.b4a.BA _ba,de.amberhome.materialdialogs.MaterialDialogBuilderWrapper _dialog) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 185;BA.debugLine="Public Sub Dialogs_RTL (Dialog As MaterialDialogBu";
 //BA.debugLineNum = 186;BA.debugLine="Dim JO As JavaObject : JO.InitializeStatic(\"andro";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 186;BA.debugLine="Dim JO As JavaObject : JO.InitializeStatic(\"andro";
_jo.InitializeStatic("android.content.res.Resources");
 //BA.debugLineNum = 187;BA.debugLine="If JO.runmethod( \"isRTL\", Null ) = True Then Dial";
if ((_jo.RunMethod("isRTL",(Object[])(anywheresoftware.b4a.keywords.Common.Null))).equals((Object)(anywheresoftware.b4a.keywords.Common.True))) { 
_dialog.Show();}
else {
_dialog.ContentGravity(_dialog.GRAVITY_END).ButtonsGravity(_dialog.GRAVITY_END).TitleGravity(_dialog.GRAVITY_END).ItemsGravity(_dialog.GRAVITY_END).ButtonStackedGravity(_dialog.GRAVITY_END).Show();};
 //BA.debugLineNum = 189;BA.debugLine="End Sub";
return "";
}
public static String  _force_rtlsupported4view(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _view) throws Exception{
anywheresoftware.b4j.object.JavaObject _ja = null;
anywheresoftware.b4j.object.JavaObject _jos = null;
 //BA.debugLineNum = 151;BA.debugLine="Sub Force_RtlSupported4View(View As View)";
 //BA.debugLineNum = 152;BA.debugLine="Dim jA,jos As JavaObject";
_ja = new anywheresoftware.b4j.object.JavaObject();
_jos = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 153;BA.debugLine="jos.InitializeStatic  (\"android.view.View\")";
_jos.InitializeStatic("android.view.View");
 //BA.debugLineNum = 154;BA.debugLine="If jA.InitializeStatic  (\"android.os.Build$VERSIO";
if ((double)(BA.ObjectToNumber(_ja.InitializeStatic("android.os.Build$VERSION").GetField("SDK_INT")))>16) { 
 //BA.debugLineNum = 155;BA.debugLine="jA = View";
_ja.setObject((java.lang.Object)(_view.getObject()));
 //BA.debugLineNum = 156;BA.debugLine="jA.RunMethod (\"setLayoutDirection\",Array(jos.Get";
_ja.RunMethod("setLayoutDirection",new Object[]{_jos.GetField("LAYOUT_DIRECTION_RTL")});
 };
 //BA.debugLineNum = 158;BA.debugLine="End Sub";
return "";
}
public static String  _forceltrsupported(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _view) throws Exception{
anywheresoftware.b4j.object.JavaObject _ja = null;
anywheresoftware.b4j.object.JavaObject _jos = null;
 //BA.debugLineNum = 159;BA.debugLine="Public Sub ForceLTRSupported(View As View)";
 //BA.debugLineNum = 160;BA.debugLine="Dim jA,jos As JavaObject";
_ja = new anywheresoftware.b4j.object.JavaObject();
_jos = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 161;BA.debugLine="jos.InitializeStatic  (\"android.view.View\")";
_jos.InitializeStatic("android.view.View");
 //BA.debugLineNum = 162;BA.debugLine="If jA.InitializeStatic  (\"android.os.Build$VERSIO";
if ((double)(BA.ObjectToNumber(_ja.InitializeStatic("android.os.Build$VERSION").GetField("SDK_INT")))>16) { 
 //BA.debugLineNum = 163;BA.debugLine="jA = View";
_ja.setObject((java.lang.Object)(_view.getObject()));
 //BA.debugLineNum = 164;BA.debugLine="jA.RunMethod (\"setLayoutDirection\",Array(jos.Get";
_ja.RunMethod("setLayoutDirection",new Object[]{_jos.GetField("LAYOUT_DIRECTION_LTR")});
 };
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return "";
}
public static String  _generatekey(anywheresoftware.b4a.BA _ba) throws Exception{
String _s = "";
String _h = "";
int _i = 0;
String _j = "";
 //BA.debugLineNum = 168;BA.debugLine="Sub generatekey As String";
 //BA.debugLineNum = 169;BA.debugLine="Dim s As String = \"ABCDEFGHIJKLMNOPQRSTUVWXYZabcd";
_s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@%#0123456789";
 //BA.debugLineNum = 170;BA.debugLine="Dim h As String";
_h = "";
 //BA.debugLineNum = 171;BA.debugLine="For i = 0 To 5";
{
final int step3 = 1;
final int limit3 = (int) (5);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 172;BA.debugLine="Dim j As String";
_j = "";
 //BA.debugLineNum = 173;BA.debugLine="j=s.CharAt(Rnd(0,s.Length-1))";
_j = BA.ObjectToString(_s.charAt(anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (_s.length()-1))));
 //BA.debugLineNum = 174;BA.debugLine="h=h&j";
_h = _h+_j;
 }
};
 //BA.debugLineNum = 176;BA.debugLine="Return h";
if (true) return _h;
 //BA.debugLineNum = 177;BA.debugLine="End Sub";
return "";
}
public static String  _getdevicelanguage(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 179;BA.debugLine="Public Sub getDeviceLanguage As String";
 //BA.debugLineNum = 180;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 181;BA.debugLine="jo.InitializeStatic(\"android.content.res.Resource";
_jo.InitializeStatic("android.content.res.Resources");
 //BA.debugLineNum = 182;BA.debugLine="Return jo.RunMethodJO(\"getSystem\",Null).RunMethod";
if (true) return BA.ObjectToString(_jo.RunMethodJO("getSystem",(Object[])(anywheresoftware.b4a.keywords.Common.Null)).RunMethodJO("getConfiguration",(Object[])(anywheresoftware.b4a.keywords.Common.Null)).GetFieldJO("locale").RunMethod("getLanguage",(Object[])(anywheresoftware.b4a.keywords.Common.Null)));
 //BA.debugLineNum = 183;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.drawable.GradientDrawable  _gradient(anywheresoftware.b4a.BA _ba,int _clr1,int _clr2,int _rad,boolean _tb) throws Exception{
anywheresoftware.b4a.objects.drawable.GradientDrawable _gradient1 = null;
int[] _clrs = null;
 //BA.debugLineNum = 122;BA.debugLine="Sub Gradient(clr1 As Int,clr2 As Int,rad As Int,tb";
 //BA.debugLineNum = 123;BA.debugLine="Dim Gradient1 As GradientDrawable";
_gradient1 = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
 //BA.debugLineNum = 124;BA.debugLine="Dim Clrs(2) As Int";
_clrs = new int[(int) (2)];
;
 //BA.debugLineNum = 125;BA.debugLine="Clrs(0) = clr1";
_clrs[(int) (0)] = _clr1;
 //BA.debugLineNum = 126;BA.debugLine="Clrs(1) = clr2";
_clrs[(int) (1)] = _clr2;
 //BA.debugLineNum = 127;BA.debugLine="If tb Then Gradient1.Initialize(\"TOP_BOTTOM\", Clr";
if (_tb) { 
_gradient1.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clrs);}
else {
_gradient1.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"LEFT_RIGHT"),_clrs);};
 //BA.debugLineNum = 129;BA.debugLine="Gradient1.CornerRadius=rad";
_gradient1.setCornerRadius((float) (_rad));
 //BA.debugLineNum = 130;BA.debugLine="Return Gradient1";
if (true) return _gradient1;
 //BA.debugLineNum = 131;BA.debugLine="End Sub";
return null;
}
public static String  _imgcreate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ImageViewWrapper _img,String _ev,anywheresoftware.b4a.objects.ActivityWrapper _activity,int _left,int _top,int _withs,int _height) throws Exception{
 //BA.debugLineNum = 99;BA.debugLine="Sub imgCreate(img As ImageView,ev As String,Activi";
 //BA.debugLineNum = 100;BA.debugLine="img.Initialize(ev)";
_img.Initialize(_ba,_ev);
 //BA.debugLineNum = 101;BA.debugLine="img.Gravity=Gravity.FILL";
_img.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 102;BA.debugLine="Activity.AddView(img,left,top,withs,height)";
_activity.AddView((android.view.View)(_img.getObject()),_left,_top,_withs,_height);
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.PanelWrapper  _nonet(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity,boolean _prim) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnlnonet = null;
anywheresoftware.b4a.objects.PanelWrapper _pnla = null;
ir.hitexroid.lottie.Hitex_LottieAnimationView _lav = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 57;BA.debugLine="Sub NoNet(activity As Activity , prim As Boolean)";
 //BA.debugLineNum = 58;BA.debugLine="IsNoNetShow=True";
_isnonetshow = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 59;BA.debugLine="IsNoNetPrimery=prim";
_isnonetprimery = _prim;
 //BA.debugLineNum = 60;BA.debugLine="Dim pnlnonet As Panel";
_pnlnonet = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 61;BA.debugLine="PnlCreate(pnlnonet,\"\",activity,0,0,-1,-1)";
_pnlcreate(_ba,_pnlnonet,"",_activity,(int) (0),(int) (0),(int) (-1),(int) (-1));
 //BA.debugLineNum = 62;BA.debugLine="pnlnonet.Color=0x78000000";
_pnlnonet.setColor((int) (0x78000000));
 //BA.debugLineNum = 63;BA.debugLine="pnlnonet.Visible=False";
_pnlnonet.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 64;BA.debugLine="Dim pnla As Panel";
_pnla = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 65;BA.debugLine="PnlCreate(pnla,\"\",pnlnonet,5%x,100%y-90%x,90%x,85";
_pnlcreate(_ba,_pnla,"",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_pnlnonet.getObject())),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),_ba),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (90),_ba)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (90),_ba),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (85),_ba));
 //BA.debugLineNum = 66;BA.debugLine="pnla.Background=Gradient(0xFFFCFCFC,0xFFFCFCFC,10";
_pnla.setBackground((android.graphics.drawable.Drawable)(_gradient(_ba,(int) (0xfffcfcfc),(int) (0xfffcfcfc),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.True).getObject()));
 //BA.debugLineNum = 67;BA.debugLine="pnla.Elevation=4dip";
_pnla.setElevation((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))));
 //BA.debugLineNum = 68;BA.debugLine="pnla.Visible=False";
_pnla.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 70;BA.debugLine="Dim lav As Hitex_LottieAnimationView";
_lav = new ir.hitexroid.lottie.Hitex_LottieAnimationView();
 //BA.debugLineNum = 71;BA.debugLine="lav.Initialize(\"LAV\")";
_lav.Initialize(_ba,"LAV");
 //BA.debugLineNum = 72;BA.debugLine="pnla.AddView(lav,0,-5%x,-1,50%x)";
_pnla.AddView((android.view.View)(_lav.getObject()),(int) (0),(int) (-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),_ba)),(int) (-1),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),_ba));
 //BA.debugLineNum = 73;BA.debugLine="lav.SetAnimation(File.DirAssets,\"no net.json\")";
_lav.SetAnimation(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"no net.json");
 //BA.debugLineNum = 74;BA.debugLine="lav.SetLoop(True) 'repeat";
_lav.SetLoop(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 75;BA.debugLine="lav.PlayAnimation";
_lav.PlayAnimation();
 //BA.debugLineNum = 76;BA.debugLine="lav.Speed=.7";
_lav.setSpeed((float) (.7));
 //BA.debugLineNum = 77;BA.debugLine="SetViewAlpha(lav,.000001)";
_setviewalpha(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_lav.getObject())),(float) (.000001));
 //BA.debugLineNum = 79;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 80;BA.debugLine="setlblset(lbl,\"\",pnla,0,36%x,-1,10%x,\"اشکال در بر";
_setlblset(_ba,_lbl,"",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_pnla.getObject())),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (36),_ba),(int) (-1),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),_ba),"اشکال در برقراری ارتباط",anywheresoftware.b4a.keywords.Common.Gravity.CENTER,_irs,(int) (20),(int) (0xff646464));
 //BA.debugLineNum = 83;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 84;BA.debugLine="setlblset(lbl,\"\",pnla,0,48%x,-1,7%x,\"از ارتباط دس";
_setlblset(_ba,_lbl,"",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_pnla.getObject())),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (48),_ba),(int) (-1),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (7),_ba),"از ارتباط دستگاه با اینترنت مطمئن شوید",_tcenter,_irs,(int) (15),(int) (0xff646464));
 //BA.debugLineNum = 87;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 88;BA.debugLine="setlblset(lbl,\"retry\",pnla,10%x,65%x,70%x,13%x,\"ت";
_setlblset(_ba,_lbl,"retry",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_pnla.getObject())),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),_ba),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (65),_ba),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),_ba),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (13),_ba),"تلاش مجدد",anywheresoftware.b4a.keywords.Common.Gravity.CENTER,_irs,(int) (15),(int) (0xffffffff));
 //BA.debugLineNum = 89;BA.debugLine="lbl.Background=Gradient(0xff54A3EC,0xff5433B0,10d";
_lbl.setBackground((android.graphics.drawable.Drawable)(_gradient(_ba,(int) (0xff54a3ec),(int) (0xff5433b0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.False).getObject()));
 //BA.debugLineNum = 90;BA.debugLine="pnlnonet.SetVisibleAnimated(500,True)";
_pnlnonet.SetVisibleAnimated((int) (500),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 91;BA.debugLine="SomUpDownFade(pnla,500,True)";
_somupdownfade(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_pnla.getObject())),(int) (500),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 92;BA.debugLine="Return  pnlnonet";
if (true) return _pnlnonet;
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return null;
}
public static String  _nonetclose(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.PanelWrapper _pnl) throws Exception{
 //BA.debugLineNum = 51;BA.debugLine="Sub NoNetClose(pnl As Panel)";
 //BA.debugLineNum = 52;BA.debugLine="pnl.SetVisibleAnimated(500,False)";
_pnl.SetVisibleAnimated((int) (500),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 53;BA.debugLine="SomUpDownFade(pnl.GetView(0),500,False)";
_somupdownfade(_ba,_pnl.GetView((int) (0)),(int) (500),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 54;BA.debugLine="IsNoNetShow=False";
_isnonetshow = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 55;BA.debugLine="IsNoNetPrimery=False";
_isnonetprimery = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public static String  _pnlcreate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.PanelWrapper _pnl,String _ev,anywheresoftware.b4a.objects.ActivityWrapper _activity,int _left,int _top,int _withs,int _height) throws Exception{
 //BA.debugLineNum = 95;BA.debugLine="Sub PnlCreate(pnl As Panel,ev As String,Activity A";
 //BA.debugLineNum = 96;BA.debugLine="pnl.Initialize(ev)";
_pnl.Initialize(_ba,_ev);
 //BA.debugLineNum = 97;BA.debugLine="Activity.AddView(pnl,left,top,withs,height)";
_activity.AddView((android.view.View)(_pnl.getObject()),_left,_top,_withs,_height);
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Dim irs As Typeface = Typeface.LoadFromAssets(\"ira";
_irs = new anywheresoftware.b4a.keywords.constants.TypefaceWrapper();
_irs.setObject((android.graphics.Typeface)(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets("iransansmobile.ttf")));
 //BA.debugLineNum = 7;BA.debugLine="Dim irsb As Typeface = Typeface.CreateNew(irs, Ty";
_irsb = new anywheresoftware.b4a.keywords.constants.TypefaceWrapper();
_irsb.setObject((android.graphics.Typeface)(anywheresoftware.b4a.keywords.Common.Typeface.CreateNew((android.graphics.Typeface)(_irs.getObject()),anywheresoftware.b4a.keywords.Common.Typeface.STYLE_BOLD)));
 //BA.debugLineNum = 8;BA.debugLine="Dim rcenter As Int = Bit.Or(Gravity.CENTER,Gravit";
_rcenter = anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.CENTER,anywheresoftware.b4a.keywords.Common.Gravity.RIGHT);
 //BA.debugLineNum = 9;BA.debugLine="Dim lcenter As Int = Bit.Or(Gravity.CENTER,Gravit";
_lcenter = anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.CENTER,anywheresoftware.b4a.keywords.Common.Gravity.LEFT);
 //BA.debugLineNum = 10;BA.debugLine="Dim tcenter As Int = Bit.Or(Gravity.CENTER,Gravit";
_tcenter = anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.CENTER,anywheresoftware.b4a.keywords.Common.Gravity.TOP);
 //BA.debugLineNum = 11;BA.debugLine="Dim IsNoNetShow As Boolean = False";
_isnonetshow = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 12;BA.debugLine="Dim IsNoNetPrimery As Boolean = False";
_isnonetprimery = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.drawable.GradientDrawable  _setbacckgd(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.drawable.GradientDrawable _gradient1 = null;
int[] _clrs = null;
 //BA.debugLineNum = 29;BA.debugLine="Sub setBacckGD As GradientDrawable";
 //BA.debugLineNum = 30;BA.debugLine="Dim Gradient1 As GradientDrawable";
_gradient1 = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
 //BA.debugLineNum = 31;BA.debugLine="Dim Clrs(2) As Int";
_clrs = new int[(int) (2)];
;
 //BA.debugLineNum = 32;BA.debugLine="Clrs(0) = 0xff54A3EC";
_clrs[(int) (0)] = (int) (0xff54a3ec);
 //BA.debugLineNum = 33;BA.debugLine="Clrs(1) = 0xff5433B0";
_clrs[(int) (1)] = (int) (0xff5433b0);
 //BA.debugLineNum = 34;BA.debugLine="Gradient1.Initialize(\"TOP_BOTTOM\", Clrs)";
_gradient1.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clrs);
 //BA.debugLineNum = 35;BA.debugLine="Return Gradient1";
if (true) return _gradient1;
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.drawable.GradientDrawable  _setbacckgd2(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.drawable.GradientDrawable _gradient1 = null;
int[] _clrs = null;
 //BA.debugLineNum = 114;BA.debugLine="Sub setBacckGD2 As GradientDrawable";
 //BA.debugLineNum = 115;BA.debugLine="Dim Gradient1 As GradientDrawable";
_gradient1 = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
 //BA.debugLineNum = 116;BA.debugLine="Dim Clrs(2) As Int";
_clrs = new int[(int) (2)];
;
 //BA.debugLineNum = 117;BA.debugLine="Clrs(0) = 0xff54A3EC";
_clrs[(int) (0)] = (int) (0xff54a3ec);
 //BA.debugLineNum = 118;BA.debugLine="Clrs(1) = 0xff5433B0";
_clrs[(int) (1)] = (int) (0xff5433b0);
 //BA.debugLineNum = 119;BA.debugLine="Gradient1.Initialize(\"TOP_BOTTOM\", Clrs)";
_gradient1.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clrs);
 //BA.debugLineNum = 120;BA.debugLine="Return Gradient1";
if (true) return _gradient1;
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return null;
}
public static String  _setlblset(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.LabelWrapper _lbl,String _ev,anywheresoftware.b4a.objects.ActivityWrapper _activity,int _left,int _top,int _withs,int _height,String _text,int _grav,anywheresoftware.b4a.keywords.constants.TypefaceWrapper _typef,int _fsize,int _tcolor) throws Exception{
 //BA.debugLineNum = 104;BA.debugLine="Sub setlblset(lbl As Label,ev As String,Activity A";
 //BA.debugLineNum = 105;BA.debugLine="lbl.Initialize(ev)";
_lbl.Initialize(_ba,_ev);
 //BA.debugLineNum = 106;BA.debugLine="Activity.AddView(lbl,left,top,withs,height)";
_activity.AddView((android.view.View)(_lbl.getObject()),_left,_top,_withs,_height);
 //BA.debugLineNum = 107;BA.debugLine="lbl.Text=text";
_lbl.setText(BA.ObjectToCharSequence(_text));
 //BA.debugLineNum = 108;BA.debugLine="lbl.Gravity=grav";
_lbl.setGravity(_grav);
 //BA.debugLineNum = 109;BA.debugLine="lbl.Typeface=typef";
_lbl.setTypeface((android.graphics.Typeface)(_typef.getObject()));
 //BA.debugLineNum = 110;BA.debugLine="lbl.TextSize=fsize";
_lbl.setTextSize((float) (_fsize));
 //BA.debugLineNum = 111;BA.debugLine="If tcolor<> -10 Then lbl.TextColor=tcolor";
if (_tcolor!=-10) { 
_lbl.setTextColor(_tcolor);};
 //BA.debugLineNum = 113;BA.debugLine="End Sub";
return "";
}
public static String  _setripple(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _view,boolean _bor) throws Exception{
de.amberhome.objects.appcompat.AppCompatBase _apc = null;
 //BA.debugLineNum = 15;BA.debugLine="Sub setripple(view As View,bor As Boolean)";
 //BA.debugLineNum = 16;BA.debugLine="Dim apc As AppCompat";
_apc = new de.amberhome.objects.appcompat.AppCompatBase();
 //BA.debugLineNum = 17;BA.debugLine="apc.SetClickEffect(view,bor)";
_apc.SetClickEffect(_ba,(android.view.View)(_view.getObject()),_bor);
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public static String  _setstatusbarcolor(anywheresoftware.b4a.BA _ba,int _clr) throws Exception{
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _window = null;
 //BA.debugLineNum = 137;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
 //BA.debugLineNum = 138;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 139;BA.debugLine="If p.SdkVersion >= 21 Then";
if (_p.getSdkVersion()>=21) { 
 //BA.debugLineNum = 140;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 141;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 142;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
_window = new anywheresoftware.b4j.object.JavaObject();
_window = _jo.RunMethodJO("getWindow",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 143;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
_window.RunMethod("addFlags",new Object[]{(Object)(0x80000000)});
 //BA.debugLineNum = 144;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
_window.RunMethod("clearFlags",new Object[]{(Object)(0x04000000)});
 //BA.debugLineNum = 145;BA.debugLine="window.RunMethod(\"setNavigationBarColor\", Array(";
_window.RunMethod("setNavigationBarColor",new Object[]{(Object)(_clr)});
 };
 //BA.debugLineNum = 150;BA.debugLine="End Sub";
return "";
}
public static String  _setviewalpha(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _view,float _f) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 132;BA.debugLine="Sub SetViewAlpha(view As View,f As Float)";
 //BA.debugLineNum = 133;BA.debugLine="Dim f As Float = 0.5";
_f = (float) (0.5);
 //BA.debugLineNum = 134;BA.debugLine="Dim jo As JavaObject = view";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_view.getObject()));
 //BA.debugLineNum = 135;BA.debugLine="jo.RunMethod(\"setAlpha\",Array(f))";
_jo.RunMethod("setAlpha",new Object[]{(Object)(_f)});
 //BA.debugLineNum = 136;BA.debugLine="End Sub";
return "";
}
public static void  _show_key(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.EditTextWrapper _ac,String _ev) throws Exception{
ResumableSub_show_key rsub = new ResumableSub_show_key(null,_ba,_ac,_ev);
rsub.resume((_ba.processBA == null ? _ba : _ba.processBA), null);
}
public static class ResumableSub_show_key extends BA.ResumableSub {
public ResumableSub_show_key(b4a.example.c parent,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.EditTextWrapper _ac,String _ev) {
this.parent = parent;
this._ba = _ba;
this._ac = _ac;
this._ev = _ev;
}
b4a.example.c parent;
anywheresoftware.b4a.BA _ba;
anywheresoftware.b4a.objects.EditTextWrapper _ac;
String _ev;
anywheresoftware.b4a.objects.IME _ime = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 24;BA.debugLine="Sleep(0)";
anywheresoftware.b4a.keywords.Common.Sleep(_ba,this,(int) (0));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 25;BA.debugLine="Dim ime As IME";
_ime = new anywheresoftware.b4a.objects.IME();
 //BA.debugLineNum = 26;BA.debugLine="ime.Initialize(ev)";
_ime.Initialize(_ev);
 //BA.debugLineNum = 27;BA.debugLine="ime.ShowKeyboard(ac)";
_ime.ShowKeyboard((android.view.View)(_ac.getObject()));
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _somupdownfade(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _view,int _dur,boolean _inorout) throws Exception{
ResumableSub_SomUpDownFade rsub = new ResumableSub_SomUpDownFade(null,_ba,_view,_dur,_inorout);
rsub.resume((_ba.processBA == null ? _ba : _ba.processBA), null);
}
public static class ResumableSub_SomUpDownFade extends BA.ResumableSub {
public ResumableSub_SomUpDownFade(b4a.example.c parent,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _view,int _dur,boolean _inorout) {
this.parent = parent;
this._ba = _ba;
this._view = _view;
this._dur = _dur;
this._inorout = _inorout;
}
b4a.example.c parent;
anywheresoftware.b4a.BA _ba;
anywheresoftware.b4a.objects.ConcreteViewWrapper _view;
int _dur;
boolean _inorout;
int _t = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 38;BA.debugLine="If inorout=True Then";
if (true) break;

case 1:
//if
this.state = 6;
if (_inorout==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 //BA.debugLineNum = 39;BA.debugLine="Dim t As Int=view.Top";
_t = _view.getTop();
 //BA.debugLineNum = 40;BA.debugLine="view.Visible=False";
_view.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 41;BA.debugLine="view.Top=view.Top+5%x";
_view.setTop((int) (_view.getTop()+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),_ba)));
 //BA.debugLineNum = 42;BA.debugLine="view.SetLayoutAnimated(dur,view.Left,t,view.Width";
_view.SetLayoutAnimated(_dur,_view.getLeft(),_t,_view.getWidth(),_view.getHeight());
 //BA.debugLineNum = 43;BA.debugLine="view.SetVisibleAnimated(dur,True)";
_view.SetVisibleAnimated(_dur,anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 45;BA.debugLine="view.SetLayoutAnimated(dur,view.Left,view.Top+5%";
_view.SetLayoutAnimated(_dur,_view.getLeft(),(int) (_view.getTop()+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),_ba)),_view.getWidth(),_view.getHeight());
 //BA.debugLineNum = 46;BA.debugLine="view.SetVisibleAnimated(dur,False)";
_view.SetVisibleAnimated(_dur,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 47;BA.debugLine="Sleep(dur)";
anywheresoftware.b4a.keywords.Common.Sleep(_ba,this,_dur);
this.state = 7;
return;
case 7:
//C
this.state = 6;
;
 //BA.debugLineNum = 48;BA.debugLine="view.Top=view.Top-5%x";
_view.setTop((int) (_view.getTop()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),_ba)));
 if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
    public static boolean isRTL() {
        return isRTL(Locale.getDefault());
    }
    public static boolean isRTL(Locale locale) {
        final int directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
        return directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT ||
                directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC;
    }
}
