package com.example.fragmenttransactionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class CommunicateActivity extends AppCompatActivity implements Communicator {

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communicate);
        FragmentManager manager = getSupportFragmentManager();
        fragment = manager.findFragmentById(R.id.fragment_four);
    }

    @Override
    public void conveyMessage(String message) {
        DisplayFragment displayFragment = (DisplayFragment) fragment;
        displayFragment.displayMessage(message);
    }
}
