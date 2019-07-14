package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_matlab2{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("imageview1").vw.setTop((int)((63d / 100 * width)));
views.get("imageview1").vw.setWidth((int)((100d / 100 * width)));
views.get("imageview1").vw.setHeight((int)((22d / 100 * width)));
views.get("pnlmatlab").vw.setWidth((int)((100d / 100 * width)));
views.get("pnlmatlab").vw.setHeight((int)((2000d / 100 * height)));
views.get("pnlmatlab").vw.setTop((int)((views.get("imageview1").vw.getTop() + views.get("imageview1").vw.getHeight())-(2d * scale)));
views.get("pnlprb").vw.setWidth((int)((13d / 100 * width)));
views.get("pnlprb").vw.setHeight((int)((13d / 100 * width)));
views.get("pnlprb").vw.setTop((int)((70d / 100 * height) - (views.get("pnlprb").vw.getHeight() / 2)));
views.get("pnlprb").vw.setLeft((int)((50d / 100 * width) - (views.get("pnlprb").vw.getWidth() / 2)));
views.get("progressbar1").vw.setWidth((int)((11d / 100 * width)));
views.get("progressbar1").vw.setHeight((int)((11d / 100 * width)));
views.get("progressbar1").vw.setTop((int)((1d / 100 * width)));
views.get("progressbar1").vw.setLeft((int)((1d / 100 * width)));
views.get("label2").vw.setLeft((int)((5d / 100 * width)));
views.get("label2").vw.setWidth((int)((95d / 100 * width) - ((5d / 100 * width))));
views.get("label2").vw.setHeight((int)((20d / 100 * width)));
views.get("label2").vw.setTop((int)((views.get("pnlprb").vw.getTop())-(10d / 100 * width)));
views.get("label1").vw.setLeft((int)((5d / 100 * width)));
views.get("label1").vw.setWidth((int)((95d / 100 * width) - ((5d / 100 * width))));
views.get("label1").vw.setTop((int)((views.get("label2").vw.getTop() + views.get("label2").vw.getHeight())));
views.get("label1").vw.setHeight((int)((120d / 100 * height) - ((views.get("label2").vw.getTop() + views.get("label2").vw.getHeight()))));
views.get("flot").vw.setWidth((int)((18.5d / 100 * width)));
views.get("flot").vw.setHeight((int)((18.5d / 100 * width)));
//BA.debugLineNum = 29;BA.debugLine="flot.Top=ImageView1.Top-2%x"[matlab2/General script]
views.get("flot").vw.setTop((int)((views.get("imageview1").vw.getTop())-(2d / 100 * width)));
//BA.debugLineNum = 31;BA.debugLine="flot2.Width=18.5%x"[matlab2/General script]
views.get("flot2").vw.setWidth((int)((18.5d / 100 * width)));
//BA.debugLineNum = 32;BA.debugLine="flot2.Height=18.5%x"[matlab2/General script]
views.get("flot2").vw.setHeight((int)((18.5d / 100 * width)));

}
}