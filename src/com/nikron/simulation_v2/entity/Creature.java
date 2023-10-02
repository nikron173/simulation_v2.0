package com.nikron.simulation_v2.entity;

public abstract class Creature extends Entity {
    private int heath;
    private int speed;
    private final int attack;
    private final boolean isResourceForHunter;

    public Creature(boolean isStaticObject, boolean isResourceObject, Coordinates coordinates,
                    int heath, int speed, int attack, boolean isResourceForHunter) {
        super(isStaticObject, isResourceObject, coordinates);
        this.heath = heath;
        this.speed = speed;
        this.attack = attack;
        this.isResourceForHunter = isResourceForHunter;
    }

    public int getHeath() {
        return heath;
    }

    public void setHeath(int heath) {
        this.heath = heath;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isResourceForHunter() {
        return isResourceForHunter;
    }

    public int getAttack() {
        return attack;
    }

    public abstract void makeMove();
}
