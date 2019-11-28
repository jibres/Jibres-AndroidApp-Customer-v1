package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class verify_subs_0 {


public static RemoteObject  _activity_click() throws Exception{
try {
		Debug.PushSubsStack("Activity_Click (verify) ","verify",3,verify.mostCurrent.activityBA,verify.mostCurrent,134);
if (RapidSub.canDelegate("activity_click")) { return b4a.example.verify.remoteMe.runUserSub(false, "verify","activity_click");}
 BA.debugLineNum = 134;BA.debugLine="Sub Activity_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 135;BA.debugLine="StartActivity(page)";
Debug.ShouldStop(64);
verify.mostCurrent.__c.runVoidMethod ("StartActivity",verify.processBA,(Object)((verify.mostCurrent._page.getObject())));
 BA.debugLineNum = 136;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (verify) ","verify",3,verify.mostCurrent.activityBA,verify.mostCurrent,23);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.verify.remoteMe.runUserSub(false, "verify","activity_create", _firsttime);}
RemoteObject _img = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _cm = RemoteObject.declareNull("ir.cafematerial.librariessupport.LibrariesSupport");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 23;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 26;BA.debugLine="Activity.Background= C.Gradient(0xff54A3EC,0xff54";
Debug.ShouldStop(33554432);
verify.mostCurrent._activity.runMethod(false,"setBackground",(verify.mostCurrent._c.runMethod(false,"_gradient" /*RemoteObject*/ ,verify.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 0xff54a3ec)),(Object)(BA.numberCast(int.class, 0xff5433b0)),(Object)(BA.numberCast(int.class, 0)),(Object)(verify.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 28;BA.debugLine="Dim img As ImageView";
Debug.ShouldStop(134217728);
_img = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("img", _img);
 BA.debugLineNum = 29;BA.debugLine="C.imgCreate(img,\"\",Activity,40%x,50%y-50%x,20%x,2";
Debug.ShouldStop(268435456);
verify.mostCurrent._c.runVoidMethod ("_imgcreate" /*RemoteObject*/ ,verify.mostCurrent.activityBA,(Object)(_img),(Object)(BA.ObjectToString("")),(Object)(verify.mostCurrent._activity),(Object)(verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 40)),verify.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {verify.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),verify.mostCurrent.activityBA),verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),verify.mostCurrent.activityBA)}, "-",1, 1)),(Object)(verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 20)),verify.mostCurrent.activityBA)),(Object)(verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 20)),verify.mostCurrent.activityBA)));
 BA.debugLineNum = 30;BA.debugLine="img.Bitmap=Application.Icon";
Debug.ShouldStop(536870912);
_img.runMethod(false,"setBitmap",(verify.mostCurrent.__c.getField(false,"Application").runMethod(false,"getIcon").getObject()));
 BA.debugLineNum = 33;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(1);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 34;BA.debugLine="C.setlblset(lbl,\"\",Activity,0,50%y-20%x,100%x,13%";
Debug.ShouldStop(2);
verify.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,verify.mostCurrent.activityBA,(Object)(_lbl),(Object)(BA.ObjectToString("")),(Object)(verify.mostCurrent._activity),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {verify.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),verify.mostCurrent.activityBA),verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 20)),verify.mostCurrent.activityBA)}, "-",1, 1)),(Object)(verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),verify.mostCurrent.activityBA)),(Object)(verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 13)),verify.mostCurrent.activityBA)),(Object)(BA.ObjectToString("تایید شماره همراه")),(Object)(verify.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),(Object)(verify.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 20)),(Object)(BA.numberCast(int.class, 0xffffffff)));
 BA.debugLineNum = 36;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(8);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 37;BA.debugLine="C.setlblset(lbl,\"\",Activity,0,50%y-10%x,100%x,13%";
Debug.ShouldStop(16);
verify.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,verify.mostCurrent.activityBA,(Object)(_lbl),(Object)(BA.ObjectToString("")),(Object)(verify.mostCurrent._activity),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {verify.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),verify.mostCurrent.activityBA),verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),verify.mostCurrent.activityBA)}, "-",1, 1)),(Object)(verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),verify.mostCurrent.activityBA)),(Object)(verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 13)),verify.mostCurrent.activityBA)),(Object)(BA.ObjectToString("لطفا کد پیامک شده را وارد کنید")),(Object)(verify.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),(Object)(verify.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 15)),(Object)(BA.numberCast(int.class, 0xffffffff)));
 BA.debugLineNum = 39;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(64);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 40;BA.debugLine="C.PnlCreate(pnl,\"\",Activity,19%x,50%y+15%x,14%x,1";
Debug.ShouldStop(128);
verify.mostCurrent._c.runVoidMethod ("_pnlcreate" /*RemoteObject*/ ,verify.mostCurrent.activityBA,(Object)(_pnl),(Object)(BA.ObjectToString("")),(Object)(verify.mostCurrent._activity),(Object)(verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 19)),verify.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {verify.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),verify.mostCurrent.activityBA),verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),verify.mostCurrent.activityBA)}, "+",1, 1)),(Object)(verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 14)),verify.mostCurrent.activityBA)),(Object)(verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 14)),verify.mostCurrent.activityBA)));
 BA.debugLineNum = 41;BA.debugLine="pnl.Background= C.Gradient(-1,-1,5000,True)";
Debug.ShouldStop(256);
_pnl.runMethod(false,"setBackground",(verify.mostCurrent._c.runMethod(false,"_gradient" /*RemoteObject*/ ,verify.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.numberCast(int.class, 5000)),(Object)(verify.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 44;BA.debugLine="C.setlblset(lbl1,\"lblc\",pnl,0,0,-1,-1,\"\",Gravity.";
Debug.ShouldStop(2048);
verify.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,verify.mostCurrent.activityBA,(Object)(verify.mostCurrent._lbl1),(Object)(BA.ObjectToString("lblc")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ActivityWrapper"), _pnl.getObject()),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.ObjectToString("")),(Object)(verify.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),(Object)(verify.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 20)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))));
 BA.debugLineNum = 46;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(8192);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 47;BA.debugLine="C.PnlCreate(pnl,\"\",Activity,19%x+16%x,50%y+15%x,1";
Debug.ShouldStop(16384);
verify.mostCurrent._c.runVoidMethod ("_pnlcreate" /*RemoteObject*/ ,verify.mostCurrent.activityBA,(Object)(_pnl),(Object)(BA.ObjectToString("")),(Object)(verify.mostCurrent._activity),(Object)(RemoteObject.solve(new RemoteObject[] {verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 19)),verify.mostCurrent.activityBA),verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 16)),verify.mostCurrent.activityBA)}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {verify.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),verify.mostCurrent.activityBA),verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),verify.mostCurrent.activityBA)}, "+",1, 1)),(Object)(verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 14)),verify.mostCurrent.activityBA)),(Object)(verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 14)),verify.mostCurrent.activityBA)));
 BA.debugLineNum = 48;BA.debugLine="pnl.Background= C.Gradient(-1,-1,5000,True)";
Debug.ShouldStop(32768);
_pnl.runMethod(false,"setBackground",(verify.mostCurrent._c.runMethod(false,"_gradient" /*RemoteObject*/ ,verify.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.numberCast(int.class, 5000)),(Object)(verify.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 50;BA.debugLine="C.setlblset(lbl2,\"lblc\",pnl,0,0,-1,-1,\"\",Gravity.";
Debug.ShouldStop(131072);
verify.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,verify.mostCurrent.activityBA,(Object)(verify.mostCurrent._lbl2),(Object)(BA.ObjectToString("lblc")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ActivityWrapper"), _pnl.getObject()),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.ObjectToString("")),(Object)(verify.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),(Object)(verify.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 20)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))));
 BA.debugLineNum = 52;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(524288);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 53;BA.debugLine="C.PnlCreate(pnl,\"\",Activity,19%x+(16%x*2),50%y+15";
Debug.ShouldStop(1048576);
verify.mostCurrent._c.runVoidMethod ("_pnlcreate" /*RemoteObject*/ ,verify.mostCurrent.activityBA,(Object)(_pnl),(Object)(BA.ObjectToString("")),(Object)(verify.mostCurrent._activity),(Object)(RemoteObject.solve(new RemoteObject[] {verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 19)),verify.mostCurrent.activityBA),(RemoteObject.solve(new RemoteObject[] {verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 16)),verify.mostCurrent.activityBA),RemoteObject.createImmutable(2)}, "*",0, 1))}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {verify.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),verify.mostCurrent.activityBA),verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),verify.mostCurrent.activityBA)}, "+",1, 1)),(Object)(verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 14)),verify.mostCurrent.activityBA)),(Object)(verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 14)),verify.mostCurrent.activityBA)));
 BA.debugLineNum = 54;BA.debugLine="pnl.Background= C.Gradient(-1,-1,5000,True)";
Debug.ShouldStop(2097152);
_pnl.runMethod(false,"setBackground",(verify.mostCurrent._c.runMethod(false,"_gradient" /*RemoteObject*/ ,verify.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.numberCast(int.class, 5000)),(Object)(verify.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 56;BA.debugLine="C.setlblset(lbl3,\"lblc\",pnl,0,0,-1,-1,\"\",Gravity.";
Debug.ShouldStop(8388608);
verify.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,verify.mostCurrent.activityBA,(Object)(verify.mostCurrent._lbl3),(Object)(BA.ObjectToString("lblc")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ActivityWrapper"), _pnl.getObject()),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.ObjectToString("")),(Object)(verify.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),(Object)(verify.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 20)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))));
 BA.debugLineNum = 58;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(33554432);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 59;BA.debugLine="C.PnlCreate(pnl,\"\",Activity,19%x+(16%x*3),50%y+15";
Debug.ShouldStop(67108864);
verify.mostCurrent._c.runVoidMethod ("_pnlcreate" /*RemoteObject*/ ,verify.mostCurrent.activityBA,(Object)(_pnl),(Object)(BA.ObjectToString("")),(Object)(verify.mostCurrent._activity),(Object)(RemoteObject.solve(new RemoteObject[] {verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 19)),verify.mostCurrent.activityBA),(RemoteObject.solve(new RemoteObject[] {verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 16)),verify.mostCurrent.activityBA),RemoteObject.createImmutable(3)}, "*",0, 1))}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {verify.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),verify.mostCurrent.activityBA),verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),verify.mostCurrent.activityBA)}, "+",1, 1)),(Object)(verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 14)),verify.mostCurrent.activityBA)),(Object)(verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 14)),verify.mostCurrent.activityBA)));
 BA.debugLineNum = 60;BA.debugLine="pnl.Background= C.Gradient(-1,-1,5000,True)";
Debug.ShouldStop(134217728);
_pnl.runMethod(false,"setBackground",(verify.mostCurrent._c.runMethod(false,"_gradient" /*RemoteObject*/ ,verify.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.numberCast(int.class, 5000)),(Object)(verify.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 62;BA.debugLine="C.setlblset(lbl4,\"lblc\",pnl,0,0,-1,-1,\"\",Gravity.";
Debug.ShouldStop(536870912);
verify.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,verify.mostCurrent.activityBA,(Object)(verify.mostCurrent._lbl4),(Object)(BA.ObjectToString("lblc")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ActivityWrapper"), _pnl.getObject()),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.ObjectToString("")),(Object)(verify.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),(Object)(verify.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 20)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))));
 BA.debugLineNum = 65;BA.debugLine="ac.Initialize(\"ed\")";
Debug.ShouldStop(1);
verify.mostCurrent._ac.runVoidMethod ("Initialize",verify.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("ed")));
 BA.debugLineNum = 66;BA.debugLine="Activity.AddView(ac,129%x,50%y+15%x,57%x,14%x)";
Debug.ShouldStop(2);
verify.mostCurrent._activity.runVoidMethod ("AddView",(Object)((verify.mostCurrent._ac.getObject())),(Object)(verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 129)),verify.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {verify.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),verify.mostCurrent.activityBA),verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),verify.mostCurrent.activityBA)}, "+",1, 1)),(Object)(verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 57)),verify.mostCurrent.activityBA)),(Object)(verify.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 14)),verify.mostCurrent.activityBA)));
 BA.debugLineNum = 67;BA.debugLine="ac.Typeface=c.irs";
Debug.ShouldStop(4);
verify.mostCurrent._ac.runMethod(false,"setTypeface",(verify.mostCurrent._c._irs /*RemoteObject*/ .getObject()));
 BA.debugLineNum = 68;BA.debugLine="ac.Hint=\"شماره موبایل\"";
Debug.ShouldStop(8);
verify.mostCurrent._ac.runMethod(true,"setHint",BA.ObjectToString("شماره موبایل"));
 BA.debugLineNum = 69;BA.debugLine="ac.HintColor=0x5AFFFFFF";
Debug.ShouldStop(16);
verify.mostCurrent._ac.runMethod(true,"setHintColor",BA.numberCast(int.class, 0x5affffff));
 BA.debugLineNum = 70;BA.debugLine="Dim cm As cmLibrariesSupport";
Debug.ShouldStop(32);
_cm = RemoteObject.createNew ("ir.cafematerial.librariessupport.LibrariesSupport");Debug.locals.put("cm", _cm);
 BA.debugLineNum = 71;BA.debugLine="cm.SetEditTextTintColor(ac,Colors.Transparent,Col";
Debug.ShouldStop(64);
_cm.runVoidMethod ("SetEditTextTintColor",(Object)((verify.mostCurrent._ac.getObject())),(Object)(verify.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent")),(Object)(verify.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent")));
 BA.debugLineNum = 72;BA.debugLine="c.Force_RtlSupported4View(ac)";
Debug.ShouldStop(128);
verify.mostCurrent._c.runVoidMethod ("_force_rtlsupported4view" /*RemoteObject*/ ,verify.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), verify.mostCurrent._ac.getObject()));
 BA.debugLineNum = 73;BA.debugLine="ac.TextColor=Colors.White";
Debug.ShouldStop(256);
verify.mostCurrent._ac.runMethod(true,"setTextColor",verify.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 74;BA.debugLine="ac.InputType=ac.INPUT_TYPE_NUMBERS";
Debug.ShouldStop(512);
verify.mostCurrent._ac.runMethod(true,"setInputType",verify.mostCurrent._ac.getField(true,"INPUT_TYPE_NUMBERS"));
 BA.debugLineNum = 75;BA.debugLine="ac.ForceDoneButton=True";
Debug.ShouldStop(1024);
verify.mostCurrent._ac.runVoidMethod ("setForceDoneButton",verify.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 76;BA.debugLine="ac.RequestFocus";
Debug.ShouldStop(2048);
verify.mostCurrent._ac.runVoidMethod ("RequestFocus");
 BA.debugLineNum = 78;BA.debugLine="C.show_key(ac,\"\")";
Debug.ShouldStop(8192);
verify.mostCurrent._c.runVoidMethod ("_show_key" /*void*/ ,verify.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.EditTextWrapper"), verify.mostCurrent._ac.getObject()),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (verify) ","verify",3,verify.mostCurrent.activityBA,verify.mostCurrent,141);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.verify.remoteMe.runUserSub(false, "verify","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 141;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 143;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (verify) ","verify",3,verify.mostCurrent.activityBA,verify.mostCurrent,137);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.verify.remoteMe.runUserSub(false, "verify","activity_resume");}
 BA.debugLineNum = 137;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(256);
 BA.debugLineNum = 139;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ed_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("ed_TextChanged (verify) ","verify",3,verify.mostCurrent.activityBA,verify.mostCurrent,93);
if (RapidSub.canDelegate("ed_textchanged")) { return b4a.example.verify.remoteMe.runUserSub(false, "verify","ed_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 93;BA.debugLine="Sub ed_TextChanged (Old As String, New As String)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 95;BA.debugLine="Select New.Length";
Debug.ShouldStop(1073741824);
switch (BA.switchObjectToInt(_new.runMethod(true,"length"),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5))) {
case 0: {
 BA.debugLineNum = 98;BA.debugLine="lbl1.Text=\"\"";
Debug.ShouldStop(2);
verify.mostCurrent._lbl1.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 99;BA.debugLine="lbl2.Text=\"\"";
Debug.ShouldStop(4);
verify.mostCurrent._lbl2.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 100;BA.debugLine="lbl3.Text=\"\"";
Debug.ShouldStop(8);
verify.mostCurrent._lbl3.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 101;BA.debugLine="lbl4.Text=\"\"";
Debug.ShouldStop(16);
verify.mostCurrent._lbl4.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 102;BA.debugLine="pnlcolor(-1,-1,-1,-1)";
Debug.ShouldStop(32);
_pnlcolor(BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, -(double) (0 + 1)));
 break; }
case 1: {
 BA.debugLineNum = 104;BA.debugLine="lbl1.Text=New.SubString2(0,1)";
Debug.ShouldStop(128);
verify.mostCurrent._lbl1.runMethod(true,"setText",BA.ObjectToCharSequence(_new.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 105;BA.debugLine="lbl2.Text=\"\"";
Debug.ShouldStop(256);
verify.mostCurrent._lbl2.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 106;BA.debugLine="lbl3.Text=\"\"";
Debug.ShouldStop(512);
verify.mostCurrent._lbl3.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 107;BA.debugLine="lbl4.Text=\"\"";
Debug.ShouldStop(1024);
verify.mostCurrent._lbl4.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 108;BA.debugLine="pnlcolor(0xFF004383,-1,-1,-1)";
Debug.ShouldStop(2048);
_pnlcolor(BA.numberCast(int.class, 0xff004383),BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, -(double) (0 + 1)));
 break; }
case 2: {
 BA.debugLineNum = 110;BA.debugLine="lbl1.Text=New.SubString2(0,1)";
Debug.ShouldStop(8192);
verify.mostCurrent._lbl1.runMethod(true,"setText",BA.ObjectToCharSequence(_new.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 111;BA.debugLine="lbl2.Text=New.SubString2(1,2)";
Debug.ShouldStop(16384);
verify.mostCurrent._lbl2.runMethod(true,"setText",BA.ObjectToCharSequence(_new.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 112;BA.debugLine="lbl3.Text=\"\"";
Debug.ShouldStop(32768);
verify.mostCurrent._lbl3.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 113;BA.debugLine="lbl4.Text=\"\"";
Debug.ShouldStop(65536);
verify.mostCurrent._lbl4.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 114;BA.debugLine="pnlcolor(0xFF004383,0xFF004383,-1,-1)";
Debug.ShouldStop(131072);
_pnlcolor(BA.numberCast(int.class, 0xff004383),BA.numberCast(int.class, 0xff004383),BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, -(double) (0 + 1)));
 break; }
case 3: {
 BA.debugLineNum = 116;BA.debugLine="lbl1.Text=New.SubString2(0,1)";
Debug.ShouldStop(524288);
verify.mostCurrent._lbl1.runMethod(true,"setText",BA.ObjectToCharSequence(_new.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 117;BA.debugLine="lbl2.Text=New.SubString2(1,2)";
Debug.ShouldStop(1048576);
verify.mostCurrent._lbl2.runMethod(true,"setText",BA.ObjectToCharSequence(_new.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 118;BA.debugLine="lbl3.Text=New.SubString2(2,3)";
Debug.ShouldStop(2097152);
verify.mostCurrent._lbl3.runMethod(true,"setText",BA.ObjectToCharSequence(_new.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 3)))));
 BA.debugLineNum = 119;BA.debugLine="lbl4.Text=\"\"";
Debug.ShouldStop(4194304);
verify.mostCurrent._lbl4.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 120;BA.debugLine="pnlcolor(0xFF004383,0xFF004383,0xFF004383,-1)";
Debug.ShouldStop(8388608);
_pnlcolor(BA.numberCast(int.class, 0xff004383),BA.numberCast(int.class, 0xff004383),BA.numberCast(int.class, 0xff004383),BA.numberCast(int.class, -(double) (0 + 1)));
 break; }
case 4: {
 BA.debugLineNum = 123;BA.debugLine="lbl1.Text=New.SubString2(0,1)";
Debug.ShouldStop(67108864);
verify.mostCurrent._lbl1.runMethod(true,"setText",BA.ObjectToCharSequence(_new.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 124;BA.debugLine="lbl2.Text=New.SubString2(1,2)";
Debug.ShouldStop(134217728);
verify.mostCurrent._lbl2.runMethod(true,"setText",BA.ObjectToCharSequence(_new.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 125;BA.debugLine="lbl3.Text=New.SubString2(2,3)";
Debug.ShouldStop(268435456);
verify.mostCurrent._lbl3.runMethod(true,"setText",BA.ObjectToCharSequence(_new.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 3)))));
 BA.debugLineNum = 126;BA.debugLine="lbl4.Text=New.SubString2(3,4)";
Debug.ShouldStop(536870912);
verify.mostCurrent._lbl4.runMethod(true,"setText",BA.ObjectToCharSequence(_new.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, 4)))));
 BA.debugLineNum = 127;BA.debugLine="pnlcolor(0xFF004383,0xFF004383,0xFF004383,0xFF0";
Debug.ShouldStop(1073741824);
_pnlcolor(BA.numberCast(int.class, 0xff004383),BA.numberCast(int.class, 0xff004383),BA.numberCast(int.class, 0xff004383),BA.numberCast(int.class, 0xff004383));
 break; }
case 5: {
 BA.debugLineNum = 129;BA.debugLine="ac.Text=Old";
Debug.ShouldStop(1);
verify.mostCurrent._ac.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_old));
 BA.debugLineNum = 130;BA.debugLine="ac.SetSelection(4,0)";
Debug.ShouldStop(2);
verify.mostCurrent._ac.runVoidMethod ("SetSelection",(Object)(BA.numberCast(int.class, 4)),(Object)(BA.numberCast(int.class, 0)));
 break; }
}
;
 BA.debugLineNum = 133;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim ac As ACEditText";
verify.mostCurrent._ac = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACEditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Dim lbl1 As Label";
verify.mostCurrent._lbl1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Dim lbl2 As Label";
verify.mostCurrent._lbl2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Dim lbl3 As Label";
verify.mostCurrent._lbl3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Dim lbl4 As Label";
verify.mostCurrent._lbl4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lblc_click() throws Exception{
try {
		Debug.PushSubsStack("lblc_Click (verify) ","verify",3,verify.mostCurrent.activityBA,verify.mostCurrent,80);
if (RapidSub.canDelegate("lblc_click")) { return b4a.example.verify.remoteMe.runUserSub(false, "verify","lblc_click");}
 BA.debugLineNum = 80;BA.debugLine="Sub lblc_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 81;BA.debugLine="C.show_key(ac,\"\")";
Debug.ShouldStop(65536);
verify.mostCurrent._c.runVoidMethod ("_show_key" /*void*/ ,verify.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.EditTextWrapper"), verify.mostCurrent._ac.getObject()),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 82;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pnlcolor(RemoteObject _a,RemoteObject _b,RemoteObject _cd,RemoteObject _d) throws Exception{
try {
		Debug.PushSubsStack("pnlcolor (verify) ","verify",3,verify.mostCurrent.activityBA,verify.mostCurrent,83);
if (RapidSub.canDelegate("pnlcolor")) { return b4a.example.verify.remoteMe.runUserSub(false, "verify","pnlcolor", _a, _b, _cd, _d);}
RemoteObject _pnl1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _pnl2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _pnl3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _pnl4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
Debug.locals.put("a", _a);
Debug.locals.put("b", _b);
Debug.locals.put("cd", _cd);
Debug.locals.put("d", _d);
 BA.debugLineNum = 83;BA.debugLine="Sub pnlcolor(a As Int,b As Int,cd As Int,d As Int)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 84;BA.debugLine="Dim pnl1 As Panel = lbl1.Parent";
Debug.ShouldStop(524288);
_pnl1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_pnl1.setObject(verify.mostCurrent._lbl1.runMethod(false,"getParent"));Debug.locals.put("pnl1", _pnl1);
 BA.debugLineNum = 85;BA.debugLine="Dim pnl2 As Panel = lbl2.Parent";
Debug.ShouldStop(1048576);
_pnl2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_pnl2.setObject(verify.mostCurrent._lbl2.runMethod(false,"getParent"));Debug.locals.put("pnl2", _pnl2);
 BA.debugLineNum = 86;BA.debugLine="Dim pnl3 As Panel = lbl3.Parent";
Debug.ShouldStop(2097152);
_pnl3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_pnl3.setObject(verify.mostCurrent._lbl3.runMethod(false,"getParent"));Debug.locals.put("pnl3", _pnl3);
 BA.debugLineNum = 87;BA.debugLine="Dim pnl4 As Panel = lbl4.Parent";
Debug.ShouldStop(4194304);
_pnl4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_pnl4.setObject(verify.mostCurrent._lbl4.runMethod(false,"getParent"));Debug.locals.put("pnl4", _pnl4);
 BA.debugLineNum = 88;BA.debugLine="pnl1.Color=a";
Debug.ShouldStop(8388608);
_pnl1.runVoidMethod ("setColor",_a);
 BA.debugLineNum = 89;BA.debugLine="pnl2.Color=b";
Debug.ShouldStop(16777216);
_pnl2.runVoidMethod ("setColor",_b);
 BA.debugLineNum = 90;BA.debugLine="pnl3.Color=cd";
Debug.ShouldStop(33554432);
_pnl3.runVoidMethod ("setColor",_cd);
 BA.debugLineNum = 91;BA.debugLine="pnl4.Color=d";
Debug.ShouldStop(67108864);
_pnl4.runVoidMethod ("setColor",_d);
 BA.debugLineNum = 92;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}