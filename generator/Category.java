package com.vanniktech.emoji.emoji;

import android.support.annotation.DrawableRes;

import com.vanniktech.emoji.R;

public class <%= name %> implements EmojiCategory {

    private static final Emoji[] DATA = new Emoji[]{
            <%= data %>
    };

    @Override
    public Emoji[] getData() {
        return DATA;
    }

    @Override
    @DrawableRes
    public int getIcon() {
        return R.drawable.emoji_cars;
    }
}
