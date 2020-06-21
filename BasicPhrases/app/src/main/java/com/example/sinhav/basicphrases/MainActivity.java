package com.example.sinhav.basicphrases;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public void playPhrase(View view) {

        Button buttonPressed = (Button)view;

        String tagName = buttonPressed.getTag().toString();

        MediaPlayer mediaPlayer = MediaPlayer.create(this,
                getResources().getIdentifier(tagName, "raw", getPackageName()));

        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}