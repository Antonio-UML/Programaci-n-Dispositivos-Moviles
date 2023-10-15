package com.example.practica6audiointernet;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void reproducir(View v){
        MediaPlayer mp = new MediaPlayer();
        try {
            mp.setDataSource("https://sonidosmp3.net/wp-content/uploads/2021/08/Google-Pixel-4-Adventure.mp3");
            mp.prepareAsync();
            Toast.makeText(this,"Espere un momento",Toast.LENGTH_LONG).show();
        }catch (IOException e){
            Toast.makeText(this,"Hubo un error",Toast.LENGTH_LONG).show();

        }
        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                mp.start();
            }
        });
    }
}