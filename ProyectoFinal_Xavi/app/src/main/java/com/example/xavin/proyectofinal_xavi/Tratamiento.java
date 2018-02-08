package com.example.xavin.proyectofinal_xavi;

public class Tratamiento {

    String nombre;
    int precio;

    public Tratamiento(String nombre, int precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre(){
        return nombre;
    }

    public int getPrecio(){
        return precio;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setPrecio(int precio){
        this.precio = precio;
    }

    public String toString() {
        return "Tratamiento{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}