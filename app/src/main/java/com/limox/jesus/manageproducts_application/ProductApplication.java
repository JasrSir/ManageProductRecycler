package com.limox.jesus.manageproducts_application;

import android.app.Application;

import com.limox.jesus.manageproducts_application.model.Product;

import java.util.ArrayList;

/**
 * Created by jesus on 20/10/16.
 */

public class ProductApplication extends Application {
    ArrayList<Product> mListaProductos = new ArrayList<Product>();

    @Override
    public void onCreate() {
        super.onCreate();
        //region adding Products
        saveProduct(new Product("Iboprufeno", "te lo cura to", "600", "IboMarc", ((double) 6), 70, R.drawable.img1));
        saveProduct(new Product("Ometrazol", "tambien te lo cura to", "600", "OmeMarc", ((double) 6), 70, R.drawable.img2));
        saveProduct(new Product("Dalsi", "te engancha", "800", "Dalsis", ((double) 6), 70, R.drawable.img3));
        saveProduct(new Product("Frenadol", "Me da alergia", "1000", "FrenaMarc", ((double) 6), 70, R.drawable.img4));
        saveProduct(new Product("Curatol", "te lo cura todo, pero todo todo", "500", "CuraMarc", ((double) 6), 70, R.drawable.img5));
        saveProduct(new Product("Carajillo", "Para dar energía por la mañana", "1000", "CaraMarc", ((double) 6), 70, R.drawable.img6));
        // endregion
    }

    /**
     * Add products to the ArrayList of the class
     * @param product product to add
     */
    private void saveProduct(Product product) {

        mListaProductos.add(product);

    }

    public ArrayList<Product> getProducts() {
        return mListaProductos;
    }
}