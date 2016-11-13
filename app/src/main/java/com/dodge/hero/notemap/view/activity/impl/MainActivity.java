package com.dodge.hero.notemap.view.activity.impl;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dodge.hero.commontlibrary.data.database.IDatabaseManager;
import com.dodge.hero.commontlibrary.view.activity.BaseMVPActivity;
import com.dodge.hero.notemap.R;
import com.dodge.hero.notemap.data.model.TestUser;
import com.dodge.hero.notemap.di.DI;
import com.dodge.hero.notemap.presenter.MainPresenter;
import com.dodge.hero.notemap.view.activity.IMainActivity;
import com.google.gson.Gson;

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
//        mPresenter = new MainPresenter();
//        mPresenter.attachView(this);
//        mTvHello = (Button) findViewById(R.id.btn_hello);
//        mTvMsg = (TextView) findViewById(R.id.tv_msg);
//        mTvHello.setOnClickListener(view -> {
//            mPresenter.present();
//            Intent intent = new Intent(MainActivity.this, TestActivity2.class);
//            intent.putExtra("action", "ok");
//            startActivity(intent);
//        });
//        findViewById(R.id.btn_error).setOnClickListener(view -> {
//            List mapPoints = mDatabaseManager.loadList(MapPoint.class, "WHERE NAME =? ORDER BY NAME ASC", "222");
//            Log.d("GreenDao", "Size = " + mapPoints.size());
//            mTvMsg.setText("Size = " + mapPoints.size());
//        });
//        findViewById(R.id.btn_empty).setOnClickListener(view -> {
//            mDatabaseManager.insert(new MapPoint(null, "222", "2342"), new AsyncCallBackAdapter<MapPoint>() {
//                @Override
//                public void onSuccess(MapPoint entity) {
//                    Log.d("GreenDao", "insert success");
//                }
//
//                @Override
//                public void onFailure(int code, String message) {
//                    Log.d("GreenDao", "insert failure");
//                }
//            });
//        });
//        findViewById(R.id.btn_delete).setOnClickListener(v -> {
////            AbstractDao<TestUser, ?> dao = mDatabaseManager.getDao(TestUser.class);
////            dao.queryBuilder()
////                    .where(TestUserDao.Properties.Address.eq("1111"))
////                    .whereOr(TestUserDao.Properties.YearsOld.eq("2"), TestUserDao.Properties.MId.eq(""))
////                    .build()
////                    .list();
////            MapPoint mapPoint = new MapPoint(null, "222", "2342");
//////            List<MapPoint> list = mDatabaseManager.loadList(MapPoint.class, 3);
////            mDatabaseManager.delete(mapPoint);
//////            Log.d("GreenDao", "删除前三条记录");
//////            mTvMsg.setText("删除前三条记录");
////            TestDialog dialog = new TestDialog();
//            GiftsFullScreenDialog dialog = new GiftsFullScreenDialog();
//            dialog.show(getSupportFragmentManager(), "Dialog");
//
//        });
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
                Toast.makeText(MainActivity.this, "add", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }





}
