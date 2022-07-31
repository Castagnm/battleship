package com.mcas;

import com.mcas.game.controller.ShipController;
import com.mcas.game.model.ship.Ship;

/**
 * Hello world!
 *
 */
public class App 
{

    private static ShipController shipController;

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        shipController = ShipController.getInstanceOf();

        Ship[] fleet = shipController.getFleet();

        for(Ship next : fleet) {
            System.out.println(next.toString());
        }
    }
}
