package com.vanniktech.emoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.content.res.AppCompatResources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.vanniktech.emoji.emoji.Emoji;
import com.vanniktech.emoji.listeners.OnEmojiClickedListener;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class EmojiArrayAdapter extends ArrayAdapter<Emoji> {
    @Nullable
    final private OnEmojiClickedListener listener;

    @SuppressWarnings("PMD.UseVarargs")
    EmojiArrayAdapter(@NonNull final Context context, @NonNull final Emoji[] emojis,
                      @Nullable OnEmojiClickedListener listener) {
        super(context, 0, toList(emojis));

        this.listener = listener;
    }

    /**
     * we need this because Arrays.asList does not support {@link Collection#clear()}
     */
    @SuppressWarnings("PMD.UseVarargs")
    private static List<Emoji> toList(final Emoji[] emojis) {
        final List<Emoji> list = new ArrayList<>(emojis.length);
        Collections.addAll(list, emojis);
        return list;
    }

    @NonNull
    @Override
    public View getView(final int position, final View convertView, @NonNull final ViewGroup parent) {
        ImageView image = (ImageView) convertView;

        if (image == null) {
            image = (ImageView) LayoutInflater.from(getContext())
                    .inflate(R.layout.emoji_item, parent, false);
        }

        image.setImageDrawable(null);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onEmojiClicked(getItem(position));
                }
            }
        });

        final Emoji emoji = getItem(position);
        ImageDownloaderTask task = (ImageDownloaderTask) image.getTag();

        if (task != null) {
            task.cancel(true);
        }

        task = new ImageDownloaderTask(image);

        image.setTag(task);
        //noinspection ConstantConditions
        task.execute(emoji.getResource());

        return image;
    }

    public void updateEmojis(final Collection<Emoji> emojis) {
        clear();
        addAll(emojis);
        notifyDataSetChanged();
    }

    private static class ImageDownloaderTask extends AsyncTask<Integer, Void, Drawable> {
        private final WeakReference<ImageView> imageViewReference;
        private final WeakReference<Context> contextReference;

        ImageDownloaderTask(final ImageView imageView) {
            imageViewReference = new WeakReference<>(imageView);
            contextReference = new WeakReference<>(imageView.getContext());
        }

        @Override
        protected Drawable doInBackground(final Integer... resource) {
            final Context context = contextReference.get();

            if (context == null) {
                return null;
            } else {
                return AppCompatResources.getDrawable(context, resource[0]);
            }
        }

        @Override
        protected void onPostExecute(final Drawable drawable) {
            if (!isCancelled() && drawable != null) {
                final ImageView imageView = imageViewReference.get();

                if (imageView != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
        }
    }
}
