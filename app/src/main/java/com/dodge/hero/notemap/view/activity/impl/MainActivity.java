package com.dodge.hero.notemap.view.activity.impl;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.dodge.hero.commontlibrary.view.activity.BaseMVPActivity;
import com.dodge.hero.notemap.R;
import com.dodge.hero.notemap.data.DataBaseManager;
import com.dodge.hero.notemap.data.entity.MapPoint;
import com.dodge.hero.notemap.di.DI;
import com.dodge.hero.notemap.presenter.MainPresenter;
import com.dodge.hero.notemap.view.activity.IMainActivity;

import org.greenrobot.greendao.AbstractDao;

import java.util.List;

import javax.inject.Inject;


public class MainActivity extends BaseMVPActivity<MainPresenter> implements IMainActivity {


    @Inject
    DataBaseManager mDataBaseManager;

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
        DI.makeActivityComponent(this).inject(this);
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
            List mapPoints = mDataBaseManager.loadList(MapPoint.class, 10);
            Log.d("GreenDao", "Size = " + mapPoints.size());
        });
        findViewById(R.id.btn_empty).setOnClickListener(view -> {
            AbstractDao<MapPoint, ?> dao = mDataBaseManager.getDao(MapPoint.class);
            dao.save(new MapPoint(null, "222", "2342"));
        });
        findViewById(R.id.btn_delete).setOnClickListener(v -> {
            AbstractDao<MapPoint, ?> dao = mDataBaseManager.getDao(MapPoint.class);
//            List<MapPoint> mapPoints = dao.queryBuilder()
//                    .offset(5)
//                    .limit(Integer.MAX_VALUE)
//                    .list();
//            dao.deleteInTx(mapPoints);
            dao.loadByRowId(5);
            String sql  = "delete from MAP_POINT where _id in (select _id from MAP_POINT order by _id limit 1, 5)";
//            String sql  = "SELECT T.\"_id\",T.\"NAME\",T.\"ADDRESS\" FROM \"MAP_POINT\" T WHERE ROWID=?";

            dao.getDatabase()
                    .execSQL(sql);
            Log.d("GreenDao", "记录大于5,删除记录");

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
