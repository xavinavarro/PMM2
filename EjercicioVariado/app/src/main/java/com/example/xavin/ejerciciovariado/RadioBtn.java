package com.example.xavin.ejerciciovariado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioBtn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_btn);


        final TextView lblMensaje = (TextView)findViewById(R.id.LblSeleccion);
        final RadioGroup rg = (RadioGroup)findViewById(R.id.gruporb);
        final Button btnBack = (Button)findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent miIntent = new Intent(RadioBtn.this, MainActivity.class);

                startActivity(miIntent);
            }
        });


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                lblMensaje.setText("ID opción seleccionada: " + checkedId);
            }
        });
    }
}
