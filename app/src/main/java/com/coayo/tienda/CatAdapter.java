package com.coayo.tienda;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> implements View.OnClickListener {
    private List<Category> categorias;
    private View.OnClickListener listener;

    public static class CatViewHolder extends RecyclerView.ViewHolder {
        //campos de un item
        TextView tv_categoria;
        TextView tv_idcategoria;
        ImageView img_categoria;
        RecyclerView rv;

        public CatViewHolder(View itemView) {
            super(itemView);
            rv = (RecyclerView) itemView.findViewById(R.id.rv1);
            tv_categoria = (TextView) itemView.findViewById(R.id.tv_categoria);
            tv_idcategoria = (TextView) itemView.findViewById(R.id.tv_idcategoria);
            img_categoria = (ImageView) itemView.findViewById(R.id.imgcategoria);
        }
    }

    @Override
    public CatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
       // v.setOnClickListener(this);
        CatViewHolder vh = new CatViewHolder(v);
        return vh;
    }

    public CatAdapter(List<Category> unalista) {
        this.categorias = unalista;
    }

    @Override
    public void onBindViewHolder(CatViewHolder holder, int position) {
        Category cat = categorias.get(position);
        holder.tv_categoria.setText(cat.getName());
        holder.tv_idcategoria.setText(String.valueOf(cat.getParentCategoryId()));

    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    @Override
    public void onClick(View view) {
        if (listener != null) listener.onClick(view);
    }

  /*  public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }*/


}