
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

public class verify implements IRemote{
	public static verify mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public verify() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("verify"), "b4a.example.verify");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, verify.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _ac = RemoteObject.declareNull("de.amberhome.objects.appcompat.ACEditTextWrapper");
public static RemoteObject _lbl1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static b4a.example.main _main = null;
public static b4a.example.act_tip _act_tip = null;
public static b4a.example.login _login = null;
public static b4a.example.home _home = null;
public static b4a.example.c _c = null;
public static b4a.example.starter _starter = null;
public static b4a.example.page _page = null;
public static b4a.example.finger _finger = null;
  public Object[] GetGlobals() {
		return new Object[] {"ac",verify.mostCurrent._ac,"act_tip",Debug.moduleToString(b4a.example.act_tip.class),"Activity",verify.mostCurrent._activity,"C",Debug.moduleToString(b4a.example.c.class),"finger",Debug.moduleToString(b4a.example.finger.class),"Home",Debug.moduleToString(b4a.example.home.class),"lbl1",verify.mostCurrent._lbl1,"lbl2",verify.mostCurrent._lbl2,"lbl3",verify.mostCurrent._lbl3,"lbl4",verify.mostCurrent._lbl4,"login",Debug.moduleToString(b4a.example.login.class),"Main",Debug.moduleToString(b4a.example.main.class),"page",Debug.moduleToString(b4a.example.page.class),"Starter",Debug.moduleToString(b4a.example.starter.class)};
}
}