package com.example.xavin.ejemplobdini;

/**
 * Created by xavin on 16/01/2018.
 */
public class Cliente {

    String nombre;
    String telefono;

    public Cliente (String nombre, String telefono){

        this.nombre=nombre;
        this.telefono=telefono;
    }

    public String getNombre(){
        return nombre;
    }

    public String getTelefono(){
        return telefono;
    }

}