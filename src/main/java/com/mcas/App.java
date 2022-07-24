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
    }
}
