package com.example.sinhav.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean show = true;
    public void fade(View view){

        Log.i("Info","ImageView Tapped");

        ImageView dog1 = (ImageView) findViewById(R.id.imageView1);
        ImageView dog2 = (ImageView) findViewById(R.id.imageView2);
        /*if(show == true){
            dog1.animate().alpha(0).setDuration(2000);
            dog2.animate().alpha(1).setDuration(2000);
            show = false;
        }else{
            dog1.animate().alpha(1).setDuration(2000);
            dog2.animate().alpha(0).setDuration(2000);
            show = true;
        }*/
        dog1.animate().translationXBy(1000).setDuration(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
