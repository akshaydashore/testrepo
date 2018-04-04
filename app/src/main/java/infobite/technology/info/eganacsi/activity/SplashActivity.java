package infobite.technology.info.eganacsi.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import infobite.technology.info.eganacsi.R;

public class SplashActivity extends AppCompatActivity {

    public static final int SPALSH_TIME_OUT = 3000;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initxml();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ctx,LoginActivity.class));
            }
        },SPALSH_TIME_OUT);
    }

    private void initxml() {
        ctx = this;
    }
}
