package com.example.cozmo.crud_mysql_android.function;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cozmo.crud_mysql_android.R;

/**
 * Created by cozmo on 21/03/18.
 */

//TODO 9: Buat Class java pada package funtion
//TODO 10: Menambahkan extend AppCompatActivity pada class myfuntion
public class MyFunction extends AppCompatActivity {

    //TODO 11: Menambahkan Override Method onCreate SaveInstanceState pada class myfuntion
    //Alt + Enter -> Generate -> Override Method... -> cari onCreate -> Pilih dan Enter

    //TODO 12: Membuat public static Variable Context
    public static Context contextmyfunction;

    //TODO 22: Membuat Fungsi Animasi dan Informasi Validasi
    Animation animation;

    //TODO 23: Buat Package Animation

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contextmyfunction = MyFunction.this;
    }

    //TODO 24: Membuat method Animasi dan Membuat Android resource directory Menambahkan animasigetarl.xml & getar.xml
    public void MyAnimation(EditText edAnimasi){
        animation = AnimationUtils.loadAnimation(contextmyfunction, R.anim.animasi_getar);
        edAnimasi.setAnimation(animation);
    }

    //TODO 25: Membuat Class Baru di dalam Package function dengan nama SessionManager.java
    public void MyToast(String isiPesan){
        Toast.makeText(contextmyfunction, isiPesan, Toast.LENGTH_LONG).show();
    }

    //TODO 56: Membuat intent method dan memberikan nilai balik
    public void MyIntent(Class classTujuan){
        startActivity(new Intent(contextmyfunction, classTujuan));
    }

}
