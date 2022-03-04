package com.example.papaly.Authentication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.papaly.MainActivity;
import com.example.papaly.R;

public class Number extends Fragment {

    View view;
    ImageButton next;
    EditText number, inviteCode;
    MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_number, container, false);

        next = view.findViewById(R.id.next);

        number = view.findViewById(R.id.Number);
        inviteCode = view.findViewById(R.id.InviteCode);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //To verify the number and invite code from database and move to the next page

                String phoneNumber = number.getText().toString();

                if(phoneNumber.length() < 10){
                    number.setError("Invalid Number");
                }
                else {
                    getParentFragmentManager()
                            .beginTransaction()
                            .replace(R.id.Authentication, Code.class, null)
                            .commit();
                }
            }
        });
        return view;
    }
}