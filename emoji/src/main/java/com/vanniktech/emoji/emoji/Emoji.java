package com.vanniktech.emoji.emoji;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import java.io.Serializable;

public final class Emoji implements Serializable {
    private static final long serialVersionUID = 2L;

    @NonNull
    private final String unicode;
    @DrawableRes
    private final int resource;

    public Emoji(@NonNull final String unicode, @DrawableRes final int resource) {
        this.unicode = unicode;
        this.resource = resource;
    }

    @NonNull
    public String getUnicode() {
        return unicode;
    }

    @DrawableRes
    public int getResource() {
        return resource;
    }

    public int getLength() {
        return unicode.length();
    }

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Emoji emoji = (Emoji) o;

        if (resource != emoji.resource) return false;
        return unicode.equals(emoji.unicode);
    }

    @Override
    public int hashCode() {
        int result = unicode.hashCode();
        result = 31 * result + resource;
        return result;
    }
}
