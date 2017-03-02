package com.selbylei.openclass.mvp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.selbylei.openclass.R;
import com.selbylei.openclass.mvp.adapter.GirlAdapter;
import com.selbylei.openclass.mvp.bean.Girl;
import com.selbylei.openclass.mvp.presenter.BasePresenter;
import com.selbylei.openclass.mvp.presenter.GirlPresenter;


import java.util.List;

public class MainActivity extends MVPBaseActivity implements IGirlView {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);
        mPresenter = createPresenter();
        mPresenter.setModelType(2);
        mPresenter.fetch();
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "正在拼命加载中...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showGirls(List<Girl> girls) {
        listView.setAdapter(new GirlAdapter(this, girls));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), position+"", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected BasePresenter createPresenter() {
        return new GirlPresenter(this);
    }
}
