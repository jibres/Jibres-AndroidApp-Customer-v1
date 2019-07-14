package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_matlab1{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[matlab1/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 3;BA.debugLine="ACToolBarLight1.Height=56dip"[matlab1/General script]
views.get("actoolbarlight1").vw.setHeight((int)((56d * scale)));
//BA.debugLineNum = 4;BA.debugLine="toolbartemp.Height=56dip"[matlab1/General script]
views.get("toolbartemp").vw.setHeight((int)((56d * scale)));
//BA.debugLineNum = 5;BA.debugLine="Img.Width=100%x"[matlab1/General script]
views.get("img").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 6;BA.debugLine="Paneldark.Width=100%x"[matlab1/General script]
views.get("paneldark").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 7;BA.debugLine="Paneldark.Left=0"[matlab1/General script]
views.get("paneldark").vw.setLeft((int)(0d));
//BA.debugLineNum = 8;BA.debugLine="Img.Left=0"[matlab1/General script]
views.get("img").vw.setLeft((int)(0d));
//BA.debugLineNum = 9;BA.debugLine="ScrollView1.Left=0"[matlab1/General script]
views.get("scrollview1").vw.setLeft((int)(0d));
//BA.debugLineNum = 10;BA.debugLine="Paneldark.Width=100%x"[matlab1/General script]
views.get("paneldark").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 11;BA.debugLine="ScrollView1.Width=100%x"[matlab1/General script]
views.get("scrollview1").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 12;BA.debugLine="ScrollView1.SetTopAndBottom(0,100%y)"[matlab1/General script]
views.get("scrollview1").vw.setTop((int)(0d));
views.get("scrollview1").vw.setHeight((int)((100d / 100 * height) - (0d)));
//BA.debugLineNum = 13;BA.debugLine="Img.SetTopAndBottom(0,73%x)"[matlab1/General script]
views.get("img").vw.setTop((int)(0d));
views.get("img").vw.setHeight((int)((73d / 100 * width) - (0d)));
//BA.debugLineNum = 14;BA.debugLine="Paneldark.SetTopAndBottom(0,70%x)"[matlab1/General script]
views.get("paneldark").vw.setTop((int)(0d));
views.get("paneldark").vw.setHeight((int)((70d / 100 * width) - (0d)));
//BA.debugLineNum = 16;BA.debugLine="ProgressBar1.Width=10%x"[matlab1/General script]
views.get("progressbar1").vw.setWidth((int)((10d / 100 * width)));
//BA.debugLineNum = 17;BA.debugLine="ProgressBar1.Height=10%x"[matlab1/General script]
views.get("progressbar1").vw.setHeight((int)((10d / 100 * width)));
//BA.debugLineNum = 18;BA.debugLine="ProgressBar1.HorizontalCenter=50%x"[matlab1/General script]
views.get("progressbar1").vw.setLeft((int)((50d / 100 * width) - (views.get("progressbar1").vw.getWidth() / 2)));
//BA.debugLineNum = 19;BA.debugLine="ProgressBar1.VerticalCenter=Img.Height/2"[matlab1/General script]
views.get("progressbar1").vw.setTop((int)((views.get("img").vw.getHeight())/2d - (views.get("progressbar1").vw.getHeight() / 2)));
//BA.debugLineNum = 21;BA.debugLine="Panel1.SetTopAndBottom(0,90%x)"[matlab1/General script]
views.get("panel1").vw.setTop((int)(0d));
views.get("panel1").vw.setHeight((int)((90d / 100 * width) - (0d)));
//BA.debugLineNum = 22;BA.debugLine="flot3.Width=15.5%x"[matlab1/General script]
views.get("flot3").vw.setWidth((int)((15.5d / 100 * width)));
//BA.debugLineNum = 23;BA.debugLine="flot3.Height=15.5%x"[matlab1/General script]
views.get("flot3").vw.setHeight((int)((15.5d / 100 * width)));
//BA.debugLineNum = 24;BA.debugLine="flot3.Top=100%y-26%x"[matlab1/General script]
views.get("flot3").vw.setTop((int)((100d / 100 * height)-(26d / 100 * width)));
//BA.debugLineNum = 26;BA.debugLine="flot4.Width=15.5%x"[matlab1/General script]
views.get("flot4").vw.setWidth((int)((15.5d / 100 * width)));
//BA.debugLineNum = 27;BA.debugLine="flot4.Height=15.5%x"[matlab1/General script]
views.get("flot4").vw.setHeight((int)((15.5d / 100 * width)));

}
}