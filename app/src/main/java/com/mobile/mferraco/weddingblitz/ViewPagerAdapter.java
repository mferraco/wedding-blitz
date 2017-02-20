package com.mobile.mferraco.weddingblitz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mobile.mferraco.weddingblitz.constants.FragmentConstants;
import com.mobile.mferraco.weddingblitz.infofragments.CeremonyFragment;
import com.mobile.mferraco.weddingblitz.infofragments.OverviewFragment;
import com.mobile.mferraco.weddingblitz.infofragments.ReceptionFragment;
import com.mobile.mferraco.weddingblitz.infofragments.schedule.ScheduleFragment;

/**
 * This is the adapter which will provide the fragments to the ViewPager for display.
 */

class ViewPagerAdapter extends FragmentPagerAdapter {

    private static final int NUM_TABS = 4;

    ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return NUM_TABS;
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
}
