package com.limox.jesus.manageproducts_application;

import android.app.Application;

import com.limox.jesus.manageproducts_application.model.User;

/**
 * Created by jesus on 20/10/16.
 */

public class LoginApplication extends Application {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

}
