package com.mobile.mferraco.weddingblitz.infofragments.schedule;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mobile.mferraco.weddingblitz.R;

/**
 * This is the ViewHolder for each Card View object that represents an Event on the Schedule
 */

public class EventViewHolder extends RecyclerView.ViewHolder {

    protected TextView vTitle;

    public EventViewHolder(View v) {
        super(v);

        // set variables for view components
        vTitle = (TextView) v.findViewById(R.id.event_title_textview);
    }


}
