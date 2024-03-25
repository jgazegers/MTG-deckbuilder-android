package com.example.mtg_deck_builder.models;

import java.util.List;

public class Card {
    private String id;
    private String name;
    private String typeLine;
    private String oracleText;
    private Legalities legalities;
    private String manaCost;
    private int cmc;
    private String power;
    private String toughness;
    private List<String> colourIdentity;
    private Images images;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTypeLine() {
        return typeLine;
    }

    public String getOracleText() {
        return oracleText;
    }

    public Legalities getLegalities() {
        return legalities;
    }

    public String getManaCost() {
        return manaCost;
    }

    public int getCmc() {
        return cmc;
    }

    public String getPower() {
        return power;
    }

    public String getToughness() {
        return toughness;
    }

    public List<String> getColourIdentity() {
        return colourIdentity;
    }

    public Images getImages() {
        return images;
    }
}