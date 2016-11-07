package com.dodge.hero.commontlibrary.dagger.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by LinZheng on 2016/10/11.
 */
@Singleton
@Module
public class CommonAppModule {

    private final Application mApplication;


    public CommonAppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return this.mApplication;
    }

    @Provides
    @Singleton
    Context provideAppContext() {
        return this.mApplication.getApplicationContext();
    }

}
