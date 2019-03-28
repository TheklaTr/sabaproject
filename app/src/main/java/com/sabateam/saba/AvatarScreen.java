package com.sabateam.saba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AvatarScreen extends AppCompatActivity {

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar_screen);

        TextView userText = (TextView)findViewById(R.id.userTxt);

        // Gets the User object from previous intent
        Intent intent = getIntent();
        user = (User)intent.getSerializableExtra("userObject");

        userText.setText(user.GetUsername());
    }

    public void SelectedMale(View view) {

        SetAvatarAndGo("male");
        DataCollection.saveStringForDataBase(this, "selectedAvatar", "Male");
    }

    public void SelectedFemale(View view) {

        SetAvatarAndGo("female");
        DataCollection.saveStringForDataBase(this, "selectedAvatar", "Female");
    }

    public void SetAvatarAndGo(String avatar) {

        user.SetAvatar(avatar);

        Intent intent = new Intent(this, MenuScreen.class);
        intent.putExtra("userObject", user);
        startActivity(intent);
        finish();
    }
}
