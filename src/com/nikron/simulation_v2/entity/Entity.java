package com.nikron.simulation_v2.entity;

public abstract class Entity {
    //static object or not
    private final boolean isStaticObject;

    //object resource or not
    private final boolean isResourceObject;

    private Coordinates coordinates;

    public Entity(boolean isStaticObject, boolean isResourceObject, Coordinates coordinates){
        this.isStaticObject = isStaticObject;
        this.isResourceObject = isResourceObject;
        this.coordinates = coordinates;
    }

    public boolean isStaticObject() {
        return isStaticObject;
    }
    public boolean isResourceObject() {
        return isResourceObject;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }
}
