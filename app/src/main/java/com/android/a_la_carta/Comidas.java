package com.android.a_la_carta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Comidas extends AppCompatActivity {
    public static RecyclerView lstComidas;
    public static ArrayList<Plato> comidas;
    public static AdaptadorListaComida adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comidas);
        lstComidas = findViewById(R.id.rvComidas);
        comidas = new ArrayList<Plato>();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getBaseContext());
        lstComidas.setLayoutManager(mLayoutManager);
        adaptador = new AdaptadorListaComida(comidas);
        lstComidas.setAdapter(adaptador);

        rellenarDatos();
        lstComidas.addItemDecoration(new DividerItemDecoration(this.getBaseContext(), LinearLayoutManager.VERTICAL));
    }

    public static void rellenarDatos() {
        comidas.add(new Plato("Hamburguesa", 5.95, 15, "hamburguesa1.jpg"));
        comidas.add(new Plato("Hamburguesa", 5.95, 15, "hamburguesa1.jpg"));
        comidas.add(new Plato("Hamburguesa", 5.95, 15, "hamburguesa1.jpg"));
        comidas.add(new Plato("Hamburguesa", 5.95, 15, "hamburguesa1.jpg"));
    }
}