package com.dodge.hero.notemap.view.activity.impl;

import android.view.View;

import com.dodge.hero.commontlibrary.view.activity.BaseToolbarActivity;
import com.dodge.hero.notemap.R;
import com.dodge.hero.notemap.view.expansion.GiftAnimExpansionView;
import com.dodge.hero.notemap.view.expansion.IGiftAnimExpansionView;

/**
 * 描述:
 * Created by LinZheng on 2016/11/22.
 */

public class AnimToolbarActivity extends BaseToolbarActivity {


    private View mBtnFlower;
    private View mBtnReward;
    private IGiftAnimExpansionView mGiftAnimExpansionView;


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mGiftAnimExpansionView = new GiftAnimExpansionView(this, mFrameLayout);
        mBtnFlower = findViewById(R.id.btn_flower);
        mBtnReward = findViewById(R.id.btn_reward);
        mBtnFlower.setOnClickListener(v -> mGiftAnimExpansionView.showFlowerAnim(0));
        mBtnReward.setOnClickListener(v -> mGiftAnimExpansionView.showRewardAnim(2));
    }

    @Override
    protected void initData() {

    }
}
