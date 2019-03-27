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

        // Some debugging stuff. Will be removed when not needed anymore
        TextView idTxt = (TextView)findViewById(R.id.debugID);
        TextView usernameTxt = (TextView)findViewById(R.id.debugUser);
        TextView avatarTxt = (TextView)findViewById(R.id.debugAvatar);
        idTxt.setText(Integer.toString(user.GetId()));
        usernameTxt.setText((user.GetUsername()));
        avatarTxt.setText(user.GetAvatar());

    }

    public void ToTrainingPrograms(View view){

        Intent intent = new Intent(this, ProgramSelectionScreen.class);

        // We need to pass in the current progress if we need to regulate on
        // how many training programs users can see

        startActivity(intent);
    }

    public void ToFAQ(View view){

        // No need to pass in User object here but we might need to pass in some
        // Data object here if we are gathering data on what FAQ's users are clicking
        storeDataExample(5); // dummy data
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
        storeDataExample(0);
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

    private void storeDataExample(int dataExample){ //make creators in .javas to store in sharedpreference
        SharedPreferences mSharedPreferences = getSharedPreferences("dataBaseSharedPreferences", MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putInt("dataExampleOne", dataExample);
        mEditor.apply();
    }

    private int getSharedData() {
        SharedPreferences mSharedPreferences = getSharedPreferences("dataBaseSharedPreferences", MODE_PRIVATE);
        int dataToBeSent = mSharedPreferences.getInt("dataExampleOne", 0);
        return  dataToBeSent;
    }
    private int getDataBaseFAQData() {
        SharedPreferences mSharedPreferences = getSharedPreferences("dataBaseSharedPreferences", MODE_PRIVATE);
        int dataToBeSent = mSharedPreferences.getInt("bdFAQData1a", 0);
        return  dataToBeSent;
    }
    /*
    private int getDataBaseFAQData2() {
        SharedPreferences mSharedPreferences = getSharedPreferences("dataBaseSharedPreferences", MODE_PRIVATE);
        int dataToBeSent2 = mSharedPreferences.getInt("bdFAQData2a", 0);
        return  dataToBeSent2;
    }
    */


    private void SendToDatabase(){

        // Set the values of Data collection object
        String msg1 = user.GetUsername();
        String msg2 = Integer.toString(DataCollection.getIntForDataBase(this, "howToBeActiveAccessed"));
        Integer msg3 = getSharedData();
        String msg4 = Integer.toString(getDataBaseFAQData());
    /*
      To do: Security rules
      Data tracking:
        Login identifier = Date+Time+User
        FAQ Access (Y/N)
            Which questions
            How many times
        How To be Active Access (Y/N)
            Which entries
            How many times
        Exercise programs
            # times accessed
            Downloaded (Y/N)
                Phone or print
            Time since last download (post data collection problem?)
            Exercises
                Which ones
                # times
            Current phase + week
    */


        // This class handles the creation of object that is sent to Firebase
        DataCollection dCollection = new DataCollection(msg1, msg2, msg3, msg4);

        // Sends the data to a collection named 'messages' in Firebase
        databaseReference.child("messages").push().setValue(dCollection);

    }


}
