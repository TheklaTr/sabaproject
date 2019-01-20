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
    }
}
