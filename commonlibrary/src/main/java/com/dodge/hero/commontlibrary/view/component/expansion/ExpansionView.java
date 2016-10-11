package com.dodge.hero.commontlibrary.view.component.expansion;

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

    public abstract void showProgressView(String msg);

    public abstract void dismissProgressView();

    public abstract void showErrorView();

    public abstract void showErrorView(int resId, String msg);

    public abstract void dismissErrorView();

    public abstract void showEmptyView();

    public abstract void showEmptyView(int resId, String msg);

    public abstract void dismissEmptyView();

    public abstract void removeAll();

    public abstract ExpansionViewClickListener getClickListener();


    public abstract void setClickListener(ExpansionViewClickListener clickListener);


    public interface ExpansionViewClickListener {

        void onEmptyViewClick();

        void onErrorViewClick();
    }

}
