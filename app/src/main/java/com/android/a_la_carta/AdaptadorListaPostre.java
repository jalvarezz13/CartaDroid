package com.android.a_la_carta;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorListaPostre extends RecyclerView.Adapter<AdaptadorListaPostre.PostreViewHolder> {
    private ArrayList<Plato> postres;

    public class PostreViewHolder extends RecyclerView.ViewHolder {
        private TextView titulo, tituloGrid;
        private TextView precio, precioGrid;
        private TextView descripcion;
        private ImageView imComida, imComidaGrid;

        public PostreViewHolder(View view) {
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

    public AdaptadorListaPostre(ArrayList<Plato> postres) {
        this.postres = postres;
    }


    @Override
    public AdaptadorListaPostre.PostreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (MainActivity.gridOnPostres == 0) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_list, parent, false);
            return new AdaptadorListaPostre.PostreViewHolder(itemView);
        } else {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_grid, parent, false);
            return new AdaptadorListaPostre.PostreViewHolder(itemView);
        }

    }

    @Override
    public void onBindViewHolder(AdaptadorListaPostre.PostreViewHolder holder, int position) {
        if (MainActivity.gridOnPostres == 0) {
            Plato p = postres.get(position);
            holder.titulo.setText(p.getNombre());
            holder.descripcion.setText(p.getDescripcionCorta());
            holder.precio.setText("Precio: " + p.getPrecio() + "€.");
            holder.imComida.setImageResource(p.getRutaImagen());
        } else {
            Plato p = postres.get(position);
            holder.tituloGrid.setText(p.getNombre());
            holder.imComidaGrid.setImageResource(p.getRutaImagen());
            holder.precioGrid.setText(p.getPrecio() + "€");
        }

    }

    @Override
    public int getItemCount() {
        return postres.size();
    }
}