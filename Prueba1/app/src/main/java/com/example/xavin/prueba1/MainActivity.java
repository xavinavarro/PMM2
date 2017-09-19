package com.example.xavin.prueba1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText miTexto= (EditText)findViewById(R.id.miTxt);
        final Button miBoton= (Button)findViewById(R.id.miBtn);
        final TextView elSaludo= (TextView)findViewById(R.id.miLbl);


        miBoton.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent = new Intent(MainActivity.this, MainActivity.class);
                String mensajePaso= "Te saludo " + miTexto.getText();
                elSaludo.setText(mensajePaso);
                startActivity(miIntent);
            }
        });
    }
}