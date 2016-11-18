package com.limox.jesus.recicledview_application;

import android.app.Application;

import com.limox.jesus.recicledview_application.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jesus on 20/10/16.
 */

public class ProductApplication extends Application {
    ArrayList<Product> mListaProductos = new ArrayList<Product>();
    public static final int SORT_DEAFULT = 0;
    public static final int SORT_ALPH_UP = 1;
    public static final int SORT_ALPH_DOWN = 2;
    public static final int SORT_PRICE_DOWN = 3;

    @Override
    public void onCreate() {
        super.onCreate();
        //region adding Products
        saveProduct(new Product("Aguamarinatol", "te limpia la napia", "500", "Mar", ((double) 15), 130, R.drawable.img1));
        saveProduct(new Product("Emetrazol", "tambien te lo cura to", "600", "OmeMarc", ((double) 6), 10, R.drawable.img2));
        saveProduct(new Product("Calsi", "te engancha", "800", "Dalsis", ((double) 6), 70, R.drawable.img3));
        saveProduct(new Product("Brenadol", "Me da alergia", "1000", "FrenaMarc", ((double) 7), 55, R.drawable.img4));
        saveProduct(new Product("Furatol", "te lo cura todo, pero todo todo", "500", "CuraMarc", ((double) 6), 70, R.drawable.img5));
        saveProduct(new Product("Yarajillo", "Para dar energía por la mañana", "1000", "CaraMarc", ((double) 6), 80, R.drawable.img6));
        saveProduct(new Product("Iboprufeno", "te lo cura to", "600", "IboMarc", ((double) 3.50), 70, R.drawable.img1));
        saveProduct(new Product("Ometrazol", "tambien te lo cura to", "600", "OmeMarc", ((double) 6), 20, R.drawable.img2));
        saveProduct(new Product("Dalsi", "te engancha", "800", "Dalsis", ((double) 78.42), 70, R.drawable.img3));
        saveProduct(new Product("Frenadol", "Me da alergia", "1000", "FrenaMarc", ((double) 6), 70, R.drawable.img4));
        saveProduct(new Product("Curatol", "te lo cura todo, pero todo todo", "500", "CuraMarc", ((double) 6), 270, R.drawable.img5));
        saveProduct(new Product("Carajillo", "Para dar energía por la mañana", "1000", "CaraMarc", ((double) 6), 3, R.drawable.img6));
        saveProduct(new Product("Dalsi", "te engancha", "800", "Dalsis", ((double) 6), 70, R.drawable.img3));
        saveProduct(new Product("Frenadol", "Me da alergia", "1000", "FrenaMarc", ((double) 6), 80, R.drawable.img4));
        saveProduct(new Product("Curatol", "te lo cura todo, pero todo todo", "500", "CuraMarc", ((double) 6), 10, R.drawable.img5));
        saveProduct(new Product("Carajillo", "Para dar energía por la mañana", "1000", "CaraMarc", ((double) 6), 70, R.drawable.img6));
        saveProduct(new Product("Iboprufeno", "te lo cura to", "600", "IboMarc", ((double) 6), 60, R.drawable.img1));
        saveProduct(new Product("Ometrazol", "tambien te lo cura to", "600", "OmeMarc", ((double) 6), 70, R.drawable.img2));
        saveProduct(new Product("Dalsi", "te engancha", "800", "Dalsis", ((double) 20), 70, R.drawable.img3));
        saveProduct(new Product("Frenadol", "Me da alergia", "1000", "FrenaMarc", ((double) 6), 10, R.drawable.img4));
        saveProduct(new Product("Curatol", "te lo cura todo, pero todo todo", "500", "CuraMarc", ((double) 6), 40, R.drawable.img5));
        saveProduct(new Product("Carajillo", "Para dar energía por la mañana", "1000", "CaraMarc", ((double) 6), 14, R.drawable.img6));
        // endregion
    }

    /**
     * Add products to the ArrayList of the class
     *
     * @param product product to add
     */
    private void saveProduct(Product product) {

        mListaProductos.add(product);

    }

    public List<Product> getProductsSorted(int TYPE_SORT) {
        //Asi es como se hacia antes
        //Collections.sort(mListaProductos,Product.PRICE_COMPARATOR);
        switch (TYPE_SORT) {
            case 0:
                Collections.sort(mListaProductos);
                break;
            case 1:
                Collections.reverse(mListaProductos);
          /*  case 1:
                Collections.sort(mListaProductos, (p1, p2) -> (p1.getmName().compareTo(p2.getmName())));
                break;
            case 2:
                Collections.sort(mListaProductos, (p1, p2) -> (p2.getmName().compareTo(p1.getmName())));
                break;
            case 3:
                Collections.sort(mListaProductos, (p1, p2) -> Double.compare(p1.getmStock(), p2.getmStock()));
                break;*/
        }

        return mListaProductos;
    }
    public List<Product> getProducts() {
        return mListaProductos;
    }
}