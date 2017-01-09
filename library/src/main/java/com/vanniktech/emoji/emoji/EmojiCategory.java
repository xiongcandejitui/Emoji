package com.vanniktech.emoji.emoji;

import android.support.annotation.DrawableRes;

public interface EmojiCategory {
    Emoji[] getData();

    @DrawableRes
    int getIcon();
}
