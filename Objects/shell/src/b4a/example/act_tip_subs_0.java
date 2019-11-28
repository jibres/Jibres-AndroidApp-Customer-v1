package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class act_tip_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (act_tip) ","act_tip",1,act_tip.mostCurrent.activityBA,act_tip.mostCurrent,24);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.act_tip.remoteMe.runUserSub(false, "act_tip","activity_create", _firsttime);}
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
int _i = 0;
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _cs = RemoteObject.declareNull("anywheresoftware.b4a.objects.CSBuilder");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 27;BA.debugLine="Activity.Background= C.Gradient(0xff54A3EC,0xff54";
Debug.ShouldStop(67108864);
act_tip.mostCurrent._activity.runMethod(false,"setBackground",(act_tip.mostCurrent._c.runMethod(false,"_gradient" /*RemoteObject*/ ,act_tip.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 0xff54a3ec)),(Object)(BA.numberCast(int.class, 0xff5433b0)),(Object)(BA.numberCast(int.class, 0)),(Object)(act_tip.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 29;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(268435456);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 30;BA.debugLine="C.PnlCreate(pnl,\"\",Activity,-100%x,100%y-75%x,300";
Debug.ShouldStop(536870912);
act_tip.mostCurrent._c.runVoidMethod ("_pnlcreate" /*RemoteObject*/ ,act_tip.mostCurrent.activityBA,(Object)(_pnl),(Object)(BA.ObjectToString("")),(Object)(act_tip.mostCurrent._activity),(Object)(BA.numberCast(int.class, -(double) (0 + act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),act_tip.mostCurrent.activityBA).<Integer>get().intValue()))),(Object)(RemoteObject.solve(new RemoteObject[] {act_tip.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),act_tip.mostCurrent.activityBA),act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 75)),act_tip.mostCurrent.activityBA)}, "-",1, 1)),(Object)(act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 300)),act_tip.mostCurrent.activityBA)),(Object)(act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 300)),act_tip.mostCurrent.activityBA)));
 BA.debugLineNum = 31;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(1073741824);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 32;BA.debugLine="cd.Initialize(Colors.White, 5000dip)";
Debug.ShouldStop(-2147483648);
_cd.runVoidMethod ("Initialize",(Object)(act_tip.mostCurrent.__c.getField(false,"Colors").getField(true,"White")),(Object)(act_tip.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5000)))));
 BA.debugLineNum = 33;BA.debugLine="pnl.Background = cd";
Debug.ShouldStop(1);
_pnl.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 35;BA.debugLine="PC.Initialize";
Debug.ShouldStop(4);
act_tip.mostCurrent._pc.runVoidMethod ("Initialize",act_tip.mostCurrent.activityBA);
 BA.debugLineNum = 36;BA.debugLine="For i = 0 To 3";
Debug.ShouldStop(8);
{
final int step8 = 1;
final int limit8 = 3;
_i = 0 ;
for (;(step8 > 0 && _i <= limit8) || (step8 < 0 && _i >= limit8) ;_i = ((int)(0 + _i + step8))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 37;BA.debugLine="Panel(i).Initialize(\"Panel\")";
Debug.ShouldStop(16);
act_tip.mostCurrent._panel.getArrayElement(false,BA.numberCast(int.class, _i)).runVoidMethod ("Initialize",act_tip.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Panel")));
 BA.debugLineNum = 38;BA.debugLine="PC.AddPage(Panel(i),\"\")";
Debug.ShouldStop(32);
act_tip.mostCurrent._pc.runVoidMethod ("AddPage",(Object)((act_tip.mostCurrent._panel.getArrayElement(false,BA.numberCast(int.class, _i)).getObject())),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 39;BA.debugLine="Panel(i).Color=Colors.Transparent";
Debug.ShouldStop(64);
act_tip.mostCurrent._panel.getArrayElement(false,BA.numberCast(int.class, _i)).runVoidMethod ("setColor",act_tip.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 40;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(128);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 41;BA.debugLine="C.PnlCreate(pnl,\"\",Panel(i),10%x,15%x,80%x,100%y";
Debug.ShouldStop(256);
act_tip.mostCurrent._c.runVoidMethod ("_pnlcreate" /*RemoteObject*/ ,act_tip.mostCurrent.activityBA,(Object)(_pnl),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ActivityWrapper"), act_tip.mostCurrent._panel.getArrayElement(false,BA.numberCast(int.class, _i)).getObject()),(Object)(act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),act_tip.mostCurrent.activityBA)),(Object)(act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),act_tip.mostCurrent.activityBA)),(Object)(act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 80)),act_tip.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {act_tip.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),act_tip.mostCurrent.activityBA),act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 70)),act_tip.mostCurrent.activityBA)}, "-",1, 1)));
 BA.debugLineNum = 42;BA.debugLine="pnl.Background=C.Gradient(0xFFFFFFFF,0xFFFFFFFF,";
Debug.ShouldStop(512);
_pnl.runMethod(false,"setBackground",(act_tip.mostCurrent._c.runMethod(false,"_gradient" /*RemoteObject*/ ,act_tip.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 0xffffffff)),(Object)(BA.numberCast(int.class, 0xffffffff)),(Object)(act_tip.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(act_tip.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 43;BA.debugLine="pnl.Elevation=10dip";
Debug.ShouldStop(1024);
_pnl.runMethod(true,"setElevation",BA.numberCast(float.class, act_tip.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 BA.debugLineNum = 44;BA.debugLine="pnl.Color=Colors.White";
Debug.ShouldStop(2048);
_pnl.runVoidMethod ("setColor",act_tip.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 46;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(8192);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 47;BA.debugLine="C.setlblset(lbl,\"\",Panel(i),0,100%y-50%x,-1,10%x";
Debug.ShouldStop(16384);
act_tip.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,act_tip.mostCurrent.activityBA,(Object)(_lbl),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ActivityWrapper"), act_tip.mostCurrent._panel.getArrayElement(false,BA.numberCast(int.class, _i)).getObject()),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {act_tip.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),act_tip.mostCurrent.activityBA),act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),act_tip.mostCurrent.activityBA)}, "-",1, 1)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),act_tip.mostCurrent.activityBA)),(Object)(BA.ObjectToString("تیتر راهنمای اپلیکیش")),(Object)(act_tip.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),(Object)(act_tip.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 20)),(Object)(act_tip.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 49;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(65536);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 50;BA.debugLine="C.setlblset(lbl,\"\",Panel(i),0,100%y-40%x,-1,20%x";
Debug.ShouldStop(131072);
act_tip.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,act_tip.mostCurrent.activityBA,(Object)(_lbl),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ActivityWrapper"), act_tip.mostCurrent._panel.getArrayElement(false,BA.numberCast(int.class, _i)).getObject()),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {act_tip.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),act_tip.mostCurrent.activityBA),act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 40)),act_tip.mostCurrent.activityBA)}, "-",1, 1)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 20)),act_tip.mostCurrent.activityBA)),(Object)(BA.ObjectToString("متن راهنمای اپلیکیشن جیبرس ، در هزینه های خود صرفه جویی کنید.")),(Object)(act_tip.mostCurrent._c._tcenter /*RemoteObject*/ ),(Object)(act_tip.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 15)),(Object)(BA.numberCast(int.class, 0xff727272)));
 BA.debugLineNum = 51;BA.debugLine="lbl.Padding = Array As Int (30dip, 0, 30dip, 0)";
Debug.ShouldStop(262144);
_lbl.runMethod(false,"setPadding",RemoteObject.createNewArray("int",new int[] {4},new Object[] {act_tip.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))),BA.numberCast(int.class, 0),act_tip.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))),BA.numberCast(int.class, 0)}));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 54;BA.debugLine="VP.Initialize2(PC,\"VP\")";
Debug.ShouldStop(2097152);
act_tip.mostCurrent._vp.runVoidMethod ("Initialize2",act_tip.mostCurrent.activityBA,(Object)(act_tip.mostCurrent._pc),(Object)(RemoteObject.createImmutable("VP")));
 BA.debugLineNum = 55;BA.debugLine="Activity.AddView(VP,0,0,-1,100%y)";
Debug.ShouldStop(4194304);
act_tip.mostCurrent._activity.runVoidMethod ("AddView",(Object)((act_tip.mostCurrent._vp.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(act_tip.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),act_tip.mostCurrent.activityBA)));
 BA.debugLineNum = 56;BA.debugLine="VP.Color=Colors.Transparent";
Debug.ShouldStop(8388608);
act_tip.mostCurrent._vp.runVoidMethod ("setColor",act_tip.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 57;BA.debugLine="VP.PageMargin=-50dip";
Debug.ShouldStop(16777216);
act_tip.mostCurrent._vp.runMethod(true,"setPageMargin",BA.numberCast(int.class, -(double) (0 + act_tip.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50))).<Integer>get().intValue())));
 BA.debugLineNum = 58;BA.debugLine="VP.OffscreenPageLimit=4";
Debug.ShouldStop(33554432);
act_tip.mostCurrent._vp.runMethod(true,"setOffscreenPageLimit",BA.numberCast(int.class, 4));
 BA.debugLineNum = 61;BA.debugLine="C.setlblset(lblprew,\"prew\",Activity,0,100%y-15%x,";
Debug.ShouldStop(268435456);
act_tip.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,act_tip.mostCurrent.activityBA,(Object)(act_tip.mostCurrent._lblprew),(Object)(BA.ObjectToString("prew")),(Object)(act_tip.mostCurrent._activity),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {act_tip.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),act_tip.mostCurrent.activityBA),act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),act_tip.mostCurrent.activityBA)}, "-",1, 1)),(Object)(act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 35)),act_tip.mostCurrent.activityBA)),(Object)(act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),act_tip.mostCurrent.activityBA)),(Object)(BA.ObjectToString("قبلی")),(Object)(act_tip.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),(Object)(act_tip.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 15)),(Object)(BA.numberCast(int.class, 0xff727272)));
 BA.debugLineNum = 62;BA.debugLine="lblprew.Visible=False";
Debug.ShouldStop(536870912);
act_tip.mostCurrent._lblprew.runMethod(true,"setVisible",act_tip.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 64;BA.debugLine="C.setlblset(lblnext,\"next\",Activity,100%x-35%x,10";
Debug.ShouldStop(-2147483648);
act_tip.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,act_tip.mostCurrent.activityBA,(Object)(act_tip.mostCurrent._lblnext),(Object)(BA.ObjectToString("next")),(Object)(act_tip.mostCurrent._activity),(Object)(RemoteObject.solve(new RemoteObject[] {act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),act_tip.mostCurrent.activityBA),act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 35)),act_tip.mostCurrent.activityBA)}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {act_tip.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),act_tip.mostCurrent.activityBA),act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),act_tip.mostCurrent.activityBA)}, "-",1, 1)),(Object)(act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 35)),act_tip.mostCurrent.activityBA)),(Object)(act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),act_tip.mostCurrent.activityBA)),(Object)(BA.ObjectToString("بعدی")),(Object)(act_tip.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),(Object)(act_tip.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 15)),(Object)(BA.numberCast(int.class, 0xff727272)));
 BA.debugLineNum = 66;BA.debugLine="Dim cs As CSBuilder";
Debug.ShouldStop(2);
_cs = RemoteObject.createNew ("anywheresoftware.b4a.objects.CSBuilder");Debug.locals.put("cs", _cs);
 BA.debugLineNum = 67;BA.debugLine="cs.Initialize.Color(0xFF727272).Append(Chr(0xF111";
Debug.ShouldStop(4);
_cs.runMethod(false,"Initialize").runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xff727272))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(act_tip.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf111)))))).runMethod(false,"Pop").runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("   ")))).runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xffcecece))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(act_tip.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf111)))))).runMethod(false,"Pop").runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("   ")))).runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xffcecece))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(act_tip.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf111)))))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("   ")))).runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xffcecece))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(act_tip.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf111)))))).runVoidMethod ("PopAll");
 BA.debugLineNum = 70;BA.debugLine="C.setlblset(lblbol,\"\",Activity,0,100%y-19.5%x,100";
Debug.ShouldStop(32);
act_tip.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,act_tip.mostCurrent.activityBA,(Object)(act_tip.mostCurrent._lblbol),(Object)(BA.ObjectToString("")),(Object)(act_tip.mostCurrent._activity),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {act_tip.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),act_tip.mostCurrent.activityBA),act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 19.5)),act_tip.mostCurrent.activityBA)}, "-",1, 1)),(Object)(act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),act_tip.mostCurrent.activityBA)),(Object)(act_tip.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 20)),act_tip.mostCurrent.activityBA)),(Object)(BA.ObjectToString("")),(Object)(act_tip.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.keywords.constants.TypefaceWrapper"), act_tip.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getFONTAWESOME")),(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))));
 BA.debugLineNum = 71;BA.debugLine="lblbol.Text=cs";
Debug.ShouldStop(64);
act_tip.mostCurrent._lblbol.runMethod(true,"setText",BA.ObjectToCharSequence(_cs.getObject()));
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (act_tip) ","act_tip",1,act_tip.mostCurrent.activityBA,act_tip.mostCurrent,135);
if (RapidSub.canDelegate("activity_keypress")) { return b4a.example.act_tip.remoteMe.runUserSub(false, "act_tip","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 135;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(64);
 BA.debugLineNum = 136;BA.debugLine="If C.IsNoNetShow And c.IsNoNetPrimery=False Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean(".",act_tip.mostCurrent._c._isnonetshow /*RemoteObject*/ ) && RemoteObject.solveBoolean("=",act_tip.mostCurrent._c._isnonetprimery /*RemoteObject*/ ,act_tip.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 137;BA.debugLine="C.NoNetClose(pnlnonet)";
Debug.ShouldStop(256);
act_tip.mostCurrent._c.runVoidMethod ("_nonetclose" /*RemoteObject*/ ,act_tip.mostCurrent.activityBA,(Object)(act_tip.mostCurrent._pnlnonet));
 BA.debugLineNum = 138;BA.debugLine="Return True";
Debug.ShouldStop(512);
if (true) return act_tip.mostCurrent.__c.getField(true,"True");
 }else 
{ BA.debugLineNum = 139;BA.debugLine="Else if C.IsNoNetShow And c.IsNoNetPrimery=True T";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean(".",act_tip.mostCurrent._c._isnonetshow /*RemoteObject*/ ) && RemoteObject.solveBoolean("=",act_tip.mostCurrent._c._isnonetprimery /*RemoteObject*/ ,act_tip.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 140;BA.debugLine="Return True";
Debug.ShouldStop(2048);
if (true) return act_tip.mostCurrent.__c.getField(true,"True");
 }}
;
 BA.debugLineNum = 145;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (act_tip) ","act_tip",1,act_tip.mostCurrent.activityBA,act_tip.mostCurrent,131);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.act_tip.remoteMe.runUserSub(false, "act_tip","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 131;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (act_tip) ","act_tip",1,act_tip.mostCurrent.activityBA,act_tip.mostCurrent,127);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.act_tip.remoteMe.runUserSub(false, "act_tip","activity_resume");}
 BA.debugLineNum = 127;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 128;BA.debugLine="VP.GotoPage(0,False)";
Debug.ShouldStop(-2147483648);
act_tip.mostCurrent._vp.runVoidMethodAndSync ("GotoPage",(Object)(BA.numberCast(int.class, 0)),(Object)(act_tip.mostCurrent.__c.getField(true,"False")));
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private VP As AHViewPager";
act_tip.mostCurrent._vp = RemoteObject.createNew ("de.amberhome.viewpager.AHViewPager");
 //BA.debugLineNum = 16;BA.debugLine="Private PC As AHPageContainer";
act_tip.mostCurrent._pc = RemoteObject.createNew ("de.amberhome.viewpager.AHPageContainer");
 //BA.debugLineNum = 17;BA.debugLine="Private Panel(4) As Panel";
act_tip.mostCurrent._panel = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.PanelWrapper", new int[] {4}, new Object[]{});
 //BA.debugLineNum = 18;BA.debugLine="Dim pnlnonet As Panel";
act_tip.mostCurrent._pnlnonet = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Dim lblnext As Label";
act_tip.mostCurrent._lblnext = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Dim lblprew As Label";
act_tip.mostCurrent._lblprew = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Dim lblbol As Label";
act_tip.mostCurrent._lblbol = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _next_click() throws Exception{
try {
		Debug.PushSubsStack("next_Click (act_tip) ","act_tip",1,act_tip.mostCurrent.activityBA,act_tip.mostCurrent,113);
if (RapidSub.canDelegate("next_click")) { return b4a.example.act_tip.remoteMe.runUserSub(false, "act_tip","next_click");}
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 113;BA.debugLine="Sub next_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 114;BA.debugLine="Dim l As Label = Sender";
Debug.ShouldStop(131072);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_l.setObject(act_tip.mostCurrent.__c.runMethod(false,"Sender",act_tip.mostCurrent.activityBA));Debug.locals.put("l", _l);
 BA.debugLineNum = 115;BA.debugLine="Select l.Text";
Debug.ShouldStop(262144);
switch (BA.switchObjectToInt(_l.runMethod(true,"getText"),BA.ObjectToString("بعدی"))) {
case 0: {
 BA.debugLineNum = 117;BA.debugLine="VP.GotoPage(VP.CurrentPage+1,True)";
Debug.ShouldStop(1048576);
act_tip.mostCurrent._vp.runVoidMethodAndSync ("GotoPage",(Object)(RemoteObject.solve(new RemoteObject[] {act_tip.mostCurrent._vp.runMethod(true,"getCurrentPage"),RemoteObject.createImmutable(1)}, "+",1, 1)),(Object)(act_tip.mostCurrent.__c.getField(true,"True")));
 break; }
default: {
 BA.debugLineNum = 119;BA.debugLine="StartActivity(login)";
Debug.ShouldStop(4194304);
act_tip.mostCurrent.__c.runVoidMethod ("StartActivity",act_tip.processBA,(Object)((act_tip.mostCurrent._login.getObject())));
 break; }
}
;
 BA.debugLineNum = 123;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _prew_click() throws Exception{
try {
		Debug.PushSubsStack("prew_Click (act_tip) ","act_tip",1,act_tip.mostCurrent.activityBA,act_tip.mostCurrent,124);
if (RapidSub.canDelegate("prew_click")) { return b4a.example.act_tip.remoteMe.runUserSub(false, "act_tip","prew_click");}
 BA.debugLineNum = 124;BA.debugLine="Sub prew_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 125;BA.debugLine="VP.GotoPage(VP.CurrentPage-1,True)";
Debug.ShouldStop(268435456);
act_tip.mostCurrent._vp.runVoidMethodAndSync ("GotoPage",(Object)(RemoteObject.solve(new RemoteObject[] {act_tip.mostCurrent._vp.runMethod(true,"getCurrentPage"),RemoteObject.createImmutable(1)}, "-",1, 1)),(Object)(act_tip.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 126;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
public static void  _vp_pagechanged(RemoteObject _position) throws Exception{
try {
		Debug.PushSubsStack("vp_PageChanged (act_tip) ","act_tip",1,act_tip.mostCurrent.activityBA,act_tip.mostCurrent,75);
if (RapidSub.canDelegate("vp_pagechanged")) { b4a.example.act_tip.remoteMe.runUserSub(false, "act_tip","vp_pagechanged", _position); return;}
ResumableSub_vp_PageChanged rsub = new ResumableSub_vp_PageChanged(null,_position);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_vp_PageChanged extends BA.ResumableSub {
public ResumableSub_vp_PageChanged(b4a.example.act_tip parent,RemoteObject _position) {
this.parent = parent;
this._position = _position;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.act_tip parent;
RemoteObject _position;
RemoteObject _cs = RemoteObject.declareNull("anywheresoftware.b4a.objects.CSBuilder");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("vp_PageChanged (act_tip) ","act_tip",1,act_tip.mostCurrent.activityBA,act_tip.mostCurrent,75);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("Position", _position);
 BA.debugLineNum = 76;BA.debugLine="Select Position";
Debug.ShouldStop(2048);
if (true) break;

case 1:
//select
this.state = 14;
switch (BA.switchObjectToInt(_position,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
this.state = 3;
if (true) break;
}
case 1: {
this.state = 5;
if (true) break;
}
case 2: {
this.state = 7;
if (true) break;
}
case 3: {
this.state = 13;
if (true) break;
}
}
if (true) break;

case 3:
//C
this.state = 14;
 BA.debugLineNum = 78;BA.debugLine="Dim cs As CSBuilder";
Debug.ShouldStop(8192);
_cs = RemoteObject.createNew ("anywheresoftware.b4a.objects.CSBuilder");Debug.locals.put("cs", _cs);
 BA.debugLineNum = 79;BA.debugLine="cs.Initialize.Color(0xFF727272).Append(Chr(0xF1";
Debug.ShouldStop(16384);
_cs.runMethod(false,"Initialize").runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xff727272))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf111)))))).runMethod(false,"Pop").runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("   ")))).runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xffcecece))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf111)))))).runMethod(false,"Pop").runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("   ")))).runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xffcecece))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf111)))))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("   ")))).runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xffcecece))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf111)))))).runVoidMethod ("PopAll");
 BA.debugLineNum = 80;BA.debugLine="lblbol.Text=cs";
Debug.ShouldStop(32768);
parent.mostCurrent._lblbol.runMethod(true,"setText",BA.ObjectToCharSequence(_cs.getObject()));
 BA.debugLineNum = 81;BA.debugLine="lblprew.SetVisibleAnimated(500,False)";
Debug.ShouldStop(65536);
parent.mostCurrent._lblprew.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 500)),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 82;BA.debugLine="lblnext.Text=\"بعدی\"";
Debug.ShouldStop(131072);
parent.mostCurrent._lblnext.runMethod(true,"setText",BA.ObjectToCharSequence("بعدی"));
 if (true) break;

case 5:
//C
this.state = 14;
 BA.debugLineNum = 84;BA.debugLine="Dim cs As CSBuilder";
Debug.ShouldStop(524288);
_cs = RemoteObject.createNew ("anywheresoftware.b4a.objects.CSBuilder");Debug.locals.put("cs", _cs);
 BA.debugLineNum = 85;BA.debugLine="cs.Initialize.Color(0xFFCECECE).Append(Chr(0xF1";
Debug.ShouldStop(1048576);
_cs.runMethod(false,"Initialize").runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xffcecece))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf111)))))).runMethod(false,"Pop").runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("   ")))).runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xff727272))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf111)))))).runMethod(false,"Pop").runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("   ")))).runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xffcecece))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf111)))))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("   ")))).runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xffcecece))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf111)))))).runVoidMethod ("PopAll");
 BA.debugLineNum = 86;BA.debugLine="lblbol.Text=cs";
Debug.ShouldStop(2097152);
parent.mostCurrent._lblbol.runMethod(true,"setText",BA.ObjectToCharSequence(_cs.getObject()));
 BA.debugLineNum = 87;BA.debugLine="lblprew.SetVisibleAnimated(500,True)";
Debug.ShouldStop(4194304);
parent.mostCurrent._lblprew.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 500)),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 88;BA.debugLine="lblnext.Text=\"بعدی\"";
Debug.ShouldStop(8388608);
parent.mostCurrent._lblnext.runMethod(true,"setText",BA.ObjectToCharSequence("بعدی"));
 if (true) break;

case 7:
//C
this.state = 8;
 BA.debugLineNum = 90;BA.debugLine="Dim cs As CSBuilder";
Debug.ShouldStop(33554432);
_cs = RemoteObject.createNew ("anywheresoftware.b4a.objects.CSBuilder");Debug.locals.put("cs", _cs);
 BA.debugLineNum = 91;BA.debugLine="cs.Initialize.Color(0xFFCECECE).Append(Chr(0xF1";
Debug.ShouldStop(67108864);
_cs.runMethod(false,"Initialize").runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xffcecece))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf111)))))).runMethod(false,"Pop").runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("   ")))).runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xffcecece))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf111)))))).runMethod(false,"Pop").runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("   ")))).runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xff727272))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf111)))))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("   ")))).runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xffcecece))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf111)))))).runVoidMethod ("PopAll");
 BA.debugLineNum = 92;BA.debugLine="lblbol.Text=cs";
Debug.ShouldStop(134217728);
parent.mostCurrent._lblbol.runMethod(true,"setText",BA.ObjectToCharSequence(_cs.getObject()));
 BA.debugLineNum = 94;BA.debugLine="If lblnext.Text<>\"بعدی\" Then";
Debug.ShouldStop(536870912);
if (true) break;

case 8:
//if
this.state = 11;
if (RemoteObject.solveBoolean("!",parent.mostCurrent._lblnext.runMethod(true,"getText"),BA.ObjectToString("بعدی"))) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
 BA.debugLineNum = 95;BA.debugLine="lblnext.SetVisibleAnimated(200,False)";
Debug.ShouldStop(1073741824);
parent.mostCurrent._lblnext.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 200)),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 96;BA.debugLine="Sleep(200)";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("Sleep",act_tip.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "act_tip", "vp_pagechanged"),BA.numberCast(int.class, 200));
this.state = 15;
return;
case 15:
//C
this.state = 11;
;
 BA.debugLineNum = 97;BA.debugLine="lblnext.Text=\"بعدی\"";
Debug.ShouldStop(1);
parent.mostCurrent._lblnext.runMethod(true,"setText",BA.ObjectToCharSequence("بعدی"));
 BA.debugLineNum = 98;BA.debugLine="lblnext.SetVisibleAnimated(200,True)";
Debug.ShouldStop(2);
parent.mostCurrent._lblnext.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 200)),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 11:
//C
this.state = 14;
;
 BA.debugLineNum = 100;BA.debugLine="lblprew.SetVisibleAnimated(200,True)";
Debug.ShouldStop(8);
parent.mostCurrent._lblprew.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 200)),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 13:
//C
this.state = 14;
 BA.debugLineNum = 102;BA.debugLine="Dim cs As CSBuilder";
Debug.ShouldStop(32);
_cs = RemoteObject.createNew ("anywheresoftware.b4a.objects.CSBuilder");Debug.locals.put("cs", _cs);
 BA.debugLineNum = 103;BA.debugLine="cs.Initialize.Color(0xFFCECECE).Append(Chr(0xF1";
Debug.ShouldStop(64);
_cs.runMethod(false,"Initialize").runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xffcecece))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf111)))))).runMethod(false,"Pop").runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("   ")))).runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xffcecece))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf111)))))).runMethod(false,"Pop").runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("   ")))).runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xffcecece))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf111)))))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("   ")))).runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xff727272))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf111)))))).runVoidMethod ("PopAll");
 BA.debugLineNum = 104;BA.debugLine="lblbol.Text=cs";
Debug.ShouldStop(128);
parent.mostCurrent._lblbol.runMethod(true,"setText",BA.ObjectToCharSequence(_cs.getObject()));
 BA.debugLineNum = 105;BA.debugLine="lblprew.SetVisibleAnimated(500,True)";
Debug.ShouldStop(256);
parent.mostCurrent._lblprew.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 500)),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 106;BA.debugLine="lblnext.SetVisibleAnimated(200,False)";
Debug.ShouldStop(512);
parent.mostCurrent._lblnext.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 200)),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 107;BA.debugLine="Sleep(200)";
Debug.ShouldStop(1024);
parent.mostCurrent.__c.runVoidMethod ("Sleep",act_tip.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "act_tip", "vp_pagechanged"),BA.numberCast(int.class, 200));
this.state = 16;
return;
case 16:
//C
this.state = 14;
;
 BA.debugLineNum = 108;BA.debugLine="lblnext.Text=\"ورود به برنامه\"";
Debug.ShouldStop(2048);
parent.mostCurrent._lblnext.runMethod(true,"setText",BA.ObjectToCharSequence("ورود به برنامه"));
 BA.debugLineNum = 109;BA.debugLine="lblnext.SetVisibleAnimated(200,True)";
Debug.ShouldStop(4096);
parent.mostCurrent._lblnext.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 200)),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 14:
//C
this.state = -1;
;
 BA.debugLineNum = 112;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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