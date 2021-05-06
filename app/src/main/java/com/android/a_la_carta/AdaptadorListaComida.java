package com.android.a_la_carta;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorListaComida extends RecyclerView.Adapter<AdaptadorListaComida.ComidaViewHolder> {
    private ArrayList<Plato> comidas;

    public class ComidaViewHolder extends RecyclerView.ViewHolder {
        private TextView titulo;
        private TextView precio;
        private TextView duracion;
        private ImageView imComida;

        public ComidaViewHolder(View view) {
            super(view);
            titulo = view.findViewById(R.id.txtTitulo);
            precio = view.findViewById(R.id.txtPrecio);
            duracion = view.findViewById(R.id.txtDuracion);
            imComida = view.findViewById(R.id.imgComida);
        }
    }

    public AdaptadorListaComida(ArrayList<Plato> comidas) {
        this.comidas = comidas;
    }

    @Override
    public ComidaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_grande, parent, false);
        return new ComidaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ComidaViewHolder holder, int position) {
        Plato p = comidas.get(position);
        holder.titulo.setText(p.getNombre());
        holder.duracion.setText("Duracion: " + p.getDuracion() + " minutos.");
        holder.precio.setText("Precio: " + p.getPrecio() + "€.");
        holder.imComida.setImageResource("@drawable/" + p.getRutaImagen());
    }

    @Override
    public int getItemCount() {
        return comidas.size();
    }
}