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
public static anywheresoftware.b4a.objects.drawable.GradientDrawable  _gradient(anywheresoftware.b4a.BA _ba,int _clr1,int _clr2,int _rad,boolean _tb) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "gradient", false))
	 {return ((anywheresoftware.b4a.objects.drawable.GradientDrawable) Debug.delegate(null, "gradient", new Object[] {_ba,_clr1,_clr2,_rad,_tb}));}
anywheresoftware.b4a.objects.drawable.GradientDrawable _gradient1 = null;
int[] _clrs = null;
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub Gradient(clr1 As Int,clr2 As Int,rad As Int,tb";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="Dim Gradient1 As GradientDrawable";
_gradient1 = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="Dim Clrs(2) As Int";
_clrs = new int[(int) (2)];
;
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="Clrs(0) = clr1";
_clrs[(int) (0)] = _clr1;
RDebugUtils.currentLine=3735556;
 //BA.debugLineNum = 3735556;BA.debugLine="Clrs(1) = clr2";
_clrs[(int) (1)] = _clr2;
RDebugUtils.currentLine=3735557;
 //BA.debugLineNum = 3735557;BA.debugLine="If tb Then Gradient1.Initialize(\"TOP_BOTTOM\", Clr";
if (_tb) { 
_gradient1.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clrs);}
else {
_gradient1.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"LEFT_RIGHT"),_clrs);};
RDebugUtils.currentLine=3735559;
 //BA.debugLineNum = 3735559;BA.debugLine="Gradient1.CornerRadius=rad";
_gradient1.setCornerRadius((float) (_rad));
RDebugUtils.currentLine=3735560;
 //BA.debugLineNum = 3735560;BA.debugLine="Return Gradient1";
if (true) return _gradient1;
RDebugUtils.currentLine=3735561;
 //BA.debugLineNum = 3735561;BA.debugLine="End Sub";
return null;
}
public static String  _getdevicelanguage(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "getdevicelanguage", false))
	 {return ((String) Debug.delegate(null, "getdevicelanguage", new Object[] {_ba}));}
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Public Sub getDeviceLanguage As String";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="jo.InitializeStatic(\"android.content.res.Resource";
_jo.InitializeStatic("android.content.res.Resources");
RDebugUtils.currentLine=4128771;
 //BA.debugLineNum = 4128771;BA.debugLine="Return jo.RunMethodJO(\"getSystem\",Null).RunMethod";
if (true) return BA.ObjectToString(_jo.RunMethodJO("getSystem",(Object[])(anywheresoftware.b4a.keywords.Common.Null)).RunMethodJO("getConfiguration",(Object[])(anywheresoftware.b4a.keywords.Common.Null)).GetFieldJO("locale").RunMethod("getLanguage",(Object[])(anywheresoftware.b4a.keywords.Common.Null)));
RDebugUtils.currentLine=4128772;
 //BA.debugLineNum = 4128772;BA.debugLine="End Sub";
return "";
}
public static String  _setlblset(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.LabelWrapper _lbl,String _ev,anywheresoftware.b4a.objects.ActivityWrapper _activity,int _left,int _top,int _withs,int _height,String _text,int _grav,anywheresoftware.b4a.keywords.constants.TypefaceWrapper _typef,int _fsize,int _tcolor) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "setlblset", false))
	 {return ((String) Debug.delegate(null, "setlblset", new Object[] {_ba,_lbl,_ev,_activity,_left,_top,_withs,_height,_text,_grav,_typef,_fsize,_tcolor}));}
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub setlblset(lbl As Label,ev As String,Activity A";
RDebugUtils.currentLine=3604481;
 //BA.debugLineNum = 3604481;BA.debugLine="lbl.Initialize(ev)";
_lbl.Initialize(_ba,_ev);
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="Activity.AddView(lbl,left,top,withs,height)";
_activity.AddView((android.view.View)(_lbl.getObject()),_left,_top,_withs,_height);
RDebugUtils.currentLine=3604483;
 //BA.debugLineNum = 3604483;BA.debugLine="lbl.Text=text";
_lbl.setText(BA.ObjectToCharSequence(_text));
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="lbl.Gravity=grav";
_lbl.setGravity(_grav);
RDebugUtils.currentLine=3604485;
 //BA.debugLineNum = 3604485;BA.debugLine="lbl.Typeface=typef";
_lbl.setTypeface((android.graphics.Typeface)(_typef.getObject()));
RDebugUtils.currentLine=3604486;
 //BA.debugLineNum = 3604486;BA.debugLine="lbl.TextSize=fsize";
_lbl.setTextSize((float) (_fsize));
RDebugUtils.currentLine=3604487;
 //BA.debugLineNum = 3604487;BA.debugLine="If tcolor<> -10 Then lbl.TextColor=tcolor";
if (_tcolor!=-10) { 
_lbl.setTextColor(_tcolor);};
RDebugUtils.currentLine=3604489;
 //BA.debugLineNum = 3604489;BA.debugLine="End Sub";
return "";
}
public static String  _pnlcreate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.PanelWrapper _pnl,String _ev,anywheresoftware.b4a.objects.ActivityWrapper _activity,int _left,int _top,int _withs,int _height) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "pnlcreate", false))
	 {return ((String) Debug.delegate(null, "pnlcreate", new Object[] {_ba,_pnl,_ev,_activity,_left,_top,_withs,_height}));}
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub PnlCreate(pnl As Panel,ev As String,Activity A";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="pnl.Initialize(ev)";
_pnl.Initialize(_ba,_ev);
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="Activity.AddView(pnl,left,top,withs,height)";
_activity.AddView((android.view.View)(_pnl.getObject()),_left,_top,_withs,_height);
RDebugUtils.currentLine=3473411;
 //BA.debugLineNum = 3473411;BA.debugLine="End Sub";
return "";
}
public static String  _nonetclose(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.PanelWrapper _pnl) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "nonetclose", false))
	 {return ((String) Debug.delegate(null, "nonetclose", new Object[] {_ba,_pnl}));}
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub NoNetClose(pnl As Panel)";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="pnl.SetVisibleAnimated(500,False)";
_pnl.SetVisibleAnimated((int) (500),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="SomUpDownFade(pnl.GetView(0),500,False)";
_somupdownfade(_ba,_pnl.GetView((int) (0)),(int) (500),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3342339;
 //BA.debugLineNum = 3342339;BA.debugLine="IsNoNetShow=False";
_isnonetshow = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=3342340;
 //BA.debugLineNum = 3342340;BA.debugLine="IsNoNetPrimery=False";
_isnonetprimery = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=3342341;
 //BA.debugLineNum = 3342341;BA.debugLine="End Sub";
return "";
}
public static String  _imgcreate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ImageViewWrapper _img,String _ev,anywheresoftware.b4a.objects.ActivityWrapper _activity,int _left,int _top,int _withs,int _height) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "imgcreate", false))
	 {return ((String) Debug.delegate(null, "imgcreate", new Object[] {_ba,_img,_ev,_activity,_left,_top,_withs,_height}));}
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub imgCreate(img As ImageView,ev As String,Activi";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="img.Initialize(ev)";
_img.Initialize(_ba,_ev);
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="img.Gravity=Gravity.FILL";
_img.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="Activity.AddView(img,left,top,withs,height)";
_activity.AddView((android.view.View)(_img.getObject()),_left,_top,_withs,_height);
RDebugUtils.currentLine=3538948;
 //BA.debugLineNum = 3538948;BA.debugLine="End Sub";
return "";
}
public static String  _force_rtlsupported4view(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _view) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "force_rtlsupported4view", false))
	 {return ((String) Debug.delegate(null, "force_rtlsupported4view", new Object[] {_ba,_view}));}
anywheresoftware.b4j.object.JavaObject _ja = null;
anywheresoftware.b4j.object.JavaObject _jos = null;
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Sub Force_RtlSupported4View(View As View)";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="Dim jA,jos As JavaObject";
_ja = new anywheresoftware.b4j.object.JavaObject();
_jos = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="jos.InitializeStatic  (\"android.view.View\")";
_jos.InitializeStatic("android.view.View");
RDebugUtils.currentLine=3932163;
 //BA.debugLineNum = 3932163;BA.debugLine="If jA.InitializeStatic  (\"android.os.Build$VERSIO";
if ((double)(BA.ObjectToNumber(_ja.InitializeStatic("android.os.Build$VERSION").GetField("SDK_INT")))>16) { 
RDebugUtils.currentLine=3932164;
 //BA.debugLineNum = 3932164;BA.debugLine="jA = View";
_ja.setObject((java.lang.Object)(_view.getObject()));
RDebugUtils.currentLine=3932165;
 //BA.debugLineNum = 3932165;BA.debugLine="jA.RunMethod (\"setLayoutDirection\",Array(jos.Get";
_ja.RunMethod("setLayoutDirection",new Object[]{_jos.GetField("LAYOUT_DIRECTION_RTL")});
 };
RDebugUtils.currentLine=3932167;
 //BA.debugLineNum = 3932167;BA.debugLine="End Sub";
return "";
}
public static String  _btm(anywheresoftware.b4a.BA _ba,String _name,anywheresoftware.b4a.objects.ImageViewWrapper _img) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "btm", false))
	 {return ((String) Debug.delegate(null, "btm", new Object[] {_ba,_name,_img}));}
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub btm(name As String,img As ImageView)";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="img.Bitmap=LoadBitmapSample(File.DirAssets,name,1";
_img.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_name,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)).getObject()));
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="End Sub";
return "";
}
public static void  _somupdownfade(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _view,int _dur,boolean _inorout) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "somupdownfade", false))
	 {Debug.delegate(null, "somupdownfade", new Object[] {_ba,_view,_dur,_inorout}); return;}
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
RDebugUtils.currentModule="c";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=3276801;
 //BA.debugLineNum = 3276801;BA.debugLine="If inorout=True Then";
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
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="Dim t As Int=view.Top";
_t = _view.getTop();
RDebugUtils.currentLine=3276803;
 //BA.debugLineNum = 3276803;BA.debugLine="view.Visible=False";
_view.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3276804;
 //BA.debugLineNum = 3276804;BA.debugLine="view.Top=view.Top+5%x";
_view.setTop((int) (_view.getTop()+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),_ba)));
RDebugUtils.currentLine=3276805;
 //BA.debugLineNum = 3276805;BA.debugLine="view.SetLayoutAnimated(dur,view.Left,t,view.Width";
_view.SetLayoutAnimated(_dur,_view.getLeft(),_t,_view.getWidth(),_view.getHeight());
RDebugUtils.currentLine=3276806;
 //BA.debugLineNum = 3276806;BA.debugLine="view.SetVisibleAnimated(dur,True)";
_view.SetVisibleAnimated(_dur,anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=3276808;
 //BA.debugLineNum = 3276808;BA.debugLine="view.SetLayoutAnimated(dur,view.Left,view.Top+5%";
_view.SetLayoutAnimated(_dur,_view.getLeft(),(int) (_view.getTop()+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),_ba)),_view.getWidth(),_view.getHeight());
RDebugUtils.currentLine=3276809;
 //BA.debugLineNum = 3276809;BA.debugLine="view.SetVisibleAnimated(dur,False)";
_view.SetVisibleAnimated(_dur,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3276810;
 //BA.debugLineNum = 3276810;BA.debugLine="Sleep(dur)";
anywheresoftware.b4a.keywords.Common.Sleep(_ba,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "c", "somupdownfade"),_dur);
this.state = 7;
return;
case 7:
//C
this.state = 6;
;
RDebugUtils.currentLine=3276811;
 //BA.debugLineNum = 3276811;BA.debugLine="view.Top=view.Top-5%x";
_view.setTop((int) (_view.getTop()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),_ba)));
 if (true) break;

case 6:
//C
this.state = -1;
;
RDebugUtils.currentLine=3276813;
 //BA.debugLineNum = 3276813;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _show_key(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.EditTextWrapper _ac,String _ev) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "show_key", false))
	 {Debug.delegate(null, "show_key", new Object[] {_ba,_ac,_ev}); return;}
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
RDebugUtils.currentModule="c";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="Sleep(0)";
anywheresoftware.b4a.keywords.Common.Sleep(_ba,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "c", "show_key"),(int) (0));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="Dim ime As IME";
_ime = new anywheresoftware.b4a.objects.IME();
RDebugUtils.currentLine=3145731;
 //BA.debugLineNum = 3145731;BA.debugLine="ime.Initialize(ev)";
_ime.Initialize(_ev);
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="ime.ShowKeyboard(ac)";
_ime.ShowKeyboard((android.view.View)(_ac.getObject()));
RDebugUtils.currentLine=3145733;
 //BA.debugLineNum = 3145733;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static float  _gettextwidth(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.LabelWrapper _label) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "gettextwidth", false))
	 {return ((Float) Debug.delegate(null, "gettextwidth", new Object[] {_ba,_label}));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvs = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Public Sub GetTextWidth(Label As Label) As Float";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="Private cvs As Canvas";
_cvs = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="bmp.InitializeMutable(1,1) 'ignore";
_bmp.InitializeMutable((int) (1),(int) (1));
RDebugUtils.currentLine=2949124;
 //BA.debugLineNum = 2949124;BA.debugLine="cvs.Initialize2(bmp)";
_cvs.Initialize2((android.graphics.Bitmap)(_bmp.getObject()));
RDebugUtils.currentLine=2949125;
 //BA.debugLineNum = 2949125;BA.debugLine="Return cvs.MeasureStringWidth(Label.Text, Label.T";
if (true) return _cvs.MeasureStringWidth(_label.getText(),_label.getTypeface(),_label.getTextSize());
RDebugUtils.currentLine=2949126;
 //BA.debugLineNum = 2949126;BA.debugLine="End Sub";
return 0f;
}
public static long  _between(anywheresoftware.b4a.BA _ba,long _t1,long _t2) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "between", false))
	 {return ((Long) Debug.delegate(null, "between", new Object[] {_ba,_t1,_t2}));}
long _t = 0L;
int _days = 0;
int _hours = 0;
int _minutes = 0;
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub between(t1 As Long,t2 As Long) As Long";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="Dim t As Long=Abs(t1-t2)";
_t = (long) (anywheresoftware.b4a.keywords.Common.Abs(_t1-_t2));
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="Dim days, hours, minutes As Int";
_days = 0;
_hours = 0;
_minutes = 0;
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="days = Floor(t / DateTime.TicksPerDay)";
_days = (int) (anywheresoftware.b4a.keywords.Common.Floor(_t/(double)anywheresoftware.b4a.keywords.Common.DateTime.TicksPerDay));
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="hours = Floor((t Mod DateTime.TicksPerDay) / Date";
_hours = (int) (anywheresoftware.b4a.keywords.Common.Floor((_t%anywheresoftware.b4a.keywords.Common.DateTime.TicksPerDay)/(double)anywheresoftware.b4a.keywords.Common.DateTime.TicksPerHour));
RDebugUtils.currentLine=2883589;
 //BA.debugLineNum = 2883589;BA.debugLine="minutes = Floor((t Mod DateTime.TicksPerHour) / D";
_minutes = (int) (anywheresoftware.b4a.keywords.Common.Floor((_t%anywheresoftware.b4a.keywords.Common.DateTime.TicksPerHour)/(double)anywheresoftware.b4a.keywords.Common.DateTime.TicksPerMinute));
RDebugUtils.currentLine=2883590;
 //BA.debugLineNum = 2883590;BA.debugLine="Return t";
if (true) return _t;
RDebugUtils.currentLine=2883592;
 //BA.debugLineNum = 2883592;BA.debugLine="End Sub";
return 0L;
}
public static String  _dialogs_rtl(anywheresoftware.b4a.BA _ba,de.amberhome.materialdialogs.MaterialDialogBuilderWrapper _dialog) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "dialogs_rtl", false))
	 {return ((String) Debug.delegate(null, "dialogs_rtl", new Object[] {_ba,_dialog}));}
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Public Sub Dialogs_RTL (Dialog As MaterialDialogBu";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="Dim JO As JavaObject : JO.InitializeStatic(\"andro";
_jo = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="Dim JO As JavaObject : JO.InitializeStatic(\"andro";
_jo.InitializeStatic("android.content.res.Resources");
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="If JO.runmethod( \"isRTL\", Null ) = True Then Dial";
if ((_jo.RunMethod("isRTL",(Object[])(anywheresoftware.b4a.keywords.Common.Null))).equals((Object)(anywheresoftware.b4a.keywords.Common.True))) { 
_dialog.Show();}
else {
_dialog.ContentGravity(_dialog.GRAVITY_END).ButtonsGravity(_dialog.GRAVITY_END).TitleGravity(_dialog.GRAVITY_END).ItemsGravity(_dialog.GRAVITY_END).ButtonStackedGravity(_dialog.GRAVITY_END).Show();};
RDebugUtils.currentLine=4194308;
 //BA.debugLineNum = 4194308;BA.debugLine="End Sub";
return "";
}
public static String  _forceltrsupported(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _view) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "forceltrsupported", false))
	 {return ((String) Debug.delegate(null, "forceltrsupported", new Object[] {_ba,_view}));}
anywheresoftware.b4j.object.JavaObject _ja = null;
anywheresoftware.b4j.object.JavaObject _jos = null;
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Public Sub ForceLTRSupported(View As View)";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="Dim jA,jos As JavaObject";
_ja = new anywheresoftware.b4j.object.JavaObject();
_jos = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="jos.InitializeStatic  (\"android.view.View\")";
_jos.InitializeStatic("android.view.View");
RDebugUtils.currentLine=3997699;
 //BA.debugLineNum = 3997699;BA.debugLine="If jA.InitializeStatic  (\"android.os.Build$VERSIO";
if ((double)(BA.ObjectToNumber(_ja.InitializeStatic("android.os.Build$VERSION").GetField("SDK_INT")))>16) { 
RDebugUtils.currentLine=3997700;
 //BA.debugLineNum = 3997700;BA.debugLine="jA = View";
_ja.setObject((java.lang.Object)(_view.getObject()));
RDebugUtils.currentLine=3997701;
 //BA.debugLineNum = 3997701;BA.debugLine="jA.RunMethod (\"setLayoutDirection\",Array(jos.Get";
_ja.RunMethod("setLayoutDirection",new Object[]{_jos.GetField("LAYOUT_DIRECTION_LTR")});
 };
RDebugUtils.currentLine=3997703;
 //BA.debugLineNum = 3997703;BA.debugLine="End Sub";
return "";
}
public static String  _generatekey(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "generatekey", false))
	 {return ((String) Debug.delegate(null, "generatekey", new Object[] {_ba}));}
String _s = "";
String _h = "";
int _i = 0;
String _j = "";
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Sub generatekey As String";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="Dim s As String = \"ABCDEFGHIJKLMNOPQRSTUVWXYZabcd";
_s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@%#0123456789";
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="Dim h As String";
_h = "";
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="For i = 0 To 5";
{
final int step3 = 1;
final int limit3 = (int) (5);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=4063236;
 //BA.debugLineNum = 4063236;BA.debugLine="Dim j As String";
_j = "";
RDebugUtils.currentLine=4063237;
 //BA.debugLineNum = 4063237;BA.debugLine="j=s.CharAt(Rnd(0,s.Length-1))";
_j = BA.ObjectToString(_s.charAt(anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (_s.length()-1))));
RDebugUtils.currentLine=4063238;
 //BA.debugLineNum = 4063238;BA.debugLine="h=h&j";
_h = _h+_j;
 }
};
RDebugUtils.currentLine=4063240;
 //BA.debugLineNum = 4063240;BA.debugLine="Return h";
if (true) return _h;
RDebugUtils.currentLine=4063241;
 //BA.debugLineNum = 4063241;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.PanelWrapper  _nonet(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity,boolean _prim) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "nonet", false))
	 {return ((anywheresoftware.b4a.objects.PanelWrapper) Debug.delegate(null, "nonet", new Object[] {_ba,_activity,_prim}));}
anywheresoftware.b4a.objects.PanelWrapper _pnlnonet = null;
anywheresoftware.b4a.objects.PanelWrapper _pnla = null;
ir.hitexroid.lottie.Hitex_LottieAnimationView _lav = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub NoNet(activity As Activity , prim As Boolean)";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="IsNoNetShow=True";
_isnonetshow = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="IsNoNetPrimery=prim";
_isnonetprimery = _prim;
RDebugUtils.currentLine=3407875;
 //BA.debugLineNum = 3407875;BA.debugLine="Dim pnlnonet As Panel";
_pnlnonet = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3407876;
 //BA.debugLineNum = 3407876;BA.debugLine="PnlCreate(pnlnonet,\"\",activity,0,0,-1,-1)";
_pnlcreate(_ba,_pnlnonet,"",_activity,(int) (0),(int) (0),(int) (-1),(int) (-1));
RDebugUtils.currentLine=3407877;
 //BA.debugLineNum = 3407877;BA.debugLine="pnlnonet.Color=0x78000000";
_pnlnonet.setColor((int) (0x78000000));
RDebugUtils.currentLine=3407878;
 //BA.debugLineNum = 3407878;BA.debugLine="pnlnonet.Visible=False";
_pnlnonet.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3407879;
 //BA.debugLineNum = 3407879;BA.debugLine="Dim pnla As Panel";
_pnla = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3407880;
 //BA.debugLineNum = 3407880;BA.debugLine="PnlCreate(pnla,\"\",pnlnonet,5%x,100%y-90%x,90%x,85";
_pnlcreate(_ba,_pnla,"",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_pnlnonet.getObject())),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),_ba),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (90),_ba)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (90),_ba),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (85),_ba));
RDebugUtils.currentLine=3407881;
 //BA.debugLineNum = 3407881;BA.debugLine="pnla.Background=Gradient(0xFFFCFCFC,0xFFFCFCFC,10";
_pnla.setBackground((android.graphics.drawable.Drawable)(_gradient(_ba,(int) (0xfffcfcfc),(int) (0xfffcfcfc),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3407882;
 //BA.debugLineNum = 3407882;BA.debugLine="pnla.Elevation=4dip";
_pnla.setElevation((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))));
RDebugUtils.currentLine=3407883;
 //BA.debugLineNum = 3407883;BA.debugLine="pnla.Visible=False";
_pnla.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3407885;
 //BA.debugLineNum = 3407885;BA.debugLine="Dim lav As Hitex_LottieAnimationView";
_lav = new ir.hitexroid.lottie.Hitex_LottieAnimationView();
RDebugUtils.currentLine=3407886;
 //BA.debugLineNum = 3407886;BA.debugLine="lav.Initialize(\"LAV\")";
_lav.Initialize(_ba,"LAV");
RDebugUtils.currentLine=3407887;
 //BA.debugLineNum = 3407887;BA.debugLine="pnla.AddView(lav,0,-5%x,-1,50%x)";
_pnla.AddView((android.view.View)(_lav.getObject()),(int) (0),(int) (-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),_ba)),(int) (-1),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),_ba));
RDebugUtils.currentLine=3407888;
 //BA.debugLineNum = 3407888;BA.debugLine="lav.SetAnimation(File.DirAssets,\"no net.json\")";
_lav.SetAnimation(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"no net.json");
RDebugUtils.currentLine=3407889;
 //BA.debugLineNum = 3407889;BA.debugLine="lav.SetLoop(True) 'repeat";
_lav.SetLoop(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3407890;
 //BA.debugLineNum = 3407890;BA.debugLine="lav.PlayAnimation";
_lav.PlayAnimation();
RDebugUtils.currentLine=3407891;
 //BA.debugLineNum = 3407891;BA.debugLine="lav.Speed=.7";
_lav.setSpeed((float) (.7));
RDebugUtils.currentLine=3407892;
 //BA.debugLineNum = 3407892;BA.debugLine="SetViewAlpha(lav,.000001)";
_setviewalpha(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_lav.getObject())),(float) (.000001));
RDebugUtils.currentLine=3407894;
 //BA.debugLineNum = 3407894;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3407895;
 //BA.debugLineNum = 3407895;BA.debugLine="setlblset(lbl,\"\",pnla,0,36%x,-1,10%x,\"اشکال در بر";
_setlblset(_ba,_lbl,"",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_pnla.getObject())),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (36),_ba),(int) (-1),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),_ba),"اشکال در برقراری ارتباط",anywheresoftware.b4a.keywords.Common.Gravity.CENTER,_irs,(int) (20),(int) (0xff646464));
RDebugUtils.currentLine=3407898;
 //BA.debugLineNum = 3407898;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3407899;
 //BA.debugLineNum = 3407899;BA.debugLine="setlblset(lbl,\"\",pnla,0,48%x,-1,7%x,\"از ارتباط دس";
_setlblset(_ba,_lbl,"",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_pnla.getObject())),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (48),_ba),(int) (-1),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (7),_ba),"از ارتباط دستگاه با اینترنت مطمئن شوید",_tcenter,_irs,(int) (15),(int) (0xff646464));
RDebugUtils.currentLine=3407902;
 //BA.debugLineNum = 3407902;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3407903;
 //BA.debugLineNum = 3407903;BA.debugLine="setlblset(lbl,\"retry\",pnla,10%x,65%x,70%x,13%x,\"ت";
_setlblset(_ba,_lbl,"retry",(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_pnla.getObject())),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),_ba),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (65),_ba),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),_ba),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (13),_ba),"تلاش مجدد",anywheresoftware.b4a.keywords.Common.Gravity.CENTER,_irs,(int) (15),(int) (0xffffffff));
RDebugUtils.currentLine=3407904;
 //BA.debugLineNum = 3407904;BA.debugLine="lbl.Background=Gradient(0xff54A3EC,0xff5433B0,10d";
_lbl.setBackground((android.graphics.drawable.Drawable)(_gradient(_ba,(int) (0xff54a3ec),(int) (0xff5433b0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.False).getObject()));
RDebugUtils.currentLine=3407905;
 //BA.debugLineNum = 3407905;BA.debugLine="pnlnonet.SetVisibleAnimated(500,True)";
_pnlnonet.SetVisibleAnimated((int) (500),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3407906;
 //BA.debugLineNum = 3407906;BA.debugLine="SomUpDownFade(pnla,500,True)";
_somupdownfade(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_pnla.getObject())),(int) (500),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3407907;
 //BA.debugLineNum = 3407907;BA.debugLine="Return  pnlnonet";
if (true) return _pnlnonet;
RDebugUtils.currentLine=3407908;
 //BA.debugLineNum = 3407908;BA.debugLine="End Sub";
return null;
}
public static String  _setviewalpha(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _view,float _f) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "setviewalpha", false))
	 {return ((String) Debug.delegate(null, "setviewalpha", new Object[] {_ba,_view,_f}));}
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Sub SetViewAlpha(view As View,f As Float)";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="Dim f As Float = 0.5";
_f = (float) (0.5);
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="Dim jo As JavaObject = view";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_view.getObject()));
RDebugUtils.currentLine=3801091;
 //BA.debugLineNum = 3801091;BA.debugLine="jo.RunMethod(\"setAlpha\",Array(f))";
_jo.RunMethod("setAlpha",new Object[]{(Object)(_f)});
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.drawable.GradientDrawable  _setbacckgd(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "setbacckgd", false))
	 {return ((anywheresoftware.b4a.objects.drawable.GradientDrawable) Debug.delegate(null, "setbacckgd", new Object[] {_ba}));}
anywheresoftware.b4a.objects.drawable.GradientDrawable _gradient1 = null;
int[] _clrs = null;
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub setBacckGD As GradientDrawable";
RDebugUtils.currentLine=3211265;
 //BA.debugLineNum = 3211265;BA.debugLine="Dim Gradient1 As GradientDrawable";
_gradient1 = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="Dim Clrs(2) As Int";
_clrs = new int[(int) (2)];
;
RDebugUtils.currentLine=3211267;
 //BA.debugLineNum = 3211267;BA.debugLine="Clrs(0) = 0xff54A3EC";
_clrs[(int) (0)] = (int) (0xff54a3ec);
RDebugUtils.currentLine=3211268;
 //BA.debugLineNum = 3211268;BA.debugLine="Clrs(1) = 0xff5433B0";
_clrs[(int) (1)] = (int) (0xff5433b0);
RDebugUtils.currentLine=3211269;
 //BA.debugLineNum = 3211269;BA.debugLine="Gradient1.Initialize(\"TOP_BOTTOM\", Clrs)";
_gradient1.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clrs);
RDebugUtils.currentLine=3211270;
 //BA.debugLineNum = 3211270;BA.debugLine="Return Gradient1";
if (true) return _gradient1;
RDebugUtils.currentLine=3211271;
 //BA.debugLineNum = 3211271;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.drawable.GradientDrawable  _setbacckgd2(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "setbacckgd2", false))
	 {return ((anywheresoftware.b4a.objects.drawable.GradientDrawable) Debug.delegate(null, "setbacckgd2", new Object[] {_ba}));}
anywheresoftware.b4a.objects.drawable.GradientDrawable _gradient1 = null;
int[] _clrs = null;
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub setBacckGD2 As GradientDrawable";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="Dim Gradient1 As GradientDrawable";
_gradient1 = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="Dim Clrs(2) As Int";
_clrs = new int[(int) (2)];
;
RDebugUtils.currentLine=3670019;
 //BA.debugLineNum = 3670019;BA.debugLine="Clrs(0) = 0xff54A3EC";
_clrs[(int) (0)] = (int) (0xff54a3ec);
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="Clrs(1) = 0xff5433B0";
_clrs[(int) (1)] = (int) (0xff5433b0);
RDebugUtils.currentLine=3670021;
 //BA.debugLineNum = 3670021;BA.debugLine="Gradient1.Initialize(\"TOP_BOTTOM\", Clrs)";
_gradient1.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clrs);
RDebugUtils.currentLine=3670022;
 //BA.debugLineNum = 3670022;BA.debugLine="Return Gradient1";
if (true) return _gradient1;
RDebugUtils.currentLine=3670023;
 //BA.debugLineNum = 3670023;BA.debugLine="End Sub";
return null;
}
public static String  _setripple(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _view,boolean _bor) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "setripple", false))
	 {return ((String) Debug.delegate(null, "setripple", new Object[] {_ba,_view,_bor}));}
de.amberhome.objects.appcompat.AppCompatBase _apc = null;
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Sub setripple(view As View,bor As Boolean)";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="Dim apc As AppCompat";
_apc = new de.amberhome.objects.appcompat.AppCompatBase();
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="apc.SetClickEffect(view,bor)";
_apc.SetClickEffect(_ba,(android.view.View)(_view.getObject()),_bor);
RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="End Sub";
return "";
}
public static String  _setstatusbarcolor(anywheresoftware.b4a.BA _ba,int _clr) throws Exception{
RDebugUtils.currentModule="c";
if (Debug.shouldDelegate(null, "setstatusbarcolor", false))
	 {return ((String) Debug.delegate(null, "setstatusbarcolor", new Object[] {_ba,_clr}));}
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _window = null;
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="If p.SdkVersion >= 21 Then";
if (_p.getSdkVersion()>=21) { 
RDebugUtils.currentLine=3866627;
 //BA.debugLineNum = 3866627;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=3866628;
 //BA.debugLineNum = 3866628;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext((_ba.processBA == null ? _ba : _ba.processBA));
RDebugUtils.currentLine=3866629;
 //BA.debugLineNum = 3866629;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
_window = new anywheresoftware.b4j.object.JavaObject();
_window = _jo.RunMethodJO("getWindow",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=3866630;
 //BA.debugLineNum = 3866630;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
_window.RunMethod("addFlags",new Object[]{(Object)(0x80000000)});
RDebugUtils.currentLine=3866631;
 //BA.debugLineNum = 3866631;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
_window.RunMethod("clearFlags",new Object[]{(Object)(0x04000000)});
RDebugUtils.currentLine=3866632;
 //BA.debugLineNum = 3866632;BA.debugLine="window.RunMethod(\"setNavigationBarColor\", Array(";
_window.RunMethod("setNavigationBarColor",new Object[]{(Object)(_clr)});
 };
RDebugUtils.currentLine=3866637;
 //BA.debugLineNum = 3866637;BA.debugLine="End Sub";
return "";
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