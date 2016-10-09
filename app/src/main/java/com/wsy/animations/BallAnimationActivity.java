package com.wsy.animations;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by songyewang on 16/10/9.
 */

public class BallAnimationActivity extends Activity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ball_animation);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void onPointEvaluatorClicked(View view) {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(300, 300);
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new PointEvaluator(), point1, point2);
        valueAnimator.setDuration(2000);
        valueAnimator.addListener(new AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d("animation", "onStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("animation", "onEnd");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d("animation", "onCancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d("animation", "onRepeat");
            }
        });
        valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Point point = (Point) animation.getAnimatedValue();
                Log.d("animation", point.toString());
            }
        });
        valueAnimator.start();
    }

    public void onViewPropertyAnimatorClicked(View view) {
        textView.animate().alpha(0f).x(100).y(200).setDuration(1000);
    }
}
