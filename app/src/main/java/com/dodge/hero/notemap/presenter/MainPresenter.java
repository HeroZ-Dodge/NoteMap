package com.dodge.hero.notemap.presenter;

import com.dodge.hero.commontlibrary.presenter.BasePresenter;
import com.dodge.hero.notemap.view.activity.IMainActivity;

/**
 * Created by LinZheng on 2016/10/8.
 */

public class MainPresenter extends BasePresenter<IMainActivity, Object> {

    @Override
    public void present() {
        mView.showHelloWorld();
    }

}
