package com.mcas;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ShipTest {

    @Test
    public void shouldBuildShipsSuccessfully() throws ShipNotCreatedException {

        // Given
        ShipBuilder shipBuilder = ShipBuilder.getInstanceOf();

        // When
        Ship patrolBoat = shipBuilder.createPatrolBoat();
        Ship cruiser = shipBuilder.createCruiser();
        Ship submarine = shipBuilder.createSubmarine();
        Ship battleship = shipBuilder.createBattleShip();
        Ship carrier = shipBuilder.createCarrier();

        // Then
        assertNotNull(patrolBoat);
        assertNotNull(cruiser);
        assertNotNull(submarine);
        assertNotNull(battleship);
        assertNotNull(carrier);
        
        checkShipTargets(patrolBoat.getTargets());
        checkShipTargets(cruiser.getTargets());
        checkShipTargets(submarine.getTargets());
        checkShipTargets(battleship.getTargets());
        checkShipTargets(carrier.getTargets());
    }

    private void checkShipTargets(Target[] shipTargets) {

        for(Target next : shipTargets) {
            assertNotNull(next.getCoordX());
            assertNotNull(next.getCoordY());
        }
    }
}
