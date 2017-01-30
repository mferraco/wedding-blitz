package com.mobile.mferraco.weddingblitz.infofragments.schedule;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.mferraco.weddingblitz.R;
import com.mobile.mferraco.weddingblitz.models.Event;

import java.util.List;

/**
 * This RecyclerView implementation sets up the schedule of events for the {@link ScheduleFragment}
 */

public class ScheduleAdapter extends RecyclerView.Adapter<EventViewHolder> {

    List<Event> mEvents;

    public ScheduleAdapter(List<Event> events) {
        mEvents = events;
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        Event event = mEvents.get(position);
        holder.vTitle.setText(event.getTitle());
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View eventView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.cardview_event, parent, false);

        return new EventViewHolder(eventView);
    }
}
