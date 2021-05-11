package com.android.a_la_carta;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class VerDuracionPlato extends AppCompatActivity {
    private TextView titulo, descripcion;
    private ImageView imgComida;
    private ProgressBar pbDuracion;
    private Button btnVale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duracion_plato);

        titulo = findViewById(R.id.txtTituloDuracion);
        descripcion = findViewById(R.id.txtDescripcionDuracion);
        imgComida = findViewById(R.id.imgComidaDuracion);
        pbDuracion = findViewById(R.id.pbDuracion);
        btnVale = findViewById(R.id.btnVale);

        Bundle bundle=getIntent().getExtras();
        titulo.setText(bundle.getString("nombre"));
        descripcion.setText("La duración del plato es de " + bundle.getInt("duracion") + " minutos.");
        imgComida.setImageResource(bundle.getInt("imagen"));
        pbDuracion.setProgress(bundle.getInt("duracion"));

        btnVale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}