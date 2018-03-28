package com.example.cozmo.crud_mysql_android;

import android.os.Bundle;
import android.widget.Button;

import com.example.cozmo.crud_mysql_android.function.SessionManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserActivity extends SessionManager {

    @BindView(R.id.btnLogout)
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLogout)
    public void onViewClicked() {
        sessionManager.logOut();
    }
}
