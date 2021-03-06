package com.dodge.hero.notemap.di.module;

import android.app.Application;

import com.dodge.hero.notemap.dao.DaoMaster;
import com.dodge.hero.notemap.dao.DaoSession;
import com.dodge.hero.notemap.data.db.DBOpenHelper;
import com.z.hero.dodge.database.db.IDatabaseManager;
import com.z.hero.dodge.database.db.impl.GreenDaoManager;

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


    public static boolean ENCRYPTED = false;
    public static final String DATA_BASE_NAME = "ai_pai_db";
    public static final String DATA_BASE_NAME_ENCRYPTED = "ai_pai_db_encrypted";
    public static final String DATA_BASE_PASSWORD = "super-secret";

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
    IDatabaseManager provideDatabaseManager(Application application) {
        DaoMaster.OpenHelper helper = new DBOpenHelper(application, ENCRYPTED ? DATA_BASE_NAME_ENCRYPTED : DATA_BASE_NAME);
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb(DATA_BASE_PASSWORD) : helper.getWritableDb();
        DaoSession session = new DaoMaster(db).newSession();
        return new GreenDaoManager(session);
    }

}
