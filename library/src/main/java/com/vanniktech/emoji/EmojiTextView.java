package com.vanniktech.emoji;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class EmojiTextView extends AppCompatTextView {

    public EmojiTextView(final Context context) {
        super(context);
        setTypeface(EmojiTypefaceProvider.getTypeface(context));
    }

    public EmojiTextView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        setTypeface(EmojiTypefaceProvider.getTypeface(context));
    }

    public EmojiTextView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        setTypeface(EmojiTypefaceProvider.getTypeface(context));
    }
}
