package com.example.mtg_deck_builder.models;

import org.json.JSONObject;

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

    public static Images parseFromJSON(JSONObject json) {
        if (json == null) {
            return new Images(
                    "https://picsum.photos/40/70",
                    "https://picsum.photos/400/700",
                    "https://picsum.photos/800/1400",
                    "https://picsum.photos/400/700"
                    );
        } else {
            return new Images(
                    json.optString("small"),
                    json.optString("normal"),
                    json.optString("large"),
                    json.optString("png")
            );
        }


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