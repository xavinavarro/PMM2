package com.example.xavin.examen1_xavinavarro;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int[] Margarita = {R.drawable.pizza1};
    private int[] TresQuesos = {R.drawable.pizza2};
    private int[] Barbacoa = {R.drawable.pizza3};
    private int[] Atun = {R.drawable.pizza4};

    Random randomimagenes = new Random();
    int aleatorio = randomimagenes.nextInt(4);

    private Pizzas[] pizza = new Pizzas[]{
            new Pizzas("Margarita", "Jamon/Tomate", "7", Margarita[aleatorio]),
            new Pizzas("3 Quesos", "Queso1/Queso2", "10", TresQuesos[aleatorio]),
            new Pizzas("Barbacoa", "Carne/Tomate", "12", Barbacoa[aleatorio]),
            new Pizzas("Atun", "Atun/Tomate", "14", Atun[aleatorio])
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //CREAMOS LA LISTA DE OBJETOS DEL SPINNER
        final RadioButton enviodomicilio = (RadioButton) findViewById(R.id.enviodomicilio);
        final RadioButton enlocal = (RadioButton) findViewById(R.id.enlocal);
        final RadioGroup grupo = (RadioGroup) findViewById(R.id.radio_grupo);

        final EditText cantidad = (EditText) findViewById(R.id.texto_cantidad);
        final CheckBox caja_masgrande = (CheckBox) findViewById(R.id.caja_masgrande);
        final CheckBox caja_masingred = (CheckBox) findViewById(R.id.caja_masingred);
        final CheckBox caja_extraqueso = (CheckBox) findViewById(R.id.caja_extraqueso);

        final Button boton = (Button) findViewById(R.id.boton_calcular);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ventana = new Intent(MainActivity.this, Factura.class);
                Bundle objeto = new Bundle();

                TextView ingrediente_texto = (TextView) findViewById(R.id.resultado_ingrediente);
                TextView modelo_texto = (TextView) findViewById(R.id.resultado_modelo);
                TextView precio_texto = (TextView) findViewById(R.id.resultado_precio);
                ImageView imagen = (ImageView) findViewById(R.id.resultado_imagen);

                final Spinner spinner = (Spinner) findViewById(R.id.spinner);

                Pizzas datos = new Pizzas(pizza[spinner.getSelectedItemPosition()].getModelo(),
                        pizza[spinner.getSelectedItemPosition()].getIngrediente(),
                        pizza[spinner.getSelectedItemPosition()].getPrecio(),
                        pizza[spinner.getSelectedItemPosition()].getView());

                boolean selected1 = false;
                boolean selected2 = false;
                boolean selected3 = false;

                if (caja_masgrande.isChecked()) {
                    selected1 = true;
                    TextView check1 = (TextView) findViewById(R.id.caja_masgrande);
                    check1.setText(caja_masgrande.getText());
                }

                if (caja_masingred.isChecked()) {
                    selected2 = true;
                    TextView check2 = (TextView) findViewById(R.id.caja_masingred);
                    check2.setText((caja_masingred.getText()));
                }
                if (caja_extraqueso.isChecked()) {
                    selected3 = true;
                    TextView check3 = (TextView) findViewById(R.id.caja_extraqueso);
                    check3.setText((caja_extraqueso.getText()));
                }

                String nombre;

                TextView radio1 = (TextView) findViewById(R.id.enviodomicilio);
                radio1.setText(radio1.getText());
                nombre = radio1.getText().toString();
                ventana.putExtra("grupo", nombre);

                if (grupo.getCheckedRadioButtonId() == R.id.enlocal) {
                    TextView radio2 = (TextView) findViewById(R.id.enlocal);
                    radio2.setText((radio2.getText()));
                    nombre = radio2.getText().toString();
                    ventana.putExtra("grupo", nombre);
                }

                double preciocantidad = 0;
                double cost = 0;

                Double.parseDouble(cantidad.getText().toString());
                preciocantidad = Double.parseDouble(cantidad.getText().toString()) * Double.parseDouble(precio_texto.getText().toString());
                if (caja_masgrande.isChecked()) {
                    cost += 1;
                }
                if (caja_masingred.isChecked()) {
                    cost += 1;
                }
                if (caja_extraqueso.isChecked()) {
                    cost += 0;
                }

                double total = preciocantidad + cost;
                double total2 = (preciocantidad + cost) * 1.1;

                ventana.putExtra("total", String.valueOf(total));
                ventana.putExtra("total2", String.valueOf(total2));
                ventana.putExtra("Extra", String.valueOf(cost));

                ventana.putExtra("cantidad", cantidad.getText().toString());
                ventana.putExtra("preciocantidad", String.valueOf(cost));

                ventana.putExtra("boolean1", selected1);
                ventana.putExtra("boolean2", selected2);
                ventana.putExtra("boolean3", selected3);
                ventana.putExtra("caja_aire", caja_masgrande.getText().toString());
                ventana.putExtra("caja_masingred", caja_masingred.getText().toString());
                ventana.putExtra("caja_extraqueso", caja_extraqueso.getText().toString());
                objeto.putSerializable("informacion", datos);
                ventana.putExtras(objeto);
                startActivity(ventana);
            }
        });

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);


        Adaptador adaptador = new Adaptador(this);
        spinner.setAdapter(adaptador);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView arg0, View view, int position, long l) {
                String mensaje = "Seleccionado: Modelo " + pizza[position].getModelo() + " Ingredientes " + pizza[position].getIngrediente() + " Precio " + pizza[position].getPrecio() + " Imagen " + pizza[position].getView();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    //MENU ACERCA DE Y DIBUJAR
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_acerca:
                Intent acerca = new Intent(MainActivity.this, Acerca.class);
                startActivity(acerca);
                return true;
            case R.id.menu_imagen:
                Intent dibujo = new Intent(MainActivity.this, Dibujar.class);
                startActivity(dibujo);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    class Adaptador extends ArrayAdapter<Pizzas> {
        public Activity context;

        public Adaptador(Activity Context) {
            super(Context, R.layout.pizzas, pizza);
            this.context = Context;
        }

        public View getView(int position, View convertview, ViewGroup Parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            final View item = inflater.inflate(R.layout.activity_factura, null);

            TextView ingrediente = (TextView) item.findViewById(R.id.resultado_ingrediente);
            TextView modelo = (TextView) item.findViewById(R.id.resultado_modelo);
            final TextView precio = (TextView) item.findViewById(R.id.resultado_precio);
            ImageView imag = (ImageView) item.findViewById(R.id.resultado_imagen);

            ingrediente.setText(pizza[position].getModelo());
            modelo.setText(pizza[position].getIngrediente());
            precio.setText(String.valueOf(pizza[position].getPrecio()));
            imag.setBackground(getDrawable(pizza[position].getView()));

            return item;
        }

        public View getDropDownView(int position, View convertview, ViewGroup Parent) {
            View ver_spinner = getView(position, convertview, Parent);
            return ver_spinner;
        }
    }
}