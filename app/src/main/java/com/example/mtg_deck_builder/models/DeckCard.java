package com.example.mtg_deck_builder.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DeckCard {
    private UUID id;
    private Card card;
    private int amount;
    private String comment;

    public DeckCard(UUID id, Card card, int amount, String comment) {
        this.id = id;
        this.card = card;
        this.amount = amount;
        this.comment = comment;
    }

    public UUID getId() {
        return id;
    }

    public Card getCard() {
        return card;
    }

    public int getAmount() {
        return amount;
    }

    public String getComment() {
        return comment;
    }

    public static List<DeckCard> getTestData() {
        List<DeckCard> deckCards = new ArrayList<DeckCard>();

        Card card1 = new Card("123", "Lightning Bolt", "Instant", "Deal 3 damage to any target.",
                new Legalities(), "{R}", 1, null, null, null, new Images());

        Card card2 = new Card("321", "fire Bolt", "Instant", "Deal 3 damage to any target.",
                new Legalities(), "{R}", 1, null, null, null, new Images());

        deckCards.add(new DeckCard(UUID.randomUUID(), card1, 2, "comment 1"));
        deckCards.add(new DeckCard(UUID.randomUUID(), card2, 3, "comment 2"));
        deckCards.add(new DeckCard(UUID.randomUUID(), card1, 2, "comment 1"));
        deckCards.add(new DeckCard(UUID.randomUUID(), card2, 3, "comment 2"));
        deckCards.add(new DeckCard(UUID.randomUUID(), card1, 2, "comment 1"));
        deckCards.add(new DeckCard(UUID.randomUUID(), card2, 3, "comment 2"));
        deckCards.add(new DeckCard(UUID.randomUUID(), card1, 2, "comment 1"));
        deckCards.add(new DeckCard(UUID.randomUUID(), card2, 3, "comment 2"));
        deckCards.add(new DeckCard(UUID.randomUUID(), card1, 2, "comment 1"));
        deckCards.add(new DeckCard(UUID.randomUUID(), card2, 3, "comment 2"));

        return deckCards;
    }
}