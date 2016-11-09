package com.limox.jesus.recicledview_application;

import android.content.res.TypedArray;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class SignUp_Activity extends AppCompatActivity {

    private Spinner spCounty;
    private Spinner spCity;
    private Button btnSignup;
    private RadioGroup rgpTipo;
    private TextInputLayout tilNameCompany;
    private AdapterView.OnItemSelectedListener spinerListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        spCounty = (Spinner) findViewById(R.id.crtUser_spnLocalidad);
        spCity = (Spinner) findViewById(R.id.crtUser_spnProvincia);
        rgpTipo = (RadioGroup) findViewById(R.id.crtUser_rgpTipo);

        tilNameCompany = (TextInputLayout) findViewById(R.id.crtUser_til_business);

        //Inicializamos provincias
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.provincias,R.layout.support_simple_spinner_dropdown_item);
        // Introducimos el adapter
        spCity.setAdapter(adapter);


        // Event of the radio button group
        rgpTipo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.crtUser_rdbtnParticular:
                        showCompany(false);
                        break;
                    case R.id.crtUser_rdbtnBusiness:
                        showCompany(true);
                        break;
                }

            }
        });

        loadSpinnerCounty();
    }


    /**
     * Create user
     * @param view
     */
    public void signup(View view){

    }

    /**
     * show or hide the tilNameCompany
     * @param visibility
     */
    private void showCompany(boolean visibility) {
        tilNameCompany.setVisibility(visibility ? View.VISIBLE : View.GONE);
    }

    /**
     * load the contais of the spinners
     */
    private void loadSpinnerCounty() {
        spinerListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (view.getId()){
                    case R.id.crtUser_spnProvincia:
                        //Inicializamos localidades
                        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,position,R.layout.support_simple_spinner_dropdown_item);

                        break;
                    case R.id.crtUser_spnLocalidad:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
    }


}
