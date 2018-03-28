package com.example.cozmo.crud_mysql_android.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

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

//TODO 39: Secara otomatis setelah di Alt + Enter akan ditambahkan import

//TODO 38: Tambahkan atau extends class SessionManager seperti dibawah jika ada error Alt + Enter
public class RegisterActivity extends SessionManager {

    //TODO 3: Inject View dengan ButterKnife

    @BindView(R.id.edNama)
    EditText edNama;
    @BindView(R.id.edAlamat)
    EditText edAlamat;
    @BindView(R.id.edTelp)
    EditText edTelp;
    @BindView(R.id.spnJk)
    Spinner spnJk;
    @BindView(R.id.edUsername)
    EditText edUsername;
    @BindView(R.id.edPassword)
    TextInputEditText edPassword;
    @BindView(R.id.edConfirmPassword)
    TextInputEditText edConfirmPassword;
    @BindView(R.id.rbAdmin)
    RadioButton rbAdmin;
    @BindView(R.id.rbUserBiasa)
    RadioButton rbUserBiasa;
    @BindView(R.id.btnRegister)
    Button btnRegister;
    @BindView(R.id.btnErase)
    Button btnErase;

    //TODO 4: Membuat variable array untuk value pilihan Jenis Kelamin
    String jenisKelamin[] = {
            "Laki-laki",
            "Perempuan"
    };

    //TODO 5: Membuat variable temporary (tampungan) untuk menyimpan inputan dari widget yang ada yang akan digunakan untuk mengirimkkan data ke dalam server database
    String strNama, strAlamat, strNoTelp, strUsername,strPassword, strLevel, strConfirmPassword, strJenisKelamin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        //TODO 6: Membuat Method fungsi pilihan untuk Level pada RadioButton dan Mengimplementasikan ke mehtod onCreate
        //TODO 7: Buat method pilihLevel(); -> Alt + Enter
        pilihLevel();

        //TODO 8: Membuat Fungsi menampilkan dan Mengisi Pilihan Jenis Kelamin pada Spinner serta mendapatkan value pilihan
        //TODO 13: Membuat Adapter untuk Spinner
        //c adalah variable context dari class function
        ArrayAdapter adapter = new ArrayAdapter(contextmyfunction, android.R.layout.simple_spinner_item, jenisKelamin);
        //TODO 14: Jika error pada context maka kita panggil class myfunction dengan cara alt + enter pada context yang error -> pilih Import Static Constant
        //TODO 15: Membuat simple simple spinner dropdown dan menampilkan value
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //TODO 16: Mengatur adapter untuk mengaktifkan dropdown pada Spinner
        spnJk.setAdapter(adapter);
        //TODO 16: Membuat aksi klik dari user onItemSelectedListener
        spnJk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posisi, long l) {
                //TODO 17: Tampung data kedalam variable strJenisKelamin
                strJenisKelamin = jenisKelamin[posisi];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void pilihLevel() {
        if (rbAdmin.isChecked()){
            strLevel = "admin";
        } else {
            strLevel = "admin biasa";
        }
    }

    @OnClick({R.id.rbAdmin, R.id.rbUserBiasa, R.id.btnRegister, R.id.btnErase})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rbAdmin:
                //TODO 18: Value secara default yang disediakan, ketika user memilih level rbAdmin maka nilai adalah berikut
                strLevel = "admin";
                break;
            case R.id.rbUserBiasa:
                //TODO 19: Value secara default yang disediakan, ketika user memilih level rbUserBiasa maka nilai adalah berikut
                strLevel = "user biasa";
                break;
            case R.id.btnRegister:
                //TODO 20: Memparsing inputan edittext Username & Password ke dalam String
                strNama = edNama.getText().toString();
                strAlamat = edAlamat.getText().toString();
                strNoTelp = edTelp.getText().toString();
                strUsername = edUsername.getText().toString();
                strPassword = edPassword.getText().toString();
                strConfirmPassword = edConfirmPassword.getText().toString();
                //TODO 21: Membuat Validator Inputan dari User
                if (strNama.isEmpty()){
                    edNama.setError("Nama masih kosong!!");
                    edNama.requestFocus();
                    //TODO 40: Akses Method MyAnimation di class MyFunction
                    MyAnimation(edNama);
                }  else if (TextUtils.isEmpty(strAlamat)){
                    edAlamat.setError("Alamat masih kosong!!");
                    edAlamat.requestFocus();
                    MyAnimation(edAlamat);
                } else if (TextUtils.isEmpty(strNoTelp)){
                    edTelp.setError("No. Telp masih kosong!!");
                    edTelp.requestFocus();
                    MyAnimation(edTelp);
                } else if (TextUtils.isEmpty(strUsername)){
                    edUsername.setError("Username masih kosong!!");
                    edUsername.requestFocus();
                    MyAnimation(edUsername);
                } else if (TextUtils.isEmpty(strPassword)){
                    edPassword.setError("Passwprd masih kosong!!");
                    edPassword.requestFocus();
                    MyAnimation(edPassword);
                } else if (TextUtils.isEmpty(strConfirmPassword)){
                    edConfirmPassword.setError("Passwprd masih kosong!!");
                    edConfirmPassword.requestFocus();
                    MyAnimation(edConfirmPassword);
                } else {
                    //TODO 41: Create Method Register, Alt + Enter (Create Method)
                    registerUser();
                }
            case R.id.btnErase:
                break;

        }
    }

    //TODO 43: Install RoboPOJOGenerator
    //TODO 44: Membuat Package: adapter, model dan network
    //TODO 45: Membuat RestAPI [network], RetrofitClient [network], MyConstant [function]

    //TODO 52: Membuat method register atau aktifitas register user
    private void registerUser() {
        final ProgressDialog dialog = ProgressDialog.show(RegisterActivity.this, "Progress Registrasi User Baru", "Loading..");

        RestAPI api = RetrofitClient.getInstaceRetrofit();
        //TODO 53: Buat Call Method Call Model User
        Call<ModelUser> modelUserCall = api.registerUser(
                strNama, strAlamat, strNoTelp, strJenisKelamin, strUsername, strPassword, strLevel
        );

        //TODO 54: Membuat Method CallBack
        modelUserCall.enqueue(new Callback<ModelUser>() {
            @Override
            public void onResponse(Call<ModelUser> call, Response<ModelUser> response) {
                if(response.isSuccessful()){
                    dialog.dismiss();

                    //TODO 55: Variable Penampungan untuk mengambil nilai Result & Message
                    String status = response.body().getResult();
                    String pesan = response.body().getMsg();

                    //{
                    //      "result": "1",
                    //       "msg": "Berhasil register!!"
                    //}

                    if (status.equals("1")) {
                        MyToast("Congratulation! " + pesan);
                        MyIntent(LoginActivity.class);
                        finish();
                    } else {
                        MyToast(pesan);
                    }
                }
            }

            @Override
            public void onFailure(Call<ModelUser> call, Throwable t) {
                MyToast("Ada masalah, Gagal terkoneksi!");
                dialog.dismiss();
            }
        });
    }
}
