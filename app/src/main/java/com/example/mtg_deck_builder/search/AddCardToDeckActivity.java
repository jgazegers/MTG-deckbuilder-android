package com.example.mtg_deck_builder.search;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mtg_deck_builder.R;
import com.example.mtg_deck_builder.models.Card;
import com.example.mtg_deck_builder.models.Deck;

public class AddCardToDeckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card_to_deck);
        Card card = (Card) getIntent().getSerializableExtra("card");

        Bundle bundle = new Bundle();
        bundle.putSerializable("card", card);
        SelectDeckFragment fragment = new SelectDeckFragment();
        fragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.select_deck_fragment, fragment)
                .commit();
    }

    public void addNewDeck(String newDeckName) {
        SelectDeckFragment selectDeckFragment = (SelectDeckFragment) getSupportFragmentManager().findFragmentById(R.id.select_deck_fragment);
        if (selectDeckFragment != null) {
            selectDeckFragment.addDeckToList(new Deck(newDeckName));
        }
    }
}
