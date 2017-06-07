package com.snehpandya.ultimateandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Sneh on 07-06-2017.
 */

public class CustomListView extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView mListView;
    ListViewAdapter mListViewAdapter;
    private final static String months[] = {"January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December"};

    private final static String numbers[] = {"Month 1","Month 2","Month 3","Month 4","Month 5","Month 6","Month 7",
            "Month 8","Month 9","Month 10","Month 11","Month 12"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        mListView = (ListView) findViewById(R.id.listview1);
        mListViewAdapter = new ListViewAdapter(this, months, numbers);
        mListView.setAdapter(mListViewAdapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, months[position]+" month, Description: "+numbers[position], Toast.LENGTH_SHORT).show();
    }
}
