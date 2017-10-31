package com.example.xavin.objetosentrepantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    protected Persona persona;
    protected TextView resultado;
    protected ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        resultado = (TextView) findViewById(R.id.result);
        imageView = (ImageView) findViewById(R.id.imageView);

        Bundle miBundle = getIntent().getExtras();
        persona  = (Persona) miBundle.getSerializable("Persona");

        resultado.setText("Nombre" + persona.getNombre() +
                "\nApellido "+persona.getApellido()+
                "\nEdad "+persona.getEdad());
        imageView.setImageResource(persona.getFoto());
    }

    public void onClick(View v){
        setResult(RESULT_OK);
        finish();
    }
}