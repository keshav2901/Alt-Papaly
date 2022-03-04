package com.example.papaly.Stats;


import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.papaly.R;
import com.github.mikephil.charting.charts.LineChart;

import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link trial_Fragmet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class trial_Fragmet extends Fragment implements OnChartValueSelectedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    LineChart lineChart;

    public trial_Fragmet() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment trial_Fragmet.
     */
    // TODO: Rename and change types and number of parameters
    public static trial_Fragmet newInstance(String param1, String param2) {
        trial_Fragmet fragment = new trial_Fragmet();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_trial__fragmet, container, false);

        lineChart = view.findViewById(R.id.lineChart);


        LineData data = getData(20, 50);


        lineChart.getDescription().setEnabled(false);
        lineChart.setDrawGridBackground(false);

        lineChart.setTouchEnabled(false);

        lineChart.setBackgroundColor(getResources().getColor(R.color.papaly_white));
        lineChart.setData(data);

        lineChart.getAxisLeft().setEnabled(true);
        lineChart.getAxisLeft().setDrawGridLines(false);

        lineChart.getXAxis().setDrawGridLines(false);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.getAxisLeft().setSpaceTop(40);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.animateX(2000);
        lineChart.getLegend().setEnabled(false);

        return view;
    }

    @Override
    public void onValueSelected(Entry entry, Highlight highlight) {

    }

    @Override
    public void onNothingSelected() {

    }

    private LineData getData(int count, float range) {

        ArrayList<Entry> values = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range) + 3;
            values.add(new Entry(i, val));
        }

        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(values,"Water Level");
        set1.setFillAlpha(255);

        set1.setLineWidth(2f);
        set1.setDrawCircles(false);
        set1.setDrawValues(false);

        set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set1.setDrawFilled(true);
//        set1.setFillColor(R.color.papaly_blue);
        set1.setFillColor(ContextCompat.getColor(requireContext(), R.color.papaly_blue));
        set1.setColor(R.color.papaly_white);
        set1.setHighLightColor(R.color.papaly_white);
        //         create a data object with the data sets
        return new LineData(set1);
    }

}