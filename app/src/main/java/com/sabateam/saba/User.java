package com.sabateam.saba;


/* This class creates a user for the session
*  Userdata is pulled from database when login happens.
*  This info should probably be transmitted between activities */

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String username;
    private String avatar;

    public User(int id, String username, String avatar) {

        this.id = id;
        this.username = username;
        this.avatar = avatar;
    }

    public User(int id, String username) {

        this.id = id;
        this.username = username;
        this.avatar = null;
    }

    public String GetAvatar() {
        return this.avatar;
    }

    public String GetUsername() {
        return this.username;
    }

    public int GetId() {
        return this.id;
    }

    public void SetAvatar(String avatar) {
        this.avatar = avatar;
    }
}
