package com.dodge.hero.notemap;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

/**
 * 描述这个类
 * Created by LinZheng on 2016/10/27.
 */

public class CustomNumberKeyBoard extends FrameLayout{

    private View mRootView;


    public CustomNumberKeyBoard(Context context) {
        super(context);
        initView();
    }

    public CustomNumberKeyBoard(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CustomNumberKeyBoard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        mRootView = inflater.inflate(R.layout.custom_number_key_board, this, true);
    }





}
