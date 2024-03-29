package com.example.mtg_deck_builder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mtg_deck_builder.models.Deck;
import com.example.mtg_deck_builder.models.DeckCard;
import com.example.mtg_deck_builder.search.SearchActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DeckViewActivity extends AppCompatActivity implements DeckCardAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private TextView txtHeader;
    private DeckCardAdapter adapter;
    private List<DeckCard> deckCards;
    private List<Deck> decks;
    private int deckIndex;
    private Deck deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_view);

        decks = Deck.getListFromUserDefaults(this);
        deck = (Deck) getIntent().getSerializableExtra("deck");
        // Retrieve deck card data from Intent extras
        deckCards = deck.getCards();

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        txtHeader = findViewById(R.id.header_text);
        txtHeader.setText(deck.getName());

        // Create and set adapter
        adapter = new DeckCardAdapter(deckCards, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        decks = Deck.getListFromUserDefaults(this);
        //How do I get a new deck?
        deck = (Deck) getIntent().getSerializableExtra("deck");
        UUID deckID = deck.getId();
        Optional<Deck> temp = decks.stream().filter(deck -> deck.getId().equals(deckID)).findFirst();
        deck = temp.orElse(null);

        // Retrieve deck card data from Intent extras
        deckCards = deck.getCards();

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            this.decks = (List<Deck>) data.getSerializableExtra("decks");

            this.deck = (Deck) getIntent().getSerializableExtra("deck");
            UUID deckID = deck.getId();
            Optional<Deck> temp = decks.stream().filter(deck -> deck.getId().equals(deckID)).findFirst();
            this.deck = temp.orElse(null);

            // Retrieve deck card data from Intent extras
            this.deckCards = deck.getCards();

            adapter.notifyDataSetChanged(); // Update RecyclerView with new data
        }
    }


    @Override
    public void onItemClick(DeckCard card) {
        Intent intent = new Intent(DeckViewActivity.this, DeckCardDetailsActivity.class);
        intent.putExtra("currentDeck", deck);
        intent.putExtra("currentCard", card);
        startActivityForResult(intent, 1);
    }


}