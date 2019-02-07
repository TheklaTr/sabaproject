package com.sabateam.saba;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import android.widget.LinearLayout.LayoutParams;

public class ProgramScreen extends AppCompatActivity {

    static String[] programArray = new String[38];
    //static TextView[] moveTexts = new TextView[19];
    //static TextView[] moveSetTexts = new TextView[19];
    static TextView[] moveTexts;
    static TextView[] moveSetTexts;

    static List<String> aerobics = new ArrayList<>();
    static List<String> strength = new ArrayList<>();
    static List<String> balance = new ArrayList<>();
    static List<String> flexes = new ArrayList<>();
    static List<String> sets = new ArrayList<>();

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

        // Receive bundle from program selection
        //Bundle bundle = this.getIntent().getExtras();
        //programArray = bundle.getStringArray("sentItem");

        receivedJson = (String) getIntent().getStringExtra("sentItem");

        aerobics = JsonIntoList(receivedJson, "aerobic");
        strength = JsonIntoList(receivedJson, "strength");
        balance = JsonIntoList(receivedJson, "balance");
        flexes = JsonIntoList(receivedJson, "flex");
        sets = JsonIntoList(receivedJson, "sets");

        moveTexts = new TextView[sets.size()];
        moveSetTexts = new TextView[sets.size()];

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

        int place = 0;

        for(int i = 0; i < aerobics.size(); i++) {

            moveTexts[place] = new TextView(this);
            moveSetTexts[place] = new TextView(this);
            LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            layoutParams.gravity = Gravity.LEFT;
            layoutParams.setMargins(16, 16, 0,20);
            layoutParams.weight = 0.33F;
            moveTexts[place].setLayoutParams(layoutParams);
            moveSetTexts[place].setLayoutParams(layoutParams);
            moveTexts[place].setText(aerobics.get(i));
            moveSetTexts[place].setText(sets.get(place));
            moveTexts[place].setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            moveSetTexts[place].setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            linear1.addView(moveTexts[place]);
            linear5.addView(moveSetTexts[place]);

            place++;
        }

        for(int i = 0; i < strength.size(); i++) {

            moveTexts[place] = new TextView(this);
            moveSetTexts[place] = new TextView(this);
            LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            layoutParams.gravity = Gravity.LEFT;
            layoutParams.setMargins(16, 16, 0,20);
            layoutParams.weight = 0.33F;
            moveTexts[place].setLayoutParams(layoutParams);
            moveSetTexts[place].setLayoutParams(layoutParams);
            moveTexts[place].setText(strength.get(i));
            moveSetTexts[place].setText(sets.get(place));
            moveTexts[place].setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            moveSetTexts[place].setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            linear2.addView(moveTexts[place]);
            linear6.addView(moveSetTexts[place]);

            place++;
        }

        for(int i = 0; i < balance.size(); i++) {

            moveTexts[place] = new TextView(this);
            moveSetTexts[place] = new TextView(this);
            LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            layoutParams.gravity = Gravity.LEFT;
            layoutParams.setMargins(16, 16, 0,20);
            layoutParams.weight = 0.33F;
            moveTexts[place].setLayoutParams(layoutParams);
            moveSetTexts[place].setLayoutParams(layoutParams);
            moveTexts[place].setText(balance.get(i));
            moveSetTexts[place].setText(sets.get(place));
            moveTexts[place].setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            moveSetTexts[place].setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            linear3.addView(moveTexts[place]);
            linear7.addView(moveSetTexts[place]);

            place++;
        }

        for(int i = 0; i < flexes.size(); i++) {

            moveTexts[place] = new TextView(this);
            moveSetTexts[place] = new TextView(this);
            LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            layoutParams.gravity = Gravity.LEFT;
            layoutParams.setMargins(16, 16, 0,20);
            layoutParams.weight = 0.33F;
            moveTexts[place].setLayoutParams(layoutParams);
            moveSetTexts[place].setLayoutParams(layoutParams);
            moveTexts[place].setText(flexes.get(i));
            moveSetTexts[place].setText(sets.get(place));
            moveTexts[place].setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            moveSetTexts[place].setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            linear4.addView(moveTexts[place]);
            linear8.addView(moveSetTexts[place]);

            place++;
        }


        // Find the id's of the textviews and sets the contents from programarray
/*        for(int i = 0; i < 19; i++) {

            String moves = "move" + (i+1);
            String moveSets = "move" + (i+1) + "sets";
            int moveResId = getResources().getIdentifier(moves, "id", getPackageName());
            int moveSetsResId = getResources().getIdentifier(moveSets, "id", getPackageName());

            moveTexts[i] = (TextView) findViewById(moveResId);
            moveSetTexts[i] = (TextView) findViewById(moveSetsResId);

            moveTexts[i].setText(programArray[i]);
            moveSetTexts[i].setText(programArray[i+19]);
        }*/

    }

    // Temp method for button
    public void ShowExerciseInfo(View view){

        Intent intent = new Intent(this, ExerciseInfo.class);
        startActivity(intent);


    }

    // Temp method for demonstration
    public void ShowExerciseInDialog(View view) {

        VideoView videoFeed = new VideoView(this);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.character_vid;
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
                //String moveSets = "move" + (i+1) +"sets";

                //program[i] = trainingProgram.getString(move);
                //program[i+19] = trainingProgram.getString(moveSets);

                list.add(move.getString(moveCounter));
            }

        } catch (JSONException ex) {
            ex.printStackTrace();
        }

        return (ArrayList<String>) list;
    }


    public void BackButton(View view){

        super.onBackPressed();
    }
}
