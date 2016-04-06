package com.jack.systemviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Intent mIntent = null;

    private Button mButton;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIntent = new Intent(MainActivity.this, MyViewClass.class);
        mButton = (Button) findViewById(R.id.update_ui);
        mTextView = (TextView) findViewById(R.id.update_text);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TextViewThread().start();
            }
        });
    }

    public void btnPopView(View view) {
        mIntent.putExtra(MyViewClass.EXTRA_FLAG, 0);
        startActivity(mIntent);
    }

    public void btnProgress(View view) {
        mIntent.putExtra(MyViewClass.EXTRA_FLAG, 1);
        startActivity(mIntent);
    }

    public void btnTimeView(View view) {
        mIntent.putExtra(MyViewClass.EXTRA_FLAG, 2);
        startActivity(mIntent);
    }

    public void btnClock(View view) {
        mIntent.putExtra(MyViewClass.EXTRA_FLAG, 3);
        startActivity(mIntent);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    mTextView.setText((String) msg.obj);
                    break;
            }
        }
    };

    private class TextViewThread extends Thread {
        @Override
        public void run() {
            String s = new String("蛤蛤");
            Message message = handler.obtainMessage(1, s);
            message.sendToTarget();
        }
    }
}
