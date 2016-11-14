package com.limox.jesus.recicledview_application.interfaces;

import android.util.Patterns;

import com.limox.jesus.recicledview_application.model.Error;

/**
 * Created by usuario on 11/11/16.
 */

public interface IValidateUser extends IValidateAccount {


    interface Presenter {
        static int validateCredentialsEmail(String email){
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                return Error.EMAIL_INVALID;
            else
                return Error.OK;
        }
    }
}
