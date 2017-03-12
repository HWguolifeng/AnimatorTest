package com.coolweather.android.animatortest;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity_tag";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //基本用法
        ValueAnimator animator = ValueAnimator.ofInt(1, 10);
        //设置时间
        animator.setDuration( 100);
        //设置监听器
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                int dest = (int) animation.getAnimatedValue();
                Log.i(TAG, "onAnimationUpdate: " + dest);
            }
        });
        //启动
        animator.start();
    }
}
