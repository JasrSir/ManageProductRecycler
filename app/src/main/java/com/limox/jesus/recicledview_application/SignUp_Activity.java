package com.limox.jesus.recicledview_application;

import android.content.res.TypedArray;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SignUp_Activity extends AppCompatActivity {

    private Spinner spCounty;
    private Spinner spCity;
    private Button btnSignup;
    private RadioGroup rgpTipo;
    private TextInputLayout tilNameCompany;
    private AdapterView.OnItemSelectedListener spinerListener;
    private EditText edtUser;
    private EditText edtEmail;
    private EditText edtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        spCounty = (Spinner) findViewById(R.id.crtUser_spnLocalidad);
        spCity = (Spinner) findViewById(R.id.crtUser_spnProvincia);
        rgpTipo = (RadioGroup) findViewById(R.id.crtUser_rgpTipo);

        edtUser = (EditText) findViewById(R.id.crtUser_edtName);
        edtPassword = (EditText) findViewById(R.id.crtUser_edtPasswrd);
        edtEmail = (EditText) findViewById(R.id.crtUser_edtEmail);

        tilNameCompany = (TextInputLayout) findViewById(R.id.crtUser_til_business);

        //Inicializamos provincias
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.provincias, R.layout.support_simple_spinner_dropdown_item);

        // Introducimos el adapter
        spCity.setAdapter(adapter);


        // Event of the radio button group
        initRadioClient();
        // Creamos el delegado de los spinners de OnItemSelectedListener
        loadSpinnerCounty();
        // !!!!! ASOCIAMOS EL DELEGADO A LOS SPINNERS!!!!!
        spCounty.setOnItemSelectedListener(spinerListener);
        spCity.setOnItemSelectedListener(spinerListener);
    }

    private void initRadioClient() {
        rgpTipo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.crtUser_rdbtnParticular:


                        showCompany(false);
                        break;
                    case R.id.crtUser_rdbtnBusiness:
                        showCompany(true);
                        break;
                }

            }
        });
    }


    /**
     * Create user
     *
     * @param view
     */
    public void signup(View view) {
        validate();
    }

    /**
     * show or hide the tilNameCompany
     *
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
                if (view != null) {
                    // Cogemos el padre y lo casteamos a Spiner
                    switch (((Spinner) parent).getId()) {
                        case R.id.crtUser_spnProvincia:
                            // Cogemos el array de provincias a localidades
                            TypedArray resLocali = getResources().obtainTypedArray(R.array.array_provincia_a_localidades);
                            // Cogemos el array de localidades del array cogido antes en la posicion de la ciudad seleccionada
                            CharSequence[] csLocali = resLocali.getTextArray(position);
                            // Creamos el adapter
                            ArrayAdapter<CharSequence> tmpAdapter = new ArrayAdapter<CharSequence>(SignUp_Activity.this, android.R.layout.simple_spinner_dropdown_item, csLocali);
                            // Inyectamos el adapter en las localidades
                            spCounty.setAdapter(tmpAdapter);
                            break;

                        case R.id.crtUser_spnLocalidad:
                            showCitySelected();
                            break;
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
    }

    private void showCitySelected() {
        String message = getString(R.string.message_county_city,
                spCity.getSelectedItem().toString(),
                spCounty.getSelectedItem().toString());
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    private void validate() {
        if (edtUser.getText().length() <= 0) {
            edtUser.setError("The text length is too short");
        }
        if (edtPassword.getText().length() <= 0){
            edtPassword.setError("The text length is too short");
        }

        if (!Pattern.matches(Patterns.EMAIL_ADDRESS.toString(), edtPassword.getText().toString())) {
            edtEmail.setError("Introduce a valid email address");
        }
    }


}
