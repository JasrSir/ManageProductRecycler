package com.limox.jesus.recicledview_application.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;

import com.limox.jesus.recicledview_application.Product_Activity;
import com.limox.jesus.recicledview_application.R;
import com.limox.jesus.recicledview_application.interfaces.IValidateAccount;
import com.limox.jesus.recicledview_application.interfaces.IValidateUser;
import com.limox.jesus.recicledview_application.model.Error;
import com.limox.jesus.recicledview_application.model.User;
import com.limox.jesus.recicledview_application.preferences.AccountPreference;
import com.limox.jesus.recicledview_application.utils.ErrorMapUtils;


/**
 * Created by usuario on 11/11/16.
 */

public class SignupPresenter implements IValidateUser.Presenter, IValidateUser.PresenterUser {

    private int validateUser;
    private int validatePassword;
    private int validateEmail;
    private IValidateAccount.View view;
    private Context context;

    public SignupPresenter(IValidateAccount.View view) {
        this.view = view;
        this.context = (Context) view;
    }

    public void validateCredentials(String user, String password, String email){

        validateUser = validateCredentialsUser(user) ;
        validatePassword = validateCredentialsPassword(password);
        validateEmail = validateCredentialsEmail(email);

        if (validateUser== Error.OK) {
            if (validatePassword== Error.OK) {
                if (validateEmail == Error.OK){
                // Guardamos en las preferencias
                savePreferences(user,password,email);
                view.startActivity();
                }else{
                    String nameResource= ErrorMapUtils.getErrorMapResource(context).get(String.valueOf(validateEmail));
                    view.setMessageError(nameResource, R.id.crtUser_til_email);
                }
            } else{
                //                                  coge el mapa del contexto          coge el valor de la key
                String nameResource= ErrorMapUtils.getErrorMapResource(context).get(String.valueOf(validatePassword));
                view.setMessageError(nameResource, R.id.crtUser_til_email);
            }
        }else {
            //                                  coge el mapa del contexto          coge el valor de la key
            String nameResource= ErrorMapUtils.getErrorMapResource(context).get(String.valueOf(validateUser));
            view.setMessageError(nameResource, R.id.crtUser_til_email);
        }
    }

    private void savePreferences(String user,String password,String email) {
        AccountPreference accountPreference = (AccountPreference) AccountPreference.getInstance(context);
        accountPreference.putUser(user);
        accountPreference.putPassword(password);
        accountPreference.putEmail(email);
    }


    @Override
    public int validateCredentialsUser(String user) {
        boolean validate = true;
        String msgError = "";
        int idError = Error.OK;
        if (TextUtils.isEmpty(user)) {
            idError = Error.DATA_EMPTY;
        }
        return idError;
    }

    @Override
    public int validateCredentialsPassword(String password) {
        boolean validate = false;
        String msgError = "";
        int idError = R.id.edtPassword;

        if (TextUtils.isEmpty(password)) {
            idError = Error.DATA_EMPTY;
        } else if (!password.matches("^.{0,}([0-9])+.{0,}$")) {
            idError = Error.PASSWORD_CASE;
        } else if (!password.matches("^.+[a-zA-Z]+.+$")) {
            idError = Error.PASSWORD_DIGIT;
        } else if (password.length() < 8) {
            idError = Error.PASSWORD_LENGTH;
        }
        else {
            idError = Error.OK;
        }
        // Throw the error
        // If wasn't found any error it sends the code for the good login
        return idError;
    }

    @Override
    public int validateCredentialsEmail(String email) {
        int idError = Error.OK;
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                idError = Error.EMAIL_INVALID;

                return idError;
    }
}
