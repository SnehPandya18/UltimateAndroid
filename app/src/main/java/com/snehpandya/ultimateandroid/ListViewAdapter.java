package com.snehpandya.ultimateandroid;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Sneh on 07-06-2017.
 */

public class ListViewAdapter extends BaseAdapter {
    Activity context;
    String title[];
    String description[];
    LayoutInflater mLayoutInflater;

    public ListViewAdapter(Activity context, String[] title, String[] description) {
        super();
        this.context = context;
        this.title = title;
        this.description = description;
        this.mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView textViewTitle;
        TextView textViewDescription;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.list_item, null);

            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageview);
            viewHolder.textViewTitle = (TextView) convertView.findViewById(R.id.textview1);
            viewHolder.textViewDescription = (TextView) convertView.findViewById(R.id.textview2);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.imageView.setImageResource(R.drawable.image);
        viewHolder.textViewTitle.setText(title[position]);
        viewHolder.textViewDescription.setText(description[position]);

        return convertView;
    }
}
