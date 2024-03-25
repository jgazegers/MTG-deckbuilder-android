package com.example.mtg_deck_builder.models;

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
}