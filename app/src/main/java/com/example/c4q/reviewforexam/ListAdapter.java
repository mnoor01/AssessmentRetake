package com.example.c4q.reviewforexam;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c4q on 1/15/18.
 */

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {
    private List<Integer> integerList=new ArrayList<>();
    private ListFragmentPresenter presenter;



    public ListAdapter(List<Integer> integerList,ListFragmentPresenter presenter) {
        this.integerList = integerList;
        this.presenter = presenter;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
