package com.example.android.coffee.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by inframincer on 2016-10-15.
 */

public class Coffee {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mKnown;

    public Coffee() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isKnown() {
        return mKnown;
    }

    public void setKnown(boolean known) {
        mKnown = known;
    }
}
