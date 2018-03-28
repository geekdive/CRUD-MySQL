package com.example.cozmo.crud_mysql_android.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.cozmo.crud_mysql_android.MainActivity;
import com.example.cozmo.crud_mysql_android.R;
import com.example.cozmo.crud_mysql_android.function.SessionManager;
import com.example.cozmo.crud_mysql_android.model.ModelUser;
import com.example.cozmo.crud_mysql_android.network.RestAPI;
import com.example.cozmo.crud_mysql_android.network.RetrofitClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//TODO 57: set extend ke Session Manager
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

    //TODO 60: Buat Variable tampung untuk login user
    String strusername, strpassword, strlevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        //TODO 61: Buat desisi pemilihan radio button untuk user biasa dan admin
        if (rbtAdmin.isChecked()) {
            strlevel = "admin";
        } else {
            strlevel = "user biasa";
        }
    }

    @OnClick({R.id.rbtAdmin, R.id.rbtUserBiasa ,R.id.btnLogin, R.id.btnRegister})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rbtAdmin:
                //TODO 62: Memberikan Nilai level Admin
                strlevel = "admin";
                break;
            case R.id.rbtUserBiasa:
                //TODO 63: Memberikan Nilai level User Biasa
                strlevel = "user biasa";
                break;
            case R.id.btnLogin:
                //TODO 59: Membuat Aktifitas Login
                //Aksi Login
                strusername = edtUsername.getText().toString();
                strpassword = edtPassword.getText().toString();
                if(TextUtils.isEmpty(strusername)){
                    edtUsername.requestFocus();
                    MyAnimation(edtUsername);
                    edtUsername.setError("Username tidak boleh kosong!");
                }else if (TextUtils.isEmpty(strpassword)){
                    edtPassword.requestFocus();
                    MyAnimation(edtPassword);
                    edtPassword.setError("Password tidak boleh kosong");
                }else{
                    //TODO 64: Create Method LoginUser
                    loginUser();
                }

                break;
            case R.id.btnRegister:
                //TODO 58: Arahkan btnRegister ke Activity Register dengan Intent
                //Aksi Register
                MyIntent(RegisterActivity.class);
                break;
        }
    }

    //TODO 66: Membuat sesi login dan method
    private void loginUser() {
        // TODO : Membuat Progress Dialog untuk aksi Login jika di proses dan akan di tampilkan di activity Login
        final ProgressDialog dialog = ProgressDialog.show(LoginActivity.this,
                "Progress login user", "Loading...");

        // TODO : Inisialisai Class RestAPI
        RestAPI api = RetrofitClient.getInstaceRetrofit();

        Call<ModelUser> modelUserCall = api.loginUser(strusername, strpassword, strlevel);
        modelUserCall.enqueue(new Callback<ModelUser>() {
            @Override
            public void onResponse(Call<ModelUser> call, Response<ModelUser> response) {
                if (response.isSuccessful()) {
                    dialog.dismiss();

                    String status = response.body().getResult();
                    String pesan = response.body().getMsg();
                    //asdfsaString level = response.body().getUser().getLevelUser();

                    if (status.equals("1")) {
                        MyToast(pesan);
                        //if (level.equals("admin")) {
                            //MyToast("Level user anda adalah " + level + " Welcome!");
                            MyIntent(MainActivity.class);
                            finish();
                            // TODO 70: Buat Session Manager dengan memanggil method sessionManager
                            // di SessionManager.java
                            sessionManager.createSession(strusername);
                            String iduser = response.body().getUser().getIdUser();
                            sessionManager.setIdUser(iduser);
                        //} else {
                        //    MyToast("Level user anda adalah " + level + " Welcome!");
                        //    MyIntent(UserActivity.class);
                        //    sessionManager.createSession(strusername);
                        //    String iduser = response.body().getUser().getIdUser();
                        //    sessionManager.setIdUser(iduser);
                        //}
                    } else {
                        MyToast(pesan + " Cek lagi username, password & hak akses user anda!");
                    }
                }
            }

            @Override
            public void onFailure(Call<ModelUser> call, Throwable t) {
                MyToast("Gagal koneksi " + t.getMessage());
                dialog.dismiss();
            }
        });
    }
}
