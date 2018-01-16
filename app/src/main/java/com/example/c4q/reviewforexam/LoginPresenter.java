package com.example.c4q.reviewforexam;

import android.support.annotation.Nullable;

/**
 * Created by c4q on 1/15/18.
 */

public class LoginPresenter {
    private final IPreferencesHelper preferencesHelper;
    private @Nullable LoginPresentation presentation;

    public LoginPresenter(IPreferencesHelper preferencesHelper) {
        this.preferencesHelper = preferencesHelper;
    }

    public void attach(LoginPresentation presentation) {
        this.presentation = presentation;
        presentation.setRememberLoginCredentials(preferencesHelper.rememberLoginCredentials());
        if (presentation != null) {
            if (preferencesHelper.rememberLoginCredentials()) {
                presentation.setUserName(preferencesHelper.getUserName());
                presentation.setPassword(preferencesHelper.getPassword());

            }
        }

    }

    public void detach() {
        presentation = null;
    }

    public void onCredentialsCheckboxClicked(boolean rememberCredentials) {
        preferencesHelper.rememberLoginCredentials(rememberCredentials);
        if (presentation != null) {
            if (rememberCredentials) {
                String userName = presentation.getUsername();
                String password = presentation.getPassword();

                preferencesHelper.saveUserName(userName);
                preferencesHelper.savePassword(password);
            }
        }
    }

    public void onLoginButtonClicked() {
        if (presentation != null){
            if (hasCorrectLoginCredentials()){
                presentation.navigateToListActivity(presentation.getUsername());
            }
            else {
                presentation.showWrongLoginCredentials();
            }
        }
    }
    public boolean hasCorrectLoginCredentials(){
        return presentation!=null &&presentation.getUsername().equals("user@aol.com")&&
                presentation.getPassword().equals("password1234");
    }

}
