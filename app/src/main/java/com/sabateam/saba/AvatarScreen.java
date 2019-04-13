package com.sabateam.saba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AvatarScreen extends AppCompatActivity {

    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar_screen);

        TextView userText = (TextView)findViewById(R.id.userTxt);
        userName = DataCollection.getStringForDataBase(this, "userName");

        userText.setText(userName);
    }

    public void SelectedMale(View view) {


        DataCollection.saveStringForDataBase(this, "selectedAvatar", "Male");
        SetAvatarAndGo();
    }

    public void SelectedFemale(View view) {


        DataCollection.saveStringForDataBase(this, "selectedAvatar", "Female");
        SetAvatarAndGo();
    }

    public void SetAvatarAndGo() {

        Intent intent = new Intent(this, MenuScreen.class);
        finish();
        startActivity(intent);
    }
}
