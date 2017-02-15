package com.mobile.mferraco.weddingblitz.infofragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobile.mferraco.weddingblitz.R;
import com.mobile.mferraco.weddingblitz.models.Wedding;
import com.squareup.picasso.Picasso;

/**
 * This fragment will hold all of the overview information for the app.
 *
 * - name of bride/groom
 * - countdown to the wedding
 * - summary of ceremony/reception venue
 *
 */

public class OverviewFragment extends Fragment {

    private ImageView mImageView;

    public static OverviewFragment newInstance(Bundle args) {
        OverviewFragment fragment = new OverviewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        mImageView = (ImageView) view.findViewById(R.id.overview_image);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get a reference to the wedding
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("weddings/1");

        // Attach a listener to read the data at the wedding reference
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Wedding wedding = dataSnapshot.getValue(Wedding.class);
                Picasso.with(getContext()).load(wedding.getOverviewImageUrl()).into(mImageView);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }
}
