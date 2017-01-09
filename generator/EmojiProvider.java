package com.vanniktech.emoji.emoji;

import android.support.annotation.NonNull;
import android.support.v4.util.Pair;

import com.vanniktech.emoji.R;
import com.vanniktech.emoji.emoji.EmojiTree.EmojiInfo;
<%= imports %>

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("checkstyle:magicnumber")
public final class EmojiProvider {
    private static final EmojiProvider INSTANCE = new EmojiProvider();

    private LinkedHashMap<String, EmojiCategory> categories = new LinkedHashMap<>();
    private EmojiTree emojis = new EmojiTree();

    public static EmojiProvider getInstance() {
        return INSTANCE;
    }

    private EmojiProvider() {
        <%= categoryMapping %>

        <%= codePointMapping %>
    }

    public List<Pair<String, EmojiCategory>> getCategories() {
        final List<Pair<String, EmojiCategory>> result = new ArrayList<>();

        for (Map.Entry<String, EmojiCategory> entry : categories.entrySet()) {
            result.add(new Pair<>(entry.getKey(), entry.getValue()));
        }

        return result;
    }

    @NonNull
    public EmojiInfo findEmoji(@NonNull final CharSequence candiate) {
        return emojis.findEmoji(candiate);
    }
}
