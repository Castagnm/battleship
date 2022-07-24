package com.mcas;

public class ShipBuilder {
    
    private CoordX coordX;

    private CoordY coordY;

    private Direction direction;
    
    private Size size;

    private ShipBuilder() {
        
    }

    public static ShipBuilder create() {
        return new ShipBuilder()
            .setCoordX(CoordX.A)
            .setCoordY(CoordY.ONE)
            .setDirectionRight()
            .setSize(Size.ONE);
    }

    public ShipBuilder setCoordX(CoordX coordX) {
        this.coordX = coordX;
        return this;
    }

    public ShipBuilder setCoordY(CoordY coordY) {
        this.coordY = coordY;
        return this;
    }
    
    public ShipBuilder setDirectionDown() {
        this.direction = Direction.DOWN;
        return this;
    }
    
    public ShipBuilder setDirectionRight() {
        this.direction = Direction.RIGHT;
        return this;
    }
    
    public ShipBuilder setSize(Size size) {
        this.size = size;
        return this;
    }

    public Ship createShip() throws ShipNotCreatedException {

        Target[] shipTargets = new Target[size.getValue()];

        shipTargets[0] = Target.create(coordX, coordY);

        try {
            for(int i = 1; i < shipTargets.length; i++) {
                Target refTarget = shipTargets[i-1];
                CoordX refCoordX = refTarget.getCoordX();
                CoordY refCoordY = refTarget.getCoordY();
                CoordX nextCoordX = this.direction.equals(Direction.RIGHT) ? refCoordX.getNext() : refCoordX;
                CoordY nextCoordY = this.direction.equals(Direction.DOWN) ? refCoordY.getNext() : refCoordY;
                Target nextTarget = Target.create(nextCoordX, nextCoordY);
                shipTargets[i] = nextTarget;
            }

            Ship ship = Ship.create(shipTargets);
            System.out.println("ship created : " + ship.toString());
            return ship;
        }
        catch(CoordOutOfBoundException e) {
            System.out.println("Coordinate not valid, the ship cannot be created");
            throw new ShipNotCreatedException();
        }
    }
}
