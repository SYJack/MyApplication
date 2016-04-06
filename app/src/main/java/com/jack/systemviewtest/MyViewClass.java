package com.jack.systemviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016/3/30.
 */
public class MyViewClass extends AppCompatActivity {
    public static final String EXTRA_FLAG = "flag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int flag = getIntent().getIntExtra(EXTRA_FLAG, -1);
        switch (flag) {
            case 0:
                setContentView(R.layout.layout_popview);
                break;
            case 1:
                setContentView(R.layout.layout_customprogress);
                break;
            case 2:
                setContentView(R.layout.layout_timeview);
                break;
            case 3:
                setContentView(R.layout.layout_custompanlview);
                break;
        }
    }
}
