package com.wsy.animations;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * Created by songyewang on 16/10/8.
 */

public class TweeAnimationActivity extends Activity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twee_animation);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void onTranslateClicked(View view) {
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.twee_translate);

        /*TranslateAnimation animation = new TranslateAnimation(TranslateAnimation.ABSOLUTE, 0f, TranslateAnimation.ABSOLUTE, 100f,
                TranslateAnimation.ABSOLUTE, 0f, TranslateAnimation.ABSOLUTE, 100f);*/
        TranslateAnimation animation = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.5f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f);
        animation.setDuration(800);
        animation.setRepeatCount(5);
        animation.setRepeatMode(TranslateAnimation.REVERSE);
        animation.setFillAfter(true);

        imageView.startAnimation(animation);
    }

    public void onRotateClicked(View view) {
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.twee_rotate);

        RotateAnimation animation = new RotateAnimation(0f, 180f, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(800);
        imageView.startAnimation(animation);
    }

    public void onAlphaClicked(View view) {
        //xml实现动画
//         Animation animation = AnimationUtils.loadAnimation(this, R.anim.twee_alpha);

        //java实现动画
        AlphaAnimation animation = new AlphaAnimation(1.0f, 0.3f);
        animation.setDuration(800);
        animation.setFillAfter(true);
        animation.setRepeatCount(5);
        animation.setRepeatMode(Animation.REVERSE);

        imageView.startAnimation(animation);
    }

    public void onScaleClicked(View view) {
        //xml实现动画
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.twee_scale);
        ScaleAnimation animation = new ScaleAnimation(0.5f, 1.5f, 0.5f, 1.5f, ScaleAnimation.RELATIVE_TO_PARENT, 0.5f, ScaleAnimation.RELATIVE_TO_PARENT, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(800);
        imageView.startAnimation(animation);
    }

    public void onSetClicked(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_set);

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(AnimationUtils.loadAnimation(this, R.anim.twee_scale));
        animationSet.addAnimation(AnimationUtils.loadAnimation(this, R.anim.twee_alpha));
        animationSet.addAnimation(AnimationUtils.loadAnimation(this, R.anim.twee_rotate));
        animationSet.addAnimation(AnimationUtils.loadAnimation(this, R.anim.twee_translate));
        imageView.startAnimation(animationSet);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.slide_out_right,android.R.anim.slide_in_left);
    }
}
