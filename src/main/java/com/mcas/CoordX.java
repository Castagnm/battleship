package com.mcas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
            
    private static final Random RANDOM = new Random();

    private static final List<CoordX> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    
    private static final int SIZE = VALUES.size();

    public CoordX getNext() throws CoordOutOfBoundException {
        int nextIndex = this.ordinal()+1;
        CoordX[] ref = CoordX.values();

        if(nextIndex >= ref.length ) throw new CoordOutOfBoundException();

        return ref[nextIndex];
    }
    
    public static CoordX getRandom() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
