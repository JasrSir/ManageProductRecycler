package com.limox.jesus.recicledview_application.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.limox.jesus.recicledview_application.Product_Activity;
import com.limox.jesus.recicledview_application.R;
import com.limox.jesus.recicledview_application.interfaces.IValidateAccount;
import com.limox.jesus.recicledview_application.interfaces.IValidateAccount.Presenter;
import com.limox.jesus.recicledview_application.interfaces.IValidateUser;

/**
 * Created by jesus on 20/10/16.
 */

public class LoginPresenter implements Presenter {
    // Viene de IValidateAccount

    private static final String TAG = "manageproducts";
    private IValidateAccount.View view;
    private int validateUser;
    private int validatePassword;

    public LoginPresenter(IValidateAccount.View view) {
        this.view = view;
    }
    public void  validateCredentialLogin(String user, String password){
         validateUser = Presenter.validateCredentialsUser(user) ;
         validatePassword = Presenter.validateCredentialsPassword(password);

        if (validateUser== IValidateAccount.OK && validatePassword== IValidateAccount.OK) {
            ((Context)view).startActivity(new Intent(((Context)view), Product_Activity.class));
        }else {
            switch (validateUser) {

            }
            switch (validatePassword) {

            }
        }
    }


}

