package com.example.asus.promosi;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.asus.promosi.Gallery_MySQL.PicassoClient;

public class GalleryDetail extends AppCompatActivity {

    ImageView imageDetail;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GalleryDetail.this, Gallery.class);
        startActivity(intent);
        finishAffinity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_detail);

        imageDetail = (ImageView) findViewById(R.id.imageDetail);
        imageDetail.post(new Runnable() {
            @Override
            public void run() {
                details();
            }
        });
    }

    private void details(){
        Intent i = this.getIntent();
        String gambar = i.getExtras().getString("GAMBAR_KEY");
        PicassoClient.downloadImage(this,gambar, imageDetail);
    }
}
