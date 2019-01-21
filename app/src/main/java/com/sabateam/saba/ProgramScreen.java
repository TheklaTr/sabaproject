package com.sabateam.saba;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProgramScreen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_screen);


    }

    // Temp method for button
    public void TempShowAlert(View view){

        ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.nwuni_logo);

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("Gif of the move would be here, maybe")
                .setPositiveButton("Done", null).setView(image);

        builder.create().show();
    }

    public void SendProgramToPhone(View view) {

        // Implementation here
        // Either send directly, or open up a new screen where the connection is established
        // with instructions
    }

    public void BackButton(View view){

        super.onBackPressed();
    }
}
