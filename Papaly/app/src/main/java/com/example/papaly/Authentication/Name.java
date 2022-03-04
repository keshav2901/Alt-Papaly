package com.example.papaly.Authentication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.papaly.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name extends Fragment {

    View view;
    ImageButton nameNext;
    ImageButton namePrevious;
    EditText name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_name, container, false);

        nameNext = view.findViewById(R.id.nameNext);
        namePrevious = view.findViewById(R.id.namePrevious);

        name = view.findViewById(R.id.Name);

        nameNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Check the name

                String regex = "^[a-zA-Z ]+$";

                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(name.getText().toString());

                if(matcher.matches()){
                    getParentFragmentManager()
                            .beginTransaction()
                            .replace(R.id.Authentication, ID.class, null)
                            .commit();
                }
                else {
                    name.setError("Enter a valid Name");
                }


            }
        });

        namePrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.Authentication, Code.class, null)
                        .commit();
            }
        });


        return view;
    }
}