package com.example.c4q.reviewforexam;


import android.app.*;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment implements ListFragmentPresenter.ListFragmentPresentation {
    private RecyclerView recyclerView;
    private View rootView;
    private static final String KEY_USERNAME = "username";

    public static ListFragment newInstance(String userName) {
        Bundle bunde = new Bundle();
        bunde.putString(KEY_USERNAME, userName);
        ListFragment listFragment = new ListFragment();
        listFragment.setArguments(bunde);
        return listFragment;
    }

    private ListAdapter adapter;
    private ListFragmentPresenter presenter;


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_list, container, false);
        Bundle nice = getArguments();
        if (nice != null) {
            String userName = nice.getString(KEY_USERNAME);
            TextView userNameView = rootView.findViewById(R.id.userTextView);
            userNameView.setText(userName);
        }
        recyclerView=rootView.findViewById(R.id.list_recyclerview);
        ArrayList<Integer> listOfIntegers=new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            listOfIntegers.add(i);
        }
        presenter=new ListFragmentPresenter();
        ListAdapter adapter= new ListAdapter(listOfIntegers,presenter);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attach(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detach();
    }

    @Override
    public void showNumber(int number) {

        ((ListActivity) getActivity()).showNumber(number);


    }
}
