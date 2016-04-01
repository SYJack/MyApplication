package com.jack.systemviewtest.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.jack.systemviewtest.R;

/**
 * Created by Administrator on 2016/3/31.
 */
public class PopWindowsView extends View {

    private Paint mPaint;
    private Path mPath;
    private int popColor;

    private int mRectHeight;
    private int mRectWidth;

    private int mHeight;
    private int mWidth;

    private int mTriangleWidth;
    private int mTriangleHeight;

    private double mPercentage=0.5;

    public PopWindowsView(Context context) {
        this(context, null);
    }

    public PopWindowsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PopWindowsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.PopWindowsView, defStyleAttr, 0);
        popColor = typedArray.getColor(R.styleable.PopWindowsView_popColor, Color.parseColor("#2C97DE"));
        typedArray.recycle();
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#2C97DE"));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setPathEffect(new CornerPathEffect(3));

        mPath=new Path();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int specWidth = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        if (widthMode==MeasureSpec.EXACTLY){
            mWidth=specWidth;
            mRectWidth= (int) (mWidth*mPercentage);
        }else {
            if (widthMode==MeasureSpec.AT_MOST){

            }
        }

        int specHeight = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        if (heightMode==MeasureSpec.EXACTLY){
            mHeight=specHeight;
            mRectHeight= (int) (mHeight*mPercentage);
        }else {
            if (heightMode==MeasureSpec.AT_MOST){

            }
        }
        setMeasuredDimension(mWidth,mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        final int padding=(mWidth-mRectWidth)/2;
        canvas.drawRoundRect(new RectF(padding, padding, mRectWidth + padding, mRectHeight - padding), 10, 10, mPaint);

        int width=mWidth-2*padding;

        mPath.moveTo(padding+width/4,mRectHeight - padding);
        mPath.lineTo(padding+width/4*3,mRectHeight - padding);
        mPath.lineTo(padding+width/2,mRectHeight - padding+30);
        mPath.close();
        canvas.drawPath(mPath, mPaint);

        super.onDraw(canvas);
    }
}
