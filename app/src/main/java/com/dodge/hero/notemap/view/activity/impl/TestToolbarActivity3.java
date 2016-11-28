package com.dodge.hero.notemap.view.activity.impl;

import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.TextView;

import com.dodge.hero.commontlibrary.view.activity.BaseToolbarActivity;
import com.dodge.hero.notemap.R;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by LinZheng on 2016/10/9.
 */

public class TestToolbarActivity3 extends BaseToolbarActivity {

    private TextView mTvHelloMsg;
    private Button mBtnHello;


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mTvHelloMsg = (TextView) findViewById(R.id.tv_hello_msg);
        mBtnHello = (Button) findViewById(R.id.btn_hello);
    }

    @Override
    protected void initData() {
        mBtnHello.setOnClickListener(v -> {
            changeTextDrawable();
            rxjavaTest();
        });
    }

    private void changeTextDrawable() {
        Drawable drawable = getResources().getDrawable(R.drawable.ic_action_add_24dp);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        mTvHelloMsg.setCompoundDrawables(drawable, drawable, null, null);
    }


    private void rxjavaTest() {

        Observable<String> observable = Observable.just("1")
                .map(s -> {
                    Thread thread = Thread.currentThread();
                    System.out.println(thread.getName());
                    System.out.println("睡了2秒");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("醒来了");
                    return s + "map";
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Observable<String> observable1 = Observable.just("2")
                .map(s -> {
                    Thread thread = Thread.currentThread();
                    System.out.println(thread.getName());
                    System.out.println("我也睡了2秒");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("我也醒来了");
                    return s + "map";
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());


        observable.zipWith(observable1, (s, s2) -> s + s2)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        // TODO get
                        System.out.println(s);
                    }
                });

//        Observable.zip(observable, observable1, (s, s2) -> s + s2)
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        // TODO get
//                        System.out.println(s);
//                    }
//                });
    }


    private String getText1() {
        try {
            System.out.println("睡了2秒");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("醒来了");
        return "1";
    }


    private String getText2() {
        try {
            System.out.println("我也睡了2秒");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我也醒来了");
        return "13232";
    }

}
