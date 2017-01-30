package com.mobile.mferraco.weddingblitz.infofragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.mferraco.weddingblitz.R;

/**
 * This fragment will display details about the ceremony.
 */

public class CeremonyFragment extends Fragment {

    public static CeremonyFragment newInstance(Bundle args) {
        CeremonyFragment fragment = new CeremonyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ceremony, container, false);
        return view;
    }
}
