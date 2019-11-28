package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class creatlv_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Dim lv As Hitex_LayoutView";
creatlv._lv = RemoteObject.createNew ("wir.hitex.recycler.Hitex_LayoutView");__ref.setField("_lv",creatlv._lv);
 //BA.debugLineNum = 3;BA.debugLine="Dim lstnews1 As List";
creatlv._lstnews1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");__ref.setField("_lstnews1",creatlv._lstnews1);
 //BA.debugLineNum = 4;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _parent,RemoteObject _top,RemoteObject _lst) throws Exception{
try {
		Debug.PushSubsStack("Initialize (creatlv) ","creatlv",10,__ref.getField(false, "ba"),__ref,7);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "creatlv","initialize", __ref, _ba, _parent, _top, _lst);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("parent", _parent);
Debug.locals.put("top", _top);
Debug.locals.put("lst", _lst);
 BA.debugLineNum = 7;BA.debugLine="Public Sub Initialize(parent As Panel,top As Int,l";
Debug.ShouldStop(64);
 BA.debugLineNum = 8;BA.debugLine="lv.Initializer(\"LV_news\").ListView.Horizontal.RTL";
Debug.ShouldStop(128);
__ref.getField(false,"_lv" /*RemoteObject*/ ).runMethod(false,"Initializer",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("LV_news"))).runMethod(false,"ListView").runMethod(false,"Horizontal").runMethod(false,"RTL").runVoidMethod ("Build");
 BA.debugLineNum = 10;BA.debugLine="lstnews1=lst";
Debug.ShouldStop(512);
__ref.setField ("_lstnews1" /*RemoteObject*/ ,_lst);
 BA.debugLineNum = 11;BA.debugLine="parent.AddView(lv,0,top,100%x,73%x)";
Debug.ShouldStop(1024);
_parent.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_lv" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_top),(Object)(creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),__ref.getField(false, "ba"))),(Object)(creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 73)),__ref.getField(false, "ba"))));
 BA.debugLineNum = 13;BA.debugLine="lv.Show";
Debug.ShouldStop(4096);
__ref.getField(false,"_lv" /*RemoteObject*/ ).runVoidMethodAndSync ("Show");
 BA.debugLineNum = 14;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lv_news_getitemcount(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("LV_news_GetItemCount (creatlv) ","creatlv",10,__ref.getField(false, "ba"),__ref,143);
if (RapidSub.canDelegate("lv_news_getitemcount")) { return __ref.runUserSub(false, "creatlv","lv_news_getitemcount", __ref);}
 BA.debugLineNum = 143;BA.debugLine="Sub LV_news_GetItemCount As Int 								        '�";
Debug.ShouldStop(16384);
 BA.debugLineNum = 144;BA.debugLine="Return lstnews1.Size '/ItemList.Size";
Debug.ShouldStop(32768);
if (true) return __ref.getField(false,"_lstnews1" /*RemoteObject*/ ).runMethod(true,"getSize");
 BA.debugLineNum = 146;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lv_news_itemclick(RemoteObject __ref,RemoteObject _clickeditem,RemoteObject _position) throws Exception{
try {
		Debug.PushSubsStack("LV_news_ItemClick (creatlv) ","creatlv",10,__ref.getField(false, "ba"),__ref,147);
if (RapidSub.canDelegate("lv_news_itemclick")) { return __ref.runUserSub(false, "creatlv","lv_news_itemclick", __ref, _clickeditem, _position);}
Debug.locals.put("ClickedItem", _clickeditem);
Debug.locals.put("Position", _position);
 BA.debugLineNum = 147;BA.debugLine="Sub LV_news_ItemClick (ClickedItem As Panel, Posit";
Debug.ShouldStop(262144);
 BA.debugLineNum = 155;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lv_news_onbindviewholder(RemoteObject __ref,RemoteObject _parent,RemoteObject _position) throws Exception{
try {
		Debug.PushSubsStack("LV_news_onBindViewHolder (creatlv) ","creatlv",10,__ref.getField(false, "ba"),__ref,110);
if (RapidSub.canDelegate("lv_news_onbindviewholder")) { return __ref.runUserSub(false, "creatlv","lv_news_onbindviewholder", __ref, _parent, _position);}
RemoteObject _p1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _img = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _glide = RemoteObject.declareNull("com.hitex_glide.Hitex_Glide");
RemoteObject _h13 = null;
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("Parent", _parent);
Debug.locals.put("Position", _position);
 BA.debugLineNum = 110;BA.debugLine="Sub LV_news_onBindViewHolder (Parent As Panel, Pos";
Debug.ShouldStop(8192);
 BA.debugLineNum = 111;BA.debugLine="Dim p1 As Panel = Parent.GetView(0)";
Debug.ShouldStop(16384);
_p1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_p1.setObject(_parent.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 0))).getObject());Debug.locals.put("p1", _p1);
 BA.debugLineNum = 112;BA.debugLine="Dim p As Panel = p1.GetView(0)";
Debug.ShouldStop(32768);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_p.setObject(_p1.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 0))).getObject());Debug.locals.put("p", _p);
 BA.debugLineNum = 113;BA.debugLine="Dim img As ImageView = p.GetView(0)";
Debug.ShouldStop(65536);
_img = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
_img.setObject(_p.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 0))).getObject());Debug.locals.put("img", _img);
 BA.debugLineNum = 114;BA.debugLine="Dim Glide As Hitex_Glide";
Debug.ShouldStop(131072);
_glide = RemoteObject.createNew ("com.hitex_glide.Hitex_Glide");Debug.locals.put("Glide", _glide);
 BA.debugLineNum = 115;BA.debugLine="Dim h13() As String=Regex.Split(\"#\",lstnews1.Get(";
Debug.ShouldStop(262144);
_h13 = creatlv.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString("#")),(Object)(BA.ObjectToString(__ref.getField(false,"_lstnews1" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(_position)))));Debug.locals.put("h13", _h13);Debug.locals.put("h13", _h13);
 BA.debugLineNum = 116;BA.debugLine="Glide.Load2(h13(0)).CenterCrop.Into(img)";
Debug.ShouldStop(524288);
_glide.runMethod(false,"Load2",__ref.getField(false, "ba"),(Object)(_h13.getArrayElement(true,BA.numberCast(int.class, 0)))).runMethod(false,"CenterCrop").runVoidMethod ("Into",(Object)(_img));
 BA.debugLineNum = 118;BA.debugLine="Dim lbl As Label = p.GetView(1)";
Debug.ShouldStop(2097152);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_lbl.setObject(_p.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 1))).getObject());Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 119;BA.debugLine="lbl.Text=h13(2)";
Debug.ShouldStop(4194304);
_lbl.runMethod(true,"setText",BA.ObjectToCharSequence(_h13.getArrayElement(true,BA.numberCast(int.class, 2))));
 BA.debugLineNum = 121;BA.debugLine="Dim lbl As Label = p.GetView(2)";
Debug.ShouldStop(16777216);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_lbl.setObject(_p.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 2))).getObject());Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 122;BA.debugLine="lbl.Text=h13(4)&\" تومان \"";
Debug.ShouldStop(33554432);
_lbl.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_h13.getArrayElement(true,BA.numberCast(int.class, 4)),RemoteObject.createImmutable(" تومان "))));
 BA.debugLineNum = 124;BA.debugLine="Dim lbl As Label = p.GetView(3)";
Debug.ShouldStop(134217728);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_lbl.setObject(_p.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 3))).getObject());Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 125;BA.debugLine="If h13(3)<>h13(4) Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("!",_h13.getArrayElement(true,BA.numberCast(int.class, 3)),_h13.getArrayElement(true,BA.numberCast(int.class, 4)))) { 
 BA.debugLineNum = 126;BA.debugLine="lbl.Text=whoops_text(h13(3)&\" تومان \")";
Debug.ShouldStop(536870912);
_lbl.runMethod(true,"setText",BA.ObjectToCharSequence(__ref.runClassMethod (b4a.example.creatlv.class, "_whoops_text" /*RemoteObject*/ ,(Object)(RemoteObject.concat(_h13.getArrayElement(true,BA.numberCast(int.class, 3)),RemoteObject.createImmutable(" تومان "))))));
 }else {
 BA.debugLineNum = 128;BA.debugLine="lbl.Text=\"\"";
Debug.ShouldStop(-2147483648);
_lbl.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 };
 BA.debugLineNum = 135;BA.debugLine="If Position=0 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",_position,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 136;BA.debugLine="Parent.Width=48%x";
Debug.ShouldStop(128);
_parent.runMethod(true,"setWidth",creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 48)),__ref.getField(false, "ba")));
 }else {
 BA.debugLineNum = 138;BA.debugLine="Parent.Width=47%x";
Debug.ShouldStop(512);
_parent.runMethod(true,"setWidth",creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 47)),__ref.getField(false, "ba")));
 };
 BA.debugLineNum = 141;BA.debugLine="Parent.Height=75%x";
Debug.ShouldStop(4096);
_parent.runMethod(true,"setHeight",creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 75)),__ref.getField(false, "ba")));
 BA.debugLineNum = 142;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lv_news_oncreateviewholder(RemoteObject __ref,RemoteObject _parent,RemoteObject _viewtype) throws Exception{
try {
		Debug.PushSubsStack("LV_news_onCreateViewHolder (creatlv) ","creatlv",10,__ref.getField(false, "ba"),__ref,16);
if (RapidSub.canDelegate("lv_news_oncreateviewholder")) { return __ref.runUserSub(false, "creatlv","lv_news_oncreateviewholder", __ref, _parent, _viewtype);}
RemoteObject _card = RemoteObject.declareNull("de.amberhome.objects.CardViewWrapper");
RemoteObject _pnlk = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _img = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lbl2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("Parent", _parent);
Debug.locals.put("ViewType", _viewtype);
 BA.debugLineNum = 16;BA.debugLine="Sub LV_news_onCreateViewHolder (Parent As Panel, V";
Debug.ShouldStop(32768);
 BA.debugLineNum = 18;BA.debugLine="Dim card As CardView";
Debug.ShouldStop(131072);
_card = RemoteObject.createNew ("de.amberhome.objects.CardViewWrapper");Debug.locals.put("card", _card);
 BA.debugLineNum = 19;BA.debugLine="card.Initialize(\"\")";
Debug.ShouldStop(262144);
_card.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 20;BA.debugLine="card.Elevation=2dip";
Debug.ShouldStop(524288);
_card.runMethod(true,"setElevation",BA.numberCast(float.class, creatlv.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 21;BA.debugLine="card.CornerRadius=2dip";
Debug.ShouldStop(1048576);
_card.runMethod(true,"setCornerRadius",BA.numberCast(float.class, creatlv.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 22;BA.debugLine="Parent.AddView(card,1%x,1%x,44%x,71%x)";
Debug.ShouldStop(2097152);
_parent.runVoidMethod ("AddView",(Object)((_card.getObject())),(Object)(creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),__ref.getField(false, "ba"))),(Object)(creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),__ref.getField(false, "ba"))),(Object)(creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 44)),__ref.getField(false, "ba"))),(Object)(creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 71)),__ref.getField(false, "ba"))));
 BA.debugLineNum = 24;BA.debugLine="Dim pnlk As Panel";
Debug.ShouldStop(8388608);
_pnlk = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnlk", _pnlk);
 BA.debugLineNum = 25;BA.debugLine="pnlk.Initialize(\"\")";
Debug.ShouldStop(16777216);
_pnlk.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 26;BA.debugLine="card.AddView(pnlk,0,0,-1,-1)";
Debug.ShouldStop(33554432);
_card.runVoidMethod ("AddView",(Object)((_pnlk.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(BA.numberCast(int.class, -(double) (0 + 1))));
 BA.debugLineNum = 28;BA.debugLine="Dim img As ImageView";
Debug.ShouldStop(134217728);
_img = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("img", _img);
 BA.debugLineNum = 29;BA.debugLine="img.Initialize(\"\")";
Debug.ShouldStop(268435456);
_img.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 30;BA.debugLine="pnlk.AddView(img,0,0,-1,36%x)";
Debug.ShouldStop(536870912);
_pnlk.runVoidMethod ("AddView",(Object)((_img.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 36)),__ref.getField(false, "ba"))));
 BA.debugLineNum = 32;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(-2147483648);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 33;BA.debugLine="lbl.Initialize(\"\")";
Debug.ShouldStop(1);
_lbl.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 34;BA.debugLine="lbl.Color=Colors.White";
Debug.ShouldStop(2);
_lbl.runVoidMethod ("setColor",creatlv.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 35;BA.debugLine="lbl.Gravity=Gravity.RIGHT";
Debug.ShouldStop(4);
_lbl.runMethod(true,"setGravity",creatlv.__c.getField(false,"Gravity").getField(true,"RIGHT"));
 BA.debugLineNum = 36;BA.debugLine="lbl.Typeface=C.irs";
Debug.ShouldStop(8);
_lbl.runMethod(false,"setTypeface",(creatlv._c._irs /*RemoteObject*/ .getObject()));
 BA.debugLineNum = 38;BA.debugLine="lbl.TextSize=14";
Debug.ShouldStop(32);
_lbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 40;BA.debugLine="lbl.Padding = Array As Int (10dip, 0, 10dip, 0)";
Debug.ShouldStop(128);
_lbl.runMethod(false,"setPadding",RemoteObject.createNewArray("int",new int[] {4},new Object[] {creatlv.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),BA.numberCast(int.class, 0),creatlv.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),BA.numberCast(int.class, 0)}));
 BA.debugLineNum = 41;BA.debugLine="pnlk.AddView(lbl,0,40%x,44%x,14%x)";
Debug.ShouldStop(256);
_pnlk.runVoidMethod ("AddView",(Object)((_lbl.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 40)),__ref.getField(false, "ba"))),(Object)(creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 44)),__ref.getField(false, "ba"))),(Object)(creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 14)),__ref.getField(false, "ba"))));
 BA.debugLineNum = 43;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(1024);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 44;BA.debugLine="lbl.Initialize(\"\")";
Debug.ShouldStop(2048);
_lbl.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 45;BA.debugLine="lbl.Color=Colors.White";
Debug.ShouldStop(4096);
_lbl.runVoidMethod ("setColor",creatlv.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 46;BA.debugLine="lbl.Gravity=Gravity.LEFT";
Debug.ShouldStop(8192);
_lbl.runMethod(true,"setGravity",creatlv.__c.getField(false,"Gravity").getField(true,"LEFT"));
 BA.debugLineNum = 47;BA.debugLine="lbl.Typeface=C.irs";
Debug.ShouldStop(16384);
_lbl.runMethod(false,"setTypeface",(creatlv._c._irs /*RemoteObject*/ .getObject()));
 BA.debugLineNum = 48;BA.debugLine="lbl.SingleLine=True";
Debug.ShouldStop(32768);
_lbl.runVoidMethod ("setSingleLine",creatlv.__c.getField(true,"True"));
 BA.debugLineNum = 49;BA.debugLine="lbl.Padding = Array As Int (10dip, 0, 10dip, 0)";
Debug.ShouldStop(65536);
_lbl.runMethod(false,"setPadding",RemoteObject.createNewArray("int",new int[] {4},new Object[] {creatlv.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),BA.numberCast(int.class, 0),creatlv.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),BA.numberCast(int.class, 0)}));
 BA.debugLineNum = 50;BA.debugLine="lbl.Ellipsize=\"END\"";
Debug.ShouldStop(131072);
_lbl.runMethod(true,"setEllipsize",BA.ObjectToString("END"));
 BA.debugLineNum = 51;BA.debugLine="lbl.TextSize=14";
Debug.ShouldStop(262144);
_lbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 52;BA.debugLine="pnlk.AddView(lbl,0,63%x,44%x,10%x)";
Debug.ShouldStop(524288);
_pnlk.runVoidMethod ("AddView",(Object)((_lbl.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 63)),__ref.getField(false, "ba"))),(Object)(creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 44)),__ref.getField(false, "ba"))),(Object)(creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),__ref.getField(false, "ba"))));
 BA.debugLineNum = 53;BA.debugLine="lbl.Text=\"2000 تومان\"";
Debug.ShouldStop(1048576);
_lbl.runMethod(true,"setText",BA.ObjectToCharSequence("2000 تومان"));
 BA.debugLineNum = 54;BA.debugLine="lbl.TextColor=0xFF006400";
Debug.ShouldStop(2097152);
_lbl.runMethod(true,"setTextColor",BA.numberCast(int.class, 0xff006400));
 BA.debugLineNum = 56;BA.debugLine="Dim lbl2 As Label";
Debug.ShouldStop(8388608);
_lbl2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl2", _lbl2);
 BA.debugLineNum = 57;BA.debugLine="lbl2.Initialize(\"\")";
Debug.ShouldStop(16777216);
_lbl2.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 58;BA.debugLine="lbl2.Color=Colors.Transparent";
Debug.ShouldStop(33554432);
_lbl2.runVoidMethod ("setColor",creatlv.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 59;BA.debugLine="lbl2.Gravity=Gravity.LEFT";
Debug.ShouldStop(67108864);
_lbl2.runMethod(true,"setGravity",creatlv.__c.getField(false,"Gravity").getField(true,"LEFT"));
 BA.debugLineNum = 60;BA.debugLine="lbl2.Typeface=C.irs";
Debug.ShouldStop(134217728);
_lbl2.runMethod(false,"setTypeface",(creatlv._c._irs /*RemoteObject*/ .getObject()));
 BA.debugLineNum = 61;BA.debugLine="lbl2.SingleLine=True";
Debug.ShouldStop(268435456);
_lbl2.runVoidMethod ("setSingleLine",creatlv.__c.getField(true,"True"));
 BA.debugLineNum = 62;BA.debugLine="lbl2.Padding = Array As Int (10dip, 0, 10dip, 0)";
Debug.ShouldStop(536870912);
_lbl2.runMethod(false,"setPadding",RemoteObject.createNewArray("int",new int[] {4},new Object[] {creatlv.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),BA.numberCast(int.class, 0),creatlv.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),BA.numberCast(int.class, 0)}));
 BA.debugLineNum = 63;BA.debugLine="lbl2.Ellipsize=\"END\"";
Debug.ShouldStop(1073741824);
_lbl2.runMethod(true,"setEllipsize",BA.ObjectToString("END"));
 BA.debugLineNum = 64;BA.debugLine="lbl2.TextSize=12";
Debug.ShouldStop(-2147483648);
_lbl2.runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 66;BA.debugLine="pnlk.AddView(lbl2,0,58%x,44%x,10%x)";
Debug.ShouldStop(2);
_pnlk.runVoidMethod ("AddView",(Object)((_lbl2.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 58)),__ref.getField(false, "ba"))),(Object)(creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 44)),__ref.getField(false, "ba"))),(Object)(creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),__ref.getField(false, "ba"))));
 BA.debugLineNum = 67;BA.debugLine="lbl2.Text=\"قیمت:\"";
Debug.ShouldStop(4);
_lbl2.runMethod(true,"setText",BA.ObjectToCharSequence("قیمت:"));
 BA.debugLineNum = 68;BA.debugLine="lbl2.TextColor=0xFF9A0000";
Debug.ShouldStop(8);
_lbl2.runMethod(true,"setTextColor",BA.numberCast(int.class, 0xff9a0000));
 BA.debugLineNum = 70;BA.debugLine="Dim pnl As Label";
Debug.ShouldStop(32);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 71;BA.debugLine="pnl.Initialize(\"\")";
Debug.ShouldStop(64);
_pnl.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 72;BA.debugLine="pnlk.AddView(pnl,0,55%x,100%x,1dip)";
Debug.ShouldStop(128);
_pnlk.runVoidMethod ("AddView",(Object)((_pnl.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 55)),__ref.getField(false, "ba"))),(Object)(creatlv.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),__ref.getField(false, "ba"))),(Object)(creatlv.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 73;BA.debugLine="pnl.Color=0xFFE5E5E5";
Debug.ShouldStop(256);
_pnl.runVoidMethod ("setColor",BA.numberCast(int.class, 0xffe5e5e5));
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
public static RemoteObject  _whoops_text(RemoteObject __ref,RemoteObject _text) throws Exception{
try {
		Debug.PushSubsStack("whoops_text (creatlv) ","creatlv",10,__ref.getField(false, "ba"),__ref,156);
if (RapidSub.canDelegate("whoops_text")) { return __ref.runUserSub(false, "creatlv","whoops_text", __ref, _text);}
RemoteObject _cs = RemoteObject.declareNull("anywheresoftware.b4a.objects.CSBuilder");
Debug.locals.put("text", _text);
 BA.debugLineNum = 156;BA.debugLine="Sub whoops_text(text As String) As Object";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 157;BA.debugLine="Dim cs As CSBuilder";
Debug.ShouldStop(268435456);
_cs = RemoteObject.createNew ("anywheresoftware.b4a.objects.CSBuilder");Debug.locals.put("cs", _cs);
 BA.debugLineNum = 158;BA.debugLine="cs.Initialize";
Debug.ShouldStop(536870912);
_cs.runVoidMethod ("Initialize");
 BA.debugLineNum = 159;BA.debugLine="cs.Strikethrough.Append(text).Pop.PopAll";
Debug.ShouldStop(1073741824);
_cs.runMethod(false,"Strikethrough").runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(_text))).runMethod(false,"Pop").runVoidMethod ("PopAll");
 BA.debugLineNum = 160;BA.debugLine="Return  cs";
Debug.ShouldStop(-2147483648);
if (true) return (_cs.getObject());
 BA.debugLineNum = 161;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}