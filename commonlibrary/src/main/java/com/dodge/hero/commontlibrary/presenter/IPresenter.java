package com.dodge.hero.commontlibrary.presenter;


import com.dodge.hero.commontlibrary.view.IView;

/**
 * Created by LinZheng on 2016/10/8.
 */

public interface IPresenter<T extends IView> {

    void attachView(T view);

    void start();

    void detachView();

}
