package com.android.a_la_carta;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorListaComida extends RecyclerView.Adapter<AdaptadorListaComida.ComidaViewHolder> {
    private ArrayList<Plato> comidas;

    public class ComidaViewHolder extends RecyclerView.ViewHolder {
        private TextView titulo;
        private TextView precio;
        private TextView descripcion;
        private ImageView imComida;

        public ComidaViewHolder(View view) {
            super(view);
            titulo = view.findViewById(R.id.txtTitulo);
            precio = view.findViewById(R.id.txtPrecio);
            descripcion = view.findViewById(R.id.txtDescripcion);
            imComida = view.findViewById(R.id.imgComida);
        }
    }

    public AdaptadorListaComida(ArrayList<Plato> comidas) {
        this.comidas = comidas;
    }

    @Override
    public ComidaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_pequeno, parent, false);
        return new ComidaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ComidaViewHolder holder, int position) {
        Plato p = comidas.get(position);
        holder.titulo.setText(p.getNombre());
        holder.descripcion.setText(p.getDescripcion());
        holder.precio.setText("Precio: " + p.getPrecio() + "€.");
        holder.imComida.setImageResource(p.getRutaImagen());
    }

    @Override
    public int getItemCount() {
        return comidas.size();
    }
}