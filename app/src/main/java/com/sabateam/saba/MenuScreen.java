package com.sabateam.saba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuScreen extends AppCompatActivity {

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        // Gets the User object from previous intent
        Intent intent = getIntent();
        user = (User)intent.getSerializableExtra("userObject");

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
        Intent intent = new Intent(this, FAQScreen.class);
        startActivity(intent);
    }

    public void ToHowToBeActive(View view) {

        // Depending on the structure of this page, which is a mystery at the moment
        // we might have to pass in the Data model in case we need to track happenings
        // inside 'How to be Active'
        Intent intent = new Intent(this, BeActiveScreen.class);
        startActivity(intent);
    }
}
