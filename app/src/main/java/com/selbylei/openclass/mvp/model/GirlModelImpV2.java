package com.selbylei.openclass.mvp.model;

import android.util.Log;

import com.selbylei.openclass.R;
import com.selbylei.openclass.mvp.bean.Girl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by selbylei on 17/2/17.
 */

public class GirlModelImpV2 implements IGirlModel {


    private static final String TAG = GirlModelImpV2.class.getSimpleName() ;

    @Override
    public void loadGirl(GirlOnLoadListen listen) {
        //模拟从网上下载
        Log.i(TAG, "load:from internet");

        List<Girl> data = new ArrayList<>();
        data.add(new Girl(R.drawable.ic_launcher,"五颗星","GirlModelImpV2获取图片"));
        data.add(new Girl(R.drawable.ic_launcher,"五颗星","GirlModelImpV2获取图片"));
        data.add(new Girl(R.drawable.ic_launcher,"五颗星","GirlModelImpV2获取图片"));
        data.add(new Girl(R.drawable.ic_launcher,"五颗星","GirlModelImpV2获取图片"));
        data.add(new Girl(R.drawable.ic_launcher,"五颗星","GirlModelImpV2获取图片"));
        data.add(new Girl(R.drawable.ic_launcher,"五颗星","GirlModelImpV2获取图片"));

        //回调监听
        listen.onComplete(data);
    }
}
