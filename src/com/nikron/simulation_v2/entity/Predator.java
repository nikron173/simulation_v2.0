package com.nikron.simulation_v2.entity;

public class Predator extends Creature {

    private final int damage;

    public Predator(Point point, int speed, int heath, int damage) {
        super(point, speed, heath);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "P";
    }
}
