package com.example.cozmo.crud_mysql_android.activity;

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
//TODO 39: Secara otomatis setelah di Alt + Enter akan ditambahkan import
import com.example.cozmo.crud_mysql_android.function.SessionManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
                    //TODO 40: Akses Method MyAnimation di class MyFunction
                    MyAnimation(edAlamat);
                } else if (TextUtils.isEmpty(strNoTelp)){
                    edTelp.setError("No. Telp masih kosong!!");
                    edTelp.requestFocus();
                    //TODO 40: Akses Method MyAnimation di class MyFunction
                    MyAnimation(edTelp);
                } else if (TextUtils.isEmpty(strUsername)){
                    edUsername.setError("Username masih kosong!!");
                    edUsername.requestFocus();
                    //TODO 40: Akses Method MyAnimation di class MyFunction
                    MyAnimation(edUsername);
                } else if (TextUtils.isEmpty(strPassword)){
                    edPassword.setError("Passwprd masih kosong!!");
                    edPassword.requestFocus();
                    //TODO 40: Akses Method MyAnimation di class MyFunction
                    MyAnimation(edPassword);
                } else if (TextUtils.isEmpty(strConfirmPassword)){
                    edConfirmPassword.setError("Passwprd masih kosong!!");
                    edConfirmPassword.requestFocus();
                    //TODO 40: Akses Method MyAnimation di class MyFunction
                    MyAnimation(edConfirmPassword);
                } else {
                    MyToast("Nama saya " + strNama + " asal saya dari " + strAlamat + " No. Telp saya adalah " + strNoTelp + " jenis kelamin saya adalah " + strJenisKelamin + " username saya adalah " + strUsername + " password saya adalah " + strPassword + " kinfirmasi password saya adalah " + strConfirmPassword + " level user saya adalah " + strLevel);
                }
            case R.id.btnErase:
                break;
        }
    }
}
