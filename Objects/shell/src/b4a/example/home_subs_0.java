package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class home_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (home) ","home",4,home.mostCurrent.activityBA,home.mostCurrent,29);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.home.remoteMe.runUserSub(false, "home","activity_create", _firsttime);}
RemoteObject _ac = RemoteObject.declareNull("de.amberhome.objects.appcompat.AppCompatBase");
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _oo = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _lst = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _retrofit = RemoteObject.declareNull("aghajari.retrofit.Retrofit");
RemoteObject _builder = RemoteObject.declareNull("aghajari.retrofit.Builder");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 32;BA.debugLine="Dim ac As AppCompat";
Debug.ShouldStop(-2147483648);
_ac = RemoteObject.createNew ("de.amberhome.objects.appcompat.AppCompatBase");Debug.locals.put("ac", _ac);
 BA.debugLineNum = 33;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(1);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 34;BA.debugLine="C.PnlCreate(pnl,\"\",Activity,0,0,-1,56dip+ac.GetSt";
Debug.ShouldStop(2);
home.mostCurrent._c.runVoidMethod ("_pnlcreate" /*RemoteObject*/ ,home.mostCurrent.activityBA,(Object)(_pnl),(Object)(BA.ObjectToString("")),(Object)(home.mostCurrent._activity),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(RemoteObject.solve(new RemoteObject[] {home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 56))),_ac.runMethod(true,"GetStatusBarHeight",home.mostCurrent.activityBA)}, "+",1, 1)));
 BA.debugLineNum = 35;BA.debugLine="pnl.Color=0xFF920000";
Debug.ShouldStop(4);
_pnl.runVoidMethod ("setColor",BA.numberCast(int.class, 0xff920000));
 BA.debugLineNum = 36;BA.debugLine="pnl.Elevation=4dip";
Debug.ShouldStop(8);
_pnl.runMethod(true,"setElevation",BA.numberCast(float.class, home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 4)))));
 BA.debugLineNum = 39;BA.debugLine="C.setlblset(lbltitletop,\"\",pnl,0,ac.GetStatusBarH";
Debug.ShouldStop(64);
home.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,home.mostCurrent.activityBA,(Object)(home.mostCurrent._lbltitletop),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ActivityWrapper"), _pnl.getObject()),(Object)(BA.numberCast(int.class, 0)),(Object)(_ac.runMethod(true,"GetStatusBarHeight",home.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),home.mostCurrent.activityBA),home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 56)))}, "-",1, 1)),(Object)(home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 56)))),(Object)(BA.ObjectToString("دی جی کالا")),(Object)(home.mostCurrent._c._rcenter /*RemoteObject*/ ),(Object)(home.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 20)),(Object)(home.mostCurrent.__c.getField(false,"Colors").getField(true,"White")));
 BA.debugLineNum = 41;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(256);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 42;BA.debugLine="C.setlblset(lbl,\"menue\",pnl,100%x-56dip,ac.GetSta";
Debug.ShouldStop(512);
home.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,home.mostCurrent.activityBA,(Object)(_lbl),(Object)(BA.ObjectToString("menue")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ActivityWrapper"), _pnl.getObject()),(Object)(RemoteObject.solve(new RemoteObject[] {home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),home.mostCurrent.activityBA),home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 56)))}, "-",1, 1)),(Object)(_ac.runMethod(true,"GetStatusBarHeight",home.mostCurrent.activityBA)),(Object)(home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 56)))),(Object)(home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 56)))),(Object)(BA.ObjectToString(home.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xe5d2))))),(Object)(home.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.keywords.constants.TypefaceWrapper"), home.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getMATERIALICONS")),(Object)(BA.numberCast(int.class, 25)),(Object)(home.mostCurrent.__c.getField(false,"Colors").getField(true,"White")));
 BA.debugLineNum = 43;BA.debugLine="ac.SetClickEffect(lbl,True)";
Debug.ShouldStop(1024);
_ac.runVoidMethod ("SetClickEffect",home.mostCurrent.activityBA,(Object)((_lbl.getObject())),(Object)(home.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 45;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(4096);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 46;BA.debugLine="C.setlblset(lbl,\"bask\",pnl,0,ac.GetStatusBarHeigh";
Debug.ShouldStop(8192);
home.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,home.mostCurrent.activityBA,(Object)(_lbl),(Object)(BA.ObjectToString("bask")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ActivityWrapper"), _pnl.getObject()),(Object)(BA.numberCast(int.class, 0)),(Object)(_ac.runMethod(true,"GetStatusBarHeight",home.mostCurrent.activityBA)),(Object)(home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 56)))),(Object)(home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 56)))),(Object)(BA.ObjectToString(home.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xe8cc))))),(Object)(home.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.keywords.constants.TypefaceWrapper"), home.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getMATERIALICONS")),(Object)(BA.numberCast(int.class, 25)),(Object)(home.mostCurrent.__c.getField(false,"Colors").getField(true,"White")));
 BA.debugLineNum = 47;BA.debugLine="ac.SetClickEffect(lbl,True)";
Debug.ShouldStop(16384);
_ac.runVoidMethod ("SetClickEffect",home.mostCurrent.activityBA,(Object)((_lbl.getObject())),(Object)(home.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 50;BA.debugLine="C.setlblset(lblbsk,\"bask\",pnl,30dip,ac.GetStatusB";
Debug.ShouldStop(131072);
home.mostCurrent._c.runVoidMethod ("_setlblset" /*RemoteObject*/ ,home.mostCurrent.activityBA,(Object)(home.mostCurrent._lblbsk),(Object)(BA.ObjectToString("bask")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ActivityWrapper"), _pnl.getObject()),(Object)(home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))),(Object)(RemoteObject.solve(new RemoteObject[] {_ac.runMethod(true,"GetStatusBarHeight",home.mostCurrent.activityBA),home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 6)))}, "+",1, 1)),(Object)(home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(BA.ObjectToString("1")),(Object)(home.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),(Object)(home.mostCurrent._c._irsb /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 10)),(Object)(BA.numberCast(int.class, 0xff920000)));
 BA.debugLineNum = 51;BA.debugLine="Dim oo As ColorDrawable";
Debug.ShouldStop(262144);
_oo = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("oo", _oo);
 BA.debugLineNum = 52;BA.debugLine="oo.Initialize2(-1,5555,2dip,0xFF920000)";
Debug.ShouldStop(524288);
_oo.runVoidMethod ("Initialize2",(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.numberCast(int.class, 5555)),(Object)(home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(BA.numberCast(int.class, 0xff920000)));
 BA.debugLineNum = 53;BA.debugLine="lblbsk.Background=oo";
Debug.ShouldStop(1048576);
home.mostCurrent._lblbsk.runMethod(false,"setBackground",(_oo.getObject()));
 BA.debugLineNum = 54;BA.debugLine="lblbsk.Padding = Array As Int (0, 2dip, 0, 0)";
Debug.ShouldStop(2097152);
home.mostCurrent._lblbsk.runMethod(false,"setPadding",RemoteObject.createNewArray("int",new int[] {4},new Object[] {BA.numberCast(int.class, 0),home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))),BA.numberCast(int.class, 0),BA.numberCast(int.class, 0)}));
 BA.debugLineNum = 56;BA.debugLine="sv.Initialize(420%x)";
Debug.ShouldStop(8388608);
home.mostCurrent._sv.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 420)),home.mostCurrent.activityBA)));
 BA.debugLineNum = 57;BA.debugLine="Activity.AddView(sv,0,56dip+ac.GetStatusBarHeight";
Debug.ShouldStop(16777216);
home.mostCurrent._activity.runVoidMethod ("AddView",(Object)((home.mostCurrent._sv.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 56))),_ac.runMethod(true,"GetStatusBarHeight",home.mostCurrent.activityBA)}, "+",1, 1)),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),home.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {home.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),home.mostCurrent.activityBA),(RemoteObject.solve(new RemoteObject[] {home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 56))),_ac.runMethod(true,"GetStatusBarHeight",home.mostCurrent.activityBA)}, "+",1, 1))}, "-",1, 1)));
 BA.debugLineNum = 61;BA.debugLine="Dim lst As List";
Debug.ShouldStop(268435456);
_lst = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("lst", _lst);
 BA.debugLineNum = 62;BA.debugLine="lst.Initialize";
Debug.ShouldStop(536870912);
_lst.runVoidMethod ("Initialize");
 BA.debugLineNum = 63;BA.debugLine="lst.Add(\"سلام#سلام\")";
Debug.ShouldStop(1073741824);
_lst.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("سلام#سلام"))));
 BA.debugLineNum = 64;BA.debugLine="lst.Add(\"سلایلبلم#سلامسلام\")";
Debug.ShouldStop(-2147483648);
_lst.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("سلایلبلم#سلامسلام"))));
 BA.debugLineNum = 65;BA.debugLine="lst.Add(\"سلازذفاتم#سلام\")";
Debug.ShouldStop(1);
_lst.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("سلازذفاتم#سلام"))));
 BA.debugLineNum = 66;BA.debugLine="lst.Add(\"سهعهعهلام#سلامسلامسلام\")";
Debug.ShouldStop(2);
_lst.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("سهعهعهلام#سلامسلامسلام"))));
 BA.debugLineNum = 67;BA.debugLine="lst.Add(\"سلایلبلم#سلامسلام\")";
Debug.ShouldStop(4);
_lst.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("سلایلبلم#سلامسلام"))));
 BA.debugLineNum = 68;BA.debugLine="lst.Add(\"سلایلبلم#سلامسلام\")";
Debug.ShouldStop(8);
_lst.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("سلایلبلم#سلامسلام"))));
 BA.debugLineNum = 69;BA.debugLine="lst.Add(\"سلازذفاتم#سلام\")";
Debug.ShouldStop(16);
_lst.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("سلازذفاتم#سلام"))));
 BA.debugLineNum = 70;BA.debugLine="lst.Add(\"سهعهعهلام#سلامسلامسلام\")";
Debug.ShouldStop(32);
_lst.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("سهعهعهلام#سلامسلامسلام"))));
 BA.debugLineNum = 71;BA.debugLine="lst.Add(\"سلازذفاتم#سلام\")";
Debug.ShouldStop(64);
_lst.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("سلازذفاتم#سلام"))));
 BA.debugLineNum = 72;BA.debugLine="lst.Add(\"سهعهعهلام#سلامسلامdfسلام\")";
Debug.ShouldStop(128);
_lst.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("سهعهعهلام#سلامسلامdfسلام"))));
 BA.debugLineNum = 74;BA.debugLine="Dim lst As List";
Debug.ShouldStop(512);
_lst = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("lst", _lst);
 BA.debugLineNum = 75;BA.debugLine="lst.Initialize";
Debug.ShouldStop(1024);
_lst.runVoidMethod ("Initialize");
 BA.debugLineNum = 76;BA.debugLine="lst.Add(\"http://bamalearn.ir/wp-content/uploads/2";
Debug.ShouldStop(2048);
_lst.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("http://bamalearn.ir/wp-content/uploads/2019/04/rtl-toolbar-b4a-348x215.jpg"))));
 BA.debugLineNum = 77;BA.debugLine="lst.Add(\"http://bamalearn.ir/wp-content/uploads/2";
Debug.ShouldStop(4096);
_lst.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("http://bamalearn.ir/wp-content/uploads/2019/04/rtl-toolbar-b4a-348x215.jpg"))));
 BA.debugLineNum = 87;BA.debugLine="Dim retrofit As Amir_Retrofit";
Debug.ShouldStop(4194304);
_retrofit = RemoteObject.createNew ("aghajari.retrofit.Retrofit");Debug.locals.put("retrofit", _retrofit);
 BA.debugLineNum = 88;BA.debugLine="Dim Builder As Amir_RetrofitBuilder";
Debug.ShouldStop(8388608);
_builder = RemoteObject.createNew ("aghajari.retrofit.Builder");Debug.locals.put("Builder", _builder);
 BA.debugLineNum = 91;BA.debugLine="Builder.Initialize.baseUrl(\"https://jeebres.ir/ap";
Debug.ShouldStop(67108864);
_builder.runMethod(false,"Initialize",home.processBA).runVoidMethod ("baseUrl",(Object)(RemoteObject.createImmutable("https://jeebres.ir/api/v1/y88d/")));
 BA.debugLineNum = 93;BA.debugLine="Builder.addHeader(CreateMap(\"appkey\":\"78e0b233fd4";
Debug.ShouldStop(268435456);
_builder.runVoidMethod ("addHeader",(Object)((home.mostCurrent.__c.runMethod(false, "createMap", (Object)(new RemoteObject[] {RemoteObject.createImmutable(("appkey")),(RemoteObject.createImmutable("78e0b233fd4ffc5ffd1eb839158c4a2d"))})).getObject())));
 BA.debugLineNum = 94;BA.debugLine="retrofit.Initialize(Builder)";
Debug.ShouldStop(536870912);
_retrofit.runVoidMethod ("Initialize",home.processBA,(Object)(_builder));
 BA.debugLineNum = 95;BA.debugLine="retrofit.Get(\"maindata\",\"app\",Null)";
Debug.ShouldStop(1073741824);
_retrofit.runVoidMethod ("Get",(Object)(BA.ObjectToString("maindata")),(Object)(BA.ObjectToString("app")),(Object)((home.mostCurrent.__c.getField(false,"Null"))));
 BA.debugLineNum = 96;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Activity_Pause (home) ","home",4,home.mostCurrent.activityBA,home.mostCurrent,424);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.home.remoteMe.runUserSub(false, "home","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 424;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(128);
 BA.debugLineNum = 425;BA.debugLine="t_shegeft.Enabled=False";
Debug.ShouldStop(256);
home._t_shegeft.runMethod(true,"setEnabled",home.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 426;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("Activity_Resume (home) ","home",4,home.mostCurrent.activityBA,home.mostCurrent,420);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.home.remoteMe.runUserSub(false, "home","activity_resume");}
 BA.debugLineNum = 420;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8);
 BA.debugLineNum = 422;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _banner1taee_card_creat(RemoteObject _top,RemoteObject _heat,RemoteObject _link,RemoteObject _action) throws Exception{
try {
		Debug.PushSubsStack("banner1taee_card_creat (home) ","home",4,home.mostCurrent.activityBA,home.mostCurrent,448);
if (RapidSub.canDelegate("banner1taee_card_creat")) { return b4a.example.home.remoteMe.runUserSub(false, "home","banner1taee_card_creat", _top, _heat, _link, _action);}
RemoteObject _card = RemoteObject.declareNull("de.amberhome.objects.CardViewWrapper");
RemoteObject _img = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _glide = RemoteObject.declareNull("com.hitex_glide.Hitex_Glide");
Debug.locals.put("top", _top);
Debug.locals.put("heat", _heat);
Debug.locals.put("link", _link);
Debug.locals.put("action", _action);
 BA.debugLineNum = 448;BA.debugLine="Sub banner1taee_card_creat(top As Int,heat As Int,";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 449;BA.debugLine="Dim card As CardView";
Debug.ShouldStop(1);
_card = RemoteObject.createNew ("de.amberhome.objects.CardViewWrapper");Debug.locals.put("card", _card);
 BA.debugLineNum = 450;BA.debugLine="card.Initialize(\"\")";
Debug.ShouldStop(2);
_card.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 451;BA.debugLine="card.Elevation=2dip";
Debug.ShouldStop(4);
_card.runMethod(true,"setElevation",BA.numberCast(float.class, home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 452;BA.debugLine="sv.Panel.AddView(card,2%x,top,96%x,heat*1%x)";
Debug.ShouldStop(8);
home.mostCurrent._sv.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_card.getObject())),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 2)),home.mostCurrent.activityBA)),(Object)(_top),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 96)),home.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {_heat,home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),home.mostCurrent.activityBA)}, "*",0, 1)));
 BA.debugLineNum = 453;BA.debugLine="Dim img As ImageView";
Debug.ShouldStop(16);
_img = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("img", _img);
 BA.debugLineNum = 454;BA.debugLine="img.Initialize(\"\")";
Debug.ShouldStop(32);
_img.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 455;BA.debugLine="card.AddView(img,0,0,-1,-1)";
Debug.ShouldStop(64);
_card.runVoidMethod ("AddView",(Object)((_img.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.numberCast(int.class, -(double) (0 + 1))));
 BA.debugLineNum = 456;BA.debugLine="img.Gravity=Gravity.FILL";
Debug.ShouldStop(128);
_img.runMethod(true,"setGravity",home.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 457;BA.debugLine="Dim Glide As Hitex_Glide";
Debug.ShouldStop(256);
_glide = RemoteObject.createNew ("com.hitex_glide.Hitex_Glide");Debug.locals.put("Glide", _glide);
 BA.debugLineNum = 458;BA.debugLine="Glide.Load2(link).CenterCrop.Into(img)";
Debug.ShouldStop(512);
_glide.runMethod(false,"Load2",home.mostCurrent.activityBA,(Object)(_link)).runMethod(false,"CenterCrop").runVoidMethod ("Into",(Object)(_img));
 BA.debugLineNum = 459;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _banner1taee_creat(RemoteObject _top,RemoteObject _heat,RemoteObject _link,RemoteObject _action) throws Exception{
try {
		Debug.PushSubsStack("banner1taee_creat (home) ","home",4,home.mostCurrent.activityBA,home.mostCurrent,428);
if (RapidSub.canDelegate("banner1taee_creat")) { return b4a.example.home.remoteMe.runUserSub(false, "home","banner1taee_creat", _top, _heat, _link, _action);}
RemoteObject _img = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _glide = RemoteObject.declareNull("com.hitex_glide.Hitex_Glide");
Debug.locals.put("top", _top);
Debug.locals.put("heat", _heat);
Debug.locals.put("link", _link);
Debug.locals.put("action", _action);
 BA.debugLineNum = 428;BA.debugLine="Sub banner1taee_creat(top As Int,heat As Int,link";
Debug.ShouldStop(2048);
 BA.debugLineNum = 429;BA.debugLine="Dim img As ImageView";
Debug.ShouldStop(4096);
_img = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("img", _img);
 BA.debugLineNum = 430;BA.debugLine="C.imgCreate(img,\"\",sv.Panel,0,top,100%x,heat*1%x)";
Debug.ShouldStop(8192);
home.mostCurrent._c.runVoidMethod ("_imgcreate" /*RemoteObject*/ ,home.mostCurrent.activityBA,(Object)(_img),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ActivityWrapper"), home.mostCurrent._sv.runMethod(false,"getPanel").getObject()),(Object)(BA.numberCast(int.class, 0)),(Object)(_top),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),home.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {_heat,home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),home.mostCurrent.activityBA)}, "*",0, 1)));
 BA.debugLineNum = 431;BA.debugLine="Dim Glide As Hitex_Glide";
Debug.ShouldStop(16384);
_glide = RemoteObject.createNew ("com.hitex_glide.Hitex_Glide");Debug.locals.put("Glide", _glide);
 BA.debugLineNum = 432;BA.debugLine="Glide.Load2(link).FitCenter.Into(img)";
Debug.ShouldStop(32768);
_glide.runMethod(false,"Load2",home.mostCurrent.activityBA,(Object)(_link)).runMethod(false,"FitCenter").runVoidMethod ("Into",(Object)(_img));
 BA.debugLineNum = 433;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _banner2taee_card_creat(RemoteObject _top,RemoteObject _heat,RemoteObject _listbannerpager) throws Exception{
try {
		Debug.PushSubsStack("banner2taee_card_creat (home) ","home",4,home.mostCurrent.activityBA,home.mostCurrent,460);
if (RapidSub.canDelegate("banner2taee_card_creat")) { return b4a.example.home.remoteMe.runUserSub(false, "home","banner2taee_card_creat", _top, _heat, _listbannerpager);}
RemoteObject _h13 = null;
RemoteObject _card = RemoteObject.declareNull("de.amberhome.objects.CardViewWrapper");
RemoteObject _img = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _glide = RemoteObject.declareNull("com.hitex_glide.Hitex_Glide");
Debug.locals.put("top", _top);
Debug.locals.put("heat", _heat);
Debug.locals.put("ListbannerPager", _listbannerpager);
 BA.debugLineNum = 460;BA.debugLine="Sub banner2taee_card_creat(top As Int,heat As Int,";
Debug.ShouldStop(2048);
 BA.debugLineNum = 461;BA.debugLine="Dim h13() As String=Regex.Split(\"#\",ListbannerPag";
Debug.ShouldStop(4096);
_h13 = home.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString("#")),(Object)(BA.ObjectToString(_listbannerpager.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))));Debug.locals.put("h13", _h13);Debug.locals.put("h13", _h13);
 BA.debugLineNum = 463;BA.debugLine="Dim card As CardView";
Debug.ShouldStop(16384);
_card = RemoteObject.createNew ("de.amberhome.objects.CardViewWrapper");Debug.locals.put("card", _card);
 BA.debugLineNum = 464;BA.debugLine="card.Initialize(\"\")";
Debug.ShouldStop(32768);
_card.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 465;BA.debugLine="card.Elevation=2dip";
Debug.ShouldStop(65536);
_card.runMethod(true,"setElevation",BA.numberCast(float.class, home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 466;BA.debugLine="sv.Panel.AddView(card,2%x,top,47%x,heat*1%x)";
Debug.ShouldStop(131072);
home.mostCurrent._sv.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_card.getObject())),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 2)),home.mostCurrent.activityBA)),(Object)(_top),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 47)),home.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {_heat,home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),home.mostCurrent.activityBA)}, "*",0, 1)));
 BA.debugLineNum = 467;BA.debugLine="Dim img As ImageView";
Debug.ShouldStop(262144);
_img = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("img", _img);
 BA.debugLineNum = 468;BA.debugLine="img.Initialize(\"\")";
Debug.ShouldStop(524288);
_img.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 469;BA.debugLine="card.AddView(img,0,0,-1,-1)";
Debug.ShouldStop(1048576);
_card.runVoidMethod ("AddView",(Object)((_img.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.numberCast(int.class, -(double) (0 + 1))));
 BA.debugLineNum = 470;BA.debugLine="img.Gravity=Gravity.FILL";
Debug.ShouldStop(2097152);
_img.runMethod(true,"setGravity",home.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 471;BA.debugLine="Dim Glide As Hitex_Glide";
Debug.ShouldStop(4194304);
_glide = RemoteObject.createNew ("com.hitex_glide.Hitex_Glide");Debug.locals.put("Glide", _glide);
 BA.debugLineNum = 472;BA.debugLine="Glide.Load2(h13(0)).CenterCrop.Into(img)";
Debug.ShouldStop(8388608);
_glide.runMethod(false,"Load2",home.mostCurrent.activityBA,(Object)(_h13.getArrayElement(true,BA.numberCast(int.class, 0)))).runMethod(false,"CenterCrop").runVoidMethod ("Into",(Object)(_img));
 BA.debugLineNum = 474;BA.debugLine="Dim h13() As String=Regex.Split(\"#\",ListbannerPag";
Debug.ShouldStop(33554432);
_h13 = home.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString("#")),(Object)(BA.ObjectToString(_listbannerpager.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))));Debug.locals.put("h13", _h13);Debug.locals.put("h13", _h13);
 BA.debugLineNum = 475;BA.debugLine="Dim card As CardView";
Debug.ShouldStop(67108864);
_card = RemoteObject.createNew ("de.amberhome.objects.CardViewWrapper");Debug.locals.put("card", _card);
 BA.debugLineNum = 476;BA.debugLine="card.Initialize(\"\")";
Debug.ShouldStop(134217728);
_card.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 477;BA.debugLine="card.Elevation=2dip";
Debug.ShouldStop(268435456);
_card.runMethod(true,"setElevation",BA.numberCast(float.class, home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 478;BA.debugLine="sv.Panel.AddView(card,51%x,top,47%x,heat*1%x)";
Debug.ShouldStop(536870912);
home.mostCurrent._sv.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_card.getObject())),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 51)),home.mostCurrent.activityBA)),(Object)(_top),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 47)),home.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {_heat,home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),home.mostCurrent.activityBA)}, "*",0, 1)));
 BA.debugLineNum = 479;BA.debugLine="Dim img As ImageView";
Debug.ShouldStop(1073741824);
_img = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("img", _img);
 BA.debugLineNum = 480;BA.debugLine="img.Initialize(\"\")";
Debug.ShouldStop(-2147483648);
_img.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 481;BA.debugLine="card.AddView(img,0,0,-1,-1)";
Debug.ShouldStop(1);
_card.runVoidMethod ("AddView",(Object)((_img.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.numberCast(int.class, -(double) (0 + 1))));
 BA.debugLineNum = 482;BA.debugLine="img.Gravity=Gravity.FILL";
Debug.ShouldStop(2);
_img.runMethod(true,"setGravity",home.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 483;BA.debugLine="Dim Glide As Hitex_Glide";
Debug.ShouldStop(4);
_glide = RemoteObject.createNew ("com.hitex_glide.Hitex_Glide");Debug.locals.put("Glide", _glide);
 BA.debugLineNum = 484;BA.debugLine="Glide.Load2(h13(0)).CenterCrop.Into(img)";
Debug.ShouldStop(8);
_glide.runMethod(false,"Load2",home.mostCurrent.activityBA,(Object)(_h13.getArrayElement(true,BA.numberCast(int.class, 0)))).runMethod(false,"CenterCrop").runVoidMethod ("Into",(Object)(_img));
 BA.debugLineNum = 485;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _banner2taee_creat(RemoteObject _top,RemoteObject _heat,RemoteObject _listbannerpager) throws Exception{
try {
		Debug.PushSubsStack("banner2taee_creat (home) ","home",4,home.mostCurrent.activityBA,home.mostCurrent,434);
if (RapidSub.canDelegate("banner2taee_creat")) { return b4a.example.home.remoteMe.runUserSub(false, "home","banner2taee_creat", _top, _heat, _listbannerpager);}
RemoteObject _h13 = null;
RemoteObject _img = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _glide = RemoteObject.declareNull("com.hitex_glide.Hitex_Glide");
Debug.locals.put("top", _top);
Debug.locals.put("heat", _heat);
Debug.locals.put("ListbannerPager", _listbannerpager);
 BA.debugLineNum = 434;BA.debugLine="Sub banner2taee_creat(top As Int,heat As Int,Listb";
Debug.ShouldStop(131072);
 BA.debugLineNum = 435;BA.debugLine="Dim h13() As String=Regex.Split(\"#\",ListbannerPag";
Debug.ShouldStop(262144);
_h13 = home.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString("#")),(Object)(BA.ObjectToString(_listbannerpager.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))));Debug.locals.put("h13", _h13);Debug.locals.put("h13", _h13);
 BA.debugLineNum = 436;BA.debugLine="Dim img As ImageView";
Debug.ShouldStop(524288);
_img = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("img", _img);
 BA.debugLineNum = 437;BA.debugLine="C.imgCreate(img,\"\",sv.Panel,0,top,50%x,heat*1%x)";
Debug.ShouldStop(1048576);
home.mostCurrent._c.runVoidMethod ("_imgcreate" /*RemoteObject*/ ,home.mostCurrent.activityBA,(Object)(_img),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ActivityWrapper"), home.mostCurrent._sv.runMethod(false,"getPanel").getObject()),(Object)(BA.numberCast(int.class, 0)),(Object)(_top),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),home.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {_heat,home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),home.mostCurrent.activityBA)}, "*",0, 1)));
 BA.debugLineNum = 438;BA.debugLine="Dim Glide As Hitex_Glide";
Debug.ShouldStop(2097152);
_glide = RemoteObject.createNew ("com.hitex_glide.Hitex_Glide");Debug.locals.put("Glide", _glide);
 BA.debugLineNum = 439;BA.debugLine="Glide.Load2(h13(0)).FitCenter.Into(img)";
Debug.ShouldStop(4194304);
_glide.runMethod(false,"Load2",home.mostCurrent.activityBA,(Object)(_h13.getArrayElement(true,BA.numberCast(int.class, 0)))).runMethod(false,"FitCenter").runVoidMethod ("Into",(Object)(_img));
 BA.debugLineNum = 441;BA.debugLine="Dim h13() As String=Regex.Split(\"#\",ListbannerPag";
Debug.ShouldStop(16777216);
_h13 = home.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString("#")),(Object)(BA.ObjectToString(_listbannerpager.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))));Debug.locals.put("h13", _h13);Debug.locals.put("h13", _h13);
 BA.debugLineNum = 442;BA.debugLine="Dim img As ImageView";
Debug.ShouldStop(33554432);
_img = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("img", _img);
 BA.debugLineNum = 443;BA.debugLine="C.imgCreate(img,\"\",sv.Panel,50%x,top,50%x,heat*1%";
Debug.ShouldStop(67108864);
home.mostCurrent._c.runVoidMethod ("_imgcreate" /*RemoteObject*/ ,home.mostCurrent.activityBA,(Object)(_img),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ActivityWrapper"), home.mostCurrent._sv.runMethod(false,"getPanel").getObject()),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),home.mostCurrent.activityBA)),(Object)(_top),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),home.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {_heat,home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),home.mostCurrent.activityBA)}, "*",0, 1)));
 BA.debugLineNum = 444;BA.debugLine="Dim Glide As Hitex_Glide";
Debug.ShouldStop(134217728);
_glide = RemoteObject.createNew ("com.hitex_glide.Hitex_Glide");Debug.locals.put("Glide", _glide);
 BA.debugLineNum = 445;BA.debugLine="Glide.Load2(h13(0)).FitCenter.Into(img)";
Debug.ShouldStop(268435456);
_glide.runMethod(false,"Load2",home.mostCurrent.activityBA,(Object)(_h13.getArrayElement(true,BA.numberCast(int.class, 0)))).runMethod(false,"FitCenter").runVoidMethod ("Into",(Object)(_img));
 BA.debugLineNum = 446;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _banners_create(RemoteObject _top,RemoteObject _heat,RemoteObject _listbannerpager) throws Exception{
try {
		Debug.PushSubsStack("banners_create (home) ","home",4,home.mostCurrent.activityBA,home.mostCurrent,486);
if (RapidSub.canDelegate("banners_create")) { return b4a.example.home.remoteMe.runUserSub(false, "home","banners_create", _top, _heat, _listbannerpager);}
int _i = 0;
RemoteObject _h13 = null;
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _img = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _glide = RemoteObject.declareNull("com.hitex_glide.Hitex_Glide");
Debug.locals.put("top", _top);
Debug.locals.put("heat", _heat);
Debug.locals.put("ListbannerPager", _listbannerpager);
 BA.debugLineNum = 486;BA.debugLine="Sub banners_create(top As Int,heat As Int,Listbann";
Debug.ShouldStop(32);
 BA.debugLineNum = 487;BA.debugLine="pa.Initialize";
Debug.ShouldStop(64);
home.mostCurrent._pa.runVoidMethod ("Initialize",home.mostCurrent.activityBA);
 BA.debugLineNum = 489;BA.debugLine="For i = 0 To ListbannerPager.Size-1";
Debug.ShouldStop(256);
{
final int step2 = 1;
final int limit2 = RemoteObject.solve(new RemoteObject[] {_listbannerpager.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2) ;_i = ((int)(0 + _i + step2))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 490;BA.debugLine="Dim h13() As String=Regex.Split(\"#\",ListbannerPa";
Debug.ShouldStop(512);
_h13 = home.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString("#")),(Object)(BA.ObjectToString(_listbannerpager.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))));Debug.locals.put("h13", _h13);Debug.locals.put("h13", _h13);
 BA.debugLineNum = 491;BA.debugLine="Dim p As Panel";
Debug.ShouldStop(1024);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 492;BA.debugLine="p.Initialize(\"banners\")";
Debug.ShouldStop(2048);
_p.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("banners")));
 BA.debugLineNum = 493;BA.debugLine="Dim img As ImageView";
Debug.ShouldStop(4096);
_img = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("img", _img);
 BA.debugLineNum = 494;BA.debugLine="img.Initialize(\"\")";
Debug.ShouldStop(8192);
_img.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 495;BA.debugLine="p.AddView(img,0,0,-1,-1)";
Debug.ShouldStop(16384);
_p.runVoidMethod ("AddView",(Object)((_img.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.numberCast(int.class, -(double) (0 + 1))));
 BA.debugLineNum = 496;BA.debugLine="Dim Glide As Hitex_Glide";
Debug.ShouldStop(32768);
_glide = RemoteObject.createNew ("com.hitex_glide.Hitex_Glide");Debug.locals.put("Glide", _glide);
 BA.debugLineNum = 497;BA.debugLine="Glide.Load2(h13(0)).FitCenter.Into(img)";
Debug.ShouldStop(65536);
_glide.runMethod(false,"Load2",home.mostCurrent.activityBA,(Object)(_h13.getArrayElement(true,BA.numberCast(int.class, 0)))).runMethod(false,"FitCenter").runVoidMethod ("Into",(Object)(_img));
 BA.debugLineNum = 498;BA.debugLine="pa.AddPage(p)";
Debug.ShouldStop(131072);
home.mostCurrent._pa.runVoidMethod ("AddPage",(Object)((_p.getObject())));
 BA.debugLineNum = 499;BA.debugLine="p.Tag=ListbannerPager.Get(i)";
Debug.ShouldStop(262144);
_p.runMethod(false,"setTag",_listbannerpager.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 502;BA.debugLine="pb.Initialize(pa,\"pb\")";
Debug.ShouldStop(2097152);
home.mostCurrent._pb.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(home.mostCurrent._pa),(Object)(RemoteObject.createImmutable("pb")));
 BA.debugLineNum = 503;BA.debugLine="pb.setDotsColor(0xFF008C79,0x7E008C79)";
Debug.ShouldStop(4194304);
home.mostCurrent._pb.runVoidMethod ("setDotsColor",(Object)(BA.numberCast(int.class, 0xff008c79)),(Object)(BA.numberCast(int.class, 0x7e008c79)));
 BA.debugLineNum = 504;BA.debugLine="pb.Transition = pb.PARALLAX_PAGE";
Debug.ShouldStop(8388608);
home.mostCurrent._pb.runVoidMethod ("setTransition",home.mostCurrent._pb.getField(true,"PARALLAX_PAGE"));
 BA.debugLineNum = 505;BA.debugLine="sv.Panel.AddView(pb,0,top,100%x,heat*1%x)";
Debug.ShouldStop(16777216);
home.mostCurrent._sv.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((home.mostCurrent._pb.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_top),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),home.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {_heat,home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),home.mostCurrent.activityBA)}, "*",0, 1)));
 BA.debugLineNum = 506;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _cat_create(RemoteObject _top,RemoteObject _lst) throws Exception{
try {
		Debug.PushSubsStack("cat_create (home) ","home",4,home.mostCurrent.activityBA,home.mostCurrent,507);
if (RapidSub.canDelegate("cat_create")) { b4a.example.home.remoteMe.runUserSub(false, "home","cat_create", _top, _lst); return;}
ResumableSub_cat_create rsub = new ResumableSub_cat_create(null,_top,_lst);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_cat_create extends BA.ResumableSub {
public ResumableSub_cat_create(b4a.example.home parent,RemoteObject _top,RemoteObject _lst) {
this.parent = parent;
this._top = _top;
this._lst = _lst;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.home parent;
RemoteObject _top;
RemoteObject _lst;
RemoteObject _sv1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper");
RemoteObject _withs = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _card = RemoteObject.declareNull("de.amberhome.objects.CardViewWrapper");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _pnlk = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _h13 = null;
int step5;
int limit5;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("cat_create (home) ","home",4,home.mostCurrent.activityBA,home.mostCurrent,507);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("top", _top);
Debug.locals.put("lst", _lst);
 BA.debugLineNum = 508;BA.debugLine="Dim sv1 As HorizontalScrollView";
Debug.ShouldStop(134217728);
_sv1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper");Debug.locals.put("sv1", _sv1);
 BA.debugLineNum = 509;BA.debugLine="sv1.Initialize(550dip,\"\")";
Debug.ShouldStop(268435456);
_sv1.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 550)))),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 510;BA.debugLine="sv.Panel.AddView(sv1,0,top+1%x,100%x,12%x)";
Debug.ShouldStop(536870912);
parent.mostCurrent._sv.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_sv1.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_top,parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),home.mostCurrent.activityBA)}, "+",1, 1)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),home.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 12)),home.mostCurrent.activityBA)));
 BA.debugLineNum = 511;BA.debugLine="Dim withs As Int = 1%x";
Debug.ShouldStop(1073741824);
_withs = parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),home.mostCurrent.activityBA);Debug.locals.put("withs", _withs);Debug.locals.put("withs", _withs);
 BA.debugLineNum = 512;BA.debugLine="For i = 0 To lst.Size-1";
Debug.ShouldStop(-2147483648);
if (true) break;

case 1:
//for
this.state = 4;
step5 = 1;
limit5 = RemoteObject.solve(new RemoteObject[] {_lst.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
Debug.locals.put("i", _i);
this.state = 5;
if (true) break;

case 5:
//C
this.state = 4;
if ((step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5)) this.state = 3;
if (true) break;

case 6:
//C
this.state = 5;
_i = ((int)(0 + _i + step5)) ;
Debug.locals.put("i", _i);
if (true) break;

case 3:
//C
this.state = 6;
 BA.debugLineNum = 514;BA.debugLine="Dim card As CardView";
Debug.ShouldStop(2);
_card = RemoteObject.createNew ("de.amberhome.objects.CardViewWrapper");Debug.locals.put("card", _card);
 BA.debugLineNum = 515;BA.debugLine="card.Initialize(\"\")";
Debug.ShouldStop(4);
_card.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 516;BA.debugLine="card.Elevation=0";
Debug.ShouldStop(8);
_card.runMethod(true,"setElevation",BA.numberCast(float.class, 0));
 BA.debugLineNum = 517;BA.debugLine="sv1.Panel.AddView(card,withs,1%x,-1,10%x)";
Debug.ShouldStop(16);
_sv1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_card.getObject())),(Object)(_withs),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),home.mostCurrent.activityBA)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),home.mostCurrent.activityBA)));
 BA.debugLineNum = 518;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(32);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 519;BA.debugLine="cd.Initialize(0xFF00C6C6, 500dip)";
Debug.ShouldStop(64);
_cd.runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 0xff00c6c6)),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 500)))));
 BA.debugLineNum = 522;BA.debugLine="Dim pnlk As Panel";
Debug.ShouldStop(512);
_pnlk = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnlk", _pnlk);
 BA.debugLineNum = 523;BA.debugLine="pnlk.Initialize(\"\")";
Debug.ShouldStop(1024);
_pnlk.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 524;BA.debugLine="card.AddView(pnlk,0,0,-1,-1)";
Debug.ShouldStop(2048);
_card.runVoidMethod ("AddView",(Object)((_pnlk.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.numberCast(int.class, -(double) (0 + 1))));
 BA.debugLineNum = 525;BA.debugLine="pnlk.Background = cd";
Debug.ShouldStop(4096);
_pnlk.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 527;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(16384);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 528;BA.debugLine="lbl.Initialize(\"\")";
Debug.ShouldStop(32768);
_lbl.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 529;BA.debugLine="lbl.TextColor=Colors.White";
Debug.ShouldStop(65536);
_lbl.runMethod(true,"setTextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 530;BA.debugLine="lbl.Gravity=Gravity.CENTER";
Debug.ShouldStop(131072);
_lbl.runMethod(true,"setGravity",parent.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 531;BA.debugLine="lbl.Typeface=C.irs";
Debug.ShouldStop(262144);
_lbl.runMethod(false,"setTypeface",(parent.mostCurrent._c._irs /*RemoteObject*/ .getObject()));
 BA.debugLineNum = 532;BA.debugLine="lbl.TextSize=15";
Debug.ShouldStop(524288);
_lbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 533;BA.debugLine="pnlk.AddView(lbl,0,0%x,-1,9%x)";
Debug.ShouldStop(1048576);
_pnlk.runVoidMethod ("AddView",(Object)((_lbl.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 0)),home.mostCurrent.activityBA)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 9)),home.mostCurrent.activityBA)));
 BA.debugLineNum = 535;BA.debugLine="Dim h13() As String=Regex.Split(\"#\",lst.Get(i))";
Debug.ShouldStop(4194304);
_h13 = parent.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString("#")),(Object)(BA.ObjectToString(_lst.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))));Debug.locals.put("h13", _h13);Debug.locals.put("h13", _h13);
 BA.debugLineNum = 537;BA.debugLine="lbl.Text=h13(1)";
Debug.ShouldStop(16777216);
_lbl.runMethod(true,"setText",BA.ObjectToCharSequence(_h13.getArrayElement(true,BA.numberCast(int.class, 1))));
 BA.debugLineNum = 539;BA.debugLine="card.Width=C.GetTextWidth(lbl)+10%x";
Debug.ShouldStop(67108864);
_card.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._c.runMethod(true,"_gettextwidth" /*RemoteObject*/ ,home.mostCurrent.activityBA,(Object)(_lbl)),parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),home.mostCurrent.activityBA)}, "+",1, 0)));
 BA.debugLineNum = 540;BA.debugLine="withs=withs+C.GetTextWidth(lbl)+12%x";
Debug.ShouldStop(134217728);
_withs = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_withs,parent.mostCurrent._c.runMethod(true,"_gettextwidth" /*RemoteObject*/ ,home.mostCurrent.activityBA,(Object)(_lbl)),parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 12)),home.mostCurrent.activityBA)}, "++",2, 0));Debug.locals.put("withs", _withs);
 BA.debugLineNum = 541;BA.debugLine="sv1.Panel.Width=withs";
Debug.ShouldStop(268435456);
_sv1.runMethod(false,"getPanel").runMethod(true,"setWidth",_withs);
 if (true) break;
if (true) break;

case 4:
//C
this.state = -1;
Debug.locals.put("i", _i);
;
 BA.debugLineNum = 544;BA.debugLine="Sleep(0)";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("Sleep",home.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "home", "cat_create"),BA.numberCast(int.class, 0));
this.state = 7;
return;
case 7:
//C
this.state = -1;
;
 BA.debugLineNum = 545;BA.debugLine="sv1.ScrollPosition=withs+9%x";
Debug.ShouldStop(1);
_sv1.runMethod(true,"setScrollPosition",RemoteObject.solve(new RemoteObject[] {_withs,parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 9)),home.mostCurrent.activityBA)}, "+",1, 1));
 BA.debugLineNum = 546;BA.debugLine="End Sub";
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim lblbsk As Label";
home.mostCurrent._lblbsk = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Dim sv As ScrollView";
home.mostCurrent._sv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Dim pb As PagerBullet";
home.mostCurrent._pb = RemoteObject.createNew ("com.porya.pagerbullet.PagerBulletWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Dim pa As PagerBulletAdapter";
home.mostCurrent._pa = RemoteObject.createNew ("com.porya.pagerbullet.PagerBulletAdapter");
 //BA.debugLineNum = 21;BA.debugLine="Dim lblho As Label";
home.mostCurrent._lblho = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Dim lblmin As Label";
home.mostCurrent._lblmin = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Dim lblsecend As Label";
home.mostCurrent._lblsecend = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Dim time313 As Long";
home._time313 = RemoteObject.createImmutable(0L);
 //BA.debugLineNum = 25;BA.debugLine="Dim lbltitletop As Label";
home.mostCurrent._lbltitletop = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Dim LV_prod(10) As Hitex_LayoutView";
home.mostCurrent._lv_prod = RemoteObject.createNewArray ("wir.hitex.recycler.Hitex_LayoutView", new int[] {10}, new Object[]{});
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _maindata_oncompleted() throws Exception{
try {
		Debug.PushSubsStack("maindata_onCompleted (home) ","home",4,home.mostCurrent.activityBA,home.mostCurrent,97);
if (RapidSub.canDelegate("maindata_oncompleted")) { return b4a.example.home.remoteMe.runUserSub(false, "home","maindata_oncompleted");}
 BA.debugLineNum = 97;BA.debugLine="Sub maindata_onCompleted      '💎💎💎           Po";
Debug.ShouldStop(1);
 BA.debugLineNum = 101;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _maindata_onerror(RemoteObject _error,RemoteObject _code) throws Exception{
try {
		Debug.PushSubsStack("maindata_onError (home) ","home",4,home.mostCurrent.activityBA,home.mostCurrent,102);
if (RapidSub.canDelegate("maindata_onerror")) { return b4a.example.home.remoteMe.runUserSub(false, "home","maindata_onerror", _error, _code);}
Debug.locals.put("Error", _error);
Debug.locals.put("Code", _code);
 BA.debugLineNum = 102;BA.debugLine="Sub maindata_onError (Error As String,Code As Int)";
Debug.ShouldStop(32);
 BA.debugLineNum = 103;BA.debugLine="Log(Error)";
Debug.ShouldStop(64);
home.mostCurrent.__c.runVoidMethod ("LogImpl","39175041",_error,0);
 BA.debugLineNum = 104;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _maindata_onnext(RemoteObject _responsebody) throws Exception{
try {
		Debug.PushSubsStack("maindata_onNext (home) ","home",4,home.mostCurrent.activityBA,home.mostCurrent,105);
if (RapidSub.canDelegate("maindata_onnext")) { return b4a.example.home.remoteMe.runUserSub(false, "home","maindata_onnext", _responsebody);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _result = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _lang_list = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _en = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _localname = RemoteObject.createImmutable("");
RemoteObject _iso = RemoteObject.createImmutable("");
RemoteObject _api_url = RemoteObject.createImmutable("");
RemoteObject _name = RemoteObject.createImmutable("");
RemoteObject _direction = RemoteObject.createImmutable("");
RemoteObject _fa = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _site = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _logo = RemoteObject.createImmutable("");
RemoteObject _slogan = RemoteObject.createImmutable("");
RemoteObject _desc = RemoteObject.createImmutable("");
RemoteObject _navigation = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colnavigation = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _icon = RemoteObject.createImmutable("");
RemoteObject _link = RemoteObject.createImmutable("");
RemoteObject _typegb = RemoteObject.createImmutable("");
RemoteObject _title = RemoteObject.createImmutable("");
RemoteObject _ad = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _top = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _content = RemoteObject.createImmutable("");
RemoteObject _bottom = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _intro = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colintro = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _bg_to = RemoteObject.createImmutable("");
RemoteObject _image = RemoteObject.createImmutable("");
RemoteObject _bg_from = RemoteObject.createImmutable("");
RemoteObject _title_color = RemoteObject.createImmutable("");
RemoteObject _desc_color = RemoteObject.createImmutable("");
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _action = RemoteObject.createImmutable("");
RemoteObject _transalate = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _changelang = RemoteObject.createImmutable("");
RemoteObject _go = RemoteObject.createImmutable("");
RemoteObject _back = RemoteObject.createImmutable("");
RemoteObject _enter = RemoteObject.createImmutable("");
RemoteObject _version = RemoteObject.createImmutable("");
RemoteObject _close = RemoteObject.createImmutable("");
RemoteObject _theme = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _default = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _intror = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _header_from = RemoteObject.createImmutable("");
RemoteObject _footer_color = RemoteObject.createImmutable("");
RemoteObject _color = RemoteObject.createImmutable("");
RemoteObject _header_to = RemoteObject.createImmutable("");
RemoteObject _header_color = RemoteObject.createImmutable("");
RemoteObject _footer_from = RemoteObject.createImmutable("");
RemoteObject _footer_to = RemoteObject.createImmutable("");
RemoteObject _global = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _btn_from = RemoteObject.createImmutable("");
RemoteObject _btn_color = RemoteObject.createImmutable("");
RemoteObject _btn_to = RemoteObject.createImmutable("");
RemoteObject _share = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _splash = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _btng = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _warn = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _success = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _danger = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _info = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _night = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _introf = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _btnf = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _menu = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colmenu = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _typefg = RemoteObject.createImmutable("");
RemoteObject _versiond = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _deprecated_descd = RemoteObject.createImmutable("");
RemoteObject _lastd = RemoteObject.createImmutable(0);
RemoteObject _deprecatedd = RemoteObject.createImmutable(0);
RemoteObject _update_titled = RemoteObject.createImmutable("");
RemoteObject _deprecated_titled = RemoteObject.createImmutable("");
RemoteObject _update_descd = RemoteObject.createImmutable("");
RemoteObject _url = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _sited = RemoteObject.createImmutable("");
RemoteObject _domain = RemoteObject.createImmutable("");
RemoteObject _rootd = RemoteObject.createImmutable("");
RemoteObject _update = RemoteObject.createImmutable("");
RemoteObject _kingdom = RemoteObject.createImmutable("");
RemoteObject _homepage = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colhomepage = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _typert = RemoteObject.createImmutable("");
RemoteObject _expire = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _lst = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _coldata = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _mode = RemoteObject.createImmutable("");
RemoteObject _activitya = RemoteObject.createImmutable("");
RemoteObject _urla = RemoteObject.createImmutable("");
RemoteObject _ok = RemoteObject.createImmutable("");
Debug.locals.put("ResponseBody", _responsebody);
 BA.debugLineNum = 105;BA.debugLine="Sub maindata_onNext (ResponseBody As Amir_Response";
Debug.ShouldStop(256);
 BA.debugLineNum = 106;BA.debugLine="Log(ResponseBody.String)";
Debug.ShouldStop(512);
home.mostCurrent.__c.runVoidMethod ("LogImpl","39240577",_responsebody.runMethod(true,"getString"),0);
 BA.debugLineNum = 107;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(1024);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 108;BA.debugLine="parser.Initialize(ResponseBody.String)";
Debug.ShouldStop(2048);
_parser.runVoidMethod ("Initialize",(Object)(_responsebody.runMethod(true,"getString")));
 BA.debugLineNum = 109;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(4096);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 110;BA.debugLine="Dim result As Map = root.Get(\"result\")";
Debug.ShouldStop(8192);
_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_result.setObject(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("result")))));Debug.locals.put("result", _result);
 BA.debugLineNum = 111;BA.debugLine="Dim lang_list As Map = result.Get(\"lang_list\")";
Debug.ShouldStop(16384);
_lang_list = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_lang_list.setObject(_result.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("lang_list")))));Debug.locals.put("lang_list", _lang_list);
 BA.debugLineNum = 112;BA.debugLine="Dim en As Map = lang_list.Get(\"en\")";
Debug.ShouldStop(32768);
_en = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_en.setObject(_lang_list.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("en")))));Debug.locals.put("en", _en);
 BA.debugLineNum = 113;BA.debugLine="Dim localname As String = en.Get(\"localname\")";
Debug.ShouldStop(65536);
_localname = BA.ObjectToString(_en.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("localname")))));Debug.locals.put("localname", _localname);Debug.locals.put("localname", _localname);
 BA.debugLineNum = 114;BA.debugLine="Dim iso As String = en.Get(\"iso\")";
Debug.ShouldStop(131072);
_iso = BA.ObjectToString(_en.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("iso")))));Debug.locals.put("iso", _iso);Debug.locals.put("iso", _iso);
 BA.debugLineNum = 115;BA.debugLine="Dim api_url As String = en.Get(\"api_url\")";
Debug.ShouldStop(262144);
_api_url = BA.ObjectToString(_en.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("api_url")))));Debug.locals.put("api_url", _api_url);Debug.locals.put("api_url", _api_url);
 BA.debugLineNum = 116;BA.debugLine="Dim name As String = en.Get(\"name\")";
Debug.ShouldStop(524288);
_name = BA.ObjectToString(_en.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name")))));Debug.locals.put("name", _name);Debug.locals.put("name", _name);
 BA.debugLineNum = 117;BA.debugLine="Dim direction As String = en.Get(\"direction\")";
Debug.ShouldStop(1048576);
_direction = BA.ObjectToString(_en.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("direction")))));Debug.locals.put("direction", _direction);Debug.locals.put("direction", _direction);
 BA.debugLineNum = 118;BA.debugLine="Dim fa As Map = lang_list.Get(\"fa\")";
Debug.ShouldStop(2097152);
_fa = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_fa.setObject(_lang_list.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fa")))));Debug.locals.put("fa", _fa);
 BA.debugLineNum = 119;BA.debugLine="Dim localname As String = fa.Get(\"localname\")";
Debug.ShouldStop(4194304);
_localname = BA.ObjectToString(_fa.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("localname")))));Debug.locals.put("localname", _localname);Debug.locals.put("localname", _localname);
 BA.debugLineNum = 120;BA.debugLine="Dim iso As String = fa.Get(\"iso\")";
Debug.ShouldStop(8388608);
_iso = BA.ObjectToString(_fa.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("iso")))));Debug.locals.put("iso", _iso);Debug.locals.put("iso", _iso);
 BA.debugLineNum = 121;BA.debugLine="Dim api_url As String = fa.Get(\"api_url\")";
Debug.ShouldStop(16777216);
_api_url = BA.ObjectToString(_fa.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("api_url")))));Debug.locals.put("api_url", _api_url);Debug.locals.put("api_url", _api_url);
 BA.debugLineNum = 122;BA.debugLine="Dim name As String = fa.Get(\"name\")";
Debug.ShouldStop(33554432);
_name = BA.ObjectToString(_fa.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name")))));Debug.locals.put("name", _name);Debug.locals.put("name", _name);
 BA.debugLineNum = 123;BA.debugLine="Dim direction As String = fa.Get(\"direction\")";
Debug.ShouldStop(67108864);
_direction = BA.ObjectToString(_fa.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("direction")))));Debug.locals.put("direction", _direction);Debug.locals.put("direction", _direction);
 BA.debugLineNum = 124;BA.debugLine="Dim site As Map = result.Get(\"site\")";
Debug.ShouldStop(134217728);
_site = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_site.setObject(_result.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("site")))));Debug.locals.put("site", _site);
 BA.debugLineNum = 125;BA.debugLine="Dim name As String = site.Get(\"name\")";
Debug.ShouldStop(268435456);
_name = BA.ObjectToString(_site.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name")))));Debug.locals.put("name", _name);Debug.locals.put("name", _name);
 BA.debugLineNum = 126;BA.debugLine="Dim logo As String = site.Get(\"logo\")";
Debug.ShouldStop(536870912);
_logo = BA.ObjectToString(_site.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("logo")))));Debug.locals.put("logo", _logo);Debug.locals.put("logo", _logo);
 BA.debugLineNum = 127;BA.debugLine="Dim slogan As String = site.Get(\"slogan\")";
Debug.ShouldStop(1073741824);
_slogan = BA.ObjectToString(_site.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("slogan")))));Debug.locals.put("slogan", _slogan);Debug.locals.put("slogan", _slogan);
 BA.debugLineNum = 128;BA.debugLine="Dim desc As String = site.Get(\"desc\")";
Debug.ShouldStop(-2147483648);
_desc = BA.ObjectToString(_site.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("desc")))));Debug.locals.put("desc", _desc);Debug.locals.put("desc", _desc);
 BA.debugLineNum = 129;BA.debugLine="Dim navigation As List = result.Get(\"navigation\")";
Debug.ShouldStop(1);
_navigation = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_navigation.setObject(_result.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("navigation")))));Debug.locals.put("navigation", _navigation);
 BA.debugLineNum = 130;BA.debugLine="For Each colnavigation As Map In navigation";
Debug.ShouldStop(2);
_colnavigation = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group25 = _navigation;
final int groupLen25 = group25.runMethod(true,"getSize").<Integer>get()
;int index25 = 0;
;
for (; index25 < groupLen25;index25++){
_colnavigation.setObject(group25.runMethod(false,"Get",index25));
Debug.locals.put("colnavigation", _colnavigation);
 BA.debugLineNum = 131;BA.debugLine="Dim icon As String = colnavigation.Get(\"icon\")";
Debug.ShouldStop(4);
_icon = BA.ObjectToString(_colnavigation.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("icon")))));Debug.locals.put("icon", _icon);Debug.locals.put("icon", _icon);
 BA.debugLineNum = 132;BA.debugLine="Dim link As String = colnavigation.Get(\"link\")";
Debug.ShouldStop(8);
_link = BA.ObjectToString(_colnavigation.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("link")))));Debug.locals.put("link", _link);Debug.locals.put("link", _link);
 BA.debugLineNum = 133;BA.debugLine="Dim Typegb As String = colnavigation.Get(\"type\")";
Debug.ShouldStop(16);
_typegb = BA.ObjectToString(_colnavigation.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("type")))));Debug.locals.put("Typegb", _typegb);Debug.locals.put("Typegb", _typegb);
 BA.debugLineNum = 134;BA.debugLine="Dim title As String = colnavigation.Get(\"title\")";
Debug.ShouldStop(32);
_title = BA.ObjectToString(_colnavigation.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("title")))));Debug.locals.put("title", _title);Debug.locals.put("title", _title);
 }
}Debug.locals.put("colnavigation", _colnavigation);
;
 BA.debugLineNum = 136;BA.debugLine="Dim ad As Map = result.Get(\"ad\")";
Debug.ShouldStop(128);
_ad = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_ad.setObject(_result.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("ad")))));Debug.locals.put("ad", _ad);
 BA.debugLineNum = 137;BA.debugLine="Dim top As Map = ad.Get(\"top\")";
Debug.ShouldStop(256);
_top = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_top.setObject(_ad.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("top")))));Debug.locals.put("top", _top);
 BA.debugLineNum = 138;BA.debugLine="Dim link As String = top.Get(\"link\")";
Debug.ShouldStop(512);
_link = BA.ObjectToString(_top.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("link")))));Debug.locals.put("link", _link);Debug.locals.put("link", _link);
 BA.debugLineNum = 139;BA.debugLine="Dim content As String = top.Get(\"content\")";
Debug.ShouldStop(1024);
_content = BA.ObjectToString(_top.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("content")))));Debug.locals.put("content", _content);Debug.locals.put("content", _content);
 BA.debugLineNum = 140;BA.debugLine="Dim bottom As List = ad.Get(\"bottom\")";
Debug.ShouldStop(2048);
_bottom = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_bottom.setObject(_ad.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bottom")))));Debug.locals.put("bottom", _bottom);
 BA.debugLineNum = 141;BA.debugLine="Dim intro As List = result.Get(\"intro\")";
Debug.ShouldStop(4096);
_intro = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_intro.setObject(_result.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("intro")))));Debug.locals.put("intro", _intro);
 BA.debugLineNum = 142;BA.debugLine="For Each colintro As Map In intro";
Debug.ShouldStop(8192);
_colintro = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group37 = _intro;
final int groupLen37 = group37.runMethod(true,"getSize").<Integer>get()
;int index37 = 0;
;
for (; index37 < groupLen37;index37++){
_colintro.setObject(group37.runMethod(false,"Get",index37));
Debug.locals.put("colintro", _colintro);
 BA.debugLineNum = 143;BA.debugLine="Dim bg_to As String = colintro.Get(\"bg_to\")";
Debug.ShouldStop(16384);
_bg_to = BA.ObjectToString(_colintro.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_to")))));Debug.locals.put("bg_to", _bg_to);Debug.locals.put("bg_to", _bg_to);
 BA.debugLineNum = 144;BA.debugLine="Dim image As String = colintro.Get(\"image\")";
Debug.ShouldStop(32768);
_image = BA.ObjectToString(_colintro.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("image")))));Debug.locals.put("image", _image);Debug.locals.put("image", _image);
 BA.debugLineNum = 145;BA.debugLine="Dim bg_from As String = colintro.Get(\"bg_from\")";
Debug.ShouldStop(65536);
_bg_from = BA.ObjectToString(_colintro.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_from")))));Debug.locals.put("bg_from", _bg_from);Debug.locals.put("bg_from", _bg_from);
 BA.debugLineNum = 146;BA.debugLine="Dim title_color As String = colintro.Get(\"title_";
Debug.ShouldStop(131072);
_title_color = BA.ObjectToString(_colintro.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("title_color")))));Debug.locals.put("title_color", _title_color);Debug.locals.put("title_color", _title_color);
 BA.debugLineNum = 147;BA.debugLine="Dim desc_color As String = colintro.Get(\"desc_co";
Debug.ShouldStop(262144);
_desc_color = BA.ObjectToString(_colintro.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("desc_color")))));Debug.locals.put("desc_color", _desc_color);Debug.locals.put("desc_color", _desc_color);
 BA.debugLineNum = 148;BA.debugLine="Dim title As String = colintro.Get(\"title\")";
Debug.ShouldStop(524288);
_title = BA.ObjectToString(_colintro.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("title")))));Debug.locals.put("title", _title);Debug.locals.put("title", _title);
 BA.debugLineNum = 149;BA.debugLine="Dim btn As List = colintro.Get(\"btn\")";
Debug.ShouldStop(1048576);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_btn.setObject(_colintro.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("btn")))));Debug.locals.put("btn", _btn);
 BA.debugLineNum = 150;BA.debugLine="For Each colbtn As Map In btn";
Debug.ShouldStop(2097152);
_colbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group45 = _btn;
final int groupLen45 = group45.runMethod(true,"getSize").<Integer>get()
;int index45 = 0;
;
for (; index45 < groupLen45;index45++){
_colbtn.setObject(group45.runMethod(false,"Get",index45));
Debug.locals.put("colbtn", _colbtn);
 BA.debugLineNum = 151;BA.debugLine="Dim action As String = colbtn.Get(\"action\")";
Debug.ShouldStop(4194304);
_action = BA.ObjectToString(_colbtn.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("action")))));Debug.locals.put("action", _action);Debug.locals.put("action", _action);
 BA.debugLineNum = 152;BA.debugLine="Dim title As String = colbtn.Get(\"title\")";
Debug.ShouldStop(8388608);
_title = BA.ObjectToString(_colbtn.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("title")))));Debug.locals.put("title", _title);Debug.locals.put("title", _title);
 }
}Debug.locals.put("colbtn", _colbtn);
;
 BA.debugLineNum = 154;BA.debugLine="Dim desc As String = colintro.Get(\"desc\")";
Debug.ShouldStop(33554432);
_desc = BA.ObjectToString(_colintro.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("desc")))));Debug.locals.put("desc", _desc);Debug.locals.put("desc", _desc);
 }
}Debug.locals.put("colintro", _colintro);
;
 BA.debugLineNum = 156;BA.debugLine="Dim transalate As Map = result.Get(\"transalate\")";
Debug.ShouldStop(134217728);
_transalate = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_transalate.setObject(_result.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("transalate")))));Debug.locals.put("transalate", _transalate);
 BA.debugLineNum = 157;BA.debugLine="Dim changelang As String = transalate.Get(\"change";
Debug.ShouldStop(268435456);
_changelang = BA.ObjectToString(_transalate.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("changelang")))));Debug.locals.put("changelang", _changelang);Debug.locals.put("changelang", _changelang);
 BA.debugLineNum = 158;BA.debugLine="Dim go As String = transalate.Get(\"go\")";
Debug.ShouldStop(536870912);
_go = BA.ObjectToString(_transalate.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("go")))));Debug.locals.put("go", _go);Debug.locals.put("go", _go);
 BA.debugLineNum = 159;BA.debugLine="Dim back As String = transalate.Get(\"back\")";
Debug.ShouldStop(1073741824);
_back = BA.ObjectToString(_transalate.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("back")))));Debug.locals.put("back", _back);Debug.locals.put("back", _back);
 BA.debugLineNum = 160;BA.debugLine="Dim enter As String = transalate.Get(\"enter\")";
Debug.ShouldStop(-2147483648);
_enter = BA.ObjectToString(_transalate.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("enter")))));Debug.locals.put("enter", _enter);Debug.locals.put("enter", _enter);
 BA.debugLineNum = 161;BA.debugLine="Dim version As String = transalate.Get(\"version\")";
Debug.ShouldStop(1);
_version = BA.ObjectToString(_transalate.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("version")))));Debug.locals.put("version", _version);Debug.locals.put("version", _version);
 BA.debugLineNum = 162;BA.debugLine="Dim close As String = transalate.Get(\"close\")";
Debug.ShouldStop(2);
_close = BA.ObjectToString(_transalate.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("close")))));Debug.locals.put("close", _close);Debug.locals.put("close", _close);
 BA.debugLineNum = 163;BA.debugLine="Dim theme As Map = result.Get(\"theme\")";
Debug.ShouldStop(4);
_theme = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_theme.setObject(_result.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("theme")))));Debug.locals.put("theme", _theme);
 BA.debugLineNum = 164;BA.debugLine="Dim default As Map = theme.Get(\"default\")";
Debug.ShouldStop(8);
_default = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_default.setObject(_theme.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("default")))));Debug.locals.put("default", _default);
 BA.debugLineNum = 165;BA.debugLine="Dim intror As Map = default.Get(\"intro\")";
Debug.ShouldStop(16);
_intror = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_intror.setObject(_default.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("intro")))));Debug.locals.put("intror", _intror);
 BA.debugLineNum = 166;BA.debugLine="Dim bg_to As String = intror.Get(\"bg_to\")";
Debug.ShouldStop(32);
_bg_to = BA.ObjectToString(_intror.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_to")))));Debug.locals.put("bg_to", _bg_to);Debug.locals.put("bg_to", _bg_to);
 BA.debugLineNum = 167;BA.debugLine="Dim header_from As String = intror.Get(\"header_fr";
Debug.ShouldStop(64);
_header_from = BA.ObjectToString(_intror.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("header_from")))));Debug.locals.put("header_from", _header_from);Debug.locals.put("header_from", _header_from);
 BA.debugLineNum = 168;BA.debugLine="Dim footer_color As String = intror.Get(\"footer_c";
Debug.ShouldStop(128);
_footer_color = BA.ObjectToString(_intror.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("footer_color")))));Debug.locals.put("footer_color", _footer_color);Debug.locals.put("footer_color", _footer_color);
 BA.debugLineNum = 169;BA.debugLine="Dim bg_from As String = intror.Get(\"bg_from\")";
Debug.ShouldStop(256);
_bg_from = BA.ObjectToString(_intror.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_from")))));Debug.locals.put("bg_from", _bg_from);Debug.locals.put("bg_from", _bg_from);
 BA.debugLineNum = 170;BA.debugLine="Dim color As String = intror.Get(\"color\")";
Debug.ShouldStop(512);
_color = BA.ObjectToString(_intror.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("color")))));Debug.locals.put("color", _color);Debug.locals.put("color", _color);
 BA.debugLineNum = 171;BA.debugLine="Dim header_to As String = intror.Get(\"header_to\")";
Debug.ShouldStop(1024);
_header_to = BA.ObjectToString(_intror.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("header_to")))));Debug.locals.put("header_to", _header_to);Debug.locals.put("header_to", _header_to);
 BA.debugLineNum = 172;BA.debugLine="Dim header_color As String = intror.Get(\"header_c";
Debug.ShouldStop(2048);
_header_color = BA.ObjectToString(_intror.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("header_color")))));Debug.locals.put("header_color", _header_color);Debug.locals.put("header_color", _header_color);
 BA.debugLineNum = 173;BA.debugLine="Dim footer_from As String = intror.Get(\"footer_fr";
Debug.ShouldStop(4096);
_footer_from = BA.ObjectToString(_intror.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("footer_from")))));Debug.locals.put("footer_from", _footer_from);Debug.locals.put("footer_from", _footer_from);
 BA.debugLineNum = 174;BA.debugLine="Dim footer_to As String = intror.Get(\"footer_to\")";
Debug.ShouldStop(8192);
_footer_to = BA.ObjectToString(_intror.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("footer_to")))));Debug.locals.put("footer_to", _footer_to);Debug.locals.put("footer_to", _footer_to);
 BA.debugLineNum = 175;BA.debugLine="Dim global As Map = default.Get(\"global\")";
Debug.ShouldStop(16384);
_global = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_global.setObject(_default.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("global")))));Debug.locals.put("global", _global);
 BA.debugLineNum = 176;BA.debugLine="Dim bg_to As String = global.Get(\"bg_to\")";
Debug.ShouldStop(32768);
_bg_to = BA.ObjectToString(_global.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_to")))));Debug.locals.put("bg_to", _bg_to);Debug.locals.put("bg_to", _bg_to);
 BA.debugLineNum = 177;BA.debugLine="Dim bg_from As String = global.Get(\"bg_from\")";
Debug.ShouldStop(65536);
_bg_from = BA.ObjectToString(_global.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_from")))));Debug.locals.put("bg_from", _bg_from);Debug.locals.put("bg_from", _bg_from);
 BA.debugLineNum = 178;BA.debugLine="Dim color As String = global.Get(\"color\")";
Debug.ShouldStop(131072);
_color = BA.ObjectToString(_global.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("color")))));Debug.locals.put("color", _color);Debug.locals.put("color", _color);
 BA.debugLineNum = 179;BA.debugLine="Dim btn_from As String = global.Get(\"btn_from\")";
Debug.ShouldStop(262144);
_btn_from = BA.ObjectToString(_global.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("btn_from")))));Debug.locals.put("btn_from", _btn_from);Debug.locals.put("btn_from", _btn_from);
 BA.debugLineNum = 180;BA.debugLine="Dim btn_color As String = global.Get(\"btn_color\")";
Debug.ShouldStop(524288);
_btn_color = BA.ObjectToString(_global.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("btn_color")))));Debug.locals.put("btn_color", _btn_color);Debug.locals.put("btn_color", _btn_color);
 BA.debugLineNum = 181;BA.debugLine="Dim btn_to As String = global.Get(\"btn_to\")";
Debug.ShouldStop(1048576);
_btn_to = BA.ObjectToString(_global.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("btn_to")))));Debug.locals.put("btn_to", _btn_to);Debug.locals.put("btn_to", _btn_to);
 BA.debugLineNum = 182;BA.debugLine="Dim share As Map = default.Get(\"share\")";
Debug.ShouldStop(2097152);
_share = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_share.setObject(_default.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("share")))));Debug.locals.put("share", _share);
 BA.debugLineNum = 183;BA.debugLine="Dim bg_to As String = share.Get(\"bg_to\")";
Debug.ShouldStop(4194304);
_bg_to = BA.ObjectToString(_share.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_to")))));Debug.locals.put("bg_to", _bg_to);Debug.locals.put("bg_to", _bg_to);
 BA.debugLineNum = 184;BA.debugLine="Dim header_from As String = share.Get(\"header_fro";
Debug.ShouldStop(8388608);
_header_from = BA.ObjectToString(_share.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("header_from")))));Debug.locals.put("header_from", _header_from);Debug.locals.put("header_from", _header_from);
 BA.debugLineNum = 185;BA.debugLine="Dim footer_color As String = share.Get(\"footer_co";
Debug.ShouldStop(16777216);
_footer_color = BA.ObjectToString(_share.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("footer_color")))));Debug.locals.put("footer_color", _footer_color);Debug.locals.put("footer_color", _footer_color);
 BA.debugLineNum = 186;BA.debugLine="Dim bg_from As String = share.Get(\"bg_from\")";
Debug.ShouldStop(33554432);
_bg_from = BA.ObjectToString(_share.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_from")))));Debug.locals.put("bg_from", _bg_from);Debug.locals.put("bg_from", _bg_from);
 BA.debugLineNum = 187;BA.debugLine="Dim color As String = share.Get(\"color\")";
Debug.ShouldStop(67108864);
_color = BA.ObjectToString(_share.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("color")))));Debug.locals.put("color", _color);Debug.locals.put("color", _color);
 BA.debugLineNum = 188;BA.debugLine="Dim header_to As String = share.Get(\"header_to\")";
Debug.ShouldStop(134217728);
_header_to = BA.ObjectToString(_share.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("header_to")))));Debug.locals.put("header_to", _header_to);Debug.locals.put("header_to", _header_to);
 BA.debugLineNum = 189;BA.debugLine="Dim header_color As String = share.Get(\"header_co";
Debug.ShouldStop(268435456);
_header_color = BA.ObjectToString(_share.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("header_color")))));Debug.locals.put("header_color", _header_color);Debug.locals.put("header_color", _header_color);
 BA.debugLineNum = 190;BA.debugLine="Dim footer_from As String = share.Get(\"footer_fro";
Debug.ShouldStop(536870912);
_footer_from = BA.ObjectToString(_share.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("footer_from")))));Debug.locals.put("footer_from", _footer_from);Debug.locals.put("footer_from", _footer_from);
 BA.debugLineNum = 191;BA.debugLine="Dim footer_to As String = share.Get(\"footer_to\")";
Debug.ShouldStop(1073741824);
_footer_to = BA.ObjectToString(_share.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("footer_to")))));Debug.locals.put("footer_to", _footer_to);Debug.locals.put("footer_to", _footer_to);
 BA.debugLineNum = 192;BA.debugLine="Dim splash As Map = default.Get(\"splash\")";
Debug.ShouldStop(-2147483648);
_splash = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_splash.setObject(_default.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("splash")))));Debug.locals.put("splash", _splash);
 BA.debugLineNum = 193;BA.debugLine="Dim bg_to As String = splash.Get(\"bg_to\")";
Debug.ShouldStop(1);
_bg_to = BA.ObjectToString(_splash.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_to")))));Debug.locals.put("bg_to", _bg_to);Debug.locals.put("bg_to", _bg_to);
 BA.debugLineNum = 194;BA.debugLine="Dim bg_from As String = splash.Get(\"bg_from\")";
Debug.ShouldStop(2);
_bg_from = BA.ObjectToString(_splash.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_from")))));Debug.locals.put("bg_from", _bg_from);Debug.locals.put("bg_from", _bg_from);
 BA.debugLineNum = 195;BA.debugLine="Dim color As String = splash.Get(\"color\")";
Debug.ShouldStop(4);
_color = BA.ObjectToString(_splash.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("color")))));Debug.locals.put("color", _color);Debug.locals.put("color", _color);
 BA.debugLineNum = 196;BA.debugLine="Dim btng As Map = default.Get(\"btn\")";
Debug.ShouldStop(8);
_btng = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_btng.setObject(_default.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("btn")))));Debug.locals.put("btng", _btng);
 BA.debugLineNum = 197;BA.debugLine="Dim warn As Map = btng.Get(\"warn\")";
Debug.ShouldStop(16);
_warn = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_warn.setObject(_btng.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("warn")))));Debug.locals.put("warn", _warn);
 BA.debugLineNum = 198;BA.debugLine="Dim bg_to As String = warn.Get(\"bg_to\")";
Debug.ShouldStop(32);
_bg_to = BA.ObjectToString(_warn.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_to")))));Debug.locals.put("bg_to", _bg_to);Debug.locals.put("bg_to", _bg_to);
 BA.debugLineNum = 199;BA.debugLine="Dim bg_from As String = warn.Get(\"bg_from\")";
Debug.ShouldStop(64);
_bg_from = BA.ObjectToString(_warn.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_from")))));Debug.locals.put("bg_from", _bg_from);Debug.locals.put("bg_from", _bg_from);
 BA.debugLineNum = 200;BA.debugLine="Dim color As String = warn.Get(\"color\")";
Debug.ShouldStop(128);
_color = BA.ObjectToString(_warn.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("color")))));Debug.locals.put("color", _color);Debug.locals.put("color", _color);
 BA.debugLineNum = 201;BA.debugLine="Dim success As Map = btng.Get(\"success\")";
Debug.ShouldStop(256);
_success = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_success.setObject(_btng.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("success")))));Debug.locals.put("success", _success);
 BA.debugLineNum = 202;BA.debugLine="Dim bg_to As String = success.Get(\"bg_to\")";
Debug.ShouldStop(512);
_bg_to = BA.ObjectToString(_success.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_to")))));Debug.locals.put("bg_to", _bg_to);Debug.locals.put("bg_to", _bg_to);
 BA.debugLineNum = 203;BA.debugLine="Dim bg_from As String = success.Get(\"bg_from\")";
Debug.ShouldStop(1024);
_bg_from = BA.ObjectToString(_success.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_from")))));Debug.locals.put("bg_from", _bg_from);Debug.locals.put("bg_from", _bg_from);
 BA.debugLineNum = 204;BA.debugLine="Dim color As String = success.Get(\"color\")";
Debug.ShouldStop(2048);
_color = BA.ObjectToString(_success.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("color")))));Debug.locals.put("color", _color);Debug.locals.put("color", _color);
 BA.debugLineNum = 205;BA.debugLine="Dim danger As Map = btng.Get(\"danger\")";
Debug.ShouldStop(4096);
_danger = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_danger.setObject(_btng.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("danger")))));Debug.locals.put("danger", _danger);
 BA.debugLineNum = 206;BA.debugLine="Dim bg_to As String = danger.Get(\"bg_to\")";
Debug.ShouldStop(8192);
_bg_to = BA.ObjectToString(_danger.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_to")))));Debug.locals.put("bg_to", _bg_to);Debug.locals.put("bg_to", _bg_to);
 BA.debugLineNum = 207;BA.debugLine="Dim bg_from As String = danger.Get(\"bg_from\")";
Debug.ShouldStop(16384);
_bg_from = BA.ObjectToString(_danger.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_from")))));Debug.locals.put("bg_from", _bg_from);Debug.locals.put("bg_from", _bg_from);
 BA.debugLineNum = 208;BA.debugLine="Dim color As String = danger.Get(\"color\")";
Debug.ShouldStop(32768);
_color = BA.ObjectToString(_danger.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("color")))));Debug.locals.put("color", _color);Debug.locals.put("color", _color);
 BA.debugLineNum = 209;BA.debugLine="Dim info As Map = btng.Get(\"info\")";
Debug.ShouldStop(65536);
_info = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_info.setObject(_btng.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("info")))));Debug.locals.put("info", _info);
 BA.debugLineNum = 210;BA.debugLine="Dim bg_to As String = info.Get(\"bg_to\")";
Debug.ShouldStop(131072);
_bg_to = BA.ObjectToString(_info.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_to")))));Debug.locals.put("bg_to", _bg_to);Debug.locals.put("bg_to", _bg_to);
 BA.debugLineNum = 211;BA.debugLine="Dim bg_from As String = info.Get(\"bg_from\")";
Debug.ShouldStop(262144);
_bg_from = BA.ObjectToString(_info.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_from")))));Debug.locals.put("bg_from", _bg_from);Debug.locals.put("bg_from", _bg_from);
 BA.debugLineNum = 212;BA.debugLine="Dim color As String = info.Get(\"color\")";
Debug.ShouldStop(524288);
_color = BA.ObjectToString(_info.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("color")))));Debug.locals.put("color", _color);Debug.locals.put("color", _color);
 BA.debugLineNum = 213;BA.debugLine="Dim night As Map = theme.Get(\"night\")";
Debug.ShouldStop(1048576);
_night = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_night.setObject(_theme.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("night")))));Debug.locals.put("night", _night);
 BA.debugLineNum = 214;BA.debugLine="Dim introf As Map = night.Get(\"intro\")";
Debug.ShouldStop(2097152);
_introf = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_introf.setObject(_night.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("intro")))));Debug.locals.put("introf", _introf);
 BA.debugLineNum = 215;BA.debugLine="Dim bg_to As String = introf.Get(\"bg_to\")";
Debug.ShouldStop(4194304);
_bg_to = BA.ObjectToString(_introf.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_to")))));Debug.locals.put("bg_to", _bg_to);Debug.locals.put("bg_to", _bg_to);
 BA.debugLineNum = 216;BA.debugLine="Dim header_from As String = introf.Get(\"header_fr";
Debug.ShouldStop(8388608);
_header_from = BA.ObjectToString(_introf.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("header_from")))));Debug.locals.put("header_from", _header_from);Debug.locals.put("header_from", _header_from);
 BA.debugLineNum = 217;BA.debugLine="Dim footer_color As String = introf.Get(\"footer_c";
Debug.ShouldStop(16777216);
_footer_color = BA.ObjectToString(_introf.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("footer_color")))));Debug.locals.put("footer_color", _footer_color);Debug.locals.put("footer_color", _footer_color);
 BA.debugLineNum = 218;BA.debugLine="Dim bg_from As String = introf.Get(\"bg_from\")";
Debug.ShouldStop(33554432);
_bg_from = BA.ObjectToString(_introf.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_from")))));Debug.locals.put("bg_from", _bg_from);Debug.locals.put("bg_from", _bg_from);
 BA.debugLineNum = 219;BA.debugLine="Dim color As String = introf.Get(\"color\")";
Debug.ShouldStop(67108864);
_color = BA.ObjectToString(_introf.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("color")))));Debug.locals.put("color", _color);Debug.locals.put("color", _color);
 BA.debugLineNum = 220;BA.debugLine="Dim header_to As String = introf.Get(\"header_to\")";
Debug.ShouldStop(134217728);
_header_to = BA.ObjectToString(_introf.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("header_to")))));Debug.locals.put("header_to", _header_to);Debug.locals.put("header_to", _header_to);
 BA.debugLineNum = 221;BA.debugLine="Dim header_color As String = introf.Get(\"header_c";
Debug.ShouldStop(268435456);
_header_color = BA.ObjectToString(_introf.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("header_color")))));Debug.locals.put("header_color", _header_color);Debug.locals.put("header_color", _header_color);
 BA.debugLineNum = 222;BA.debugLine="Dim footer_from As String = introf.Get(\"footer_fr";
Debug.ShouldStop(536870912);
_footer_from = BA.ObjectToString(_introf.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("footer_from")))));Debug.locals.put("footer_from", _footer_from);Debug.locals.put("footer_from", _footer_from);
 BA.debugLineNum = 223;BA.debugLine="Dim footer_to As String = introf.Get(\"footer_to\")";
Debug.ShouldStop(1073741824);
_footer_to = BA.ObjectToString(_introf.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("footer_to")))));Debug.locals.put("footer_to", _footer_to);Debug.locals.put("footer_to", _footer_to);
 BA.debugLineNum = 224;BA.debugLine="Dim global As Map = night.Get(\"global\")";
Debug.ShouldStop(-2147483648);
_global = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_global.setObject(_night.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("global")))));Debug.locals.put("global", _global);
 BA.debugLineNum = 225;BA.debugLine="Dim bg_to As String = global.Get(\"bg_to\")";
Debug.ShouldStop(1);
_bg_to = BA.ObjectToString(_global.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_to")))));Debug.locals.put("bg_to", _bg_to);Debug.locals.put("bg_to", _bg_to);
 BA.debugLineNum = 226;BA.debugLine="Dim bg_from As String = global.Get(\"bg_from\")";
Debug.ShouldStop(2);
_bg_from = BA.ObjectToString(_global.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_from")))));Debug.locals.put("bg_from", _bg_from);Debug.locals.put("bg_from", _bg_from);
 BA.debugLineNum = 227;BA.debugLine="Dim color As String = global.Get(\"color\")";
Debug.ShouldStop(4);
_color = BA.ObjectToString(_global.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("color")))));Debug.locals.put("color", _color);Debug.locals.put("color", _color);
 BA.debugLineNum = 228;BA.debugLine="Dim btn_from As String = global.Get(\"btn_from\")";
Debug.ShouldStop(8);
_btn_from = BA.ObjectToString(_global.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("btn_from")))));Debug.locals.put("btn_from", _btn_from);Debug.locals.put("btn_from", _btn_from);
 BA.debugLineNum = 229;BA.debugLine="Dim btn_color As String = global.Get(\"btn_color\")";
Debug.ShouldStop(16);
_btn_color = BA.ObjectToString(_global.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("btn_color")))));Debug.locals.put("btn_color", _btn_color);Debug.locals.put("btn_color", _btn_color);
 BA.debugLineNum = 230;BA.debugLine="Dim btn_to As String = global.Get(\"btn_to\")";
Debug.ShouldStop(32);
_btn_to = BA.ObjectToString(_global.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("btn_to")))));Debug.locals.put("btn_to", _btn_to);Debug.locals.put("btn_to", _btn_to);
 BA.debugLineNum = 231;BA.debugLine="Dim share As Map = night.Get(\"share\")";
Debug.ShouldStop(64);
_share = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_share.setObject(_night.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("share")))));Debug.locals.put("share", _share);
 BA.debugLineNum = 232;BA.debugLine="Dim bg_to As String = share.Get(\"bg_to\")";
Debug.ShouldStop(128);
_bg_to = BA.ObjectToString(_share.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_to")))));Debug.locals.put("bg_to", _bg_to);Debug.locals.put("bg_to", _bg_to);
 BA.debugLineNum = 233;BA.debugLine="Dim header_from As String = share.Get(\"header_fro";
Debug.ShouldStop(256);
_header_from = BA.ObjectToString(_share.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("header_from")))));Debug.locals.put("header_from", _header_from);Debug.locals.put("header_from", _header_from);
 BA.debugLineNum = 234;BA.debugLine="Dim footer_color As String = share.Get(\"footer_co";
Debug.ShouldStop(512);
_footer_color = BA.ObjectToString(_share.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("footer_color")))));Debug.locals.put("footer_color", _footer_color);Debug.locals.put("footer_color", _footer_color);
 BA.debugLineNum = 235;BA.debugLine="Dim bg_from As String = share.Get(\"bg_from\")";
Debug.ShouldStop(1024);
_bg_from = BA.ObjectToString(_share.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_from")))));Debug.locals.put("bg_from", _bg_from);Debug.locals.put("bg_from", _bg_from);
 BA.debugLineNum = 236;BA.debugLine="Dim color As String = share.Get(\"color\")";
Debug.ShouldStop(2048);
_color = BA.ObjectToString(_share.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("color")))));Debug.locals.put("color", _color);Debug.locals.put("color", _color);
 BA.debugLineNum = 237;BA.debugLine="Dim header_to As String = share.Get(\"header_to\")";
Debug.ShouldStop(4096);
_header_to = BA.ObjectToString(_share.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("header_to")))));Debug.locals.put("header_to", _header_to);Debug.locals.put("header_to", _header_to);
 BA.debugLineNum = 238;BA.debugLine="Dim header_color As String = share.Get(\"header_co";
Debug.ShouldStop(8192);
_header_color = BA.ObjectToString(_share.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("header_color")))));Debug.locals.put("header_color", _header_color);Debug.locals.put("header_color", _header_color);
 BA.debugLineNum = 239;BA.debugLine="Dim footer_from As String = share.Get(\"footer_fro";
Debug.ShouldStop(16384);
_footer_from = BA.ObjectToString(_share.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("footer_from")))));Debug.locals.put("footer_from", _footer_from);Debug.locals.put("footer_from", _footer_from);
 BA.debugLineNum = 240;BA.debugLine="Dim footer_to As String = share.Get(\"footer_to\")";
Debug.ShouldStop(32768);
_footer_to = BA.ObjectToString(_share.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("footer_to")))));Debug.locals.put("footer_to", _footer_to);Debug.locals.put("footer_to", _footer_to);
 BA.debugLineNum = 241;BA.debugLine="Dim splash As Map = night.Get(\"splash\")";
Debug.ShouldStop(65536);
_splash = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_splash.setObject(_night.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("splash")))));Debug.locals.put("splash", _splash);
 BA.debugLineNum = 242;BA.debugLine="Dim bg_to As String = splash.Get(\"bg_to\")";
Debug.ShouldStop(131072);
_bg_to = BA.ObjectToString(_splash.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_to")))));Debug.locals.put("bg_to", _bg_to);Debug.locals.put("bg_to", _bg_to);
 BA.debugLineNum = 243;BA.debugLine="Dim bg_from As String = splash.Get(\"bg_from\")";
Debug.ShouldStop(262144);
_bg_from = BA.ObjectToString(_splash.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_from")))));Debug.locals.put("bg_from", _bg_from);Debug.locals.put("bg_from", _bg_from);
 BA.debugLineNum = 244;BA.debugLine="Dim color As String = splash.Get(\"color\")";
Debug.ShouldStop(524288);
_color = BA.ObjectToString(_splash.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("color")))));Debug.locals.put("color", _color);Debug.locals.put("color", _color);
 BA.debugLineNum = 245;BA.debugLine="Dim btnf As Map = night.Get(\"btn\")";
Debug.ShouldStop(1048576);
_btnf = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_btnf.setObject(_night.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("btn")))));Debug.locals.put("btnf", _btnf);
 BA.debugLineNum = 246;BA.debugLine="Dim warn As Map = btnf.Get(\"warn\")";
Debug.ShouldStop(2097152);
_warn = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_warn.setObject(_btnf.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("warn")))));Debug.locals.put("warn", _warn);
 BA.debugLineNum = 247;BA.debugLine="Dim bg_to As String = warn.Get(\"bg_to\")";
Debug.ShouldStop(4194304);
_bg_to = BA.ObjectToString(_warn.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_to")))));Debug.locals.put("bg_to", _bg_to);Debug.locals.put("bg_to", _bg_to);
 BA.debugLineNum = 248;BA.debugLine="Dim bg_from As String = warn.Get(\"bg_from\")";
Debug.ShouldStop(8388608);
_bg_from = BA.ObjectToString(_warn.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_from")))));Debug.locals.put("bg_from", _bg_from);Debug.locals.put("bg_from", _bg_from);
 BA.debugLineNum = 249;BA.debugLine="Dim color As String = warn.Get(\"color\")";
Debug.ShouldStop(16777216);
_color = BA.ObjectToString(_warn.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("color")))));Debug.locals.put("color", _color);Debug.locals.put("color", _color);
 BA.debugLineNum = 250;BA.debugLine="Dim success As Map = btnf.Get(\"success\")";
Debug.ShouldStop(33554432);
_success = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_success.setObject(_btnf.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("success")))));Debug.locals.put("success", _success);
 BA.debugLineNum = 251;BA.debugLine="Dim bg_to As String = success.Get(\"bg_to\")";
Debug.ShouldStop(67108864);
_bg_to = BA.ObjectToString(_success.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_to")))));Debug.locals.put("bg_to", _bg_to);Debug.locals.put("bg_to", _bg_to);
 BA.debugLineNum = 252;BA.debugLine="Dim bg_from As String = success.Get(\"bg_from\")";
Debug.ShouldStop(134217728);
_bg_from = BA.ObjectToString(_success.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_from")))));Debug.locals.put("bg_from", _bg_from);Debug.locals.put("bg_from", _bg_from);
 BA.debugLineNum = 253;BA.debugLine="Dim color As String = success.Get(\"color\")";
Debug.ShouldStop(268435456);
_color = BA.ObjectToString(_success.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("color")))));Debug.locals.put("color", _color);Debug.locals.put("color", _color);
 BA.debugLineNum = 254;BA.debugLine="Dim danger As Map = btnf.Get(\"danger\")";
Debug.ShouldStop(536870912);
_danger = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_danger.setObject(_btnf.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("danger")))));Debug.locals.put("danger", _danger);
 BA.debugLineNum = 255;BA.debugLine="Dim bg_to As String = danger.Get(\"bg_to\")";
Debug.ShouldStop(1073741824);
_bg_to = BA.ObjectToString(_danger.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_to")))));Debug.locals.put("bg_to", _bg_to);Debug.locals.put("bg_to", _bg_to);
 BA.debugLineNum = 256;BA.debugLine="Dim bg_from As String = danger.Get(\"bg_from\")";
Debug.ShouldStop(-2147483648);
_bg_from = BA.ObjectToString(_danger.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_from")))));Debug.locals.put("bg_from", _bg_from);Debug.locals.put("bg_from", _bg_from);
 BA.debugLineNum = 257;BA.debugLine="Dim color As String = danger.Get(\"color\")";
Debug.ShouldStop(1);
_color = BA.ObjectToString(_danger.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("color")))));Debug.locals.put("color", _color);Debug.locals.put("color", _color);
 BA.debugLineNum = 258;BA.debugLine="Dim info As Map = btnf.Get(\"info\")";
Debug.ShouldStop(2);
_info = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_info.setObject(_btnf.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("info")))));Debug.locals.put("info", _info);
 BA.debugLineNum = 259;BA.debugLine="Dim bg_to As String = info.Get(\"bg_to\")";
Debug.ShouldStop(4);
_bg_to = BA.ObjectToString(_info.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_to")))));Debug.locals.put("bg_to", _bg_to);Debug.locals.put("bg_to", _bg_to);
 BA.debugLineNum = 260;BA.debugLine="Dim bg_from As String = info.Get(\"bg_from\")";
Debug.ShouldStop(8);
_bg_from = BA.ObjectToString(_info.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("bg_from")))));Debug.locals.put("bg_from", _bg_from);Debug.locals.put("bg_from", _bg_from);
 BA.debugLineNum = 261;BA.debugLine="Dim color As String = info.Get(\"color\")";
Debug.ShouldStop(16);
_color = BA.ObjectToString(_info.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("color")))));Debug.locals.put("color", _color);Debug.locals.put("color", _color);
 BA.debugLineNum = 262;BA.debugLine="Dim menu As List = result.Get(\"menu\")";
Debug.ShouldStop(32);
_menu = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_menu.setObject(_result.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("menu")))));Debug.locals.put("menu", _menu);
 BA.debugLineNum = 263;BA.debugLine="For Each colmenu As Map In menu";
Debug.ShouldStop(64);
_colmenu = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group158 = _menu;
final int groupLen158 = group158.runMethod(true,"getSize").<Integer>get()
;int index158 = 0;
;
for (; index158 < groupLen158;index158++){
_colmenu.setObject(group158.runMethod(false,"Get",index158));
Debug.locals.put("colmenu", _colmenu);
 BA.debugLineNum = 264;BA.debugLine="Dim icon As String = colmenu.Get(\"icon\")";
Debug.ShouldStop(128);
_icon = BA.ObjectToString(_colmenu.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("icon")))));Debug.locals.put("icon", _icon);Debug.locals.put("icon", _icon);
 BA.debugLineNum = 265;BA.debugLine="Dim link As String = colmenu.Get(\"link\")";
Debug.ShouldStop(256);
_link = BA.ObjectToString(_colmenu.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("link")))));Debug.locals.put("link", _link);Debug.locals.put("link", _link);
 BA.debugLineNum = 266;BA.debugLine="Dim Typefg As String = colmenu.Get(\"type\")";
Debug.ShouldStop(512);
_typefg = BA.ObjectToString(_colmenu.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("type")))));Debug.locals.put("Typefg", _typefg);Debug.locals.put("Typefg", _typefg);
 BA.debugLineNum = 267;BA.debugLine="Dim title As String = colmenu.Get(\"title\")";
Debug.ShouldStop(1024);
_title = BA.ObjectToString(_colmenu.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("title")))));Debug.locals.put("title", _title);Debug.locals.put("title", _title);
 }
}Debug.locals.put("colmenu", _colmenu);
;
 BA.debugLineNum = 270;BA.debugLine="Dim versiond As Map = result.Get(\"version\")";
Debug.ShouldStop(8192);
_versiond = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_versiond.setObject(_result.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("version")))));Debug.locals.put("versiond", _versiond);
 BA.debugLineNum = 271;BA.debugLine="Dim deprecated_descd As String = versiond.Get(\"de";
Debug.ShouldStop(16384);
_deprecated_descd = BA.ObjectToString(_versiond.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("deprecated_desc")))));Debug.locals.put("deprecated_descd", _deprecated_descd);Debug.locals.put("deprecated_descd", _deprecated_descd);
 BA.debugLineNum = 272;BA.debugLine="Dim lastd As Int = versiond.Get(\"last\")";
Debug.ShouldStop(32768);
_lastd = BA.numberCast(int.class, _versiond.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("last")))));Debug.locals.put("lastd", _lastd);Debug.locals.put("lastd", _lastd);
 BA.debugLineNum = 273;BA.debugLine="Dim deprecatedd As Int = versiond.Get(\"deprecated";
Debug.ShouldStop(65536);
_deprecatedd = BA.numberCast(int.class, _versiond.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("deprecated")))));Debug.locals.put("deprecatedd", _deprecatedd);Debug.locals.put("deprecatedd", _deprecatedd);
 BA.debugLineNum = 274;BA.debugLine="Dim update_titled As String = versiond.Get(\"updat";
Debug.ShouldStop(131072);
_update_titled = BA.ObjectToString(_versiond.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("update_title")))));Debug.locals.put("update_titled", _update_titled);Debug.locals.put("update_titled", _update_titled);
 BA.debugLineNum = 275;BA.debugLine="Dim deprecated_titled As String = versiond.Get(\"d";
Debug.ShouldStop(262144);
_deprecated_titled = BA.ObjectToString(_versiond.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("deprecated_title")))));Debug.locals.put("deprecated_titled", _deprecated_titled);Debug.locals.put("deprecated_titled", _deprecated_titled);
 BA.debugLineNum = 276;BA.debugLine="Dim update_descd As String = versiond.Get(\"update";
Debug.ShouldStop(524288);
_update_descd = BA.ObjectToString(_versiond.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("update_desc")))));Debug.locals.put("update_descd", _update_descd);Debug.locals.put("update_descd", _update_descd);
 BA.debugLineNum = 277;BA.debugLine="Dim url As Map = result.Get(\"url\")";
Debug.ShouldStop(1048576);
_url = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_url.setObject(_result.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("url")))));Debug.locals.put("url", _url);
 BA.debugLineNum = 278;BA.debugLine="Dim sited As String = url.Get(\"site\")";
Debug.ShouldStop(2097152);
_sited = BA.ObjectToString(_url.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("site")))));Debug.locals.put("sited", _sited);Debug.locals.put("sited", _sited);
 BA.debugLineNum = 279;BA.debugLine="Dim domain As String = url.Get(\"domain\")";
Debug.ShouldStop(4194304);
_domain = BA.ObjectToString(_url.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("domain")))));Debug.locals.put("domain", _domain);Debug.locals.put("domain", _domain);
 BA.debugLineNum = 280;BA.debugLine="Dim rootd As String = url.Get(\"root\")";
Debug.ShouldStop(8388608);
_rootd = BA.ObjectToString(_url.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("root")))));Debug.locals.put("rootd", _rootd);Debug.locals.put("rootd", _rootd);
 BA.debugLineNum = 281;BA.debugLine="Dim update As String = url.Get(\"update\")";
Debug.ShouldStop(16777216);
_update = BA.ObjectToString(_url.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("update")))));Debug.locals.put("update", _update);Debug.locals.put("update", _update);
 BA.debugLineNum = 282;BA.debugLine="Dim enter As String = url.Get(\"enter\")";
Debug.ShouldStop(33554432);
_enter = BA.ObjectToString(_url.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("enter")))));Debug.locals.put("enter", _enter);Debug.locals.put("enter", _enter);
 BA.debugLineNum = 283;BA.debugLine="Dim kingdom As String = url.Get(\"kingdom\")";
Debug.ShouldStop(67108864);
_kingdom = BA.ObjectToString(_url.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("kingdom")))));Debug.locals.put("kingdom", _kingdom);Debug.locals.put("kingdom", _kingdom);
 BA.debugLineNum = 284;BA.debugLine="Dim homepage As List = result.Get(\"homepage\")";
Debug.ShouldStop(134217728);
_homepage = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_homepage.setObject(_result.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("homepage")))));Debug.locals.put("homepage", _homepage);
 BA.debugLineNum = 285;BA.debugLine="For Each colhomepage As Map In homepage";
Debug.ShouldStop(268435456);
_colhomepage = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group179 = _homepage;
final int groupLen179 = group179.runMethod(true,"getSize").<Integer>get()
;int index179 = 0;
;
for (; index179 < groupLen179;index179++){
_colhomepage.setObject(group179.runMethod(false,"Get",index179));
Debug.locals.put("colhomepage", _colhomepage);
 BA.debugLineNum = 287;BA.debugLine="Dim Typert As String = colhomepage.Get(\"type\")";
Debug.ShouldStop(1073741824);
_typert = BA.ObjectToString(_colhomepage.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("type")))));Debug.locals.put("Typert", _typert);Debug.locals.put("Typert", _typert);
 BA.debugLineNum = 290;BA.debugLine="Select Typert";
Debug.ShouldStop(2);
switch (BA.switchObjectToInt(_typert,BA.ObjectToString("promotion"))) {
case 0: {
 BA.debugLineNum = 292;BA.debugLine="Dim expire As Map = colhomepage.Get(\"expire\")";
Debug.ShouldStop(8);
_expire = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_expire.setObject(_colhomepage.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("expire")))));Debug.locals.put("expire", _expire);
 BA.debugLineNum = 293;BA.debugLine="If colhomepage.ContainsKey(\"data\") Then";
Debug.ShouldStop(16);
if (_colhomepage.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("data")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 295;BA.debugLine="Dim data As List = colhomepage.Get(\"data\")";
Debug.ShouldStop(64);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_data.setObject(_colhomepage.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("data")))));Debug.locals.put("data", _data);
 BA.debugLineNum = 296;BA.debugLine="Dim lst As List";
Debug.ShouldStop(128);
_lst = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("lst", _lst);
 BA.debugLineNum = 297;BA.debugLine="lst.Initialize";
Debug.ShouldStop(256);
_lst.runVoidMethod ("Initialize");
 BA.debugLineNum = 298;BA.debugLine="For Each coldata As Map In data";
Debug.ShouldStop(512);
_coldata = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group188 = _data;
final int groupLen188 = group188.runMethod(true,"getSize").<Integer>get()
;int index188 = 0;
;
for (; index188 < groupLen188;index188++){
_coldata.setObject(group188.runMethod(false,"Get",index188));
Debug.locals.put("coldata", _coldata);
 BA.debugLineNum = 299;BA.debugLine="Dim mode As String = coldata.Get(\"mode\")";
Debug.ShouldStop(1024);
_mode = BA.ObjectToString(_coldata.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("mode")))));Debug.locals.put("mode", _mode);Debug.locals.put("mode", _mode);
 BA.debugLineNum = 300;BA.debugLine="Dim title As String = coldata.Get(\"title\")";
Debug.ShouldStop(2048);
_title = BA.ObjectToString(_coldata.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("title")))));Debug.locals.put("title", _title);Debug.locals.put("title", _title);
 BA.debugLineNum = 302;BA.debugLine="Dim image As String = coldata.Get(\"image\")";
Debug.ShouldStop(8192);
_image = BA.ObjectToString(_coldata.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("image")))));Debug.locals.put("image", _image);Debug.locals.put("image", _image);
 BA.debugLineNum = 303;BA.debugLine="Dim Activitya As String = coldata.Get(\"activ";
Debug.ShouldStop(16384);
_activitya = BA.ObjectToString(_coldata.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("activity")))));Debug.locals.put("Activitya", _activitya);Debug.locals.put("Activitya", _activitya);
 BA.debugLineNum = 304;BA.debugLine="Dim urla As String = coldata.Get(\"url\")";
Debug.ShouldStop(32768);
_urla = BA.ObjectToString(_coldata.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("url")))));Debug.locals.put("urla", _urla);Debug.locals.put("urla", _urla);
 BA.debugLineNum = 306;BA.debugLine="lst.Add(image&\"#\"&\"123123\"&\"#\"&title&\"#\"&\"10";
Debug.ShouldStop(131072);
_lst.runVoidMethod ("Add",(Object)((RemoteObject.concat(_image,RemoteObject.createImmutable("#"),RemoteObject.createImmutable("123123"),RemoteObject.createImmutable("#"),_title,RemoteObject.createImmutable("#"),RemoteObject.createImmutable("1000"),RemoteObject.createImmutable("#"),RemoteObject.createImmutable("455"),RemoteObject.createImmutable("#"),RemoteObject.createImmutable("132"),RemoteObject.createImmutable("#"),RemoteObject.createImmutable("123"),RemoteObject.createImmutable("#"),RemoteObject.createImmutable("123"),RemoteObject.createImmutable("#"),RemoteObject.createImmutable("132")))));
 }
}Debug.locals.put("coldata", _coldata);
;
 BA.debugLineNum = 309;BA.debugLine="Log(expire.Get(\"serverttime\"))";
Debug.ShouldStop(1048576);
home.mostCurrent.__c.runVoidMethod ("LogImpl","39240780",BA.ObjectToString(_expire.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("serverttime"))))),0);
 BA.debugLineNum = 310;BA.debugLine="Log(expire.Get(\"expiretime\"))";
Debug.ShouldStop(2097152);
home.mostCurrent.__c.runVoidMethod ("LogImpl","39240781",BA.ObjectToString(_expire.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("expiretime"))))),0);
 BA.debugLineNum = 311;BA.debugLine="shegeft_creat(4%x,lst,expire.Get(\"serverttime";
Debug.ShouldStop(4194304);
_shegeft_creat(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 4)),home.mostCurrent.activityBA),_lst,BA.numberCast(long.class, _expire.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("serverttime"))))),BA.numberCast(long.class, _expire.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("expiretime"))))));
 BA.debugLineNum = 312;BA.debugLine="Log(title)";
Debug.ShouldStop(8388608);
home.mostCurrent.__c.runVoidMethod ("LogImpl","39240783",_title,0);
 };
 break; }
}
;
 }
}Debug.locals.put("colhomepage", _colhomepage);
;
 BA.debugLineNum = 321;BA.debugLine="Dim ok As String = root.Get(\"ok\")";
Debug.ShouldStop(1);
_ok = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("ok")))));Debug.locals.put("ok", _ok);Debug.locals.put("ok", _ok);
 BA.debugLineNum = 322;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
 //BA.debugLineNum = 9;BA.debugLine="Dim t_shegeft As Timer";
home._t_shegeft = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _shegeft_creat(RemoteObject _top,RemoteObject _lstnews1,RemoteObject _start,RemoteObject _endd) throws Exception{
try {
		Debug.PushSubsStack("shegeft_creat (home) ","home",4,home.mostCurrent.activityBA,home.mostCurrent,323);
if (RapidSub.canDelegate("shegeft_creat")) { return b4a.example.home.remoteMe.runUserSub(false, "home","shegeft_creat", _top, _lstnews1, _start, _endd);}
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _shegeft = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _fc = RemoteObject.declareNull("b4a.example.creatlv");
Debug.locals.put("top", _top);
Debug.locals.put("lstnews1", _lstnews1);
Debug.locals.put("start", _start);
Debug.locals.put("endd", _endd);
 BA.debugLineNum = 323;BA.debugLine="Sub shegeft_creat(top As Int,lstnews1 As List,star";
Debug.ShouldStop(4);
 BA.debugLineNum = 324;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(8);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 325;BA.debugLine="pnl.Initialize(\"\")";
Debug.ShouldStop(16);
_pnl.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 326;BA.debugLine="sv.Panel.AddView(pnl,0,top,100%x,50%x)";
Debug.ShouldStop(32);
home.mostCurrent._sv.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_pnl.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_top),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),home.mostCurrent.activityBA)),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),home.mostCurrent.activityBA)));
 BA.debugLineNum = 328;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(128);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 329;BA.debugLine="cd.Initialize(0xFF727272,2dip)";
Debug.ShouldStop(256);
_cd.runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 0xff727272)),(Object)(home.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 332;BA.debugLine="lblho.Initialize(\"\")";
Debug.ShouldStop(2048);
home.mostCurrent._lblho.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 333;BA.debugLine="pnl.AddView(lblho,4%x,1%x,8%x,8%x)";
Debug.ShouldStop(4096);
_pnl.runVoidMethod ("AddView",(Object)((home.mostCurrent._lblho.getObject())),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 4)),home.mostCurrent.activityBA)),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),home.mostCurrent.activityBA)),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 8)),home.mostCurrent.activityBA)),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 8)),home.mostCurrent.activityBA)));
 BA.debugLineNum = 334;BA.debugLine="lblho.Background=cd";
Debug.ShouldStop(8192);
home.mostCurrent._lblho.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 335;BA.debugLine="lblho.Text=\"02\"";
Debug.ShouldStop(16384);
home.mostCurrent._lblho.runMethod(true,"setText",BA.ObjectToCharSequence("02"));
 BA.debugLineNum = 336;BA.debugLine="lblho.Gravity=Gravity.CENTER";
Debug.ShouldStop(32768);
home.mostCurrent._lblho.runMethod(true,"setGravity",home.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 337;BA.debugLine="lblho.TextColor=Colors.White";
Debug.ShouldStop(65536);
home.mostCurrent._lblho.runMethod(true,"setTextColor",home.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 338;BA.debugLine="lblho.TextSize=16";
Debug.ShouldStop(131072);
home.mostCurrent._lblho.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 340;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(524288);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 341;BA.debugLine="lbl.Initialize(\"\")";
Debug.ShouldStop(1048576);
_lbl.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 342;BA.debugLine="pnl.AddView(lbl,12%x,1%x,3%x,8%x)";
Debug.ShouldStop(2097152);
_pnl.runVoidMethod ("AddView",(Object)((_lbl.getObject())),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 12)),home.mostCurrent.activityBA)),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),home.mostCurrent.activityBA)),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 3)),home.mostCurrent.activityBA)),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 8)),home.mostCurrent.activityBA)));
 BA.debugLineNum = 343;BA.debugLine="lbl.Text=\":\"";
Debug.ShouldStop(4194304);
_lbl.runMethod(true,"setText",BA.ObjectToCharSequence(":"));
 BA.debugLineNum = 344;BA.debugLine="lbl.Gravity=Gravity.CENTER";
Debug.ShouldStop(8388608);
_lbl.runMethod(true,"setGravity",home.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 345;BA.debugLine="lbl.TextColor=0xFF727272";
Debug.ShouldStop(16777216);
_lbl.runMethod(true,"setTextColor",BA.numberCast(int.class, 0xff727272));
 BA.debugLineNum = 346;BA.debugLine="lbl.TextSize=16";
Debug.ShouldStop(33554432);
_lbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 348;BA.debugLine="lblmin.Initialize(\"\")";
Debug.ShouldStop(134217728);
home.mostCurrent._lblmin.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 349;BA.debugLine="pnl.AddView(lblmin,15%x,1%x,8%x,8%x)";
Debug.ShouldStop(268435456);
_pnl.runVoidMethod ("AddView",(Object)((home.mostCurrent._lblmin.getObject())),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),home.mostCurrent.activityBA)),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),home.mostCurrent.activityBA)),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 8)),home.mostCurrent.activityBA)),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 8)),home.mostCurrent.activityBA)));
 BA.debugLineNum = 350;BA.debugLine="lblmin.Background=cd";
Debug.ShouldStop(536870912);
home.mostCurrent._lblmin.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 351;BA.debugLine="lblmin.Text=\"02\"";
Debug.ShouldStop(1073741824);
home.mostCurrent._lblmin.runMethod(true,"setText",BA.ObjectToCharSequence("02"));
 BA.debugLineNum = 352;BA.debugLine="lblmin.Gravity=Gravity.CENTER";
Debug.ShouldStop(-2147483648);
home.mostCurrent._lblmin.runMethod(true,"setGravity",home.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 353;BA.debugLine="lblmin.TextColor=Colors.White";
Debug.ShouldStop(1);
home.mostCurrent._lblmin.runMethod(true,"setTextColor",home.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 354;BA.debugLine="lblmin.TextSize=16";
Debug.ShouldStop(2);
home.mostCurrent._lblmin.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 356;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(8);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 357;BA.debugLine="lbl.Initialize(\"\")";
Debug.ShouldStop(16);
_lbl.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 358;BA.debugLine="pnl.AddView(lbl,23%x,1%x,3%x,8%x)";
Debug.ShouldStop(32);
_pnl.runVoidMethod ("AddView",(Object)((_lbl.getObject())),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 23)),home.mostCurrent.activityBA)),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),home.mostCurrent.activityBA)),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 3)),home.mostCurrent.activityBA)),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 8)),home.mostCurrent.activityBA)));
 BA.debugLineNum = 359;BA.debugLine="lbl.Text=\":\"";
Debug.ShouldStop(64);
_lbl.runMethod(true,"setText",BA.ObjectToCharSequence(":"));
 BA.debugLineNum = 360;BA.debugLine="lbl.Gravity=Gravity.CENTER";
Debug.ShouldStop(128);
_lbl.runMethod(true,"setGravity",home.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 361;BA.debugLine="lbl.TextColor=0xFF727272";
Debug.ShouldStop(256);
_lbl.runMethod(true,"setTextColor",BA.numberCast(int.class, 0xff727272));
 BA.debugLineNum = 362;BA.debugLine="lbl.TextSize=16";
Debug.ShouldStop(512);
_lbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 364;BA.debugLine="lblsecend.Initialize(\"\")";
Debug.ShouldStop(2048);
home.mostCurrent._lblsecend.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 365;BA.debugLine="pnl.AddView(lblsecend,26%x,1%x,8%x,8%x)";
Debug.ShouldStop(4096);
_pnl.runVoidMethod ("AddView",(Object)((home.mostCurrent._lblsecend.getObject())),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 26)),home.mostCurrent.activityBA)),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),home.mostCurrent.activityBA)),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 8)),home.mostCurrent.activityBA)),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 8)),home.mostCurrent.activityBA)));
 BA.debugLineNum = 366;BA.debugLine="lblsecend.Background=cd";
Debug.ShouldStop(8192);
home.mostCurrent._lblsecend.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 367;BA.debugLine="lblsecend.Text=\"02\"";
Debug.ShouldStop(16384);
home.mostCurrent._lblsecend.runMethod(true,"setText",BA.ObjectToCharSequence("02"));
 BA.debugLineNum = 368;BA.debugLine="lblsecend.Gravity=Gravity.CENTER";
Debug.ShouldStop(32768);
home.mostCurrent._lblsecend.runMethod(true,"setGravity",home.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 369;BA.debugLine="lblsecend.TextColor=Colors.White";
Debug.ShouldStop(65536);
home.mostCurrent._lblsecend.runMethod(true,"setTextColor",home.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 370;BA.debugLine="lblsecend.TextSize=16";
Debug.ShouldStop(131072);
home.mostCurrent._lblsecend.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 372;BA.debugLine="time313 =endd-start";
Debug.ShouldStop(524288);
home._time313 = RemoteObject.solve(new RemoteObject[] {_endd,_start}, "-",1, 2);
 BA.debugLineNum = 374;BA.debugLine="t_shegeft.Initialize(\"t_shegeft\", 1000)";
Debug.ShouldStop(2097152);
home._t_shegeft.runVoidMethod ("Initialize",home.processBA,(Object)(BA.ObjectToString("t_shegeft")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 375;BA.debugLine="t_shegeft.Enabled = True";
Debug.ShouldStop(4194304);
home._t_shegeft.runMethod(true,"setEnabled",home.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 377;BA.debugLine="Dim shegeft As Label";
Debug.ShouldStop(16777216);
_shegeft = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("shegeft", _shegeft);
 BA.debugLineNum = 378;BA.debugLine="shegeft.Initialize(\"\")";
Debug.ShouldStop(33554432);
_shegeft.runVoidMethod ("Initialize",home.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 379;BA.debugLine="shegeft.Text=\"محصولات شگفت انگیز\"";
Debug.ShouldStop(67108864);
_shegeft.runMethod(true,"setText",BA.ObjectToCharSequence("محصولات شگفت انگیز"));
 BA.debugLineNum = 380;BA.debugLine="shegeft.Gravity=Gravity.RIGHT+Gravity.CENTER";
Debug.ShouldStop(134217728);
_shegeft.runMethod(true,"setGravity",RemoteObject.solve(new RemoteObject[] {home.mostCurrent.__c.getField(false,"Gravity").getField(true,"RIGHT"),home.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")}, "+",1, 1));
 BA.debugLineNum = 381;BA.debugLine="shegeft.Typeface=C.irs";
Debug.ShouldStop(268435456);
_shegeft.runMethod(false,"setTypeface",(home.mostCurrent._c._irs /*RemoteObject*/ .getObject()));
 BA.debugLineNum = 382;BA.debugLine="shegeft.TextSize=18";
Debug.ShouldStop(536870912);
_shegeft.runMethod(true,"setTextSize",BA.numberCast(float.class, 18));
 BA.debugLineNum = 383;BA.debugLine="sv.Panel.AddView(shegeft,50%x,top,45%x,10%x)";
Debug.ShouldStop(1073741824);
home.mostCurrent._sv.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_shegeft.getObject())),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),home.mostCurrent.activityBA)),(Object)(_top),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 45)),home.mostCurrent.activityBA)),(Object)(home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),home.mostCurrent.activityBA)));
 BA.debugLineNum = 385;BA.debugLine="Dim fc As creatLV";
Debug.ShouldStop(1);
_fc = RemoteObject.createNew ("b4a.example.creatlv");Debug.locals.put("fc", _fc);
 BA.debugLineNum = 386;BA.debugLine="fc.Initialize(sv.Panel,top+12%x,lstnews1)";
Debug.ShouldStop(2);
_fc.runClassMethod (b4a.example.creatlv.class, "_initialize" /*RemoteObject*/ ,home.mostCurrent.activityBA,(Object)(home.mostCurrent._sv.runMethod(false,"getPanel")),(Object)(RemoteObject.solve(new RemoteObject[] {_top,home.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 12)),home.mostCurrent.activityBA)}, "+",1, 1)),(Object)(_lstnews1));
 BA.debugLineNum = 388;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _t_shegeft_tick() throws Exception{
try {
		Debug.PushSubsStack("t_shegeft_Tick (home) ","home",4,home.mostCurrent.activityBA,home.mostCurrent,390);
if (RapidSub.canDelegate("t_shegeft_tick")) { return b4a.example.home.remoteMe.runUserSub(false, "home","t_shegeft_tick");}
RemoteObject _sec = RemoteObject.createImmutable(0);
RemoteObject _hours = RemoteObject.createImmutable(0);
RemoteObject _minutes = RemoteObject.createImmutable(0);
 BA.debugLineNum = 390;BA.debugLine="Sub t_shegeft_Tick";
Debug.ShouldStop(32);
 BA.debugLineNum = 393;BA.debugLine="time313=time313-1000";
Debug.ShouldStop(256);
home._time313 = RemoteObject.solve(new RemoteObject[] {home._time313,RemoteObject.createImmutable(1000)}, "-",1, 2);
 BA.debugLineNum = 395;BA.debugLine="Dim sec, hours, minutes As Int";
Debug.ShouldStop(1024);
_sec = RemoteObject.createImmutable(0);Debug.locals.put("sec", _sec);
_hours = RemoteObject.createImmutable(0);Debug.locals.put("hours", _hours);
_minutes = RemoteObject.createImmutable(0);Debug.locals.put("minutes", _minutes);
 BA.debugLineNum = 401;BA.debugLine="hours = DateTime.GetHour(time313)";
Debug.ShouldStop(65536);
_hours = home.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(home._time313));Debug.locals.put("hours", _hours);
 BA.debugLineNum = 402;BA.debugLine="minutes = DateTime.GetMinute(time313)";
Debug.ShouldStop(131072);
_minutes = home.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(home._time313));Debug.locals.put("minutes", _minutes);
 BA.debugLineNum = 403;BA.debugLine="sec = DateTime.GetSecond(time313)";
Debug.ShouldStop(262144);
_sec = home.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetSecond",(Object)(home._time313));Debug.locals.put("sec", _sec);
 BA.debugLineNum = 406;BA.debugLine="lblsecend.Text=sec";
Debug.ShouldStop(2097152);
home.mostCurrent._lblsecend.runMethod(true,"setText",BA.ObjectToCharSequence(_sec));
 BA.debugLineNum = 407;BA.debugLine="lblmin.Text=minutes";
Debug.ShouldStop(4194304);
home.mostCurrent._lblmin.runMethod(true,"setText",BA.ObjectToCharSequence(_minutes));
 BA.debugLineNum = 408;BA.debugLine="lblho.Text=hours";
Debug.ShouldStop(8388608);
home.mostCurrent._lblho.runMethod(true,"setText",BA.ObjectToCharSequence(_hours));
 BA.debugLineNum = 412;BA.debugLine="If lblsecend.Text<10 Then  lblsecend.Text=\"0\"&lbl";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("<",BA.numberCast(double.class, home.mostCurrent._lblsecend.runMethod(true,"getText")),BA.numberCast(double.class, 10))) { 
home.mostCurrent._lblsecend.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("0"),home.mostCurrent._lblsecend.runMethod(true,"getText"))));};
 BA.debugLineNum = 413;BA.debugLine="If lblmin.Text<10 Then  lblmin.Text=\"0\"& lblmin.T";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("<",BA.numberCast(double.class, home.mostCurrent._lblmin.runMethod(true,"getText")),BA.numberCast(double.class, 10))) { 
home.mostCurrent._lblmin.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("0"),home.mostCurrent._lblmin.runMethod(true,"getText"))));};
 BA.debugLineNum = 414;BA.debugLine="If lblho.Text<9 Then  lblho.Text=\"0\"& lblho.Text";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("<",BA.numberCast(double.class, home.mostCurrent._lblho.runMethod(true,"getText")),BA.numberCast(double.class, 9))) { 
home.mostCurrent._lblho.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("0"),home.mostCurrent._lblho.runMethod(true,"getText"))));};
 BA.debugLineNum = 416;BA.debugLine="If lblsecend.Text=0 Then  lblsecend.Text=\"00\"";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",home.mostCurrent._lblsecend.runMethod(true,"getText"),BA.NumberToString(0))) { 
home.mostCurrent._lblsecend.runMethod(true,"setText",BA.ObjectToCharSequence("00"));};
 BA.debugLineNum = 417;BA.debugLine="If lblmin.Text=0 Then  lblmin.Text=\"00\"";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",home.mostCurrent._lblmin.runMethod(true,"getText"),BA.NumberToString(0))) { 
home.mostCurrent._lblmin.runMethod(true,"setText",BA.ObjectToCharSequence("00"));};
 BA.debugLineNum = 418;BA.debugLine="If lblho.Text=0 Then  lblho.Text=\"00\"";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",home.mostCurrent._lblho.runMethod(true,"getText"),BA.NumberToString(0))) { 
home.mostCurrent._lblho.runMethod(true,"setText",BA.ObjectToCharSequence("00"));};
 BA.debugLineNum = 419;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}