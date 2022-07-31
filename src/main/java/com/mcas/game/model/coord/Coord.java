package com.mcas.game.model.coord;

import com.mcas.game.exception.CoordOutOfBoundException;

public interface Coord {

    public Coord getNext() throws CoordOutOfBoundException;
    
}
