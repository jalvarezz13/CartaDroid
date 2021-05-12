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
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class Postres extends AppCompatActivity {
    public static RecyclerView lstPostres;
    public static ArrayList<Plato> postres;
    public static AdaptadorListaPostre adaptador;
    public static ConectorDB conectorDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postres);
        lstPostres = findViewById(R.id.rvPostres);
        postres = new ArrayList<Plato>();

        if (MainActivity.gridOnPostres == 0) {
            lstPostres.setLayoutManager(new LinearLayoutManager(getBaseContext()));
            lstPostres.addItemDecoration(new DividerItemDecoration(this.getBaseContext(), LinearLayoutManager.VERTICAL));
        } else {
            lstPostres.setLayoutManager(new GridLayoutManager(getBaseContext(), 2));
            lstPostres.addItemDecoration(new DividerItemDecoration(this.getBaseContext(), LinearLayoutManager.VERTICAL));
            lstPostres.addItemDecoration(new DividerItemDecoration(this.getBaseContext(), LinearLayoutManager.HORIZONTAL));
        }

        adaptador = new AdaptadorListaPostre(postres);
        lstPostres.setAdapter(adaptador);

        Intent i_duracion = new Intent(this, VerDuracionPlato.class);
        Intent i_valoresNutricionales = new Intent(this, VerValoresNutricionales.class);

        adaptador.setItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onMenuContextualPlato(int posicion, MenuItem menu) {
                switch (menu.getItemId()) {
                    case R.id.showDuration:
                        i_duracion.putExtra("nombre", postres.get(posicion).getNombre());
                        i_duracion.putExtra("duracion", postres.get(posicion).getDuracion());
                        i_duracion.putExtra("imagen", postres.get(posicion).getRutaImagen());
                        startActivity(i_duracion);
                        break;
                    case R.id.showNutricionalValues:
                        i_valoresNutricionales.putExtra("nombre", postres.get(posicion).getNombre());
                        i_valoresNutricionales.putExtra("tabla", postres.get(posicion).getRutaValorNutricional());
                        i_valoresNutricionales.putExtra("imagen", postres.get(posicion).getRutaImagen());
                        startActivity(i_valoresNutricionales);
                        break;
                }
            }
        });

        conectorDB = new ConectorDB(this.getBaseContext());
        rellenarDatos();
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
        postres.removeAll(postres);
        conectorDB.abrir();
        Cursor c = conectorDB.obtenerPostres();
        if (c.moveToFirst()) {
            do {
                Plato p = new Plato();
                p.setNombre(c.getString(0));
                p.setDescripcion(c.getString(1));
                p.setPrecio(c.getDouble(2));
                p.setDuracion(c.getInt(3));
                p.setRutaImagen(c.getInt(4));
                p.setRutaValorNutricional(c.getInt(5));
                postres.add(p);
            } while (c.moveToNext());
        }
        c.close();
        conectorDB.cerrar();
        lstPostres.getAdapter().notifyDataSetChanged();

//        postres.add(new Plato("Yogur natural", "Yogur casero elaborado por nuestro chef. Contiene leche.", 1.50, 2, R.drawable.yogur_natural, R.drawable.tabla_yogur_natural));
//        postres.add(new Plato("Tarta de chocolate", "¡RECOMENDADO POR LA CASA! Bollo de chocolate con nueces en su interior. Se sirve frío y con nata por encima.", 2.50, 10, R.drawable.tarta_chocolate, R.drawable.tabla_tarta_chocolate));
//        postres.add(new Plato("Fruta de temporada", "Frutas a elegir: Melón, Sandía, Manzana o Fresas.", 2, 0, R.drawable.fruta, R.drawable.tabla_fruta));
//        postres.add(new Plato("Gofre", "Gofre elaborado en el momento. Se sirve caliente con unas finas capas de nutella, nata y fresas troceadas.", 3.00, 15, R.drawable.gofre, R.drawable.tabla_gofre));
//        postres.add(new Plato("Creps con nutella", "El postre está compuesto por dos creps con crema de Nutella en su interior. (Se puede servir con otros complementos)", 2.00, 10, R.drawable.crepes, R.drawable.tabla_crepe));
//        postres.add(new Plato("Conos de hellado", "Conos de helado de diferentes sabores. Disponibles: Fresa, Nata, Vainilla, Chocolate y Turrón.", 1.5, 2, R.drawable.cono_helado, R.drawable.tabla_cono_helado));
//        postres.add(new Plato("Flan de huevo", "Flan casero elaborado por nuestro chef con cremoso caramelo por encima.", 2.5, 5, R.drawable.flan, R.drawable.tabla_flan_huevo));
//        postres.add(new Plato("Natillas con canela", "Natillas caseras con regusto a canela de Vigo y con una galleta Maria encima manteniendo su tradición.", 1.10, 8, R.drawable.natillas, R.drawable.tablanatillas));
//        postres.add(new Plato("Brownie", "Disfruta de nuestro Brownie relleno de nata, la mezcla de frio y calor lo convierte en el postre perfecto", 2.50, 5, R.drawable.brownie, R.drawable.tablabrownie));
//        postres.add(new Plato("Cup cakes", "Delicioso combinado de cup cakes de diferentes colores y sabores. Muy esponjosos y sabrosos.", 3.00, 4, R.drawable.cup_cakes, R.drawable.tabla_cup_cakes));
//        postres.add(new Plato("Arroz con leche", "Riquísimo arroz con leche de la casa realizadas con la receta original de la familia. Con ligero sabor a canela.", 2.50, 5, R.drawable.arroz_leche, R.drawable.tabla_arroz_leche));
    }
}

