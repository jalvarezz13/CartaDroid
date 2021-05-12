package com.android.a_la_carta;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ConectorDB {
    static final String NOMBRE_BD = "cartaDB";
    private SQLiteHelper dbHelper;
    private SQLiteDatabase db;

    /*Constructor*/
    public ConectorDB(Context ctx) {
        dbHelper = new SQLiteHelper(ctx, NOMBRE_BD, null, 1);
    }

    /*Abre la conexión con la base de datos*/
    public ConectorDB abrir() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    /*Cierra la conexión con la base de datos*/
    public void cerrar() {
        if (db != null)
            db.close();
    }

    //nombre TEXT, descripcion TEXT, precio DOUBLE, duracion INTEGER, ingredientes STRING, imagenId INTEGER, valorNutricionalId INTEGER

    public void insertarPlato(String table, String nombrePlato, String descripcionPlato, double precioPlato, int duracionPlato, int imagenId, int valorNutricionalId) {
        String consulta = "INSERT INTO " + table + " (nombre, descripcion, precio, duracion, imagenId, valorNutricionalId) VALUES('" + nombrePlato + "', '" + descripcionPlato + "', " + precioPlato + ", " + duracionPlato + ", " + imagenId + ", " + valorNutricionalId + ")";
        Log.d("dbconsulta", consulta);
        db.execSQL(consulta);
    }

    public Cursor obtenerComidas() {
        return db.rawQuery("SELECT * FROM Comida", null);
    }

    public Cursor obtenerBebidas() {
        return db.rawQuery("SELECT * FROM Bebida", null);
    }

    public Cursor obtenerPostres() {
        return db.rawQuery("SELECT * FROM Postre", null);
    }
}