package com.coolweather.android.animatortest;

import android.animation.TypeEvaluator;

/**
 * Created by 郭利锋 on 2017/3/12 0012.
 * [简要描述]<BR>
 */

public class PointEvaluator implements TypeEvaluator
{
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue)
    {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
        return new Point(x, y);
    }
}
