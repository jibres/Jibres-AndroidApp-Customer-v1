
package b4a.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class creatlv {
    public static RemoteObject myClass;
	public creatlv() {
	}
    public static PCBA staticBA = new PCBA(null, creatlv.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _lv = RemoteObject.declareNull("wir.hitex.recycler.Hitex_LayoutView");
public static RemoteObject _lstnews1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static b4a.example.main _main = null;
public static b4a.example.act_tip _act_tip = null;
public static b4a.example.login _login = null;
public static b4a.example.verify _verify = null;
public static b4a.example.home _home = null;
public static b4a.example.c _c = null;
public static b4a.example.starter _starter = null;
public static b4a.example.page _page = null;
public static b4a.example.finger _finger = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"lstnews1",_ref.getField(false, "_lstnews1"),"lv",_ref.getField(false, "_lv")};
}
}