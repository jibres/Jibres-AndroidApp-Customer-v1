
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class c implements IRemote{
	public static c mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public c() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, c.class);
    static {
		mostCurrent = new c();
        remoteMe = RemoteObject.declareNull("b4a.example.c");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("c"), "b4a.example.c");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("b4a.example.c"), new java.lang.ref.WeakReference<PCBA> (pcBA));
	}
   
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public PCBA create(Object[] args) throws ClassNotFoundException{
        throw new RuntimeException("CREATE is not supported.");
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _irs = RemoteObject.declareNull("anywheresoftware.b4a.keywords.constants.TypefaceWrapper");
public static RemoteObject _irsb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.constants.TypefaceWrapper");
public static RemoteObject _rcenter = RemoteObject.createImmutable(0);
public static RemoteObject _lcenter = RemoteObject.createImmutable(0);
public static RemoteObject _tcenter = RemoteObject.createImmutable(0);
public static RemoteObject _isnonetshow = RemoteObject.createImmutable(false);
public static RemoteObject _isnonetprimery = RemoteObject.createImmutable(false);
public static b4a.example.main _main = null;
public static b4a.example.act_tip _act_tip = null;
public static b4a.example.login _login = null;
public static b4a.example.verify _verify = null;
public static b4a.example.home _home = null;
public static b4a.example.starter _starter = null;
public static b4a.example.page _page = null;
public static b4a.example.finger _finger = null;
  public Object[] GetGlobals() {
		return new Object[] {"act_tip",Debug.moduleToString(b4a.example.act_tip.class),"finger",Debug.moduleToString(b4a.example.finger.class),"Home",Debug.moduleToString(b4a.example.home.class),"irs",c._irs,"irsb",c._irsb,"IsNoNetPrimery",c._isnonetprimery,"IsNoNetShow",c._isnonetshow,"lcenter",c._lcenter,"login",Debug.moduleToString(b4a.example.login.class),"Main",Debug.moduleToString(b4a.example.main.class),"page",Debug.moduleToString(b4a.example.page.class),"rcenter",c._rcenter,"Starter",Debug.moduleToString(b4a.example.starter.class),"tcenter",c._tcenter,"verify",Debug.moduleToString(b4a.example.verify.class)};
}
}