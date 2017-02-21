package com.mobile.mferraco.weddingblitz.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.mobile.mferraco.weddingblitz.FirebaseUtils;
import com.mobile.mferraco.weddingblitz.R;
import com.mobile.mferraco.weddingblitz.WeddingDateUtils;
import com.mobile.mferraco.weddingblitz.models.Wedding;

import java.util.Date;

/**
 * The AppWidgetProvider for the countdown widget that can be displayed on the homescreen.
 */

public class CountdownWidgetProvider extends AppWidgetProvider {

    public void onUpdate(final Context context, final AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;

        for (int i = 0; i < N; i++) {
            final int appWidgetId = appWidgetIds[i];

            DatabaseReference ref = FirebaseUtils.getDatabase().getReference("weddings/0");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Wedding wedding = dataSnapshot.getValue(Wedding.class);

                    RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_countdown);

                    String names = context.getString(R.string.two_data_point_string,
                            wedding.getBride(), wedding.getGroom());
                    views.setTextViewText(R.id.widget_name_textview, names);


                    String weddingDateString = wedding.getWeddingDate();


                    // count the number of days until the wedding
                    Date weddingDate = WeddingDateUtils.parseDateFromString(weddingDateString);
                    String countdownString = context.getString(R.string.countdown_text,
                            String.valueOf(WeddingDateUtils.getNumDaysUntilDate(weddingDate)));

                    views.setTextViewText(R.id.widget_count_textvite, countdownString);

                    appWidgetManager.updateAppWidget(appWidgetId, views);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // do nothing
                }
            });

        }
    }

}
