package com.example.mtg_deck_builder.decks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mtg_deck_builder.DeckViewActivity;
import com.example.mtg_deck_builder.R;
import com.example.mtg_deck_builder.models.Deck;

import java.util.ArrayList;
import java.util.List;

public class DecksActivity extends AppCompatActivity implements DeckAdapter.OnItemClickListener {

    private RecyclerView recyclerViewDecks;
    private List<Deck> decks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decks);

        decks = Deck.getListFromUserDefaults(this);

        recyclerViewDecks = findViewById(R.id.decks_list);
        DeckAdapter adapter = new DeckAdapter(decks, this);
        recyclerViewDecks.setAdapter(adapter);
        recyclerViewDecks.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClick(Deck deck) {
        Intent intent = new Intent(this, DeckViewActivity.class);
        intent.putExtra("deck", deck);
        startActivity(intent);
    }
}