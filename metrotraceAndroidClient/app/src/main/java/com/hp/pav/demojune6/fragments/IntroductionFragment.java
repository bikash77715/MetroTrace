package com.hp.pav.demojune6.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hp.pav.demojune6.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Pav on 6/8/2017.
 */

public class IntroductionFragment extends Fragment {

    TextView tv;
    StringBuilder text = new StringBuilder();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View convertView = inflater.inflate(R.layout.introlayout, null);

        return convertView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv = (TextView)view.findViewById(R.id.tv);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getActivity().getAssets().open("intro.txt")));
            String mline;

            while((mline = reader.readLine())!=null){
                text.append(mline);
                tv.setText(text);
            }
        } catch (IOException e) {
            Toast.makeText(getActivity(), " File not found error", Toast.LENGTH_LONG).show();
        }

    }
}
