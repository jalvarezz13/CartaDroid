package com.android.a_la_carta;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteHelper extends SQLiteOpenHelper {
    String sqlCrearUsuario = "CREATE TABLE Comida(nombre TEXT, descripcion TEXT, precio DOUBLE, duracion INTEGER, imagenId INTEGER, valorNutricionalId INTEGER)";
    String sqlCrearCliente = "CREATE TABLE Bebida(nombre TEXT, descripcion TEXT, precio DOUBLE, duracion INTEGER, imagenId INTEGER, valorNutricionalId INTEGER)";
    String sqlCrearProveedor = "CREATE TABLE Postre(nombre TEXT, descripcion TEXT, precio DOUBLE, duracion INTEGER, imagenId INTEGER, valorNutricionalId INTEGER)";

    public SQLiteHelper(Context contexto, String nombreBD, SQLiteDatabase.CursorFactory factory, int versionBD) {
        super(contexto, nombreBD, factory, versionBD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(sqlCrearUsuario);
            db.execSQL(sqlCrearCliente);
            db.execSQL(sqlCrearProveedor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        try {
            // DELETE THE LAST VERSION
            db.execSQL("DROP TABLE IF EXISTS Usuario");
            db.execSQL("DROP TABLE IF EXISTS Cliente");
            db.execSQL("DROP TABLE IF EXISTS Proveedor");

            // CREATE NEW VERSION
            db.execSQL(sqlCrearUsuario);
            db.execSQL(sqlCrearCliente);
            db.execSQL(sqlCrearProveedor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
