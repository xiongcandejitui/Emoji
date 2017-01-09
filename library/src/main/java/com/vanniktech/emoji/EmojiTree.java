package com.vanniktech.emoji;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

public class EmojiTree {

    private EmojiNode root = new EmojiNode(null);

    public void add(@NonNull String unicode, @DrawableRes int resource) {
        EmojiNode current = root;

        for (int i = 0; i < unicode.length(); i++) {
            current = current.append(unicode.charAt(i), i == unicode.length() - 1 ? resource : null);
        }
    }

    @Nullable
    public EmojiInfo findEmoji(CharSequence candidate) {
        EmojiNode previous = root;
        EmojiNode current = root;
        int i = 0;

        for (; i < candidate.length(); i++) {
            previous = current;
            current = current.getChild(candidate.charAt(i));

            if (current == null) {
                break;
            }
        }

        if(current == null){
            return previous.getResource() == null ? null : new EmojiInfo(previous.getResource(), i);
        }else{
            return current.getResource() == null ? null : new EmojiInfo(current.getResource(), i);
        }
    }

    public static class EmojiInfo {

        private int resource;
        private int length;

        public EmojiInfo(@DrawableRes int resource, int length) {
            this.resource = resource;
            this.length = length;
        }

        @DrawableRes
        public int getResource() {
            return resource;
        }

        public int getLength() {
            return length;
        }
    }

    private static class EmojiNode {
        private Map<Character, EmojiNode> children = new LinkedHashMap<>();
        private Integer resource;

        public EmojiNode(@Nullable @DrawableRes Integer resource) {
            this.resource = resource;
        }

        @Nullable
        public EmojiNode getChild(char child) {
            return children.get(child);
        }

        @Nullable
        @DrawableRes
        public Integer getResource() {
            return resource;
        }

        @NonNull
        public EmojiNode append(char child, @Nullable @DrawableRes Integer resource) {
            EmojiNode existing = children.get(child);

            if (existing == null) {
                existing = new EmojiNode(resource);

                children.put(child, existing);
            }

            return existing;
        }
    }
}
