package com.sabateam.saba;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BeActiveScreen extends AppCompatActivity {

    private SoundPool sounds;

    int howto1;
    int howto2;
    int howto3;
    int howto4;
    int howto5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_be_active_screen);


        sounds = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        howto1 = sounds.load(this, R.raw.donald, 1);
        howto2 = sounds.load(this, R.raw.donald, 1);
        howto3 = sounds.load(this, R.raw.donald, 1);
        howto4 = sounds.load(this, R.raw.donald, 1);
        howto5 = sounds.load(this, R.raw.donald, 1);
    }

    public void BackButton(View view){

        super.onBackPressed();
        finish();
    }
    public void Howto1(View view){
        sounds.play(howto1, 1, 1, 1, 0, 1);

    }
    public void Howto2(View view){
        sounds.play(howto2, 1, 1, 1, 0, 1);

    }
    public void Howto3(View view){
        sounds.play(howto3, 1, 1, 1, 0, 1);

    }
    public void Howto4(View view){
        sounds.play(howto4, 1, 1, 1, 0, 1);

    }
    public void Howto5(View view){
        sounds.play(howto5, 1, 1, 1, 0, 1);

    }
}
