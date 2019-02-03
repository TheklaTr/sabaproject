package com.sabateam.saba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

public class ProgramSelectionScreen extends AppCompatActivity implements View.OnClickListener {

    static String[] program = new String[38];
    static String returnedJson;
    static Button[] buttons = new Button[24];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_selection_screen);

        // Finds the id's of buttons and sets the listeners
        for (int i = 0; i < 24; i++) {

            String buttonId = "week" + (i+1);
            int resId = getResources().getIdentifier(buttonId, "id", getPackageName());
            buttons[i] = (Button) findViewById(resId);
            buttons[i].setOnClickListener(this);
        }

    }

    // Switch structure for buttons and fetching the correct training program
    // This is probably the best structure we can have for now
    @Override
    public void onClick(View v){

        switch (v.getId()) {

            case R.id.week1:
                returnedJson = LoadJsonFromAssets("week1to3.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week2:
                returnedJson = LoadJsonFromAssets("week1to3.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week3:
                returnedJson = LoadJsonFromAssets("week1to3.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week4:
                returnedJson = LoadJsonFromAssets("week4.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week5:
                returnedJson = LoadJsonFromAssets("week4.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week6:
                returnedJson = LoadJsonFromAssets("week1to3.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week7:
                returnedJson = LoadJsonFromAssets("week1to3.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week8:
                returnedJson = LoadJsonFromAssets("week4.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week9:
                returnedJson = LoadJsonFromAssets("week1to3.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week10:
                returnedJson = LoadJsonFromAssets("week1to3.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week11:
                returnedJson = LoadJsonFromAssets("week1to3.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week12:
                returnedJson = LoadJsonFromAssets("week4.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week13:
                returnedJson = LoadJsonFromAssets("week1to3.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week14:
                returnedJson = LoadJsonFromAssets("week1to3.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week15:
                returnedJson = LoadJsonFromAssets("week1to3.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week16:
                returnedJson = LoadJsonFromAssets("week4.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week18:
                returnedJson = LoadJsonFromAssets("week1to3.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week19:
                returnedJson = LoadJsonFromAssets("week1to3.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week20:
                returnedJson = LoadJsonFromAssets("week1to3.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week21:
                returnedJson = LoadJsonFromAssets("week4.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week22:
                returnedJson = LoadJsonFromAssets("week1to3.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week23:
                returnedJson = LoadJsonFromAssets("week1to3.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;

            case R.id.week24:
                returnedJson = LoadJsonFromAssets("week4.json");
                JsonIntoArray(returnedJson);
                FetchProgramAndSendIt(program);
                break;
        }
    }


    public void FetchProgramAndSendIt(String[] array) {

        Bundle bundle = new Bundle();
        bundle.putStringArray("sentItem", array);

        Intent intent = new Intent(this, ProgramScreen.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }


    public String LoadJsonFromAssets(String fileName){

        String json = null;

        try {

            InputStream iStream = getAssets().open(fileName);
            int size = iStream.available();
            byte[] buffer = new byte[size];
            iStream.read(buffer);
            iStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    public void JsonIntoArray(String jsonString) {

        try {

            JSONObject reader = new JSONObject(jsonString);
            JSONObject trainingProgram = reader.getJSONObject("program");

            for (int i = 0; i < 19; i++) {

                String move = "move" + (i+1);
                String moveSets = "move" + (i+1) +"sets";

                program[i] = trainingProgram.getString(move);
                program[i+19] = trainingProgram.getString(moveSets);
            }

        } catch (JSONException ex) {
            ex.printStackTrace();
        }

    }
}
