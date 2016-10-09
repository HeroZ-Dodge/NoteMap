package com.dodge.hero.notemap.view.activity.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dodge.hero.commontlibrary.view.activity.BaseActivity;
import com.dodge.hero.notemap.R;

/**
 * Created by LinZheng on 2016/10/9.
 */

public class TestActivity2 extends BaseActivity {

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
        action = getIntent().getStringExtra("action");
        setTitleStr("Test 2");
        findViewById(R.id.btn_hello).setOnClickListener(view -> {
            Intent intent = new Intent(TestActivity2.this, TestActivity3.class);
            startActivity(intent);
        });
    }

    @Override
    protected void initData() {

    }
}
