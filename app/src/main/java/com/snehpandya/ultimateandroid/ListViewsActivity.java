package com.snehpandya.ultimateandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Sneh on 07-06-2017.
 */

public class ListViewsActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviews);

        TextView listview = (TextView) findViewById(R.id.listview);
        listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listviewIntent = new Intent(ListViewsActivity.this, ListViewActivity.class);
                startActivity(listviewIntent);
            }
        });

        TextView customlistview = (TextView) findViewById(R.id.customlistview);
        customlistview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent customlistviewIntent = new Intent(ListViewsActivity.this, CustomListView.class);
                startActivity(customlistviewIntent);
            }
        });
    }
}
