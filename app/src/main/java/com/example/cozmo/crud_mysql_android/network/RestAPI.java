package com.example.cozmo.crud_mysql_android.network;

import com.example.cozmo.crud_mysql_android.model.ModelInventori;
import com.example.cozmo.crud_mysql_android.model.ModelKategori;
import com.example.cozmo.crud_mysql_android.model.ModelUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by cozmo on 22/03/18.
 */

public interface RestAPI {

    //TODO 45: Tambahkan Form URL atau Persiapan Akses Model User
    @FormUrlEncoded
    @POST("registeruser.php/")
    //TODO 47: Menautkan ModelUser dengan API berikut Retrofit
    Call<ModelUser> registerUser (
            //TODO 48: Tambahkan sebuah variable tampung data untuk menyimpan inputan dari user
            @Field("vsnama") String strnama,
            @Field("vsalamat") String stralamat,
            @Field("vsnotelp") String strtelp,
            @Field("vsjenkel") String strjeniskelamin,
            @Field("vsusername") String strusername,
            @Field("vspassword") String strpassword,
            @Field("vslevel") String strlevel
    );

    //TODO 65: Tambahkan Form URL atau Persiapan Akses User Login
    @FormUrlEncoded
    @POST("loginuser.php/")
    Call<ModelUser> loginUser (
            @Field("usernamein") String strusername,
            @Field("passwordin") String strpassword,
            @Field("levelin") String strlevel
    );

    // TODO 1B: Membuat ModelInventori (GSON -> !dicek toString) Kemudian Generate
    // TODO 1C: Menambahkan Get Method atau Akses Ambil data Inventori
    @GET("view_datainventori.php/")
    Call<ModelInventori> getInventori();

    // TODO 3g: Mengambil data dari database melewati PHP
    @GET("view_datakategori.php/")
    Call<ModelKategori> getKategoriInv();

    //TODO 46: Membuat Class ModelUser untuk Membuat Setter & Getter variabel informasi Register User

    //TODO 49: Membuat Class RetrofitClient dalam package Network
}
