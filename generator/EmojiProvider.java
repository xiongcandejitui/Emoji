package com.vanniktech.emoji.emoji;

import android.support.annotation.NonNull;
import android.support.v4.util.Pair;

import com.vanniktech.emoji.EmojiTree;
import com.vanniktech.emoji.EmojiTree.EmojiInfo;
import com.vanniktech.emoji.R;
<%= imports %>

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class EmojiProvider {

    private static EmojiProvider INSTANCE = new EmojiProvider();

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
        List<Pair<String, EmojiCategory>> result = new ArrayList<>();

        for (Map.Entry<String, EmojiCategory> entry : categories.entrySet()) {
            result.add(new Pair<>(entry.getKey(), entry.getValue()));
        }

        return result;
    }

    @NonNull
    public EmojiInfo findEmoji(@NonNull CharSequence candiate){
        return emojis.findEmoji(candiate);
    }
}
