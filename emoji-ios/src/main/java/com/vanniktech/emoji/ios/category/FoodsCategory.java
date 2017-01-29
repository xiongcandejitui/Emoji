package com.vanniktech.emoji.ios.category;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import com.vanniktech.emoji.emoji.Emoji;
import com.vanniktech.emoji.emoji.EmojiCategory;
import com.vanniktech.emoji.ios.R;

@SuppressWarnings({"checkstyle:magicnumber", "PMD.MethodReturnsInternalArray"})
public class FoodsCategory implements EmojiCategory {
    private static final Emoji[] DATA = new Emoji[]{
            new Emoji(new String(new int[]{0x1f347}, 0, 1), R.drawable.emoji_1f347),
            new Emoji(new String(new int[]{0x1f348}, 0, 1), R.drawable.emoji_1f348),
            new Emoji(new String(new int[]{0x1f349}, 0, 1), R.drawable.emoji_1f349),
            new Emoji(new String(new int[]{0x1f34a}, 0, 1), R.drawable.emoji_1f34a),
            new Emoji(new String(new int[]{0x1f34b}, 0, 1), R.drawable.emoji_1f34b),
            new Emoji(new String(new int[]{0x1f34c}, 0, 1), R.drawable.emoji_1f34c),
            new Emoji(new String(new int[]{0x1f34d}, 0, 1), R.drawable.emoji_1f34d),
            new Emoji(new String(new int[]{0x1f34e}, 0, 1), R.drawable.emoji_1f34e),
            new Emoji(new String(new int[]{0x1f34f}, 0, 1), R.drawable.emoji_1f34f),
            new Emoji(new String(new int[]{0x1f350}, 0, 1), R.drawable.emoji_1f350),
            new Emoji(new String(new int[]{0x1f351}, 0, 1), R.drawable.emoji_1f351),
            new Emoji(new String(new int[]{0x1f352}, 0, 1), R.drawable.emoji_1f352),
            new Emoji(new String(new int[]{0x1f353}, 0, 1), R.drawable.emoji_1f353),
            new Emoji(new String(new int[]{0x1f95d}, 0, 1), R.drawable.emoji_1f95d),
            new Emoji(new String(new int[]{0x1f345}, 0, 1), R.drawable.emoji_1f345),
            new Emoji(new String(new int[]{0x1f951}, 0, 1), R.drawable.emoji_1f951),
            new Emoji(new String(new int[]{0x1f346}, 0, 1), R.drawable.emoji_1f346),
            new Emoji(new String(new int[]{0x1f954}, 0, 1), R.drawable.emoji_1f954),
            new Emoji(new String(new int[]{0x1f955}, 0, 1), R.drawable.emoji_1f955),
            new Emoji(new String(new int[]{0x1f33d}, 0, 1), R.drawable.emoji_1f33d),
            new Emoji(new String(new int[]{0x1f336}, 0, 1), R.drawable.emoji_1f336),
            new Emoji(new String(new int[]{0x1f952}, 0, 1), R.drawable.emoji_1f952),
            new Emoji(new String(new int[]{0x1f95c}, 0, 1), R.drawable.emoji_1f95c),
            new Emoji(new String(new int[]{0x1f330}, 0, 1), R.drawable.emoji_1f330),
            new Emoji(new String(new int[]{0x1f35e}, 0, 1), R.drawable.emoji_1f35e),
            new Emoji(new String(new int[]{0x1f950}, 0, 1), R.drawable.emoji_1f950),
            new Emoji(new String(new int[]{0x1f956}, 0, 1), R.drawable.emoji_1f956),
            new Emoji(new String(new int[]{0x1f95e}, 0, 1), R.drawable.emoji_1f95e),
            new Emoji(new String(new int[]{0x1f9c0}, 0, 1), R.drawable.emoji_1f9c0),
            new Emoji(new String(new int[]{0x1f356}, 0, 1), R.drawable.emoji_1f356),
            new Emoji(new String(new int[]{0x1f357}, 0, 1), R.drawable.emoji_1f357),
            new Emoji(new String(new int[]{0x1f953}, 0, 1), R.drawable.emoji_1f953),
            new Emoji(new String(new int[]{0x1f354}, 0, 1), R.drawable.emoji_1f354),
            new Emoji(new String(new int[]{0x1f35f}, 0, 1), R.drawable.emoji_1f35f),
            new Emoji(new String(new int[]{0x1f355}, 0, 1), R.drawable.emoji_1f355),
            new Emoji(new String(new int[]{0x1f32d}, 0, 1), R.drawable.emoji_1f32d),
            new Emoji(new String(new int[]{0x1f32e}, 0, 1), R.drawable.emoji_1f32e),
            new Emoji(new String(new int[]{0x1f32f}, 0, 1), R.drawable.emoji_1f32f),
            new Emoji(new String(new int[]{0x1f959}, 0, 1), R.drawable.emoji_1f959),
            new Emoji(new String(new int[]{0x1f95a}, 0, 1), R.drawable.emoji_1f95a),
            new Emoji(new String(new int[]{0x1f373}, 0, 1), R.drawable.emoji_1f373),
            new Emoji(new String(new int[]{0x1f958}, 0, 1), R.drawable.emoji_1f958),
            new Emoji(new String(new int[]{0x1f372}, 0, 1), R.drawable.emoji_1f372),
            new Emoji(new String(new int[]{0x1f957}, 0, 1), R.drawable.emoji_1f957),
            new Emoji(new String(new int[]{0x1f37f}, 0, 1), R.drawable.emoji_1f37f),
            new Emoji(new String(new int[]{0x1f371}, 0, 1), R.drawable.emoji_1f371),
            new Emoji(new String(new int[]{0x1f358}, 0, 1), R.drawable.emoji_1f358),
            new Emoji(new String(new int[]{0x1f359}, 0, 1), R.drawable.emoji_1f359),
            new Emoji(new String(new int[]{0x1f35a}, 0, 1), R.drawable.emoji_1f35a),
            new Emoji(new String(new int[]{0x1f35b}, 0, 1), R.drawable.emoji_1f35b),
            new Emoji(new String(new int[]{0x1f35c}, 0, 1), R.drawable.emoji_1f35c),
            new Emoji(new String(new int[]{0x1f35d}, 0, 1), R.drawable.emoji_1f35d),
            new Emoji(new String(new int[]{0x1f360}, 0, 1), R.drawable.emoji_1f360),
            new Emoji(new String(new int[]{0x1f362}, 0, 1), R.drawable.emoji_1f362),
            new Emoji(new String(new int[]{0x1f363}, 0, 1), R.drawable.emoji_1f363),
            new Emoji(new String(new int[]{0x1f364}, 0, 1), R.drawable.emoji_1f364),
            new Emoji(new String(new int[]{0x1f365}, 0, 1), R.drawable.emoji_1f365),
            new Emoji(new String(new int[]{0x1f361}, 0, 1), R.drawable.emoji_1f361),
            new Emoji(new String(new int[]{0x1f366}, 0, 1), R.drawable.emoji_1f366),
            new Emoji(new String(new int[]{0x1f367}, 0, 1), R.drawable.emoji_1f367),
            new Emoji(new String(new int[]{0x1f368}, 0, 1), R.drawable.emoji_1f368),
            new Emoji(new String(new int[]{0x1f369}, 0, 1), R.drawable.emoji_1f369),
            new Emoji(new String(new int[]{0x1f36a}, 0, 1), R.drawable.emoji_1f36a),
            new Emoji(new String(new int[]{0x1f382}, 0, 1), R.drawable.emoji_1f382),
            new Emoji(new String(new int[]{0x1f370}, 0, 1), R.drawable.emoji_1f370),
            new Emoji(new String(new int[]{0x1f36b}, 0, 1), R.drawable.emoji_1f36b),
            new Emoji(new String(new int[]{0x1f36c}, 0, 1), R.drawable.emoji_1f36c),
            new Emoji(new String(new int[]{0x1f36d}, 0, 1), R.drawable.emoji_1f36d),
            new Emoji(new String(new int[]{0x1f36e}, 0, 1), R.drawable.emoji_1f36e),
            new Emoji(new String(new int[]{0x1f36f}, 0, 1), R.drawable.emoji_1f36f),
            new Emoji(new String(new int[]{0x1f37c}, 0, 1), R.drawable.emoji_1f37c),
            new Emoji(new String(new int[]{0x1f95b}, 0, 1), R.drawable.emoji_1f95b),
            new Emoji(new String(new int[]{0x2615}, 0, 1), R.drawable.emoji_2615),
            new Emoji(new String(new int[]{0x1f375}, 0, 1), R.drawable.emoji_1f375),
            new Emoji(new String(new int[]{0x1f376}, 0, 1), R.drawable.emoji_1f376),
            new Emoji(new String(new int[]{0x1f37e}, 0, 1), R.drawable.emoji_1f37e),
            new Emoji(new String(new int[]{0x1f377}, 0, 1), R.drawable.emoji_1f377),
            new Emoji(new String(new int[]{0x1f378}, 0, 1), R.drawable.emoji_1f378),
            new Emoji(new String(new int[]{0x1f379}, 0, 1), R.drawable.emoji_1f379),
            new Emoji(new String(new int[]{0x1f37a}, 0, 1), R.drawable.emoji_1f37a),
            new Emoji(new String(new int[]{0x1f37b}, 0, 1), R.drawable.emoji_1f37b),
            new Emoji(new String(new int[]{0x1f942}, 0, 1), R.drawable.emoji_1f942),
            new Emoji(new String(new int[]{0x1f943}, 0, 1), R.drawable.emoji_1f943),
            new Emoji(new String(new int[]{0x1f37d}, 0, 1), R.drawable.emoji_1f37d),
            new Emoji(new String(new int[]{0x1f374}, 0, 1), R.drawable.emoji_1f374),
            new Emoji(new String(new int[]{0x1f944}, 0, 1), R.drawable.emoji_1f944)
    };

    @Override
    @NonNull
    public Emoji[] getEmojis() {
        return DATA;
    }

    @Override
    @DrawableRes
    public int getIcon() {
        return R.drawable.emoji_category_foods;
    }
}
