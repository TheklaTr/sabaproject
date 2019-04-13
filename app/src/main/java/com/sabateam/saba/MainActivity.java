package com.sabateam.saba;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;

    EditText givenUsername;
    EditText givenPassword;

    ImageButton clickedUK;
    ImageButton clickedSA;

    int[] flags = {R.drawable.ukflag, R.drawable.ukflag_small, R.drawable.saflag, R.drawable.saflag_small};

    String currentLocale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        givenUsername = (EditText)findViewById(R.id.userName);
        givenPassword = (EditText)findViewById(R.id.passwordField);
        clickedUK = (ImageButton)findViewById(R.id.selectUk);
        clickedSA = (ImageButton)findViewById(R.id.selectSA);

        Log.d("test tag", "test message");

        currentLocale = getResources().getConfiguration().locale.getLanguage();
        // For debugging
        Toast.makeText(MainActivity.this, "selected language " + currentLocale, Toast.LENGTH_LONG).show();

        if(currentLocale.equals("en")){
            clickedUK.setImageResource(flags[0]);
            clickedSA.setImageResource(flags[3]);
        }
        else {
            clickedUK.setImageResource(flags[1]);
            clickedSA.setImageResource(flags[2]);
        }

        givenPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if(actionId == 100 || actionId == EditorInfo.IME_NULL) {
                    StartLoginProcess();
                    return true;
                }
                return false;
            }
        });


        auth = FirebaseAuth.getInstance();

    }

//    public void Login(View view) {
//
//        // When user pressed login button, we need to check given data against database that
//        // holds login information. So replace this placeholder with that implementation when
//        // it is ready
//
//        if(givenUsername.getText().toString().equals("user") &&
//                givenPassword.getText().toString().equals("1111")) {
//
//            // Database checks here, if user is found then populate User object with data that is needed
//            // Current data is just placeholder for now. This section might need bit rearranging
//
//            User user = new User(1, givenUsername.getText().toString());
//
//            // If the avatar is null, then it is presumed that user is logging in for the first time
//            // and is redirected to the avatar selection screen. After first login and logout, avatar
//            // data is saved to database and next time they will skip this check
//            if(user.GetAvatar() == null) {
//                Intent intent = new Intent(this, AvatarScreen.class);
//                intent.putExtra("userObject", user);
//                startActivity(intent);
//                finish();
//
//            } else {
//                Intent intent = new Intent(this, MenuScreen.class);
//                intent.putExtra("userObject", user);
//                startActivity(intent);
//                DataCollection.saveStringForDataBase(this, "selectedAvatar", user.GetAvatar());
//                finish();
//            }
//
//        } else {
//            Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show();
//        }
//    }

    // Executed when Sign in button pressed
    public void signInExistingUser(View v)   {
        StartLoginProcess();

    }

    private void StartLoginProcess(){

        final String login = givenUsername.getText().toString();
        String password = givenPassword.getText().toString();

        String fullLogin = login + "@a.com";

        // If both fields are empty, stop login process
        if(login.equals("") || password.equals("")) return;

        auth.signInWithEmailAndPassword(fullLogin, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(!task.isSuccessful()){
                    ShowErrorDialog("Problem signing in, please check username and password");
                }
                else{
                    DataCollection.saveStringForDataBase(MainActivity.this, "userName", login);
                    Intent intent = new Intent(MainActivity.this, AvatarScreen.class);
                    finish();
                    startActivity(intent);
                }
            }
        });
    }

    private void ShowErrorDialog(String message){

        new AlertDialog.Builder(this)
                .setTitle("Oops")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
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
