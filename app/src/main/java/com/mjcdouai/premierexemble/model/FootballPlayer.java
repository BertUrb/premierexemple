package com.mjcdouai.premierexemble.model;


public class FootballPlayer {
    private String mName;
    private String mPhotoUrl;

    private String mDesc;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhotoUrl() {
        return mPhotoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        mPhotoUrl = photoUrl;
    }
    public String getDesc() {
        return mDesc;
    }

    public FootballPlayer(String name, String photoUrl, String desc) {
        mName = name;
        mPhotoUrl = photoUrl;
        mDesc = desc;
    }
}
