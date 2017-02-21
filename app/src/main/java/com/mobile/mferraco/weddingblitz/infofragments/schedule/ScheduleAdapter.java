package com.mobile.mferraco.weddingblitz.infofragments.schedule;

import android.content.Context;
import android.support.annotation.DrawableRes;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.mobile.mferraco.weddingblitz.R;
import com.mobile.mferraco.weddingblitz.WeddingDateUtils;
import com.mobile.mferraco.weddingblitz.models.Event;

/**
 * This RecyclerView implementation sets up the schedule of events for the {@link ScheduleFragment}
 */

public class ScheduleAdapter extends FirebaseRecyclerAdapter<Event, EventViewHolder> {

    private final int HEIGHT_OFFSET_MULTIPLIER = 100;

    private String currentWordDay;

    private Context mContext;

    public ScheduleAdapter(Class<Event> modelClass, int modelLayout, Class<EventViewHolder> viewHolderClass, DatabaseReference ref, Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        mContext = context;
    }

    @Override
    protected void populateViewHolder(EventViewHolder vh, Event event, int position) {
        vh.setTitle(event.getTitle());

        // set time on cardview
        String startTime = WeddingDateUtils.getFormattedTimeString(event.getStartTime());
        String endTime = WeddingDateUtils.getFormattedTimeString(event.getEndTime());
        vh.setTime(mContext.getString(R.string.schedule_time_text, startTime, endTime));
        vh.setTimeAccessibility(mContext.getString(R.string.scheduled_time_accessibility_text, startTime, endTime));

        // set date in left column
        String wordDay = WeddingDateUtils.getAbbreviatedWordDayFromDate(event.getStartTime());
        if (currentWordDay == null || !wordDay.equals(currentWordDay)) {
            currentWordDay = wordDay;
            vh.setDay(currentWordDay);
            vh.setDayAccessibility(WeddingDateUtils.getWordDayFromDate(event.getStartTime()));

            vh.setDayOfMonth(WeddingDateUtils.getDayOfMonthFromDate(event.getStartTime()));
        }

        vh.setTypeIcon(getIconForType(event));
    }

    @DrawableRes
    private int getIconForType(Event event) {

        switch (event.getType()) {
            case Event.FOOD:
                return R.drawable.food;
            case Event.CEREMONY:
                return R.drawable.church;
            case Event.RECEPTION:
            default:
                return R.drawable.reception;
        }
    }
}
