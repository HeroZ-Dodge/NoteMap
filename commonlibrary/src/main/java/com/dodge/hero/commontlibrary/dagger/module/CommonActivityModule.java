package com.dodge.hero.commontlibrary.dagger.module;

import android.app.Activity;

import com.dodge.hero.commontlibrary.dagger.ForActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by LinZheng on 2016/10/11.
 */
@ForActivity
@Module
public class CommonActivityModule {

    private final Activity mActivity;

    public CommonActivityModule(Activity activity) {
        mActivity = activity;
    }

    @ForActivity
    @Provides
    Activity provideActivity() {
        return mActivity;
    }


}
