package com.dodge.hero.notemap.data.db;

import android.content.Context;
import android.util.Log;

import com.dodge.hero.notemap.dao.DaoMaster;

import org.greenrobot.greendao.database.Database;


/**
 * Created by LinZheng on 2016/10/14.
 */

public class DBOpenHelper extends DaoMaster.OpenHelper {

    public final String TAG = getClass().getSimpleName();

    public DBOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onOpen(Database db) {
        super.onOpen(db);
        Log.d(TAG, "onPen");
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
        Log.d(TAG, "onCreate");
        saveOldData();
    }

    /**
     * 迁移之前版本的数据
     */
    private void saveOldData() {



    }


    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        DaoMaster.createAllTables(db, true);
        Log.d(TAG, "oldVersion = " + oldVersion + "| newVersion = " + newVersion);
        Log.d(TAG, "onUpgrade");
    }


}
