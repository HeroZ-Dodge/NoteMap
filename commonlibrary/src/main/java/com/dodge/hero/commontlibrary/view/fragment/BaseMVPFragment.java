package com.dodge.hero.commontlibrary.view.fragment;

import com.dodge.hero.commontlibrary.presenter.BasePresenter;

/**
 * Created by LinZheng on 2016/10/8.
 */

public abstract class BaseMVPFragment<P extends BasePresenter> extends BaseFragment {


    protected P mPresenter;


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
