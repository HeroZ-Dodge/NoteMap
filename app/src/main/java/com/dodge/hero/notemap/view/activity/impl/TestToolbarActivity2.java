package com.dodge.hero.notemap.view.activity.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dodge.hero.commontlibrary.view.activity.BaseToolbarActivity;
import com.dodge.hero.notemap.R;

/**
 * Created by LinZheng on 2016/10/9.
 */

public class TestToolbarActivity2 extends BaseToolbarActivity {

    private String action = "";

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
    }

    @Override
    protected void initData() {

    }
}
