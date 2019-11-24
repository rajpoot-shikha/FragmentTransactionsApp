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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mAddFragmentBtn;
    private Button mRemoveFragmentBtn;
    private Fragment mTargetFragment;
    private TextView mNextText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();
        registerClicks();

        mTargetFragment = new FragmentOne();
    }

    /*
     * This method provides the views with their xml ids
     */
    private void findViewById() {
        mAddFragmentBtn = findViewById(R.id.add_fragment_button);
        mRemoveFragmentBtn = findViewById(R.id.remove_fragment_button);
        mNextText = findViewById(R.id.next_txt);
    }

    /*
     * This method sets the on click listener on views
     */
    private void registerClicks() {
        mRemoveFragmentBtn.setOnClickListener(this);
        mAddFragmentBtn.setOnClickListener(this);
        mNextText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_fragment_button:
                addFragment();
                break;

            case R.id.remove_fragment_button:
                removeFragment();
                break;

            case R.id.next_txt:
                startActivity(new Intent(this, ReplaceActivity.class));
        }
    }

    /*
    * Adds the fragment
    */
    private void addFragment() {
        mAddFragmentBtn.setEnabled(false);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container, mTargetFragment, "FragmentOne");
        transaction.commit();
    }

    /*
     * Removes the fragment
     */
    private void removeFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(mTargetFragment);
        transaction.commit();
        mAddFragmentBtn.setEnabled(true);
    }
}
