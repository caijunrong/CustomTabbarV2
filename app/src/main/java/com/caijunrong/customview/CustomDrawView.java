package com.caijunrong.customview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputBinding;
import android.widget.Toast;

import java.io.InputStream;

/**
 * TODO: document your custom view class.
 */
public class CustomDrawView extends View {

    private String mtext;
    private int textColor;
    private int msrc;
    private Context mContext;
//
    public CustomDrawView(Context context) {
        super(context, null);
        this.mContext = context;
    }

    public CustomDrawView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
        this.mContext = context;
        //需要调用
        initAttrs(attrs);

    }

    public CustomDrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initAttrs(attrs);

    }

    //获取资源
    private void initAttrs(AttributeSet attrs){

        TypedArray a = this.mContext.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomDrawView, 0, 0);

        int n = a.getIndexCount();

        for(int i = 0; i < n; i++) {
            int attr = a.getIndex(i);

            switch(attr){
                case R.styleable.CustomDrawView_showName:
                    mtext = a.getString(R.styleable.CustomDrawView_showName);
                    break;
                case R.styleable.CustomDrawView_textColor:
                    textColor = a.getColor(R.styleable.CustomDrawView_textColor,0xcc025923);
                    break;
                case R.styleable.CustomDrawView_showImage:
                    msrc = a.getResourceId(R.styleable.CustomDrawView_showImage,R.drawable.backtop);
                    break;
                default:
                    break;
            }


        }

        a.recycle();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();

        if (mtext != null) {

            paint.setColor(textColor);
            paint.setTextSize(46);

            canvas.drawText(mtext, 100, 30, paint);

        }

        if (msrc != 0){

            InputStream is = getResources().openRawResource(msrc);
            Bitmap mBitmap = BitmapFactory.decodeStream(is);
//            int bh = mBitmap.getHeight();
//            int bw = mBitmap.getWidth();
            canvas.drawBitmap(mBitmap, 0,0, paint);

        }

    }

    public void setMtext(String s){

        this.mtext = s;
        invalidate();

    }



}
