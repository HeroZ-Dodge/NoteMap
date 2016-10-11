package com.dodge.hero.commontlibrary.dagger.component;

import android.app.Activity;

import com.dodge.hero.commontlibrary.dagger.ForActivity;
import com.dodge.hero.commontlibrary.dagger.module.CommonActivityModule;

import dagger.Component;

/**
 * Created by LinZheng on 2016/10/11.
 */
@ForActivity
@Component(dependencies = CommonAppComponent.class, modules = CommonActivityModule.class)
public interface CommonActivityComponent {

    Activity activity();


}
