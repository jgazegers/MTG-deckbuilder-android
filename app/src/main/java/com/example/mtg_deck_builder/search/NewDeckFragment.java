package com.example.mtg_deck_builder.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mtg_deck_builder.R;

public class NewDeckFragment extends Fragment {

    private EditText editText;
    private Button button;

    public NewDeckFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_deck, container, false);

        editText = view.findViewById(R.id.editText);
        button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if (getActivity() instanceof AddCardToDeckActivity) {
                    ((AddCardToDeckActivity)getActivity()).addNewDeck(text);
                }
            }
        });

        return view;
    }
}
