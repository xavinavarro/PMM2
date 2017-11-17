package com.example.xavin.examen1_xavinavarro;

import java.io.Serializable;

public class Pizzas implements Serializable {
    private String modelo, ingrediente;
    private String precio;
    private int View;


    public Pizzas(String modelo, String ingrediente,String precio,int mg){
        this.modelo=modelo;
        this.ingrediente=ingrediente;
        this.precio=precio;
        this.View=mg;

    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getView() {
        return View;
    }

    public void setView(int view) {
        View = view;
    }

    @Override
    public String toString() {
        return "Pizzas{" +
                "modelo='" + modelo + '\'' +
                ", ingrediente='" + ingrediente + '\'' +
                ", precio='" + precio + '\'' +
                ", View=" + View +
                '}';
    }
}