package com.vanniktech.emoji;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.KeyEvent;

import com.vanniktech.emoji.emoji.Emoji;

public class EmojiEditText extends AppCompatEditText {

    public EmojiEditText(final Context context) {
        super(context);
        setTypeface(EmojiTypefaceProvider.getTypeface(context));
    }

    public EmojiEditText(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        setTypeface(EmojiTypefaceProvider.getTypeface(context));
    }

    public EmojiEditText(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        setTypeface(EmojiTypefaceProvider.getTypeface(context));
    }

    public void backspace() {
        final KeyEvent event = new KeyEvent(0, 0, 0, KeyEvent.KEYCODE_DEL, 0, 0, 0, 0, KeyEvent.KEYCODE_ENDCALL);
        dispatchKeyEvent(event);
    }

    public void input(final Emoji emoji) {
        if (emoji != null) {
            append(emoji.getEmoji());
        }
    }
}
