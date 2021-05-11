package com.android.a_la_carta;

import java.util.ArrayList;

public class Plato {
    private String nombre;
    private String descripcion;
    private double precio;
    private int duracion; // minutos
    private int rutaImagen;
    private int rutaValorNutricional;

    public Plato(String nombre, String descripcion, String descripcionCorta, double precio, int duracion, int rutaImagen, int rutaValorNutricional) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.duracion = duracion;
        this.rutaImagen = rutaImagen;
    }

    public Plato(String nombre, double precio, String descripcion, int rutaImagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
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

    public int getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(int rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public int getRutaValorNutricional() {
        return rutaValorNutricional;
    }

    public void setRutaValorNutricional(int rutaValorNutricional) {
        this.rutaValorNutricional = rutaValorNutricional;
    }
}
