package com.mcas.game.model.ship;

import com.mcas.game.model.coord.CoordX;
import com.mcas.game.model.coord.CoordY;
import com.mcas.game.model.coord.Direction;

public class CarrierTemplate extends ShipTemplate {

    private static final int SIZE = 5;

    private static final String NAME = "Carrier";
    
    public CarrierTemplate(CoordX coordX, CoordY coordY, Direction direction) {
        super(coordX, coordY, direction, SIZE, NAME);
    }
}
