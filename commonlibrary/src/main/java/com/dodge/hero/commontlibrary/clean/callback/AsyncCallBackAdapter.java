package com.dodge.hero.commontlibrary.clean.callback;

/**
 * Created by moo on 16/5/17.
 */
public abstract class AsyncCallBackAdapter<T> implements AsyncCallBack<T> {

    @Override
    public void onGetCacheData(T entity) {

    }

    @Override
    public void onCancel() {

    }
}
