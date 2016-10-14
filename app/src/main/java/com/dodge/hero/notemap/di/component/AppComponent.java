package com.dodge.hero.notemap.di.component;

import com.dodge.hero.commontlibrary.dagger.component.CommonAppComponent;
import com.dodge.hero.commontlibrary.dagger.module.CacheModule;
import com.dodge.hero.commontlibrary.dagger.module.CommonAppModule;
import com.dodge.hero.commontlibrary.data.database.IDatabaseManager;
import com.dodge.hero.notemap.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by LinZheng on 2016/10/11.
 */
@Singleton
@Component(
        modules = {
                CommonAppModule.class,
                CacheModule.class,

                AppModule.class
        }
)
public interface AppComponent extends CommonAppComponent {


        String appName();

        IDatabaseManager databaseManager();

}
