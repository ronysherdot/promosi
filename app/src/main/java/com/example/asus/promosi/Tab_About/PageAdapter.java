package com.example.asus.promosi.Tab_About;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {
    int num_tab;

    public PageAdapter(FragmentManager fm, int num_tab){
        super(fm);
        this.num_tab = num_tab;
    }

    public Fragment getItem(int position){
        switch (position){
            case 0:
                AboutFragment1 af1 = new AboutFragment1();
                return af1;
            case 1:
                AboutFragment2 af2 = new AboutFragment2();
                return  af2;
            case 2:
                AboutFragment3 af3 = new AboutFragment3();
                return af3;
            case 3:
                AboutFragment4 af4 = new AboutFragment4();
                return af4;
                default: return null;
        }
    }

    public int getCount(){
        return num_tab;
    }

}
