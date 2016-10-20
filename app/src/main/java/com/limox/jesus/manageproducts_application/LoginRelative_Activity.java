package com.limox.jesus.manageproducts_application;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginRelative_Activity extends AppCompatActivity implements  ILoginMvp.View{

    private ILoginMvp.Present loginMvp;
    private EditText mEdtPassword;
    private EditText mEdtUser;
    private Button mBtnLogin;
    private TextInputLayout mTilUser;
    private TextInputLayout mTilPassword;
    private final String TAG="logintextinputlayout";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //region Initiations
        loginMvp = new LoginPresenter(this);
        mEdtUser = (EditText) findViewById(R.id.edtUser);
        mEdtPassword = (EditText) findViewById(R.id.edtPassword);
        mBtnLogin = (Button) findViewById(R.id.btnLogin);
        mTilUser = (TextInputLayout) findViewById(R.id.tilUser);
        mTilPassword = (TextInputLayout) findViewById(R.id.tilPassword);
        //endregion

        //region Anonymous method
        mEdtUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTilUser.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mEdtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTilPassword.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validates the credentials picked from the name and the password
                loginMvp.validateCredentials(mEdtUser.getText().toString(), mEdtPassword.getText().toString());
            }
        });
    //endregion

        //Comprobar la persistencia del objeto Application
        /* I comment that because if I let it free I cant cast class at the other activity
            cause the Manifest need the application name of who is going to use others class resources
        if (((LoginApplication)getApplicationContext()).getUser() != null){
            Log.d(TAG, ((LoginApplication)getApplicationContext()).getUser().toString());
        }else {
            Log.d(TAG, "No hay nadie");
        }
        */
        // All who is iniciated at onCreate must be finalize  at onStop
        Log.d(TAG,"Activity inicializada");

    }
    @Override
    public void setMessageError(String messageError, int idView) {
        //Toast.makeText(this, messageError, Toast.LENGTH_SHORT).show();

        switch (idView){
            case R.id.edtUser:
                // This show us the message of error below the widget like in html
                mTilUser.setError(messageError);
                break;
            case R.id.edtPassword:
                // This show us the message of error below the widget like in html
                mTilPassword.setError(messageError);
                break;
            case 0: // Login accepted
                Intent intent = new Intent(this,ListProduct_Activity.class);
                startActivity(intent);
                finish();
                break;
        }

    }

    //Es el par de onCreate
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Activity finalizada");
    }



    /**
     * Turns the values of mEdtPassword and mEdtUser to ""
     */
    private void resetValues(){
        mEdtPassword.setText("");
        mEdtUser.setText("");
    }
}
