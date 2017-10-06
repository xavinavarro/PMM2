package com.example.xavin.ejerciciovariado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonCheck = (Button)findViewById(R.id.buttonCheck);
        final Button buttonRadio = (Button)findViewById(R.id.buttonRadio);


        buttonCheck.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, Checkbx.class);

                startActivity(miIntent);
            }
        });

        buttonRadio.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, RadioBtn.class);

                startActivity(miIntent);
            }
        });
    }
}
