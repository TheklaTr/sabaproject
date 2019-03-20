package com.sabateam.saba;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class CustomAnim {

    public static void SlideDown(Context ctx, View v){

        Animation anim = AnimationUtils.loadAnimation(ctx, R.anim.slidedown);
        if(anim != null){
            anim.reset();
        }

        if(v != null){
            v.clearAnimation();
            v.startAnimation(anim);
        }
    }

    public static void SlideUp(Context ctx, View v){

        Animation anim = AnimationUtils.loadAnimation(ctx, R.anim.slideup);
        if(anim != null){
            anim.reset();
        }

        if(v != null){
            v.clearAnimation();
            v.startAnimation(anim);
        }
    }
}
