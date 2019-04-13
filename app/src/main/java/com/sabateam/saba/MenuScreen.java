package com.sabateam.saba;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.Locale;

public class MenuScreen extends AppCompatActivity {

    User user;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);


        // Gets the User object from previous intent
        Intent intent = getIntent();
        user = (User)intent.getSerializableExtra("userObject");

        // For database
        databaseReference = FirebaseDatabase.getInstance().getReference();


    }
    int timesTrainingProgrammesAccessed =0;
    public void ToTrainingPrograms(View view){
        timesTrainingProgrammesAccessed++;
        DataCollection.saveIntForDataBase(this, "trainingProgrammesAccessed", timesTrainingProgrammesAccessed);
        Intent intent = new Intent(this, ProgramSelectionScreen.class);

        // We need to pass in the current progress if we need to regulate on
        // how many training programs users can see

        startActivity(intent);
    }

    public void ToFAQ(View view){

        // No need to pass in User object here but we might need to pass in some
        // Data object here if we are gathering data on what FAQ's users are clicking
        DataCollection.saveIntForDataBase(this, "faqPageAccessed", 1);
        Intent intent = new Intent(this, FAQScreen.class);
        startActivity(intent);
    }

    public void ToHowToBeActive(View view) {

        // Depending on the structure of this page, which is a mystery at the moment
        // we might have to pass in the Data model in case we need to track happenings
        // inside 'How to be Active'
        Intent intent = new Intent(this, BeActiveScreen.class);
        DataCollection.saveIntForDataBase(this, "howToBeActiveAccessed", 1);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){

        // Do nothing in here for now. We are overriding the default onBackPressed
        // method with empty implementation so that we can prevent users from getting back to
        // avatar selection and login screen by pressing the back button
    }

    // ask the user of they really want to logout
    public void ShowConfirmation(View view) {

        AlertDialog.Builder confirmation = new AlertDialog.Builder(this);
        confirmation.setMessage("Are you sure you want to logout?")
                .setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Logout();
                    }
                }).setNegativeButton("Cancel", null);

        confirmation.create();
        confirmation.show();

    }

    private void Logout(){
        SendToDatabase();
        flushSharedPreferences();
        flushDBHTBA();
        flushFAQDB();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void flushSharedPreferences(){
        SharedPreferences preferences = getSharedPreferences("dataBaseSharedPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }

    public void flushDBHTBA(){
        BeActiveScreen.dbHowTo1=0;
        BeActiveScreen.dbHowTo2=0;
        BeActiveScreen.dbHowTo3=0;
        BeActiveScreen.dbHowTo4=0;
        BeActiveScreen.dbHowTo5=0;
    }
    public void flushFAQDB(){
        FAQScreen.faq1Access = 0;
        FAQScreen.faq2Access = 0;
        FAQScreen.faq3Access = 0;
        FAQScreen.faq4Access = 0;
        FAQScreen.faq5Access = 0;
        FAQScreen.faq6Access = 0;
        FAQScreen.faq7Access = 0;
        FAQScreen.faq8Access = 0;
        FAQScreen.faq9Access = 0;
        FAQScreen.faq10Access = 0;
        FAQScreen.faq11Access = 0;
        FAQScreen.faq12Access = 0;
        FAQScreen.faq13Access = 0;
        FAQScreen.faq14Access = 0;
        FAQScreen.faq15Access = 0;
        FAQScreen.faq16Access = 0;
        FAQScreen.faq17Access = 0;
        FAQScreen.faq18Access = 0;
        FAQScreen.faq19Access = 0;

    }
    private void storeDataExample(int dataExample){ //make creators in .javas to store in sharedpreference
        SharedPreferences mSharedPreferences = getSharedPreferences("dataBaseSharedPreferences", MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putInt("dataExampleOne", dataExample);
        mEditor.apply();
    }


    private void SendToDatabase(){

        // Set the values of Data collection object
        String userLog = "user:" + DataCollection.getStringForDataBase(this, "userName");
        String avatar = DataCollection.getStringForDataBase(this, "selectedAvatar");
        Integer FAQAccessed = DataCollection.getIntForDataBase(this, "faqPageAccessed");
        Integer faqdata1 = DataCollection.getIntForDataBase(this, "faq1Access");
        Integer faqdata2 = DataCollection.getIntForDataBase(this, "faq2Access");
        Integer faqdata3 = DataCollection.getIntForDataBase(this, "faq3Access");
        Integer faqdata4 = DataCollection.getIntForDataBase(this, "faq4Access");
        Integer faqdata5 = DataCollection.getIntForDataBase(this, "faq5Access");
        Integer faqdata6 = DataCollection.getIntForDataBase(this, "faq6Access");
        Integer faqdata7 = DataCollection.getIntForDataBase(this, "faq7Access");
        Integer faqdata8 = DataCollection.getIntForDataBase(this, "faq8Access");
        Integer faqdata9 = DataCollection.getIntForDataBase(this, "faq9Access");
        Integer faqdata10 = DataCollection.getIntForDataBase(this, "faq10Access");
        Integer faqdata11 = DataCollection.getIntForDataBase(this, "faq11Access");
        Integer faqdata12 = DataCollection.getIntForDataBase(this, "faq12Access");
        Integer faqdata13 = DataCollection.getIntForDataBase(this, "faq13Access");
        Integer faqdata14 = DataCollection.getIntForDataBase(this, "faq14Access");
        Integer faqdata15 = DataCollection.getIntForDataBase(this, "faq15Access");
        Integer faqdata16 = DataCollection.getIntForDataBase(this, "faq16Access");
        Integer faqdata17 = DataCollection.getIntForDataBase(this, "faq17Access");
        Integer faqdata18 = DataCollection.getIntForDataBase(this, "faq18Access");
        Integer sentToPhone = DataCollection.getIntForDataBase(this, "sentToPhone");
        Integer trainingProgrammesAccessed = DataCollection.getIntForDataBase(this, "trainingProgrammesAccessed");
        String exerciseViewed = DataCollection.getStringForDataBase(this, "exerciseViewed");
        String dataBaseWeekAccessed = DataCollection.getStringForDataBase(this, "dataBaseWeekAccessed");
        Integer htbaAccess1 = DataCollection.getIntForDataBase(this, "howTo1");
        Integer htbaAccess2 = DataCollection.getIntForDataBase(this, "howTo2");
        Integer htbaAccess3 = DataCollection.getIntForDataBase(this, "howTo3");
        Integer htbaAccess4 = DataCollection.getIntForDataBase(this, "howTo4");
        Integer htbaAccess5 = DataCollection.getIntForDataBase(this, "howTo5");


        // This class handles the creation of object that is sent to Firebase
        DataCollection dCollection = new DataCollection(
                userLog,
                avatar,
                FAQAccessed,
                faqdata1,
                faqdata2,
                faqdata3,
                faqdata4,
                faqdata5,
                faqdata6,
                faqdata7,
                faqdata8,
                faqdata9,
                faqdata10,
                faqdata11,
                faqdata12,
                faqdata13,
                faqdata14,
                faqdata15,
                faqdata16,
                faqdata17,
                faqdata18,
                sentToPhone,
                trainingProgrammesAccessed,
                exerciseViewed,
                dataBaseWeekAccessed,
                htbaAccess1,
                htbaAccess2,
                htbaAccess3,
                htbaAccess4,
                htbaAccess5
                );

        // Sends the data to a collection named 'messages' in Firebase
        databaseReference.child("messages").push().setValue(dCollection);
    /*
      To do:
      Security rules
      Sending data on startup if previous user didn't log out
      Data tracking:
        Login identifier = Date+Time+User
        FAQ Access (Y/N)                DONE
            Which questions             DONE
            How many times              DONE
        How To be Active Access (Y/N)   DONE
            Which entries               DONE
            How many times              DONE
        Exercise programs               DONE
            # times accessed            DONE
            Downloaded (Y/N)            Done for phone, print not in the code yet (I think)
                Phone or print
            Time since last download (post data collection problem?)
            Exercises                   DONE
                Which ones              DONE
                # times                 DONE
        Current phase + week        Is this in the code yet?
        Sending and flushing in case logout is not used         NOT DONE
    */




    }


}
