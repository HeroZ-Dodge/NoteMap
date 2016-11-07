package com.dodge.hero.commontlibrary.clean.callback;

import rx.Subscription;

/**
 * Created by moo on 16/5/17.
 */
public class RxCancelable implements ICancelable {
    private Subscription subscription;

    public RxCancelable(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public void cancel() {
        subscription.unsubscribe();
    }
}
