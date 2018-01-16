package com.example.c4q.reviewforexam;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by c4q on 1/15/18.
 */

public class ListViewHolder extends RecyclerView.ViewHolder {
    private ListFragmentPresenter presenter;
    private TextView textView;
    public ListViewHolder(View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.numberText);
        presenter=new ListFragmentPresenter();
    }
    public void onBind(final int number){
        textView.setText(number);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onNumberCLicked(number);
            }
        });
    }
}
