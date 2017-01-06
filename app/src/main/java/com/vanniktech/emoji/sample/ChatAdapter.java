package com.vanniktech.emoji.sample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
    private final List<String> texts = new ArrayList<>();

    @Override
    public ChatViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new ChatViewHolder(layoutInflater.inflate(R.layout.adapter_chat, parent, false));
    }

    @Override
    public void onBindViewHolder(final ChatViewHolder chatViewHolder, final int position) {
        final String text = texts.get(position);
        chatViewHolder.textView.setText(text);
    }

    @Override
    public int getItemCount() {
        return texts.size();
    }

    public void add(final String text) {
        texts.add(text);
        this.notifyDataSetChanged();
    }

    static class ChatViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        ChatViewHolder(final View view) {
            super(view);

            textView = (TextView) view.findViewById(R.id.adapter_chat_text_view);
        }
    }
}
