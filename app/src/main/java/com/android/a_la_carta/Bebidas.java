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

        if (MainActivity.gridOnBebidas == 0) {
            lstBebidas.setLayoutManager(new LinearLayoutManager(getBaseContext()));
            lstBebidas.addItemDecoration(new DividerItemDecoration(this.getBaseContext(), LinearLayoutManager.VERTICAL));
        } else {
            lstBebidas.setLayoutManager(new GridLayoutManager(getBaseContext(), 2));
            lstBebidas.addItemDecoration(new DividerItemDecoration(this.getBaseContext(), LinearLayoutManager.VERTICAL));
            lstBebidas.addItemDecoration(new DividerItemDecoration(this.getBaseContext(), LinearLayoutManager.HORIZONTAL));
        }

        adaptador = new AdaptadorListaBebida(bebidas);
        lstBebidas.setAdapter(adaptador);

        rellenarDatos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.over_menu, menu);
        MenuItem item = menu.findItem(R.id.changeView);

        switch (MainActivity.gridOnBebidas) {
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
            switch (MainActivity.gridOnBebidas) {
                case 0:
                    MainActivity.gridOnBebidas = 1;
                    break;
                case 1:
                    MainActivity.gridOnBebidas = 0;
                    break;
            }
            startActivity(new Intent(this, Bebidas.class));
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
    }

    public static void rellenarDatos() {
        bebidas.add(new Plato("Coca-Cola", 2.20, "Bebida gaseosa y refrescante de cola.", R.drawable.coca_cola));
        bebidas.add(new Plato("Fanta de Naranja", 2.20, "Bebida gaseosa y refrescante con sabor a naranja.", R.drawable.fanta_naranja));
        bebidas.add(new Plato("Fanta de Limon", 2.20, "Bebida gaseosa y refrescante con sabor a limon.", R.drawable.fanta_limon));
        bebidas.add(new Plato("Cerveza Amstel (con Alcohol)", 2.00, "Bebida alcohólica preparada a base de cebada", R.drawable.cerveza_amstel));
    }
}