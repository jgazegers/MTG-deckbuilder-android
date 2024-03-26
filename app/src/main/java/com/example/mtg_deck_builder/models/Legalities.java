package com.example.mtg_deck_builder.models;

import org.json.JSONObject;

import java.io.Serializable;

public class Legalities implements Serializable {
    private String standard;
    private String future;
    private String historic;
    private String timeless;
    private String gladiator;
    private String pioneer;
    private String explorer;
    private String modern;
    private String legacy;
    private String pauper;
    private String vintage;
    private String penny;
    private String commander;
    private String oathbreaker;
    private String standardbrawl;
    private String brawl;
    private String alchemy;
    private String paupercommander;
    private String duel;
    private String oldschool;
    private String premodern;
    private String predh;

    public Legalities(String standard, String future, String historic, String timeless, String gladiator, String pioneer, String explorer, String modern, String legacy, String pauper, String vintage, String penny, String commander, String oathbreaker, String standardbrawl, String brawl, String alchemy, String paupercommander, String duel, String oldschool, String premodern, String predh) {
        this.standard = standard;
        this.future = future;
        this.historic = historic;
        this.timeless = timeless;
        this.gladiator = gladiator;
        this.pioneer = pioneer;
        this.explorer = explorer;
        this.modern = modern;
        this.legacy = legacy;
        this.pauper = pauper;
        this.vintage = vintage;
        this.penny = penny;
        this.commander = commander;
        this.oathbreaker = oathbreaker;
        this.standardbrawl = standardbrawl;
        this.brawl = brawl;
        this.alchemy = alchemy;
        this.paupercommander = paupercommander;
        this.duel = duel;
        this.oldschool = oldschool;
        this.premodern = premodern;
        this.predh = predh;
    }

    public static Legalities parseJson(JSONObject legalitiesJson) {
        String standard = legalitiesJson.optString("standard");
        String future = legalitiesJson.optString("future");
        String historic = legalitiesJson.optString("historic");
        String timeless = legalitiesJson.optString("timeless");
        String gladiator = legalitiesJson.optString("gladiator");
        String pioneer = legalitiesJson.optString("pioneer");
        String explorer = legalitiesJson.optString("explorer");
        String modern = legalitiesJson.optString("modern");
        String legacy = legalitiesJson.optString("legacy");
        String pauper = legalitiesJson.optString("pauper");
        String vintage = legalitiesJson.optString("vintage");
        String penny = legalitiesJson.optString("penny");
        String commander = legalitiesJson.optString("commander");
        String oathbreaker = legalitiesJson.optString("oathbreaker");
        String standardbrawl = legalitiesJson.optString("standardbrawl");
        String brawl = legalitiesJson.optString("brawl");
        String alchemy = legalitiesJson.optString("alchemy");
        String paupercommander = legalitiesJson.optString("paupercommander");
        String duel = legalitiesJson.optString("duel");
        String oldschool = legalitiesJson.optString("oldschool");
        String premodern = legalitiesJson.optString("premodern");
        String predh = legalitiesJson.optString("predh");

        return new Legalities(standard, future, historic, timeless, gladiator, pioneer, explorer,
                modern, legacy, pauper, vintage, penny, commander, oathbreaker, standardbrawl,
                brawl, alchemy, paupercommander, duel, oldschool, premodern, predh);
    }

    public String getStandard() {
        return standard;
    }

    public String getFuture() {
        return future;
    }

    public String getHistoric() {
        return historic;
    }

    public String getTimeless() {
        return timeless;
    }

    public String getGladiator() {
        return gladiator;
    }

    public String getPioneer() {
        return pioneer;
    }

    public String getExplorer() {
        return explorer;
    }

    public String getModern() {
        return modern;
    }

    public String getLegacy() {
        return legacy;
    }

    public String getPauper() {
        return pauper;
    }

    public String getVintage() {
        return vintage;
    }

    public String getPenny() {
        return penny;
    }

    public String getCommander() {
        return commander;
    }

    public String getOathbreaker() {
        return oathbreaker;
    }

    public String getStandardbrawl() {
        return standardbrawl;
    }

    public String getBrawl() {
        return brawl;
    }

    public String getAlchemy() {
        return alchemy;
    }

    public String getPaupercommander() {
        return paupercommander;
    }

    public String getDuel() {
        return duel;
    }

    public String getOldschool() {
        return oldschool;
    }

    public String getPremodern() {
        return premodern;
    }

    public String getPredh() {
        return predh;
    }

}