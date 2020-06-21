package com.example.sinhav.seektable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    public void generateNumber(int i) {

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for(int index = 1; index <= 10; index++) {
            numbers.add(i*index);
        }

        listView = (ListView)findViewById(R.id.listView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, numbers);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        int max = 20;
        int startingPosition = 10;
        seekBar.setMax(max);
        seekBar.setProgress(startingPosition);

        generateNumber(startingPosition);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timeTableNumber;
                if(i < min){
                    timeTableNumber = min;
                    seekBar.setProgress(timeTableNumber);
                }else
                {
                    timeTableNumber = i;
                }
                Log.i("Seek Bar changed", Integer.toString(i));
                generateNumber(timeTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
