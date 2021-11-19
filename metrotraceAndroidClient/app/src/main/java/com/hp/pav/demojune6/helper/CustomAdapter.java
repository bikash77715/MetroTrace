package com.hp.pav.demojune6.helper;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.hp.pav.demojune6.slidingtab.FirstFragment;

/**
 * Created by Pav on 6/12/2017.
 */

public class CustomAdapter extends FragmentStatePagerAdapter {

    Context context;

    public CustomAdapter(FragmentActivity activity, FragmentManager fm) {

        super(fm);
        context = activity;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
                return new FirstFragment();




        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if(position == 0){
            return "Songs";
        }else if(position == 1){

            return "Vedios";

        }else if(position ==2){

            return  "movies";

        }else{
            return null;
        }


    }
}
