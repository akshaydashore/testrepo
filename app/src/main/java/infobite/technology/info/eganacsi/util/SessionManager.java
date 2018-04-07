package infobite.technology.info.eganacsi.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

import infobite.technology.info.eganacsi.activity.LoginActivity;
import infobite.technology.info.eganacsi.activity.MainActivity;


/**
 * Created by kamlesh on 11/25/2017.
 */
public class SessionManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context ctx;

    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "sessionmanager";
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_FNAME = "fname";
    public static final String KEY_LNAME = "lname";
    public static final String KEY_MOBILE = "mobile";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_CITY = "city";
    public static final String KEY_STATE = "state";
    public static final String KEY_COUNTRY = "country";
    public static final String KEY_PINCODE = "pincode";
    public static final String KEY_ADDRESS = "address";

    public static final String KEY_ORDER_DATA = "order";
    public static final String KEY_BILLING_DATA = "billling";

    public SessionManager(Context context) {
        this.ctx = context;
        pref = ctx.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String fname, String lname,String mobile,String email,String city,String pincode,String address) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_FNAME, fname);
        editor.putString(KEY_LNAME, lname);
        editor.putString(KEY_MOBILE, mobile);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_CITY, city);
        editor.putString(KEY_PINCODE, pincode);
        editor.putString(KEY_ADDRESS, address);
        editor.commit();
    }

    public void setData(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public void checkLogin() {
        if (!this.isLoggedIn()) {
            Intent i = new Intent(ctx, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ctx.startActivity(i);
        }
    }

    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_FNAME, pref.getString(KEY_FNAME, null));
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        return user;
    }

    public void logoutUser() {
        editor.clear();
        editor.commit();
        Intent i = new Intent(ctx, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ctx.startActivity(i);
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }

    public String getData(String key) {
        return pref.getString(key, null);
    }
}
