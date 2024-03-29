package com.example.mtg_deck_builder;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.example.mtg_deck_builder.models.DeckCard;
import com.squareup.picasso.Picasso;

public class DeckCardDetailsActivity extends AppCompatActivity {

    private boolean showImages;
    private ImageView cardImage;
    private TextView txtCardName;
    private TextView txtCardTypeLine;
    private TextView txtCardOracleText;
    private TextView txtCardManaCost;
    private TextView txtCardCmc;
    private TextView txtCardPower;
    private TextView txtCardToughness;
    private TextView txtLegalities;
    private EditText edtComment;
    private EditText edtAmount;
    private Button btnSave;

    private DeckCard deckCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_card_details);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.showImages = preferences.getBoolean("showImages", true);

        // Initialize views
        cardImage = findViewById(R.id.card_image);
        if (showImages) cardImage.setVisibility(View.INVISIBLE);

        txtCardName = findViewById(R.id.txtCardName);
        txtCardTypeLine = findViewById(R.id.txtCardTypeLine);
        txtCardOracleText = findViewById(R.id.txtCardOracleText);
        txtCardManaCost = findViewById(R.id.txtCardManaCost);
        txtCardCmc = findViewById(R.id.txtCardCmc);
        txtCardPower = findViewById(R.id.txtCardPower);
        txtCardToughness = findViewById(R.id.txtCardToughness);
        txtLegalities = findViewById(R.id.txtLegalities);
        edtComment = findViewById(R.id.edtComment);
        edtAmount = findViewById(R.id.edtAmount);
        btnSave = findViewById(R.id.btnSave);

        // TODO: figure out how the card will actually be loaded in.
        deckCard = DeckCard.getTestDeckCard1();

        // Display card details
        displayDeckCardDetails();

        // Set onClick listener for save button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update comment and amount in deckCard
                String newComment = edtComment.getText().toString();
                int newAmount = Integer.parseInt(edtAmount.getText().toString());

                deckCard.setComment(newComment);
                deckCard.setAmount(newAmount);

                // Update UI to reflect changes
                displayDeckCardDetails();
            }
        });
    }

    private void displayDeckCardDetails() {
        // Display card details
        if (showImages) {
            Picasso.get().load(deckCard.getCard().getImages().getNormal()).into(cardImage);
        }
        txtCardName.setText(deckCard.getCard().getName());
        txtCardTypeLine.setText("Type: " + deckCard.getCard().getTypeLine());
        txtCardOracleText.setText("Oracle Text: " + deckCard.getCard().getOracleText());
        txtCardManaCost.setText("ManaCost: " + deckCard.getCard().getManaCost());
        txtCardCmc.setText(String.valueOf("CMC: " + deckCard.getCard().getCmc()));
        txtCardPower.setText("Card Power: " + deckCard.getCard().getPower());
        txtCardToughness.setText("Toughness: " + deckCard.getCard().getToughness());
        txtLegalities.setText(buildLegalities());

        // Display deck card details
        edtComment.setText(deckCard.getComment());
        edtAmount.setText(String.valueOf(deckCard.getAmount()));
    }

    private String buildLegalities(){
        StringBuilder theLaw = new StringBuilder();

        theLaw.append("Standard: ").append(deckCard.getCard().getLegalities().getStandard()).append("\n");
        theLaw.append("Future: ").append(deckCard.getCard().getLegalities().getFuture()).append("\n");
        theLaw.append("Historic: ").append(deckCard.getCard().getLegalities().getHistoric()).append("\n");
        theLaw.append("Timeless: ").append(deckCard.getCard().getLegalities().getTimeless()).append("\n");
        theLaw.append("Gladiator: ").append(deckCard.getCard().getLegalities().getGladiator()).append("\n");
        theLaw.append("Pioneer: ").append(deckCard.getCard().getLegalities().getPioneer()).append("\n");
        theLaw.append("Explorer: ").append(deckCard.getCard().getLegalities().getExplorer()).append("\n");
        theLaw.append("Modern: ").append(deckCard.getCard().getLegalities().getModern()).append("\n");
        theLaw.append("Legacy: ").append(deckCard.getCard().getLegalities().getLegacy()).append("\n");
        theLaw.append("Pauper: ").append(deckCard.getCard().getLegalities().getPauper()).append("\n");
        theLaw.append("Vintage: ").append(deckCard.getCard().getLegalities().getVintage()).append("\n");
        theLaw.append("Penny: ").append(deckCard.getCard().getLegalities().getPenny()).append("\n");
        theLaw.append("Commander: ").append(deckCard.getCard().getLegalities().getCommander()).append("\n");
        theLaw.append("Oathbreaker: ").append(deckCard.getCard().getLegalities().getOathbreaker()).append("\n");
        theLaw.append("Standard Brawl: ").append(deckCard.getCard().getLegalities().getStandardbrawl()).append("\n");
        theLaw.append("Brawl: ").append(deckCard.getCard().getLegalities().getBrawl()).append("\n");
        theLaw.append("Alchemy: ").append(deckCard.getCard().getLegalities().getAlchemy()).append("\n");
        theLaw.append("Pauper Commander: ").append(deckCard.getCard().getLegalities().getPaupercommander()).append("\n");
        theLaw.append("Duel: ").append(deckCard.getCard().getLegalities().getDuel()).append("\n");
        theLaw.append("Old School: ").append(deckCard.getCard().getLegalities().getOldschool()).append("\n");
        theLaw.append("Premodern: ").append(deckCard.getCard().getLegalities().getPremodern()).append("\n");
        theLaw.append("Predh: ").append(deckCard.getCard().getLegalities().getPredh());

        return theLaw.toString();
    }
}