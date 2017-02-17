package com.mobile.mferraco.weddingblitz.models;

/**
 * Represents an event object.  Events make up each of the items in the schedule.
 */

public class Event {

    private String mTitle;

    private String mStartTime;

    private String mEndTime;

    private String mDescription;

    public Event() {
        // do nothing, required for Firebase
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getStartTime() {
        return mStartTime;
    }

    public void setStartTime(String startTime) {
        this.mStartTime = startTime;
    }

    public String getEndTime() {
        return mEndTime;
    }

    public void setEndTime(String endTime) {
        this.mEndTime = endTime;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }
}
