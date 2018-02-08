package com.example.xavin.proyectofinal_xavi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;


public class Pedido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        String total = getIntent().getStringExtra("Total");
        String extras = getIntent().getStringExtra("Total extras");

        TextView precioE = (TextView) findViewById(R.id.precioE);
        TextView precioT = (TextView) findViewById(R.id.precioT);

        precioE.setText(extras);
        precioT.setText(total);

    }
}