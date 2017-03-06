package com.selbylei.besier.util;

/**
 * Created by selbylei on 17/3/6.
 * 创建一个path指令类，存储指令类型和坐标
 */

public class PathPoint {

    public static final int MOVE = 0;
    public static final int LINE = 1;
    public static final int COBIC = 2;

    int mOperation;
    public float mX, mY;
    float mControl0x, mControl0y;
    float mControl1x, mControl1y;

    public PathPoint(int mOperation, float x, float y) {
        this.mOperation = mOperation;
        this.mX = x;
        this.mY = y;
    }

    public PathPoint(int mOperation, float mControl0x, float mControl0y, float mControl1x, float mControl1y, float mX, float mY) {
        this.mOperation = mOperation;
        this.mX = mX;
        this.mY = mY;
        this.mControl0x = mControl0x;
        this.mControl0y = mControl0y;
        this.mControl1x = mControl1x;
        this.mControl1y = mControl1y;
    }

    public static PathPoint moveTo(float x, float y) {
        return new PathPoint(MOVE, x, y);
    }


    public static PathPoint lineTo(float x, float y) {
        return new PathPoint(LINE, x, y);
    }

    public static PathPoint cobicTo(float mControl0x, float mControl0y, float mControl1x, float mControl1y, float mX, float mY) {
        return new PathPoint(COBIC, mControl0x, mControl0y, mControl1x, mControl1y, mX, mY);

    }
}
