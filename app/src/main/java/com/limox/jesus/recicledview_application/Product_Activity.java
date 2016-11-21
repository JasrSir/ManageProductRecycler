package com.limox.jesus.recicledview_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.limox.jesus.recicledview_application.adapter.ProductAdapter;
import com.limox.jesus.recicledview_application.adapter.ProductAdapterRecycler;
import com.limox.jesus.recicledview_application.interfaces.IProducto;
import com.limox.jesus.recicledview_application.model.Product;
import com.limox.jesus.recicledview_application.settings.AccountSettings_Activity;
import com.limox.jesus.recicledview_application.settings.GeneralSettings_Activity;

public class Product_Activity extends AppCompatActivity {

    private ListView listProduct;
    private static final int ADD_PRODUCT = 0;
    private static final int EDIT_PRODUCT = 1;
    private boolean alfDown = false;
    private ProductAdapter adapter;
    private Product tmpProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        adapter = new ProductAdapter(this);

        listProduct = (ListView) findViewById(R.id.ap_lvPorductos);
        listProduct.setAdapter(adapter);

        listProduct.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                tmpProduct = (Product)parent.getItemAtPosition(position);
                bundle.putSerializable(IProducto.PRODUCT_KEY,tmpProduct);
                Intent intent = new Intent(Product_Activity.this,ManageProduct_Activity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent,EDIT_PRODUCT);

                //TODO MIRAR EL PRODUCTO QUE SE LE ENVIA
                return true;
            }

        });
    }


    /**
     * Method who inflate the menu into the Activity
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // This inflate the menu
        getMenuInflater().inflate(R.menu.menu_product, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * For the event of the menu
     *
     * @param item
     * @return if whe use the event, if is false it go to the super
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_add_product:
                intent = new Intent(Product_Activity.this, ManageProduct_Activity.class);
                // if (startActivityForResult(intent,ADD_PRODUCT))
                break;
            case R.id.action_sort_alphabetically:
                adapter.getAllProduct();
                break;

            case R.id.action_settings_general:
                intent = new Intent(Product_Activity.this, GeneralSettings_Activity.class);
                startActivity(intent);
                break;
            case R.id.action_settings_account:
                intent = new Intent(Product_Activity.this, AccountSettings_Activity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Take the result of startActivityForResult of the method onOptionsItemSelected
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        switch (requestCode) {
            case ADD_PRODUCT:
                if (resultCode == RESULT_OK) {
                    Product product = (Product)data.getExtras().getSerializable(IProducto.PRODUCT_KEY);
                    ((ProductAdapter)listProduct.getAdapter()).addProduct(product);
                }
                    break;
            case EDIT_PRODUCT:
                if (resultCode == RESULT_OK){
                 Product product = (Product) data.getExtras().getSerializable(IProducto.PRODUCT_KEY);
                    ((ProductAdapter)listProduct.getAdapter()).replaceProduct(tmpProduct,product);
                }
                break;

        }
    }
}
