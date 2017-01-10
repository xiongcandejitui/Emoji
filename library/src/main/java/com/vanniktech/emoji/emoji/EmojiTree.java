package com.vanniktech.emoji.emoji;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.util.SparseArrayCompat;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class EmojiTree {
    private final EmojiNode root = new EmojiNode(null);

    public void add(@NonNull final String unicode, @DrawableRes final int resource) {
        EmojiNode current = root;

        for (int i = 0; i < unicode.length(); i++) {
            current = current.append(unicode.charAt(i), i == unicode.length() - 1 ? resource : null);
        }
    }

    @NonNull
    public EmojiInfo findEmoji(final @NonNull CharSequence candidate) {
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

        if (current == null) {
            return new EmojiInfo(previous.getResource(), i);
        } else {
            return new EmojiInfo(current.getResource(), i);
        }
    }

    public static class EmojiInfo {
        private final Integer resource;
        private final int length;

        EmojiInfo(@Nullable @DrawableRes final Integer resource, final int length) {
            this.resource = resource;
            this.length = length;
        }

        @DrawableRes
        @Nullable
        public Integer getResource() {
            return resource;
        }

        public int getLength() {
            return length;
        }
    }

    private static class EmojiNode {
        private final SparseArrayCompat<EmojiNode> children = new SparseArrayCompat<>();
        private Integer resource;

        EmojiNode(@Nullable @DrawableRes final Integer resource) {
            this.resource = resource;
        }

        @Nullable
        public EmojiNode getChild(final char child) {
            return children.get(child);
        }

        @Nullable
        @DrawableRes
        public Integer getResource() {
            return resource;
        }

        public void setResource(@DrawableRes final Integer resource) {
            this.resource = resource;
        }

        @NonNull
        public EmojiNode append(final char child, @Nullable @DrawableRes final Integer newResource) {
            EmojiNode existing = children.get(child);

            if (existing == null) {
                existing = new EmojiNode(newResource);

                children.put(child, existing);
            }

            if (newResource != null) {
                existing.setResource(newResource);
            }

            return existing;
        }
    }
}
