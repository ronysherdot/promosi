package com.example.asus.promosi;

import android.content.Intent;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import com.uncopt.android.widget.text.justify.JustifiedTextView;

public class Help extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Help.this,Home.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        JustifiedTextView justifiedTextView = (JustifiedTextView) findViewById(R.id.justify);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("About");
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_black_24dp);
        toolbar.setTitleTextColor(Color.parseColor("#000000"));
    }
}
