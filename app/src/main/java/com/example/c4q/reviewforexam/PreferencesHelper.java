package com.example.c4q.reviewforexam;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by c4q on 1/15/18.
 */

public class PreferencesHelper implements IPreferencesHelper {
    private static final String KEY_PREF_USERNAME = "username pref";
    private static final String KEY_PREF_PASSWORD = "password pref";
    private static final String KEY_PREF_REMEMBER_CREDENTIALS = "remember credentials pref";
    private final Context context;

    public PreferencesHelper(Context context) {
        this.context = context;
    }

    @Override
    public void saveUserName(String userName) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        preferences.edit().putString(KEY_PREF_USERNAME,userName).apply();//this is saving the input by using sharedpreferences.


    }

    @Override
    public String getUserName() {
        SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(context);
        String defaultValue="";
        return preferences.getString(KEY_PREF_USERNAME,defaultValue);
    }

    @Override
    public void savePassword(String passWord) {
        SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(context);
        preferences.edit().putString(KEY_PREF_PASSWORD,passWord).apply();

    }

    @Override
    public String getPassword() {
        SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(context);
        String defaultValue=" ";
        return preferences.getString(KEY_PREF_PASSWORD,defaultValue);
    }

    @Override
    public void rememberLoginCredentials(boolean loginCredentials) {
        SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(context);
        preferences.edit().putBoolean(KEY_PREF_REMEMBER_CREDENTIALS,loginCredentials).apply();

    }

    @Override
    public boolean rememberLoginCredentials() {
        SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(context);
        boolean defaultValue=false;
        return preferences.getBoolean(KEY_PREF_REMEMBER_CREDENTIALS,defaultValue);
    }
}
