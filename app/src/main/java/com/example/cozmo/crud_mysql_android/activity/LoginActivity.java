package com.example.cozmo.crud_mysql_android.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.cozmo.crud_mysql_android.R;
import com.example.cozmo.crud_mysql_android.function.SessionManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends SessionManager {

    @BindView(R.id.edtUsername)
    EditText edtUsername;
    @BindView(R.id.edtPassword)
    EditText edtPassword;
    @BindView(R.id.rbtAdmin)
    RadioButton rbtAdmin;
    @BindView(R.id.rbtUserBiasa)
    RadioButton rbtUserBiasa;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.btnRegister)
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnLogin, R.id.btnRegister})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                //Aksi Login

                break;
            case R.id.btnRegister:
                //Aksi Register
                MyIntent(RegisterActivity.class);
                break;
        }
    }
}
