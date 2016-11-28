package com.dodge.hero.notemap.view.activity.impl;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dodge.hero.commontlibrary.view.activity.BaseMVPToolbarActivity;
import com.dodge.hero.notemap.R;
import com.dodge.hero.notemap.data.model.TestUser;
import com.dodge.hero.notemap.presenter.MainPresenter;
import com.dodge.hero.notemap.view.activity.IMainActivity;
import com.dodge.hero.notemap.view.expansion.GiftAnimExpansionView;
import com.dodge.hero.notemap.view.expansion.IGiftAnimExpansionView;
import com.google.gson.Gson;


public class MainToolbarActivity extends BaseMVPToolbarActivity<MainPresenter> implements IMainActivity {

    MainPresenter mPresenter;
    private Button mTvHello;
    private Button mBtnError;
    private TextView mTvMsg;

    private IGiftAnimExpansionView mGiftAnimExpansionView;

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
        mTvHello = (Button) findViewById(R.id.btn_hello);
        mTvMsg = (TextView) findViewById(R.id.tv_msg);
        mBtnError = (Button) findViewById(R.id.btn_error);
        mGiftAnimExpansionView = new GiftAnimExpansionView(this, mFrameLayout);
        mTvHello.setOnClickListener(v -> mGiftAnimExpansionView.showFlowerAnim(0));
        mBtnError.setOnClickListener(v -> mGiftAnimExpansionView.showRewardAnim(0));
    }

    @Override
    protected void initData() {

    }

    private void testUser() {
        Gson gson = new Gson();
        TestUser testUser = new TestUser(1l, "address", 2);
        testUser.setName("name");
        String json = gson.toJson(testUser);
        Log.d("json", json);
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
                Toast.makeText(MainToolbarActivity.this, "add", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
