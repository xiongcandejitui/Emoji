package com.vanniktech.emoji.emoji;

import android.support.v4.util.Pair;

<%= imports %>

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class EmojiCategories {

    private static final LinkedHashMap<String, EmojiCategory> categories;

    static {
        categories = new LinkedHashMap<>();

        <%= mapping %>
    }

    protected EmojiCategories() {

    }

    public static List<Pair<String, EmojiCategory>> getCategories() {
        List<Pair<String, EmojiCategory>> result = new ArrayList<>();

        for (Map.Entry<String, EmojiCategory> entry : categories.entrySet()) {
            result.add(new Pair<>(entry.getKey(), entry.getValue()));
        }

        return result;
    }

}
