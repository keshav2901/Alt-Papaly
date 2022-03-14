package com.example.papaly.Authentication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.papaly.R;
//import com.kofigyan.stateprogressbar.StateProgressBar;

public class Code extends Fragment {

    ImageButton codeNext;
    ImageButton codePrevious;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_code, container, false);

        codeNext =  view.findViewById(R.id.codeNext);
        codePrevious = view.findViewById(R.id.codePrevious);

        codeNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // check the otp

                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.Authentication, Name.class, null)
                        .commit();
            }
        });

        codePrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.Authentication, Number.class, null)
                        .commit();
            }
        });

        return view;
    }
}