package com.example.xavin.listaobjetos;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Titular[] datos = new Titular[]{
            new Titular("Homer Simpson", "Los Simpsons", R.drawable.homer),
            new Titular("Peter Griffin", "Padre de Familia", R.drawable.peter),
            new Titular("Stan Smith", "American Dad", R.drawable.stan)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        ListView istOpciones = (ListView) findViewById(R.id.LstOpciones);
        istOpciones.setAdapter(adaptador);

        //Toast
        istOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView arg0, View arg1, int posicion, long id){
                String mensaje = "Nombre: " + datos[posicion].getNombre() + ". Serie: " +datos[posicion].getSerie();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> adapterView){
            }
        });
    }

    public class AdaptadorTitulares extends ArrayAdapter {
        Activity context;

        AdaptadorTitulares(Activity context){
            super(context, R.layout.listitem_titular, datos);
            this.context = context;
        }

        public View getView(int i, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_titular, null);

            TextView lbnombre = (TextView) item.findViewById(R.id.LbNombre);
            lbnombre.setText(datos[i].getNombre());

            TextView lbSerie = (TextView) item.findViewById(R.id.LbSerie);
            lbSerie.setText(datos[i].getSerie());

            ImageView imagen = (ImageView) item.findViewById(R.id.ivImagen);
            imagen.setBackground(getDrawable(datos[i].getImagen()));

            return (item);
        }
    }
}