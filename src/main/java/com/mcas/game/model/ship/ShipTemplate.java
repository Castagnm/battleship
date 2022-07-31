package com.mcas.game.model.ship;

import com.mcas.game.model.coord.CoordX;
import com.mcas.game.model.coord.CoordY;
import com.mcas.game.model.coord.Direction;

public abstract class ShipTemplate {

    private final CoordX coordX;

    private final CoordY coordY;

    private final Direction direction;

    private final int shipSize;

    private final String shipName;

    public ShipTemplate(CoordX coordX, CoordY coordY, Direction direction, int shipSize, String shipName) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.direction = direction;
        this.shipName = shipName;
        this.shipSize = shipSize;
    }

    public CoordX getCoordX() {
        return coordX;
    }

    public CoordY getCoordY() {
        return coordY;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getShipSize() {
        return shipSize;
    }

    public String getShipName() {
        return shipName;
    }
}
