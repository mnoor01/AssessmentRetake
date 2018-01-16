package com.example.c4q.reviewforexam;

/**
 * Created by c4q on 1/15/18.
 */

public interface IPreferencesHelper {
    void saveUserName(String userName);
    String getUserName();
    void savePassword(String passWord);
    String getPassword();
    void rememberLoginCredentials(boolean rememberLoginCredentials);
    boolean rememberLoginCredentials();
}
