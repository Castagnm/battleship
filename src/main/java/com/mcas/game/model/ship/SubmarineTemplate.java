package com.mcas.game.model.ship;

import com.mcas.game.model.coord.CoordX;
import com.mcas.game.model.coord.CoordY;
import com.mcas.game.model.coord.Direction;

public class SubmarineTemplate extends ShipTemplate {

    private static final int SIZE = 3;

    private static final String NAME = "Submarine";
    
    public SubmarineTemplate(CoordX coordX, CoordY coordY, Direction direction) {
        super(coordX, coordY, direction, SIZE, NAME);
    }
}
