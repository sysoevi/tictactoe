package com.example.igor.tictactoe.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.igor.tictactoe.CombinationsPool;
import com.example.igor.tictactoe.GameField;
import com.example.igor.tictactoe.R;
import com.example.igor.tictactoe.activity.GameFieldActivity;
import com.example.igor.tictactoe.players.AndroidPlayer;
import com.example.igor.tictactoe.players.Player;

public class GameFieldFragment extends Fragment {
    private AndroidPlayer mAndroidPlayer;
    private Player mPlayer;
    private GameField mGameField;

    private Button mButtonField0_0;
    private Button mButtonField0_1;
    private Button mButtonField0_2;

    private Button mButtonField1_0;
    private Button mButtonField1_1;
    private Button mButtonField1_2;

    private Button mButtonField2_0;
    private Button mButtonField2_1;
    private Button mButtonField2_2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String sign = getActivity().getIntent().getStringExtra(GameFieldActivity.EXTRA_SIGN);
        String mName = getActivity().getIntent().getStringExtra(GameFieldActivity.EXTRA_NAME);

        CombinationsPool combinationsPool = new CombinationsPool(getActivity());
        mGameField = new GameField();
        if(sign.equals("X")){
            mAndroidPlayer = new AndroidPlayer("o", "Android",mGameField, combinationsPool);
        }else{
            mAndroidPlayer = new AndroidPlayer("x", "Android",mGameField, combinationsPool);
        }
        mPlayer = new Player(sign, mName,mGameField);
    }

    public void restartGame(){

    }

    public void move(int i, int y){
        if(!mPlayer.isWinner() & !mAndroidPlayer.isWinner()){
            mPlayer.fill(i,y);
            if(!mPlayer.isWinner()){
                setAndBlockView(mAndroidPlayer.getSign(), mAndroidPlayer.fill());
            }else{
                Toast.makeText(getActivity(), mPlayer.getName() + " победил!", Toast.LENGTH_SHORT).show();
            }
            if(mAndroidPlayer.isWinner()){
                Toast.makeText(getActivity(), mAndroidPlayer.getName() + " победил!", Toast.LENGTH_SHORT).show();
            }
            if(!mGameField.checkEmptyField()){
                Toast.makeText(getActivity(), "Ничья !", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void setAndBlockView(String sign, int position){
        switch (position){
            case -1:
                mButtonField0_0.setText(sign);
                mButtonField0_0.setEnabled(false);
                break;
            case 1:
                mButtonField0_1.setText(sign);
                mButtonField0_1.setEnabled(false);
                break;
            case 2:
                mButtonField0_2.setText(sign);
                mButtonField0_2.setEnabled(false);
                break;
            case 3:
                mButtonField1_0.setText(sign);
                mButtonField1_0.setEnabled(false);
                break;
            case 4:
                mButtonField1_1.setText(sign);
                mButtonField1_1.setEnabled(false);
                break;
            case 5:
                mButtonField1_2.setText(sign);
                mButtonField1_2.setEnabled(false);
                break;
            case 6:
                mButtonField2_0.setText(sign);
                mButtonField2_0.setEnabled(false);
                break;
            case 7:
                mButtonField2_1.setText(sign);
                mButtonField2_1.setEnabled(false);
                break;
            case 8:
                mButtonField2_2.setText(sign);
                mButtonField2_2.setEnabled(false);
                break;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.game_field, container, false);

        mButtonField0_0 = v.findViewById(R.id.field_0_0);
        mButtonField0_1 = v.findViewById(R.id.field_0_1);
        mButtonField0_2 = v.findViewById(R.id.field_0_2);

        mButtonField1_0 = v.findViewById(R.id.field_1_0);
        mButtonField1_1 = v.findViewById(R.id.field_1_1);
        mButtonField1_2 = v.findViewById(R.id.field_1_2);

        mButtonField2_0 = v.findViewById(R.id.field_2_0);
        mButtonField2_1 = v.findViewById(R.id.field_2_1);
        mButtonField2_2 = v.findViewById(R.id.field_2_2);

        mButtonField0_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAndBlockView(mPlayer.getSign(), -1);
                move(0,0);
            }
        });

        mButtonField0_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAndBlockView(mPlayer.getSign(), 1);
                move(0,1);
            }
        });

        mButtonField0_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAndBlockView(mPlayer.getSign(), 2);
                move(0,2);
            }
        });

        mButtonField1_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAndBlockView(mPlayer.getSign(), 3);
                move(1,0);
            }
        });

        mButtonField1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAndBlockView(mPlayer.getSign(), 4);
                move(1,1);
            }
        });

        mButtonField1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAndBlockView(mPlayer.getSign(), 5);
                move(1,2);
            }
        });

        mButtonField2_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAndBlockView(mPlayer.getSign(), 6);
                move(2,0);
            }
        });

        mButtonField2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAndBlockView(mPlayer.getSign(), 7);
                move(2,1);
            }
        });

        mButtonField2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAndBlockView(mPlayer.getSign(), 8);
                move(2,2);
            }
        });

        if(mAndroidPlayer.getSign().equals("x")){
            setAndBlockView(mAndroidPlayer.getSign(), mAndroidPlayer.fill());
        }

        return v;

    }
}
