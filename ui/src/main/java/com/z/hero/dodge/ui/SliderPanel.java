package com.z.hero.dodge.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;


/**
 * Created by Luoweiqiang on 2015/8/12 0012.
 */
public class SliderPanel extends FrameLayout {
    private static final String TAG = "SliderPanel";

    //手指向右滑动时的最小距离
    private static final int XDISTANCE_MIN = 200;
    private static final float DIM_VIEW_ALPHA = 0.8f;
    private static final int ANIM_DURATION_LONG = 250;
    private static final int ANIM_DURATION = 150;
    //记录手指按下时的横坐标。
    private float xDown = 0;
    private float yDown = 0;
    private boolean isDraging = false;
    private View mDimView;
    private View mContentView;
    private Activity mActivity;
    private int mScreenWidth;
    private int mTouchSlop;

    public SliderPanel(Activity activity, View contentView) {
        super(activity);
        init(activity, contentView);
    }

    private void init(Activity activity, View contentView) {
//        ViewGroupCompat.setMotionEventSplittingEnabled(this, false);
        mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        mActivity = activity;
        mTouchSlop = ViewConfiguration.get(mActivity).getScaledPagingTouchSlop();
        mContentView = contentView;
        mContentView.setBackgroundResource(android.R.color.transparent);
        mDimView = new View(mActivity);
        mDimView.setBackgroundResource(android.R.color.transparent);
        mDimView.setAlpha(DIM_VIEW_ALPHA);
        addView(mDimView);
        addView(mContentView);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        int distanceX = 0;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xDown = event.getRawX();
                yDown = event.getRawY();
                isDraging = false;
                break;
            case MotionEvent.ACTION_MOVE:
                //活动的距离
                distanceX = (int) (event.getRawX() - xDown);
                float distanceY = Math.abs(event.getRawY() - yDown);
                if (!isDraging && distanceX > mTouchSlop && distanceX > distanceY && distanceY < mTouchSlop && xDown < mScreenWidth / 4) {
//                    Log.d("test","distanceX = " + distanceX + " distanceY = " + distanceY + " yDown = " + yDown);
                    isDraging = true;
                }
                break;
            case MotionEvent.ACTION_UP:

                break;
            default:
                break;
        }
        return isDraging || super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int distanceX = 0;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xDown = event.getRawX();
                yDown = event.getRawY();
                isDraging = true;
                break;
            case MotionEvent.ACTION_MOVE:
                if (isDraging && mContentView != null) {
                    distanceX = (int) (event.getRawX() - xDown);
                    if (distanceX > 0) {
                        mContentView.setTranslationX(distanceX);
                        float tmp = DIM_VIEW_ALPHA - (DIM_VIEW_ALPHA * distanceX / mScreenWidth);
                        mDimView.setAlpha(tmp);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                if (isDraging) {
                    //活动的距离
                    distanceX = (int) (event.getRawX() - xDown);
                    if (distanceX > XDISTANCE_MIN) {
                        ValueAnimator animation = ValueAnimator.ofInt(distanceX, mScreenWidth);
                        animation.setDuration(ANIM_DURATION_LONG);
                        animation.setInterpolator(new LinearInterpolator());
                        animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {
                                int value = (Integer) animation.getAnimatedValue();
                                mContentView.setTranslationX(value);
                                mDimView.setAlpha(DIM_VIEW_ALPHA - (DIM_VIEW_ALPHA * value / mScreenWidth));
                                if (value == mScreenWidth) {
                                    mActivity.finish();
                                }
                            }

                        });
                        animation.start();
                    } else if (mContentView.getTranslationX() > 0) {
                        ValueAnimator animation = ValueAnimator.ofInt((int) mContentView.getTranslationX(), 0);
                        animation.setDuration(ANIM_DURATION);
                        animation.setInterpolator(new LinearInterpolator());
                        animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {
                                int value = (Integer) animation.getAnimatedValue();
                                mContentView.setTranslationX(value);
                                mDimView.setAlpha(DIM_VIEW_ALPHA - (DIM_VIEW_ALPHA * value / mScreenWidth));
                            }
                        });
                        animation.start();
                    }
                }
                break;
            default:
                break;
        }
        return isDraging || super.onTouchEvent(event);
    }
}
