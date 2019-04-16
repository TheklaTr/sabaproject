package com.sabateam.saba;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
import android.content.Context;
import android.content.SharedPreferences;
import java.io.Serializable;

public class DataCollection implements Serializable {

    private Context context;
    public DataCollection(Context context){
        this.context = context;
    }

    public static void saveIntForDataBase(Context context, String key, int value) {
        SharedPreferences sharedPref = context.getSharedPreferences("dataBaseSharedPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    public static int getIntForDataBase(Context context, String key){
        SharedPreferences mSharedPreferences = context.getSharedPreferences("dataBaseSharedPreferences", context.MODE_PRIVATE);
        int dataToBeSent = mSharedPreferences.getInt(key, 0);
        return  dataToBeSent;
    }
    public static void saveStringForDataBase(Context context, String key, String value) {
        SharedPreferences sharedPref = context.getSharedPreferences("dataBaseSharedPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.commit();
    }
    public static String getStringForDataBase(Context context, String key){
        SharedPreferences mSharedPreferences = context.getSharedPreferences("dataBaseSharedPreferences", context.MODE_PRIVATE);
        String dataToBeSent = mSharedPreferences.getString(key, " ");
        return  dataToBeSent;
    }

    private String userLog;
    private String avatar;
    private Integer faqMenuAccessed;
    private Integer sentToPhone;
    private Integer trainingProgrammesAccessed;
    private String exerciseViewed;
    private String WeekAccessed;
    private String howToAnswerViewed;
    private String faqViewed;



    public DataCollection(String userLog,
                          String avatar,
                          Integer faqMenuAccessed,
                          Integer sentToPhone,
                          Integer trainingProgrammesAccessed,
                          String exerciseViewed,
                          String WeekAccessed,
                          String howToAnswerViewed,
                          String faqViewed

    ) {
        this.userLog = userLog;
        this.avatar = avatar;
        this.faqMenuAccessed = faqMenuAccessed;
        this.sentToPhone = sentToPhone;
        this.trainingProgrammesAccessed = trainingProgrammesAccessed;
        this.exerciseViewed = exerciseViewed;
        this.WeekAccessed = WeekAccessed;
        this.howToAnswerViewed  = howToAnswerViewed;
        this.faqViewed = faqViewed;
    }

    public DataCollection() {
        //Firebase requires empty constructor
    }

    public String getuserLog() {return userLog;}

    public String getavatar() {return avatar;}

    public int getfaqMenuAccessed() { return faqMenuAccessed;}

    public int getsentToPhone() {return sentToPhone;}

    public int gettrainingProgrammesAccessed() {return trainingProgrammesAccessed;}

    public String getexerciseViewed() {return exerciseViewed;}

    public String getWeekAccessed() {return  WeekAccessed;}

    public String gethowToAnswerViewed() {return howToAnswerViewed; }

    public String getfaqViewed() {return  faqViewed;}

}
