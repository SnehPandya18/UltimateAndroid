package com.snehpandya.ultimateandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

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

        TextView webview = (TextView) findViewById(R.id.webview);
        webview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webviewIntent = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(webviewIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu item) {
        getMenuInflater().inflate(R.menu.menu_main, item);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.aboutmenu) {
            Toast.makeText(this, "Menu Item: About", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}