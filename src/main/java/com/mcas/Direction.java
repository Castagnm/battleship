package com.mcas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Direction {

    RIGHT,
    DOWN;
        
    private static final Random RANDOM = new Random();

    private static final List<Direction> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    
    private static final int SIZE = VALUES.size();

    public static Direction getRandom() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
