package com.mcas;

public enum CoordX implements Coord {

    A,
    B,
    C,
    D,
    E,
    F,
    G,
    H,
    I;

    public CoordX getNext() throws CoordOutOfBoundException {
        int nextIndex = this.ordinal()+1;
        CoordX[] ref = CoordX.values();

        if(nextIndex >= ref.length ) throw new CoordOutOfBoundException();

        return ref[nextIndex];
    }
}
