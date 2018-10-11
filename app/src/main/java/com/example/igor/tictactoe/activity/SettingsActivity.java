package com.example.igor.tictactoe.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.example.igor.tictactoe.R;
import com.example.igor.tictactoe.fragments.SettingsFragment;

public class SettingsActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new SettingsFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
