package com.mobile.mferraco.weddingblitz.infofragments.schedule;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.mobile.mferraco.weddingblitz.models.Event;

/**
 * This RecyclerView implementation sets up the schedule of events for the {@link ScheduleFragment}
 */

public class ScheduleAdapter extends FirebaseRecyclerAdapter<Event, EventViewHolder> {

    public ScheduleAdapter(Class<Event> modelClass, int modelLayout, Class<EventViewHolder> viewHolderClass, DatabaseReference ref) {
        super(modelClass, modelLayout, viewHolderClass, ref);
    }

    @Override
    protected void populateViewHolder(EventViewHolder vh, Event event, int position) {
        vh.setTitle(event.getTitle());
        vh.setDescription(event.getDescription());
    }
}
