package com.example.xavin.examen1_xavinavarro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Factura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        TextView resultado_modelo=(TextView)findViewById(R.id.resultado_modelo);
        TextView resultado_precio=(TextView)findViewById(R.id.resultado_precio);
        TextView resultado_caja=(TextView)findViewById(R.id.resultado_cajas);
        TextView resultado_radio=(TextView)findViewById(R.id.resultado_radios);
        TextView resultado_coste=(TextView)findViewById(R.id.resultado_coste);
        TextView resultado_extra=(TextView)findViewById(R.id.extras);
        ImageView resultado_imagen=(ImageView)findViewById(R.id.resultado_imagen);

        Bundle miBundle = getIntent().getExtras();
        Pizzas pizza = (Pizzas) miBundle.getSerializable("informacion");

        resultado_modelo.setText("Modelo "+pizza.getModelo());
        resultado_precio.setText("Precio por Unidad "+pizza.getPrecio());
        resultado_imagen.setImageDrawable(getDrawable(pizza.getView()));

        if(getIntent().getExtras().getBoolean("boolean1")==true){
            resultado_caja.setText(getIntent().getStringExtra("caja_masgrande"));
        }
        if(getIntent().getExtras().getBoolean("boolean2")==true){
            resultado_caja.setText(resultado_caja.getText()+" , " + getIntent().getStringExtra("caja_masingred"));
        }
        if(getIntent().getExtras().getBoolean("boolean3")==true){
            resultado_caja.setText(resultado_caja.getText()+" , " + getIntent().getStringExtra("caja_extraqueso"));
        }

        resultado_radio.setText(resultado_radio.getText() + getIntent().getStringExtra("grupo"));
        resultado_extra.setText("Extras: "+getIntent().getExtras().getString("Extra")+ "€" );

        if (resultado_radio.getText().equals("EN LOCAL")) {
            resultado_coste.setText("TOTAL: " + String.valueOf(getIntent().getStringExtra("total2"))+ "€ ");

        }else
            resultado_coste.setText("TOTAL: " + String.valueOf(getIntent().getStringExtra("total")) + "€ ");
    }
}