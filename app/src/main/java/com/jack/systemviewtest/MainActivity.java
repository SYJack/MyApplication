package com.jack.systemviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent mIntent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIntent = new Intent(MainActivity.this, MyViewClass.class);
    }

    public void btnPopView(View view) {
        mIntent.putExtra(MyViewClass.EXTRA_FLAG, 0);
        startActivity(mIntent);
    }

    public void btnProgress(View view){
        mIntent.putExtra(MyViewClass.EXTRA_FLAG,1);
        startActivity(mIntent);
    }
}
