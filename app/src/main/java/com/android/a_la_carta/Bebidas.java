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

        Intent i_duracion = new Intent(this, VerDuracionPlato.class);
        Intent i_valoresNutricionales = new Intent(this, VerValoresNutricionales.class);

        adaptador.setItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onMenuContextualPlato(int posicion, MenuItem menu) {
                switch (menu.getItemId()) {
                    case R.id.showDuration:
                        i_duracion.putExtra("nombre", bebidas.get(posicion).getNombre());
                        i_duracion.putExtra("duracion", bebidas.get(posicion).getDuracion());
                        i_duracion.putExtra("imagen", bebidas.get(posicion).getRutaImagen());
                        startActivity(i_duracion);
                        break;
                    case R.id.showNutricionalValues:
                        i_valoresNutricionales.putExtra("nombre", bebidas.get(posicion).getNombre());
                        i_valoresNutricionales.putExtra("tabla", bebidas.get(posicion).getRutaValorNutricional());
                        i_valoresNutricionales.putExtra("imagen", bebidas.get(posicion).getRutaImagen());
                        startActivity(i_valoresNutricionales);
                        break;
                }
            }
        });
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
        bebidas.add(new Plato("Coca-Cola", "Bebida gaseosa y refrescante de cola.", 2.20, 0, R.drawable.coca_cola, R.drawable.tabla_cocacola));
        bebidas.add(new Plato("Fanta de Naranja", "Bebida gaseosa y refrescante con sabor a naranja.", 2.20, 0, R.drawable.fanta_naranja, R.drawable.fanta_naranja));
        bebidas.add(new Plato("Fanta de Limon", "Bebida gaseosa y refrescante con sabor a limon.", 2.20, 0, R.drawable.fanta_limon, R.drawable.tabla_fantalimon));
        bebidas.add(new Plato("Cerveza Amstel (con Alcohol)", "Bebida alcohólica preparada a base de cebada", 2.00, 0, R.drawable.cerveza_amstel, R.drawable.tabla_cerveza_amstel));
        bebidas.add(new Plato("San Miguel", "Cerveza fría, de procedencia cantábrica.", 2.20, 0, R.drawable.sanmiguel, R.drawable.tablacerveza));
        bebidas.add(new Plato("Mahou", "Cerveza artesanal con 120 años de experiencia.", 2.20, 0, R.drawable.mahou, R.drawable.tablacervezaligera));
        bebidas.add(new Plato("Aquarius", "Bebida azucarada para darte energía", 2.00, 0, R.drawable.aquarius, R.drawable.tablaaquarius));
        bebidas.add(new Plato("Trina", "Bebida perfecta para los días de calor.", 2.20, 0, R.drawable.trina, R.drawable.tablatrina));
        bebidas.add(new Plato("Agua embotellada", "Agua de manantial, 100% libre de impurezas. Elige entre fría o del tiempo.", 1.50, 0, R.drawable.agua, R.drawable.tablaagua));
        bebidas.add(new Plato("Nestea", "Bebida resfrescante con ligero sabor a limón", 2.20, 0, R.drawable.nestea, R.drawable.tablanestea));
        bebidas.add(new Plato("Batido de Chocolate", "Batido con un 80% de cacao original. ¡Pruébalo!", 2.00, 0, R.drawable.batidochocolate, R.drawable.tablabatidochocolate));
    }
}