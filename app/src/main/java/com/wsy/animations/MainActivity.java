package com.wsy.animations;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    public void onClickButton(View view) {
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(tv, "translationX", -500, 0f);
        moveIn.addListener(new AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        ObjectAnimator rotate = ObjectAnimator.ofFloat(tv, "rotation", 0, 360);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(tv, "alpha", 1f, 0f, 1f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(rotate).with(fadeInOut).after(moveIn);
        animatorSet.setDuration(3000);
        animatorSet.start();
        tv.animate().x(10).y(20).alpha(0).setDuration(3000).start();
    }

    public void onTweeAnimClicked(View view) {
        Intent intent = new Intent(this, TweeAnimationActivity.class);
        startActivity(intent);
    }

    public void onFrameAnimClicked(View view) {
        Intent intent = new Intent(this, FrameAnimationActivity.class);
        startActivity(intent);
    }

    public void onPropertyAnimClicked(View view) {
        Intent intent = new Intent(this, PropertyAnimationActivity.class);
        startActivity(intent);
    }

}