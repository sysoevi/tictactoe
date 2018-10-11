package com.example.igor.tictactoe.players;

import com.example.igor.tictactoe.GameField;

abstract class AbstractPlayer {

    private String mSign;
    private String mName;
    private boolean winner;
    private GameField mGameField;

    public AbstractPlayer(String sign, String name, GameField gameField){
        mSign = sign;
        mName = name;
        winner = false;
        mGameField = gameField;
    }

    public String getSign() {
        return mSign;
    }

    public String getName(){
        return mName;
    }

    public boolean isWinner() {
        return winner;
    }

    protected void setWinner(boolean winner) {
        this.winner = winner;
    }

    protected GameField getGameField() {
        return mGameField;
    }

}
