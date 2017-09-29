package com.example.xavin.botonesprueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Tabla extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla);

        final Button btnvolver3 = (Button) findViewById(R.id.btnvolver3);

        btnvolver3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent = new Intent(Tabla.this, MainActivity.class);
                startActivity(miIntent);
            }
        });

    }
}