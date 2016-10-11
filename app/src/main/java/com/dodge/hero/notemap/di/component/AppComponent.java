package com.dodge.hero.notemap.di.component;

import android.app.Application;
import android.content.Context;

import com.dodge.hero.notemap.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by LinZheng on 2016/10/11.
 */
@Singleton
@Component(
        modules = {AppModule.class}
)
public interface AppComponent {


    Context applicationContext();


    Application application();


}
