package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class page_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,79);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.page.remoteMe.runUserSub(false, "page","activity_create", _firsttime);}
RemoteObject _sdk = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _a = RemoteObject.declareNull("de.amberhome.objects.appcompat.AppCompatBase");
RemoteObject _gradient1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.GradientDrawable");
RemoteObject _clrs = null;
RemoteObject _xml = RemoteObject.declareNull("anywheresoftware.b4a.object.XmlLayoutBuilder");
RemoteObject _imgtemp = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _ri = RemoteObject.declareNull("anywheresoftware.b4a.agraham.richstring.RichStringBuilder.RichString");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 79;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 80;BA.debugLine="If File.Exists(File.DirInternal,\"fsize\") = False";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",page.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(page.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("fsize"))),page.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 81;BA.debugLine="File.WriteString(File.DirInternal,\"fsize\",\"14\")";
Debug.ShouldStop(65536);
page.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(page.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("fsize")),(Object)(RemoteObject.createImmutable("14")));
 BA.debugLineNum = 82;BA.debugLine="fsize=14";
Debug.ShouldStop(131072);
page._fsize = BA.numberCast(int.class, 14);
 }else {
 BA.debugLineNum = 84;BA.debugLine="fsize=File.ReadString(File.DirInternal,\"fsize\")";
Debug.ShouldStop(524288);
page._fsize = BA.numberCast(int.class, page.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(page.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("fsize"))));
 };
 BA.debugLineNum = 87;BA.debugLine="isdowned=False";
Debug.ShouldStop(4194304);
page._isdowned = page.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 88;BA.debugLine="videolink=\"\"";
Debug.ShouldStop(8388608);
page._videolink = BA.ObjectToString("");
 BA.debugLineNum = 90;BA.debugLine="Activity.LoadLayout(\"matlab1\")";
Debug.ShouldStop(33554432);
page.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("matlab1")),page.mostCurrent.activityBA);
 BA.debugLineNum = 93;BA.debugLine="ScrollView1.Panel.LoadLayout(\"matlab2\")";
Debug.ShouldStop(268435456);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("matlab2")),page.mostCurrent.activityBA);
 BA.debugLineNum = 95;BA.debugLine="Dim sdk As Phone";
Debug.ShouldStop(1073741824);
_sdk = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("sdk", _sdk);
 BA.debugLineNum = 97;BA.debugLine="If sdk.SdkVersion >=19 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("g",_sdk.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 19))) { 
 BA.debugLineNum = 98;BA.debugLine="Dim a As AppCompat";
Debug.ShouldStop(2);
_a = RemoteObject.createNew ("de.amberhome.objects.appcompat.AppCompatBase");Debug.locals.put("a", _a);
 BA.debugLineNum = 99;BA.debugLine="ACToolBarLight1.Top=a.GetStatusBarHeight";
Debug.ShouldStop(4);
page.mostCurrent._actoolbarlight1.runMethod(true,"setTop",_a.runMethod(true,"GetStatusBarHeight",page.mostCurrent.activityBA));
 BA.debugLineNum = 100;BA.debugLine="toolbartemp.Height=a.GetStatusBarHeight";
Debug.ShouldStop(8);
page.mostCurrent._toolbartemp.runMethod(true,"setHeight",_a.runMethod(true,"GetStatusBarHeight",page.mostCurrent.activityBA));
 BA.debugLineNum = 101;BA.debugLine="toolbartemp.Top=0";
Debug.ShouldStop(16);
page.mostCurrent._toolbartemp.runMethod(true,"setTop",BA.numberCast(int.class, 0));
 BA.debugLineNum = 102;BA.debugLine="toolbartemp.Color=Colors.ARGB(100,0,39,0)";
Debug.ShouldStop(32);
page.mostCurrent._toolbartemp.runVoidMethod ("setColor",page.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 39)),(Object)(BA.numberCast(int.class, 0))));
 };
 BA.debugLineNum = 106;BA.debugLine="Dim Gradient1 As GradientDrawable";
Debug.ShouldStop(512);
_gradient1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("Gradient1", _gradient1);
 BA.debugLineNum = 107;BA.debugLine="Dim Clrs(2) As Int";
Debug.ShouldStop(1024);
_clrs = RemoteObject.createNewArray ("int", new int[] {2}, new Object[]{});Debug.locals.put("Clrs", _clrs);
 BA.debugLineNum = 108;BA.debugLine="Clrs(0) =Colors.ARGB(100,0,39,0)";
Debug.ShouldStop(2048);
_clrs.setArrayElement (page.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 39)),(Object)(BA.numberCast(int.class, 0))),BA.numberCast(int.class, 0));
 BA.debugLineNum = 109;BA.debugLine="Clrs(1) = Colors.Transparent";
Debug.ShouldStop(4096);
_clrs.setArrayElement (page.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"),BA.numberCast(int.class, 1));
 BA.debugLineNum = 110;BA.debugLine="Gradient1.Initialize(\"TOP_BOTTOM\", Clrs)";
Debug.ShouldStop(8192);
_gradient1.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"TOP_BOTTOM")),(Object)(_clrs));
 BA.debugLineNum = 112;BA.debugLine="ACToolBarLight1.Background=Gradient1";
Debug.ShouldStop(32768);
page.mostCurrent._actoolbarlight1.runMethod(false,"setBackground",(_gradient1.getObject()));
 BA.debugLineNum = 113;BA.debugLine="ACToolBarLight1.Elevation=5dip";
Debug.ShouldStop(65536);
page.mostCurrent._actoolbarlight1.runMethod(true,"setElevation",BA.numberCast(float.class, page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))));
 BA.debugLineNum = 114;BA.debugLine="Dim xml As XmlLayoutBuilder";
Debug.ShouldStop(131072);
_xml = RemoteObject.createNew ("anywheresoftware.b4a.object.XmlLayoutBuilder");Debug.locals.put("xml", _xml);
 BA.debugLineNum = 115;BA.debugLine="ACToolBarLight1.NavigationIconDrawable=xml.GetDra";
Debug.ShouldStop(262144);
page.mostCurrent._actoolbarlight1.runMethod(false,"setNavigationIconDrawable",_xml.runMethod(false,"GetDrawable",(Object)(RemoteObject.createImmutable("baseline_arrow_forward_white_24"))));
 BA.debugLineNum = 116;BA.debugLine="ACToolBarLight1.InitMenuListener";
Debug.ShouldStop(524288);
page.mostCurrent._actoolbarlight1.runVoidMethod ("InitMenuListener");
 BA.debugLineNum = 117;BA.debugLine="ACToolBarLight1.TitleTextColor=Colors.Transparent";
Debug.ShouldStop(1048576);
page.mostCurrent._actoolbarlight1.runVoidMethod ("setTitleTextColor",page.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 118;BA.debugLine="ACToolBarLight1.Title=Main.txtnewstitle";
Debug.ShouldStop(2097152);
page.mostCurrent._actoolbarlight1.runMethod(true,"setTitle",BA.ObjectToCharSequence(page.mostCurrent._main._txtnewstitle /*RemoteObject*/ ));
 BA.debugLineNum = 121;BA.debugLine="add2toolbar_sub";
Debug.ShouldStop(16777216);
_add2toolbar_sub();
 BA.debugLineNum = 123;BA.debugLine="Img.Tag=Null";
Debug.ShouldStop(67108864);
page.mostCurrent._img.runMethod(false,"setTag",page.mostCurrent.__c.getField(false,"Null"));
 BA.debugLineNum = 124;BA.debugLine="Img.Height=Img.Height+1%x";
Debug.ShouldStop(134217728);
page.mostCurrent._img.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {page.mostCurrent._img.runMethod(true,"getHeight"),page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),page.mostCurrent.activityBA)}, "+",1, 1));
 BA.debugLineNum = 125;BA.debugLine="firstimg=\"\"'Main.matlabimg313";
Debug.ShouldStop(268435456);
page.mostCurrent._firstimg = BA.ObjectToString("");
 BA.debugLineNum = 127;BA.debugLine="Img.Color=Colors.Transparent";
Debug.ShouldStop(1073741824);
page.mostCurrent._img.runVoidMethod ("setColor",page.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 130;BA.debugLine="Glide.Load(\"http\",Main.picnew).CenterCrop.Into(Im";
Debug.ShouldStop(2);
page.mostCurrent._glide.runMethod(false,"Load",page.mostCurrent.activityBA,(Object)(BA.ObjectToString("http")),(Object)(page.mostCurrent._main._picnew /*RemoteObject*/ )).runMethod(false,"CenterCrop").runVoidMethod ("Into",(Object)(page.mostCurrent._img));
 BA.debugLineNum = 133;BA.debugLine="Dim imgtemp As ImageView";
Debug.ShouldStop(16);
_imgtemp = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("imgtemp", _imgtemp);
 BA.debugLineNum = 134;BA.debugLine="imgtemp.Initialize(\"img\")";
Debug.ShouldStop(32);
_imgtemp.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("img")));
 BA.debugLineNum = 135;BA.debugLine="ScrollView1.Panel.AddView(imgtemp,0,0,100%x,Img.H";
Debug.ShouldStop(64);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_imgtemp.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),page.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {page.mostCurrent._img.runMethod(true,"getHeight"),page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),page.mostCurrent.activityBA)}, "-",1, 1)));
 BA.debugLineNum = 138;BA.debugLine="imglisnks.Initialize";
Debug.ShouldStop(512);
page.mostCurrent._imglisnks.runVoidMethod ("Initialize");
 BA.debugLineNum = 141;BA.debugLine="addtitle_sub(Main.txtnewstitle,\"\")";
Debug.ShouldStop(4096);
_addtitle_sub(page.mostCurrent._main._txtnewstitle /*RemoteObject*/ ,RemoteObject.createImmutable(""));
 BA.debugLineNum = 150;BA.debugLine="Disable_ScroolbarH(ScrollView1)";
Debug.ShouldStop(2097152);
_disable_scroolbarh(page.mostCurrent._scrollview1);
 BA.debugLineNum = 151;BA.debugLine="Force_LtrSupported4View(ProgressBar1)";
Debug.ShouldStop(4194304);
_force_ltrsupported4view(RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), page.mostCurrent._progressbar1.getObject()));
 BA.debugLineNum = 154;BA.debugLine="set_Ripple(flot2)";
Debug.ShouldStop(33554432);
_set_ripple(page.mostCurrent._flot2);
 BA.debugLineNum = 155;BA.debugLine="set_Ripple(flot4)";
Debug.ShouldStop(67108864);
_set_ripple(page.mostCurrent._flot4);
 BA.debugLineNum = 156;BA.debugLine="flot4.Visible=False";
Debug.ShouldStop(134217728);
page.mostCurrent._flot4.runMethod(true,"setVisible",page.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 157;BA.debugLine="flot3.Visible=False";
Debug.ShouldStop(268435456);
page.mostCurrent._flot3.runMethod(true,"setVisible",page.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 158;BA.debugLine="Dim ri As RichString";
Debug.ShouldStop(536870912);
_ri = RemoteObject.createNew ("anywheresoftware.b4a.agraham.richstring.RichStringBuilder.RichString");Debug.locals.put("ri", _ri);
 BA.debugLineNum = 159;BA.debugLine="ri.Initialize(Label2.Text)";
Debug.ShouldStop(1073741824);
_ri.runVoidMethod ("Initialize",(Object)(BA.ObjectToCharSequence(page.mostCurrent._label2.runMethod(true,"getText"))));
 BA.debugLineNum = 160;BA.debugLine="Label2.Text=ri.Color(0xFFBE1043,39,45)";
Debug.ShouldStop(-2147483648);
page.mostCurrent._label2.runMethod(true,"setText",BA.ObjectToCharSequence(_ri.runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xffbe1043)),(Object)(BA.numberCast(int.class, 39)),(Object)(BA.numberCast(int.class, 45))).getObject()));
 BA.debugLineNum = 163;BA.debugLine="bring_Up(flot3)";
Debug.ShouldStop(4);
_bring_up(RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), page.mostCurrent._flot3.getObject()));
 BA.debugLineNum = 169;BA.debugLine="flot.Visible=False";
Debug.ShouldStop(256);
page.mostCurrent._flot.runMethod(true,"setVisible",page.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 170;BA.debugLine="flot2.Visible=False";
Debug.ShouldStop(512);
page.mostCurrent._flot2.runMethod(true,"setVisible",page.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 171;BA.debugLine="flot3.Visible=False";
Debug.ShouldStop(1024);
page.mostCurrent._flot3.runMethod(true,"setVisible",page.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 172;BA.debugLine="flot4.Visible=False";
Debug.ShouldStop(2048);
page.mostCurrent._flot4.runMethod(true,"setVisible",page.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 174;BA.debugLine="c.Force_RtlSupported4View(ACToolBarLight1)";
Debug.ShouldStop(8192);
page.mostCurrent._c.runVoidMethod ("_force_rtlsupported4view" /*RemoteObject*/ ,page.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), page.mostCurrent._actoolbarlight1.getObject()));
 BA.debugLineNum = 175;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Pause (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,396);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.page.remoteMe.runUserSub(false, "page","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 396;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 398;BA.debugLine="Try";
Debug.ShouldStop(8192);
try { BA.debugLineNum = 400;BA.debugLine="ispus=False";
Debug.ShouldStop(32768);
page._ispus = page.mostCurrent.__c.getField(true,"False");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e4) {
			BA.rdebugUtils.runVoidMethod("setLastException",page.processBA, e4.toString()); };
 BA.debugLineNum = 404;BA.debugLine="Try";
Debug.ShouldStop(524288);
try { BA.debugLineNum = 405;BA.debugLine="mpo.Release";
Debug.ShouldStop(1048576);
page.mostCurrent._mpo.runVoidMethod ("Release");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",page.processBA, e8.toString()); };
 BA.debugLineNum = 409;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Activity_Resume (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,214);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.page.remoteMe.runUserSub(false, "page","activity_resume");}
 BA.debugLineNum = 214;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 216;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _actoolbarlight1_navigationitemclick() throws Exception{
try {
		Debug.PushSubsStack("ACToolBarLight1_NavigationItemClick (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,74);
if (RapidSub.canDelegate("actoolbarlight1_navigationitemclick")) { return b4a.example.page.remoteMe.runUserSub(false, "page","actoolbarlight1_navigationitemclick");}
 BA.debugLineNum = 74;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="StartActivity(finger)";
Debug.ShouldStop(1024);
page.mostCurrent.__c.runVoidMethod ("StartActivity",page.processBA,(Object)((page.mostCurrent._finger.getObject())));
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add2toolbar_sub() throws Exception{
try {
		Debug.PushSubsStack("add2toolbar_sub (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,494);
if (RapidSub.canDelegate("add2toolbar_sub")) { return b4a.example.page.remoteMe.runUserSub(false, "page","add2toolbar_sub");}
RemoteObject _xml = RemoteObject.declareNull("anywheresoftware.b4a.object.XmlLayoutBuilder");
RemoteObject _bh = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
 BA.debugLineNum = 494;BA.debugLine="Sub add2toolbar_sub";
Debug.ShouldStop(8192);
 BA.debugLineNum = 495;BA.debugLine="Dim xml As XmlLayoutBuilder";
Debug.ShouldStop(16384);
_xml = RemoteObject.createNew ("anywheresoftware.b4a.object.XmlLayoutBuilder");Debug.locals.put("xml", _xml);
 BA.debugLineNum = 498;BA.debugLine="Dim bh = xml.GetDrawable(\"baseline_share_white_24";
Debug.ShouldStop(131072);
_bh = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
_bh.setObject(_xml.runMethod(false,"GetDrawable",(Object)(RemoteObject.createImmutable("baseline_share_white_24"))));Debug.locals.put("bh", _bh);
 BA.debugLineNum = 499;BA.debugLine="Activity.AddMenuItem3(menu_Change(\"اشتراک گذاری\",";
Debug.ShouldStop(262144);
page.mostCurrent._activity.runVoidMethod ("AddMenuItem3",(Object)(BA.ObjectToCharSequence(_menu_change(BA.ObjectToString("اشتراک گذاری"),page.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"),page.mostCurrent._c._irs /*RemoteObject*/ ).getObject())),(Object)(BA.ObjectToString("share")),(Object)(_bh.runMethod(false,"getBitmap")),(Object)(page.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 507;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addtitle_sub(RemoteObject _title,RemoteObject _matn) throws Exception{
try {
		Debug.PushSubsStack("addtitle_sub (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,339);
if (RapidSub.canDelegate("addtitle_sub")) { return b4a.example.page.remoteMe.runUserSub(false, "page","addtitle_sub", _title, _matn);}
RemoteObject _lable = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _h = RemoteObject.declareNull("wir.hitex.recycler.Hitex_Utils");
Debug.locals.put("title", _title);
Debug.locals.put("matn", _matn);
 BA.debugLineNum = 339;BA.debugLine="Sub addtitle_sub(title As String , matn As String)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 340;BA.debugLine="If titletemp=False Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",page._titletemp,page.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 341;BA.debugLine="Dim lable As Label";
Debug.ShouldStop(1048576);
_lable = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lable", _lable);
 BA.debugLineNum = 342;BA.debugLine="lable.Initialize(\"\")";
Debug.ShouldStop(2097152);
_lable.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 343;BA.debugLine="lable.Text=title";
Debug.ShouldStop(4194304);
_lable.runMethod(true,"setText",BA.ObjectToCharSequence(_title));
 BA.debugLineNum = 344;BA.debugLine="lable.Typeface=Typeface.CreateNew(C.irs, Typefac";
Debug.ShouldStop(8388608);
_lable.runMethod(false,"setTypeface",page.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"CreateNew",(Object)((page.mostCurrent._c._irs /*RemoteObject*/ .getObject())),(Object)(page.mostCurrent.__c.getField(false,"Typeface").getField(true,"STYLE_BOLD"))));
 BA.debugLineNum = 345;BA.debugLine="lable.Color=Colors.White'.ARGB(255,245,229,231)";
Debug.ShouldStop(16777216);
_lable.runVoidMethod ("setColor",page.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 346;BA.debugLine="lable.TextColor=Colors.ARGB(255,4,0,153)";
Debug.ShouldStop(33554432);
_lable.runMethod(true,"setTextColor",page.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 4)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 153))));
 BA.debugLineNum = 347;BA.debugLine="lable.Padding=Array As Int (20dip,0,20dip,0)";
Debug.ShouldStop(67108864);
_lable.runMethod(false,"setPadding",RemoteObject.createNewArray("int",new int[] {4},new Object[] {page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20))),BA.numberCast(int.class, 0),page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20))),BA.numberCast(int.class, 0)}));
 BA.debugLineNum = 349;BA.debugLine="lable.TextSize=23";
Debug.ShouldStop(268435456);
_lable.runMethod(true,"setTextSize",BA.numberCast(float.class, 23));
 BA.debugLineNum = 350;BA.debugLine="lable.Gravity= Gravity.RIGHT";
Debug.ShouldStop(536870912);
_lable.runMethod(true,"setGravity",page.mostCurrent.__c.getField(false,"Gravity").getField(true,"RIGHT"));
 BA.debugLineNum = 352;BA.debugLine="ScrollView1.Panel.AddView(lable,2%x,toptemp,96%x";
Debug.ShouldStop(-2147483648);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_lable.getObject())),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 2)),page.mostCurrent.activityBA)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 96)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 353;BA.debugLine="Dim h As Hitex_Utils";
Debug.ShouldStop(1);
_h = RemoteObject.createNew ("wir.hitex.recycler.Hitex_Utils");Debug.locals.put("h", _h);
 BA.debugLineNum = 354;BA.debugLine="lable.Height=h.GetTextHeight(lable)'hlbl.LabelHe";
Debug.ShouldStop(2);
_lable.runMethod(true,"setHeight",BA.numberCast(int.class, _h.runMethod(true,"GetTextHeight",(Object)(_lable))));
 BA.debugLineNum = 355;BA.debugLine="lable.Height=lable.Height";
Debug.ShouldStop(4);
_lable.runMethod(true,"setHeight",_lable.runMethod(true,"getHeight"));
 BA.debugLineNum = 356;BA.debugLine="toptemp=toptemp+lable.Height";
Debug.ShouldStop(8);
page._toptemp = RemoteObject.solve(new RemoteObject[] {page._toptemp,_lable.runMethod(true,"getHeight")}, "+",1, 1);
 BA.debugLineNum = 357;BA.debugLine="titletemp=True";
Debug.ShouldStop(16);
page._titletemp = page.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 358;BA.debugLine="titelhaghttemp=lable.Height";
Debug.ShouldStop(32);
page._titelhaghttemp = _lable.runMethod(true,"getHeight");
 BA.debugLineNum = 360;BA.debugLine="Dim lable As Label";
Debug.ShouldStop(128);
_lable = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lable", _lable);
 BA.debugLineNum = 361;BA.debugLine="lable.Initialize(\"\")";
Debug.ShouldStop(256);
_lable.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 362;BA.debugLine="lable.Text=Chr(0xE916)";
Debug.ShouldStop(512);
_lable.runMethod(true,"setText",BA.ObjectToCharSequence(page.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xe916)))));
 BA.debugLineNum = 363;BA.debugLine="lable.Typeface=Typeface.MATERIALICONS";
Debug.ShouldStop(1024);
_lable.runMethod(false,"setTypeface",page.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getMATERIALICONS"));
 BA.debugLineNum = 364;BA.debugLine="lable.TextColor=0x8B000690";
Debug.ShouldStop(2048);
_lable.runMethod(true,"setTextColor",BA.numberCast(int.class, 0x8b000690));
 BA.debugLineNum = 365;BA.debugLine="lable.Padding=Array As Int (20dip,0,20dip,0)";
Debug.ShouldStop(4096);
_lable.runMethod(false,"setPadding",RemoteObject.createNewArray("int",new int[] {4},new Object[] {page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20))),BA.numberCast(int.class, 0),page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20))),BA.numberCast(int.class, 0)}));
 BA.debugLineNum = 366;BA.debugLine="ScrollView1.Panel.AddView(lable,2%x,toptemp,96%x";
Debug.ShouldStop(8192);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_lable.getObject())),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 2)),page.mostCurrent.activityBA)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 96)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 367;BA.debugLine="lable.Gravity= Bit.Or(Gravity.RIGHT,Gravity.CENT";
Debug.ShouldStop(16384);
_lable.runMethod(true,"setGravity",page.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(page.mostCurrent.__c.getField(false,"Gravity").getField(true,"RIGHT")),(Object)(page.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"))));
 BA.debugLineNum = 370;BA.debugLine="Dim lable As Label";
Debug.ShouldStop(131072);
_lable = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lable", _lable);
 BA.debugLineNum = 371;BA.debugLine="lable.Initialize(\"\")";
Debug.ShouldStop(262144);
_lable.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 372;BA.debugLine="lable.Text=saato_ina(Main.newsdate)";
Debug.ShouldStop(524288);
_lable.runMethod(true,"setText",BA.ObjectToCharSequence(_saato_ina(page.mostCurrent._main._newsdate /*RemoteObject*/ )));
 BA.debugLineNum = 373;BA.debugLine="lable.Typeface=C.irs";
Debug.ShouldStop(1048576);
_lable.runMethod(false,"setTypeface",(page.mostCurrent._c._irs /*RemoteObject*/ .getObject()));
 BA.debugLineNum = 374;BA.debugLine="lable.TextColor=0x8B000690";
Debug.ShouldStop(2097152);
_lable.runMethod(true,"setTextColor",BA.numberCast(int.class, 0x8b000690));
 BA.debugLineNum = 375;BA.debugLine="lable.Padding=Array As Int (20dip,0,40dip,0)";
Debug.ShouldStop(4194304);
_lable.runMethod(false,"setPadding",RemoteObject.createNewArray("int",new int[] {4},new Object[] {page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20))),BA.numberCast(int.class, 0),page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40))),BA.numberCast(int.class, 0)}));
 BA.debugLineNum = 376;BA.debugLine="ScrollView1.Panel.AddView(lable,2%x,toptemp,96%x";
Debug.ShouldStop(8388608);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_lable.getObject())),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 2)),page.mostCurrent.activityBA)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 96)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 377;BA.debugLine="lable.Gravity= Bit.Or(Gravity.RIGHT,Gravity.CENT";
Debug.ShouldStop(16777216);
_lable.runMethod(true,"setGravity",page.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(page.mostCurrent.__c.getField(false,"Gravity").getField(true,"RIGHT")),(Object)(page.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"))));
 BA.debugLineNum = 378;BA.debugLine="toptemp=toptemp+10%x";
Debug.ShouldStop(33554432);
page._toptemp = RemoteObject.solve(new RemoteObject[] {page._toptemp,page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),page.mostCurrent.activityBA)}, "+",1, 1);
 };
 BA.debugLineNum = 380;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addviewtosv_sub() throws Exception{
try {
		Debug.PushSubsStack("addviewtosv_sub (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,561);
if (RapidSub.canDelegate("addviewtosv_sub")) { return b4a.example.page.remoteMe.runUserSub(false, "page","addviewtosv_sub");}
int _o = 0;
RemoteObject _h13 = null;
RemoteObject _typee = RemoteObject.createImmutable("");
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _img1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _imgdori = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _txt = RemoteObject.createImmutable("");
RemoteObject _lable = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _h14 = null;
RemoteObject _colo = RemoteObject.createImmutable(0);
RemoteObject _lable1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 561;BA.debugLine="Sub addviewtosv_sub";
Debug.ShouldStop(65536);
 BA.debugLineNum = 562;BA.debugLine="canshare=True";
Debug.ShouldStop(131072);
page._canshare = page.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 565;BA.debugLine="For o = 0 To map.Size-1";
Debug.ShouldStop(1048576);
{
final int step2 = 1;
final int limit2 = RemoteObject.solve(new RemoteObject[] {page.mostCurrent._map.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_o = 0 ;
for (;(step2 > 0 && _o <= limit2) || (step2 < 0 && _o >= limit2) ;_o = ((int)(0 + _o + step2))  ) {
Debug.locals.put("o", _o);
 BA.debugLineNum = 567;BA.debugLine="Dim h13() As String=Regex.Split(\"#\",map.Get(o))";
Debug.ShouldStop(4194304);
_h13 = page.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString("#")),(Object)(BA.ObjectToString(page.mostCurrent._map.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _o))))));Debug.locals.put("h13", _h13);Debug.locals.put("h13", _h13);
 BA.debugLineNum = 568;BA.debugLine="Try";
Debug.ShouldStop(8388608);
try { BA.debugLineNum = 569;BA.debugLine="Dim Typee As String = h13(1)";
Debug.ShouldStop(16777216);
_typee = _h13.getArrayElement(true,BA.numberCast(int.class, 1));Debug.locals.put("Typee", _typee);Debug.locals.put("Typee", _typee);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e7) {
			BA.rdebugUtils.runVoidMethod("setLastException",page.processBA, e7.toString()); BA.debugLineNum = 571;BA.debugLine="Dim Typee As String =\"TEXT\"";
Debug.ShouldStop(67108864);
_typee = BA.ObjectToString("TEXT");Debug.locals.put("Typee", _typee);Debug.locals.put("Typee", _typee);
 };
 BA.debugLineNum = 574;BA.debugLine="Select Typee";
Debug.ShouldStop(536870912);
switch (BA.switchObjectToInt(_typee,BA.ObjectToString("IMG"),BA.ObjectToString("CAPTION"),BA.ObjectToString("TEXT"),BA.ObjectToString("SUB_TITLE"),BA.ObjectToString("TABLE"))) {
case 0: {
 BA.debugLineNum = 576;BA.debugLine="Dim url As String =  h13(0)";
Debug.ShouldStop(-2147483648);
_url = _h13.getArrayElement(true,BA.numberCast(int.class, 0));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 577;BA.debugLine="If h13(0)=\"http://www.beytoote.com\" Or h13(0)=";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_h13.getArrayElement(true,BA.numberCast(int.class, 0)),BA.ObjectToString("http://www.beytoote.com")) || RemoteObject.solveBoolean("=",_h13.getArrayElement(true,BA.numberCast(int.class, 0)),BA.ObjectToString("")) || RemoteObject.solveBoolean("n",_h13.getArrayElement(true,BA.numberCast(int.class, 0))) || RemoteObject.solveBoolean("=",_h13.getArrayElement(true,BA.numberCast(int.class, 0)),BA.ObjectToString("Null"))) { 
 }else {
 BA.debugLineNum = 580;BA.debugLine="If firstpicshow=False Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",page._firstpicshow,page.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 581;BA.debugLine="firstpicshow=True";
Debug.ShouldStop(16);
page._firstpicshow = page.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 583;BA.debugLine="Dim img1 As ImageView";
Debug.ShouldStop(64);
_img1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("img1", _img1);
 BA.debugLineNum = 584;BA.debugLine="img1.Initialize(\"img\")";
Debug.ShouldStop(128);
_img1.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("img")));
 BA.debugLineNum = 585;BA.debugLine="img1.Color=Colors.LightGray";
Debug.ShouldStop(256);
_img1.runVoidMethod ("setColor",page.mostCurrent.__c.getField(false,"Colors").getField(true,"LightGray"));
 BA.debugLineNum = 586;BA.debugLine="ScrollView1.Panel.AddView(img1,0,toptemp,100";
Debug.ShouldStop(512);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_img1.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 589;BA.debugLine="imglisnks.Put(img1,url)";
Debug.ShouldStop(4096);
page.mostCurrent._imglisnks.runVoidMethod ("Put",(Object)((_img1.getObject())),(Object)((_url)));
 BA.debugLineNum = 591;BA.debugLine="Dim imgdori As ImageView";
Debug.ShouldStop(16384);
_imgdori = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("imgdori", _imgdori);
 BA.debugLineNum = 592;BA.debugLine="imgdori.Initialize(\"\")";
Debug.ShouldStop(32768);
_imgdori.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 593;BA.debugLine="imgdori.Gravity=Gravity.FILL";
Debug.ShouldStop(65536);
_imgdori.runMethod(true,"setGravity",page.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 596;BA.debugLine="ScrollView1.Panel.AddView(imgdori,0,toptemp,";
Debug.ShouldStop(524288);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_imgdori.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 597;BA.debugLine="toptemp=toptemp+60%x";
Debug.ShouldStop(1048576);
page._toptemp = RemoteObject.solve(new RemoteObject[] {page._toptemp,page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),page.mostCurrent.activityBA)}, "+",1, 1);
 };
 };
 break; }
case 1: {
 BA.debugLineNum = 602;BA.debugLine="If h13(0).Length>2 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean(">",_h13.getArrayElement(true,BA.numberCast(int.class, 0)).runMethod(true,"length"),BA.numberCast(double.class, 2))) { 
 BA.debugLineNum = 603;BA.debugLine="Dim txt As String =  h13(0)";
Debug.ShouldStop(67108864);
_txt = _h13.getArrayElement(true,BA.numberCast(int.class, 0));Debug.locals.put("txt", _txt);Debug.locals.put("txt", _txt);
 BA.debugLineNum = 605;BA.debugLine="Dim lable As Label";
Debug.ShouldStop(268435456);
_lable = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lable", _lable);
 BA.debugLineNum = 606;BA.debugLine="lable.Initialize(\"\")";
Debug.ShouldStop(536870912);
_lable.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 607;BA.debugLine="lable.Text=Convert_FA2EN(txt)";
Debug.ShouldStop(1073741824);
_lable.runMethod(true,"setText",BA.ObjectToCharSequence(_convert_fa2en(_txt)));
 BA.debugLineNum = 608;BA.debugLine="alltext=alltext&CRLF&Convert_FA2EN(txt)";
Debug.ShouldStop(-2147483648);
page.mostCurrent._alltext = RemoteObject.concat(page.mostCurrent._alltext,page.mostCurrent.__c.getField(true,"CRLF"),_convert_fa2en(_txt));
 BA.debugLineNum = 609;BA.debugLine="lable.Typeface=C.irs";
Debug.ShouldStop(1);
_lable.runMethod(false,"setTypeface",(page.mostCurrent._c._irs /*RemoteObject*/ .getObject()));
 BA.debugLineNum = 610;BA.debugLine="lable.Color=Colors.RGB(234,209,212)";
Debug.ShouldStop(2);
_lable.runVoidMethod ("setColor",page.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 234)),(Object)(BA.numberCast(int.class, 209)),(Object)(BA.numberCast(int.class, 212))));
 BA.debugLineNum = 611;BA.debugLine="lable.TextColor=Colors.ARGB(255,22,13,108)";
Debug.ShouldStop(4);
_lable.runMethod(true,"setTextColor",page.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 22)),(Object)(BA.numberCast(int.class, 13)),(Object)(BA.numberCast(int.class, 108))));
 BA.debugLineNum = 612;BA.debugLine="lable.Padding=Array As Int (10dip,5dip,10dip,";
Debug.ShouldStop(8);
_lable.runMethod(false,"setPadding",RemoteObject.createNewArray("int",new int[] {4},new Object[] {page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5))),page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}));
 BA.debugLineNum = 613;BA.debugLine="lable.TextSize=15";
Debug.ShouldStop(16);
_lable.runMethod(true,"setTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 614;BA.debugLine="lable.Gravity= Gravity.CENTER',Gravity.RIGHT)";
Debug.ShouldStop(32);
_lable.runMethod(true,"setGravity",page.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 616;BA.debugLine="ScrollView1.Panel.AddView(lable,0,toptemp,100";
Debug.ShouldStop(128);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_lable.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 617;BA.debugLine="lable.Height=hlbl.LabelHeight(Convert_FA2EN(t";
Debug.ShouldStop(256);
_lable.runMethod(true,"setHeight",BA.numberCast(int.class, page.mostCurrent._hlbl.runMethod(true,"_labelheight",(Object)(_convert_fa2en(_txt)),(Object)(_lable),(Object)(page.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 15)),(Object)(page.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")),(Object)(BA.numberCast(float.class, 1.2)))));
 BA.debugLineNum = 618;BA.debugLine="lable.Height=lable.Height+5dip";
Debug.ShouldStop(512);
_lable.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {_lable.runMethod(true,"getHeight"),page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "+",1, 1));
 BA.debugLineNum = 619;BA.debugLine="toptemp=toptemp+lable.Height+5%x";
Debug.ShouldStop(1024);
page._toptemp = RemoteObject.solve(new RemoteObject[] {page._toptemp,_lable.runMethod(true,"getHeight"),page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),page.mostCurrent.activityBA)}, "++",2, 1);
 };
 break; }
case 2: {
 BA.debugLineNum = 624;BA.debugLine="If h13(0).Length>2 Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean(">",_h13.getArrayElement(true,BA.numberCast(int.class, 0)).runMethod(true,"length"),BA.numberCast(double.class, 2))) { 
 BA.debugLineNum = 625;BA.debugLine="Dim txt As String =  h13(0)";
Debug.ShouldStop(65536);
_txt = _h13.getArrayElement(true,BA.numberCast(int.class, 0));Debug.locals.put("txt", _txt);Debug.locals.put("txt", _txt);
 BA.debugLineNum = 627;BA.debugLine="Dim lable As Label";
Debug.ShouldStop(262144);
_lable = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lable", _lable);
 BA.debugLineNum = 628;BA.debugLine="lable.Initialize(\"\")";
Debug.ShouldStop(524288);
_lable.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 629;BA.debugLine="lable.Text=Convert_FA2EN(txt)";
Debug.ShouldStop(1048576);
_lable.runMethod(true,"setText",BA.ObjectToCharSequence(_convert_fa2en(_txt)));
 BA.debugLineNum = 630;BA.debugLine="alltext=alltext&CRLF&Convert_FA2EN(txt)";
Debug.ShouldStop(2097152);
page.mostCurrent._alltext = RemoteObject.concat(page.mostCurrent._alltext,page.mostCurrent.__c.getField(true,"CRLF"),_convert_fa2en(_txt));
 BA.debugLineNum = 631;BA.debugLine="lable.Typeface=C.irs";
Debug.ShouldStop(4194304);
_lable.runMethod(false,"setTypeface",(page.mostCurrent._c._irs /*RemoteObject*/ .getObject()));
 BA.debugLineNum = 633;BA.debugLine="lable.TextColor=Colors.Black";
Debug.ShouldStop(16777216);
_lable.runMethod(true,"setTextColor",page.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 634;BA.debugLine="lable.Padding=Array As Int (1dip,5dip,10dip,0";
Debug.ShouldStop(33554432);
_lable.runMethod(false,"setPadding",RemoteObject.createNewArray("int",new int[] {4},new Object[] {page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))),page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5))),page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),BA.numberCast(int.class, 0)}));
 BA.debugLineNum = 635;BA.debugLine="lable.TextSize=14";
Debug.ShouldStop(67108864);
_lable.runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 636;BA.debugLine="lable.Gravity= Gravity.RIGHT";
Debug.ShouldStop(134217728);
_lable.runMethod(true,"setGravity",page.mostCurrent.__c.getField(false,"Gravity").getField(true,"RIGHT"));
 BA.debugLineNum = 637;BA.debugLine="ScrollView1.Panel.AddView(lable,2%x,toptemp,9";
Debug.ShouldStop(268435456);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_lable.getObject())),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 2)),page.mostCurrent.activityBA)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 96)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 638;BA.debugLine="lable.Height=hlbl.LabelHeight(Convert_FA2EN(t";
Debug.ShouldStop(536870912);
_lable.runMethod(true,"setHeight",BA.numberCast(int.class, page.mostCurrent._hlbl.runMethod(true,"_labelheight",(Object)(_convert_fa2en(_txt)),(Object)(_lable),(Object)(page.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 14)),(Object)(page.mostCurrent.__c.getField(false,"Gravity").getField(true,"RIGHT")),(Object)(BA.numberCast(float.class, 1.2)))));
 BA.debugLineNum = 639;BA.debugLine="toptemp=toptemp+lable.Height+5%x";
Debug.ShouldStop(1073741824);
page._toptemp = RemoteObject.solve(new RemoteObject[] {page._toptemp,_lable.runMethod(true,"getHeight"),page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),page.mostCurrent.activityBA)}, "++",2, 1);
 };
 break; }
case 3: {
 BA.debugLineNum = 643;BA.debugLine="If h13(0).Length>2 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean(">",_h13.getArrayElement(true,BA.numberCast(int.class, 0)).runMethod(true,"length"),BA.numberCast(double.class, 2))) { 
 BA.debugLineNum = 644;BA.debugLine="Dim txt As String =  h13(0)";
Debug.ShouldStop(8);
_txt = _h13.getArrayElement(true,BA.numberCast(int.class, 0));Debug.locals.put("txt", _txt);Debug.locals.put("txt", _txt);
 BA.debugLineNum = 646;BA.debugLine="titletemp=True";
Debug.ShouldStop(32);
page._titletemp = page.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 647;BA.debugLine="Dim lable As Label";
Debug.ShouldStop(64);
_lable = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lable", _lable);
 BA.debugLineNum = 648;BA.debugLine="lable.Initialize(\"\")";
Debug.ShouldStop(128);
_lable.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 649;BA.debugLine="lable.Text=Convert_FA2EN(txt)";
Debug.ShouldStop(256);
_lable.runMethod(true,"setText",BA.ObjectToCharSequence(_convert_fa2en(_txt)));
 BA.debugLineNum = 650;BA.debugLine="alltext=alltext&CRLF&Convert_FA2EN(txt)";
Debug.ShouldStop(512);
page.mostCurrent._alltext = RemoteObject.concat(page.mostCurrent._alltext,page.mostCurrent.__c.getField(true,"CRLF"),_convert_fa2en(_txt));
 BA.debugLineNum = 651;BA.debugLine="lable.Typeface=C.irs";
Debug.ShouldStop(1024);
_lable.runMethod(false,"setTypeface",(page.mostCurrent._c._irs /*RemoteObject*/ .getObject()));
 BA.debugLineNum = 653;BA.debugLine="lable.TextColor=Colors.ARGB(255,146,6,47)";
Debug.ShouldStop(4096);
_lable.runMethod(true,"setTextColor",page.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 146)),(Object)(BA.numberCast(int.class, 6)),(Object)(BA.numberCast(int.class, 47))));
 BA.debugLineNum = 654;BA.debugLine="lable.Padding=Array As Int (1dip,5dip,10dip,0";
Debug.ShouldStop(8192);
_lable.runMethod(false,"setPadding",RemoteObject.createNewArray("int",new int[] {4},new Object[] {page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))),page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5))),page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),BA.numberCast(int.class, 0)}));
 BA.debugLineNum = 655;BA.debugLine="lable.TextSize=17";
Debug.ShouldStop(16384);
_lable.runMethod(true,"setTextSize",BA.numberCast(float.class, 17));
 BA.debugLineNum = 656;BA.debugLine="lable.Gravity= Gravity.RIGHT";
Debug.ShouldStop(32768);
_lable.runMethod(true,"setGravity",page.mostCurrent.__c.getField(false,"Gravity").getField(true,"RIGHT"));
 BA.debugLineNum = 657;BA.debugLine="ScrollView1.Panel.AddView(lable,2%x,toptemp,9";
Debug.ShouldStop(65536);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_lable.getObject())),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 2)),page.mostCurrent.activityBA)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 96)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 658;BA.debugLine="lable.Height=hlbl.LabelHeight(Convert_FA2EN(t";
Debug.ShouldStop(131072);
_lable.runMethod(true,"setHeight",BA.numberCast(int.class, page.mostCurrent._hlbl.runMethod(true,"_labelheight",(Object)(_convert_fa2en(_txt)),(Object)(_lable),(Object)(page.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 17)),(Object)(page.mostCurrent.__c.getField(false,"Gravity").getField(true,"RIGHT")),(Object)(BA.numberCast(float.class, 1.2)))));
 BA.debugLineNum = 659;BA.debugLine="toptemp=toptemp+lable.Height";
Debug.ShouldStop(262144);
page._toptemp = RemoteObject.solve(new RemoteObject[] {page._toptemp,_lable.runMethod(true,"getHeight")}, "+",1, 1);
 };
 break; }
case 4: {
 BA.debugLineNum = 662;BA.debugLine="If h13(0).Length>2 Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean(">",_h13.getArrayElement(true,BA.numberCast(int.class, 0)).runMethod(true,"length"),BA.numberCast(double.class, 2))) { 
 BA.debugLineNum = 664;BA.debugLine="titletemp=True";
Debug.ShouldStop(8388608);
page._titletemp = page.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 665;BA.debugLine="Try";
Debug.ShouldStop(16777216);
try { BA.debugLineNum = 667;BA.debugLine="Dim h14() As String=Regex.Split(\"@\",h13(0))";
Debug.ShouldStop(67108864);
_h14 = page.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString("@")),(Object)(_h13.getArrayElement(true,BA.numberCast(int.class, 0))));Debug.locals.put("h14", _h14);Debug.locals.put("h14", _h14);
 BA.debugLineNum = 669;BA.debugLine="Dim colo As Int";
Debug.ShouldStop(268435456);
_colo = RemoteObject.createImmutable(0);Debug.locals.put("colo", _colo);
 BA.debugLineNum = 670;BA.debugLine="If map.IndexOf(map.Get(o)) Mod 2 = 0 Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",RemoteObject.solve(new RemoteObject[] {page.mostCurrent._map.runMethod(true,"IndexOf",(Object)(page.mostCurrent._map.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _o))))),RemoteObject.createImmutable(2)}, "%",0, 1),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 671;BA.debugLine="colo=0xFFF7F7F7";
Debug.ShouldStop(1073741824);
_colo = BA.numberCast(int.class, 0xfff7f7f7);Debug.locals.put("colo", _colo);
 }else {
 BA.debugLineNum = 673;BA.debugLine="colo=0xFFEBEBEB";
Debug.ShouldStop(1);
_colo = BA.numberCast(int.class, 0xffebebeb);Debug.locals.put("colo", _colo);
 };
 BA.debugLineNum = 676;BA.debugLine="Dim lable1 As Label";
Debug.ShouldStop(8);
_lable1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lable1", _lable1);
 BA.debugLineNum = 677;BA.debugLine="lable1.Initialize(\"\")";
Debug.ShouldStop(16);
_lable1.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 678;BA.debugLine="lable1.Text=Convert_FA2EN(h14(0))";
Debug.ShouldStop(32);
_lable1.runMethod(true,"setText",BA.ObjectToCharSequence(_convert_fa2en(_h14.getArrayElement(true,BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 679;BA.debugLine="lable1.Typeface=C.irs";
Debug.ShouldStop(64);
_lable1.runMethod(false,"setTypeface",(page.mostCurrent._c._irs /*RemoteObject*/ .getObject()));
 BA.debugLineNum = 680;BA.debugLine="lable1.Color=colo";
Debug.ShouldStop(128);
_lable1.runVoidMethod ("setColor",_colo);
 BA.debugLineNum = 681;BA.debugLine="lable1.TextColor=Colors.ARGB(255,146,6,47)";
Debug.ShouldStop(256);
_lable1.runMethod(true,"setTextColor",page.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 146)),(Object)(BA.numberCast(int.class, 6)),(Object)(BA.numberCast(int.class, 47))));
 BA.debugLineNum = 682;BA.debugLine="lable1.Padding=Array As Int (1dip,5dip,10dip";
Debug.ShouldStop(512);
_lable1.runMethod(false,"setPadding",RemoteObject.createNewArray("int",new int[] {4},new Object[] {page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))),page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5))),page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),BA.numberCast(int.class, 0)}));
 BA.debugLineNum = 683;BA.debugLine="lable1.TextSize=17";
Debug.ShouldStop(1024);
_lable1.runMethod(true,"setTextSize",BA.numberCast(float.class, 17));
 BA.debugLineNum = 684;BA.debugLine="lable1.Gravity= Gravity.RIGHT";
Debug.ShouldStop(2048);
_lable1.runMethod(true,"setGravity",page.mostCurrent.__c.getField(false,"Gravity").getField(true,"RIGHT"));
 BA.debugLineNum = 685;BA.debugLine="ScrollView1.Panel.AddView(lable1,0,toptemp,4";
Debug.ShouldStop(4096);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_lable1.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 49.5)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 686;BA.debugLine="lable1.Height=hlbl.LabelHeight(Convert_FA2EN";
Debug.ShouldStop(8192);
_lable1.runMethod(true,"setHeight",BA.numberCast(int.class, page.mostCurrent._hlbl.runMethod(true,"_labelheight",(Object)(_convert_fa2en(_h14.getArrayElement(true,BA.numberCast(int.class, 1)))),(Object)(_lable1),(Object)(page.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 14)),(Object)(page.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(page.mostCurrent.__c.getField(false,"Gravity").getField(true,"RIGHT")),(Object)(page.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")))),(Object)(BA.numberCast(float.class, 1.2)))));
 BA.debugLineNum = 689;BA.debugLine="Dim lable As Label";
Debug.ShouldStop(65536);
_lable = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lable", _lable);
 BA.debugLineNum = 690;BA.debugLine="lable.Initialize(\"\")";
Debug.ShouldStop(131072);
_lable.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 691;BA.debugLine="lable.Text=Convert_FA2EN(h14(0))";
Debug.ShouldStop(262144);
_lable.runMethod(true,"setText",BA.ObjectToCharSequence(_convert_fa2en(_h14.getArrayElement(true,BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 692;BA.debugLine="lable.Typeface=C.irs";
Debug.ShouldStop(524288);
_lable.runMethod(false,"setTypeface",(page.mostCurrent._c._irs /*RemoteObject*/ .getObject()));
 BA.debugLineNum = 693;BA.debugLine="lable.Color=colo";
Debug.ShouldStop(1048576);
_lable.runVoidMethod ("setColor",_colo);
 BA.debugLineNum = 694;BA.debugLine="lable.TextColor=Colors.ARGB(255,146,6,47)";
Debug.ShouldStop(2097152);
_lable.runMethod(true,"setTextColor",page.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 146)),(Object)(BA.numberCast(int.class, 6)),(Object)(BA.numberCast(int.class, 47))));
 BA.debugLineNum = 695;BA.debugLine="lable.Padding=Array As Int (1dip,5dip,10dip,";
Debug.ShouldStop(4194304);
_lable.runMethod(false,"setPadding",RemoteObject.createNewArray("int",new int[] {4},new Object[] {page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))),page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5))),page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),BA.numberCast(int.class, 0)}));
 BA.debugLineNum = 696;BA.debugLine="lable.TextSize=17";
Debug.ShouldStop(8388608);
_lable.runMethod(true,"setTextSize",BA.numberCast(float.class, 17));
 BA.debugLineNum = 697;BA.debugLine="lable.Gravity= Gravity.RIGHT";
Debug.ShouldStop(16777216);
_lable.runMethod(true,"setGravity",page.mostCurrent.__c.getField(false,"Gravity").getField(true,"RIGHT"));
 BA.debugLineNum = 698;BA.debugLine="ScrollView1.Panel.AddView(lable,50%x,toptemp";
Debug.ShouldStop(33554432);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_lable.getObject())),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),page.mostCurrent.activityBA)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 699;BA.debugLine="lable.Height=hlbl.LabelHeight(Convert_FA2EN(";
Debug.ShouldStop(67108864);
_lable.runMethod(true,"setHeight",BA.numberCast(int.class, page.mostCurrent._hlbl.runMethod(true,"_labelheight",(Object)(_convert_fa2en(_h14.getArrayElement(true,BA.numberCast(int.class, 0)))),(Object)(_lable),(Object)(page.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 14)),(Object)(page.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(page.mostCurrent.__c.getField(false,"Gravity").getField(true,"RIGHT")),(Object)(page.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER")))),(Object)(BA.numberCast(float.class, 1.2)))));
 BA.debugLineNum = 700;BA.debugLine="lable1.Height=lable.Height";
Debug.ShouldStop(134217728);
_lable1.runMethod(true,"setHeight",_lable.runMethod(true,"getHeight"));
 BA.debugLineNum = 701;BA.debugLine="toptemp=toptemp+lable.Height+.5%x";
Debug.ShouldStop(268435456);
page._toptemp = RemoteObject.solve(new RemoteObject[] {page._toptemp,_lable.runMethod(true,"getHeight"),page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, .5)),page.mostCurrent.activityBA)}, "++",2, 1);
 BA.debugLineNum = 703;BA.debugLine="alltext=alltext&CRLF&h14(0)&\" : \"&h14(1)";
Debug.ShouldStop(1073741824);
page.mostCurrent._alltext = RemoteObject.concat(page.mostCurrent._alltext,page.mostCurrent.__c.getField(true,"CRLF"),_h14.getArrayElement(true,BA.numberCast(int.class, 0)),RemoteObject.createImmutable(" : "),_h14.getArrayElement(true,BA.numberCast(int.class, 1)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e117) {
			BA.rdebugUtils.runVoidMethod("setLastException",page.processBA, e117.toString()); };
 };
 break; }
}
;
 }
}Debug.locals.put("o", _o);
;
 BA.debugLineNum = 714;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _bring_up(RemoteObject _v) throws Exception{
try {
		Debug.PushSubsStack("bring_Up (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,189);
if (RapidSub.canDelegate("bring_up")) { return b4a.example.page.remoteMe.runUserSub(false, "page","bring_up", _v);}
RemoteObject _phone1 = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _elevation = RemoteObject.createImmutable(0f);
Debug.locals.put("v", _v);
 BA.debugLineNum = 189;BA.debugLine="Sub bring_Up(v As View)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 190;BA.debugLine="Dim phone1 As Phone";
Debug.ShouldStop(536870912);
_phone1 = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("phone1", _phone1);
 BA.debugLineNum = 191;BA.debugLine="If phone1.SdkVersion>20 Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean(">",_phone1.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 20))) { 
 BA.debugLineNum = 192;BA.debugLine="Dim jo As JavaObject = v";
Debug.ShouldStop(-2147483648);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo.setObject(_v.getObject());Debug.locals.put("jo", _jo);
 BA.debugLineNum = 193;BA.debugLine="Dim elevation As Float = 8dip";
Debug.ShouldStop(1);
_elevation = BA.numberCast(float.class, page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 8))));Debug.locals.put("elevation", _elevation);Debug.locals.put("elevation", _elevation);
 BA.debugLineNum = 194;BA.debugLine="jo.RunMethod(\"setElevation\",Array(elevation))";
Debug.ShouldStop(2);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setElevation")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_elevation)})));
 }else {
 BA.debugLineNum = 196;BA.debugLine="v.BringToFront";
Debug.ShouldStop(8);
_v.runVoidMethod ("BringToFront");
 };
 BA.debugLineNum = 198;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _convert_fa2en(RemoteObject _contente) throws Exception{
try {
		Debug.PushSubsStack("Convert_FA2EN (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,545);
if (RapidSub.canDelegate("convert_fa2en")) { return b4a.example.page.remoteMe.runUserSub(false, "page","convert_fa2en", _contente);}
RemoteObject _res = RemoteObject.createImmutable("");
Debug.locals.put("contente", _contente);
 BA.debugLineNum = 545;BA.debugLine="Sub Convert_FA2EN(contente As String) As String";
Debug.ShouldStop(1);
 BA.debugLineNum = 547;BA.debugLine="Dim Res As String = contente";
Debug.ShouldStop(4);
_res = _contente;Debug.locals.put("Res", _res);Debug.locals.put("Res", _res);
 BA.debugLineNum = 548;BA.debugLine="Res = Res.Replace(\"0\", \"۰\")";
Debug.ShouldStop(8);
_res = _res.runMethod(true,"replace",(Object)(BA.ObjectToString("0")),(Object)(RemoteObject.createImmutable("۰")));Debug.locals.put("Res", _res);
 BA.debugLineNum = 549;BA.debugLine="Res = Res.Replace(\"1\", \"۱\")";
Debug.ShouldStop(16);
_res = _res.runMethod(true,"replace",(Object)(BA.ObjectToString("1")),(Object)(RemoteObject.createImmutable("۱")));Debug.locals.put("Res", _res);
 BA.debugLineNum = 550;BA.debugLine="Res = Res.Replace(\"2\", \"۲\")";
Debug.ShouldStop(32);
_res = _res.runMethod(true,"replace",(Object)(BA.ObjectToString("2")),(Object)(RemoteObject.createImmutable("۲")));Debug.locals.put("Res", _res);
 BA.debugLineNum = 551;BA.debugLine="Res = Res.Replace(\"3\", \"۳\")";
Debug.ShouldStop(64);
_res = _res.runMethod(true,"replace",(Object)(BA.ObjectToString("3")),(Object)(RemoteObject.createImmutable("۳")));Debug.locals.put("Res", _res);
 BA.debugLineNum = 552;BA.debugLine="Res = Res.Replace(\"4\", \"۴\")";
Debug.ShouldStop(128);
_res = _res.runMethod(true,"replace",(Object)(BA.ObjectToString("4")),(Object)(RemoteObject.createImmutable("۴")));Debug.locals.put("Res", _res);
 BA.debugLineNum = 553;BA.debugLine="Res = Res.Replace(\"5\", \"۵\")";
Debug.ShouldStop(256);
_res = _res.runMethod(true,"replace",(Object)(BA.ObjectToString("5")),(Object)(RemoteObject.createImmutable("۵")));Debug.locals.put("Res", _res);
 BA.debugLineNum = 554;BA.debugLine="Res = Res.Replace(\"6\", \"۶\")";
Debug.ShouldStop(512);
_res = _res.runMethod(true,"replace",(Object)(BA.ObjectToString("6")),(Object)(RemoteObject.createImmutable("۶")));Debug.locals.put("Res", _res);
 BA.debugLineNum = 555;BA.debugLine="Res = Res.Replace(\"7\", \"۷\")";
Debug.ShouldStop(1024);
_res = _res.runMethod(true,"replace",(Object)(BA.ObjectToString("7")),(Object)(RemoteObject.createImmutable("۷")));Debug.locals.put("Res", _res);
 BA.debugLineNum = 556;BA.debugLine="Res = Res.Replace(\"8\", \"۸\")";
Debug.ShouldStop(2048);
_res = _res.runMethod(true,"replace",(Object)(BA.ObjectToString("8")),(Object)(RemoteObject.createImmutable("۸")));Debug.locals.put("Res", _res);
 BA.debugLineNum = 557;BA.debugLine="Res = Res.Replace(\"9\", \"۹\")";
Debug.ShouldStop(4096);
_res = _res.runMethod(true,"replace",(Object)(BA.ObjectToString("9")),(Object)(RemoteObject.createImmutable("۹")));Debug.locals.put("Res", _res);
 BA.debugLineNum = 558;BA.debugLine="Return Res";
Debug.ShouldStop(8192);
if (true) return _res;
 BA.debugLineNum = 560;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _converttickstotimestring_sub(RemoteObject _ta) throws Exception{
try {
		Debug.PushSubsStack("ConvertTicksToTimeString_sub (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,1037);
if (RapidSub.canDelegate("converttickstotimestring_sub")) { return b4a.example.page.remoteMe.runUserSub(false, "page","converttickstotimestring_sub", _ta);}
RemoteObject _hours = RemoteObject.createImmutable(0);
RemoteObject _minutes = RemoteObject.createImmutable(0);
RemoteObject _seconds = RemoteObject.createImmutable(0);
Debug.locals.put("ta", _ta);
 BA.debugLineNum = 1037;BA.debugLine="Sub ConvertTicksToTimeString_sub(ta As Long) As St";
Debug.ShouldStop(4096);
 BA.debugLineNum = 1038;BA.debugLine="Dim  hours, minutes, seconds As Int";
Debug.ShouldStop(8192);
_hours = RemoteObject.createImmutable(0);Debug.locals.put("hours", _hours);
_minutes = RemoteObject.createImmutable(0);Debug.locals.put("minutes", _minutes);
_seconds = RemoteObject.createImmutable(0);Debug.locals.put("seconds", _seconds);
 BA.debugLineNum = 1039;BA.debugLine="hours = ta / DateTime.TicksPerHour";
Debug.ShouldStop(16384);
_hours = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_ta,page.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerHour")}, "/",0, 0));Debug.locals.put("hours", _hours);
 BA.debugLineNum = 1040;BA.debugLine="minutes = (ta Mod DateTime.TicksPerHour) / DateTi";
Debug.ShouldStop(32768);
_minutes = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_ta,page.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerHour")}, "%",0, 2)),page.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerMinute")}, "/",0, 0));Debug.locals.put("minutes", _minutes);
 BA.debugLineNum = 1041;BA.debugLine="seconds = (ta Mod DateTime.TicksPerMinute) / Date";
Debug.ShouldStop(65536);
_seconds = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_ta,page.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerMinute")}, "%",0, 2)),page.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerSecond")}, "/",0, 0));Debug.locals.put("seconds", _seconds);
 BA.debugLineNum = 1042;BA.debugLine="Return NumberFormat(minutes, 2, 0) & \":\" & Number";
Debug.ShouldStop(131072);
if (true) return RemoteObject.concat(page.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _minutes)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(":"),page.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _seconds)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 1043;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _disable_scroolbarh(RemoteObject _sv1) throws Exception{
try {
		Debug.PushSubsStack("Disable_ScroolbarH (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,209);
if (RapidSub.canDelegate("disable_scroolbarh")) { return b4a.example.page.remoteMe.runUserSub(false, "page","disable_scroolbarh", _sv1);}
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
Debug.locals.put("sv1", _sv1);
 BA.debugLineNum = 209;BA.debugLine="Sub Disable_ScroolbarH(sv1 As ScrollView)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 210;BA.debugLine="Dim r As Reflector";
Debug.ShouldStop(131072);
_r = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("r", _r);
 BA.debugLineNum = 211;BA.debugLine="r.Target = sv1";
Debug.ShouldStop(262144);
_r.setField ("Target",(_sv1.getObject()));
 BA.debugLineNum = 212;BA.debugLine="r.RunMethod2(\"setVerticalScrollBarEnabled\", False";
Debug.ShouldStop(524288);
_r.runVoidMethod ("RunMethod2",(Object)(BA.ObjectToString("setVerticalScrollBarEnabled")),(Object)(BA.ObjectToString(page.mostCurrent.__c.getField(true,"False"))),(Object)(RemoteObject.createImmutable("java.lang.boolean")));
 BA.debugLineNum = 213;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _file_onfailure(RemoteObject _msg) throws Exception{
try {
		Debug.PushSubsStack("file_onFailure (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,779);
if (RapidSub.canDelegate("file_onfailure")) { return b4a.example.page.remoteMe.runUserSub(false, "page","file_onfailure", _msg);}
Debug.locals.put("msg", _msg);
 BA.debugLineNum = 779;BA.debugLine="Sub file_onFailure(msg As String)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 781;BA.debugLine="Pnlprb.Visible=False";
Debug.ShouldStop(4096);
page.mostCurrent._pnlprb.runMethod(true,"setVisible",page.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 782;BA.debugLine="Label1.Visible=True";
Debug.ShouldStop(8192);
page.mostCurrent._label1.runMethod(true,"setVisible",page.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 783;BA.debugLine="Label2.Visible=True";
Debug.ShouldStop(16384);
page.mostCurrent._label2.runMethod(true,"setVisible",page.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 784;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _flot2_click() throws Exception{
try {
		Debug.PushSubsStack("flot2_Click (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,955);
if (RapidSub.canDelegate("flot2_click")) { return b4a.example.page.remoteMe.runUserSub(false, "page","flot2_click");}
 BA.debugLineNum = 955;BA.debugLine="Sub flot2_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 958;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _flot3_click() throws Exception{
try {
		Debug.PushSubsStack("flot3_Click (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,960);
if (RapidSub.canDelegate("flot3_click")) { return b4a.example.page.remoteMe.runUserSub(false, "page","flot3_click");}
RemoteObject _aria = RemoteObject.declareNull("anywheresoftware.b4a.ariagplib.ARIAlib");
 BA.debugLineNum = 960;BA.debugLine="Sub flot3_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 961;BA.debugLine="Dim Aria As AriaLib";
Debug.ShouldStop(1);
_aria = RemoteObject.createNew ("anywheresoftware.b4a.ariagplib.ARIAlib");Debug.locals.put("Aria", _aria);
 BA.debugLineNum = 962;BA.debugLine="StartActivity( Aria.ShareText(Main.txtnewstitle&C";
Debug.ShouldStop(2);
page.mostCurrent.__c.runVoidMethod ("StartActivity",page.processBA,(Object)((_aria.runMethod(false,"ShareText",(Object)(RemoteObject.concat(page.mostCurrent._main._txtnewstitle /*RemoteObject*/ ,page.mostCurrent.__c.getField(true,"CRLF"),page.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Main.txtnews"),page.mostCurrent.__c.getField(true,"CRLF"),page.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("برگرفته از اپلیکیشن هواشناسی پیشرفته ؛"),page.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("https://cafebazaar.ir/app/"),page.mostCurrent.__c.getField(false,"Application").runMethod(true,"getPackageName"),RemoteObject.createImmutable("/?l=fa"))),(Object)(RemoteObject.createImmutable("اشتراک گذاری با ؛"))))));
 BA.debugLineNum = 963;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _force_ltrsupported4view(RemoteObject _view) throws Exception{
try {
		Debug.PushSubsStack("Force_LtrSupported4View (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,760);
if (RapidSub.canDelegate("force_ltrsupported4view")) { return b4a.example.page.remoteMe.runUserSub(false, "page","force_ltrsupported4view", _view);}
RemoteObject _ja = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _jos = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("View", _view);
 BA.debugLineNum = 760;BA.debugLine="Sub Force_LtrSupported4View(View As View)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 761;BA.debugLine="Dim jA,jos As JavaObject";
Debug.ShouldStop(16777216);
_ja = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jA", _ja);
_jos = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jos", _jos);
 BA.debugLineNum = 762;BA.debugLine="jos.InitializeStatic  (\"android.view.View\")";
Debug.ShouldStop(33554432);
_jos.runVoidMethod ("InitializeStatic",(Object)(RemoteObject.createImmutable("android.view.View")));
 BA.debugLineNum = 763;BA.debugLine="If jA.InitializeStatic  (\"android.os.Build$VERSIO";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean(">",BA.numberCast(double.class, _ja.runMethod(false,"InitializeStatic",(Object)(RemoteObject.createImmutable("android.os.Build$VERSION"))).runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("SDK_INT")))),BA.numberCast(double.class, 16))) { 
 BA.debugLineNum = 764;BA.debugLine="jA = View";
Debug.ShouldStop(134217728);
_ja.setObject(_view.getObject());
 BA.debugLineNum = 765;BA.debugLine="jA.RunMethod (\"setLayoutDirection\",Array(jos.Get";
Debug.ShouldStop(268435456);
_ja.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setLayoutDirection")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {_jos.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("LAYOUT_DIRECTION_LTR")))})));
 };
 BA.debugLineNum = 767;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _force_rtlsupported4view(RemoteObject _view) throws Exception{
try {
		Debug.PushSubsStack("Force_RtlSupported4View (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,536);
if (RapidSub.canDelegate("force_rtlsupported4view")) { return b4a.example.page.remoteMe.runUserSub(false, "page","force_rtlsupported4view", _view);}
RemoteObject _ja = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _jos = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("View", _view);
 BA.debugLineNum = 536;BA.debugLine="Sub Force_RtlSupported4View(View As View)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 537;BA.debugLine="Dim jA,jos As JavaObject";
Debug.ShouldStop(16777216);
_ja = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jA", _ja);
_jos = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jos", _jos);
 BA.debugLineNum = 538;BA.debugLine="jos.InitializeStatic  (\"android.view.View\")";
Debug.ShouldStop(33554432);
_jos.runVoidMethod ("InitializeStatic",(Object)(RemoteObject.createImmutable("android.view.View")));
 BA.debugLineNum = 539;BA.debugLine="If jA.InitializeStatic  (\"android.os.Build$VERSIO";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean(">",BA.numberCast(double.class, _ja.runMethod(false,"InitializeStatic",(Object)(RemoteObject.createImmutable("android.os.Build$VERSION"))).runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("SDK_INT")))),BA.numberCast(double.class, 16))) { 
 BA.debugLineNum = 540;BA.debugLine="jA = View";
Debug.ShouldStop(134217728);
_ja.setObject(_view.getObject());
 BA.debugLineNum = 541;BA.debugLine="jA.RunMethod (\"setLayoutDirection\",Array(jos.Get";
Debug.ShouldStop(268435456);
_ja.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setLayoutDirection")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {_jos.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("LAYOUT_DIRECTION_RTL")))})));
 };
 BA.debugLineNum = 543;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _from_cacht(RemoteObject _a,RemoteObject _size) throws Exception{
try {
		Debug.PushSubsStack("from_cacht (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,786);
if (RapidSub.canDelegate("from_cacht")) { return b4a.example.page.remoteMe.runUserSub(false, "page","from_cacht", _a, _size);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _thumbnail = RemoteObject.createImmutable("");
RemoteObject _images = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colimages = RemoteObject.createImmutable("");
RemoteObject _title = RemoteObject.createImmutable("");
RemoteObject _contentd = RemoteObject.createImmutable("");
RemoteObject _cd = RemoteObject.createImmutable("");
RemoteObject _h14 = null;
int _i = 0;
RemoteObject _h13 = null;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _img1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _img12 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _ac = RemoteObject.declareNull("de.amberhome.objects.appcompat.AppCompatBase");
RemoteObject _lblplaya = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lbldownd = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _txt = RemoteObject.createImmutable("");
RemoteObject _lable = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("a", _a);
Debug.locals.put("size", _size);
 BA.debugLineNum = 786;BA.debugLine="Sub from_cacht(a As String , size As Int)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 787;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(262144);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 788;BA.debugLine="parser.Initialize(a)";
Debug.ShouldStop(524288);
_parser.runVoidMethod ("Initialize",(Object)(_a));
 BA.debugLineNum = 789;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(1048576);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 790;BA.debugLine="Dim thumbnail As String = root.Get(\"thumbnail\")";
Debug.ShouldStop(2097152);
_thumbnail = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("thumbnail")))));Debug.locals.put("thumbnail", _thumbnail);Debug.locals.put("thumbnail", _thumbnail);
 BA.debugLineNum = 791;BA.debugLine="Dim images As List = root.Get(\"images\")";
Debug.ShouldStop(4194304);
_images = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_images.setObject(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("images")))));Debug.locals.put("images", _images);
 BA.debugLineNum = 792;BA.debugLine="For Each colimages As String In images";
Debug.ShouldStop(8388608);
{
final RemoteObject group6 = _images;
final int groupLen6 = group6.runMethod(true,"getSize").<Integer>get()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_colimages = BA.ObjectToString(group6.runMethod(false,"Get",index6));Debug.locals.put("colimages", _colimages);
Debug.locals.put("colimages", _colimages);
 }
}Debug.locals.put("colimages", _colimages);
;
 BA.debugLineNum = 795;BA.debugLine="Dim title As String = root.Get(\"title\")";
Debug.ShouldStop(67108864);
_title = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("title")))));Debug.locals.put("title", _title);Debug.locals.put("title", _title);
 BA.debugLineNum = 796;BA.debugLine="Dim contentd As String = root.Get(\"content\")";
Debug.ShouldStop(134217728);
_contentd = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("content")))));Debug.locals.put("contentd", _contentd);Debug.locals.put("contentd", _contentd);
 BA.debugLineNum = 798;BA.debugLine="Dim cd As String";
Debug.ShouldStop(536870912);
_cd = RemoteObject.createImmutable("");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 800;BA.debugLine="Dim h14() As String=Regex.Split(CRLF,contentd)";
Debug.ShouldStop(-2147483648);
_h14 = page.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(page.mostCurrent.__c.getField(true,"CRLF")),(Object)(_contentd));Debug.locals.put("h14", _h14);Debug.locals.put("h14", _h14);
 BA.debugLineNum = 801;BA.debugLine="For i = 0 To h14.Length-1";
Debug.ShouldStop(1);
{
final int step12 = 1;
final int limit12 = RemoteObject.solve(new RemoteObject[] {_h14.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step12 > 0 && _i <= limit12) || (step12 < 0 && _i >= limit12) ;_i = ((int)(0 + _i + step12))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 803;BA.debugLine="If h14(i).Length>1 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean(">",_h14.getArrayElement(true,BA.numberCast(int.class, _i)).runMethod(true,"length"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 804;BA.debugLine="cd=cd&CRLF&h14(i)";
Debug.ShouldStop(8);
_cd = RemoteObject.concat(_cd,page.mostCurrent.__c.getField(true,"CRLF"),_h14.getArrayElement(true,BA.numberCast(int.class, _i)));Debug.locals.put("cd", _cd);
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 808;BA.debugLine="DoEvents";
Debug.ShouldStop(128);
page.mostCurrent.__c.runVoidMethodAndSync ("DoEvents");
 BA.debugLineNum = 810;BA.debugLine="addtitle_sub(title,\"\")";
Debug.ShouldStop(512);
_addtitle_sub(_title,RemoteObject.createImmutable(""));
 BA.debugLineNum = 811;BA.debugLine="Dim h13() As String=Regex.Split(\"<span>\",c)";
Debug.ShouldStop(1024);
_h13 = page.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString("<span>")),(Object)(BA.ObjectToString(page.mostCurrent._c)));Debug.locals.put("h13", _h13);Debug.locals.put("h13", _h13);
 BA.debugLineNum = 812;BA.debugLine="For i = 0 To h13.Length-1";
Debug.ShouldStop(2048);
{
final int step20 = 1;
final int limit20 = RemoteObject.solve(new RemoteObject[] {_h13.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step20 > 0 && _i <= limit20) || (step20 < 0 && _i >= limit20) ;_i = ((int)(0 + _i + step20))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 823;BA.debugLine="If h13(i).Contains(\".mp3\") Or h13(i).Contains(\".";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean(".",_h13.getArrayElement(true,BA.numberCast(int.class, _i)).runMethod(true,"contains",(Object)(RemoteObject.createImmutable(".mp3")))) || RemoteObject.solveBoolean(".",_h13.getArrayElement(true,BA.numberCast(int.class, _i)).runMethod(true,"contains",(Object)(RemoteObject.createImmutable(".mp4")))) || RemoteObject.solveBoolean(".",_h13.getArrayElement(true,BA.numberCast(int.class, _i)).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("img")))) || RemoteObject.solveBoolean(".",_h13.getArrayElement(true,BA.numberCast(int.class, _i)).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("caption"))))) { 
 BA.debugLineNum = 824;BA.debugLine="If h13(i).Contains(\"img\") Then";
Debug.ShouldStop(8388608);
if (_h13.getArrayElement(true,BA.numberCast(int.class, _i)).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("img"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 825;BA.debugLine="Dim url As String =  GetImage_Path(h13(i))";
Debug.ShouldStop(16777216);
_url = _getimage_path(_h13.getArrayElement(true,BA.numberCast(int.class, _i)));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 826;BA.debugLine="If h13(i)<>\"\"  Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("!",_h13.getArrayElement(true,BA.numberCast(int.class, _i)),BA.ObjectToString(""))) { 
 BA.debugLineNum = 827;BA.debugLine="Dim img1 As ImageView";
Debug.ShouldStop(67108864);
_img1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("img1", _img1);
 BA.debugLineNum = 828;BA.debugLine="img1.Initialize(\"\")";
Debug.ShouldStop(134217728);
_img1.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 829;BA.debugLine="img1.Color=Colors.Transparent";
Debug.ShouldStop(268435456);
_img1.runVoidMethod ("setColor",page.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 830;BA.debugLine="ScrollView1.Panel.AddView(img1,0,toptemp,100%";
Debug.ShouldStop(536870912);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_img1.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 832;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(-2147483648);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 833;BA.debugLine="pnl.Initialize(\"\")";
Debug.ShouldStop(1);
_pnl.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 834;BA.debugLine="pnl.Color=0xC8FFFFFF";
Debug.ShouldStop(2);
_pnl.runVoidMethod ("setColor",BA.numberCast(int.class, 0xc8ffffff));
 BA.debugLineNum = 835;BA.debugLine="ScrollView1.Panel.AddView(pnl,0,toptemp,100%x";
Debug.ShouldStop(4);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_pnl.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 837;BA.debugLine="Dim img12 As ImageView";
Debug.ShouldStop(16);
_img12 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("img12", _img12);
 BA.debugLineNum = 838;BA.debugLine="img12.Initialize(\"img\")";
Debug.ShouldStop(32);
_img12.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("img")));
 BA.debugLineNum = 839;BA.debugLine="img12.Color=Colors.Transparent";
Debug.ShouldStop(64);
_img12.runVoidMethod ("setColor",page.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 840;BA.debugLine="ScrollView1.Panel.AddView(img12,0,toptemp,100";
Debug.ShouldStop(128);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_img12.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 847;BA.debugLine="imglisnks.Put(img12,url)";
Debug.ShouldStop(16384);
page.mostCurrent._imglisnks.runVoidMethod ("Put",(Object)((_img12.getObject())),(Object)((_url)));
 BA.debugLineNum = 848;BA.debugLine="toptemp=toptemp+62%x";
Debug.ShouldStop(32768);
page._toptemp = RemoteObject.solve(new RemoteObject[] {page._toptemp,page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 62)),page.mostCurrent.activityBA)}, "+",1, 1);
 };
 };
 BA.debugLineNum = 851;BA.debugLine="If h13(i).Contains(\".mp4\") Then";
Debug.ShouldStop(262144);
if (_h13.getArrayElement(true,BA.numberCast(int.class, _i)).runMethod(true,"contains",(Object)(RemoteObject.createImmutable(".mp4"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 857;BA.debugLine="videolink=Getmp4_Path(h13(i))";
Debug.ShouldStop(16777216);
page._videolink = _getmp4_path(_h13.getArrayElement(true,BA.numberCast(int.class, _i)));
 };
 BA.debugLineNum = 863;BA.debugLine="If h13(i).Contains(\".mp3\") Then";
Debug.ShouldStop(1073741824);
if (_h13.getArrayElement(true,BA.numberCast(int.class, _i)).runMethod(true,"contains",(Object)(RemoteObject.createImmutable(".mp3"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 864;BA.debugLine="soundurl =  Getmp3_Path(h13(i))";
Debug.ShouldStop(-2147483648);
page.mostCurrent._soundurl = _getmp3_path(_h13.getArrayElement(true,BA.numberCast(int.class, _i)));
 BA.debugLineNum = 866;BA.debugLine="If h13(i)<>\"\"  Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("!",_h13.getArrayElement(true,BA.numberCast(int.class, _i)),BA.ObjectToString(""))) { 
 BA.debugLineNum = 868;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(8);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 869;BA.debugLine="pnl.Initialize(\"\")";
Debug.ShouldStop(16);
_pnl.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 870;BA.debugLine="pnl.Color=Colors.LightGray";
Debug.ShouldStop(32);
_pnl.runVoidMethod ("setColor",page.mostCurrent.__c.getField(false,"Colors").getField(true,"LightGray"));
 BA.debugLineNum = 871;BA.debugLine="ScrollView1.Panel.AddView(pnl,0,toptemp,100%x";
Debug.ShouldStop(64);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_pnl.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 873;BA.debugLine="Dim ac As AppCompat";
Debug.ShouldStop(256);
_ac = RemoteObject.createNew ("de.amberhome.objects.appcompat.AppCompatBase");Debug.locals.put("ac", _ac);
 BA.debugLineNum = 875;BA.debugLine="Dim lblplaya As Label";
Debug.ShouldStop(1024);
_lblplaya = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblplaya", _lblplaya);
 BA.debugLineNum = 876;BA.debugLine="lblplaya.Initialize(\"\")";
Debug.ShouldStop(2048);
_lblplaya.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 877;BA.debugLine="lblplaya.Color=0xFFBCBCBC";
Debug.ShouldStop(4096);
_lblplaya.runVoidMethod ("setColor",BA.numberCast(int.class, 0xffbcbcbc));
 BA.debugLineNum = 878;BA.debugLine="ScrollView1.Panel.AddView(lblplaya,85%x,topte";
Debug.ShouldStop(8192);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_lblplaya.getObject())),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 85)),page.mostCurrent.activityBA)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 880;BA.debugLine="Dim lbldownd As Label";
Debug.ShouldStop(32768);
_lbldownd = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbldownd", _lbldownd);
 BA.debugLineNum = 881;BA.debugLine="lbldownd.Initialize(\"\")";
Debug.ShouldStop(65536);
_lbldownd.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 882;BA.debugLine="lbldownd.Color=0xFFBCBCBC";
Debug.ShouldStop(131072);
_lbldownd.runVoidMethod ("setColor",BA.numberCast(int.class, 0xffbcbcbc));
 BA.debugLineNum = 883;BA.debugLine="ScrollView1.Panel.AddView(lbldownd,0,toptemp,";
Debug.ShouldStop(262144);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_lbldownd.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 886;BA.debugLine="lblplay.Initialize(\"lblplay\")";
Debug.ShouldStop(2097152);
page.mostCurrent._lblplay.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lblplay")));
 BA.debugLineNum = 887;BA.debugLine="lblplay.Text=Chr(0xE037)";
Debug.ShouldStop(4194304);
page.mostCurrent._lblplay.runMethod(true,"setText",BA.ObjectToCharSequence(page.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xe037)))));
 BA.debugLineNum = 888;BA.debugLine="lblplay.Typeface=Typeface.MATERIALICONS";
Debug.ShouldStop(8388608);
page.mostCurrent._lblplay.runMethod(false,"setTypeface",page.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getMATERIALICONS"));
 BA.debugLineNum = 889;BA.debugLine="lblplay.Gravity=Gravity.CENTER";
Debug.ShouldStop(16777216);
page.mostCurrent._lblplay.runMethod(true,"setGravity",page.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 890;BA.debugLine="lblplay.TextColor=Colors.DarkGray";
Debug.ShouldStop(33554432);
page.mostCurrent._lblplay.runMethod(true,"setTextColor",page.mostCurrent.__c.getField(false,"Colors").getField(true,"DarkGray"));
 BA.debugLineNum = 891;BA.debugLine="lblplay.TextSize=20";
Debug.ShouldStop(67108864);
page.mostCurrent._lblplay.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 892;BA.debugLine="ScrollView1.Panel.AddView(lblplay,0,toptemp,1";
Debug.ShouldStop(134217728);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((page.mostCurrent._lblplay.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 893;BA.debugLine="ac.SetClickEffect(lblplay,False)";
Debug.ShouldStop(268435456);
_ac.runVoidMethod ("SetClickEffect",page.mostCurrent.activityBA,(Object)((page.mostCurrent._lblplay.getObject())),(Object)(page.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 895;BA.debugLine="lbldown.Initialize(\"lbldown\")";
Debug.ShouldStop(1073741824);
page.mostCurrent._lbldown.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lbldown")));
 BA.debugLineNum = 896;BA.debugLine="lbldown.Text=Chr(0xE2C4)";
Debug.ShouldStop(-2147483648);
page.mostCurrent._lbldown.runMethod(true,"setText",BA.ObjectToCharSequence(page.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xe2c4)))));
 BA.debugLineNum = 897;BA.debugLine="lbldown.Typeface=Typeface.MATERIALICONS";
Debug.ShouldStop(1);
page.mostCurrent._lbldown.runMethod(false,"setTypeface",page.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getMATERIALICONS"));
 BA.debugLineNum = 898;BA.debugLine="lbldown.Gravity=Gravity.CENTER";
Debug.ShouldStop(2);
page.mostCurrent._lbldown.runMethod(true,"setGravity",page.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 899;BA.debugLine="lbldown.TextColor=Colors.DarkGray";
Debug.ShouldStop(4);
page.mostCurrent._lbldown.runMethod(true,"setTextColor",page.mostCurrent.__c.getField(false,"Colors").getField(true,"DarkGray"));
 BA.debugLineNum = 900;BA.debugLine="lbldown.TextSize=20";
Debug.ShouldStop(8);
page.mostCurrent._lbldown.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 901;BA.debugLine="ac.SetClickEffect(lbldown,False)";
Debug.ShouldStop(16);
_ac.runVoidMethod ("SetClickEffect",page.mostCurrent.activityBA,(Object)((page.mostCurrent._lbldown.getObject())),(Object)(page.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 902;BA.debugLine="ScrollView1.Panel.AddView(lbldown,85%x,toptem";
Debug.ShouldStop(32);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((page.mostCurrent._lbldown.getObject())),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 85)),page.mostCurrent.activityBA)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 904;BA.debugLine="lbldur.Initialize(\"\")";
Debug.ShouldStop(128);
page.mostCurrent._lbldur.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 905;BA.debugLine="lbldur.Text=\"00:00\"";
Debug.ShouldStop(256);
page.mostCurrent._lbldur.runMethod(true,"setText",BA.ObjectToCharSequence("00:00"));
 BA.debugLineNum = 906;BA.debugLine="lbldur.Typeface=C.irs";
Debug.ShouldStop(512);
page.mostCurrent._lbldur.runMethod(false,"setTypeface",(page.mostCurrent._c._irs /*RemoteObject*/ .getObject()));
 BA.debugLineNum = 907;BA.debugLine="lbldur.Gravity=Bit.Or(Gravity.LEFT,Gravity.BO";
Debug.ShouldStop(1024);
page.mostCurrent._lbldur.runMethod(true,"setGravity",page.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(page.mostCurrent.__c.getField(false,"Gravity").getField(true,"LEFT")),(Object)(page.mostCurrent.__c.getField(false,"Gravity").getField(true,"BOTTOM"))));
 BA.debugLineNum = 908;BA.debugLine="lbldur.TextColor=Colors.DarkGray";
Debug.ShouldStop(2048);
page.mostCurrent._lbldur.runMethod(true,"setTextColor",page.mostCurrent.__c.getField(false,"Colors").getField(true,"DarkGray"));
 BA.debugLineNum = 909;BA.debugLine="lbldur.TextSize=10";
Debug.ShouldStop(4096);
page.mostCurrent._lbldur.runMethod(true,"setTextSize",BA.numberCast(float.class, 10));
 BA.debugLineNum = 910;BA.debugLine="ScrollView1.Panel.AddView(lbldur,17.5%x,topte";
Debug.ShouldStop(8192);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((page.mostCurrent._lbldur.getObject())),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 17.5)),page.mostCurrent.activityBA)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 30)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 912;BA.debugLine="lblpos.Initialize(\"\")";
Debug.ShouldStop(32768);
page.mostCurrent._lblpos.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 913;BA.debugLine="lblpos.Text=\"00:00\"";
Debug.ShouldStop(65536);
page.mostCurrent._lblpos.runMethod(true,"setText",BA.ObjectToCharSequence("00:00"));
 BA.debugLineNum = 914;BA.debugLine="lblpos.Typeface=C.irs";
Debug.ShouldStop(131072);
page.mostCurrent._lblpos.runMethod(false,"setTypeface",(page.mostCurrent._c._irs /*RemoteObject*/ .getObject()));
 BA.debugLineNum = 915;BA.debugLine="lblpos.Gravity=Bit.Or(Gravity.RIGHT,Gravity.B";
Debug.ShouldStop(262144);
page.mostCurrent._lblpos.runMethod(true,"setGravity",page.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(page.mostCurrent.__c.getField(false,"Gravity").getField(true,"RIGHT")),(Object)(page.mostCurrent.__c.getField(false,"Gravity").getField(true,"BOTTOM"))));
 BA.debugLineNum = 916;BA.debugLine="lblpos.TextColor=Colors.DarkGray";
Debug.ShouldStop(524288);
page.mostCurrent._lblpos.runMethod(true,"setTextColor",page.mostCurrent.__c.getField(false,"Colors").getField(true,"DarkGray"));
 BA.debugLineNum = 917;BA.debugLine="lblpos.TextSize=10";
Debug.ShouldStop(1048576);
page.mostCurrent._lblpos.runMethod(true,"setTextSize",BA.numberCast(float.class, 10));
 BA.debugLineNum = 918;BA.debugLine="ScrollView1.Panel.AddView(lblpos,52.5%x,topte";
Debug.ShouldStop(2097152);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((page.mostCurrent._lblpos.getObject())),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 52.5)),page.mostCurrent.activityBA)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 30)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 920;BA.debugLine="seekbar.Initialize(\"seekbar\")";
Debug.ShouldStop(8388608);
page.mostCurrent._seekbar.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("seekbar")));
 BA.debugLineNum = 921;BA.debugLine="ScrollView1.Panel.AddView(seekbar,15%x,toptem";
Debug.ShouldStop(16777216);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((page.mostCurrent._seekbar.getObject())),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),page.mostCurrent.activityBA)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 70)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 922;BA.debugLine="Force_LtrSupported4View(seekbar)";
Debug.ShouldStop(33554432);
_force_ltrsupported4view(RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), page.mostCurrent._seekbar.getObject()));
 BA.debugLineNum = 924;BA.debugLine="toptemp=toptemp+18%x";
Debug.ShouldStop(134217728);
page._toptemp = RemoteObject.solve(new RemoteObject[] {page._toptemp,page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 18)),page.mostCurrent.activityBA)}, "+",1, 1);
 };
 };
 }else {
 BA.debugLineNum = 929;BA.debugLine="If h13(i).Length>2 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean(">",_h13.getArrayElement(true,BA.numberCast(int.class, _i)).runMethod(true,"length"),BA.numberCast(double.class, 2))) { 
 BA.debugLineNum = 931;BA.debugLine="Dim txt As String =  h13(i)";
Debug.ShouldStop(4);
_txt = _h13.getArrayElement(true,BA.numberCast(int.class, _i));Debug.locals.put("txt", _txt);Debug.locals.put("txt", _txt);
 BA.debugLineNum = 932;BA.debugLine="Dim lable As Label";
Debug.ShouldStop(8);
_lable = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lable", _lable);
 BA.debugLineNum = 933;BA.debugLine="lable.Initialize(\"\")";
Debug.ShouldStop(16);
_lable.runVoidMethod ("Initialize",page.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 934;BA.debugLine="lable.Text=Convert_FA2EN(txt)";
Debug.ShouldStop(32);
_lable.runMethod(true,"setText",BA.ObjectToCharSequence(_convert_fa2en(_txt)));
 BA.debugLineNum = 935;BA.debugLine="alltext=alltext&CRLF&Convert_FA2EN(txt)";
Debug.ShouldStop(64);
page.mostCurrent._alltext = RemoteObject.concat(page.mostCurrent._alltext,page.mostCurrent.__c.getField(true,"CRLF"),_convert_fa2en(_txt));
 BA.debugLineNum = 936;BA.debugLine="lable.Typeface=C.irs";
Debug.ShouldStop(128);
_lable.runMethod(false,"setTypeface",(page.mostCurrent._c._irs /*RemoteObject*/ .getObject()));
 BA.debugLineNum = 937;BA.debugLine="lable.TextColor= Colors.Transparent";
Debug.ShouldStop(256);
_lable.runMethod(true,"setTextColor",page.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 938;BA.debugLine="lable.Padding=Array As Int (25dip,0,25dip,0)";
Debug.ShouldStop(512);
_lable.runMethod(false,"setPadding",RemoteObject.createNewArray("int",new int[] {4},new Object[] {page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25))),BA.numberCast(int.class, 0),page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25))),BA.numberCast(int.class, 0)}));
 BA.debugLineNum = 939;BA.debugLine="lable.TextSize=size";
Debug.ShouldStop(1024);
_lable.runMethod(true,"setTextSize",BA.numberCast(float.class, _size));
 BA.debugLineNum = 940;BA.debugLine="lable.Gravity= Gravity.RIGHT";
Debug.ShouldStop(2048);
_lable.runMethod(true,"setGravity",page.mostCurrent.__c.getField(false,"Gravity").getField(true,"RIGHT"));
 BA.debugLineNum = 941;BA.debugLine="ScrollView1.Panel.AddView(lable,2%x,toptemp,96";
Debug.ShouldStop(4096);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_lable.getObject())),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 2)),page.mostCurrent.activityBA)),(Object)(page._toptemp),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 96)),page.mostCurrent.activityBA)),(Object)(page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),page.mostCurrent.activityBA)));
 BA.debugLineNum = 942;BA.debugLine="lable.Height=hlbl.LabelHeight(Convert_FA2EN(la";
Debug.ShouldStop(8192);
_lable.runMethod(true,"setHeight",BA.numberCast(int.class, page.mostCurrent._hlbl.runMethod(true,"_labelheight",(Object)(_convert_fa2en(_lable.runMethod(true,"getText"))),(Object)(_lable),(Object)(page.mostCurrent._c._irs /*RemoteObject*/ ),(Object)(_size),(Object)(page.mostCurrent.__c.getField(false,"Gravity").getField(true,"RIGHT")),(Object)(BA.numberCast(float.class, 1.2)))));
 BA.debugLineNum = 943;BA.debugLine="toptemp=toptemp+lable.Height";
Debug.ShouldStop(16384);
page._toptemp = RemoteObject.solve(new RemoteObject[] {page._toptemp,_lable.runMethod(true,"getHeight")}, "+",1, 1);
 BA.debugLineNum = 944;BA.debugLine="CallSubDelayed2( Me, \"Justify_Text\", lable )";
Debug.ShouldStop(32768);
page.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",page.processBA,(Object)(page.getObject()),(Object)(BA.ObjectToString("Justify_Text")),(Object)((_lable)));
 };
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 949;BA.debugLine="toolbar";
Debug.ShouldStop(1048576);
_toolbar();
 BA.debugLineNum = 951;BA.debugLine="Pnlprb.Visible=False";
Debug.ShouldStop(4194304);
page.mostCurrent._pnlprb.runMethod(true,"setVisible",page.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 952;BA.debugLine="canshare=True";
Debug.ShouldStop(8388608);
page._canshare = page.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 953;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getimage_path(RemoteObject _val) throws Exception{
try {
		Debug.PushSubsStack("GetImage_Path (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,978);
if (RapidSub.canDelegate("getimage_path")) { return b4a.example.page.remoteMe.runUserSub(false, "page","getimage_path", _val);}
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Regex.MatcherWrapper");
RemoteObject _find = RemoteObject.createImmutable(false);
RemoteObject _res = RemoteObject.createImmutable("");
Debug.locals.put("val", _val);
 BA.debugLineNum = 978;BA.debugLine="Public Sub GetImage_Path(val As String) As String";
Debug.ShouldStop(131072);
 BA.debugLineNum = 980;BA.debugLine="Dim l As Matcher";
Debug.ShouldStop(524288);
_l = RemoteObject.createNew ("anywheresoftware.b4a.keywords.Regex.MatcherWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 981;BA.debugLine="l = Regex.Matcher(\"src\\s*=\\s*(.+?)\"\"\",val)";
Debug.ShouldStop(1048576);
_l = page.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Matcher",(Object)(BA.ObjectToString("src\\s*=\\s*(.+?)\"")),(Object)(_val));Debug.locals.put("l", _l);
 BA.debugLineNum = 983;BA.debugLine="Try";
Debug.ShouldStop(4194304);
try { BA.debugLineNum = 984;BA.debugLine="Dim find As Boolean";
Debug.ShouldStop(8388608);
_find = RemoteObject.createImmutable(false);Debug.locals.put("find", _find);
 BA.debugLineNum = 985;BA.debugLine="find = l.find";
Debug.ShouldStop(16777216);
_find = _l.runMethod(true,"Find");Debug.locals.put("find", _find);
 BA.debugLineNum = 986;BA.debugLine="If find = False Then Return \"\"";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",_find,page.mostCurrent.__c.getField(true,"False"))) { 
Debug.CheckDeviceExceptions();if (true) return BA.ObjectToString("");};
 BA.debugLineNum = 987;BA.debugLine="Dim res As String";
Debug.ShouldStop(67108864);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 989;BA.debugLine="res = l.Group(1)";
Debug.ShouldStop(268435456);
_res = _l.runMethod(true,"Group",(Object)(BA.numberCast(int.class, 1)));Debug.locals.put("res", _res);
 BA.debugLineNum = 990;BA.debugLine="res = res.SubString(1)";
Debug.ShouldStop(536870912);
_res = _res.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 1)));Debug.locals.put("res", _res);
 BA.debugLineNum = 991;BA.debugLine="Return res";
Debug.ShouldStop(1073741824);
Debug.CheckDeviceExceptions();if (true) return _res;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",page.processBA, e12.toString()); BA.debugLineNum = 993;BA.debugLine="Return \"\"";
Debug.ShouldStop(1);
if (true) return BA.ObjectToString("");
 };
 BA.debugLineNum = 996;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getmp3_path(RemoteObject _val) throws Exception{
try {
		Debug.PushSubsStack("Getmp3_Path (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,997);
if (RapidSub.canDelegate("getmp3_path")) { return b4a.example.page.remoteMe.runUserSub(false, "page","getmp3_path", _val);}
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Regex.MatcherWrapper");
RemoteObject _find = RemoteObject.createImmutable(false);
RemoteObject _res = RemoteObject.createImmutable("");
Debug.locals.put("val", _val);
 BA.debugLineNum = 997;BA.debugLine="Public Sub Getmp3_Path(val As String) As String";
Debug.ShouldStop(16);
 BA.debugLineNum = 999;BA.debugLine="Dim l As Matcher";
Debug.ShouldStop(64);
_l = RemoteObject.createNew ("anywheresoftware.b4a.keywords.Regex.MatcherWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 1000;BA.debugLine="l = Regex.Matcher(\"mp3\\s*=\\s*(.+?)\"\"\",val)";
Debug.ShouldStop(128);
_l = page.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Matcher",(Object)(BA.ObjectToString("mp3\\s*=\\s*(.+?)\"")),(Object)(_val));Debug.locals.put("l", _l);
 BA.debugLineNum = 1002;BA.debugLine="Try";
Debug.ShouldStop(512);
try { BA.debugLineNum = 1003;BA.debugLine="Dim find As Boolean";
Debug.ShouldStop(1024);
_find = RemoteObject.createImmutable(false);Debug.locals.put("find", _find);
 BA.debugLineNum = 1004;BA.debugLine="find = l.find";
Debug.ShouldStop(2048);
_find = _l.runMethod(true,"Find");Debug.locals.put("find", _find);
 BA.debugLineNum = 1005;BA.debugLine="If find = False Then Return \"\"";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",_find,page.mostCurrent.__c.getField(true,"False"))) { 
Debug.CheckDeviceExceptions();if (true) return BA.ObjectToString("");};
 BA.debugLineNum = 1006;BA.debugLine="Dim res As String";
Debug.ShouldStop(8192);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 1008;BA.debugLine="res = l.Group(1)";
Debug.ShouldStop(32768);
_res = _l.runMethod(true,"Group",(Object)(BA.numberCast(int.class, 1)));Debug.locals.put("res", _res);
 BA.debugLineNum = 1009;BA.debugLine="res = res.SubString(1)";
Debug.ShouldStop(65536);
_res = _res.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 1)));Debug.locals.put("res", _res);
 BA.debugLineNum = 1010;BA.debugLine="Return res";
Debug.ShouldStop(131072);
Debug.CheckDeviceExceptions();if (true) return _res;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",page.processBA, e12.toString()); BA.debugLineNum = 1012;BA.debugLine="Return \"\"";
Debug.ShouldStop(524288);
if (true) return BA.ObjectToString("");
 };
 BA.debugLineNum = 1015;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getmp4_path(RemoteObject _val) throws Exception{
try {
		Debug.PushSubsStack("Getmp4_Path (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,1016);
if (RapidSub.canDelegate("getmp4_path")) { return b4a.example.page.remoteMe.runUserSub(false, "page","getmp4_path", _val);}
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Regex.MatcherWrapper");
RemoteObject _find = RemoteObject.createImmutable(false);
RemoteObject _res = RemoteObject.createImmutable("");
Debug.locals.put("val", _val);
 BA.debugLineNum = 1016;BA.debugLine="Public Sub Getmp4_Path(val As String) As String";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 1018;BA.debugLine="Dim l As Matcher";
Debug.ShouldStop(33554432);
_l = RemoteObject.createNew ("anywheresoftware.b4a.keywords.Regex.MatcherWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 1019;BA.debugLine="l = Regex.Matcher(\"mp4\\s*=\\s*(.+?)\"\"\",val)";
Debug.ShouldStop(67108864);
_l = page.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Matcher",(Object)(BA.ObjectToString("mp4\\s*=\\s*(.+?)\"")),(Object)(_val));Debug.locals.put("l", _l);
 BA.debugLineNum = 1021;BA.debugLine="Try";
Debug.ShouldStop(268435456);
try { BA.debugLineNum = 1022;BA.debugLine="Dim find As Boolean";
Debug.ShouldStop(536870912);
_find = RemoteObject.createImmutable(false);Debug.locals.put("find", _find);
 BA.debugLineNum = 1023;BA.debugLine="find = l.find";
Debug.ShouldStop(1073741824);
_find = _l.runMethod(true,"Find");Debug.locals.put("find", _find);
 BA.debugLineNum = 1024;BA.debugLine="If find = False Then Return \"\"";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_find,page.mostCurrent.__c.getField(true,"False"))) { 
Debug.CheckDeviceExceptions();if (true) return BA.ObjectToString("");};
 BA.debugLineNum = 1025;BA.debugLine="Dim res As String";
Debug.ShouldStop(1);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 1027;BA.debugLine="res = l.Group(1)";
Debug.ShouldStop(4);
_res = _l.runMethod(true,"Group",(Object)(BA.numberCast(int.class, 1)));Debug.locals.put("res", _res);
 BA.debugLineNum = 1028;BA.debugLine="res = res.SubString(1)";
Debug.ShouldStop(8);
_res = _res.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 1)));Debug.locals.put("res", _res);
 BA.debugLineNum = 1029;BA.debugLine="Return res";
Debug.ShouldStop(16);
Debug.CheckDeviceExceptions();if (true) return _res;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",page.processBA, e12.toString()); BA.debugLineNum = 1031;BA.debugLine="Return \"\"";
Debug.ShouldStop(64);
if (true) return BA.ObjectToString("");
 };
 BA.debugLineNum = 1034;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 20;BA.debugLine="Dim soundurl As String";
page.mostCurrent._soundurl = RemoteObject.createImmutable("");
 //BA.debugLineNum = 21;BA.debugLine="Private ScrollView1 As ScrollView";
page.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Dim nazarat_lbl As Label";
page.mostCurrent._nazarat_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private Paneldark As Panel";
page.mostCurrent._paneldark = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private ACToolBarLight1 As ACToolBarLight";
page.mostCurrent._actoolbarlight1 = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACToolbarLightWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private Img As ImageView";
page.mostCurrent._img = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private toolbartemp As Panel";
page.mostCurrent._toolbartemp = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private Glide As Hitex_Glide";
page.mostCurrent._glide = RemoteObject.createNew ("com.hitex_glide.Hitex_Glide");
 //BA.debugLineNum = 28;BA.debugLine="Dim lbltoolbar As Label";
page.mostCurrent._lbltoolbar = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private pnlmatlab As Panel";
page.mostCurrent._pnlmatlab = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Dim toptemp As Int = 80%x";
page._toptemp = page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 80)),page.mostCurrent.activityBA);
 //BA.debugLineNum = 31;BA.debugLine="Dim titelhaghttemp As Int = 0";
page._titelhaghttemp = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 34;BA.debugLine="Dim titletemp As Boolean = False";
page._titletemp = page.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 37;BA.debugLine="Dim name As String =\"\"' Main.matlablink313";
page.mostCurrent._name = BA.ObjectToString("");
 //BA.debugLineNum = 38;BA.debugLine="Dim map As List";
page.mostCurrent._map = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 39;BA.debugLine="Dim firstimg As String";
page.mostCurrent._firstimg = RemoteObject.createImmutable("");
 //BA.debugLineNum = 41;BA.debugLine="Private Pnlprb As Panel";
page.mostCurrent._pnlprb = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private ProgressBar1 As ProgressBar";
page.mostCurrent._progressbar1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ProgressBarWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Dim fsize As Int";
page._fsize = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 44;BA.debugLine="Dim foldername As String =\"\"' Main.link313";
page.mostCurrent._foldername = BA.ObjectToString("");
 //BA.debugLineNum = 45;BA.debugLine="Dim canshare As Boolean = False";
page._canshare = page.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 46;BA.debugLine="Dim firstpicshow As Boolean = False";
page._firstpicshow = page.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 47;BA.debugLine="Dim imglisnks As Map";
page.mostCurrent._imglisnks = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 48;BA.debugLine="Dim comment As String";
page.mostCurrent._comment = RemoteObject.createImmutable("");
 //BA.debugLineNum = 50;BA.debugLine="Dim downtost As Boolean=False";
page._downtost = page.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 51;BA.debugLine="Private Label1 As Label";
page.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private Label2 As Label";
page.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Dim flot As Panel";
page.mostCurrent._flot = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Dim flot2 As Label";
page.mostCurrent._flot2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Dim flot3 As Panel";
page.mostCurrent._flot3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Dim flot4 As Label";
page.mostCurrent._flot4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Dim mpo As MediaPlayer";
page.mostCurrent._mpo = RemoteObject.createNew ("anywheresoftware.b4a.objects.MediaPlayerWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Dim lbldown As Label";
page.mostCurrent._lbldown = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Dim lblplay As Label";
page.mostCurrent._lblplay = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Dim lbldur As Label";
page.mostCurrent._lbldur = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Dim lblpos As Label";
page.mostCurrent._lblpos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 62;BA.debugLine="Dim seekbar As ACSeekBar";
page.mostCurrent._seekbar = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACSeekBarWrapper");
 //BA.debugLineNum = 63;BA.debugLine="Dim ispus As Boolean = False";
page._ispus = page.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 65;BA.debugLine="Dim downmap As Map";
page.mostCurrent._downmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 66;BA.debugLine="Dim favmap As Map";
page.mostCurrent._favmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 68;BA.debugLine="Dim alltext As String";
page.mostCurrent._alltext = RemoteObject.createImmutable("");
 //BA.debugLineNum = 69;BA.debugLine="Dim hlbl As HeightLabel";
page.mostCurrent._hlbl = RemoteObject.createNew ("b4a.example.heightlabel");
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _img_click() throws Exception{
try {
		Debug.PushSubsStack("img_Click (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,769);
if (RapidSub.canDelegate("img_click")) { return b4a.example.page.remoteMe.runUserSub(false, "page","img_click");}
RemoteObject _s = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
 BA.debugLineNum = 769;BA.debugLine="Sub img_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 770;BA.debugLine="If canshare Then";
Debug.ShouldStop(2);
if (page._canshare.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 771;BA.debugLine="Dim s As ImageView = Sender";
Debug.ShouldStop(4);
_s = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
_s.setObject(page.mostCurrent.__c.runMethod(false,"Sender",page.mostCurrent.activityBA));Debug.locals.put("s", _s);
 BA.debugLineNum = 772;BA.debugLine="postimg=imglisnks.Get(s)";
Debug.ShouldStop(8);
page._postimg = BA.ObjectToString(page.mostCurrent._imglisnks.runMethod(false,"Get",(Object)((_s.getObject()))));
 }else {
 BA.debugLineNum = 775;BA.debugLine="ToastMessageShow(\"باز کردن عکس قبل از بارگزاری ص";
Debug.ShouldStop(64);
page.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("باز کردن عکس قبل از بارگزاری صفحه امکان پذیر نمیباشد.")),(Object)(page.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 778;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _jsontomap(RemoteObject _strjson) throws Exception{
try {
		Debug.PushSubsStack("JsonToMap (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,328);
if (RapidSub.canDelegate("jsontomap")) { return b4a.example.page.remoteMe.runUserSub(false, "page","jsontomap", _strjson);}
RemoteObject _jmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _json = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
Debug.locals.put("strJSON", _strjson);
 BA.debugLineNum = 328;BA.debugLine="Sub JsonToMap(strJSON As String) As Map";
Debug.ShouldStop(128);
 BA.debugLineNum = 331;BA.debugLine="Dim jMap As Map";
Debug.ShouldStop(1024);
_jmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("jMap", _jmap);
 BA.debugLineNum = 332;BA.debugLine="jMap.Initialize";
Debug.ShouldStop(2048);
_jmap.runVoidMethod ("Initialize");
 BA.debugLineNum = 333;BA.debugLine="Dim JSON As JSONParser";
Debug.ShouldStop(4096);
_json = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("JSON", _json);
 BA.debugLineNum = 334;BA.debugLine="JSON.Initialize(strJSON)";
Debug.ShouldStop(8192);
_json.runVoidMethod ("Initialize",(Object)(_strjson));
 BA.debugLineNum = 335;BA.debugLine="jMap = JSON.NextObject";
Debug.ShouldStop(16384);
_jmap = _json.runMethod(false,"NextObject");Debug.locals.put("jMap", _jmap);
 BA.debugLineNum = 336;BA.debugLine="Return jMap";
Debug.ShouldStop(32768);
if (true) return _jmap;
 BA.debugLineNum = 337;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _justify_text(RemoteObject _lable) throws Exception{
try {
		Debug.PushSubsStack("Justify_Text (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,381);
if (RapidSub.canDelegate("justify_text")) { return b4a.example.page.remoteMe.runUserSub(false, "page","justify_text", _lable);}
RemoteObject _jjustify = RemoteObject.declareNull("ir.TeamEight.Justify.teameightjustify");
Debug.locals.put("lable", _lable);
 BA.debugLineNum = 381;BA.debugLine="Sub Justify_Text(lable As Label)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 383;BA.debugLine="Private JJustify As TeamEightJustify";
Debug.ShouldStop(1073741824);
_jjustify = RemoteObject.createNew ("ir.TeamEight.Justify.teameightjustify");Debug.locals.put("JJustify", _jjustify);
 BA.debugLineNum = 385;BA.debugLine="JJustify.Initialize";
Debug.ShouldStop(1);
_jjustify.runVoidMethod ("_initialize",page.processBA);
 BA.debugLineNum = 386;BA.debugLine="lable.text = JJustify.JustifyByExtendWords(lable,";
Debug.ShouldStop(2);
_lable.runMethod(true,"setText",BA.ObjectToCharSequence(_jjustify.runMethod(true,"_vv3",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _lable.getObject()),(Object)(_lable.runMethod(true,"getText")),(Object)(page.mostCurrent.__c.getField(true,"False")),(Object)(BA.numberCast(float.class, .5)),(Object)(page.mostCurrent.__c.getField(true,"False")))));
 BA.debugLineNum = 387;BA.debugLine="DoEvents";
Debug.ShouldStop(4);
page.mostCurrent.__c.runVoidMethodAndSync ("DoEvents");
 BA.debugLineNum = 390;BA.debugLine="If lable.TextColor = Colors.Transparent Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_lable.runMethod(true,"getTextColor"),BA.numberCast(double.class, page.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent")))) { 
 BA.debugLineNum = 391;BA.debugLine="lable.SetTextColorAnimated(250, Colors.Black)";
Debug.ShouldStop(64);
_lable.runVoidMethod ("SetTextColorAnimated",(Object)(BA.numberCast(int.class, 250)),(Object)(page.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")));
 };
 BA.debugLineNum = 395;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _label2_click() throws Exception{
try {
		Debug.PushSubsStack("Label2_Click (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,202);
if (RapidSub.canDelegate("label2_click")) { return b4a.example.page.remoteMe.runUserSub(false, "page","label2_click");}
 BA.debugLineNum = 202;BA.debugLine="Sub Label2_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 203;BA.debugLine="Pnlprb.Visible=True";
Debug.ShouldStop(1024);
page.mostCurrent._pnlprb.runMethod(true,"setVisible",page.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 205;BA.debugLine="Label2.Visible=False";
Debug.ShouldStop(4096);
page.mostCurrent._label2.runMethod(true,"setVisible",page.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 206;BA.debugLine="Label1.Visible=False";
Debug.ShouldStop(8192);
page.mostCurrent._label1.runMethod(true,"setVisible",page.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 208;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _menu_change(RemoteObject _onvan,RemoteObject _color,RemoteObject _font) throws Exception{
try {
		Debug.PushSubsStack("menu_Change (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,489);
if (RapidSub.canDelegate("menu_change")) { return b4a.example.page.remoteMe.runUserSub(false, "page","menu_change", _onvan, _color, _font);}
RemoteObject _cs = RemoteObject.declareNull("anywheresoftware.b4a.objects.CSBuilder");
Debug.locals.put("onvan", _onvan);
Debug.locals.put("color", _color);
Debug.locals.put("font", _font);
 BA.debugLineNum = 489;BA.debugLine="Sub menu_Change(onvan As String,color As Int,font";
Debug.ShouldStop(256);
 BA.debugLineNum = 490;BA.debugLine="Dim cs As CSBuilder";
Debug.ShouldStop(512);
_cs = RemoteObject.createNew ("anywheresoftware.b4a.objects.CSBuilder");Debug.locals.put("cs", _cs);
 BA.debugLineNum = 491;BA.debugLine="cs.Initialize.Color(color).Typeface(font).Append(";
Debug.ShouldStop(1024);
_cs.runMethod(false,"Initialize").runMethod(false,"Color",(Object)(_color)).runMethod(false,"Typeface",(Object)((_font.getObject()))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(_onvan))).runVoidMethod ("PopAll");
 BA.debugLineNum = 492;BA.debugLine="Return cs";
Debug.ShouldStop(2048);
if (true) return _cs;
 BA.debugLineNum = 493;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _menu_change2(RemoteObject _onvan,RemoteObject _color,RemoteObject _font) throws Exception{
try {
		Debug.PushSubsStack("menu_Change2 (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,483);
if (RapidSub.canDelegate("menu_change2")) { return b4a.example.page.remoteMe.runUserSub(false, "page","menu_change2", _onvan, _color, _font);}
RemoteObject _cs = RemoteObject.declareNull("anywheresoftware.b4a.objects.CSBuilder");
Debug.locals.put("onvan", _onvan);
Debug.locals.put("color", _color);
Debug.locals.put("font", _font);
 BA.debugLineNum = 483;BA.debugLine="Sub menu_Change2(onvan As String,color As Int,font";
Debug.ShouldStop(4);
 BA.debugLineNum = 484;BA.debugLine="Dim cs As CSBuilder";
Debug.ShouldStop(8);
_cs = RemoteObject.createNew ("anywheresoftware.b4a.objects.CSBuilder");Debug.locals.put("cs", _cs);
 BA.debugLineNum = 485;BA.debugLine="cs.Initialize.Color(color).Typeface(font).Alignme";
Debug.ShouldStop(16);
_cs.runMethod(false,"Initialize").runMethod(false,"Color",(Object)(_color)).runMethod(false,"Typeface",(Object)((_font.getObject()))).runMethod(false,"Alignment",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.text.Layout.Alignment"),RemoteObject.createImmutable("ALIGN_CENTER")))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(_onvan))).runVoidMethod ("PopAll");
 BA.debugLineNum = 486;BA.debugLine="Return cs";
Debug.ShouldStop(32);
if (true) return _cs;
 BA.debugLineNum = 487;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pagerlist_onerror(RemoteObject _error) throws Exception{
try {
		Debug.PushSubsStack("pagerlist_OnError (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,322);
if (RapidSub.canDelegate("pagerlist_onerror")) { return b4a.example.page.remoteMe.runUserSub(false, "page","pagerlist_onerror", _error);}
Debug.locals.put("Error", _error);
 BA.debugLineNum = 322;BA.debugLine="Sub pagerlist_OnError (Error As String)";
Debug.ShouldStop(2);
 BA.debugLineNum = 324;BA.debugLine="Pnlprb.Visible=False";
Debug.ShouldStop(8);
page.mostCurrent._pnlprb.runMethod(true,"setVisible",page.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 325;BA.debugLine="Label1.Visible=True";
Debug.ShouldStop(16);
page.mostCurrent._label1.runMethod(true,"setVisible",page.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 326;BA.debugLine="Label2.Visible=True";
Debug.ShouldStop(32);
page.mostCurrent._label2.runMethod(true,"setVisible",page.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 327;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
 //BA.debugLineNum = 9;BA.debugLine="Dim picurl As String";
page._picurl = RemoteObject.createImmutable("");
 //BA.debugLineNum = 10;BA.debugLine="Dim videolink As String";
page._videolink = RemoteObject.createImmutable("");
 //BA.debugLineNum = 11;BA.debugLine="Dim isdowned As Boolean";
page._isdowned = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 12;BA.debugLine="Dim postimg As String";
page._postimg = RemoteObject.createImmutable("");
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _saato_ina(RemoteObject _h13) throws Exception{
try {
		Debug.PushSubsStack("saato_ina (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,283);
if (RapidSub.canDelegate("saato_ina")) { return b4a.example.page.remoteMe.runUserSub(false, "page","saato_ina", _h13);}
RemoteObject _lbl2 = RemoteObject.createImmutable("");
RemoteObject _date = RemoteObject.createImmutable("");
RemoteObject _month = RemoteObject.createImmutable(0);
RemoteObject _day = RemoteObject.createImmutable(0);
RemoteObject _year = RemoteObject.createImmutable(0);
RemoteObject _saat = RemoteObject.createImmutable(0);
RemoteObject _minu = RemoteObject.createImmutable("");
RemoteObject _minu2 = RemoteObject.createImmutable(0);
RemoteObject _manam = RemoteObject.declareNull("ir.anamsoftware.persiandateultimate.ManamPDUltimate");
RemoteObject _utils = RemoteObject.declareNull("wir.hitex.recycler.Hitex_Utils");
Debug.locals.put("h13", _h13);
 BA.debugLineNum = 283;BA.debugLine="Sub saato_ina(h13 As String) As String";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 284;BA.debugLine="Dim lbl2 As String";
Debug.ShouldStop(134217728);
_lbl2 = RemoteObject.createImmutable("");Debug.locals.put("lbl2", _lbl2);
 BA.debugLineNum = 285;BA.debugLine="Dim date As String = h13.SubString2(9,19)";
Debug.ShouldStop(268435456);
_date = _h13.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 9)),(Object)(BA.numberCast(int.class, 19)));Debug.locals.put("date", _date);Debug.locals.put("date", _date);
 BA.debugLineNum = 286;BA.debugLine="Dim month As Int = h13.SubString2(12,14)";
Debug.ShouldStop(536870912);
_month = BA.numberCast(int.class, _h13.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 14))));Debug.locals.put("month", _month);Debug.locals.put("month", _month);
 BA.debugLineNum = 287;BA.debugLine="Dim day As Int = h13.SubString2(9,11)";
Debug.ShouldStop(1073741824);
_day = BA.numberCast(int.class, _h13.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 9)),(Object)(BA.numberCast(int.class, 11))));Debug.locals.put("day", _day);Debug.locals.put("day", _day);
 BA.debugLineNum = 288;BA.debugLine="Dim year As Int = h13.SubString2(15,19)";
Debug.ShouldStop(-2147483648);
_year = BA.numberCast(int.class, _h13.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 15)),(Object)(BA.numberCast(int.class, 19))));Debug.locals.put("year", _year);Debug.locals.put("year", _year);
 BA.debugLineNum = 289;BA.debugLine="Dim saat As Int = h13.SubString2(0,2)";
Debug.ShouldStop(1);
_saat = BA.numberCast(int.class, _h13.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))));Debug.locals.put("saat", _saat);Debug.locals.put("saat", _saat);
 BA.debugLineNum = 290;BA.debugLine="Dim minu As String = h13.SubString2(3,5)";
Debug.ShouldStop(2);
_minu = _h13.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("minu", _minu);Debug.locals.put("minu", _minu);
 BA.debugLineNum = 291;BA.debugLine="Dim minu2 As Int = h13.SubString2(3,5)";
Debug.ShouldStop(4);
_minu2 = BA.numberCast(int.class, _h13.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, 5))));Debug.locals.put("minu2", _minu2);Debug.locals.put("minu2", _minu2);
 BA.debugLineNum = 292;BA.debugLine="Log(saat)";
Debug.ShouldStop(8);
page.mostCurrent.__c.runVoidMethod ("LogImpl","35373961",BA.NumberToString(_saat),0);
 BA.debugLineNum = 293;BA.debugLine="Log(minu)";
Debug.ShouldStop(16);
page.mostCurrent.__c.runVoidMethod ("LogImpl","35373962",_minu,0);
 BA.debugLineNum = 295;BA.debugLine="lbl2=date.Replace(\"-\",\"/\") & \" در \"& saat&\":\"&min";
Debug.ShouldStop(64);
_lbl2 = RemoteObject.concat(_date.runMethod(true,"replace",(Object)(BA.ObjectToString("-")),(Object)(RemoteObject.createImmutable("/"))),RemoteObject.createImmutable(" در "),_saat,RemoteObject.createImmutable(":"),_minu);Debug.locals.put("lbl2", _lbl2);
 BA.debugLineNum = 296;BA.debugLine="Dim manam As ManamPerianDateUltimate";
Debug.ShouldStop(128);
_manam = RemoteObject.createNew ("ir.anamsoftware.persiandateultimate.ManamPDUltimate");Debug.locals.put("manam", _manam);
 BA.debugLineNum = 297;BA.debugLine="If year=manam.PersianYear Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",_year,BA.numberCast(double.class, _manam.runMethod(true,"getPersianYear")))) { 
 BA.debugLineNum = 298;BA.debugLine="If month=manam.PersianMonth Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_month,BA.numberCast(double.class, _manam.runMethod(true,"getPersianMonth")))) { 
 BA.debugLineNum = 299;BA.debugLine="If day=(manam.PersianDay)-1 Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",_day,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {(_manam.runMethod(true,"getPersianDay")),RemoteObject.createImmutable(1)}, "-",1, 1)))) { 
 BA.debugLineNum = 300;BA.debugLine="lbl2=\"دیروز در \"& saat&\":\"&minu";
Debug.ShouldStop(2048);
_lbl2 = RemoteObject.concat(RemoteObject.createImmutable("دیروز در "),_saat,RemoteObject.createImmutable(":"),_minu);Debug.locals.put("lbl2", _lbl2);
 };
 BA.debugLineNum = 302;BA.debugLine="If day<(manam.PersianDay)-1 Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("<",_day,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {(_manam.runMethod(true,"getPersianDay")),RemoteObject.createImmutable(1)}, "-",1, 1)))) { 
 BA.debugLineNum = 303;BA.debugLine="lbl2=((manam.PersianDay)-day)&\" روز پیش در \"&";
Debug.ShouldStop(16384);
_lbl2 = RemoteObject.concat((RemoteObject.solve(new RemoteObject[] {(_manam.runMethod(true,"getPersianDay")),_day}, "-",1, 1)),RemoteObject.createImmutable(" روز پیش در "),_saat,RemoteObject.createImmutable(":"),_minu);Debug.locals.put("lbl2", _lbl2);
 };
 BA.debugLineNum = 305;BA.debugLine="If day=(manam.PersianDay) Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_day,BA.numberCast(double.class, (_manam.runMethod(true,"getPersianDay"))))) { 
 BA.debugLineNum = 306;BA.debugLine="If saat<(DateTime.GetHour(DateTime.Now)) Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("<",_saat,BA.numberCast(double.class, (page.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(page.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))))))) { 
 BA.debugLineNum = 307;BA.debugLine="lbl2=((DateTime.GetHour(DateTime.Now))-saat)";
Debug.ShouldStop(262144);
_lbl2 = RemoteObject.concat((RemoteObject.solve(new RemoteObject[] {(page.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(page.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))),_saat}, "-",1, 1)),RemoteObject.createImmutable(" ساعت پیش"));Debug.locals.put("lbl2", _lbl2);
 }else {
 BA.debugLineNum = 310;BA.debugLine="If minu2<(DateTime.GetMinute(DateTime.Now)) T";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("<",_minu2,BA.numberCast(double.class, (page.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(page.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))))))) { 
 BA.debugLineNum = 311;BA.debugLine="lbl2=((DateTime.GetMinute(DateTime.Now))-min";
Debug.ShouldStop(4194304);
_lbl2 = RemoteObject.concat((RemoteObject.solve(new RemoteObject[] {(page.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(page.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))),_minu2}, "-",1, 1)),RemoteObject.createImmutable(" دقیقه پیش"));Debug.locals.put("lbl2", _lbl2);
 }else {
 BA.debugLineNum = 313;BA.debugLine="lbl2=\"همین حالا\"";
Debug.ShouldStop(16777216);
_lbl2 = BA.ObjectToString("همین حالا");Debug.locals.put("lbl2", _lbl2);
 };
 };
 };
 };
 };
 BA.debugLineNum = 319;BA.debugLine="Dim utils As Hitex_Utils";
Debug.ShouldStop(1073741824);
_utils = RemoteObject.createNew ("wir.hitex.recycler.Hitex_Utils");Debug.locals.put("utils", _utils);
 BA.debugLineNum = 320;BA.debugLine="Return utils.EnToFa(lbl2)";
Debug.ShouldStop(-2147483648);
if (true) return _utils.runMethod(true,"EnToFa",(Object)(_lbl2));
 BA.debugLineNum = 321;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _scrollview1_scrollchanged(RemoteObject _position) throws Exception{
try {
		Debug.PushSubsStack("ScrollView1_ScrollChanged (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,411);
if (RapidSub.canDelegate("scrollview1_scrollchanged")) { return b4a.example.page.remoteMe.runUserSub(false, "page","scrollview1_scrollchanged", _position);}
RemoteObject _x = RemoteObject.createImmutable(0);
RemoteObject _gradient1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.GradientDrawable");
RemoteObject _clrs = null;
Debug.locals.put("Position", _position);
 BA.debugLineNum = 411;BA.debugLine="Sub ScrollView1_ScrollChanged(Position As Int)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 412;BA.debugLine="Try";
Debug.ShouldStop(134217728);
try { BA.debugLineNum = 413;BA.debugLine="Dim x As Int";
Debug.ShouldStop(268435456);
_x = RemoteObject.createImmutable(0);Debug.locals.put("x", _x);
 BA.debugLineNum = 414;BA.debugLine="If Position>0 And Position<500 Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean(">",_position,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("<",_position,BA.numberCast(double.class, 500))) { 
 BA.debugLineNum = 415;BA.debugLine="x=Position";
Debug.ShouldStop(1073741824);
_x = _position;Debug.locals.put("x", _x);
 BA.debugLineNum = 416;BA.debugLine="Paneldark.Color=Colors.ARGB(x/2,0,0,0)";
Debug.ShouldStop(-2147483648);
page.mostCurrent._paneldark.runVoidMethod ("setColor",page.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 }else 
{ BA.debugLineNum = 417;BA.debugLine="Else if Position<3 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("<",_position,BA.numberCast(double.class, 3))) { 
 BA.debugLineNum = 418;BA.debugLine="Paneldark.Color=Colors.ARGB(0,0,0,0)";
Debug.ShouldStop(2);
page.mostCurrent._paneldark.runVoidMethod ("setColor",page.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 }else 
{ BA.debugLineNum = 419;BA.debugLine="else if  Position>500 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean(">",_position,BA.numberCast(double.class, 500))) { 
 BA.debugLineNum = 420;BA.debugLine="Paneldark.Color=Colors.ARGB(255,0,0,0)";
Debug.ShouldStop(8);
page.mostCurrent._paneldark.runVoidMethod ("setColor",page.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 }}}
;
 BA.debugLineNum = 423;BA.debugLine="If Position>0 And Position<256 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean(">",_position,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("<",_position,BA.numberCast(double.class, 256))) { 
 BA.debugLineNum = 424;BA.debugLine="x=Position";
Debug.ShouldStop(128);
_x = _position;Debug.locals.put("x", _x);
 BA.debugLineNum = 426;BA.debugLine="Dim Gradient1 As GradientDrawable";
Debug.ShouldStop(512);
_gradient1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("Gradient1", _gradient1);
 BA.debugLineNum = 427;BA.debugLine="Dim Clrs(2) As Int";
Debug.ShouldStop(1024);
_clrs = RemoteObject.createNewArray ("int", new int[] {2}, new Object[]{});Debug.locals.put("Clrs", _clrs);
 BA.debugLineNum = 428;BA.debugLine="If Position<156 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("<",_position,BA.numberCast(double.class, 156))) { 
 BA.debugLineNum = 429;BA.debugLine="Clrs(0) =Colors.ARGB(100+x,0,87,0)";
Debug.ShouldStop(4096);
_clrs.setArrayElement (page.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(100),_x}, "+",1, 1)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 87)),(Object)(BA.numberCast(int.class, 0))),BA.numberCast(int.class, 0));
 BA.debugLineNum = 430;BA.debugLine="toolbartemp.Color=Colors.ARGB(100+x,0,87,0)";
Debug.ShouldStop(8192);
page.mostCurrent._toolbartemp.runVoidMethod ("setColor",page.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(100),_x}, "+",1, 1)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 87)),(Object)(BA.numberCast(int.class, 0))));
 }else {
 BA.debugLineNum = 432;BA.debugLine="Clrs(0) =0xFF005700";
Debug.ShouldStop(32768);
_clrs.setArrayElement (BA.numberCast(int.class, 0xff005700),BA.numberCast(int.class, 0));
 BA.debugLineNum = 433;BA.debugLine="toolbartemp.Color=0xFF005700";
Debug.ShouldStop(65536);
page.mostCurrent._toolbartemp.runVoidMethod ("setColor",BA.numberCast(int.class, 0xff005700));
 };
 BA.debugLineNum = 436;BA.debugLine="Clrs(1) = Colors.ARGB(x,0,87,0)";
Debug.ShouldStop(524288);
_clrs.setArrayElement (page.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(_x),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 87)),(Object)(BA.numberCast(int.class, 0))),BA.numberCast(int.class, 1));
 BA.debugLineNum = 437;BA.debugLine="Gradient1.Initialize(\"TOP_BOTTOM\", Clrs)";
Debug.ShouldStop(1048576);
_gradient1.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"TOP_BOTTOM")),(Object)(_clrs));
 BA.debugLineNum = 438;BA.debugLine="ACToolBarLight1.Background=Gradient1";
Debug.ShouldStop(2097152);
page.mostCurrent._actoolbarlight1.runMethod(false,"setBackground",(_gradient1.getObject()));
 BA.debugLineNum = 443;BA.debugLine="ACToolBarLight1.TitleTextColor=Colors.ARGB(x,25";
Debug.ShouldStop(67108864);
page.mostCurrent._actoolbarlight1.runVoidMethod ("setTitleTextColor",page.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(_x),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255))));
 }else 
{ BA.debugLineNum = 444;BA.debugLine="Else if Position<3 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("<",_position,BA.numberCast(double.class, 3))) { 
 BA.debugLineNum = 445;BA.debugLine="Dim Gradient1 As GradientDrawable";
Debug.ShouldStop(268435456);
_gradient1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("Gradient1", _gradient1);
 BA.debugLineNum = 446;BA.debugLine="Dim Clrs(2) As Int";
Debug.ShouldStop(536870912);
_clrs = RemoteObject.createNewArray ("int", new int[] {2}, new Object[]{});Debug.locals.put("Clrs", _clrs);
 BA.debugLineNum = 447;BA.debugLine="Clrs(0) =Colors.ARGB(100,0,39,0)";
Debug.ShouldStop(1073741824);
_clrs.setArrayElement (page.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 39)),(Object)(BA.numberCast(int.class, 0))),BA.numberCast(int.class, 0));
 BA.debugLineNum = 448;BA.debugLine="Clrs(1) = Colors.Transparent";
Debug.ShouldStop(-2147483648);
_clrs.setArrayElement (page.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"),BA.numberCast(int.class, 1));
 BA.debugLineNum = 449;BA.debugLine="Gradient1.Initialize(\"TOP_BOTTOM\", Clrs)";
Debug.ShouldStop(1);
_gradient1.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"TOP_BOTTOM")),(Object)(_clrs));
 BA.debugLineNum = 450;BA.debugLine="ACToolBarLight1.Background=Gradient1";
Debug.ShouldStop(2);
page.mostCurrent._actoolbarlight1.runMethod(false,"setBackground",(_gradient1.getObject()));
 BA.debugLineNum = 451;BA.debugLine="toolbartemp.Color=Colors.ARGB(100,0,39,0)";
Debug.ShouldStop(4);
page.mostCurrent._toolbartemp.runVoidMethod ("setColor",page.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 39)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 452;BA.debugLine="ACToolBarLight1.TitleTextColor=Colors.ARGB(0,25";
Debug.ShouldStop(8);
page.mostCurrent._actoolbarlight1.runVoidMethod ("setTitleTextColor",page.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255))));
 }else 
{ BA.debugLineNum = 453;BA.debugLine="else if  Position>500 Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean(">",_position,BA.numberCast(double.class, 500))) { 
 BA.debugLineNum = 455;BA.debugLine="Dim Gradient1 As GradientDrawable";
Debug.ShouldStop(64);
_gradient1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("Gradient1", _gradient1);
 BA.debugLineNum = 456;BA.debugLine="Dim Clrs(2) As Int";
Debug.ShouldStop(128);
_clrs = RemoteObject.createNewArray ("int", new int[] {2}, new Object[]{});Debug.locals.put("Clrs", _clrs);
 BA.debugLineNum = 457;BA.debugLine="Clrs(0) =0xFF005700";
Debug.ShouldStop(256);
_clrs.setArrayElement (BA.numberCast(int.class, 0xff005700),BA.numberCast(int.class, 0));
 BA.debugLineNum = 458;BA.debugLine="Clrs(1) = 0xFF005700";
Debug.ShouldStop(512);
_clrs.setArrayElement (BA.numberCast(int.class, 0xff005700),BA.numberCast(int.class, 1));
 BA.debugLineNum = 459;BA.debugLine="Gradient1.Initialize(\"TOP_BOTTOM\", Clrs)";
Debug.ShouldStop(1024);
_gradient1.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"TOP_BOTTOM")),(Object)(_clrs));
 BA.debugLineNum = 460;BA.debugLine="ACToolBarLight1.Background=Gradient1";
Debug.ShouldStop(2048);
page.mostCurrent._actoolbarlight1.runMethod(false,"setBackground",(_gradient1.getObject()));
 BA.debugLineNum = 461;BA.debugLine="toolbartemp.Color=0xFF005700";
Debug.ShouldStop(4096);
page.mostCurrent._toolbartemp.runVoidMethod ("setColor",BA.numberCast(int.class, 0xff005700));
 BA.debugLineNum = 463;BA.debugLine="ACToolBarLight1.TitleTextColor=Colors.ARGB(255,";
Debug.ShouldStop(16384);
page.mostCurrent._actoolbarlight1.runVoidMethod ("setTitleTextColor",page.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255))));
 BA.debugLineNum = 464;BA.debugLine="lbltoolbar.Padding = Array As Int (0, 10dip, 0,";
Debug.ShouldStop(32768);
page.mostCurrent._lbltoolbar.runMethod(false,"setPadding",RemoteObject.createNewArray("int",new int[] {4},new Object[] {BA.numberCast(int.class, 0),page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),BA.numberCast(int.class, 0),BA.numberCast(int.class, 0)}));
 }}}
;
 BA.debugLineNum = 466;BA.debugLine="Try";
Debug.ShouldStop(131072);
try { BA.debugLineNum = 467;BA.debugLine="If 56dip+((Position/3)*-1)>=10dip Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("g",RemoteObject.solve(new RemoteObject[] {page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 56))),RemoteObject.createImmutable(((RemoteObject.solve(new RemoteObject[] {_position,RemoteObject.createImmutable(3)}, "/",0, 0)).<Double>get().doubleValue()*-(double) (0 + 1)))}, "+",1, 0),BA.numberCast(double.class, page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))))) { 
 BA.debugLineNum = 468;BA.debugLine="lbltoolbar.Padding = Array As Int (0, 56dip+((";
Debug.ShouldStop(524288);
page.mostCurrent._lbltoolbar.runMethod(false,"setPadding",RemoteObject.createNewArray("int",new int[] {4},new Object[] {BA.numberCast(int.class, 0),BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 56))),RemoteObject.createImmutable(((RemoteObject.solve(new RemoteObject[] {_position,RemoteObject.createImmutable(3)}, "/",0, 0)).<Double>get().doubleValue()*-(double) (0 + 1)))}, "+",1, 0)),BA.numberCast(int.class, 0),BA.numberCast(int.class, 0)}));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e51) {
			BA.rdebugUtils.runVoidMethod("setLastException",page.processBA, e51.toString()); };
 BA.debugLineNum = 475;BA.debugLine="Img.Top=(Position/2)*-1";
Debug.ShouldStop(67108864);
page.mostCurrent._img.runMethod(true,"setTop",BA.numberCast(int.class, (RemoteObject.solve(new RemoteObject[] {_position,RemoteObject.createImmutable(2)}, "/",0, 0)).<Double>get().doubleValue()*-(double) (0 + 1)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e54) {
			BA.rdebugUtils.runVoidMethod("setLastException",page.processBA, e54.toString()); };
 BA.debugLineNum = 482;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _set_ripple(RemoteObject _label) throws Exception{
try {
		Debug.PushSubsStack("set_Ripple (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,177);
if (RapidSub.canDelegate("set_ripple")) { return b4a.example.page.remoteMe.runUserSub(false, "page","set_ripple", _label);}
RemoteObject _phone1 = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _imageviewjo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _colorstate = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _rippledrawable = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("label", _label);
 BA.debugLineNum = 177;BA.debugLine="Sub set_Ripple(label As Label)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 178;BA.debugLine="Dim phone1 As Phone";
Debug.ShouldStop(131072);
_phone1 = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("phone1", _phone1);
 BA.debugLineNum = 179;BA.debugLine="If phone1.SdkVersion<21 Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("<",_phone1.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 21))) { 
 }else {
 BA.debugLineNum = 181;BA.debugLine="Dim ImageViewJo As JavaObject = label";
Debug.ShouldStop(1048576);
_imageviewjo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_imageviewjo.setObject(_label.getObject());Debug.locals.put("ImageViewJo", _imageviewjo);
 BA.debugLineNum = 182;BA.debugLine="Dim ColorState As JavaObject";
Debug.ShouldStop(2097152);
_colorstate = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("ColorState", _colorstate);
 BA.debugLineNum = 183;BA.debugLine="ColorState.InitializeStatic(\"android.content.res";
Debug.ShouldStop(4194304);
_colorstate.runVoidMethod ("InitializeStatic",(Object)(RemoteObject.createImmutable("android.content.res.ColorStateList")));
 BA.debugLineNum = 184;BA.debugLine="Dim RippleDrawable As JavaObject";
Debug.ShouldStop(8388608);
_rippledrawable = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("RippleDrawable", _rippledrawable);
 BA.debugLineNum = 185;BA.debugLine="RippleDrawable.InitializeNewInstance(\"android.gr";
Debug.ShouldStop(16777216);
_rippledrawable.runVoidMethod ("InitializeNewInstance",(Object)(BA.ObjectToString("android.graphics.drawable.RippleDrawable")),(Object)(RemoteObject.createNewArray("Object",new int[] {3},new Object[] {_colorstate.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("valueOf")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x78000000))}))),page.mostCurrent.__c.getField(false,"Null"),page.mostCurrent.__c.getField(false,"Null")})));
 BA.debugLineNum = 186;BA.debugLine="ImageViewJo.RunMethod(\"setBackground\",Array(Ripp";
Debug.ShouldStop(33554432);
_imageviewjo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setBackground")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_rippledrawable.getObject())})));
 };
 BA.debugLineNum = 188;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setalllabel() throws Exception{
try {
		Debug.PushSubsStack("SetAllLabel (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,738);
if (RapidSub.canDelegate("setalllabel")) { return b4a.example.page.remoteMe.runUserSub(false, "page","setalllabel");}
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _h13 = null;
RemoteObject _hhh = RemoteObject.createImmutable("");
int _m = 0;
 BA.debugLineNum = 738;BA.debugLine="Sub SetAllLabel";
Debug.ShouldStop(2);
 BA.debugLineNum = 739;BA.debugLine="Try";
Debug.ShouldStop(4);
try { BA.debugLineNum = 740;BA.debugLine="For Each v As View In Activity.GetAllViewsRecurs";
Debug.ShouldStop(8);
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");
{
final RemoteObject group2 = page.mostCurrent._activity.runMethod(false,"GetAllViewsRecursive");
final int groupLen2 = group2.runMethod(true,"getSize").<Integer>get()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_v.setObject(group2.runMethod(false,"Get",index2));
Debug.locals.put("v", _v);
 BA.debugLineNum = 741;BA.debugLine="If GetType(v) = \"android.widget.TextView\" Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",page.mostCurrent.__c.runMethod(true,"GetType",(Object)((_v.getObject()))),BA.ObjectToString("android.widget.TextView"))) { 
 BA.debugLineNum = 742;BA.debugLine="Dim lbl As Label = v";
Debug.ShouldStop(32);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_lbl.setObject(_v.getObject());Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 743;BA.debugLine="Dim h13() As String=Regex.Split(CRLF,lbl.Text)";
Debug.ShouldStop(64);
_h13 = page.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(page.mostCurrent.__c.getField(true,"CRLF")),(Object)(_lbl.runMethod(true,"getText")));Debug.locals.put("h13", _h13);Debug.locals.put("h13", _h13);
 BA.debugLineNum = 744;BA.debugLine="Dim hhh As String";
Debug.ShouldStop(128);
_hhh = RemoteObject.createImmutable("");Debug.locals.put("hhh", _hhh);
 BA.debugLineNum = 745;BA.debugLine="For m = 0 To h13.Length-1";
Debug.ShouldStop(256);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {_h13.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_m = 0 ;
for (;(step7 > 0 && _m <= limit7) || (step7 < 0 && _m >= limit7) ;_m = ((int)(0 + _m + step7))  ) {
Debug.locals.put("m", _m);
 BA.debugLineNum = 746;BA.debugLine="If h13(m).Contains(\"بیتوته\") Or h13(m).Contai";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean(".",_h13.getArrayElement(true,BA.numberCast(int.class, _m)).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("بیتوته")))) || RemoteObject.solveBoolean(".",_h13.getArrayElement(true,BA.numberCast(int.class, _m)).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("منبع")))) || RemoteObject.solveBoolean("=",_h13.getArrayElement(true,BA.numberCast(int.class, _m)),BA.ObjectToString("")) || RemoteObject.solveBoolean("=",_h13.getArrayElement(true,BA.numberCast(int.class, _m)),BA.ObjectToString(" "))) { 
 }else {
 BA.debugLineNum = 748;BA.debugLine="hhh=hhh+h13(m)";
Debug.ShouldStop(2048);
_hhh = BA.NumberToString(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, _hhh),BA.numberCast(double.class, _h13.getArrayElement(true,BA.numberCast(int.class, _m)))}, "+",1, 0));Debug.locals.put("hhh", _hhh);
 };
 }
}Debug.locals.put("m", _m);
;
 BA.debugLineNum = 751;BA.debugLine="lbl.Text=hhh";
Debug.ShouldStop(16384);
_lbl.runMethod(true,"setText",BA.ObjectToCharSequence(_hhh));
 };
 }
}Debug.locals.put("v", _v);
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e17) {
			BA.rdebugUtils.runVoidMethod("setLastException",page.processBA, e17.toString()); };
 BA.debugLineNum = 759;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _settextshadow(RemoteObject _pview,RemoteObject _pradius,RemoteObject _pdx,RemoteObject _pdy,RemoteObject _pcolor) throws Exception{
try {
		Debug.PushSubsStack("SetTextShadow (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,1046);
if (RapidSub.canDelegate("settextshadow")) { return b4a.example.page.remoteMe.runUserSub(false, "page","settextshadow", _pview, _pradius, _pdx, _pdy, _pcolor);}
RemoteObject _ref = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
Debug.locals.put("pView", _pview);
Debug.locals.put("pRadius", _pradius);
Debug.locals.put("pDx", _pdx);
Debug.locals.put("pDy", _pdy);
Debug.locals.put("pColor", _pcolor);
 BA.debugLineNum = 1046;BA.debugLine="Sub SetTextShadow(pView As View, pRadius As Float,";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 1047;BA.debugLine="Dim ref As Reflector";
Debug.ShouldStop(4194304);
_ref = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("ref", _ref);
 BA.debugLineNum = 1049;BA.debugLine="ref.Target = pView";
Debug.ShouldStop(16777216);
_ref.setField ("Target",(_pview.getObject()));
 BA.debugLineNum = 1050;BA.debugLine="ref.RunMethod4(\"setShadowLayer\", Array As Object(";
Debug.ShouldStop(33554432);
_ref.runVoidMethod ("RunMethod4",(Object)(BA.ObjectToString("setShadowLayer")),(Object)(RemoteObject.createNewArray("Object",new int[] {4},new Object[] {(_pradius),(_pdx),(_pdy),(_pcolor)})),(Object)(RemoteObject.createNewArray("String",new int[] {4},new Object[] {BA.ObjectToString("java.lang.float"),BA.ObjectToString("java.lang.float"),BA.ObjectToString("java.lang.float"),RemoteObject.createImmutable("java.lang.int")})));
 BA.debugLineNum = 1051;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _share_click() throws Exception{
try {
		Debug.PushSubsStack("share_Click (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,522);
if (RapidSub.canDelegate("share_click")) { return b4a.example.page.remoteMe.runUserSub(false, "page","share_click");}
RemoteObject _aria = RemoteObject.declareNull("anywheresoftware.b4a.ariagplib.ARIAlib");
 BA.debugLineNum = 522;BA.debugLine="Sub share_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 523;BA.debugLine="Dim Aria As AriaLib";
Debug.ShouldStop(1024);
_aria = RemoteObject.createNew ("anywheresoftware.b4a.ariagplib.ARIAlib");Debug.locals.put("Aria", _aria);
 BA.debugLineNum = 528;BA.debugLine="StartActivity( Aria.ShareText(Main.txtnewstitle&C";
Debug.ShouldStop(32768);
page.mostCurrent.__c.runVoidMethod ("StartActivity",page.processBA,(Object)((_aria.runMethod(false,"ShareText",(Object)(RemoteObject.concat(page.mostCurrent._main._txtnewstitle /*RemoteObject*/ ,page.mostCurrent.__c.getField(true,"CRLF"),page.mostCurrent.__c.getField(true,"CRLF"),page.mostCurrent._alltext,page.mostCurrent.__c.getField(true,"CRLF"),page.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("برگرفته از اپلیکیشن هواداری ؛"),page.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("https://cafebazaar.ir/app/"),page.mostCurrent.__c.getField(false,"Application").runMethod(true,"getPackageName"),RemoteObject.createImmutable("/?l=fa"))),(Object)(RemoteObject.createImmutable("اشتراک گذاری با ؛"))))));
 BA.debugLineNum = 532;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _showbigpik() throws Exception{
try {
		Debug.PushSubsStack("showbigpik (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,199);
if (RapidSub.canDelegate("showbigpik")) { return b4a.example.page.remoteMe.runUserSub(false, "page","showbigpik");}
 BA.debugLineNum = 199;BA.debugLine="Sub showbigpik";
Debug.ShouldStop(64);
 BA.debugLineNum = 201;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _toolbar() throws Exception{
try {
		Debug.PushSubsStack("toolbar (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,715);
if (RapidSub.canDelegate("toolbar")) { return b4a.example.page.remoteMe.runUserSub(false, "page","toolbar");}
RemoteObject _pntool = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
 BA.debugLineNum = 715;BA.debugLine="Sub toolbar";
Debug.ShouldStop(1024);
 BA.debugLineNum = 716;BA.debugLine="ScrollView1.Panel.Height=toptemp+10%x";
Debug.ShouldStop(2048);
page.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {page._toptemp,page.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),page.mostCurrent.activityBA)}, "+",1, 1));
 BA.debugLineNum = 717;BA.debugLine="pnlmatlab.Height=toptemp";
Debug.ShouldStop(4096);
page.mostCurrent._pnlmatlab.runMethod(true,"setHeight",page._toptemp);
 BA.debugLineNum = 718;BA.debugLine="ACToolBarLight1.Title=Main.txtnewstitle";
Debug.ShouldStop(8192);
page.mostCurrent._actoolbarlight1.runMethod(true,"setTitle",BA.ObjectToCharSequence(page.mostCurrent._main._txtnewstitle /*RemoteObject*/ ));
 BA.debugLineNum = 720;BA.debugLine="Dim Pntool As Panel = ACToolBarLight1";
Debug.ShouldStop(32768);
_pntool = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_pntool.setObject(page.mostCurrent._actoolbarlight1.getObject());Debug.locals.put("Pntool", _pntool);
 BA.debugLineNum = 721;BA.debugLine="For Each v As View In Pntool";
Debug.ShouldStop(65536);
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");
{
final RemoteObject group5 = _pntool;
final int groupLen5 = group5.runMethod(true,"getSize").<Integer>get()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_v.setObject(group5.runMethod(false,"Get",index5));
Debug.locals.put("v", _v);
 BA.debugLineNum = 722;BA.debugLine="If v Is Label Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.TextView"))) { 
 BA.debugLineNum = 723;BA.debugLine="lbltoolbar = v";
Debug.ShouldStop(262144);
page.mostCurrent._lbltoolbar.setObject(_v.getObject());
 BA.debugLineNum = 724;BA.debugLine="Select lbltoolbar.text";
Debug.ShouldStop(524288);
switch (BA.switchObjectToInt(page.mostCurrent._lbltoolbar.runMethod(true,"getText"),page.mostCurrent._actoolbarlight1.runMethod(true,"getTitle"))) {
case 0: {
 BA.debugLineNum = 726;BA.debugLine="lbltoolbar.Typeface = C.irs";
Debug.ShouldStop(2097152);
page.mostCurrent._lbltoolbar.runMethod(false,"setTypeface",(page.mostCurrent._c._irs /*RemoteObject*/ .getObject()));
 BA.debugLineNum = 727;BA.debugLine="lbltoolbar.TextSize=15";
Debug.ShouldStop(4194304);
page.mostCurrent._lbltoolbar.runMethod(true,"setTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 728;BA.debugLine="lbltoolbar.Padding = Array As Int (0, 4dip, 0";
Debug.ShouldStop(8388608);
page.mostCurrent._lbltoolbar.runMethod(false,"setPadding",RemoteObject.createNewArray("int",new int[] {4},new Object[] {BA.numberCast(int.class, 0),page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 4))),BA.numberCast(int.class, 0),BA.numberCast(int.class, 0)}));
 BA.debugLineNum = 729;BA.debugLine="lbltoolbar.Color=Colors.Transparent";
Debug.ShouldStop(16777216);
page.mostCurrent._lbltoolbar.runVoidMethod ("setColor",page.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 730;BA.debugLine="lbltoolbar.Height=56dip";
Debug.ShouldStop(33554432);
page.mostCurrent._lbltoolbar.runMethod(true,"setHeight",page.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 56))));
 break; }
}
;
 };
 }
}Debug.locals.put("v", _v);
;
 BA.debugLineNum = 735;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _zoom_in_click() throws Exception{
try {
		Debug.PushSubsStack("zoom_in_Click (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,508);
if (RapidSub.canDelegate("zoom_in_click")) { b4a.example.page.remoteMe.runUserSub(false, "page","zoom_in_click"); return;}
ResumableSub_zoom_in_Click rsub = new ResumableSub_zoom_in_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_zoom_in_Click extends BA.ResumableSub {
public ResumableSub_zoom_in_Click(b4a.example.page parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.page parent;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("zoom_in_Click (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,508);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 BA.debugLineNum = 509;BA.debugLine="fsize=fsize+2";
Debug.ShouldStop(268435456);
parent._fsize = RemoteObject.solve(new RemoteObject[] {parent._fsize,RemoteObject.createImmutable(2)}, "+",1, 1);
 BA.debugLineNum = 510;BA.debugLine="File.WriteString(File.DirInternal,\"fsize\",fsize)";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("fsize")),(Object)(BA.NumberToString(parent._fsize)));
 BA.debugLineNum = 511;BA.debugLine="Sleep(0)";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("Sleep",page.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "page", "zoom_in_click"),BA.numberCast(int.class, 0));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 BA.debugLineNum = 513;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1);
parent.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 514;BA.debugLine="End Sub";
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
public static void  _zoom_out_click() throws Exception{
try {
		Debug.PushSubsStack("zoom_out_Click (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,515);
if (RapidSub.canDelegate("zoom_out_click")) { b4a.example.page.remoteMe.runUserSub(false, "page","zoom_out_click"); return;}
ResumableSub_zoom_out_Click rsub = new ResumableSub_zoom_out_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_zoom_out_Click extends BA.ResumableSub {
public ResumableSub_zoom_out_Click(b4a.example.page parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.page parent;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("zoom_out_Click (page) ","page",7,page.mostCurrent.activityBA,page.mostCurrent,515);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 BA.debugLineNum = 516;BA.debugLine="fsize=fsize-2";
Debug.ShouldStop(8);
parent._fsize = RemoteObject.solve(new RemoteObject[] {parent._fsize,RemoteObject.createImmutable(2)}, "-",1, 1);
 BA.debugLineNum = 517;BA.debugLine="File.WriteString(File.DirInternal,\"fsize\",fsize)";
Debug.ShouldStop(16);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("fsize")),(Object)(BA.NumberToString(parent._fsize)));
 BA.debugLineNum = 518;BA.debugLine="Sleep(0)";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("Sleep",page.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "page", "zoom_out_click"),BA.numberCast(int.class, 0));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 BA.debugLineNum = 520;BA.debugLine="Activity.Finish";
Debug.ShouldStop(128);
parent.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 521;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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