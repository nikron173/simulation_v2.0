package com.nikron.simulation_v2.entity;

import com.nikron.simulation_v2.Map;

import java.util.List;

public abstract class Creature extends Entity {
    private final int speed;
    private final int heath;

    public Creature(Point point, int speed, int heath) {
        super(point);
        this.speed = speed;
        this.heath = heath;
    }

    public void makeMove(List<Point> path, Map map) {
        int len = Math.min(path.size(), getSpeed());

        map.removeEntity(this.getPoint());
        for (int i = 1; i <= len; i++) {
            map.removeEntity(path.get(i - 1));
            map.setEntity(path.get(i), this);
        }
    }

    protected int getSpeed() {
        return speed;
    }

    protected int getHeath() {
        return heath;
    }
}
