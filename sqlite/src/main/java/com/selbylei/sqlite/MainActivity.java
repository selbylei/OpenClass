package com.selbylei.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.selbylei.sqlite.enity.User;

public class MainActivity extends AppCompatActivity {

    IBaseDao<User> userIBaseDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


    public void insert(View view){

        User user = new User();
    }

}
