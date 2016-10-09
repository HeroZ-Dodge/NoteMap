package com.dodge.hero.notemap.view.activity.impl;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.dodge.hero.commontlibrary.view.activity.BaseMVPActivity;
import com.dodge.hero.notemap.R;
import com.dodge.hero.notemap.presenter.MainPresenter;
import com.dodge.hero.notemap.view.activity.IMainActivity;

public class MainActivity extends BaseMVPActivity<MainPresenter> implements IMainActivity {


    MainPresenter mPresenter;
    private Button mTvHello;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
        mTvHello = (Button) findViewById(R.id.btn_hello);
        mTvHello.setOnClickListener(view -> {
            mPresenter.start();
            Intent intent = new Intent(MainActivity.this, TestActivity2.class);
            intent.putExtra("action", "ok");
            startActivity(intent);
        });
    }

    @Override
    protected void initData() {

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
