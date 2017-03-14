package selbylei.com.customcontainer;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.IntDef;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by selbylei on 17/3/14.
 */

public class LineeLayout extends ViewGroup {
    //每行每个子view
    private List<List<View>> mViewList = new ArrayList<>();
    private List<Integer> mHeightList = new ArrayList<>();

    public LineeLayout(Context context) {
//        LinearLayout
        super(context);
    }

    public LineeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LineeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LineeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mViewList.clear();
        mHeightList.clear();

        int lineWidth;
        int lineHeight;
        int width = getWidth();
        int height = getHeight();

        int count = getChildCount();

        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            MarginLayoutParams mlp = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getMeasuredWidth() + mlp.leftMargin + mlp.rightMargin;
            int childHeight = child.getMinimumHeight() + mlp.topMargin + mlp.bottomMargin;

        }

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        //自定义容器的宽高
        int width = 0;
        int height = 0;

        //当前的行宽高
        int lineWidth = 0;
        int lineHeight = 0;

        //循环遍历子控件
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            MarginLayoutParams mlp = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = mlp.leftMargin + mlp.rightMargin + child.getWidth();
            int childHeight = mlp.topMargin + mlp.bottomMargin + child.getHeight();

            /**
             * 往一个容器中放子控件有两种情况
             * 1.子控件可以放入，这时候的linwidth+=childWidth；lineHeight=Math.max(lineHeight,childHeight)
             * 2.如果子控件无法放入子控件放到下一行了
             * lineWidth = childWidth;
             lineHeight = childHeight;

             */
            if (childWidth + lineWidth > sizeWidth) {  //一旦超出容器宽度 换行
                width = Math.max(width, lineWidth);  //这边的linewidth是上一次的linewidth
                height += lineHeight;
                lineWidth = childWidth;     //这边的linewidth是子控件放到下面当前的linewidth就是子控件的
                lineHeight = childHeight;
            } else { //如果没有超出
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight, childHeight);
            }

            if (i == count - 1) {
                width = Math.max(width, lineWidth);
                height += lineHeight;
            }
        }
        /**
         *         判断使用的是什么模式
         *         MeasureSpec.EXACTLY 表示具体数值
         *         MeasureSpec.UNSPECIFIED  wrap_content
         *         MeasureSpec.AT_MOST     match_parent
         */
        int measureWidth = modeWidth == MeasureSpec.EXACTLY ? sizeWidth : width;
        int measureHeight = modeHeight == MeasureSpec.EXACTLY ? sizeHeight : width;

        setMeasuredDimension(measureWidth, measureHeight);

    }

    //获取LayoutParams
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }
}
