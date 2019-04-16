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
        flushStatics();
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

    public void flushStatics(){
        BeActiveScreen.dbHowTo = "";
        FAQScreen.faqAccess = "";
        ProgramSelectionScreen.currentWeek ="";
    }


    private void SendToDatabase(){

        // Set the values of Data collection object
        String userLog = "user:" + DataCollection.getStringForDataBase(this, "userName");
        String avatar = DataCollection.getStringForDataBase(this, "selectedAvatar");
        Integer FAQMenuAccessed = DataCollection.getIntForDataBase(this, "faqPageAccessed");
        String sentToPhone = DataCollection.getStringForDataBase(this, "sentToPhone");
        Integer trainingProgrammesAccessed = DataCollection.getIntForDataBase(this, "trainingProgrammesAccessed");
        String exerciseViewed = DataCollection.getStringForDataBase(this, "exerciseViewed");
        String WeekAccessed = DataCollection.getStringForDataBase(this, "dataBaseWeekAccessed");
        String howToAnswerViewed = DataCollection.getStringForDataBase(this, "dbHowToNew");
        String faqAccessNew = DataCollection.getStringForDataBase(this, "faqAccessNew");
        String sentToPrinter = DataCollection.getStringForDataBase(this, "sentToPrinter");

        // This class handles the creation of object that is sent to Firebase
        DataCollection dCollection = new DataCollection(
                userLog,
                avatar,
                FAQMenuAccessed,
                sentToPhone,
                trainingProgrammesAccessed,
                exerciseViewed,
                WeekAccessed,
                howToAnswerViewed,
                faqAccessNew,
                sentToPrinter
        );

        // Sends the data to a collection named 'messages' in Firebase
        databaseReference.child("messages").push().setValue(dCollection);
    /*
      To do:
      Security rules                    DONE
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
