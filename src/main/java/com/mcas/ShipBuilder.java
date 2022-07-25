package com.mcas;

public class ShipBuilder {
    
    private CoordX coordX;

    private CoordY coordY;

    private Direction direction;
    
    private ShipSize shipSize;

    private static final int FLEET_SIZE = 5;

    private ShipBuilder() {
        
    }

    public static ShipBuilder create() {
        return new ShipBuilder()
            .setCoordX(CoordX.A)
            .setCoordY(CoordY.ONE)
            .setDirection(Direction.RIGHT)
            .setShipSize(ShipSize.ONE);
    }

    public ShipBuilder setCoordX(CoordX coordX) {
        this.coordX = coordX;
        return this;
    }

    public ShipBuilder setCoordY(CoordY coordY) {
        this.coordY = coordY;
        return this;
    }
    
    public ShipBuilder setDirection(Direction direction) {
        this.direction = direction;
        return this;
    }
    
    public ShipBuilder setShipSize(ShipSize size) {
        this.shipSize = size;
        return this;
    }

    public Ship createShip() throws ShipNotCreatedException {

        Target[] shipTargets = new Target[shipSize.getValue()];

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

            Ship ship = Ship.create(shipTargets);
            System.out.println("ship created : " + ship.toString());
            return ship;
        }
        catch(CoordOutOfBoundException e) {
            System.out.println("Coordinate not valid, the ship cannot be created");
            throw new ShipNotCreatedException();
        }
    }

    public Ship[] createFleet() throws ShipNotCreatedException {
        Ship[] fleet = new Ship[FLEET_SIZE];

        ShipSize[] fleetModel = ShipSize.values();

        for(int i = 0; i< FLEET_SIZE; i++) {
            setShipSize(fleetModel[i]);
            fleet[i] = createRandomShip();
        }

        return fleet;
    }

    private Ship createRandomShip() throws ShipNotCreatedException {
        setDirection(Direction.getRandom());
        setCoordX(CoordX.A);
        setCoordY(CoordY.ONE);
        return createShip();
    }
}
