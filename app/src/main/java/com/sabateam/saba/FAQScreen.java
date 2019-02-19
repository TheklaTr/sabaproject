package com.sabateam.saba;

import android.media.AudioManager;
import android.media.Image;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FAQScreen extends AppCompatActivity {

    boolean selectedEnglish;
    int[] flags = {R.drawable.ukflag, R.drawable.saflag};
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


        ToggleButton toggle = (ToggleButton) findViewById(R.id.languageToggle);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    selectedEnglish = true;
                    flag = (ImageView) findViewById(R.id.flagImg);
                    flag.setImageResource(flags[0]);

                } else {
                    selectedEnglish = false;
                    flag = (ImageView) findViewById(R.id.flagImg);
                    flag.setImageResource(flags[1]);

                }
            }
        });

        sounds = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        ArrayList<ImageButton> buttons = new ArrayList<>();

        // Program crashes if the button count in layout is less than the number here
        int buttonCount = 6;
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
}
