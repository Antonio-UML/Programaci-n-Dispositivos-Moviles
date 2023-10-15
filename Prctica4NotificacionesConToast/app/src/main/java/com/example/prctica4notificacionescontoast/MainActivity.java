package com.example.prctica4notificacionescontoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.et1);
        num = (int)(Math.random()*10001);
        String cadena = String.valueOf(num);
        Toast notification = Toast.makeText(this,cadena,Toast.LENGTH_LONG);
        notification.show();
    }

    public void controlar(View view){
        String valorIngresado= et1.getText().toString();
        int valor = Integer.parseInt(valorIngresado);
        if(valor==num){
            Toast notification= Toast.makeText(this, "Muy bien ese es el numero",Toast.LENGTH_LONG);
            notification.show();
        }else{
            Toast notification= Toast.makeText(this, "Ese no es el numero ",Toast.LENGTH_LONG);
            notification.show();
        }
    }
}