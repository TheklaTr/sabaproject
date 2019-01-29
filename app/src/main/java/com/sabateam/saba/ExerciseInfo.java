package com.sabateam.saba;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class ExerciseInfo extends AppCompatActivity {

    VideoView videoFeed;

    int[] videoArray = {R.raw.character_vid};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_info);

        videoFeed = (VideoView) findViewById(R.id.videoWindow);

        String path = "android.resource://" + getPackageName() + "/" + videoArray[0];
        videoFeed.setVideoPath(path);

        videoFeed.start();
        videoFeed.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }

    public void BackButton(View view){

        super.onBackPressed();
    }
}
