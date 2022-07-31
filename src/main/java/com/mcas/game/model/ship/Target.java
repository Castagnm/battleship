package com.mcas.game.model.ship;

import com.mcas.game.model.coord.CoordX;
import com.mcas.game.model.coord.CoordY;

public class Target {

    private CoordX coordX;

    private CoordY coordY;

    private Target(CoordX coordX, CoordY coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public static Target create(CoordX coordX, CoordY coordY) {
        return new Target(coordX, coordY);
    }

    public CoordX getCoordX() {
        return this.coordX;
    }

    public CoordY getCoordY() {
        return this.coordY;
    }

    public boolean equals(Target target) {
        return coordX.equals(target.getCoordX()) && coordY.equals(target.getCoordY());
    }
    
    @Override
    public String toString() {
        return coordX.toString() + coordY.toString();
    }
}
