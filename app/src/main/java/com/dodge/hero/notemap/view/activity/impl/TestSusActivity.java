package com.dodge.hero.notemap.view.activity.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.dodge.hero.commontlibrary.view.activity.BaseActivity;
import com.dodge.hero.notemap.R;
import com.z.hero.dodge.ui.SuspensionRecyclerView;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 * Created by Linzheng on 2016/11/29.
 */

public class TestSusActivity extends BaseActivity {


    private SuspensionRecyclerView mSusView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sus);

        mSusView = (SuspensionRecyclerView) findViewById(R.id.sus_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mSusView.setLayoutManager(layoutManager);
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(i);
        }

        mSusView.setSuspensionType(1000);
        MultiItemTypeAdapter<Integer> adapter = new MultiItemTypeAdapter<>(this, data);
        adapter.addItemViewDelegate(1000, new ItemViewDelegate<Integer>() {
            @Override
            public int getItemViewLayoutId() {
                return R.layout.item_sus_view;
            }

            @Override
            public boolean isForViewType(Integer item, int position) {
                return position % 4 == 0;
            }

            @Override
            public void convert(ViewHolder holder, Integer integer, int position) {
                holder.setText(R.id.tv_head, "" + position);
            }
        });


        adapter.addItemViewDelegate(2, new ItemViewDelegate<Integer>() {
            @Override
            public int getItemViewLayoutId() {
                return R.layout.item_recycler_view_msg;
            }

            @Override
            public boolean isForViewType(Integer item, int position) {
                return position % 4 != 0;
            }

            @Override
            public void convert(ViewHolder holder, Integer integer, int position) {

            }
        });
        mSusView.setViewChangeListener((view, position) -> {
            TextView textView = (TextView) view.findViewById(R.id.tv_head);
            textView.setText("" + position);
        });
        mSusView.setAdapter(adapter);
    }






}
