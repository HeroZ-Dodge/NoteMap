package com.dodge.hero.commontlibrary.presenter;


import com.dodge.hero.commontlibrary.view.IView;

/**
 * 描述
 * Created by LinZheng on 2016/10/8.
 */

public interface IPresenter<T extends IView, D> {

    void attachView(T view);

    void present();

    void detachView();

    void setData(D data);

    D getData();


}
