package com.example.xavin.figurasaleatorias;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DrawShapes1 extends Activity {

    private RandomShapeView mDrawingArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_shapes1);
        mDrawingArea = (RandomShapeView)findViewById(R.id.drawing_area);
    }

    public void redraw(View clickedButton) {
        mDrawingArea.invalidate();
    }
}