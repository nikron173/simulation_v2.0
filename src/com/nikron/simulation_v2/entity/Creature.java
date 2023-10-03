package com.nikron.simulation_v2.entity;

import com.nikron.simulation_v2.AStarAlgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public abstract void makeMove(com.nikron.simulation_v2.Map map);

    public <T> List<Coordinates> getShortListMovesCoordinates(T start, List<T> ends, Map<Coordinates, Entity> map){
        List<List<Coordinates>> lists = new ArrayList<>();
        for(T t : ends){
            lists.add(AStarAlgo.aStar(start, t, map));
        }
        if (lists.isEmpty()) return null;
        int max = -1;
        int index = -1;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) == null) continue;
            if (max < lists.get(i).size()){
                max = lists.get(i).size();
                index = i;
            }
        }
        return index == -1 ? null : lists.get(index);
    };
}
