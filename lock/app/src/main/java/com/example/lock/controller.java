package com.example.lock;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

class controller extends DeviceAdminReceiver {


    public void onEnable(Context context, Intent intent){
        Toast.makeText(context, "Enable", Toast.LENGTH_SHORT).show();
    }
    public  void onDisable(Context context,Intent intent){
        Toast.makeText(context, "Disable", Toast.LENGTH_SHORT).show();
    }
}
