package com.example.xavin.spinnerobjetos;

/**
 * Created by xavin on 20/10/2017.
 */

public class Titular {

    private String titulo;
    private String subtitulo;
    private int imagen;

    public Titular(String tit, String sub, int img){
        titulo = tit;
        subtitulo = sub;
        imagen = img;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getSubtitulo(){
        return subtitulo;
    }

    public int getImagen(){
        return imagen;
    }
}