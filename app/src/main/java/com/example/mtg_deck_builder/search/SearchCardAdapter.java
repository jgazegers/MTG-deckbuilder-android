package com.example.mtg_deck_builder.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mtg_deck_builder.R;
import com.example.mtg_deck_builder.models.Card;

import java.util.List;

public class SearchCardAdapter extends RecyclerView.Adapter<SearchCardViewHolder> {

    private List<Card> cards;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Card card);
    }

    public SearchCardAdapter(List<Card> cards, OnItemClickListener listener) {
        this.cards = cards;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SearchCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_card_item, parent, false);
        return new SearchCardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchCardViewHolder holder, int position) {
        Card card = cards.get(position);
        holder.bind(card);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(card);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
}
