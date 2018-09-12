package com.smaboy.pc120.xiuxiu.c.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Smaboy on 2018/3/26-20:27.
 * WHERE IS A WILL,THERE IS A WAY!
 */

public class LookinngFragmentAdapter extends FragmentPagerAdapter {

    private  ArrayList<Fragment> fragments;
    private ArrayList<String> tabs;

    public LookinngFragmentAdapter(FragmentManager childFragmentManager, ArrayList<Fragment> fragments, ArrayList<String> tabs) {
        super(childFragmentManager);
        this.fragments=fragments;
        this.tabs=tabs;

    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
}



    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position);
    }
}
