package com.dodge.hero.notemap.di;

import android.app.Activity;
import android.app.Application;

import com.dodge.hero.notemap.di.component.ActivityComponent;
import com.dodge.hero.notemap.di.component.AppComponent;
import com.dodge.hero.notemap.di.component.DaggerActivityComponent;
import com.dodge.hero.notemap.di.component.DaggerAppComponent;
import com.dodge.hero.notemap.di.module.ActivityModule;
import com.dodge.hero.notemap.di.module.AppModule;

/**
 * Created by LinZheng on 2016/10/11.
 */

public class DI {

    private static AppComponent mAppComponent;


    public static void initialize(Application application) {
        initComponent(application);
    }

    private static void initComponent(Application application) {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }


    public static AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static ActivityComponent makeActivityComponent(Activity activity) {
        return  DaggerActivityComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(new ActivityModule(activity))
                .build();
    }


}
