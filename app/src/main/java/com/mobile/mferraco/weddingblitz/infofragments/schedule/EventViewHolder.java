package com.mobile.mferraco.weddingblitz.infofragments.schedule;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mobile.mferraco.weddingblitz.R;

/**
 * This is the ViewHolder for each Card View object that represents an Event on the Schedule
 */

public class EventViewHolder extends RecyclerView.ViewHolder {

    private TextView vTitle;
    private TextView vTime;
    private TextView vDay;
    private TextView vDayOfMonth;

    public EventViewHolder(View v) {
        super(v);

        // set variables for view components
        vTitle = (TextView) v.findViewById(R.id.event_title_textview);
        vTime = (TextView) v.findViewById(R.id.event_time_textview);
        vDay = (TextView) v.findViewById(R.id.event_day_textview);
        vDayOfMonth = (TextView) v.findViewById(R.id.event_date_textview);
    }

    public void setTitle(String title) {
        vTitle.setText(title);
    }

    public void setTime(String time) {
        vTime.setText(time);
    }

    public void setDay(String day) {
        vDay.setText(day);
    }

    public void setDayOfMonth(String dayOfMonth) {
        vDayOfMonth.setText(dayOfMonth);
    }
}
