package com.example.igor.tictactoe;

public class GameField {

    private String[][] mField;

    public GameField(){
        mField = new String[][]
                {{" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}};
    }

    public void newField(){
        for(int i = 0; i < mField.length; i++){
            for(int j = 0; j < mField[i].length; j++){
                mField[i][j] = " ";
            }
        }
    }

    public String[][] getField(){
        return mField;
    }

    public void fill(String sign, int i, int y){
        mField[i][y] = sign;
    }

    public void fill(char[] newGameField){
        int counter = -1;
        for(int i = 0; i < mField.length; i++){
            for(int j = 0; j < mField[i].length; j++){
                counter++;
                mField[i][j] = Character.toString(newGameField[counter]);
            }
        }
    }

    public String toString(){
        return mField[0][0] + mField[0][1] + mField[0][2] +
                mField[1][0] + mField[1][1] + mField[1][2] +
                mField[2][0] + mField[2][1] + mField[2][2];
    }

    public boolean checkEmptyField(){
        for(int i = 0; i < mField.length; i++){
            for(int j = 0; j < mField[i].length; j++){
                if(mField[i][j].equals(" ")){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWinner(String sign){
        return checkHorizontal(sign) || checkVertical(sign) || checkDiagonal(sign);
    }

    private boolean checkHorizontal(String sign){
        for(int i = 0; i < mField.length; i++){
            boolean find = true;
            for(int j = 1; j < mField[i].length && find; j++){
                find = (mField[i][j].equals(mField[i][0])) & (mField[i][0].equals(sign));
            }
            if(find){

               return true;
            }
        }
        return false;
    }

    private boolean checkVertical(String sign){
        for(int i = 0; i < mField.length; i++){
            boolean find = true;
            for (int j = 1; j < mField[i].length && find; j++){
                find = (mField[j][i].equals(mField[0][i]) & (mField[0][i].equals(sign)));
            }
            if (find){
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal(String sign){
        if(mField[0][0].equals(sign) & mField[1][1].equals(mField[0][0]) & mField[2][2].equals(mField[0][0])){
            return true;
        }
        if(mField[2][0].equals(sign) & mField[1][1].equals(mField[2][0]) & mField[0][2].equals(mField[2][0])) {
            return true;
        }
        return false;
    }


}
