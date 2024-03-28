package com.example.mtg_deck_builder.search;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mtg_deck_builder.R;
import com.example.mtg_deck_builder.models.Card;
import com.example.mtg_deck_builder.models.Deck;

import java.util.ArrayList;
import java.util.List;

public class SelectDeckFragment extends Fragment {


    private ListView listView;
    private EditText numberInput;
    private ArrayAdapter<Deck> adapter;
    private List<Deck> deckList;
    private Card card;

    public SelectDeckFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Load the list of decks from SharedPreferences
        deckList = Deck.getListFromUserDefaults(getContext());
        if (deckList == null) {
            deckList = new ArrayList<>();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.card = (Card) getArguments().getSerializable("card");

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select_deck, container, false);

        listView = view.findViewById(R.id.listView);

        numberInput = view.findViewById(R.id.numberInput);

        // Set up adapter
        adapter = new DeckAdapter(getContext(), deckList);
        listView.setAdapter(adapter);

        // Set item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Deck selectedDeck = deckList.get(position);
                if (selectedDeck == null) return;

                String inputString = numberInput.getText().toString();
                if (inputString.isEmpty()) return;

                int inputInt = Integer.parseInt(inputString);

                selectedDeck.addCard(card, inputInt);
                Deck.saveList(deckList, getContext());

            }
        });

        return view;
    }

    // Method to add a deck to the list
    public void addDeckToList(Deck deck) {
        deckList.add(deck);
        adapter.notifyDataSetChanged();
        // Save the updated list to SharedPreferences
        Deck.saveList(deckList, getContext());
    }

    private static class DeckAdapter extends ArrayAdapter<Deck> {
        private List<Deck> decks;

        public DeckAdapter(@NonNull Context context, List<Deck> decks) {
            super(context, 0, decks);
            this.decks = decks;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            }

            // Get the deck at the current position
            Deck deck = decks.get(position);

            // Set the name of the deck as the text for the list item
            if (deck != null) {
                TextView textView = view.findViewById(android.R.id.text1);
                if (textView != null) {
                    textView.setText(deck.getName());
                }
            }

            return view;
        }
    }
}
