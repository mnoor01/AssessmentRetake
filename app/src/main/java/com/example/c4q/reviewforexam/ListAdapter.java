package com.example.c4q.reviewforexam;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
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
        View childView= LayoutInflater.from(parent.getContext()).inflate(R.layout.number_itemview,parent,false);
        return new ListViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.onBind(position);

    }

    @Override
    public int getItemCount() {
        return integerList.size();
    }
}
