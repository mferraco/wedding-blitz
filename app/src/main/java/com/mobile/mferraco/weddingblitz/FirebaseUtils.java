package com.mobile.mferraco.weddingblitz;

import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobile.mferraco.weddingblitz.infofragments.DataLoadingInterface;

/**
 * Created by mferraco on 2/20/17.
 */

public class FirebaseUtils {

    private static FirebaseDatabase mDatabase;

    public static FirebaseDatabase getDatabase() {
        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
            mDatabase.setPersistenceEnabled(true);
        }
        return mDatabase;
    }


    public static void detectOffline(final ImageView imageView, @DrawableRes final int imageResource, final DataLoadingInterface dataLoadingFragment) {
        DatabaseReference connectedRef = getDatabase().getReference(".info/connected");
        connectedRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                dataLoadingFragment.fragmentLoadComplete();
                boolean connected = snapshot.getValue(Boolean.class);
                if (!connected) {
                    imageView.setImageResource(imageResource);
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                dataLoadingFragment.fragmentLoadComplete();
            }
        });
    }
}
