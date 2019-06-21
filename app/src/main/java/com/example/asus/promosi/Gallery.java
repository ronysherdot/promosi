package com.example.asus.promosi;

import android.content.Intent;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.GridView;

import com.example.asus.promosi.Gallery_MySQL.Downloader;
import com.example.asus.promosi.Gallery_MySQL.Ukiran;

public class Gallery extends AppCompatActivity {

    Toolbar toolbar;
    final static String urlAddress = "http://192.168.43.12/tradisional_web/api/gallery.php";

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Gallery.this,Home.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Gallery");
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_black_24dp);
        toolbar.setTitleTextColor(Color.parseColor("#000000"));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Gallery.this,Home.class);
                startActivity(intent);
                finish();
            }
        });

        final Ukiran ukiran = new Ukiran();
        final GridView gv =(GridView) findViewById(R.id.gv);
        gv.post(new Runnable() {
            @Override
            public void run() {
                new Downloader(Gallery.this, urlAddress, gv).execute();
            }
        });
    }
}