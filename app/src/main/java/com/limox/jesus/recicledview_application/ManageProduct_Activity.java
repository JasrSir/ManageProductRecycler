package com.limox.jesus.recicledview_application;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.limox.jesus.recicledview_application.interfaces.IProducto;
import com.limox.jesus.recicledview_application.model.Product;

public class ManageProduct_Activity extends AppCompatActivity {

    EditText edtName;
    EditText edtBrand;
    EditText edtDescription;
    EditText edtPrice;
    EditText edtStock;
    EditText edtDosage;
    ImageView ibtnImage;
    Button btnOk;

    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_product);
        edtName = (EditText) findViewById(R.id.mp_edtName);
        edtBrand = (EditText) findViewById(R.id.mp_edtBrand);
        edtDescription = (EditText) findViewById(R.id.mp_edtDescription);
        edtPrice = (EditText) findViewById(R.id.mp_edtPrice);
        edtStock = (EditText) findViewById(R.id.mp_edtStock);
        edtDosage = (EditText) findViewById(R.id.mp_edtDosage);

        ibtnImage = (ImageView) findViewById(R.id.mp_iBtnPicture);

        btnOk = (Button) findViewById(R.id.btnOk);

        product = getIntent().getParcelableExtra(IProducto.PRODUCT_KEY);

        if (product != null){
            edtName.setText(product.getmName());
            edtBrand.setText(product.getmBrand());
            edtDescription.setText(product.getmDescription());
            edtPrice.setText(Double.toString(product.getmPrice()));
            edtStock.setText(Integer.toString(product.getmStock()));
            edtDosage.setText(product.getmDosage());
            btnOk.setText(getResources().getString(R.string.action_add_product));
        }else
            btnOk.setText(getResources().getString(R.string.action_create_product));

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String name = edtName.getText().toString();
                    String brand = edtBrand.getText().toString();
                    String description = edtDescription.getText().toString();
                    String dosage = edtDosage.getText().toString();
                    Double price = Double.parseDouble(edtPrice.getText().toString());
                    int stock =Integer.parseInt(edtStock.getText().toString());

                    product = new Product(name,description,dosage,brand,price,stock);
                    Bundle bundle = new Bundle();
                    Intent intent = getIntent();
                    bundle.putParcelable(IProducto.PRODUCT_KEY,product);
                    intent.putExtras(bundle);
                    setResult(RESULT_OK,intent);
                    finish();


            }
        });



    }


}
