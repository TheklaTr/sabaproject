package com.sabateam.saba;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import android.widget.LinearLayout.LayoutParams;

import com.google.android.gms.vision.text.Line;

public class ProgramScreen extends AppCompatActivity {

    static TextView[] moveTexts;
    static TextView[] moveSetTexts;
    static ImageButton[] moveAnimations;
    int[] videoArray;

    static List<String> aerobics = new ArrayList<>();
    static List<String> strength = new ArrayList<>();
    static List<String> balance = new ArrayList<>();
    static List<String> flexes = new ArrayList<>();
    static List<String> animationsMale = new ArrayList<>();
    static List<String> animationsFemale = new ArrayList<>();
    static List<String> sets = new ArrayList<>();

    int place;

    LinearLayout linear1;
    LinearLayout linear2;
    LinearLayout linear3;
    LinearLayout linear4;
    LinearLayout linear5;
    LinearLayout linear6;
    LinearLayout linear7;
    LinearLayout linear8;
    LinearLayout linear9;
    LinearLayout linear10;
    LinearLayout linear11;
    LinearLayout linear12;

    String receivedJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_screen);


        receivedJson = (String) getIntent().getStringExtra("sentItem");

        aerobics = JsonIntoList(receivedJson, "aerobic");
        strength = JsonIntoList(receivedJson, "strength");
        balance = JsonIntoList(receivedJson, "balance");
        flexes = JsonIntoList(receivedJson, "flex");
        animationsMale = JsonIntoList(receivedJson, "animations_male");
        animationsFemale = JsonIntoList(receivedJson, "animations_female");
        sets = JsonIntoList(receivedJson, "sets");

        moveTexts = new TextView[sets.size()];
        moveSetTexts = new TextView[sets.size()];
        moveAnimations = new ImageButton[sets.size()];
        videoArray = new int[sets.size()];

        linear1 = (LinearLayout) findViewById(R.id.aerobicMoves);
        linear2 = (LinearLayout) findViewById(R.id.strengthMoves);
        linear3 = (LinearLayout) findViewById(R.id.balanceMoves);
        linear4 = (LinearLayout) findViewById(R.id.flexMoves);
        linear5 = (LinearLayout) findViewById(R.id.aerobicReps);
        linear6 = (LinearLayout) findViewById(R.id.strengthReps);
        linear7 = (LinearLayout) findViewById(R.id.balanceReps);
        linear8 = (LinearLayout) findViewById(R.id.flexReps);
        linear9 = (LinearLayout) findViewById(R.id.aerobicVid);
        linear10 = (LinearLayout) findViewById(R.id.strengthVid);
        linear11 = (LinearLayout) findViewById(R.id.balanceVid);
        linear12 = (LinearLayout) findViewById(R.id.flexVid);

        place = 0;

        // Sets the correct animations into the videoArray
        SetVideoArray(sets.size());


        // Sets the contents of exercise page
        SetContent(aerobics.size(), linear1, linear5, linear9, aerobics);
        SetContent(strength.size(), linear2, linear6, linear10, strength);
        SetContent(balance.size(), linear3, linear7, linear11, balance);
        SetContent(flexes.size(), linear4, linear8, linear12, flexes);
    }

    public void SetContent(int size, LinearLayout linearA, LinearLayout linearB, LinearLayout linearC, List<String> moveList) {

        for(int i = 0; i < size; i++) {
            moveTexts[place] = new TextView(this);
            moveSetTexts[place] = new TextView(this);
            moveAnimations[place] = new ImageButton(this);

            LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            layoutParams.gravity = Gravity.LEFT;
            layoutParams.setMargins(16, 90, 0,40);
            layoutParams.weight = 0.33F;

            moveTexts[place].setLayoutParams(layoutParams);
            moveSetTexts[place].setLayoutParams(layoutParams);
            moveTexts[place].setText(moveList.get(i));
            moveSetTexts[place].setText(sets.get(place));
            moveTexts[place].setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            moveSetTexts[place].setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

            linearA.addView(moveTexts[place]);
            linearB.addView(moveSetTexts[place]);

            LayoutParams imageParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            imageParams.setMargins(16, 10, 0,15);
            imageParams.weight = 0.33F;

            moveAnimations[place].setImageResource(R.drawable.placeholderimg);
            moveAnimations[place].setLayoutParams(imageParams);
            moveAnimations[place].setOnClickListener(animationListener);
            moveAnimations[place].setBackgroundColor(Color.TRANSPARENT);
            moveAnimations[place].setTag(place);
            moveAnimations[place].setId(place);
            linearC.addView(moveAnimations[place]);

            place++;
        }
    }

    private View.OnClickListener animationListener = new View.OnClickListener(){

        @Override
        public void onClick(View v){
            // For debugging
            Toast.makeText(ProgramScreen.this, "ID " + v.getId(), Toast.LENGTH_LONG).show();

            ShowExerciseInDialog(v.getId());
        }
    };

    private void SetVideoArray(int size) {

        for(int i = 0; i < size; i++){

            String nameOfAnimation = animationsMale.get(i);
            int resID = getResources().getIdentifier(nameOfAnimation, "raw", getPackageName());

            videoArray[i] = resID;
        }
    }


    // Temp method for button
    public void ShowExerciseInfo(View view){

        Intent intent = new Intent(this, ExerciseInfo.class);
        startActivity(intent);


    }



    // Temp method for demonstration
    public void ShowExerciseInDialog(int idNumber) {

        VideoView videoFeed = new VideoView(this);
        String videoPath = "android.resource://" + getPackageName() + "/" + getResources().getIdentifier("" + videoArray[idNumber], "raw", getPackageName());
        videoFeed.setVideoPath(videoPath);

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this).
                        setView(videoFeed).
                        setPositiveButton("OK", null);


        videoFeed.setZOrderOnTop(true);
        videoFeed.start();
        builder.create().show();

        videoFeed.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }


    public void SendProgramToPhone(View view) {

        // Implementation here
        // Either send directly, or open up a new screen where the connection is established
        // with instructions
    }


    public ArrayList<String> JsonIntoList(String jsonString, String moveType) {

        List<String> list = new ArrayList<>();

        try {

            JSONObject reader = new JSONObject(jsonString);
            JSONObject move = reader.getJSONObject(moveType);

            for (int i = 0; i < move.length(); i++) {

                String moveCounter = "move" + (i+1);
                list.add(move.getString(moveCounter));
            }

        } catch (JSONException ex) {
            ex.printStackTrace();
        }

        return (ArrayList<String>) list;
    }


    public void BackButton(View view){

        super.onBackPressed();
        finish();
    }


}
