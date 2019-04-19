package com.sabateam.saba;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BeActiveScreen extends AppCompatActivity {

    private MediaPlayer mp;


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

    }

    public void BackButton(View view){

        super.onBackPressed();
        finish();
    }

    public void Howto1(View view){
        dbHowTo = dbHowTo + "1, ";
        DataCollection.saveStringForDataBase(this, "dbHowToNew", dbHowTo);

        mp = MediaPlayer.create(this,R.raw.tips1);
        mp.start();

    }
    public void Howto2(View view){
        dbHowTo = dbHowTo + "2, ";
        DataCollection.saveStringForDataBase(this, "dbHowToNew", dbHowTo);
        mp = MediaPlayer.create(this,R.raw.tips2);
        mp.start();
    }
    public void Howto3(View view){
        dbHowTo = dbHowTo + "3, ";
        DataCollection.saveStringForDataBase(this, "dbHowToNew", dbHowTo);
        mp = MediaPlayer.create(this,R.raw.tips3);
        mp.start();

    }
    public void Howto4(View view){
        dbHowTo = dbHowTo + "4, ";
        DataCollection.saveStringForDataBase(this, "dbHowToNew", dbHowTo);
        mp = MediaPlayer.create(this,R.raw.tips4);
        mp.start();
    }
    public void Howto5(View view){
        dbHowTo = dbHowTo + "5, ";
        DataCollection.saveStringForDataBase(this, "dbHowToNew", dbHowTo);
        mp = MediaPlayer.create(this,R.raw.tips5);
        mp.start();
    }
}
