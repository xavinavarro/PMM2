package com.example.xavin.ejerciciovariado;

import android.content.Intent;
import android.media.MediaPlayer;
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

    @Override protected void onStart(){
        super.onStart();
        Toast.makeText(this, "onStart",Toast.LENGTH_SHORT).show();
    }

    @Override protected void onResume() {
    super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override protected void onPause() {
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    super.onPause();
    }

    @Override protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override protected void onRestart() {
    super.onRestart();
    Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }
    @Override protected void onDestroy() {
    Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    super.onDestroy();
    }
}
