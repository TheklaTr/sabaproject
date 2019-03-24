package com.sabateam.saba;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;

public class DataCollection implements Serializable {

    private String data1;
    private String data2;
    private String data3;

    public DataCollection(String data1, String data2, String data3) {
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;

    }

    public DataCollection() {
        //Firebase requires empty constructor
    }

    public String getData1() {
        return data1;
    }

    public String getData2() {
        return data2;
    }

    public String getData3() {
        return data3;
    }


}
