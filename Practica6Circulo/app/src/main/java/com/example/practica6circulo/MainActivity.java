package com.example.practica6circulo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private int corx,cory;
    private Lienzo fondo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        corx=100;
        cory=100;
        ConstraintLayout layout1 = (ConstraintLayout) findViewById(R.id.layout1);
        fondo = new Lienzo (this);
        fondo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                corx = (int) event.getX();
                cory=(int) event.getY();
                fondo.invalidate();
                return true;
            }
        });
        layout1.addView(fondo);

    }


    public boolean onTouch(View view, MotionEvent event) {
        corx = (int) event.getX();
        cory=(int) event.getY();
        fondo.invalidate();
        return true;
    }
    class Lienzo extends View{
        public Lienzo (Context context){
            super(context);
        }

        protected void onDraw(Canvas canvas){
            canvas.drawRGB(255,255,0);
            Paint pincel1 = new Paint();
            pincel1.setARGB(255,255,0,0);
            pincel1.setStrokeWidth(4);
            pincel1.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(corx,cory,50, pincel1);
        }
    }
}