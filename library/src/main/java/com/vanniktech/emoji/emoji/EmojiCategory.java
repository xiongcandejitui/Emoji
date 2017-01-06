package com.vanniktech.emoji.emoji;

import android.support.annotation.DrawableRes;

/**
 * TODO: Describe class
 *
 * @author Ruben Gees
 */

public interface EmojiCategory {

    Emoji[] getData();

    @DrawableRes
    int getIcon();

}
