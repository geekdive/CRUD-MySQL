package com.example.cozmo.crud_mysql_android.function;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;

import com.example.cozmo.crud_mysql_android.MainActivity;
import com.example.cozmo.crud_mysql_android.activity.LoginActivity;

/**
 * Created by cozmo on 21/03/18.
 */
//TODO 26: extends to MyFunction
public class SessionManager extends MyFunction {

    //TODO 27: Ketik @VisibleForTesting untuk Preference
    @VisibleForTesting
    //TODO 28: Membuat variable SharePrerences
    SharedPreferences pref;

    public SharedPreferences.Editor editor;
    public SessionManager sessionManager;

    //TODO 29: Membuat variable dengan typedata int untuk mode share Preferences
    int mode = 0;

    //TODO 30: Membuat nama dari share preferences
    private static final String pref_name = "crudpref";

    //TODO 31: Membuat kunci share preferences
    private static final String is_login = "isLogin";
    private static final String kunci_email = "keyMail";


    //TODO 32: Klik kanan -> Override Method ->  OnClick set Enter / Klik kanan -> Generate -> Override Method ->  OnClick set Enter
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO 33: Membuat sessionManager
        sessionManager = new SessionManager(getApplicationContext());
    }

    //TODO 36: Tambahkan Method kosong seperti dibawah untuk mengakses class
    public SessionManager(){

    }

    //TODO : Create Constructor for getAplicationContext
    public SessionManager(Context context){
        //TODO 34: Mengakses class MyFunction
        contextmyfunction = context;
        //TODO 35: Membuat informasi share preference dari class SessionManager ini
                                       //Nama Preference, Mode
        pref = context.getSharedPreferences(pref_name, mode);
        editor = pref.edit();
    }

    // 26 Maret 2018

    //TODO 67: Membaut Sesi dari login user
    public void createSession(String email){
        //TODO 68: Login value menjadi true
        editor.putBoolean(is_login, true);
        //TODO 69: Memasukkan email ke dalam variable kunci email
        editor.putString(kunci_email, email);
        editor.commit();
    }

    //TODO 71: Buat IdUser
    public void setIdUser(String iduser){
        editor.putBoolean(is_login, true);
        editor.putString("iduser", iduser);
        editor.commit();
    }

    public String getIdUser(){
        return pref.getString("iduser", "");
    }


    // TODO : checkLogin
    public boolean isLogin(){
        return pref.getBoolean(is_login, false);
    }

    //TODO 72: Membuat Cek Login Method
    public void checkLogin(){
        if (!this.isLogin()) {
            Intent i = new Intent(contextmyfunction, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            contextmyfunction.startActivity(i);
        } else {
            Intent i = new Intent(contextmyfunction, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            contextmyfunction.startActivity(i);
        }
    }

    public void logOut() {
        editor.clear();
        editor.commit();

        Intent i = new Intent(contextmyfunction, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        contextmyfunction.startActivity(i);
    }

    //TODO 73: Alt + Insert -> Override Method -> OnStop
    @Override
    protected void onStop() {
        super.onStop();
        //TODO 74: Create Method hide Progress di MyFunction.java
        hideProgressDialog();
    }
}
