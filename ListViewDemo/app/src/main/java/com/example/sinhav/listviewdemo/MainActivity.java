package com.example.sinhav.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListview = findViewById(R.id.myListView);

        final ArrayList<String> myFamily = new ArrayList<String>();

        myFamily.add("Mom");
        myFamily.add("Dad");
        myFamily.add("Juhi");
        myFamily.add("Puja");
        myFamily.add("Varun");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, myFamily);

        myListview.setAdapter(arrayAdapter);

        myListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Log.i("Name is ", myFamily.get(i));
            }
        });

    }
}
