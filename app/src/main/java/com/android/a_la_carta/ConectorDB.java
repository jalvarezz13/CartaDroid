package com.android.a_la_carta;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

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

//    /*inserta un usuario en la BD*/
//    public void insertarUsuario(String name, String username, String phone, String email, String pass) {
//        String consulta = "INSERT INTO Usuario (name, username, phone, email, pass) VALUES('" + name + "', '" + username + "', '" + phone + "', '" + email + "', '" + pass + "')";
//        Log.d("dbconsulta", consulta);
//        db.execSQL(consulta);
//    }
//
//    public String autenticarUsuario(String username) {
//        Cursor c = db.rawQuery("SELECT pass FROM Usuario WHERE username='" + username + "'", null);
//        c.moveToFirst();
//        Log.d("dbconsulta", c.getString(0));
//        return c.getString(0);
//    }
//
//    public void insertarCliente(String name, String phone, String email, Integer numPedidos) {
//        String consulta = "INSERT INTO Cliente (name, phone, email, ultConexion, numPedidos) VALUES('" + name + "', '" + phone + "', '" + email + "', 'Nunca', " + numPedidos + ")";
//        Log.d("dbconsulta", consulta);
//        db.execSQL(consulta);
//    }
//
//    public void insertarProveedor(String name, String phone, String email, double deuda, Integer numPedidos) {
//        String consulta = "INSERT INTO Proveedor (name, phone, email, deuda, numPedidos) VALUES('" + name + "', '" + phone + "', '" + email + "', " + deuda + ", " + numPedidos + ")";
//        Log.d("dbconsulta", consulta);
//        db.execSQL(consulta);
//    }
//
//    public Cursor obtenerClientes() {
//        return db.rawQuery("SELECT * FROM Cliente", null);
//    }
//
//    public Cursor obtenerProveedores() {
//        return db.rawQuery("SELECT * FROM Proveedor", null);
//    }
}