package com.wsy.animations;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by songyewang on 16/10/9.
 */

public class ListAnimAdapter extends ArrayAdapter<String> {
    public List<String> items;
    LayoutInflater layoutInflater;

    public static class ViewHolder {
        public TextView textView;
        public String info;
    }

    public ListAnimAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        items = objects;
        layoutInflater = LayoutInflater.from(context);
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return items.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView != null) {
            view = convertView;
        } else {
            view = layoutInflater.inflate(R.layout.list_item, parent, false);
        }
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (viewHolder == null) {
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) view.findViewById(R.id.textView);
        }
        viewHolder.textView.setText(getItem(position));
        view.setTag(viewHolder);
        return view;
    }

    @Override
    public int getCount() {
        return items.size();
    }
}
