package com.example.android.coffee.model;

import java.util.UUID;

/**
 * Created by inframincer on 2016-10-15.
 */

public class Coffee {

    private UUID mId;
    private String mTitle;

    public Coffee() {
        mId = UUID.randomUUID();
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
}
