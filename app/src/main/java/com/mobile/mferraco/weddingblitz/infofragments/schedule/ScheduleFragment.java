package com.mobile.mferraco.weddingblitz.infofragments.schedule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.mferraco.weddingblitz.R;
import com.mobile.mferraco.weddingblitz.models.Event;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * This fragment will display the schedule of events.
 */

public class ScheduleFragment extends Fragment {

    public static ScheduleFragment newInstance(Bundle args) {
        ScheduleFragment fragment = new ScheduleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.schedule_recyclerview);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        Date startTime1 = new GregorianCalendar(2017, 0, 30, 10, 30).getTime();

        List<Event> events = new ArrayList<>();
        Event event1 = new Event("MIKE", startTime1, startTime1, "TEST", 1);
        Event event2 = new Event("CARLY", startTime1, startTime1, "TEST", 1);
        Event event3 = new Event("NICOLE", startTime1, startTime1, "TEST", 1);
        events.add(event1);
        events.add(event2);
        events.add(event3);
        recyclerView.setAdapter(new ScheduleAdapter(events));

    }
}
