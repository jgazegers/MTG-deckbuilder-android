package com.example.mtg_deck_builder.models;
public class Legalities {
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