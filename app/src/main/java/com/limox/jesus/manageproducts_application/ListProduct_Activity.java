package com.limox.jesus.manageproducts_application;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.limox.jesus.manageproducts_application.model.Product;

public class ListProduct_Activity extends ListActivity {

    private static final String TAG = "managesproducts";
    private ArrayAdapter<Product> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);
        //listView = (ListView) findViewById(R.id.lvProduct) Esto no
        // Caso 1: Adapter no personalizado
        try {
            adapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, ((ProductApplication) getApplication()).getProducts());
            // Get the arrayAdapter of the Activity
            getListView().setAdapter(adapter);
        }catch (Exception e)
        {
            String error = e.getMessage();
            Log.d(TAG,error);
        }
    }
}
