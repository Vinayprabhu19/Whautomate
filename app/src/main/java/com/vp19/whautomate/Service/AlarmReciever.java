package com.vp19.whautomate.Service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.vp19.whautomate.MainActivity;

public class AlarmReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent)
    {   //Build pending intent from calling information to display Notification

        String message = intent.getStringExtra("message");
        String phone = intent.getStringExtra("phone");

        Log.w("myApp","Reciever "+message+phone);
        Log.w("myApp",context.getApplicationInfo().toString());

        WhautomateService.sendWhatsappMessage(context,message,phone);
        //display that alarm is ringing
        Toast.makeText(context, "Alarm Ringing...!!!", Toast.LENGTH_LONG).show();
    }}