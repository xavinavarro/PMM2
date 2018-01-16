package com.example.xavin.proyectobasedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by xavin on 16/01/2018.
 */

public class UsuarioSQLiteHelper extends SQLiteOpenHelper {

    //Creamos variable sentencia SQL
    String sql = "CREATE TABLE Cliente (Identificacion INTEGER, Nombre TEXT, Apellidos TEXT)";

    public UsuarioSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Crea la BD si no existe
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Cliente");
        db.execSQL(sql);
    }
}