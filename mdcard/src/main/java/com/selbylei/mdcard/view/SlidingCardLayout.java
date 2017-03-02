package com.selbylei.mdcard.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.selbylei.mdcard.R;

/**
 * Created by selbylei on 17/2/17.
 */

@CoordinatorLayout.DefaultBehavior(SlidingCardBehavior.class)
public class SlidingCardLayout extends FrameLayout {

    private int mHeaderHigh;

    public SlidingCardLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlidingCardLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.widget_card, this);
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        TextView tv = (TextView) findViewById(R.id.tv);
        mHeaderHigh = tv.getHeight();
    }

    public int getHeaderHigh() {
        return mHeaderHigh;
    }

}
