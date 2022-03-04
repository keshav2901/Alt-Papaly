package com.example.papaly.Barath;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.papaly.R;

import java.util.Calendar;

public class AsifActivity extends AppCompatActivity {
    int waterLevelTriggerPercentage1 = 75;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View v = getLayoutInflater().inflate(R.layout.activity_mainasif, null);
        setContentView(v);


        //get temperature from firebase
        float temp = 135.0F;

        //Boolean values
        boolean TimeTriggerState = false;


        //setting value holders for variables
        TextView waterLiter = (TextView) findViewById(R.id.tank_liters);
        TextView temperature = (TextView) findViewById(R.id.temp_degree);
        TextView tankPercentage = (TextView) findViewById(R.id.tank_percentage);

        TextView waterLevelTriggerPercentage = (TextView) findViewById(R.id.waterLevelTriggerPercentage);

        waterLevelTriggerPercentage.setText(""+ waterLevelTriggerPercentage1);
        //waterLevelTriggerPercentage.setEnabled(true);
        //waterLevelTriggerPercentage.type;
        
        TextView timeTriggerTime = findViewById(R.id.timetriggertime);
        TextView timeTriggerWaterLevel = (TextView) findViewById(R.id.timetriggerwaterlevel);

        ToggleButton ManualSwitch = (ToggleButton) findViewById(R.id.manualswitchbutton1);

        LinearLayout WaterLevelTrigger = (LinearLayout) findViewById(R.id.waterLevelTrigger);
        LinearLayout TimeTrigger = (LinearLayout) findViewById(R.id.timeTrigger);

        ImageView thermometer = (ImageView) findViewById(R.id.thermoboys);

        //get time from firebase
        int mHour, mMinute;
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        timeTriggerTime.setText("12:00 AM");



        //*******
        //setting temperature reading on thermometer
        //*******

        thermometer.setTranslationY(300.0F-temp*2);
        //135F max -30F min


        if(TimeTriggerState==false){
            WaterLevelTrigger.setBackground(getDrawable(R.drawable.selectedbutton));
            TimeTrigger.setBackground(getDrawable(R.drawable.unselectedbutton));
        }
        else{
            TimeTrigger.setBackground(getDrawable(R.drawable.selectedbutton));
            WaterLevelTrigger.setBackground(getDrawable(R.drawable.unselectedbutton));
        }

        // onclicklistener for manual trigger toggle
        ManualSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ManualSwitch.setAlpha(0);
                    ((TextView) findViewById(R.id.manualswitchstate)).setText("ON");
                    v.setKeepScreenOn(true);
                } else {
                    ManualSwitch.setAlpha(1);
                    ((TextView) findViewById(R.id.manualswitchstate)).setText("OFF");
                    v.setKeepScreenOn(false);

                }
            }
        });


        //***********
        //Waterlevel or timetrigger setting buttons
        //***********
        v.findViewById(R.id.waterLevelTrigger).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                WaterLevelTrigger.setBackground(getDrawable(R.drawable.selectedbutton));
                TimeTrigger.setBackground(getDrawable(R.drawable.unselectedbutton));
            }
        });
        v.findViewById(R.id.timeTrigger).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                TimeTrigger.setBackground(getDrawable(R.drawable.selectedbutton));
                WaterLevelTrigger.setBackground(getDrawable(R.drawable.unselectedbutton));
            }
        });

        //***********
        //Time trigger time value
        //add code to send time to firebase
        //***********
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            if(hourOfDay==0){
                                if(minute==0){
                                    timeTriggerTime.setText((hourOfDay+12) + ":00"  + " AM");
                                }
                                else
                                timeTriggerTime.setText((hourOfDay+12) + ":" + minute + " AM");
                            }
                            else if(hourOfDay==12){
                                if(minute==0){
                                    timeTriggerTime.setText((hourOfDay) + ":00" + " PM");
                                }
                                else
                                timeTriggerTime.setText((hourOfDay) + ":" + minute + " PM");
                            }
                            else if(hourOfDay>12)
                            {
                                if(minute==0){
                                    timeTriggerTime.setText((hourOfDay-12) + ":00" + " PM");
                                }
                                else
                                timeTriggerTime.setText((hourOfDay-12) + ":" + minute + " PM");
                            }
                            else{
                                if(minute==0){
                                    timeTriggerTime.setText((hourOfDay) + ":00" + " AM");
                                }
                                else
                                timeTriggerTime.setText((hourOfDay) + ":" + minute + " AM");
                            }

                        }
                    }, mHour, mMinute, false);

            //onclick listener for timetrigger time setting button
            findViewById(R.id.timetriggertime).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    timePickerDialog.show();
                }
            });

            findViewById(R.id.waterLevelTriggerPercentage).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(AsifActivity.this);
                    alert.setMessage("Please select water-level percentage for automatic water-level trigger:");
                    alert.setTitle("Select Water-level");

                    final NumberPicker numberPicker = new NumberPicker(AsifActivity.this);
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
    }

    //---------------------



    @Override
    public void onBackPressed()
    {

        // Create the object of
        // AlertDialog Builder class
        AlertDialog.Builder builder
                = new AlertDialog
                .Builder(AsifActivity.this);

        // Set the message show for the Alert time
        builder.setMessage("Do you want to exit ?");

        // Set Alert Title
        builder.setTitle("Alert !");

        // Set Cancelable false
        // for when the user clicks on the outside
        // the Dialog Box then it will remain show
        builder.setCancelable(false);

        // Set the positive button with yes name
        // OnClickListener method is use of
        // DialogInterface interface.

        builder
                .setPositiveButton(
                        "Yes",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {

                                // When the user click yes button
                                // then app will close
                                finish();
                            }
                        });

        // Set the Negative button with No name
        // OnClickListener method is use
        // of DialogInterface interface.
        builder
                .setNegativeButton(
                        "No",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {

                                // If user click no
                                // then dialog box is canceled.
                                dialog.cancel();
                            }
                        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();

        // Show the Alert Dialog box
        alertDialog.show();
    }

    //---------------------

}