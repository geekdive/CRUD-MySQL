package com.example.cozmo.crud_mysql_android.function;

/**
 * Created by cozmo on 22/03/18.
 */

public class MyConstant {
    //TODO 51: Membuat Akses URL ke Base_URL Project
    //TODO 51.1: Jangan gunakan "https://192.xxx.xxx.xxx (Untuk SSL perlu perizinan) jadi gunakan "http://192.xxx.xxx.xxx

    // command@army:/var/www/html/db_inventori$
    //.
    //├── db_datainventori.sql
    //├── delete_datainventori.php
    //├── delete_datakategori.php
    //├── delete_datauser.php
    //├── input_datainventori.php
    //├── input_datakategori.php
    //├── input_datauser.php
    //├── koneksi
    //│   └── config.php
    //├── loginuser.php
    //├── registeruser.php
    //├── update_datainventori.php
    //├── update_datakategori.php
    //├── update_datauser.php
    // TODO First: Create Folder ├── uploads [folder-penyimpanan-gambar]
    //├── view_datainventori.php
    //├── view_datakategori.php
    //└── view_datauser.php

    public static final String BASE_URL = "http://192.168.2.8/db_inventori/";

    // Buat terlebih dahulu dalam project API db_inventori dengan nama forlder: uploads
    // TODO 1A: Menambahkan Link Directori Upload Data Gambar
    public static final String IMAGE_URL = "http://192.168.2.8/db_inventori/uploads/";
}
