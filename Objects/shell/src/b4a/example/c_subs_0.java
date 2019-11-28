package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class c_subs_0 {


public static RemoteObject  _between(RemoteObject _ba,RemoteObject _t1,RemoteObject _t2) throws Exception{
try {
		Debug.PushSubsStack("between (c) ","c",5,_ba,c.mostCurrent,15);
if (RapidSub.canDelegate("between")) { return b4a.example.c.remoteMe.runUserSub(false, "c","between", _ba, _t1, _t2);}
RemoteObject _t = RemoteObject.createImmutable(0L);
RemoteObject _days = RemoteObject.createImmutable(0);
RemoteObject _hours = RemoteObject.createImmutable(0);
RemoteObject _minutes = RemoteObject.createImmutable(0);
;
Debug.locals.put("t1", _t1);
Debug.locals.put("t2", _t2);
 BA.debugLineNum = 15;BA.debugLine="Sub between(t1 As Long,t2 As Long) As Long";
Debug.ShouldStop(16384);
 BA.debugLineNum = 16;BA.debugLine="Dim t As Long=Abs(t1-t2)";
Debug.ShouldStop(32768);
_t = BA.numberCast(long.class, c.mostCurrent.__c.runMethod(true,"Abs",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_t1,_t2}, "-",1, 2)))));Debug.locals.put("t", _t);Debug.locals.put("t", _t);
 BA.debugLineNum = 17;BA.debugLine="Dim days, hours, minutes As Int";
Debug.ShouldStop(65536);
_days = RemoteObject.createImmutable(0);Debug.locals.put("days", _days);
_hours = RemoteObject.createImmutable(0);Debug.locals.put("hours", _hours);
_minutes = RemoteObject.createImmutable(0);Debug.locals.put("minutes", _minutes);
 BA.debugLineNum = 18;BA.debugLine="days = Floor(t / DateTime.TicksPerDay)";
Debug.ShouldStop(131072);
_days = BA.numberCast(int.class, c.mostCurrent.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {_t,c.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerDay")}, "/",0, 0))));Debug.locals.put("days", _days);
 BA.debugLineNum = 19;BA.debugLine="hours = Floor((t Mod DateTime.TicksPerDay) / Date";
Debug.ShouldStop(262144);
_hours = BA.numberCast(int.class, c.mostCurrent.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_t,c.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerDay")}, "%",0, 2)),c.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerHour")}, "/",0, 0))));Debug.locals.put("hours", _hours);
 BA.debugLineNum = 20;BA.debugLine="minutes = Floor((t Mod DateTime.TicksPerHour) / D";
Debug.ShouldStop(524288);
_minutes = BA.numberCast(int.class, c.mostCurrent.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_t,c.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerHour")}, "%",0, 2)),c.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerMinute")}, "/",0, 0))));Debug.locals.put("minutes", _minutes);
 BA.debugLineNum = 21;BA.debugLine="Return t";
Debug.ShouldStop(1048576);
if (true) return _t;
 BA.debugLineNum = 23;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable(0L);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btm(RemoteObject _ba,RemoteObject _name,RemoteObject _img) throws Exception{
try {
		Debug.PushSubsStack("btm (c) ","c",5,_ba,c.mostCurrent,35);
if (RapidSub.canDelegate("btm")) { return b4a.example.c.remoteMe.runUserSub(false, "c","btm", _ba, _name, _img);}
;
Debug.locals.put("name", _name);
Debug.locals.put("img", _img);
 BA.debugLineNum = 35;BA.debugLine="Sub btm(name As String,img As ImageView)";
Debug.ShouldStop(4);
 BA.debugLineNum = 36;BA.debugLine="img.Bitmap=LoadBitmapSample(File.DirAssets,name,1";
Debug.ShouldStop(8);
_img.runMethod(false,"setBitmap",(c.mostCurrent.__c.runMethod(false,"LoadBitmapSample",(Object)(c.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(_name),(Object)(c.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba)),(Object)(c.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba))).getObject()));
 BA.debugLineNum = 38;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _dialogs_rtl(RemoteObject _ba,RemoteObject _dialog) throws Exception{
try {
		Debug.PushSubsStack("Dialogs_RTL (c) ","c",5,_ba,c.mostCurrent,201);
if (RapidSub.canDelegate("dialogs_rtl")) { return b4a.example.c.remoteMe.runUserSub(false, "c","dialogs_rtl", _ba, _dialog);}
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
;
Debug.locals.put("Dialog", _dialog);
 BA.debugLineNum = 201;BA.debugLine="Public Sub Dialogs_RTL (Dialog As MaterialDialogBu";
Debug.ShouldStop(256);
 BA.debugLineNum = 202;BA.debugLine="Dim JO As JavaObject : JO.InitializeStatic(\"andro";
Debug.ShouldStop(512);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("JO", _jo);
 BA.debugLineNum = 202;BA.debugLine="Dim JO As JavaObject : JO.InitializeStatic(\"andro";
Debug.ShouldStop(512);
_jo.runVoidMethod ("InitializeStatic",(Object)(RemoteObject.createImmutable("android.content.res.Resources")));
 BA.debugLineNum = 203;BA.debugLine="If JO.runmethod( \"isRTL\", Null ) = True Then Dial";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",_jo.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("isRTL")),(Object)((c.mostCurrent.__c.getField(false,"Null")))),(c.mostCurrent.__c.getField(true,"True")))) { 
_dialog.runVoidMethod ("Show");}
else {
_dialog.runMethod(false,"ContentGravity",(Object)(_dialog.getField(false,"GRAVITY_END"))).runMethod(false,"ButtonsGravity",(Object)(_dialog.getField(false,"GRAVITY_END"))).runMethod(false,"TitleGravity",(Object)(_dialog.getField(false,"GRAVITY_END"))).runMethod(false,"ItemsGravity",(Object)(_dialog.getField(false,"GRAVITY_END"))).runMethod(false,"ButtonStackedGravity",(Object)(_dialog.getField(false,"GRAVITY_END"))).runVoidMethod ("Show");};
 BA.debugLineNum = 205;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _force_rtlsupported4view(RemoteObject _ba,RemoteObject _view) throws Exception{
try {
		Debug.PushSubsStack("Force_RtlSupported4View (c) ","c",5,_ba,c.mostCurrent,167);
if (RapidSub.canDelegate("force_rtlsupported4view")) { return b4a.example.c.remoteMe.runUserSub(false, "c","force_rtlsupported4view", _ba, _view);}
RemoteObject _ja = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _jos = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
;
Debug.locals.put("View", _view);
 BA.debugLineNum = 167;BA.debugLine="Sub Force_RtlSupported4View(View As View)";
Debug.ShouldStop(64);
 BA.debugLineNum = 168;BA.debugLine="Dim jA,jos As JavaObject";
Debug.ShouldStop(128);
_ja = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jA", _ja);
_jos = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jos", _jos);
 BA.debugLineNum = 169;BA.debugLine="jos.InitializeStatic  (\"android.view.View\")";
Debug.ShouldStop(256);
_jos.runVoidMethod ("InitializeStatic",(Object)(RemoteObject.createImmutable("android.view.View")));
 BA.debugLineNum = 170;BA.debugLine="If jA.InitializeStatic  (\"android.os.Build$VERSIO";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean(">",BA.numberCast(double.class, _ja.runMethod(false,"InitializeStatic",(Object)(RemoteObject.createImmutable("android.os.Build$VERSION"))).runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("SDK_INT")))),BA.numberCast(double.class, 16))) { 
 BA.debugLineNum = 171;BA.debugLine="jA = View";
Debug.ShouldStop(1024);
_ja.setObject(_view.getObject());
 BA.debugLineNum = 172;BA.debugLine="jA.RunMethod (\"setLayoutDirection\",Array(jos.Get";
Debug.ShouldStop(2048);
_ja.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setLayoutDirection")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {_jos.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("LAYOUT_DIRECTION_RTL")))})));
 };
 BA.debugLineNum = 174;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _forceltrsupported(RemoteObject _ba,RemoteObject _view) throws Exception{
try {
		Debug.PushSubsStack("ForceLTRSupported (c) ","c",5,_ba,c.mostCurrent,175);
if (RapidSub.canDelegate("forceltrsupported")) { return b4a.example.c.remoteMe.runUserSub(false, "c","forceltrsupported", _ba, _view);}
RemoteObject _ja = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _jos = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
;
Debug.locals.put("View", _view);
 BA.debugLineNum = 175;BA.debugLine="Public Sub ForceLTRSupported(View As View)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 176;BA.debugLine="Dim jA,jos As JavaObject";
Debug.ShouldStop(32768);
_ja = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jA", _ja);
_jos = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jos", _jos);
 BA.debugLineNum = 177;BA.debugLine="jos.InitializeStatic  (\"android.view.View\")";
Debug.ShouldStop(65536);
_jos.runVoidMethod ("InitializeStatic",(Object)(RemoteObject.createImmutable("android.view.View")));
 BA.debugLineNum = 178;BA.debugLine="If jA.InitializeStatic  (\"android.os.Build$VERSIO";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean(">",BA.numberCast(double.class, _ja.runMethod(false,"InitializeStatic",(Object)(RemoteObject.createImmutable("android.os.Build$VERSION"))).runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("SDK_INT")))),BA.numberCast(double.class, 16))) { 
 BA.debugLineNum = 179;BA.debugLine="jA = View";
Debug.ShouldStop(262144);
_ja.setObject(_view.getObject());
 BA.debugLineNum = 180;BA.debugLine="jA.RunMethod (\"setLayoutDirection\",Array(jos.Get";
Debug.ShouldStop(524288);
_ja.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setLayoutDirection")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {_jos.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("LAYOUT_DIRECTION_LTR")))})));
 };
 BA.debugLineNum = 182;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _generatekey(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("generatekey (c) ","c",5,_ba,c.mostCurrent,184);
if (RapidSub.canDelegate("generatekey")) { return b4a.example.c.remoteMe.runUserSub(false, "c","generatekey", _ba);}
RemoteObject _s = RemoteObject.createImmutable("");
RemoteObject _h = RemoteObject.createImmutable("");
int _i = 0;
RemoteObject _j = RemoteObject.createImmutable("");
;
 BA.debugLineNum = 184;BA.debugLine="Sub generatekey As String";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 185;BA.debugLine="Dim s As String = \"ABCDEFGHIJKLMNOPQRSTUVWXYZabcd";
Debug.ShouldStop(16777216);
_s = BA.ObjectToString("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@%#0123456789");Debug.locals.put("s", _s);Debug.locals.put("s", _s);
 BA.debugLineNum = 186;BA.debugLine="Dim h As String";
Debug.ShouldStop(33554432);
_h = RemoteObject.createImmutable("");Debug.locals.put("h", _h);
 BA.debugLineNum = 187;BA.debugLine="For i = 0 To 5";
Debug.ShouldStop(67108864);
{
final int step3 = 1;
final int limit3 = 5;
_i = 0 ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 188;BA.debugLine="Dim j As String";
Debug.ShouldStop(134217728);
_j = RemoteObject.createImmutable("");Debug.locals.put("j", _j);
 BA.debugLineNum = 189;BA.debugLine="j=s.CharAt(Rnd(0,s.Length-1))";
Debug.ShouldStop(268435456);
_j = BA.ObjectToString(_s.runMethod(true,"charAt",(Object)(c.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_s.runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1))))));Debug.locals.put("j", _j);
 BA.debugLineNum = 190;BA.debugLine="h=h&j";
Debug.ShouldStop(536870912);
_h = RemoteObject.concat(_h,_j);Debug.locals.put("h", _h);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 192;BA.debugLine="Return h";
Debug.ShouldStop(-2147483648);
if (true) return _h;
 BA.debugLineNum = 193;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getdevicelanguage(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("getDeviceLanguage (c) ","c",5,_ba,c.mostCurrent,195);
if (RapidSub.canDelegate("getdevicelanguage")) { return b4a.example.c.remoteMe.runUserSub(false, "c","getdevicelanguage", _ba);}
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
;
 BA.debugLineNum = 195;BA.debugLine="Public Sub getDeviceLanguage As String";
Debug.ShouldStop(4);
 BA.debugLineNum = 196;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(8);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 197;BA.debugLine="jo.InitializeStatic(\"android.content.res.Resource";
Debug.ShouldStop(16);
_jo.runVoidMethod ("InitializeStatic",(Object)(RemoteObject.createImmutable("android.content.res.Resources")));
 BA.debugLineNum = 198;BA.debugLine="Return jo.RunMethodJO(\"getSystem\",Null).RunMethod";
Debug.ShouldStop(32);
if (true) return BA.ObjectToString(_jo.runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getSystem")),(Object)((c.mostCurrent.__c.getField(false,"Null")))).runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getConfiguration")),(Object)((c.mostCurrent.__c.getField(false,"Null")))).runMethod(false,"GetFieldJO",(Object)(RemoteObject.createImmutable("locale"))).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getLanguage")),(Object)((c.mostCurrent.__c.getField(false,"Null")))));
 BA.debugLineNum = 199;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _gettextwidth(RemoteObject _ba,RemoteObject _label) throws Exception{
try {
		Debug.PushSubsStack("GetTextWidth (c) ","c",5,_ba,c.mostCurrent,24);
if (RapidSub.canDelegate("gettextwidth")) { return b4a.example.c.remoteMe.runUserSub(false, "c","gettextwidth", _ba, _label);}
RemoteObject _cvs = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
;
Debug.locals.put("Label", _label);
 BA.debugLineNum = 24;BA.debugLine="Public Sub GetTextWidth(Label As Label) As Float";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 25;BA.debugLine="Private cvs As Canvas";
Debug.ShouldStop(16777216);
_cvs = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("cvs", _cvs);
 BA.debugLineNum = 26;BA.debugLine="Dim bmp As Bitmap";
Debug.ShouldStop(33554432);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 27;BA.debugLine="bmp.InitializeMutable(1,1) 'ignore";
Debug.ShouldStop(67108864);
_bmp.runVoidMethod ("InitializeMutable",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 28;BA.debugLine="cvs.Initialize2(bmp)";
Debug.ShouldStop(134217728);
_cvs.runVoidMethod ("Initialize2",(Object)((_bmp.getObject())));
 BA.debugLineNum = 29;BA.debugLine="Return cvs.MeasureStringWidth(Label.Text, Label.T";
Debug.ShouldStop(268435456);
if (true) return _cvs.runMethod(true,"MeasureStringWidth",(Object)(_label.runMethod(true,"getText")),(Object)(_label.runMethod(false,"getTypeface")),(Object)(_label.runMethod(true,"getTextSize")));
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(0f);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _gradient(RemoteObject _ba,RemoteObject _clr1,RemoteObject _clr2,RemoteObject _rad,RemoteObject _tb) throws Exception{
try {
		Debug.PushSubsStack("Gradient (c) ","c",5,_ba,c.mostCurrent,138);
if (RapidSub.canDelegate("gradient")) { return b4a.example.c.remoteMe.runUserSub(false, "c","gradient", _ba, _clr1, _clr2, _rad, _tb);}
RemoteObject _gradient1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.GradientDrawable");
RemoteObject _clrs = null;
;
Debug.locals.put("clr1", _clr1);
Debug.locals.put("clr2", _clr2);
Debug.locals.put("rad", _rad);
Debug.locals.put("tb", _tb);
 BA.debugLineNum = 138;BA.debugLine="Sub Gradient(clr1 As Int,clr2 As Int,rad As Int,tb";
Debug.ShouldStop(512);
 BA.debugLineNum = 139;BA.debugLine="Dim Gradient1 As GradientDrawable";
Debug.ShouldStop(1024);
_gradient1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("Gradient1", _gradient1);
 BA.debugLineNum = 140;BA.debugLine="Dim Clrs(2) As Int";
Debug.ShouldStop(2048);
_clrs = RemoteObject.createNewArray ("int", new int[] {2}, new Object[]{});Debug.locals.put("Clrs", _clrs);
 BA.debugLineNum = 141;BA.debugLine="Clrs(0) = clr1";
Debug.ShouldStop(4096);
_clrs.setArrayElement (_clr1,BA.numberCast(int.class, 0));
 BA.debugLineNum = 142;BA.debugLine="Clrs(1) = clr2";
Debug.ShouldStop(8192);
_clrs.setArrayElement (_clr2,BA.numberCast(int.class, 1));
 BA.debugLineNum = 143;BA.debugLine="If tb Then Gradient1.Initialize(\"TOP_BOTTOM\", Clr";
Debug.ShouldStop(16384);
if (_tb.<Boolean>get().booleanValue()) { 
_gradient1.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"TOP_BOTTOM")),(Object)(_clrs));}
else {
_gradient1.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"LEFT_RIGHT")),(Object)(_clrs));};
 BA.debugLineNum = 145;BA.debugLine="Gradient1.CornerRadius=rad";
Debug.ShouldStop(65536);
_gradient1.runVoidMethod ("setCornerRadius",BA.numberCast(float.class, _rad));
 BA.debugLineNum = 146;BA.debugLine="Return Gradient1";
Debug.ShouldStop(131072);
if (true) return _gradient1;
 BA.debugLineNum = 147;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _imgcreate(RemoteObject _ba,RemoteObject _img,RemoteObject _ev,RemoteObject _activity,RemoteObject _left,RemoteObject _top,RemoteObject _withs,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("imgCreate (c) ","c",5,_ba,c.mostCurrent,115);
if (RapidSub.canDelegate("imgcreate")) { return b4a.example.c.remoteMe.runUserSub(false, "c","imgcreate", _ba, _img, _ev, _activity, _left, _top, _withs, _height);}
;
Debug.locals.put("img", _img);
Debug.locals.put("ev", _ev);
Debug.locals.put("Activity", _activity);
Debug.locals.put("left", _left);
Debug.locals.put("top", _top);
Debug.locals.put("withs", _withs);
Debug.locals.put("height", _height);
 BA.debugLineNum = 115;BA.debugLine="Sub imgCreate(img As ImageView,ev As String,Activi";
Debug.ShouldStop(262144);
 BA.debugLineNum = 116;BA.debugLine="img.Initialize(ev)";
Debug.ShouldStop(524288);
_img.runVoidMethod ("Initialize",_ba,(Object)(_ev));
 BA.debugLineNum = 117;BA.debugLine="img.Gravity=Gravity.FILL";
Debug.ShouldStop(1048576);
_img.runMethod(true,"setGravity",c.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 118;BA.debugLine="Activity.AddView(img,left,top,withs,height)";
Debug.ShouldStop(2097152);
_activity.runVoidMethod ("AddView",(Object)((_img.getObject())),(Object)(_left),(Object)(_top),(Object)(_withs),(Object)(_height));
 BA.debugLineNum = 119;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _nonet(RemoteObject _ba,RemoteObject _activity,RemoteObject _prim) throws Exception{
try {
		Debug.PushSubsStack("NoNet (c) ","c",5,_ba,c.mostCurrent,73);
if (RapidSub.canDelegate("nonet")) { return b4a.example.c.remoteMe.runUserSub(false, "c","nonet", _ba, _activity, _prim);}
RemoteObject _pnlnonet = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _pnla = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _lav = RemoteObject.declareNull("ir.hitexroid.lottie.Hitex_LottieAnimationView");
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
;
Debug.locals.put("activity", _activity);
Debug.locals.put("prim", _prim);
 BA.debugLineNum = 73;BA.debugLine="Sub NoNet(activity As Activity , prim As Boolean)";
Debug.ShouldStop(256);
 BA.debugLineNum = 74;BA.debugLine="IsNoNetShow=True";
Debug.ShouldStop(512);
c._isnonetshow = c.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 75;BA.debugLine="IsNoNetPrimery=prim";
Debug.ShouldStop(1024);
c._isnonetprimery = _prim;
 BA.debugLineNum = 76;BA.debugLine="Dim pnlnonet As Panel";
Debug.ShouldStop(2048);
_pnlnonet = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnlnonet", _pnlnonet);
 BA.debugLineNum = 77;BA.debugLine="PnlCreate(pnlnonet,\"\",activity,0,0,-1,-1)";
Debug.ShouldStop(4096);
_pnlcreate(_ba,_pnlnonet,BA.ObjectToString(""),_activity,BA.numberCast(int.class, 0),BA.numberCast(int.class, 0),BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, -(double) (0 + 1)));
 BA.debugLineNum = 78;BA.debugLine="pnlnonet.Color=0x78000000";
Debug.ShouldStop(8192);
_pnlnonet.runVoidMethod ("setColor",BA.numberCast(int.class, 0x78000000));
 BA.debugLineNum = 79;BA.debugLine="pnlnonet.Visible=False";
Debug.ShouldStop(16384);
_pnlnonet.runMethod(true,"setVisible",c.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 80;BA.debugLine="Dim pnla As Panel";
Debug.ShouldStop(32768);
_pnla = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnla", _pnla);
 BA.debugLineNum = 81;BA.debugLine="PnlCreate(pnla,\"\",pnlnonet,5%x,100%y-90%x,90%x,85";
Debug.ShouldStop(65536);
_pnlcreate(_ba,_pnla,BA.ObjectToString(""),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ActivityWrapper"), _pnlnonet.getObject()),c.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),_ba),RemoteObject.solve(new RemoteObject[] {c.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),c.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 90)),_ba)}, "-",1, 1),c.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 90)),_ba),c.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 85)),_ba));
 BA.debugLineNum = 82;BA.debugLine="pnla.Background=Gradient(0xFFFCFCFC,0xFFFCFCFC,10";
Debug.ShouldStop(131072);
_pnla.runMethod(false,"setBackground",(_gradient(_ba,BA.numberCast(int.class, 0xfffcfcfc),BA.numberCast(int.class, 0xfffcfcfc),c.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),c.mostCurrent.__c.getField(true,"True")).getObject()));
 BA.debugLineNum = 83;BA.debugLine="pnla.Elevation=4dip";
Debug.ShouldStop(262144);
_pnla.runMethod(true,"setElevation",BA.numberCast(float.class, c.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 4)))));
 BA.debugLineNum = 84;BA.debugLine="pnla.Visible=False";
Debug.ShouldStop(524288);
_pnla.runMethod(true,"setVisible",c.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 86;BA.debugLine="Dim lav As Hitex_LottieAnimationView";
Debug.ShouldStop(2097152);
_lav = RemoteObject.createNew ("ir.hitexroid.lottie.Hitex_LottieAnimationView");Debug.locals.put("lav", _lav);
 BA.debugLineNum = 87;BA.debugLine="lav.Initialize(\"LAV\")";
Debug.ShouldStop(4194304);
_lav.runVoidMethod ("Initialize",_ba,(Object)(RemoteObject.createImmutable("LAV")));
 BA.debugLineNum = 88;BA.debugLine="pnla.AddView(lav,0,-5%x,-1,50%x)";
Debug.ShouldStop(8388608);
_pnla.runVoidMethod ("AddView",(Object)((_lav.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, -(double) (0 + c.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),_ba).<Integer>get().intValue()))),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(c.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),_ba)));
 BA.debugLineNum = 89;BA.debugLine="lav.SetAnimation(File.DirAssets,\"no net.json\")";
Debug.ShouldStop(16777216);
_lav.runVoidMethod ("SetAnimation",(Object)(c.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("no net.json")));
 BA.debugLineNum = 90;BA.debugLine="lav.SetLoop(True) 'repeat";
Debug.ShouldStop(33554432);
_lav.runVoidMethod ("SetLoop",(Object)(c.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 91;BA.debugLine="lav.PlayAnimation";
Debug.ShouldStop(67108864);
_lav.runVoidMethod ("PlayAnimation");
 BA.debugLineNum = 92;BA.debugLine="lav.Speed=.7";
Debug.ShouldStop(134217728);
_lav.runVoidMethod ("setSpeed",BA.numberCast(float.class, .7));
 BA.debugLineNum = 93;BA.debugLine="SetViewAlpha(lav,.000001)";
Debug.ShouldStop(268435456);
_setviewalpha(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _lav.getObject()),BA.numberCast(float.class, .000001));
 BA.debugLineNum = 95;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(1073741824);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 96;BA.debugLine="setlblset(lbl,\"\",pnla,0,36%x,-1,10%x,\"اشکال در بر";
Debug.ShouldStop(-2147483648);
_setlblset(_ba,_lbl,BA.ObjectToString(""),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ActivityWrapper"), _pnla.getObject()),BA.numberCast(int.class, 0),c.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 36)),_ba),BA.numberCast(int.class, -(double) (0 + 1)),c.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),_ba),BA.ObjectToString("اشکال در برقراری ارتباط"),c.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"),c._irs,BA.numberCast(int.class, 20),BA.numberCast(int.class, 0xff646464));
 BA.debugLineNum = 99;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(4);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 100;BA.debugLine="setlblset(lbl,\"\",pnla,0,48%x,-1,7%x,\"از ارتباط دس";
Debug.ShouldStop(8);
_setlblset(_ba,_lbl,BA.ObjectToString(""),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ActivityWrapper"), _pnla.getObject()),BA.numberCast(int.class, 0),c.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 48)),_ba),BA.numberCast(int.class, -(double) (0 + 1)),c.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 7)),_ba),BA.ObjectToString("از ارتباط دستگاه با اینترنت مطمئن شوید"),c._tcenter,c._irs,BA.numberCast(int.class, 15),BA.numberCast(int.class, 0xff646464));
 BA.debugLineNum = 103;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(64);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 104;BA.debugLine="setlblset(lbl,\"retry\",pnla,10%x,65%x,70%x,13%x,\"ت";
Debug.ShouldStop(128);
_setlblset(_ba,_lbl,BA.ObjectToString("retry"),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ActivityWrapper"), _pnla.getObject()),c.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),_ba),c.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 65)),_ba),c.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 70)),_ba),c.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 13)),_ba),BA.ObjectToString("تلاش مجدد"),c.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"),c._irs,BA.numberCast(int.class, 15),BA.numberCast(int.class, 0xffffffff));
 BA.debugLineNum = 105;BA.debugLine="lbl.Background=Gradient(0xff54A3EC,0xff5433B0,10d";
Debug.ShouldStop(256);
_lbl.runMethod(false,"setBackground",(_gradient(_ba,BA.numberCast(int.class, 0xff54a3ec),BA.numberCast(int.class, 0xff5433b0),c.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),c.mostCurrent.__c.getField(true,"False")).getObject()));
 BA.debugLineNum = 106;BA.debugLine="pnlnonet.SetVisibleAnimated(500,True)";
Debug.ShouldStop(512);
_pnlnonet.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 500)),(Object)(c.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 107;BA.debugLine="SomUpDownFade(pnla,500,True)";
Debug.ShouldStop(1024);
_somupdownfade(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _pnla.getObject()),BA.numberCast(int.class, 500),c.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 108;BA.debugLine="Return  pnlnonet";
Debug.ShouldStop(2048);
if (true) return _pnlnonet;
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _nonetclose(RemoteObject _ba,RemoteObject _pnl) throws Exception{
try {
		Debug.PushSubsStack("NoNetClose (c) ","c",5,_ba,c.mostCurrent,67);
if (RapidSub.canDelegate("nonetclose")) { return b4a.example.c.remoteMe.runUserSub(false, "c","nonetclose", _ba, _pnl);}
;
Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 67;BA.debugLine="Sub NoNetClose(pnl As Panel)";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="pnl.SetVisibleAnimated(500,False)";
Debug.ShouldStop(8);
_pnl.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 500)),(Object)(c.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 69;BA.debugLine="SomUpDownFade(pnl.GetView(0),500,False)";
Debug.ShouldStop(16);
_somupdownfade(_ba,_pnl.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 0))),BA.numberCast(int.class, 500),c.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 70;BA.debugLine="IsNoNetShow=False";
Debug.ShouldStop(32);
c._isnonetshow = c.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 71;BA.debugLine="IsNoNetPrimery=False";
Debug.ShouldStop(64);
c._isnonetprimery = c.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pnlcreate(RemoteObject _ba,RemoteObject _pnl,RemoteObject _ev,RemoteObject _activity,RemoteObject _left,RemoteObject _top,RemoteObject _withs,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("PnlCreate (c) ","c",5,_ba,c.mostCurrent,111);
if (RapidSub.canDelegate("pnlcreate")) { return b4a.example.c.remoteMe.runUserSub(false, "c","pnlcreate", _ba, _pnl, _ev, _activity, _left, _top, _withs, _height);}
;
Debug.locals.put("pnl", _pnl);
Debug.locals.put("ev", _ev);
Debug.locals.put("Activity", _activity);
Debug.locals.put("left", _left);
Debug.locals.put("top", _top);
Debug.locals.put("withs", _withs);
Debug.locals.put("height", _height);
 BA.debugLineNum = 111;BA.debugLine="Sub PnlCreate(pnl As Panel,ev As String,Activity A";
Debug.ShouldStop(16384);
 BA.debugLineNum = 112;BA.debugLine="pnl.Initialize(ev)";
Debug.ShouldStop(32768);
_pnl.runVoidMethod ("Initialize",_ba,(Object)(_ev));
 BA.debugLineNum = 113;BA.debugLine="Activity.AddView(pnl,left,top,withs,height)";
Debug.ShouldStop(65536);
_activity.runVoidMethod ("AddView",(Object)((_pnl.getObject())),(Object)(_left),(Object)(_top),(Object)(_withs),(Object)(_height));
 BA.debugLineNum = 114;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Dim irs As Typeface = Typeface.LoadFromAssets(\"ir";
c._irs = RemoteObject.createNew ("anywheresoftware.b4a.keywords.constants.TypefaceWrapper");
c._irs.setObject(c.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(RemoteObject.createImmutable("iransansmobile(fanum)_light.ttf"))));
 //BA.debugLineNum = 7;BA.debugLine="Dim irsb As Typeface = Typeface.LoadFromAssets(\"i";
c._irsb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.constants.TypefaceWrapper");
c._irsb.setObject(c.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(RemoteObject.createImmutable("iransansmobile(fanum)_medium.ttf"))));
 //BA.debugLineNum = 8;BA.debugLine="Dim rcenter As Int = Bit.Or(Gravity.CENTER,Gravit";
c._rcenter = c.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(c.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),(Object)(c.mostCurrent.__c.getField(false,"Gravity").getField(true,"RIGHT")));
 //BA.debugLineNum = 9;BA.debugLine="Dim lcenter As Int = Bit.Or(Gravity.CENTER,Gravit";
c._lcenter = c.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(c.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),(Object)(c.mostCurrent.__c.getField(false,"Gravity").getField(true,"LEFT")));
 //BA.debugLineNum = 10;BA.debugLine="Dim tcenter As Int = Bit.Or(Gravity.CENTER,Gravit";
c._tcenter = c.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(c.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),(Object)(c.mostCurrent.__c.getField(false,"Gravity").getField(true,"TOP")));
 //BA.debugLineNum = 11;BA.debugLine="Dim IsNoNetShow As Boolean = False";
c._isnonetshow = c.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 12;BA.debugLine="Dim IsNoNetPrimery As Boolean = False";
c._isnonetprimery = c.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _setbacckgd(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("setBacckGD (c) ","c",5,_ba,c.mostCurrent,45);
if (RapidSub.canDelegate("setbacckgd")) { return b4a.example.c.remoteMe.runUserSub(false, "c","setbacckgd", _ba);}
RemoteObject _gradient1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.GradientDrawable");
RemoteObject _clrs = null;
;
 BA.debugLineNum = 45;BA.debugLine="Sub setBacckGD As GradientDrawable";
Debug.ShouldStop(4096);
 BA.debugLineNum = 46;BA.debugLine="Dim Gradient1 As GradientDrawable";
Debug.ShouldStop(8192);
_gradient1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("Gradient1", _gradient1);
 BA.debugLineNum = 47;BA.debugLine="Dim Clrs(2) As Int";
Debug.ShouldStop(16384);
_clrs = RemoteObject.createNewArray ("int", new int[] {2}, new Object[]{});Debug.locals.put("Clrs", _clrs);
 BA.debugLineNum = 48;BA.debugLine="Clrs(0) = 0xff54A3EC";
Debug.ShouldStop(32768);
_clrs.setArrayElement (BA.numberCast(int.class, 0xff54a3ec),BA.numberCast(int.class, 0));
 BA.debugLineNum = 49;BA.debugLine="Clrs(1) = 0xff5433B0";
Debug.ShouldStop(65536);
_clrs.setArrayElement (BA.numberCast(int.class, 0xff5433b0),BA.numberCast(int.class, 1));
 BA.debugLineNum = 50;BA.debugLine="Gradient1.Initialize(\"TOP_BOTTOM\", Clrs)";
Debug.ShouldStop(131072);
_gradient1.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"TOP_BOTTOM")),(Object)(_clrs));
 BA.debugLineNum = 51;BA.debugLine="Return Gradient1";
Debug.ShouldStop(262144);
if (true) return _gradient1;
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setbacckgd2(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("setBacckGD2 (c) ","c",5,_ba,c.mostCurrent,130);
if (RapidSub.canDelegate("setbacckgd2")) { return b4a.example.c.remoteMe.runUserSub(false, "c","setbacckgd2", _ba);}
RemoteObject _gradient1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.GradientDrawable");
RemoteObject _clrs = null;
;
 BA.debugLineNum = 130;BA.debugLine="Sub setBacckGD2 As GradientDrawable";
Debug.ShouldStop(2);
 BA.debugLineNum = 131;BA.debugLine="Dim Gradient1 As GradientDrawable";
Debug.ShouldStop(4);
_gradient1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("Gradient1", _gradient1);
 BA.debugLineNum = 132;BA.debugLine="Dim Clrs(2) As Int";
Debug.ShouldStop(8);
_clrs = RemoteObject.createNewArray ("int", new int[] {2}, new Object[]{});Debug.locals.put("Clrs", _clrs);
 BA.debugLineNum = 133;BA.debugLine="Clrs(0) = 0xff54A3EC";
Debug.ShouldStop(16);
_clrs.setArrayElement (BA.numberCast(int.class, 0xff54a3ec),BA.numberCast(int.class, 0));
 BA.debugLineNum = 134;BA.debugLine="Clrs(1) = 0xff5433B0";
Debug.ShouldStop(32);
_clrs.setArrayElement (BA.numberCast(int.class, 0xff5433b0),BA.numberCast(int.class, 1));
 BA.debugLineNum = 135;BA.debugLine="Gradient1.Initialize(\"TOP_BOTTOM\", Clrs)";
Debug.ShouldStop(64);
_gradient1.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"TOP_BOTTOM")),(Object)(_clrs));
 BA.debugLineNum = 136;BA.debugLine="Return Gradient1";
Debug.ShouldStop(128);
if (true) return _gradient1;
 BA.debugLineNum = 137;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setlblset(RemoteObject _ba,RemoteObject _lbl,RemoteObject _ev,RemoteObject _activity,RemoteObject _left,RemoteObject _top,RemoteObject _withs,RemoteObject _height,RemoteObject _text,RemoteObject _grav,RemoteObject _typef,RemoteObject _fsize,RemoteObject _tcolor) throws Exception{
try {
		Debug.PushSubsStack("setlblset (c) ","c",5,_ba,c.mostCurrent,120);
if (RapidSub.canDelegate("setlblset")) { return b4a.example.c.remoteMe.runUserSub(false, "c","setlblset", _ba, _lbl, _ev, _activity, _left, _top, _withs, _height, _text, _grav, _typef, _fsize, _tcolor);}
;
Debug.locals.put("lbl", _lbl);
Debug.locals.put("ev", _ev);
Debug.locals.put("Activity", _activity);
Debug.locals.put("left", _left);
Debug.locals.put("top", _top);
Debug.locals.put("withs", _withs);
Debug.locals.put("height", _height);
Debug.locals.put("text", _text);
Debug.locals.put("grav", _grav);
Debug.locals.put("typef", _typef);
Debug.locals.put("fsize", _fsize);
Debug.locals.put("tcolor", _tcolor);
 BA.debugLineNum = 120;BA.debugLine="Sub setlblset(lbl As Label,ev As String,Activity A";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 121;BA.debugLine="lbl.Initialize(ev)";
Debug.ShouldStop(16777216);
_lbl.runVoidMethod ("Initialize",_ba,(Object)(_ev));
 BA.debugLineNum = 122;BA.debugLine="Activity.AddView(lbl,left,top,withs,height)";
Debug.ShouldStop(33554432);
_activity.runVoidMethod ("AddView",(Object)((_lbl.getObject())),(Object)(_left),(Object)(_top),(Object)(_withs),(Object)(_height));
 BA.debugLineNum = 123;BA.debugLine="lbl.Text=text";
Debug.ShouldStop(67108864);
_lbl.runMethod(true,"setText",BA.ObjectToCharSequence(_text));
 BA.debugLineNum = 124;BA.debugLine="lbl.Gravity=grav";
Debug.ShouldStop(134217728);
_lbl.runMethod(true,"setGravity",_grav);
 BA.debugLineNum = 125;BA.debugLine="lbl.Typeface=typef";
Debug.ShouldStop(268435456);
_lbl.runMethod(false,"setTypeface",(_typef.getObject()));
 BA.debugLineNum = 126;BA.debugLine="lbl.TextSize=fsize";
Debug.ShouldStop(536870912);
_lbl.runMethod(true,"setTextSize",BA.numberCast(float.class, _fsize));
 BA.debugLineNum = 127;BA.debugLine="If tcolor<> -10 Then lbl.TextColor=tcolor";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("!",_tcolor,BA.numberCast(double.class, -(double) (0 + 10)))) { 
_lbl.runMethod(true,"setTextColor",_tcolor);};
 BA.debugLineNum = 129;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setripple(RemoteObject _ba,RemoteObject _view,RemoteObject _bor) throws Exception{
try {
		Debug.PushSubsStack("setripple (c) ","c",5,_ba,c.mostCurrent,31);
if (RapidSub.canDelegate("setripple")) { return b4a.example.c.remoteMe.runUserSub(false, "c","setripple", _ba, _view, _bor);}
RemoteObject _apc = RemoteObject.declareNull("de.amberhome.objects.appcompat.AppCompatBase");
;
Debug.locals.put("view", _view);
Debug.locals.put("bor", _bor);
 BA.debugLineNum = 31;BA.debugLine="Sub setripple(view As View,bor As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 32;BA.debugLine="Dim apc As AppCompat";
Debug.ShouldStop(-2147483648);
_apc = RemoteObject.createNew ("de.amberhome.objects.appcompat.AppCompatBase");Debug.locals.put("apc", _apc);
 BA.debugLineNum = 33;BA.debugLine="apc.SetClickEffect(view,bor)";
Debug.ShouldStop(1);
_apc.runVoidMethod ("SetClickEffect",_ba,(Object)((_view.getObject())),(Object)(_bor));
 BA.debugLineNum = 34;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setstatusbarcolor(RemoteObject _ba,RemoteObject _clr) throws Exception{
try {
		Debug.PushSubsStack("SetStatusBarColor (c) ","c",5,_ba,c.mostCurrent,153);
if (RapidSub.canDelegate("setstatusbarcolor")) { return b4a.example.c.remoteMe.runUserSub(false, "c","setstatusbarcolor", _ba, _clr);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _window = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
;
Debug.locals.put("clr", _clr);
 BA.debugLineNum = 153;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 154;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(33554432);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 155;BA.debugLine="If p.SdkVersion >= 21 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 21))) { 
 BA.debugLineNum = 156;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(134217728);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 157;BA.debugLine="jo.InitializeContext";
Debug.ShouldStop(268435456);
_jo.runVoidMethod ("InitializeContext",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba));
 BA.debugLineNum = 158;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
Debug.ShouldStop(536870912);
_window = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_window = _jo.runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getWindow")),(Object)((c.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("window", _window);Debug.locals.put("window", _window);
 BA.debugLineNum = 159;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
Debug.ShouldStop(1073741824);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("addFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x80000000))})));
 BA.debugLineNum = 160;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
Debug.ShouldStop(-2147483648);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("clearFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x04000000))})));
 BA.debugLineNum = 161;BA.debugLine="window.RunMethod(\"setNavigationBarColor\", Array(";
Debug.ShouldStop(1);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setNavigationBarColor")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_clr)})));
 };
 BA.debugLineNum = 166;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setviewalpha(RemoteObject _ba,RemoteObject _view,RemoteObject _f) throws Exception{
try {
		Debug.PushSubsStack("SetViewAlpha (c) ","c",5,_ba,c.mostCurrent,148);
if (RapidSub.canDelegate("setviewalpha")) { return b4a.example.c.remoteMe.runUserSub(false, "c","setviewalpha", _ba, _view, _f);}
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
;
Debug.locals.put("view", _view);
 BA.debugLineNum = 148;BA.debugLine="Sub SetViewAlpha(view As View,f As Float)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 149;BA.debugLine="Dim f As Float = 0.5";
Debug.ShouldStop(1048576);
_f = BA.numberCast(float.class, 0.5);Debug.locals.put("f", _f);Debug.locals.put("f", _f);
 BA.debugLineNum = 150;BA.debugLine="Dim jo As JavaObject = view";
Debug.ShouldStop(2097152);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo.setObject(_view.getObject());Debug.locals.put("jo", _jo);
 BA.debugLineNum = 151;BA.debugLine="jo.RunMethod(\"setAlpha\",Array(f))";
Debug.ShouldStop(4194304);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setAlpha")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_f)})));
 BA.debugLineNum = 152;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _show_key(RemoteObject _ba,RemoteObject _ac,RemoteObject _ev) throws Exception{
try {
		Debug.PushSubsStack("show_key (c) ","c",5,_ba,c.mostCurrent,39);
if (RapidSub.canDelegate("show_key")) { b4a.example.c.remoteMe.runUserSub(false, "c","show_key", _ba, _ac, _ev); return;}
ResumableSub_show_key rsub = new ResumableSub_show_key(null,_ba,_ac,_ev);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_show_key extends BA.ResumableSub {
public ResumableSub_show_key(b4a.example.c parent,RemoteObject _ba,RemoteObject _ac,RemoteObject _ev) {
this.parent = parent;
this._ba = _ba;
this._ac = _ac;
this._ev = _ev;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.c parent;
RemoteObject _ba;
RemoteObject _ac;
RemoteObject _ev;
RemoteObject _ime = RemoteObject.declareNull("anywheresoftware.b4a.objects.IME");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("show_key (c) ","c",5,_ba,c.mostCurrent,39);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
;
Debug.locals.put("ac", _ac);
Debug.locals.put("ev", _ev);
 BA.debugLineNum = 40;BA.debugLine="Sleep(0)";
Debug.ShouldStop(128);
parent.mostCurrent.__c.runVoidMethod ("Sleep",_ba,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "c", "show_key"),BA.numberCast(int.class, 0));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 BA.debugLineNum = 41;BA.debugLine="Dim ime As IME";
Debug.ShouldStop(256);
_ime = RemoteObject.createNew ("anywheresoftware.b4a.objects.IME");Debug.locals.put("ime", _ime);
 BA.debugLineNum = 42;BA.debugLine="ime.Initialize(ev)";
Debug.ShouldStop(512);
_ime.runVoidMethod ("Initialize",(Object)(_ev));
 BA.debugLineNum = 43;BA.debugLine="ime.ShowKeyboard(ac)";
Debug.ShouldStop(1024);
_ime.runVoidMethod ("ShowKeyboard",(Object)((_ac.getObject())));
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _somupdownfade(RemoteObject _ba,RemoteObject _view,RemoteObject _dur,RemoteObject _inorout) throws Exception{
try {
		Debug.PushSubsStack("SomUpDownFade (c) ","c",5,_ba,c.mostCurrent,53);
if (RapidSub.canDelegate("somupdownfade")) { b4a.example.c.remoteMe.runUserSub(false, "c","somupdownfade", _ba, _view, _dur, _inorout); return;}
ResumableSub_SomUpDownFade rsub = new ResumableSub_SomUpDownFade(null,_ba,_view,_dur,_inorout);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_SomUpDownFade extends BA.ResumableSub {
public ResumableSub_SomUpDownFade(b4a.example.c parent,RemoteObject _ba,RemoteObject _view,RemoteObject _dur,RemoteObject _inorout) {
this.parent = parent;
this._ba = _ba;
this._view = _view;
this._dur = _dur;
this._inorout = _inorout;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.c parent;
RemoteObject _ba;
RemoteObject _view;
RemoteObject _dur;
RemoteObject _inorout;
RemoteObject _t = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("SomUpDownFade (c) ","c",5,_ba,c.mostCurrent,53);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
;
Debug.locals.put("view", _view);
Debug.locals.put("dur", _dur);
Debug.locals.put("inorout", _inorout);
 BA.debugLineNum = 54;BA.debugLine="If inorout=True Then";
Debug.ShouldStop(2097152);
if (true) break;

case 1:
//if
this.state = 6;
if (RemoteObject.solveBoolean("=",_inorout,parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 BA.debugLineNum = 55;BA.debugLine="Dim t As Int=view.Top";
Debug.ShouldStop(4194304);
_t = _view.runMethod(true,"getTop");Debug.locals.put("t", _t);Debug.locals.put("t", _t);
 BA.debugLineNum = 56;BA.debugLine="view.Visible=False";
Debug.ShouldStop(8388608);
_view.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 57;BA.debugLine="view.Top=view.Top+5%x";
Debug.ShouldStop(16777216);
_view.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_view.runMethod(true,"getTop"),parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),_ba)}, "+",1, 1));
 BA.debugLineNum = 58;BA.debugLine="view.SetLayoutAnimated(dur,view.Left,t,view.Width";
Debug.ShouldStop(33554432);
_view.runVoidMethod ("SetLayoutAnimated",(Object)(_dur),(Object)(_view.runMethod(true,"getLeft")),(Object)(_t),(Object)(_view.runMethod(true,"getWidth")),(Object)(_view.runMethod(true,"getHeight")));
 BA.debugLineNum = 59;BA.debugLine="view.SetVisibleAnimated(dur,True)";
Debug.ShouldStop(67108864);
_view.runVoidMethod ("SetVisibleAnimated",(Object)(_dur),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 5:
//C
this.state = 6;
 BA.debugLineNum = 61;BA.debugLine="view.SetLayoutAnimated(dur,view.Left,view.Top+5%";
Debug.ShouldStop(268435456);
_view.runVoidMethod ("SetLayoutAnimated",(Object)(_dur),(Object)(_view.runMethod(true,"getLeft")),(Object)(RemoteObject.solve(new RemoteObject[] {_view.runMethod(true,"getTop"),parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),_ba)}, "+",1, 1)),(Object)(_view.runMethod(true,"getWidth")),(Object)(_view.runMethod(true,"getHeight")));
 BA.debugLineNum = 62;BA.debugLine="view.SetVisibleAnimated(dur,False)";
Debug.ShouldStop(536870912);
_view.runVoidMethod ("SetVisibleAnimated",(Object)(_dur),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 63;BA.debugLine="Sleep(dur)";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("Sleep",_ba,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "c", "somupdownfade"),_dur);
this.state = 7;
return;
case 7:
//C
this.state = 6;
;
 BA.debugLineNum = 64;BA.debugLine="view.Top=view.Top-5%x";
Debug.ShouldStop(-2147483648);
_view.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_view.runMethod(true,"getTop"),parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),_ba)}, "-",1, 1));
 if (true) break;

case 6:
//C
this.state = -1;
;
 BA.debugLineNum = 66;BA.debugLine="End Sub";
Debug.ShouldStop(2);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
}