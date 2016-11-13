package com.dodge.hero.notemap.view.activity.impl;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.ToastUtils;
import com.dodge.hero.commontlibrary.view.activity.BaseMVPActivity;
import com.dodge.hero.notemap.R;
import com.dodge.hero.notemap.data.model.MapPoint;
import com.dodge.hero.notemap.di.DI;
import com.dodge.hero.notemap.presenter.MapPointListPresenter;
import com.dodge.hero.notemap.view.activity.IMapPointListView;
import com.dodge.hero.notemap.view.adapter.MapPointAdapter;
import com.zhy.adapter.recyclerview.CommonAdapter;

import java.util.List;

import javax.inject.Inject;

/**
 * 描述:
 * Created by LinZheng on 2016/11/13.
 */

public class MapPointListActivity extends BaseMVPActivity<MapPointListPresenter> implements IMapPointListView{

    @Inject
    MapPointListPresenter mPresenter;

    private TextView mTvNearBy;
    private TextView mTvHistory;
    private TextView mTvSetting;
    private FrameLayout mFlContent;
    private RecyclerView mRecyclerView;

    private CommonAdapter<MapPoint> mAdapter;

    @Override
    protected MapPointListPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_map_point_list;
    }

    @Override
    public void initView() {
        DI.makeActivityComponent(this).inject(this);
        findViews();
        setClickListener();
    }

    private void findViews() {
        mTvNearBy = (TextView) findViewById(R.id.tv_near_by);
        mTvHistory = (TextView) findViewById(R.id.tv_history);
        mTvSetting = (TextView) findViewById(R.id.tv_setting);
        mFlContent = (FrameLayout) findViewById(R.id.frame_layout_content);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
    }


    private void setClickListener() {
        mTvNearBy.setOnClickListener(v ->
                ToastUtils.showShortToast(getApplicationContext(), "TODO Near By"));

        mTvHistory.setOnClickListener(v ->
                ToastUtils.showShortToast(getApplicationContext(), "TODO History"));

        mTvSetting.setOnClickListener(v ->
                ToastUtils.showShortToast(getApplicationContext(), "TODO Setting"));

    }

    @Override
    protected void initData() {
        mPresenter.attachView(this);
        mPresenter.present();
    }

    @NonNull
    @Override
    public FrameLayout getContentLayout() {
        return mFlContent;
    }

    @Override
    public void loadFirstPageSuccess(List<MapPoint> mapPoints) {
        if (mAdapter == null) {
            mAdapter = new MapPointAdapter(this, R.layout.item_map_point_lsit, mapPoints);
        }
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void loadNextPageSuccess(List<MapPoint> mapPoints) {

    }

    @Override
    public void deleteSuccess() {

    }

    @Override
    public void deleteFailure() {

    }


}
