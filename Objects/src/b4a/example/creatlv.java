package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class creatlv extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.example.creatlv");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.creatlv.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public wir.hitex.recycler.Hitex_LayoutView _lv = null;
public anywheresoftware.b4a.objects.collections.List _lstnews1 = null;
public b4a.example.main _main = null;
public b4a.example.act_tip _act_tip = null;
public b4a.example.login _login = null;
public b4a.example.verify _verify = null;
public b4a.example.home _home = null;
public b4a.example.c _c = null;
public b4a.example.starter _starter = null;
public b4a.example.page _page = null;
public b4a.example.finger _finger = null;
public String  _initialize(b4a.example.creatlv __ref,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.PanelWrapper _parent,int _top,anywheresoftware.b4a.objects.collections.List _lst) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="creatlv";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_parent,_top,_lst}));}
RDebugUtils.currentLine=8454144;
 //BA.debugLineNum = 8454144;BA.debugLine="Public Sub Initialize(parent As Panel,top As Int,l";
RDebugUtils.currentLine=8454145;
 //BA.debugLineNum = 8454145;BA.debugLine="lv.Initializer(\"LV_news\").ListView.Horizontal.RTL";
__ref._lv /*wir.hitex.recycler.Hitex_LayoutView*/ .Initializer(ba,"LV_news").ListView().Horizontal().RTL().Build();
RDebugUtils.currentLine=8454147;
 //BA.debugLineNum = 8454147;BA.debugLine="lstnews1=lst";
__ref._lstnews1 /*anywheresoftware.b4a.objects.collections.List*/  = _lst;
RDebugUtils.currentLine=8454148;
 //BA.debugLineNum = 8454148;BA.debugLine="parent.AddView(lv,0,top,100%x,73%x)";
_parent.AddView((android.view.View)(__ref._lv /*wir.hitex.recycler.Hitex_LayoutView*/ .getObject()),(int) (0),_top,__c.PerXToCurrent((float) (100),ba),__c.PerXToCurrent((float) (73),ba));
RDebugUtils.currentLine=8454150;
 //BA.debugLineNum = 8454150;BA.debugLine="lv.Show";
__ref._lv /*wir.hitex.recycler.Hitex_LayoutView*/ .Show();
RDebugUtils.currentLine=8454151;
 //BA.debugLineNum = 8454151;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.example.creatlv __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="creatlv";
RDebugUtils.currentLine=8388608;
 //BA.debugLineNum = 8388608;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=8388609;
 //BA.debugLineNum = 8388609;BA.debugLine="Dim lv As Hitex_LayoutView";
_lv = new wir.hitex.recycler.Hitex_LayoutView();
RDebugUtils.currentLine=8388610;
 //BA.debugLineNum = 8388610;BA.debugLine="Dim lstnews1 As List";
_lstnews1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=8388611;
 //BA.debugLineNum = 8388611;BA.debugLine="End Sub";
return "";
}
public int  _lv_news_getitemcount(b4a.example.creatlv __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="creatlv";
if (Debug.shouldDelegate(ba, "lv_news_getitemcount", false))
	 {return ((Integer) Debug.delegate(ba, "lv_news_getitemcount", null));}
RDebugUtils.currentLine=8650752;
 //BA.debugLineNum = 8650752;BA.debugLine="Sub LV_news_GetItemCount As Int 								        '�";
RDebugUtils.currentLine=8650753;
 //BA.debugLineNum = 8650753;BA.debugLine="Return lstnews1.Size '/ItemList.Size";
if (true) return __ref._lstnews1 /*anywheresoftware.b4a.objects.collections.List*/ .getSize();
RDebugUtils.currentLine=8650755;
 //BA.debugLineNum = 8650755;BA.debugLine="End Sub";
return 0;
}
public String  _lv_news_itemclick(b4a.example.creatlv __ref,anywheresoftware.b4a.objects.PanelWrapper _clickeditem,int _position) throws Exception{
__ref = this;
RDebugUtils.currentModule="creatlv";
if (Debug.shouldDelegate(ba, "lv_news_itemclick", false))
	 {return ((String) Debug.delegate(ba, "lv_news_itemclick", new Object[] {_clickeditem,_position}));}
RDebugUtils.currentLine=8716288;
 //BA.debugLineNum = 8716288;BA.debugLine="Sub LV_news_ItemClick (ClickedItem As Panel, Posit";
RDebugUtils.currentLine=8716296;
 //BA.debugLineNum = 8716296;BA.debugLine="End Sub";
return "";
}
public String  _lv_news_onbindviewholder(b4a.example.creatlv __ref,anywheresoftware.b4a.objects.PanelWrapper _parent,int _position) throws Exception{
__ref = this;
RDebugUtils.currentModule="creatlv";
if (Debug.shouldDelegate(ba, "lv_news_onbindviewholder", false))
	 {return ((String) Debug.delegate(ba, "lv_news_onbindviewholder", new Object[] {_parent,_position}));}
anywheresoftware.b4a.objects.PanelWrapper _p1 = null;
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.ImageViewWrapper _img = null;
com.hitex_glide.Hitex_Glide _glide = null;
String[] _h13 = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
RDebugUtils.currentLine=8585216;
 //BA.debugLineNum = 8585216;BA.debugLine="Sub LV_news_onBindViewHolder (Parent As Panel, Pos";
RDebugUtils.currentLine=8585217;
 //BA.debugLineNum = 8585217;BA.debugLine="Dim p1 As Panel = Parent.GetView(0)";
_p1 = new anywheresoftware.b4a.objects.PanelWrapper();
_p1.setObject((android.view.ViewGroup)(_parent.GetView((int) (0)).getObject()));
RDebugUtils.currentLine=8585218;
 //BA.debugLineNum = 8585218;BA.debugLine="Dim p As Panel = p1.GetView(0)";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
_p.setObject((android.view.ViewGroup)(_p1.GetView((int) (0)).getObject()));
RDebugUtils.currentLine=8585219;
 //BA.debugLineNum = 8585219;BA.debugLine="Dim img As ImageView = p.GetView(0)";
_img = new anywheresoftware.b4a.objects.ImageViewWrapper();
_img.setObject((android.widget.ImageView)(_p.GetView((int) (0)).getObject()));
RDebugUtils.currentLine=8585220;
 //BA.debugLineNum = 8585220;BA.debugLine="Dim Glide As Hitex_Glide";
_glide = new com.hitex_glide.Hitex_Glide();
RDebugUtils.currentLine=8585221;
 //BA.debugLineNum = 8585221;BA.debugLine="Dim h13() As String=Regex.Split(\"#\",lstnews1.Get(";
_h13 = __c.Regex.Split("#",BA.ObjectToString(__ref._lstnews1 /*anywheresoftware.b4a.objects.collections.List*/ .Get(_position)));
RDebugUtils.currentLine=8585222;
 //BA.debugLineNum = 8585222;BA.debugLine="Glide.Load2(h13(0)).CenterCrop.Into(img)";
_glide.Load2(ba,_h13[(int) (0)]).CenterCrop().Into(_img);
RDebugUtils.currentLine=8585224;
 //BA.debugLineNum = 8585224;BA.debugLine="Dim lbl As Label = p.GetView(1)";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl.setObject((android.widget.TextView)(_p.GetView((int) (1)).getObject()));
RDebugUtils.currentLine=8585225;
 //BA.debugLineNum = 8585225;BA.debugLine="lbl.Text=h13(2)";
_lbl.setText(BA.ObjectToCharSequence(_h13[(int) (2)]));
RDebugUtils.currentLine=8585227;
 //BA.debugLineNum = 8585227;BA.debugLine="Dim lbl As Label = p.GetView(2)";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl.setObject((android.widget.TextView)(_p.GetView((int) (2)).getObject()));
RDebugUtils.currentLine=8585228;
 //BA.debugLineNum = 8585228;BA.debugLine="lbl.Text=h13(4)&\" تومان \"";
_lbl.setText(BA.ObjectToCharSequence(_h13[(int) (4)]+" تومان "));
RDebugUtils.currentLine=8585230;
 //BA.debugLineNum = 8585230;BA.debugLine="Dim lbl As Label = p.GetView(3)";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl.setObject((android.widget.TextView)(_p.GetView((int) (3)).getObject()));
RDebugUtils.currentLine=8585231;
 //BA.debugLineNum = 8585231;BA.debugLine="If h13(3)<>h13(4) Then";
if ((_h13[(int) (3)]).equals(_h13[(int) (4)]) == false) { 
RDebugUtils.currentLine=8585232;
 //BA.debugLineNum = 8585232;BA.debugLine="lbl.Text=whoops_text(h13(3)&\" تومان \")";
_lbl.setText(BA.ObjectToCharSequence(__ref._whoops_text /*Object*/ (null,_h13[(int) (3)]+" تومان ")));
 }else {
RDebugUtils.currentLine=8585234;
 //BA.debugLineNum = 8585234;BA.debugLine="lbl.Text=\"\"";
_lbl.setText(BA.ObjectToCharSequence(""));
 };
RDebugUtils.currentLine=8585241;
 //BA.debugLineNum = 8585241;BA.debugLine="If Position=0 Then";
if (_position==0) { 
RDebugUtils.currentLine=8585242;
 //BA.debugLineNum = 8585242;BA.debugLine="Parent.Width=48%x";
_parent.setWidth(__c.PerXToCurrent((float) (48),ba));
 }else {
RDebugUtils.currentLine=8585244;
 //BA.debugLineNum = 8585244;BA.debugLine="Parent.Width=47%x";
_parent.setWidth(__c.PerXToCurrent((float) (47),ba));
 };
RDebugUtils.currentLine=8585247;
 //BA.debugLineNum = 8585247;BA.debugLine="Parent.Height=75%x";
_parent.setHeight(__c.PerXToCurrent((float) (75),ba));
RDebugUtils.currentLine=8585248;
 //BA.debugLineNum = 8585248;BA.debugLine="End Sub";
return "";
}
public Object  _whoops_text(b4a.example.creatlv __ref,String _text) throws Exception{
__ref = this;
RDebugUtils.currentModule="creatlv";
if (Debug.shouldDelegate(ba, "whoops_text", false))
	 {return ((Object) Debug.delegate(ba, "whoops_text", new Object[] {_text}));}
anywheresoftware.b4a.objects.CSBuilder _cs = null;
RDebugUtils.currentLine=8781824;
 //BA.debugLineNum = 8781824;BA.debugLine="Sub whoops_text(text As String) As Object";
RDebugUtils.currentLine=8781825;
 //BA.debugLineNum = 8781825;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
RDebugUtils.currentLine=8781826;
 //BA.debugLineNum = 8781826;BA.debugLine="cs.Initialize";
_cs.Initialize();
RDebugUtils.currentLine=8781827;
 //BA.debugLineNum = 8781827;BA.debugLine="cs.Strikethrough.Append(text).Pop.PopAll";
_cs.Strikethrough().Append(BA.ObjectToCharSequence(_text)).Pop().PopAll();
RDebugUtils.currentLine=8781828;
 //BA.debugLineNum = 8781828;BA.debugLine="Return  cs";
if (true) return (Object)(_cs.getObject());
RDebugUtils.currentLine=8781829;
 //BA.debugLineNum = 8781829;BA.debugLine="End Sub";
return null;
}
public String  _lv_news_oncreateviewholder(b4a.example.creatlv __ref,anywheresoftware.b4a.objects.PanelWrapper _parent,int _viewtype) throws Exception{
__ref = this;
RDebugUtils.currentModule="creatlv";
if (Debug.shouldDelegate(ba, "lv_news_oncreateviewholder", false))
	 {return ((String) Debug.delegate(ba, "lv_news_oncreateviewholder", new Object[] {_parent,_viewtype}));}
de.amberhome.objects.CardViewWrapper _card = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlk = null;
anywheresoftware.b4a.objects.ImageViewWrapper _img = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl2 = null;
anywheresoftware.b4a.objects.LabelWrapper _pnl = null;
RDebugUtils.currentLine=8519680;
 //BA.debugLineNum = 8519680;BA.debugLine="Sub LV_news_onCreateViewHolder (Parent As Panel, V";
RDebugUtils.currentLine=8519682;
 //BA.debugLineNum = 8519682;BA.debugLine="Dim card As CardView";
_card = new de.amberhome.objects.CardViewWrapper();
RDebugUtils.currentLine=8519683;
 //BA.debugLineNum = 8519683;BA.debugLine="card.Initialize(\"\")";
_card.Initialize(ba,"");
RDebugUtils.currentLine=8519684;
 //BA.debugLineNum = 8519684;BA.debugLine="card.Elevation=2dip";
_card.setElevation((float) (__c.DipToCurrent((int) (2))));
RDebugUtils.currentLine=8519685;
 //BA.debugLineNum = 8519685;BA.debugLine="card.CornerRadius=2dip";
_card.setCornerRadius((float) (__c.DipToCurrent((int) (2))));
RDebugUtils.currentLine=8519686;
 //BA.debugLineNum = 8519686;BA.debugLine="Parent.AddView(card,1%x,1%x,44%x,71%x)";
_parent.AddView((android.view.View)(_card.getObject()),__c.PerXToCurrent((float) (1),ba),__c.PerXToCurrent((float) (1),ba),__c.PerXToCurrent((float) (44),ba),__c.PerXToCurrent((float) (71),ba));
RDebugUtils.currentLine=8519688;
 //BA.debugLineNum = 8519688;BA.debugLine="Dim pnlk As Panel";
_pnlk = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=8519689;
 //BA.debugLineNum = 8519689;BA.debugLine="pnlk.Initialize(\"\")";
_pnlk.Initialize(ba,"");
RDebugUtils.currentLine=8519690;
 //BA.debugLineNum = 8519690;BA.debugLine="card.AddView(pnlk,0,0,-1,-1)";
_card.AddView((android.view.View)(_pnlk.getObject()),(int) (0),(int) (0),(int) (-1),(int) (-1));
RDebugUtils.currentLine=8519692;
 //BA.debugLineNum = 8519692;BA.debugLine="Dim img As ImageView";
_img = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=8519693;
 //BA.debugLineNum = 8519693;BA.debugLine="img.Initialize(\"\")";
_img.Initialize(ba,"");
RDebugUtils.currentLine=8519694;
 //BA.debugLineNum = 8519694;BA.debugLine="pnlk.AddView(img,0,0,-1,36%x)";
_pnlk.AddView((android.view.View)(_img.getObject()),(int) (0),(int) (0),(int) (-1),__c.PerXToCurrent((float) (36),ba));
RDebugUtils.currentLine=8519696;
 //BA.debugLineNum = 8519696;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=8519697;
 //BA.debugLineNum = 8519697;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(ba,"");
RDebugUtils.currentLine=8519698;
 //BA.debugLineNum = 8519698;BA.debugLine="lbl.Color=Colors.White";
_lbl.setColor(__c.Colors.White);
RDebugUtils.currentLine=8519699;
 //BA.debugLineNum = 8519699;BA.debugLine="lbl.Gravity=Gravity.RIGHT";
_lbl.setGravity(__c.Gravity.RIGHT);
RDebugUtils.currentLine=8519700;
 //BA.debugLineNum = 8519700;BA.debugLine="lbl.Typeface=C.irs";
_lbl.setTypeface((android.graphics.Typeface)(_c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ .getObject()));
RDebugUtils.currentLine=8519702;
 //BA.debugLineNum = 8519702;BA.debugLine="lbl.TextSize=14";
_lbl.setTextSize((float) (14));
RDebugUtils.currentLine=8519704;
 //BA.debugLineNum = 8519704;BA.debugLine="lbl.Padding = Array As Int (10dip, 0, 10dip, 0)";
_lbl.setPadding(new int[]{__c.DipToCurrent((int) (10)),(int) (0),__c.DipToCurrent((int) (10)),(int) (0)});
RDebugUtils.currentLine=8519705;
 //BA.debugLineNum = 8519705;BA.debugLine="pnlk.AddView(lbl,0,40%x,44%x,14%x)";
_pnlk.AddView((android.view.View)(_lbl.getObject()),(int) (0),__c.PerXToCurrent((float) (40),ba),__c.PerXToCurrent((float) (44),ba),__c.PerXToCurrent((float) (14),ba));
RDebugUtils.currentLine=8519707;
 //BA.debugLineNum = 8519707;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=8519708;
 //BA.debugLineNum = 8519708;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(ba,"");
RDebugUtils.currentLine=8519709;
 //BA.debugLineNum = 8519709;BA.debugLine="lbl.Color=Colors.White";
_lbl.setColor(__c.Colors.White);
RDebugUtils.currentLine=8519710;
 //BA.debugLineNum = 8519710;BA.debugLine="lbl.Gravity=Gravity.LEFT";
_lbl.setGravity(__c.Gravity.LEFT);
RDebugUtils.currentLine=8519711;
 //BA.debugLineNum = 8519711;BA.debugLine="lbl.Typeface=C.irs";
_lbl.setTypeface((android.graphics.Typeface)(_c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ .getObject()));
RDebugUtils.currentLine=8519712;
 //BA.debugLineNum = 8519712;BA.debugLine="lbl.SingleLine=True";
_lbl.setSingleLine(__c.True);
RDebugUtils.currentLine=8519713;
 //BA.debugLineNum = 8519713;BA.debugLine="lbl.Padding = Array As Int (10dip, 0, 10dip, 0)";
_lbl.setPadding(new int[]{__c.DipToCurrent((int) (10)),(int) (0),__c.DipToCurrent((int) (10)),(int) (0)});
RDebugUtils.currentLine=8519714;
 //BA.debugLineNum = 8519714;BA.debugLine="lbl.Ellipsize=\"END\"";
_lbl.setEllipsize("END");
RDebugUtils.currentLine=8519715;
 //BA.debugLineNum = 8519715;BA.debugLine="lbl.TextSize=14";
_lbl.setTextSize((float) (14));
RDebugUtils.currentLine=8519716;
 //BA.debugLineNum = 8519716;BA.debugLine="pnlk.AddView(lbl,0,63%x,44%x,10%x)";
_pnlk.AddView((android.view.View)(_lbl.getObject()),(int) (0),__c.PerXToCurrent((float) (63),ba),__c.PerXToCurrent((float) (44),ba),__c.PerXToCurrent((float) (10),ba));
RDebugUtils.currentLine=8519717;
 //BA.debugLineNum = 8519717;BA.debugLine="lbl.Text=\"2000 تومان\"";
_lbl.setText(BA.ObjectToCharSequence("2000 تومان"));
RDebugUtils.currentLine=8519718;
 //BA.debugLineNum = 8519718;BA.debugLine="lbl.TextColor=0xFF006400";
_lbl.setTextColor((int) (0xff006400));
RDebugUtils.currentLine=8519720;
 //BA.debugLineNum = 8519720;BA.debugLine="Dim lbl2 As Label";
_lbl2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=8519721;
 //BA.debugLineNum = 8519721;BA.debugLine="lbl2.Initialize(\"\")";
_lbl2.Initialize(ba,"");
RDebugUtils.currentLine=8519722;
 //BA.debugLineNum = 8519722;BA.debugLine="lbl2.Color=Colors.Transparent";
_lbl2.setColor(__c.Colors.Transparent);
RDebugUtils.currentLine=8519723;
 //BA.debugLineNum = 8519723;BA.debugLine="lbl2.Gravity=Gravity.LEFT";
_lbl2.setGravity(__c.Gravity.LEFT);
RDebugUtils.currentLine=8519724;
 //BA.debugLineNum = 8519724;BA.debugLine="lbl2.Typeface=C.irs";
_lbl2.setTypeface((android.graphics.Typeface)(_c._irs /*anywheresoftware.b4a.keywords.constants.TypefaceWrapper*/ .getObject()));
RDebugUtils.currentLine=8519725;
 //BA.debugLineNum = 8519725;BA.debugLine="lbl2.SingleLine=True";
_lbl2.setSingleLine(__c.True);
RDebugUtils.currentLine=8519726;
 //BA.debugLineNum = 8519726;BA.debugLine="lbl2.Padding = Array As Int (10dip, 0, 10dip, 0)";
_lbl2.setPadding(new int[]{__c.DipToCurrent((int) (10)),(int) (0),__c.DipToCurrent((int) (10)),(int) (0)});
RDebugUtils.currentLine=8519727;
 //BA.debugLineNum = 8519727;BA.debugLine="lbl2.Ellipsize=\"END\"";
_lbl2.setEllipsize("END");
RDebugUtils.currentLine=8519728;
 //BA.debugLineNum = 8519728;BA.debugLine="lbl2.TextSize=12";
_lbl2.setTextSize((float) (12));
RDebugUtils.currentLine=8519730;
 //BA.debugLineNum = 8519730;BA.debugLine="pnlk.AddView(lbl2,0,58%x,44%x,10%x)";
_pnlk.AddView((android.view.View)(_lbl2.getObject()),(int) (0),__c.PerXToCurrent((float) (58),ba),__c.PerXToCurrent((float) (44),ba),__c.PerXToCurrent((float) (10),ba));
RDebugUtils.currentLine=8519731;
 //BA.debugLineNum = 8519731;BA.debugLine="lbl2.Text=\"قیمت:\"";
_lbl2.setText(BA.ObjectToCharSequence("قیمت:"));
RDebugUtils.currentLine=8519732;
 //BA.debugLineNum = 8519732;BA.debugLine="lbl2.TextColor=0xFF9A0000";
_lbl2.setTextColor((int) (0xff9a0000));
RDebugUtils.currentLine=8519734;
 //BA.debugLineNum = 8519734;BA.debugLine="Dim pnl As Label";
_pnl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=8519735;
 //BA.debugLineNum = 8519735;BA.debugLine="pnl.Initialize(\"\")";
_pnl.Initialize(ba,"");
RDebugUtils.currentLine=8519736;
 //BA.debugLineNum = 8519736;BA.debugLine="pnlk.AddView(pnl,0,55%x,100%x,1dip)";
_pnlk.AddView((android.view.View)(_pnl.getObject()),(int) (0),__c.PerXToCurrent((float) (55),ba),__c.PerXToCurrent((float) (100),ba),__c.DipToCurrent((int) (1)));
RDebugUtils.currentLine=8519737;
 //BA.debugLineNum = 8519737;BA.debugLine="pnl.Color=0xFFE5E5E5";
_pnl.setColor((int) (0xffe5e5e5));
RDebugUtils.currentLine=8519738;
 //BA.debugLineNum = 8519738;BA.debugLine="End Sub";
return "";
}
}