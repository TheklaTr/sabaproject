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

    public static int dbHowTo1 = 0;
    public static int dbHowTo2 = 0;
    public static int dbHowTo3 = 0;
    public static int dbHowTo4 = 0;
    public static  int dbHowTo5 = 0;

    public static String dbHowTo = "";
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
        dbHowTo = dbHowTo + "1, ";
        DataCollection.saveStringForDataBase(this, "dbHowToNew", dbHowTo);

        sounds.play(howto1, 1, 1, 1, 0, 1);

    }
    public void Howto2(View view){
        dbHowTo = dbHowTo + "2, ";
        DataCollection.saveStringForDataBase(this, "dbHowToNew", dbHowTo);
        sounds.play(howto2, 1, 1, 1, 0, 1);

    }
    public void Howto3(View view){
        dbHowTo = dbHowTo + "3, ";
        DataCollection.saveStringForDataBase(this, "dbHowToNew", dbHowTo);
        sounds.play(howto3, 1, 1, 1, 0, 1);

    }
    public void Howto4(View view){
        dbHowTo = dbHowTo + "4, ";
        DataCollection.saveStringForDataBase(this, "dbHowToNew", dbHowTo);
        sounds.play(howto4, 1, 1, 1, 0, 1);

    }
    public void Howto5(View view){
        dbHowTo = dbHowTo + "5, ";
        DataCollection.saveStringForDataBase(this, "dbHowToNew", dbHowTo);
        sounds.play(howto5, 1, 1, 1, 0, 1);

    }
}
