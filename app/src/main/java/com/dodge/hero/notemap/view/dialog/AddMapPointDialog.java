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
 * 描述:
 * Created by LinZheng on 2016/11/14.
 */

public class AddMapPointDialog extends DialogFragment {


    private View mRootView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, R.style.no_title_dialog);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.dialog_add_map_point, container, false);

        }
//        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        mRootView.setLayoutParams(layoutParams);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        if (getDialog() != null) {
//            Window window = getDialog().getWindow();
//            if (window != null) {
//                WindowManager.LayoutParams layoutParams = window.getAttributes();
//                if (layoutParams != null) {
//                    layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
//                    layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
//                    window.setAttributes(layoutParams);
//                }
//            }
//        }
    }


}
