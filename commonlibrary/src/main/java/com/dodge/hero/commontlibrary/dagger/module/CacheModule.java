package com.dodge.hero.commontlibrary.dagger.module;

import android.content.Context;


import com.z.hero.dodge.database.cache.ICache;
import com.z.hero.dodge.database.cache.impl.PreferenceCache;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by LinZheng on 2016/10/11.
 */
@Singleton
@Module
public class CacheModule {

    @Singleton
    @Provides
    ICache provideCache(Context context) {
        return new PreferenceCache(context.getSharedPreferences("rx_sf_cache", Context.MODE_PRIVATE));
    }


}
