package com.example.c4q.reviewforexam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.renderscript.ScriptGroup;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MainActivity extends AppCompatActivity {
    private static TextView asynchView;
    private Button b1;
    private  MidtermAsyncTask myAsyncTaskClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        asynchView= findViewById(R.id.checking_ascynchtask);
        b1= findViewById(R.id.button1);
        myAsyncTaskClass= new MidtermAsyncTask(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Handler handler= new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        myAsyncTaskClass.execute(70);
                    }
                },700);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity mainActivity= new MainActivity();
        mainActivity.myAsyncTaskClass=null;

    }

    private static class MidtermAsyncTask extends AsyncTask<Integer, Integer, Integer> {
        private final ReentrantLock lock = new ReentrantLock();
        private final Condition tryAgain = lock.newCondition();
        private volatile boolean finished = false;

            MainActivity activity;

            MidtermAsyncTask(@Nullable MainActivity activity) {
                this.activity = activity;
            }

            @Override
            protected Integer doInBackground(Integer... integers) {
                final int start = integers[0];

                for (int i = 0; i < 100; i++) {
                    try{
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    publishProgress(i);


                }


                return 100 - start;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(Integer result) {
                super.onPostExecute(result);
                Log.d("main",String.valueOf(result));

                if (activity != null) {
                    String info=R.string.loop_result+String.valueOf(result);
                    activity.asynchView.setText("result:"+info);
//                    Intent loginIntent = new Intent(activity, LoginActivity.class);
//                    activity.startActivity(loginIntent);
                }
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);

                int progress = values[0];

                if (activity != null) {
                    activity.asynchView.setText("loops completed:"+progress);
                }
            }

    }
}
/*
I am going to  have three activities in this project
and I am going to use shared preferences to save inputs.
I am going to have use many intents to pass information by using
intent.putStringExtra, intent.getStringExtra and etc.
I am going to use a recyclerView inside of a fragment to show numbers.
which make it a little easier for me
I will also use presenters so I can organize my code a little better



 */
