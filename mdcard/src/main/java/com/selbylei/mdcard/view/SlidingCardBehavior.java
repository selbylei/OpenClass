package com.selbylei.mdcard.view;


import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.view.View;


/**
 * Created by selbylei on 17/2/17.
 */

public class SlidingCardBehavior extends CoordinatorLayout.Behavior<SlidingCardLayout> {

    private int mInitalOffset;


    /**
     * 判断监听的方向
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, SlidingCardLayout child,
                                       View directTargetChild, View target, int nestedScrollAxes) {
        boolean isVertical = (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
        return isVertical && child == directTargetChild;
    }


    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, SlidingCardLayout child, View target, int dxConsumed,
                               int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        int shift = scroll(
                child,
                dyUnconsumed,
                mInitalOffset,
                mInitalOffset + child.getHeight() - child.getHeaderHigh()
        );

        //控制自己的上下滑动
        int initalOffset = child.getTop();
        //dy:[min,max]
        int offset = initalOffset - dyUnconsumed;
        child.offsetTopAndBottom(offset);
        //控制上边和下边child的移动
    }

    /**
     * 测量子控件
     *
     * @return
     */
    @Override
    public boolean onMeasureChild(CoordinatorLayout parent, SlidingCardLayout child, int parentWidthMeasureSpec, int widthUsed,
                                  int parentHeightMeasureSpec, int heightUsed) {
        //每一个卡片的高度变化
        //当前控件的高度＝父容器给的高度－上面和下面几个child的头部的高度
        int offset = getChildMeasureOffset(parent, child);
//        child.measure();
        return true;
    }

    private int getChildMeasureOffset(CoordinatorLayout parent, SlidingCardLayout child) {
        int offset = 0;
        for (int i = 0; i < parent.getChildCount(); i++) {
            View view = parent.getChildAt(i);
            if (child != view && view instanceof SlidingCardLayout) {
                offset += ((SlidingCardLayout) view).getHeaderHigh();
            }
        }

        return offset;
    }


    /**
     * 绘制子控件
     */
    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, SlidingCardLayout child, int layoutDirection) {

        //摆放parent里面的所有子控件
        parent.onLayoutChild(child, layoutDirection);
        //给里面的子控件做偏移
        //拿到上面的child，获取每一个child的头部高度
        SlidingCardLayout previous = getPreviousChild(parent, child);
        return true;
    }

    private SlidingCardLayout getPreviousChild(CoordinatorLayout parent, SlidingCardLayout child) {

        int cardIndex = parent.indexOfChild(child);
        for (int i = cardIndex - 1; i > 0; i--) {
            View v = parent.getChildAt(i);
            if (v instanceof SlidingCardLayout) {
                return (SlidingCardLayout) v;
            }
        }
        return null;
    }


    private SlidingCardLayout getNextChild(CoordinatorLayout parent, SlidingCardLayout child) {

        int cardIndex = parent.indexOfChild(child);
        for (int i = cardIndex + 1; i < parent.getChildCount(); i++) {
            View v = parent.getChildAt(i);
            if (v instanceof SlidingCardLayout) {
                return (SlidingCardLayout) v;
            }
        }
        return null;
    }


    private int scroll(SlidingCardLayout child, int dy, int minOffset, int maxOffset) {
        int initalOffset = child.getTop();
        return initalOffset;
    }


    private int clamp(int i, int minOffset, int maxOffset) {
        if (i > maxOffset) {
            return maxOffset;
        } else if (i < minOffset) {
            return minOffset;
        } else {
            return i;
        }
    }
}
