package com.mobile.mferraco.weddingblitz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

/**
 * The main activity which holds the View Pager, and therefore all of the fragments that can be
 * tabbed through
 */

public class MainActivity extends AppCompatActivity {

    private int[] tabIcons = {
            R.drawable.overview,
            R.drawable.church,
            R.drawable.reception,
            R.drawable.schedule
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        // Setup the ViewPager & Adapter
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager_main);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(3);

        // Setup the TabLayout for the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout_main);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons(tabLayout);
    }

    private void setupTabIcons(TabLayout tabLayout) {
        String[] tabTitles = getResources().getStringArray(R.array.fragment_tab_titles);

        for (int i = 0; i < tabTitles.length; i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setIcon(tabIcons[i]);
                tab.setContentDescription("Tab " + (i + 1) + " of " + tabTitles.length + ". " + tabTitles[i]);
            }
        }
    }
}
