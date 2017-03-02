package com.selbylei.openclass.mvp.view;

import com.selbylei.openclass.mvp.bean.Girl;

import java.util.List;

/**
 *
 * girl view interface
 * Created by selbylei on 17/2/17.
 */

public interface IGirlView {

    void showLoading();

    void showGirls(List<Girl> girls);
}
