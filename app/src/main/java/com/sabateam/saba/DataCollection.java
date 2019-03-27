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


    private String data1;
    private String data2;
    private Integer data3;
    private String data4;

    public DataCollection(String data1, String data2, Integer data3, String data4) {
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
    }

    public DataCollection() {
        //Firebase requires empty constructor
    }

    public String getData1() {
        return data1;
    }

    public String getData2() {
        return data2;
    }

    public int getData3() {
        return data3;
    }

    public String getData4() {
        return data4;
    }

}
