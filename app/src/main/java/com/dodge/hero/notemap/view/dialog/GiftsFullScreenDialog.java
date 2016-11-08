package com.dodge.hero.notemap.view.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.dodge.hero.notemap.R;

/**
 * Created by LinZheng on 2016/10/27.
 */

public class GiftsFullScreenDialog extends DialogFragment {

    private View mRootView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, R.style.dialog_note);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.dialog_fragment_full_screen_gifts, container, false);
        }
        return mRootView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Window window = getDialog().getWindow();
        if (window != null) {
            WindowManager.LayoutParams lp = window.getAttributes();
//            lp.gravity = Gravity.BOTTOM;                                            // 紧贴底部
//            lp.width = WindowManager.LayoutParams.MATCH_PARENT;                     // 宽度持平
//            window.setAttributes(lp);
        }
    }


}
