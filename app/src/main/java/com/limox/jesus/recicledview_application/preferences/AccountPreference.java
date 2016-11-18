package com.limox.jesus.recicledview_application.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import com.limox.jesus.recicledview_application.interfaces.IPreferences;

import java.io.File;
import java.util.Map;
import java.util.Set;

/**
 * Created by usuario on 10/11/16.
 */

public class AccountPreference implements IPreferences {

    private static IPreferences accountPreference;
    //No es el package es el id de la aplicacin
    // public static final String FILE = "com.limox.jesus.recicledview_application_preferences";
    public static final String USER = "user";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    private SharedPreferences sharedPreferences;

    private AccountPreference(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    //Singletón de la clase
    public static IPreferences getInstance(Context context) {
        if (accountPreference == null) {
            accountPreference = new AccountPreference(context);
        }
        return accountPreference;
    }

    public void putUser(String user) {
        getEditor().putString(USER, user).apply();
    }

    public void putPassword(String password) {
        getEditor().putString(PASSWORD, password).apply();
    }

    public void putEmail(String email) {
        getEditor().putString(EMAIL, email).apply();
    }

    private SharedPreferences.Editor getEditor() {
        return sharedPreferences.edit();
    }
}
