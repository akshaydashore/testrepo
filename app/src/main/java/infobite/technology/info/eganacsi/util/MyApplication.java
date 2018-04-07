package infobite.technology.info.eganacsi.util;

import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
 * Created by kamlesh on 11/9/2017.
 */
public class MyApplication extends MultiDexApplication
{
    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        MultiDex.install(this);
    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    public void setConnectivityListener(ConnectionDetector.ConnectivityReceiverListener listener) {
        ConnectionDetector.connectivityReceiverListener = listener;
    }
}
