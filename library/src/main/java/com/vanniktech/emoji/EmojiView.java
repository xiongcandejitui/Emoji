package com.vanniktech.emoji;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.vanniktech.emoji.emoji.Emoji;
import com.vanniktech.emoji.emoji.EmojiCategories;
import com.vanniktech.emoji.emoji.EmojiCategory;
import com.vanniktech.emoji.listeners.OnEmojiBackspaceClickListener;
import com.vanniktech.emoji.listeners.OnEmojiClickedListener;
import com.vanniktech.emoji.listeners.RepeatListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressLint("ViewConstructor")
final class EmojiView extends LinearLayout implements ViewPager.OnPageChangeListener {

    private static final long INITIAL_INTERVAL = TimeUnit.SECONDS.toMillis(1) / 2;
    private static final int NORMAL_INTERVAL = 50;

    @ColorInt private final int themeAccentColor;
    @ColorInt private final int themeIconColor;

    private final ImageButton[] emojiTabs;

    @Nullable OnEmojiBackspaceClickListener onEmojiBackspaceClickListener;

    private int emojiTabLastSelectedIndex = -1;
    private RecentEmojiGridView recentGridView;

    EmojiView(final Context context, final OnEmojiClickedListener onEmojiClickedListener, @NonNull final RecentEmoji recentEmoji) {
        super(context);

        View.inflate(context, R.layout.emoji_view, this);

        setOrientation(VERTICAL);
        setBackgroundColor(ContextCompat.getColor(context, R.color.emoji_background));

        themeIconColor = ContextCompat.getColor(context, R.color.emoji_icons);

        final TypedValue value = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorAccent, value, true);
        themeAccentColor = value.data;

        final ViewPager emojisPager = (ViewPager) findViewById(R.id.emojis_pager);
        emojisPager.addOnPageChangeListener(this);

        final List<Pair<String, EmojiCategory>> categories = EmojiCategories.getCategories();

        emojiTabs = new ImageButton[categories.size() + 2];

        for (int i = 0; i < categories.size(); i++) {
            emojiTabs[i + 1] = inflateButton(context, categories.get(i).second.getIcon());
        }

        emojiTabs[0] = inflateButton(context, R.drawable.emoji_recent);
        emojiTabs[emojiTabs.length - 1] = inflateButton(context, R.drawable.emoji_backspace_back_normal);

        final ViewGroup emojisTab = (ViewGroup) findViewById(R.id.emojis_tab);

        for (ImageButton emojiTab : emojiTabs) {
            emojisTab.addView(emojiTab);
        }

        handleOnClicks(emojisPager);

        final List<? extends View> views = getViews(context, onEmojiClickedListener, recentEmoji);
        final EmojiPagerAdapter emojisAdapter = new EmojiPagerAdapter(views);
        emojisPager.setAdapter(emojisAdapter);

        final int startIndex = recentGridView.numberOfRecentEmojis() > 0 ? 0 : 1;
        emojisPager.setCurrentItem(startIndex);
        onPageSelected(startIndex);
    }

    private void handleOnClicks(final ViewPager emojisPager) {
        for (int i = 0; i < emojiTabs.length - 1; i++) {
            emojiTabs[i].setOnClickListener(new EmojiTabsClickListener(emojisPager, i));
        }

        emojiTabs[emojiTabs.length - 1].setOnTouchListener(new RepeatListener(INITIAL_INTERVAL, NORMAL_INTERVAL, new OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (onEmojiBackspaceClickListener != null) {
                    onEmojiBackspaceClickListener.onEmojiBackspaceClicked(view);
                }
            }
        }));
    }

    public void setOnEmojiBackspaceClickListener(@Nullable final OnEmojiBackspaceClickListener onEmojiBackspaceClickListener) {
        this.onEmojiBackspaceClickListener = onEmojiBackspaceClickListener;
    }

    private ImageButton inflateButton(final Context context, @DrawableRes int icon) {
        final ImageButton button = (ImageButton) View.inflate(context, R.layout.emoji_category, null);

        button.setImageDrawable(ContextCompat.getDrawable(context, icon));
        button.setColorFilter(themeIconColor, PorterDuff.Mode.SRC_IN);

        return button;
    }

    @NonNull
    private List<? extends View> getViews(final Context context, @Nullable final OnEmojiClickedListener onEmojiClickedListener, @NonNull final RecentEmoji recentEmoji) {
        recentGridView = new RecentEmojiGridView(context).init(onEmojiClickedListener, recentEmoji);

        final List<EmojiGridView> result = new ArrayList<>();

        result.add(recentGridView);
        for (Pair<String, EmojiCategory> category : EmojiCategories.getCategories()) {
            result.add(createGridView(context, category.second.getData(), onEmojiClickedListener));
        }

        return result;
    }

    private EmojiGridView createGridView(@NonNull final Context context, final Emoji[] emojis, @Nullable final OnEmojiClickedListener onEmojiClickedListener) {
        final EmojiGridView emojiGridView = new EmojiGridView(context);
        final EmojiArrayAdapter emojiArrayAdapter = new EmojiArrayAdapter(getContext(), emojis);
        emojiArrayAdapter.setOnEmojiClickedListener(onEmojiClickedListener);
        emojiGridView.setAdapter(emojiArrayAdapter);
        return emojiGridView;
    }

    @Override
    public void onPageSelected(final int i) {
        if (emojiTabLastSelectedIndex != i) {
            if (i == 0) {
                recentGridView.invalidateEmojis();
            }

            if (emojiTabLastSelectedIndex >= 0 && emojiTabLastSelectedIndex < emojiTabs.length) {
                emojiTabs[emojiTabLastSelectedIndex].setSelected(false);
                emojiTabs[emojiTabLastSelectedIndex].setColorFilter(themeIconColor, PorterDuff.Mode.SRC_IN);
            }

            emojiTabs[i].setSelected(true);
            emojiTabs[i].setColorFilter(themeAccentColor, PorterDuff.Mode.SRC_IN);

            emojiTabLastSelectedIndex = i;
        }
    }

    @Override
    public void onPageScrolled(final int i, final float v, final int i2) {
        // Don't care
    }

    @Override
    public void onPageScrollStateChanged(final int i) {
        // Don't care
    }

    static class EmojiTabsClickListener implements OnClickListener {
        private final ViewPager emojisPager;
        private final int position;

        EmojiTabsClickListener(final ViewPager emojisPager, final int position) {
            this.emojisPager = emojisPager;
            this.position = position;
        }

        @Override
        public void onClick(final View v) {
            emojisPager.setCurrentItem(position);
        }
    }
}
