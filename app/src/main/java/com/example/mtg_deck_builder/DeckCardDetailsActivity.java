package com.example.mtg_deck_builder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mtg_deck_builder.models.DeckCard;

public class DeckCardDetailsActivity extends AppCompatActivity {

    private TextView txtCardName;
    private TextView txtCardTypeLine;
    private TextView txtCardOracleText;
    private TextView txtCardManaCost;
    private TextView txtCardCmc;
    private TextView txtCardPower;
    private TextView txtCardToughness;
    private TextView txtDeckAmount;
    private EditText edtComment;
    private EditText edtAmount;
    private Button btnSave;

    private DeckCard deckCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_card_details);

        // Initialize views
        txtCardName = findViewById(R.id.txtCardName);
        txtCardTypeLine = findViewById(R.id.txtCardTypeLine);
        txtCardOracleText = findViewById(R.id.txtCardOracleText);
        txtCardManaCost = findViewById(R.id.txtCardManaCost);
        txtCardCmc = findViewById(R.id.txtCardCmc);
        txtCardPower = findViewById(R.id.txtCardPower);
        txtCardToughness = findViewById(R.id.txtCardToughness);
        txtDeckAmount = findViewById(R.id.txtDeckAmount);
        edtComment = findViewById(R.id.edtComment);
        edtAmount = findViewById(R.id.edtAmount);
        btnSave = findViewById(R.id.btnSave);

        // Get DeckCard object from intent
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
        txtCardName.setText(deckCard.getCard().getName());
        txtCardTypeLine.setText(deckCard.getCard().getTypeLine());
        txtCardOracleText.setText(deckCard.getCard().getOracleText());
        txtCardManaCost.setText(deckCard.getCard().getManaCost());
        txtCardCmc.setText(String.valueOf(deckCard.getCard().getCmc()));
        txtCardPower.setText(deckCard.getCard().getPower());
        txtCardToughness.setText(deckCard.getCard().getToughness());

        // Display deck card details
        txtDeckAmount.setText(String.valueOf(deckCard.getAmount()));
        edtComment.setText(deckCard.getComment());
        edtAmount.setText(String.valueOf(deckCard.getAmount()));
    }
}