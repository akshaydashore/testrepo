package infobite.technology.info.eganacsi.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import infobite.technology.info.eganacsi.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Context ctx;
    Button login_bt;
    TextView newuser_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initxml();
    }

    private void initxml() {
        ctx = this;
        login_bt = (Button)findViewById(R.id.bt_login_login);
        newuser_tv = (TextView) findViewById(R.id.tv_login_newuser);

        login_bt.setOnClickListener(this);
        newuser_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.bt_login_login:
                startActivity(new Intent(ctx,MainActivity.class));
                break;

            case R.id.tv_login_newuser:
                startActivity(new Intent(ctx,RegisterActivity.class));
                break;
        }
    }
}
