package com.dodge.hero.commontlibrary.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.z.hero.dodge.ui.SliderPanel;


/**
 * 描述
 * Created by Linzheng on 2016/11/26.
 */

public abstract class BaseFinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup decorView = (ViewGroup) getWindow().getDecorView();
        View contentView = decorView.getChildAt(0);
        decorView.removeViewAt(0);
        SliderPanel sliderPanel = new SliderPanel(this, contentView);
        decorView.addView(sliderPanel, 0);
    }

}
