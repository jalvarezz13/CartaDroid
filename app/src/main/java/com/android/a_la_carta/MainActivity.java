package com.android.a_la_carta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnComidas, btnBebidas, btnPostres;
    public static int gridOnComidas = 0;
    public static int gridOnBebidas = 0;
    public static int gridOnPostres = 0;
    public static ConectorDB conectorDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnComidas = findViewById(R.id.btnComida);
        btnBebidas = findViewById(R.id.btnBebida);
        btnPostres = findViewById(R.id.btnPostres);

        btnComidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Comidas.class));
            }
        });

        btnBebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Bebidas.class));
            }
        });

        btnPostres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Postres.class));
            }
        });

        conectorDB = new ConectorDB(this.getBaseContext());
//        insertarDataBase();
    }

    private void insertarDataBase() {
        conectorDB.abrir();

        conectorDB.insertarPlato("comida", "Hamburguesa de vacuno", "Hamburguesa de carne de vacuno 120 gramos, tomate, queso, lechuga, pepinillos y pan con semillas de sésamo.", 5.95, 20, R.drawable.hamburguesa, R.drawable.tabla_hamburguesa);
        conectorDB.insertarPlato("comida", "Patatas fritas", "Cucurucho de patatas fritas con dos salsas a elegir.", 2.50, 15, R.drawable.patatas_fritas, R.drawable.tabla_patatas_fritas);
        conectorDB.insertarPlato("comida", "Bocadillo de calamares", "Bocadillo de calamares rebozados con salsa tártara.", 3.99, 9, R.drawable.bocadillo_calamares, R.drawable.tabla_bocadillo_calamares);
        conectorDB.insertarPlato("comida", "Ensalada césar", "Ensalada con picatostes de pan frito, tiras de pollo rebozadas y salsa césar.", 5.00, 12, R.drawable.ensalada_cesar, R.drawable.tabla_ensalada_cesar);
        conectorDB.insertarPlato("comida", "Pizza Pepperoni", "¡ESPECIAL DE LA CASA! Pizza con base de queso y rodajas de pepperoni.", 9.95, 20, R.drawable.pizza_peperonni, R.drawable.tabla_pizza_pepperoni);
        conectorDB.insertarPlato("comida", "Alitas de pollo", "Crujientes alitas de pollo picantes y con salsa barbacoa.", 5.50, 20, R.drawable.alitas, R.drawable.tabla_alitas);
        conectorDB.insertarPlato("comida", "Sopa de marisco", "Rica y nutritiva sopa de marisco, del mar a tu plato.", 6.00, 15, R.drawable.sopa_marisco, R.drawable.tabla_sopa_marisco);
        conectorDB.insertarPlato("comida", "Ensalada mixta", "Ensalada de la caso con hortalizas recien cogidas del huerto.", 4.50, 13, R.drawable.ensalada, R.drawable.ensalada);
        conectorDB.insertarPlato("comida", "Lentejas", "Lentejas cocidas con verdura y carne para combatir el frío.", 5.00, 17, R.drawable.lentejas, R.drawable.tabla_lentejas);
        conectorDB.insertarPlato("comida", "Paella", "Auténtica paella valenciana hecha por nuestros chefs en un tiempo record sin perder su sabor original.", 12.00, 40, R.drawable.paella, R.drawable.tabla_paella);
        conectorDB.insertarPlato("comida", "Pan", "Pan del dia horneado para lograr su corteza crujiente y su miga tierna.", 1.50, 0, R.drawable.pan, R.drawable.tabla_pan);

        conectorDB.insertarPlato("bebida", "Coca-Cola", "Bebida gaseosa y refrescante de cola.", 2.20, 0, R.drawable.coca_cola, R.drawable.tabla_cocacola);
        conectorDB.insertarPlato("bebida", "Fanta de Naranja", "Bebida gaseosa y refrescante con sabor a naranja.", 2.20, 0, R.drawable.fanta_naranja, R.drawable.fanta_naranja);
        conectorDB.insertarPlato("bebida", "Fanta de Limon", "Bebida gaseosa y refrescante con sabor a limon.", 2.20, 0, R.drawable.fanta_limon, R.drawable.tabla_fantalimon);
        conectorDB.insertarPlato("bebida", "Cerveza Amstel (con Alcohol)", "Bebida alcohólica preparada a base de cebada", 2.00, 0, R.drawable.cerveza_amstel, R.drawable.tabla_cerveza_amstel);
        conectorDB.insertarPlato("bebida", "San Miguel", "Cerveza fría, de procedencia cantábrica.", 2.20, 0, R.drawable.sanmiguel, R.drawable.tablacerveza);
        conectorDB.insertarPlato("bebida", "Mahou", "Cerveza artesanal con 120 años de experiencia.", 2.20, 0, R.drawable.mahou, R.drawable.tablacervezaligera);
        conectorDB.insertarPlato("bebida", "Aquarius", "Bebida azucarada para darte energía", 2.00, 0, R.drawable.aquarius, R.drawable.tablaaquarius);
        conectorDB.insertarPlato("bebida", "Trina", "Bebida perfecta para los días de calor.", 2.20, 0, R.drawable.trina, R.drawable.tablatrina);
        conectorDB.insertarPlato("bebida", "Agua embotellada", "Agua de manantial, 100% libre de impurezas. Elige entre fría o del tiempo.", 1.50, 0, R.drawable.agua, R.drawable.tablaagua);
        conectorDB.insertarPlato("bebida", "Nestea", "Bebida resfrescante con ligero sabor a limón", 2.20, 0, R.drawable.nestea, R.drawable.tablanestea);
        conectorDB.insertarPlato("bebida", "Batido de Chocolate", "Batido con un 80% de cacao original. ¡Pruébalo!", 2.00, 0, R.drawable.batidochocolate, R.drawable.tablabatidochocolate);

        conectorDB.insertarPlato("postre", "Yogur natural", "Yogur casero elaborado por nuestro chef. Contiene leche.", 1.50, 2, R.drawable.yogur_natural, R.drawable.tabla_yogur_natural);
        conectorDB.insertarPlato("postre", "Tarta de chocolate", "¡RECOMENDADO POR LA CASA! Bollo de chocolate con nueces en su interior. Se sirve frío y con nata por encima.", 2.50, 10, R.drawable.tarta_chocolate, R.drawable.tabla_tarta_chocolate);
        conectorDB.insertarPlato("postre", "Fruta de temporada", "Frutas a elegir: Melón, Sandía, Manzana o Fresas.", 2, 0, R.drawable.fruta, R.drawable.tabla_fruta);
        conectorDB.insertarPlato("postre", "Gofre", "Gofre elaborado en el momento. Se sirve caliente con unas finas capas de nutella, nata y fresas troceadas.", 3.00, 15, R.drawable.gofre, R.drawable.tabla_gofre);
        conectorDB.insertarPlato("postre", "Creps con nutella", "El postre está compuesto por dos creps con crema de Nutella en su interior. (Se puede servir con otros complementos)", 2.00, 10, R.drawable.crepes, R.drawable.tabla_crepe);
        conectorDB.insertarPlato("postre", "Conos de hellado", "Conos de helado de diferentes sabores. Disponibles: Fresa, Nata, Vainilla, Chocolate y Turrón.", 1.5, 2, R.drawable.cono_helado, R.drawable.tabla_cono_helado);
        conectorDB.insertarPlato("postre", "Flan de huevo", "Flan casero elaborado por nuestro chef con cremoso caramelo por encima.", 2.5, 5, R.drawable.flan, R.drawable.tabla_flan_huevo);
        conectorDB.insertarPlato("postre", "Natillas con canela", "Natillas caseras con regusto a canela de Vigo y con una galleta Maria encima manteniendo su tradición.", 1.10, 8, R.drawable.natillas, R.drawable.tablanatillas);
        conectorDB.insertarPlato("postre", "Brownie", "Disfruta de nuestro Brownie relleno de nata, la mezcla de frio y calor lo convierte en el postre perfecto", 2.50, 5, R.drawable.brownie, R.drawable.tablabrownie);
        conectorDB.insertarPlato("postre", "Cup cakes", "Delicioso combinado de cup cakes de diferentes colores y sabores. Muy esponjosos y sabrosos.", 3.00, 4, R.drawable.cup_cakes, R.drawable.tabla_cup_cakes);
        conectorDB.insertarPlato("postre", "Arroz con leche", "Riquísimo arroz con leche de la casa realizadas con la receta original de la familia. Con ligero sabor a canela.", 2.50, 5, R.drawable.arroz_leche, R.drawable.tabla_arroz_leche);

        conectorDB.cerrar();
    }


}