package com.example.c4q.reviewforexam;

/**
 * Created by c4q on 1/15/18.
 */

public interface LoginPresentation {
    String getUsername();
    String getPassword();
    void setUserName(String userName);
    void setPassword(String password);
    void setRememberLoginCredentials(boolean rememberLoginCredentials);
    void navigateToListActivity(String userName);
    void showWrongLoginCredentials();
}
