package com.dodge.hero.notemap.view.activity.impl;

import android.os.Bundle;
import android.widget.Toast;

import com.dodge.hero.commontlibrary.view.activity.BaseMVPActivity;
import com.dodge.hero.notemap.R;
import com.dodge.hero.notemap.presenter.MainPresenter;
import com.dodge.hero.notemap.view.activity.IMainActivity;

public class MainActivity extends BaseMVPActivity<MainPresenter> implements IMainActivity{


    MainPresenter mPresenter;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
        findViewById(R.id.btn_hello).setOnClickListener(view -> {
            mPresenter.start();
        });
    }

    @Override
    public void showHelloWorld() {
        Toast.makeText(this, "hello world", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected MainPresenter getPresenter() {
        return mPresenter;
    }
}
