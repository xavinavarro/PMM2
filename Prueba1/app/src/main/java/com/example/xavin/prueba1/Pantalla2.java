package com.example.xavin.prueba1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Pantalla2 extends MainActivity {

    public static int COD_RESPUESTA = 0;
    TextView elSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText miTexto = (EditText) findViewById(R.id.miTxt);
        final Button miBoton = (Button) findViewById(R.id.miBtn);
        elSaludo = (TextView) findViewById(R.id.miLbl);
//Borrar el texto inicial del EditText
        miTexto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                miTexto.setText("");
            }
        });

        miBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(Pantalla2.this, Pantalla2.class);
                Bundle miBundle = new Bundle();
                String mensajePaso = "Te saludo " + miTexto.getText();
                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });
    }
}