package com.mcas;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        // let's try out a few shots
        Shot.create(CoordX.A, CoordY.ONE).execute();
        Shot.create(CoordX.C, CoordY.TWO).execute();
        Shot.create(CoordX.E, CoordY.SEVEN).execute();

        // let's create a ship
        try {
            ShipBuilder
            .create()
            .setCoordX(CoordX.A)
            .setCoordY(CoordY.THREE)
            .setDirectionRight()
            .setSize(Size.TWO)
            .createShip();
        }
        catch(ShipNotCreatedException e) {
            System.out.println("error while creating ship ! It should not happen.");
        }

        
        // let's create a ship, but this time there is an error !
        try {
            ShipBuilder
            .create()
            .setCoordX(CoordX.I)
            .setCoordY(CoordY.THREE)
            .setDirectionRight()
            .setSize(Size.FIVE)
            .createShip();
        }
        catch(ShipNotCreatedException e) {
            System.out.println("error while creating ship ! It is expected.");
        }
    }
}
