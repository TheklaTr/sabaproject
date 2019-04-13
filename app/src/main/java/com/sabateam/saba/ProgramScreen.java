package com.sabateam.saba;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
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

    CardView aerobicBox;
    CardView strengthBox;
    CardView balanceBox;
    CardView flexBox;

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
    String selectedAvatar;
    String bluetoothFilename;
    String exercisesViewed = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_screen);

        selectedAvatar = DataCollection.getStringForDataBase(this, "selectedAvatar");

        // For debugging
        Toast.makeText(ProgramScreen.this, "selected avatar " + selectedAvatar, Toast.LENGTH_LONG).show();


        receivedJson = (String) getIntent().getStringExtra("sentItem");

        aerobics = JsonIntoList(receivedJson, "aerobic");
        strength = JsonIntoList(receivedJson, "strength");
        balance = JsonIntoList(receivedJson, "balance");
        flexes = JsonIntoList(receivedJson, "flex");
        animationsMale = JsonIntoList(receivedJson, "animations_male");
        animationsFemale = JsonIntoList(receivedJson, "animations_female");
        sets = JsonIntoList(receivedJson, "sets");

        // Nico use this variable in bluetooth code
        bluetoothFilename = getStringFromJSON(receivedJson, "bluetoothFile");


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

        // Finds the expandable cards and sets them GONE
        aerobicBox = (CardView)findViewById(R.id.aerobicCard);
        strengthBox = (CardView)findViewById(R.id.strengthCard);
        balanceBox = (CardView)findViewById(R.id.balanceCard);
        flexBox = (CardView)findViewById(R.id.flexCard);
        aerobicBox.setVisibility(View.GONE);
        strengthBox.setVisibility(View.GONE);
        balanceBox.setVisibility(View.GONE);
        flexBox.setVisibility(View.GONE);


    }

    public void SetContent(int size, LinearLayout linearA, LinearLayout linearB, LinearLayout linearC, List<String> moveList) {

        for(int i = 0; i < size; i++) {
            moveTexts[place] = new TextView(this);
            moveSetTexts[place] = new TextView(this);
            moveAnimations[place] = new ImageButton(this);

            LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            layoutParams.gravity = Gravity.LEFT;
            layoutParams.setMargins(16, 65, 0,40);
            layoutParams.weight = 0.33F;

            moveTexts[place].setLayoutParams(layoutParams);
            moveSetTexts[place].setLayoutParams(layoutParams);
            moveTexts[place].setText(moveList.get(i));
            moveSetTexts[place].setText(sets.get(place));
            moveTexts[place].setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            moveSetTexts[place].setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

            linearA.addView(moveTexts[place]);
            linearB.addView(moveSetTexts[place]);

            LayoutParams imageParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
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


            ShowExerciseInDialog(v.getId());
        }
    };

    private void SetVideoArray(int size) {

        for(int i = 0; i < size; i++){

            // if user has selected male, populate videoArray with male moves else with female moves
            if(selectedAvatar.equals("Male")){

                String nameOfAnimation = animationsMale.get(i);
                int resID = getResources().getIdentifier(nameOfAnimation, "raw", getPackageName());
                videoArray[i] = resID;

            } else {

                String nameOfAnimation = animationsFemale.get(i);
                int resID = getResources().getIdentifier(nameOfAnimation, "raw", getPackageName());
                videoArray[i] = resID;
            }
        }
    }


    // Temp method for button
    public void ShowExerciseInfo(View view){

        Intent intent = new Intent(this, ExerciseInfo.class);
        startActivity(intent);


    }

    String dataBaseTest = "ProgramTest: ";


    // Temp method for demonstration
    public void ShowExerciseInDialog(int idNumber) {


        String currentExercise;

        if(selectedAvatar.equals("Male")){
            currentExercise = animationsMale.get(idNumber);
        } else {
            currentExercise = animationsFemale.get(idNumber);
        }

        exercisesViewed += currentExercise + ", ";
        DataCollection.saveStringForDataBase(this,"exerciseViewed", exercisesViewed);

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
        DataCollection.saveIntForDataBase(this,"sentToPhone", 1); //save info for database
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

    public String getStringFromJSON(String jsonString, String stringToGet){

        String filename = "";

        try {
            JSONObject json = new JSONObject(jsonString);
            filename = json.getString(stringToGet);

        } catch (JSONException ex) {
            ex.printStackTrace();
        }

        return filename;

    }




    public void BackButton(View view){

        super.onBackPressed();
        finish();
    }

    // Placeholder methods for sliding the training views
    public void AerobicToggle(View v){
        if(aerobicBox.isShown()){
            CustomAnim.SlideUp(this, aerobicBox);
            aerobicBox.setVisibility(View.GONE);
        }
        else {
            aerobicBox.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, aerobicBox);
        }
    }

    public void StrengthToggle(View v){
        if(strengthBox.isShown()){
            CustomAnim.SlideUp(this, strengthBox);
            strengthBox.setVisibility(View.GONE);
        }
        else {
            strengthBox.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, strengthBox);
        }
    }

    public void BalanceToggle(View v){
        if(balanceBox.isShown()){
            CustomAnim.SlideUp(this, balanceBox);
            balanceBox.setVisibility(View.GONE);
        }
        else {
            balanceBox.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, balanceBox);
        }
    }

    public void FlexToggle(View v){
        if(flexBox.isShown()){
            CustomAnim.SlideUp(this, flexBox);
            flexBox.setVisibility(View.GONE);
        }
        else {
            flexBox.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, flexBox);
        }
    }


}
