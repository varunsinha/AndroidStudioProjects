package com.example.sinhav.downloadingimages;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    public void downloadImage(View view){

        Log.i("Button Tapped","ok");
        ImageDownloader task = new ImageDownloader();
        Bitmap myImage = null;

        try {
            myImage = task.execute("https://imagevars.gulfnews.com/2019/07/20/MS-Dhoni_16c0e955558_large.jpg").get();

            imageView.setImageBitmap(myImage);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
    }

    public class ImageDownloader extends AsyncTask<String, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {

            try {
                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream in = connection.getInputStream();

                Bitmap myBitMap = BitmapFactory.decodeStream(in);

                return  myBitMap;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }
    }
}
