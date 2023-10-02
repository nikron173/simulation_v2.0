package com.nikron.simulation_v2.entity;

public class Rock extends Entity{

    public Rock(boolean isStaticObject, boolean isResourceObject, Coordinates coordinates) {
        super(isStaticObject, isResourceObject, coordinates);
    }

    @Override
    public String toString() {
        return "\uD83E\uDEA8";
    }
}
