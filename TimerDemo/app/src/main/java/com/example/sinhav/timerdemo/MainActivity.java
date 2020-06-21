package com.example.sinhav.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /* One way to run the Timer
        final Handler handler = new Handler(); // Handler Runs the Runnable

        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.i("Info", "A second is gone");

                handler.postDelayed(this,1000);
            }
        };

        handler.post(run) ;
        */

         /* CountDown Timer */
         new CountDownTimer(10000, 1000) {

             @Override
             public void onTick(long l) {
                 Log.i("Seconds Left!",String.valueOf(l/1000));
             }

             @Override
             public void onFinish() {
                Log.i("Done!", "No more CountDown");
             }
         }.start();
    }
}
