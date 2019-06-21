package com.example.asus.promosi;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.promosi.Produk_MySQL.PicassoClient;
import com.uncopt.android.widget.text.justify.JustifiedTextView;

public class BestprodukDetail extends AppCompatActivity {

    TextView txtJudulProductBest;
    JustifiedTextView txtKeteranganBest;
    ImageView imageProductBest;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(BestprodukDetail.this, BestProduct.class);
        startActivity(intent);
        finishAffinity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestproduk_detail);

        txtJudulProductBest = (TextView) findViewById(R.id.txtJudulProductBest);
        txtKeteranganBest = (JustifiedTextView) findViewById(R.id.txtKeteranganBest);
        imageProductBest = (ImageView) findViewById(R.id.imageProductBest);

        detail();
    }

    private void detail(){
        Intent i = this.getIntent();
        String produk = i.getExtras().getString("GAMBAR_KEY");
        String judul = i.getExtras().getString("JUDUL_KEY");
        String keterangan = i.getExtras().getString("KETERANGAN_KEY");

        PicassoClient.downloadImage(this, produk, imageProductBest);
        txtJudulProductBest.setText(judul);
        txtKeteranganBest.setText(keterangan);
    }
}
