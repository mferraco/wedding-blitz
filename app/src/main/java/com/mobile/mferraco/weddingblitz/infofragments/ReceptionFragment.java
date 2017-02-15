package com.mobile.mferraco.weddingblitz.infofragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mobile.mferraco.weddingblitz.R;

/**
 * This fragment will display details about the reception.
 */

public class ReceptionFragment extends Fragment implements OnMapReadyCallback {

    private MapView mMapView;

    public static ReceptionFragment newInstance(Bundle args) {
        ReceptionFragment fragment = new ReceptionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reception, container, false);

        mMapView = (MapView) view.findViewById(R.id.reception_google_map);
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(this);

        return view;
    }

    /* ========== Google Maps ========== */

    @Override
    public void onMapReady(GoogleMap map) {
        Marker marker = map.addMarker(new MarkerOptions()
                .position(new LatLng(39.8858, -79.6484))
                .title("Marker"));

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 15));
        // Zoom in, animating the camera.
        map.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        map.animateCamera(CameraUpdateFactory.zoomTo(15), 1000, null);
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
