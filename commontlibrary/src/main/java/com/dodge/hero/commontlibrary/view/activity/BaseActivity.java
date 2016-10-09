package com.dodge.hero.commontlibrary.view.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.dodge.hero.commontlibrary.R;
import com.dodge.hero.commontlibrary.view.commont.ExpansionView;
import com.dodge.hero.commontlibrary.view.commont.ExpansionViewProvider;

/**
 * 基础Activity
 * Created by LinZheng on 2016/10/8.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected View mRootView; // 根布局

    protected Toolbar mToolbar; // 工具栏

    protected FrameLayout mFrameLayout; // 内容布局

    protected ExpansionView mExpansionView; // 扩展视图

    protected abstract int getLayoutRes();

    public abstract void initView();

    protected abstract void initData();

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        LayoutInflater inflater = getLayoutInflater();
        mRootView = inflater.inflate(R.layout.base_activity, null);
        mFrameLayout = (FrameLayout) mRootView.findViewById(R.id.content_frame_layout);
        inflater.inflate(layoutResID, mFrameLayout, true);
        super.setContentView(mRootView);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        initToolbar();
        initExpansionView();
        initView();
        initData();
    }


    /**
     * 初始化toolbar 工具栏
     */
    protected void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        if (mToolbar != null) {
            mToolbar.setNavigationIcon(getNavigationIcon());
            mToolbar.setNavigationOnClickListener(view -> onNavigationOnClick());
            mToolbar.setTitle(getTitleText());
            setSupportActionBar(mToolbar);
        }
    }

    /**
     * 初始化扩展视图
     */
    protected void initExpansionView() {
        mExpansionView = ExpansionViewProvider.DEFAULT.createExpansionView(mFrameLayout);
    }

    protected CharSequence getTitleText() {
        return getTitle();
    }

    public void setTitleStr(String titleStr) {
        if (mToolbar != null) {
            mToolbar.setTitle(titleStr);
        }
    }

    /**
     * 菜单图标
     */
    protected int getNavigationIcon() {
        return R.drawable.ic_action_menu_24dp;
    }


    public void setNavigationIcon(int resId) {
        if (mToolbar != null) {
            mToolbar.setNavigationIcon(resId);
        }
    }

    /**
     * 菜单点击事件
     */
    protected void onNavigationOnClick() {

    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
