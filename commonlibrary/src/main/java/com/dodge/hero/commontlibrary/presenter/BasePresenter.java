package com.dodge.hero.commontlibrary.presenter;


import com.dodge.hero.commontlibrary.view.IView;

/**
 * Created by LinZheng on 2016/10/8.
 */

public abstract class BasePresenter<T extends IView> implements IPresenter<T> {

    protected static final String TAG = "BasePresenter";
    protected T mView;

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    public boolean isViewAttached() {
        return mView != null;
    }

    public T getView() {
        return mView;
    }

}
