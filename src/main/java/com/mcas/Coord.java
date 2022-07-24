package com.mcas;

public interface Coord {

    public Coord getNext() throws CoordOutOfBoundException;
    
}
