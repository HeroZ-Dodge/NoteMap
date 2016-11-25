package com.dodge.hero.notemap.view.expansion;

/**
 * 描述:送礼动画扩展视图
 * Created by LinZheng on 2016/11/21.
 */

public interface IGiftAnimExpansionView {


    void showFlowerAnim(int count);

    void cancelFlowerAnim();

    void showRewardAnim(int count);

    void cancelRewardAnim();

    void showGiftAnim();

    void cancelGiftAnim();


}
