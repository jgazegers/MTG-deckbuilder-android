package com.example.mtg_deck_builder.models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Deck implements Serializable {
    private UUID id;
    private String name;
    private List<DeckCard> cards;

    public Deck(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.cards = new ArrayList<>();
    }

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

    public static void saveList(List<Deck> decks) {
        // Your implementation to save decks
    }

    public static List<Deck> getListFromUserDefaults() {
        // Your implementation to retrieve decks from UserDefaults
        return new ArrayList<>();
    }
}