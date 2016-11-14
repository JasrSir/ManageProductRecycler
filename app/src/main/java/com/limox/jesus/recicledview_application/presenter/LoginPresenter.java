package com.limox.jesus.recicledview_application.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.limox.jesus.recicledview_application.Product_Activity;
import com.limox.jesus.recicledview_application.R;
import com.limox.jesus.recicledview_application.interfaces.IValidateAccount;
import com.limox.jesus.recicledview_application.interfaces.IValidateAccount.Presenter;
import com.limox.jesus.recicledview_application.interfaces.IValidateUser;
import com.limox.jesus.recicledview_application.model.Error;
import com.limox.jesus.recicledview_application.utils.ErrorMapUtils;

/**
 * Created by jesus on 20/10/16.
 */

public class LoginPresenter implements Presenter {
    // Viene de IValidateAccount

    private static final String TAG = "manageproducts";
    private IValidateAccount.View view;
    private int validateUser;
    private int validatePassword;
    private Context mContext;

    public LoginPresenter(IValidateAccount.View view) {
        this.view = view;
        this.mContext = (Context)view;
    }
    public void  validateCredentialLogin(String user, String password){
         validateUser = Presenter.validateCredentialsUser(user) ;
         validatePassword = Presenter.validateCredentialsPassword(password);

        if (validateUser== Error.OK) {
            if (validatePassword== Error.OK) {
                Intent intent = new Intent(mContext,Product_Activity.class);
                view.startActivity(intent);
            } else{
                //                                  coge el mapa del contexto          coge el valor de la key
                String nameResource= ErrorMapUtils.getErrorMapResource(mContext).get(String.valueOf(validatePassword));
                view.setMessageError(nameResource, R.id.tilPassword);
            }
        }else {
            //                                  coge el mapa del contexto          coge el valor de la key
            String nameResource= ErrorMapUtils.getErrorMapResource(mContext).get(String.valueOf(validateUser));
            view.setMessageError(nameResource, R.id.tilUser);
        }
    }


}

