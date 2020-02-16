package com.dinesh.sheduleit.galleryMultipleImagePick.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.dinesh.sheduleit.R;

public class FitWidthRelativeLayout extends RelativeLayout {

    /**
     * Aspect ratio is calculated by width / height.
     */
    protected float aspectRatio;

    public FitWidthRelativeLayout(Context context) {
        super(context);
    }

    public FitWidthRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.AspectRatioView, 0, 0);
        try {
            aspectRatio = a.getFloat(R.styleable.AspectRatioView_view_aspectRatio, 0);
        } finally {
            a.recycle();
        }
    }

    public FitWidthRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (aspectRatio > 0) {
            int width = View.MeasureSpec.getSize(widthMeasureSpec);
            int height = Math.round(View.MeasureSpec.getSize(widthMeasureSpec) / aspectRatio);
            int finalWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY);
            int finalHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY);
            super.onMeasure(finalWidthMeasureSpec, finalHeightMeasureSpec);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}

