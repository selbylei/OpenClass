package com.selbylei.waterwave.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.selbylei.waterwave.R;

/**
 * Created by selbylei on 17/3/1.
 */

public class WaveView extends View {


    private Paint paint;
    private Path path;
    private int waveLength = 400;
    private int dx;
    private int dy;

    private Bitmap mBitmap;
    private int width;  //屏幕宽度
    private int height; //屏幕高度

    private Region region;
    private int waveHeight = 80;
    private int waveView_boatBitmap;
    private boolean waveView_rise;
    private int duration; //动画时间
    private int originY;
    private ValueAnimator animator;


    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
        init();
    }

    private void initAttrs(Context context, AttributeSet attrs) {

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.WaveView);
        waveView_boatBitmap = (int) a.getDimension(R.styleable.WaveView_bBitmap, 0);
        waveView_rise = a.getBoolean(R.styleable.WaveView_rise, false);
        duration = (int) a.getDimension(R.styleable.WaveView_duration, 5000);
        originY = (int) a.getDimension(R.styleable.WaveView_originY, 500);
        waveHeight = (int) a.getDimension(R.styleable.WaveView_wHeight, 400);
        waveLength = (int) a.getDimension(R.styleable.WaveView_wLength, 800);
        a.recycle();

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2; //缩放图片

        if (waveView_boatBitmap > 0) {
            mBitmap = BitmapFactory.decodeResource(getResources(), waveView_boatBitmap, options);
        } else {
            mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher, options);
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(widthSize, heightSize);

        width = widthSize;
        height = heightSize;

        if (originY == 0) {
            originY = height;
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画曲线
        setPathData();
        canvas.drawPath(path, paint);

        Rect bounds = region.getBounds();
        if (bounds.top < originY) {
            canvas.drawBitmap(mBitmap, bounds.right - mBitmap.getWidth() / 2, bounds.top - mBitmap.getHeight(), paint);
        } else {
            canvas.drawBitmap(mBitmap, bounds.right - mBitmap.getWidth() / 2, bounds.bottom - mBitmap.getHeight(), paint);
        }

    }

    private void init() {
        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.colorAccent));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        path = new Path();

    }

    //画出水波纹
    private void setPathData() {
        path.reset();
        int halfWaveLength = waveLength / 2;
        path.moveTo(-waveLength + dx, originY - dy);
        for (int i = -waveLength; i < width + waveLength; i += waveLength) {
            path.rQuadTo(halfWaveLength / 2, -waveHeight, halfWaveLength, 0);//相对于圆点
            path.rQuadTo(halfWaveLength / 2, waveHeight, halfWaveLength, 0);
        }

        //用一个矩形区域去截取一个path得到一个新的矩形区域
        float x = width / 2;
        region = new Region();
        Region clip = new Region((int) (x -  1), 0, (int) x, height * 2);
        region.setPath(path, clip);

        path.lineTo(width, height);
        path.lineTo(0, height);
        path.close();

    }

    //开始动画
    public void startAnimation() {
        //dx不对增加
        animator = ValueAnimator.ofFloat(0, 1);
        animator.setDuration(duration);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = (float) animation.getAnimatedValue();
                dx = (int) (fraction * waveLength);
                if (waveView_rise){
                    dy += 5;
                }
                postInvalidate();
            }
        });

        animator.start();
    }
}

