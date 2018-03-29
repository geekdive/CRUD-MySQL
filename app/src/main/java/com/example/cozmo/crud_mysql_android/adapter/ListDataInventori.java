package com.example.cozmo.crud_mysql_android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cozmo.crud_mysql_android.R;
import com.example.cozmo.crud_mysql_android.function.MyConstant;
import com.example.cozmo.crud_mysql_android.model.DataInventoriItem;
import com.squareup.picasso.Picasso;

import java.util.List;

// TODO 2c: extend ke RecyclerView classnya dengan menginisiasi ListAdapter ke method MyViewHolder
// TODO 2d: jika merah alt + enter kemudian pilih semua tekan Enter

public class ListDataInventori extends RecyclerView.Adapter<ListDataInventori.MyViewHolder> {

    // TODO 2e: buat class Context dengan mendeklarasikannya
    Context context;

    // TODO 2s: untuk penanganan klik dari user kita perlu sebuah variable untuk menampung aksi nya
    OnItemClicked clicked;


    // TODO 2f: buat inisialisasi List untuk nge-Array data dari database [Mentah]
    List<DataInventoriItem> dataInventoriItems;

    // TODO 2g: Membuat public method ListDataInventori class untuk mengumpulkan data dari database dan menyelaraskannya ke variable context dan datainventoritem agar memiliki nilai sama
    public ListDataInventori(Context ctx, List<DataInventoriItem> dataInventoriItemList){
        this.context = ctx;
        dataInventoriItems = dataInventoriItemList;
    }

    @Override
    public ListDataInventori.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // TODO 2h: Buat layout untuk menampung item nya kedalam CardView di viewdaainventori.xml dan data di inflate kesana
        View view = LayoutInflater.from(context).inflate(R.layout.viewdatainventori, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
        // TODO 2i: Alt Enter pada bagian RecyclerView.Adapter<ListDataInventori.MyViewHolder> kemudian import class -> Alt + Enter extend ke CardView yang ada di viewdatainventori.xml
    }

    @Override
    public void onBindViewHolder(ListDataInventori.MyViewHolder holder, final int position) {
        // TODO 2o: binding data nama inventori, waktu input, user yang nginput kedalam textview dalam layout
        holder.tvNamadataInv.setText(dataInventoriItems.get(position).getNamaInventori());
        holder.tvWaktuInputdataInv.setText(dataInventoriItems.get(position).getWaktuInput());
        holder.tvUserInputdataInv.setText(dataInventoriItems.get(position).getIdUser());

        // TODO 2p: Mengambil data gambar dari path uploads kemudian di infalate ke view jika kosong picasso akan menangani dengan menginflate kan gambar noimage
        Picasso.with(context).load(MyConstant.IMAGE_URL + dataInventoriItems.get(position).getImgInvventori().toString())
                .error(R.drawable.noimage).placeholder(R.drawable.noimage).into(holder.ivGambardataInv);

        // TODO 2u: Memberikan Action onClick pada CardView
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        // TODO 2n: Membaca data total dalam database ke tbl data inventori
        return dataInventoriItems.size();
    }

    // TODO 2j: jika masih merah alt + enter untuk membuat constructor
    public class MyViewHolder extends RecyclerView.ViewHolder {
        // TODO 2k: Buat Deklarasi ImageView dan TextView yang digunakan pada viewdatainventori.xmlnya
        ImageView ivGambardataInv;
        TextView tvNamadataInv, tvWaktuInputdataInv, tvUserInputdataInv;
        public MyViewHolder(View itemView) {
            super(itemView);
            // TODO 2l: filih Build -> Rebuild terlebih dahulu agar id pada viewdatainventori.xml terbaca selanjutnya
            // TODO 2m: Kita instansiasikan variable diatas kedalam itemView
            tvNamadataInv = (TextView)itemView.findViewById(R.id.txtNamaDataItemInv);
            tvWaktuInputdataInv = (TextView)itemView.findViewById(R.id.txtWaktuInputDataItemInv);
            tvUserInputdataInv = (TextView)itemView.findViewById(R.id.txtNamaUserInputDataItemInv);

            ivGambardataInv = (ImageView)itemView.findViewById(R.id.picDataItemInventori);
        }
    }

    // TODO 2q: buat class interface InItemClicked untuk menangani klik
    public interface OnItemClicked {
        void onItemClick(int position);
    }

    // TODO 2r: buat method setOnClick aksi penanganan sesudah di klik
    public void setOnClick(OnItemClicked onClick){
        // TODO 2t: tambahkan method agar aksi di eksekusi
        clicked = onClick;
    }
}
