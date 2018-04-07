package infobite.technology.info.eganacsi.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import infobite.technology.info.eganacsi.R;
import infobite.technology.info.eganacsi.util.ConnectionDetector;
import infobite.technology.info.eganacsi.util.Utility;
import infobite.technology.info.eganacsi.util.WebApi;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Context ctx;
    EditText fname_et,lname_et,email_et,moble_et,password_et,conf_password_et;
    Button signu_bt;
    ImageView facebook_iv,gplus_iv;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    ConnectionDetector connectionDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initXml();
        intObj();
    }

    private void intObj() {
        connectionDetector = new ConnectionDetector();
    }

    private void initXml() {
        ctx = this;
        fname_et = (EditText)findViewById(R.id.et_reg_fname);
        lname_et = (EditText)findViewById(R.id.et_reg_lname);
        email_et = (EditText)findViewById(R.id.et_reg_email);
        moble_et = (EditText)findViewById(R.id.et_reg_mobile);
        password_et = (EditText)findViewById(R.id.et_reg_password);
        conf_password_et = (EditText)findViewById(R.id.et_reg_conf_password);
        signu_bt = (Button) findViewById(R.id.bt_reg_signup);
        facebook_iv = (ImageView)findViewById(R.id.iv_reg_facebook);
        gplus_iv = (ImageView)findViewById(R.id.iv_reg_gplus);

        signu_bt.setOnClickListener(this);
        facebook_iv.setOnClickListener(this);
        gplus_iv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.iv_reg_facebook:
                break;

            case R.id.iv_reg_gplus:
                break;

            case R.id.bt_reg_signup:
                boolean internet = connectionDetector.isConnected();
                if (internet){
                    getData();
                }else {
                    Utility.toastView(ctx,ctx.getString(R.string.no_internet));
                }
                break;

        }
    }


    private void getData() {

        String fname = fname_et.getText().toString();
        String lname = lname_et.getText().toString();
        String mobile = moble_et.getText().toString();
        String email = email_et.getText().toString();
        String password = password_et.getText().toString();
        String con_password= conf_password_et.getText().toString();

        if (fname.equals("")||lname.equals("")||mobile.equals("")||email.equals("")||password.equals("")||con_password.equals("")){
            Utility.toastView(ctx,"Enter All Fields");
        }else if (!email.matches(emailPattern)){
            Utility.toastView(ctx,"Invalid Username");
        }else {
            getRegister(fname,lname,mobile,email,password,con_password);
        }
    }

    private void getRegister(String fname, String lname, String mobile, String email, String password, String con_password) {


        final ProgressDialog progressDialog = new ProgressDialog(ctx);
        progressDialog.setMessage("wait...");
        progressDialog.show();

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
                        progressDialog.dismiss();
                        setResponse(response.toString());
                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error
                        progressDialog.dismiss();
                        setResponse("error");
                    }
                });
    }

    private void setResponse(String s) {

        if (s.equals("error")){
            Utility.toastView(ctx,ctx.getString(R.string.something_went));
        }else if (!s.equals("")){
            try {
                JSONObject object = new JSONObject(s);
                String status = object.getString("status");
                String messgae= object.getString("message");

                if (messgae.equals("Email already existed")){
                    Utility.toastView(ctx,"Email already existed");
                }else if (messgae.equals("User Successfully Register")){

                    Utility.toastView(ctx,"Successfully Register");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else {
            Utility.toastView(ctx,ctx.getString(R.string.no_found));
        }
    }
}
