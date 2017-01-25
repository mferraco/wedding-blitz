package com.mobile.mferraco.weddingblitz;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * This is the adapter which will provide the fragments to the ViewPager for display.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private String[] mTabTitles;

    private Context mContext;

    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
        mTabTitles = context.getResources().getStringArray(R.array.fragment_tab_titles);
    }

    @Override
    public int getCount() {
        return mTabTitles.length;
    }

    @Override
    public Fragment getItem(int position) {
        return SummaryFragment.newInstance(new Bundle());
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // TODO: change this to icons once I have them
        return mTabTitles[position];
    }
}
