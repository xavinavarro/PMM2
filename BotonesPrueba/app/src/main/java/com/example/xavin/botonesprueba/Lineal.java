package com.example.xavin.botonesprueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Lineal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lineal);


        final ImageButton btnvolver = (ImageButton) findViewById(R.id.btnvolver);

        btnvolver.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent = new Intent(Lineal.this, MainActivity.class);
                startActivity(miIntent);
            }
        });

    }
}
