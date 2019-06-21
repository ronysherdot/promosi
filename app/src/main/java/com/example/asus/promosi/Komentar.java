package com.example.asus.promosi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class Komentar extends AppCompatActivity {

    Toolbar toolbar;

    EditText txtEmail,txtNamaPengguna, txtKomentar;
    Button buttonAdd;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Komentar.this,Home.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komentar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Komentar");
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_black_24dp);
        toolbar.setTitleTextColor(Color.parseColor("#000000"));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Komentar.this,Contact.class);
                startActivity(intent);
                finish();
            }
        });

        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtNamaPengguna = (EditText)findViewById(R.id.txtNamaPengguna);
        txtKomentar = (EditText)findViewById(R.id.txtKomentar);
        buttonAdd = (Button)findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addKomentar();
                Intent intent = new Intent(Komentar.this, Home.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void addKomentar (){
        final String email = txtEmail.getText().toString().trim();
        final String nama_pengguna = txtNamaPengguna.getText().toString().trim();
        final  String komentar = txtKomentar.getText().toString().trim();

        class AddKomentar extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Komentar.this, "Insert", "Waiting", false, false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Konfigurasi.KEY_EMAIL,email);
                params.put(Konfigurasi.KEY_NAMA,nama_pengguna);
                params.put(Konfigurasi.KEY_KOMENTAR,komentar);

               Request rh = new Request();
               String res = rh.sendPostRequest(Konfigurasi.URL_ADD, params);
               return res;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                loading.dismiss();
                Toast.makeText(Komentar.this, s,Toast.LENGTH_SHORT).show();
            }
        }

        AddKomentar ad = new AddKomentar();
        ad.execute();
    }
}
