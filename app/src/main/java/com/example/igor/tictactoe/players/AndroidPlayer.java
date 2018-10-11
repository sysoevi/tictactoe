package com.example.igor.tictactoe.players;

import com.example.igor.tictactoe.CombinationsPool;
import com.example.igor.tictactoe.GameField;

import java.util.Arrays;
import java.util.Random;

public class AndroidPlayer extends AbstractPlayer {

    private CombinationsPool mCombinationsPool;

    public AndroidPlayer(String sign, String name, GameField gameField, CombinationsPool combinationsPool) {
        super(sign, name, gameField);
        mCombinationsPool = combinationsPool;
    }

    public int fill() {
        String strField = getGameField().toString();
        String [][] gameField = getGameField().getField();
        for(int i = 0; i < gameField.length; i++){
            for(int j = 0; j < gameField[i].length; j++){
                System.out.print("[" + gameField[i][j] + "]");
            }
            System.out.println();
        }
        char[] newField = mCombinationsPool.getCombinations().get(strField).toCharArray();


        int counter = -1;

        int x = 0;
        int y = 0;

        for(int i = 0; i < gameField.length;i++){
            for (int j = 0; j < gameField[i].length; j++){
                counter++;
                if(!gameField[i][j].equals(Character.toString(newField[counter]))){
                    getGameField().fill(getSign(), i, j);
                    x = i;
                    y = j;
                }
            }
        }

        if(getGameField().checkWinner(getSign())){
            setWinner(true);
        }

        if(x == 0 & y == 0){
            return -1;
        }
        if(x == 0 & y == 1){
            return 1;
        }
        if(x == 0 & y == 2){
            return 2;
        }
        if(x == 1 & y == 0){
            return 3;
        }
        if(x == 1 & y == 1){
            return 4;
        }
        if(x == 1 & y == 2){
            return 5;
        }
        if(x == 2 & y == 0){
            return 6;
        }
        if(x == 2 & y == 1){
            return 7;
        }
        if(x == 2 & y == 2){
            return 8;
        }

        return 0;
    }


}
