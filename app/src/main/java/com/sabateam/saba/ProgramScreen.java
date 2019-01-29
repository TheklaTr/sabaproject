package com.sabateam.saba;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

public class ProgramScreen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_screen);


    }

    // Temp method for button
    public void ShowExerciseInfo(View view){

        Intent intent = new Intent(this, ExerciseInfo.class);
        startActivity(intent);


    }

    public void SendProgramToPhone(View view) {

        // Implementation here
        // Either send directly, or open up a new screen where the connection is established
        // with instructions
    }

    public void BackButton(View view){

        super.onBackPressed();
    }
}
