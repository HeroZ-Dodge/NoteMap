package com.dodge.hero.notemap.di.module;

import android.app.Application;

import com.dodge.hero.notemap.data.DataBaseManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by LinZheng on 2016/10/11.
 */
@Module
@Singleton
public class AppModule {


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
    DataBaseManager provideDataBaseManager() {
        return new DataBaseManager(mApplication.getApplicationContext());
    }


}
