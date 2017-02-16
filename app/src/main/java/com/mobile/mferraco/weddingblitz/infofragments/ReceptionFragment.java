package com.mobile.mferraco.weddingblitz.infofragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
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
 * This fragment will display details about the reception.
 */

public class ReceptionFragment extends DataLoadingFragment implements OnMapReadyCallback {

    private MapView mMapView;
    private ImageView mImageView;
    private TextView mTitleTextView;
    private Marker mMarker;
    private Wedding mWedding;
    private GoogleMap mMap;

    public static ReceptionFragment newInstance(Bundle args) {
        ReceptionFragment fragment = new ReceptionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        // inflate content into DataLoadingFragment's content layout
        getActivity().getLayoutInflater().inflate(R.layout.fragment_reception, getContentLayout());

        mMapView = (MapView) view.findViewById(R.id.reception_google_map);
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(this);

        mImageView = (ImageView) view.findViewById(R.id.reception_image);
        mTitleTextView = (TextView) view.findViewById(R.id.reception_name_textview);

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
                mWedding = dataSnapshot.getValue(Wedding.class);
                Picasso.with(getContext()).load(mWedding.getReceptionImageUrl()).into(mImageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        fragmentLoadComplete();
                    }

                    @Override
                    public void onError() {
                        fragmentLoadComplete();
                    }
                });
                setMarkerDetails();
                mTitleTextView.setText(mWedding.getReceptionName());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }

    private void setMarkerDetails() {
        if (mMarker != null && mWedding != null && mMap != null) {
            mMarker.setTitle(mWedding.getReceptionName());
            mMarker.setPosition(new LatLng(mWedding.getReceptionLat(), mWedding.getReceptionLng()));

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mMarker.getPosition(), 15));
            // Zoom in, animating the camera.
            mMap.animateCamera(CameraUpdateFactory.zoomIn());
            // Zoom out to zoom level 10, animating with a duration of 2 seconds.
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 1000, null);
        }
    }

    /* ========== Google Maps ========== */

    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;
        mMarker = map.addMarker(new MarkerOptions()
                .position(new LatLng(0, 0)));

        setMarkerDetails();
    }

    /* ========== LifeCycle Methods ========== */

    /*
    Need to call all the MapView lifecycle methods from the fragment
     */

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}
