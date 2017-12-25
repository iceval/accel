package com.example.ugs.people;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    public static Sensor accel;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SensorManager sm =(SensorManager) getSystemService(SENSOR_SERVICE);
        accel =sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        tv = (TextView)findViewById(R.id.textView);
        sm.registerListener(this, accel,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        tv.setText("v1:" + sensorEvent.values[0] + "\nv2:" + sensorEvent.values[1] + "\nv3:" + sensorEvent.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
