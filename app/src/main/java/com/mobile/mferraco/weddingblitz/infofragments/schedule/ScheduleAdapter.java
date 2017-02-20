package com.mobile.mferraco.weddingblitz.infofragments.schedule;

import android.content.Context;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.mobile.mferraco.weddingblitz.R;
import com.mobile.mferraco.weddingblitz.WeddingDateUtils;
import com.mobile.mferraco.weddingblitz.models.Event;

/**
 * This RecyclerView implementation sets up the schedule of events for the {@link ScheduleFragment}
 */

public class ScheduleAdapter extends FirebaseRecyclerAdapter<Event, EventViewHolder> {

    private Context mContext;

    public ScheduleAdapter(Class<Event> modelClass, int modelLayout, Class<EventViewHolder> viewHolderClass, DatabaseReference ref, Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        mContext = context;
    }

    @Override
    protected void populateViewHolder(EventViewHolder vh, Event event, int position) {
        vh.setTitle(event.getTitle());
        vh.setDescription(event.getDescription());

        // set time on cardview
        String startTime = WeddingDateUtils.getFormattedTimeString(event.getStartTime());
        String endTime = WeddingDateUtils.getFormattedTimeString(event.getEndTime());
        vh.setTime(mContext.getString(R.string.schedule_time_text, startTime, endTime));

        vh.setDay(WeddingDateUtils.getDayFromDate(event.getStartTime()));
    }
}
