package com.wsy.animations;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by songyewang on 16/10/8.
 */

public class PropertyAnimationActivity extends Activity {
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.property_animation);
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void onTranslateClicked(View view) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "translationX", 0, 100, 0);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }

    public void onOfIntClicked(View view) {
        ValueAnimator animator = ValueAnimator.ofInt(1, 100, 50);
        animator.addUpdateListener(new AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();
                textView.setText(value.toString());
            }
        });
        animator.setDuration(800);
        animator.setRepeatCount(5);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();
    }

    public void onOfIntXmlClicked(View view) {
        ValueAnimator animator = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.int_animator);
        animator.addUpdateListener(new AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();
                textView.setText(value.toString());
            }
        });
        animator.start();
    }

    public void onObjectAnimatorXmlClicked(View view) {
        ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.obj_animator);
        objectAnimator.setTarget(textView);
        objectAnimator.start();
    }

    public void onSetAnimatorXmlClicked(View view) {
        AnimatorSet objectAnimator = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.set_animator);
        objectAnimator.setTarget(textView);
        objectAnimator.start();
    }

    public void onAlphaClicked(View view) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "alpha", 0, 1, 0);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }

    public void onRotateClicked(View view) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "rotation", 0, 180, 90);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    public void onScaleClicked(View view) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "scaleX", 0.5f, 1.5f, 0.3f);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    public void onMultiClicked(View view) {
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(imageView, "translationX", -500, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(imageView, "rotation", 0, 360);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(imageView, "alpha", 1f, 0f, 1f);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(rotate).with(fadeInOut).after(moveIn);

        animatorSet.setDuration(2000);
        animatorSet.start();
    }

    public void onBallClicked(View view) {
        Intent intent = new Intent(this, BallAnimationActivity.class);
        startActivity(intent);
    }
}
