package com.mcas;

public class Shot {
    
    private final CoordX coordX;

    private final CoordY coordY;

    private boolean missed;

    private Shot(CoordX coordX, CoordY coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public static Shot create(CoordX coordX, CoordY coordY) {
        return new Shot(coordX, coordY);
    }

    public boolean hasMissed() {
        return missed;
    }

    public Shot execute() {
        System.out.println("target is " + coordX.toString() + coordY.toString());
        missed = true;
        return this;
    }
}
