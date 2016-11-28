package com.dodge.hero.notemap.view.activity.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;

import com.blankj.utilcode.utils.RegexUtils;
import com.dodge.hero.commontlibrary.view.activity.BaseFinishActivity;
import com.dodge.hero.commontlibrary.view.ui.CircleDrawable;
import com.dodge.hero.notemap.R;
import com.dodge.hero.notemap.view.fragment.impl.MapPointListFragment;

/**
 * 描述:
 * Created by LinZheng on 2016/11/13.
 */

public class MapPointListActivity extends BaseFinishActivity {

    private View mBtnNearBy;
    private View mBtnHistory;
    private ImageView mIvCircle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_point_list);
        mBtnNearBy = findViewById(R.id.tv_near_by);
        mBtnNearBy.setOnClickListener(v -> {
            Intent intent = new Intent(MapPointListActivity.this, MapPointListActivity.class);
            startActivity(intent);
        });
        mIvCircle = (ImageView) findViewById(R.id.iv_circle);
        mBtnHistory = findViewById(R.id.tv_history);
        mBtnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvCircle.setBackground(new CircleDrawable(MapPointListActivity.this, R.drawable.gift_rank_bg));
            }
        });
        MapPointListFragment fragment = new MapPointListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }


    private int getTextMaxLength(String text) {
        int length = 0;
        int size = 0;

        for (int i = 0; i < text.length(); i++) {
            length = i;
            char c = text.charAt(i);
            String str = String.valueOf(c);
            if (RegexUtils.isChz(str)) {
                size += 2;
            } else {
                size += 1;
            }
            if (size >= 12) {
                return length + 1;
            }
        }
        return length;
    }


}
