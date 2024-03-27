package com.example.mtg_deck_builder.decks;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mtg_deck_builder.R;
import com.example.mtg_deck_builder.models.Deck;

public class DeckViewHolder extends RecyclerView.ViewHolder {
    private TextView nameView;
    public DeckViewHolder(@NonNull View itemView) {
        super(itemView);
        this.nameView = itemView.findViewById(R.id.textViewDeckName);
    }

    public void bind(Deck deck) {
        nameView.setText(deck.getName());
    }
}
