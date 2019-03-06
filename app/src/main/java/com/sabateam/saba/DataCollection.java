package com.sabateam.saba;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;

public class DataCollection implements Serializable {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    //    myRef.setValue("Hello, World!");
    // Firebase message = setValue("Hello, World!");

}
