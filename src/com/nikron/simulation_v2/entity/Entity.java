package com.nikron.simulation_v2.entity;

public abstract class Entity {
    private Point point;

    public Entity(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
