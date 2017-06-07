package com.snehpandya.ultimateandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Sneh on 07-06-2017.
 */

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView mListView;
    private final static String months[] = {"January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        mListView = (ListView) findViewById(R.id.listview1);
        mListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, months));
        mListView.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, months[position] + " month", Toast.LENGTH_SHORT).show();
    }
}
