package com.vanniktech.emoji.emoji.category;

import android.support.annotation.DrawableRes;

import com.vanniktech.emoji.R;
import com.vanniktech.emoji.emoji.Emoji;
import com.vanniktech.emoji.emoji.EmojiCategory;

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
