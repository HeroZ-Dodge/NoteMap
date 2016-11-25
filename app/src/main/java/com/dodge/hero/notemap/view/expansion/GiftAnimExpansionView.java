package com.dodge.hero.notemap.view.expansion;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.dodge.hero.notemap.R;

import org.greenrobot.greendao.annotation.NotNull;

/**
 * 描述:
 * Created by LinZheng on 2016/11/21.
 */
public class GiftAnimExpansionView implements IGiftAnimExpansionView {

    private final Context mContext;
    private int mFlowerAnimRes = R.layout.item_msg;
    private int mRewardAnimRes = R.layout.item_recycler_view_msg;
    private int mGiftAnimRes = R.layout.item_msg;

    private ViewGroup mContentView;
    private LayoutInflater mInflater;

    private View mFlowerAnimView;
    private View mRewardAnimView;
    private View mGiftAnimView;

    private Handler mHandler;


    public GiftAnimExpansionView(Context context, @NotNull ViewGroup contentView) {
        this.mContext = context;
        this.mContentView = contentView;
        mInflater = LayoutInflater.from(mContext);
        mHandler = new Handler();

    }

    @Override
    public void showFlowerAnim(int count) {
//        cancelRewardAnim();

        try {
            if (mFlowerAnimView == null) {
                mFlowerAnimView = mInflater.inflate(mFlowerAnimRes, mContentView, false);
            }
            if (mFlowerAnimView.getParent() == null) {
                Log.d("flower", "add");
                mContentView.addView(mFlowerAnimView);
                startFlowerAnim();
            } else {
                if (mFlowerAnimView.getAnimation() != null) {
                    mFlowerAnimView.getAnimation().start();
                    Log.d("flower", "重启动画");
                } else {
                    Log.d("flower", "设置新的动画");
                    startFlowerAnim();
                }
            }
        } catch (Exception e) {
            Log.d("bug", e.getMessage());
        }


    }

    private void startFlowerAnim() {
        Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.anim_fade_out);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d("flower", "动画结束");
                removeView(mFlowerAnimView);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        try {
            mFlowerAnimView.startAnimation(animation);

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("bug", "!!");
        }
        Log.d("showFlowerAnim", mContentView.getChildCount() + "个");
    }

    @Override
    public void cancelFlowerAnim() {
        if (mFlowerAnimView != null) {
            mFlowerAnimView.clearAnimation();
        }
        removeView(mFlowerAnimView);
        Log.d("cancelFlowerAnim", mContentView.getChildCount() + "个");
    }

    @Override
    public void showRewardAnim(int count) {
//        cancelFlowerAnim();
        if (mRewardAnimView == null) {
            mRewardAnimView = mInflater.inflate(mRewardAnimRes, mContentView, false);
        }
        if (mRewardAnimView.getParent() == null) {
            mContentView.addView(mRewardAnimView);
            startRewardAnim();
        } else {
            if (mRewardAnimView.getAnimation() != null) {
                mRewardAnimView.getAnimation().start();
            } else {
                startRewardAnim();
            }
        }
    }

    private void startRewardAnim() {
        Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.anim_fade_out);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                removeView(mRewardAnimView);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mRewardAnimView.startAnimation(animation);
        Log.d("showRewardAnim", mContentView.getChildCount() + "个");
    }

    @Override
    public void cancelRewardAnim() {
        if (mRewardAnimView != null) {
            mRewardAnimView.clearAnimation();

        }
        removeView(mRewardAnimView);
    }

    @Override
    public void showGiftAnim() {

    }

    @Override
    public void cancelGiftAnim() {
        removeView(mGiftAnimView);
    }

    /**
     * 移除控件
     *
     * @param view 视图
     */
    private void removeView(final View view) {
        if (view != null && mContentView != null) {

            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mContentView.removeView(view);
                }
            });
            Log.d("remove", "移除view");
        }
    }

}
