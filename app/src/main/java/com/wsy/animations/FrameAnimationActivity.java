package com.wsy.animations;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by songyewang on 16/10/8.
 */

public class FrameAnimationActivity extends Activity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_animation);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void onStartFrameAnimClicked(View view) {
        imageView.setBackgroundResource(R.drawable.frame_anim);
        AnimationDrawable drawable = (AnimationDrawable) imageView.getBackground();
        drawable.start();
    }

    public void onStopFrameAnimClicked(View view) {
        AnimationDrawable drawable = (AnimationDrawable) imageView.getBackground();
        drawable.stop();
    }

    public void onJavaFrameAnimClicked(View view) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.ear_playing_1), 300);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.ear_playing_2), 300);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.ear_playing_3), 300);
        //设置动画是否只执行一次,如果为true则只执行一次,否则执行多次。
        animationDrawable.setOneShot(true);
        imageView.setBackgroundDrawable(animationDrawable);
        AnimationDrawable drawable = (AnimationDrawable) imageView.getBackground();
        drawable.start();
    }
}
