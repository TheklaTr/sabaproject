package com.sabateam.saba;

import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FAQScreen extends AppCompatActivity {

    CardView faq1a;
    CardView faq2a;
    CardView faq3a;
    CardView faq4a;
    CardView faq5a;
    CardView faq6a;
    CardView faq7a;
    CardView faq8a;
    CardView faq9a;
    CardView faq10a;
    CardView faq11a;
    CardView faq12a;
    CardView faq13a;
    CardView faq14a;
    CardView faq15a;
    CardView faq16a;
    CardView faq17a;
    CardView faq18a;
    CardView faq19a;


    private SoundPool sounds;
    private Map<String, Object> clips = new HashMap<>();
    // Maybe do similar int-arrays as above for both english voice and tswana voice
    // Set the voices into the array same way the flags are set
    // Instead of R.drawable.image it might be something like R.raw.voicename

    ImageView flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqscreen);

        faq1a = (CardView)findViewById(R.id.faq1cardtest);
        faq2a = (CardView)findViewById(R.id.faq2card);
        faq3a = (CardView)findViewById(R.id.faq3card);
        faq4a = (CardView)findViewById(R.id.faq4card);
        faq5a = (CardView)findViewById(R.id.faq5card);
        faq6a = (CardView)findViewById(R.id.faq6card);
        faq7a = (CardView)findViewById(R.id.faq7card);
        faq8a = (CardView)findViewById(R.id.faq8card);
        faq9a = (CardView)findViewById(R.id.faq9card);
        faq10a = (CardView)findViewById(R.id.faq10card);
        faq11a = (CardView)findViewById(R.id.faq11card);
        faq12a = (CardView)findViewById(R.id.faq12card);
        faq13a = (CardView)findViewById(R.id.faq13card);
        faq14a = (CardView)findViewById(R.id.faq14card);
        faq15a = (CardView)findViewById(R.id.faq15card);
        faq16a = (CardView)findViewById(R.id.faq16card);
        faq17a = (CardView)findViewById(R.id.faq17card);
        faq18a = (CardView)findViewById(R.id.faq18card);


        faq1a.setVisibility(View.GONE);
        faq2a.setVisibility(View.GONE);
        faq3a.setVisibility(View.GONE);
        faq4a.setVisibility(View.GONE);
        faq5a.setVisibility(View.GONE);
        faq6a.setVisibility(View.GONE);
        faq7a.setVisibility(View.GONE);
        faq8a.setVisibility(View.GONE);
        faq9a.setVisibility(View.GONE);
        faq10a.setVisibility(View.GONE);
        faq11a.setVisibility(View.GONE);
        faq12a.setVisibility(View.GONE);
        faq13a.setVisibility(View.GONE);
        faq14a.setVisibility(View.GONE);
        faq15a.setVisibility(View.GONE);
        faq16a.setVisibility(View.GONE);
        faq17a.setVisibility(View.GONE);
        faq18a.setVisibility(View.GONE);


        sounds = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        ArrayList<ImageButton> buttons = new ArrayList<>();

        // Program crashes if the button count in layout is less than the number here
        int buttonCount = 18;
        for (int i = 1; i <= buttonCount; i++) {
            int id = getResources().getIdentifier("faqbut" + i, "id", getPackageName());

            ImageButton button = (ImageButton) findViewById(id);
            int soundid = getResources().getIdentifier(button.getTag().toString(),
                    "raw", getPackageName());
            clips.put(button.getTag().toString(), sounds.load(this, soundid, 1));

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    sounds.play((int) clips.get(v.getTag().toString()), 1, 1, 1, 0, 1);
                }
            });

            buttons.add(button);


            // Toggle button above sets the selectedEnglish boolean value
            // so maybe we can do a check here for each sound button, something like this pseudocode

            /* once the id of button is identified:
             *   if selectedEnglish (meaning its true)
             *       play sound from correct index from english voice array
             *   else
             *       play sound from same index at tswana voice array*/
        }
    }
    //for database

    public static String faqAccess ="";

    public void Faq1AnswerToggle(View v){
        if(faq1a.isShown()){
            CustomAnim.SlideUp(this, faq1a);
            faq1a.setVisibility(View.GONE);
        }
        else {
            faq1a.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, faq1a);
            faqAccess = faqAccess + "1, ";
            DataCollection.saveStringForDataBase(this, "faqAccessNew", faqAccess);
          }
    }

    public void Faq2AnswerToggle(View v){
        if(faq2a.isShown()){
            CustomAnim.SlideUp(this, faq2a);
            faq2a.setVisibility(View.GONE);
        }
        else {
            faq2a.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, faq2a);
            faqAccess = faqAccess + "2, ";
            DataCollection.saveStringForDataBase(this, "faqAccessNew", faqAccess);
        }

    }
    public void Faq3AnswerToggle(View v){
        if(faq3a.isShown()){
            CustomAnim.SlideUp(this, faq3a);
            faq3a.setVisibility(View.GONE);
        }
        else {
            faq3a.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, faq3a);
            faqAccess = faqAccess + "3, ";
            DataCollection.saveStringForDataBase(this, "faqAccessNew", faqAccess);
        }
    }
    public void Faq4AnswerToggle(View v){
        if(faq4a.isShown()){
            CustomAnim.SlideUp(this, faq4a);
            faq4a.setVisibility(View.GONE);
        }
        else {
            faq4a.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, faq4a);
            faqAccess = faqAccess + "4, ";
            DataCollection.saveStringForDataBase(this, "faqAccessNew", faqAccess);       }
    }
    public void Faq5AnswerToggle(View v){
        if(faq5a.isShown()){
            CustomAnim.SlideUp(this, faq5a);
            faq5a.setVisibility(View.GONE);
        }
        else {
            faq5a.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, faq5a);
            faqAccess = faqAccess + "5, ";
            DataCollection.saveStringForDataBase(this, "faqAccessNew", faqAccess);      }
    }
    public void Faq6AnswerToggle(View v){
        if(faq6a.isShown()){
            CustomAnim.SlideUp(this, faq6a);
            faq6a.setVisibility(View.GONE);
        }
        else {
            faq6a.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, faq6a);
            faqAccess = faqAccess + "6, ";
            DataCollection.saveStringForDataBase(this, "faqAccessNew", faqAccess);      }
    }
    public void Faq7AnswerToggle(View v){
        if(faq7a.isShown()){
            CustomAnim.SlideUp(this, faq7a);
            faq7a.setVisibility(View.GONE);
        }
        else {
            faq7a.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, faq7a);
            faqAccess = faqAccess + "7, ";
            DataCollection.saveStringForDataBase(this, "faqAccessNew", faqAccess);      }
    }
    public void Faq8AnswerToggle(View v){
        if(faq8a.isShown()){
            CustomAnim.SlideUp(this, faq8a);
            faq8a.setVisibility(View.GONE);
        }
        else {
            faq8a.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, faq8a);
            faqAccess = faqAccess + "8, ";
            DataCollection.saveStringForDataBase(this, "faqAccessNew", faqAccess);      }
    }
    public void Faq9AnswerToggle(View v){
        if(faq9a.isShown()){
            CustomAnim.SlideUp(this, faq9a);
            faq9a.setVisibility(View.GONE);
        }
        else {
            faq9a.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, faq9a);
            faqAccess = faqAccess + "9, ";
            DataCollection.saveStringForDataBase(this, "faqAccessNew", faqAccess);
        }
    }
    public void Faq10AnswerToggle(View v){
        if(faq10a.isShown()){
            CustomAnim.SlideUp(this, faq10a);
            faq10a.setVisibility(View.GONE);
        }
        else {
            faq10a.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, faq10a);
            faqAccess = faqAccess + "10, ";
            DataCollection.saveStringForDataBase(this, "faqAccessNew", faqAccess);
        }
    }
    public void Faq11AnswerToggle(View v){
        if(faq11a.isShown()){
            CustomAnim.SlideUp(this, faq11a);
            faq11a.setVisibility(View.GONE);
        }
        else {
            faq11a.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, faq11a);
            faqAccess = faqAccess + "11, ";
            DataCollection.saveStringForDataBase(this, "faqAccessNew", faqAccess);
        }
    }
    public void Faq12AnswerToggle(View v){
        if(faq12a.isShown()){
            CustomAnim.SlideUp(this, faq12a);
            faq12a.setVisibility(View.GONE);
        }
        else {
            faq12a.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, faq12a);
            faqAccess = faqAccess + "12, ";
            DataCollection.saveStringForDataBase(this, "faqAccessNew", faqAccess);
        }
    }
    public void Faq13AnswerToggle(View v){
        if(faq13a.isShown()){
            CustomAnim.SlideUp(this, faq13a);
            faq13a.setVisibility(View.GONE);
        }
        else {
            faq13a.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, faq13a);
            faqAccess = faqAccess + "13, ";
            DataCollection.saveStringForDataBase(this, "faqAccessNew", faqAccess);
        }
    }
    public void Faq14AnswerToggle(View v){
        if(faq14a.isShown()){
            CustomAnim.SlideUp(this, faq14a);
            faq14a.setVisibility(View.GONE);
        }
        else {
            faq14a.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, faq14a);
            faqAccess = faqAccess + "14, ";
            DataCollection.saveStringForDataBase(this, "faqAccessNew", faqAccess);
        }
    }
    public void Faq15AnswerToggle(View v){
        if(faq15a.isShown()){
            CustomAnim.SlideUp(this, faq15a);
            faq15a.setVisibility(View.GONE);
        }
        else {
            faq15a.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, faq15a);
            faqAccess = faqAccess + "15, ";
            DataCollection.saveStringForDataBase(this, "faqAccessNew", faqAccess);
        }
    }
    public void Faq16AnswerToggle(View v){
        if(faq16a.isShown()){
            CustomAnim.SlideUp(this, faq16a);
            faq16a.setVisibility(View.GONE);
        }
        else {
            faq16a.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, faq16a);
            faqAccess = faqAccess + "16, ";
            DataCollection.saveStringForDataBase(this, "faqAccessNew", faqAccess);
        }
    }
    public void Faq17AnswerToggle(View v){
        if(faq17a.isShown()){
            CustomAnim.SlideUp(this, faq17a);
            faq17a.setVisibility(View.GONE);
        }
        else {
            faq17a.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, faq17a);
            faqAccess = faqAccess + "17, ";
            DataCollection.saveStringForDataBase(this, "faqAccessNew", faqAccess);
        }
    }
    public void Faq18AnswerToggle(View v){
        if(faq18a.isShown()){
            CustomAnim.SlideUp(this, faq18a);
            faq18a.setVisibility(View.GONE);
        }
        else {
            faq18a.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, faq18a);
            faqAccess = faqAccess + "18, ";
            DataCollection.saveStringForDataBase(this, "faqAccessNew", faqAccess);
        }
    }
    public void Faq19AnswerToggle(View v) {
        if (faq19a.isShown()) {
            CustomAnim.SlideUp(this, faq19a);
            faq19a.setVisibility(View.GONE);
        } else {
            faq19a.setVisibility(View.VISIBLE);
            CustomAnim.SlideDown(this, faq19a);
        }
        faqAccess = faqAccess + "19, ";
        DataCollection.saveStringForDataBase(this, "faqAccessNew", faqAccess);

    }

    public void BackButton(View view){
        super.onBackPressed();
        finish();
    }
}
