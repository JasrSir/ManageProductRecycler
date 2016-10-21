package com.limox.jesus.manageproducts_application;

import android.app.ListActivity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.view.View;

import com.limox.jesus.manageproducts_application.adapter.ProductAdapterA;
import com.limox.jesus.manageproducts_application.adapter.ProductAdapterB;
import com.limox.jesus.manageproducts_application.adapter.ProductAdapterC;

public class ListProduct_Activity extends ListActivity {

    private static final String TAG = "managesproducts";
    //private ArrayAdapter<Product> adapter;
    FloatingActionButton faBtnAdd;
    private ProductAdapterC adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        faBtnAdd = (FloatingActionButton) findViewById(R.id.faBtnAdd);

        //listView = (ListView) findViewById(R.id.lvProduct) Esto no
        // Caso 1: Adapter no personalizado
        //adapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, ((ProductApplication) getApplication()).getProducts());

        // This make the adapter will be who pick the resources of the database
        adapter = new ProductAdapterC(this);
        // Get the arrayAdapter of the Activity
        getListView().setAdapter(adapter);

        faBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListProduct_Activity.this,AddProduct_Activity.class);
                startActivity(intent);
            }
        });

    }
}
