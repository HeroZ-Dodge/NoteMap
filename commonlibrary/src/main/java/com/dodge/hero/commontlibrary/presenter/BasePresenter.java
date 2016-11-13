package com.dodge.hero.commontlibrary.presenter;


import com.dodge.hero.commontlibrary.view.IView;

/**
 * Created by LinZheng on 2016/10/8.
 */

public abstract class BasePresenter<T extends IView, D> implements IPresenter<T, D> {

    protected T mView;
    protected D mData;

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

    @Override
    public void setData(D data) {
        mData = data;
    }

    @Override
    public D getData() {
        return mData;
    }
}
