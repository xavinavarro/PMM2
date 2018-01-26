package com.example.xavin.proyectofinal_xavi;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {

    String posibilidad = "";
    int precioP = 0;
    int precioE = 0;
    int precioMascarilla= 0;
    int precioFacial = 0;
    int precioCejas = 0;
    int precioTotal = 0;
    private Tratamiento[] datos;
    String tratamientoss;
    int precioss;
    String tratamientoSelect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


        final RadioButton RBEco = (RadioButton) findViewById(R.id.RBEcologico);
        final RadioButton RBDeluze = (RadioButton) findViewById(R.id.RBDeluxe);
        final RadioButton RBSensor = (RadioButton) findViewById(R.id.RBSensor);

        final CheckBox EMascarilla = (CheckBox) findViewById(R.id.extraMascarilla);
        final CheckBox EFacial = (CheckBox) findViewById(R.id.extraFacial);
        final CheckBox ECejas = (CheckBox) findViewById(R.id.extraCejas);

        Button BPedido = (Button) findViewById(R.id.botonPedido);

        RBEco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                posibilidad = "Linea Ecológica";
                precioP = 10;

            }
        });

        RBDeluze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                posibilidad = "Linea Deluxe";
                precioP = 1;

            }
        });

        RBSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                posibilidad = "Linea Sensorial";
                precioP = 10;

            }
        });

        EMascarilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                precioMascarilla = 7;
                precioE += precioMascarilla;

            }
        });

        EFacial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                precioFacial = 10;
                precioE += precioFacial;
            }
        });

        ECejas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                precioCejas = 5;
                precioE += precioCejas;
            }
        });

        BPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(RBEco.isChecked()){
                    precioTotal = precioP;
                }else {
                    Toast aviso = Toast.makeText(getApplicationContext(), "Elige al menos una posibilidad",Toast.LENGTH_SHORT);
                }
                if(RBDeluze.isChecked()){
                    precioTotal = precioP;
                }else {
                    Toast aviso = Toast.makeText(getApplicationContext(), "Elige al menos una posibilidad",Toast.LENGTH_SHORT);
                }
                if(RBSensor.isChecked()){
                    precioTotal = precioP;
                }else {
                    Toast aviso = Toast.makeText(getApplicationContext(), "Elige al menos una posibilidad",Toast.LENGTH_SHORT);
                }

                if(EMascarilla.isChecked()){
                    precioTotal += precioMascarilla;
                }
                if(ECejas.isChecked()){
                    precioTotal += precioCejas;
                }
                if(EFacial.isChecked()){
                    precioTotal += precioFacial;
                }

                Intent pedido = new Intent(Inicio.this, Pedido.class);
                pedido.putExtra("Total", precioTotal).toString();
                pedido.putExtra("Total extras", precioE).toString();

                startActivity(pedido);


            }
        });

        BDTratamientos admin = new BDTratamientos(Inicio.this, "BaseDatos", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        // Spinner de la marca

        if (db != null ){

            String [] campos = new String[]{"tratamientos"};

            Cursor cursor = db.query("Tratamiento", campos, null, null, null, null, null);
            datos = new Tratamiento[cursor.getCount()];
            int i = 0;
            //Nos aseguramos de que exista al menos un registro
            if (cursor.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {

                    tratamientoss = cursor.getString(0);
                    precioss = cursor.getInt(1);

                    datos[i] = new Tratamiento(tratamientoss, precioss);

                    i++;

                } while (cursor.moveToNext());
            }

            AdaptadorTratamientos adaptador = new AdaptadorTratamientos(this);
            Spinner spinnerTratamiento = (Spinner) findViewById(R.id.spinner);
            spinnerTratamiento.setAdapter(adaptador);

            spinnerTratamiento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                    String menasje = "Tratamiento: " + datos[position].getNombre();
                    tratamientoSelect = datos[position].getNombre();


                    BDTratamientos basedatos=new BDTratamientos(Inicio.this,"BaseDatos",null,1);
                    SQLiteDatabase db=basedatos.getWritableDatabase();

                    // Spinner de tratamientos


                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            db.close();
        }




        // Menu Acerca De y Información

        /**    public boolean onCreateOptionsMenu (Menu menu){
         MenuInflater inflater = getMenuInflater();
         inflater.inflate(R.menu.activity_menu, menu);
         return true;
         }
         public boolean onOptionItemSelected(MenuItem item){
         switch(item.getItemId()){
         case R.id.acerca:
         Intent acerca = new Intent(Inicio.this, acercade.class);
         startActivity(acerca);
         return true;
         case R.id.informacion:
         Intent info = new Intent(Inicio.this, informacion.class);
         startActivity(info);
         return true;
         default:
         return super.onOptionsItemSelected(item);
         }
         }
         **/
    }

    public class AdaptadorTratamientos extends ArrayAdapter {

        Activity context;

        AdaptadorTratamientos(Activity context) {

            super(context, R.layout.activity_tratamiento, datos);
            this.context = context;

        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {

            View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }

        /**public View getView(int i, View convertView, ViewGroup parent) {

         LayoutInflater inflater = context.getLayoutInflater();
         View item = inflater.inflate(R.layout.activity_marca, null);


         TextView marca = (TextView) item.findViewById(R.id.marca);
         marca.setText(dades[i].getModel());


         return (item);
         }*/
    }


}