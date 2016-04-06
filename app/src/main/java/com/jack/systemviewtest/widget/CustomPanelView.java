package com.jack.systemviewtest.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/4/6.
 */
public class CustomPanelView extends View {
    private Paint mPainCircleBig;
    private Paint mPainCircleSmall;

    private Paint mPaintLine;

    private Paint mPaintPoint;

    public CustomPanelView(Context context) {
        this(context, null);
    }

    public CustomPanelView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomPanelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /**绘制外圆*/
        mPainCircleBig = new Paint();
        mPainCircleBig.setAntiAlias(true);
        mPainCircleBig.setStrokeWidth(2);
        mPainCircleBig.setStyle(Paint.Style.STROKE);
        mPainCircleBig.setColor(Color.WHITE);
        /**绘制内圆*/
        mPainCircleSmall = new Paint();
        mPainCircleSmall.setAntiAlias(true);
        mPainCircleSmall.setStrokeWidth(2);
        mPainCircleSmall.setStyle(Paint.Style.STROKE);
        mPainCircleSmall.setColor(Color.rgb(30, 144, 255));
        /**绘制刻度*/
        mPaintLine = new Paint();
        mPaintLine.setStyle(Paint.Style.STROKE);
        mPaintLine.setAntiAlias(true);
        mPaintLine.setColor(Color.WHITE);

        /**绘制小圆点*/
        mPaintPoint = new Paint();
        mPaintPoint.setColor(Color.WHITE);
        mPaintPoint.setAntiAlias(true);
        mPaintPoint.setStyle(Paint.Style.FILL);
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        setMeasuredDimension(setMeasure(widthMeasureSpec, true),setMeasure(heightMeasureSpec,false) );
//    }

//    private int setMeasure(int measureSpec, boolean isWidth) {
//        int size=MeasureSpec.getSize(measureSpec);
//        int mode=MeasureSpec.getMode(measureSpec);
//
//        int padding=isWidth?getPaddingLeft()
//        return 0;
//    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getHeight() - getWidth()) / 2, mPainCircleBig);

        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getHeight() - getWidth()) / 4, mPainCircleSmall);

        for (int i = 0; i <= 60; i++) {
            if (i % 6 == 0) {
                mPaintLine.setStrokeWidth(5);
                canvas.drawLine(getWidth() / 2, getWidth() / 2 + 15, getWidth() / 2, getWidth() / 2 + 60, mPaintLine);
            } else {
                if (i == 3 || i == 9 || i == 15 || i == 21 || i == 27 || i == 33 || i == 39 || i == 45 || i == 51 || i == 57) {

                    canvas.drawCircle(getWidth() / 2 ,getWidth() / 2 +22,5,mPaintPoint);
                }else {
                    mPaintLine.setStrokeWidth(2);
                    canvas.drawLine(getWidth() / 2, getWidth() / 2 + 15, getWidth() / 2, getWidth() / 2 + 30, mPaintLine);
                }

            }
            canvas.rotate(6, getWidth() / 2, getHeight() / 2);
        }
    }
}
