package com.smaboy.pc120.xiuxiu.c.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Smaboy on 2017/12/5-17:24.
 * WHERE IS A WILL,THERE IS A WALL!
 */

public class TalkingFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragments;
    private ArrayList<String> mTitles;

    public TalkingFragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> tabs) {
        super(fm);

        mFragments=fragments;
        mTitles=tabs;

    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
