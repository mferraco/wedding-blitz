package com.mobile.mferraco.weddingblitz.models;

import java.util.List;

/**
 * An object which holds all the data for a single wedding.
 */

public class Wedding {

    private String mCeremonyName;
    private float mCeremonyLat;
    private float mCeremonyLng;
    private String mCeremonyImageUrl;
    private String mReceptionName;
    private float mReceptionLat;
    private float mReceptionLng;
    private String mReceptionImageUrl;
    private String mOverviewImageUrl;
    private String mBride;
    private String mGroom;
    private String mWeddingDate;
    private List<Event> mSchedule;

    public Wedding() {
        // do nothing, required for Firebase
    }

    public String getCeremonyName() {
        return mCeremonyName;
    }

    public void setCeremonyName(String ceremonyName) {
        this.mCeremonyName = ceremonyName;
    }

    public float getCeremonyLat() {
        return mCeremonyLat;
    }

    public void setCeremonyLat(float ceremonyLat) {
        this.mCeremonyLat = ceremonyLat;
    }

    public float getCeremonyLng() {
        return mCeremonyLng;
    }

    public void setCeremonyLng(float ceremonyLng) {
        this.mCeremonyLng = ceremonyLng;
    }

    public String getCeremonyImageUrl() {
        return mCeremonyImageUrl;
    }

    public void setCeremonyImageUrl(String ceremonyImageUrl) {
        this.mCeremonyImageUrl = ceremonyImageUrl;
    }

    public String getReceptionName() {
        return mReceptionName;
    }

    public void setReceptionName(String receptionName) {
        this.mReceptionName = receptionName;
    }

    public float getReceptionLat() {
        return mReceptionLat;
    }

    public void setReceptionLat(float receptionLat) {
        this.mReceptionLat = receptionLat;
    }

    public float getReceptionLng() {
        return mReceptionLng;
    }

    public void setReceptionLng(float receptionLng) {
        this.mReceptionLng = receptionLng;
    }

    public String getReceptionImageUrl() {
        return mReceptionImageUrl;
    }

    public void setReceptionImageUrl(String receptionImageUrl) {
        this.mReceptionImageUrl = receptionImageUrl;
    }

    public String getOverviewImageUrl() {
        return mOverviewImageUrl;
    }

    public void setOverviewImageUrl(String overviewImageUrl) {
        this.mOverviewImageUrl = overviewImageUrl;
    }

    public String getBride() {
        return mBride;
    }

    public void setBride(String bride) {
        this.mBride = bride;
    }

    public String getGroom() {
        return mGroom;
    }

    public void setGroom(String groom) {
        this.mGroom = groom;
    }

    public String getWeddingDate() {
        return mWeddingDate;
    }

    public void setWeddingDate(String weddingDate) {
        this.mWeddingDate = weddingDate;
    }

    public List<Event> getSchedule() {
        return mSchedule;
    }

    public void setSchedule(List<Event> schedule) {
        mSchedule = schedule;
    }
}
