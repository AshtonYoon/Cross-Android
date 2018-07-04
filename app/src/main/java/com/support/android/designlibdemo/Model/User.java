package com.support.android.designlibdemo.Connector.model;

import io.realm.RealmObject;

public class User extends RealmObject{
    String email, name, profile, uid;
    private String crossAddress;
public User(){}
    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getCrossAddress() {
        return crossAddress;
    }

    public void setCrossAddress(String crossAddress) {
        this.crossAddress = crossAddress;
    }
}
