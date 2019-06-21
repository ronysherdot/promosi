package com.example.asus.promosi;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class Home extends AppCompatActivity {

    Toolbar toolbars;
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.patung,R.drawable.canggah,R.drawable.kesimar};
    CardView card1, card2, card3, card4, card5, card6;


    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Apakah Anda Ingin Keluar")
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Home.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        carouselView = (CarouselView) findViewById(R.id.carousel);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        toolbars = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbars);
        getSupportActionBar().setTitle("Sudana Wood Carving");
        toolbars.setTitleTextColor(Color.parseColor("#000000"));

        card1 = (CardView) findViewById(R.id.card1);
        card2 = (CardView) findViewById(R.id.card2);
        card3 = (CardView) findViewById(R.id.card3);
        card4 = (CardView) findViewById(R.id.card4);
        card5 = (CardView) findViewById(R.id.card5);
        card6 = (CardView) findViewById(R.id.card6);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent produk = new Intent(Home.this, Product.class);
                startActivity(produk);
                finish();
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bestproduk = new Intent(Home.this, BestProduct.class);
                startActivity(bestproduk);
                finish();
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galeri = new Intent(Home.this, Gallery.class);
                startActivity(galeri);
                finish();
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contact = new Intent(Home.this, Contact.class);
                startActivity(contact);
                finish();
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about = new Intent(Home.this, About.class);
                startActivity(about);
                finish();
            }
        });

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent help = new Intent(Home.this, Help.class);
                startActivity(help);
                finish();
            }
        });
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}


