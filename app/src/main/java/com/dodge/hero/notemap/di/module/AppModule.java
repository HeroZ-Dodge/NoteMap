package com.dodge.hero.notemap.di.module;

import android.app.Application;

import com.dodge.hero.notemap.data.entity.DaoMaster;
import com.dodge.hero.notemap.data.entity.DaoSession;

import org.greenrobot.greendao.database.Database;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by LinZheng on 2016/10/11.
 */
@Module
@Singleton
public class AppModule {

    private static boolean ENCRYPTED = false; // 是否加密


    private final Application mApplication;


    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    String provideAppName() {
        return mApplication.getClass().getSimpleName();
    }

    @Provides
    @Singleton
    DaoSession provideDaoSession() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(mApplication, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        return new DaoMaster(db).newSession();
    }


}
