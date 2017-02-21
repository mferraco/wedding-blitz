package com.mobile.mferraco.weddingblitz.infofragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.mobile.mferraco.weddingblitz.R;

/**
 * A fragment which contains the logic for showing a progress bar when data is loading.
 */

public class DataLoadingFragment extends Fragment implements DataLoadingInterface {

    private ProgressBar mProgressBar;
    private FrameLayout mContentLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data_loading, container, false);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        mContentLayout = (FrameLayout) view.findViewById(R.id.content);
        return view;
    }

    public ProgressBar getProgressBar() {
        return mProgressBar;
    }

    public FrameLayout getContentLayout() {
        return mContentLayout;
    }

    public void fragmentLoadComplete() {
        mProgressBar.setVisibility(View.GONE);
        mContentLayout.setVisibility(View.VISIBLE);
    }

}
