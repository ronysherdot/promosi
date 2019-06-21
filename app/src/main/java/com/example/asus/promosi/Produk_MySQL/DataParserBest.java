package com.example.asus.promosi.Produk_MySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataParserBest extends AsyncTask<Void,Void,Boolean> {
    Context c;
    String jsonData;
    ListView lv;

    ProgressDialog pd;
    ArrayList<Ukiran> produk = new ArrayList<>();

    public DataParserBest(Context c, String jsonData, ListView lv) {
        this.c = c;
        this.jsonData = jsonData;
        this.lv = lv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...Please Wait");
        pd.show();
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        return this.parseData() ;
    }
    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        pd.dismiss();

        if(result){
            lv.setAdapter(new Adapter(c, produk));
        }else {
            Toast.makeText(c,"Gagal di unduh",Toast.LENGTH_SHORT).show();
        }
    }
    private Boolean parseData()
    {
        try
        {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;

            produk.clear();
            Ukiran ukiran;

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                int id_produk = jo.getInt("id_produk");
                String nama_produk =jo.getString("nama_produk");
                String gambar = jo.getString("base_url");
                String keterangan = jo.getString("keterangan");

                ukiran=new Ukiran();

                ukiran.setId_produk(id_produk);
                ukiran.setNama_produk(nama_produk);
                ukiran.setGambar(gambar);
                ukiran.setKeterangan(keterangan);

                produk.add(ukiran);
            }

            return true;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }

}
