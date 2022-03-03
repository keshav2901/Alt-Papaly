package com.example.papaly;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link water_pi#newInstance} factory method to
 * create an instance of this fragment.
 */
public class water_pi extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public water_pi() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment water_pi.
     */
    // TODO: Rename and change types and number of parameters
    public static water_pi newInstance(String param1, String param2) {
        water_pi fragment = new water_pi();
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
        View view =  inflater.inflate(R.layout.fragment_water_pi, container, false);
        PieChart pieChart = view.findViewById(R.id.pieChart_view);
        showPieChart(pieChart);
        return view;
    }
    private void showPieChart(PieChart pieChart){

        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        String label = "type";

        //initializing data
        Map<String, Integer> typeAmountMap = new HashMap<>();
        typeAmountMap.put(" ",100);
        typeAmountMap.put("",100);


        //initializing colors for the entries
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(getResources().getColor(R.color.papaly_blue));
        colors.add(getResources().getColor(R.color.papaly_white));


        //input data and fit data into pie chart entry
        for(String type: typeAmountMap.keySet()){
            pieEntries.add(new PieEntry(typeAmountMap.get(type).floatValue(), type));
        }

        //collecting the entries with label name
        PieDataSet pieDataSet = new PieDataSet(pieEntries,label);
        //setting text size of the value
        pieDataSet.setValueTextSize(12f);
        //providing color list for coloring different entries
        pieDataSet.setColors(colors);
        //grouping the data set from entry to chart
        PieData pieData = new PieData(pieDataSet);
        //showing the value of the entries, default true if not set
        pieData.setDrawValues(false);

        pieChart.getDescription().setEnabled(false);
        pieChart.setData(pieData);
        pieChart.setHoleColor(getResources().getColor(R.color.papaly_white));
        pieChart.setHoleRadius(80);
        pieChart.setCenterText("500L");
        pieChart.setCenterTextSize(24f);
//        pieChart.setCenterTextTypeface(tf);
        pieChart.setDrawCenterText(false);
        pieChart.setCenterTextColor(getResources().getColor(R.color.papaly_blue));
        pieChart.getLegend().setEnabled(false);
        pieChart.animateX(2000);
        pieChart.setClickable(false);
        pieChart.setRotationEnabled(false);
        pieChart.setHighlightPerTapEnabled(false);
        pieChart.invalidate();
    }
}