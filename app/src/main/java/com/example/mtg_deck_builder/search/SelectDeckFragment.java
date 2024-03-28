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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mtg_deck_builder.R;
import com.example.mtg_deck_builder.models.Deck;

import java.util.ArrayList;
import java.util.List;

public class SelectDeckFragment extends Fragment {


    private ListView listView;
    private ArrayAdapter<Deck> adapter;
    private List<Deck> deckList;

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select_deck, container, false);

        listView = view.findViewById(R.id.listView);

        // Set up adapter
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, deckList);
        listView.setAdapter(adapter);

        // Set item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item click, for example, show details of the selected deck
                Deck selectedDeck = deckList.get(position);
                // You can perform any action with the selected deck, such as displaying its details in another fragment or activity
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

    private class DeckAdapter extends ArrayAdapter<Deck> {
        public DeckAdapter(@NonNull Context context, List<Deck> decks) {
            super(context, android.R.layout.simple_list_item_1);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return super.getView(position, convertView, parent);
        }
    }
}
