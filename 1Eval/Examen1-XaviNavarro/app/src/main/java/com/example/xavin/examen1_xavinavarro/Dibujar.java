package com.example.xavin.examen1_xavinavarro;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class Dibujar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dibujar);
    }
    public class Dibujo extends View {

        public Dibujo(Context context) { super(context); }

        float x=50;
        float y=50;
        String accion = "accion";

        Path path = new Path();

        protected void onDraw(Canvas canvas) {

            Paint pizza = new Paint();

            pizza.setColor(Color.BLACK);
            pizza.setStrokeWidth(15);
            pizza.setStyle(Paint.Style.STROKE);

            canvas.drawCircle(700, 500, 100, pizza);
        }

        public boolean onTouchEvent(MotionEvent e){
            x=e.getX();
            y=e.getY();

            if (e.getAction()==MotionEvent.ACTION_DOWN){
                accion="down";
            }

            if (e.getAction()==MotionEvent.ACTION_MOVE){
                accion="move";
            }
            //actualiza nuestro dibujo
            invalidate();
            return true;
        }
    }
}