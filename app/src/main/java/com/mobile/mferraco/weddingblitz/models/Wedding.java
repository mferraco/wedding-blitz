package com.mobile.mferraco.weddingblitz.models;

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
}
