package com.limox.jesus.recicledview_application.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.limox.jesus.recicledview_application.ProductApplication;
import com.limox.jesus.recicledview_application.R;
import com.limox.jesus.recicledview_application.model.Product;

import java.util.ArrayList;
import java.util.Collections;

/**
 * No hace falta llamar a notifyDataSetChanged al usar:
 * add(), insert(), remove(), clear(), sort()... Se llama solo
 */

public class ProductAdapter extends ArrayAdapter<Product> {

    ProductApplication productApplication;
    private boolean ASC = true;

    /**
     * Se pasa como parametro la lista de productos y se hace una copia de ella,
     * por lo que no se actualiza directamente de la otra, se tiene una copia local.
     *
     * @param context
     */
    public ProductAdapter(Context context) {
        super(context, R.layout.item_product,new ArrayList<Product>(((ProductApplication)context.getApplicationContext()).getProducts()));
        productApplication = ((ProductApplication)context.getApplicationContext());
    }

    @NonNull
    @Override                          //La lista           // El que contiene a convertView
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        ProductHolder productHolder = null;
        if (view == null){

            // Esto es a partir de ciarta api
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.item_product, null);

            productHolder=new ProductHolder();

            // TODO IMPORTANTE!! INICIALIZAR LOS COMPONENTES DEL PRODUCTHOLDER CON LO DE LA VISTA ITEM_PRODUCT
            productHolder.produc_image = (ImageView)view.findViewById(R.id.ivwImage_item);
            productHolder.txvName = (TextView)view.findViewById(R.id.txvName_item);
            productHolder.txvStock = (TextView)view.findViewById(R.id.txvStock_item);
            productHolder.txvPrice = (TextView)view.findViewById(R.id.txvPrice_item);


            view.setTag(productHolder);

        }else
            productHolder = (ProductHolder)view.getTag();

        productHolder.produc_image.setImageResource(getItem(position).getmImage());
        productHolder.txvName.setText(getItem(position).getmName());
        productHolder.txvStock.setText(getItem(position).getFormattedStock());
        productHolder.txvPrice.setText(getItem(position).getFormattedPrice());

        return view;


    }

    /**
     *
     */
    public void getAllProduct(/*int TYPE_SORT*/) {
        /*this.clear();
        this.addAll(productApplication.getProductsSorted(TYPE_SORT));
        notifyDataSetChanged(); // Notify all the views who implement this list
        // Patron Observer-observator*/
        ASC=!ASC;
        if (ASC)
        sort(Product.NAME_COMARATOR);
        else
            sort(Collections.<Product>reverseOrder());
    }

    public void editProduct(Product product) {

    }

    class ProductHolder{
        ImageView produc_image;
        TextView txvName;
        TextView txvStock;
        TextView txvPrice;
    }

    public void addProduct(Product product){
        add(product);
        /*En el caso de que lo mandasemos a la base de dato
        dao.add(product);
        notifyDataSetChanged();*/
    }
}
