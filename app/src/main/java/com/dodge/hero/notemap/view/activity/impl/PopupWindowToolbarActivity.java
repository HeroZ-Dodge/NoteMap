package com.dodge.hero.notemap.view.activity.impl;

import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.dodge.hero.commontlibrary.view.activity.BaseToolbarActivity;
import com.dodge.hero.notemap.R;

/**
 * Created by LinZheng on 2016/11/11.
 */

public class PopupWindowToolbarActivity extends BaseToolbarActivity {

    private View mBtnLeft;
    private View mBtnRight;
    PopupWindow mPopupWindow;




    @Override
    protected int getLayoutRes() {
        return R.layout.activity_pupup_window;
    }

    @Override
    public void initView() {
        mBtnLeft = findViewById(R.id.btn_left);
        mBtnRight = findViewById(R.id.btn_right);
        mBtnLeft.setOnClickListener(v -> {
            getPopupWindow().showAsDropDown(mBtnLeft);
        });

        mBtnRight.setOnClickListener(v -> {
            getPopupWindow().showAtLocation(mBtnRight, Gravity.BOTTOM, 0, 0);
//            getPopupWindow().showAsDropDown(mBtnRight);
        });
    }


    private PopupWindow getPopupWindow() {
        if (mPopupWindow == null) {
            RecyclerView recyclerView = (RecyclerView) getLayoutInflater().inflate(R.layout.recyler_view, null);
            setupRecyclerView(recyclerView);
            mPopupWindow = new PopupWindow(recyclerView, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            mPopupWindow.setTouchable(true);
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            shapeDrawable.getPaint().setColor(Color.TRANSPARENT);
            mPopupWindow.setBackgroundDrawable(shapeDrawable);
            mPopupWindow.setOutsideTouchable(true);

        }
        return mPopupWindow;
    }


    private void setupRecyclerView(RecyclerView recyclerView) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MyAdapter());

    }


    private class MyAdapter extends RecyclerView.Adapter {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.item_msg, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }


    @Override
    protected void initData() {

    }
}
