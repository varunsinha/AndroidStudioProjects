package com.example.sinhav.imagedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public  void changePicture(View view){
        ImageView view1 = findViewById(R.id.imageView1);
        view1.setImageResource(R.drawable.dog2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
