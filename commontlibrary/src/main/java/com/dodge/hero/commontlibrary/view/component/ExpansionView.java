package com.dodge.hero.commontlibrary.view.component;

import android.widget.FrameLayout;

/**
 * Created by LinZheng on 2016/10/9.
 */

public abstract class ExpansionView {

    protected FrameLayout mContentLayout;
    protected ExpansionViewConfig mViewConfig;


    public ExpansionView(FrameLayout contentLayout, ExpansionViewConfig viewConfig) {
        mContentLayout = contentLayout;
        mViewConfig = viewConfig;
    }

    public abstract void showProgressView();

    public abstract void dismissProgressView();

    public abstract void showErrorView();

    public abstract void dismissErrorView();

    public abstract void showEmptyView();

    public abstract void dismissEmptyView();

    public abstract void removeAll();


}
