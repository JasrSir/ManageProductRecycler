package com.limox.jesus.manageproducts_application.interfaces;

/**
 * Created by jesus on 20/10/16.
 */

public interface ILoginMvp {
    int OK=0;
    int PASSWORD_DIGIT=1;
    int PASSWORD_CASE=2;
    int PASSWORD_LENGTH=3;
    int DATA_EMPTY = 4;

    interface View{
        public void setMessageError(String messageError, int idView);
    }

    interface Present{
        public void validateCredentials(String user, String password);

    }

}
