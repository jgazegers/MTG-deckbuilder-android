package com.example.mtg_deck_builder.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
import com.example.mtg_deck_builder.models.Images;
import com.example.mtg_deck_builder.models.Legalities;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SearchActivity extends AppCompatActivity {
    private List<Card> cards;
    private RequestQueue queue;

    private SearchCardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        cards = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new SearchCardAdapter(cards);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchData();
    }

    private void fetchData() {
        queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://api.scryfall.com/cards/search?q=demon", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    cards.get(0).setImages(new Images("https://picsum.photos/100/100", "https://picsum.photos/100/100", "https://picsum.photos/100/100", "https://picsum.photos/100/100"));

                    JSONArray data = response.getJSONArray("data");

                    cards.clear();

                    for (int i = 0; i < data.length(); i++) {
                        JSONObject cardJson = data.getJSONObject(i);
                        Card card = Card.parseFromJSON(cardJson);
                        cards.add(card);
                    }
                    
                    adapter.notifyDataSetChanged();
                } catch (Exception e) {
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
}
