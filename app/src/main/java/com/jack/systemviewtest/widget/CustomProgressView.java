package com.jack.systemviewtest.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.jack.systemviewtest.R;

/**
 * Created by Administrator on 2016/4/1.
 */
public class CustomProgressView extends View{
    private int firstColor;
    private int secondColor;
    private int circleWidth;
    private int speed;

    private Paint mPaint;

    private int currentProgress;

    private boolean isNext;

    public CustomProgressView(Context context) {
        this(context, null);
    }

    public CustomProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray=context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomProgressView,defStyleAttr,0);
        int a=typedArray.getIndexCount();
        for (int i=0;i<a;i++){
            int attr=typedArray.getIndex(i);
            switch (attr){
                case R.styleable.CustomProgressView_firstColor:
                    firstColor=typedArray.getColor(attr, Color.GREEN);
                    break;
                case R.styleable.CustomProgressView_secondColor:
                    secondColor=typedArray.getColor(attr,Color.BLUE);
                    break;
                case R.styleable.CustomProgressView_circleWidth:
                    circleWidth=typedArray.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,20,
                            getResources().getDisplayMetrics()));
                    break;
                case R.styleable.CustomProgressView_speed:
                    speed=typedArray.getInt(attr, 20);
                    break;
            }
        }
        typedArray.recycle();

        mPaint=new Paint();
     new Thread(){
         @Override
         public void run() {
             while (true){
                 currentProgress++;
                 if (currentProgress==360){
                     currentProgress=0;
                     if (!isNext){
                         isNext=false;
                     }else {
                         isNext=true;
                     }
                 }
                 postInvalidate();
                     try {
                         Thread.sleep(speed);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
             }
         }
     }.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**圆心X坐标*/
        int centre=getWidth()/2;
        int radius=centre-circleWidth/2;
        mPaint.setStrokeWidth(circleWidth);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);

        RectF rectF=new RectF(centre-radius,centre-radius,centre+radius,centre+radius);

        if (!isNext){
            mPaint.setColor(firstColor);
            canvas.drawCircle(centre,centre,radius,mPaint);
            mPaint.setColor(secondColor);
            canvas.drawArc(rectF,-90,currentProgress,false,mPaint);
        }else {
            mPaint.setColor(secondColor);
            canvas.drawCircle(centre,centre,radius,mPaint);
            mPaint.setColor(firstColor);
            canvas.drawArc(rectF,-90,currentProgress,false,mPaint);
        }

    }
}
