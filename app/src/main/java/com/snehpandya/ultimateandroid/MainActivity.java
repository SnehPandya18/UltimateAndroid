package com.snehpandya.ultimateandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView widgets = (TextView) findViewById(R.id.widgets);
        widgets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent widgetsIntent = new Intent(MainActivity.this, WidgetsActivity.class);
                startActivity(widgetsIntent);
            }
        });
    }
}