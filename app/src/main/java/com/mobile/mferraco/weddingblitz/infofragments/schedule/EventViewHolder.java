package com.mobile.mferraco.weddingblitz.infofragments.schedule;

import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
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
    private ImageView vTypeIcon;

    public EventViewHolder(View v) {
        super(v);

        // set variables for view components
        vTitle = (TextView) v.findViewById(R.id.event_title_textview);
        vTime = (TextView) v.findViewById(R.id.event_time_textview);
        vDay = (TextView) v.findViewById(R.id.event_day_textview);
        vDayOfMonth = (TextView) v.findViewById(R.id.event_date_textview);
        vTypeIcon = (ImageView) v.findViewById(R.id.event_type_icon_imageview);
    }

    public void setTitle(String title) {
        vTitle.setText(title);
    }

    public void setTime(String time) {
        vTime.setText(time);
    }

    public void setTimeAccessibility(String cd) {
        vTime.setContentDescription(cd);
    }

    public void setDay(String day) {
        vDay.setText(day);
    }

    public void setDayAccessibility(String cd) {
        vDay.setContentDescription(cd);
    }

    public void setDayOfMonth(String dayOfMonth) {
        vDayOfMonth.setText(dayOfMonth);
    }

    public void setTypeIcon(@DrawableRes int imageResource) {
        vTypeIcon.setImageResource(imageResource);
    }
}
