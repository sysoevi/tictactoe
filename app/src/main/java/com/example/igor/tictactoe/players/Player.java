package com.example.igor.tictactoe.players;

import com.example.igor.tictactoe.GameField;

public class Player extends AbstractPlayer {

    public Player(String sign, String name, GameField gameField) {
        super(sign, name, gameField);
    }

    public void fill(int i, int y) {
        getGameField().fill(getSign(), i, y);
        if(getGameField().checkWinner(getSign())){
            setWinner(true);
        }
    }
}
