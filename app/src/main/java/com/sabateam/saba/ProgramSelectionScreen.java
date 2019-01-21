package com.sabateam.saba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;

public class ProgramSelectionScreen extends AppCompatActivity implements View.OnClickListener {

    Button[] weekButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_selection_screen);

        // Set up the array holding button id's and setting the onclicklistener
        weekButtons = new Button[24];
        for(int i = 1; i < 25; i++) {
            String buttonIdTxt = "week" + i;
            int buttonId = getResources().getIdentifier(buttonIdTxt, "id", getPackageName());
            weekButtons[i-1] = ((Button)findViewById(buttonId));

            weekButtons[i-1].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v){

        GetIdAndShowProgram(v.getId());
    }

    public void GetIdAndShowProgram(int givenId) {

        // For now like this.
        // We can implement database fetching here. givenId holds the information about pressed button
        // so with that we can decide what content is shown. At this moment it's not used.

        Intent intent = new Intent(this, ProgramScreen.class);
        startActivity(intent);
    }
}
