package com.nikron.simulation_v2.entity;

public class Creature extends Entity{
    private final int speed;
    private final int heath;
    public Creature(Point point, int speed, int heath) {
        super(point);
        this.speed = speed;
        this.heath = heath;
    }
    protected void makeMove(){}

    public int getSpeed() {
        return speed;
    }

    public int getHeath() {
        return heath;
    }
}
