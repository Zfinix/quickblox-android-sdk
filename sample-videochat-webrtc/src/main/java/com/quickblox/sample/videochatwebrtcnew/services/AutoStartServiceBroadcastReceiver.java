package com.quickblox.sample.videochatwebrtcnew.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.quickblox.sample.videochatwebrtcnew.definitions.Consts;

/**
 * QuickBlox team
 */
public class AutoStartServiceBroadcastReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Consts.SHARED_PREFERENCES, Context.MODE_PRIVATE);
        String login = sharedPreferences.getString(Consts.USER_LOGIN, null);
        String password = sharedPreferences.getString(Consts.USER_PASSWORD, null);

        if (!TextUtils.isEmpty(login) && !TextUtils.isEmpty(password)) {
            Intent serviceIntent = new Intent(context, IncomeCallListenerService.class);
            serviceIntent.putExtra(Consts.USER_LOGIN, login);
            serviceIntent.putExtra(Consts.USER_PASSWORD, password);
            serviceIntent.putExtra(Consts.START_SERVICE_VARIANT, Consts.AUTOSTART);
            context.startService(serviceIntent);
        }
    }
}
