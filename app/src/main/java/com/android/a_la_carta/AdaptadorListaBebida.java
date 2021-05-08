package com.android.a_la_carta;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorListaBebida extends RecyclerView.Adapter<AdaptadorListaBebida.BebidaViewHolder> {
    private ArrayList<Plato> bebidas;

    public class BebidaViewHolder extends RecyclerView.ViewHolder {
        private TextView titulo;
        private TextView precio;
        private TextView descripcion;
        private ImageView imComida;

        public BebidaViewHolder(View view) {
            super(view);
            titulo = view.findViewById(R.id.txtTitulo);
            precio = view.findViewById(R.id.txtPrecio);
            descripcion = view.findViewById(R.id.txtDescripcion);
            imComida = view.findViewById(R.id.imgComida);
        }
    }

    public AdaptadorListaBebida(ArrayList<Plato> bebidas) {
        this.bebidas = bebidas;
    }

    @Override
    public AdaptadorListaBebida.BebidaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_list, parent, false);
        return new AdaptadorListaBebida.BebidaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AdaptadorListaBebida.BebidaViewHolder holder, int position) {
        Plato p = bebidas.get(position);
        holder.titulo.setText(p.getNombre());
        holder.descripcion.setText(p.getDescripcion());
        holder.precio.setText("Precio: " + p.getPrecio() + " €");
        holder.imComida.setImageResource(p.getRutaImagen());
    }

    @Override
    public int getItemCount() {
        return bebidas.size();
    }
}