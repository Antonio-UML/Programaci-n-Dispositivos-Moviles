package com.example.practica6audiointerno;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ejecutar(View v)
    {
        File audioFile = new File("/sdcard/Download/Wow.mp3");

// Verifica si el archivo existe
        if (audioFile.exists()) {
            // Crea un URI utilizando FileProvider
            Uri audioUri = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".fileprovider", audioFile);

            // Crea un intent para abrir el archivo de audio
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
            intent.setDataAndType(audioUri, "audio/*");
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); // Concede permisos de lectura al otro componente

            // Inicia la actividad con el intent
            startActivity(intent);
        } else {
            // El archivo no existe, maneja el error o muestra un mensaje al usuario
            Toast.makeText(this, "El archivo Wow.mp3 no existe.", Toast.LENGTH_SHORT).show();
        }
    }


}