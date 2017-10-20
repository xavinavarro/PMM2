package com.example.xavin.spinnerobjetos;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
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
        Spinner istOpciones = (Spinner) findViewById(R.id.SOpciones);
        istOpciones.setAdapter(adaptador);

        istOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView arg0, View arg1, int posicion, long id){
                String mensaje = "Titulo: " + datos[posicion].getTitulo() + ". Subtitulo: " +datos[posicion].getSubtitulo();
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
        public  View getDropDownView (int position, View convertView, ViewGroup parent){
            View vistaDesplegada = getView(position, convertView, parent);
            return  vistaDesplegada;

        }

        public View getView(int i, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_titular, null);

            TextView lblTitulo = (TextView) item.findViewById(R.id.LblTitulo);
            lblTitulo.setText(datos[i].getTitulo());

            TextView lblSubtitulo = (TextView) item.findViewById(R.id.LblSubTitulo);
            lblSubtitulo.setText(datos[i].getSubtitulo());

            ImageView imagen = (ImageView) item.findViewById(R.id.ivImagen);
            imagen.setBackground(getDrawable(datos[i].getImagen()));

            return (item);
        }
    }
}
