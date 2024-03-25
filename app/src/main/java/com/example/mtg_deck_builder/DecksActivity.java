package com.example.mtg_deck_builder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class DecksActivity extends AppCompatActivity {

    private ListView lvDecks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decks);

        lvDecks = findViewById(R.id.lvDecks);

        // Dummy data for demonstration
        String[] deckNames = {"Deck 1", "Deck 2", "Deck 3", "Deck 4", "Deck 5"};

        // Adapter to populate list view with deck names
        ArrayAdapter<String> arrayadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, deckNames);
        lvDecks.setAdapter(arrayadapter);

        // Set click listener for list view items
        lvDecks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Start DeckViewActivity when a deck is clicked
                Intent intent = new Intent(DecksActivity.this, DeckViewActivity.class);
                startActivity(intent);
            }
        });

        // Adapter to populate list view with deck names
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, deckNames);
        lvDecks.setAdapter(adapter);
    }
}