package com.coolweather.android.animatortest;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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
        animator.setDuration(10000);
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

        //ObjectAnimator 的简单使用

        //改变text View 的透明度
        TextView textView = (TextView) this.findViewById(R.id.text_view);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f, 1f);
        objectAnimator.setDuration(5000);
        objectAnimator.start();

        //设置旋转的属性
        ObjectAnimator objectAnimatorRotation = ObjectAnimator.ofFloat(textView, "rotation", 0f, 360f, 0f);
        objectAnimatorRotation.setDuration(5000);
        objectAnimatorRotation.start();

        //平移的属性
        float translationX = textView.getTranslationX();
        ObjectAnimator objectAnimatorTrans = ObjectAnimator.ofFloat(textView, "translationX", translationX, -500f, translationX);
        objectAnimatorTrans.setDuration(10000);
        objectAnimatorTrans.start();


    }
}
