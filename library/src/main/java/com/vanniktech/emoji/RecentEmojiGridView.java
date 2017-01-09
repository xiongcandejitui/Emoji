package com.vanniktech.emoji;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;

import com.vanniktech.emoji.emoji.Emoji;
import com.vanniktech.emoji.listeners.OnEmojiClickedListener;

import java.util.Collection;

final class RecentEmojiGridView extends EmojiGridView {
    private RecentEmoji recentEmojis;

    RecentEmojiGridView(@NonNull final Context context) {
        super(context);
    }

    public RecentEmojiGridView init(@Nullable final OnEmojiClickedListener onEmojiClickedListener, final RecentEmoji recentEmoji) {
        this.recentEmojis = recentEmoji;

        final Collection<Emoji> emojis = recentEmojis.getRecentEmojis();
        emojiArrayAdapter = new EmojiArrayAdapter(getContext(), emojis.toArray(new Emoji[emojis.size()]));
        this.setAdapter(emojiArrayAdapter);

        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(onEmojiClickedListener != null) {
                    onEmojiClickedListener.onEmojiClicked(emojiArrayAdapter.getItem(position));
                }
            }
        });

        return this;
    }

    public void invalidateEmojis() {
        emojiArrayAdapter.updateEmojis(recentEmojis.getRecentEmojis());
    }

    public int numberOfRecentEmojis() {
        return emojiArrayAdapter.getCount();
    }
}
