package com.mobile.mferraco.weddingblitz.infofragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.mferraco.weddingblitz.R;

/**
 * This fragment will hold all of the overview information for the app.
 *
 * - name of bride/groom
 * - countdown to the wedding
 * - summary of ceremony/reception venue
 *
 */

public class OverviewFragment extends Fragment {

    public static OverviewFragment newInstance(Bundle args) {
        OverviewFragment fragment = new OverviewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);
        return view;
    }
}
