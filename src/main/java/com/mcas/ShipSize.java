package com.mcas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum ShipSize {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private int value;
    
    private static final Random RANDOM = new Random();

    private static final List<ShipSize> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    
    private static final int SIZE = VALUES.size();

    ShipSize(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ShipSize getRandom() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
