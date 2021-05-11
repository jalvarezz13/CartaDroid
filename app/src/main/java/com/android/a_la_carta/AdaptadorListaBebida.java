package com.android.a_la_carta;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorListaBebida extends RecyclerView.Adapter<AdaptadorListaBebida.BebidaViewHolder> {
    private ArrayList<Plato> bebidas;
    private OnItemSelectedListener itemSelectedListener;

    public class BebidaViewHolder extends RecyclerView.ViewHolder {
        private TextView titulo, tituloGrid;
        private TextView precio, precioGrid;
        private TextView descripcion;
        private ImageView imComida, imComidaGrid;

        public BebidaViewHolder(View view) {
            super(view);
            titulo = view.findViewById(R.id.txtTitulo);
            precio = view.findViewById(R.id.txtPrecio);
            descripcion = view.findViewById(R.id.txtDescripcion);
            imComida = view.findViewById(R.id.imgComida);
            tituloGrid = view.findViewById(R.id.txtTituloGrid);
            precioGrid = view.findViewById(R.id.txtPrecioGrid);
            imComidaGrid = view.findViewById(R.id.imgComidaGrid);

            PopupMenu popup = new PopupMenu(view.getContext(), view);
            popup.getMenuInflater().inflate(R.menu.menu_contextual, popup.getMenu());
            view.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                @Override
                public void onCreateContextMenu(ContextMenu menu, View v,
                                                ContextMenu.ContextMenuInfo menuInfo) {
                    popup.show();
                }
            });

            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (itemSelectedListener != null) {
                        itemSelectedListener.onMenuContextualPlato(getAdapterPosition(), item);
                    }
                    return true;
                }
            });
        }
    }

    public AdaptadorListaBebida(ArrayList<Plato> bebidas) {
        this.bebidas = bebidas;
    }

    @Override
    public AdaptadorListaBebida.BebidaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (MainActivity.gridOnBebidas == 0) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_list, parent, false);
            return new AdaptadorListaBebida.BebidaViewHolder(itemView);
        } else {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_grid, parent, false);
            return new AdaptadorListaBebida.BebidaViewHolder(itemView);
        }

    }

    @Override
    public void onBindViewHolder(AdaptadorListaBebida.BebidaViewHolder holder, int position) {
        if (MainActivity.gridOnBebidas == 0) {
            Plato p = bebidas.get(position);
            holder.titulo.setText(p.getNombre());
            holder.descripcion.setText(p.getDescripcion());
            holder.precio.setText("Precio: " + p.getPrecio() + "€.");
            holder.imComida.setImageResource(p.getRutaImagen());
        } else {
            Plato p = bebidas.get(position);
            holder.tituloGrid.setText(p.getNombre());
            holder.imComidaGrid.setImageResource(p.getRutaImagen());
            holder.precioGrid.setText(p.getPrecio() + "€");
        }

    }

    @Override
    public int getItemCount() {
        return bebidas.size();
    }

    public void setItemSelectedListener(OnItemSelectedListener itemSelectedListener) {
        this.itemSelectedListener = itemSelectedListener;
    }
}