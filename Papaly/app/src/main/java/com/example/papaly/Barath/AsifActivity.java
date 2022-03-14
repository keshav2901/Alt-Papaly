//package com.example.papaly.Barath;
//
//import android.app.TimePickerDialog;
//import android.content.DialogInterface;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.CompoundButton;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.NumberPicker;
//import android.widget.TextView;
//import android.widget.TimePicker;
//import android.widget.ToggleButton;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//
//import com.example.papaly.R;
//
//import java.util.Calendar;
//
//public class AsifActivity extends Fragment {
//    int waterLevelTriggerPercentage1 = 75;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        View v = inflater.inflate(R.layout.fragment_main, container, false);
//
//
//        //get temperature from firebase
//        float temp = 135.0F;
//
//        //Boolean values
//        boolean TimeTriggerState = false;
//
//
//        //setting value holders for variables
//        TextView waterLiter = (TextView) v.findViewById(R.id.tank_liters);
////        TextView temperature = (TextView) v.findViewById(R.id.temp_degree);
////        TextView tankPercentage = (TextView) v.findViewById(R.id.tank_percentage);
//
//        TextView waterLevelTriggerPercentage = (TextView) v.findViewById(R.id.waterLevelTriggerPercentage);
//
//        waterLevelTriggerPercentage.setText(""+ waterLevelTriggerPercentage1);
//        //waterLevelTriggerPercentage.setEnabled(true);
//        //waterLevelTriggerPercentage.type;
//
//        TextView timeTriggerTime = v.findViewById(R.id.timetriggertime);
//        TextView timeTriggerWaterLevel = (TextView) v.findViewById(R.id.timetriggerwaterlevel);
//
//        ToggleButton ManualSwitch = (ToggleButton) v.findViewById(R.id.manualswitchbutton1);
//
//        LinearLayout WaterLevelTrigger = (LinearLayout) v.findViewById(R.id.waterLevelTrigger);
//        LinearLayout TimeTrigger = (LinearLayout) v.findViewById(R.id.timeTrigger);
//
////        ImageView thermometer = (ImageView) v.findViewById(R.id.thermoboys);
//
//        //get time from firebase
//        int mHour, mMinute;
//        final Calendar c = Calendar.getInstance();
//        mHour = c.get(Calendar.HOUR_OF_DAY);
//        mMinute = c.get(Calendar.MINUTE);
//        timeTriggerTime.setText("12:00 AM");
//
//
//
//        //*******
//        //setting temperature reading on thermometer
//        //*******
//
////        thermometer.setTranslationY(300.0F-temp*2);
//        //135F max -30F min
//
//        /*if(TimeTriggerState==false){
//            WaterLevelTrigger.setBackgroundResource(R.drawable.selectedbutton);
//            TimeTrigger.setBackgroundResource(R.drawable.unselectedbutton);
//        }
//        else{
//            TimeTrigger.setBackgroundResource(R.drawable.selectedbutton);
//            WaterLevelTrigger.setBackgroundResource(R.drawable.unselectedbutton);
//        }*/
//
//        // onclicklistener for manual trigger toggle
//        ManualSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    ManualSwitch.setAlpha(0);
//                    ((TextView) v.findViewById(R.id.manualswitchstate)).setText("ON");
//                    v.setKeepScreenOn(true);
//                } else {
//                    ManualSwitch.setAlpha(1);
//                    ((TextView) v.findViewById(R.id.manualswitchstate)).setText("OFF");
//                    v.setKeepScreenOn(false);
//
//                }
//            }
//        });
//
//
//        //***********
//        //Waterlevel or timetrigger setting buttons
//        //***********
////        v.findViewById(R.id.waterLevelTrigger).setOnClickListener(new View.OnClickListener(){
////
////            @Override
////            public void onClick(View v) {
////                WaterLevelTrigger.setBackgroundResource(R.drawable.water_level_background);
////                TimeTrigger.setBackgroundResource(R.drawable.water_level_background);
////            }
////        });
////        v.findViewById(R.id.timeTrigger).setOnClickListener(new View.OnClickListener(){
////
////            @Override
////            public void onClick(View v) {
////                TimeTrigger.setBackgroundResource(R.drawable.water_level_background);
////                WaterLevelTrigger.setBackgroundResource(R.drawable.water_level_background);
////            }
////        });
//
//        //***********
//        //Time trigger time value
//        //add code to send time to firebase
//        //***********
//        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
//                new TimePickerDialog.OnTimeSetListener() {
//
//                    @Override
//                    public void onTimeSet(TimePicker view, int hourOfDay,
//                                          int minute) {
//                        if(hourOfDay==0){
//                            if(minute==0){
//                                timeTriggerTime.setText((hourOfDay+12) + ":00"  + " AM");
//                            }
//                            else
//                                timeTriggerTime.setText((hourOfDay+12) + ":" + minute + " AM");
//                        }
//                        else if(hourOfDay==12){
//                            if(minute==0){
//                                timeTriggerTime.setText((hourOfDay) + ":00" + " PM");
//                            }
//                            else
//                                timeTriggerTime.setText((hourOfDay) + ":" + minute + " PM");
//                        }
//                        else if(hourOfDay>12)
//                        {
//                            if(minute==0){
//                                timeTriggerTime.setText((hourOfDay-12) + ":00" + " PM");
//                            }
//                            else
//                                timeTriggerTime.setText((hourOfDay-12) + ":" + minute + " PM");
//                        }
//                        else{
//                            if(minute==0){
//                                timeTriggerTime.setText((hourOfDay) + ":00" + " AM");
//                            }
//                            else
//                                timeTriggerTime.setText((hourOfDay) + ":" + minute + " AM");
//                        }
//
//                    }
//                }, mHour, mMinute, false);
//
//        //onclick listener for timetrigger time setting button
//        v.findViewById(R.id.timetriggertime).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                timePickerDialog.show();
//            }
//        });
//
//        v.findViewById(R.id.waterLevelTriggerPercentage).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
//                alert.setMessage("Please select water-level percentage for automatic water-level trigger:");
//                alert.setTitle("Select Water-level");
//
//                final NumberPicker numberPicker = new NumberPicker(getContext());
//                numberPicker.setMaxValue(100);
//                numberPicker.setMinValue(15);
//                alert.setView(numberPicker);
//
//                alert.setPositiveButton(
//                        "Yes",
//                        new DialogInterface
//                                .OnClickListener() {
//
//                            @Override
//                            public void onClick(DialogInterface dialog,
//                                                int which)
//                            {
//                                // for +ve ....set water level
//
//                                // change value for this
//                                //numberPicker.setValue(waterLevelTriggerPercentage1);
//                                waterLevelTriggerPercentage1 = (int)numberPicker.getValue();
//                                waterLevelTriggerPercentage.setText("" + waterLevelTriggerPercentage1);
//                                //finish();
//                            }
//                        });
//
//                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
//                        //nothing happens
//                    }
//                });
//
//                alert.show();
//            }
//        });
//
//        return v;
//
//    }
//
//    //---------------------
//
//
//
//    public void onBackPressed()
//    {
//
//        // Create the object of
//        // AlertDialog Builder class
//        AlertDialog.Builder builder
//                = new AlertDialog
//                .Builder(getContext());
//
//        // Set the message show for the Alert time
//        builder.setMessage("Do you want to exit ?");
//
//        // Set Alert Title
//        builder.setTitle("Alert !");
//
//        // Set Cancelable false
//        // for when the user clicks on the outside
//        // the Dialog Box then it will remain show
//        builder.setCancelable(false);
//
//        // Set the positive button with yes name
//        // OnClickListener method is use of
//        // DialogInterface interface.
//
//        builder
//                .setPositiveButton(
//                        "Yes",
//                        new DialogInterface
//                                .OnClickListener() {
//
//                            @Override
//                            public void onClick(DialogInterface dialog,
//                                                int which)
//                            {
//
//                                // When the user click yes button
//                                // then app will close
////                                finish();
//                            }
//                        });
//
//        // Set the Negative button with No name
//        // OnClickListener method is use
//        // of DialogInterface interface.
//        builder
//                .setNegativeButton(
//                        "No",
//                        new DialogInterface
//                                .OnClickListener() {
//
//                            @Override
//                            public void onClick(DialogInterface dialog,
//                                                int which)
//                            {
//
//                                // If user click no
//                                // then dialog box is canceled.
//                                dialog.cancel();
//                            }
//                        });
//
//        // Create the Alert dialog
//        AlertDialog alertDialog = builder.create();
//
//        // Show the Alert Dialog box
//        alertDialog.show();
//    }
//
//    //---------------------
//
//}