
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

public class home implements IRemote{
	public static home mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public home() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("home"), "b4a.example.home");
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
		pcBA = new PCBA(this, home.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _t_shegeft = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _lblbsk = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _sv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _pb = RemoteObject.declareNull("com.porya.pagerbullet.PagerBulletWrapper");
public static RemoteObject _pa = RemoteObject.declareNull("com.porya.pagerbullet.PagerBulletAdapter");
public static RemoteObject _lblho = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblmin = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblsecend = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _time313 = RemoteObject.createImmutable(0L);
public static RemoteObject _lbltitletop = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lv_prod = null;
public static b4a.example.main _main = null;
public static b4a.example.act_tip _act_tip = null;
public static b4a.example.login _login = null;
public static b4a.example.verify _verify = null;
public static b4a.example.c _c = null;
public static b4a.example.starter _starter = null;
public static b4a.example.page _page = null;
public static b4a.example.finger _finger = null;
  public Object[] GetGlobals() {
		return new Object[] {"act_tip",Debug.moduleToString(b4a.example.act_tip.class),"Activity",home.mostCurrent._activity,"C",Debug.moduleToString(b4a.example.c.class),"finger",Debug.moduleToString(b4a.example.finger.class),"lblbsk",home.mostCurrent._lblbsk,"lblho",home.mostCurrent._lblho,"lblmin",home.mostCurrent._lblmin,"lblsecend",home.mostCurrent._lblsecend,"lbltitletop",home.mostCurrent._lbltitletop,"login",Debug.moduleToString(b4a.example.login.class),"LV_prod",home.mostCurrent._lv_prod,"Main",Debug.moduleToString(b4a.example.main.class),"pa",home.mostCurrent._pa,"page",Debug.moduleToString(b4a.example.page.class),"pb",home.mostCurrent._pb,"Starter",Debug.moduleToString(b4a.example.starter.class),"sv",home.mostCurrent._sv,"t_shegeft",home._t_shegeft,"time313",home._time313,"verify",Debug.moduleToString(b4a.example.verify.class)};
}
}