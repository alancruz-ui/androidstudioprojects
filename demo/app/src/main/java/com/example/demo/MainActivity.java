package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;


import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.SystemClock;

public class MainActivity extends AppCompatActivity {
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;
    public static DevicePolicyManager devicePolicyManager;
    ComponentName devAdminReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        devicePolicyManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
        devAdminReceiver = new ComponentName(this, DeviceAdminReceiver.class);





        if (sensor == null)
            finish();

            sensorEventListener = new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent sensorEvent) {

                    if (sensorEvent.values[0] < sensor.getMaximumRange()) {
                       LockNows();

                    } else {
                        getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                    }
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) {

                }
            };
           start();
        }
        public void start(){
        sensorManager.registerListener(sensorEventListener, sensor, 2000 * 1000);

       }
        public void stop(){
        sensorManager.unregisterListener(sensorEventListener);
        }

    @Override
    protected void onPause() {
        stop();
        super.onPause();
    }

    @Override
    protected void onResume() {
        start();
        LockNows();
        super.onResume();

    }
    public void LockNows() {
        devicePolicyManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
        devAdminReceiver = new ComponentName(this, DeviceAdminReceiver.class);
        boolean active=devicePolicyManager.isAdminActive(devAdminReceiver);
        if(active){
           // devicePolicyManager.resetPassword(Password,DevicePolicyManager.RESET_PASSWORD_REQUIRE_ENTRY);
            devicePolicyManager.lockNow();
        }

    }


}

