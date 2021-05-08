package com.android.a_la_carta;

import java.util.ArrayList;

public class Plato {
    private String nombre;
    private String descripcion;
    private String descripcionCorta;
    private double precio;
    private int duracion; // minutos
    private ArrayList<String> ingredientes;
    private int rutaImagen;

    public Plato(String nombre, String descripcion, String descripcionCorta, double precio, int duracion, ArrayList<String> ingredientes, int rutaImagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descripcionCorta = descripcionCorta;
        this.precio = precio;
        this.duracion = duracion;
        this.ingredientes = ingredientes;
        this.rutaImagen = rutaImagen;
    }

    public Plato(String nombre, double precio, String descripcionCorta, int rutaImagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcionCorta = descripcionCorta;
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

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
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

    public int getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(int rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
