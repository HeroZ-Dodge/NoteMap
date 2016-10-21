package com.dodge.hero.notemap.view.activity.impl;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dodge.hero.commontlibrary.clean.callback.AsyncCallBackAdapter;
import com.dodge.hero.commontlibrary.data.database.IDatabaseManager;
import com.dodge.hero.commontlibrary.view.activity.BaseMVPActivity;
import com.dodge.hero.notemap.R;
import com.dodge.hero.notemap.data.entity.MapPoint;
import com.dodge.hero.notemap.di.DI;
import com.dodge.hero.notemap.presenter.MainPresenter;
import com.dodge.hero.notemap.view.activity.IMainActivity;

import java.util.List;

import javax.inject.Inject;


public class MainActivity extends BaseMVPActivity<MainPresenter> implements IMainActivity {


    @Inject
    IDatabaseManager mDatabaseManager;

    MainPresenter mPresenter;
    private Button mTvHello;
    private TextView mTvMsg;

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
        DI.makeActivityComponent(this).inject(this);
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
        mTvHello = (Button) findViewById(R.id.btn_hello);
        mTvMsg = (TextView) findViewById(R.id.tv_msg);
        mTvHello.setOnClickListener(view -> {
            mPresenter.start();
            Intent intent = new Intent(MainActivity.this, TestActivity2.class);
            intent.putExtra("action", "ok");
            startActivity(intent);
        });
        findViewById(R.id.btn_error).setOnClickListener(view -> {
            List mapPoints = mDatabaseManager.loadList(MapPoint.class, "WHERE NAME =? ORDER BY NAME ASC", "222");
            Log.d("GreenDao", "Size = " + mapPoints.size());
            mTvMsg.setText("Size = " + mapPoints.size());
        });
        findViewById(R.id.btn_empty).setOnClickListener(view -> {
            mDatabaseManager.save(new MapPoint(null, "222", "2342"), new AsyncCallBackAdapter<MapPoint>() {
                @Override
                public void onSuccess(MapPoint entity) {
                    Log.d("GreenDao", "save success");
                }

                @Override
                public void onFailure(int code, String message) {
                    Log.d("GreenDao", "save failure");
                }
            });
        });
        findViewById(R.id.btn_delete).setOnClickListener(v -> {
            MapPoint mapPoint = new MapPoint(null, "222", "2342");
//            List<MapPoint> list = mDatabaseManager.loadList(MapPoint.class, 3);
            mDatabaseManager.delete(mapPoint);
//            Log.d("GreenDao", "删除前三条记录");
//            mTvMsg.setText("删除前三条记录");

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
