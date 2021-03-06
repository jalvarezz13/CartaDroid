package com.android.a_la_carta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class Comidas extends AppCompatActivity {
    public static RecyclerView lstComidas;
    public static ArrayList<Plato> comidas;
    public static AdaptadorListaComida adaptador;
    public static ConectorDB conectorDB;

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

        Intent i_duracion = new Intent(this, VerDuracionPlato.class);
        Intent i_valoresNutricionales = new Intent(this, VerValoresNutricionales.class);

        adaptador.setItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onMenuContextualPlato(int posicion, MenuItem menu) {
                switch (menu.getItemId()) {
                    case R.id.showDuration:
                        i_duracion.putExtra("nombre", comidas.get(posicion).getNombre());
                        i_duracion.putExtra("duracion", comidas.get(posicion).getDuracion());
                        i_duracion.putExtra("imagen", comidas.get(posicion).getRutaImagen());
                        startActivity(i_duracion);
                        break;
                    case R.id.showNutricionalValues:
                        i_valoresNutricionales.putExtra("nombre", comidas.get(posicion).getNombre());
                        i_valoresNutricionales.putExtra("tabla", comidas.get(posicion).getRutaValorNutricional());
                        i_valoresNutricionales.putExtra("imagen", comidas.get(posicion).getRutaImagen());
                        startActivity(i_valoresNutricionales);
                        break;
                }
            }
        });

        conectorDB = new ConectorDB(this.getBaseContext());
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
            builder.setMessage("Aplicaci??n creada por:\n" + " - Javier ??lvarez P??ramo\n - Juan Mu??oz Calvo\n - Carlos Mohedano Callejo");
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
        comidas.removeAll(comidas);
        conectorDB.abrir();
        Cursor c = conectorDB.obtenerComidas();
        if (c.moveToFirst()) {
            do {
                Plato p = new Plato();
                p.setNombre(c.getString(0));
                p.setDescripcion(c.getString(1));
                p.setPrecio(c.getDouble(2));
                p.setDuracion(c.getInt(3));
                p.setRutaImagen(c.getInt(4));
                p.setRutaValorNutricional(c.getInt(5));
                comidas.add(p);
            } while (c.moveToNext());
        }
        c.close();
        conectorDB.cerrar();
        lstComidas.getAdapter().notifyDataSetChanged();

//        comidas.add(new Plato("Hamburguesa de vacuno", "Hamburguesa de carne de vacuno 120 gramos, tomate, queso, lechuga, pepinillos y pan con semillas de s??samo.", 5.95, 20, R.drawable.hamburguesa, R.drawable.tabla_hamburguesa));
//        comidas.add(new Plato("Patatas fritas", "Cucurucho de patatas fritas con dos salsas a elegir.", 2.50, 15, R.drawable.patatas_fritas, R.drawable.tabla_patatas_fritas));
//        comidas.add(new Plato("Bocadillo de calamares", "Bocadillo de calamares rebozados con salsa t??rtara.", 3.99, 9, R.drawable.bocadillo_calamares, R.drawable.tabla_bocadillo_calamares));
//        comidas.add(new Plato("Ensalada c??sar", "Ensalada con picatostes de pan frito, tiras de pollo rebozadas y salsa c??sar.", 5.00, 12, R.drawable.ensalada_cesar, R.drawable.tabla_ensalada_cesar));
//        comidas.add(new Plato("Pizza Pepperoni", "??ESPECIAL DE LA CASA! Pizza con base de queso y rodajas de pepperoni.", 9.95, 20, R.drawable.pizza_peperonni, R.drawable.tabla_pizza_pepperoni));
//        comidas.add(new Plato("Alitas de pollo", "Crujientes alitas de pollo picantes y con salsa barbacoa.", 5.50, 20, R.drawable.alitas, R.drawable.tabla_alitas));
//        comidas.add(new Plato("Sopa de marisco", "Rica y nutritiva sopa de marisco, del mar a tu plato.", 6.00, 15, R.drawable.sopa_marisco, R.drawable.tabla_sopa_marisco));
//        comidas.add(new Plato("Ensalada mixta", "Ensalada de la caso con hortalizas recien cogidas del huerto.", 4.50, 13, R.drawable.ensalada, R.drawable.ensalada));
//        comidas.add(new Plato("Lentejas", "Lentejas cocidas con verdura y carne para combatir el fr??o.", 5.00, 17, R.drawable.lentejas, R.drawable.tabla_lentejas));
//        comidas.add(new Plato("Paella", "Aut??ntica paella valenciana hecha por nuestros chefs en un tiempo record sin perder su sabor original.", 12.00, 40, R.drawable.paella, R.drawable.tabla_paella));
//        comidas.add(new Plato("Pan", "Pan del dia horneado para lograr su corteza crujiente y su miga tierna.", 1.50, 0, R.drawable.pan, R.drawable.tabla_pan));
    }
}