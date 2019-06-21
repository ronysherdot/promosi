package com.example.asus.promosi.Gallery_MySQL;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.promosi.GalleryDetail;
import com.example.asus.promosi.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<Ukiran> Ukirans;
    LayoutInflater layoutInflater;

    public CustomAdapter(Context c, ArrayList<Ukiran> ukirans) {
        this.c = c;
        Ukirans = ukirans;
    }

    @Override
    public int getCount() {
        return Ukirans.size();
    }

    @Override
    public Object getItem(int position) {
        return Ukirans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            convertView=layoutInflater.from(c).inflate(R.layout.gallery_model,parent,false);
        }

        TextView detail = (TextView) convertView.findViewById(R.id.detail);
        ImageView gallery = (ImageView) convertView.findViewById(R.id.gallery);

        final Ukiran ukiran = Ukirans.get(position);

        detail.setText(ukiran.getNama_gambar());
        PicassoClient.downloadImage(c,ukiran.getGambar(),gallery);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetail(ukiran.getGambar());
            }
        });

        return convertView;
    }

    private void openDetail(String gambar){
        Intent i = new Intent(c, GalleryDetail.class);
        i.putExtra("GAMBAR_KEY", gambar);
        c.startActivity(i);
    }
}
