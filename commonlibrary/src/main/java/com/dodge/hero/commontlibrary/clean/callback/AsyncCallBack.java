package com.dodge.hero.commontlibrary.clean.callback;

/**
 * Created by moo on 16/5/12.
 */
public interface AsyncCallBack<T> {
    void onSuccess(T entity);
    void onGetCacheData(T entity);
    void onFailure(int code, String message);
    void onCancel();
}
