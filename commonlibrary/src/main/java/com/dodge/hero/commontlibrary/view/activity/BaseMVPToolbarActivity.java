package com.dodge.hero.commontlibrary.view.activity;

import com.dodge.hero.commontlibrary.presenter.BasePresenter;

/**
 * MVP 基础类型
 * Created by LinZheng on 2016/10/8.
 */

public abstract class BaseMVPToolbarActivity<P extends BasePresenter> extends BaseToolbarActivity {


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getPresenter() != null) {
            getPresenter().detachView();
        }
    }

    protected abstract P getPresenter();


}
