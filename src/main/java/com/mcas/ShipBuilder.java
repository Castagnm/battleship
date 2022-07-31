package com.mcas;

import java.util.ArrayList;
import java.util.List;

public class ShipBuilder {
    
    private CoordX initialCoordX;

    private CoordY initialCoordY;

    private Direction direction;

    private int shipSize;

    private String shipName;

    private List<Target> takenTargets;

    private ShipBuilder() {
        takenTargets = new ArrayList<>();
    }

    public static ShipBuilder getInstanceOf() {
        return new ShipBuilder();
    }

    public Ship createPatrolBoat() throws ShipNotCreatedException {
        shipName = "Patrol boat";
        shipSize = 2;
        initialCoordX = CoordX.J;
        initialCoordY = CoordY.TWO;
        direction = Direction.DOWN;
        return createShip();
    }

    public Ship createCruiser() throws ShipNotCreatedException {
        shipName = "Cruiser";
        shipSize = 3;
        initialCoordX = CoordX.A;
        initialCoordY = CoordY.ONE;
        direction = Direction.RIGHT;
        return createShip();
    }
    
    public Ship createSubmarine() throws ShipNotCreatedException {
        shipName = "Submarine";
        shipSize = 3;
        initialCoordX = CoordX.C;
        initialCoordY = CoordY.THREE;
        direction = Direction.DOWN;
        return createShip();
    }
    
    public Ship createBattleShip() throws ShipNotCreatedException {
        shipName = "Battleship";
        shipSize = 4;
        initialCoordX = CoordX.C;
        initialCoordY = CoordY.NINE;
        direction = Direction.RIGHT;
        return createShip();
    }
    
    public Ship createCarrier() throws ShipNotCreatedException {
        shipName = "Patrol boat";
        shipSize = 5;
        initialCoordX = CoordX.G;
        initialCoordY = CoordY.THREE;
        direction = Direction.DOWN;
        return createShip();
    }

    public Ship createShip() throws ShipNotCreatedException {
        return Ship.getInstanceOf(shipName, createShipTargets());
    }

    private Target[] createShipTargets() throws ShipNotCreatedException {

        Target[] shipTargets = new Target[shipSize];
        shipTargets[0] = Target.create(initialCoordX, initialCoordY);
                    
        for(int i = 1; i < shipTargets.length; i++) {
            Target refTarget = shipTargets[i-1];
            shipTargets[i] = createShipTarget(refTarget);
        }

        return shipTargets;
    }

    private Target createShipTarget(Target refTarget) throws ShipNotCreatedException {

        CoordX refCoordX = refTarget.getCoordX();
        CoordY refCoordY = refTarget.getCoordY();

        try {
            CoordX nextCoordX = direction.equals(Direction.RIGHT) ? refCoordX.getNext() : refCoordX;
            CoordY nextCoordY = direction.equals(Direction.DOWN) ? refCoordY.getNext() : refCoordY;
            return Target.create(nextCoordX, nextCoordY);
        }
        catch(CoordOutOfBoundException e) {
            throw new ShipNotCreatedException();
        }
    }
}
