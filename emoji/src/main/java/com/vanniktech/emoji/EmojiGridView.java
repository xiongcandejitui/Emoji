package com.vanniktech.emoji;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.vanniktech.emoji.emoji.EmojiCategory;
import com.vanniktech.emoji.listeners.OnEmojiClickedListener;

class EmojiGridView extends GridView {
    protected EmojiArrayAdapter emojiArrayAdapter;

    EmojiGridView(final Context context) {
        super(context);

        final int width = getResources().getDimensionPixelSize(R.dimen.emoji_grid_view_column_width);
        final int spacing = getResources().getDimensionPixelSize(R.dimen.emoji_grid_view_spacing);

        setColumnWidth(width);
        setHorizontalSpacing(spacing);
        setVerticalSpacing(spacing);
        setPadding(spacing, spacing, spacing, spacing);
        setNumColumns(AUTO_FIT);
        setClipToPadding(false);
    }

    public EmojiGridView init(final @Nullable OnEmojiClickedListener onEmojiClickedListener,
                     final @NonNull EmojiCategory category) {
        emojiArrayAdapter = new EmojiArrayAdapter(getContext(), category.getData());
        this.setAdapter(emojiArrayAdapter);

        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
                if (onEmojiClickedListener != null) {
                    onEmojiClickedListener.onEmojiClicked(emojiArrayAdapter.getItem(position));
                }
            }
        });

        return this;
    }
}
