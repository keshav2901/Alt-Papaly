package com.example.papaly.Authentication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.papaly.Barath.MainActivity;
import com.example.papaly.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class Tank extends Fragment {

    TextInputLayout dropdown_menu;
    AutoCompleteTextView dropdown_text;
    RelativeLayout tankNext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_tank, container, false);

        dropdown_menu = view.findViewById(R.id.dropdown_menu);
        dropdown_text = view.findViewById(R.id.dropdown_text);

        String[] user = getResources().getStringArray(R.array.Tank_array);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),R.layout.items_list, user);
        dropdown_text.setAdapter(adapter);


        tankNext = view.findViewById(R.id.tankNext);

        tankNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }
        });

        return view;
    }

}