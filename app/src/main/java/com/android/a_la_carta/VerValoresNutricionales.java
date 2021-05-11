package com.android.a_la_carta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class VerValoresNutricionales extends AppCompatActivity {
    private TextView titulo, descripcion;
    private ImageView imgComida, imgTabla;
    private ProgressBar pbDuracion;
    private Button btnVale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valores_nutricionales);

        titulo = findViewById(R.id.txtTituloValorNutricional);
        imgComida = findViewById(R.id.imgComidaValorNutricional);
        imgTabla = findViewById(R.id.imgTablaValorNutricional);
        btnVale = findViewById(R.id.btnVale);

        Bundle bundle = getIntent().getExtras();
        titulo.setText(bundle.getString("nombre"));
        imgComida.setImageResource(bundle.getInt("imagen"));
        imgTabla.setImageResource(bundle.getInt("tabla"));

        btnVale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}