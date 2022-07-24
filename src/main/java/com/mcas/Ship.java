package com.mcas;
public class Ship {

    private Target[] targets;

    private Ship(Target[] targets) {
        this.targets = targets;
    }

    public static Ship create(Target[] targets) {
        return new Ship(targets);
    }

    public Target[] getTargets() {
        return this.targets;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String prefix = "ship has " + targets.length + "targets, they are : ";
        builder.append(prefix);

        for(Target next : targets) {
            builder.append(next.toString() + " ");
        }

        return builder.toString();
    }
}
