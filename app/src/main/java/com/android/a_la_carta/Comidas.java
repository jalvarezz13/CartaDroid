package com.android.a_la_carta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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

        if (MainActivity.gridOnComidas == 0) {
            lstComidas.setLayoutManager(new LinearLayoutManager(getBaseContext()));
            lstComidas.addItemDecoration(new DividerItemDecoration(this.getBaseContext(), LinearLayoutManager.VERTICAL));
        } else {
            lstComidas.setLayoutManager(new GridLayoutManager(getBaseContext(), 2));
            lstComidas.addItemDecoration(new DividerItemDecoration(this.getBaseContext(), LinearLayoutManager.VERTICAL));
            lstComidas.addItemDecoration(new DividerItemDecoration(this.getBaseContext(), LinearLayoutManager.HORIZONTAL));
        }

        adaptador = new AdaptadorListaComida(comidas);
        lstComidas.setAdapter(adaptador);

        rellenarDatos();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.over_menu, menu);
        MenuItem item = menu.findItem(R.id.changeView);

        switch (MainActivity.gridOnComidas) {
            case 0:
                item.setIcon(R.drawable.grid);
                item.setTitle("Modo Grid");
                break;
            case 1:
                item.setIcon(R.drawable.list);
                item.setTitle("Modo Lista");
                break;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.acercaDe) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Acerca de...");
            builder.setMessage("Aplicación creada por:\n" + " - Javier Álvarez Páramo\n - Juan Muñoz Calvo\n - Carlos Mohedano Callejo");
            builder.setPositiveButton("OK", null);
            builder.create();
            builder.show();
        }
        if (item.getItemId() == R.id.salir) {
            finishAffinity();
        }
        if (item.getItemId() == R.id.changeView) {
            switch (MainActivity.gridOnComidas) {
                case 0:
                    MainActivity.gridOnComidas = 1;
                    break;
                case 1:
                    MainActivity.gridOnComidas = 0;
                    break;
            }
            startActivity(new Intent(this, Comidas.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public static void rellenarDatos() {
        comidas.add(new Plato("Hamburguesa de vacuno", 5.95, "Hamburguesa de carne de vacuno 120 gramos, tomate, queso, lechuga, pepinillos y pan con semillas de sésamo.", R.drawable.hamburguesa));
        comidas.add(new Plato("Patatas fritas", 2.50, "Cucurucho de patatas fritas con dos salsas a elegir.", R.drawable.patatas_fritas));
        comidas.add(new Plato("Bocadillo de calamares", 3.99, "Bocadillo de calamares rebozados con salsa tártara.", R.drawable.bocadillo_calamares));
        comidas.add(new Plato("Ensalada césar", 5.00, "Ensalada con picatostes de pan frito, tiras de pollo rebozadas y salsa césar.", R.drawable.ensalada_cesar));
        comidas.add(new Plato("Pizza Pepperoni", 9.95, "¡ESPECIAL DE LA CASA! Pizza con base de queso y rodajas de pepperoni.", R.drawable.pizza_peperonni));
    }
}