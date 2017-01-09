package com.vanniktech.emoji;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public class SquareImageButton extends AppCompatImageButton {
    public SquareImageButton(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
}
