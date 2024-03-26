package com.example.mtg_deck_builder.search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mtg_deck_builder.R;
import com.example.mtg_deck_builder.models.Card;
import com.squareup.picasso.Picasso;

public class SearchCardDetails extends AppCompatActivity {

    private ImageView cardImage;
    private TextView txtCardName;
    private TextView txtCardTypeLine;
    private TextView txtCardOracleText;
    private TextView txtCardManaCost;
    private TextView txtCardCmc;
    private TextView txtCardPower;
    private TextView txtCardToughness;
    private TextView txtLegalities;
    private Button btnAddToDeck;
    private Card card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_card_details);

        cardImage = findViewById(R.id.card_image);
        txtCardName = findViewById(R.id.txtCardName);
        txtCardTypeLine = findViewById(R.id.txtCardTypeLine);
        txtCardOracleText = findViewById(R.id.txtCardOracleText);
        txtCardManaCost = findViewById(R.id.txtCardManaCost);
        txtCardCmc = findViewById(R.id.txtCardCmc);
        txtCardPower = findViewById(R.id.txtCardPower);
        txtCardToughness = findViewById(R.id.txtCardToughness);
        txtLegalities = findViewById(R.id.txtLegalities);
        btnAddToDeck = findViewById(R.id.btnAddToDeck);

        Intent intent = getIntent();
        card = (Card) intent.getSerializableExtra("card");

        displayCardDetails();

        btnAddToDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: add going to the activity of adding cards to a deck
            }
        });
    }

    private void displayCardDetails() {
        // Display card details
        Picasso.get().load(card.getImages().getNormal()).into(cardImage);
        txtCardName.setText(card.getName());
        txtCardTypeLine.setText("Type: " + card.getTypeLine());
        txtCardOracleText.setText("Oracle Text: " + card.getOracleText());
        txtCardManaCost.setText("ManaCost: " + card.getManaCost());
        txtCardCmc.setText(String.valueOf("CMC: " + card.getCmc()));
        txtCardPower.setText("Card Power: " + card.getPower());
        txtCardToughness.setText("Toughness: " + card.getToughness());
        txtLegalities.setText(buildLegalities());
    }

    private String buildLegalities(){
        StringBuilder theLaw = new StringBuilder();

        theLaw.append("Standard: ").append(card.getLegalities().getStandard()).append("\n");
        theLaw.append("Future: ").append(card.getLegalities().getFuture()).append("\n");
        theLaw.append("Historic: ").append(card.getLegalities().getHistoric()).append("\n");
        theLaw.append("Timeless: ").append(card.getLegalities().getTimeless()).append("\n");
        theLaw.append("Gladiator: ").append(card.getLegalities().getGladiator()).append("\n");
        theLaw.append("Pioneer: ").append(card.getLegalities().getPioneer()).append("\n");
        theLaw.append("Explorer: ").append(card.getLegalities().getExplorer()).append("\n");
        theLaw.append("Modern: ").append(card.getLegalities().getModern()).append("\n");
        theLaw.append("Legacy: ").append(card.getLegalities().getLegacy()).append("\n");
        theLaw.append("Pauper: ").append(card.getLegalities().getPauper()).append("\n");
        theLaw.append("Vintage: ").append(card.getLegalities().getVintage()).append("\n");
        theLaw.append("Penny: ").append(card.getLegalities().getPenny()).append("\n");
        theLaw.append("Commander: ").append(card.getLegalities().getCommander()).append("\n");
        theLaw.append("Oathbreaker: ").append(card.getLegalities().getOathbreaker()).append("\n");
        theLaw.append("Standard Brawl: ").append(card.getLegalities().getStandardbrawl()).append("\n");
        theLaw.append("Brawl: ").append(card.getLegalities().getBrawl()).append("\n");
        theLaw.append("Alchemy: ").append(card.getLegalities().getAlchemy()).append("\n");
        theLaw.append("Pauper Commander: ").append(card.getLegalities().getPaupercommander()).append("\n");
        theLaw.append("Duel: ").append(card.getLegalities().getDuel()).append("\n");
        theLaw.append("Old School: ").append(card.getLegalities().getOldschool()).append("\n");
        theLaw.append("Premodern: ").append(card.getLegalities().getPremodern()).append("\n");
        theLaw.append("Predh: ").append(card.getLegalities().getPredh());

        return theLaw.toString();
    }
}

