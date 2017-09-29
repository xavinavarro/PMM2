package com.example.xavin.botonesprueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Clock extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

        final ImageButton btnvolver2 = (ImageButton) findViewById(R.id.btnvolver2);

        btnvolver2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent = new Intent(Clock.this, MainActivity.class);
                startActivity(miIntent);
            }
        });
    }
}
