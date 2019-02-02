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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_selection_screen);


        Button week1 = findViewById(R.id.week1);
        Button week2 = findViewById(R.id.week2);
        Button week3 = findViewById(R.id.week3);
        Button week4 = findViewById(R.id.week4);
        Button week5 = findViewById(R.id.week5);
        Button week6 = findViewById(R.id.week6);
        Button week7 = findViewById(R.id.week7);
        Button week8 = findViewById(R.id.week8);
        Button week9 = findViewById(R.id.week9);
        Button week10 = findViewById(R.id.week10);
        Button week11 = findViewById(R.id.week11);
        Button week12 = findViewById(R.id.week12);
        Button week13 = findViewById(R.id.week13);
        Button week14 = findViewById(R.id.week14);
        Button week15 = findViewById(R.id.week15);
        Button week16 = findViewById(R.id.week16);
        Button week17= findViewById(R.id.week17);
        Button week18 = findViewById(R.id.week18);
        Button week19 = findViewById(R.id.week19);
        Button week20 = findViewById(R.id.week20);
        Button week21 = findViewById(R.id.week21);
        Button week22 = findViewById(R.id.week22);
        Button week23 = findViewById(R.id.week23);
        Button week24 = findViewById(R.id.week24);

        week1.setOnClickListener(this);
        week2.setOnClickListener(this);
        week3.setOnClickListener(this);
        week4.setOnClickListener(this);
        week5.setOnClickListener(this);
        week6.setOnClickListener(this);
        week7.setOnClickListener(this);
        week8.setOnClickListener(this);
        week9.setOnClickListener(this);
        week10.setOnClickListener(this);
        week11.setOnClickListener(this);
        week12.setOnClickListener(this);
        week13.setOnClickListener(this);
        week14.setOnClickListener(this);
        week15.setOnClickListener(this);
        week16.setOnClickListener(this);
        week17.setOnClickListener(this);
        week18.setOnClickListener(this);
        week19.setOnClickListener(this);
        week20.setOnClickListener(this);
        week21.setOnClickListener(this);
        week22.setOnClickListener(this);
        week23.setOnClickListener(this);
        week24.setOnClickListener(this);


    }

    // Switch structure for buttons and fetching the correct training program
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

            program[0] = trainingProgram.getString("move1");
            program[1] = trainingProgram.getString("move2");
            program[2] = trainingProgram.getString("move3");
            program[3] = trainingProgram.getString("move4");
            program[4] = trainingProgram.getString("move5");
            program[5] = trainingProgram.getString("move6");
            program[6] = trainingProgram.getString("move7");
            program[7] = trainingProgram.getString("move8");
            program[8] = trainingProgram.getString("move9");
            program[9] = trainingProgram.getString("move10");
            program[10] = trainingProgram.getString("move11");
            program[11] = trainingProgram.getString("move12");
            program[12] = trainingProgram.getString("move13");
            program[13] = trainingProgram.getString("move14");
            program[14] = trainingProgram.getString("move15");
            program[15] = trainingProgram.getString("move16");
            program[16] = trainingProgram.getString("move17");
            program[17] = trainingProgram.getString("move18");
            program[18] = trainingProgram.getString("move19");
            program[19] = trainingProgram.getString("move1sets");
            program[20] = trainingProgram.getString("move2sets");
            program[21] = trainingProgram.getString("move3sets");
            program[22] = trainingProgram.getString("move4sets");
            program[23] = trainingProgram.getString("move5sets");
            program[24] = trainingProgram.getString("move6sets");
            program[25] = trainingProgram.getString("move7sets");
            program[26] = trainingProgram.getString("move8sets");
            program[27] = trainingProgram.getString("move9sets");
            program[28] = trainingProgram.getString("move10sets");
            program[29] = trainingProgram.getString("move11sets");
            program[30] = trainingProgram.getString("move12sets");
            program[31] = trainingProgram.getString("move13sets");
            program[32] = trainingProgram.getString("move14sets");
            program[33] = trainingProgram.getString("move15sets");
            program[34] = trainingProgram.getString("move16sets");
            program[35] = trainingProgram.getString("move17sets");
            program[36] = trainingProgram.getString("move18sets");
            program[37] = trainingProgram.getString("move19sets");


        } catch (JSONException ex) {
            ex.printStackTrace();
        }

    }
}
