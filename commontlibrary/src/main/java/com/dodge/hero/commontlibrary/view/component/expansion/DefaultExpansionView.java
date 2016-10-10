package com.dodge.hero.commontlibrary.view.component.expansion;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.dodge.hero.commontlibrary.R;

/**
 * 扩展视图
 * Created by LinZheng on 2016/10/9.
 */

public class DefaultExpansionView extends ExpansionView {

    private LayoutInflater mInflater;
    private View mProgressView; // 进度视图
    private View mErrorView;    // 错误视图
    private View mEmptyView;    // 空页面

    private ExpansionViewClickListener mClickListener;


    public DefaultExpansionView(FrameLayout contentLayout) {
        this(contentLayout, new ExpansionViewConfig());
    }

    public DefaultExpansionView(FrameLayout contentLayout, ExpansionViewConfig viewConfig) {
        super(contentLayout, viewConfig);
        mInflater = LayoutInflater.from(contentLayout.getContext());
    }

    public ExpansionViewClickListener getClickListener() {
        return mClickListener;
    }

    public void setClickListener(ExpansionViewClickListener clickListener) {
        mClickListener = clickListener;
    }

    @Override
    public void showProgressView() {
        showProgressView(null);
    }

    @Override
    public void showProgressView(String msg) {
        if (mProgressView == null) {
            mProgressView = mInflater.inflate(mViewConfig.mProgressViewRes, mContentLayout, false);
        }
        if (mProgressView.getParent() == null) {
            if (!TextUtils.isEmpty(msg)) {
                TextView textView = (TextView) mProgressView.findViewById(R.id.tv_progress_msg);
                textView.setText(msg);
            }
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
        showErrorView(0, null);
    }

    @Override
    public void showErrorView(int resId, String msg) {
        if (mErrorView == null) {
            mErrorView = mInflater.inflate(mViewConfig.mErrorViewRes, mContentLayout, false);
            mErrorView.setOnClickListener(view -> {
                if (mClickListener != null) {
                    mClickListener.onErrorViewClick();
                }
            });
        }
        if (mErrorView.getParent() == null) {
            if (resId != 0) {
                ImageView imageView = (ImageView) mErrorView.findViewById(R.id.iv_error);
                imageView.setImageResource(resId);
            }
            if (!TextUtils.isEmpty(msg)) {
                TextView textView = (TextView) mErrorView.findViewById(R.id.tv_error_msg);
                textView.setText(msg);
            }
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
        showEmptyView(0, null);
    }

    @Override
    public void showEmptyView(int resId, String msg) {
        if (mEmptyView == null) {
            mEmptyView = mInflater.inflate(mViewConfig.mEmptyViewRes, mContentLayout, false);
            mEmptyView.setOnClickListener(view -> {
                if (mClickListener != null) {
                    mClickListener.onEmptyViewClick();
                }
            });
        }
        if (mEmptyView.getParent() == null) {
            if (resId != 0) {
                ImageView imageView = (ImageView) mEmptyView.findViewById(R.id.iv_empty);
                imageView.setImageResource(resId);
            }
            if (!TextUtils.isEmpty(msg)) {
                TextView textView = (TextView) mEmptyView.findViewById(R.id.tv_empty_msg);
                textView.setText(msg);
            }
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
