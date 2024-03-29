package com.example.mtg_deck_builder.models;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Deck implements Serializable {
    private static final String PREF_DECKS = "pref_decks";
    private UUID id;
    private String name;
    private List<DeckCard> cards;
    private String image;

    public Deck(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public Uri getImage(){
        if(image != null) {
            return Uri.parse(image);
        }
        else return null;
    }

    public void setImage(Uri image){ this.image = image.toString(); }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<DeckCard> getCards() {
        return cards;
    }

    public int countTotalCards() {
        int totalCards = 0;
        for (DeckCard card : cards) {
            totalCards += card.getAmount();
        }
        return totalCards;
    }

    public void addCard(Card card, int amount) {
        if (amount > 0) {
            this.cards.add(new DeckCard(UUID.randomUUID(), card, amount, ""));
        }
    }

    public static void saveList(List<Deck> decks, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_DECKS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(decks);
        editor.putString(PREF_DECKS, json);
        editor.apply();
    }

    public static List<Deck> getListFromUserDefaults(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_DECKS, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(PREF_DECKS, null);
        Type type = new TypeToken<ArrayList<Deck>>() {}.getType();
        return gson.fromJson(json, type);
    }
}