package com.example.c4q.reviewforexam;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;



public class ListActivity extends AppCompatActivity {
    private static final String KEY_USERNAME="username";
    public static Intent getNewIntent(Context context, String username) {
        Intent intent = new Intent(context, ListActivity.class);
        intent.putExtra(KEY_USERNAME, username);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        String userName=getIntent().getStringExtra(KEY_USERNAME);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frag_container, ListFragment.newInstance(userName));

        fragmentManager.executePendingTransactions();
    }
    public void showNumber(int number){
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frag_container, NumberFragment.newInstance(number));
        fragmentManager.executePendingTransactions();

    }
}
