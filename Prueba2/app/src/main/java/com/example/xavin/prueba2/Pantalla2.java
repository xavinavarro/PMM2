package com.example.xavin.prueba2;

/**
 * Created by xavin on 19/09/2017.
 */
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Pantalla2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView otroSaludo= (TextView)findViewById(R.id.miMensaje);

        Bundle  miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));

    }
}