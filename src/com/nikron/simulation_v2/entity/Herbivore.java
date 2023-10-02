package com.nikron.simulation_v2.entity;

public class Herbivore extends Creature {

    public Herbivore(boolean isStaticObject, boolean isResourceObject, Coordinates coordinates,
                     int heath, int speed, int attack, boolean isResourceForHunter) {
        super(isStaticObject, isResourceObject, coordinates, heath, speed, attack, isResourceForHunter);
    }

    @Override
    public void makeMove() {

    }

    @Override
    public String toString() {
        return "\uD83D\uDC07";
    }
}
