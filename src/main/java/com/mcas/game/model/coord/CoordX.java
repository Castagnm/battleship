package com.mcas.game.model.coord;

import com.mcas.game.exception.CoordOutOfBoundException;

public enum CoordX implements Coord {

    A,
    B,
    C,
    D,
    E,
    F,
    G,
    H,
    I,
    J;

    public CoordX getNext() throws CoordOutOfBoundException {
        int nextIndex = this.ordinal()+1;
        CoordX[] ref = CoordX.values();

        if(nextIndex >= ref.length ) throw new CoordOutOfBoundException();

        return ref[nextIndex];
    }
}
