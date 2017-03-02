package com.selbylei.waterwave;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.selbylei.waterwave.view.WaveView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WaveView waveView = (WaveView) findViewById(R.id.waveView);
        waveView.startAnimation();
    }
}
