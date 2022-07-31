package com.mcas.game.model.ship;

import com.mcas.game.model.coord.CoordX;
import com.mcas.game.model.coord.CoordY;
import com.mcas.game.model.coord.Direction;

public class PatrolBoatTemplate extends ShipTemplate {
    
    private static final int SIZE = 2;

    private static final String NAME = "Patrol boat";

    public PatrolBoatTemplate(CoordX coordX, CoordY coordY, Direction direction) {
        super(coordX, coordY, direction, SIZE, NAME);
    }
}
