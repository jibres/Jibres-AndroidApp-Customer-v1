package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class login_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (login) ","login",2,login.mostCurrent.activityBA,login.mostCurrent,18);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.login.remoteMe.runUserSub(false, "login","activity_create", _firsttime);}
RemoteObject _img = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _ac = RemoteObject.declareNull("de.amberhome.objects.appcompat.ACEditTextWrapper");
RemoteObject _cm = RemoteObject.declareNull("ir.cafematerial.librariessupport.LibrariesSupport");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 18;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 21;BA.debugLine="Activity.Background= C.Gradient(0xff54A3EC,0xff54";
Debug.ShouldStop(1048576);
login.mostCurrent._activity.runMethod(false,"setBackground",(login.mostCurrent._c.runMethod(false,"_gradient" /*RemoteObject*/ ,login.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 0xff54a3ec)),(Object)(BA.numberCast(int.class, 0xff5433b0)),(Object)(BA.numberCast(int.class, 0)),(Object)(login.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 23;BA.debugLine="Dim img As ImageView";
Debug.ShouldStop(4194304);
_img = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("img", _img);
 BA.debugLineNum = 24;BA.debugLine="C.imgCreate(img,\"\",Activity,40%x,50%y-50%x,20%x,2";
Debug.ShouldStop(8388608);
login.mostCurrent._c.runVoidMethod ("_imgcreate" /*RemoteObject*/ ,login.mostCurrent.activityBA,(Object)(_img),(Object)(BA.ObjectToString("")),(Object)(login.mostCurrent._activity),(Object)(login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 40)),login.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {login.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),login.mostCurrent.activityBA),login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),login.mostCurrent.activityBA)}, "-",1, 1)),(Object)(login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 20)),login.mostCurrent.activityBA)),(Object)(login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 20)),login.mostCurrent.activityBA)));
 BA.debugLineNum = 25;BA.debugLine="img.Bitmap=Application.Icon";
Debug.ShouldStop(16777216);
_img.runMethod(false,"setBitmap",(login.mostCurrent.__c.getField(false,"Application").runMethod(false,"getIcon").getObject()));
 BA.debugLineNum = 28;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(134217728);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 29;BA.debugLine="pnl.Initialize(\"\")";
Debug.ShouldStop(268435456);
_pnl.runVoidMethod ("Initialize",login.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 30;BA.debugLine="Activity.AddView(pnl,12%x,50%y-67%x+74%x,76%x,13%";
Debug.ShouldStop(536870912);
login.mostCurrent._activity.runVoidMethod ("AddView",(Object)((_pnl.getObject())),(Object)(login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 12)),login.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {login.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),login.mostCurrent.activityBA),login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 67)),login.mostCurrent.activityBA),login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 74)),login.mostCurrent.activityBA)}, "-+",2, 1)),(Object)(login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 76)),login.mostCurrent.activityBA)),(Object)(login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 13)),login.mostCurrent.activityBA)));
 BA.debugLineNum = 33;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(1);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 34;BA.debugLine="C.setlblset(lbl,\"\",Activity,0,50%y-20%x,100%x,13%";
Debug.ShouldStop(2);
login.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,login.mostCurrent.activityBA,(Object)(_lbl),(Object)(BA.ObjectToString("")),(Object)(login.mostCurrent._activity),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {login.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),login.mostCurrent.activityBA),login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 20)),login.mostCurrent.activityBA)}, "-",1, 1)),(Object)(login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),login.mostCurrent.activityBA)),(Object)(login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 13)),login.mostCurrent.activityBA)),(Object)(BA.ObjectToString("ثبت نام با شماره همراه")),(Object)(login.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),(Object)(login.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 20)),(Object)(BA.numberCast(int.class, 0xffffffff)));
 BA.debugLineNum = 36;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(8);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 37;BA.debugLine="cd.Initialize2(0x5AC4C4C4, 10dip,1.5dip,0x5AFFFFF";
Debug.ShouldStop(16);
_cd.runVoidMethod ("Initialize2",(Object)(BA.numberCast(int.class, 0x5ac4c4c4)),(Object)(login.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(login.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1.5)))),(Object)(BA.numberCast(int.class, 0x5affffff)));
 BA.debugLineNum = 38;BA.debugLine="pnl.Background = cd";
Debug.ShouldStop(32);
_pnl.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 40;BA.debugLine="Dim ac As ACEditText";
Debug.ShouldStop(128);
_ac = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACEditTextWrapper");Debug.locals.put("ac", _ac);
 BA.debugLineNum = 41;BA.debugLine="ac.Initialize(\"ed\")";
Debug.ShouldStop(256);
_ac.runVoidMethod ("Initialize",login.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("ed")));
 BA.debugLineNum = 42;BA.debugLine="Activity.AddView(ac,29%x,50%y-67%x+74%x,57%x,14%x";
Debug.ShouldStop(512);
login.mostCurrent._activity.runVoidMethod ("AddView",(Object)((_ac.getObject())),(Object)(login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 29)),login.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {login.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),login.mostCurrent.activityBA),login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 67)),login.mostCurrent.activityBA),login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 74)),login.mostCurrent.activityBA)}, "-+",2, 1)),(Object)(login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 57)),login.mostCurrent.activityBA)),(Object)(login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 14)),login.mostCurrent.activityBA)));
 BA.debugLineNum = 43;BA.debugLine="ac.Typeface=c.irs";
Debug.ShouldStop(1024);
_ac.runMethod(false,"setTypeface",(login.mostCurrent._c._irs /*RemoteObject*/ .getObject()));
 BA.debugLineNum = 44;BA.debugLine="ac.Hint=\"شماره موبایل\"";
Debug.ShouldStop(2048);
_ac.runMethod(true,"setHint",BA.ObjectToString("شماره موبایل"));
 BA.debugLineNum = 45;BA.debugLine="ac.HintColor=0x5AFFFFFF";
Debug.ShouldStop(4096);
_ac.runMethod(true,"setHintColor",BA.numberCast(int.class, 0x5affffff));
 BA.debugLineNum = 46;BA.debugLine="Dim cm As cmLibrariesSupport";
Debug.ShouldStop(8192);
_cm = RemoteObject.createNew ("ir.cafematerial.librariessupport.LibrariesSupport");Debug.locals.put("cm", _cm);
 BA.debugLineNum = 47;BA.debugLine="cm.SetEditTextTintColor(ac,Colors.Transparent,Col";
Debug.ShouldStop(16384);
_cm.runVoidMethod ("SetEditTextTintColor",(Object)((_ac.getObject())),(Object)(login.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent")),(Object)(login.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent")));
 BA.debugLineNum = 48;BA.debugLine="c.Force_RtlSupported4View(ac)";
Debug.ShouldStop(32768);
login.mostCurrent._c.runVoidMethod ("_force_rtlsupported4view" /*RemoteObject*/ ,login.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _ac.getObject()));
 BA.debugLineNum = 49;BA.debugLine="ac.TextColor=Colors.White";
Debug.ShouldStop(65536);
_ac.runMethod(true,"setTextColor",login.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 50;BA.debugLine="ac.InputType=ac.INPUT_TYPE_PHONE";
Debug.ShouldStop(131072);
_ac.runMethod(true,"setInputType",_ac.getField(true,"INPUT_TYPE_PHONE"));
 BA.debugLineNum = 51;BA.debugLine="ac.ForceDoneButton=True";
Debug.ShouldStop(262144);
_ac.runVoidMethod ("setForceDoneButton",login.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 53;BA.debugLine="Dim img As ImageView";
Debug.ShouldStop(1048576);
_img = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("img", _img);
 BA.debugLineNum = 54;BA.debugLine="C.imgCreate(img,\"\",Activity,15%x,50%y-67%x+77.5%x";
Debug.ShouldStop(2097152);
login.mostCurrent._c.runVoidMethod ("_imgcreate" /*RemoteObject*/ ,login.mostCurrent.activityBA,(Object)(_img),(Object)(BA.ObjectToString("")),(Object)(login.mostCurrent._activity),(Object)(login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),login.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {login.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),login.mostCurrent.activityBA),login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 67)),login.mostCurrent.activityBA),login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 77.5)),login.mostCurrent.activityBA)}, "-+",2, 1)),(Object)(login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 6)),login.mostCurrent.activityBA)),(Object)(login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 6)),login.mostCurrent.activityBA)));
 BA.debugLineNum = 55;BA.debugLine="C.btm(\"iran.png\",img)";
Debug.ShouldStop(4194304);
login.mostCurrent._c.runVoidMethod ("_btm" /*RemoteObject*/ ,login.mostCurrent.activityBA,(Object)(BA.ObjectToString("iran.png")),(Object)(_img));
 BA.debugLineNum = 57;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(16777216);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 58;BA.debugLine="C.setlblset(lbl,\"\",Activity,22%x,50%y-67%x+77.5%x";
Debug.ShouldStop(33554432);
login.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,login.mostCurrent.activityBA,(Object)(_lbl),(Object)(BA.ObjectToString("")),(Object)(login.mostCurrent._activity),(Object)(login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 22)),login.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {login.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),login.mostCurrent.activityBA),login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 67)),login.mostCurrent.activityBA),login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 77.5)),login.mostCurrent.activityBA)}, "-+",2, 1)),(Object)(login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 6)),login.mostCurrent.activityBA)),(Object)(login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 6)),login.mostCurrent.activityBA)),(Object)(BA.ObjectToString(login.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xe313))))),(Object)(login.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.keywords.constants.TypefaceWrapper"), login.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getMATERIALICONS")),(Object)(BA.numberCast(int.class, 20)),(Object)(BA.numberCast(int.class, 0xffffffff)));
 BA.debugLineNum = 61;BA.debugLine="c.setlblset(lblbtn,\"lbl\",Activity,12%x,50%y-67%x+";
Debug.ShouldStop(268435456);
login.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,login.mostCurrent.activityBA,(Object)(login.mostCurrent._lblbtn),(Object)(BA.ObjectToString("lbl")),(Object)(login.mostCurrent._activity),(Object)(login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 12)),login.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {login.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),login.mostCurrent.activityBA),login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 67)),login.mostCurrent.activityBA),login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 94)),login.mostCurrent.activityBA)}, "-+",2, 1)),(Object)(login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 76)),login.mostCurrent.activityBA)),(Object)(login.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 13)),login.mostCurrent.activityBA)),(Object)(BA.ObjectToString("ادامه")),(Object)(login.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),(Object)(login.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 15)),(Object)(BA.numberCast(int.class, 0xffffffff)));
 BA.debugLineNum = 62;BA.debugLine="lblbtn.Background=c.Gradient(0xff54A3EC,0xff54A3E";
Debug.ShouldStop(536870912);
login.mostCurrent._lblbtn.runMethod(false,"setBackground",(login.mostCurrent._c.runMethod(false,"_gradient" /*RemoteObject*/ ,login.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 0xff54a3ec)),(Object)(BA.numberCast(int.class, 0xff54a3ec)),(Object)(login.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(login.mostCurrent.__c.getField(true,"False"))).getObject()));
 BA.debugLineNum = 63;BA.debugLine="lblbtn.Visible=False";
Debug.ShouldStop(1073741824);
login.mostCurrent._lblbtn.runMethod(true,"setVisible",login.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("Activity_Pause (login) ","login",2,login.mostCurrent.activityBA,login.mostCurrent,80);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.login.remoteMe.runUserSub(false, "login","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 80;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(32768);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (login) ","login",2,login.mostCurrent.activityBA,login.mostCurrent,76);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.login.remoteMe.runUserSub(false, "login","activity_resume");}
 BA.debugLineNum = 76;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2048);
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("ed_TextChanged (login) ","login",2,login.mostCurrent.activityBA,login.mostCurrent,69);
if (RapidSub.canDelegate("ed_textchanged")) { return b4a.example.login.remoteMe.runUserSub(false, "login","ed_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 69;BA.debugLine="Sub ed_TextChanged (Old As String, New As String)";
Debug.ShouldStop(16);
 BA.debugLineNum = 70;BA.debugLine="If New.Length=10 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_new.runMethod(true,"length"),BA.numberCast(double.class, 10))) { 
 BA.debugLineNum = 71;BA.debugLine="c.SomUpDownFade(lblbtn,500, True)";
Debug.ShouldStop(64);
login.mostCurrent._c.runVoidMethod ("_somupdownfade" /*void*/ ,login.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), login.mostCurrent._lblbtn.getObject()),(Object)(BA.numberCast(int.class, 500)),(Object)(login.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 73;BA.debugLine="c.SomUpDownFade(lblbtn,500, False)";
Debug.ShouldStop(256);
login.mostCurrent._c.runVoidMethod ("_somupdownfade" /*void*/ ,login.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), login.mostCurrent._lblbtn.getObject()),(Object)(BA.numberCast(int.class, 500)),(Object)(login.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
 //BA.debugLineNum = 15;BA.debugLine="Dim lblbtn As Label";
login.mostCurrent._lblbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_Click (login) ","login",2,login.mostCurrent.activityBA,login.mostCurrent,66);
if (RapidSub.canDelegate("lbl_click")) { return b4a.example.login.remoteMe.runUserSub(false, "login","lbl_click");}
 BA.debugLineNum = 66;BA.debugLine="Sub lbl_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="StartActivity(verify)";
Debug.ShouldStop(4);
login.mostCurrent.__c.runVoidMethod ("StartActivity",login.processBA,(Object)((login.mostCurrent._verify.getObject())));
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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