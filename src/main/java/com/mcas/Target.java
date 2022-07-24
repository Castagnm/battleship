package com.mcas;

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
    
    @Override
    public String toString() {
        return "Target " + coordX.toString() + coordY.toString();
    }
}