package com.limox.jesus.recicledview_application;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.limox.jesus.recicledview_application.adapter.ProductAdapter;
import com.limox.jesus.recicledview_application.interfaces.IProducto;
import com.limox.jesus.recicledview_application.model.Product;
import com.limox.jesus.recicledview_application.settings.AccountSettings_Activity;
import com.limox.jesus.recicledview_application.settings.GeneralSettings_Activity;

public class ListProduct_Fragment extends Fragment {

    private ListView listProduct;
    private boolean alfDown = false;
    private ProductAdapter adapter;
    private Product tmpProduct;
    private FloatingActionButton fabAdd;




    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list_product);

        adapter = new ProductAdapter(this);

        listProduct = (ListView) findViewById(R.id.ap_lvPorductos);
        listProduct.setAdapter(adapter);

        listProduct.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                *//* Esto es de ahora*//*
                AlertDialog.Builder builder = new AlertDialog.Builder(ListProduct_Fragment.this);
                builder.setTitle("¡Cuidado!");
                builder.setMessage("¿Estas segur@ de que quieres borrar este producto?");

                builder.setPositiveButton("Borrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //((ProductAdapter)listProduct.getAdapter()).remove((Product)listProduct.getItemAtPosition(position));
                        adapter.remove(adapter.getItem(position));
                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                return true;
            }
        });
        listProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                tmpProduct = (Product) parent.getItemAtPosition(position);
                bundle.putParcelable(IProducto.PRODUCT_KEY, tmpProduct);
                Intent intent = new Intent(ListProduct_Fragment.this, ManageProduct_Fragment.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, IProducto.EDIT_PRODUCT);

                //TODO MIRAR EL PRODUCTO QUE SE LE ENVIA

            }
        });

        fabAdd = (FloatingActionButton) findViewById(R.id.ap_fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(ListProduct_Fragment.this, ManageProduct_Fragment.class);
                // Cogemos un objeto vacío
                bundle.putParcelable(IProducto.PRODUCT_KEY, tmpProduct);
                intent.putExtras(bundle);
                startActivityForResult(intent, IProducto.ADD_PRODUCT);
            }
        });
    }
    *//**
     * Take the result of startActivityForResult of the method onOptionsItemSelected
     *
     * @param requestCode
     * @param resultCode
     * @param data
     *//*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        switch (requestCode) {
            case IProducto.ADD_PRODUCT:
                if (resultCode == RESULT_OK) {
                    // Creamos un nuevo producto
                    Product product = data.getParcelableExtra(IProducto.PRODUCT_KEY);
                    ((ProductAdapter) listProduct.getAdapter()).addProduct(product);
                }
                break;
            case IProducto.EDIT_PRODUCT:
                if (resultCode == RESULT_OK) {
                    // Editamos un producto
                    Product product = data.getParcelableExtra(IProducto.PRODUCT_KEY);
                    ((ProductAdapter) listProduct.getAdapter()).replaceProduct(tmpProduct, product);
                }
                break;
        }
        // Vaciamos el objeto para que si se le da a añadir nuevo no salga el último modificado
        tmpProduct = null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_product, menu);
        return super.onCreateOptionsMenu(menu);
    }

    *//**
     * For the event of the menu
     *
     * @param item
     * @return if whe use the event, if is false it go to the super
     *//*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_sort_alphabetically:
                adapter.sortAllProduct();
                break;

            case R.id.action_settings_general:
                intent = new Intent(ListProduct_Fragment.this, GeneralSettings_Activity.class);
                startActivity(intent);
                break;
            case R.id.action_settings_account:
                intent = new Intent(ListProduct_Fragment.this, AccountSettings_Activity.class);
                startActivity(intent);
                break;
        }
        return super.onContextItemSelected(item);
    }
*/

}
