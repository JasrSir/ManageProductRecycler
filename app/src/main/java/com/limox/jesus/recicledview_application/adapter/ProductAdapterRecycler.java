package com.limox.jesus.recicledview_application.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.limox.jesus.recicledview_application.ProductApplication;
import com.limox.jesus.recicledview_application.R;
import com.limox.jesus.recicledview_application.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 24/10/16.
 */

// El recicledView lo que contiene son ViewHolders
public class ProductAdapterRecycler extends RecyclerView.Adapter<ProductAdapterRecycler.ProductViewHolder> {
    // El recycledView no contiene listas, por lo que no tiene los metodos de las listas por defecto


    // RecycledView tiene que tener:

    // onBindViewHolder (Vinvula datos con otros onBindViewHolder)
    //      Devuelve el objeto view
    //      Que infla el xml
    // Implementar onCreateViewHolder
    // Crear objeto con la coleccion de datos
    // Constructor que reciba el contexto

    private List<Product> products;
    private Context _context;
    private ProductApplication productApplication;

    public ProductAdapterRecycler(Context context) {
        this._context = context;
        productApplication = ((ProductApplication) context.getApplicationContext());
        products = new ArrayList<Product>(productApplication.getProductsSorted(ProductApplication.SORT_DEAFULT));
    }


    @Override
    /**
     * Se usa por cada ProductViewHolder que se cree
     */
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Metemos el layout, le decimos quien es su padre y ponemos false para que lo añada al padre
        // El paren es el recycledView
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);

        return new ProductViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        // Initialize components
        holder.ivwImage_item.setImageResource(products.get(position).getmImage());
        holder.txvName_item.setText(products.get(position).getmName());
        holder.txvPrice_item.setText(products.get(position).getFormattedPrice());
        holder.txvStock_item.setText(products.get(position).getFormattedStock());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView ivwImage_item;
        TextView txvName_item;
        TextView txvStock_item;
        TextView txvPrice_item;

        public ProductViewHolder(View item) {
            super(item);

            txvName_item = (TextView) item.findViewById(R.id.txvName_item);
            txvStock_item = (TextView) item.findViewById(R.id.txvStock_item);
            txvPrice_item = (TextView) item.findViewById(R.id.txvPrice_item);
            ivwImage_item = (ImageView) item.findViewById(R.id.ivwImage_item);
        }
    }

    public void getAllProduct(int TYPE_SORT) {
        products.clear();
        products.addAll(productApplication.getProductsSorted(TYPE_SORT));
        notifyDataSetChanged(); // Notify all the views who implement this list
        // Patron Observer-observator
    }
}
