package com.example.cozmo.crud_mysql_android.activity;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.cozmo.crud_mysql_android.R;
import com.example.cozmo.crud_mysql_android.adapter.ListDataInventori;
import com.example.cozmo.crud_mysql_android.function.SessionManager;
import com.example.cozmo.crud_mysql_android.model.DataInventoriItem;
import com.example.cozmo.crud_mysql_android.model.DataKategoriItem;

import java.lang.annotation.Target;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

// TODO 3a: Extends Session Manager
// TODO 3b: Menambahkan file List Data Inventori untuk sebagai Adapter pada Package Adapter dengan Implements
// TODO 3c: jika pada saat kita alt + enter kemudian kita membatalkan kemudian mencoba alt + enter lagi kemudian
// pilihan implement method tidak ada hapus dulu dari implements sampai OnRefreshListener kemudian -> Rebuild
// -> setelah selesai implemenet lagi kemudian lakukan alt+enter lagi
public class ViewInventoriActivity extends SessionManager implements ListDataInventori.OnItemClicked, SwipeRefreshLayout.OnRefreshListener {

    // TODO 3d: injectview untuk spinnner, recyclerview, swiperefreshlayout !menggunakan onClick
    @BindView(R.id.spnCariInventori)
    Spinner spnCariInventori;
    @BindView(R.id.rvDataInventoriList)
    RecyclerView rvDataInventoriList;
    @BindView(R.id.srlRefreshLayout)
    SwipeRefreshLayout srlRefreshLayout;

    // TODO 3f: Generate class model dari Data Kategori dengan Pojo Generator
    // TODO 3h: Deklarasikan variable untuk DataKategori dari table kategori
    List<DataKategoriItem> listdataKategori;
    List<DataInventoriItem> listdataInventori;

    // TODO 3i: membuat string untuk nama kategori inventori, id user, nama data inventori
    String strKategoriInv, strIdUser, strNamaInvt;

    // TODO 3j: membuat variable untuk fragment dialog show dari aksi user klik cardview
    TextInputEditText edtNamaInventori;
    EditText edtIdInventori;
    Button btnUploadImgInventori, btnInsert, btnReset, btnUpdate, btnDelete;
    ImageView imgInventori;
    Spinner spinnerPilihKategori;

    // TODO 3k: Persiapkan classPath, extractor untuk gambar menjadi Bitmap
    Uri filePath;
    Bitmap bitmap;

    // TODO 3l: Deklarasikan Dialog
    Dialog dialogPopUp;
    private String strpath;
    private String strtime;
    private String dialog;
    private Target mTarget;
    private Spinner spnPilihKategori;
    private String strIdInv;
    private String strPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewinventori);
        ButterKnife.bind(this);
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onItemClick(int position) {

    }
}

