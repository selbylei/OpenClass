package com.selbylei.besier.util;

import java.util.ArrayList;

/**
 * Created by selbylei on 17/3/6.
 */

public class AnimatorPath {

    ArrayList<PathPoint> mPoints = new ArrayList<PathPoint>();

    public void moveTo(float x, float y) {
        mPoints.add(new PathPoint(PathPoint.MOVE, x, y));
    }

    public void lineTo(float x, float y) {
        mPoints.add(new PathPoint(PathPoint.LINE, x, y));
    }

    public void cubicTo(float c0x, float c0y, float c1x, float c1y, float x, float y) {
        mPoints.add(new PathPoint(PathPoint.COBIC, c0x, c0y, c1x, c1y, x, y));

    }


    public ArrayList<PathPoint> getPoints(){
        return mPoints;
    }


}
