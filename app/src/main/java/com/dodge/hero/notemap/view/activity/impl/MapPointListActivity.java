package com.dodge.hero.notemap.view.activity.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.dodge.hero.commontlibrary.view.activity.BaseFinishActivity;
import com.dodge.hero.notemap.R;
import com.dodge.hero.notemap.view.fragment.impl.MapPointListFragment;

/**
 * 描述:
 * Created by LinZheng on 2016/11/13.
 */

public class MapPointListActivity extends BaseFinishActivity {

    private View mBtnNearBy;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_point_list);
        mBtnNearBy = findViewById(R.id.tv_near_by);
        mBtnNearBy.setOnClickListener(v -> {
            Intent intent = new Intent(MapPointListActivity.this, MapPointListActivity.class);
            startActivity(intent);
        });
        MapPointListFragment fragment = new MapPointListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }

}
