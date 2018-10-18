package com.example.igor.tictactoe.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.igor.tictactoe.fragments.GameFieldFragment;

public class GameFieldActivity extends SingleFragmentActivity {

    public static final String EXTRA_NAME = "com.example.igor.tictactoe.name";
    public static final String EXTRA_SIGN = "com.example.igor.tictactoe.sign";
    public static final String EXTRA_AI_LEVEL = "com.example.igor.tictactoe.aiLevel";


    public static Intent newIntent(Context context,String name, String sign, int aiLevel){
        Intent intent = new Intent(context, GameFieldActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        intent.putExtra(EXTRA_SIGN, sign);
        intent.putExtra(EXTRA_AI_LEVEL, aiLevel);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new GameFieldFragment();
    }
}
