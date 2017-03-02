package com.selbylei.openclass.mvp.model;

import com.selbylei.openclass.mvp.bean.Girl;

import java.util.List;

/**
 * Created by selbylei on 17/2/17.
 */

public interface IGirlModel {

    void loadGirl(GirlOnLoadListen listen);

    //加载girls回调接口
    interface GirlOnLoadListen {

        void onComplete(List<Girl> girls);

    }
}
