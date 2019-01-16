package com.sabateam.saba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProgramSelectionScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_selection_screen);
    }

    public void TempButtonClick(View view) {

        Intent intent = new Intent(this, ProgramScreen.class);
        startActivity(intent);
    }
}
