package com.sabateam.saba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BeActiveScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_be_active_screen);
    }

    public void BackButton(View view){

        super.onBackPressed();
        finish();
    }
}
