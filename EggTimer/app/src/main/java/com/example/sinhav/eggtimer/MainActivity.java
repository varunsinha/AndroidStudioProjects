package com.example.sinhav.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    TextView timerView;
    Button startButton;
    SeekBar seekBar;

    CountDownTimer countDownTimer;
    Boolean counterIsActive = false;

    public void resetTimer(){
        seekBar.setEnabled(true);
        seekBar.setProgress(30);
        countDownTimer.cancel();
        timerView.setText("0:30");
        startButton.setText("Start");
        counterIsActive = false;
    }

    public void startTimer(View view) {
        if(counterIsActive) {
            resetTimer();
        }
        else
        {
            counterIsActive = true;

            seekBar.setEnabled(false);
            startButton = (Button) findViewById(R.id.startButton);
            startButton.setText("Stop");

            countDownTimer = new CountDownTimer(seekBar.getProgress()*1000, 1000) {

                @Override
                public void onTick(long l) {
                    updateTimer((int)l/1000);
                }

                @Override
                public void onFinish() {
                    Log.i("Done!", "No more CountDown");
                    mediaPlayer.start();
                    resetTimer();
                }
            }.start();
        }
    }


    public void updateTimer(int secondsLeft) {
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft % 60;

        String sec = Integer.toString(seconds);
        if(sec.equals("0")) {
            sec = "00";
        }
        else if(sec.length() == 1){
            sec = "0"+sec;
        }
        timerView.setText(Integer.toString(minutes) + ":" + sec);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        timerView = (TextView) findViewById(R.id.displayTimer);

        mediaPlayer = MediaPlayer.create(this, R.raw.airhorn);

        /*10 min*/
        seekBar.setMax(600);
        /*30 sec*/
        seekBar.setProgress(30);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateTimer(i);
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
