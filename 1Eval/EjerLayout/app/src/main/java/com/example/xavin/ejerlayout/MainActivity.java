package com.example.xavin.ejerlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private RadioButton red,green, blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button mostrar = (Button)findViewById(R.id.mostrar);
        red = (RadioButton)findViewById(R.id.red);
        green = (RadioButton)findViewById(R.id.green);
        blue = (RadioButton)findViewById(R.id.blue);


    }
}