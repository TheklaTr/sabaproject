package com.sabateam.saba;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class ProgramScreen extends AppCompatActivity {

    static String[] programArray = new String[38];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_screen);

        // Receive bundle from program selection
        Bundle bundle = this.getIntent().getExtras();
        programArray = bundle.getStringArray("sentItem");

        // Setting textviews
        // I'll make a for loop structure here later
        TextView move1 = findViewById(R.id.move1);
        TextView move2 = findViewById(R.id.move2);
        TextView move3 = findViewById(R.id.move3);
        TextView move4 = findViewById(R.id.move4);
        TextView move5 = findViewById(R.id.move5);
        TextView move6 = findViewById(R.id.move6);
        TextView move7 = findViewById(R.id.move7);
        TextView move8 = findViewById(R.id.move8);
        TextView move9 = findViewById(R.id.move9);
        TextView move10 = findViewById(R.id.move10);
        TextView move11 = findViewById(R.id.move11);
        TextView move12 = findViewById(R.id.move12);
        TextView move13 = findViewById(R.id.move13);
        TextView move14 = findViewById(R.id.move14);
        TextView move15 = findViewById(R.id.move15);
        TextView move16 = findViewById(R.id.move16);
        TextView move17 = findViewById(R.id.move17);
        TextView move18 = findViewById(R.id.move18);
        TextView move19 = findViewById(R.id.move19);
        TextView move1sets = findViewById(R.id.move1sets);
        TextView move2sets = findViewById(R.id.move2sets);
        TextView move3sets = findViewById(R.id.move3sets);
        TextView move4sets = findViewById(R.id.move4sets);
        TextView move5sets = findViewById(R.id.move5sets);
        TextView move6sets = findViewById(R.id.move6sets);
        TextView move7sets = findViewById(R.id.move7sets);
        TextView move8sets = findViewById(R.id.move8sets);
        TextView move9sets = findViewById(R.id.move9sets);
        TextView move10sets = findViewById(R.id.move10sets);
        TextView move11sets = findViewById(R.id.move11sets);
        TextView move12sets = findViewById(R.id.move12sets);
        TextView move13sets = findViewById(R.id.move13sets);
        TextView move14sets = findViewById(R.id.move14sets);
        TextView move15sets = findViewById(R.id.move15sets);
        TextView move16sets = findViewById(R.id.move16sets);
        TextView move17sets = findViewById(R.id.move17sets);
        TextView move18sets = findViewById(R.id.move18sets);
        TextView move19sets = findViewById(R.id.move19sets);

        // Set content of textviews as the contents of programArray
        // I'll make a for loop structure here later
        move1.setText(programArray[0]);
        move2.setText(programArray[1]);
        move3.setText(programArray[2]);
        move4.setText(programArray[3]);
        move5.setText(programArray[4]);
        move6.setText(programArray[5]);
        move7.setText(programArray[6]);
        move8.setText(programArray[7]);
        move9.setText(programArray[8]);
        move10.setText(programArray[9]);
        move11.setText(programArray[10]);
        move12.setText(programArray[11]);
        move13.setText(programArray[12]);
        move14.setText(programArray[13]);
        move15.setText(programArray[14]);
        move16.setText(programArray[15]);
        move17.setText(programArray[16]);
        move18.setText(programArray[17]);
        move19.setText(programArray[18]);
        move1sets.setText(programArray[19]);
        move2sets.setText(programArray[20]);
        move3sets.setText(programArray[21]);
        move4sets.setText(programArray[22]);
        move5sets.setText(programArray[23]);
        move6sets.setText(programArray[24]);
        move7sets.setText(programArray[25]);
        move8sets.setText(programArray[26]);
        move9sets.setText(programArray[27]);
        move10sets.setText(programArray[28]);
        move11sets.setText(programArray[29]);
        move12sets.setText(programArray[30]);
        move13sets.setText(programArray[31]);
        move14sets.setText(programArray[32]);
        move15sets.setText(programArray[33]);
        move16sets.setText(programArray[34]);
        move17sets.setText(programArray[35]);
        move18sets.setText(programArray[36]);
        move19sets.setText(programArray[37]);

    }

    // Temp method for button
    public void ShowExerciseInfo(View view){

        Intent intent = new Intent(this, ExerciseInfo.class);
        startActivity(intent);


    }

    // Temp method for demonstration
    public void ShowExerciseInDialog(View view) {

        VideoView videoFeed = new VideoView(this);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.character_vid;
        videoFeed.setVideoPath(videoPath);

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this).
                        setView(videoFeed).
                        setPositiveButton("OK", null);


        videoFeed.setZOrderOnTop(true);
        videoFeed.start();
        builder.create().show();

        videoFeed.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
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
