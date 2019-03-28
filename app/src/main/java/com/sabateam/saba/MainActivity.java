package com.sabateam.saba;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText givenUsername;
    EditText givenPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        givenUsername = (EditText)findViewById(R.id.userName);
        givenPassword = (EditText)findViewById(R.id.passwordField);

        Log.d("test tag", "test message");

    }

    public void Login(View view) {

        // When user pressed login button, we need to check given data against database that
        // holds login information. So replace this placeholder with that implementation when
        // it is ready

        if(givenUsername.getText().toString().equals("user") &&
                givenPassword.getText().toString().equals("1111")) {

            // Database checks here, if user is found then populate User object with data that is needed
            // Current data is just placeholder for now. This section might need bit rearranging

            User user = new User(1, givenUsername.getText().toString());

            // If the avatar is null, then it is presumed that user is logging in for the first time
            // and is redirected to the avatar selection screen. After first login and logout, avatar
            // data is saved to database and next time they will skip this check
            if(user.GetAvatar() == null) {
                Intent intent = new Intent(this, AvatarScreen.class);
                intent.putExtra("userObject", user);
                startActivity(intent);
                finish();

            } else {
                Intent intent = new Intent(this, MenuScreen.class);
                intent.putExtra("userObject", user);
                startActivity(intent);
                DataCollection.saveStringForDataBase(this, "selectedAvatar", user.GetAvatar());
                finish();
            }

        } else {
            Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show();
        }
    }

    // Translation buttons
    public void TranslateToEnglish(View v){
        SetLocale("en");
    }

    public void TranslateToTSwana(View v) {
        SetLocale("tn");
    }

    public void SetLocale(String lang) {

        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();

        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        finish();
        startActivity(refresh);
    }
}
