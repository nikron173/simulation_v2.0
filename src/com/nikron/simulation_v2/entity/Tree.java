package com.nikron.simulation_v2.entity;

public class Tree extends Entity {
    public Tree(boolean isStaticObject, boolean isResourceObject, Coordinates coordinates) {
        super(isStaticObject, isResourceObject, coordinates);
    }

    @Override
    public String toString() {
        return "\uD83C\uDF32";
    }
}
