package com.example.mtg_deck_builder.decks;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mtg_deck_builder.DeckViewActivity;
import com.example.mtg_deck_builder.R;
import com.example.mtg_deck_builder.models.Deck;

import java.util.ArrayList;
import java.util.List;

public class DecksActivity extends AppCompatActivity implements DeckAdapter.OnItemClickListener {

    private RecyclerView recyclerViewDecks;
    private List<Deck> decks;

    private int STORAGE_PERMISSION_CODE = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decks);

        decks = Deck.getListFromUserDefaults(this);

        recyclerViewDecks = findViewById(R.id.decks_list);
        DeckAdapter adapter = new DeckAdapter(decks, this);
        recyclerViewDecks.setAdapter(adapter);
        recyclerViewDecks.setLayoutManager(new LinearLayoutManager(this));

        checkPermission(Manifest.permission.READ_MEDIA_IMAGES, STORAGE_PERMISSION_CODE);
    }

    @Override
    public void onItemClick(Deck deck) {
        Intent intent = new Intent(this, DeckViewActivity.class);
        intent.putExtra("deck", deck);
        startActivity(intent);
    }

    public void checkPermission(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(DecksActivity.this, permission) == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(DecksActivity.this, new String[] { permission }, requestCode);
        }
        else {
            Toast.makeText(DecksActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(DecksActivity.this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(DecksActivity.this, "Storage Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}