package com.vanniktech.emoji.sample;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.vanniktech.emoji.EmojiEditText;
import com.vanniktech.emoji.EmojiManager;
import com.vanniktech.emoji.EmojiPopup;
import com.vanniktech.emoji.google.GoogleEmojiProvider;
import com.vanniktech.emoji.ios.IosEmojiProvider;
import com.vanniktech.emoji.one.EmojiOneProvider;

public class MainActivity extends AppCompatActivity {
  static final String TAG = "MainActivity";

  ChatAdapter chatAdapter;
  EmojiPopup emojiPopup;

  EmojiEditText editText;
  ViewGroup rootView;
  ImageView emojiButton;

  @Override protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);

    chatAdapter = new ChatAdapter();

    editText = (EmojiEditText) findViewById(R.id.main_activity_chat_bottom_message_edittext);
    rootView = (ViewGroup) findViewById(R.id.main_activity_root_view);
    emojiButton = (ImageView) findViewById(R.id.main_activity_emoji);
    final ImageView sendButton = (ImageView) findViewById(R.id.main_activity_send);

    emojiButton.setColorFilter(ContextCompat.getColor(this, R.color.emoji_icons), PorterDuff.Mode.SRC_IN);
    sendButton.setColorFilter(ContextCompat.getColor(this, R.color.emoji_icons), PorterDuff.Mode.SRC_IN);

    emojiButton.setOnClickListener(v -> emojiPopup.toggle());
    sendButton.setOnClickListener(v -> {
      final String text = editText.getText().toString().trim();

      if (text.length() > 0) {
        chatAdapter.add(text);

        editText.setText("");
      }
    });

    final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_activity_recycler_view);
    recyclerView.setAdapter(chatAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    setUpEmojiPopup();
  }

  @Override public boolean onCreateOptionsMenu(final Menu menu) {
    getMenuInflater().inflate(R.menu.activity_main, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override public boolean onOptionsItemSelected(final MenuItem item) {
    switch (item.getItemId()) {
      case R.id.show_dialog:
        MainDialog.show(this);
        return true;
      case R.id.variantIos:
        EmojiManager.install(new IosEmojiProvider());
        recreate();
        return true;
      case R.id.variantGoogle:
        EmojiManager.install(new GoogleEmojiProvider());
        recreate();
        return true;
      case R.id.variantEmojiOne:
        EmojiManager.install(new EmojiOneProvider());
        recreate();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  @Override public void onBackPressed() {
    if (emojiPopup != null && emojiPopup.isShowing()) {
      emojiPopup.dismiss();
    } else {
      super.onBackPressed();
    }
  }

  @Override protected void onStop() {
    if (emojiPopup != null) {
      emojiPopup.dismiss();
    }

    super.onStop();
  }

  private void setUpEmojiPopup() {
    emojiPopup = EmojiPopup.Builder.fromRootView(rootView)
        .setOnEmojiBackspaceClickListener(v -> Log.d(TAG, "Clicked on Backspace"))
        .setOnEmojiClickedListener(emoji -> Log.d(TAG, "Clicked on emoji"))
        .setOnEmojiPopupShownListener(() -> emojiButton.setImageResource(R.drawable.ic_keyboard))
        .setOnSoftKeyboardOpenListener(keyBoardHeight -> Log.d(TAG, "Opened soft keyboard"))
        .setOnEmojiPopupDismissListener(() -> emojiButton.setImageResource(R.drawable.emoji_ios_category_people))
        .setOnSoftKeyboardCloseListener(() -> Log.d(TAG, "Closed soft keyboard"))
        .build(editText);
  }
}
