package com.dodge.hero.notemap.view.activity.impl;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        findViewById(R.id.btn_error).setOnClickListener(view -> {
            mExpansionView.showErrorView();
        });
        findViewById(R.id.btn_empty).setOnClickListener(view -> mExpansionView.showEmptyView());
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                Toast.makeText(MainActivity.this, "add", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
