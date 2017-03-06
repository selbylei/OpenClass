package com.selbylei.besier.util;

import android.animation.TypeEvaluator;

/**
 * Created by selbylei on 17/3/6.
 */

public class PathEvaluator implements TypeEvaluator<PathPoint> {

    @Override
    public PathPoint evaluate(float t, PathPoint startValue, PathPoint endValue) {

        PathPoint point = null;

        if (endValue.mOperation == PathPoint.COBIC) {


        } else if (endValue.mOperation == PathPoint.LINE) { //直线运动

            //x,y=起点的坐标+t*(起点和中点的距离)
            float x = startValue.mX + t * (endValue.mX - startValue.mX);
            float y = startValue.mY + t * (endValue.mY - startValue.mY);
            point = new PathPoint(PathPoint.LINE, x, y);

        } else {

            float x = startValue.mX + t * (endValue.mX - startValue.mX);
            float y = startValue.mY + t * (endValue.mY - startValue.mY);
            point = new PathPoint(PathPoint.LINE, x, y);

        }

        return point;
    }
}
