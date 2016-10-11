package com.dodge.hero.commontlibrary.dagger.component;

import android.app.Application;
import android.content.Context;

import com.dodge.hero.commontlibrary.dagger.module.CacheModule;
import com.dodge.hero.commontlibrary.dagger.module.CommonAppModule;
import com.dodge.hero.commontlibrary.data.cache.ICache;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by LinZheng on 2016/10/11.
 */
@Singleton
@Component(
        modules = {
                CommonAppModule.class,
                CacheModule.class
        }
)
public interface CommonAppComponent {

    Context applicationContext();


    Application application();

    ICache cache();

}
