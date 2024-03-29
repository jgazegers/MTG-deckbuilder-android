package com.example.mtg_deck_builder.decks;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mtg_deck_builder.R;
import com.example.mtg_deck_builder.models.Deck;

public class DeckViewHolder extends RecyclerView.ViewHolder {
    private TextView nameView;
    ImageView imageView;
    public DeckViewHolder(@NonNull View itemView) {
        super(itemView);
        this.nameView = itemView.findViewById(R.id.textViewDeckName);
        this.imageView = itemView.findViewById(R.id.deck_image);
    }

    public void bind(Deck deck) {
        nameView.setText(deck.getName());
    }
}
