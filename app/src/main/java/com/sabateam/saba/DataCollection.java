package com.sabateam.saba;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;

public class DataCollection implements Serializable {

    private String message1;
    private String message2;

    public DataCollection(String message1, String message2) {
        this.message1 = message1;
        this.message2 = message2;
    }

    public DataCollection() {
    }

    public String getMessage1() {
        return message1;
    }

    public String getMessage2() {
        return message2;
    }

}
