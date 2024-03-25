package com.example.mtg_deck_builder.models;

import java.util.ArrayList;
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

    public Card(String id, String name, String typeLine, String oracleText, Legalities legalities,
                String manaCost, int cmc, String power, String toughness, List<String> colourIdentity,
                Images images) {
        this.id = id;
        this.name = name;
        this.typeLine = typeLine;
        this.oracleText = oracleText;
        this.legalities = legalities;
        this.manaCost = manaCost;
        this.cmc = cmc;
        this.power = power;
        this.toughness = toughness;
        this.colourIdentity = colourIdentity;
        this.images = images;
    }

    public static List<Card> getTestData() {
        List<Card> testCards = new ArrayList<>();

        // Creating test cards
        Card card1 = new Card(
                "1",
                "Card Name 1",
                "Creature",
                "Oracle Text 1",
                new Legalities(),
                "{2}{W}",
                3,
                "2",
                "2",
                new ArrayList<>(),
                new Images(
                        "https://picsum.photos/40/70",
                        "https://picsum.photos/400/700",
                        "https://picsum.photos/800/1400",
                        "https://picsum.photos/400/700"
                )
        );
        testCards.add(card1);

        Card card2 = new Card(
                "2",
                "Card Name 2",
                "Enchantment",
                "Oracle Text 2",
                new Legalities(),
                "{2}{G}",
                4,
                null,
                null,
                new ArrayList<>(),
                new Images(
                        "https://picsum.photos/40/70",
                        "https://picsum.photos/400/700",
                        "https://picsum.photos/800/1400",
                        "https://picsum.photos/400/700"
                )
        );
        testCards.add(card2);

        Card card3 = new Card(
                "3",
                "Card Name 3",
                "Instant",
                "Oracle Text 3",
                new Legalities(),
                "{U}",
                1,
                null,
                null,
                new ArrayList<>(),
                new Images(
                        "https://picsum.photos/40/70",
                        "https://picsum.photos/400/700",
                        "https://picsum.photos/800/1400",
                        "https://picsum.photos/400/700"
                )
        );
        testCards.add(card3);

        Card card4 = new Card(
                "4",
                "Card Name 4",
                "Artifact",
                "Oracle Text 4",
                new Legalities(),
                "{3}",
                3,
                null,
                null,
                new ArrayList<>(),
                new Images(
                        "https://picsum.photos/40/70",
                        "https://picsum.photos/400/700",
                        "https://picsum.photos/800/1400",
                        "https://picsum.photos/400/700"
                )
        );
        testCards.add(card4);

        Card card5 = new Card(
                "5",
                "Card Name 5",
                "Sorcery",
                "Oracle Text 5",
                new Legalities(),
                "{2}{B}",
                3,
                null,
                null,
                new ArrayList<String>(),
                new Images(
                        "https://picsum.photos/40/70",
                        "https://picsum.photos/400/700",
                        "https://picsum.photos/800/1400",
                        "https://picsum.photos/400/700"
                )
        );
        testCards.add(card5);

        return testCards;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeLine() {
        return typeLine;
    }

    public void setTypeLine(String typeLine) {
        this.typeLine = typeLine;
    }

    public String getOracleText() {
        return oracleText;
    }

    public void setOracleText(String oracleText) {
        this.oracleText = oracleText;
    }

    public Legalities getLegalities() {
        return legalities;
    }

    public void setLegalities(Legalities legalities) {
        this.legalities = legalities;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public int getCmc() {
        return cmc;
    }

    public void setCmc(int cmc) {
        this.cmc = cmc;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    public List<String> getColourIdentity() {
        return colourIdentity;
    }

    public void setColourIdentity(List<String> colourIdentity) {
        this.colourIdentity = colourIdentity;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }
}