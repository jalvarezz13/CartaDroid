package com.android.a_la_carta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class Postres extends AppCompatActivity {
    public static RecyclerView lstPostres;
    public static ArrayList<Plato> postres;
    public static AdaptadorListaPostre adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postres);
        lstPostres = findViewById(R.id.rvPostres);
        postres = new ArrayList<Plato>();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getBaseContext());
        lstPostres.setLayoutManager(mLayoutManager);
        adaptador = new AdaptadorListaPostre(postres);
        lstPostres.setAdapter(adaptador);

        rellenarDatos();
        lstPostres.addItemDecoration(new DividerItemDecoration(this.getBaseContext(), LinearLayoutManager.VERTICAL));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.over_menu, menu);
        MenuItem item = menu.findItem(R.id.changeView);

        switch (MainActivity.gridOnPostres) {
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
            switch (MainActivity.gridOnPostres) {
                case 0:
                    MainActivity.gridOnPostres = 1;
                    break;
                case 1:
                    MainActivity.gridOnPostres = 0;
                    break;
            }
            startActivity(new Intent(this, Postres.class));
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
    }

    public static void rellenarDatos() {
        postres.add(new Plato("Yogur natural", 1.50, "Yogur casero elaborado por nuestro chef. Contiene leche.", R.drawable.yogur_natural));
        postres.add(new Plato("Tarta de chocolate", 2.50, "¡RECOMENDADO POR LA CASA! Bollo de chocolate con nueces en su interior. Se sirve frío y con nata por encima.", R.drawable.tarta_chocolate));
        postres.add(new Plato("Fruta de temporada", 2, "Frutas a elegir: Melón, Sandía, Manzana o Fresas.", R.drawable.fruta));
        postres.add(new Plato("Gofre", 3.00, "Gofre elaborado en el momento. Se sirve caliente con unas finas capas de nutella, nata y fresas troceadas.", R.drawable.gofre));
        postres.add(new Plato("Creps con nutella", 2.00, "El postre está compuesto por dos creps con crema de Nutella en su interior. (Se puede servir con otros complementos)", R.drawable.crepes));
        postres.add(new Plato("Conos de hellado", 1, "Conos de helado de diferentes sabores. Disponibles: Fresa, Nata, Vainilla, Chocolate y Turrón.", R.drawable.cono_helado));
        postres.add(new Plato("Flan de huevo", 2.5, "Flan casero elaborado por nuestro chef con cremoso caramelo por encima.", R.drawable.flan));
    }
}

