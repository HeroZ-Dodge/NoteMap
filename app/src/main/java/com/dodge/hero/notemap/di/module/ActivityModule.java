package com.dodge.hero.notemap.di.module;

import android.app.Activity;

import com.dodge.hero.notemap.di.ForActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by LinZheng on 2016/10/11.
 */

@ForActivity
@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @ForActivity
    @Provides
    Activity provideActivity() {
        return mActivity;
    }

}
