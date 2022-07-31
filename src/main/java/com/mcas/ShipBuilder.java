package com.mcas;

public class ShipBuilder {
    
    private CoordX coordX;

    private CoordY coordY;

    private Direction direction;
    
    private int shipSize;

    private String shipName;

    private ShipBuilder() {
        
    }

    public static ShipBuilder getInstanceOf() {
        return new ShipBuilder();
    }

    public Ship createPatrolBoat() throws ShipNotCreatedException {
        shipName = "Patrol boat";
        shipSize = 2;
        return createRandomShip();
    }

    public Ship createCruiser() throws ShipNotCreatedException {
        shipName = "Cruiser";
        shipSize = 3;
        return createRandomShip();
    }
    
    public Ship createSubmarine() throws ShipNotCreatedException {
        shipName = "Submarine";
        shipSize = 3;
        return createRandomShip();
    }
    
    public Ship createBattleShip() throws ShipNotCreatedException {
        shipName = "Battleship";
        shipSize = 4;
        return createRandomShip();
    }
    
    public Ship createCarrier() throws ShipNotCreatedException {
        shipName = "Patrol boat";
        shipSize = 5;
        return createRandomShip();
    }

    public Ship createShip() throws ShipNotCreatedException {

        Target[] shipTargets = new Target[shipSize];

        shipTargets[0] = Target.create(coordX, coordY);

        try {
            for(int i = 1; i < shipTargets.length; i++) {
                Target refTarget = shipTargets[i-1];
                CoordX refCoordX = refTarget.getCoordX();
                CoordY refCoordY = refTarget.getCoordY();
                CoordX nextCoordX = direction.equals(Direction.RIGHT) ? refCoordX.getNext() : refCoordX;
                CoordY nextCoordY = direction.equals(Direction.DOWN) ? refCoordY.getNext() : refCoordY;
                Target nextTarget = Target.create(nextCoordX, nextCoordY);
                shipTargets[i] = nextTarget;
            }

            Ship ship = Ship.getInstanceOf(shipName, shipTargets);
            System.out.println("ship created : " + ship.toString());
            return ship;
        }
        catch(CoordOutOfBoundException e) {
            System.out.println("Coordinate not valid, the ship cannot be created");
            throw new ShipNotCreatedException();
        }
    }

    private Ship createRandomShip() throws ShipNotCreatedException {
        direction = Direction.getRandom();
        coordX = CoordX.A;
        coordY = CoordY.ONE;
        return createShip();
    }
}
