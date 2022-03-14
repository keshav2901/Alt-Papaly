package com.example.papaly.Stats;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.papaly.R;

public class trial_fragment2 extends Fragment {

    Button button1, button2, button3, button4, button5, button6, button7;

    public trial_fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trial_fragment2, container, false);

        button1 = view.findViewById(R.id.day_button_1);
        button2 = view.findViewById(R.id.day_button_2);
        button3 = view.findViewById(R.id.day_button_3);
        button4 = view.findViewById(R.id.day_button_4);
        button5 = view.findViewById(R.id.day_button_5);
        button6 = view.findViewById(R.id.day_button_6);
        button7 = view.findViewById(R.id.day_button_7);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackground(getResources().getDrawable(R.drawable.date_background_selected));
                button2.setBackground(getResources().getDrawable(R.drawable.date_background));
                button3.setBackground(getResources().getDrawable(R.drawable.date_background));
                button4.setBackground(getResources().getDrawable(R.drawable.date_background));
                button5.setBackground(getResources().getDrawable(R.drawable.date_background));
                button6.setBackground(getResources().getDrawable(R.drawable.date_background));
                button7.setBackground(getResources().getDrawable(R.drawable.date_background));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackground(getResources().getDrawable(R.drawable.date_background));
                button2.setBackground(getResources().getDrawable(R.drawable.date_background_selected));
                button3.setBackground(getResources().getDrawable(R.drawable.date_background));
                button4.setBackground(getResources().getDrawable(R.drawable.date_background));
                button5.setBackground(getResources().getDrawable(R.drawable.date_background));
                button6.setBackground(getResources().getDrawable(R.drawable.date_background));
                button7.setBackground(getResources().getDrawable(R.drawable.date_background));            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackground(getResources().getDrawable(R.drawable.date_background));
                button2.setBackground(getResources().getDrawable(R.drawable.date_background));
                button3.setBackground(getResources().getDrawable(R.drawable.date_background_selected));
                button4.setBackground(getResources().getDrawable(R.drawable.date_background));
                button5.setBackground(getResources().getDrawable(R.drawable.date_background));
                button6.setBackground(getResources().getDrawable(R.drawable.date_background));
                button7.setBackground(getResources().getDrawable(R.drawable.date_background));            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackground(getResources().getDrawable(R.drawable.date_background));
                button2.setBackground(getResources().getDrawable(R.drawable.date_background));
                button3.setBackground(getResources().getDrawable(R.drawable.date_background));
                button4.setBackground(getResources().getDrawable(R.drawable.date_background_selected));
                button5.setBackground(getResources().getDrawable(R.drawable.date_background));
                button6.setBackground(getResources().getDrawable(R.drawable.date_background));
                button7.setBackground(getResources().getDrawable(R.drawable.date_background));            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackground(getResources().getDrawable(R.drawable.date_background));
                button2.setBackground(getResources().getDrawable(R.drawable.date_background));
                button3.setBackground(getResources().getDrawable(R.drawable.date_background));
                button4.setBackground(getResources().getDrawable(R.drawable.date_background));
                button5.setBackground(getResources().getDrawable(R.drawable.date_background_selected));
                button6.setBackground(getResources().getDrawable(R.drawable.date_background));
                button7.setBackground(getResources().getDrawable(R.drawable.date_background));            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackground(getResources().getDrawable(R.drawable.date_background));
                button2.setBackground(getResources().getDrawable(R.drawable.date_background));
                button3.setBackground(getResources().getDrawable(R.drawable.date_background));
                button4.setBackground(getResources().getDrawable(R.drawable.date_background));
                button5.setBackground(getResources().getDrawable(R.drawable.date_background));
                button6.setBackground(getResources().getDrawable(R.drawable.date_background_selected));
                button7.setBackground(getResources().getDrawable(R.drawable.date_background));            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackground(getResources().getDrawable(R.drawable.date_background));
                button2.setBackground(getResources().getDrawable(R.drawable.date_background));
                button3.setBackground(getResources().getDrawable(R.drawable.date_background));
                button4.setBackground(getResources().getDrawable(R.drawable.date_background));
                button5.setBackground(getResources().getDrawable(R.drawable.date_background));
                button6.setBackground(getResources().getDrawable(R.drawable.date_background));
                button7.setBackground(getResources().getDrawable(R.drawable.date_background_selected));            }
        });

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        if (savedInstanceState == null) {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(false)
                    .add(R.id.graph_fragment,  trial_Fragmet.class, null)
                    .addToBackStack("sum")
                    .commit();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(false)
                    .add(R.id.water_usage_pie_fragment,  water_pi.class, null)
                    .addToBackStack("water")
                    .commit();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(false)
                    .add(R.id.Bar_Graph_Fragmet,  Bar_Chart.class, null)
                    .addToBackStack("water")
                    .commit();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(false)
                    .add(R.id.Weekly_Water_Pi,  weekly_water_pi.class, null)
                    .addToBackStack("water")
                    .commit();
        }

        return view;
    }
}