package com.example.fragmenttransactionapp;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {

    private EditText mMessageEdittext;
    private Button mDisplayButton;
    private Communicator mCommunicator;


    public InputFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Communicator) {
            mCommunicator = (Communicator) context;
        } else {
            throw new RuntimeException(context.toString() + "  must implement Communicator Interface");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCommunicator = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_three, container, false);
        mMessageEdittext = view.findViewById(R.id.message_editText);
        mDisplayButton = view.findViewById(R.id.message_display_btn);
        mDisplayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCommunicator.conveyMessage(mMessageEdittext.getText().toString());
            }
        });
        return view;
    }

}
