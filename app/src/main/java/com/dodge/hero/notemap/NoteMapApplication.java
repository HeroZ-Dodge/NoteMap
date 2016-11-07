package com.dodge.hero.notemap;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.dodge.hero.notemap.di.DI;

/**
 * Created by z on 2016/10/10.
 */

public class NoteMapApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
        DI.initialize(this);
    }

}
