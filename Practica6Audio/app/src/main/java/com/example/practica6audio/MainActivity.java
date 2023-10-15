package com.example.practica6audio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclickPerro (View v){
        MediaPlayer mp = MediaPlayer.create(this,R.raw.perro);
        mp.start();
    }

    public void onclickPaloma (View v){
        MediaPlayer mp = MediaPlayer.create(this,R.raw.paloma);
        mp.start();
    }
}