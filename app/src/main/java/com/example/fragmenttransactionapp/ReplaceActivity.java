package com.example.fragmenttransactionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReplaceActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mAddFragmentBtn;
    private Button mReplaceFragmentBtn;
    private TextView mNexttext;
    private Fragment mFragmentOne;
    private Fragment mFragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replace);
        mFragmentOne = new FragmentOne();
        mFragmentTwo = new FragmentTwo();

        findViewById();
        registerClicks();
    }

    /*
    * This method provides the views with their xml ids
    */
    private void findViewById() {
        mAddFragmentBtn = findViewById(R.id.add_fragment_button);
        mReplaceFragmentBtn = findViewById(R.id.replace_fragment_button);
        mNexttext = findViewById(R.id.next_txt);
    }

    /*
     * This method sets the on click listener on views
     */
    private void registerClicks() {
        mAddFragmentBtn.setOnClickListener(this);
        mReplaceFragmentBtn.setOnClickListener(this);
        mNexttext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_fragment_button:
                addFragment();
                break;
            case R.id.replace_fragment_button:
                replaceFragment();
                break;
            case R.id.next_txt:
                startActivity(new Intent(this, CommunicateActivity.class));
        }
    }

    /*
     * Adds the fragment
     */
    private void addFragment() {
        mAddFragmentBtn.setEnabled(false);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container, mFragmentOne, "FragmentOne");
        transaction.commit();
    }

    /*
     * Removes the fragment
     */
    private void replaceFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, mFragmentTwo, "FragmentTwo");
        transaction.commit();
        mAddFragmentBtn.setEnabled(true);
    }

}
