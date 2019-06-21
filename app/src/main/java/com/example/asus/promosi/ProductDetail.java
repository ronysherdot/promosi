package com.example.asus.promosi;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.promosi.Produk_MySQL.PicassoClient;

public class ProductDetail extends AppCompatActivity {

    TextView txtJudulProduct, txtKeterangan;
    ImageView imageProduct;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ProductDetail.this, Product.class);
        startActivity(intent);
        finishAffinity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        txtJudulProduct = (TextView) findViewById(R.id.txtJudulProduct);
        txtKeterangan = (TextView) findViewById(R.id.txtKeterangan);
        imageProduct = (ImageView) findViewById(R.id.imageProduct);

        detail();
    }

    private void detail(){
        Intent i = this.getIntent();
        String produk = i.getExtras().getString("GAMBAR_KEY");
        String judul = i.getExtras().getString("JUDUL_KEY");
        String keterangan = i.getExtras().getString("KETERANGAN_KEY");

        PicassoClient.downloadImage(this, produk, imageProduct);
        txtJudulProduct.setText(judul);
        txtKeterangan.setText(keterangan);
    }
}
