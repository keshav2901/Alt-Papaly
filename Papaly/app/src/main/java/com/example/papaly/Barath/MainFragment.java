package com.example.papaly.Barath;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import com.example.papaly.R;

import java.util.Calendar;

public class MainFragment extends Fragment {

    int waterLevelTriggerPercentage1 = 75;
    int timeTriggerLevel = 100;

    RelativeLayout relative_one;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_main, container, false);

        relative_one = view.findViewById(R.id.relative_one);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        float width = displayMetrics.widthPixels;

        relative_one.getLayoutParams().height = height;


        //get temperature from firebase
        float temp = 135.0F;

        //Boolean values
        boolean TimeTriggerState = false;


        //setting value holders for variables
        TextView waterLiter = (TextView) view.findViewById(R.id.tank_liters);
//        TextView temperature = (TextView) view.findViewById(R.id.temp_degree);
//        TextView tankPercentage = (TextView) view.findViewById(R.id.tank_percentage);

        TextView waterLevelTriggerPercentage = (TextView) view.findViewById(R.id.waterLevelTriggerPercentage);

        waterLevelTriggerPercentage.setText(""+ waterLevelTriggerPercentage1);
        //waterLevelTriggerPercentage.setEnabled(true);
        //waterLevelTriggerPercentage.type;

        TextView timeTriggerTime = view.findViewById(R.id.timetriggertime);
        TextView timeTriggerWaterLevel = (TextView) view.findViewById(R.id.timetriggerwaterlevel);

        ToggleButton ManualSwitch = (ToggleButton) view.findViewById(R.id.manualswitchbutton1);

        LinearLayout WaterLevelTrigger = (LinearLayout) view.findViewById(R.id.waterLevelTrigger);
        LinearLayout TimeTrigger = (LinearLayout) view.findViewById(R.id.timeTrigger);

//        ImageView thermometer = (ImageView) view.findViewById(R.id.thermoboys);

        //get time from firebase
        int mHour, mMinute;
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        timeTriggerTime.setText("12:00 AM");

        //*******
        //setting temperature reading on thermometer
        //*******

//        thermometer.setTranslationY(300.0F-temp*2);
        //135F max -30F min


        if(TimeTriggerState==false){
            WaterLevelTrigger.setBackgroundResource(R.drawable.water_level_background_selected);
            TimeTrigger.setBackgroundResource(R.drawable.water_level_background);
        }
        else{
            TimeTrigger.setBackgroundResource(R.drawable.water_level_background_selected);
            WaterLevelTrigger.setBackgroundResource(R.drawable.water_level_background);
        }

        // onclicklistener for manual trigger toggle
        ManualSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ManualSwitch.setAlpha(0);
                    ((TextView) view.findViewById(R.id.manualswitchstate)).setText("ON");
                } else {
                    ManualSwitch.setAlpha(1);
                    ((TextView) view.findViewById(R.id.manualswitchstate)).setText("OFF");//
                }
            }
        });


        //***********
        //Waterlevel or timetrigger setting buttons
        //***********
        view.findViewById(R.id.waterLevelTrigger).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                WaterLevelTrigger.setBackgroundResource(R.drawable.water_level_background);
                TimeTrigger.setBackgroundResource(R.drawable.water_level_background_selected);
            }
        });
        view.findViewById(R.id.timeTrigger).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                TimeTrigger.setBackgroundResource(R.drawable.water_level_background);
                WaterLevelTrigger.setBackgroundResource(R.drawable.water_level_background_selected);
            }
        });

        //***********
        //Time trigger time value
        //add code to send time to firebase
        //***********
        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        if(hourOfDay==0){
                            if(minute<=9){
                                timeTriggerTime.setText((hourOfDay+12) + ":0" + minute +" AM");
                            }
                            else
                                timeTriggerTime.setText((hourOfDay+12) + ":" + minute + " AM");
                        }
                        else if(hourOfDay==12){
                            if(minute<=9){
                                timeTriggerTime.setText((hourOfDay) + ":0" + minute +" PM");
                            }
                            else
                                timeTriggerTime.setText((hourOfDay) + ":" + minute + " PM");
                        }
                        else if(hourOfDay>12)
                        {
                            if(minute<=9){
                                timeTriggerTime.setText((hourOfDay-12) + ":0" + minute + " PM");
                            }
                            else
                                timeTriggerTime.setText((hourOfDay-12) + ":" + minute + " PM");
                        }
                        else{
                            if(minute<=9){
                                timeTriggerTime.setText((hourOfDay) + ":0" + minute + " AM");
                            }
                            else
                                timeTriggerTime.setText((hourOfDay) + ":" + minute + " AM");
                        }

                    }
                }, mHour, mMinute, false);

        //onclick listener for timetrigger time setting button
        view.findViewById(R.id.timetriggertime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });

        view.findViewById(R.id.waterLevelTriggerPercentage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setMessage("Please select water-level percentage for automatic water-level trigger:");
                alert.setTitle("Select Water-level");

                final NumberPicker numberPicker = new NumberPicker(getContext());
                numberPicker.setMaxValue(100);
                numberPicker.setMinValue(15);
                alert.setView(numberPicker);

                alert.setPositiveButton(
                        "Yes",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {
                                // for +ve ....set water level

                                // change value for this
                                //numberPicker.setValue(waterLevelTriggerPercentage1);
                                waterLevelTriggerPercentage1 = (int)numberPicker.getValue();
                                waterLevelTriggerPercentage.setText("" + waterLevelTriggerPercentage1);
                                //finish();
                            }
                        });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //nothing happens
                    }
                });

                alert.show();
            }
        });

        view.findViewById(R.id.timetriggerwaterlevel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setMessage("Please select water-level percentage for automatic water-level trigger:");
                alert.setTitle("Select Water-level");

                final NumberPicker numberPicker = new NumberPicker(getContext());
                numberPicker.setMaxValue(100);
                numberPicker.setMinValue(15);
                alert.setView(numberPicker);

                alert.setPositiveButton(
                        "Yes",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {
                                // for +ve ....set water level

                                // change value for this
                                //numberPicker.setValue(waterLevelTriggerPercentage1);
                                timeTriggerLevel = (int)numberPicker.getValue();
                                timeTriggerWaterLevel.setText("" + timeTriggerLevel);
                                //finish();
                            }
                        });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //nothing happens
                    }
                });

                alert.show();
            }
        });
        
        return view;
    }
}