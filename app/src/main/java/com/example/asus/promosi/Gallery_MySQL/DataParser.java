package com.example.asus.promosi.Gallery_MySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataParser extends AsyncTask<Void,Void,Integer> {

    Context c;
    String jsonData;
    GridView gv;

    ProgressDialog pd;
    ArrayList<Ukiran> Ukirans =new ArrayList<>();

    public DataParser(Context c, GridView gv, String jsonData) {
        this.c = c;
        this.jsonData = jsonData;
        this.gv = gv;
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
    protected Integer doInBackground(Void... voids) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

        pd.dismiss();
        if (result==0){
            Toast.makeText(c,"Gagal di unduh",Toast.LENGTH_SHORT).show();
        }
        else {
            CustomAdapter customAdapter = new CustomAdapter(c, Ukirans);
            gv.setAdapter(customAdapter);
        }
    }

    private int parseData()
    {
        try
        {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;

            Ukirans.clear();
            Ukiran ukiran;

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                int id_gallery = jo.getInt("id_gambar");
                String nama_gambar=jo.getString("nama_gambar");
                String gambar=jo.getString("base_url");

                ukiran=new Ukiran();

                ukiran.setId_gallery(id_gallery);
                ukiran.setNama_gambar(nama_gambar);
                ukiran.setGambar(gambar);

                Ukirans.add(ukiran);
            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}

