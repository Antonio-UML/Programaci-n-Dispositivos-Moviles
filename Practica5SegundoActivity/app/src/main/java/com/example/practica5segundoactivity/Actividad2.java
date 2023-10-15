package com.example.practica5segundoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Actividad2 extends AppCompatActivity {

    private WebView webView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        webView1 = (WebView) findViewById(R.id.webView);

        // Configura un WebViewClient para manejar las URL dentro de tu WebView
        webView1.setWebViewClient(new WebViewClient());

        // Habilita JavaScript si es necesario
        webView1.getSettings().setJavaScriptEnabled(true);

        Bundle bundle = getIntent().getExtras();
        String dato = bundle.getString("direccion");
        webView1.loadUrl("https://"+dato);
    }

    public void finalizar(View v){
        finish();
    }
}