package com.limox.jesus.recicledview_application.interfaces;

import android.content.Context;
import android.text.TextUtils;

import com.limox.jesus.recicledview_application.R;

/**
 * Created by jesus on 20/10/16.
 */

public interface IValidateAccount {
    int OK=0;
    int PASSWORD_DIGIT=10;
    int PASSWORD_CASE=11;
    int PASSWORD_LENGTH=12;
    int DATA_EMPTY = 13;

    interface View{
        public void setMessageError(String messageError, int idView);
    }

    interface Presenter{

        public static int validateCredentialsUser(String user) {
            boolean validate = true;
            String msgError = "";
            int idError = 0;
            if (TextUtils.isEmpty(user)) {
                return DATA_EMPTY;
            }
            return OK;
        }


        public static int validateCredentialsPassword(String password) {
            boolean validate = false;
            String msgError = "";
            int idError = R.id.edtPassword;

            if (TextUtils.isEmpty(password)) {
                idError = DATA_EMPTY;
            } else if (!password.matches("^.{0,}([0-9])+.{0,}$")) {
                idError = PASSWORD_CASE;
            } else if (!password.matches("^.+[a-zA-Z]+.+$")) {
                idError = PASSWORD_DIGIT;
            } else if (password.length() < 8) {
                idError = PASSWORD_LENGTH;
            }
            else {
                idError = OK;
            }
            // Throw the error
            // If wasn't found any error it sends the code for the good login
            return idError;
        }

    }

}
