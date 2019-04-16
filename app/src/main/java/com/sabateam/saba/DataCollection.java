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
    private Integer FAQAccessed;
    private Integer sentToPhone;
    private Integer trainingProgrammesAccessed;
    private String exerciseViewed;
    private String dataBaseWeekAccessed;
    private String dbHowToNew;
    private String faqAccessNew;



    public DataCollection(String userLog,
                          String avatar,
                          Integer FAQAccessed,
                          Integer sentToPhone,
                          Integer trainingProgrammesAccessed,
                          String exerciseViewed,
                          String dataBaseWeekAccessed,
                          String dbHowToNew,
                          String faqAccessNew

    ) {
        this.userLog = userLog;
        this.avatar = avatar;
        this.FAQAccessed = FAQAccessed;
        this.sentToPhone = sentToPhone;
        this.trainingProgrammesAccessed = trainingProgrammesAccessed;
        this.exerciseViewed = exerciseViewed;
        this.dataBaseWeekAccessed = dataBaseWeekAccessed;
        this.dbHowToNew  = dbHowToNew;
        this.faqAccessNew = faqAccessNew;
    }

    public DataCollection() {
        //Firebase requires empty constructor
    }

    public String getuserLog() {
        return userLog;
    }

    public String getavatar() {
        return avatar;
    }

    public int getFAQAccessed() { return FAQAccessed;}

    public int getsentToPhone() {return sentToPhone;}

    public int gettrainingProgrammesAccessed() {return trainingProgrammesAccessed;}

    public String getexerciseViewed() {return exerciseViewed;}

    public String getdataBaseWeekAccessed() {return  dataBaseWeekAccessed;}

    public String getdbHowToNew() {return dbHowToNew; }
    public String getfaqAccessNew() {return  faqAccessNew;}

}
