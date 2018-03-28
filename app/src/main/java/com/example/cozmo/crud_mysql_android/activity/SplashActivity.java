package com.example.cozmo.crud_mysql_android.activity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.example.cozmo.crud_mysql_android.R;
import com.example.cozmo.crud_mysql_android.function.SessionManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends SessionManager {

    @BindView(R.id.pbProgress)
    ProgressBar pbProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sessionManager.checkLogin();
            }
        }, 4000);
    }
}
