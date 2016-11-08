package com.dodge.hero.notemap.view.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dodge.hero.notemap.R;

/**
 * Created by LinZheng on 2016/10/26.
 */

public class TestDialog extends DialogFragment {

    private View mDialogView;
    private TextView mTextView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.MyDialogStyle);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (mDialogView == null) {
            mDialogView = inflater.inflate(R.layout.dialog_fragment_test, container, false);
        }
        return mDialogView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);


    }

    private void initView(View view) {
        mTextView = (TextView) view.findViewById(R.id.tv_msg);
        mTextView.setText("GOGOGO");

    }
}
