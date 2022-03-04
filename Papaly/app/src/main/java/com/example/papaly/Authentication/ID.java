package com.example.papaly.Authentication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.papaly.R;

public class ID extends Fragment {

    View view;
    ImageButton idNext;
    ImageButton idPrevious;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_i_d, container, false);

        idNext = view.findViewById(R.id.idNext);
        idPrevious = view.findViewById(R.id.idPrevious);

        idNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check the id with the database and if the id is not available contact

                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.Authentication, Tank.class, null)
                        .commit();
            }
        });

        idPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.Authentication, Name.class, null)
                        .commit();
            }
        });

        return view;
    }
}