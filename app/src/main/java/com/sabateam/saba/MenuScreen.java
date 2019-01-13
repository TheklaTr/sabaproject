package com.sabateam.saba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
