package com.example.mtg_deck_builder.models;
public class Images {
    private String small;
    private String normal;
    private String large;
    private String png;

    public Images(String small, String normal, String large, String png) {
        this.small = small;
        this.normal = normal;
        this.large = large;
        this.png = png;
    }

    public String getSmall() {
        return small;
    }

    public String getNormal() {
        return normal;
    }

    public String getLarge() {
        return large;
    }

    public String getPng() {
        return png;
    }
}