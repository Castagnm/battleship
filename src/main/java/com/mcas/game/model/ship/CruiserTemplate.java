package com.mcas.game.model.ship;

import com.mcas.game.model.coord.CoordX;
import com.mcas.game.model.coord.CoordY;
import com.mcas.game.model.coord.Direction;

public class CruiserTemplate extends ShipTemplate {

    private static final int SIZE = 3;

    private static final String NAME = "Cruiser";
    
    public CruiserTemplate(CoordX coordX, CoordY coordY, Direction direction) {
        super(coordX, coordY, direction, SIZE, NAME);
    }
}
