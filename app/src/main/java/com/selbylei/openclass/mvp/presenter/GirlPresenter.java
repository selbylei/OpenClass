package com.selbylei.openclass.mvp.presenter;

import com.selbylei.openclass.mvp.bean.Girl;
import com.selbylei.openclass.mvp.model.GirlModelImpV1;
import com.selbylei.openclass.mvp.model.GirlModelImpV2;
import com.selbylei.openclass.mvp.model.IGirlModel;
import com.selbylei.openclass.mvp.view.IGirlView;

import java.util.List;

/**
 * Created by selbylei on 17/2/17.
 */

public class GirlPresenter  extends BasePresenter{

    private IGirlModel mGirlModel;
    private IGirlView mGirlView;

    //构造函数初始化view，一般为activity上下文传递下来
    public GirlPresenter(IGirlView mGirlView) {
        this.mGirlView = mGirlView;
    }


    public void setModelType(int type ) {
        switch (type){
            case 1:
                mGirlModel = new GirlModelImpV1();
                break;
            case 2:
                mGirlModel = new GirlModelImpV2();
                break;
            default:
                mGirlModel = new GirlModelImpV2();
                break;
        }
    }



    /**
     * 绑定view和model，实现IGirlModel.GirlOnLoadListen回调
     */
    public void fetch() {
        //让model  load data
        mGirlView.showLoading();
        if (mGirlModel != null) {
            mGirlModel.loadGirl(new IGirlModel.GirlOnLoadListen() {
                @Override
                public void onComplete(List<Girl> girls) {
                    mGirlView.showGirls(girls);
                }
            });
        }
    }




}
