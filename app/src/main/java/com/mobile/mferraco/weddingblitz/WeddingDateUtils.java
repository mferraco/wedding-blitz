package com.mobile.mferraco.weddingblitz;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * A collection of static utility methods for working with dates.
 */

public final class WeddingDateUtils {

    private static final String TAG = WeddingDateUtils.class.getSimpleName();

    private static final DateFormat firebaseDateFormat = new SimpleDateFormat("MM/dd/yyyy kk:mm a, z", Locale.US);
    private static final SimpleDateFormat stringDateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.US);

    /**
     * The number of days from today until the date passed in.
     *
     * @param date The date to count days until.
     * @return The number of days until the date.
     */
    public static long getNumDaysUntilDate(Date date) {
        long msDiff = date.getTime() - Calendar.getInstance().getTimeInMillis();
        return TimeUnit.MILLISECONDS.toDays(msDiff);
    }

    /**
     * Retrieve a date object representing the date from the String passed in.  The String
     * passed in must be in the format of 'MM/dd/yyyy kk:mm a, z'. (Ex. 07/08/2017 00:00 AM, EST)
     *
     * @param dateString The string to parse the date from.
     * @return The date.
     */
    public static Date parseDateFromString(String dateString) {
        try {
            return firebaseDateFormat.parse(dateString);
        } catch (ParseException e) {
            Log.d(TAG, "Failed to parse date string: " + dateString);
        }

        return new Date();
    }

    /**
     * Retrieve the date as a String in the format of 'MMMM d, yyyy' (Ex. July, 8, 2017)
     *
     * @param dateString The String to format.
     * @return The formatted date String.
     */
    public static String getFormattedDateString(String dateString) {
        return stringDateFormat.format(parseDateFromString(dateString));

    }
}
