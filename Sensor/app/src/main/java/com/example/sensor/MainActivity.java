package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor sensor;
    TextView mmuestrasensores;
    ConstraintLayout cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creamos la instancia del textview donde nos dara los sensores disponibles del telefono
        mmuestrasensores=findViewById(R.id.muestrasensores);
        cl=findViewById(R.id.mcl);
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);





    }

    @Override
    public void onSensorChanged(SensorEvent event) {
    float x,y,z;
        x=event.values[0];
        y=event.values[1];
        z=event.values[2];
        mmuestrasensores.append("\n" +"el valor de x es:"+ x +"\n"+"el valor de y es "+y+"\n"+"el valor de z es"+z);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}