package com.example.papaly.Barath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.papaly.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

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

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.placeholder, new FirstFragment());
                ft.commit();
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.placeholder, new SecondFragment());
                ft.commit();
            }
        });

        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                getLayoutInflater().inflate(R.layout.fragment_menu, root);
//                btn_menu.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.menu_button_down));
//                btn_menu.getLayoutParams().height = 200;
//                btn_menu.getLayoutParams().width = 200;
                //registerForContextMenu(view);
                PopupMenu popup = new PopupMenu(MainActivity.this, view);
                popup.setOnMenuItemClickListener(MainActivity.this);
                popup.inflate(R.menu.example_menu);
                popup.show();
            }
        });

//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        int height = displayMetrics.heightPixels;
//        int width = displayMetrics.widthPixels;

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }

    /*@Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.example_menu, menu);
    }*/
}