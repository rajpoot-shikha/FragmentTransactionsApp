package com.example.fragmenttransactionapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {

    private TextView mDisplayMessage;

    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_four, container, false);
        mDisplayMessage = view.findViewById(R.id.display_msg);
        return view;
    }

    void displayMessage(String message) {
        if (mDisplayMessage != null) {
            mDisplayMessage.setText(message);
        }
    }

}
