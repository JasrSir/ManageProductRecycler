package com.limox.jesus.manageproducts_application;

import android.content.Context;
import android.text.TextUtils;

import com.limox.jesus.manageproducts_application.interfaces.ILoginMvp;

/**
 * Created by jesus on 20/10/16.
 */

public class LoginPresenter implements ILoginMvp.Present {
    private static final String TAG = "manageproducts";
    private ILoginMvp.View view;

    public LoginPresenter(ILoginMvp.View view) {
        this.view = view;
    }

    @Override
    public void validateCredentials(String user, String password) {

        String msgError = "";
        int idError = 0;
        // Check if have errors and introduce his id and name at the vars
        if (TextUtils.isEmpty(user)) {
            msgError = ((Context) view).getResources().getString(R.string.data_empty);
            idError = R.id.edtUser;
        } else if (TextUtils.isEmpty(password)) {
            msgError = ((Context) view).getResources().getString(R.string.data_empty);
            idError = R.id.edtPassword;
        } else if (!password.matches("^.{0,}([0-9])+.{0,}$")) {
            msgError = ((Context) view).getResources().getString(R.string.password_digit);
            idError = R.id.edtPassword;
        } else if (!password.matches("^.+[a-zA-Z]+.+$")) {
            msgError = ((Context) view).getResources().getString(R.string.password_case);
            idError = R.id.edtPassword;
        } else if (password.length() < 8) {
            msgError = ((Context) view).getResources().getString(R.string.password_length);
            idError = R.id.edtPassword;
        }
        // Throw the error
        // If wasn't found any error it sends the code for the good login
        view.setMessageError(msgError, idError);

    }
}

