package com.vanniktech.emoji.emoji.category;

import android.support.annotation.DrawableRes;

import com.vanniktech.emoji.R;
import com.vanniktech.emoji.emoji.Emoji;
import com.vanniktech.emoji.emoji.EmojiCategory;

public class FoodCategory implements EmojiCategory {

    private static final Emoji[] DATA = new Emoji[]{
            Emoji.fromCodePoints(0x1f347),
            Emoji.fromCodePoints(0x1f348),
            Emoji.fromCodePoints(0x1f349),
            Emoji.fromCodePoints(0x1f34a),
            Emoji.fromCodePoints(0x1f34b),
            Emoji.fromCodePoints(0x1f34c),
            Emoji.fromCodePoints(0x1f34d),
            Emoji.fromCodePoints(0x1f34e),
            Emoji.fromCodePoints(0x1f34f),
            Emoji.fromCodePoints(0x1f350),
            Emoji.fromCodePoints(0x1f351),
            Emoji.fromCodePoints(0x1f352),
            Emoji.fromCodePoints(0x1f353),
            Emoji.fromCodePoints(0x1f95d),
            Emoji.fromCodePoints(0x1f345),
            Emoji.fromCodePoints(0x1f951),
            Emoji.fromCodePoints(0x1f346),
            Emoji.fromCodePoints(0x1f954),
            Emoji.fromCodePoints(0x1f955),
            Emoji.fromCodePoints(0x1f33d),
            Emoji.fromCodePoints(0x1f336),
            Emoji.fromCodePoints(0x1f952),
            Emoji.fromCodePoints(0x1f95c),
            Emoji.fromCodePoints(0x1f35e),
            Emoji.fromCodePoints(0x1f950),
            Emoji.fromCodePoints(0x1f956),
            Emoji.fromCodePoints(0x1f95e),
            Emoji.fromCodePoints(0x1f9c0),
            Emoji.fromCodePoints(0x1f356),
            Emoji.fromCodePoints(0x1f357),
            Emoji.fromCodePoints(0x1f953),
            Emoji.fromCodePoints(0x1f354),
            Emoji.fromCodePoints(0x1f35f),
            Emoji.fromCodePoints(0x1f355),
            Emoji.fromCodePoints(0x1f32d),
            Emoji.fromCodePoints(0x1f32e),
            Emoji.fromCodePoints(0x1f32f),
            Emoji.fromCodePoints(0x1f959),
            Emoji.fromCodePoints(0x1f95a),
            Emoji.fromCodePoints(0x1f373),
            Emoji.fromCodePoints(0x1f958),
            Emoji.fromCodePoints(0x1f372),
            Emoji.fromCodePoints(0x1f957),
            Emoji.fromCodePoints(0x1f37f),
            Emoji.fromCodePoints(0x1f371),
            Emoji.fromCodePoints(0x1f358),
            Emoji.fromCodePoints(0x1f359),
            Emoji.fromCodePoints(0x1f35a),
            Emoji.fromCodePoints(0x1f35b),
            Emoji.fromCodePoints(0x1f35c),
            Emoji.fromCodePoints(0x1f35d),
            Emoji.fromCodePoints(0x1f360),
            Emoji.fromCodePoints(0x1f362),
            Emoji.fromCodePoints(0x1f363),
            Emoji.fromCodePoints(0x1f364),
            Emoji.fromCodePoints(0x1f365),
            Emoji.fromCodePoints(0x1f361),
            Emoji.fromCodePoints(0x1f366),
            Emoji.fromCodePoints(0x1f367),
            Emoji.fromCodePoints(0x1f368),
            Emoji.fromCodePoints(0x1f369),
            Emoji.fromCodePoints(0x1f36a),
            Emoji.fromCodePoints(0x1f382),
            Emoji.fromCodePoints(0x1f370),
            Emoji.fromCodePoints(0x1f36b),
            Emoji.fromCodePoints(0x1f36c),
            Emoji.fromCodePoints(0x1f36d),
            Emoji.fromCodePoints(0x1f36e),
            Emoji.fromCodePoints(0x1f36f),
            Emoji.fromCodePoints(0x1f37c),
            Emoji.fromCodePoints(0x1f95b),
            Emoji.fromCodePoints(0x2615),
            Emoji.fromCodePoints(0x1f375),
            Emoji.fromCodePoints(0x1f376),
            Emoji.fromCodePoints(0x1f37e),
            Emoji.fromCodePoints(0x1f377),
            Emoji.fromCodePoints(0x1f378),
            Emoji.fromCodePoints(0x1f379),
            Emoji.fromCodePoints(0x1f37a),
            Emoji.fromCodePoints(0x1f37b),
            Emoji.fromCodePoints(0x1f942),
            Emoji.fromCodePoints(0x1f943),
            Emoji.fromCodePoints(0x1f37d),
            Emoji.fromCodePoints(0x1f374),
            Emoji.fromCodePoints(0x1f944)
    };

    @Override
    public Emoji[] getData() {
        return DATA;
    }

    @Override
    @DrawableRes
    public int getIcon() {
        return R.drawable.emoji_category_food;
    }
}
