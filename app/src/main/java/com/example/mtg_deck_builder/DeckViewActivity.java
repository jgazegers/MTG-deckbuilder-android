package com.example.mtg_deck_builder;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mtg_deck_builder.models.DeckCard;

import java.util.List;

public class DeckViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DeckCardAdapter adapter;
    private List<DeckCard> deckCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_view);

        // Retrieve deck card data from Intent extras
        deckCards = DeckCard.getTestData();

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create and set adapter
        adapter = new DeckCardAdapter(deckCards);
        recyclerView.setAdapter(adapter);
    }
}