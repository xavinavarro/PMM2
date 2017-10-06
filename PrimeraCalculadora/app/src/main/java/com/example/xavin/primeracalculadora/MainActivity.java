package com.example.xavin.primeracalculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText operando1, operando2;
    private TextView resultado;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operando1=(EditText)findViewById(R.id.operando1);
        operando2=(EditText)findViewById(R.id.operando2);
        resultado=(TextView)findViewById(R.id.resultado);
        rg=(RadioGroup)findViewById(R.id.rg);
    }

    public void resultado(View view){
        try{
            int valor1 = Integer.parseInt(operando1.getText().toString());
            int valor2 = Integer.parseInt(operando2.getText().toString());
            int total = 0;
            switch(rg.getCheckedRadioButtonId()){
                case R.id.suma: total=valor1+valor2;
                    break;
                case R.id.resta: total=valor1-valor2;
                    break;
            }
        resultado.setText("Resultado: " +total);
        } catch (NumberFormatException  e){
            resultado.setText("Resultado: Faltan Datos");
        }
    }
}