package com.example.mtg_deck_builder.search;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mtg_deck_builder.R;
import com.example.mtg_deck_builder.models.Card;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements SearchCardAdapter.OnItemClickListener {
    private List<Card> cards;
    private RequestQueue queue;

    private SearchCardAdapter adapter;
    private TextInputEditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        cards = new ArrayList<>();

        searchEditText = findViewById(R.id.searchEditText);
        Button searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchTerm = searchEditText.getText().toString();
                if (!searchTerm.isEmpty()) {
                    fetchData(searchTerm);
                }
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new SearchCardAdapter(cards, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void fetchData(String searchTerm) {
        queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://api.scryfall.com/cards/search?q=" + searchTerm, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    // Removed setting image URLs manually here, assuming it's fetched from the API response.

                    JSONArray data = response.getJSONArray("data");

                    cards.clear();

                    for (int i = 0; i < data.length(); i++) {
                        JSONObject cardJson = data.getJSONObject(i);
                        Card card = Card.parseFromJSON(cardJson);
                        cards.add(card);
                    }

                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                cards.clear();
                error.printStackTrace();
            }
        });

        queue.add(jsonObjectRequest);
    }

    @Override
    public void onItemClick(Card card) {
        // Open SearchCardDetails activity with the details of the clicked card
        Intent intent = new Intent(this, SearchCardDetails.class);
        intent.putExtra("card", card); // Pass the clicked card to the details activity
        startActivity(intent);
    }
}
