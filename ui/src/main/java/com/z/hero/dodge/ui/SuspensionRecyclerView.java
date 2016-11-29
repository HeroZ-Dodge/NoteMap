package com.z.hero.dodge.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import java.util.MissingResourceException;

/**
 * 描述 有头部悬浮栏 RecyclerView
 * Created by Linzheng on 2016/11/29.
 */

public class SuspensionRecyclerView extends FrameLayout {

    private View mSuspensionView;       // 悬浮的控件
    private RecyclerView mRecyclerView;
    private int mSuspensionHeight;
    private int mCurrentPosition;
    private int mSuspensionType = 1000;

    private SuspensionViewChangeListener mViewChangeListener;


    public SuspensionRecyclerView(Context context) {
        super(context);
        init(context, null);
    }

    public SuspensionRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public SuspensionRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mRecyclerView = new RecyclerView(context, attrs);
        mRecyclerView.setId(R.id.suspension_recycler_view_def_id);
        addView(mRecyclerView);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SuspensionRecyclerView);
        int suspensionViewRes = ta.getResourceId(R.styleable.SuspensionRecyclerView_suspension_view, 0);
        if (suspensionViewRes != 0) {
            LayoutInflater inflater = LayoutInflater.from(context);
            mSuspensionView = inflater.inflate(suspensionViewRes, this, false);
            addView(mSuspensionView);
        } else {
            throw new MissingResourceException("miss suspension_view", getClass().getName(), "suspension_view");
        }
        ta.recycle();
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (mSuspensionHeight == 0 && mSuspensionView != null) {
                    mSuspensionHeight = mSuspensionView.getHeight();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                if (layoutManager != null && adapter != null) {
                    int currentType = -1;
                    int nextType = -1;
                    if (mCurrentPosition + 1 < adapter.getItemCount()) {
                        currentType = adapter.getItemViewType(mCurrentPosition);
                        nextType = adapter.getItemViewType(mCurrentPosition + 1);
                    }
                    if (nextType == mSuspensionType) {
                        View view = layoutManager.findViewByPosition(mCurrentPosition + 1);
                        if (view != null) {
                            if (view.getTop() <= mSuspensionHeight) {
                                mSuspensionView.setY(-(mSuspensionHeight - view.getTop()));
                            } else {
                                mSuspensionView.setY(0);
                            }
                        }

                    }

                    if (nextType == mSuspensionType && dy > 0) {            // 向上滚动
                        if (mCurrentPosition != layoutManager.findFirstVisibleItemPosition()) {
                            mCurrentPosition = layoutManager.findFirstVisibleItemPosition();
                            mSuspensionView.setY(0);
                            updateSuspensionView(mCurrentPosition);
                        }
                    } else if (currentType == mSuspensionType && dy < 0) {  // 向下滚动
                        if (mCurrentPosition != layoutManager.findFirstVisibleItemPosition()) {
                            int position = mCurrentPosition - 1;
                            if (0 < position && position < adapter.getItemCount()) {
                                int itemType = adapter.getItemViewType(position);
                                while (itemType != mSuspensionType && position > 0) {
                                    position -= 1;
                                    itemType = adapter.getItemViewType(position);
                                }
                                updateSuspensionView(position);
                            }
                            mSuspensionView.setY(0);
                            mCurrentPosition = layoutManager.findFirstVisibleItemPosition();
                        }
                    } else {
                        mCurrentPosition = layoutManager.findFirstVisibleItemPosition();
                    }
                }
            }
        });
    }

    /**
     * 更新悬浮条 的视图
     */
    private void updateSuspensionView(int currentPosition) {
        if (mViewChangeListener != null) {
            mViewChangeListener.onViewChange(mSuspensionView, currentPosition);
        }
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        mRecyclerView.setLayoutManager(layoutManager);
    }


    public RecyclerView.LayoutManager getLayoutManager() {
        return mRecyclerView.getLayoutManager();
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        mRecyclerView.setAdapter(adapter);
    }

    public RecyclerView.Adapter getAdapter() {
        return mRecyclerView.getAdapter();
    }

    public void setSuspensionType(int suspensionType) {
        mSuspensionType = suspensionType;
    }

    public SuspensionViewChangeListener getViewChangeListener() {
        return mViewChangeListener;
    }

    public void setViewChangeListener(SuspensionViewChangeListener viewChangeListener) {
        mViewChangeListener = viewChangeListener;
    }

    public interface SuspensionViewChangeListener {
        void onViewChange(View view, int position);
    }


}
