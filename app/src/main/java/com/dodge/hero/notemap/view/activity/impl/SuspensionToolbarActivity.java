package com.dodge.hero.notemap.view.activity.impl;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dodge.hero.commontlibrary.view.activity.BaseToolbarActivity;
import com.dodge.hero.notemap.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LinZheng on 2016/11/8.
 */

public class SuspensionToolbarActivity extends BaseToolbarActivity {

    private RecyclerView mRecyclerView;
    private TextView mTvHead;
    private int mHeadHeight;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_suspension;
    }

    @Override
    public void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mTvHead = (TextView) findViewById(R.id.tv_head);
    }


    private int mCurrentPosition;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void initData() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            strings.add("Index = " + (i + 1));
        }
        mLayoutManager = new LinearLayoutManager(this);
        MyAdapter myAdapter = new MyAdapter(strings);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(myAdapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (mHeadHeight == 0) {
                    if (mTvHead != null) {
                        mHeadHeight = mTvHead.getHeight();
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //找到列表第二个可见的View
                View view = mLayoutManager.findViewByPosition(mCurrentPosition + 1);
                if (view == null) return;
                //判断View的top值是否小于悬浮条的高度
                if (view.getTop() <= mTvHead.getHeight()) {
                    //被顶掉的效果
                    mTvHead.setY(-(mTvHead.getHeight() - view.getTop()));
                } else {
                    mTvHead.setY(0);
                }

                //判断是否需要更新悬浮条
                if (mCurrentPosition != mLayoutManager.findFirstVisibleItemPosition()) {
                    mCurrentPosition = mLayoutManager.findFirstVisibleItemPosition();
                    mTvHead.setY(0);
                    //更新悬浮条
                    updateSuspensionBar(mCurrentPosition);
                }
            }
        });


    }

    private void updateSuspensionBar(int currentPosition) {
        Log.d("updateSuspensionBar", "Position = " + currentPosition);
    }


    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        private List<String> mData;


        public MyAdapter(List<String> data) {
            mData = data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(SuspensionToolbarActivity.this);
            return new MyViewHolder(inflater.inflate(R.layout.item_recycler_view_msg, parent, false));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.bindView(mData.get(position));
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
    }


    private class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
        }

        public void bindView(String msg) {
            mTextView = (TextView) itemView.findViewById(R.id.tv_item);
            mTextView.setText(msg);
        }

    }


}
