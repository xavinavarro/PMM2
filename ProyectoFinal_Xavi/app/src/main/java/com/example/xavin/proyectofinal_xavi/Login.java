package com.example.xavin.proyectofinal_xavi;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Cursor cursor;
    EditText nombre,contrasenya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button entrar = (Button) findViewById(R.id.BEntrar);
        Button salir = (Button) findViewById(R.id.BSalir);
        Button registrar = (Button) findViewById(R.id.BRegistro);

        nombre = (EditText) findViewById(R.id.nombre);
        contrasenya = (EditText) findViewById(R.id.contrasenya);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nombre.getText().toString();
                String password = contrasenya.getText().toString();

                DBHelper dbDatos = new DBHelper(Login.this, "BaseDatos", null, 1 );

                SQLiteDatabase bd = dbDatos.getWritableDatabase();

                cursor = bd.rawQuery("SELECT nombre,contrasenya from Clientes where nombre='"+name+"' and  contrasenya='"+password+"'", null);

                if(cursor.moveToFirst() == true){

                    String usuario = cursor.getString(0);
                    String contra = cursor.getString(1);

                    if(name.equals(usuario)&&password.equals(contra)){

                        Intent ventana = new Intent(Login.this, Inicio.class);

                        ventana.putExtra("name", nombre.getText().toString());
                        ventana.putExtra("password", contrasenya.getText().toString());

                        startActivity(ventana);
                        Toast entrando = Toast.makeText(getApplicationContext(), "Entrando a tu cuenta...", Toast.LENGTH_SHORT);
                        entrando.show();

                    }else{
                        Toast error = Toast.makeText(getApplicationContext(), "Error al entrar en tu cuenta", Toast.LENGTH_SHORT);
                        error.show();
                    }
                }
            }
        });

        registrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent ventanaRegistro = new Intent(Login.this, Registro.class);
                startActivity(ventanaRegistro);
                Toast registrando = Toast.makeText(getApplicationContext(), "Entrando a registro..", Toast.LENGTH_SHORT);
                registrando.show();
            }
        });

        salir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                finish();

            }
        });
    }
}