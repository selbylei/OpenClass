package com.selbylei.addview.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.selbylei.addview.R;


/**
 * Created by selbylei on 17/3/9.
 */

public class BoundingView extends View {


    private Paint mPaint;
    private Path mPath;

    private float mArcheight;
    private int mStatus;

    private int mMaxArcHeight;


    public BoundingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setColor(getResources().getColor(android.R.color.white));
        mMaxArcHeight = getResources().getDimensionPixelSize(R.dimen.arc_max_heigt);

    }

    public void show() {
        //弹出控件
        mStatus = Status.STATUS_SMOOTH_UP;

        ValueAnimator va = ValueAnimator.ofInt(mMaxArcHeight, 0);
        va.setDuration(2000);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mArcheight
            }
        });

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int currentPointY = 0;

        switch (mStatus) {
            case Status.NONE:
                currentPointY = 0;
            case Status.STATUS_SMOOTH_UP:
                /**
                 * 当前的高度个mArcheight的变化率是一样的
                 * getHeight()~0
                 * currentPointY/getHeight=1-mArcheight/
                 */

        }

        mPath.reset();
        mPath.moveTo(0, currentPointY);

        mPath.quadTo(getWidth() / 2, currentPointY + mArcheight, getWidth(), currentPointY);
        mPath.lineTo(getWidth(), getHeight());
        mPath.lineTo(0, getWidth());


    }


}


class Status {
    static int NONE = 1;
    static int STATUS_SMOOTH_UP = 2;

}
