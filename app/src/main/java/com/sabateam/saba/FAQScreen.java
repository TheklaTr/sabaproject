package com.sabateam.saba;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class FAQScreen extends AppCompatActivity {

    boolean selectedEnglish;
    int[] flags = {R.drawable.ukflag, R.drawable.saflag};

    // Maybe do similar int-arrays as above for both english voice and tswana voice
    // Set the voices into the array same way the flags are set
    // Instead of R.drawable.image it might be something like R.raw.voicename

    ImageView flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqscreen);


        ToggleButton toggle = (ToggleButton)findViewById(R.id.languageToggle);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked) {
                    selectedEnglish = true;
                    flag = (ImageView)findViewById(R.id.flagImg);
                    flag.setImageResource(flags[0]);

                }
                else {
                    selectedEnglish = false;
                    flag = (ImageView)findViewById(R.id.flagImg);
                    flag.setImageResource(flags[1]);

                }
            }
        });

        // Toggle button above sets the selectedEnglish boolean value
        // so maybe we can do a check here for each sound button, something like this pseudocode

        /* once the id of button is identified:
        *   if selectedEnglish (meaning its true)
        *       play sound from correct index from english voice array
        *   else
        *       play sound from same index at tswana voice array*/
    }
}
