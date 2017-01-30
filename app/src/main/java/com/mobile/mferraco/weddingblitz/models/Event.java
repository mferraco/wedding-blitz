package com.mobile.mferraco.weddingblitz.models;

/**
 * Represents an event object.  Events make up each of the items in the schedule.
 */

public class Event {

    private String mTitle;

    public Event(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
