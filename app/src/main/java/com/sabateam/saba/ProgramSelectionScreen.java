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
    String dataBaseWeekAccessed = "Weeks: ";

    // Switch structure for buttons and fetching the correct training program
    // This is probably the best structure we can have for now
    @Override
    public void onClick(View v){
        switch (v.getId()) {

            case R.id.week1:
                returnedJson = LoadJsonFromAssets("week1to3.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",1";
                break;

            case R.id.week2:
                returnedJson = LoadJsonFromAssets("week1to3.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",2";
                break;

            case R.id.week3:
                returnedJson = LoadJsonFromAssets("week1to3.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",3";
                break;

            case R.id.week4:
                returnedJson = LoadJsonFromAssets("week4.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",4";
                break;

            case R.id.week5:
                returnedJson = LoadJsonFromAssets("week5.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",5";
                break;

            case R.id.week6:
                returnedJson = LoadJsonFromAssets("week6to8.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",6";
                break;

            case R.id.week7:
                returnedJson = LoadJsonFromAssets("week6to8.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",7";
                break;

            case R.id.week8:
                returnedJson = LoadJsonFromAssets("week6to8.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",8";
                break;

            case R.id.week9:
                returnedJson = LoadJsonFromAssets("week9to11.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",9";
                break;

            case R.id.week10:
                returnedJson = LoadJsonFromAssets("week9to11.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",10";
                break;

            case R.id.week11:
                returnedJson = LoadJsonFromAssets("week9to11.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",11";
                break;

            case R.id.week12:
                returnedJson = LoadJsonFromAssets("week12to16.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",12";
                break;

            case R.id.week13:
                returnedJson = LoadJsonFromAssets("week12to16.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",13";
                break;

            case R.id.week14:
                returnedJson = LoadJsonFromAssets("week12to16.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",14";
                break;

            case R.id.week15:
                returnedJson = LoadJsonFromAssets("week12to16.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",15";
                break;

            case R.id.week16:
                returnedJson = LoadJsonFromAssets("week12to16.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",16";
                break;

            case R.id.week17:
                returnedJson = LoadJsonFromAssets("week17to24.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",17";
                break;

            case R.id.week18:
                returnedJson = LoadJsonFromAssets("week17to24.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",18";
                break;

            case R.id.week19:
                returnedJson = LoadJsonFromAssets("week17to24.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",19";
                break;

            case R.id.week20:
                returnedJson = LoadJsonFromAssets("week17to24.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",20";
                break;

            case R.id.week21:
                returnedJson = LoadJsonFromAssets("week17to24.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",21";
                break;

            case R.id.week22:
                returnedJson = LoadJsonFromAssets("week17to24.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",22";
                break;

            case R.id.week23:
                returnedJson = LoadJsonFromAssets("week17to24.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",23";
                break;

            case R.id.week24:
                returnedJson = LoadJsonFromAssets("week17to24.json");
                FetchProgramAndSendIt(returnedJson);
                dataBaseWeekAccessed = dataBaseWeekAccessed + ",24";
                break;
        }
        DataCollection.saveStringForDataBase(this,"dataBaseWeekAccessed", dataBaseWeekAccessed);
    }


    public void FetchProgramAndSendIt(String jsonString) {


        Intent intent = new Intent(this, ProgramScreen.class);
        intent.putExtra("sentItem", jsonString);
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


    public void BackButton(View view){

        super.onBackPressed();
        finish();
    }
}
