package com.example.xavin.proyectofinal_xavi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by xavin on 26/01/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    // Sentencia SQL para crear tabla Clientes
    String clientesSQL = "CREATE TABLE Clientes(codigo INTEGER primary key autoincrement, nombre TEXT , contrasenya TEXT)";
   // String clientesSQLinsert = "insert into Clientes values(1, 'admin', 'admin')";
    String tratamientosSQL = "CREATE TABLE Tratamientos(nombre text primary key, precio integer, descripcion text)";
    // Sentencia SQL para crear la tabla Tratamientos
    //String tratamientoSQL = "create tabla Tratamientos (codigo INTEGER, nombre TEXT, precio DOUBLE)";

    public DBHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    // Se ejecutara automaticamente cuando se necesite crear la BD.
    // Aqui deberemos crear todas las tablas necesarias e insertar los datos iniciales si es necesario
    @Override
    public void onCreate(SQLiteDatabase bd){
        // Ejecutamos la sentencia para crear la tabla Clientes
        bd.execSQL(clientesSQL);
        bd.execSQL(tratamientosSQL);
        //bd.execSQL(clientesSQLinsert);
       // bd.execSQL(tratamientoSQL);
    }

    // Se lanza automaticamente cuado sea necesario una actualizacion de la BD o una conversion de datos
    @Override
    public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion) {

        // Eliminamos version anterior de la tabla
        bd.execSQL("DROP TABLE IF EXISTS Clientes");

        // Creamos nueva version de la tabla
        bd.execSQL(clientesSQL);
    }
}