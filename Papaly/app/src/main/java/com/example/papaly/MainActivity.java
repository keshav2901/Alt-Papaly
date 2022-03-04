package com.example.papaly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.papaly.Barath.FirstFragment;
import com.example.papaly.Barath.SecondFragment;

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
                    .add(R.id.fragment_container_view,  SecondFragment.class, null)
                    .addToBackStack("sum")
                    .commit();
        }

        btn_stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(false)
                        .add(R.id.fragment_container_view,  trial_fragment2.class, null)
                        .addToBackStack("sum")
                        .commit();
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(false)
                        .add(R.id.fragment_container_view, FirstFragment.class, null)
                        .addToBackStack("sum")
                        .commit();
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(false)
                        .add(R.id.fragment_container_view, SecondFragment.class, null)
                        .addToBackStack("sum")
                        .commit();
            }
        });
    }
}