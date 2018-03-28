package com.example.cozmo.crud_mysql_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cozmo.crud_mysql_android.activity.ViewInventoriActivity;
import com.example.cozmo.crud_mysql_android.function.SessionManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends SessionManager {

    @BindView(R.id.btnLogout)
    Button btnLogout;
    @BindView(R.id.btnAksesDataInventori)
    Button btnAksesDataInventori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnLogout, R.id.btnAksesDataInventori})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLogout:
                sessionManager.logOut();
                break;
            case R.id.btnAksesDataInventori:
                MyIntent(ViewInventoriActivity.class);
                break;
        }
    }
}
