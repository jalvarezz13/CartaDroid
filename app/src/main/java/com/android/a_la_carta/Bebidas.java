package com.android.a_la_carta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class Bebidas extends AppCompatActivity {
    public static RecyclerView lstBebidas;
    public static ArrayList<Plato> bebidas;
    public static AdaptadorListaBebida adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);
        lstBebidas = findViewById(R.id.rvBebidas);
        bebidas = new ArrayList<Plato>();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getBaseContext());
        lstBebidas.setLayoutManager(mLayoutManager);
        adaptador = new AdaptadorListaBebida(bebidas);
        lstBebidas.setAdapter(adaptador);

        rellenarDatos();
        lstBebidas.addItemDecoration(new DividerItemDecoration(this.getBaseContext(), LinearLayoutManager.VERTICAL));
    }

    public static void rellenarDatos() {
        bebidas.add(new Plato("Coca-Cola", 2.20, "Bebida gaseosa y refrescante de cola.", R.drawable.coca_cola));
        bebidas.add(new Plato("Fanta de Naranja", 2.20, "Bebida gaseosa y refrescante con sabor a naranja.", R.drawable.fanta_naranja));
        bebidas.add(new Plato("Fanta de Limon", 2.20, "Bebida gaseosa y refrescante con sabor a limon.", R.drawable.fanta_limon));
        bebidas.add(new Plato("Cerveza Amstel (con Alcohol)", 2.00, "Bebida alcohólica preparada a base de cebada", R.drawable.cerveza_amstel));
    }
}