package com.example.papaly.Authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.papaly.R;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
        fragment.replace(R.id.Authentication, Number.class, null).commit();
    }
}