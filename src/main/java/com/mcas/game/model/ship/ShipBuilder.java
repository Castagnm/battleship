package com.mcas.game.model.ship;

import com.mcas.game.exception.CoordOutOfBoundException;
import com.mcas.game.exception.ShipNotCreatedException;
import com.mcas.game.model.coord.CoordX;
import com.mcas.game.model.coord.CoordY;
import com.mcas.game.model.coord.Direction;

public class ShipBuilder {
    
    private CoordX initialCoordX;

    private CoordY initialCoordY;

    private Direction direction;

    private int shipSize;

    private String shipName;

    private static final ShipBuilder INSTANCE = new ShipBuilder();

    private ShipBuilder() {

    }

    public static ShipBuilder getInstanceOf() {
        return INSTANCE;
    }

    public ShipBuilder setShipTemplate(ShipTemplate shipTemplate) {
        this.initialCoordX = shipTemplate.getCoordX();
        this.initialCoordY = shipTemplate.getCoordY();
        this.direction = shipTemplate.getDirection();
        this.shipSize = shipTemplate.getShipSize();
        this.shipName = shipTemplate.getShipName();
        return this;
    }

    public Ship createShip() throws ShipNotCreatedException {
        return new Ship(shipName, createShipTargets());
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
