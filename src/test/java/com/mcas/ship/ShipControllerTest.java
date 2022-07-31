package com.mcas.ship;

import org.junit.Test;

import com.mcas.game.controller.ShipController;
import com.mcas.game.exception.ShipNotCreatedException;
import com.mcas.game.model.ship.Ship;
import com.mcas.game.model.ship.Target;

import static org.junit.Assert.assertNotNull;


public class ShipControllerTest {

    private final ShipController shipController = com.mcas.game.controller.ShipController.getInstanceOf();

    @Test
    public void shouldBuildShipsSuccessfully() throws ShipNotCreatedException {

        // Given

        // When
        Ship[] fleet = shipController.getFleet();

        // Then
        for(Ship next : fleet) {
            assertNotNull(next);
            checkShipTargets(next.getTargets());
        }
    }

    private void checkShipTargets(Target[] shipTargets) {

        for(Target next : shipTargets) {
            assertNotNull(next.getCoordX());
            assertNotNull(next.getCoordY());
        }
    }
}
