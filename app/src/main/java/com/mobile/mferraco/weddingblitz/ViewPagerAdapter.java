package com.mobile.mferraco.weddingblitz;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mobile.mferraco.weddingblitz.constants.FragmentConstants;
import com.mobile.mferraco.weddingblitz.infofragments.CeremonyFragment;
import com.mobile.mferraco.weddingblitz.infofragments.ReceptionFragment;
import com.mobile.mferraco.weddingblitz.infofragments.ScheduleFragment;
import com.mobile.mferraco.weddingblitz.infofragments.OverviewFragment;

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

        switch (position) {
            case FragmentConstants.OVERVIEW_FRAGMENT:
                return OverviewFragment.newInstance(new Bundle());
            case FragmentConstants.CEREMONY_FRAGMENT:
                return CeremonyFragment.newInstance(new Bundle());
            case FragmentConstants.RECEPTION_FRAGMENT:
                return ReceptionFragment.newInstance(new Bundle());
            case FragmentConstants.SCHEDULE_FRAGMENT:
                return ScheduleFragment.newInstance(new Bundle());
            default:
                return OverviewFragment.newInstance(new Bundle());
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // TODO: change this to icons once I have them
        return mTabTitles[position];
    }
}
