package com.dodge.hero.notemap.view.activity.impl;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.dodge.hero.commontlibrary.view.activity.BaseToolbarActivity;
import com.dodge.hero.notemap.R;
import com.dodge.hero.notemap.view.fragment.Fragment1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by z on 2016/11/7.
 */

public class ViewPagerToolbarActivity extends BaseToolbarActivity {

    private ViewPager mViewPager;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_view_pager;
    }

    @Override
    public void initView() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
    }

    @Override
    protected void initData() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(Fragment1.create("1"));
        fragmentList.add(Fragment1.create("2"));
        fragmentList.add(Fragment1.create("3"));
        fragmentList.add(Fragment1.create("4"));
        fragmentList.add(Fragment1.create("5"));
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        mViewPager.setPageMargin(50);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(adapter);
    }

    private class MyViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragments;


        public MyViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            mFragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments == null ? null : mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments == null ? 0 : mFragments.size();
        }
    }

}
