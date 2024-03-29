package com.example.mtg_deck_builder.decks;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mtg_deck_builder.R;
import com.example.mtg_deck_builder.models.Deck;
import com.example.mtg_deck_builder.search.SearchCardViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DeckAdapter extends RecyclerView.Adapter<DeckViewHolder> {

    private List<Deck> decks;
    private OnItemClickListener listener;

    public DeckAdapter(List<Deck> decks, OnItemClickListener listener) {
        this.decks = decks;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(Deck deck);
    }

    @NonNull
    @Override
    public DeckViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_deck, parent, false);
        return new DeckViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DeckViewHolder holder, int position) {
        Deck deck = decks.get(position);
        holder.bind(deck);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(deck);
            }
        });


        if (deck.getImage() != null) {
            if(ContextCompat.checkSelfPermission(holder.itemView.getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                holder.imageView.setImageURI(deck.getImage());
                Picasso.get().load(deck.getImage()).into(holder.imageView);
            }

        } else {
            // Placeholder or default image if no image is available
            holder.imageView.setImageResource(R.drawable.ic_launcher_background);
        }
    }





    @Override
    public int getItemCount() {
        if(decks != null) {
            return decks.size();
        }
        return 0;
    }
}