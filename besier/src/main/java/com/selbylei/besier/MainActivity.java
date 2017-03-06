package com.selbylei.besier;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.selbylei.besier.util.AnimatorPath;
import com.selbylei.besier.util.PathEvaluator;
import com.selbylei.besier.util.PathPoint;

public class MainActivity extends AppCompatActivity {

    private ImageButton ib_left;
    private TextView tv;

    private final int ANIMATION_DURATION = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();

    }

    private void bindView() {
        ib_left = (ImageButton) findViewById(R.id.ib_left);
        ib_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFabPress();
            }
        });
        tv = (TextView) findViewById(R.id.tv);
    }


    protected void onFabPress() {
        AnimatorPath mPath = new AnimatorPath();
        //移动
        mPath.moveTo(-100, -100);
        //直线
        mPath.lineTo(-100, -100);
        //什么是属性动画?可以控制一个对象身上的任何属性值，--setxxx()
        ObjectAnimator animator = ObjectAnimator.ofObject(this, "haha", new PathEvaluator(), mPath.getPoints().toArray());
        animator.setDuration(ANIMATION_DURATION);
        animator.start();

        ObjectAnimator a = ObjectAnimator.ofFloat(this, "wuwu", 0, 1);
        a.setDuration(ANIMATION_DURATION);
        a.start();
    }


    public void setHaha(PathPoint p) {
        ib_left.setTranslationX(p.mX);
        ib_left.setTranslationY(p.mY);
    }

    public void setWuwu(float a) {
        tv.setText(String.valueOf(a));
    }

}
