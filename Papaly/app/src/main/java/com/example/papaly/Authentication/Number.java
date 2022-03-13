package com.example.papaly.Authentication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.papaly.Barath.MainActivity;
import com.example.papaly.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class Number extends Fragment {

    View view;
    ImageButton next;
    EditText number, inviteCode;
    MainActivity mainActivity;

    //Firebase

    private FirebaseUser currentUser;
    private FirebaseAuth mAuth;
    private DatabaseReference RootRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_number, container, false);

        next = view.findViewById(R.id.next);

        number = view.findViewById(R.id.Number);
        inviteCode = view.findViewById(R.id.InviteCode);

        //Firebase
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        RootRef = FirebaseDatabase.getInstance().getReference();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //To verify the number and invite code from database and move to the next page

                String phoneNumber = number.getText().toString();

                if(phoneNumber.length() < 10){
                    number.setError("Invalid Number");
                }
                else {
                    RootRef.child("Users").child("Hello").setValue("null");
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