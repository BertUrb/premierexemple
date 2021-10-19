package com.mjcdouai.premierexemble.model;

import java.net.URL;

public class FootballPlayer {
    private String mName;
    private URL mPhotoUrl;

    private String mDesc;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public URL getPhotoUrl() {
        return mPhotoUrl;
    }

    public void setPhotoUrl(URL photoUrl) {
        mPhotoUrl = photoUrl;
    }
    public String getDesc() {
        return mDesc;
    }

    public FootballPlayer(String name, URL photoUrl, String desc) {
        mName = name;
        mPhotoUrl = photoUrl;
        mDesc = desc;
    }
}
