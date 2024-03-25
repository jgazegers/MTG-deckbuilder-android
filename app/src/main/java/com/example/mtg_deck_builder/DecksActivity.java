package com.example.mtg_deck_builder;

import android.os.Bundle;
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
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, deckNames);
        lvDecks.setAdapter(adapter);
    }
}