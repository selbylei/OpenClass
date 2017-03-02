package com.selbylei.openclass.mvp.model;

import com.selbylei.openclass.R;
import com.selbylei.openclass.mvp.bean.Girl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by selbylei on 17/2/17.
 */

public class GirlModelImpV1 implements IGirlModel {

    @Override
    public void loadGirl(GirlOnLoadListen listen) {

        List<Girl> data = new ArrayList<>();
        data.add(new Girl(R.drawable.ic_launcher,"五颗星","GirlModelImpV1获取图片"));
        data.add(new Girl(R.drawable.ic_launcher,"五颗星","GirlModelImpV1获取图片"));
        data.add(new Girl(R.drawable.ic_launcher,"五颗星","GirlModelImpV1获取图片"));
        data.add(new Girl(R.drawable.ic_launcher,"五颗星","GirlModelImpV1获取图片"));
        data.add(new Girl(R.drawable.ic_launcher,"五颗星","GirlModelImpV1获取图片"));
        data.add(new Girl(R.drawable.ic_launcher,"五颗星","GirlModelImpV1获取图片"));

        //回调监听
        listen.onComplete(data);
    }
}
