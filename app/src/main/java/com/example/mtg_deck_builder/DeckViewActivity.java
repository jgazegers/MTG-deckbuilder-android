package com.example.mtg_deck_builder;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mtg_deck_builder.models.Deck;
import com.example.mtg_deck_builder.models.DeckCard;
import com.example.mtg_deck_builder.search.SearchActivity;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DeckViewActivity extends AppCompatActivity implements DeckCardAdapter.OnItemClickListener {

    private static final int REQUEST_IMAGE_CAPTURE = 5;
    private static final int REQUEST_IMAGE_PICK = 6;
    private RecyclerView recyclerView;
    private TextView txtHeader;
    private DeckCardAdapter adapter;
    private List<DeckCard> deckCards;
    private List<Deck> decks;
    private Deck deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_view);

        decks = Deck.getListFromUserDefaults(this);
        deck = (Deck) getIntent().getSerializableExtra("deck");
        // Retrieve deck card data from Intent extras
        deckCards = deck.getCards();

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        txtHeader = findViewById(R.id.header_text);
        txtHeader.setText(deck.getName());

        // Create and set adapter
        adapter = new DeckCardAdapter(deckCards, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        decks = Deck.getListFromUserDefaults(this);
        //How do I get a new deck?
        deck = (Deck) getIntent().getSerializableExtra("deck");
        UUID deckID = deck.getId();
        Optional<Deck> temp = decks.stream().filter(deck -> deck.getId().equals(deckID)).findFirst();
        deck = temp.orElse(null);

        // Retrieve deck card data from Intent extras
        deckCards = deck.getCards();

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        System.out.println("request code: " + requestCode);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            this.decks = (List<Deck>) data.getSerializableExtra("decks");

            this.deck = (Deck) getIntent().getSerializableExtra("deck");
            UUID deckID = deck.getId();
            Optional<Deck> temp = decks.stream().filter(deck -> deck.getId().equals(deckID)).findFirst();
            this.deck = temp.orElse(null);

            // Retrieve deck card data from Intent extras
            this.deckCards = deck.getCards();

            adapter.notifyDataSetChanged(); // Update RecyclerView with new data
        }
        else{
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    // Handle image pick from gallery
                    Uri selectedImageUri = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
                        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                        String path = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "File", null);
                        Uri newUri = Uri.parse(path);

                        for(int i = 0; i < decks.size(); i++){
                            if(decks.get(i).getId().equals(deck.getId())){
                                decks.get(i).setImage(newUri);
                            }
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }




                    Deck.saveList(decks, getBaseContext());

                }
            }
        }
    }

    @Override
    public void onItemClick(DeckCard card) {
        Intent intent = new Intent(DeckViewActivity.this, DeckCardDetailsActivity.class);
        intent.putExtra("currentDeck", deck);
        intent.putExtra("currentCard", card);
        startActivityForResult(intent, 1);
    }

    public void selectImageSource(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Intent pickImageIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickImageIntent.setType("image/*");

        // Check if there is a camera app available to handle the capture intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Show options to the user to select either camera or gallery
            Intent chooserIntent = Intent.createChooser(pickImageIntent, "Select Image Source");
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] { takePictureIntent });
            startActivityForResult(chooserIntent, REQUEST_IMAGE_CAPTURE);
        } else {
            // Handle the case where there is no app available to handle the capture intent
            startActivityForResult(pickImageIntent, REQUEST_IMAGE_PICK);
        }
    }

}