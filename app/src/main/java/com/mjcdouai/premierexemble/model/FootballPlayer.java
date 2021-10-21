package com.mjcdouai.premierexemble.model;


import android.os.Parcel;
import android.os.Parcelable;

public class FootballPlayer implements Parcelable {
    private String mName;
    private String mPhotoUrl;

    private String mDesc;

    protected FootballPlayer(Parcel in) {
        mName = in.readString();
        mPhotoUrl = in.readString();
        mDesc = in.readString();
    }

    public static final Creator<FootballPlayer> CREATOR = new Creator<FootballPlayer>() {
        @Override
        public FootballPlayer createFromParcel(Parcel in) {
            return new FootballPlayer(in);
        }

        @Override
        public FootballPlayer[] newArray(int size) {
            return new FootballPlayer[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeString(mPhotoUrl);
        parcel.writeString(mDesc);
    }
}
