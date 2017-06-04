package com.snehpandya.ultimateandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BatteryActivity extends AppCompatActivity {

    TextView batteryInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

         batteryInfo = (TextView) findViewById(R.id.batteryinfo);

        registerReceiver(this.batteryInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    BroadcastReceiver batteryInfoReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int health = intent.getIntExtra(BatteryManager.EXTRA_HEALTH,0);
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED,0);
            boolean present = intent.getExtras().getBoolean(BatteryManager.EXTRA_PRESENT);
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS,0);
            String technology = intent.getExtras().getString(BatteryManager.EXTRA_TECHNOLOGY);
            int temperature = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,0);
            int voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE,0);

            batteryInfo.setText("Health: "+health
            +"\nLevel: "+level
            +"\nPlugged in: "+plugged
            +"\nPresent: "+present
            +"\nStatus: "+status
            +"\nTechnology: "+technology
            +"\nTemperature: "+temperature
            +"\nVoltage: "+voltage);
        }
    };
}
