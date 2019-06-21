package com.example.asus.promosi;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeAdapter extends BaseAdapter {
    Context c;
    String[] viewMenu;

    public HomeAdapter(Context c, String[] viewMenu) {
        this.c = c;
        this.viewMenu = viewMenu;
    }

    @Override
    public int getCount() {
        return viewMenu.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
        View gridView;

        if(view==null){
            gridView=new View(c);
            gridView=inflater.inflate(R.layout.homemodel, null);
            TextView fungsi=(TextView)gridView.findViewById(R.id.fungsi);
            fungsi.setText(viewMenu[position]);

            ImageView images = (ImageView) gridView.findViewById(R.id.images);
            String img = viewMenu[position];

            if(img.equals("product")){
                images.setImageResource(R.drawable.patung);
            }else if (img.equals("bestproduct")){
                images.setImageResource(R.drawable.depan);
            }else if (img.equals("gallery")){
                images.setImageResource(R.drawable.kesimar);
            }else if (img.equals("contact")){
                images.setImageResource(R.drawable.canggah);
            }else if (img.equals("about")){
                images.setImageResource(R.drawable.kayu);
            }else if (img.equals("help")){
                images.setImageResource(R.drawable.patung);
            }

        }else {
            gridView = (View) view;
        }
        return gridView;
    }
}
