package infobite.technology.info.eganacsi.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONObject;

import infobite.technology.info.eganacsi.R;
import infobite.technology.info.eganacsi.util.ConnectionDetector;
import infobite.technology.info.eganacsi.util.SessionManager;
import infobite.technology.info.eganacsi.util.Utility;
import infobite.technology.info.eganacsi.util.WebApi;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Context ctx;
    Button login_bt;
    EditText email_et,password_et;
    TextView newuser_tv,forgot_tv,privacy_tv,terms_tv;
    CheckBox remenber_cb;
    ImageView facebook_iv,gplus_iv;

    SessionManager sessionManager;
    ConnectionDetector connectionDetector;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initxml();
        initObj();
    }

    private void initObj() {
        sessionManager = new SessionManager(ctx);
        connectionDetector = new ConnectionDetector();
    }

    private void initxml() {
        ctx = this;
        login_bt = (Button)findViewById(R.id.bt_login_login);
        newuser_tv = (TextView) findViewById(R.id.tv_login_newuser);
        forgot_tv = (TextView) findViewById(R.id.tv_login_fogot);
        privacy_tv = (TextView) findViewById(R.id.tv_login_privacy);
        terms_tv = (TextView) findViewById(R.id.tv_login_terms);
        remenber_cb = (CheckBox ) findViewById(R.id.cb_login_remember);
        facebook_iv = (ImageView ) findViewById(R.id.iv_login_facebook);
        gplus_iv = (ImageView ) findViewById(R.id.iv_login_facebook);
        email_et = (EditText ) findViewById(R.id.et_login_email);
        password_et = (EditText ) findViewById(R.id.et_login_password);
        login_bt.setOnClickListener(this);
        newuser_tv.setOnClickListener(this);
        forgot_tv.setOnClickListener(this);
        privacy_tv.setOnClickListener(this);
        terms_tv.setOnClickListener(this);
        facebook_iv.setOnClickListener(this);
        gplus_iv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.bt_login_login:
                boolean internet = connectionDetector.isConnected();
                if (internet){
                    getData();
                }else {
                    Utility.toastView(ctx,ctx.getString(R.string.no_internet));
                }
                break;

            case R.id.tv_login_newuser:
                startActivity(new Intent(ctx,RegisterActivity.class));
                break;

            case R.id.tv_login_fogot:
                break;

            case R.id.tv_login_privacy:
                break;

            case R.id.tv_login_terms:
                break;

            case R.id.iv_login_facebook:
                break;

            case R.id.iv_login_gplus:
                break;
        }
    }

    private void getData() {

        String email = email_et.getText().toString();
        String password = password_et.getText().toString();

        if (email.equals("")||password.equals("")){
            Utility.toastView(ctx,"Enter Username and password");
        }else if (!email.matches(emailPattern)){
            Utility.toastView(ctx,"Invalid Username");
        }else {
            getLogin(email,password);
        }
    }

    private void getLogin(String email, String password) {

        AndroidNetworking.post(WebApi.URL_LOGIN)
                .addBodyParameter("email", email)
                .addBodyParameter("password", password)
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error
                    }
                });
    }
}
