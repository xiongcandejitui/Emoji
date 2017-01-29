package com.vanniktech.emoji;

import android.support.annotation.NonNull;

import com.vanniktech.emoji.emoji.Emoji;
import com.vanniktech.emoji.emoji.EmojiCategory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Config(sdk = 21, constants = BuildConfig.class)
@RunWith(RobolectricTestRunner.class)
public class EmojiViewTest {
    private EmojiView emojiView;
    private RecentEmoji recentEmoji;

    @Before
    public void setUp() {
        EmojiManager.install(new EmojiProvider() {
            @NonNull
            @Override
            public Map<String, EmojiCategory> getCategories() {
                final HashMap<String, EmojiCategory> result = new HashMap<>();

                result.put("Mock", new EmojiCategory() {
                    @NonNull
                    @Override
                    public Emoji[] getEmojis() {
                        return new Emoji[]{new Emoji(0x123, R.drawable.emoji_recent)};
                    }

                    @Override
                    public int getIcon() {
                        return R.drawable.emoji_recent;
                    }
                });

                return result;
            }
        });

        recentEmoji = mock(RecentEmoji.class);
        emojiView = new EmojiView(RuntimeEnvironment.application, null, recentEmoji);
    }

    @Test
    public void onPageSelectedRecentShouldUpdateRecentEmojis() {
        verify(recentEmoji, times(1)).getRecentEmojis(); // During init phase it is called

        emojiView.onPageSelected(2);
        verify(recentEmoji, times(1)).getRecentEmojis(); // Should not be called again

        emojiView.onPageSelected(0);
        verify(recentEmoji, times(2)).getRecentEmojis(); // Should be to update view

        emojiView.onPageSelected(0);
        verify(recentEmoji, times(2)).getRecentEmojis(); // Should not update again
    }
}
