package com.mobile.mferraco.weddingblitz.infofragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobile.mferraco.weddingblitz.R;
import com.mobile.mferraco.weddingblitz.models.Wedding;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * This fragment will hold all of the overview information for the app.
 * <p>
 * - name of bride/groom
 * - countdown to the wedding
 * - summary of ceremony/reception venue
 */

public class OverviewFragment extends DataLoadingFragment {

    private ImageView mImageView;
    private TextView mNamesTextView;
    private TextView mLocationTextView;

    public static OverviewFragment newInstance(Bundle args) {
        OverviewFragment fragment = new OverviewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        // inflate content into DataLoadingFragment's content layout
        getActivity().getLayoutInflater().inflate(R.layout.fragment_overview, getContentLayout());

        mImageView = (ImageView) view.findViewById(R.id.overview_image);
        mNamesTextView = (TextView) view.findViewById(R.id.names_textview);
        mLocationTextView = (TextView) view.findViewById(R.id.location_textview);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get a reference to the wedding
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("weddings/0");

        // Attach a listener to read the data at the wedding reference
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Wedding wedding = dataSnapshot.getValue(Wedding.class);
                Picasso.with(getContext()).load(wedding.getOverviewImageUrl()).into(mImageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        fragmentLoadComplete();
                    }

                    @Override
                    public void onError() {
                        fragmentLoadComplete();
                    }
                });
                mNamesTextView.setText(getString(R.string.two_data_point_string, wedding.getBride(), wedding.getGroom()));
                mLocationTextView.setText(getString(R.string.two_data_point_string, wedding.getCeremonyName(), wedding.getReceptionName()));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }
}
