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


    public SearchCardViewHolder(@NonNull View itemView) {
        super(itemView);
        cardImage = itemView.findViewById(R.id.card_image);
        name = itemView.findViewById(R.id.card_name);
    }

    public void bind(Card card) {
        Picasso.get().load(card.getImages().getNormal()).into(cardImage);

        name.setText("something");
    }
}
