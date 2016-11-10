package com.limox.jesus.recicledview_application.preferences;

import android.content.Context;
import android.content.SharedPreferences;
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
    public static final String FILE = "com.limox.jesus.recicledview_application_preferences";
    public static final String USER = "user";
    public static final String PASSWORD = "password";
    public static Context contexto;

    private AccountPreference(){

    }
    //Singletón de la clase
    public static IPreferences getInstance(Context context){
        if (accountPreference == null){
            accountPreference = new AccountPreference();
            contexto = context;
        }
        return accountPreference;
    }
    public static void putUser(String user){
        getEditor().putString(USER,user).apply();
    }
    private static SharedPreferences.Editor getEditor(Context context){
        SharedPreferences sharedPreferences
        return SharedPreferences
    }
}
