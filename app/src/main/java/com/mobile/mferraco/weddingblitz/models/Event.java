package com.mobile.mferraco.weddingblitz.models;

import java.util.Date;

/**
 * Represents an event object.  Events make up each of the items in the schedule.
 */

public class Event {

    private String mTitle;

    private Date mStartTime;

    private Date mEndTime;

    private String mDescription;

    private int mWeddingId;

    public Event(String mTitle, Date mStartTime, Date mEndTime, String mDescription, int weddingId) {
        this.mTitle = mTitle;
        this.mStartTime = mStartTime;
        this.mEndTime = mEndTime;
        this.mDescription = mDescription;
        this.mWeddingId = weddingId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getStartTime() {
        return mStartTime;
    }

    public void setStartTime(Date startTime) {
        this.mStartTime = startTime;
    }

    public Date getEndTime() {
        return mEndTime;
    }

    public void setEndTime(Date endTime) {
        this.mEndTime = endTime;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public int getWeddingId() {
        return mWeddingId;
    }

    public void setWeddingId(int weddingId) {
        this.mWeddingId = weddingId;
    }
}
