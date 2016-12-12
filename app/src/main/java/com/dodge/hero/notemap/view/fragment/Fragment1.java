package com.dodge.hero.notemap.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dodge.hero.commontlibrary.view.fragment.ViewPagerFragment;
import com.dodge.hero.notemap.R;

import java.util.Random;

/**
 * Created by z on 2016/11/7.
 */

public class Fragment1 extends ViewPagerFragment {

    public static final String INDEX_NUM = "index_num";

    private String tag;

    public static Fragment1 create(String index) {
        Bundle bundle = new Bundle();
        bundle.putString(INDEX_NUM, index);
        Fragment1 fragment = new Fragment1();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    protected String getTAG() {
        if (tag == null) {
            Bundle bundle = getArguments();
            tag = bundle.getString(INDEX_NUM);
        }
        return tag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(getTAG(), "onCreate");
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(getTAG(), "onCreateView");
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragmetn_content, container, false);
            Random random = new Random();
            int n = random.nextInt();
            int x = n % 3;
            if (x == 0) {
                rootView.setBackgroundResource(R.color.white_100);

            } else if (x == 1) {
                rootView.setBackgroundResource(R.color.text_color_black_57);

            } else {
                rootView.setBackgroundResource(R.color.colorPrimary);
            }
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) rootView.findViewById(R.id.tv_index_num);
        textView.setText(getTAG());
        Log.d(getTAG(), "onViewCreated");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(getTAG(), "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(getTAG(), "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(getTAG(), "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(getTAG(), "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(getTAG(), "onDestroy");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        Log.d(getTAG(), "setUserVisibleHint isVisibleToUser = " + isVisibleToUser);
    }


}
