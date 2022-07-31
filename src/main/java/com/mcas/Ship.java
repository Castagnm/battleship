package com.mcas;
public class Ship {

    private final Target[] targets;

    private final String name;

    private Ship(String name, Target[] targets) {
        this.name = name;
        this.targets = targets;
    }

    public static Ship getInstanceOf(String name, Target[] targets) {
        return new Ship(name, targets);
    }

    public Target[] getTargets() {
        return this.targets;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String prefix = name + " has " + targets.length + " targets, they are : ";
        builder.append(prefix);

        for(Target next : targets) {
            builder.append(next.toString() + " ");
        }

        return builder.toString();
    }
}
