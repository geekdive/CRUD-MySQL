package com.example.cozmo.crud_mysql_android.network;

import com.example.cozmo.crud_mysql_android.function.MyConstant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cozmo on 22/03/18.
 */

//TODO 50: Membuat Class MyConstant pada package Function
public class RetrofitClient {
    //TODO 52: Class Builder untuk koneksi ke Web Server
    private static Retrofit getRetrofit(){
        //Inisialisasi Retrofit 2
        Retrofit r = new Retrofit.Builder()
                .baseUrl(MyConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return r;
    }

    public static RestAPI getInstaceRetrofit(){
        return getRetrofit().create(RestAPI.class);
    }

}
