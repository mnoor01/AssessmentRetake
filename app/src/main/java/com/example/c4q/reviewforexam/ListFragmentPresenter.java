package com.example.c4q.reviewforexam;

/**
 * Created by c4q on 1/15/18.
 */

public class ListFragmentPresenter {
    private ListFragmentPresentation presentation;
    public void attach(ListFragmentPresentation presentation){
        this.presentation=presentation;
    }
    public void detach(){
        presentation=null;
    }
    public void onNumberCLicked(int number){
        if (presentation!=null){
            presentation.showNumber(number*10);
        }
    }

    interface ListFragmentPresentation{
        void showNumber(int number);
    }
}
