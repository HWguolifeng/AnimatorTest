package com.coolweather.android.animatortest;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        animatorTest();


    }

    /**
     * 包含了animator 一些基本用法
     */
    private void animatorTest()
    {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.int0top100);
//        //基本用法
//        ValueAnimator animator = ValueAnimator.ofInt(1, 10);
//        //设置时间
        animator.setDuration(10000);
        //设置监听器
        animator.addListener(new Animator.AnimatorListener()
        {
            @Override
            public void onAnimationStart(Animator animation)
            {
                Log.i(TAG, "onAnimationStart: ");
            }

            @Override
            public void onAnimationEnd(Animator animation)
            {
                Log.i(TAG, "onAnimationEnd: ");
            }

            @Override
            public void onAnimationCancel(Animator animation)
            {
                Log.i(TAG, "onAnimationCancel: ");
            }

            @Override
            public void onAnimationRepeat(Animator animation)
            {
                Log.i(TAG, "onAnimationRepeat: ");
            }
        });
        animator.start();

        //ObjectAnimator 的简单使用

//        //改变text View 的透明度
        TextView textView = (TextView) this.findViewById(R.id.text_view);
        Animator anim = AnimatorInflater.loadAnimator(this, R.animator.group);
        anim.setTarget(textView);
        anim.start();
        anim.addListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationCancel(Animator animation)
            {
                super.onAnimationCancel(animation);
            }
        });
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f, 1f);
//        objectAnimator.setDuration(5000);
//        objectAnimator.start();

        //设置旋转的属性
        ObjectAnimator objectAnimatorRotation = ObjectAnimator.ofFloat(textView, "rotation", 0f, 360f, 0f);
//        objectAnimatorRotation.setDuration(5000);
//        objectAnimatorRotation.start();
//
//        //平移的属性
        float translationX = textView.getTranslationX();
        ObjectAnimator objectAnimatorTrans = ObjectAnimator.ofFloat(textView, "translationX", translationX, -500f, translationX);
////        objectAnimatorTrans.setDuration(10000);
////        objectAnimatorTrans.start();
//
        //设置组合动画
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimator).with(objectAnimatorRotation).after(objectAnimatorTrans);
        animatorSet.setDuration(10000);
        animatorSet.start();
        animatorSet.addListener(animatorListenerAdapter);
    }

    /**
     * 监听器的示例
     */
    private AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter()
    {
        @Override
        public void onAnimationCancel(Animator animation)
        {
            Log.i(TAG, "onAnimationCancel: ");
            super.onAnimationCancel(animation);
        }

        @Override
        public void onAnimationEnd(Animator animation)
        {
            Log.i(TAG, "onAnimationEnd: ");
            super.onAnimationEnd(animation);
        }

        @Override
        public void onAnimationRepeat(Animator animation)
        {
            Log.i(TAG, "onAnimationRepeat: ");
            super.onAnimationRepeat(animation);
        }

        @Override
        public void onAnimationStart(Animator animation)
        {
            Log.i(TAG, "onAnimationStart: ");
            super.onAnimationStart(animation);
        }

        @Override
        public void onAnimationPause(Animator animation)
        {
            super.onAnimationPause(animation);
        }

        @Override
        public void onAnimationResume(Animator animation)
        {
            super.onAnimationResume(animation);
        }
    };
}
