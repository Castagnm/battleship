package com.mcas.game.controller;

import java.util.ArrayList;
import java.util.List;

import com.mcas.game.exception.ShipNotCreatedException;
import com.mcas.game.model.coord.CoordX;
import com.mcas.game.model.coord.CoordY;
import com.mcas.game.model.coord.Direction;
import com.mcas.game.model.ship.BattleshipTemplate;
import com.mcas.game.model.ship.CarrierTemplate;
import com.mcas.game.model.ship.CruiserTemplate;
import com.mcas.game.model.ship.PatrolBoatTemplate;
import com.mcas.game.model.ship.Ship;
import com.mcas.game.model.ship.ShipBuilder;
import com.mcas.game.model.ship.ShipTemplate;
import com.mcas.game.model.ship.SubmarineTemplate;

public class ShipController {

    private static final ShipTemplate[] FLEET_TEMPLATE = new ShipTemplate[] {
        new PatrolBoatTemplate(CoordX.J, CoordY.TWO, Direction.DOWN),
        new CruiserTemplate(CoordX.A, CoordY.ONE, Direction.RIGHT),
        new SubmarineTemplate(CoordX.C, CoordY.THREE, Direction.DOWN),
        new BattleshipTemplate(CoordX.C, CoordY.NINE, Direction.RIGHT),
        new CarrierTemplate(CoordX.G, CoordY.THREE, Direction.DOWN)
    };

    private final ShipBuilder shipBuilder;
    
    private static final ShipController INSTANCE = new ShipController();

    private ShipController() {
        shipBuilder = ShipBuilder.getInstanceOf();
    }

    public static ShipController getInstanceOf() {
        return INSTANCE;
    }

    public Ship[] getFleet() {
        List<Ship> fleet = new ArrayList<Ship>();

        try {
            for(ShipTemplate next : FLEET_TEMPLATE) {
                Ship ship = shipBuilder.setShipTemplate(next).createShip();
                fleet.add(ship);
            }
            return fleet.toArray(new Ship[fleet.size()]);

        }
        catch(ShipNotCreatedException e) {
            return new Ship[0];
        }
        
    }
}
