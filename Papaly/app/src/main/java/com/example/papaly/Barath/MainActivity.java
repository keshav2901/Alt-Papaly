package com.example.papaly.Barath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.papaly.R;
import com.example.papaly.Stats.trial_fragment2;

public class MainActivity extends AppCompatActivity
{
    ImageButton btn_stats, btn_home, btn_profile;
    private ViewPager viewPager;
    Button btn_menu;
    RelativeLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_stats = findViewById(R.id.btn_stats);
        btn_home = findViewById(R.id.btn_home);
        btn_profile = findViewById(R.id.btn_profile);

        btn_menu = findViewById(R.id.btn_menu);

        root = findViewById(R.id.root);

        Toolbar toolbar = findViewById(R.id.tabs);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(false)
                    .add(R.id.fragment_container_view,  MainFragment.class, null)
                    .addToBackStack("sum")
                    .commit();
        }

        btn_stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(false)
                        .replace(R.id.fragment_container_view,  trial_fragment2.class, null)
                        .addToBackStack("sum")
                        .commit();
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(false)
                        .replace(R.id.fragment_container_view, FirstFragment.class, null)
                        .addToBackStack("sum")
                        .commit();
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(false)
                        .replace(R.id.fragment_container_view, MainFragment.class, null)
                        .addToBackStack("sum")
                        .commit();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}