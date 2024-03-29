package com.example.mtg_deck_builder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mtg_deck_builder.models.Card;
import com.example.mtg_deck_builder.models.DeckCard;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DeckCardAdapter extends RecyclerView.Adapter<DeckCardAdapter.DeckCardViewHolder> {

    private List<DeckCard> deckCardList;
    private OnItemClickListener onItemClickListener;

    public DeckCardAdapter(List<DeckCard> deckCardList, OnItemClickListener onItemClickListener) {
        this.deckCardList = deckCardList;
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(DeckCard card);
    }

    @NonNull
    @Override
    public DeckCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_layout, parent, false);
        return new DeckCardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DeckCardViewHolder holder, int position) {
        DeckCard currentDeckCard = deckCardList.get(position);
        Card card = currentDeckCard.getCard();

        boolean showImages = PreferenceManager.getDefaultSharedPreferences(holder.itemView.getContext())
                .getBoolean("showImages", true);

        if (showImages) {
            Picasso.get().load(card.getImages().getNormal()).into(holder.cardImage);
        } else {
            holder.cardImage.setVisibility(View.INVISIBLE);
        }


        holder.cardName.setText(card.getName());
        holder.cardQuantity.setText("Quantity: " + currentDeckCard.getAmount());
        holder.cardComment.setText(currentDeckCard.getComment());
        holder.itemView.setOnClickListener(view -> {
            onItemClickListener.onItemClick(currentDeckCard);
        });
    }

    @Override
    public int getItemCount() {
        return deckCardList.size();
    }

    public static class DeckCardViewHolder extends RecyclerView.ViewHolder {
        public ImageView cardImage;
        public TextView cardName;
        public TextView cardQuantity;
        public TextView cardComment;

        public DeckCardViewHolder(View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.card_image);
            cardName = itemView.findViewById(R.id.card_name);
            cardQuantity = itemView.findViewById(R.id.card_quantity);
            cardComment = itemView.findViewById(R.id.card_comment);
        }
    }
}