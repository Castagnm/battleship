package com.mcas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum CoordY implements Coord {

    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10");

    private static final Random RANDOM = new Random();

    private static final List<CoordY> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    
    private static final int SIZE = VALUES.size();

    private String coordStr;

    CoordY(String coordStr) {
        this.coordStr = coordStr;
    }

    @Override
    public String toString() {
        return this.coordStr;
    }
    
    public CoordY getNext() throws CoordOutOfBoundException {
        int nextIndex = this.ordinal()+1;
        CoordY[] ref = CoordY.values();

        if(nextIndex >= ref.length ) throw new CoordOutOfBoundException();

        return ref[nextIndex];
    }
    
    public static CoordY getRandom() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
