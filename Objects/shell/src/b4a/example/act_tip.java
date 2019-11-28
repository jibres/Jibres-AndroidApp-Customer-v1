
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

public class act_tip implements IRemote{
	public static act_tip mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public act_tip() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("act_tip"), "b4a.example.act_tip");
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
		pcBA = new PCBA(this, act_tip.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _vp = RemoteObject.declareNull("de.amberhome.viewpager.AHViewPager");
public static RemoteObject _pc = RemoteObject.declareNull("de.amberhome.viewpager.AHPageContainer");
public static RemoteObject _panel = null;
public static RemoteObject _pnlnonet = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lblnext = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblprew = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblbol = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static b4a.example.main _main = null;
public static b4a.example.login _login = null;
public static b4a.example.verify _verify = null;
public static b4a.example.home _home = null;
public static b4a.example.c _c = null;
public static b4a.example.starter _starter = null;
public static b4a.example.page _page = null;
public static b4a.example.finger _finger = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",act_tip.mostCurrent._activity,"C",Debug.moduleToString(b4a.example.c.class),"finger",Debug.moduleToString(b4a.example.finger.class),"Home",Debug.moduleToString(b4a.example.home.class),"lblbol",act_tip.mostCurrent._lblbol,"lblnext",act_tip.mostCurrent._lblnext,"lblprew",act_tip.mostCurrent._lblprew,"login",Debug.moduleToString(b4a.example.login.class),"Main",Debug.moduleToString(b4a.example.main.class),"page",Debug.moduleToString(b4a.example.page.class),"Panel",act_tip.mostCurrent._panel,"PC",act_tip.mostCurrent._pc,"pnlnonet",act_tip.mostCurrent._pnlnonet,"Starter",Debug.moduleToString(b4a.example.starter.class),"verify",Debug.moduleToString(b4a.example.verify.class),"VP",act_tip.mostCurrent._vp};
}
}