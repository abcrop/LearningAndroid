package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        System.out.println("Broadcast Received...");
        Toast.makeText(context, "Airplane mood activated", Toast.LENGTH_SHORT).show();
    }
}
