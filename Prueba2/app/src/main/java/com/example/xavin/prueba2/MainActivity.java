package com.example.xavin.prueba2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // final TextView mensajeIni;
        final EditText miTexto= (EditText)findViewById(R.id.miTxt);
        final Button miBoton= (Button)findViewById(R.id.miBtn);
        final TextView elSaludo= (TextView)findViewById(R.id.miLbl);

        miTexto.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            public void onFocusChange(View v, boolean b){
                if (b)  miTexto.setText("");

            }
        });

        miBoton.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent= new Intent(MainActivity.this, Pantalla2.class);

                Bundle miBundle=new Bundle();
                String mensajePaso= "Te saludo " + miTexto.getText();

                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);


                startActivity(miIntent);
            }

        });


    }

}
