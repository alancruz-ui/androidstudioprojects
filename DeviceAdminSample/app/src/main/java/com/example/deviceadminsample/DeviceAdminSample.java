package com.example.deviceadminsample;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import android.preference.Preference;
import android.widget.Toast;

public class DeviceAdminSample extends DeviceAdminReceiver {
    void showToast(Context context, String msg) {
        String status= context.getString(R.string.admin_receiver_status, msg);
        Toast.makeText(context, status, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEnabled(Context context, Intent intent) {
        showToast(context, context.getString(R.string.admin_receiver_status_enabled));
    }

    @Override
    public CharSequence onDisableRequested(Context context, Intent intent) {
        return context.getString(R.string.admin_receiver_status_disable_warning);
    }

    @Override
    public void onDisabled(Context context, Intent intent) {
        showToast(context, context.getString(R.string.admin_receiver_status_disabled));
    }

    @Override
    public void onPasswordChanged(Context context, Intent intent, userHandle:UserHandle) {
        showToast(context, context.getString(R.string.admin_receiver_status_pw_changed));
    }
    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if (super.onPreferenceChange(preference, newValue)) {
            return true;
        }
        boolean value = (Boolean) newValue;
        if (preference == enableCheckbox) {
            if (value != adminActive) {
                if (value) {
                    // Launch the activity to have the user enable our admin.
                    Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
                    intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, deviceAdminSample);
                    intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                            activity.getString(R.string.add_admin_extra_app_text));
                    startActivityForResult(intent, REQUEST_CODE_ENABLE_ADMIN);
                    // return false - don't update checkbox until we're really active
                    return false;
                } else {
                    dpm.removeActiveAdmin(deviceAdminSample);
                    enableDeviceCapabilitiesArea(false);
                    adminActive = false;
                }
            }
        } else if (preference == disableCameraCheckbox) {
            dpm.setCameraDisabled(deviceAdminSample, value);
        }
        return true;
    }
}

