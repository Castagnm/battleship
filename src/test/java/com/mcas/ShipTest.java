package com.mcas;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class ShipTest {
    
    @Test
    public void shouldSuccessfullyCreateShip() throws ShipNotCreatedException {

        // Given
        CoordX coordX = CoordX.A;
        CoordY coordY = CoordY.ONE;
        Size size = Size.THREE;

        // When
        Ship ship = ShipBuilder
            .create()
            .setCoordX(coordX)
            .setCoordY(coordY)
            .setDirectionRight()
            .setSize(size)
            .createShip();

        // Then
        int shipSize = ship.getTargets().length;
        assertNotNull(ship);
        assertEquals(size.getValue(), shipSize);
        assertEquals(coordX, ship.getTargets()[0].getCoordX());
        assertEquals(coordY, ship.getTargets()[0].getCoordY());
        assertEquals(CoordX.C, ship.getTargets()[shipSize-1].getCoordX());
        assertEquals(CoordY.ONE, ship.getTargets()[shipSize-1].getCoordY());
    }
}
