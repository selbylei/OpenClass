package com.selbylei.openclass.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.selbylei.openclass.R;
import com.selbylei.openclass.mvp.adapter.GirlAdapter;
import com.selbylei.openclass.mvp.bean.Girl;
import com.selbylei.openclass.mvp.presenter.GirlPresenter;
import com.selbylei.openclass.mvp.view.IGirlView;

import java.util.List;

public class GirlGridActivity extends AppCompatActivity implements IGirlView{

    private GridView gridview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girl_grid);
        gridview = (GridView) findViewById(R.id.gridview);

        //中间者

        GirlPresenter presenter = new GirlPresenter(this);
        presenter.setModelType(2);
        presenter.fetch();

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showGirls(List<Girl> girls) {
        gridview.setAdapter(new GirlAdapter(this,girls));
    }
}
