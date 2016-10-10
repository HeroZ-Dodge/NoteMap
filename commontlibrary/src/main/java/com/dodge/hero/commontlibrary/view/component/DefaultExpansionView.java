package com.dodge.hero.commontlibrary.view.component;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

/**
 * 扩展视图
 * Created by LinZheng on 2016/10/9.
 */

public class DefaultExpansionView extends ExpansionView {

    private LayoutInflater mInflater;
    private View mProgressView; // 进度视图
    private View mErrorView;    // 错误视图
    private View mEmptyView;    // 空页面


    public DefaultExpansionView(FrameLayout contentLayout) {
        this(contentLayout, new ExpansionViewConfig());
    }

    public DefaultExpansionView(FrameLayout contentLayout, ExpansionViewConfig viewConfig) {
        super(contentLayout, viewConfig);
        mInflater = LayoutInflater.from(contentLayout.getContext());
    }

    @Override
    public void showProgressView() {
        if (mProgressView == null) {
            mProgressView = mInflater.inflate(mViewConfig.mProgressViewRes, mContentLayout, false);
        }
        if (mProgressView.getParent() == null) {
            mContentLayout.addView(mProgressView);
        }
    }

    @Override
    public void dismissProgressView() {
        if (mProgressView != null) {
            mContentLayout.removeView(mProgressView);
        }
    }

    @Override
    public void showErrorView() {
        if (mErrorView == null) {
            mErrorView = mInflater.inflate(mViewConfig.mErrorViewRes, mContentLayout, false);
        }
        if (mErrorView.getParent() == null) {
            mContentLayout.addView(mErrorView);
        }
    }

    @Override
    public void dismissErrorView() {
        if (mErrorView != null) {
            mContentLayout.removeView(mErrorView);
        }
    }

    @Override
    public void showEmptyView() {
        if (mEmptyView == null) {
            mEmptyView = mInflater.inflate(mViewConfig.mEmptyViewRes, mContentLayout, false);
        }
        if (mEmptyView.getParent() == null) {
            mContentLayout.addView(mEmptyView);
        }
    }

    @Override
    public void dismissEmptyView() {
        if (mEmptyView != null) {
            mContentLayout.removeView(mEmptyView);
        }
    }

    @Override
    public void removeAll() {
        dismissProgressView();
        dismissErrorView();
        dismissEmptyView();
    }
}
