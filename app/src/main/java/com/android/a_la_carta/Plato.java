package com.android.a_la_carta;

import java.util.ArrayList;

public class Plato {
    String nombre;
    String descripcion;
    double precio;
    int duracion; // minutos
    ArrayList<String> ingredientes;
    String rutaImagen;

    public Plato(String nombre, String descripcion, double precio, int duracion, ArrayList<String> ingredientes, String rutaImagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.duracion = duracion;
        this.ingredientes = ingredientes;
        this.rutaImagen = rutaImagen;
    }

    public Plato(String nombre, double precio, int duracion, String rutaImagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.duracion = duracion;
        this.rutaImagen = rutaImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
