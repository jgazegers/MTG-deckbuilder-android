package com.example.mtg_deck_builder.search;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mtg_deck_builder.R;
import com.example.mtg_deck_builder.models.Card;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class SearchCardViewHolder extends RecyclerView.ViewHolder {
    private ImageView cardImage;
    private TextView name;
    private TextView type;
    private TextView power;
    private TextView toughness;


    public SearchCardViewHolder(@NonNull View itemView) {
        super(itemView);
        cardImage = itemView.findViewById(R.id.card_image);
        name = itemView.findViewById(R.id.card_name);
        type = itemView.findViewById(R.id.card_type);
        power = itemView.findViewById(R.id.card_power);
        toughness = itemView.findViewById(R.id.card_toughness);
    }

    public void bind(Card card) {
        Picasso.get().load(card.getImages().getNormal()).into(cardImage);
        name.setText(card.getName());
        type.setText("Type: " + card.getTypeLine());
        power.setText("Power: " + card.getPower());
        toughness.setText("Toughness: " + card.getToughness());


    }
}
