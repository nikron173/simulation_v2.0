package com.nikron.simulation_v2.entity;

import java.util.List;

public abstract class Creature extends Entity {
    private final int speed;
    private final int heath;

    public Creature(Point point, int speed, int heath) {
        super(point);
        this.speed = speed;
        this.heath = heath;
    }

    public void makeMove(List<Point> path) {
        if (path.size() == 1){

        }
    }

    protected int getSpeed() {
        return speed;
    }

    protected int getHeath() {
        return heath;
    }
}
