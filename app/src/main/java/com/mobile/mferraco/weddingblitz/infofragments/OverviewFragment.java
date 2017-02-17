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
import com.mobile.mferraco.weddingblitz.WeddingDateUtils;
import com.mobile.mferraco.weddingblitz.models.Wedding;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Date;

/**
 * This fragment will hold all of the overview information for the app.
 * <p>
 * - name of bride/groom
 * - countdown to the wedding
 * - summary of ceremony/reception venue
 */

public class OverviewFragment extends DataLoadingFragment {

    private static final String TAG = OverviewFragment.class.getSimpleName();

    private ImageView mImageView;
    private TextView mNamesTextView;
    private TextView mCountdownTextView;
    private TextView mWeddingDateTextView;

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
        mCountdownTextView = (TextView) view.findViewById(R.id.countdown_textview);
        mWeddingDateTextView = (TextView) view.findViewById(R.id.wedding_date_textview);

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
                mNamesTextView.setText(getString(R.string.two_data_point_string,
                        wedding.getBride(), wedding.getGroom()));

                String weddingDateString = wedding.getWeddingDate();

                // get the String format of the wedding date (Ex. July 8, 2017)
                String formattedDateString =
                        WeddingDateUtils.getFormattedDateString(weddingDateString);

                // count the number of days until the wedding
                Date weddingDate = WeddingDateUtils.parseDateFromString(weddingDateString);
                String countdownString = getString(R.string.countdown_text,
                        String.valueOf(WeddingDateUtils.getNumDaysUntilDate(weddingDate)));

                // set the date values on the text views
                mCountdownTextView.setText(countdownString);
                mWeddingDateTextView.setText(formattedDateString);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }
}
