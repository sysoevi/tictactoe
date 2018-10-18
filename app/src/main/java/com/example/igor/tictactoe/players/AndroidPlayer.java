package com.example.igor.tictactoe.players;

import com.example.igor.tictactoe.CombinationsPool;
import com.example.igor.tictactoe.GameField;

import java.util.Arrays;
import java.util.Random;

public class AndroidPlayer extends AbstractPlayer {

    private CombinationsPool mCombinationsPool;
    private int aiLevel;
    private Random mRandom;

    public AndroidPlayer(String sign, String name, GameField gameField, CombinationsPool combinationsPool, int aiLevel) {
        super(sign, name, gameField);
        this.aiLevel = aiLevel;
        mCombinationsPool = combinationsPool;
        if(aiLevel == 0){
            mRandom = new Random();
        }
    }

    public int getAiLevel() {
        return aiLevel;
    }

    public void setAiLevel(int aiLevel) {
        this.aiLevel = aiLevel;
    }

    public int fill() {
        String strField = getGameField().toString();
        String [][] gameField = getGameField().getField();

        int x = 0;
        int y = 0;

        if(aiLevel == 1){
            for(int i = 0; i < gameField.length; i++){
                for(int j = 0; j < gameField[i].length; j++){
                    System.out.print("[" + gameField[i][j] + "]");
                }
                System.out.println();
            }
            char[] newField = mCombinationsPool.getCombinations().get(strField).toCharArray();

            int counter = -1;

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
        }

        if(aiLevel == 0){
            while (true){
                x = mRandom.nextInt(3);
                y = mRandom.nextInt(3);

                if(getGameField().checkCell(x,y)){
                    getGameField().fill(getSign(), x,y);
                    System.out.println("сходил");
                    break;
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
