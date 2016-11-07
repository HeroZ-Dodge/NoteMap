package com.dodge.hero.commontlibrary.clean.callback;

/**
 * Created by LinZheng on 2016/10/14.
 */

import android.util.Log;

import rx.Subscriber;

/**
 * Default subscriber base class to be used whenever you want default error handling.
 */
public class RxSubscriber<T> extends Subscriber<T> {
    private static final String TAG = RxSubscriber.class.getSimpleName();

    protected boolean completed;
    protected boolean canceled;
    protected boolean error;

    protected T lastItem;

    public RxSubscriber(){
        this.add(new SubscriptionForCancel() {
            @Override
            protected void onUnsubscribe() {
                RxSubscriber.this.onUnsubscribe();
            }
        });
    }

    private void onUnsubscribe(){
        if(!isCompleted()) {
            Log.i(TAG, "onUnsubscribe");
            this.canceled = true;

            onCancel();
        }
    }

    protected void onCancel(){
    }

    protected void onCompleted(T lastItem){
    }

    @Override
    public void onCompleted() {
        Log.i(TAG, "onCompleted");
        this.completed = true;
        onCompleted(lastItem);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        error = true;
    }

    @Override
    public void onNext(T t) {
        Log.i(TAG, "onNext:" + t);
        lastItem = t;
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public boolean isError() {
        return error;
    }
}

