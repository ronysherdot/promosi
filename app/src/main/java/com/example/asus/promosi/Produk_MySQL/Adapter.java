package com.example.asus.promosi.Produk_MySQL;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.promosi.BestprodukDetail;
import com.example.asus.promosi.ProductDetail;
import com.example.asus.promosi.R;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    Context c;
    ArrayList<Ukiran> produk;
    LayoutInflater inflater;

    public Adapter(Context c, ArrayList<Ukiran> produk) {
        this.c = c;
        this.produk = produk;
    }

    @Override
    public int getCount() {
        return produk.size();
    }

    @Override
    public Object getItem(int position) {
        return produk.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.from(c).inflate(R.layout.produk_model, parent, false);
        }

        TextView judul = (TextView) convertView.findViewById(R.id.txtJudul);
        ImageView produk = (ImageView) convertView.findViewById(R.id.imageList);

        ImageView detail = (ImageView) convertView.findViewById(R.id.imageProductBest);
        TextView judul_product = (TextView) convertView.findViewById(R.id.txtJudulProductBest);
        TextView keterangan = (TextView) convertView.findViewById(R.id.txtKeteranganBest);
        TextView deskripsi = (TextView) convertView.findViewById(R.id.txtDeskripsi);

        final Ukiran ukiran = (Ukiran) this.getItem(position);

        PicassoClient.downloadImage(c, ukiran.getGambar(), produk);
        judul.setText(ukiran.getNama_produk());
        deskripsi.setText(ukiran.getDeskripsi_singkat());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetail(ukiran.getGambar(), ukiran.getNama_produk(), ukiran.getKeterangan());
            }
        });

        return convertView;
    }

    private void openDetail(String...detail){
        Intent i = new Intent(c, BestprodukDetail.class);
        i.putExtra("GAMBAR_KEY", detail[0]);
        i.putExtra("JUDUL_KEY", detail[1]);
        i.putExtra("KETERANGAN_KEY", detail[2]);
        c.startActivity(i);
    }
}
