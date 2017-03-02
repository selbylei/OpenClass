package com.selbylei.openclass.mvp.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.selbylei.openclass.mvp.presenter.BasePresenter;

/**
 * baseActivity
 * Created by selbylei on 17/2/17.
 */

public abstract class MVPBaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity  {

    protected T mPresenter;


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        //关联view
        mPresenter.attachView((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除和view的关联
        mPresenter.detachView();
    }


    /**
     * 创建presenter
     *
     * @return
     */
    protected abstract T createPresenter();

}
