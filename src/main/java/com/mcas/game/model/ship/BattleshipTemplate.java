package com.mcas.game.model.ship;

import com.mcas.game.model.coord.CoordX;
import com.mcas.game.model.coord.CoordY;
import com.mcas.game.model.coord.Direction;

public class BattleshipTemplate extends ShipTemplate {

    private static final int SIZE = 4;

    private static final String NAME = "Battleship";
    
    public BattleshipTemplate(CoordX coordX, CoordY coordY, Direction direction) {
        super(coordX, coordY, direction, SIZE, NAME);
    }
}
