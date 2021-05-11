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
        private TextView titulo, tituloGrid;
        private TextView precio, precioGrid;
        private TextView descripcion;
        private ImageView imComida, imComidaGrid;

        public ComidaViewHolder(View view) {
            super(view);
            titulo = view.findViewById(R.id.txtTitulo);
            precio = view.findViewById(R.id.txtPrecio);
            descripcion = view.findViewById(R.id.txtDescripcion);
            imComida = view.findViewById(R.id.imgComida);
            tituloGrid = view.findViewById(R.id.txtTituloGrid);
            precioGrid = view.findViewById(R.id.txtPrecioGrid);
            imComidaGrid = view.findViewById(R.id.imgComidaGrid);
        }
    }

    public AdaptadorListaComida(ArrayList<Plato> comidas) {
        this.comidas = comidas;
    }

    @Override
    public ComidaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (MainActivity.gridOnComidas == 0) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_list, parent, false);
            return new ComidaViewHolder(itemView);
        } else {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_grid, parent, false);
            return new ComidaViewHolder(itemView);
        }

    }

    @Override
    public void onBindViewHolder(ComidaViewHolder holder, int position) {
        if (MainActivity.gridOnComidas == 0) {
            Plato p = comidas.get(position);
            holder.titulo.setText(p.getNombre());
            holder.descripcion.setText(p.getDescripcionCorta());
            holder.precio.setText("Precio: " + p.getPrecio() + "€.");
            holder.imComida.setImageResource(p.getRutaImagen());
        } else {
            Plato p = comidas.get(position);
            holder.tituloGrid.setText(p.getNombre());
            holder.imComidaGrid.setImageResource(p.getRutaImagen());
            holder.precioGrid.setText(p.getPrecio() + "€");
        }

    }

    @Override
    public int getItemCount() {
        return comidas.size();
    }
}