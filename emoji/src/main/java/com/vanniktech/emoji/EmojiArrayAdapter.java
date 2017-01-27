package com.vanniktech.emoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.content.res.AppCompatResources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.vanniktech.emoji.emoji.Emoji;
import com.vanniktech.emoji.emoji.EmojiProvider;
import com.vanniktech.emoji.emoji.EmojiTree.EmojiInfo;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class EmojiArrayAdapter extends ArrayAdapter<Emoji> {
    @SuppressWarnings("PMD.UseVarargs")
    EmojiArrayAdapter(final Context context, final Emoji[] data) {
        super(context, 0, toList(data));
    }

    /**
     * we need this because Arrays.asList does not support {@link Collection#clear()}
     */
    @SuppressWarnings("PMD.UseVarargs")
    private static List<Emoji> toList(final Emoji[] data) {
        final List<Emoji> list = new ArrayList<>(data.length);
        Collections.addAll(list, data);
        return list;
    }

    @NonNull
    @Override
    public View getView(final int position, final View convertView, @NonNull final ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.emoji_item, parent, false);

            final ViewHolder holder = new ViewHolder();
            holder.icon = (ImageView) view.findViewById(R.id.emoji_image);
            view.setTag(holder);
        }

        final Emoji emoji = getItem(position);
        final ViewHolder holder = (ViewHolder) view.getTag();

        holder.icon.setImageDrawable(null);

        ImageDownloaderTask task = (ImageDownloaderTask) holder.icon.getTag();

        if (task != null) {
            task.cancel(true);
        }

        //noinspection ConstantConditions
        final EmojiInfo emojiInfo = EmojiProvider.getInstance().findEmoji(emoji.getEmoji());

        if (emojiInfo.getResource() != null) {
            task = new ImageDownloaderTask(holder.icon);
            holder.icon.setTag(task);

            task.execute(emojiInfo.getResource());
        }

        return view;
    }

    public void updateEmojis(final Collection<Emoji> emojis) {
        clear();
        addAll(emojis);
        notifyDataSetChanged();
    }

    private static class ViewHolder {
        ImageView icon;
    }

    private static class ImageDownloaderTask extends AsyncTask<Integer, Void, Drawable> {
        private static final SparseArrayCompat<Drawable> CACHE = new SparseArrayCompat<>();

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
                Drawable result = CACHE.get(resource[0]);

                if (result == null) {
                    result = AppCompatResources.getDrawable(context, resource[0]);

                    CACHE.put(resource[0], result);
                }

                return result;
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
