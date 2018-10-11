package com.example.igor.tictactoe.fragments;

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
    private int[] mButtonArray;

    private Button mButtonField0_0;
    private Button mButtonField0_1;
    private Button mButtonField0_2;

    private Button mButtonField1_0;
    private Button mButtonField1_1;
    private Button mButtonField1_2;

    private Button mButtonField2_0;
    private Button mButtonField2_1;
    private Button mButtonField2_2;

    private Button mNewGameButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String sign = getActivity().getIntent().getStringExtra(GameFieldActivity.EXTRA_SIGN);
        String mName = getActivity().getIntent().getStringExtra(GameFieldActivity.EXTRA_NAME);

        mButtonArray = new int[] {-1, 1, 2, 3, 4, 5, 6, 7, 8};

        CombinationsPool combinationsPool = new CombinationsPool(getActivity());
        mGameField = new GameField();
        if(sign.equals("X")){
            mAndroidPlayer = new AndroidPlayer("o", "Android",mGameField, combinationsPool);
        }else{
            mAndroidPlayer = new AndroidPlayer("x", "Android",mGameField, combinationsPool);
        }
        mPlayer = new Player(sign, mName,mGameField);
    }

    public void endOfGame(){
        mNewGameButton.setVisibility(View.VISIBLE);

        mButtonField0_0.setEnabled(false);
        mButtonField0_1.setEnabled(false);
        mButtonField0_2.setEnabled(false);

        mButtonField1_0.setEnabled(false);
        mButtonField1_1.setEnabled(false);
        mButtonField1_2.setEnabled(false);

        mButtonField2_0.setEnabled(false);
        mButtonField2_1.setEnabled(false);
        mButtonField2_2.setEnabled(false);
    }

    public void restartGame(){
        mGameField.newField();

        mAndroidPlayer.setWinner(false);
        mPlayer.setWinner(false);

        for(int i = 0; i < mButtonArray.length; i++){
            setStateOfView(" ", mButtonArray[i], true);
        }

        if(mAndroidPlayer.getSign().equals("x")){
            setStateOfView(mAndroidPlayer.getSign(), mAndroidPlayer.fill(), false);
        }

    }

    public void move(int i, int y){
        if(!mPlayer.isWinner() & !mAndroidPlayer.isWinner()){
            mPlayer.fill(i,y);
            if(!mPlayer.isWinner()){
                setStateOfView(mAndroidPlayer.getSign(), mAndroidPlayer.fill(), false);
            }else{
                Toast.makeText(getActivity(), mPlayer.getName() + " победил!", Toast.LENGTH_SHORT).show();
                endOfGame();
            }
            if(mAndroidPlayer.isWinner()){
                Toast.makeText(getActivity(), mAndroidPlayer.getName() + " победил!", Toast.LENGTH_SHORT).show();
                endOfGame();
            }
            if(!mGameField.checkEmptyField() & !mPlayer.isWinner() & !mAndroidPlayer.isWinner()){
                Toast.makeText(getActivity(), "Ничья !", Toast.LENGTH_SHORT).show();
                endOfGame();
            }
        }
    }

    public void setStateOfView(String sign, int position, boolean enable){
        switch (position){
            case -1:
                mButtonField0_0.setText(sign);
                mButtonField0_0.setEnabled(enable);
                break;
            case 1:
                mButtonField0_1.setText(sign);
                mButtonField0_1.setEnabled(enable);
                break;
            case 2:
                mButtonField0_2.setText(sign);
                mButtonField0_2.setEnabled(enable);
                break;
            case 3:
                mButtonField1_0.setText(sign);
                mButtonField1_0.setEnabled(enable);
                break;
            case 4:
                mButtonField1_1.setText(sign);
                mButtonField1_1.setEnabled(enable);
                break;
            case 5:
                mButtonField1_2.setText(sign);
                mButtonField1_2.setEnabled(enable);
                break;
            case 6:
                mButtonField2_0.setText(sign);
                mButtonField2_0.setEnabled(enable);
                break;
            case 7:
                mButtonField2_1.setText(sign);
                mButtonField2_1.setEnabled(enable);
                break;
            case 8:
                mButtonField2_2.setText(sign);
                mButtonField2_2.setEnabled(enable);
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

        mNewGameButton = v.findViewById(R.id.new_game_button);
        mNewGameButton.setVisibility(View.GONE);

                mButtonField0_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setStateOfView(mPlayer.getSign(), -1, false);
                move(0,0);
            }
        });

        mButtonField0_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setStateOfView(mPlayer.getSign(), 1, false);
                move(0,1);
            }
        });

        mButtonField0_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setStateOfView(mPlayer.getSign(), 2, false);
                move(0,2);
            }
        });

        mButtonField1_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setStateOfView(mPlayer.getSign(), 3, false);
                move(1,0);
            }
        });

        mButtonField1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setStateOfView(mPlayer.getSign(), 4, false);
                move(1,1);
            }
        });

        mButtonField1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setStateOfView(mPlayer.getSign(), 5, false);
                move(1,2);
            }
        });

        mButtonField2_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setStateOfView(mPlayer.getSign(), 6, false);
                move(2,0);
            }
        });

        mButtonField2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setStateOfView(mPlayer.getSign(), 7, false);
                move(2,1);
            }
        });

        mButtonField2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setStateOfView(mPlayer.getSign(), 8, false);
                move(2,2);
            }
        });

        if(mAndroidPlayer.getSign().equals("x")){
            setStateOfView(mAndroidPlayer.getSign(), mAndroidPlayer.fill(), false);
        }

        mNewGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartGame();
                mNewGameButton.setVisibility(View.GONE);
            }
        });

        return v;

    }
}
