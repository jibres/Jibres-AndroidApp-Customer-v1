
package b4a.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class fingerprintmanager {
    public static RemoteObject myClass;
	public fingerprintmanager() {
	}
    public static PCBA staticBA = new PCBA(null, fingerprintmanager.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _sensor = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
public static RemoteObject _cancelobject = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
public static RemoteObject _mtarget = RemoteObject.declareNull("Object");
public static RemoteObject _meventname = RemoteObject.createImmutable("");
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
		return new Object[] {"cancelObject",_ref.getField(false, "_cancelobject"),"mEventName",_ref.getField(false, "_meventname"),"mTarget",_ref.getField(false, "_mtarget"),"sensor",_ref.getField(false, "_sensor")};
}
}