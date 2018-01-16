package com.example.c4q.reviewforexam;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NumberFragment extends Fragment {
    private View rootView;
    private static final String SHOW_NUMBER="number";
    //I will create an instance class
    public static NumberFragment newInstance(int showNumber){
        Bundle nuevoBundle= new Bundle();
        nuevoBundle.putInt(SHOW_NUMBER,showNumber);
        NumberFragment numberFragment= new NumberFragment();
        numberFragment.setArguments(nuevoBundle);

        return numberFragment;
    }


    public NumberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_number, container, false);
        TextView textView=rootView.findViewById(R.id.numberText);

        Bundle args=getArguments();
        if (args!=null){
            int numberShow=args.getInt(SHOW_NUMBER);
            textView.setText(Integer.toString(numberShow));
        }
        // Inflate the layout for this fragment
        return rootView;
    }

}
