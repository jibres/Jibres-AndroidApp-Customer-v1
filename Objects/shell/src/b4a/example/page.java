
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

public class page implements IRemote{
	public static page mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public page() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("page"), "b4a.example.page");
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
		pcBA = new PCBA(this, page.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _picurl = RemoteObject.createImmutable("");
public static RemoteObject _videolink = RemoteObject.createImmutable("");
public static RemoteObject _isdowned = RemoteObject.createImmutable(false);
public static RemoteObject _postimg = RemoteObject.createImmutable("");
public static RemoteObject _soundurl = RemoteObject.createImmutable("");
public static RemoteObject _scrollview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _nazarat_lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _paneldark = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _actoolbarlight1 = RemoteObject.declareNull("de.amberhome.objects.appcompat.ACToolbarLightWrapper");
public static RemoteObject _img = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _toolbartemp = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _glide = RemoteObject.declareNull("com.hitex_glide.Hitex_Glide");
public static RemoteObject _lbltoolbar = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pnlmatlab = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _toptemp = RemoteObject.createImmutable(0);
public static RemoteObject _titelhaghttemp = RemoteObject.createImmutable(0);
public static RemoteObject _titletemp = RemoteObject.createImmutable(false);
public static RemoteObject _name = RemoteObject.createImmutable("");
public static RemoteObject _map = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _firstimg = RemoteObject.createImmutable("");
public static RemoteObject _pnlprb = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _progressbar1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ProgressBarWrapper");
public static RemoteObject _fsize = RemoteObject.createImmutable(0);
public static RemoteObject _foldername = RemoteObject.createImmutable("");
public static RemoteObject _canshare = RemoteObject.createImmutable(false);
public static RemoteObject _firstpicshow = RemoteObject.createImmutable(false);
public static RemoteObject _imglisnks = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _comment = RemoteObject.createImmutable("");
public static RemoteObject _downtost = RemoteObject.createImmutable(false);
public static RemoteObject _label1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _flot = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _flot2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _flot3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _flot4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _mpo = RemoteObject.declareNull("anywheresoftware.b4a.objects.MediaPlayerWrapper");
public static RemoteObject _lbldown = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblplay = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbldur = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblpos = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _seekbar = RemoteObject.declareNull("de.amberhome.objects.appcompat.ACSeekBarWrapper");
public static RemoteObject _ispus = RemoteObject.createImmutable(false);
public static RemoteObject _downmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _favmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _alltext = RemoteObject.createImmutable("");
public static RemoteObject _hlbl = RemoteObject.declareNull("b4a.example.heightlabel");
public static b4a.example.main _main = null;
public static b4a.example.act_tip _act_tip = null;
public static b4a.example.login _login = null;
public static b4a.example.verify _verify = null;
public static b4a.example.home _home = null;
public static b4a.example.c _c = null;
public static b4a.example.starter _starter = null;
public static b4a.example.finger _finger = null;
  public Object[] GetGlobals() {
		return new Object[] {"act_tip",Debug.moduleToString(b4a.example.act_tip.class),"Activity",page.mostCurrent._activity,"ACToolBarLight1",page.mostCurrent._actoolbarlight1,"alltext",page.mostCurrent._alltext,"C",Debug.moduleToString(b4a.example.c.class),"canshare",page._canshare,"comment",page.mostCurrent._comment,"downmap",page.mostCurrent._downmap,"downtost",page._downtost,"favmap",page.mostCurrent._favmap,"finger",Debug.moduleToString(b4a.example.finger.class),"firstimg",page.mostCurrent._firstimg,"firstpicshow",page._firstpicshow,"flot",page.mostCurrent._flot,"flot2",page.mostCurrent._flot2,"flot3",page.mostCurrent._flot3,"flot4",page.mostCurrent._flot4,"foldername",page.mostCurrent._foldername,"fsize",page._fsize,"Glide",page.mostCurrent._glide,"hlbl",page.mostCurrent._hlbl,"Home",Debug.moduleToString(b4a.example.home.class),"Img",page.mostCurrent._img,"imglisnks",page.mostCurrent._imglisnks,"isdowned",page._isdowned,"ispus",page._ispus,"Label1",page.mostCurrent._label1,"Label2",page.mostCurrent._label2,"lbldown",page.mostCurrent._lbldown,"lbldur",page.mostCurrent._lbldur,"lblplay",page.mostCurrent._lblplay,"lblpos",page.mostCurrent._lblpos,"lbltoolbar",page.mostCurrent._lbltoolbar,"login",Debug.moduleToString(b4a.example.login.class),"Main",Debug.moduleToString(b4a.example.main.class),"map",page.mostCurrent._map,"mpo",page.mostCurrent._mpo,"name",page.mostCurrent._name,"nazarat_lbl",page.mostCurrent._nazarat_lbl,"Paneldark",page.mostCurrent._paneldark,"picurl",page._picurl,"pnlmatlab",page.mostCurrent._pnlmatlab,"Pnlprb",page.mostCurrent._pnlprb,"postimg",page._postimg,"ProgressBar1",page.mostCurrent._progressbar1,"ScrollView1",page.mostCurrent._scrollview1,"seekbar",page.mostCurrent._seekbar,"soundurl",page.mostCurrent._soundurl,"Starter",Debug.moduleToString(b4a.example.starter.class),"titelhaghttemp",page._titelhaghttemp,"titletemp",page._titletemp,"toolbartemp",page.mostCurrent._toolbartemp,"toptemp",page._toptemp,"verify",Debug.moduleToString(b4a.example.verify.class),"videolink",page._videolink};
}
}