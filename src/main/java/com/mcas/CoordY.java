package com.mcas;

public enum CoordY {

    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9");

    private String coordStr;

    CoordY(String coordStr) {
        this.coordStr = coordStr;
    }

    @Override
    public String toString() {
        return this.coordStr;
    }
    
}