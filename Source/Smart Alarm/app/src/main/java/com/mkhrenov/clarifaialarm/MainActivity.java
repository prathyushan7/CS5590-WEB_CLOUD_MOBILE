package com.mkhrenov.clarifaialarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.mkhrenov.clarifaialarm.MESSAGE";
    public TimePicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        picker = (TimePicker)findViewById(R.id.timepicker);
    }

    public void setAlarm(View view) throws ParseException {
        EditText object = findViewById(R.id.object);

        Calendar calendar = Calendar.getInstance();
        int dat = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH)+1;
        int year = calendar.get(Calendar.YEAR);

        String date = year+"-"+month+"-"+dat;

        String hour = Integer.toString(picker.getCurrentHour());
        String minute = Integer.toString(picker.getCurrentMinute());

        String dateString = date + " " + hour + ":" + minute;
        System.out.println(dateString);

        Date dateTime = (new SimpleDateFormat("yy-MM-dd HH:mm")).parse(dateString);

        Intent alarmIntent = new Intent(this, AlarmActivity.class);
        alarmIntent.putExtra(EXTRA_MESSAGE, object.getText().toString());
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, dateTime.getTime(),
                PendingIntent.getActivity(this, 1, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT));
        finish();
    }


}
