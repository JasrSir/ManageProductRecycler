package com.limox.jesus.manageproducts_application.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.limox.jesus.manageproducts_application.ProductApplication;
import com.limox.jesus.manageproducts_application.R;
import com.limox.jesus.manageproducts_application.model.Product;

/**
 * Created by usuario on 21/10/16.
 */

public class ProductAdapterB extends ArrayAdapter<Product> {

    private Context context;

    public ProductAdapterB(Context context) {
        // Pick the context, the layout, and the list of products
        super(context, R.layout.item_product,((ProductApplication)context.getApplicationContext()).getProducts());
        // Grab the context
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // A bit better way

        View item = convertView;
        ImageView ivwImage_item;
        TextView txvName_item;
        TextView txvStock_item;
        TextView txvPrice_item;

        // If the convertView isn't in memory create it, else use the created
        if (item == null) {

            //1. Create a objext inflater who initializates to LayourInflater of the proyecy
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());

            // 2.
            // Inflate view
            // Inflate the itemProduct and the parent go null to put a parent
            // This create at memory the objects View who contains the xml
            item = layoutInflater.inflate(R.layout.item_product, null);
        }
        //3
        // Asignate to the vars the widgets using findViewById
        // Make it simple cause is already charged in memory for inflate the view
        ivwImage_item = (ImageView) item.findViewById(R.id.ivwImage_item);
        txvName_item = (TextView) item.findViewById(R.id.txvName_item);
        txvStock_item = (TextView) item.findViewById(R.id.txvStock_item);
        txvPrice_item = (TextView) item.findViewById(R.id.txvPrice_item);


        //4
        // Asignate the datas of the adapter of the widgets
        ivwImage_item.setImageResource(getItem(position).getmImage());
        txvName_item.setText(getItem(position).getmName());
        txvStock_item.setText(getItem(position).getFormattedStock());
        txvPrice_item.setText(getItem(position).getFormattedPrice());

        return item;
    }
}
