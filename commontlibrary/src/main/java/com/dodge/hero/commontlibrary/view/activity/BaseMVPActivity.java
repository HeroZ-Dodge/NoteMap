package com.dodge.hero.commontlibrary.view.activity;

import com.dodge.hero.commontlibrary.presenter.BasePresenter;

/**
 * Created by LinZheng on 2016/10/8.
 */

public abstract class BaseMVPActivity<P extends BasePresenter> extends BaseActivity {


    protected P mPresenter;


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }


    protected abstract P getPresenter();



}
