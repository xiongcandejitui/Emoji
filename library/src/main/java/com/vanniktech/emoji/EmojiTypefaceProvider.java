package com.vanniktech.emoji;


import android.content.Context;
import android.graphics.Typeface;

final class EmojiTypefaceProvider {

    private static Typeface typeface;

    static Typeface getTypeface(final Context context) {
        if (typeface == null) {
            typeface = Typeface.createFromAsset(context.getAssets(), "fonts/emojione.ttf");
        }

        return typeface;
    }

}
