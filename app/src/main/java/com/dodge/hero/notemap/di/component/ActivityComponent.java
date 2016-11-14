package com.dodge.hero.notemap.di.component;

import com.dodge.hero.commontlibrary.dagger.ForActivity;
import com.dodge.hero.commontlibrary.dagger.component.CommonActivityComponent;
import com.dodge.hero.commontlibrary.dagger.module.CommonActivityModule;
import com.dodge.hero.notemap.di.module.ActivityModule;
import com.dodge.hero.notemap.view.activity.impl.MainActivity;
import com.dodge.hero.notemap.view.activity.impl.MapActivity;
import com.dodge.hero.notemap.view.activity.impl.MapPointListActivity;

import dagger.Component;

/**
 * Created by LinZheng on 2016/10/11.
 */
@ForActivity
@Component(
        dependencies = AppComponent.class,
        modules = {
                CommonActivityModule.class,

                ActivityModule.class
        })
public interface ActivityComponent extends AppComponent, CommonActivityComponent {


    void inject(MapActivity activity);

    void inject(MainActivity activity);

    void inject(MapPointListActivity activity);

}
