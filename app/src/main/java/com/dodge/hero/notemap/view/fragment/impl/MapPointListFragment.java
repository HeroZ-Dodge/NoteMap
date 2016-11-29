package com.dodge.hero.notemap.view.fragment.impl;

import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.dodge.hero.commontlibrary.view.component.expansion.ExpansionView;
import com.dodge.hero.commontlibrary.view.component.expansion.ExpansionViewProvider;
import com.dodge.hero.commontlibrary.view.fragment.BaseMVPFragment;
import com.dodge.hero.notemap.R;
import com.dodge.hero.notemap.data.model.MapPoint;
import com.dodge.hero.notemap.presenter.MapPointListPresenter;
import com.dodge.hero.notemap.view.fragment.IMapPointListView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/**
 * 描述
 * Created by Linzheng on 2016/11/25.
 */

public class MapPointListFragment extends BaseMVPFragment<MapPointListPresenter> implements IMapPointListView {

    private FrameLayout mFrameLayout;
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mFrameLayout == null) {
            mFrameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_recycler_view, container, false);
        }
        return mFrameLayout;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) mFrameLayout.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void loadFirstPageSuccess(List<MapPoint> mapPoints) {

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

    @NonNull
    @Override
    public ExpansionView getExpansionView() {
        return ExpansionViewProvider.DEFAULT.createExpansionView(mFrameLayout);
    }

    @NonNull
    @Override
    public FrameLayout getContentLayout() {
        return mFrameLayout;
    }
}
