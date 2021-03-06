package com.mobile.mferraco.weddingblitz.infofragments.schedule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.mobile.mferraco.weddingblitz.FirebaseUtils;
import com.mobile.mferraco.weddingblitz.R;
import com.mobile.mferraco.weddingblitz.infofragments.DataLoadingFragment;
import com.mobile.mferraco.weddingblitz.models.Event;

/**
 * This fragment will display the schedule of events.
 */

public class ScheduleFragment extends DataLoadingFragment {

    public static ScheduleFragment newInstance(Bundle args) {
        ScheduleFragment fragment = new ScheduleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        // inflate content into DataLoadingFragment's content layout
        getActivity().getLayoutInflater().inflate(R.layout.fragment_schedule, getContentLayout());

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

        DatabaseReference ref = FirebaseUtils.getDatabase().getReference("weddings/0/schedule");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                fragmentLoadComplete();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                fragmentLoadComplete();
            }
        });

        recyclerView.setAdapter(new ScheduleAdapter(Event.class, R.layout.cardview_event, EventViewHolder.class, ref, getContext()));
    }
}
