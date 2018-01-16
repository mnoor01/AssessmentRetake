package com.example.c4q.reviewforexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LoginPresentation{
    private LoginPresenter loginPresenter;
    private EditText userNameEditText;
    private EditText passwordEditText;
    private CheckBox rememberCredentialsCheckbox;
    private Button loginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter = new LoginPresenter(new PreferencesHelper(this));
        userNameEditText=findViewById(R.id.username);
        passwordEditText=findViewById(R.id.password);
        rememberCredentialsCheckbox=findViewById(R.id.logincheckbox);

        rememberCredentialsCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onCredentialsCheckboxClicked(rememberCredentialsCheckbox.isChecked());
            }
        });
        loginButton=findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onLoginButtonClicked();
            }
        });




    }

    @Override
    protected void onStart() {
        super.onStart();
        loginPresenter.attach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        loginPresenter.detach();
    }

    @Override
    public String getUsername() {
        return userNameEditText.getText().toString();
    }

    @Override
    public String getPassword() {
        return passwordEditText.getText().toString();
    }

    @Override
    public void setUserName(String userName) {
        userNameEditText.setText(userName);

    }

    @Override
    public void setPassword(String password) {
     passwordEditText.setText(password);
    }

    @Override
    public void setRememberLoginCredentials(boolean rememberLoginCredentials) {
        rememberCredentialsCheckbox.setChecked(rememberLoginCredentials);

    }

    @Override
    public void navigateToListActivity(String userName) {
        Intent intent=ListActivity.getNewIntent(this,userName);
        startActivity(intent);

    }

    @Override
    public void showWrongLoginCredentials() {
        Toast.makeText(this,"incorrect username or password",Toast.LENGTH_LONG).show();

    }
}
