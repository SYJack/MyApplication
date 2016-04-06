package com.jack.systemviewtest.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.jack.systemviewtest.R;

/**
 * Created by Administrator on 2016/4/5.
 */
public class CustomTimeView extends View {
    Paint mPaint;
    Paint mPainDegree;

    public CustomTimeView(Context context) {
        this(context, null);
    }

    public CustomTimeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTimeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        mPaint.setStrokeWidth(5);
        mPaint.setColor(getResources().getColor(R.color.colorAccent));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);

        mPainDegree = new Paint();
        mPainDegree.setColor(getResources().getColor(R.color.colorAccent));
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getHeight() / 2 - getWidth() / 2, mPaint);
        for (int i = 1; i <= 12; i++) {
            if (i == 3 || i == 6 || i == 9 || i == 12) {
                mPaint.setStrokeWidth(20);
                mPaint.setTextSize(30);
                canvas.drawLine(getWidth() / 2, getWidth() / 2, getWidth() / 2, getWidth() / 2 + 60, mPainDegree);
                String s = String.valueOf(i);
                canvas.drawText(s, getWidth() / 2, getWidth() / 2 + 90, mPainDegree);
            } else {
                mPaint.setStrokeWidth(10);
                mPaint.setTextSize(15);
                canvas.drawLine(getWidth() / 2, getWidth() / 2, getWidth() / 2, getWidth() / 2 + 30, mPainDegree);
                String s = String.valueOf(i);
                canvas.drawText(s, getWidth() / 2, getWidth() / 2 + 60, mPainDegree);
            }
            canvas.rotate(30, getWidth() / 2, getHeight() / 2);
        }

        Paint paintPoint=new Paint();
        paintPoint.setStrokeWidth(10);
        paintPoint.setColor(getResources().getColor(R.color.colorPrimaryDark));

        canvas.drawPoint(getWidth() / 2, getHeight() / 2, paintPoint);

        Paint paintHour=new Paint();
        paintHour.setStrokeWidth(10);
        paintHour.setColor(getResources().getColor(R.color.colorPrimaryDark));

        Paint paintMin=new Paint();
        paintMin.setStrokeWidth(5);
        paintMin.setColor(getResources().getColor(R.color.colorPrimaryDark));

        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.drawLine(0, 0, 100, 100, paintMin);
        canvas.drawLine(0, 0, 100, 200, paintHour);

        canvas.restore();
    }
}
