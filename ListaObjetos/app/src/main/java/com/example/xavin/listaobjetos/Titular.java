package com.example.xavin.listaobjetos;

/**
 * Created by xavin on 20/10/2017.
 */

public class Titular {

    private String nombre;
    private String serie;
    private int imagen;

    public Titular(String tit, String sub, int img){
        nombre = tit;
        serie = sub;
        imagen = img;
    }

    public String getNombre(){
        return nombre;
    }

    public String getSerie(){
        return serie;
    }

    public int getImagen(){
        return imagen;
    }
}