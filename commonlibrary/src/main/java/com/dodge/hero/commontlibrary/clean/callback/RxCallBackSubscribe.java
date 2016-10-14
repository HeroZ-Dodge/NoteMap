package com.dodge.hero.commontlibrary.clean.callback;


import com.dodge.hero.commontlibrary.BuildConfig;

/**
 * Created by moo on 16/5/17.
 */
public class RxCallBackSubscribe<T> extends RxSubscriber<T> {
    private AsyncCallBack<T> asyncCallBack;

    public RxCallBackSubscribe(AsyncCallBack<T> asyncCallBack) {
        this.asyncCallBack = asyncCallBack;
    }

    @Override
    public void onError(Throwable e) {
        this.error = true;
        boolean handled = AsyncCallBackHandler.handleFailureCalBack(e, asyncCallBack);
        if (!handled) {
            if (BuildConfig.DEBUG) {
                throw new RuntimeException(e);
            }
        }
        e.printStackTrace();
    }

    @Override
    public void onNext(T t) {
        super.onNext(t);
        AsyncCallBackHandler.handleSuccessCallBack(lastItem, asyncCallBack);
    }

    @Override
    protected void onCancel() {
        AsyncCallBackHandler.handleCancel(asyncCallBack);
    }
}
