package com.dodge.hero.notemap.di.component;

import android.app.Activity;

import com.dodge.hero.notemap.di.ForActivity;
import com.dodge.hero.notemap.di.module.ActivityModule;
import com.dodge.hero.notemap.view.activity.impl.MapActivity;

import dagger.Component;

/**
 * Created by LinZheng on 2016/10/11.
 */
@ForActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent extends AppComponent {

    Activity activity();


    void inject(MapActivity activity);

}
