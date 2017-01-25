package com.mobile.mferraco.weddingblitz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * This fragment will hold all of the summary information for the app.
 *
 * - name of bride/groom
 * - countdown to the wedding
 * - summary of ceremony/reception venue
 *
 */

public class SummaryFragment extends Fragment {

    public static SummaryFragment newInstance(Bundle args) {
        SummaryFragment fragment = new SummaryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summary, container, false);
        return view;
    }
}
