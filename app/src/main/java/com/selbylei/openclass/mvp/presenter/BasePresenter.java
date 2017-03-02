package com.selbylei.openclass.mvp.presenter;


import java.lang.ref.WeakReference;

/**
 * Created by selbylei on 17/2/17.
 */
public abstract class BasePresenter<T> {

    //定义弱引用
    private WeakReference<T> mViewRef;

    //关联activity和view
    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
    }

    //解除activity和view关联
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    //绑定view和model
    public abstract void fetch();

    //设置model类型
    public abstract void setModelType(int type);



}
