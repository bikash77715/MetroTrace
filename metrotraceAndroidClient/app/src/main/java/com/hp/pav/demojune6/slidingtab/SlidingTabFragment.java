package com.hp.pav.demojune6.slidingtab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.hp.pav.demojune6.helper.CustomAdapter;
import com.hp.pav.demojune6.R;

/**
 * Created by Pav on 6/12/2017.
 */

public class SlidingTabFragment extends Fragment {

    PagerSlidingTabStrip tabs;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.slidingtablayout, container, false);
        return  view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tabs = (PagerSlidingTabStrip)view.findViewById(R.id.pagertabs);
        viewPager = (ViewPager)view.findViewById(R.id.viewpager);

        FragmentManager fm = getChildFragmentManager();

        viewPager.setAdapter(new CustomAdapter(getActivity(), fm));
        tabs.setViewPager(viewPager);
    }
}
