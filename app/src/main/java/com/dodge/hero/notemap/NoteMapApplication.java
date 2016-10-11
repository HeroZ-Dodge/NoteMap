package com.dodge.hero.notemap;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.dodge.hero.notemap.data.entity.DaoMaster;
import com.dodge.hero.notemap.data.entity.DaoSession;
import com.dodge.hero.notemap.di.DI;

import org.greenrobot.greendao.database.Database;

/**
 * Created by z on 2016/10/10.
 */

public class NoteMapApplication extends Application {


    public static boolean ENCRYPTED = false; // 是否加密

    DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
        DI.initialize(this);
        initGreenDao();


    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
    }


    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
