package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.content.BroadcastReceiver;
import android.widget.Button;
import android.widget.Toast;

//Runtime based broadcast receiver

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver receiver;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btn);
        receiver = new BroadcastReceiver(){
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "Broadcast received...", Toast.LENGTH_LONG).show();
            }
        };

        btn.setOnClickListener(v->{
            sendIntent();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter("ACTION_BTN_CLICK");
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(receiver != null) {
            unregisterReceiver(receiver);
        }
    }

    public void sendIntent() {
        Intent intent = new Intent("ACTION_BTN_CLICK");
        sendBroadcast(intent);
    }
}