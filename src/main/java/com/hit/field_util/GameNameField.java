package com.hit.field_util;

import com.hit.dm.Game;

public class GameNameField implements GameField{

    @Override
    public String getGameField(Game game) {
        return game.getName();
    }
    
}
