package com.caijunrong.customview;

import com.caijunrong.customview.DensityUtil;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.BoolRes;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by biyabi on 16/5/3.
 */
public class CustomXMLView extends RelativeLayout {

    private Context mContext;
    private TextView titleTextView;
    private  String titleString;

    private int imageResId;
    private int textNormalColorId;
    private int selectedColorId;
    private int selectedImageResId;

    private ImageView imageView;

    public CustomXMLView(Context context) {
        super(context);
        this.mContext = context;
        initView(context);
    }

    public CustomXMLView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initAttrs(attrs);
        initView(context);

    }

    public CustomXMLView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs,defStyleAttr);
        this.mContext = context;
        initAttrs(attrs);
        initView(context);

    }

    private void initView(Context context){


        imageView = new ImageView(mContext);
        int tagImageSize = DensityUtil.dip2px(mContext, 25);
        LayoutParams tabImageLayoutParams = new LayoutParams(tagImageSize,tagImageSize);
        tabImageLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        tabImageLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        int tabImagePadding = DensityUtil.dip2px(context,0);
        imageView.setPadding(tabImagePadding, 0, tabImagePadding, 0);
        imageView.setImageResource(imageResId);
        imageView.setLayoutParams(tabImageLayoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setId(R.id.tabbutton_imageview);
        addView(imageView);

        titleTextView = new TextView(mContext);
        LayoutParams titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        titleParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        titleParams.addRule(RelativeLayout.BELOW,R.id.tabbutton_imageview);
        titleTextView.setTextColor(0xffaaaaaa);
        titleTextView.setTextSize(10);
        titleTextView.setText(titleString);
        titleTextView.setLayoutParams(titleParams);
        addView(titleTextView);


    }

    private void initAttrs(AttributeSet attrs){

        TypedArray array = mContext.obtainStyledAttributes(attrs,R.styleable.CustomXMLView);

        titleString = array.getString(R.styleable.CustomXMLView_showName2);

        imageResId = array.getResourceId(R.styleable.CustomXMLView_showImage2,R.drawable.ic_launcher);

        selectedImageResId =   array.getResourceId(R.styleable.CustomXMLView_selectedShowImage,R.drawable.ic_launcher);

        selectedColorId = array.getColor(R.styleable.CustomXMLView_selectedTextColor2,0x88888888);

        textNormalColorId =  array.getColor(R.styleable.CustomXMLView_textColor2,0x88888888);

    }


    public void setSelectedState(Boolean state){

        if (state){

            titleTextView.setTextColor(selectedColorId);
            imageView.setImageResource(selectedImageResId);

        }else {

            titleTextView.setTextColor(textNormalColorId);
            imageView.setImageResource(imageResId);

        }

    }



}
