package infobite.technology.info.eganacsi;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

/**
 * Created by Admin on 05-Apr-18.
 */

public class MyApplication  extends Application{


    @Override
    public void onCreate() {
        super.onCreate();

        AndroidNetworking.initialize(getApplicationContext());

    }
}
