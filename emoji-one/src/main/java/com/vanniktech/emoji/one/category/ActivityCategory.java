package com.vanniktech.emoji.one.category;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import com.vanniktech.emoji.emoji.Emoji;
import com.vanniktech.emoji.emoji.EmojiCategory;
import com.vanniktech.emoji.one.R;

@SuppressWarnings({"checkstyle:magicnumber", "PMD.MethodReturnsInternalArray"})
public class ActivityCategory implements EmojiCategory {
    private static final Emoji[] DATA = new Emoji[]{
            new Emoji(new String(new int[]{0x1f93a}, 0, 1), R.drawable.emoji_1f93a),
            new Emoji(new String(new int[]{0x1f3c7}, 0, 1), R.drawable.emoji_1f3c7),
            new Emoji(new String(new int[]{0x1f3c7, 0x1f3fb}, 0, 2), R.drawable.emoji_1f3c7_1f3fb),
            new Emoji(new String(new int[]{0x1f3c7, 0x1f3fc}, 0, 2), R.drawable.emoji_1f3c7_1f3fc),
            new Emoji(new String(new int[]{0x1f3c7, 0x1f3fd}, 0, 2), R.drawable.emoji_1f3c7_1f3fd),
            new Emoji(new String(new int[]{0x1f3c7, 0x1f3fe}, 0, 2), R.drawable.emoji_1f3c7_1f3fe),
            new Emoji(new String(new int[]{0x1f3c7, 0x1f3ff}, 0, 2), R.drawable.emoji_1f3c7_1f3ff),
            new Emoji(new String(new int[]{0x26f7}, 0, 1), R.drawable.emoji_26f7),
            new Emoji(new String(new int[]{0x1f3c2}, 0, 1), R.drawable.emoji_1f3c2),
            new Emoji(new String(new int[]{0x1f3cc}, 0, 1), R.drawable.emoji_1f3cc),
            new Emoji(new String(new int[]{0x1f3c4}, 0, 1), R.drawable.emoji_1f3c4),
            new Emoji(new String(new int[]{0x1f3c4, 0x1f3fb}, 0, 2), R.drawable.emoji_1f3c4_1f3fb),
            new Emoji(new String(new int[]{0x1f3c4, 0x1f3fc}, 0, 2), R.drawable.emoji_1f3c4_1f3fc),
            new Emoji(new String(new int[]{0x1f3c4, 0x1f3fd}, 0, 2), R.drawable.emoji_1f3c4_1f3fd),
            new Emoji(new String(new int[]{0x1f3c4, 0x1f3fe}, 0, 2), R.drawable.emoji_1f3c4_1f3fe),
            new Emoji(new String(new int[]{0x1f3c4, 0x1f3ff}, 0, 2), R.drawable.emoji_1f3c4_1f3ff),
            new Emoji(new String(new int[]{0x1f6a3}, 0, 1), R.drawable.emoji_1f6a3),
            new Emoji(new String(new int[]{0x1f6a3, 0x1f3fb}, 0, 2), R.drawable.emoji_1f6a3_1f3fb),
            new Emoji(new String(new int[]{0x1f6a3, 0x1f3fc}, 0, 2), R.drawable.emoji_1f6a3_1f3fc),
            new Emoji(new String(new int[]{0x1f6a3, 0x1f3fd}, 0, 2), R.drawable.emoji_1f6a3_1f3fd),
            new Emoji(new String(new int[]{0x1f6a3, 0x1f3fe}, 0, 2), R.drawable.emoji_1f6a3_1f3fe),
            new Emoji(new String(new int[]{0x1f6a3, 0x1f3ff}, 0, 2), R.drawable.emoji_1f6a3_1f3ff),
            new Emoji(new String(new int[]{0x1f3ca}, 0, 1), R.drawable.emoji_1f3ca),
            new Emoji(new String(new int[]{0x1f3ca, 0x1f3fb}, 0, 2), R.drawable.emoji_1f3ca_1f3fb),
            new Emoji(new String(new int[]{0x1f3ca, 0x1f3fc}, 0, 2), R.drawable.emoji_1f3ca_1f3fc),
            new Emoji(new String(new int[]{0x1f3ca, 0x1f3fd}, 0, 2), R.drawable.emoji_1f3ca_1f3fd),
            new Emoji(new String(new int[]{0x1f3ca, 0x1f3fe}, 0, 2), R.drawable.emoji_1f3ca_1f3fe),
            new Emoji(new String(new int[]{0x1f3ca, 0x1f3ff}, 0, 2), R.drawable.emoji_1f3ca_1f3ff),
            new Emoji(new String(new int[]{0x26f9}, 0, 1), R.drawable.emoji_26f9),
            new Emoji(new String(new int[]{0x26f9, 0x1f3fb}, 0, 2), R.drawable.emoji_26f9_1f3fb),
            new Emoji(new String(new int[]{0x26f9, 0x1f3fc}, 0, 2), R.drawable.emoji_26f9_1f3fc),
            new Emoji(new String(new int[]{0x26f9, 0x1f3fd}, 0, 2), R.drawable.emoji_26f9_1f3fd),
            new Emoji(new String(new int[]{0x26f9, 0x1f3fe}, 0, 2), R.drawable.emoji_26f9_1f3fe),
            new Emoji(new String(new int[]{0x26f9, 0x1f3ff}, 0, 2), R.drawable.emoji_26f9_1f3ff),
            new Emoji(new String(new int[]{0x1f3cb}, 0, 1), R.drawable.emoji_1f3cb),
            new Emoji(new String(new int[]{0x1f3cb, 0x1f3fb}, 0, 2), R.drawable.emoji_1f3cb_1f3fb),
            new Emoji(new String(new int[]{0x1f3cb, 0x1f3fc}, 0, 2), R.drawable.emoji_1f3cb_1f3fc),
            new Emoji(new String(new int[]{0x1f3cb, 0x1f3fd}, 0, 2), R.drawable.emoji_1f3cb_1f3fd),
            new Emoji(new String(new int[]{0x1f3cb, 0x1f3fe}, 0, 2), R.drawable.emoji_1f3cb_1f3fe),
            new Emoji(new String(new int[]{0x1f3cb, 0x1f3ff}, 0, 2), R.drawable.emoji_1f3cb_1f3ff),
            new Emoji(new String(new int[]{0x1f6b4}, 0, 1), R.drawable.emoji_1f6b4),
            new Emoji(new String(new int[]{0x1f6b4, 0x1f3fb}, 0, 2), R.drawable.emoji_1f6b4_1f3fb),
            new Emoji(new String(new int[]{0x1f6b4, 0x1f3fc}, 0, 2), R.drawable.emoji_1f6b4_1f3fc),
            new Emoji(new String(new int[]{0x1f6b4, 0x1f3fd}, 0, 2), R.drawable.emoji_1f6b4_1f3fd),
            new Emoji(new String(new int[]{0x1f6b4, 0x1f3fe}, 0, 2), R.drawable.emoji_1f6b4_1f3fe),
            new Emoji(new String(new int[]{0x1f6b4, 0x1f3ff}, 0, 2), R.drawable.emoji_1f6b4_1f3ff),
            new Emoji(new String(new int[]{0x1f6b5}, 0, 1), R.drawable.emoji_1f6b5),
            new Emoji(new String(new int[]{0x1f6b5, 0x1f3fb}, 0, 2), R.drawable.emoji_1f6b5_1f3fb),
            new Emoji(new String(new int[]{0x1f6b5, 0x1f3fc}, 0, 2), R.drawable.emoji_1f6b5_1f3fc),
            new Emoji(new String(new int[]{0x1f6b5, 0x1f3fd}, 0, 2), R.drawable.emoji_1f6b5_1f3fd),
            new Emoji(new String(new int[]{0x1f6b5, 0x1f3fe}, 0, 2), R.drawable.emoji_1f6b5_1f3fe),
            new Emoji(new String(new int[]{0x1f6b5, 0x1f3ff}, 0, 2), R.drawable.emoji_1f6b5_1f3ff),
            new Emoji(new String(new int[]{0x1f3f5}, 0, 1), R.drawable.emoji_1f3f5),
            new Emoji(new String(new int[]{0x1f3aa}, 0, 1), R.drawable.emoji_1f3aa),
            new Emoji(new String(new int[]{0x1f3ad}, 0, 1), R.drawable.emoji_1f3ad),
            new Emoji(new String(new int[]{0x1f3a8}, 0, 1), R.drawable.emoji_1f3a8),
            new Emoji(new String(new int[]{0x1f3b0}, 0, 1), R.drawable.emoji_1f3b0),
            new Emoji(new String(new int[]{0x1f397}, 0, 1), R.drawable.emoji_1f397),
            new Emoji(new String(new int[]{0x1f39f}, 0, 1), R.drawable.emoji_1f39f),
            new Emoji(new String(new int[]{0x1f3ab}, 0, 1), R.drawable.emoji_1f3ab),
            new Emoji(new String(new int[]{0x1f396}, 0, 1), R.drawable.emoji_1f396),
            new Emoji(new String(new int[]{0x1f3c6}, 0, 1), R.drawable.emoji_1f3c6),
            new Emoji(new String(new int[]{0x1f3c5}, 0, 1), R.drawable.emoji_1f3c5),
            new Emoji(new String(new int[]{0x1f947}, 0, 1), R.drawable.emoji_1f947),
            new Emoji(new String(new int[]{0x1f948}, 0, 1), R.drawable.emoji_1f948),
            new Emoji(new String(new int[]{0x1f949}, 0, 1), R.drawable.emoji_1f949),
            new Emoji(new String(new int[]{0x26bd}, 0, 1), R.drawable.emoji_26bd),
            new Emoji(new String(new int[]{0x26be}, 0, 1), R.drawable.emoji_26be),
            new Emoji(new String(new int[]{0x1f3c0}, 0, 1), R.drawable.emoji_1f3c0),
            new Emoji(new String(new int[]{0x1f3d0}, 0, 1), R.drawable.emoji_1f3d0),
            new Emoji(new String(new int[]{0x1f3c8}, 0, 1), R.drawable.emoji_1f3c8),
            new Emoji(new String(new int[]{0x1f3c9}, 0, 1), R.drawable.emoji_1f3c9),
            new Emoji(new String(new int[]{0x1f3be}, 0, 1), R.drawable.emoji_1f3be),
            new Emoji(new String(new int[]{0x1f3b1}, 0, 1), R.drawable.emoji_1f3b1),
            new Emoji(new String(new int[]{0x1f3b3}, 0, 1), R.drawable.emoji_1f3b3),
            new Emoji(new String(new int[]{0x1f3cf}, 0, 1), R.drawable.emoji_1f3cf),
            new Emoji(new String(new int[]{0x1f3d1}, 0, 1), R.drawable.emoji_1f3d1),
            new Emoji(new String(new int[]{0x1f3d2}, 0, 1), R.drawable.emoji_1f3d2),
            new Emoji(new String(new int[]{0x1f3d3}, 0, 1), R.drawable.emoji_1f3d3),
            new Emoji(new String(new int[]{0x1f3f8}, 0, 1), R.drawable.emoji_1f3f8),
            new Emoji(new String(new int[]{0x1f94a}, 0, 1), R.drawable.emoji_1f94a),
            new Emoji(new String(new int[]{0x1f94b}, 0, 1), R.drawable.emoji_1f94b),
            new Emoji(new String(new int[]{0x1f945}, 0, 1), R.drawable.emoji_1f945),
            new Emoji(new String(new int[]{0x1f3af}, 0, 1), R.drawable.emoji_1f3af),
            new Emoji(new String(new int[]{0x26f3}, 0, 1), R.drawable.emoji_26f3),
            new Emoji(new String(new int[]{0x26f8}, 0, 1), R.drawable.emoji_26f8),
            new Emoji(new String(new int[]{0x1f3a3}, 0, 1), R.drawable.emoji_1f3a3),
            new Emoji(new String(new int[]{0x1f3bd}, 0, 1), R.drawable.emoji_1f3bd),
            new Emoji(new String(new int[]{0x1f3bf}, 0, 1), R.drawable.emoji_1f3bf),
            new Emoji(new String(new int[]{0x1f3ae}, 0, 1), R.drawable.emoji_1f3ae),
            new Emoji(new String(new int[]{0x1f3b2}, 0, 1), R.drawable.emoji_1f3b2),
            new Emoji(new String(new int[]{0x1f3bc}, 0, 1), R.drawable.emoji_1f3bc),
            new Emoji(new String(new int[]{0x1f3a4}, 0, 1), R.drawable.emoji_1f3a4),
            new Emoji(new String(new int[]{0x1f3a7}, 0, 1), R.drawable.emoji_1f3a7),
            new Emoji(new String(new int[]{0x1f3b7}, 0, 1), R.drawable.emoji_1f3b7),
            new Emoji(new String(new int[]{0x1f3b8}, 0, 1), R.drawable.emoji_1f3b8),
            new Emoji(new String(new int[]{0x1f3b9}, 0, 1), R.drawable.emoji_1f3b9),
            new Emoji(new String(new int[]{0x1f3ba}, 0, 1), R.drawable.emoji_1f3ba),
            new Emoji(new String(new int[]{0x1f3bb}, 0, 1), R.drawable.emoji_1f3bb),
            new Emoji(new String(new int[]{0x1f3ac}, 0, 1), R.drawable.emoji_1f3ac),
            new Emoji(new String(new int[]{0x1f3f9}, 0, 1), R.drawable.emoji_1f3f9)
    };

    @Override
    @NonNull
    public Emoji[] getEmojis() {
        return DATA;
    }

    @Override
    @DrawableRes
    public int getIcon() {
        return R.drawable.emoji_category_activity;
    }
}
