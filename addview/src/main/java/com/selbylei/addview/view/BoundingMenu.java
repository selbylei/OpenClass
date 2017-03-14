//package com.selbylei.addview.view;
//
//import android.content.Context;
//
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.ViewParent;
//import android.widget.FrameLayout;
//import android.widget.Toast;
//
//import com.selbylei.addview.R;
//
///**
// * Created by selbylei on 17/3/9.
// */
//
//public class BoundingMenu {
//
//    private ViewGroup mParentVG;
//    private View rootView;
//    private BoundingView boundingView;
//    private RecyclerView recycleView;
//
//    public BoundingMenu(View view, int resId) {
//        //找到@android:id/content--不断找父容器，知道找到
//        mParentVG = findRootParent(view);
//        rootView = LayoutInflater.from(view.getContext()).inflate(R.layout.activity_main, null);
//        recycleView = (RecyclerView) rootView.findViewById(R.id.rv);
//        boundingView = (BoundingView) rootView.findViewById(R.id.bv);
//
//    }
//
//    private ViewGroup findRootParent(View view) {
//
//        do {
//            if (view instanceof FrameLayout) {
//                if (view.getId() == android.R.id.content) {
//                    return (ViewGroup) view;
//                }
//            }
//            if (view != null) {
//                ViewParent parent = view.getParent();
//                view = parent instanceof View ? (View) parent : null;
//            }
//        } while (true);
//    }
//
//    static BoundingMenu makeMenu(View view, int resId) {
//        return new BoundingMenu(view, resId);
//    }
//
//    public BoundingMenu show() {
//        //往@android：id/content里面addview(resId)
//
//        if (rootView.getParent() != null) {
//            mParentVG.removeView(rootView);
//        }
//
//        return this;
//    }
//}
