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
        String dataToBeSent = mSharedPreferences.getString(key, null);
        return  dataToBeSent;
    }

    private String data1;
    private Integer data2;
    private Integer data3;
    private String avatar;
    private Integer FAQAccessed;
    private Integer fdata1;
    private Integer fdata2;
    private Integer fdata3;
    private Integer fdata4;
    private Integer fdata5;
    private Integer fdata6;
    private Integer fdata7;
    private Integer fdata8;
    private Integer fdata9;
    private Integer fdata10;
    private Integer fdata11;
    private Integer fdata12;
    private Integer fdata13;
    private Integer fdata14;
    private Integer fdata15;
    private Integer fdata16;
    private Integer fdata17;
    private Integer fdata18;
    private Integer sentToPhone;
    private Integer trainingProgrammesAccessed;




    public DataCollection(String data1,
                          Integer data2,
                          Integer data3,
                          String avatar,
                          Integer FAQAccessed,
                          Integer fdata1,
                          Integer fdata2,
                          Integer fdata3,
                          Integer fdata4,
                          Integer fdata5,
                          Integer fdata6,
                          Integer fdata7,
                          Integer fdata8,
                          Integer fdata9,
                          Integer fdata10,
                          Integer fdata11,
                          Integer fdata12,
                          Integer fdata13,
                          Integer fdata14,
                          Integer fdata15,
                          Integer fdata16,
                          Integer fdata17,
                          Integer fdata18,
                          Integer sentToPhone,
                          Integer trainingProgrammesAccessed
                            ) {
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.avatar = avatar;
        this.FAQAccessed = FAQAccessed;
        this.fdata1 = fdata1;
        this.fdata2 = fdata2;
        this.fdata3 = fdata3;
        this.fdata4 = fdata4;
        this.fdata5 = fdata5;
        this.fdata6 = fdata6;
        this.fdata7 = fdata7;
        this.fdata8 = fdata8;
        this.fdata9 = fdata9;
        this.fdata10 = fdata10;
        this.fdata11 = fdata11;
        this.fdata12 = fdata12;
        this.fdata13 = fdata13;
        this.fdata14 = fdata14;
        this.fdata15 = fdata15;
        this.fdata16 = fdata16;
        this.fdata17 = fdata17;
        this.fdata18 = fdata18;
        this.sentToPhone = sentToPhone;
        this.trainingProgrammesAccessed = trainingProgrammesAccessed;
    }

    public DataCollection() {
        //Firebase requires empty constructor
    }

    public String getData1() {
        return data1;
    }

    public int getData2() {
        return data2;
    }

    public int getData3() {
        return data3;
    }

    public String getavatar() {
        return avatar;
    }

    public int getFAQAccessed() { return FAQAccessed;}

    public int getfData1() {
        return fdata1;
    }

    public int getfData2() {
        return fdata2;
    }

    public int getfData3() {
        return fdata3;
    }

    public int getfData4() {
        return fdata4;
    }

    public int getfData5() {
        return fdata5;
    }

    public int getfData6() {
        return fdata6;
    }

    public int getfData7() {
        return fdata7;
    }

    public int getfData8() {
        return fdata8;
    }

    public int getfData9() {
        return fdata9;
    }

    public int getfData10() {
        return fdata10;
    }

    public int getfData11() {
        return fdata11;
    }

    public int getfData12() {
        return fdata12;
    }

    public int getfData13() {
        return fdata13;
    }

    public int getfData14() {
        return fdata14;
    }

    public int getfData15() {
        return fdata15;
    }

    public int getfData16() {
        return fdata16;
    }

    public int getfData17() {
        return fdata17;
    }

    public int getfData18() {
        return fdata18;
    }

    public int getsentToPhone() {return sentToPhone;}

    public int gettrainingProgrammesAccessed() {return trainingProgrammesAccessed;}


}
