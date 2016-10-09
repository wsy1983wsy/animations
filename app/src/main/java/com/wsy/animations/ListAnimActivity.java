package com.wsy.animations;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songyewang on 16/10/9.
 */

public class ListAnimActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        ListView listView = (ListView) findViewById(R.id.listView);
        List<String> items = new ArrayList<>();
        items.add("1");
        items.add("2");
        items.add("3");
        items.add("4");
        items.add("5");
        items.add("6");
        items.add("7");
        items.add("8");
        items.add("9");
        items.add("10");
        items.add("11");
        items.add("12");
        listView.setAdapter(new ListAnimAdapter(this, R.layout.list_item, items));
    }


}

